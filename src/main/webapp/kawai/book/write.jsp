<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/kawai/inc/header.jsp" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<div class="container map_container" id="bs_write_div">
		<h1 class="panel-heading">서점등록</h1>
	  <div class="form-group">
	  <form action="${pageContext.request.contextPath}/kawai/write"  method="post" class="writeform">
	   	 <!--  <input type="hidden" id="selectedTagsInput" name="selectedTagsInput" >   -->
      <dl>
	  <dd>
	    <label for="bs_name">이름*</label>
	    <input type="text" name="bs_name" id="bs_name" 
	    	   placeholder="한글 상호" class="form-control" value="${bookStoreVO.bs_name}">
	    	   <p>${Param.bs_name}</p>
	  </dd>
	  </dl>
      <div>
      		<span class="address_search">주소*</span>
				<input type="button" onclick="sample5_execDaumPostcode()" 
				value="주소 검색" id="search_button" title="search_button">
	  </div>
	  <div>		
	        <input type="text" id="bs_postnum" name="bs_postnum" 
	        	    placeholder="우편번호">
			<input type="text" id="bs_address" name="bs_address" 
			        placeholder="주소">
	  </div>
	  <div>
	  		<input type="text" id="bs_address_detail" name="bs_address_detail"
	  		        placeholder="상세주소">
	  </div>
	 <%--  
	  <div>
		 <span id="HashTag">#HashTag &nbsp;</span>
			<input type="button" value="#추가하기" name="addtag" id="addtag">
	  </div>
	  <br/>
	  <!-- Modal 창으로 태그추가 -->
		<div id="myModal" class="modal">
		  <div class="modal-content">
		    <span class="close">&times;</span>
		    <h2>#태그 추가하기</h2>
		    <div id="checkboxContainer">
		      <c:forEach var="tag" items="${list}">
		        <input type="checkbox" id="${tag.tag_id}" value="${tag.tag_id}"
		               class="tag-checkbox" name="taglist">
		        <label for="taglist">#${tag.tag_name}</label><br>
		      </c:forEach>
		    </div>
		    <div class="modal-body">
		    	<p class="text-right"> 
		    	<input type="button" class="btn btn-danger" value="적용하기">
		    	</p>
		    </div>
		  </div>
		</div>
		<!-- Modal 창으로 태그추가 -->
		--%>
		<dl>
        <dd>
        	<label for="bs_start_date">오픈 :</label>
        	<input type="time" name="bs_start_date" id="bs_start_date" 
        	        placeholder="시간입력">
        	<label for="bs_end_date">마감 :</label>
        	<input type="time" name="bs_end_date" id="bs_end_date" 
        	        placeholder="시간입력">
       	</dd>
        </dl>
        <dl>
        <dd>
        <label for="bs_closeday">휴무일</label>
        <input type="text" name="bs_closeday" id="bs_closeday" 
               placeholder="휴무일입력" class="form-control">
        </dd>
        </dl>
        <dl>
        <dd>
        <label for="bs_phonenum">전화번호</label>
        <input type="text" name="bs_phonenum" id="bs_phonenum" 
               placeholder="전화번호 입력" class="form-control">
        </dd>
        </dl>
        <dl>
        <dd>
        <label for="bs_content">소개(500자 이내)</label>
        <textarea name="bs_content" id="bs_content" placeholder="500자 내외로 작성하세요." 
                  class="form-control"></textarea>
        </dd>
        </dl>
       <!--  <dl>
        <dt>사진</dt>
        <dd><input type="file" id="img" name="img" > </dd>
        </dl> -->
        <dl>
        <dd>
        <label for="bs_opendate">오픈일자</label>
        <input type=date name="bs_opendate" id="bs_opendate" 
               placeholder="날짜 입력" >
        </dd>
        </dl>
        <br/>
        <br/>
        <div class="input_button">
        <input type="submit" value="작성하기"> <span>&nbsp&nbsp&nbsp&nbsp&nbsp</span>
        <button type="button"  onclick="history.go(-1)" >작성취소</button>
        </div>
        </form>
	</div> 
