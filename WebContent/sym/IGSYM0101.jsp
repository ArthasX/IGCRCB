<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGSYM0101" toScope="request" />
<bean:define id="title" value="机构管理查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<%

	Map<Integer,String> namemap = new HashMap<Integer,String>();
	Map<Integer,String> buttonmap = new HashMap<Integer,String>();
	Map<Integer,String> startbuttonmap = new HashMap<Integer,String>();
	if(null!=request.getAttribute("nameMap")){
		namemap = (Map)request.getAttribute("nameMap");
	}
	if(null!=request.getAttribute("buttonMap")){
		buttonmap = (Map)request.getAttribute("buttonMap");
	}
	if(null!=request.getAttribute("startbuttonMap")){
		startbuttonmap = (Map)request.getAttribute("startbuttonMap");
	}
	
%>
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//删除所选
	function deleteRec(obj){
		var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="机构基本信息" />';
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
	    if(window.confirm(confirmMsg)){
	        form.action = getAppRootUrl() + "/IGSYM0101_Del.do";
	        return true;
	    } else {
	        return false;
	    }
	}

	function setOrg(url){
		 
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

		if("_resetall"==temp){
			document.forms[0].orgparstr_q.value = "";
			document.forms[0].orgparname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].orgparstr_q.value = temp.split("|")[0];
			document.forms[0].orgparname.value = temp.split("|")[1];
		}
		
	}

	

	function changeStatus(orgid){
		if(confirm("是否改变状态？")){
			var form = document.getElementById("form");
			form.action="changeORGStatus.do?orgid=" + orgid;
			form.submit();
		}
	}
//-->
	</script><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGSYM0101"
	onsubmit="return checkSubmit(this);">
	
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>机构名称：</span><html:text property="orgname_q" styleId="orgname_q" errorStyleClass="inputError imeDisabled" size="15" maxlength="32"  tabindex="1"/>
	<span>&nbsp;&nbsp;上级机构：</span><html:text property="orgparname" readonly="true"></html:text>
	<img src="images/tree.gif" style="cursor: hand;" alt="选择上级机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_ROLETREE.do');"/>&nbsp;&nbsp; 
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<!--<th width="6%">
				<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteOrgid')"/> </label>
				</th>
				-->
				<th width="5%">序号</th>
				<th width="8%">编码</th>
				<th width="15%">上级机构</th>
				<th width="15%">机构名称</th>
				<th width="8%">联系人</th>
				<th width="10%">联系电话</th>
				<th width="10%">传真</th>
				<th width="15%">说明</th>
				<th width="6%">状态</th>
				<th width="4%">调整</th>
				<th width="4%">修改</th>
			</tr>
			<logic:present name="IGSYM01011VO" property="organizationcondList">
				<logic:iterate id="bean" name="IGSYM01011VO"
					property="organizationcondList" indexId="index">
					<bean:define id="oid" name="bean" property="orgid"  toScope="request" />
					<tr class="<ig:rowcss index="${index}"/>">
						
						<!--<td><label><html:checkbox
							property="deleteOrgid" value="${bean.orgid}" /></label>
						</td>
						-->
						<td>
							<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
						</td>
						<td>${bean.orgusercoding}</td>
						<td>${bean.orgparname}</td>
						<td title='${bean.orgname }'>${bean.orgname}</td>
						
						
						<td>${bean.orgcontact}</td>
						<td>${bean.orgphone}</td>
						<td>${bean.orgfax}</td>
						<td><pre>${bean.orgdesc}</pre></td>
						
						<td>
							  <logic:equal name="bean" property="orgstatus"  value="1">使用中
						      </logic:equal>
						      <logic:equal name="bean" property="orgstatus"  value="0">停用中
						      </logic:equal>
						</td>
						<td>
						<%if(buttonmap.get(oid).equals("1")){ %>
							<logic:equal name="bean" property="orgstatus"  value="1"><a href="javascript:changeStatus(${bean.orgid});"><img src="images/stop.gif" border="0" alt="停用"/></a>
						      </logic:equal>
						   
						<%}%>      
						<%if(startbuttonmap.get(oid).equals("1")){ %>
							<logic:equal name="bean" property="orgstatus"  value="0"><a href="javascript:changeStatus(${bean.orgid});"><img src="images/start.gif" border="0" alt="启用"/></a>
						      </logic:equal>
						<%}%> 
						 
						</td>
						<td>		
							<c:if test="${bean.orgpar != '0001'}">		
								<html:link action="/IGSYM0102_Edit_Disp.do?orgidstr=${bean.orgid}&orgstatus=${bean.orgstatus}">
									<img src="images/edit.gif" width="16" height="16" border="0"/>
								</html:link>	
							</c:if>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGSYM01011VO"
		property="organizationcondList">
		<!--<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('deleteOrgid');" /></span>
	--></logic:present> <!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
	<html:hidden property="orgparstr_q"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>