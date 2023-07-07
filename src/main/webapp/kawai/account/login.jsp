<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>    
    
	<!-- img 태그의 width에 맞춰 h태그의 사이즈가 따라옴 -->
	<div class="container" id="accountLoginView">
		<p class="text-center"><img  style="width:100px;" src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFP0-wv89LkxDV8yIpgNVEe7T-0YIqczCH3A&usqp=CAU" alt="??" ><p>
		<h3 class ="text-center">동네글방 로그인</h3>
		<form action="${pageContext.request.contextPath}/account/login" method="post" id="loginform" >
			<fieldset>
				<div class="form-group text-center">
					<label class="a" for="input_id">ID</label>
					<input type="text" id="input_id" name="id" />
				</div>
				<div class="form-group text-center">
					<label for="input_pass">PASSWORD</label>
					<input type="password" id="input_pass" name="pass" />
				</div>
				<div class="form-group text-center">
					<input type="submit" class="btn btn-warning" value="LOGIN"  />
				</div>
				<div class="form-group text-center">
					<p><a href="https://www.naver.com"><img  style="width: 300px;" src="https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Ft1.daumcdn.net%2Fcfile%2Ftistory%2F9902043E5B34B47D0D" ></a></p>
				</div>
				<div id="my-signin2"></div>
				  <script>
				    function onSuccess(googleUser) {
				      console.log('Logged in as: ' + googleUser.getBasicProfile().getName());
				    }
				    function onFailure(error) {
				      console.log(error);
				    }
				    function renderButton() {
				      gapi.signin2.render('my-signin2', {
				        'scope': 'profile email',
				        'width': 240,
				        'height': 50,
				        'longtitle': true,
				        'theme': 'dark',
				        'onsuccess': onSuccess,
				        'onfailure': onFailure
				      });
				    }
				  </script>
				
				  <script src="https://apis.google.com/js/platform.js?onload=renderButton" async defer></script>
				  <div class="form-group text-center">
				  	<p><a href="https://www.kakaocorp.com/"><img style="width: 300px;" src="https://papaspick.com/web/upload/2019_web/icon/kakao_login.jpg" ></a></p>
				  </div>
			</fieldset>
		</form>
		
		
		
		
		
	</div>
<%@ include file="../inc/footer.jsp" %>