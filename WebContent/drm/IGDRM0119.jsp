<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0119" toScope="request"/>
<bean:define id="title" value="场景触发策略" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<link type="text/css" rel="stylesheet"	href="<html:rewrite forward='tree.css'/>">
<style type="text/css">
	a img{
		border: 0px;
	}
	.hover{
		background-color: #d3d3d3;
		cursor: pointer;
		
	}
	.leftd{
		text-align: left;
	}
</style>
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
	<div id="container">

    <!--content  右侧内容-->
    	<div id="contentWrap">  
    		<html:form action="IGDRM0119_Search" styleId="form1" method="POST" onsubmit="return refreshSearch();">
		    <!-- 左侧内容 -->
        		<div id="content" style="float:left;height:520px; margin-left: 10px;padding-top: 10px;">
        			<div id="location">
						<div class="image"></div>
						<p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 场景策略查看</p>
						<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
					</div>
        		<fieldset>
					<legend>场景基本信息 </legend>
					<div id="results_list">
						<table class="table_style"  style="width: 98%;">
							<tr>
								<th width="10%">场景编号</th>
								<th width="20%">场景名称</th>
								<th width="20%">场景所属机构</th>
								<th width="10%">是否已演练</th>
								<th width="30%">场景说明</th>
							</tr>
							<tr>	
								<td>${IGDRM01191VO.planInfo.eilabel} <html:hidden styleId="secenid" property="secenid" value="${IGDRM01191VO.planInfo.eiid}"/></td>
								<td>${IGDRM01191VO.planInfo.scename}</td>
								<td>${IGDRM01191VO.planInfo.orgname}</td>
								<td>${IGDRM01191VO.planInfo.isplan}</td>
								<td>${IGDRM01191VO.planInfo.scedes}</td>
							</tr>
						</table>
					</div>
				</fieldset>
				<!--  message -->
					<ig:message/>
				<!--  /message -->     
				<fieldset>
					<legend>场景基本信息 </legend>
					    <div id="results_list" >
					       <table width="100%" class="table_style">
					       	<tr>
					       		<th width="10%">序号</th>
					       		<th width="40%">策略描述</th>
					       		<th width="20%">关键字</th>
					       		<th width="10%">触发规则BL</th>
					       		<th width="10%">详细信息</th>
					       		<th width="10%">删除</th>
					       	</tr>
					       	 <logic:present name="IGDRM01191VO" property="responseStrategyList" >
					       	 	<logic:iterate id="bean" name="IGDRM01191VO" property="responseStrategyList" indexId="index">
					       	 		<tr class="<ig:rowcss index="${index}"/>">
					       	 			<td>${index+1 }</td>
					       	 			<td>${bean.strategyDesc }</td>
					       	 			<td>${bean.keyword }</td>
					       	 			<td>${bean.handleBL }</td>
					       	 			<td><html:link href="javascript:toSave('${bean.rsid}');"><img src="images/xx.gif" alt="显示详细信息" width="16" height="16"  border="0"/></html:link></td>
					       	 			<td><html:link href="javascript:deleteResponseStrategy('${bean.rsid }');"><img src="images/delete.gif" alt='删除'  width="16" height="16"  border="0"/></html:link></td>
					       	 		</tr>
					       	 	</logic:iterate>
					       	 </logic:present>
					       </table>
		 			</div>
				<div id="operate" style=" margin-left:10px; text-align: center;"> 
					<html:button styleClass="button" onclick="toSave();" property="btn_submit">新增</html:button>
				</div>
			 	</fieldset>
    		</div>
    	</html:form>
	</div>
</div> 
</div>
<script type="text/javascript">	
function toback(){
	window.location.href = getAppRootUrl() + "/IGDRM0104_Back.do";
}
function toSave(rsid){
	var url = "/IGDRM0119_Detail.do?senceid="+jQuery("#secenid").val()+(rsid?"&rsid="+rsid:"");
	var windowName = rsid?"触发策略修改":"触发策略新增";
	openSubWindow(url,windowName,800,600);
}

function deleteResponseStrategy(rsid){
	var alert= '您确认要删除此条信息吗？';
	if(window.confirm(alert)){
		form1.action = getAppRootUrl() + "/IGDRM0119_Del.do?senceid="+jQuery("#secenid").val()+"&rsid=" + rsid;
        form1.submit();
	}

}

function refreshSearch(){
	alert(1);
}
</script>
</body>
</html:html>