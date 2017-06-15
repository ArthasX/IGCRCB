<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>

<html:html>
<bean:define id="id" value="IGRIS0237" toScope="request" />
<bean:define id="title" value="检查任务查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	
	function readInfo(cwrid){
		var csid = document.getElementById("csid").value;
		var form = document.getElementById("form");
		form.action="IGRIS0203_sel_read.do?cwrid="+cwrid +"&csid="+csid;
		form.submit();

	}
	
function showIncident(){
	var ccid = "106";
	var cid = "";
	var syscode = "";
	if(null==syscode || ""==syscode){
		syscode = ccid;
	}else{
		ccid = syscode.substring(0,3);
	}

	url = "IGSYM1505_TREE.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("rccategory").value="";
		$("rccategoryname").value="";
			return false;
		}
	if(null!=temp && temp.split("|").length>1){
		var id = temp.split("|")[0];
		var name = temp.split("|")[1];
		var treeccid;
		var treecid;
		var treesyscode;
		
		if(id.split("_").length>1){
			treeccid = id.split("_")[0];
			treecid = id.split("_")[1];
			treesyscode = id.split("_")[2];
		}else{
			treeccid = id.split("_")[0];
			treecid = "";
			treesyscode = "";
		}
		$("rccategory").value=treesyscode;
		$("rccategoryname").value=name;
		
	}		
	
}
//-->

	window.onload=function(){
		var obj = document.getElementById("table_list");
		var date=new Date();
		var mon=((date.getMonth()+1).toString().length==1?"0"+(date.getMonth()+1):(date.getMonth()+1));
		var day=date.getDate().toString().length==1?"0"+date.getDate():date.getDate();
		var h=date.getHours().toString().length==1?"0"+date.getHours():date.getHours();
		var min=date.getMinutes().toString().length==1?"0"+date.getMinutes():date.getMinutes();
		var time=date.getYear()+"/"+mon+"/"+day+" "+h+":"+min;
		for(var i=1;i<obj.rows.length;i++){
			//计划结束时间
			var endtime=obj.rows[i].cells[3].innerHTML;
			//实际检查时间
			var checktime=obj.rows[i].cells[5].innerHTML;
			/* 如果实际检查时间不为空,则拿实际检查时间与计划结束时间比较,
			  // 如果实际检查时间为空,则拿计划结束时间与当前时间比较
			*/
			if(checktime!=''){
				if(endtime<checktime){
					obj.rows[i].cells[0].innerHTML = "<img src='images/cs1.png' align='middle' style='cursor:pointer;'  border='0' id='cs' />";
				}
			}else{
				if(time>endtime){
					obj.rows[i].cells[0].innerHTML = "<img src='images/cs1.png' align='middle' style='cursor:pointer;'  border='0' id='cs' />";
				}
			}
		}
	};
	function toback(){
		form.action = getAppRootUrl() + "/IGCOM0202.do?linkID=IGRIS0201";
		form.submit();
	 }
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGRIS0237_SERACH" onsubmit="return checkSubmit(this);" >
<div id="location">
<div class="image"></div>
<p class="fonts1">检查任务管理&gt;&gt; 检查任务查询&gt;&gt; 检查任务管理</p>
<div class="back">
	<html:link href="javascript:toback();">返回</html:link>
