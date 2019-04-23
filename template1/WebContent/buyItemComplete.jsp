<%@include file="consumer.jsp"%>
</head>
<body>
<div id="header">
<ul>
 <li><a href='<s:url action="MyPageAction"/>'>MyPage</a></li>
 <li><a href='<s:url action="LoginAction"/>'>Items</a></li>
 <li><a href='<s:url action="LogoutAction"/>'>Sign Out</a></li>
 </ul></div>
<div id="main">
 <div id="top">
  <p>BuyItemComplete</p>
  </div>
  <div>
  <p>Completed!</p>
  <div>
   <a href='<s:url action="MyPageAction"/>'>
   From MYPAGE</a><span> you can see your parchase history.</span>
   <p><a href='<s:url action="GoHomeAction"/>'>HOME</a></p>
   </div>
   </div>
   </div>
   <div id="footer">
    <div id="pr">
    </div>
    </div>
</body>
</html>