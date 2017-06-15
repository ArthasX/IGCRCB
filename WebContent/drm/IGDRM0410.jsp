<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0410" toScope="request"/>
<bean:define id="title" value="应急资源树" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<link type="text/css" rel="stylesheet"	href="<html:rewrite forward='tree.css'/>">
<script src="<html:rewrite forward='tree.js'/>"></script>
<style type="text/css">
html {
   overflow-x: hidden;
   overflow-y: auto;    
}
body {
	font-size: 12px;
	color: #0066CC;
	background-color: #FFFFFF;
	margin-top: 10px;
	margin-left: 20px;
}

</style>
<!-- /header1 -->
<body >
<table width="300" align="center">
	<tr>
	<div id="treeBox" ></div>
	</tr>
	<tr>
		<td align="right"><br>
		<br>
		<input onclick="choiceNode()" type="button"  class="button" value="确定"></td>
		<td align="left"><br>
		<br>
		<input onclick="javascript:window.close()" type="button"  class="button" value="取消">
		<input onclick="resetType()" type="button"  class="button" value="清空">
		</td>
		
	</tr>
</table>
<!-- 	<input type="hidden" id="esyscoding" name="esyscoding" /> -->
	<input type="hidden" name="ercode" id="ercode" />
	<input type="hidden" name="erid" id="erid" />
	<input type="hidden" name="ername" id="ername" />
</body>
<script type="text/javascript">
var tree ;
//初始化
jQuery(function(){
	jQuery("#erid").val("");
	jQuery("#ercode").val("");
	var nodeMap = eval('(${IGDRM04021VO.nodeMapJson})');
	//初始化树('999013')
	if(document.getElementById) {
		tree = new WebFXTree(nodeMap['000'].name.split("(")[0]);
		tree.eid = nodeMap['000'].id;
		tree.name = nodeMap['000'].name;
		tree.remark = nodeMap['000'].remark;
		tree.setBehavior('classic');
		
		for(var k in nodeMap['000'].childTreeNodeMap){
			loadTree(tree,nodeMap['000'].childTreeNodeMap[k]);
		}
		
		jQuery("#treeBox").html(tree.toString());
		tree.collapseAll(); 
		tree.expand(); 
		getSelNode(tree,jQuery("#ercode").val());
	}
	 //绑定树的点击事件
	 jQuery("#treeBox a").click(function(event){
			if (tree.getSelected()){
				if(tree.getSelected().eid=='000'){
					jQuery("#erid").val("1");
					jQuery("#ername").val("应急资源");
					document.getElementById("ercode").value = '000';
				}else{
					jQuery("#erid").val(tree.getSelected().remark);
					jQuery("#ername").val(tree.getSelected().name);
					document.getElementById("ercode").value = tree.getSelected().eid;
				}
// 				document.forms[0].submit();
			}
			event.stopPropagation();
			
	});
	 jQuery("#treeBox").click(function(){
		 getSelNode(tree,jQuery("#ercode").val());
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
		jQuery("#ercode").val(codeccid);
		jQuery("#erid").val(node.remark);
	} else {
		for(var i=0;i<node.childNodes.length;i++){
			getSelNode(node.childNodes[i],codeccid);
		}
	}
}

function loadTree(parentNode,obj){
	//'999013'
	if(obj.id!='000'){
		var newNode = new WebFXTreeItem(obj.name.split("(")[0]);
		newNode.eid = obj.id;
		newNode.name = obj.name;
		newNode.remark = obj.remark;
		parentNode.add(newNode);
		if(obj.childTreeNodeMap){
			for(var k in obj.childTreeNodeMap){
				loadTree(newNode,obj.childTreeNodeMap[k]);
			}
		}
	}
}	

//鼠标双击事件
// tree.expandRootChildren();
document.ondblclick=choiceNode;

function choiceNode(){
	if (jQuery("#erid").val()){
		selectType(jQuery("#erid").val(),jQuery("#ername").val().split("(")[0],jQuery("#ercode").val());
	}else{
		alert("请选择应急资源模型！");
	}
}
function selectType(id,name,ercode){
	
	window.returnValue = id + "|" +name + "|" +ercode;
	window.close();
}
function resetType(){
	window.returnValue = "_resetall";
	window.close();
}
</script>
</html:html>