<%@include file="consumer.jsp"%>
</head>
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
 <p>Cart</p>
 </div>
 <div>

<s:iterator value="list" status="ex">
<s:form action="CartDeleteAction">
<input type="hidden" name="index" value="<s:property value="#ex.index"/>"/>
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
  <s:submit value="delete" class="button8"/>
    </table>
    </s:form>
    </s:iterator>
    <div class="underinform">
    <s:form action="ConfirmAction">
    <s:submit value="certification" theme="simple" class="button8"/>
    </s:form>


 <div class="underinform">
 <p><a href='<s:url action="HomeAction"/>'>SHOPPING</a></p>
    </div>
    </div>
    </div>
    </div>
 <div id="footer">
 <div id="pr">
 </div>
 </div>

</body>
</html>