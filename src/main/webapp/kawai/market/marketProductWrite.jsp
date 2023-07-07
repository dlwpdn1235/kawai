<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>
   <div class="container panel tmpt">
      <h3 class="panel-heading">상품등록</h3>   
      <div class="marketWrite-group">           
		   <div class="marketWriteName marketWriteCon">
		   		<input type="text" class="form-control" placeholder="작성자" readOnly/>
		   </div>
		   
		    <div class="marketWriteTitle marketWriteCon">
		   		<input type="text" class="form-control" placeholder="제목"/>
		   </div>
		   
		   
		    <div class="marketWritePrice marketWriteCon">
		   		<input type="text" class="form-control" placeholder="가격"/>
		   </div>
		   
		    <div class="marketWriteContent marketWriteCon">
		   		<textarea rows="4" cols="100" name="marketWriteContent" class="form-control"></textarea>
		   </div>
		   
		   <div class="marketWriteSubmit">
		   		<input type="button" class="btn btn-info" value="등록완료"/>
		   		<input type="button" class="btn btn-danger" value="취소"/>
		   </div>
		   
	  </div>
</div>                        
<%@include file="../inc/footer.jsp" %>
<!-- 
   
 -->