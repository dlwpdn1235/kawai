<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

      <div class="market-search-group tmpt">
    	<input type="search" id="market_search" placeholder="책 정보입력" autocomplete="off"/>  
      </div>

   <div class="container panel">
      <h3 class="panel-heading ">장바구니</h3>   
      

      
   </div>   
   <div class="container panel">

	<div class="row" style="font-weight:bold">
				<div class="col-sm-2">번호</div>				
				<div class="col-sm-2">이미지</div>
				<div class="col-sm-2">책 내용</div>
				<div class="col-sm-2">책 저자</div>
				<div class="col-sm-2">책 등록날짜</div>
				<div class="col-sm-2">책 가격</div>
	</div>
		<c:forEach var="i" items="${cartlist}">
			<div class="row">
				<div class="col-sm-2">${i.MCart_id}</div>
				<div class="col-sm-2">
					<img src="${i.market.bookinfo.book_image }" class="marketCartImg"
						alt="${i.market.bookinfo.book_title }"
						style="height: 200px; width: 150px;" />
				</div>
				<div class="col-sm-2">${i.market.bookinfo.book_title }</div>
				<div class="col-sm-2">${i.market.bookinfo.book_author}</div>
				<div class="col-sm-2">${i.MCartDate}</div>
				<div class="col-sm-2">${i.market.MPrice}</div>
				  <div class="marketCartForm">
		<a href="${pageContext.request.contextPath}/market/marketCartDelete?MCart_id=${i.MCart_id}&user_id=<%=user_id%>" class="btn btn-danger">삭제</a>  		
 				 
 				 </div>
			</div>
		</c:forEach>


		<div class="row"></div>
  
  <p id="market-paying">결제 예정 금액 : ${totalPrice} </p>

  		<a href="marketOrder?user_id=<%=user_id%>" class="btn btn-info" id="marketOrderPage">주문하기</a>
  		<a href="marketview" id="reshop" class="btn btn-success">계속 쇼핑하기</a>
  </div>
  


               


  
   <script>
   $(function() {
	    $("#marketAllCheck").on("click", function() {
	      var isChecked = $(this).is(":checked");
	      $("[id^=marketProductCheck]").prop("checked", isChecked);
	    });
   
     $(function(){
  	$("#market_search").keydown(function(event){
  		event.preventDefault();
  		var marketSearch ="";
  		if (event.keyCode === 13) {
  			marketSearch=$("#market_search").val();
  			location.href='${pageContext.request.contextPath}/market/marketSearch?book_title='+marketSearch;
  		}
  		
  		marketSearch = "";
  	});
  });
   </script>                              
<%@include file="../inc/footer.jsp" %>