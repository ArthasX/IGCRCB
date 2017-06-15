<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM1904" toScope="request" />
<bean:define id="title" value="查询人员" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--

function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
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
//选择按钮 begin
function setParentValue(username,orgname,orgid,useremail,userphone,usermobile,userid){
    if(!window.opener.closed){
        window.opener.setIGCYB0101Params(username,orgname,orgid,useremail,userphone,usermobile,userid);
     }
    window.close();
}
//选择按钮 end
//清空begin
function clearParentValue(){
       if(!window.opener.closed){
           window.opener.setIGCYB0101Params("","","","","","");
        }
       window.close();
}
//清空end
//-->
</script><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<%-- <jsp:include page="/include/header2.jsp" /> --%>
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGSYM1905_Disp"
	onsubmit="return checkSubmit(this);">
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>&nbsp;&nbsp;机构：</span><html:text property="orgname" readonly="true" name="IGSYM0201Form"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="Org. select"/>
	<html:hidden property="orgidstr" name="IGSYM0201Form"/>
	<span>&nbsp;&nbsp;用户名：</span><span><html:text
		property="username_q" styleId="username_q"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" name="IGSYM0201Form"/>
	</span>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="5%">选择</th>
<!-- 				<th width="13%">User ID</th> -->
				<th width="15%">机构</th>
				<th width="12%">用户名</th>
				<th width="10%">电话</th>
				<th width="10%">手机</th>
				<th width="15%">邮箱</th>
				<th width="11%">描述</th>
			</tr>
			<logic:present name="IGSYM02011VO" property="userList">
				<logic:iterate id="bean" name="IGSYM02011VO"
					property="userList" indexId="index">
						<tr class="<ig:rowcss index="${index}"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,''); "
					onclick="setParentValue('${bean.username}','${bean.orgname}','${bean.orgid}','${bean.useremail}','${bean.userphone}','${bean.usermobile}','${bean.userid }')">
						<td>
							<img src="images/select_asset.gif" border="0" alt="Select" />
						</td>
						<td>${bean.orgname}</td>
						<td>${bean.username}</td>
						<td>${bean.userphone}</td>
						<td>${bean.usermobile}</td>
						<td>${bean.useremail}</td>
						<td>${bean.userdesc}</td>
			    		</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<!-- paging -->
	<jsp:include page="/include/paging.jsp" />
		<div class="enter">
		<input type="button" name="btn_clear" value="重置" onclick="clearParentValue()" class="button">
			<input type="button" class="button" value="关闭" onclick="window.close();">
		</div>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>