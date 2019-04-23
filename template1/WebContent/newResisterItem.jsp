<%@include file="consumer.jsp"%>
<style>
li{
margin-bottom:20px;
}</style>
<body>
<%@include file="header.jsp" %>
 <div id="main">
 <div id="top">
 <p>Resiter <s:property value="#session.username"/>s'Item</p>
 </div>
 <div>
 <s:form action="doUpload" method="post" enctype="multipart/form-data">
<ul id="form">
<li><input type="text" name="itemname" placeholder="ItemName" minlength="5" maxlength="30" autocomplete="off" required/></li>
<li><input type="number" name="price" placeholder="ItemPrice" maxlength="7" autocomplete="off" step="10" min="10" required/></li>
<li><input type="number" name="stock" placeholder="ItemStock" maxlength="4" autocomplete="off" min="1" required/></li>
<li><textarea name="comment"rows="10" cols="50" placeholder="ItemComment" autocomplete="off" maxlength="255"></textarea></li>
<li>Image:<s:file name="upload" label="File" theme="simple"/></li>
<li><s:submit value="ToCon" theme="simple" class="button8"/></li>
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