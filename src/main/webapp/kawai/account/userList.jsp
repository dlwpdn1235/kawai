<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.jsp" %>    
<script>
var result = '${success}';
if(result=="fail"){ alert("회원가입 실패!"); history.go(-1); }
else if(result.length != 0){ alert(result); }
</script>

	<div class="container panel panel-warning" id="accountLoginView">
		<h3 class="panel-heading">유저 목록</h3>
		<table class="table table-striped">
			<caption>회원 관리</caption>
			<thead>
				<tr>
					<th>성함</th>
					<th>아이디</th>
					<th>이메일</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="user" items="${userList}">
					<tr>
						<td>${user.name}</td>
						<td> <a href="${pageContext.request.contextPath}/account/userDetail?id=${user.id}">${user.id}</a> </td>
						<td>${user.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	
<%@ include file="../inc/footer.jsp" %>