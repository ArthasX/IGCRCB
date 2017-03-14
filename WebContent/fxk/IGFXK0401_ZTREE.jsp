<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
import="com.deliverik.infogovernor.fxk.vo.IGFXK04011VO,com.deliverik.framework.user.model.Organization,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
	<title>选择风险类别</title>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="js/ztree/css/demo.css" type="text/css">
	<link rel="stylesheet" href="js/ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script type="text/javascript" src="js/ztree/js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript" src="js/ztree/js/jquery.ztree.core-3.2.js"></script>
	<script type="text/javascript" src="js/ztree/js/jquery.ztree.excheck-3.2.js"></script>
	
	
<style>


.buttonStyle{
	color:#FFFFFF;
	padding:1px 10px;
	font-size:12px;
	border:2px outset #EEEEEE;
	background-color: #6699CC;
	cursor: hand;
	height:20px;
}

</style>
	<script type="text/javascript">
		<!--
		var setting = {
			check: {
				enable: true,
				autoCheckTrigger: false
						
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			callback: {
				onCheck: zTreeOnCheck
			}

		};
		var zNodes = new Array();
		var num = 0;
		zNodes =${IGFXK04011VO.treejson};
		
		/* zNodes = [       
		                          {id:0, pId:-1, name:"中国"},  
		                          {id:1, pId:0, name:"北京"},   
		                          {id:2, pId:0, name:"天津"},  
		                          {id:3, pId:0, name:"上海"},   
		                          {id:6, pId:0, name:"重庆"},   
		                          {id:4, pId:0, name:"河北省", open:false, nocheck:true},   
		                          {id:41, pId:4, name:"石家庄"},   
		                          {id:42, pId:4, name:"保定"},   
		                          {id:43, pId:4, name:"邯郸"},   
		                          {id:44, pId:4, name:"承德"},   
		                          {id:5, pId:0, name:"广东省", open:false, nocheck:true},   
		                          {id:51, pId:5, name:"广州"},   
		                          {id:52, pId:5, name:"深圳"},   
		                          {id:53, pId:5, name:"东莞"},   
		                          {id:54, pId:5, name:"佛山"},   
		                          {id:6, pId:0, name:"福建省", open:false, nocheck:true},   
		                          {id:61, pId:6, name:"福州"},   
		                          {id:62, pId:6, name:"厦门"},   
		                          {id:63, pId:6, name:"泉州"},   
		                          {id:64, pId:6, name:"三明"},  
		                          {id:7, pId:0, name:"四川省", open:true, nocheck:true},  
		                          {id:71, pId:7, name:"成都"},  
		                          {id:72, pId:7, name:"绵阳"},  
		                          {id:73, pId:7, name:"自贡"},  
		                          {id:711, pId:71, name:"金牛区"},  
		                          {id:712, pId:71, name:"锦江区"},  
		                          {id:7111, pId:711, name:"九里堤"},  
		                          {id:7112, pId:711, name:"火车北站"}  
		                          ];  */
		
		
		
		
		var code;
		var zTree;
		function setCheck() {
			zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			type = { "Y":"", "N":""};
			zTree.setting.check.chkboxType = type;
			showCode('setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };');
		}
		function showCode(str) {
			if (!code) code = $("#code");
			code.empty();
			code.append("<li>"+str+"</li>");
		}
		
		$(document).ready(function(){
			$.fn.zTree.init($("#treeDemo"), setting, zNodes);
			setCheck();
		
		});
		var result = "";
		function zTreeOnCheck(event, treeId, treeNode) {
			var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
			if(treeNode.id == "0A0000"){
				for ( var i = 0; i < treeNode.children.length; i++) {
					var isTrue = treeNode.children[i].id.indexOf("1A");
					if(!isTrue){
						treeNode.children[i].checked = treeNode.checked;
						zTree.updateNode(treeNode.children[i]);
					}
				}
			}
			var nodes = treeObj.getCheckedNodes(true);
			result = "";
			for(var i = 0; i < nodes.length; i++){
				result += nodes[i].id +"|"+nodes[i].name + "@";
				//alert(nodes[i].id + "---" +  nodes[i].name + "#");
			}
			//alert(result);
			document.getElementById("resultValue").value =result ;

		};

		function selectType(){
			//alert(document.getElementById("resultValue").value);
			window.returnValue = document.getElementById("resultValue").value;
			window.close();
		}

		function resetType(){
			window.returnValue = "_resetall";
			window.close();
		}
	
		//-->
	</script>
</head>

<body>

<div class="content_wrap">
	<div class="zTreeDemoBackground">
		<ul id="treeDemo" class="ztree"></ul>
		<logic:present name="IGFXK04011VO">
			<bean:define id="vo" name="IGFXK04011VO" type="com.deliverik.infogovernor.fxk.vo.IGFXK04011VO"></bean:define>
			<%
				String  list = vo.getTreejson(); 
				if(list == null ){
					out.print("当前没有风险类别!");
				}	
				%>
			
		</logic:present>
	</div>
	<div>
	<table align="center">
	<tr>
		<td align="right"><br>
		<br>
		<input onclick="selectType()" type="button"  class="buttonStyle" value="确定"></td>
		<td align="left"><br>
		<br>
		<input onclick="javascript:window.close()" type="button"  class="buttonStyle" value="取消">
		<input type="hidden" name="resultValue" id="resultValue"/>
		</td>
	
	</tr>
	</table>
	</div>
</div>
</body>
</html>