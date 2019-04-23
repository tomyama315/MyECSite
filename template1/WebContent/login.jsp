<%@include file="consumer.jsp"%>
<body>
	<div id="header">
		<div id="pr"></div>
	</div>
	<div id="main">
		<div id="top">
			<p>Login</p>
		</div>
		<div>
			<s:form action="LoginAction">
				<input type="text" name="loginUserId" placeholder="ID" autocomplete="off" required/><br>
				<input type="password" name="loginPassword" placeholder="PASSWORD" autocomplete="off" required/>
				<div>
				<input type="submit" value="Sign In" class="button8"/>
				</div>
			</s:form>
			<br />
			<div id="text-link">
				<p>
					SignUp: <a href='<s:url action="UserCreateAction"/>'>HERE</a>
				</p>
				<p>
					Return Home: <a href='<s:url action="GoHomeAction"/>'>HERE</a>
				</p>
			</div>
		</div>
	</div>
	<div id="footer">
		<div id="pr"></div>
	</div>

</body>
</html>