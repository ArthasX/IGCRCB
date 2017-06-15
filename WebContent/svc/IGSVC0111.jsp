<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.util.SVCHelper"%>
<html:html>
<bean:define id="id" value="IGSVC0111" toScope="request" />
<bean:define id="title"  toScope="request" >
<bean:message bundle="svcResources" key="ietitle.IGSVC0111"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

function searchprocessStatus(){
	var pdid = $("pdid").value;
	var propertyValue = '<bean:write name="provalue" />';
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'pdid='+ pdid + '&property=prstatus&ccid=103&propertyValue='+propertyValue+'&type=searchprocessStatus',
		 onSuccess:  function(req, json){
		 var result=req.responseText;
		 statusTxt.innerHTML= result;				
	     }
		});
}
function ope(temp,prid){
	if(temp=="del"){
		if(window.confirm('<bean:message bundle="svcResources" key="message.IGSVC0111.001"/>')){
			window.location=getAppRootUrl() + "/IGSVC0111_del.do?delprid="+prid;			
		}
	}
}

function showSort(field){
	var imgSrc = document.getElementById("img_"+field).src;
	var strs = imgSrc.split("/");
	var imgname=strs[strs.length-1];
	if("timeup.gif" == imgname){
		document.getElementById("porder").value = field + " desc";
		//alert(document.getElementById("porder").value);
		document.forms[0].submit();
	}else if("timedown.gif" == imgname){
		document.getElementById("porder").value = field + " asc";
		//alert(document.getElementById("porder").value);
		document.forms[0].submit();
	}else{
		
	}
}
function initImg(){
	var showorder = document.forms[0].porder.value;
	if(showorder == null || "" == showorder){
		return;
	}
	var field = showorder.split(" ")[0];
	var order = showorder.split(" ")[1];
	if(order != null && "desc" == order){
		document.getElementById("img_"+field).src = "images/timedown.gif";
	}else if(order != null && "asc" == order){
		document.getElementById("img_"+field).src = "images/timeup.gif";
	}
	document.getElementById("porder").value = "";

	showorder = $("psort_order").value;
	if(showorder == null || "" == showorder){
		return;
	}
	field = showorder.split(" ")[0];
	order = showorder.split(" ")[1];
	if(order != null && "desc" == order){
		document.getElementById("img_prpdname").src = "images/timedown.gif";
	}else if(order != null && "asc" == order){
		document.getElementById("img_prpdname").src = "images/timeup.gif";
	}
}

function setpsort_order(){
	var psort = $("psort").value;
	if(psort != null && psort != ""){
		$("psort_order").value = $("psort").value + " asc";
	}
	else{
		$("psort_order").value = "";
	}
}

function doLookOpen(url,urlparent){
	var obj=window.showModalDialog(url,null,"dialogWidth:1024px;dialogHeight:650px;status:no;help:no;resizable:yes");		
	if(obj){
		window.parent.location=obj;
	}
}
</script>
<style>
html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	font-size: 12px;
	overflow-x: hidden;
	background-color: #FFFFFF;
}
</style>
<body onload="searchprocessStatus();initImg();">

