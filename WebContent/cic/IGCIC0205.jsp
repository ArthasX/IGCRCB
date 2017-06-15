<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html:html>
<bean:define id="id" value="IGCIC0205" toScope="request" />
<bean:define id="title" value="对比明细画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script src="<html:rewrite forward='tree.js'/>"></script>
<link type="text/css" rel="stylesheet"	href="<html:rewrite forward='tree.css'/>">
<!-- /header1 -->
<style type="text/css">
.case {
	margin: 2px;
}
.case  div{
	margin: 0px;
}
.case ul {
	margin: 0px;
	padding: 0px; overflow : hidden;
	zoom: 1;
	overflow: hidden;
}

.case ul li {
	float: left;
	width: 470px;
	margin-bottom: 10px;
}

.dvblock {

	border: 1px solid #ccc;
	float: left;
	margin-right: 10px;
	height: 251px; 
	width: 450px
}

.dvblock .dvTitle {
	width: 100%;
	background-image: url("images/bg_titlevim101.png");
	font-size: 14px;
	height: 25px;
	vertical-align: middle;
	line-height: 25px;
}

.dvblock .dvTitle .titText {
	float: left;
	width: 70%;
	text-align: left;
	text-indent: 15px;
	color: #1C87E1;
	font-weight: 800;
}
.dvContentTitle{
	width: 100%;
	height:10px;
}

.dvContent {
	width: 100%;
	height:202px;
	overflow: scroll;
	overflow-x: hidden;
}
#treeBox{
	float: left;
	width: 200px; 
/* 	border-right: 1px solid #2BA0E8;  */
	margin-left: 10px;
	 margin-top:20px; 
	 height: 500px;
	 overflow: auto;
}
#resultBox{
	width:745px;
	float: left;
	padding: 20px;
	height: 500px;
	overflow: auto;
}
.tbResult{
	
	margin:0 auto;
	margin-top:20px;
	width:650px;
	border-collapse: collapse;
	border: 1px solid #EEEEEE;
}
.tbResult th{
	background-color:#EEEEEE;
	border-bottom: 1px solid #EEEEEE;
	height: 24px;
}
.tbResult td{
	border-bottom: 1px solid #EEEEEE;
	padding-left: 3px;
	padding-right: 3px;
	
	min-height: 22px;
	
}
.cenTd{
	text-align: center;
}

.enameTd{
	text-align: center;
}
#blankDv{
	width: 1px;
	border-left: 1px solid #2BA0E8;
	height: 540px;
	
	float: left;
}
.ne{
	font-size: 16px;
	color: red;
	text-align: center;
}
#baseInfo{
	text-align: center;
}
a img{
	border: 0px;
}
</style>
<script type="text/javascript">
<!--
	
//-->
</script>
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<div id="location">
							<div class="image"></div>
							<p class="fonts1">
								<ig:navigation extname1="${urlable}" />
							</p>
							<div class="back"><a href="IGCIC0202.do?cpid=${cpid }" target="_self">返回</a></div> 
					</div>
					
					<div>
						<div id="treeBox" style=""></div>
						<div id="blankDv"></div>
						<div id="resultBox">
							<fieldset >
								<legend>对比主机基本信息信息</legend>
								<table id="baseInfo" class="tbResult">
									<tr>
										<th>对比对象</th><th>主机名</th><th>IP地址</th>
									</tr>
									<bean:define id="sourceMap" name="IGCIC02051VO" property="sourceMap"></bean:define>
									<bean:define id="targetMap" name="IGCIC02051VO" property="targetMap"></bean:define>
										<tr>
											<td>源主机 </td><td>${sourceMap['einame'] }</td><td>${sourceMap['ip'] }</td>
										</tr>
										<tr>
											<td>目标主机 </td><td>${targetMap['einame'] }</td><td>${targetMap['ip'] }</td>
										</tr>
								</table>
							</fieldset>
							<fieldset id ="resultField" >
								<legend><span id = "titleLen"></span></legend>
								<table id="tbResult" class="tbResult">
									<tr> 
											<th width="14%">对象名</th>
											<th width="14%">属性名</th>
											<th width="30%" style="text-align: left;">${sourceMap['ip'] }&nbsp;上的值 </th>
											<th width="4%"> </th>
											<th width="30%" style="text-align: left;">${targetMap['ip'] }&nbsp;上的值 </th>
											<th width="4%"></th>
									</tr>
								</table>
							</fieldset>
						</div>
					</div>
					
				</div>
			</div>
			<div class="zishiying"></div>
		</div>


	</div>
