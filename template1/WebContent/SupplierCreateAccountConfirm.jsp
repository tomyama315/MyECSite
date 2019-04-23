<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirm Step</title>
</head>
<body>
<h3>Confirmation</h3>
<s:form action="SupplierCreateAccountCompleteAction" method="execute">
Name:<s:property value="Name" escape="false"/><br>
Pass:<s:property value="Password" escape="false"/><br>
--Press "Complete button" if all elements are CORRECT.--
 <s:submit value="Complete"/>
 </s:form>
</body>
</html>