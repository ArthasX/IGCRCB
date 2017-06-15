<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGSMR0801" toScope="request" />
<bean:define id="title" value="填报考核" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
</style>
<script type="text/javascript">
function checkForm(){
	if($F('assesstype').trim() == ""){
		alert("请选择考核类别！");
		return false;
	}
	var url  = document.getElementById("assesstype").value;
	//获得考核周期
	var starttime = document.getElementById("assessstartdate").value;
	
	var overtime = document.getElementById("assessoverdate").value;
	if(url=="1"){
		var form = document.getElementById("form");
		form.action="IGSMR0801_SEARCH.do?assesstype="+url;
		form.submit();
		
	}
	if(url=="2"){
		var form = document.getElementById("form");
		form.action="IGSMR0801_SEARCH.do?assesstype="+url;
		form.submit();
	}
		

}
function reportexport(url){
	if(url=="1"){
		var form = document.getElementById("form");
		form.action="IGSMR0801_EXPORT.do?assesstype="+url;
		form.submit();
		
	}
	if(url=="2"){
		var form = document.getElementById("form");
		form.action="IGSMR0801_EXPORT.do?assesstype="+url;
		form.submit();
	}
}
</script>
<body>
	<div id="maincontent">
		<!--container 左菜单 右侧内容-->
		<!-- 新增加流程菜单 结束 -->
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />

		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<div id="location">
						<div class="image"></div>
						<p class="fonts1">
							<ig:navigation />
						</p>
						
					</div>
					<div id="search">
					<html:form action="/IGSMR0801_SEARCH" styleId="form" onsubmit="return checkForm();">					
					 <div class="img"></div>
					 <div class="conditions">
                       <span><span class="red">*</span>考核类别</span>：
                       <html:select property="assesstype" name="IGSMR0801Form">
                        <html:option value=""></html:option>
                       <html:option value="1">部门考核</html:option>
                       <html:option value="2">人员考核</html:option>
                       </html:select>
                        &nbsp;&nbsp;
                         <span>考核开始日期：</span><html:text property="assessstartdate" styleId="assessstartdate" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="showDate($('assessstartdate'))" border="0" style="cursor: hand" /> &nbsp;&nbsp;
		<span>考核结束日期：</span><html:text property="assessoverdate" styleId="assessoverdate" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="showDate($('assessoverdate'))" border="0" style="cursor: hand" />
		     			<html:submit property="btn_search" styleClass="button" value="查询" />
		     			</div>
		     			</html:form>
		     			</div>
		     			
		     			<logic:present name="IGSMR08011VO" property="list">
		     			<div id="results_list">
<!-- 		     			<div style="text-align:center;font-weight:bold;font-size:22px;">填报质量考核（部门）</div> -->
<!-- 		     			<div style="text-align:center;font-size:18px;"><span id="orground">考核周期</span></div> -->
						<table class="table_style">
							<tr>
								<th width="20%" rowspan="2">填报部门</th>								
								<th width="23%" colspan="3">年报</th>
								<th width="23%" colspan="3">季报</th>
								<th width="24%" colspan="3">不定期报表</th>
							</tr>
							<tr>
								<th >填报次数</th>
								<th>及时率</th>
								<th >准确率</th>
								<th >填报次数</th>
								<th >及时率</th>
								<th >准确率</th>
								<th >填报次数</th>
								<th>及时率</th>
								<th >准确率</th>
							</tr>
			<logic:iterate id="vo" name="IGSMR08011VO" property="list">
			<tr>
			<td>
			<html:link action="/IGSMR0803.do?orgid=${vo.orgid }" style="text-decoration:underline;">	
			${vo.orgname }
			</html:link>
			</td>		
			<td>
			${vo.yearnum }
		 	</td>
		 	<td>
		 	${vo.yeartime }
		 	</td>
		 	<td>
		 	${vo.yeartrue }
			</td>
		 	<td>
		 	${vo.quarternum }
		 	</td>
		 	<td>
		 	${vo.quartertime }
		 	</td>
		 	<td>
		 	${vo.quartertrue }
		 	</td>
		 	<td>
		 	${vo.notimenum }
		 	</td>
		 	<td>
		 	${vo.notime }
		 	</td>
		 	<td>
		 	${vo.notimetrue }
		 	</td>
			</tr>
			</logic:iterate> 
			<bean:define id="sumorg" name="IGSMR08011VO" property="orgsum"/>  
			<tr>
			<td>
			合计
			</td>		
			<td>
			${sumorg.yearnum }
		 	</td>
		 	<td>
		 	${sumorg.yeartime }
		 	</td>
		 	<td>
		 	${sumorg.yeartrue }
			</td>
		 	<td>
		 	${sumorg.quarternum }
		 	</td>
		 	<td>
		 	${sumorg.quartertime }
		 	</td>
		 	<td>
		 	${sumorg.quartertrue }
		 	</td>
		 	<td>
		 	${sumorg.notimenum }
		 	</td>
		 	<td>
		 	${sumorg.notime }
		 	</td>
		 	<td>
		 	${sumorg.notimetrue }
		 	</td>
			</tr>                                	        	
			</table>
			</div>
			<div style="margin-left:8px;">
			<html:button property="btn_search" styleClass="button" value="导出"  onclick="reportexport('1');"/>
			</div>
			</logic:present>
			<logic:present name="IGSMR08011VO" property="map">
			<div id="results_list">