</body>
<script>
	var json = '${IGCIC02051VO.treeMapJson}';
	var cpid = '${cpid}';
	var soc0124Info = '${IGCIC02051VO.soc0124InfoJson}';
	jQuery("#resultField").hide();
	
		json&&(json = eval('('+json+')'));
		soc0124Info&&(soc0124Info=eval('('+soc0124Info+')'));
		//创建树
	if (document.getElementById){
		var tree = new WebFXTree(soc0124Info.ename);
		tree.eid = soc0124Info.eid;
		tree.setBehavior('classic');
		}
	
	//装载树的 方法
	function loadTree(parentNode,obj){
		if(obj.id==soc0124Info.eid){
			return;
		}
		var newNode = new WebFXTreeItem(obj.name);
		newNode.eid = obj.id;
		parentNode.add(newNode);
		if(obj.childTreeNodeMap){
			for(var k in obj.childTreeNodeMap){
				loadTree(newNode,obj.childTreeNodeMap[k]);
			}
		}
	}
	//装载树
	for(var k in json){
		loadTree(tree,json[k]);
	}
		
		
		
	jQuery(function(){
		jQuery("#treeBox").html(tree.toString());
		tree.expandAll();
		tree.expandRootChildren();
		
		//绑定树的点击事件
		jQuery("#treeBox").click(function(){
				jQuery("#resultField").fadeOut("fast",function(){
					jQuery("#tbResult tr:not(:first)").remove();
					if (tree.getSelected()){
						loadResult(tree.getSelected().eid);
					}
				});
		});
		
	});
	function loadResult(eid){
		jQuery.ajax({
			url:getAppRootUrl()+"/IGCIC0205_Detail.do",
			data:{cpid:cpid,eid:eid},
			type:"POST",
			dataType:"json",
			success:function(result){
				if(result.length>0){
					var lastT = null;
					result.each(function(t,i){
						var tr;
						var html="<tr class='content' >";
							if(jQuery("td[eiid='"+t.seiid+"']").length>0){
								tr=jQuery(jQuery("td[eiid='"+t.seiid+"']").get(0)).parent();
								jQuery("td[eiid='"+t.seiid+"']").attr("rowspan",jQuery("td[eiid='"+t.seiid+"']").attr("rowspan")+1);
							}else{
								tr=jQuery("#tbResult tr:last");
								html+="<td class='enameTd' eiid='"+t.seiid+"'>"+t.einame+"</td>";
							}
							html+="<td>"+t.cname+"</td>";
							if(t.configtype==0){
								html+="<td>"+t.svalue+"</td><td class='ne'>&ne;</td><td>"+t.tvalue+"</td><td</td>";
							}else{
								html+="<td>"+getFilename(t.svalue)+"</td><td class='ne'>&ne;</td><td>"+getFilename(t.tvalue)+"</td><td><a target='_blank' href='IGCIC0204.do?crid="+t.crid+"'><img title='查看详细' src='images/igsvc0401.gif'></a></td>";
							}
							
							html+="</tr>";
						tr.after(html);
						lastT = t;
					});
					jQuery("#titleLen").html(lastT.ename);
					jQuery("#resultField").fadeIn("fast");
				}
			}
			
		})
	}

	function getFilename(path){
// 		"".lastIndexOf(searchString, startPosition)
		return path.substring(path.lastIndexOf("\\")+1);
	}
</script>
</html:html>