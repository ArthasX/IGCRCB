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
<%@ page import="com.deliverik.infogovernor.sym.bl.IGSYM03BLImpl"%>
<html:html>
<bean:define id="id" value="IGSYM0100" toScope="request" />
<bean:define id="title" value="机构列表" toScope="request" />
<bean:define id="treemap" name="IGSYM01011VO" property="treeNodeMap" type="java.util.Map" />
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
	background-color: red;
	cursor: hand;
	height:20px;
}
</style>
<script src="<html:rewrite forward='tree.js'/>"></script>
<link type="text/css" rel="stylesheet"
	href="<html:rewrite forward='tree.css'/>">
<%!
	ArrayList<String> treeIdCounter=new ArrayList<String>();//机构id信息读取位置计数器
	ArrayList<String> treeNameCounter=new ArrayList<String>();//机构name信息读取位置计数器

	ArrayList<String> treeWriter=new ArrayList<String>();//信息读取位置计数器
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
						//System.out.println("---key---"+key);
						treeIdCounter.add(key);
						//System.out.println("---name---"+treeNode.getName());
						treeNameCounter.add(treeNode.getName());
						treeWriter.add(" var Key"+key+" = new WebFXTreeItem('"+(treeNode.getName().lastIndexOf("-")<0?treeNode.getName():treeNode.getName().substring(treeNode.getName().lastIndexOf("-")+1))+"');");
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
	<logic:equal name="IGSYM0101Form" property="roledomain_q" value="role">
	var tree = new WebFXTree("用户自身机构");
	</logic:equal>
	<logic:notEqual name="IGSYM0101Form" property="roledomain_q" value="role">
	var tree = new WebFXTree("机构");
	</logic:notEqual>
	tree.setBehavior('classic');
<%}%>
	<%	
	if(!treemap.isEmpty()){
		treeIdCounter=new ArrayList<String>();//信息读取位置计数器
		treeNameCounter=new ArrayList<String>();//信息读取位置计数器
		treeWriter=new ArrayList<String>();//信息读取位置计数器
		
			writeJS("tree",treemap);	
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
		<input onclick="choiceNode()" type="button"  class="button" value="确定"></td>
		<td align="left"><br>
		<br>
		<input onclick="javascript:window.close()" type="button"  class="button" value="取消">
		<input onclick="resetType()" type="button"  class="button" value="清空">
		</td>
	</tr>

	<script>
		//鼠标双击事件
		document.ondblclick=choiceNode;
		<logic:equal name="IGSYM0101Form" property="roledomain_q" value="role">
			tree.expandRootChildren();
		</logic:equal>
		function choiceNode(){
			if (tree.getSelected()) { 
				var tmp=tree.getSelected().id.substring(18);

				if(tmp==2){

					<logic:equal name="IGSYM0101Form" property="roledomain_q" value="role">
							selectType("<%=IGSYM03BLImpl.GROUP_ROLE_MARK%>","<%=IGSYM03BLImpl.GROUP_ROLE_NAME%>");
					</logic:equal>
					<logic:notEqual name="IGSYM0101Form" property="roledomain_q" value="role">
					//alert("不能选择‘机构’！");	
					tree.expandAll();
					return;
					</logic:notEqual>
				}
				
				<%
				if(treeIdCounter!=null&&!treeIdCounter.isEmpty()){
					for(int i=0;i<treeIdCounter.size();i++){
				%>
						
						var compare=parseInt("<%=i%>");
						
						if(tmp==(compare+3)){
							selectType("<%=treeIdCounter.get(i)%>","<%=treeNameCounter.get(i)%>");
						}
				<%	
					}
				}
				%>	
				
			}
		}
		function selectType(id,name){
			
			window.returnValue = id + "|" +name;
			window.close();
		}
		function resetType(){
			window.returnValue = "_resetall";
			window.close();
		}
		</script>
</table>
<%}%>
<%	
	if(treemap.isEmpty()){%>
目前不存在机构信息！
<%}%>
<div style="height:10px;"></div>
</body>
</html:html>
