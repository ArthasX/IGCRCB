<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<%@ page import="com.deliverik.infogovernor.util.CodeDefine" %>
<html:html>
<bean:define id="id" value="IGPRD0139h" toScope="request" />
<bean:define id="title" value="可被分派角色授权页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function deleteRec(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="角色" />';
        var mode="0";
        var count=0;
		if(flag=="1"){
			message = '请选择要添加的角色。';
			confirmMsg = '请确认是否要进行角色添加处理?';
			mode="1";
		}
        if(window.confirm(confirmMsg)){
			
			count=checkAndCreate(flag);
			if(count==0){
				alert(message);
	            return false;
			}
			IGPRD0139Form.action = getAppRootUrl() + "/IGPRD0139.do?mode="+mode;
            return true;
        } else {
            return false;
        }
	}

	function checkAndCreate(flag){
		var count=0;
		if(flag==1){
			count = checkNum("roleids");
		}else{
			count = checkNum("psrdids");
		}
		return count;
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
<html:form styleId="form" action="/IGPRD0139" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt;流程管理 &gt;&gt; 历史版本 &gt;&gt; 状态列表 &gt;&gt; 可被分派角色授权</p>
<div class="back"><a href="IGPRD0104_Back.do?pdid=${IGPRD0139Form.pdid}&viewhistory=1" target="_self">返回</a></div> 
</div>
	<div class="role_title">现有角色</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="tab_del" class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label> 
						<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','psrdids')"/>
					</label>
				</th>
				<th width="40%">角色</th>
				<th width="40%"></th>
			</tr>
			<logic:present name="IGPRD01391VO" property="lst_ProcessStatusRoleDef">
				<logic:iterate id="bean" name="IGPRD01391VO" property="lst_ProcessStatusRoleDef" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
								<input type="checkbox" name="psrdids" value="${bean.psrdid}">
						 	</label>
						</td>
						<td>
							${bean.role.rolename}
						</td>
						<td>
							
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate" style="display:none">
	<logic:present name="IGPRD01391VO" property="lst_ProcessStatusRoleDef">
		<bean:size id="lst_ProcessStatusRoleDef_count" name="IGPRD01391VO" property="lst_ProcessStatusRoleDef"/>
		<c:if test="${lst_ProcessStatusRoleDef_count > 0}">
			<span>
			<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
			<html:submit property="btn_delete" value="删除所选"
				styleClass="button" onclick="return deleteRec('0');" />
			<%} %>	
			</span>
		</c:if>
	</logic:present>
	</div>
	<div class="role_title">可选角色</div>
	<div id="results_list">
	<table class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label>
						<input type="checkbox" name="checkbox2" id="checkbox2" onclick="selectAll('checkbox2','roleids')"/> 
					</label>
				</th>
				<th width="40%">角色</th>
				<th width="40%"></th>
			</tr>
			<logic:present name="IGPRD01391VO" property="lst_Role">
				<logic:iterate id="bean" name="IGPRD01391VO" property="lst_Role" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
								<input type="checkbox" name="roleids" value="${bean.roleid}">
							</label>
						</td>
						<td>
							${bean.rolename}
						</td>
						<td>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<!--  
	<div id="operate">
	<logic:present name="IGPRD01391VO" property="lst_Role">
		<bean:size id="lst_Role_count" name="IGPRD01391VO" property="lst_Role"/>
		<c:if test="${lst_Role_count > 0}">
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
			<html:submit property="btn_delete" value="添加所选" styleClass="button"  onclick="return deleteRec('1');"/>
		<%} %>
		</c:if>
	</logic:present>
	</div>
	-->
	<html:hidden property="psdid" styleId="psdid" />
	<html:hidden property="pdid" styleId="pdid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>