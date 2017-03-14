<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0402" toScope="request"/>
<bean:define id="title" value="应急制度分类管理" toScope="request"/>
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
</script>
<body onLoad="">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
	<div id="location">
		<div class="image"></div>
		<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
	</div>
	<!--content  右侧内容-->
	<div id="contentWrap">
		<div id="treeNode">
			<html:form styleId="form" action="/IGDRM0105" onsubmit="">			
			<div style="width:240px;float:left;border:0px; border:1px solid #BB0500;height:530px; ">
				<div class="conditions" >
					<div>
						<div class="titBox">应急制度分类</div>
						<div id="treeBox" style="height:480px;margin: 10px 0px 0px 10px;overflow:auto;"></div>
					</div>
					<html:hidden property="esyscoding" styleId="esyscoding"/>
				</div>
			</div>
			
			<div id="content"  style="width:730px;float:left; border:1px solid #BB0500;height:530px; margin-left: 10px;">
				<iframe name="dataFrame" id ="dataFrame" frameborder="0"  width="100%" height="100%" >
				
				
				</iframe>
			
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
jQuery(function(){
	
	jQuery("#dataFrame").attr("src",getAppRootUrl()+"/IGDRM0105_Search.do?eparcoding=999070");
	var nodeMap = eval('(${IGDRM01151VO.nodeMapJson})');
	//初始化树('999013')
	if(document.getElementById) {
		var tree = new WebFXTree(nodeMap['999070'].name);
		tree.eid = nodeMap['999070'].id;
		tree.setBehavior('classic');
		
		for(var k in nodeMap['999070'].childTreeNodeMap){
			loadTree(tree,nodeMap['999070'].childTreeNodeMap[k]);
		}
		
		jQuery("#treeBox").html(tree.toString());
		tree.collapseAll(); 
		tree.expand(); 
		getSelNode(tree,jQuery("#esyscoding").val());
	}
	 //绑定树的点击事件
	 jQuery("#treeBox a").click(function(event){
		 jQuery("#einame").val("");
			if (tree.getSelected()){
// 				if(tree.getSelected().eid=='999070'){
// 					document.getElementById("esyscoding").value = '';
// 				}else{
// 					document.getElementById("esyscoding").value = tree.getSelected().eid;
// 				}
// 				document.forms[0].submit();
				window.frames[1].document.form.eparcoding.value = tree.getSelected().eid;
				window.frames[1].document.form.submit();
			}
			event.stopPropagation();
			
	});
	 jQuery("#treeBox").click(function(){
		 getSelNode(tree,jQuery("#esyscoding").val());
	 });
});

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