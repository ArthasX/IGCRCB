<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0581" toScope="request" />
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
        form.action = getAppRootUrl() + "/IGLOM0507_Del.do";
        return true;
    } else {
        return false;
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
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGLOM0580" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 接待月度汇总 &gt;&gt; 接待工作明细 &gt;&gt; 食堂招待管理</p>
	<div class="back"><html:link action="/IGLOM0111_Back.do">返回</html:link></div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="8%">序号</th>
			<th width="10%">日期</th>
			<th width="15%">招待活动</th>
			<th width="10%">主陪人</th>
			<th width="10%">每桌菜价格</th>
			<th width="10%">桌数</th>
			<th width="10%">酒价</th>
			<th width="10%">烟价</th>
			<th width="10%">其他用品价格</th>
		</tr>
		<logic:present name="IGLOM05071VO" property="eentertainmentList">
			<logic:iterate id="bean" name="IGLOM05071VO" property="eentertainmentList"
				indexId="index">
				<tr>
					<td>${PagingDTO.viewStartCount+index}</td>
					<td><bean:write name="bean" property="eedate" /></td>
					<td>${bean.recptionTB.rname}</td>
					<td><bean:write name="bean" property="eeuser" /></td>
					<td><bean:write name="bean" property="eetableprice" /></td>
					<td><bean:write name="bean" property="eetablenum" /></td>
					<td><bean:write name="bean" property="eedrinkprice" /></td>
					<td><bean:write name="bean" property="eesmokeprice" /></td>
					<td><bean:write name="bean" property="eeotherprice" /></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
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
