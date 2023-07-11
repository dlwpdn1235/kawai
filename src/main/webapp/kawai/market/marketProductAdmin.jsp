<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../inc/header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



   <div class="container panel tmpt">
      <h3 class="panel-heading">관리자 내역</h3>   
	
<table class="marketProductTable">
	<thead>
			<tr>
				<th scope="col">글 번호</th>
				<th scope="col">작성자</th>
				<th scope="col">책제목</th>
				<th scope="col">등록날짜</th>
				<th scope="col">수정</th>
				<th scope="col">삭제</th>				
			</tr>
	<tbody>
		
		<tbody>
			<c:forEach var = "market" items="${list}">
			<tr class="trMargin">
				<td class="col-sm-2">${market.market_id }</td>
				<td class="col-sm-2">${market.user_id }</td>
				<td class="col-sm-2">${market.bookinfo.book_title }</td>
				<td class="col-sm-2">${market.MDate }</td>
				<td class="col-sm-2"><a href="${pageContext.request.contextPath}/market/marketProductWriteUpdate?market_id=${market.market_id}" class="btn btn-info">수정</a></td>
				<td class="col-sm-2"><a href="${pageContext.request.contextPath}/market/marketProductDelete?market_id=${market.market_id}" class="btn btn-danger">삭제</a></td>

			</tr>
			</c:forEach>
		</tbody>


</table>
</form>
   </div>
<div class="marketOderOkLine"></div>
<!--    		 <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        }
    }).open();
</script> -->
                      
<%@include file="../inc/footer.jsp" %>
<!-- 
   
 -->