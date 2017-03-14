<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.deliverik.framework.tree.TreeNode"%>
<%@ page import="com.deliverik.infogovernor.sym.bl.IGSYM03BLImpl"%>
<html:html>
<bean:define id="id" value="IGSYM0100" toScope="request" />
<bean:define id="title" value="机构列表" toScope="request" />
<bean:define id="treemap" name="IGSYM01011VO" property="treeNodeMap" type="java.util.Map" />
<title><bean:write name="title"/></title>
<!-- 业务连续性 drm -->
<base target="_self" />
<style>
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
.button{
	color:#FFFFFF;
	padding:1px 10px;
	font-size:12px;
	border:2px outset #EEEEEE;
	background-color: #6699CC;
	cursor: hand;
	height:20px;
}
</style>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="js/jquery-1.4.4.min.js"></script>
<script type="text/javascript" src="js/jquery.ztree.core-3.2.js"></script>
<script type="text/javascript" src="js/jquery.ztree.excheck-3.2.js"></script>
<link rel="stylesheet" href="css/ztree/demo_drm.css" type="text/css">
<link rel="stylesheet" href="css/ztree/zTreeStyle/zTreeStyle_drm.css" type="text/css">
<%!
	ArrayList<String> treeIdCounter=new ArrayList<String>();//机构id信息读取位置计数器
	ArrayList<String> treeNameCounter=new ArrayList<String>();//机构name信息读取位置计数器
	String treePIdCounter= "0";//上级机构id信息读取位置计数器
	ArrayList<String> treeWriter=new ArrayList<String>();//信息读取位置计数器
	String jsonTree = "";
	StringBuffer buffer = null;
%>
<%!
	public void writeJS (String lastNode,Map<String,TreeNode> treeNodeMap){
		if(treeNodeMap!=null&&!treeNodeMap.isEmpty()){			
			if(treeNodeMap.keySet()!=null&&!treeNodeMap.keySet().isEmpty()){
					Iterator<String> it=treeNodeMap.keySet().iterator();
					while(it.hasNext()){
						Object obj = it.next();
						String key=(String)obj;	
						TreeNode treeNode=(TreeNode)treeNodeMap.get(key);
						treeWriter.add("{\"id\":"+key+",\"pId\":"+lastNode+",\"fullName\":\""+treeNode.getName()+"\",\"name\":\""+(treeNode.getName().lastIndexOf("/")<0?treeNode.getName():treeNode.getName().substring(treeNode.getName().lastIndexOf("/")+1))+"\"},");
						writeJS(key,treeNode.getChildTreeNodeMap());
					}
			}
		}
	}
   public void writeJSON(){
		if(treeWriter!=null&&!treeWriter.isEmpty()){
			buffer = new StringBuffer("");
			String temp = null;
			for(int i=0;i<treeWriter.size();i++){
				temp = (String)treeWriter.get(i);
				if(i==0){
					buffer.append("["+temp);
				}else if(i == treeWriter.size()-1){
					buffer.append(temp.substring(0,temp.length()-1)+"]");
				}
				else{
					buffer.append(temp);
				}
			}
			jsonTree = buffer.toString();
		}
   }
%>

<body>
<ig:message />
<%if(!treemap.isEmpty()){ 
	treeWriter.clear();
	writeJS("0",treemap);
	writeJSON(); 
%>
<script type="text/javascript">
    var tempJSON = '<%=jsonTree%>';
    var zNodes =  eval("(" + tempJSON + ")");  
    var setting = {
			check: {
				enable: true,
				chkStyle: "checkbox",
				nocheckInherit: false,
				autoCheckTrigger: true
				},
			data: {
				simpleData: {
					enable: true
				}
			},callback: {
				onCheck: zTreeOnCheck
			}
		};
		
		var code;
		
		function setCheck() {
			var zTree = $.fn.zTree.getZTreeObj("tree"),
			type = { "Y":"", "N":""};
			zTree.setting.check.chkboxType = type;
			showCode('setting.check.chkboxType = { "Y" : "", "N" : "" };');
		}
		function showCode(str) {
			if (!code) code = $("#code");
			code.empty();
			code.append("<li>"+str+"</li>");
		}
		
		jQuery(document).ready(function(){
			jQuery.fn.zTree.init($("#tree"), setting, zNodes);
			setCheck();
		
		});
		function zTreeOnCheck(event, treeId, treeNode){
			var treeObj = $.fn.zTree.getZTreeObj("tree");
			var nodes = treeNode.children;
			if(nodes&&nodes.length>0){
				for (var i=0; i < nodes.length; i++){
					nodes[i].checked = false;
					treeObj.setChkDisabled(nodes[i], treeNode.checked);
				} 
			}
		}
// 		function zTreeOnCheck(event, treeId, treeNode) {
// 			//alert(treeNode.checked);
// 			//setDisableCheck(treeNode);
// 		};
	<%}%>
<%if(!treemap.isEmpty()){%>
</script>
<table width="400" border="0" align="center" style="margin-left: 50px;">
	<tr>
		<td align="center" >
		       
			   <div class="zTreeDemoBackground left" style="min-height: 450px;">
				<ul id="tree" class="ztree"></ul>
			   </div>
		      
	     </td>
	</tr>
	<tr>
		<td align="left" style="padding-left: 30px;">
		<input onclick="choiceNode()" type="button"  class="button" value="确定">
		<input onclick="javascript:window.close()" type="button"  class="button" value="取消">
		<input onclick="resetType()" type="button"  class="button" value="清空">
		</td>
	</tr>
</table>
	<script>
	
		function choiceNode(){
			var treeObj = $.fn.zTree.getZTreeObj("tree");
			var treeNodes = treeObj.getCheckedNodes(true);
			var tempNode  = "";
			if(treeNodes){
				for(var obj in treeNodes){
					tempNode += treeNodes[obj].fullName+",";
				}
				    selectType(tempNode.substr(0,tempNode.length-1));
			}
		}
		
		
		function selectType(name){
			window.returnValue = name;
			window.close();
		}
		function resetType(){
			window.returnValue = "_resetall";
			window.close();
		}
		</script>

<%}%>
<%	
	if(treemap.isEmpty()){%>
目前不存在机构信息！
<%}%>

<div style="height:10px;"></div>
</body>
</html:html>
