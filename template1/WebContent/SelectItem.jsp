<%@include file="consumer.jsp"%>
<style>
.test {
	border: 2px solid blue;
	min-height: 150px;
	width: 1400px;
	font-size: 15px;
	float: left;
	margin-left: 50px;
	margin-bottom:10px;
}

.test td {
	border-radius: 0px;
	border: 1px solid blue;
	background: linear-gradient(180deg, skyblue, lightblue, skyblue);
}

.in {
	color: blue;
	margin: 0 auto;
	width: 100%;
	margin-bottom: 50px;
}
.cm{
text-align:left;
}
</style>
<body>
	<%@include file="header.jsp"%>
	<div id="main">
		<div id="top">
			<p>
				List in which
				<s:property value="#session.username" />
				ve'resisterd Items.
			</p>
		</div>
		<div>
			<s:form action="DeleteItemsByAutholizerAction" theme="simple">
				<div class="in">
					<input type="submit" value="DELETE FROM THIS SITE" class="button8" />
				</div>
				<s:iterator value="list">
					<table border="1" class="test" ~~~ style="table-layout:fixed;width:1410px;">
						<tr>
							<td>ID <input type="checkbox" name="index"
								value=<s:property value="SHAREID"/>></td>
							<td><s:property value="SHAREID" /></td>
							<td>NAME</td>
							<td><s:property value="SHARENAME" /></td>
						</tr>
						<tr>
							<td>PRICE</td>
							<td><s:property value="ITEMPRICE" /></td>
							<td>STOCK</td>
							<td><s:property value="ITEMSTOCK" /></td>
						</tr>
						<tr>
							<td>INSERTDATE</td>
							<td><s:property value="SHAREINSERTDAY" /></td>

							<td>UPDATEDATE</td>
							<td><s:property value="SHAREUPDATEDAY" /></td>
						</tr>
						<tr>
							<td rowspan="2">COMMENT</td>
							<td ~~~ style="word-wrap:break-word;" rowspan="2" colspan="3" height="80px" class="cm"><s:property value="ITEMCOMMENT" /></td>
						</tr>
					</table>
				</s:iterator>
			</s:form>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>

</body>
</html>