<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0121" toScope="request"/>
<bean:define id="title" value="关系查询画面" toScope="request"/>
<style>
html,body {
   margin-top:0;
   padding:0;
   height:100%;
   font-size: 12px;
   overflow-x:hidden;
   overflow-y:hidden;
   background-image: url(images/maincontent.jpg);
	background-repeat: repeat-x;
}
#maincontent{
    min-height:100%;
    _height:100%;
    position: relative;
    min-width:1002px;
    background-image: url(images/maincontent.jpg);
	background-repeat: repeat-x;
}

#container{
    margin:0 auto;
    width:1002px;
    background-color: #FFFFFF;
    
} 
#contentWrap{
	margin-right:-240px;
	float:right;
	width:100%;
	margin-top: 10px;
}

#content{
    margin-right:240px;
}
#location {
	height: 25px;
	width: 98%;
	border-bottom: 2px solid #6699CC;
	margin: 0px auto;

}
#location .image {
	background-image: url(images/location_img.gif);
	background-repeat: no-repeat;
	float: left;
	height: 13px;
	width: 12px;
	margin-right: 8px;
	margin-left: 2px;
	margin-top: 6px;
}
#location .fonts1 {
	font-weight: bold;
	overflow: hidden;
	margin-top: 3px;
	font-size: 12px;
	line-height: 20px;
	color: #000000;
	float: left;
}
</style>

<link rel="stylesheet" href="css/ztree/demo.css" type="text/css"></link>
<link rel="stylesheet" href="css/ztree/zTreeStyle/zTreeStyle.css" type="text/css"></link>
<script src="<html:rewrite forward='common.js'/>"></script>
<script type="text/javascript" src="js/ztree/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/ztree/jquery.ztree.core-3.4.js"></script>
<script type="text/javascript">
var setting = {
		view: {
			selectedMulti: false,
			fontCss: getFontCss,
			showIcon: true
		},
		async: {
			enable: true,
			url:getAppRootUrl() + ajaxAction,
			autoParam:["id=nid", "name=nname"],
			otherParam:{"type":"getContainTreeNode"},  
			dataFilter: null
		},
		callback: {
			beforeClick: beforeClick, 
			beforeAsync:beforeAsync,
			onAsyncSuccess:onAsyncSuccess
			//onClick:ztreeOnClick
		},
		data: {
			simpleData: {
				enable: true
			}
		}
	};
	var zNodes =${IGCIM01371VO.initTreeStr};
	function filter(treeId, parentNode, childNodes) {
		if (!childNodes) return null;
		return childNodes;
		
	}
	function ztreeOnClick(treeId, treeNode){
	}
	function beforeClick(treeId, treeNode) {
		var nlv=treeNode.level;
		var nid=treeNode.id; 
		if(nlv>0){//判断不是第一个结点
			var idArr=nid.split("_");
			var idTypeFlag=idArr[0];
			if(idTypeFlag==1){
				$('#IndexContext').attr("src","IGCIM0138_Disp.do?eiid=" + idArr[1] + "&civersion=" + idArr[3] +"&cismallversion=" + idArr[4]);
			}
		}
	}
	function onAsyncSuccess(msg){

	} 


	//
	function beforeAsync(treeId, treeNode){
		var nlv=treeNode.level;
		var nid=treeNode.id;
		if(nlv>0){//判断不是第一个结点
			return true;
		}else{
			return false;
		}
	}
	//搜索功能  ---ylq修改为精确查询
	var nodeList=[];//搜索结点集合
	var lastValue="";//上次搜索内容
	function onSearch(type){//type 1为本页搜索，0为传值
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		var str="";
		var nodes=null;
		if(type==0){//为0获取传值的searchName
			str="${IGCIM01371VO.initNodeID}";
			nodes = zTree.getNodesByParam("id", str, null);
		}else{//获取本页所有的值
			str=$("#key").val();
			nodes = zTree.getNodesByParamFuzzy("name", str, null);
		}
		if(lastValue!=null&&lastValue!=''){
			updateNodes(false);
		}
		if(str==null||str==''){
			lastValue=str;
			return ;
		}
		lastValue=str;
		nodeList=nodes;
		updateNodes(true,type);
	}
	//修改结点样式
	function updateNodes(highlight,type) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo");
		for( var i=0, l=nodeList.length; i<l; i++) {
			//判断是否是第二结点
			var level=nodeList[i].level;
			if(level==0){
				nodeList[i].highlight = highlight;
				zTree.updateNode(nodeList[i]);
				if(type==0){
					//zTree.selectNode(nodeList[i],false);
					if(i==0){
						var curNodes=nodeList[i].children;
						for(var j=0;j<curNodes.length;j++){
								zTree.selectNode(curNodes[j],false);
								beforeClick(curNodes[j].id,curNodes[j]); 
						}
					}
				}
			}
			else if(level==1){ 
				nodeList[i].highlight = highlight;
				zTree.updateNode(nodeList[i]);
				zTree.selectNode(nodeList[i],false);
				zTree.cancelSelectedNode(nodeList[i]);
			}
		}
	}
	//样式
	function getFontCss(treeId, treeNode) {
		return (!!treeNode.highlight) ? {color:"red", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
	}

	function refreshNode(e) {
		var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
		type = e.data.type,
		silent = e.data.silent,
		nodes = zTree.getSelectedNodes();
		if (nodes.length == 0) {
			alert("请先选择一个父节点");
		}
		for (var i=0, l=nodes.length; i<l; i++) {
			zTree.reAsyncChildNodes(nodes[i], type, silent);
			if (!silent) zTree.selectNode(nodes[i]);
		}
		
	}
	function initTree(){
		$.fn.zTree.init($("#treeDemo"), setting,zNodes);
		$("#refreshNode").bind("click", {type:"refresh", silent:false}, refreshNode);
		onSearch(1);//设置初始化
	}
</script>
<link rel="stylesheet" type="text/css" href="css/ztree/icon.css" ></link>
<body onload="initTree()">
<div id="maincontent">
<div id="container" >
<div style="float: left;">
		<ul id="treeDemo" class="ztree" style="height:530px;width: 370px"></ul>
</div>

<iframe name="IndexContext" id="IndexContext" width="600" height="620" frameborder="0" scrolling="auto" src="IGCIM0138_Disp.do?eiid=${IGCIM0137Form.eiid}&civersion=${IGCIM0137Form.eiversion}&cismallversion=${IGCIM0137Form.eismallversion}&flag=${IGCIM0137Form.flag}&assetRoleType='IGCI01'"></iframe>
</div>
</div>
</body>
</html:html>
