<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM2002" toScope="request" />
<bean:define id="title" value="章节信息维护" toScope="request" />
<!-- start header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- end header1 -->
<link rel="stylesheet" href="css/ztree/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="js/ztree/jquery-1.4.4.min.js"></script>
<script>
var jQ14 = jQuery.noConflict(true);
</script>
<script type="text/javascript" src="js/ztree/jquery.ztree.core.js"></script>
<script type="text/javascript" src="js/ztree/jquery.ztree.excheck.js"></script>
<script type="text/javascript" src="js/ztree/jquery.ztree.exedit.js"></script>
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
.ellips{
	width:100%; 
	white-space:nowrap; 
	text-overflow:ellipsis; 
	overflow:hidden;
}
</style>
<SCRIPT type="text/javascript">
	<!--
	function initTree(sels, reloadDetail){
		var setting = {
				
				edit: {
					},
				data: {
						key: {
							name: "cname"
						},
						simpleData: {
							enable: true,
							idKey: "cid",
							pIdKey: "pcid",
							rootPId: "0"
						}
					},
					callback: {
						beforeClick: zTreeOnBeforeClick,
						onClick: zTreeOnClick					
					}
				
			};
		jQ14.fn.zTree.init(jQ14("#treeDemo"), setting, zNodes);
		var treeObj = jQ14.fn.zTree.getZTreeObj("treeDemo"); 
		treeObj.expandAll(true); 
		if(sels != null && sels.length != null && sels.length > 0){
			var node = treeObj.getNodeByParam('cid', sels[0].cid);
			if(node == null){
				var nodes = treeObj.getNodes();
				if(nodes.length != null && nodes.length > 0){
					node = nodes[0];
				}else{
					jQ14('#IndexContext').attr("src","");
					return;
				}
			}
			treeObj.selectNode(node);
			if(reloadDetail){
				clickNode(treeObj, node);
			}
		}else{
			var nodes = treeObj.getNodes();
			if(nodes.length != null && nodes.length > 0){
				treeObj.selectNode(nodes[0]);
				if(reloadDetail){
					clickNode(treeObj, nodes[0]);
				}
			}else{
				jQ14('#IndexContext').attr("src","");
			}
		}
	}
	
	function clickNode(treeObj,node){
		treeObj.setting.callback.onClick(null, treeObj.setting.treeId, node);//触发函数
	}
	
	function zTreeOnBeforeClick(event, treeId, treeNode){
		var chl = g('IndexContext');
		if(chl.contentWindow.hasNewNode){
			if(!confirm("当前有未保存的节点信息，继续将导致信息丢失！是否继续？")){
				return false;
			}
		}
		return true;
	}
	
	function zTreeOnClick(event, treeId, treeNode) {
		var param = '?pcid=' + treeNode.cid;
		if(!treeNode.cattach){
			param += '&eid=' + treeNode.eid;
		}
		jQ14('#IndexContext').attr("src","IGDRM2003_Disp.do" + param);
	};
	var zNodes = ${IGDRM20021VO.planSectionTreeJson}
	jQ14(document).ready(function(){
		initTree(null, true);
	});
	function reflashTree(reloadDetail){
		var treeObj = jQ14.fn.zTree.getZTreeObj("treeDemo");
		var sels = treeObj.getSelectedNodes();
		(function(ss){
			jQuery.ajax({
				url:"IGDRM2002_Ajax.do",
				type:"POST",
				dataType :"json",
				data:{},
				cache:false,
				success:function(res){
					zNodes = res;
					initTree(ss, reloadDetail);
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					alert('出错了');
				}
			});
			
		})(sels);
	}
	
	function g(id){
		return document.getElementById(id);
	}
	//-->
</SCRIPT>
<body>
	<div id="maincontent">
	<!--header  头部和 一级菜单-->
	<jsp:include page="/include/header2.jsp" />
	<!--container 左菜单 右侧内容-->
		<div id="container">
		<div id="contentWrap">
        <div id="content">
			<div id="location">
				<div class="image"></div>
				<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
				<div class="back"><html:link href="IGDRM2004_Back.do">返回</html:link></div>
			</div>
			<br>
			<div id="treeNode" >
				<div style="width:240px;float:left;border:0px; border:1px solid #BB0500;height:550px;overflow:auto;">
					<div class="conditions" style="height:550px;" >
						<div>
							<div class="titBox">文档大纲</div>
							<ul id="treeDemo" class="ztree"></ul>
						</div>
						<html:hidden property="esyscoding" styleId="esyscoding" value="${IGDRM0402Form.ercode}"/>
					</div>
				</div>
				<div id="content" style="width:730px;float:left; border:1px solid #BB0500;height:550px; margin-left: 10px;">
					<iframe id="IndexContext" name="IndexContext" style="width:100%;height:100%;" frameborder="0"></iframe>
				</div>
			</div>
		</div>
		<div class="zishiying"></div>
		</div>
		</div>
	</div>
</body>
</html:html>
