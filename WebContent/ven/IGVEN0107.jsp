<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGVEN0107" toScope="request" />
<bean:define id="title" value="风险监测工作执行画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->

<script type="text/javascript">	
<!--
	function toback() {
		form0206.action = getAppRootUrl() + "/IGVEN0201_BACK_1.do";
		form0206.submit();
	}
	
	
	function createHiddenInput(name,value){   
	    var inputElement=document.createElement("input");   
	    inputElement.name=name;   
	    inputElement.value=value;     
	    inputElement.type="hidden";
	    inputElement.id=name;
	    document.forms[1].appendChild(inputElement);   
	}
//-->
</script>
<script type="text/javascript">	


function removeShowRlComment(){
	if(jQuery("#rlshowvaluediv").length > 0){
		jQuery("#rlshowvaluediv").remove();
	}
}


</script>
<style type="text/css"> 
.subscribe{
	background-color:url(images/sub_bg.gif) 0 0 no-repeat; 
	width:84px;
	font:12px "Trebuchet MS",Arial, Helvetica, sans-serif;
	background-color:#EEEEEE;
	color:#000000;
	text-align:right;
	text-transform:uppercase;
	text-decoration:none;
	padding-top:2px;
	display:inline-block;
	padding-bottom:1px;
	margin-left:2px;
	line-height:18px;
	height:18px;
	vertical-align:middle;
	position: relative;
	top: -2px;
}
.input1 {
width:100px;
margin-left:1px;
border:1px solid #ccc;
}
</style>
<style type="text/css">
.rlcomment{cursor: hand;}
#rlshowvaluediv{
	word-wrap:break-word;
	position:absolute;
	z-index: 9999;
	width: 400px;
	min-height: 50px;
	background-color: #eee;
	border:1px solid #ccc;
}
#rlshowvaluediv #title{
	width:395px;
	height:23px;
	line-height:23px;
	font-weight: bold;
	background:url(images/title-23.gif);
	padding-left:5px;
}
#rlshowvaluediv #title #fountDiv{
	width:100px;
	height:23px;
	float: left;
}
#rlshowvaluediv #title #imgDiv{
	width:30px;
	height:23px;
	float: right;
	padding-top:3px;
	cursor: hand;
}
#rlshowvaluediv #content{
	width:395px;
	padding:5px;
	line-height: 20px;
}
</style>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation></ig:navigation>&nbsp;&nbsp;&gt;&gt; 监测工作查询  </p>
<div class="back">
	<html:link href="javascript:toback();">返回</html:link>
</div>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<html:form action="/IGVEN0202_LASTSEARCH">
			<div>
			<span>指标编号：</span>
			<html:text property="eilabel" styleId="eilabel" size="18" errorStyleClass="inputError imeActive"/> 
			&nbsp;&nbsp;<span>指标名称：</span>
			<html:text property="einame" size="18" errorStyleClass="inputError imeActive" /> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:submit property="btn_search" styleClass="button" value="查询" />
			</div>
		</html:form> 
	</div>
</div>
</div>
</div>

<html:form styleId="form0206" action="/IGVEN0203_Insert" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="results_list">
	<ig:message />
	
	<table class="table_style" id="table_list">
			<tr>
				<th width="3%"><label> 
				</th>
				<th width="10%">风险领域</th>
				<th width="10%">风险子域</th>
				<th width="10%">风险项</th>
				<th width="10%">指标编号</th>
				<th width="12%">指标名称</th>
				<th width="14%">监测结果</th>
				<th width="14%">结果说明</th>
				<th width="17%">附件</th>
			</tr>
			<logic:present name="IGVEN02013VO" property="igven02012voList">
				<logic:iterate id="beanvo" name="IGVEN02013VO" property="igven02012voList" indexId="index">
					<bean:define id="bean1" name="beanvo" property="monitoringWorkInfo" ></bean:define>
						<bean:define id="bean2" name="bean1" property="riskIndexSearchVWInfo" ></bean:define>
						<tr class="<ig:rowcss index="${index}"/>">
							<td height="20">
							</td>
							<td>${bean2.riskly } </td>
							<td>${bean2.riskarea } </td>
							<td>${bean2.riskitem } </td>
							<td>${bean2.eilabel } </td>
							<td title="${bean2.einame}" >
								<ig:SubstringShowEllipsisWriteTag len="20" showEllipsis="true">
									${bean2.einame}
								</ig:SubstringShowEllipsisWriteTag>
						    </td>
							<td>
								<ig:codeValue ccid="RISKCHECKRESULT_CODE" cid="${bean1.result}" ></ig:codeValue>					
							</td> 
							<td title="${bean1.resultdesc}" >
								<ig:SubstringShowEllipsisWriteTag len="20" showEllipsis="true">
									${bean1.resultdesc}
								</ig:SubstringShowEllipsisWriteTag>
						    </td>
							<td>
								<html:link action="/IGVEN0202_loadFIle.do?attid=${beanvo.attid}"  styleId='attach${beanvo.attid}'>
								${beanvo.attname}
								</html:link> 				 
							</td>
						</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
		<jsp:include page="/include/paging.jsp" />
	</div>
	<logic:present name="IGVEN02013VO" property="igven02012voList">
	</logic:present>
	<input type="hidden" id="rmid" name="rmid" value="${rmid}">
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
	
</div>

</body>
</html:html>