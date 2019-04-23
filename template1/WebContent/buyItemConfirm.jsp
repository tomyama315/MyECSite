<%@include file="consumer.jsp"%>
<script type="text/javascript">
 function submitAction(url){
	 $('form').attr('action',url);
	 $('form').submit();
 }
 </script>
</head>
<body>
<div id="modal-content">
	<p>「閉じる」か「背景」をクリックするとモーダルウィンドウを終了します。</p>
	<p><a id="modal-close" class="button-link">閉じる</a></p>
</div>
<div id="header">
  <ul>
 <li><a href='<s:url action="MyPageAction"/>'>MyPage</a></li>
 <li><a href='<s:url action="LoginAction"/>'>Items</a></li>
 <li><a href='<s:url action="LogoutAction"/>'>Sign Out</a></li>
 </ul>
 </div>
 <div id="main">
 <div id="top">
 <p>BuyItem</p>
 </div>
 <div>
 <s:form>
  <tr>
 <td>商品名</td>
 <td><s:property value="session.buyItem_name"/></td>
 </tr>
 <tr>
 <td>値段</td>
 <td>
 <s:property value="session.total_price"/>
 <span>円</span>
 </td>
 </tr>
 <tr>
 <td>購入個数</td>
 <td>
 <s:property value="session.count"/>
 <span>個</span>
 </td>
 </tr>
 <tr>
 <td>支払い方法</td>
 <td><s:property value="session.pay"/></td>
 </tr>
 <tr>
 <td><br></td>
 </tr>
 <tr>
 <td><input type="button" value="戻る" onclick="submitAction('HomeAction')"/></td>
 <td><input type="button" value="完了" onclick="submitAction('BuyItemConfirmAction')"/></td>
 </tr>

 </s:form>
  <p>前画面に戻る場合は<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
   <p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
 </div>
 </div>
 <div id="footer">
 <a>ecsite</a>
 </div>
</body>
</html>