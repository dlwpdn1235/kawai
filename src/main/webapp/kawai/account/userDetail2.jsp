<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../inc/header.jsp" %>
<script>
var result = '${success}';
if(result=="fail"){ alert("회원가입 실패!"); history.go(-1); }
else if(result.length != 0){ alert(result); }
</script>
	<div class="container panel panel-warning" id="accountSingUpView">
			<h3>나의 정보</h3>
			<div class="form-group"  >
			  <span class="glyphicon glyphicon-plus"><label for="bname">아이디</label></span>
			  <input type="text" id="id"  name="id" value="${userInfo.id}"  readonly="readonly" class="form-control" /> 
			</div>				
			<div class="form-group"  >
			  <span class="glyphicon glyphicon-plus"><label for="bname">이름</label></span>
			  <input type="text" id="name"  name="name" value="${userInfo.name}"  readonly="readonly" class="form-control" /> 
			</div>
			<div class="form-group"  >
			  <span class="glyphicon glyphicon-plus"><label for="bname">생년월일</label></span>
			  <input type="text" id="birth"  name="birth" value="${userInfo.birth}"  readonly="readonly" class="form-control" /> 
			</div>
			<div class="form-group"  >
			  <span class="glyphicon glyphicon-plus"><label for="bname">이메일</label></span>
			  <input type="text" id="email"  name="email" value="${userInfo.email}"  readonly="readonly" class="form-control" /> 
			</div>
			<div class="form-group"  >
			  <span class="glyphicon glyphicon-plus"><label for="bname">전화번호</label></span>
			  <input type="text" id="phonenum"  name="phonenum" value="${userInfo.phonenum}"  readonly="readonly" class="form-control" /> 
			</div>
			<div class="form-group"  >
			  <span class="glyphicon glyphicon-plus"><label for="bname">우편번호</label></span>
			  <input type="text" id="postnum"  name="postnum" value="${userInfo.postnum}"  readonly="readonly" class="form-control" /> 
			</div>
			<div class="form-group"  >
			  <span class="glyphicon glyphicon-plus"><label for="bname">주소</label></span>
			  <input type="text" id="address"  name="address" value="${userInfo.address}"  readonly="readonly" class="form-control" /> 
			</div>
			<div class="form-group"  >
			  <span class="glyphicon glyphicon-plus"><label for="bname">가입일</label></span>
			  <input type="text" id="create_date"  name="create_date" value="${userInfo.create_date}"  readonly="readonly" class="form-control" /> 
			</div>
				<c:forEach var="coupon" items="${couponInfo.couponList}">
			<div class="form-group"  >
			  <span class="glyphicon glyphicon-plus"><label for="bname">쿠폰번호</label></span>
			  <input type="text" id="coupon"  name="coupon" value="${coupon.couponname}"  readonly="readonly" class="form-control" /> 
			</div>
				</c:forEach>
			<div class="row  text-right"    >
				 <a href="${pageContext.request.contextPath}/account/userEdit2?id=${userInfo.id}"  class="btn" >수정</a> 
				 <a href="${pageContext.request.contextPath}/account/userDelete?id=${userInfo.id}"  class="btn" >삭제</a> 
			</div>	
	</div>
<%@ include file="../inc/footer.jsp" %>