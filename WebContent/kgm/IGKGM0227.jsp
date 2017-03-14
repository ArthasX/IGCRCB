<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>

<bean:define id="id" value="IGKGM0227" toScope="request" />
<bean:define id="title" value="知识打印页" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<style media=print>
.Noprint{
	display:none;
}
</style>
<style>
.prings{
	font-size: 15px;
	font-family: "幼圆" 
    text-align:left;
    table-layout:fixed;
}
.prings td{
    word-break: break-all; 
    word-wrap:break-word;    
}
</style>
<body>
<div align="center">
<span style="font-size: 17px"><strong>知识信息</strong></span>

<table border="2" width="100%" border="1" cellpadding="0" cellspacing="0" bordercolor="#000000" class="prings">
	<logic:present name="IGKGM02051VO" property="knowledge">
	<bean:define id="knowledge" name="IGKGM02051VO" property="knowledge" />
	<tr height="38">
	    <td align="left" width="20%">标题： </td>
		<td align="left" width="80%" colspan="5">&nbsp;<bean:write name="knowledge" property="kntitle" /></td>
	</tr>
	<tr height="38">
	    <td align="left" width="20%">分类： </td>
		<td align="left" width="30%" colspan="2">&nbsp;<bean:write name="knowledge" property="knclassname" /></td>
		<td align="left" width="20%">关键字：  </td>
		<td align="left" width="30%" colspan="2">&nbsp;<bean:write name="knowledge" property="knkey" /></td>
	</tr>
	<tr height="38">
	    <td align="left" width="20%">归档人： </td>
		<td align="left" width="30%" colspan="2">&nbsp;${knowledge.user.username}</td>
		<td align="left" width="20%">归档时间：  </td>
		<td align="left" width="30%" colspan="2">&nbsp;<bean:write name="knowledge" property="knapprovetime"/></td>
	</tr>
	<tr height="38">
	    <td align="left" width="20%">来源： </td>
		<td align="left" width="30%" colspan="2">&nbsp;${knowledge.knoriginname}</td>
		<td align="left" width="20%">知识贡献人：  </td>
		<td align="left" width="30%" colspan="2">&nbsp;<bean:write name="knowledge" property="knproffername"/></td>
	</tr>
	<tr height="38">
	    <td align="left" width="20%">贡献时间： </td>
		<td align="left" width="30%" colspan="2">&nbsp;<bean:write name="knowledge" property="knproffertime" /></td>
		<td align="left" width="20%">部门：  </td>
		<td align="left" width="30%" colspan="2">&nbsp;<bean:write name="knowledge" property="kndepartment"/></td>
	</tr>
	<tr height="38">
	    <td align="left" width="20%">技术领域： </td>
		<td align="left" width="30%" colspan="2">&nbsp;<bean:write name="knowledge" property="kntelareaname"/></td>
		<td align="left" width="50%" colspan="3">&nbsp;</td>
	</tr>
	<tr height="38">
	    <td align="left">业务系统： </td>
		<td align="left" colspan="5">&nbsp;
			<logic:present name="IGKGM02051VO" property="knowledgeAppImpactList">
				<logic:iterate id="bean" name="IGKGM02051VO" property="knowledgeAppImpactList">
					<ig:codeValue ccid="BUSINESS_SYSTEM_CODE" cid="${bean.kaicode}" />
				</logic:iterate>
			</logic:present>
		</td>
	</tr>
	<tr height="85">
		<td align="left">问题描述： </td>
		<td align="left" colspan="5">&nbsp;<pre><bean:write name="knowledge" property="knfaultcause" /></pre></td>
	</tr>
	<tr height="85">
		<td align="left">解决办法：</td>
		<td align="left" colspan="5">&nbsp;<pre><bean:write name="knowledge" property="knsolveway" /></pre></td>
	</tr>
	<tr height="85">
		<td align="left">知识描述：</td>
		<td align="left" colspan="5">&nbsp;<pre><bean:write name="knowledge" property="kndes" /></pre></td>
	</tr>
	</logic:present>
</table>
<OBJECT classid=CLSID:8856F961-340A-11D0-A96B-00C04FD705A2 height=0 id=WebBrowser width=0></OBJECT>
<br /><br />
<input type="button" class="Noprint" value="打印预览" style="
	color:#FFFFFF;
	padding:1px 10px;
	font-size:12px;
	border:2px outset #EEEEEE;
	background-color: #6699CC;
	cursor: hand;
	height:20px;" onClick=document.all.WebBrowser.ExecWB(7,1) >
<input type="button" class="Noprint" value="  打印  " style="
	color:#FFFFFF;
	padding:1px 10px;
	font-size:12px;
	border:2px outset #EEEEEE;
	background-color: #6699CC;
	cursor: hand;
	height:20px;" onClick=document.all.WebBrowser.ExecWB(6,1)>

</div>
</body>
</html:html>
