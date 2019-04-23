<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thank you for joining us!</title>
</head>
<body>
<s:form>
[<s:property value="#session.Name" escape="false"/>] Than,brk you for joining us!<br>
Your ID :<s:property value="#session.Id" escape="false"/><br>
Please DO NOT FORGET this ID becouse it's nesessary for sign up.<br><br>

<a href="ForSupplier.jsp">Login page is here</a>
</s:form>
</body>
</html>