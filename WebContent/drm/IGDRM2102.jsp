<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html:html>
<bean:define id="id" value="IGDRM2102" toScope="request" />
<bean:define id="title" value="预案信息维护" toScope="request" />
<!-- start header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- end header1 -->
<link rel="stylesheet" href="css/ztree/zTreeStyle/zTreeStyle.css" />
<script type="text/javascript" src="js/ztree/jquery-1.4.4.min.js"></script>
<script>
var jQ14 = jQuery.noConflict(true);
</script>
<script type="text/javascript" src="js/ztree/jquery.ztree.core-3.4.js"></script>
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
</style>
<SCRIPT type="text/javascript">
	<!--
	function initTree(){
		var setting = {
				data: {
					key: {
						name: "cname"
					},
					simpleData: {
						enable: true,
						idKey: "cid",
						pIdKey: "pcid",
						rootPId: "0"
					}
				},
				callback: {
					onClick: zTreeOnClick,
					beforeClick: zTreeBeforeClick
				}
			};
		jQ14.fn.zTree.init(jQ14("#treeDemo"), setting, zNodes);
		var treeObj = jQ14.fn.zTree.getZTreeObj("treeDemo"); 
		treeObj.expandAll(true); 
	}
	function zTreeBeforeClick(treeId, treeNode, clickFlag) {
		if(!treeNode.cattach){
			alert("父节点不可以编辑");
		    return false;
		}else{
		    return true;
		}
	};
	function zTreeOnClick(event, treeId, treeNode) {
	    jQ14('#IndexContext').attr("src","IGDRM2103_Disp.do?pcid=" + treeNode.cid + "&pcname=" + treeNode.cname + "&cattach=" + treeNode.cattach+ "&cid=" + treeNode.cid+ "&eid=" + treeNode.eid+ "&esyscoding=" + treeNode.esyscoding+ "&eiid=" + '${param.eiid}'+ "&view=" + '${param.view}');
	};
	var zNodes = ${IGDRM21021VO.planSectionTreeJson}
	jQ14(document).ready(function(){
		initTree();
	});
	function reflashTree(){
		jQuery.ajax({
			url:"IGDRM2002_Ajax.do",
			type:"POST",
			dataType :"json",
			data:{},
			async:false,
			cache:false,
			success:function(res){
				zNodes = res;
				initTree();
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				alert('出错了');
			}
		});
	}
	function toback(){
		window.location.href = getAppRootUrl() + "/IGDRM2105_Back.do?mode=1";
	}
	
	function saveContent(){
		alert("aaaaaaa");
	}
	//-->
</SCRIPT>
<body>
	<div id="maincontent">
	<!--header  头部和 一级菜单-->
	<jsp:include page="/include/header2.jsp" />
	<!--container 左菜单 右侧内容-->
		<div id="container">
		
		<div id="contentWrap">
		 <div id="content">
			<div id="location">
				<div class="image"></div>
				<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
				<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
			</div>
			<br>
			<div id="treeNode">
				<div style="width:240px;float:left;border:0px; border:1px solid #BB0500;height:550px; overflow:auto;">
					<div class="conditions" style="height:550px;" >
						<div>
							<div class="titBox">章节树</div>
							<ul id="treeDemo" class="ztree"></ul>
						</div>
						<html:hidden property="esyscoding" styleId="esyscoding" value="${IGDRM0402Form.ercode}"/>
					</div>
				</div>
				<div id="content" style="width:730px;float:left; border-top:1px solid #BB0500;border-right:1px solid #BB0500;border-left:1px solid #BB0500;height:55px; margin-left: 10px;">
					<div id="results_list">
					<table class="table_style">
						<tr>
							<th width="18%">模型名称</th>
							<th width="12%">预案编号</th>
							<th width="20%">预案名称</th>
							<th width="12%">预案所属机构</th>
							<th width="20%">预案说明</th>
							<th width="10%">管理人</th>
							<th width="8%">登记日</th>
						</tr>
						<tr>
							<td align="center" title="${IGDRM21021VO.entityItemVWInfo.ename}">
								<c:if test="${fn:length(IGDRM21021VO.entityItemVWInfo.ename)>10}">
									${fn:substring(IGDRM21021VO.entityItemVWInfo.ename,0,10)}...
								</c:if>
								<c:if test="${fn:length(IGDRM21021VO.entityItemVWInfo.ename)<=10}">${IGDRM21021VO.entityItemVWInfo.ename}</c:if>
							</td>
							<td>${IGDRM21021VO.entityItemVWInfo.eilabel}</td>
							<td title="${IGDRM21021VO.entityItemVWInfo.einame}">
								<c:if test="${fn:length(IGDRM21021VO.entityItemVWInfo.einame)>10}">
									${fn:substring(IGDRM21021VO.entityItemVWInfo.einame,0,10)}...
								</c:if>
								<c:if test="${fn:length(IGDRM21021VO.entityItemVWInfo.einame)<=10}">${IGDRM21021VO.entityItemVWInfo.einame}</c:if>
							</td>
							<td>${IGDRM21021VO.eiorgname}</td>
							<td title="${IGDRM21021VO.entityItemVWInfo.eidesc}">
								<c:if test="${fn:length(IGDRM21021VO.entityItemVWInfo.eidesc)>10}">
									${fn:substring(IGDRM21021VO.entityItemVWInfo.eidesc,0,10)}...
								</c:if>
								<c:if test="${fn:length(IGDRM21021VO.entityItemVWInfo.eidesc)<=10}">${IGDRM21021VO.entityItemVWInfo.eidesc}</c:if>
							</td>
							<td>${IGDRM21021VO.entityItemVWInfo.eiusername}</td>
							<td>${IGDRM21021VO.entityItemVWInfo.eiinsdate}</td>
						</tr>
					</table>
					</div>
				</div>
				<div id="content" style="width:730px;float:left; border:1px solid #BB0500;height:495px; margin-left: 10px;" >
					<iframe id="IndexContext" name="IndexContext" style="width:100%;height:100%; overflow: auto;" frameborder="0" scrolling="yes" src="IGDRM2103_Disp.do" ></iframe>
				</div>
			</div>
		</div>
		<div class="zishiying"></div>
		
		</div>
		</div>
	</div>
</body>
</html:html>
