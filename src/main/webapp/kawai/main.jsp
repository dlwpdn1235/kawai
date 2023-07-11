<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="inc/header.jsp"%>
<script>
var result = '${success}';
if(result=="fail"){ alert("회원가입 실패!"); history.go(-1); }
else if(result.length != 0){ alert(result); }
</script>
<%@ include file="book/main2.jsp" %>
<%@ include file="community/commMain.jsp" %>
<%@ include file="inc/footer.jsp"%>