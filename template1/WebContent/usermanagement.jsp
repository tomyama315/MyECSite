<%@include file="consumer.jsp"%>
<body>
<%@include file="header.jsp" %>
 <div id="main">
 <div id="top">
 <p>Create and autholized users</p>
 </div>
 <div>
<table>
<s:form action="UserCreateConfirmAction">

<ul id="form">
<li><input type="text" name="loginUserId" value="" placeholder="ID" minlength="3" maxlength="16" autocomplete="off" required/></li>
<li><input type="password" name="loginPassword" value="" placeholder="PASSWORD" minlength="5" maxlength="16" autocomplete="off" required/></li>
<li><input type="text" name="userName" value=""placeholder="USERNAME" minlength="3" maxlength="50" autocomplete="off" required/></li>
<li>Autholization:<input type="checkbox" name="aut" value="1"></li>
<li><input type="submit" value="certification"/></li>
</ul>

</s:form>
</table>
</div>
</div>
 <div id="footer">
 <div id="pr">
 </div>
 </div>
</body>
</html>