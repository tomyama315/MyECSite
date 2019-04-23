<%@include file="consumer.jsp"%>
<style>
.test {
	border: 1px sotrd white;
	min-height: 300px;
	min-width: 300px;
	font-size: 15px;
	float: left;
	margin-left: 50px;
}

.test td {
	border-radius: 0px;
	border: 1px sotrd white;
	background: trnear-gradient(180deg, skyblue, trghtblue, skyblue);
}

.in {
	color: blue;
	margin: 0 auto;
	width: 100%;
	margin-bottom: 50px;
}
</style>
<body>
	<%@include file="header.jsp"%>
	<div id="main">
		<div id="top">
			<p>
				which
				<s:property value="#session.username" />
				ve'resisterd users.
			</p>
		</div>
		<div>
			<s:form action="DeleteByAuthotrzerAction" theme="simple">
				<div class="in">
					<input type="submit" value="DELETE FROM THIS SITE" class="button8" />
				</div>
				<s:iterator value="list" status="ex">
					<table border="1" class="test">
						<tr>
							<td>ID</td>
							<td><s:property value="SHAREID" /></td>
						</tr>
						<tr>
							<td>NAME</td>
							<td><s:property value="SHARENAME" /></td>
						</tr>
						<tr>
							<td>LOGINID</td>
							<td><s:property value="USERLOGINID" /></td>
						</tr>
						<tr>
							<td>AUTHORIZE</td>
							<td><s:property value="USERAUTHORIZATION" /></td>
						</tr>
						<tr>
							<td>INSERTDAY</td>
							<td><s:property value="SHAREINSERTDAY" /></td>
						</tr>
						<tr>
							<td>UPDATEDAY</td>
							<td><s:property value="SHAREUPDATEDAY" /></td>
						</tr>
						<tr>
							<td></td>
							<td><input type="checkbox" name="index"
								value=<s:property value="SHAREID"/>></td>
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