<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="../inc/header.jsp" %>
<div class="container panel panel-warning" id="accountDeleteView">
    <h3>회원 탈퇴</h3>
    <form action="${pageContext.request.contextPath}/account/userDelete" method="POST">
        <div class="form-group">
            <label for="id">아이디</label>
            <input type="text" id="id" name="id" value="${userInfo.id}" readonly="readonly" class="form-control" /> 
        </div>				
        <div class="form-group">
            <label for="pass">비밀번호</label>
            <input type="password" id="pass" name="pass" class="form-control" /> 
        </div>
        <div class="row text-right">
            <button type="submit" class="btn btn-danger">탈퇴</button>
            <a href="${pageContext.request.contextPath}/account/userDetail?id=${userInfo.id}" class="btn btn-default">취소</a>
        </div>
    </form>
</div>
<%@ include file="../inc/footer.jsp" %>