<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.jsp" %>
<div class="container panel panel-warning" id="accountEditView">
<script>
var result = '${success}';
if(result=="fail"){ alert("회원가입 실패!"); history.go(-1); }
else if(result.length != 0){ alert(result); }
</script>
	<h3>회원 정보 수정</h3>
	<form action="${pageContext.request.contextPath}/account/userEdit" method="POST">
		<div class="form-group">
			<span class="glyphicon glyphicon-plus"><label for="id">아이디</label></span>
			<input type="text" id="id" name="id" value="${userInfo.id}" readonly="readonly" class="form-control" /> 
		</div>				
		<div class="form-group">
			<span class="glyphicon glyphicon-plus"><label for="name">이름</label></span>
			<input type="text" id="name" name="name" value="${userInfo.name}" class="form-control" /> 
		</div>
		<div class="form-group">
			<span class="glyphicon glyphicon-plus"><label for="birth">생년월일</label></span>
			<input type="text" id="birth" name="birth" value="${userInfo.birth}" class="form-control" /> 
		</div>
		<div class="form-group">
			<span class="glyphicon glyphicon-plus"><label for="email">이메일</label></span>
			<input type="text" id="email" name="email" value="${userInfo.email}" class="form-control" readonly="readonly" /> 
		</div>
		<div class="form-group">
			<span class="glyphicon glyphicon-plus"><label for="phonenum">전화번호</label></span>
			<input type="text" id="phonenum" name="phonenum" value="${userInfo.phonenum}" class="form-control" /> 
		</div>
		<div class="form-group">
			<span class="glyphicon glyphicon-plus"><label for="postnum">우편번호</label></span>
			<input type="text" id="postnum" name="postnum" value="${userInfo.postnum}" class="form-control" /> 
		</div>
		<div class="form-group">
			<span class="glyphicon glyphicon-plus"><label for="address">주소</label></span>
			<input type="text" id="address" name="address" value="${userInfo.address}" class="form-control" /> 
		</div>
		
		<div class="row text-right">
			<button type="submit" class="btn btn-primary">수정</button>
			<a href="${pageContext.request.contextPath}/account/userDetail?id=${userInfo.id}" class="btn btn-default">취소</a>
		</div>
	</form>
</div>
<%@ include file="../inc/footer.jsp" %>