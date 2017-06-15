<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.deliverik.framework.tree.TreeNode"%>
<html:html>
<title>IGCOM0211统计分析画面</title>
<bean:define id="treemap" name="IGCOM02111VO" property="treeNodeMap" type="java.util.Map" />
<style>
html,body {
   margin:0;
   padding:0;
   height:100%;
   font-size: 12px;
   overflow-x:hidden;
   background-color: #FFFFFF;
}
#maincontent{
    min-height:100%;
    _height:100%;
    position: relative;
    min-width:1024px;
}
#container{
    margin:0 auto;
    width:1002px;
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
<script src="<html:rewrite forward='tree.js'/>"></script>
<link type="text/css" rel="stylesheet" href="<html:rewrite forward='tree.css'/>"/>
<script src="<html:rewrite forward='prototype.js'/>"></script>
<script src="<html:rewrite forward='common.js'/>"></script>
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
<div id="maincontent">
<jsp:include page="/include/header2.jsp" />
<div id="container">
<div style="height:460px;width:240px;overflow: auto;float: left;margin-top: 10px">
<%if(!treemap.isEmpty()){%>
<table align="left">
	<tr>
		<td colspan="2"><script type="text/javascript">
if (document.getElementById) {
	var tree = new WebFXTree("报表分类信息");
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

	<script type="text/javascript">
		tree.expandRootChildren();
		document.onclick = choiceNode;
		function choiceNode(){
			var obj = event.srcElement.getAttribute("id");
			if(obj){
				if (obj.indexOf(webFXTreeHandler.idPrefix) > -1 && event.srcElement.tagName && event.srcElement.tagName.toUpperCase() != "IMG" && tree.getSelected()) { 
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
								selectType("<%=treeIdCounter.get(i)%>","<%=treeNameCounter.get(i)%>");
							}
					<%	
						}
					}
					%>	
				}
			}
		}
		function selectType(id,name){
			if(id == '217') {
				$("frmcontent").src = "IGCOM0215.do";
			} else {
				$("frmcontent").src = "IGCOM0215.do?rfdtype=" + id.split("_")[2];
			}
		}
	</script>
</table>
<%}%>
<%	
	if(treemap.isEmpty()){%>
不存在报表分类信息！
<%}%>
</div>
<div id="contentWrap">
<div id="content">
           <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><span id="rfdtypename"></span></p>
            </div>
<iframe name="frmcontent" width="756" height="460" frameborder="0" scrolling="auto" src="IGCOM0215.do" ></iframe>
</div>
</div>
</div>
</div>
</body>
</html:html>