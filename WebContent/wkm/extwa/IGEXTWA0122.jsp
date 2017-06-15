<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.WorkFlowConstDefine"%>
<html:html>
<bean:define id="id" value="IGEXTWA0122" toScope="request" />
<bean:define id="title" value="流程参与人员选择页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
function checkNotSelect(obj) {
	var ret = 0; 
	var array = document.getElementsByName(obj); 
	for(var i=0;i<array.length;i++){
		if(array[i].checked==true){
			ret ++;
		}
	}
	if(ret == array.length){
		return true;
	} else {
		return false;
	}
}

	function checkForm(){
		var confirmMsg = '您是否确认提交？';
		<c:if test="${IGEXTWA01212VO.num==0}">
	   		alert("指派工作需要指定处理人！");
	   		return false;
 		</c:if>
 		<c:if test="${IGEXTWA01212VO.numV==0}">
	   		alert("指派工作需要指定审核人！");
	   		return false;
		</c:if>
		if(window.confirm(confirmMsg)){
			document.forms[0].action=getAppRootUrl() + "/IGEXTWA0122.do?prid="+${IGEXTWA0102Form.prid};
			document.forms[0].submit();
			return true;
		} else {
	        return false;
	    }
	}

	function verifiors(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var mode="0";
        var count=0;
        confirmMsg = '请确认是否要进行审核人删除处理?';
		if(flag=="1"){
			openSubWindow('/IGEXTWA0124_Disp.do?prid='+${IGEXTWA0102Form.prid} , 'newpage', '1000', '600');
	 		return false;
		}else{
			var vArray = document.getElementsByName("check_v"); 
			count=vArray.length;
			
			if(count==1){
				alert("请至少保留一个角色！");
	            return false;
			}
			count=0;
			var check=document.getElementsByName("check_v");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
				}
			}
			
			if(count==0){
				alert(message);
	            return false;
			}
			if(window.confirm(confirmMsg)){
	            form.action = getAppRootUrl() + "/IGEXTWA0124_Del.do?mode="+mode+"&path="+"IGEXTWA0122";
	            return true;
	        } else {
	            return false;
	        }
		}
	}

	function implementors(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var mode="0";
        var count=0;
        confirmMsg = '请确认是否要进行合作人删除处理?';
		if(flag=="1"){
			openSubWindow('/IGEXTWA0123_Disp.do?prid='+${IGEXTWA0102Form.prid} , '', '1000', '600');
	 		return false;
		}else{
			var check=document.getElementsByName("check_i");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
				}
			}
			if(count==0){
				alert(message);
	            return false;
			}
			if(window.confirm(confirmMsg)){
	            form.action = getAppRootUrl() + "/IGEXTWA0123_Del.do?mode="+mode+"&path="+"IGEXTWA0122";
	            return true;
	        } else {
	            return false;
	        }
		}
	}
	
	function goPage(url){
		document.forms[0].action=url+"?prid="+${IGEXTWA0102Form.prid};
		document.forms[0].submit();
		return true;
	}
	function freshPage(){
		document.forms[0].action=getAppRootUrl() + "/IGEXTWA0122_Assign_Disp.do?prid="+${IGEXTWA0102Form.prid};
		document.forms[0].submit();
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGEXTWA0122"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">参与人</p>
	</div>
	<div class="image" style="margin-top:2px;margin-left:4px;"><img src="images/w222.gif"/></div>
	<div id="formwrapper">
	<fieldset><legend><span class="red">*</span>处理人信息</legend>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<!-- 标题 -->
				<tr>
					<div class="role_title" style="margin-left: 5px">现有处理人</div>
				</tr>
				<!-- 合作人列表 -->
				<tr>
					<table class="table_style8" width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th width="10%">
								<input type="checkbox" name="checkbox_del_i" id="checkbox_del_i"
									   onclick="selectAllNoDisable('checkbox_del_i','check_i')" />
							</th>
							<th width="28%">角色</th>
							<th width="30%">处理人</th>
							<th width="30%">机构</th>
							<td width="2%"></td>
						</tr>
						<logic:present name="IGEXTWA01212VO" property="implementorsList">
							<logic:iterate id="bean" name="IGEXTWA01212VO"
								property="implementorsList" indexId="index">
								<tr class="<ig:rowcss index="${index}"/>">
									<td>
										<input type="checkbox" name="check_i" value="${bean.ppid}"/><input type="hidden"
										name="ppids_i" value="${bean.ppid}">
									</td>
									<td>
										${bean.rolename}<input type="hidden"
										name="rolenames_i" value="${bean.rolename}"><input type="hidden"
										name="roleids_i" value="${bean.roleid}">
									</td>
									<td>
										${bean.username}<input type="hidden"
										name="ppusernames_i" value="${bean.username}"><input type="hidden"
										name="ppuserids_i" value="${bean.userid}">
									</td>
									<td>
										${bean.orgname}<input type="hidden"
										name="pporgnames_i" value="${bean.orgname}"><input type="hidden"
										name="pporgids_i" value="${bean.orgid}">
									</td>
								</tr>
							</logic:iterate>
						</logic:present>
					</table>
				</tr>
				<tr>
					<table width="98%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td align="right">
								<html:submit property="btn_add" value="添加处理人"
								styleClass="button" onclick="return implementors('1');" />
								<html:submit
								property="btn_delete" value="删除选择" styleClass="button"
								onclick="return implementors('0');" />
							</td>
						</tr>
					</table>
				</tr>
			</table>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend><span class="red">*</span>审核人信息</legend>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<table width="100%" border="0" cellspacing="0" cellpadding="0">
				<!-- 标题 -->
				<tr>
					<div class="role_title" style="margin-left: 5px">现有审核人</div>
				</tr>
				<!-- 审核人列表 -->
				<tr>
					<table class="table_style8" width="100%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<th width="10%">
								<input type="checkbox" name="checkbox_del_v" id="checkbox_del_v"
									   onclick="selectAllNoDisable('checkbox_del_v','check_v')" />
							</th>
							<th width="28%">角色</th>
							<th width="30%">审核人</th>
							<th width="30%">机构</th>
							<td width="2%"></td>
						</tr>
						<logic:present name="IGEXTWA01212VO" property="verifiorsList">
							<logic:iterate id="bean" name="IGEXTWA01212VO"
								property="verifiorsList" indexId="index">
								<tr class="<ig:rowcss index="${index}"/>">
									<td>
										<input type="checkbox" name="check_v" value="${bean.ppid}"/><input type="hidden"
										name="ppids_v" value="${bean.ppid}">
									</td>
									<td>
										${bean.rolename}<input type="hidden"
										name="rolenames_v" value="${bean.rolename}"><input type="hidden"
										name="roleids_v" value="${bean.roleid}">
									</td>
									<td>
										${bean.username}<input type="hidden"
										name="ppusernames_v" value="${bean.username}"><input type="hidden"
										name="ppuserids_v" value="${bean.userid}">
									</td>
									<td>
										${bean.orgname}<input type="hidden"
										name="pporgnames_v" value="${bean.orgname}"><input type="hidden"
										name="pporgids_v" value="${bean.orgid}">
									</td>
								</tr>
							</logic:iterate>
						</logic:present>
					</table>
				</tr>
				<tr>
					<table width="98%" border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td align="right">
								<html:submit property="btn_add" value="添加审核人"
								styleClass="button" onclick="return verifiors('1');" />
								<html:submit
								property="btn_delete" value="删除选择" styleClass="button"
								onclick="return verifiors('0');" />
							</td>
						</tr>
					</table>
				</tr>
			</table>
		</tr>
	</table>
	</fieldset>
	
	<div class="enter">
		<html:submit property="btn_add" value="上一步"
		styleClass="button" onclick="return goPage('IGEXTWA0122_DispI.do');" />
		<html:submit styleClass="button" value="提交" onclick="return checkForm();"/>
	</div>
	</div>
	<html:hidden property="prid" styleId="prid" name="IGEXTWA0102Form" />
	<html:hidden property="roleid" name="IGEXTWA0102Form" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>