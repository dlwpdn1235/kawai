<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="inc/header.jsp" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	</br>
	</br>
		<h1 class="panel-heading">서점등록</h1>
	  <div class="form-group">
      <dl>
        <dt>이름</dt>
        <dd> <input type="text" name="name" id="name" placeholder="한글 상호" class="form-control"></dd>
      </dl>
		<dt class="dt_find_search"> 주소
		<input type="button" onclick="sample5_execDaumPostcode()" value="주소 검색">
		</dt>
		<dd><input type="text" id="sample5_address" placeholder="주소" class="form-control"> </dd>
	</br>
	<dl>
		<dt>#HashTag &nbsp
			<input type="button" value="#추가하기" name="addtag" id="addtag"> 
		</dt>
	</dl>
		<div id="myModal" class="modal">
			<div class="modal-content">
				<span class="close">&times;</span>
				<h2>모달 제목</h2>
				<div id="checkboxContainer">
				<c:forEach var="taglist" items="tagList">
					${taglist}
				</c:forEach>
				</div>
			</div>
		</div>
		<dl>
        <dt>운영시간</dt>
        <dd> <input type="text" name="operatingtime" id="operatingtime" placeholder="시간입력" class="form-control"></dd>
        </dl>
        <dl>
        <dt>휴무일</dt>
        <dd> <input type="text" name="closeday" id="closeday" placeholder="휴무일입력" class="form-control"></dd>
        </dl>
        <dl>
        <dt>전화번호</dt>
        <dd> <input type="text" name="phonenum" id="phonenum" placeholder="전화번호 입력" class="form-control"></dd>
        </dl>
        </br>
        <dl>
        <dt>소개(500자 이내)</dt>
        <dd> <textarea name="content" id="content" placeholder="500자 내외로 작성하세요." class="form-control"></textarea></dd>
        </dl>
        <dt>사진</dt>
        <dd><input type="file" id="img" name="img" > </dd>
        </dl>
        </br>
        </br>
        <dl>
        <dt>개점일</dt>
        <dd> <input type="text" name="opendate" id="opendate" placeholder="날짜 입력" class="form-control"></dd>
        </dl>
        </br>
        </br>
        </br>
        <div class="input_button">
        <input type="submit" value="작성하기" id="submit"> <span>&nbsp&nbsp&nbsp&nbsp&nbsp</span>
        <button type="button"  onclick="history.go(-1)" >작성취소</button>
        </div>
	</div>
</div>

<%@ include file="inc/footer.jsp" %>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=75bc52b7e552dc0c2e818096144eaeeb&libraries=services"></script>
<script>
var geocoder = new daum.maps.services.Geocoder();

function sample5_execDaumPostcode() {
  new daum.Postcode({
    oncomplete: function(data) {
      var addr = data.address;
      document.getElementById("sample5_address").value = addr;
      
      geocoder.addressSearch(data.address, function(results, status) {
        if (status === daum.maps.services.Status.OK) {
          var result = results[0];
          var coords = new daum.maps.LatLng(result.y, result.x);
          console.log("검색 결과 위치:", coords);
        }
      });
    }
  }).open();
}
////////////////////////////////////////////////// modal관련
	// 모달 열기
	$("#addtag").click(function() {
	  $("#myModal").show();
	  $("#myModal").css("height", "100%");
	});
	
	// 모달 닫기
	$(".close").click(function() {
	  $("#myModal").hide();
	  $("#myModal").css("height", "0");
	});
/////////////////////////////////////////////////// 체크박스

// 체크박스 생성 및 추가 함수
// 데이터를 가져와서 체크박스 생성 함수
	function createCheckboxes(data) {
	  for (var i = 0; i < data.length; i++) {
	    var tagId = data[i].tag_id;
	    var tagName = data[i].tag_name;
	
	    var checkbox = $('<input type="checkbox">')
	      .attr('id', tagId)
	      .addClass('tag-checkbox');
	    var label = $('<label>')
	      .attr('for', tagId)
	      .text('#' + tagName);
	
	    // 체크박스를 감싸는 div에 추가
	    $('#checkboxContainer').append(checkbox).append(label);
	  }
	}
	
	// 데이터 가져오기 예시
	$.ajax({
	  url: 'your-api-endpoint', // 데이터를 가져올 API 엔드포인트
	  method: 'GET',
	  success: function(response) {
	    var data = response.data; // API 응답에서 데이터 추출
	    createCheckboxes(data); // 체크박스 생성 함수 호출
	  },
	  error: function() {
	    console.log('Failed to fetch data from the API.'); // API 요청 실패 시 처리
	  }
	});



/////////////////////////////////////////////////////

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
 /////////////////////////////////////////////////// 	
 
    
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

</style>
