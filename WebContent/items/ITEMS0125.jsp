<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="ITEMS0125" toScope="request" />
<bean:define id="title" value="申领状态调整" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">

</script>
<!-- /header1 -->
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="results_list">
<table class="table_style">
	<tr>
		<th width="50%">当前状态</th>
		<th width="50%">操作</th>
	</tr>

	<tr>
		<td>
			<logic:equal name="requestStatus" value="0">
				不可申领
			</logic:equal>
			<logic:equal name="requestStatus" value="1">
				可申领
			</logic:equal>
		</td>
		<td>
			<logic:equal name="requestStatus" value="0">
				<a href="ITEMS0125.do?requestStatus=${requestStatus}"><img src="images/start.gif" width="16" height="16" border="0" alt="启用"/></a>
			</logic:equal>
			<logic:equal name="requestStatus" value="1">
				
				<a href="ITEMS0125.do?requestStatus=${requestStatus}"><img src="images/stop.gif" width="16" height="16" border="0" alt="关闭"/></a>
			</logic:equal>
		</td>
	</tr>

</table>
</div>


</div>
</div>
</div>
</div>
</body>
</html:html>