<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/inc/header.jsp" %>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<div>
</br>
</br>
<h2>지도</h2>
<p></p>

<div class="book_container">
  <div class="bookleft">
  	<form> 
		<input type="text" placeholder="검색" name="keyword" value="${keyword}" /> 
		<input type="submit" value="검색" /> 
	</form> 
  </div>
  <div class="bookright">지도 API 넣기</div>
</div>
	  <%-- 예시로서 검색 결과 표시 --%>
    <table>
        <thead>
            <tr>
                <th>Bookstore Name</th>
                <th>Address</th>
                <th>Phone Number</th>
            </tr>
        </thead>
        <tbody>
            <%-- 검색 결과를 반복해서 테이블 행으로 표시 --%>
            <c:forEach items="${blist}" var="bookstore">
                <tr>
                    <td>${bookstore.bs_name}</td>
                    <td>${bookstore.bs_address}</td>
                    <td>${bookstore.bs_phonenum}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<%@ include file="/inc/footer.jsp" %>

<script>
$('input[type="text"]').css('width', '400px');
$('.book_container').css('display', 'flex');
$('.book_container').css('justify-content', 'center');
$('.bookleft, .bookright').css('flex-basis', '50%');
$('.bookleft, .bookright').css('justify-content', 'center');

</script>

