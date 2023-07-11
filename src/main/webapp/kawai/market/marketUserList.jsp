<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



   <div class="container panel tmpt">
      <h3 class="panel-heading">유저 구매내역</h3>   

	
	
		<div class="market-search-group tmpt">
    	<input type="search" id="market_search" placeholder="관리자 검색" autocomplete="off"/>  
    	
		<input type="button" class="btn btn-info marketUserWrite" value="상품등록"/>	
      </div>
	
<table class="marketUserTable col-sm-12">
	<thead>
			<tr>
				<th class="col-sm-3">휴대폰 번호</th>
				<th class="col-sm-3">작성자</th>
				<th class="col-sm-3">책제목</th>
				<th class="col-sm-3">등록날짜</th>
			</tr>

		<c:forEach var="list" items="mCart"> <!-- col-sm 맞춰서 넣어주기. -->
		
				<td class="col-sm-2">테스트</td>
				<td class="col-sm-2">테스트</td>
				<td class="col-sm-2">테스트</td>
				<td class="col-sm-2">테스트</td> 
				<td class="col-sm-1"><input type="button" class="btn btn-info" value="수정"/></td> 
				<td class="col-sm-1"><input type="button" class="btn btn-danger" value="삭제"/> </td>
				
		<div class="marketUserBox">

		 
		</div>
		
				
		</c:forEach>

	</thead>
</table>
   </div>
<div class="marketOderOkLine"></div>
   		 
                      
<%@include file="../inc/footer.jsp" %>
<!-- 
   
 -->