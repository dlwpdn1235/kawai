<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../inc/header.jsp" %>
<!-- 사용자 회원가입 폼 -->
	<script>
	var result = '${success}';
	if(result=="fail"){ alert("회원가입 실패!"); history.go(-1); }
	else if(result.length != 0){ alert(result); }
	</script> 
	<div class="container body-top" id="accountSingUpView">
		
		<form action="${pageContext.request.contextPath}/account/singUp" method="post" id="form" >
			<fieldset>
				<legend class="text-center">동네글방 회원가입</legend>
				<p>*표시는 필수 입력사항입니다.</p>
				<div class="form-group">
					<label for="id_form_input">아이디 입력(*) </label><span id="id_is_dupl"></span>
					<input type="text" class="form-control" id="id_form_input" name="id" placeholder="사용할 아이디를 입력해주세요"/>
				</div>
				
				<div class="form-group">
					<label for="pass_form_input">비밀번호 입력(*)</label>
					<input type="password" class="pass_form form-control" id="pass_form_input" name="pass" placeholder="비밀번호를 입력해주세요"/>
				</div>
				
				<div class="form-group">
					<label for="pass_re">비밀번호 재입력(*) </label><span id="pass_confirm"></span>
					<input type="password" class="pass_form form-control" id="pass_re" name="pass_re" placeholder="다시 한번 비밀번호를 입력해주세요"/>
				</div>
				<div class="form-group">
					<label for="name_form_input">이름 입력(*)</label>
					<input type="text" class="form-control" id="name_form_input" name="name" placeholder="이름을 입력해주세요"/>
				</div>
				<div class="form-group">
					<label for="birth_form_input">생년월일 입력(*)</label>
					<input type="date" class="form-control" id="birth_form_input" name="birth" />
				</div>
				<div class="form-group">
					<label for="email_form_input">이메일 입력(*)</label>
					<input type="email" class="form-control" id="email_form_input"  name="email" value="${email}" placeholder="이메일을 입력해주세요" readonly="readonly"/>
				</div>
				<div class="form-group">
					<label for="phone_form_input">휴대전화번호 입력(*)</label>
					<input type="text" class="form-control" id="phone_form_input" name="phonenum" placeholder="휴대전화번호를 입력해주세요"/>
				</div>
				<div class="form-group">
					<div style="width:200px;">
						<label for="postnum_form_input">우편번호 입력(5자리)(*)</label>
						<input type="text" class="form-control" id="postnum_form_input" name="postnum" placeholder="우편번호를 입력해주세요" maxlength="5"/>
					</div>
				</div>
				<div class="form-group">
					<label for="postnum_form_input">도로명 주소 입력</label>
					<input type="text" class="form-control" id="basic_addr_form_input" name="basic_addr" placeholder="우편번호를 입력하면 채워집니다." readonly/>
				</div>
				<div class="form-group">
					<label for="addr_form_input">상세주소 입력(*)</label>
					<input type="text" class="form-control" id="addr_form_input" name="address" placeholder="상세주소를 입력해주세요"/>
				</div>
				<div class="form-group">
					<input type="submit" class="btn btn-success form-control" value="회원 가입"/>
				</div>
			</fieldset>
		</form>
		<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
		<script>
		$(function(){
			//우편번호 입력
			$("#postnum_form_input").on("click",function(){
				new daum.Postcode({
			        oncomplete: function(data) {
			        	$("#postnum_form_input").val(data.zonecode);
			            $("#basic_addr_form_input").val(data.roadAddress);
			            $("#addr_form_input").focus();
			        }
			    }).open();
			});
			$("#basic_addr_form_input").on("click",function(){
				$("#postnum_form_input").click();
			});
			//// 아이디 입력 중복 확인
			$("#id_form_input").on("keyup",function(){
				if ($(this).val().trim()!=""){
					$.ajax({
						url:"${pageContext.request.contextPath}/account/accountIdCheck",
						type:"get",
						dataType:"json",
						data: {"id":$(this).val().trim()} ,
						success:function(data){
							 if (data.check == "true") {
							        // 사용 가능한 ID인 경우
							        $('#id_is_dupl').text(data.msg).css('color', data.color);
							      } else {
							        // 중복된 ID인 경우
							        $('#id_is_dupl').text(data.msg).css('color', data.color);
							      }
						},
						error:function(xhr,textStatus,errorThrown){
							$("#id_is_dupl").html(xhr.status + "-"+textStatus+":"+errorThrown);
						}
					});
				}
			});
			
			////비밀번호 입력 확인
			$(".pass_form").on("keyup",function(){
				if ($("#pass_form_input").val()!="" && $("#pass_re").val()!="" ){
					//비밀번호와 비밀번호 재입력이 같지 않다면
					if($("#pass_form_input").val()!=$("#pass_re").val()){
						$("#pass_confirm").css("color","red");
						$("#pass_confirm").html(" 비밀번호를 다시 확인해주세요");
						$("#pass_confirm").attr("data-check","false");
					} else { //비밀번호 재입력과 비밀번호가 같다면
						$("#pass_confirm").css("color","green");
						$("#pass_confirm").html(" 비밀번호가 일치합니다.");
						$("#pass_confirm").attr("data-check","true");
					}
				}
			});
			
			////빈칸 체크
			$("#form").on("submit",function(){
				if ($("#id_form_input").val().trim()==""){ //아이디 빈칸 체크
					alert('아이디를 입력해주세요.');
					$("#id_form_input").focus();
					return false;
				} else if ($("#pass_form_input").val().trim()==""){ //비밀번호 빈칸 체크
					alert('비밀번호를 입력해주세요.');
					$("#pass_form_input").focus();
					return false;
				}else if ($("#pass_confirm").attr("data-check") != 'true'){ //비밀번호 확인
					alert ('비밀번호가 일치하지 않습니다.');
					$("#pass_form_input").focus();
					return false;
				} else if ($("#name_form_input").val().trim()==""){//이름 빈칸 체크
					alert('이름을 입력해주세요.');
					$("#name_form_input").focus();
					return false;
				} else if ($("#birth_form_input").val()==""){ //생일 빈칸 체크
					alert('생일을 입력해주세요.');
					$("#birth_form_input").focus();
					return false;
				}else if ($("#email_form_input").val()==""){ //이메일 빈칸 체크
					alert('이메일을 입력해주세요.');
					$("#email_form_input").focus();
					return false;
				}else if ($("#phone_form_input").val()==""){ //휴대전화 빈칸 체크
					alert('휴대전화번호를 입력해주세요.');
					$("#phone_form_input").focus();
					return false;
				}else if ($("#postnum_form_input").val()==""){ //우편번호 빈칸 체크
					alert('우편번호를 입력해주세요.');
					$("#postnum_form_input").focus();
					return false;
				}else if ($("#addr_form_input").val()==""){ //상세주소 빈칸 체크
					alert('상세주소를 입력해주세요.');
					$("#addr_form_input").focus();
					return false;
				}
			});						
		});
		</script>
	</div>
	<!-- 사용자 회원가입 폼 -->
<%@ include file="../inc/footer.jsp" %>