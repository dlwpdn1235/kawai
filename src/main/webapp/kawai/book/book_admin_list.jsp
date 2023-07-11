 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/kawai/inc/header.jsp" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
	
<div class="container map_container">
		<h1>서점 등록 리스트</h1>
		<c:forEach items="${list}" var="store">
					<div class="row">
						<div class="col-sm-6 text-center">
						<img alt="이미지" class="img-circle  img_bs_img"
									   		 src="${pageContext.request.contextPath}/resources/upload/${store.bfile}">
						</div>
						<div class="col-sm-6">
								   <p><a href="${pageContext.request.contextPath}/kawai/detail.kawai?bs_name=${store.bs_name}">${store.bs_name}</a></p>
								   	<p>${store.bs_address_detail}</p>
						</div>
					</div>	
		</c:forEach>
						
							
</div>
<div>
	<a href='${pageContext.request.contextPath}/kawai/main2'>메인으로</a>
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
img.img_bs_img {
    width: 157px;
    height: 155px;
    border: 2px #666 solid;
    flex-basis: 128px;
    flex-shrink: 0;
}
.col-sm-8 {
    padding: 16px;
}
.div_img {
    width: 165px;
}

</style>
