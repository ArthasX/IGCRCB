<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html >
<bean:define id="id" value="IGRAM0201" toScope="request" />
<bean:define id="title" value="评分历史记录" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<style type="text/css">

.table_style33{    
    width:auto;    
    margin:0 auto;    
    border-collapse:collapse;     
    text-align:center;    
}    
.table_style33 th{ 
	color:#000000;   
    border-top:1px solid #CCCCCC;
    border-bottom:1px solid #CCCCCC; 
    background-color:#EEEEEE;
    word-break: break-all;
     
}    
.table_style33 td{ 
    border-bottom:1px solid #DDDDDD;
	
    word-break: break-all;  
}
.table_style33 input{
    height:20px;
}
</style>
<body >
<!-- 	<div id="maincontent" >
		<div id="container"> -->
			<div id="location" style="margin-top: 10px" >
				<div class="image"></div>
				<p class="fonts1">评分历史记录</p>
			</div>
			<div style="margin:10px; overflow-x:scroll; width:98%;" >
			<bean:size id="size" name="IGRAM02011VO" property="ppList"/>
			<c:set var="wid" value="${size+1}"></c:set>
				<table class="table_style33" border="1" style="margin:10px; width:${wid*400+100}px;">
					<tr>
						<th colspan="2" style="width:500px"></th>
						<logic:present name="IGRAM02011VO" property="ppList">
							<logic:iterate id="pp" name="IGRAM02011VO" property="ppList"
								indexId="index">
								<th colspan="2" style="width:400px">${pp.ppusername}</th>
							</logic:iterate>
						</logic:present>
					</tr>
					<tr>
						<th style="width:100px">评估分类</th>
						<th style="width:400px">评估名称</th>
						<logic:present name="IGRAM02011VO" property="ppList">
							<logic:iterate id="pp" name="IGRAM02011VO" property="ppList"
								indexId="index">
								<th style="width:70px">评估分数</th>
								<th style="width:330px">备注</th>
							</logic:iterate>
						</logic:present>
					</tr>
					
		<logic:present name="IGRAM02011VO" property="prjMap">
			<c:set var="index" value="1"></c:set>
			<logic:iterate id="prjMap" name="IGRAM02011VO" property="prjMap">
				<bean:define id="pt" name="prjMap" property="key"
					type="java.lang.String" />
				<bean:define id="prjMapList" name="prjMap" property="value"
					type="java.util.ArrayList" />
				<bean:size id="size" name="prjMapList" />
				<c:if test="${not empty pt}">
				<tr>
					<td rowspan="${size}">${pt}</td>
					<!--评估项  -->
					<logic:iterate id="valueBean" name="prjMapList" indexId="num">
							<bean:define id="astb" name="valueBean"
							type="com.deliverik.framework.workflow.prd.model.IG007Info"/>
					
						<td align="left">${index}.&nbsp; ${astb.pidlabel }</td>
						<c:set var="index" value="${index+1}"></c:set>
						<c:set var="totalprj" value="${totalprj+1 }"></c:set>
						<html:hidden property="assyscoding" value="${astb.pidid}" /> 
						<logic:iterate id="hs" name="IGRAM02011VO" property="hsList"
									indexId="cc">
							<bean:size id="size" name="IGRAM02011VO" property="hsList" />
							
							<c:if test="${astb.pidid==hs.pidid}">
								<td>${hs.ppivalue }</td>
								<td> ${hs.ppicommect } &nbsp;</td>
							</c:if>
						</logic:iterate>
					
				</tr>
			</logic:iterate>
				</c:if>
			</logic:iterate>
		</logic:present>
				</table>
			</div>
			<div class="enter">
				<input type="button" class="button" value="关闭"
					onclick="window.close();">
			</div>
</body>
</html:html>

