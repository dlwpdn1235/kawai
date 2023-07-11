<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ include file="../inc/header.jsp" %>

<script>
var result = '${success}';   console.log( result  );
if(result =="fail"){ alert("관리자에게 문의하세요.");  history.go(-1); }
else if( result.length !=0 ){  alert(result);  }
</script>
	<div class="container tmpt">
		<h3>커뮤니티</h3>
		<div class="text-right">
		<c:if test="${sessionScope.role_id == 0}">
			<a href="${pageContext.request.contextPath}/community/commInsert" title="글쓰기폼으로" class="btn btn-info">글쓰기</a>
		</c:if>
		</div>
		<br/>
	</div>
	  <div class="container">
	  	<div class="row">
		<div class="col-sm-2" style="position: sticky; top: 100px;">
				<div class="btn-group-vertical">
					<input type="button" class="btn btn-default categorybtn" value="전체" data-categoryid="0"/>
				</div>
	      	</div>
			<div class="col-sm-10">
		    <div class="btn-group" role="group" style="display: flex;">
		        <input type="button" class="btn btn-default conditions" name="condition" value="인기" data-condition="1" style="margin-right: 10px;" />
		        <input type="button" class="btn btn-default conditions" name="condition" value="최신" data-condition="2" style="margin-right: 10px;" />
	            <select class="btn" id="selectDay" style="margin-right: 10px;">
	                <option class="days" data-day="0">전체 (조회수순)</option>
	                <option class="days" data-day="1">지난 1일</option>
	                <option class="days" data-day="7">지난 1주</option>
	                <option class="days" data-day="30">지난 1개월</option>
	                <option class="days" data-day="365">지난 1년</option>
	            </select>
		        <div style="margin-left: auto;">
		            <select class="btn searchTypes" style="margin-right: 10px;">
		                <option data-searchType="1">제목</option>
		                <option data-searchType="2">작성자</option>
		            </select>
		            <input type="search" id="searchKeyword" style="margin-right: 10px;" />
		            <input type="button" class="btn btn-info" name="searchbtn" id="searchbtn" value="검색" />
		            <input type="button" class="btn btn-danger" id="resetbtn" value="검색초기화"/>
		        </div>
		    </div>
			

			<div class="well">
				<div class="row ajaxMarket text-center">
				<table class="table table-striped table-hover commListTable">
					<colgroup>
						<col  style="width:10%" >
						<col  style="width:40%" >
						<col  style="width:20%" >
						<col  style="width:20%" >
						<col  style="width:10%" >
					</colgroup>
					<thead>
						<tr>
							<th scope="col" class="text-center">카테고리</th>
							<th scope="col" class="text-center">제목</th>
							<th scope="col" class="text-center">작성자</th>
							<th scope="col" class="text-center">날짜</th>
							<th scope="col" class="text-center">조회수</th>
						</tr>
					</thead>
					<tbody>
			
					</tbody>			
				</table>
				</div>
			</div>
	      	</div> 
	    </div>
	  </div>
	  <script>
	  var category_id = 0;
	  var condition = 0;
	  var day = 0;
	  var searchKeyword = '';
	  var searchType = 0;
	  var count = 0;
	  var community_hide = 1;
	  var isFirst = true;
	  var isLoading = false; // 데이터 로딩 여부
	  
	  	$("#resetbtn").on("click",function(){
	  		searchKeyword = '';
		  	searchType = 0;
		  	$("#searchKeyword").val("");
	  	});
		$(function(){
	  		if(isFirst){
				commList();	  			
	  		}
	  	});
		$(window).on('scroll', function() {
		    if ($(window).scrollTop() + $(window).height() >= $(document).height()) {
		        if (!isLoading) { // 데이터 로딩 중이 아닌 경우에만 호출
		            isLoading = true; // 데이터 로딩 상태로 설정
		            commList();
		        }
		    }
		});
		$(".conditions").on("click", function() {
			  isLoading = true;
			  condition = $(this).data("condition");
			  console.log(condition);
			  $(".commListTable tbody").empty();
			  count=0;
			  commList();
		});
		$("#selectDay").on("change", function() {
			  isLoading = true;
			  day = $(this).find(":selected").data("day");
			  $(".commListTable tbody").empty();
			  if(day != 0){
			  	condition = 3;				  
			  }else{
				  condition = 0;
			  }
			  count=0;
			  commList();
		});
		$(document).on("click", ".categorybtn", function(){
			isLoading = true;
		    category_id = $(this).data("categoryid");
			$(".commListTable tbody").empty();
		    count = 0;
		    day=0;
		    condition=0;
		    commList();
		});
		$("#searchbtn").on("click",function(){
			isLoading = true;
			$(".commListTable tbody").empty();
		    count = 0;
		    day=0;
		    condition=0;
			searchKeyword = $("#searchKeyword").val();
			searchType = $(".searchTypes option:selected").data("searchtype");
			commList();
		});
	  	function commList(){
	  		var search = {
	  			category_id: category_id,
	  			condition: condition,
	  			day: day,
	  			searchKeyword: searchKeyword,
	  			searchType: searchType,
	  			count: count,
	  			community_hide: community_hide
	  		};
	  		$.ajax({
	  			url : "${pageContext.request.contextPath}/community/commAjaxView",
	  			type : "POST",
	  			data : JSON.stringify(search),
	  			dataType : "json", 
	  			contentType : "application/json;charset=UTF-8",
	  			error : function(xhr, status, msg) {alert(status + "/" + msg); isLoading = false;},
	  			success : commListResult
	  		});
	  	}
	  	function commListResult(json){
	  		if(isFirst){
	  			$(".commListTable tbody").empty();
	  		}
	  		$.each(json.commList, function(idx, commList){
	  			$("<tr>")
	  			.append($("<input type='hidden' class='hidden_no'>").val(commList.community_id)) // 수정ok
	  			.append($("<td>").html(commList.category_name))
				.append($("<td>").append($("<a>").attr("href", "${pageContext.request.contextPath}/community/commDetail?community_id=" + commList.community_id).text(commList.community_title)))	  			.append($("<td>").html(commList.user_id))
	  			.append($("<td>").html(commList.community_date))
	  			.append($("<td>").html(commList.community_hit))
	  			.appendTo(".commListTable tbody");
	  		});
			if(isFirst){
		  		$.each(json.comm_category, function(idx, comm_category) {
		  		  $(".btn-group-vertical").append($("<input type='button' class='btn btn-default categorybtn' value='" + comm_category.category_name + "' data-categoryid='" + comm_category.category_id + "'>"));
		  		});
		  		isFirst=false;
			}
			isLoading = false;
			count = count+10;
	  	}
	  </script>
                           
<%@ include file="../inc/footer.jsp" %>