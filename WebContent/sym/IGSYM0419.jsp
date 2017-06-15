<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0419" toScope="request" />
<bean:define id="title" value="添加人员画面" toScope="request" />
<bean:define id="navigation" value="系统管理 &gt;&gt; 角色管理 &gt;&gt; 添加人员" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
<!--
	function toSave(){
		if(checkNum('urids')==0){
			alert("请选择添加人！");
	        return false;
		}
	    if(window.confirm("您是否确认保存？")){
	        form.action = getAppRootUrl() + "/IGSYM0419_Save.do?roleid="+$F("roleid");
	        return true;
	    } else {
	        return false;
	    }
	}
	function setOrg(url){
		 
		var temp = window.showModalDialog(url+"?roleid="+$F("roleid"),null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].orgidstr.value = "";
			document.forms[0].orgname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].orgidstr.value = temp.split("|")[0];
			document.forms[0].orgname.value = temp.split("|")[1];
		}		
	
	}
	function init(sign){

		if("1" == sign) {
			window.opener.location.href= getAppRootUrl() + "/IGSYM0418_Disp.do?roleid="+$F("roleid");
			window.close();
		}	

	}

	function confirmDisp(){
		if($("orgname").value.trim()==""){
			alert("请选择所属机构！");
			return false;
		}
		return true;
	}
	function setdefaultorg(){
		var orgidstr = document.forms[0].orgidstr.value;
		var orgname = document.forms[0].orgname.value;
		if((orgidstr==null || orgidstr=="") && (orgname==null || orgname=="")){
			var name = '<%=request.getAttribute("deforgname") %>';
			var id = '<%=request.getAttribute("deforgsys") %>';

			if(null!=id && null!=name && "null"!=id && "null"!=name){
				document.forms[0].orgidstr.value = id;
				document.forms[0].orgname.value = name;
			}		
		}
		
	}

	function selectUserItem(obj){
        var type = "del";
        if(obj.checked) {
        	type = "add";
        }
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=selectUserItem&urids=' + obj.value + '&clicktype=' + type,
			 onSuccess:  function(req, json){
			 	var result = req.responseText;
				if(result != null && result.trim() != ""){	
				} else {
				}
		     }
			});
	}
	function doSelectAll(name,obj){
		selectAll(name,obj);
		var checks = document.getElementsByName(obj);
		for(var i=0;i < checks.length;i++){
			selectUserItem(checks[i]);
		} 
	}
//-->
	</script>
<body onload="init('${IGSYM0419Form.sign}');setdefaultorg();" style="OVERFLOW-Y: auto;">
<html:form styleId="form" action="/IGSYM0419"  onsubmit="return checkSubmit(this);">

	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>用户ID：</span><span><html:text property="userid_q" styleId="userid_q"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" />
	</span>
	<span>&nbsp;&nbsp;用户姓名：</span><span><html:text
		property="username_q" styleId="username_q"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" />
	</span>
	<span>&nbsp;&nbsp;<span class="red">*</span>所属机构：</span><html:text property="orgname" readonly="true" ></html:text>
		<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_0410TREE.do');" alt="请选择机构"/>
	<html:hidden property="orgidstr" />
	<html:submit property="btn_search" styleClass="button" value="查询" onclick="return confirmDisp();"/>
	</div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="5%">
				<input type="checkbox" name="checkbox" id="checkbox" onclick="doSelectAll('checkbox','urids')"/>
			</th>
			<th width="10%">用户ID</th>
			<th width="10%">用户姓名</th>
			<th width="20%">所属机构</th>
			<th width="10%">用户电话</th>
			<th width="15%">用户手机</th>
			<th width="20%">用户邮箱</th>
			<th width="10%">同步</th>
		</tr>
		<logic:present name="IGSYM04191VO" property="userNotRoleList">
			<logic:iterate id="bean" name="IGSYM04191VO" property="userNotRoleList"
				indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><label><html:multibox property="urids" value="${bean.userid}-${bean.orgid}" onclick="selectUserItem(this)"/></label></td>
					<td>${bean.userid}</td>
					<td>${bean.username}</td>
					<td>${bean.orgname}</td>
					<td>${bean.userphone}</td>
					<td>${bean.usermobile}</td>
					<td>${bean.useremail}</td>
					<td>
						<logic:notEmpty name="bean" property="userstatus">是</logic:notEmpty>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<div id="operate" align="center"><logic:present name="IGSYM04191VO"
		property="userNotRoleList">
		<span><html:submit property="btn_save" value="保存"
			styleClass="button" onclick="return toSave();" /></span>
	</logic:present><input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button" align="middle"></div>
	<html:hidden property="roleid" name="IGSYM0419Form" styleId="roleid"/>
	<html:hidden property="sign" name="IGSYM0419Form" styleId="sign"/>
</html:form>
</body>
</html:html>