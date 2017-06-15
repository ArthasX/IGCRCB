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
<bean:define id="id" value="IGCIM0142" toScope="request" />
<bean:define id="title"  toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGASM0342"/>
</bean:define>
<bean:define id="treemap" name="IGCIM01011VO" property="treeNodeMap" type="java.util.Map" />

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
						treeIdCounter.add(key);
						treeNameCounter.add(treeNode.getName());
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
	var alterMessage= '<bean:message bundle="asmResources" key="message.IGASM0342.001"/>';
	var tree = new WebFXTree(alterMessage);
	tree.setBehavior('classic');
<%}%>
	<%	
	if(!treemap.isEmpty()){
		treeIdCounter=new ArrayList<String>();//信息读取位置计数器
		treeNameCounter=new ArrayList<String>();//信息读取位置计数器
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
		
	</tr>

	<script>
		//鼠标双击事件
		document.onclick=choiceNode;
		function choiceNode(){
			if (tree.getSelected()) { 
				var tmp=tree.getSelected().id.substring(18);

				if(tmp==2){
					tree.expandAll();
					return;
				}
				
				<%
				if(treeIdCounter!=null&&!treeIdCounter.isEmpty()){
					for(int i=0;i<treeIdCounter.size();i++){
				%>
						
						var compare=parseInt("<%=i%>");
						
						if(tmp==(compare+3)){
							var nodeid = "<%=treeIdCounter.get(i)%>";
							
							if(nodeid!=null && nodeid.length>=9){
								selectType("<%=treeIdCounter.get(i)%>","<%=treeNameCounter.get(i)%>");
							}else{

							}
														
						}
				<%	
					}
				}
				%>	
				
			}
		}
		function getAppRootUrl(){
			var lct = location.href;
			var arr = lct.split("/",4);
			return "/" + arr[3];
		}
		function selectType(id,name){
			var rightFrame = window.parent.document.getElementById("rightFrame");
			var temp_src = getAppRootUrl()+"/IGASM0343.do?nodeID="+id+"&eiid="+${IGASM0301Form.eiid}+"&eiversion="+${IGASM0301Form.eiversion}+"&eismallversion="+${IGASM0301Form.eismallversion};
			rightFrame.src=temp_src;
			//window.returnValue = id;
			//window.close();
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
<bean:message bundle="asmResources" key="label.IGASM0342.Totip"/>
<%}%>
<div style="height:10px;"></div>
</body>
</html:html>
