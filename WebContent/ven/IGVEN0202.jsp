<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGVEN0202" toScope="request" />
<bean:define id="title" value="风险监测工作执行画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->

<script type="text/javascript">	
<!--
	function toback() {
		form0206.action = getAppRootUrl() + "/IGVEN0201_BACK.do";
		form0206.submit();
	}
	//提交校验
	function confirmDisp() {
		var count = 0;
		count = checkAndCreate();
		if (count == 0) {
			alert("请您先选择要提交的记录！");
			return false;
		}
		if (count == 9) {
			return false;
		}
		if (window.confirm("您确定要提交吗？")) {
			return true;
		} else {
			return false;
		}
	}
	
	function checkAndCreate() {
		var count = 0;
		var check = document.getElementsByName("rcr_id");
		var results = document.getElementsByName("result");
		var comments = document.getElementsByName("resultdesc");
		var names = document.getElementsByName("name");

		for ( var i = 0; i < check.length; i++) {
			if (check[i].checked == true) {
				if ((results[i].value).trim() == "") {
					alert("请选择结果！");
					return 9;
				}
				if ((comments[i].value).trim() != "") {
					if ((comments[i].value).strlen() > 120) {
						alert("指标名称为‘" + names[i].value + "’的结果说明不能多于40个汉字！");
						return 9;
					}
				}

			}
		}

		for ( var i = 0; i < check.length; i++) {
			if (check[i].checked == true) {
				count = 1;
				createHiddenInput("rmids", check[i].value);
				createHiddenInput("results", results[i].value);
				createHiddenInput("resultdescs", comments[i].value);
				createHiddenInput("filenum", jQuery(comments[i]).parent().find(
						"input[name='filenums']").val());
			}
		}

		return count;
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
<html:form action="/IGVEN0202">
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
		<span style="font-size:15px;"><strong>查询条件</strong></span>
	</div>
	<div style="margin-top:4px">
		<div>
			<span class="subscribe">指标编号：</span>
			<html:text property="eilabel" styleId="eilabel" size="18" errorStyleClass="inputError imeActive"/> 
			&nbsp;&nbsp;<span class="subscribe">指标名称：</span>
			<html:text property="einame" size="18" errorStyleClass="inputError imeActive" /> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<html:submit property="btn_search" styleClass="button" value="查询" />
		</div>
	</div>
</div>
</div>
</html:form> 
</div>

<html:form styleId="form0206" action="/IGVEN0203_Insert" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="results_list">
	<ig:message />
	
	<table class="table_style" id="table_list">
			<tr>
				<th width="3%"><label> <input type="checkbox"
					name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','rcr_id')"/> </label>
				</th>
				<th width="9%">风险领域</th>
				<th width="8%">风险子域</th>
				<th width="11%">风险项</th>
				<th width="10%">指标编号</th>
				<th width="12%">指标名称</th>
				<th width="11%">监测结果</th>
				<th width="12%">结果说明</th>
				<th width="16%">附件</th>
				<th width="8%">指派工作</th>
			</tr>
			<logic:present name="IGVEN02013VO" property="igven02012voList">
				<logic:iterate id="beanvo" name="IGVEN02013VO" property="igven02012voList" indexId="index">
					<bean:define id="bean1" name="beanvo" property="monitoringWorkInfo" ></bean:define>
						<bean:define id="bean2" name="bean1" property="riskIndexSearchVWInfo" ></bean:define>
						<tr class="<ig:rowcss index="${index}"/>">
							<td height="20">
								<label>
									<c:if test="${bean1.result != 'A' && bean1.result != 'B' && bean1.result != 'C'}">
										<input type="checkbox" name="rcr_id" value="${bean1.mwid}">
									</c:if>
							 	</label>
							</td>
							<td>${bean2.riskly } </td>
							<td>${bean2.riskarea } </td>
							<td>${bean2.riskitem } </td>
							<td>${bean2.eilabel } </td>
							<td title="${bean2.einame }">
								<ig:SubstringShowEllipsisWriteTag len="21" showEllipsis="true">
									${bean2.einame }
								</ig:SubstringShowEllipsisWriteTag>
							</td>
							<td>
								<c:if test="${bean1.result != 'A' && bean1.result != 'B' && bean1.result != 'C'}">
									<html:select property="result" styleId="result">
	                      				<ig:optionsCollection ccid="RISKCHECKRESULT_CODE" isMakeBlankRow="true" isCodeLabel="true" />
	                    			</html:select>
								</c:if>
								<c:if test="${bean1.result == 'A' || bean1.result == 'B' || bean1.result == 'C'}">
									<ig:codeValue ccid="RISKCHECKRESULT_CODE" cid="${bean1.result}" ></ig:codeValue>					
								</c:if>
							</td> 
							<td 
								<c:if test="${bean1.result == 'A' || bean1.result == 'B' || bean1.result == 'C'}">
									title ="<bean:write name="bean1" property="resultdesc"/>"
								</c:if>
							 >
								<c:if test="${bean1.result != 'A' && bean1.result != 'B' && bean1.result != 'C'}">
									<html:textarea property="resultdesc" cols="11" rows="2" value="" errorStyleClass="inputError imeActive">
									</html:textarea>
								</c:if>
								<c:if test="${bean1.result == 'A' || bean1.result == 'B' || bean1.result == 'C'}">
									<ig:SubstringShowEllipsisWriteTag len="17" showEllipsis="true">
										<bean:write name="bean1" property="resultdesc"/> 
									</ig:SubstringShowEllipsisWriteTag>
								</c:if>
								<input type="hidden" name="filenums" value="${index}"/>
							</td>
							<td>
								 <c:if test="${bean1.result != 'A' && bean1.result != 'B' && bean1.result != 'C'}">
									<input type="file" name="attachFile[${index}]" onkeydown="return false;" class="imeDisabled" size="15">
									<input type="hidden" name="name" value="${bean2.einame}">
								</c:if>
								<c:if test="${bean1.result == 'A' || bean1.result == 'B' || bean1.result == 'C'}">
									<html:link action="/IGVEN0202_loadFIle.do?attid=${beanvo.attid}"  styleId='attach${beanvo.attid}'>
									${beanvo.attname}
									</html:link> 				
								</c:if> 
							</td>
							<td id="assignwork">
								<c:if test="${bean1.result != 'A' && bean1.result != 'B' && bean1.result != 'C'}">
									<logic:empty name="bean1" property="assignprid" >
										<a href="javascript:void(0)" onclick="zhipai('${bean1.mwid}','${rmid}');">发起</a>
									</logic:empty>
									<%-- <a href="IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01140&ptid=8&actname=ACT04RIS0302&parameters=${bean1.rcrid}&cwrid=${cwrid}">发起</a> --%>
									<logic:notEmpty name="bean1" property="assignprid">
									<a href="javascript:void(0)"  onclick="chakan('${bean1.assignprid}','${rmid}');">
										查看
									</a>
									</logic:notEmpty>
								</c:if>
								<c:if test="${bean1.result == 'A' || bean1.result == 'B' || bean1.result == 'C'}">
									<logic:notEmpty name="bean1" property="assignprid">
										<a href="javascript:void(0)"  onclick="chakan('${bean1.assignprid}','${rmid}');">
											查看
										</a>
									</logic:notEmpty>	
								</c:if>
								<input type="hidden" name="assignprid" value="${bean1.assignprid}"/>
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
	<div class="enter">
		<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" />
		<html:submit property="btn_insert" value="批量发起" styleClass="button" onclick="return piliang();" />
		<html:reset property="btn_clear" styleClass="button" value="重置" />
	</div>
	</logic:present>
	<input type="hidden" id="rmid" name="rmid" value="${rmid}">
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
	
</div>

</body>
<script type="text/javascript">
	jQuery("input:checkbox[name='rcr_id']").each(function(index,obj){
		obj = jQuery(obj);
		obj.unbind();
		obj.bind("click",function(){
			jQuery(this).attr("style","");
		});
	});
	jQuery("#checkbox1").unbind();
	jQuery("#checkbox1").bind("click",function(){
		if(jQuery(this).attr("checked")){
			jQuery("input:checkbox[name='rcr_id']").each(function(index,obj){
				jQuery(obj).attr("checked","true");
			});
		}else{
			jQuery("input:checkbox[name='rcr_id']").each(function(index,obj){
				jQuery(obj).attr("style","");
				jQuery(obj).attr("checked","");
			});
		}
	});
	function chakan(assignprid,rmid){
		var href= 'IGPRR0102_Disp.do?prid='+ assignprid +'&jump=474&rmid=' +rmid;
		window.location.href= href;
	}
	function zhipai(assignprid,cwrid){
		var href= 'IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01004&ptid=8&parameters='+assignprid+'&cwrid='+cwrid;
		window.location.href= href;
	}
	function piliang(){
		var count=0;
		count=checkAndCreate1();
		if(count==0){
			alert("请您先选择要发起的工作！");
			return false;
		}
		if(count==9){
			alert("您选择的工作中存在已经发起工作(红圈的工作)，请重新选择！");
			return false;
		}
		if(window.confirm("您确定要发起这些工作吗？")){
			document.getElementById("form0206").action = getAppRootUrl() + '/IGVEN0203_BATCH.do';
		 	return true;			
		 } else {
			return false;
		 } 
	}
	function checkAndCreate1(){
		var count=0;
		var check = document.getElementsByName("rcr_id");
		var results = document.getElementsByName("result");
		var comments = document.getElementsByName("resultdesc");
		var names = document.getElementsByName("name");
		var assignprid = document.getElementsByName("assignprid");
		var flag = 0;
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				var inputNode = check[i].parentElement.parentElement.parentElement.lastChild.firstChild.nextSibling;
				if(typeof(inputNode.value) != "undefined"){
					jQuery(check[i]).css("border","thin solid red");
					var checkEd = jQuery("input:checkbox:eq(i)[name='rcr_id']");
					flag = 1;
				}
			}
		}
		if(flag == 1){
			return 9;
		}
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				count=1;
				createHiddenInput("rmids", check[i].value);
				createHiddenInput("results", results[i].value);
				createHiddenInput("resultdescs", comments[i].value);
				createHiddenInput("filenum", jQuery(comments[i]).parent().find(
						"input[name='filenums']").val());
			}
		}
	    return count;
	}
	
	
</script>

</html:html>