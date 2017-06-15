<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM01151" toScope="request"/>
<bean:define id="title" value="应急制度分类查询" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<link type="text/css" rel="stylesheet"	href="<html:rewrite forward='tree.css'/>">
<script src="<html:rewrite forward='tree.js'/>"></script>
<style type="text/css">

.conditions a img{
	border: 0px;
}
.conditions .hover{
	background-color: #d3d3d3;
	cursor: pointer;
}
.conditions .leftd{
	text-align: left;
}
.conditions .delFlag{
	display: none;
}
.conditions .titBox{
	background-color: #FFB1BB;
	font-size: 14px; 
	font-weight: bold;
	color:#fff;
	border-bottom: 1px solid #BB0500;
	line-height: 30px;
	height: 30px;
	text-indent: 10px;
}
.conditions a{
	text-decoration: none;
	color: #f00;
}
.conditions a:HOVER{
	text-decoration: none;
}
.conditions a:VISITED {
	color:#f00;
}
</style>
<!-- /header1 -->
<script type="text/javascript">
WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
WebCalendar.format     = "yyyy/mm/dd"; //回传日期的格式
WebCalendar.timeShow   = false;        //是否返回时间
WebCalendar.drag       = true;         //是否允许拖动
WebCalendar.darkColor  = "#014DB4";    //控件的暗色
WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
WebCalendar.wordColor  = "#000080";    //控件的文字颜色
WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色



function checkForm(){
	if($F('eiorgname').trim()=="") {
		alert("请选择所属机构！");
			return false;
	} else {
		return true;
	}
}
/**
 * 新增按钮点击事件
 *	弹出新增页面
 */
function addBtnHandle(){
	openSubWindow("/IGDEM0105_Add.do?eparcoding="+jQuery("eparcoding").val());
}
</script>
<body onLoad="">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container" style="width: 100%;">
	<!--content  右侧内容-->
	<div id="contentWrap">
		<div id="treeNode">
			<html:form styleId="form" action="/IGDRM0105_Search" onsubmit="">			
			
			<div id="search">
				<div class="img"></div>
				<div class="conditions">
					<div>
						<label>应急资源名称：</label>
						<html:text property="einame" styleId="einame" style="width:110px;"  errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp;
						<label>负责人：</label><html:text property="eiusername" styleId="eiusername" style="width:110px;" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp;
						<html:hidden property="eparcoding" styleId="eparcoding"/>
						<html:hidden property="eistatus" value="1"/>
						<html:submit property="btn_search" value="查询" styleClass="button" onclick=""/>
						<html:button property="btn_add" value="新增" styleClass="button" onclick=""/>
					</div>
				</div>
			</div>
			
			<div id="results_list">
				<ig:message/>
				<table width="100%" class="table_style">
<!-- 					header部 -->
					<tr>
						<th width="3%">
							<label>
								<input type="checkbox" class="delFlag" name="allbox" id="allbox" onclick="selectAll('allbox','deleteEiid')"/>
							</label>
						</th>
<!-- 						<th width="20%">应急资产编号</th> -->
						<th >应急资源名称</th>
<!-- 						<th>应急资产说明</th> -->
<!-- 						<th width="10%">负责人</th> -->
<!-- 						<th width="12%">登记日期</th> -->
<!-- 						<th width="10%">历史版本</th> -->
<!-- 						<th width="8%">修订</th> -->
<!-- 						<th width="8%">删除</th> -->
					</tr>
<!-- 					body部 -->
					<logic:present name="IGDRM011511VO" property="entityList" >
						<logic:iterate id="bean" name="IGDRM011511VO" property="entityList" indexId="index">
							<tr class="<ig:rowcss index="${index}"/>">
								<td>
									<html:checkbox property="deleteEiid" styleClass="delFlag" value="${bean.eiid}"/>
								<td>
									<div class="nowrapDiv" style="text-align: left;">
										<logic:empty name="bean" property="einame">&nbsp;</logic:empty>
										<html:link action="/IGDRM0401_Disp.do?eiid=${bean.eiid}" >${bean.einame}</html:link>
									</div>
								</td>
<!-- 								说明 -->
<!-- 								管理人 -->
								<td>
									<div class="nowrapDiv">
										<logic:empty name="bean" property="eiusername">&nbsp;</logic:empty>
										${bean.eiusername}
									</div>
								</td>
<!-- 								登记日期 -->
								<td>
									<div class="nowrapDiv">
										<logic:empty name="bean" property="eiinsdate">&nbsp;</logic:empty>
										${bean.eiinsdate}
									</div>
								</td>
