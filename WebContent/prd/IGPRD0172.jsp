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
<bean:define id="id" value="IGPRD0172" toScope="request" />
<bean:define id="title" value="查看权限页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	//按钮操作提示
	function deleteRec(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="表单" />';
        var mode="0";
        var count=0;
		if(flag=="1"){
			message = '请选择要添加的表单。';
			confirmMsg = '请确认是否要进行表单添加处理?';
			mode="1";
		}
        if(window.confirm(confirmMsg)){
			
			count=checkAndCreate(flag);
			if(count==0){
				alert(message);
	            return false;
			}
			IGPRD0172Form.action = getAppRootUrl() + "/IGPRD0172.do?mode="+mode;
            return true;
        } else {
            return false;
        }
	}

	function checkAndCreate(flag){
		var count=0;
		if(flag==1){
			var check=document.getElementsByName("pidid_add");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
					createHiddenInputForm("pididb",check[i].value,IGPRD0172Form);
				}
			}
		}else{
			var check=document.getElementsByName("pidid_del");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
					createHiddenInputForm("pidida",check[i].value,IGPRD0172Form);
				}
			}
		}
		return count;
	}	

	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRD0172" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 查看权限 &gt;&gt; 查看角色&gt;&gt; 权限</p>
<div class="back"><a href="IGPRD0171_Disp.do" target="_self">返回</a></div> 
</div>
	<div class="role_title">现有表单</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="tab_del" class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label> 
							<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','pidid_del')"/> 
					</label>
				</th>
				<th width="40%">表单</th>
				<th width="20%"></th>
			</tr>
			<logic:present name="IGPRD01721VO" property="ig701InfoList">
				<logic:iterate id="bean" name="IGPRD01721VO" property="ig701InfoList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
							<input type="checkbox" name="pidid_del" value="${bean.pdid}_${bean.roleid}_${bean.pidid}">
						 	</label>
						</td>
						<td>
							${bean.processInfoDef.pidname}
						</td>
						<td>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01721VO" property="ig701InfoList">
		<span>
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
		<html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec('0');" />
		<%} %>	
		</span>
	</logic:present>
	</div>
	<div class="role_title">可选表单</div>
	<div id="results_list">
	<table class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label>
							<input type="checkbox" name="checkbox2" id="checkbox2" onclick="selectAll('checkbox2','pidid_add')"/> 
					</label>
				</th>
				<th width="40%">表单</th>
				<th width="20%"></th>
			</tr>
			<logic:present name="IGPRD01721VO" property="ig007InfoList">
				<logic:iterate id="bean" name="IGPRD01721VO" property="ig007InfoList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
						<label>
							<input type="checkbox" name="pidid_add" value="${bean.pidid}">
						</label>
						</td>
						<td>${bean.pidname}</td>
						<td></td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01721VO" property="ig007InfoList">
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
		<html:submit property="btn_delete" value="添加所选" styleClass="button"  onclick="return deleteRec('1');"/>
		<%} %>	
	</logic:present>
	</div>
	<html:hidden property="pdid" styleId="pdid" />
	<html:hidden property="roleid" styleId="roleid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>