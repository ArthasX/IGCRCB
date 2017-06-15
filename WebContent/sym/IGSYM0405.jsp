<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0405" toScope="request" />
<bean:define id="title" value="角色用户查询画面" toScope="request" />
<%
	String path = request.getParameter("path");
	String cog="";
	cog=(String)session.getAttribute("cog");
	
%>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
        function setParentValue(userid, username,orgid,orgname,usermobile){
            if(document.forms[0].flag.value == "1"){
                if(!window.opener.closed){
                    window.opener.setParamRoleUser(userid, username,'<bean:write name="IGSYM0405Form" property="roleida"/>',orgid,orgname,usermobile,'<%=cog %>');
                }
            }else{
                if(!window.opener.closed){
                    window.opener.setParamRoleUser(userid, username,'<bean:write name="IGSYM0405Form" property="roleida"/>',orgid,orgname,'<%=cog %>');
                }
            }
            window.close();
        }
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
<html:form styleId="form" action="/IGSYM0405"
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
	</span>&nbsp;&nbsp;<span>所属机构:</span> <span> <html:text property="orgname" readonly="true" name="IGSYM0405Form" styleId="orgname"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" alt="选择机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" />
		<html:hidden property="orgida" name="IGSYM0405Form" styleId="orgida"/>&nbsp;&nbsp;</span><html:submit property="btn_search" styleClass="button" value="查询" /></div>
	</div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="10%">用户ID</th>
			<th width="10%">所属机构</th>
			<th width="10%">用户姓名</th>
			<!--				<th width="8%">用户状态</th>-->
			<th width="10%">用户电话</th>
			<th width="10%">用户手机</th>
			<th width="15%">用户邮箱</th>
			<th width="10%">工作数量</th>
			<th width="15%">工作内容</th>
		</tr>
		<logic:present name="IGSYM04051VO" property="desplayVOList">
			<logic:iterate id="bean" name="IGSYM04051VO" property="desplayVOList"
				indexId="index">
				<tr
					<%if((null != path || "system".equals(path)) && !"strategy".equals(path)){ %>
					<%}else{%> onmouseover="mouseOver(this);"
					onmouseout="mouseOut(this,'');"
					onclick="setParentValue('${bean.userida}','${bean.username}','${bean.orgida}','${bean.orgname}','${bean.usermobile}')"
					<%} %>>
					<td>${bean.userida}</td>
					<td>${bean.orgname}</td>
					<td>${bean.username}</td>
					<!--						<td>${bean.userstatus}</td>-->
					<td>${bean.userphone}</td>
					<td>${bean.usermobile}</td>
					<td>${bean.useremail}</td>
					<td>${bean.workCount}</td>
					<td>
						<logic:iterate id="prBean" name="bean" property="processRecordInfoList">
							<bean:write name="prBean" property="prtitle" /><br />
						</logic:iterate>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<div class="enter">
	<input id="parent" type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	<html:hidden property="roleida"  name="IGSYM0405Form" styleId="roleida"/>
	<html:hidden property="roletype"  name="IGSYM0405Form" styleId="roletype"/>
	<html:hidden property="flag"  name="IGSYM0405Form" styleId="flag"/>
</html:form></div>
</div>
</body>
</html:html>