<!-- 								历史版本 -->
								<td>
									<div class="nowrapDiv">
										<html:link action="/IGDRM0403_Disp.do?eiid=${bean.eiid}&civersion=&assertName=${IGDRM0502Form.assetsName}"><img src="images/notepad_16x16.gif" alt="历史版本" width="16" height="16"  border="0"/></html:link>
									</div>
								</td>
<!-- 								编辑 -->
								
<%-- 									<c:if test="${bean.ekey3=='editable'}"> --%>
										<td>
											<div align="center">
												<html:link action="/IGDRM0404_Disp.do?eiid=${bean.eiid}"><img src="images/edit.gif" alt="编辑" width="16" height="16"  border="0"/></html:link>
												</div>
										</td>
										<td>
											<div align="center">
												<a href="javascript:void(0);" onclick="doDel(this)" ><img src="images/delete_16x16.gif" alt="删除" width="16" height="16"  border="0"/></a>
											</div>
										</td>
										
							</tr>
						</logic:iterate>
					</logic:present>
				</table>
			</div>
			
			<div id="operate">
				<logic:present name="IGDRM01151VO" property="entityList" >
<%-- 				<html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec();" /> --%>
				</logic:present>
				<!-- paging -->
				<jsp:include page="/include/paging.jsp"/>
				<!-- /paging -->
			</div>
		</html:form>
	</div>
</div>

<div class="zishiying"></div>
</div>
</div>
</body>
<script type="text/javascript">

//初始化
// jQuery(function(){
// 	var nodeMap = eval('(${IGDRM01151VO.nodeMapJson})');
// 	//初始化树('999013')
// 	if(document.getElementById) {
// 		var tree = new WebFXTree(nodeMap['999070'].name);
// 		tree.eid = nodeMap['999070'].id;
// 		tree.setBehavior('classic');
		
// 		for(var k in nodeMap['999070'].childTreeNodeMap){
// 			loadTree(tree,nodeMap['999070'].childTreeNodeMap[k]);
// 		}
		
// 		jQuery("#treeBox").html(tree.toString());
// 		tree.collapseAll(); 
// 		tree.expand(); 
// 		getSelNode(tree,jQuery("#esyscoding").val());
// 	}
// 	 //绑定树的点击事件
// 	 jQuery("#treeBox a").click(function(event){
// 		 jQuery("#einame").val("");
// 			if (tree.getSelected()){
// 				if(tree.getSelected().eid=='999070'){
// 					document.getElementById("esyscoding").value = '';
// 				}else{
// 					document.getElementById("esyscoding").value = tree.getSelected().eid;
// 				}
// 				document.forms[0].submit();
// 			}
// 			event.stopPropagation();
			
// 	});
// 	 jQuery("#treeBox").click(function(){
// 		 getSelNode(tree,jQuery("#esyscoding").val());
// 	 });
// });

function getSelNode(node,codeccid){
	if(!codeccid){
		node.select();
		return;
	}
	if(node.eid==codeccid) {
		node.select();
		if(node.childNodes.length>0){
			node.expand();
		}
		document.getElementById("einame").focus();
	} else {
		for(var i=0;i<node.childNodes.length;i++){
			getSelNode(node.childNodes[i],codeccid);
		}
	}
}

function loadTree(parentNode,obj){
	//'999013'
	if(obj.id!='999070'){
		var newNode = new WebFXTreeItem(obj.name);
		newNode.eid = obj.id;
		parentNode.add(newNode);
		if(obj.childTreeNodeMap){
			for(var k in obj.childTreeNodeMap){
				loadTree(newNode,obj.childTreeNodeMap[k]);
			}
		}
	}
}	
function doDel(obj){
	obj = jQuery(obj);
	var message ='<bean:message key="IGCO10000.E002"/>';
	var confirmMsg ='确认删除？';
	if( window.confirm(confirmMsg)){
		obj.parent().parent().parent().find(":checkbox").attr("checked",true);
		form.action = getAppRootUrl() + "/IGDRM0402_Del.do";
		form.submit();
	}
}

function deleteRec(){
	
// 	alert();
	var frm = window.document.forms[0];
// 	alert(frm.deleteEiid);
	if(frm.deleteEiid) {
		if(frm.deleteEiid.length > 0){
			var bchecked = false;
			for(i=0; i<frm.deleteEiid.length; i++ ){
				if(frm.deleteEiid[i].checked == true) {
					bchecked = true;
				}
			}
			if(!bchecked) {
				alert(message);
				return false;
			}
		} else {
			if($("deleteEiid").checked == false) {
				alert(message);
				return false;
			}
		}
	} else {
		alert("没有可删除的数据！");
		return false;
	}
	
	if( window.confirm(confirmMsg)){
		form.action = getAppRootUrl() + "/IGASM0501_Del.do";
		return true;
	} else {
		return false;
	}
}
</script>
</html:html>