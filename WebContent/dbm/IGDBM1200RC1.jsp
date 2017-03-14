<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDBM1200RC1" toScope="request" />
<bean:define id="title" value="工作查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">
<html:form action="/IGDBM1200_page_Risk.do" styleId="form" onsubmit="return checkSubmit(this);">
    <div id="location" style="margin-top:10px">
        <div class="image"></div>
            <p class="fonts1">工作查询</p>
    </div>
	<div id="results_list">
	<table class="table_style">
		<tr>
				<th width="15%">检查项名称</th>
				<th width="13%">计划检查时间</th>
				<th width="13%">实际检查时间</th>
				<th width="8%">检查方式</th>
				<th width="10%">责任组</th>
				<th width="10%">责任人</th>
				<th width="10%">合作执行人</th>
				<th width="10%">处理人</th>
				<th width="10%">结果</th>
		</tr>
		<logic:present name="IGDBM12001VO" property="rcrList">
			<logic:iterate id="bean1" name="IGDBM12001VO" property="rcrList">
				<bean:define id="bean" name="bean1" property="riskCheck" ></bean:define>
				<tr style='cursor:hand'  onmouseover="mouseOver(this);" onmouseout="mouseOut(this);"
					onclick="doLook(getAppRootUrl()+'/IGRIS0201_Read.do?rcid=<bean:write name="bean" property="rcid" />&flag=1');">
					<td>${bean.rcname}</td>
					<td>${bean1.rcrplandate}</td>
					<td>${bean1.rcrrealtime}</td>
					<td>
						<c:if test="${bean.rcrtestmode==1}" >内部常规</c:if>
						<c:if test="${bean.rcrtestmode==2}" >等级保护</c:if>
						<c:if test="${bean.rcrtestmode==3}" >专项</c:if>
					</td>
					<td>${bean.rcrolename}</td>
					<td>${bean.rcusername}</td>
					<td>${bean.ciiop}</td>
					<td>${bean1.rcrusername }</td>
					<td>
						<c:if test="${bean1.rcrresult=='A'}" >正常</c:if>
						<c:if test="${bean1.rcrresult=='B'}" >存在问题</c:if>
						<c:if test="${bean1.rcrresult=='C'}" >存在重大问题</c:if>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	<div class="enter">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	</div>
	</html:form>
</div>
</div>
</body>
</html:html>
