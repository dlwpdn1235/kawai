<%@page import="com.kawai.dto.MarketDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
MarketDto dto = new MarketDto();
%>

   <div class="container panel">
      <h3 class="panel-heading"></h3>   
      <form method="${pageContext.request.contextPath}/marketSearch.kawai" method="get">
   	<div class="row well">
   		<div class="col-sm-4">
	   		<div class="row">

	   			<div class="col-sm-6">
	   			<select name="year">
				  <c:forEach var="i" begin="0" end="6" step="1" varStatus="status">
				    <option value="i">${2023-i}년</option>
				  </c:forEach>
				</select>
	   			</div>
	   			<div class="col-sm-6">
	   			<select name="month">
	   				<c:forEach var="i" begin="1" end="12" step="1">
	   				<option value="i">${i}월</option>
	   				</c:forEach>
	   			</select>
	   			</div>
	   		</div>
   		</div>
   		
   		<div class="col-sm-4">
	   			   <input type="search" id="market_search" placeholder="책 정보입력" autocomplete="off"/>  
   		</div>
   		
   		<div class="col-sm-4">
   			<div class="row">
   				<div class="col-sm-6">

   					<select name="marketOption">
   						<option value="1">판매량순</option>
   						<option value="2">등록일순</option>
   						<option value="3">높은 가격순</option>
   						<option value="4">낮은 가격순</option>
   					</select>
   				</div>
   				<div class="col-sm-6">
   					<select name="marketListCount">
   						<option value="1">20개씩 보기</option>
   						<option value="2">40개씩 보기</option>
   					</select>
   				</div>
   			</div>
   		</div>
   	</div>
  	</form>



	<!-- Form 체크하는 곳 select 박스 이용해서 장바구니 -->
		<div id="marketCheck">
			<label for="marketAllcheck">전체선택</label>
			<input type="checkbox" id="marketAllCheck"/>

			<label for="marketLikeCheck">
			<input type="checkbox" id="marketLikeCheck" style="display:none;"/>
			<img src="../img/marketLikeUnCheck.jpg" />
			</label>
			
		</div>

<%--     <c:forEach var="i" begin="1" end="20" step="1"> --%>
<!--     <div class="col-sm-3"> -->
    
<%--         <label for="marketProductCheck${i}"></label> --%>
<%--         <input type="checkbox" value="1" id="marketProductCheck${i}" /> --%>
<%--         <a href="marketDetail.jsp?market_id=${market_id.market_id }"> --%>
<!--         <img src="../img/marketLikeCheck.jpg" alt="책이미지" /> -->
<!--         </a> -->
<!--         <p>출판사 : ㅁㄴㅇㄴㅇㅁ</p> -->
<!--         <span id="marketPrice">가격</span> -->
<!--       </div> -->
<%--     </c:forEach> --%>



    <c:forEach var="market" items="${marketlist}">
    <div class="col-sm-3">
    
        <label for="marketProductCheck${i}"></label>
        <input type="checkbox" value="1" id="marketProductCheck${i}" />
      
        <a href="${pageContext.request.contextPath }/market/marketDetail?market_id=${market.market_id }">
        <img src="${pageContext.request.contextPath }../img/marketLikeUnCheck.jpg" alt="책이미지" />
        </a>
        
        <p>출판사 : </p>
        <span id="marketPrice">${market.MPrice}</span>
        
      </div>
    </c:forEach>
  </div>
  
 <script>
 
  $(function() {
    $("#marketAllCheck").on("click", function() {
      var isChecked = $(this).is(":checked");
      $("[id^=marketProductCheck]").prop("checked", isChecked);
    });

    $("#marketLikeCheck").on("click", function() {
      var isChecked = $(this).is(":checked");
      $(this).siblings("img").attr("src", isChecked ? "../img/marketLikeCheck.jpg" : "../img/marketLikeUnCheck.jpg");
    });
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
<!-- 
   
 -->