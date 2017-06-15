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
<bean:define id="id" value="IGPRM0001" toScope="request" />
<bean:define id="title" value="工作类型" toScope="request" />
<bean:define id="treemap" name="IGPRM00001VO" property="treeNodeMap"
	type="java.util.Map" />
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
<script src="<html:rewrite forward='tree.js'/>"></script>
<link type="text/css" rel="stylesheet"
	href="<html:rewrite forward='tree.css'/>">
<%! 
	ArrayList<String> treeIdCounter=new ArrayList<String>();//id信息读取位置计数器
	ArrayList<String> treeNameCounter=new ArrayList<String>();//name信息读取位置计数器
	ArrayList<String> treeRemarkCounter=new ArrayList<String>();//remark信息读取位置计数器
	ArrayList<String> treeTypeCounter=new ArrayList<String>();//模板定义类型信息读取位置计数器 0-基本工作，1-具体工作
	ArrayList<String> treeWriter=new ArrayList<String>();//信息读取位置计数器
%>
<%!
	public void writeJS(String lastNode,Map<String,TreeNode> treeNodeMap){
		if(treeNodeMap!=null&&!treeNodeMap.isEmpty()){			
			if(treeNodeMap.keySet()!=null&&!treeNodeMap.keySet().isEmpty()){
					Iterator<String> it=treeNodeMap.keySet().iterator();
					while(it.hasNext()){
						Object obj = it.next();
						String key=(String)obj;	
						TreeNode treeNode=(TreeNode)treeNodeMap.get(key);
						treeIdCounter.add(key);
						treeNameCounter.add(treeNode.getName());
						treeRemarkCounter.add(treeNode.getRemark());
						treeTypeCounter.add(treeNode.getBelong());
						treeWriter.add(" var Key"+key+" = new WebFXTreeItem('"+treeNode.getName()+"');");
						treeWriter.add(lastNode+".add(Key"+key+");");
						writeJS("Key"+key,treeNode.getChildTreeNodeMap());
					}
			}
		}
	}
%>
<body>
<ig:message />
<%if(!treemap.isEmpty()){%>
<table width="300" align="center">
	<tr>
		<td colspan="2"><script type="text/javascript">
if (document.getElementById) {
	var tree = new WebFXTree("工作");
	tree.setBehavior('classic');
<%}%>
	<%	
	if(!treemap.isEmpty()){
		treeIdCounter=new ArrayList<String>();//信息读取位置计数器
		treeWriter=new ArrayList<String>();//信息读取位置计数器
			writeJS("tree",treemap);		
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
		<input onclick="choiceNode()" type="button"  class="button" value="确定"></td>
		<td align="left"><br>
		<br>
		<input onclick="javascript:window.close()" type="button"  class="button" value="取消"></td>
	</tr>

	<script>
		//鼠标双击事件
		document.ondblclick=choiceNode;
		function choiceNode(){
			if (tree.getSelected()) { 
				var tmp=tree.getSelected().id.substring(18);
				if(tmp==2){
					alert("不能选择根节点！");	
					tree.expandAll();
					return;
				}
				<%
				if(treeIdCounter!=null&&!treeIdCounter.isEmpty()){
					for(int i=0;i<treeIdCounter.size();i++){%>
						var compare=parseInt("<%=i%>");
						if(tmp==(compare+3)){	
							selectType("<%=treeRemarkCounter.get(i)%>","<%=treeIdCounter.get(i)%>","<%=treeNameCounter.get(i)%>","<%=treeTypeCounter.get(i)%>");
						}
				<%	}
					}
				%>	
			}
		}
		function selectType(ptstartpg,pdid,pdname,type){
			if(ptstartpg.indexOf("/") != 0){
				ptstartpg = "/"+ptstartpg;
			}
			if(type==0){
				pdid = "";
			}
			window.returnValue = '<%=request.getContextPath()%>'+ptstartpg+"?prpdid="+pdid+"&prpdname="+pdname;
			window.close();
		}
		</script>
</table>
<%}%>
<%	
	if(treemap.isEmpty()){%>
工作模板不存在
<%}%>
<div style="height:10px;"></div>
</body>
</html:html>
