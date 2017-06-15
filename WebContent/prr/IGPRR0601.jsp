<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGPRR0601" toScope="request" />
<bean:define id="title"	value="工作查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
.queryBox{
	width:25%;
	height:30px;
	float:left;
}
.queryBox span{
	display: block;
	height:30px;
	line-height: 30px;
	float: left;
	width:100px;
	text-align: right;
}
.edit_table_style{    
    margin:0 auto;    
    border-collapse:collapse;     
    text-align:right; 
    table-layout:fixed;  

}    
.edit_table_style th{ 
	color:#000000;   
    border-top:1px solid #CCCCCC;
    border-bottom:1px solid #CCCCCC;
    background-color:#EEEEEE;
    height:20px;      
}  
.edit_table_style td{ 
	border-bottom:1px solid #D3D3D3;
    height:18px;
    word-break: break-all; 
    word-wrap:break-word;   
    text-align: center;
}   
</style>
<script type="text/javascript">
var roleObj = null;
function changeDateOrTimeForQueryValue(obj){
	var name = jQuery(obj).attr("name");
	var $valueObj = jQuery(obj).parent().find("input[name='queryValue']");
	var value = $valueObj.val();
	var v1 = "";
	var v2 = "";
	if(value){
		var split = value.split("#");
		v1 = split[0];
		if(split.length > 1){
			v2 = split[1];
		}
	}
	if(name == "qv1"){
		$valueObj.val(obj.value + "#" + v2);
	}else{
		$valueObj.val(v1 + "#" + obj.value);
	}
}
function selectTree(obj,ccidinfo){
	var ccid = ccidinfo.split("_tree_")[0];
	var url = "IGSYM1505_TREE.do" + "?ccid="+ccid;
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		jQuery(obj).val("");
		jQuery(obj).parent().find("input[name='queryValue']").val("");
	}else if(null!=temp && temp.split("|").length>1){
		var id = temp.split("|")[0];
		var name = temp.split("|")[1];
		var treesyscode = "";
		
		if(id.split("_").length>2){
			treesyscode = id.split("_")[2];
		}else{
			treesyscode = "";
		}
		if(treesyscode!=null && name!=null && treesyscode != ''){
			jQuery(obj).val(name);
			jQuery(obj).parent().find("input[name='queryValue']").val(treesyscode + "_tree_" + name);
		}else{
			jQuery(obj).val("");
			jQuery(obj).parent().find("input[name='queryValue']").val("");
		}
		
	}	
}
function selectOrgTree(obj){
	var temp = window.showModalDialog('IGSYM0101_ROLETREE.do',null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		jQuery(obj).val("");
		jQuery(obj).parent().find("input[name='queryValue']").val("");
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		jQuery(obj).val(temp.split("|")[1]);
		jQuery(obj).parent().find("[name='queryValue']").val(temp.split("|")[0]+"_OrgTree_"+temp.split("|")[1]);
	}
}

function selectRoleOnIGSYM0306(obj,pdid){
    openSubIGSYM0306(pdid);
    roleObj = obj;
}
function setRoleParams(roleid,rolename){
	if(roleid != ""){
		jQuery(roleObj).val(rolename);
		jQuery(roleObj).parent().find("input[name='queryValue']").val(roleid + "_role_" + rolename);
	}else{
		jQuery(roleObj).val("");
		jQuery(roleObj).parent().find("input[name='queryValue']").val("");
	}
	roleObj = null;
}
jQ(document).ready(function(){
	jQ("#btn_search").click(function(){
		form.action = "IGPRR0601.do";
		form.submit();
	});
	jQ("#btn_export").click(function(){
		form.action = "IGPRR0601_Export.do";
		form.submit();
	});
});
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRR0601.do" onsubmit="return checkSubmit(this);">
<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	<ig:ProcessBackUrlTag jump="${jump}"/>
</div>
<div id="search" style="width:1005px;">
	<div class="img" style="margin-left: 5px;"></div>
	<div class="conditions" style="width:935px;">
		<logic:present name="AD_ProcessQuery">
			<logic:iterate id="bean" name="AD_ProcessQuery" indexId="index">
			<div class="queryBox"
				<logic:equal value="bt" name="bean" property="qmode">
					style="width:480px;"
				</logic:equal>
			>
				<ig:processQuery name="bean" index="${index }"/>
			</div>
			</logic:iterate>
		</logic:present>
		<div class="queryBox" align="center" style="float: right;">
			<html:button property="btn_search" styleId="btn_search" styleClass="button" value="查询"/>
			<html:button property="btn_export" styleId="btn_export" styleClass="button" value="导出"/>
		</div>
	</div>
</div>
<div id="results_list" style="overflow-x:auto;overflow-y: hidden; "><!--  message --> <ig:message /> <!--  /message -->
	<logic:present name="AD_ProcessQueryTitle">
		<table class="edit_table_style" style="width:100%;">
			<tr>
			<logic:iterate id="bean" name="AD_ProcessQueryTitle">
				<th width="${bean.width }">${bean.sname }</th>
			</logic:iterate>
			</tr>
			<logic:present name="IGPRR06011VO" property="result">
				<logic:iterate id="map" name="IGPRR06011VO" property="result">
					<tr onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=${map.PRID}&jump=500');" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);">
						<logic:iterate id="entry" name="map">
							<logic:notEqual value="PRID" name="entry" property="key">
								<td>${entry.value }</td>
							</logic:notEqual>
						</logic:iterate>
					</tr>
				</logic:iterate>
			</logic:present>
		</table>
		<div id="operate">
			<jsp:include page="/include/paging.jsp" />
		</div>
	</logic:present>
	<br/>
</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>