<%@include file="consumer.jsp"%>
<style>
.T{
background-color:lightblue;
}
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
 <s:if test="#session.Key==null">
 <p>All Items</p>
 </s:if>
 <s:else>
 <p>To <a href='<s:url action="LoginAction"/>'>All Items</a></p>
 <p>Items of name contains <s:property value="#session.Key"/></p>
 </s:else>
 <s:form action="ItemSearchAction">
 <p>Search:<input type="text" name="Key" class="text"><input type="submit" value="Search" class="button8"/></p>
 </s:form>
 </div>



 <s:iterator value="BIList">
 <s:form action="ShowDetailAction" theme="simple">
 <input type="hidden" name="id" value="<s:property value="id"/>"/>
  <table class="T">
<tr><td width="300px"><img src="<s:property value="imagename"/>" width="300px" height="250px"/></td>
<td><table class="t" border="1">

<tr><td>Name:<s:property value="itemName" /></td></tr>
<tr><td>Price:<s:property value="itemPrice"/></td></tr>
<s:if test="itemstock==0"><tr><td>SOLDOUT</td></tr></s:if>
<s:else><tr><td>Stock:<s:property value="itemstock"/></td></tr></s:else>

<%-- <s:if test="itemstock==0"><tr><td></td></tr></s:if> --%>
<%-- <s:else><tr><td>Quantity:<select name="count" class="quantity"> --%>
<!--    <option value="1" selected="selected">1</option> -->
<!--     <option value="2">2</option> -->
<!--     <option value="3">3</option> -->
<!--     <option value="4">4</option> -->
<!--     <option value="5">5</option> -->
<!--     </select></td></tr> -->
<%--     </s:else> --%>

    <s:if test="itemstock==0"><tr><td><input type="submit" value="details" class="button8"/></td></tr>
  </s:if>
  <s:else>
<tr><td><input type="submit" value="details" class="button8"/></td></tr>
  </s:else>

  </table>
  </td>
  </tr>
    </table>
    </s:form>
    </s:iterator>
    </div>

     <div class="underinform">
    <p>前画面に戻るには<a href='<s:url action="GoHomeAction"/>'>こちら</a></p>
    <p>マイページは<a href='<s:url action="MyPageAction"/>'>こちら</a></p>
    </div>
 <div id="footer">
 <a>ecsite</a>
 </div>

</body>
</html>