<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<div class="container tmpt">
	<h3>공지사항</h3>
	<br />
<div class="well">
	<div class="row ajaxMarket text-center">
		<table class="table table-striped table-hover commListTable">
			<colgroup>
				<col style="width: 20%">
				<col style="width: 40%">
				<col style="width: 10%">
				<col style="width: 20%">
				<col style="width: 10%">
			</colgroup>
			<thead>
				<tr>
					<th scope="col" class="text-center">카테고리</th>
					<th scope="col" class="text-center">제목</th>
					<th scope="col" class="text-center">작성자</th>
					<th scope="col" class="text-center">날짜</th>
					<th scope="col" class="text-center">조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="commlistt" items="${commList}" varStatus="status">
					<tr>
						<td>공지사항</td>
						<td><a href="${pageContext.request.contextPath}/community/commDetail?community_id=${commlistt.community_id}" title="디테일페이지로">${commlistt.community_title}</a></td>
						<td>${commlistt.user_id}</td>
						<td>${commlistt.community_date}</td>
						<td>${commlistt.community_hit}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</div>

