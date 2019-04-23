<%@include file="consumer.jsp"%>
<body>
<%@include file="header.jsp" %>
 <div id="main">
 <div id="top">
<p>Confirmation</p>
 </div>
 <div>
 <s:form action="ResisterItemAction">
  <table border="1">
  <tr>
  <th>ItemName</th>
  <th><s:property value="itemname"/></th>
  </tr>
  <tr>
  <th>Price</th>
  <th><s:property value="price"/></th>
  </tr>
  <tr>
  <th>Stock</th>
  <th><s:property value="stock"/></th>
  </tr>
  <tr>
  <th>Comment</th>
  <th><s:property value="comment"/></th>
  </tr>
  <tr>
  <th>Item image</th>
  <th><img src="<s:property value="imagename"/>" width="500px" height="300px"/></th>
  </tr>
   </table>
   <input type="submit" value="CONFIRM"/>
   </s:form>
</div>
</div>
 <div id="footer">
 <div id="pr">
 </div>
 </div>
</body>
</html>