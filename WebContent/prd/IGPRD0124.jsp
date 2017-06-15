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
<bean:define id="id" value="IGPRD0124" toScope="request" />
<bean:define id="title" value="授权页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function deleteRec(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="角色类型" />';
        var mode="0";
        var count=0;
		if(flag=="1"){
			message = '请选择要添加的角色类型。';
			confirmMsg = '请确认是否要进行角色类型添加处理?';
			mode="1";
		}
        if(window.confirm(confirmMsg)){
			
			count=checkAndCreate(flag);
			if(count==0){
				alert(message);
	            return false;
			}
			IGPRD0124Form.action = getAppRootUrl() + "/IGPRD0124.do?mode="+mode;
            return true;
        } else {
            return false;
        }
	}

	function checkAndCreate(flag){
		var count=0;
		if(flag==1){
			var check=document.getElementsByName("roleid_add");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
					createHiddenInputForm("roletypes",check[i].value,IGPRD0124Form);
				}
			}
		}else{
			var check=document.getElementsByName("roleid_del");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
					createHiddenInputForm("prtdids",check[i].value,IGPRD0124Form);
				}
			}
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
<html:form styleId="form" action="/IGPRD0124" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation /> &gt;&gt; 授权</p>
<div class="back"><a href="IGPRD0101_Back.do" target="_self">返回</a></div> 
</div>
	<div class="role_title">现有角色类型</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="tab_del" class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label> 
						<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','roleid_del')"/>
					</label>
				</th>
				<th width="40%">角色类型</th>
				<th width="40%"></th>
			</tr>
			<logic:present name="IGPRD01241VO" property="processRoleTypeDefList">
				<logic:iterate id="bean" name="IGPRD01241VO" property="processRoleTypeDefList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
								<input type="checkbox" name="roleid_del" value="${bean.prtdid}">
						 	</label>
						</td>
						<td>
							<ig:codeValue ccid="ROLE_CATEGORY_CODE" cid="${bean.roletype}"/>
						</td>
						<td>
							
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01241VO" property="processRoleTypeDefList">
		<span>
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
		<html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('0');" />
		<%} %>	
		</span>
	</logic:present>
	</div>
	<div class="role_title">可选角色类型</div>
	<div id="results_list">
	<table class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label>
						<input type="checkbox" name="checkbox2" id="checkbox2" onclick="selectAll('checkbox2','roleid_add')"/> 
					</label>
				</th>
				<th width="40%">角色类型</th>
				<th width="40%"></th>
			</tr>
			<logic:present name="IGPRD01241VO" property="codeDetailList">
				<logic:iterate id="bean" name="IGPRD01241VO" property="codeDetailList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
								<input type="checkbox" name="roleid_add" value="${bean.cid}">
							</label>
						</td>
						
						<td>
							${bean.cvalue}
						</td>
						<td>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01241VO" property="codeDetailList">
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
			<html:submit property="btn_delete" value="添加所选" styleClass="button"  onclick="return deleteRec('1');"/>
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