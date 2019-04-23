<%@include file="consumer.jsp"%>
</head>
<body>
<div id="header">
 <div id="pr">
 </div>
 </div>
 <div id="main">
 <div id="top">
 <p>Home</p>
 </div>
 <div id="text-center">
 <s:form action="HomeAction">
 <div><input type="submit" value="buy" class="button8"/></div>
 </s:form>
 <s:if test="#session.login_user_id != null">
  <p>Sign Out:<a href='<s:url action="LogoutAction"/>'>HERE</a></p>
  </s:if>
 </div>
 </div>
 <div id="footer">
 <div id="pr">
 </div>
 </div>
</body>
</html>