<%@include file="toendofheadsupplier.jsp"%>
<body>
<%@include file="header.jsp" %>
 <div id="main">
 <div id="top">
 <p><s:property value="#session.username"/>s'request was not accepted</p>
 </div>
 <div>
<ul id="form">
<li>ItemName:<s:property value="#session.name"/></li>
<li>ItemPrice:<s:property value="#session.price"/></li>
<li>ItemStock:<s:property value="#session.stock"/></li>
<li>ItemComment:<s:property value="#session.comment"/></li>
</ul>
</div>
</div>
 <div id="footer">
 <div id="pr">
 </div>
 </div>

</body>
</html>