<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="com.deliverik.framework.utility.CommonDefineUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.deliverik.framework.tree.TreeNode"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<bean:define id="treemap" name="IGCIM04011VO" property="treeNodeMap" type="java.util.Map" />

<html:html>
<bean:define id="id" value="IGCIM0401" toScope="request" />
<bean:define id="title" value="模型查询画面" toScope="request" />
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
</style>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<%

	Map<Integer,String> stopbuttonmap = new HashMap<Integer,String>();
	Map<Integer,String> startbuttonmap = new HashMap<Integer,String>();
	if(null!=request.getAttribute("stopbuttonMap")){
		stopbuttonmap = (Map)request.getAttribute("stopbuttonMap");
	}
	if(null!=request.getAttribute("startbuttonMap")){
		startbuttonmap = (Map)request.getAttribute("startbuttonMap");
	}
	
%>

<!-- /header1 -->
<script src="<html:rewrite forward='tree.js'/>"></script>
<link type="text/css" rel="stylesheet"
	href="<html:rewrite forward='tree.css'/>">
<%!
	ArrayList<String> treeIdCounter=new ArrayList<String>();//数据信息id信息读取位置计数器
	ArrayList<String> treeNameCounter=new ArrayList<String>();//数据信息name信息读取位置计数器

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
					//	System.out.println("---key---"+key);
						treeIdCounter.add(key);
					//	System.out.println("---name---"+treeNode.getName());
						treeNameCounter.add(treeNode.getName());
						treeWriter.add(" var Key"+key+" = new WebFXTreeItem('"+treeNode.getName()+"');");
						treeWriter.add(lastNode+".add(Key"+key+");");
						writeJS("Key"+key,treeNode.getChildTreeNodeMap());
					}
					
			}
		}
		
	}
%>
<script>

function load(){
	var b=document.documentElement.clientHeight;
	var height = (parseInt(b)-201)+'px'
	document.getElementById("cDiv").style.height = height;
	document.getElementById("frmDiv").style.height = height;
	document.getElementById("frmcontent").height = height;
}

</script>


<body onload="load();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<div id="container">
	<div id = "contentWrap">
    <div id="location">
                <div class="image"></div>
                <p class="fonts1">配置管理 &gt;&gt; 配置模型 &gt;&gt;模型管理 </p>
    </div>
    <div style="width:98%;margin:auto;">
	<div style="width:24%;overflow: auto;float: left;margin-top: 15px;height: auto;" id="cDiv">
         <!-- <iframe height="700" frameborder="1" scrolling="auto" src="IGCIM1203_ENTITY_TREE.do?levelnode=999"></iframe>  -->
		<%if(true){%>
		<table align="left">
			<tr >
				<td ><script type="text/javascript">
		if (document.getElementById) {
			var tree = new WebFXTree("资产模型");
			tree.setBehavior('classic');
			
		<%}%>
			<%	
			if(true){
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
			tree.expandAll();
			<%
			}
			%>
		<%if(true){%>
		</script></td>
			</tr>
		
			<script>
				tree.expandRootChildren();
// 				document.onclick=choiceNode;
				jQuery("#cDiv").click(choiceNode);
				function choiceNode(){
					
					if (tree.getSelected()) { 
						var tmp=tree.getSelected().id.substring(18);
						if(tmp==2){
							//selectType("999","资产模型");
							//tree.expandAll();
							return;
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
					$("frmcontent").src = "IGAIM0406_Disp.do?eid=" + id.split("_")[0];
				}
				</script>
		</table>
		<%}%>
    </div>
    <div style="width:76%;overflow: auto;float: right;margin-top: 10px;" id="frmDiv"> 
    <iframe id="frmcontent" name="frmcontent" width="100%" frameborder="0" scrolling="auto" src="IGAIM0406_Disp.do?eid=${IGCIM04011VO.eidInSession}"></iframe>
    </div>
   </div>
   </div>
</div>


</div>
</body>
</html:html>