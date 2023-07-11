<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>

   <div class="container panel">
      <h3 class="panel-heading tmpt" style="font-weight:bold">주문 결제</h3>   
      <div class="borderLine">    </div>
      
      
   <div class="container panel">
   		<h4>구매자 정보</h4>
   		<table>
   			<thead>
   				<tr>
   				<th id="marketThOption">이름</th>
   				<td id="marketTdOption">${user_id } 테스트</td>
   				</tr>
   				
   				<tr>
   				<th id="marketThOption">이메일</th>
   				<td id="marketTdOption">${user_id } 테스트</td>
   				</tr>
   				
   				
   				<tr>
   				<th id="marketThOption">휴대폰 번호</th>
   				<td id="marketTdOption">${user_id } 테스트</td>
   				</tr>
   			</thead>
   		</table>
   		
   		
   		<div class="marketReceiveAddress">
   		
   		<h4>받는사람 정보 <input type="submit" class="btn btn-info" value="배송지 변경"/> </h4>
   		</div>
   		
   		<table>
   			<thead>
   				<tr>
   				<th id="marketThOption">이름</th>
   				<td id="marketTdOption">${user_id } 테스트</td>
   				</tr>
   				
   				<tr>
   				<th id="marketThOption">배송지 주소</th>
   				<td id="marketTdOption">${user_id } 테스트</td>
   				</tr>
   				
   				
   				<tr>
   				<th id="marketThOption">연락처</th>
   				<td id="marketTdOption">${user_id } 테스트</td>
   				</tr>
   				
   				
   				<tr>
   				<th id="marketThOption">배송요청 사항</th>
   				<td id="marketTdOption">${user_id } 테스트</td>
   				</tr>
   			</thead>
   		</table>
   </div>   
	
					<div class="marketProduct-group">
					<span class="marketProductReceive">배송 내용${mContent }</span>
					<pre>
					상품 이름 : ${mName }
					상품 수량 : ${mCount }
					</pre>
					</div>
					
	<div class="marketProductSumPrice">
		최종결제금액		${mSumPrice }
	</div>
			
	<div class="marketProductPaying">
			<input type="button" class="btn btn-info" value="결제하기"/>
	</div>
      
   </div>                                                        
<%@include file="../inc/footer.jsp" %>
<!-- 
   
 -->