<div id="content" style="width:678px;height:511px;border: 1px solid #CCCCCC;margin-left:2px;">
<html:form action="/IGSVC0111" styleId="form"
	onsubmit="return checkSubmit(this);" method="get">
	<div id="search" style="border: 0px;">
	<div class="img" style="margin-top: 8px"></div>
	<div class="conditions">
	<div>
	<!--  
	  <span>编号：&nbsp;&nbsp;</span><span><html:text
		property="prserialnum" errorStyleClass="inputError imeActive" size="12" /></span> 
	-->
	<span>&nbsp;&nbsp;<bean:message bundle="svcResources" key="label.IGSVC0111.prtitle"/>：</span><span><html:text
		property="prtitle" /></span>
		<!--  
		<span>&nbsp;&nbsp;发起者：</span><span><html:text
		property="prusername" size="12"/></span>
		-->
			<span>&nbsp;&nbsp;&nbsp;&nbsp;<bean:message bundle="svcResources" key="label.IGSVC0111.pdid"/>：</span><span>
            <html:select property="pdid" onchange="searchprocessStatus();">
            	<option></option>
            	<logic:iterate name="ADlist" id="bean" type="com.deliverik.framework.workflow.prd.model.ProcessDefinition">
				<html:option value="${bean.pdid}">${bean.pdname}</html:option>
				</logic:iterate>
			</html:select></span>
		<!--  
		<span>&nbsp;&nbsp;状态：</span><span id="statusTxt">
		<SELECT name="prstatus" style="width: 80px;">
			<option></option>
		</SELECT>
	   </span>
	   -->
    </div>
	<div>
	<html:hidden property="porder"/>
	<html:hidden property="psort_order"/>
	<span>&nbsp;&nbsp;<bean:message bundle="svcResources" key="label.IGSVC0111.time"/>：<bean:message bundle="svcResources" key="label.IGSVC0111.propentime"/></span><span><html:text
		property="propentime" styleId="propentime"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
	</span>
	<span>&nbsp;&nbsp;<bean:message bundle="svcResources" key="label.IGSVC0111.prclosetime"/></span><span><html:text
		property="prclosetime" styleId="prclosetime"
		errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
	<img src="images/date.gif" align="middle"
		onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" /></span>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <span> <html:submit
		styleClass="button"  >
		<bean:message bundle="svcResources" key="button.IGSVC0111.search"/>
		</html:submit>
		</span>
		<div>
		<span>&nbsp;&nbsp;<bean:message bundle="svcResources" key="label.IGSVC0111.psort"/>：</span><span>
            <html:select property="psort" onchange="setpsort_order()">
            	<option></option>
				<html:option value="prpdname"><bean:message bundle="svcResources" key="title.IGSVC0111.prtype"/></html:option>
			</html:select></span>
		</div>
		
	</div>
	</div>
	</div>
	<div id="results_list"  style="width:670px;"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style" style="width:670px;">
		<tr>
			<th width="3%"></th>
			<th width="10%"><a href="javascript:showSort('prid');"><bean:message bundle="svcResources" key="title.IGSVC0111.prid"/><img id="img_prid" src="images/timeup.gif" border="0"></a></th>
			<th width="15%"><a href="javascript:showSort('prtitle');"><bean:message bundle="svcResources" key="title.IGSVC0111.prtitle"/><img id="img_prtitle" src="images/timeup.gif" border="0"></a></th>
			<th width="10%"><a href="javascript:showSort('prpdname');"><bean:message bundle="svcResources" key="title.IGSVC0111.prtype"/><img id="img_prpdname" src="images/timeup.gif" border="0"></a></th>
			<th width="15%"><a href="javascript:showSort('propentime');"><bean:message bundle="svcResources" key="title.IGSVC0111.propentime"/><img id="img_propentime" src="images/timeup.gif" border="0"></a></th>
			<th width="15%"><a href="javascript:showSort('prclosetime');"><bean:message bundle="svcResources" key="title.IGSVC0111.prclosetime"/><img id="img_prclosetime" src="images/timeup.gif" border="0"></a></th>
			<th width="10%"><a href="javascript:showSort('prstatus');"><bean:message bundle="svcResources" key="title.IGSVC0111.prstatus"/><img id="img_prstatus" src="images/timeup.gif" border="0"></a></th>
			<% if("1".equals(request.getAttribute("isAdmin"))){ %>
				<th width="5%"><bean:message bundle="svcResources" key="title.IGSVC0111.delete"/></th>
				<th width="10%" align="center"><bean:message bundle="comResources" key="title.IGPOR0102.facttime"/></th>
			<%}%>
		</tr>
	</table>
	</div>
	<div id="results_list" style="width:670px;height:340px;overflow-y:auto;overflow-x:hidden;">
	<table class="table_style" style="width:670px;">
		<logic:present name="IGSVC02011VO" property="processList">
			<logic:iterate id="bean" name="IGSVC02011VO" property="processList"
				indexId="index" type="com.deliverik.framework.workflow.prr.model.entity.ProcessRecordTB">
			<bean:define id="prtype" name="bean" property="prtype" type="java.lang.String" />
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');">
					<td width="3%">
						<%
							String prassetname = bean.getPrassetname();
							if(prassetname!=null&& prassetname.split(":").length==2){
								String isShow=prassetname.split(":")[1];
								if("1".equals(isShow)){
								%>
									<img src="images/full-time.gif" width="16" height="16" border="0" alt='<bean:message bundle="svcResources" key="img.IGSVC0111.time.alt"/>' />
								<%
							}
						}
						%>
					</td>
					<td width="10%">
					<logic:equal name="bean" property="prtype" value="WA">
						onclick="doLookOpen('IGEXTWA0103_Disp.do?prid=<bean:write name="bean" property="prid" />','IGSVC0111.do');"
					</logic:equal>
					<logic:equal name="bean" property="prtype" value="WB">
						onclick="doLookOpen('IGEXTWB0103_Disp.do?prid=<bean:write name="bean" property="prid" />','IGSVC0111.do');"
					</logic:equal>
					<logic:notEqual name="bean" property="prtype" value="WA">
					       <logic:notEqual name="bean" property="prtype" value="WB">
						 onclick="doLookOpen(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&prtype=<bean:write name="bean" property="prtype" />&prstatus=<bean:write name="bean" property="prstatus" />','IGSVC0111.do');" 
					       </logic:notEqual>
					</logic:notEqual>	
					<bean:write name="bean" property="prserialnum" /></td>
					<td width="15%">
					<logic:equal name="bean" property="prtype" value="WA">
						onclick="doLookOpen('IGEXTWA0103_Disp.do?prid=<bean:write name="bean" property="prid" />','IGSVC0111.do');"
					</logic:equal>
					<logic:equal name="bean" property="prtype" value="WB">
						onclick="doLookOpen('IGEXTWB0103_Disp.do?prid=<bean:write name="bean" property="prid" />','IGSVC0111.do');"
					</logic:equal>
					<logic:notEqual name="bean" property="prtype" value="WA">
					       <logic:notEqual name="bean" property="prtype" value="WB">
						 onclick="doLookOpen(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&prtype=<bean:write name="bean" property="prtype" />&prstatus=<bean:write name="bean" property="prstatus" />','IGSVC0111.do');" 
					       </logic:notEqual>
					</logic:notEqual>	
					
					<bean:write name="bean" property="prtitle" /></td>
					<td width="10%">
					<logic:equal name="bean" property="prtype" value="WA">
						onclick="doLookOpen('IGEXTWA0103_Disp.do?prid=<bean:write name="bean" property="prid" />','IGSVC0111.do');"
					</logic:equal>
					<logic:equal name="bean" property="prtype" value="WB">
						onclick="doLookOpen('IGEXTWB0103_Disp.do?prid=<bean:write name="bean" property="prid" />','IGSVC0111.do');"
					</logic:equal>
					<logic:notEqual name="bean" property="prtype" value="WA">
					       <logic:notEqual name="bean" property="prtype" value="WB">
						 onclick="doLookOpen(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&prtype=<bean:write name="bean" property="prtype" />&prstatus=<bean:write name="bean" property="prstatus" />','IGSVC0111.do');" 
					       </logic:notEqual>
					</logic:notEqual>	
					
					<bean:write name="bean" property="prpdname" /></td>
				<!--<td><bean:write name="bean" property="prusername" /></td> -->	
					<td width="15%">
					<logic:equal name="bean" property="prtype" value="WA">
						onclick="doLookOpen('IGEXTWA0103_Disp.do?prid=<bean:write name="bean" property="prid" />','IGSVC0111.do');"
					</logic:equal>
					<logic:equal name="bean" property="prtype" value="WB">
						onclick="doLookOpen('IGEXTWB0103_Disp.do?prid=<bean:write name="bean" property="prid" />','IGSVC0111.do');"
					</logic:equal>
					<logic:notEqual name="bean" property="prtype" value="WA">
					       <logic:notEqual name="bean" property="prtype" value="WB">
						 onclick="doLookOpen(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&prtype=<bean:write name="bean" property="prtype" />&prstatus=<bean:write name="bean" property="prstatus" />','IGSVC0111.do');" 
					       </logic:notEqual>
					</logic:notEqual>	
					<bean:write name="bean" property="propentime" /></td>
					<td width="15%">
					<logic:equal name="bean" property="prtype" value="WA">
						onclick="doLookOpen('IGEXTWA0103_Disp.do?prid=<bean:write name="bean" property="prid" />','IGSVC0111.do');"
					</logic:equal>
					<logic:equal name="bean" property="prtype" value="WB">
						onclick="doLookOpen('IGEXTWB0103_Disp.do?prid=<bean:write name="bean" property="prid" />','IGSVC0111.do');"
					</logic:equal>
					<logic:notEqual name="bean" property="prtype" value="WA">
					       <logic:notEqual name="bean" property="prtype" value="WB">
						 onclick="doLookOpen(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&prtype=<bean:write name="bean" property="prtype" />&prstatus=<bean:write name="bean" property="prstatus" />','IGSVC0111.do');" 
					       </logic:notEqual>
					</logic:notEqual>	
					<bean:write name="bean" property="prclosetime" /></td>
					<td width="10%">
					<logic:equal name="bean" property="prtype" value="WA">
						onclick="doLookOpen('IGEXTWA0103_Disp.do?prid=<bean:write name="bean" property="prid" />','IGSVC0111.do');"
					</logic:equal>
					<logic:equal name="bean" property="prtype" value="WB">
						onclick="doLookOpen('IGEXTWB0103_Disp.do?prid=<bean:write name="bean" property="prid" />','IGSVC0111.do');"
					</logic:equal>
					<logic:notEqual name="bean" property="prtype" value="WA">
					       <logic:notEqual name="bean" property="prtype" value="WB">
						 onclick="doLookOpen(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&prtype=<bean:write name="bean" property="prtype" />&prstatus=<bean:write name="bean" property="prstatus" />','IGSVC0111.do');" 
					       </logic:notEqual>
					</logic:notEqual>
						<logic:notEqual value="WA" name="bean" property="prtype">
						  <logic:notEqual value="WB" name="bean" property="prtype">
						<ig:processDefineTypeValue prid="${bean.prid}"/>
						  </logic:notEqual>
						</logic:notEqual>
						<logic:equal value="WA" name="bean" property="prtype">
						<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
						</logic:equal>
						<logic:equal value="WB" name="bean" property="prtype">
						<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
						</logic:equal>
					</td>
					<%if("1".equals(request.getAttribute("isAdmin"))){ %>
						<td width="5%">
							<a href="javascript:ope('del','${bean.prid}');">
								<img src="images/delete.gif" width="16" height="16" border="0" alt='<bean:message bundle="svcResources" key="img.IGSVC0111.delete.alt"/>' />
							</a>
						</td>
						<td width="10%" align="center"><bean:write name="bean" property="prfacttime" /></td>
					<%}%>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>	
</html:form></div>
</body>
</html:html>
