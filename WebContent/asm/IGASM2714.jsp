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
<html:html>
<bean:define id="id" value="IGASM2714" toScope="request" />
<bean:define id="title" value="风险点资产查询画面" toScope="request" />
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
<script type="text/javascript">	
         var gid='IGASM2702';

function setEntity(url){
	url = url+"?roletype=IGAC13&subtype=999017&selecedlast=0";
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].ename.value = "";
		//document.forms[0].eid.value = "";
		document.forms[0].syscoding.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		var syscode_eid = temp.split("|")[0];
		var name = temp.split("|")[1];
		var syscode;
		var eid;
		if(syscode_eid =="999")
		{
			alert("资产模型不可用！请选择其他模型！");
			return false;
			
		}else if(syscode_eid.split("_").length>1){
			eid = syscode_eid.split("_")[0];
			syscode = syscode_eid.split("_")[1];
		}
		document.getElementById("ename").value = name; 
		document.getElementById("syscoding").value = syscode;
}
}
	function searchuser(){	
		openSubWindow('/IGSYM1905_Disp.do?', '_blank','1000','600','center:1');
	}
	function setIGCYB0101Params(username,orgname,orgid,useremail,userphone,usermobile,userid){
		document.getElementById("managername").value = username;
		document.getElementById("mguserid").value = userid;
	}
	function checkitem(eid,version){
		window.location.href="IGASM2704_Disp.do?eiid="+eid+"&eiversion="+version+"&looksign=0";;
	}
	
	
	function onExcel(){
		form.action = "IGASM2714_Excel.do";
		form.submit();
	}
	function onSearch(){
		form.action = "IGASM2714.do";
		form.submit();
	}
	function onShow(){
		document.getElementById("div_0.0").style.display="";
		document.getElementById("label_img").innerHTML = "<img src=\"images/backup.gif\" align=\"middle\" alt=\"收起\" onclick=\"onHidden()\" style=\"cursor: hand;\" border=\"0\"/>";
	}
	function onHidden(){
		document.getElementById("div_0.0").style.display="none";
		document.getElementById("label_img").innerHTML = "<img src=\"images/moreSearch.gif\" align=\"middle\" alt=\"更多搜索条件\" onclick=\"onShow()\" style=\"cursor: hand;\" border=\"0\"/>";
	}
	function condition(){
		var hiddendiv = jQuery(".conditions").find("div[id^='div_']:hidden");
		hiddendiv.each(function(i,o){
			o=jQuery(o);
			var e=o.find("input:not(:empty),select[value!='']").length;
			if(e>0){
				onShow();
			}
		});
	}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body onload="condition();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
          <html:form styleId="form" action="/IGASM2714" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">风险管理&gt;&gt; 风险库管理&gt;&gt;风险点查询</p>
            </div>
            <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                    <div style="margin-top:4px">
						<span style="font-size:15px;"><strong>查询条件</strong></span>
						<label id="label_img" style="margin-left:736px;margin-top:-1px;">
				    		<img src="images/moreSearch.gif" align="middle" alt="更多搜索条件" onclick="onShow()" style="cursor: hand;" border="0"/>
				   	    </label>
					</div>
				   <div>
                   <span class="subscribe">风险分类：</span>
                   <html:text property="ename" styleId="ename" readonly="readonly"  size="16"/>
                    <img src="images/tree.gif" style="cursor: hand;" alt="风险分类" width="16" height="16" border="0" onclick="setEntity('IGSYM0304_RISK.do');"/>
            		<span class="subscribe">风险点名称：</span>
            		<html:text property="einame" styleId="einame"/>
            		<span class="subscribe">风险点编号：</span>
            		<html:text property="eilabel" styleId="eilabel"/>
					<html:hidden property="syscoding"/>
					<span class="subscribe">风险严重等级：</span>
					 <html:select property="grad" name="IGASM2713Form" style="width:100px;height:20px;margin:0px;">
			               	 <option value=""></option>
					    <logic:present name="IGASM27071VO" property="gradeList" >
					    <html:optionsCollection name="IGASM27071VO" property="gradeList" label="ccdvalue" value="ccdvalue"/>
						</logic:present>
           			 </html:select>
           			 <html:button property="btn_search" style="margin-left:5px" styleClass="button" value="查询" onclick="onSearch()" />
                   </div>
                   <div style="margin-top:12px">
                    <span class="subscribe">管理人：</span>
                    <html:text property="managername" styleId="managername" size="10"/>
            		<img  id="img01" src="images/seek.gif" border="0" style="cursor: pointer;" onclick="searchuser();"/>
            		<span class="subscribe">风险发生可能：</span>
					 <html:select property="poss">
			             <option value=""></option>
					    <logic:present name="IGASM27071VO" property="possibleList" >
							 <html:optionsCollection name="IGASM27071VO" property="possibleList" label="ccdvalue" value="ccdvalue"/>
						</logic:present>
           			 </html:select>
           			 <span class="subscribe">登记日：</span>
					<html:text property="startdate" styleId="startdate"  errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
					<img src="images/date.gif" align="middle" onclick="calendar($('startdate'))" border="0" style="cursor: hand" />
					<span>&nbsp;--&nbsp;</span>
					<html:text property="enddate" styleId="enddate" errorStyleClass="inputError imeDisabled" size="16" readonly="true" />
					<img src="images/date.gif" align="middle" onclick="calendar($('enddate'))" border="0" style="cursor: hand" />
            		<input type="button" value="导出" class="button" style="margin-left:39px;" onclick="onExcel()">
                   <html:hidden property="mguserid" styleId="mguserid"/>	
                   </div>
                   <div id="div_0.0" style="display:none" style="margin-top:12px">
                   <span class="subscribe">风险点标志：</span>
					 <html:select property="risksign" >
			               	 <option value=""></option>
					    <logic:present name="IGASM27071VO" property="signList" >
		                <html:optionsCollection name="IGASM27071VO" property="signList" label="ccdvalue" value="ccdvalue"/>
						</logic:present>
           			 </html:select>
                   </div>
                   </div>
                </div>
                
                <div id="results_list">
					<ig:message />
                    <table class="table_style" >
						<!-- header部 -->
						
							<tr>
								<th width="12%">风险领域</th>
								<th width="12%">风险子域</th>
								<th width="10%" >风险项</th>
								<th width="8%">风险点编号</th>
								<th width="14%">风险点名称</th>
								<th width="6%">风险级别</th>
								<th width="8%">风险严重等级</th>
								<th width="10%">风险发生可能性</th>
								<th width="6%">管理人</th>
							</tr>
						
						<!-- body部 -->
						 <logic:present name="IGASM27071VO" property="riskList" >
		               <logic:iterate id="bean" name="IGASM27071VO" property="riskList" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">

											
										<td>
											${bean.riskly }
										</td>
											
										<td>
											${bean.riskarea}
										</td>
											
										<td>
											${bean.riskitem}
										</td>
										<td>
										<a href="javascript:void(0)" onclick="checkitem('${bean.eiid}','${bean.eiversion }')">${bean.eilabel}</a>
										</td>
										
										<td>
											${bean.einame }
											
										</td>
										<td>
											${bean.levels }
										</td>
										<td>
											${bean.grad }
										</td>
										<td>
											${bean.poss }
										</td>
										<td>
											${bean.mguserid}
										</td>
									</tr>
									
									</logic:iterate>
									</logic:present>
					</table>
				</div>
				<div id="operate">
	             <jsp:include page="/include/paging.jsp" />
                </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>