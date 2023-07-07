<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>
   <div class="container panel tmpt">
      <h3 class="panel-heading">유저 상품 수정</h3>   
      <div class="marketUserUpdate-group">           
		   <div class="marketUserUpdateName marketUserUpdateCon">
		   		<input type="text" class="form-control" readOnly/>
		   </div>
		   
		    <div class="marketUpdateTitle marketUserUpdateCon">
		   		<input type="text" class="form-control"/>
		   </div>
		   
		   
		    <div class="marketUpdatePrice marketUserUpdateCon">
		   		<input type="text" class="form-control" placeholder="가격"/>
		   </div>
		   
		    <div class="marketUpdateContent marketUserUpdateCon">
		   		<textarea rows="4" cols="100" name="marketUpdateContent" class="form-control"></textarea>
		   </div>
		   
		   <div class="marketUserUpdateSubmit">
		   		<input type="button" class="btn btn-info" value="수정완료"/>
		   		<input type="button" class="btn btn-danger" value="수정취소"/>
		   </div>
		   
	  </div>
</div>                        
<%@include file="../inc/footer.jsp" %>
<!-- 
   
 -->