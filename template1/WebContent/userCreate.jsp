<%@include file="consumer.jsp"%>
<body>
<div id="header">
 <div id="pr">
 </div>
 </div>
 <div id="main">
 <div id="top">
 <p>UserCreate</p>
 </div>
 <div>
 <s:if test="errorMessage!=''">
  <s:property value="errorMessage" escape="false"/>
  </s:if>
  <table>
  <s:form action="UserCreateConfirmAction">
  <tr>
  <td>
  <label>LoginID:</label>
  </td>
  <td>
  <input type="text" name="loginUserId" value="" placeholder="ID" minlength="3" maxlength="16" autocomplete="off" required/>
  </td>
  </tr>
  <tr>
  <td>
  <label>LoginPASS</label>
  </td>
  <td>
  <input type="text" name="loginPassword" value="" placeholder="PASSWORD" minlength="5" maxlength="16" autocomplete="off" required/>
  </td>
  </tr>
  <tr>
  <td>
  <label>UserName</label>
  </td>
  <td>
  <input type="text" name="userName" value="" placeholder="USERNAME" minlength="3" maxlength="50" autocomplete="off" required/>
  </td>
  </tr>
  <s:submit value="SignUp"/>
 </s:form>
 </table>
 <div>
 <span>Return</span>
 <a href='<s:url action="HomeAction"/>'>here</a>
 </div>
 </div>
 </div>
<div id="footer">
<div id="pr">
</div>
</div>
</body>
</html>