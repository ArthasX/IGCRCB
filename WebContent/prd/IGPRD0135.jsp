<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<html:html>
<bean:define id="id" value="IGPRD0135" toScope="request" />
<bean:define id="title" value="参与者页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	function deleteRec(flag){
		var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="参与者" />';
	    var mode="0";
	    var count=0;
		if(flag=="1"){
			message = '请选择要添加的参与者。';
			confirmMsg = '请确认是否要进行参与者添加处理?';
			mode="1";
		}
   	 	if(window.confirm(confirmMsg)){
	   	 	count=checkAndCreate(flag);
			if(count==0){
				alert(message);
	            return false;
			}
			form.action = getAppRootUrl() + '/IGPRD0134.do?mode='+ mode;
			return true;
   	 	}else{
   	 		return false;
   	 	}
	}
	
	function checkAndCreate(flag){
		var count=0;
		if(flag==1){
			var check=document.getElementsByName("org_add");
			var ppuserids=document.getElementsByName("ppuserid");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count++;
					createHiddenInputForm("orgids",check[i].value,form);
				}
			}
		}else{
			var check=document.getElementsByName("ppdid_del");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count++;
					createHiddenInputForm("ppdids",check[i].value,form);
				}
			}
		}
		return count;
	}
	function ope(temp,psdid,ppdid,pdid){
		if(temp=="domain"){
			form.action=getAppRootUrl() + "/IGPRD0108_Disp.do?psdid="+psdid+"&ppdid="+ppdid+"&pdid="+pdid;
			form.submit();
		}
	}
//-->
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRD0134" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 状态列表 &gt;&gt; 参与者</p>
<div class="back"><a href="IGPRD0104_Back.do?pdid=<bean:write name="IGPRD0134Form" property="pdid"/>" target="_self">返回</a></div> 
</div>
<div class="role_title">当前状态：${IGPRD01341VO.processStatusDef.psdname}</div>
<br/>
	<div class="role_title">现有参与者</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="tab_del" class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label> 
						<c:if test="${IGPRD01341VO.processStatusDef.psdtype != '1'}">
							<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','ppdid_del')"/> 
						</c:if>
					</label>
				</th>
				<th width="50%">机构名称</th>
				<th width="30%">权限</th>
			</tr>
			<logic:present name="IGPRD01341VO" property="processParticipantDefList">
				<logic:iterate id="bean" name="IGPRD01341VO" property="processParticipantDefList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
							<c:if test="${IGPRD01341VO.processStatusDef.psdtype != '1'}">
							<input type="checkbox" name="ppdid_del" value="${bean.ppdid}">
							</c:if>
							<c:if test="${IGPRD01341VO.processStatusDef.psdtype == '1'}">
							<input type="radio" name="ppdid_del" value="${bean.ppdid}">
							</c:if>
						 	</label>
						</td>
						<td>
							${bean.org.orgname}
						</td>
						<td>
							<a href="javascript:ope('domain','${bean.psdid}','${bean.ppdid}','<bean:write name="IGPRD0134Form" property="pdid"/>');">
							<img src="images/sqcd.gif" width="16" height="16" border="0" alt="权限" />
							</a>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01341VO" property="processParticipantDefList">
		<span>
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
		<html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec('0');" />
		<%} %>	
		</span>
	</logic:present>
	</div>
	<div class="role_title">可选参与者</div>
	<div id="results_list">
	<table class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label>
						<c:if test="${IGPRD01341VO.processStatusDef.psdtype != '1'}">
							<input type="checkbox" name="checkbox2" id="checkbox2" onclick="selectAll('checkbox2','org_add')"/> 
						</c:if>
					</label>
				</th>
				<th width="80%">机构名称</th>
			</tr>
			<logic:present name="IGPRD01341VO" property="orgList">
				<logic:iterate id="bean" name="IGPRD01341VO" property="orgList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
						<label>
							<c:if test="${IGPRD01341VO.processStatusDef.psdtype != '1'}">
								<input type="checkbox" name="org_add" value="${bean.orgid}">
							</c:if>
							<c:if test="${IGPRD01341VO.processStatusDef.psdtype == '1'}">
							<input type="radio" name="org_add" value="${bean.orgid}">
							</c:if>
						</label>
						</td>
						<td>${bean.orgname}</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01341VO" property="orgList">
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
			<html:submit property="btn_delete" value="添加所选" styleClass="button"  onclick="return deleteRec('1');"/>
			<c:if test="${IGPRD01341VO.processStatusDef.psdtype == '2'}">
			<html:button property="btn_zhuguan" value="设定主办部门"
				styleClass="button"  onclick="window.location.href='IGPRD0114_Disp.do?psdid=${IGPRD0134Form.psdid}&pdid=${IGPRD0134Form.pdid}'"/>
			</c:if>
		<%} %>	
	</logic:present>
	</div>
	<html:hidden property="psdid" styleId="psdid" />
	<html:hidden property="pdid" styleId="pdid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>