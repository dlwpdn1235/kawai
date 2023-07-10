<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <!-- Theme Made By www.w3schools.com -->
  <title>Bootstrap Theme Company Page</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet" type="text/css">
  <link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet" type="text/css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
  body {
    font: 400 15px Lato, sans-serif;
    line-height: 1.8;
    color: #818181;
  }
  h2 {
    font-size: 24px;
    text-transform: uppercase;
    color: #303030;
    font-weight: 600;
    margin-bottom: 30px;
  }
  h4 {
    font-size: 19px;
    line-height: 1.375em;
    color: #303030;
    font-weight: 400;
    margin-bottom: 30px;
  }  
  .container-fluid {
    padding: 60px 50px;
  }
  .logo-small {
    color: #f4511e;
    font-size: 50px;
  }
  .logo {
    color: #f4511e;
    font-size: 200px;
  }
  .navbar {
    margin-bottom: 0;
    background-color: #A27B5C;
    z-index: 9999;
    border: 0;
    font-size: 18px !important;
    line-height: 1.42857143 !important;
    letter-spacing: 4px;
    border-radius: 0;
    font-family: Montserrat, sans-serif;
  }
  .navbar li a, .navbar .navbar-brand {
    color: #fff !important;
  }
  .navbar-brand{
  	font-size: 25px;
  }
  .navbar-nav li a:hover, .navbar-nav li.active a {
    color: #A27B5C !important;
    background-color: #fff !important;
  }
  .navbar-default .navbar-toggle {
    border-color: transparent;
    color: #fff !important;
  }
  footer .glyphicon {
    font-size: 20px;
    margin-bottom: 20px;
    color: #f4511e;
  }
  .slideanim {visibility:hidden;}
  .slide {
    animation-name: slide;
    -webkit-animation-name: slide;
    animation-duration: 1s;
    -webkit-animation-duration: 1s;
    visibility: visible;
  }
  
  img{
  	width: 50px;
  }
  
	
#gogogo{
	width:250px;
}  

/*
06-30 도연 주소검색부분
	map 수정
*/
.map_container {
    padding-top: 75px;
}
dt.dt_find_search {
    display: flex;
    flex-direction: row-reverse;
}
.address_search {
  display: inline-block;
  color: gray;
}
#search_button {
  float: right;
}
#sample6_postcode { 
  width: 150px;
  margin-bottom: 12px;
  padding: 0.5em;
  background-color: transparent;
  border: 1px solid #666;
  box-sizing: border-box;
}
#sample6_address {
  width: 450px;
  margin-bottom: 12px;
  padding: 0.5em;
  background-color: transparent;
  border: 1px solid #666;
  box-sizing: border-box;
}
#sample6_detailAddress {
  width: 300px;
  margin-bottom: 12px;
  padding: 0.5em;
  background-color: transparent;
  border: 1px solid #666;
  box-sizing: border-box;
}
/*
수정완
*/

#marketCheck{
margin-left:700px;
}


#marketLikeCheck + label {
  display: inline-block;
  width: 40px;
  height: 40px;
  background-image: url('../img/marketLikeCheck.png');
  background-size: cover;
}

#market-paying{
font-size:14px;
font-weight:bold;
text-align:center;
margin-right:20px;
}

#marketPayNameUpdate{
float:right;
}

#marketThOption{
font-wieght:bold;
padding:15px;
border:solid 0.5px;
}

#marketTdOption{
border-bottom-style: solid;
border-top-style:solid;
width:1000px;
}

#marketShop{
	float:right;
	margin-right:60px;
}

.marketWriting{
float:right;
margin-right:30px;
}

.marketUserUpdateSubmit{
float:right;
}

.marketUserUpdateCon{
margin-bottom:30px;
}

.marketUserUpdate-group{
padding:25px;

}

.marketUpdateSubmit{
float:right;
}

.marketUpdateCon{
margin-bottom:30px;
}

.marketUpdate-group{
padding:25px;

}

.marketWriteSubmit{
float:right;
}

.marketWriteCon{
margin-bottom:30px;
}

.marketWrite-group{
padding:25px;

}

.marketProductWrite{
margin-left:200px;
}

.marketProductTable{
border-style:none;
}

.marketOrderCommit{
margin-top:30px;
text-align:center;
}

.marketOderOkLine{
margin-top:50px;
margin-bottom:50px;
}

.marketProductPaying{
text-align:center;
margin-top:50px;
}

.marketProductSumPrice{
font-weight: bold;
margin-top:30px;
text-align:center;
margin-right:30px;
}

.marketProduct-group{
border:solid 1px;
border-radius: 1px;

}

.marketProductReceive{
font-weight:bold;
font-size:22px;
text-align:center;
}

.borderLine{
border:solid 4px;
margin-bottom:15px;
}

.marketProductCheck{
float:left;
}


.marketCheck{
float:right;
margin-right:360px;
}

.marketBuy{
text-align:center;
}

.market-search-group{
text-align:center;
}

.marketDelete{
float:right;
margin-right:300px;
}

.tmpt{
  margin-top: 50px;
  padding: 20px;
}


 </style>


</head>
<body id="myPage" data-spy="scroll" data-target=".navbar" data-offset="60">

<nav class="navbar navbar-default navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href="${pageContext.request.contextPath}/main/view">동네글방</a>
    </div>
    
	    <ul class="nav navbar-nav">
	      <li><a href="#">지도</a></li>
	      <li><a href="${pageContext.request.contextPath}/community/commView">커뮤니티</a></li>
	      <li><a href="${pageContext.request.contextPath}/market/marketview">마켓</a></li>
	    </ul>
	    
	    <ul class="nav navbar-nav navbar-right">
	      <li><a href="${pageContext.request.contextPath}/account/singUp"><span class="glyphicon glyphicon-user"></span> 회원가입</a></li>
	      <li><a href="${pageContext.request.contextPath}/account/login"><span class="glyphicon glyphicon-log-in"></span> 로그인</a></li>
	    </ul>
  </div>
</nav>
