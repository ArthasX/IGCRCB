<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM04024" toScope="request"/>
<bean:define id="title" value="应急资源管理画面" toScope="request"/>
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
.conditions a:active {
	color:#0066cc;
}
.ellips{
	width:100%; 
	white-space:nowrap; 
	text-overflow:ellipsis; 
	overflow:hidden;
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
<body>
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
	<div id="contentWrap" style="padding-left: 11px;">
		<div id="treeNode">
			<div style="width:240px;float:left;border:0px; border:1px solid #BB0500;height:530px; ">
				<div class="conditions" >
					<div>
						<div class="titBox">应急资源分类</div>
						<div id="treeBox" style="height:480px;margin: 10px 0px 0px 10px;overflow:auto;"></div>
					</div>
<%-- 							<html:hidden property="ercode" styleId="ercode"/> --%>
						

				</div>
			</div>
			<div style="padding-left: 7px;float:left;">
			<iframe id="iframe" name="iframe" src="IGDRM0402_Search.do" width="730px" height="520px" frameborder="0"  style="padding-top: 10px;border:1px solid #BB0500;">
			</iframe>
			</div>
	</div>
</div>

<div class="zishiying"></div>
</div>
</div>
</body>
<script type="text/javascript">
//初始化
jQuery(function(){
	var nodeMap = eval('(${IGDRM04021VO.nodeMapJson})');
	if(document.getElementById) {
		var tree = new WebFXTree(nodeMap['000'].name);
		tree.eid = nodeMap['000'].id;
		tree.remark = nodeMap['000'].remark;
		tree.setBehavior('classic');

		for(var k in nodeMap['000'].childTreeNodeMap){
			loadTree(tree,nodeMap['000'].childTreeNodeMap[k]);
		}
		
		jQuery("#treeBox").html(tree.toString());
		tree.collapseAll(); 
		tree.expand(); 
		if(tree.childNodes[0]){
			tree.childNodes[0].select();
			jQ("#iframe").attr("src","IGDRM0402_Search.do?resourceType=${resourceType}&ercode="+tree.childNodes[0].eid+"&erid="+tree.childNodes[0].remark.split("_")[0]+"&esyscode="+tree.childNodes[0].remark.split("_")[1]+"_"+tree.childNodes[0].remark.split("_")[3]);
		} 
// 		console.log(nodeMap['000'].childTreeNodeMap['000001']);
// 		getSelNode(tree,jQuery("#ercode").val());
	}
	 //绑定树的点击事件
	 jQuery("#treeBox a").click(function(event){
			if (tree.getSelected()){
				jQ("#ercode",document.frames('iframe').document).val(tree.getSelected().eid);
				jQ("#erid",document.frames('iframe').document).val(tree.getSelected().remark.split("_")[0]);
				jQ("#esyscode",document.frames('iframe').document).val(tree.getSelected().remark.split("_")[1]+"_"+tree.getSelected().remark.split("_")[3]);
				jQ("#form",document.frames('iframe').document).submit();
			}
			event.stopPropagation();
	});
// 	 jQuery("#treeBox").click(function(){
// 		 getSelNode(tree,jQuery("#ercode").val());
// 	 });
});

function getSelNode(node,codeccid){
	if(!codeccid){
		node.select();
		return;
	}
	if(node.eid==codeccid) {
		if(node.eid.length<=6){
			node.expandAll();
		}else{
			returnParent6(node).expandAll();
		}
		if(node.childNodes.length>0){
			node.expandAll();
		}
		node.select();
	} else {
		for(var i=0;i<node.childNodes.length;i++){
			getSelNode(node.childNodes[i],codeccid);
		}
	}
}
function returnParent6(node){
	if(node.parentNode.eid.length==6){
		return node.parentNode;
	}else{
		
	return returnParent6(node.parentNode);
	}
}
function loadTree(parentNode,obj){
	if(obj.id!='000'){
		var newNode = new WebFXTreeItem(obj.name);
		newNode.eid = obj.id;
		newNode.remark = obj.remark;
		parentNode.add(newNode);
		if(obj.childTreeNodeMap){
			for(var k in obj.childTreeNodeMap){
				loadTree(newNode,obj.childTreeNodeMap[k]);
			}
		}
	}
}	
</script>
</html:html>