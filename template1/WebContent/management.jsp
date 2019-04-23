<%@include file="consumer.jsp"%>
<body>
<%@include file="header.jsp" %>
 <div id="main">
 <div id="top">
 <p>Information for <s:property value="#session.username"/></p>
 </div>
 <div>
<table>
 <s:if test="HBList.size()==0">
 <h3>No Information</h3>
 </s:if>
  <s:else>
  <h3>Information</h3>
   <s:form action="SendAction">
  <table border="1">
  <tr>
  <th>ItemName</th>
  <th>Price</th>
  <th>Quantity</th>
  <th>Payment</th>
  <th>Purchaser</th>
  <th>Status</th>
  <th>check</th>
  </tr>
  <s:iterator value="HBList" status="ex">
   <tr>
   <td><s:property value="itemName"/></td>
   <td><span></span><s:property value="itemPrice"/></td>
   <td><s:property value="count"/><span></span></td>
   <td><s:property value="pay"/></td>
   <td><s:property value="boughtbyid"/></td>
   <s:if test="done==1">
   <td>ALREADY</td>
   </s:if>
   <s:else>
   <td>YET</td>
   </s:else>
   <s:if test="done==1">
   <td></td>
   </s:if>
   <s:else>
   <td><input type="checkbox" name="index" value="<s:property value="#ex.index"/>">
  </td></s:else>
   </tr>
   </s:iterator>
   </table>
<input type="submit" value="OK"></s:form>
   </s:else>
</table>
</div>
</div>
 <div id="footer">
 <div id="pr">
 </div>
 </div>
</body>
</html>