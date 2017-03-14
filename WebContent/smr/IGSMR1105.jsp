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
<bean:define id="id" value="IGSMR1105" toScope="request" />
<bean:define id="title" value="填报监督" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
</style>
<script type="text/javascript">
function stop(instanceID){
	var form = document.getElementById("form");
	form.action="IGSMR1103_STOP.do?instanceID="+instanceID;
	form.submit();
}
function sendmessage(){
	var alids = new Array();
	var idnum = 0;
	//定义选中的报表主键
	var prid = "";
	var selects = document.getElementsByName("prid");
	if(null != selects && selects.length > 0){
		for(var i = 0; i< selects.length; i++){
			var checkbox = selects[i];
			if(checkbox.checked){
				alids[idnum]=checkbox.value;
				prid = prid+checkbox.value+",";
				idnum += 1;
			}
		}
	}
	if(null != alids && alids.length > 0){
		var url="IGSMR1103_Modal.do?prid="+prid;
		var objs = window.showModalDialog(url,null,"dialogWidth:600px;dialogHeight:200px;status:no;help:no;resizable:no;");
		if(objs!=null){ 
	    	alert(objs);
		}
	}else{
		alert("请选择催办报表！");
		return false;
	}	
		

}
function checkForm(){
	if($F('year').trim() == ""){
		alert("请选择年份！");
		return false;
	}
	if($F('month').trim() == ""){
		alert("请选择月度！");
		return false;
	}
	return true;
		

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
					<html:form action="/IGSMR1103_DISP" styleId="form" onsubmit="return checkForm();">
					
					 <div class="img"></div>
					 <div class="conditions">
					  <span><span class="red">*</span>年份</span>：
					 <html:select  property="year" styleId="year" style="width:100px;" errorStyleClass="inputError" tabindex="1">
							<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="true" isCodeLabel="true" />    
		     			</html:select>
                       <span><span class="red">*</span>月份</span>：
						<html:select  property="month" styleId="month" style="width:100px;" errorStyleClass="inputError" tabindex="1">
						<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="true" isCodeLabel="true" />    
		     			</html:select>
		     			<html:submit property="btn_search" styleClass="button" value="查询" />
		     			</div>
		     			</html:form>
		     			</div>
		     				<div id="results_list">
		     			<ig:message/>
						<table class="table_style">
							<tr>
							    <th width="5%"><input id="checkbox" name="checkbox" type="checkbox" onclick="selectAll('checkbox','prid');"/></th>
								<th width="28%">报表名</th>
								<th width="10%">状态</th>
								<th width="13%">处理人</th>
								<th width="13%">发起时间</th>
								<th width="10%">发起人</th>
								<th width="13%">填报限制时间</th>
								<th width="8%">操作</th>
							</tr>
			<logic:present name="IGSMR11021VO" property="map_see">
			<logic:iterate id="map_see" name="IGSMR11021VO" property="map_see">
			<bean:define id="year" name="map_see" property="key"/>
			<bean:define id="list_rri" name="map_see" property="value"/>
						<bean:size id="listsize" name="list_rri" />
			<logic:iterate id="info" name="list_rri"  indexId="index">
			<tr>
			<td>
			<c:if test="${(info.prstatus!='#')&&(info.prstatus!='C') }">
			<input name="prid" type="checkbox" value="${info.prid}" id="prid"/>
			</c:if>
			</td>		
			<td>	
			<logic:present name="info" property="flag">			
			<html:link action="/IGPRR0102_Disp.do?prtype=WD4&prid=${info.prid}&jump=102" style="text-decoration:underline;">			
		 	${info.prtitle }		 			 	
		 	</html:link>
		 	</logic:present>
		 	<logic:notPresent name="info" property="flag">
			<html:link action="/IGPRR0102_Disp.do?prtype=WD4&prid=${info.prid}&jump=102" style="text-decoration:underline;">			
		 	${info.prtitle }		 			 	
		 	</html:link>
		 	</logic:notPresent>		 	
		 	</td>
		 	<td>
		 	<c:if test="${info.prstatus=='#' }">
		 	已中止
		 	</c:if>
		 	<c:if test="${info.prstatus!='#' }">
		 	${info.psdname }
		 	</c:if>
		 	</td>
		 	<td  >
			<ig:ProcessParticipantForStatusWriteTag prid="${info.prid }" prstatus="${info.prstatus }"/>
			</td>
		 	<c:if test="${index==0 }">			   						
			<td rowspan="${listsize}">
			${info.inittime }
			</td>
			<td rowspan="${listsize}">
			${info.username }
			</td>
			<td rowspan="${listsize}">
			${info.limittime }
			</td>
			<c:if test="${info.status=='2' }">
			<td rowspan="${listsize}">已中止</td>
			</c:if>
			<c:if test="${info.status=='3' }">
			<td rowspan="${listsize}">已关闭</td>
			</c:if>	
			<c:if test="${info.status=='1' }">
			<td rowspan="${listsize}">月报审批</td>
			</c:if>									
			<c:if test="${info.status=='0' }">
			<td rowspan="${listsize}">
			<img src="images/stop_16.png"  border="0" onclick="stop(${info.instanceID});" style="cursor: hand"/>
			</td>
			</c:if>	
			</c:if>			
			</tr>                                       
             </logic:iterate> 
			</logic:iterate>
   
	        	</logic:present>
						</table>
						</div>					
						<logic:present name="IGSMR11021VO" property="map_see">
						<bean:size id="size" name="IGSMR11021VO" property="map_see"/>
						<c:if test="${size!=0 }">
        <div style="margin-left: -5px;">
        <html:button property="btn_add" styleClass="button" value="催办" onclick="sendmessage();"/>
        </div>	
        </c:if>
        </logic:present>				
				</div>
			</div>
		</div>
	</div>
</body>
</html:html>