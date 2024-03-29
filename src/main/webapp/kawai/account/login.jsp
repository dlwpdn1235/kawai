<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>    
    <script>
var result = '${success}';
if(result=="fail"){ alert("회원가입 실패!"); history.go(-1); }
else if(result.length != 0){ alert(result); }
</script>          
	<!-- img 태그의 width에 맞춰 h태그의 사이즈가 따라옴 -->
	<div class="container" id="accountLoginView">
		<p class="text-center"><img  style="width:100px;" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFP0-wv89LkxDV8yIpgNVEe7T-0YIqczCH3A&usqp=CAU" alt="??" ><p>
		<h3 class ="text-center">동네글방 로그인</h3>
		<form action="${pageContext.request.contextPath}/account/login" method="post" id="loginform" >
			<fieldset>
				<div class="form-group text-center">
					<label class="a" for="input_id">ID</label>
					<input type="text" id="input_id" name="id" data-check="" />
				</div>
				<div class="form-group text-center">
					<label for="input_pass">PASSWORD</label>
					<input type="password" id="input_pass" name="pass" data-check="" />
				</div>
				<div class="form-group text-center">
					<input type="submit" class="btn btn-warning" value="LOGIN"  />
				</div>
				<!-- 카카오 로그인 -->
				<a class="p-2" href="https://kauth.kakao.com/oauth/authorize?client_id=5b0f67c0f0c2554251291f96f710c67d&redirect_uri=http://3.34.129.104:8080/kawaiProject/account/kakaoToken&response_type=code">
				<img style="width: 300px; margin-left: 430px;" src="https://papaspick.com/web/upload/2019_web/icon/kakao_login.jpg" ><!-- http://3.34.129.104:8080/kawaiProject/kawai/account/kakaoToken -->
  				</a>
			</fieldset>
		</form>
			<div class="row  text-right"    >
				 <a href="${pageContext.request.contextPath}/account/findPass"  class="btn" >비밀번를 잊으셨나요</a> 
			</div>	
	</div>
	
<script>
	$("#loginform").on("submit",function(){
		if ($("#input_id").val().trim()==""){
			alert('아이디를 입력해주세요.');
			$("#input_id").focus();
			retrun false;
		}else if($("#input_pass").val().trim()==""){
			alert('비밀번호를 입력해주세요.');
			$("#input_pass").focus();
			retrun false;
		};
	});
</script>
<%@ include file="../inc/footer.jsp" %>