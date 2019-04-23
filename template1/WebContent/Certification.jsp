<%@include file="consumer.jsp"%>
<body>
<%@include file="header.jsp" %>
 <div id="main">
 <div id="top">
 <p>Resiter <s:property value="#session.username"/>s'Item</p>
 </div>
 <div>
 <s:form action="ResisterItemAction">
<ul id="form">
<li>ItemName:<s:property value="name"/></li>
<li>ItemPrice:<s:property value="price"/></li>
<li>ItemStock:<s:property value="stock"/></li>
<li>ItemComment:<s:property value="comment"/></li>
<li><input type="submit" value="Resister"/></li>
</ul>

</s:form>
</div>
</div>
 <div id="footer">
 <div id="pr">
 </div>
 </div>

</body>
</html>