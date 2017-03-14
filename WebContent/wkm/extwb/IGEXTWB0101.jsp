<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGEXTWB0101" toScope="request" />
<bean:define id="title" value="个人工作查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGEXTWB0101" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">流程管理 &gt;&gt; 工作管理 &gt;&gt; 个人工作查询</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div><span>编号：</span><html:text property="prserialnum"size="12" />
	<span>&nbsp;&nbsp;名称：</span><html:text property="prtitle" />
	<span>&nbsp;&nbsp;发起者：</span><html:text property="prusername" />
	</div>
	<div><span>时间：从</span><html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" /> &nbsp;&nbsp;
	<span>到</span><html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
	<span>&nbsp;&nbsp;紧急程度：</span><html:select property="prurgency">
	<ig:optionsCollection ccid="WBURGENCY_GRADE_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	</html:select>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><html:submit
		styleClass="button" value="查询" /></span></div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="5%">编号
			</th>
			<th width="30%">名称
			</th>
			<th width="10%">类型
			</th>
			<th width="10%">发起者
			</th>
			<th width="10%">发起时间
			</th>
			<th width="10%">结束时间
			</th>
			<th width="10%">状态
			</th>
			<th width="8%">紧急程度
			</th>
			<th width="7%">查看
			</th>
		</tr>
		<logic:present name="IGEXTWB01011VO" property="processList">
			<logic:iterate id="bean" name="IGEXTWB01011VO" property="processList"
				indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><bean:write name="bean" property="prserialnum" />
					</td>
					<td><bean:write name="bean"
						property="prtitle" />
					</td>
					<td>
					<bean:write name="bean" property="prpdname" />
					</td>
					<td><bean:write name="bean"
						property="prusername" />
					</td>
					<td><bean:write name="bean"
						property="propentime" />
					</td>
					<td><bean:write name="bean"
						property="prclosetime" />
					</td>
					<td>
							<ig:codeValue ccid="${bean.prtype}"
							cid="${bean.prstatus}" />
					</td>
					<td>
						<ig:codeValue ccid="WBURGENCY_GRADE_CODE"
							cid="${bean.prurgency}" />
					</td>
					<td><a
						href="IGEXTWB0103_Disp.do?prid=<bean:write name="bean" property="prid" />"><img
						src="images/look.gif" width="16" alt="查看详细信息" height="16" border="0" /></a>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>
