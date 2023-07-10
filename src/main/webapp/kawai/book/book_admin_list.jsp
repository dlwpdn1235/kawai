 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/kawai/inc/header.jsp" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
	<div class="container map_container col-sm-12">
		<h1>서점 등록 리스트</h1>
		<div class="col-sm-3">
		</div>
		<div class="col-sm-8">
			<div>
			    <c:forEach items="${list}" var="store">
				    <span>${store.bs_no}</span>
				    <span>${store.bs_name}</span>
				    <span>${store.tagNames}</span>
				    <span>
				        <!-- 해시태그 출력 -->
				        <c:forEach items="${tag}" var="tag">
				            ${tag} 
				        </c:forEach>
				    </span><br>
				</c:forEach>  
			<%-- <c:forEach var="tag" items="${tagNames}" varStatus="status">
			<span>${tag.tag_name}</span>
			</c:forEach> --%>	
			<%-- <c:forEach var="list" items="${list}" varStatus="status">
			<span class="img_radius"><img class="profile" src="${pageContext.request.contextPath}/kawai/img/iron.jpg" alt="이미지"> </span>
			<span>${list.tag_id}</span>
			<span>${list.bs_name}</span><br>
			<span>${list.bs_address_detail}</span><br>
			</c:forEach> --%>
			<%-- <c:forEach var="tagName" items="${tagNames}" varStatus="status">
		    		<span>${tagName}</span>
			</c:forEach> --%>
			</div>
		</div>
		<div class="col-sm-3">
		</div>
		<div>
			<a href='${pageContext.request.contextPath}/kawai/main2'>메인으로</a>
		</div>
		
		
		
	</div>
<%@ include file="/kawai/inc/footer.jsp" %>
<style>
img.profile {
    border-radius: 44%;
}
.profile {
    width: 11%;
    height: 11%;
    object-fit: cover;
}
</style>
