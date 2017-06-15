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
<bean:define id="id" value="IGSYM1506" toScope="request" />
<bean:define id="title" value="基础数据定义" toScope="request" />
<bean:define id="treemap" name="IGSYM15051VO" property="treeNodeMap" type="java.util.Map" />
<bean:define id="treemapnew" name="IGSYM15051VO" property="treeNodeNewMap" type="java.util.Map" />
<title><bean:write name="title"/></title>
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
	background-color: #CC0000;
	cursor: hand;
	height:20px;
}
 .setTree{
/* 	background-color:#00FF00; */
	color:pink;
 }
  .clearTree{
	background-color:#FFFFFF;
 } 
</style>
<script type="text/javascript">
var selectedLast = "0";
<logic:notEmpty name="IGSYM15051VO" property="selectedLast">
	<bean:define id="selectedLast" name="IGSYM15051VO" property="selectedLast" type="java.lang.String" />
	selectedLast = "${selectedLast}";
</logic:notEmpty>
</script>
<script src="<html:rewrite forward='tree.js'/>"></script>
<script src="js/jquery-1.9.1.min.js"></script>
<link type="text/css" rel="stylesheet" href="<html:rewrite forward='tree.css'/>">
<%!
	ArrayList<String> treeIdCounter=new ArrayList<String>();//数据信息id信息读取位置计数器
	ArrayList<String> treeNameCounter=new ArrayList<String>();//数据信息name信息读取位置计数器
	ArrayList<String> treeRemarkCounter=new ArrayList<String>();//数据信息remark信息读取位置计数器
	
	ArrayList<String> treeWriter=new ArrayList<String>();//信息读取位置计数器
%>
<%!
	public void writeJS (String lastNode,Map<String,TreeNode> treeNodeMap,Map<String,TreeNode> treeNodeNewMap){
	int j=0;
		if(treeNodeMap!=null&&!treeNodeMap.isEmpty()){			
			if(treeNodeMap.keySet()!=null&&!treeNodeMap.keySet().isEmpty()){
					Iterator<String> it=treeNodeMap.keySet().iterator();
					while(it.hasNext()){
						Object obj = it.next();
						String key=(String)obj;	
						TreeNode treeNode=(TreeNode)treeNodeMap.get(key);
						//System.out.println("---key---"+key);
						treeIdCounter.add(key);
						//System.out.println("---name---"+treeNode.getName());
						treeNameCounter.add(treeNodeNewMap.get(key).getName());
						treeRemarkCounter.add(treeNode.getRemark());
						treeWriter.add(" var Key"+key+" = new WebFXTreeItem('"+treeNode.getName()+"');");
						treeWriter.add(lastNode+".add(Key"+key+");");
						writeJS("Key"+key,treeNode.getChildTreeNodeMap(),treeNodeNewMap.get(key).getChildTreeNodeMap());
						j+=1;
					}
			}
		}
	}
%>
<script type="text/javascript">
	function gotoSelected(){
		for(var i=0;i<=<%=treeIdCounter.size()%>;i++){
			var vid = "webfx-tree-object-"+(i+2)+"-anchor";
			document.getElementById(vid).className = "clearTree";
		}
		
		jQuery("a").removeAttr("style");
		
		for(var i=0;i<document.getElementsByName("redq").length;i++){
			document.getElementsByName("redq")[i].src = "images/tree/node.jpg";
		}
		
		var searchText = document.getElementById("searchText").value;
		
		if(searchText==""){
			alert("请输入检索条件!");
			return;
		}
		/* jQuery("a").removeClass("setTree"); */
		var len=jQuery("a:contains('"+searchText+"')").length;
		if(len>0){
			alert("共检索出"+len+"条记录!");
			tree.expand(); 
			expandChildNodes(tree,searchText);
			var ggg=$(window).height();
			var lengs = jQuery(jQuery("a:contains('"+searchText+"')").get(0)).position().top-ggg/2;
			$("html,body").animate({scrollTop:lengs},1000);
				var $objs = jQuery("a:contains('"+searchText+"')").removeAttr("class");
				jQuery.each($objs,function(i,o){
					jQuery(o).attr("style","color:red;font-weight:bold;");
					jQuery(o).parent().find(".webfx-tree-icon").attr("src","images/tree/node2.jpg");
					jQuery(o).parent().find(".webfx-tree-icon").attr("name","redq");
				}
			);
		}else{
			alert("没有符合条件的记录!");
		}
		
	}
	
	function expandChildNodes(obj,searchKeyWord){
		var returnValue = false;
		var value = false;
		if(obj.childNodes && searchKeyWord){
			for(var i=0;i<obj.childNodes.length;i++){
				var flag = false;
				if(obj.childNodes[i].text.indexOf(searchKeyWord) >= 0){
					flag = true;
					current = true;
				}
				value = expandChildNodes(obj.childNodes[i],searchKeyWord);
				if((!returnValue) && (value || flag)){
					returnValue = !returnValue;
				}
				if((value || flag) && obj.childNodes[i].childNodes.length > 0){
					obj.childNodes[i].expand();
				}
			}
		}
		return returnValue;
	}

