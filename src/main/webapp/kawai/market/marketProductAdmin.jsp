<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



   <div class="container panel tmpt">
      <h3 class="panel-heading">관리자 내역</h3>   

	
	
		<div class="market-search-group">
    	<input type="search" id="market_search" placeholder="관리자 검색" autocomplete="off"/>
      </div>
	
<table class="marketProductTable col-sm-12">
	<thead>
			<tr>
				<th class="col-sm-3">글 번호</th>
				<th class="col-sm-3">작성자</th>
				<th class="col-sm-3">책제목</th>
				<th class="col-sm-3">등록날짜</th>
			</tr>

		<c:forEach var="list" items="${marketlist }"> <!-- col-sm 맞춰서 넣어주기. -->
		
				<td class="col-sm-2">${list.Market_id}</td>
				<td class="col-sm-2">${list.user_id }</td>
				<td class="col-sm-2">${list.bookinfo.book_title }</td> 
				<td class="col-sm-1">${list.mDate }</td> 

				<td class="col-sm-1"><input type="button" class="btn btn-info" value="수정"/></td>
				<td class="col-sm-1"><input type="button" class="btn btn-danger" value="삭제"/></td>
		</c:forEach>
		

	</thead>
</table>
   </div>
<div class="marketOderOkLine"></div>
<!--    		 <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        }
    }).open();
</script> -->
                      
<%@include file="../inc/footer.jsp" %>
<!-- 
   
 -->