</div>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
	</div>
	<div>
		<span class="subscribe">检查方式：</span>
		<html:select property="rcrtestmode" styleId="rcrtestmode" style="margin-left:-5px">
		<ig:optionsCollection ccid="RISKCHECK_CLASS_TYPE" isMakeBlankRow="true" isCodeLabel="true" />
		</html:select> 
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<span class="subscribe">检查任务名称：</span>
		<html:text property="rcrcomment" styleId="rcrcomment" errorStyleClass="inputError imeDisabled" size="15" maxlength="32"  tabindex="1" />
		<span class="subscribe">责任人：</span>
		<html:text property="rcusername_like" size="15" styleId="rcusername_like"/>
		
		<html:submit styleClass="button" value="查询" />
		<html:hidden property="rccategory"/>
	</div>
	<div style="margin-top:12px;">
		<span class="subscribe">任务开始时间：</span>
		<html:text property="ntime_from" readonly="true" size="18" style="width:118px;"/>
		<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('ntime_from'))" border="0" />
		<span>&nbsp;--&nbsp;</span>
		<html:text property="ntime_to" readonly="true" style="width:118px;"/>
		<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('ntime_to'))" border="0" />
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<span class="subscribe">实际完成时间：</span>
		<html:text property="etime_from" readonly="true" size="18" style="width:118px;"/>
		<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('etime_from'))" border="0" />
		<span>&nbsp;--&nbsp;</span>
		<html:text property="etime_to" readonly="true" style="width:118px;"/>
		<img src="images/date.gif" align="middle" style="cursor:pointer;" onClick="calendar($('etime_to'))" border="0" />
	</div>
	<div style="margin-top:8px;"></div>
	</div>
</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style" id="table_list">
			<tr>
				<th width="7%">序号</th>
				<th width="18%">检查任务名称</th>
				<th width="5%">检查方式</th>
				<th width="15%">责任人</th>
				<th width="10%">合作执行人</th>
				<th width="10%">计划开始时间</th>
				<th style="display: none;" >prid</th>
				<th width="10%">实际完成时间</th>
				<th width="8%">进度</th>
			</tr>
			<logic:present name="IGRIS02013VO" property="igris02012voList">
				<logic:iterate id="beanvo" name="IGRIS02013VO" property="igris02012voList" indexId="index">
					<bean:define id="bean1" name="beanvo" property="checkWorkResultInfo" ></bean:define>
					<%-- <bean:define id="bean" name="bean1" property="riskCheck" ></bean:define> --%>
					<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="readInfo('${bean1.cwrid}')">
						
						<%-- <td>
							<img src="images/${bean1.rctype}.gif" alt="重要程度：<ig:codeValue ccid="RISKCHECK_TYPE_CODE"
									cid="${bean1.rctype}"/>" width="10" height="16" />
						</td>
						<td>${bean.rccategoryname}</td> --%>
						<td >
							<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
						</td>
						<td>
							${bean1.cwrname}
						</td>
						
						<%-- <td>
						<c:if test="${not empty bean1.rcrrealtime}">已检查</c:if>
						
						<c:if test="${empty bean1.rcrrealtime}">未检查</c:if>
						</td> --%>
						
						<td>
							
							<ig:codeValue ccid="RISKCHECK_CLASS_TYPE"  cid="${bean1.cwrtestmode}"/>
							<%-- 
							<c:if test="${bean1.cwrtestmode=='1'}" >内部常规</c:if>
							<c:if test="${bean1.cwrtestmode=='2'}" >等级保护</c:if>
							<c:if test="${bean1.cwrtestmode=='3'}" >专项</c:if> --%>
						</td>
						<td>${bean1.cwrusername}</td>
						<td>${bean1.cwrassetname}</td>
						<td>${bean1.cwrplandate}</td>
						<td style="display: none;">${bean1.cwrid}</td>
						<td>${bean1.cwrrealtime}</td>
						<td>${bean1.cwrrate}%</td>
						
						<%-- <td></td> 
						<td style="display: none;">${bean1.cwrid}</td>
						
						<td>
						<c:if test="${bean.rcrtestmode==1}" >内部常规</c:if>
						<c:if test="${bean.rcrtestmode==2}" >等级保护</c:if>
						<c:if test="${bean.rcrtestmode==3}" >专项</c:if>
						</td>
						<td>${bean.rcrolename}</td>

						
						<td>${bean.ciiop}</td>
						<td>${bean1.rcrusername }</td>
						<td>
						<c:if test="${bean1.rcrresult=='A'}" >正常</c:if>
						<c:if test="${bean1.rcrresult=='B'}" >存在问题</c:if>
						<c:if test="${bean1.rcrresult=='C'}" >存在重大问题</c:if>
						</td> --%>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
	<html:hidden property="csid" styleId="csid"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>