<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>报表预览</title>
</head>
<%
String filename = (String)request.getAttribute("filename");
%>
<body>
<ig:message/>
<object classid="clsid:CA8A9780-280D-11CF-A24D-444553540000" width="100%" height="100%" border="0"><!--IE--> 
      <param name="_Version" value="65539">
      <param name="_ExtentX" value="20108">
      <param name="_ExtentY" value="10866">
      <param name="_StockProps" value="0">
      <param name="SRC" value='${filename}' >
<embed src='${filename}'  width="100%"  height="800" ></embed><!--FF-->
</object>

</body>
</html>