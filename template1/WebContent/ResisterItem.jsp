<%@include file="consumer.jsp"%>
<body>
<%@include file="header.jsp" %>
 <div id="main">
 <div id="top">
 <p>Resiter <s:property value="#session.username"/>s'Item</p>
 </div>
 <div>
 <s:form action="CertificationAction">

<ul id="form">
<li>ItemName:<input type="text" name="name"/></li>
<li>ItemPrice:<input type="text" name="price"/></li>
<li>ItemStock:<input type="text" name="stock"/></li>
<li>ItemComment:<textarea name="comment"></textarea></li>
<li><input type="submit" value="certification"/></li>
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