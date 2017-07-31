<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGZWJ0103" toScope="request" />
<bean:define id="title" value="查询人员" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--

jQuery(function(){
	var orgname = document.forms[0].orgname.value;
	if(orgname==""){
		document.forms[0].orgname.value = "总行机构-信息科技部";
	}
})

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
function setParentValue(){
    if(!window.opener.closed){
    	var userid ="";	//定义userid
    	//获取userid长度
    	var idLen = jQuery(":checked").siblings("input[uid='userid']").length;
    	//循环获取userid
    	jQuery(":checked").siblings("input[uid='userid']").each(function(i,t){
    		userid += jQuery(this).val()+"、";
    	})
    	//处理掉最后一个、
    	if(idLen>0){
    		userid = userid.substr(0,userid.length-1);
    	}
    	
    	var username ="";	//定义username
    	//获取username长度
    	var nameLen = jQuery(":checked").siblings("input[uname='username']").length;
    	//循环获取username
    	jQuery(":checked").siblings("input[uname='username']").each(function(i,t){
    		username += jQuery(this).val()+"、";
    	})
    	//处理掉最后一个、
    	if(nameLen>0){
    		username = username.substr(0,username.length-1);
    	}
    	if(userid && username){
	        window.opener.setIGZWJ0103Params(userid,username);
		    window.close();
    	}else{
    		alert("请至少选择一个用户！");
    	}
     }
}
//选择按钮 end
//清空begin
function clearParentValue(){
       if(!window.opener.closed){
           window.opener.setIGZWJ0103Params("","");
        }
       window.close();
}
//清空end

//全选
function doSelectAll(name,obj){
	selectAll(name,obj);
	var checks = document.getElementsByName(obj);
// 	for(var i=0;i < checks.length;i++){
// 		selectUserItem(checks[i]);
// 	} 
}

//-->
</script><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<%-- <jsp:include page="/include/header2.jsp" /> --%>
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGZWJ0101_Open" onsubmit="return checkSubmit(this);">
<!-- <div id="location"> -->
<!-- <div class="image"></div> -->
<%-- <p class="fonts1"><ig:navigation /></p> --%>
<!-- </div> -->
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
<%-- 	<span>用户ID：</span><span><html:text property="userid_q" styleId="userid_q" --%>
<%-- 		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" /> --%>
<!-- 	</span> -->
	
	<span>&nbsp;&nbsp;机构：</span><html:text property="orgname" readonly="true" name="IGZWJ0101Form"></html:text>
		<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_CONDTREE.do?orgid=0002001017');" alt="Org. select"/>
	<html:hidden property="orgidstr" name="IGZWJ0101Form"/>
	<span>&nbsp;&nbsp;用户名：</span><span><html:text
		property="username_q" styleId="username_q"
		errorStyleClass="inputError imeDisabled" size="15" maxlength="16" name="IGZWJ0101Form"/>
	</span>
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="5%">
					<input type="checkbox" name="checkbox" id="checkbox" onclick="doSelectAll('checkbox','ckbox')"/>
				</th>
				<th width="15%">机构</th>
				<th width="12%">用户名</th>
				<th width="10%">电话</th>
				<th width="10%">手机</th>
				<th width="15%">邮箱</th>
				<th width="11%">描述</th>
			</tr>
			<logic:present name="IGZWJ01011VO" property="userList">
				<logic:iterate id="bean" name="IGZWJ01011VO"
					property="userList" indexId="index">
					<tr>
						<td>
<%-- 							<html:multibox property="userid" onclick="selectUserItem(this)"/> --%>
							<input type="checkbox" name="ckbox"/>
							<input type="hidden" uid="userid" value="${bean.userid}"/>
							<input type="hidden" uname="username" value="${bean.username}"/>
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
		<input type="button" name="btn_clear" value="选择" onclick="setParentValue()" class="button">
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