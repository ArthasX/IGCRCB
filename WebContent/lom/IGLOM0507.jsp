<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0507" toScope="request" />
<bean:define id="title" value="食堂招待管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script>

//删除所选
function deleteRec(obj){
	var message = '<bean:message key="IGCO10000.E002"/>';
    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="食堂招待信息" />';
    if(checkNum(obj)==0){
		alert(message);
        return false;
	}
    if(window.confirm(confirmMsg)){
        form.action = getAppRootUrl() + "/IGLOM0507_Del.do";
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


</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGLOM0507" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 食堂招待管理</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	
	<div>
	<span>招待日期：从</span><span><html:text
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
			<th width="3%">
				<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteEeid')"/> 
				</label>
			</th>
			<th width="5%">序号</th>
			<th width="10%">日期</th>
			<th width="15%">招待活动</th>
			<th width="10%">主陪人</th>
			<th width="10%">每桌菜价格</th>
			<th width="10%">桌数</th>
			<th width="10%">酒价</th>
			<th width="10%">烟价</th>
			<th width="10%">其他用品价格</th>
			<th width="6%">修改</th>
		</tr>
		<logic:present name="IGLOM05071VO" property="eentertainmentList">
			<logic:iterate id="bean" name="IGLOM05071VO" property="eentertainmentList"
				indexId="index">
				<tr>
					<c:if test="${bean.recptionTB.rstatus != '2'}">
	                    <td>
	                    	<label><html:checkbox property="deleteEeid" value="${bean.eeid}" /></label>
						</td>
					</c:if>
					<c:if test="${bean.recptionTB.rstatus == '2'}">
	                    <td>
						</td>
					</c:if>
					<td>${PagingDTO.viewStartCount+index}</td>
					<td><bean:write name="bean" property="eedate" /></td>
					<td>${bean.recptionTB.rname}</td>
					<td><bean:write name="bean" property="eeuser" /></td>
					<td><bean:write name="bean" property="eetableprice" /></td>
					<td><bean:write name="bean" property="eetablenum" /></td>
					<td><bean:write name="bean" property="eedrinkprice" /></td>
					<td><bean:write name="bean" property="eesmokeprice" /></td>
					<td><bean:write name="bean" property="eeotherprice" /></td>
					<c:if test="${bean.recptionTB.rstatus != '2'}">
	                    <td>							
							<html:link action="/IGLOM0507_Edit_Disp.do?eeid=${bean.eeid}">
								<img src="images/edit.gif" width="16" height="16" border="0"/>
							</html:link>			
						</td>
					</c:if>
					<c:if test="${bean.recptionTB.rstatus == '2'}">
	                    <td>
						</td>
					</c:if>
					
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGLOM05071VO"
		property="eentertainmentList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('deleteEeid');" /></span>
	</logic:present>
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
