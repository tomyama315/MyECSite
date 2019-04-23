<%@include file="consumer.jsp"%>
<style>
h1{
border-bottom:5px dotted blue
}
img{
float:left;
border:5px outset;
margin-left:20px;
}
.ida td{
color:black;
font-size:30px;
margin-bottom:40px;
border-radius:0px;
border:3px outset ;
max-width:400px;
margin:0 auto;
}
.button8{
float:left;
margin:0 auto;
text-align:center;
}
th{
margin:0 auto;
text-align:center;
backgroud-color:black;
}
.abovef{
margin-left:350px;
}
h2{
margin-left:-50px;}
</style>
<body>
<div id="header">
 <ul>
 <li><a href='<s:url action="MyPageAction"/>'>MyPage</a></li>
 <li><a href='<s:url action="LoginAction"/>'>Items</a></li>
 <li><a href='<s:url action="LogoutAction"/>'>Sign Out</a></li>
 </ul>
 </div>
 <div id="main">
 <div id="top">
 </div>
 <h1><s:property value="#session.adcdto.itemName"/></h1>

 <div><img src="<s:property value="#session.adcdto.imagename"/>" width="500px" height="500px"/>
 </div>
 <table border="1" class="ida">
 <tr><td>Name</td><td><s:property value="#session.adcdto.itemName"/></td></tr>
 <tr><td>Price</td><td><s:property value="#session.adcdto.itemPrice"/> YEN</td></tr>
 <tr><td>Stock</td><td><s:property value="#session.adcdto.itemStock"/></td></tr>
 <tr><td>Exhibiter</td><td><s:property value="#session.adcdto.insertbyid"/></td></tr>
 </table>
 <table border="1" class="ida">
  <tr><td>Comment by Ex</td></tr>
  <tr><td ~~~ style="word-wrap:break-word;" colspan="5" height="300px"><s:property value="#session.adcdto.comment"/></td></tr>
  </table>

  <s:form action="CartrAddAction" theme="simple">
<table class="abovef">
<tr>
  <s:if test="#session.adcdto.itemStock==0"><td><h2>SOLD</s:if>
<s:else><td>QUANTITY<select name="count" class="quantity">
   <option value="1" selected="selected">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
    </select></td>
    </s:else>
    <s:if test="#session.adcdto.itemStock==0">OUT</h2></td></s:if>
    <s:else><td><input type="submit" value="Add to cart" class="button8"/></td></s:else>
    </tr>
  </table>
  </s:form>
 </div>
 <div id="footer">
 <a>ecsite</a>
 </div>

 </body>