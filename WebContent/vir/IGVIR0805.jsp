<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGVIR0805" toScope="request" />
<bean:define id="title" value="项目资源 " toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function particulars(pid){
	//alert(pid);
	location.href = "IGVIR0802.do?showType=ctrl&searchType=proj&pid_eq="+pid;
}
</script><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGVIR0805_SEARCH"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>

	<span>项目名称：</span><span><html:text
		property="pname_like" styleId="username_q"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" name="IGVIR0805Form"/>
	</span>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
		<ig:message />
		<table class="table_style">
			<logic:present name="IGVIR08051VO" property="vim03pList">
				<tr>
					<th width="10%">序号</th>
					<th width="60%">项目名称</th>
					<th width="40%">虚机数量</th>
				</tr>
				<logic:iterate id="bean" name="IGVIR08051VO"
					property="vim03pList" indexId="index">
					<tr style='cursor:hand' onmouseover="mouseOver(this);" onmouseout="mouseOut(this);"
					onclick="particulars('${bean.pid}');">
						<td>${index+1}</td>
						<td>${bean.pname}</td>
						<td>${bean.count}</td>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
	</div>
	<div id="operate">
	<!-- paging -->
	<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>