</script>
<body>
<ig:message />
<%if(!treemap.isEmpty()){%>
<table width="300" align="center">
	<tr>
		<tr>
			<td colspan="2"><strong style="color: red;">名称:</strong>&nbsp;&nbsp;<INPUT TYPE="TEXT" name="searchText" id="searchText">
			<INPUT TYPE="button" value="查询" onclick="gotoSelected();"  class="button"></td>
		</tr>
	
		<td colspan="2"><script type="text/javascript">
if (document.getElementById) {
	var tree = new WebFXTree("基础数据信息");
	tree.setBehavior('classic');
<%}%>
	<%	
	if(!treemap.isEmpty()){
		treeIdCounter=new ArrayList<String>();//信息读取位置计数器
		treeNameCounter=new ArrayList<String>();//信息读取位置计数器
		treeRemarkCounter=new ArrayList<String>();//信息读取位置计数器
		treeWriter=new ArrayList<String>();//信息读取位置计数器
		
			writeJS("tree",treemap,treemapnew);	
			//for(String temp :treeIdCounter){
			//	System.out.println("---idcounter---"+temp);
			//}
			//for(String temp :treeNameCounter){
			//	System.out.println("---namecounter---"+temp);
			//}
			if(treeWriter!=null&&!treeWriter.isEmpty()){
				for(int i=0;i<treeWriter.size();i++){
				%>
					<%=(String)treeWriter.get(i)%>
				<%
				}
			}
	%>
	document.write(tree);
}
	<%
	}
	%>
<%if(!treemap.isEmpty()){%>
</script></td>
	</tr>
	<tr>
		<td align="right"><br>
		<br>
		<input onclick="choiceNode()" type="button" class="button" value="确定"></td>
		<td align="left"><br>
		<br>
		<input onclick="javascript:window.close()" type="button"  class="button" value="取消">
		<input onclick="resetType()" type="button"  class="button" value="清空">
		</td>
	</tr>

	<script type="text/javascript">
		//鼠标双击事件
		document.ondblclick=choiceNode;
		function choiceNode(){
			if (tree.getSelected()) { 
				var tmp=tree.getSelected().id.substring(18);
				if(tmp==2){
					tree.expand();
					return;
				}
				
				<%
				if(treeIdCounter!=null&&!treeIdCounter.isEmpty()){
					for(int i=0;i<treeIdCounter.size();i++){
				%>
						
						var compare=parseInt("<%=i%>");
						
						if(tmp==(compare+3)){
							var remark = "<%=treeRemarkCounter.get(i)%>";
							
							if(remark!=null && remark!="" && remark=="1"){
								tree.expandAll();
								return;
							}else{
								if(selectedLast=='1'&&tree.getSelected()._last){
									tree.expand();
								}else{ 
									selectType("<%=treeIdCounter.get(i)%>","<%=treeNameCounter.get(i)%>");
								 }
							}
							
						}
				<%	
					}
				}
				%>	
				
			}
		}
		function selectType(id,name){
			if(id == "" || name == "") {
				window.returnValue = "_resetall";
			} else {
				window.returnValue = id + "|" +name;
			}
			window.close();
		}
		</script>
</table>
<%}%>
<%	
	if(treemap.isEmpty()){%>
目前不存在基础数据信息！
<%}%>
<div style="height:10px;"></div>
</body>
<script>
function resetType(){
	selectType("","");
	window.close();
}
</script>
</html:html>
