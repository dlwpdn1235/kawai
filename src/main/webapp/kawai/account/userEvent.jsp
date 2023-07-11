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
		                <th  colspan="7">
		                   <h4 class="text-center"><span class="myc year"></span>년  <span class="myc month"></span>월 의 이벤트!!</h4>
		                </th>
		            </tr>
		            <tr id="yoil" ><th scope="col">SUN</th><th scope="col">MON</th><th scope="col">TUE</th>
		              	<th scope="col">WED</th><th scope="col">THU</th><th scope="col">FRI</th>
		               	<th scope="col">SAT</th></tr>
		         </thead>
        		 <tbody>
   
         		 </tbody>
     		</table>
	</div> <!-- myCalendar -->
<script>
$(function(){
    // 7/9까지 prev , next 버튼 구현
    calendarNow();
});

function calendarNow() {
    $.ajax({
        url: "myCalendar",
        type: "GET",
        dataType: "json",
        contentType: "application/json;charset=UTF-8",
        error: function(xhr, status, msg) {
            alert(status + "/" + msg);
        },
        success: function(json) {
        	console.log(json);
            $("#mytable tbody").empty();
            $(".year").html(json.mycalc.year);
            $(".month").html(json.mycalc.month);          
            var calcDays = json.mycalc.calc_days; 
            var eventDays = json.eventDates;      
            /*
            if (json.eventDates.length > 0) {
            	eventDates_result = [json.accountEventList[0].eventdate];
            }*/
            var checkDays  =  new Array(42);  //42
            for(var i = 0 ; i < 42; i++){ checkDays[i] = 0; } 
            
            // i가 유저의 출석날자(eventDays)와 같다면 
            for(var i = 0 ; i < checkDays.length; i++){  //42
                console.log(  typeof(eventDays[i]));
            	var data =   parseInt(  json.mycalc.startyoil ) + parseInt( eventDays[i] )-2   ;
				checkDays[   parseInt( data  ) ] = 1;   
            }         
            console.log("유저의 출석날짜 " + eventDays);   //9 , 10
            console.log("42을도는 체크날짜"+ checkDays);
            for (var i = 0; i < calcDays.length; i++) {
                if (i % 7 === 0) {
                    tr = $("<tr>");
                }
                var td = $("<td>");
                td.append(calcDays[i]);
                // 출석체크한 날짜인 경우 이미지 변경
                // 1. eventDays(유저가 접속한 날짜가 담긴 값) 이 calcDays달력의 해당 날짜가 일치해야하고 
                // 2. td.text 는 빈칸이 아니여야 한다.    
                // 반복을 돌고 있는 i찾기
                // (빈칸 +9)라면
                 console.log(i +"/"+ checkDays[i] +"/"+ (i == checkDays[i]));                
                 if (checkDays[i]==1) {
                	console.log(i +"/"+ checkDays[i]);
                    var image = $("<img>").attr("src", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRGob2rT16jqTmdN2x1sgp4mi-SiInGVZOaMg&usqp=CAU"); 
                    td.append(image);
                } else if (td.text() != "") {
                    var image = $("<img>").attr("src", "https://img.danawa.com/img/m/dpg/attendance/stamp_check3.png");
                    td.append(image);
                } 
                tr.append(td);
                $("#mytable tbody").append(tr);
                
            }
        }
    });
}
</script>
	
<%@ include file="../inc/footer.jsp" %>
