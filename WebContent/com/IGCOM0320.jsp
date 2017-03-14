<%@ page buffer="2048kb" language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="java.util.Map"%>
<%@ page import="java.net.URLEncoder" %>
<html:html>
<bean:define id="id" value="IGCOM0320" toScope="request"/>
<bean:define id="title" value = "资产详细画面" toScope="request" />
<%
	String temp_srname = String.valueOf(request.getAttribute("temp_srname"));
%>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<link rel="stylesheet" href="<html:rewrite forward='pop.css'/>" type="text/css">
	
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<STYLE>
html{
  overflow-y: auto;
  overflow-x: hidden;
}

</STYLE>
<script type="text/javascript">

     function mousedown(obj,eiids){
       var color =  obj.style.backgroundColor;
       //清除端口行的颜色
       var table = document.getElementById("porttable");
       var trList = table.childNodes;
       for(var i = 0; i < trList[0].childNodes.length; i++){          
            trList[0].childNodes[i].style.backgroundColor=''; 
       }
     //清除Zoning行的颜色
       table = document.getElementById("zoningtable");
       trList = table.childNodes;
       for(i = 0; i < trList[0].childNodes.length; i++){          
           trList[0].childNodes[i].style.backgroundColor=''; 
       }
       var eiid = eiids.split(";");
       //如果本身不为红，则变红，否则颜色清了就清了
       if(color != 'red'){
    	   for (i = 0; i < eiid.length; i++) {
     	       var myele = document.getElementById(eiid[i]);
     	       if(myele!=null){
     	    	  myele.style.backgroundColor='red'; 
         	   }   	     
     	    }
     	    obj.style.backgroundColor = 'red';   
       }    
     }
     function mouseOverNoHand(obj){
        if(obj.style.backgroundColor!='red'){
    	  obj.style.backgroundColor='#F8F8F8';
        }
     }
     function mouseOutNoHand(obj){
    	if(obj.style.backgroundColor!='red'){
    	  obj.style.backgroundColor='';
    	}
     }
</script>
<style>
  html,body {
	margin: 0;
	padding: 0;
	height: 100%;
	font-size: 12px;
	overflow-x: hidden;
	background-color: #FFFFFF;
	background-image:none;
 }
</style>
<body onload="startCheckOpenerClosed();">
<% 
    int fsTypeTotal = 0;
    int capacityTotal = 0;
%>

<div id="maincontent" style="background-color: #FFFFFF;background-image:none;">
<div class="message" ><ig:message /></div>
<div id="container">
	    
<!--	    <div class="message"><ig:message /></div>-->
<!-- 将上句移动到container的div外面，解决当最大化窗口时无信息提示的位置变动问题-->
           <div id="location" style="width:100%">
	            <div class="image"></div>
	            <p class="fonts1">资产详细信息</p>
	       </div>
           	   <div class="title" style="width: 100%;">
	             <div class="name">资产基本信息</div>
	           </div>
	           <table class="table_style2_SOC">
	              <tr>
	                   <th>交换机名称</th>
	                   <th>IP 地址</th>
	                   <th>Domain ID</th>
	                   <th>当前Zone配置</th>
	              </tr>
	               <tr>
	                   <bean:define id="item" name="IGCOM03201VO" property="switchConfigItem"></bean:define>
	                   <td>${item.switchname}</td>
	                   <td>${item.switchip}</td>
	                   <td>${item.switchdomain}</td>
	                   <td>${item.effectivecfg}</td>
	              </tr>
	           
	           </table>
	            <div class="title" style="width:60%;float:left;">
	             <div class="name">端口信息</div>
	           </div>
	            <div class="title" style="width:40%;float:right;">
	             <div class="name">Zoning配置</div>
	           </div>
				<div class="record_list" style="height:400px;width:60%;float: left">
				<!--  <div class="record_list" style="height:380px;overflow-x:scroll;"> -->
				
				<table class="table_style2_SOC">
					<tr>
						<th width="10%">No.</th>
						<th width="20%">端口</th>
						<th width="36%">WWN</th>
						<th width="30%" align="center">所连接设备描述</th>			
					    <th width="4%"></th>
					</tr>
				</table>										
				<div style="overflow-y:auto;height:350px;overflow-x:hidden;width:100%;">
				 <logic:present name="IGCOM03201VO" property="portList">		
					<table class="table_style2_SOC" style="width:96%" id = "porttable">
							<logic:iterate id="bean" name="IGCOM03201VO" property="portList" indexId="index" type="com.deliverik.framework.soc.asset.model.SOC0132VW">
							<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" onclick="mousedown(this,'${bean.eiids}')" id = "${bean.eiid}" >
									<!-- 序号 -->
									<td width="10%">								
										${index+1}									
									</td>
									<td width="20%">${bean.port}</td>									
									<td width="36%">${bean.wwn}</td>
									<td width="30%"></td>						
							</tr>
							</logic:iterate>
					</table>
					</logic:present>
				 </div>		
			   </div>		
				<div class="record_list" style="height:400px;width:40%;float: right;">				
				<table class="table_style2_SOC">
					<tr>
						<th width="60%">Zone名称</th>
						<th width="36%">Zone成员</th>	
						<th width="4%"></th>	
					</tr>
				</table>										
				<div style="overflow-y:auto;height:350px;overflow-x:hidden;width:100%;">
				<logic:present name="IGCOM03201VO" property="zoneList">	
					<table class="table_style2_SOC" style="width:96%" id ="zoningtable">
							<logic:iterate id="bean" name="IGCOM03201VO" property="zoneList" indexId="index" type="com.deliverik.framework.soc.asset.model.SOC0133VW">
							<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" onclick="mousedown(this,'${bean.eiids}')" id = "${bean.eiid}">
									<!-- 序号 -->
									<td width="60%"><%=bean.getZonename().substring(bean.getZonename().lastIndexOf("_")+1)%></td>	<!-- ${bean.zonename}	 -->							
									<td width="36%">${bean.zonemember}</td>														
							</tr>
							</logic:iterate>
					</table>
				</logic:present>
				 </div>		
			  </div>	
</div>
</div>
</body>
</html:html>