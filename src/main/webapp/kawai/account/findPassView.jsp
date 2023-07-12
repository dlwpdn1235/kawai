<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
	<div class="container" id="accountLoginView">
		<form action="${pageContext.request.contextPath}/account/findPass" method="post" id="form" >
			<div class="form-group">
	            <label for="id">이메일을 입력해주세요.</label>
	            <input type="email" id="email" name="email" placeholder="email을 입력해주세요."  class="form-control" /> 
	        </div>
            <div class="form-group">
				<input type="submit" class="btn btn-success form-control" value="email로 비밀번호 전송"/>
			</div>
        </form>
	</div>
<%@ include file="../inc/footer.jsp" %>