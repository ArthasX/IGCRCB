<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0406" toScope="request" />
<bean:define id="title" value="角色用户查询画面" toScope="request" />
<%
	String path = request.getParameter("path");
%>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParamRoleUser("", "",'<bean:write name="IGSYM0405Form" property="roleida"/>',"","");
            }
            window.close();
        }
        function checkParent(){
			if(!window.opener.setParamRoleUser){
				document.getElementById("parent").style.display = "none";
			}
        }
      //选择
    	function deleteRec(obj){
    		var message = '请选择相应人员！';
    		var count=0;
    		var check = document.getElementsByName(obj);
    		var userids = document.getElementsByName("userid");
    		var usernames = document.getElementsByName("user_name");
    		var orgids = document.getElementsByName("orgid");
    		var orgnames = document.getElementsByName("userorgname");
    		var userid = ""; 
    		var username = "";
    		var orgid = "";
    		var orgname = "";
    		for(var i=0;i<check.length;i++){
    			if(check[i].checked==true){
    				count=1;
    				userid += userids[i].value+",,,,";
    				username += usernames[i].value+",";
    				orgid += orgids[i].value+",";
    				orgname += orgnames[i].value+",";
    			}
    		}
    		if(count==0){
				alert(message);
				return false;
        	}else{
        		userid = userid.substring(0,userid.length-4);
        		username = username.substring(0,username.length-1);
        		orgid = orgid.substring(0,orgid.length-1);
        		orgname = orgname.substring(0,orgname.length-1);
            }
    		 if(!window.opener.closed){
                 window.opener.setParamRoleUser(userid, username,'<bean:write name="IGSYM0405Form" property="roleida"/>',orgid,orgname);
             }
             window.close();
  
    	}

    	 function setOrg(url){
       	   	 
 	    	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
 	    	if("_resetall"==temp){
 				document.forms[0].orgida.value = "";
 				document.forms[0].orgname.value = "";
 				return false;
 			}
 	    	if(null!=temp && temp.split("|").length>1){
 	    		document.forms[0].orgida.value = temp.split("|")[0];
 	    		document.forms[0].orgname.value = temp.split("|")[1];
 	    	}		

 	    }
	</script>
<body style="background-color: white; background-image: none;" onload="checkParent()">
<div id="maincontent">
<div id="contentainer">
<html:form styleId="form" action="/IGSYM0406"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">角色用户查询</p>
</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div><span>用户姓名:</span> <span> <html:text
		property="username" styleId="username"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" />
	</span>&nbsp;&nbsp;<span>所属机构:</span> <span> <html:text property="orgname_q" readonly="true" name="IGSYM0405Form" styleId="orgname"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" alt="选择机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" />
		<html:hidden property="orgida" name="IGSYM0405Form" styleId="orgida"/>&nbsp;&nbsp;</span><html:submit property="btn_search" styleClass="button" value="查询" /></div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
		<th width="10%"><label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteRoleid')"/> </label>
				</th>
			<th width="15%">用户ID</th>
			<th width="15%">所属机构</th>
			<th width="15%">用户姓名</th>
			<th width="12%">用户电话</th>
			<th width="12%">用户手机</th>
			<th width="21%">用户邮箱</th>
		</tr>
		<logic:present name="IGSYM04051VO" property="roleUserList">
			<logic:iterate id="bean" name="IGSYM04051VO" property="roleUserList"
				indexId="index">
				<tr >
				<td><input type="checkbox" name="deleteRoleid" value="${bean.userida}"/></td>
					<td>${bean.userida}</td>
					<td>${bean.orgname}<input type="hidden" name="orgid" value="${bean.orgida}"><input type="hidden" name="userorgname" value="${bean.orgname}"></td>
					<td>${bean.username}<input type="hidden" name="userid" value="${bean.userida}"><input type="hidden" name="user_name" value="${bean.username}"></td>
					<td>${bean.userphone}</td>
					<td>${bean.usermobile}</td>
					<td>${bean.useremail}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>

	<div class="enter">
	<logic:present name="IGSYM04051VO"
		property="roleUserList">
	<html:submit property="btn_delete" value="确认所选"
			styleClass="button" onclick="return deleteRec('deleteRoleid');" /></logic:present>
	<input id="parent" type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	<html:hidden property="roleida" name="IGSYM0405Form"/>
</html:form></div>
</div>
</body>
</html:html>