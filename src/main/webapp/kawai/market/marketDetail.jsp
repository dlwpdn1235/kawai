
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
#market_search{
float-left:80px;
}
</style>

   <div class="container panel tmpt">
      <h3 class="panel-heading">

      </h3>   
	</div>
	
	<div class="marketDetail-group">
	<div class="marketTitle">
		${market.bookinfo.book_title}
	</div>
	
	<div class="market-group">
		<div class="marketImage-group">
			<img src="${market.bookinfo.book_image }" alt="${market.bookinfo.book_title }" style="width:500px;"/>
			<div class="marketPrice">
			<!-- mCart에 있는 장바구니 List를 뽑아서 값 합산하기. 단일값일 경우 market.MPrice. -->
				<h3 class="marketsumPrice">총 상품 금액 : ${market.MPrice }</h3>
				
				<div class="marketRec">
					<label for="marketAddress"></label>
				배송지 <input type="button" id="marketAddress" class="btn btn-info" value="변경"/>
					<div class="marketDetailLine"></div>		
				</div>
			
			    <div class="marketDetailSumPrice">
				    <label for="minus"></label>
				    <input Type="button" id="minus" name="minus" value="-" class="marketDetailMinus"/>
				    1
				    <label for="plus"></label>
				    <input Type="button" id="plus" name="plus" value="+" class="marketDetailPlus"/>
    			</div>	
    			
    		    <div class="row"></div>
  	<form action="marketCart?market_id=${market.market_id }" method="post">
    <div class="marketCart" id="marketSum">
    	<input type="submit" class="btn btn-danger" value="장바구니"/>
     </div>
     </form>
     
     <form action="marketCareer?market_id=${market.market_id }" method="post">
     <input type="submit" class="btn btn-info" value="담기"/>
     </form>
     
     <div class="marketQuick">
    	<a href="#" class="btn btn-info" id="marketDetailQuick">바로가기</a>		    
   	 </div>
    

    
	
    			
			
		</div>


			
    	</div>  
    </div>
	${market.bookinfo.book_author }
	
	${market.bookinfo.book_publisher }
	
	
    	       
    </div>
    

    
   <div class="text-center">   
</div>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<script>


$(function() {
	  var result = 0;

	  $("#plus").on("click", function() {
	    result++;
	    console.log("Result: " + result);
	  });

	  $("#minus").on("click", function() {
	    result--;
	    console.log("Result: " + result);
	  });
	});
	
$(function() {
  $("#marketAddress").on("click", function() {
    new daum.Postcode({
      oncomplete: function(data) {
        // 주소 검색 완료 후 실행할 코드를 작성하는 부분입니다.
        // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        console.log(data);
      }
    }).open();
  });
});

$(function() {
  $("#marketAddress").on("click", function() {
    window.location.href = "#";
  });
});
</script>

<%@include file="../inc/footer.jsp" %>
