<%@include file="consumer.jsp"%>
<body>
<div id="header">
 <div id="pr">
 </div>
 </div>
 <div id="main">
 <div id="top">
 <p>UserCreateConfirm</p>
 </div>
 <div>
  <h3>Please check below</h3>
  <table>
  <s:form action="UserCreateCompleteAction">
  <tr id="box">
  <td>
  <label>LoginID:</label>
  </td>
  <td>
  <s:property value="loginUserId" escape="false"/>
  </td>
  </tr>
  <tr id="box">
  <td>
  <label>LoginPASS:</label>
  </td>
  <td>
  <s:property value="loginPassword" escape="false"/>
  </td>
  </tr>
  <tr id="box">
   <td>
   <label>UserName:</label>
   </td>
   <td>
   <s:property value="userName" escape="false"/>
   </td>
   </tr>
   <tr>
   <td>
   <s:submit value="Complete"/>
   </td>
   </tr>
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
