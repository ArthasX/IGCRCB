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
<bean:define id="id" value="IGEXTWA0003" toScope="request" />
<bean:define id="title" value="流程参与人员选择页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

	function checkForm(){
		var confirmMsg = '您是否确认提交？';
		<c:if test="${IGEXTWA01212VO.num==0}">
	   		alert("指派工作需要指定处理人！");
	   		return false;
 		</c:if>
		if(window.confirm(confirmMsg)){
			return true;
		} else {
	        return false;
	    }
	}

	function implementors(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var mode="0";
        var count=0;
        confirmMsg = '请确认是否要进行合作人删除处理?';
		if(flag=="1"){
			openSubWindow('/IGEXTWA0127_Disp.do?queryjsp=exta0003' , '', '1000', '600');
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
	            form.action = getAppRootUrl() + "/IGEXTWA0127_Del.do";
	            return true;
	        } else {
	            return false;
	        }
		}
	}
	
	function goPage(url){
		document.forms[0].action=url;
		document.forms[0].submit();
		return true;
	}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGEXTWA0003"
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
										name="rolenames" value="${bean.rolename}"><input type="hidden"
										name="roleids" value="${bean.roleid}">
									</td>
									<td>
										${bean.username}<input type="hidden"
										name="ppusernames" value="${bean.username}"><input type="hidden"
										name="ppuserids" value="${bean.userid}">
									</td>
									<td>
										${bean.orgname}<input type="hidden"
										name="pporgnames" value="${bean.orgname}"><input type="hidden"
										name="pporgids" value="${bean.orgid}">
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
	
	<div class="enter">
		<html:submit property="btn_add" value="上一步"
		styleClass="button" onclick="return goPage('IGEXTWA0003_DispI.do');" />
		<html:submit styleClass="button" value="提交" onclick="return checkForm();"/>
	</div>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>

</div>
</body>
</html:html>