<!-- 			<span>填报质量考核（人员）</span> -->
			<table class="table_style">
							<tr>
								<th width="15%" rowspan="2">填报部门</th>
								<th width="15%" rowspan="2">填报人员</th>
								<th width="20%" colspan="3">年报</th>
								<th width="20%" colspan="3">季报</th>
								<th width="20%" colspan="3">不定期报表</th>
							</tr>
							<tr>
								<th >填报次数</th>
								<th>及时率</th>
								<th >准确率</th>
								<th >填报次数</th>
								<th >及时率</th>
								<th >准确率</th>
								<th >填报次数</th>
								<th>及时率</th>
								<th >准确率</th>
							</tr>
			<logic:iterate id="map" name="IGSMR08011VO" property="map">
			<bean:define id="userlist" name="map" property="value"/>
			<bean:define id="orgname" name="map" property="key"/>
			<bean:size id="listsize" name="userlist"/>
			<logic:iterate id="bean" name="userlist" indexId="index">			
			<tr>
			<c:if test="${index==0 }">
			<td rowspan="${listsize }">
			${orgname }
			</td>
			</c:if>	
			<td>
			<html:link action="/IGSMR0803.do?userid=${bean.userid }" style="text-decoration:underline;">	
			${bean.username }
			</html:link>
		 	</td>	
			<td>
			${bean.yearnum }
		 	</td>
		 	<td>
		 	${bean.yeartime }
		 	</td>
		 	<td>
		 	${bean.yeartrue }
			</td>
		 	<td>
		 	${bean.quarternum }
		 	</td>
		 	<td>
		 	${bean.quartertime }
		 	</td>
		 	<td>
		 	${bean.quartertrue }
		 	</td>
		 	<td>
		 	${bean.notimenum }
		 	</td>
		 	<td>
		 	${bean.notime }
		 	</td>
		 	<td>
		 	${bean.notimetrue }
		 	</td>
			</tr> 
			</logic:iterate> 
			</logic:iterate> 
			<bean:define id="sumuser" name="IGSMR08011VO" property="usersum"/>  
			<tr>
			<td colspan="2">
			合计
			</td>		
			<td>
			${sumuser.yearnum }
		 	</td>
		 	<td>
		 	${sumuser.yeartime }
		 	</td>
		 	<td>
		 	${sumuser.yeartrue }
			</td>
		 	<td>
		 	${sumuser.quarternum }
		 	</td>
		 	<td>
		 	${sumuser.quartertime }
		 	</td>
		 	<td>
		 	${sumuser.quartertrue }
		 	</td>
		 	<td>
		 	${sumuser.notimenum }
		 	</td>
		 	<td>
		 	${sumuser.notime }
		 	</td>
		 	<td>
		 	${sumuser.notimetrue }
		 	</td>
			</tr>                                     	        	
			</table>
			</div>
			<div style="margin-left:8px;">
			<html:button property="btn_search" styleClass="button" value="导出"  onclick="reportexport('2');"/>
			</div>
			</logic:present>					
			</div>
			
				
			</div>
		</div>
	</div>
</body>
</html:html>