</div>

<%-- <%@ include file="/kawai/inc/footer.jsp" %> --%>
<script>
$(document).ready(function() {
	  var selectedTags = []; // 선택한 태그를 담을 배열

	  // 모달 열기
	  $("#addtag").click(function() {
	    // 서버에서 해시태그 데이터 가져오기
	    $.ajax({
	      url: "${pageContext.request.contextPath}/kawai/getHashtags", // 서버의 API 엔드포인트
	      type: "GET",
	      dataType: "json",
	      success: function(response) {
	        var hashtags = response; // 서버에서 받은 해시태그 배열
	        var options = "";

	        // 해시태그 옵션 생성
	        for (var i = 0; i < hashtags.length; i++) {
	          var tagId = hashtags[i].tag_id;
	          var tagName = hashtags[i].tag_name;
	          options += "<input type='checkbox' id='" + tagId + "' name='taglist' value='" + tagId + "' class='tag-checkbox'>"
	            + "<label for='" + tagId + "'>" + tagName + "</label><br>";
	        }

	        // 해시태그 옵션을 모달의 checkboxContainer에 추가
	        $("#checkboxContainer").html(options);
	      },
	      error: function(xhr, status, error) {
	        console.log(error);
	      }
	    });

	    // 적용하기 버튼 클릭 이벤트 처리
	    $(".btn-danger").click(function() {
	      // 선택한 체크박스 태그 값 가져오기
	      selectedTags = []; // 선택한 태그를 초기화
	      $(".tag-checkbox:checked").each(function() {
	        var tagId = $(this).attr("id");
	        selectedTags.push(tagId); // tagId를 배열에 추가
	      });

	      // 모달 창 닫기
	      $("#myModal").hide();
	      $("#myModal").css("height", "0");
	    });

	    // 모달 닫기
	    $(".close").click(function() {
	      $("#myModal").hide();
	      $("#myModal").css("height", "0");
	    });

	    // 모달 창 열기
	    $("#myModal").show();
	    $("#myModal").css("height", "100%");
	  });

	  // write.jsp의 form 제출 이벤트 처리
	  $(".writeform").submit(function(e) {
	    // 선택한 태그 값을 hidden input으로 추가
	    for (var i = 0; i < selectedTags.length; i++) {
	      var tagValue = selectedTags[i];
	      var $tagInput = $("<input>").attr("type", "hidden").attr("name", "selectedTags").val(tagValue);
	      $(this).append($tagInput);
	    }
	  });
	});
function sample5_execDaumPostcode() {
	  new daum.Postcode({
	    oncomplete: function(data) {
	      console.log(data);

	      var roadAddr = data.roadAddress; // 도로명 주소 변수
	      var jibunAddr = data.jibunAddress; // 지번 주소 변수
	      var extraAddr = data.buildingName; // 상세주소 변수
	      var additionalAddr = data.sigungu; // 추가적인 주소 정보 (예: 서교동)
	      
	      document.getElementById('bs_postnum').value = data.zonecode;
	      document.getElementById("bs_address").value = roadAddr;
	      document.getElementById("bs_address_detail").value = jibunAddr + '(' + additionalAddr + ') ' + extraAddr;
	      document.getElementById("bs_address_detail").focus();
	    }
	  }).open();
	}
</script>
<script>
/////////////////////////////////////////////////// css적용
    // 주소검색창 css
    $(document).ready(function() {
  	  $('.dt_find_search').css({
  	    'display': 'flex',
  	    'justify-content': 'space-between'
  	  });
  	$('.input_button').css({
  	    'display': 'flex',
  	    'justify-content': 'center'
  	  });
  	});
  	
</script>

<style>
.modal {
    display: none;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgba(0, 0, 0, 0.5);
}

.modal-content {
    background-color: #fff;
    margin: 15% auto;
    padding: 20px;
    width: 50%;
}

.close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
}
input#bs_address_detail {
    width: 420px;
}
input#bs_address {
    width: 203px;
}

</style>
