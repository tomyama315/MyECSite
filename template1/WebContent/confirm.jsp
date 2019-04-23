<%@include file="consumer.jsp"%>
<style>
.a{
text-align:center;
}
#modal-content{
position:absolute;
top:40%;
left:23%;
	width:50%;
	margin:1.5em auto 0;
	padding:10px 20px;
	border:2px solid #aaa;
	background:#fff;
	z-index:10;
	text-align:center;
}

.modal-p{
	margin-top:1em;
	text-align:center;
}

.modal-p:first-child{
	margin-top:0;
	text-align:center;
}
.button{
padding-right:45%;
}
</style>

</head>
<body>
<s:if test="#session.Error!=null">
<div id="modal-content">
    <p>SORRY</p>
	<p><s:property value="#session.Erroritemname"/>:NOT ENOUGH STOCK</p>
	<s:form action="ConfirmErrorReturnAction">
	<div class="button"><s:submit type="button" value="close"/></div>
	</s:form>
</div>
</s:if>
<div id="header">
 <div id="pr">
 </div>
 </div>
 <div id="main">
 <div id="top">
 <p>Information</p>
 </div>
 <div>

<s:iterator value="list">
  <table class="T">
  <tr>
  <td>
  <span>Name</span>
  </td>
  <td>
  <s:property value="itemName"/>
  </td>
  </tr>
  <tr>
  <td>
  <span>Price</span>
  </td>
  <td>
  <s:property value="itemPrice"/>
  <span>YEN</span>

  </td>
  </tr>
  <tr>
  <td>
  <span>Quantity</span>
  </td>
  <td>
  <s:property value="count"/>
  </td>
  </tr>
    </table>
    </s:iterator>
    <s:form action="BuyItemConfirmAction">
    <tr class="underinform">
    <td>
     <h3 class="underinform"> Sum:<s:property value="#session.totalprice"/>YEN<br></h3>
      </td>
      </tr>
     <tr>
    <td>
    <span>PAYMENT</span>
    </td>
    <td>
    <input type="radio" name="pay" value="1" checked="checked">CASH
    <input type="radio" name="pay" value="2">CREDIT CARD
    </td>
    </tr>
    <s:if test="#session.Error==null">
    <s:submit value="Buy"/>
    </s:if>
    </s:form>

 <div class="underinform">
 <p><a href='<s:url action="GoCartAction"/>'>return</a></p>
    <p><a href='<s:url action="MyPageAction"/>'>MYPAGE</a></p>
    </div>
    </div>
    </div>
 <div id="footer">
 <div id="pr">
 </div>
 </div>
</body>
</html>