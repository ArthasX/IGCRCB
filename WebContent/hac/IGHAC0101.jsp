<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.deliverik.framework.tree.TreeNode"%>
<html:html>
<bean:define id="id" value="IGHAC0101" toScope="request" />
<bean:define id="title" value="HAC树状数据请求" toScope="request" />
<title><bean:write name="title"/></title>
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
.buttons{
	color:#FFFFFF;
	padding:1px 10px;
	font-size:12px;
	border:2px outset #EEEEEE;
	background-color: #CC0000;
	cursor: hand;
	height:20px;
	margin-left:60px;
}
</style>
<SCRIPT type="text/javascript">

	function initTree(sels, reloadDetail){
		var setting = {
				check: {
					enable: true,
					chkStyle: "checkbox",
					chkboxType: { "Y": "s", "N": "ps" }
				},
				edit: {
					},
				data: {
						key: {
							name: "name"
						},
						simpleData: {
							enable: true,
							idKey: "id",
							pIdKey: "pid",
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
	var zNodes = ${IGHAC01011VO.jsonstr};

	jQ14(document).ready(function(){
		initTree(null, true);
	});

	function g(id){
		return document.getElementById(id);
	}
	
	function  fun_getCheckValue(){  
	      var zTree = jQ14.fn.zTree.getZTreeObj("treeDemo");  
	          
	      var nodes=zTree.getChangeCheckedNodes(true);  
	      
	      var result='';  
          if(nodes.length>0){
        	  for (var i = 0; i < nodes.length; i++) {  
                  var halfCheck = nodes[i].getCheckStatus();  
                   if (!halfCheck.half){  
                	   if(nodes[i].pid!="0"){
                		   var treenode = zTree.getNodeByParam("id", nodes[i].pid, null);
                     	  if(treenode.pid!="0"){
                               result += treenode.id+'|'+treenode.name+'|'+nodes[i].id +'|'+nodes[i].name+','; 
                     	  }
                	   }
                   }  
                
              }  
    	      result=result.substring(0,result.lastIndexOf(","));  
    	      window.returnValue = result;
          }else{
        	  window.returnValue = "_resetall";
          }
          
	      window.close();
	      
	    }  
</SCRIPT>
<body>
	<div id="maincontent">
	<!--container 左菜单 右侧内容-->
		<div id="container">
		<div id="contentWrap">
        <div id="content">
			<div id="treeNode" >
			
						<div style="width:300px;float:left;margin-left:50px;margin-top:30px;height:400px;overflow:auto;">
							<div class="conditions" style="height:400px;" >
								<div>
									<ul id="treeDemo" class="ztree"></ul>
								</div>
							</div>
						</div>
					<div style="width:300px;float:left;margin-left:50px;height:50px;">
						<input onclick="fun_getCheckValue()" type="button" class="buttons" value="确定">
						<input onclick="javascript:window.close()" type="button"  class="buttons" value="取消">
						<!-- <input onclick="resetType()" type="button"  class="button" value="清空"> -->
					</div>
			</div>
		</div>
		<div class="zishiying"></div>
		</div>
		</div>
	</div>
</body>
</html:html>
