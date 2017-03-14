<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0520" toScope="request" />
<bean:define id="title" value="部门食堂招待汇总画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间
        

	function checkSearch(){
		
		if(Number($F('month_from')) > Number($F('month_to'))){
			alert("结束月份不能大于开始月份！");
			return false;
		}else{
			document.forms[0].action = getAppRootUrl() + "/IGLOM0520.do";
			document.forms[0].submit();
		}
	}
	function exportExcel() {
		
		if(Number($F('month_from')) > Number($F('month_to'))){
			alert("结束月份不能大于开始月份！");
			return false;
		}else{
			document.forms[0].action = getAppRootUrl() + "/IGLOM0520.do?report=1";
			document.forms[0].submit();
		}
	
	}
	
	function setRoleDomain(url){
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].rapporgid.value = "";
			document.forms[0].rapporgname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].rapporgid.value = temp.split("|")[0];
			document.forms[0].rapporgname.value = temp.split("|")[1];
		}		
	
	}
	
	</script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0520"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 部门招待汇总</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">&nbsp;&nbsp;&nbsp;&nbsp;<span class="red">*</span>年度：
	<html:select property="year" name="IGLOM0520Form">
		<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false"
			isCodeLabel="true" />
	</html:select>&nbsp;&nbsp; <span>从</span> <html:select property="month_from"
		name="IGLOM0520Form">
		<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false"
			isCodeLabel="true" />
	</html:select><span>月&nbsp;&nbsp; 到</span> <html:select property="month_to"
		name="IGLOM0520Form">
		<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false"
			isCodeLabel="true" />
	</html:select> <label>月&nbsp;&nbsp;申请部门：</label> <html:text property="rapporgname"
		readonly="true"></html:text> <img src="images/tree.gif"
		style="cursor: hand;" alt="选择申请部门" width="16" height="16" border="0"
		onclick="setRoleDomain('IGSYM0101_TREE.do');" /> <html:hidden
		property="rapporgid" />&nbsp;&nbsp; <html:submit property="btn_search"
		value="查询" styleClass="button" onclick="return checkSearch();" /> <html:button
		property="btn_search" value="导出" styleClass="button"
		onclick="exportExcel();" /></div>
	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="5%"></th>
			<th width="10%">部门</th>
			<th width="12%">招待数量</th>
			<th width="10%">费用总额</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGLOM01081VO" property="eeOrgVWList">
			<logic:iterate id="bean" name="IGLOM01081VO"
				property="eeOrgVWList" indexId="index">
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');"
					onclick="doLook('IGLOM0521.do?rapporgid_org=${bean.rapporgid}&year_org=${IGLOM0520Form.year}&month_from_org=${IGLOM0520Form.month_from}&month_to_org=${IGLOM0520Form.month_to}');">

					<td>
				
					</td>
					<!-- 申请部门 -->
					<td>
					<div class="nowrapDiv">${bean.rapporgname}</div>
					</td>
					<!-- 接待工作数量 -->
					<td>
					<div class="nowrapDiv">${bean.rnum}</div>
					</td>

					<!-- 费用总额 -->
					<td>
					<div class="nowrapDiv">${bean.amount}</div>
					</td>
				</tr>
			</logic:iterate>
			<logic:iterate id="bean" name="IGLOM01081VO"
				property="eeOrgVWList" length="1">
				<tr>
					<td></td>
					<td>合计:</td>
					<td align="center">${IGLOM01081VO.sumrnum}</td>

					<td align="center">${IGLOM01081VO.sumamount}</td>
				</tr>
			</logic:iterate>	

		</logic:present>
	</table>
	</div>

</html:form></div>
</div>
<div class="zishiying"></div>

</div>

</div>
</body>
</html:html>