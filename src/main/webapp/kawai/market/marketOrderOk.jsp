<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>  
   <div class="container panel">
      <h3 class="panel-heading tmpt" style="font-weight:bold">주문결제 완료!</h3>   
      <div class="borderLine"></div>
      
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
   		
   		<div class="marketOderOkLine"></div>
   		
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
      
      
      	<div class="marketProductSumPrice">
		최종결제금액		${mSumPrice }
	</div>
	
		<div class="marketOrderCommit">
			<input type="submit" class="btn btn-info" value="확인"/>
	</div>
         
   </div>                                                 
<%@include file="../inc/footer.jsp" %>  
<!-- 
   
 -->