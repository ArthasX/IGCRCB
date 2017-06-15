<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.LOMHelper" %>
<%@ page import="java.math.BigDecimal" %>
<html:html>
<bean:define id="id" value="IGLOM0580" toScope="request" />
<bean:define id="title" value="食堂招待管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script>

//删除所选
function deleteRec(obj){
	var message = '<bean:message key="IGCO10000.E002"/>';
    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="食堂招待信息" />';
    if(window.confirm(confirmMsg)){
        form.action = getAppRootUrl() + "/IGLOM0580_Del.do";
        return true;
    } else {
        return false;
    }
}
function checkSearch(){
	if(!checkDateByContent("eetime_from","eetime_to")){
		alert("开始日期不能晚于结束日期！");
		return false;
	}else{
		return true;
	}

}
function checkNum(obj){
	if(isNaN(obj.value)){
		alert("请输入数字！");
		obj.value = "";
		return;
	}
}

</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGLOM0580" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 接待工作管理 &gt;&gt; 食堂招待管理</p>
	<div class="back"><a href="IGLOM0103_Back.do" target="_self">返回</a></div> 
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	
	<div>
	<span>时间：从</span><span><html:text
		property="eetime_from" styleId="eetime_from"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('eetime_from'))" border="0" style="cursor: hand" />
	</span>
	<span>&nbsp;&nbsp;到</span><span><html:text
		property="eetime_to" styleId="eetime_to"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('eetime_to'))" border="0" style="cursor: hand" /></span>
	<span> <html:submit
		styleClass="button" value="查询" onclick="return checkSearch();"/></span></div>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<logic:notEqual name="IGLOM0507Form" property="rstatus" value="2">
			<th width="5%"></th>
			</logic:notEqual>
			<th width="5%">日期</th>
			<th width="10%">招待活动</th>
			<th width="5%">主陪人</th>
			<th width="5%">每桌菜价格</th>
			<th width="5%">桌数</th>
			<th width="5%">酒价</th>
			<th width="5%">烟价</th>
			<th width="5%">其他用品价格</th>
		    <th width="5%">费用合计</th>
			<logic:notEqual name="IGLOM0507Form" property="rstatus" value="2">
			<th width="6%">修改</th>
			</logic:notEqual>
		</tr>
		<logic:present name="IGLOM05071VO" property="eentertainmentList">
			<logic:iterate id="bean" name="IGLOM05071VO" property="eentertainmentList"
				indexId="index">
				<bean:define id="tableprice" name="bean" property="eetableprice" ></bean:define>
				<bean:define id="tablenum"  name="bean" property="eetablenum"></bean:define>
				<bean:define id="drinkprice"  name="bean" property="eedrinkprice"></bean:define>
				<bean:define id="smokeprice"  name="bean" property="eesmokeprice"></bean:define>
				<bean:define id="otherprice"  name="bean" property="eeotherprice"></bean:define>
				<tr>
					<logic:notEqual name="IGLOM0507Form" property="rstatus" value="2">
					<td><label><html:checkbox
							property="deleteEeid" value="${bean.eeid}" /></label>
					</td>
					</logic:notEqual>
					<td><bean:write name="bean" property="eedate" /></td>
					<td>${bean.recptionTB.rname}</td>
					<td><bean:write name="bean" property="eeuser" /></td>
					<td><bean:write name="bean" property="eetableprice" /></td>
					<td><bean:write name="bean" property="eetablenum" /></td>
					<td><bean:write name="bean" property="eedrinkprice" /></td>
					<td><bean:write name="bean" property="eesmokeprice" /></td>
					<td><bean:write name="bean" property="eeotherprice" /></td>
					<td><% BigDecimal table =LOMHelper.getMultiply(String.valueOf(tableprice),String.valueOf(tablenum));
					       BigDecimal other = LOMHelper.getAdd(String.valueOf(
				    		                  LOMHelper.getAdd(String.valueOf(drinkprice),String.valueOf(smokeprice))),
				    		                                   String.valueOf(otherprice)); %>
					    <%=LOMHelper.getAdd(table,other)%>
					 </td>
					<logic:notEqual name="IGLOM0507Form" property="rstatus" value="2">
					<td>							
							<html:link action="/IGLOM0580_Edit_Disp.do?eeid=${bean.eeid}">
								<img src="images/edit.gif" width="16" height="16" border="0"/>
							</html:link>			
					</td>
					</logic:notEqual>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:notEqual name="IGLOM0507Form" property="rstatus" value="2">
    	<input type="button" class="button" value="增加"  onclick="window.location='IGLOM0583_Disp.do?rid=${IGLOM0507Form.rid_mon}';" />
		<logic:present name="IGLOM05071VO"
			property="eentertainmentList">
			<span> <html:submit property="btn_delete" value="删除所选"
				styleClass="button" onclick="return deleteRec('deleteEeid');" /></span>
		</logic:present>
    </logic:notEqual>	
	<jsp:include page="/include/paging.jsp" />
	</div>
	<html:hidden property="rid_mon" styleId="rid_mon" name="IGLOM0507Form"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>
