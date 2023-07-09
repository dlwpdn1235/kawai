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
        //7/9까지 prev , next 버튼 구현
        calendarNow();
        //calendarPrev();
        //calendarNext();
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
                console.log(json.mycalc);
                for (var i = 0; i < json.mycalc.calc_days.length; i++) {
                    if (i % 7 === 0) {
                        tr = $("<tr>");
                    }
                    var td = $("<td>");
                    td.append(json.mycalc.calc_days[i]);
                    if (td.text() != "") {
                        var image = $("<img>").attr("src", "https://img.danawa.com/img/m/dpg/attendance/stamp_check3.png");
                        image.addClass("imgbutton"); 
                        td.append(image);
                    }
                    tr.append(td);
                    $("#mytable tbody").append(tr);
                }

                // 이미지 클릭 이벤트 처리
                $(".imgbutton").on("click", function() {
                    $(this).addClass("red"); 
                });
            }
        });
    }
</script>
	
<!-- 		  // 나는 지금 달력까지 완성했고 이미지까지 달력에 들어간다
		      // 이제 해야할것은 eventdao에있는 출석체크 한적이 있니? 라는 구문을 돌려 값이 0이면 출석체크를 넣어주는 것
		      
		      
		      /// 여기까지는 로그인서비스의 영역
		      
		      
		      // 하지만 여기서해야할것은 내가 출석한 기록을 담은 테이블에 있는 값의 날만 도장의 색이 빨간색으로 변하는것
		      // 그러려면 eventdao에있는 accountEventList를 불러와서 거기있는 날짜만 색 변경
		      // 그리고 버튼을 누르면 흑백에서 빨간으로 변경
 -->
	
<%@ include file="../inc/footer.jsp" %>