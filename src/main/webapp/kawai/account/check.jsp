<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %> 
<script>
var result = '${success}';
if(result=="fail"){ alert("회원가입 실패!"); history.go(-1); }
else if(result.length != 0){ alert(result); }
</script>
<div class="container panel" id="accountSingUpView">
    <h3 class="text-center"> ~출석체크 이벤트~ </h3>
    <table class="table table-bordered" id="mytable">
        <caption class="text-center"> 매월 출석체크 20일을 채우시면 지역상품권 지급!! </caption>
        <thead>
            <tr>
                <th colspan="7">
                    <button id="prevButton">이전</button> <!-- 이전 버튼 -->
                    <h4 class="text-center"><span class="myc year"></span>년  <span class="myc month"></span>월 의 이벤트!!</h4>
                    <button id="nextButton">다음</button> <!-- 다음 버튼 -->
                </th>
            </tr>
            <tr id="yoil">
                <th scope="col">SUN</th>
                <th scope="col">MON</th>
                <th scope="col">TUE</th>
                <th scope="col">WED</th>
                <th scope="col">THU</th>
                <th scope="col">FRI</th>
                <th scope="col">SAT</th>
            </tr>
        </thead>
        <tbody>

        </tbody>
    </table>
</div> <!-- myCalendar -->
<script>
$(function(){
    // 7/9까지 prev , next 버튼 구현
    var currentDate = new Date(); // 현재 날짜 정보 가져오기
    var year = currentDate.getFullYear(); // 현재 연도 가져오기
    var month = currentDate.getMonth() + 1; // 현재 월 가져오기
    
    $(".year").html(year);
    $(".month").html(month);
    
    calendarNow();
});

function calendarNow() {
    // ... (이전 코드 그대로 유지)
}

// 이전 버튼에 대한 이벤트 리스너
$("#prevButton").on("click", function() {
    var year = $(".year").html();
    var month = $(".month").html();

    // 현재 날짜에서 한 달을 빼줍니다.
    var newDate = new Date(year, month - 2, 1);
    var newYear = newDate.getFullYear();
    var newMonth = newDate.getMonth() + 1;

    $(".year").html(newYear);
    $(".month").html(newMonth);

    // 업데이트된 연도와 월을 사용하여 calendarNow() 함수를 호출합니다.
    calendarNow();
});

// 다음 버튼에 대한 이벤트 리스너
$("#nextButton").on("click", function() {
    var year = $(".year").html();
    var month = $(".month").html();

    // 현재 날짜에 한 달을 더해줍니다.
    var newDate = new Date(year, month, 1);
    var newYear = newDate.getFullYear();
    var newMonth = newDate.getMonth() + 1;

    $(".year").html(newYear);
    $(".month").html(newMonth);

    // 업데이트된 연도와 월을 사용하여 calendarNow() 함수를 호출합니다.
    calendarNow();
});
</script>

<%@ include file="../inc/footer.jsp" %>