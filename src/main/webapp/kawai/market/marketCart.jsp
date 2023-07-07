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
     <form action="/market_order?mcart_id="${mcart_id } method="post">
     
   <div class="marketCheck">
			<label for="marketAllcheck" id="marketAllcheck">전체선택</label>
			<input type="checkbox" id="marketAllCheck"/>
  </div>
     
   <div>
       <c:forEach var="market" items="${marketlist}">
       <hr/>
    <div class="col-sm-3">
   
        <label for="marketProductCheck${i}"></label>
        <input type="checkbox" value="1" id="marketProductCheck${i}" />
      
        <a href="${pageContext.request.contextPath }/market/marketDetail?market_id=${market.market_id }">
        <img src="${pageContext.request.contextPath }../img/marketLikeUnCheck.jpg" alt="책이미지" />
        </a>
        
        <p>출판사 : </p>
        <span id="marketPrice">${market.MPrice}</span>
        
      </div>
      <hr/>
    </c:forEach>
    

  <div class="row"></div>
  <p id="market-paying">결제 예정 금액 : ${mSumPrice }</p>
  <div class="marketBuy">
  		<input type="submit" class="btn btn-info" value="주문하기(${mCount})"/>
  </div>
  
  <div class="marketDelete">
  		<input type="button" class="btn btn-danger" value="삭제"/>
  </div>
    
    
    
  </div>
  
  

  
  </form>                
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