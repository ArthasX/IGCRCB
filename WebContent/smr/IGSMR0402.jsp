<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGSMR0402" toScope="request" />
<bean:define id="title" value="年报审批" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
</style>
<script type="text/javascript">
function checkForm(type,formobj){
	var alids = new Array();
	var idnum = 0;
	var prstatus =document.getElementsByName("prstatus");
	var selects = document.getElementsByName("prids");
	var prpdids = document.getElementsByName("prpdids");
	if(null != selects && selects.length > 0){
		for(var i = 0; i< selects.length; i++){
			var checkbox = selects[i];
			if(checkbox.checked){
				prpdids[i].checked = true;
				alids[idnum]=checkbox.value;								
				if(prstatus[i].value!='W'){
					alert("请选择未审批的报表！");
					return ;
				}
				idnum += 1;
			}
		}
	}
	if(null != alids && alids.length > 0){
		
	}else{
		alert("请选择报表！");
		return ;
	}

	if(type=="1"){
		if( window.confirm("是否确认审批？")){
			formobj.action = getAppRootUrl() + "/IGSMR0402_MANAGER.do?type="+type;
			formobj.submit();
		}
		else {
			return ;
		}
	}
	if(type=="2"){
		if( window.confirm("是否确认驳回？")){
			formobj.action = getAppRootUrl() + "/IGSMR0402_MANAGER.do?type="+type;
			formobj.submit();
		}
		else {
			return ;
		}
	}
	if(type=="3"){
		if( window.confirm("是否确认导出？")){
			formobj.action = getAppRootUrl() + "/IGSMR0402_EXPORT.do";
			formobj.submit();
		}
		else {
			return ;
		}
	}
	
}	
</script>
<body>
	<div id="maincontent">
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
					<html:form action="/IGSMR0402_Disp" styleId="form">
                        <ig:message/>
						<div id="results_list">
							<table class="table_style">
								<tr>
								    <th width="5%"><input id="checkbox" name="checkbox" type="checkbox" onclick="selectAll('checkbox','prids');"/></th>
									<th width="13%">报表名</th>
									<th width="7%">处理人</th>
									<th width="13%">填报人</th>
									<th width="13%">填报完成时间</th>
									<th width="13%">报表审批人</th>
									<th width="13%">报表审批完成时间</th>
									<th width="10%">状态</th>
									<th width="13%">驳回时间</th>
								</tr>
								<logic:present name="IGSMR04021VO" property="lst_Report">
									<logic:iterate id="bean" name="IGSMR04021VO"
										property="lst_Report" indexId="index">										
										<tr onmouseover="mouseOver(this);"
											onmouseout="mouseOut(this,'');">
											<td>
											<c:if test="${bean.prstatus=='W' }">
											<input name="prids" type="checkbox" value="${bean.prid}" id="prids" />
											<input name="prpdids" type="checkbox" value="${bean.prpdid}" id="prpdids" style="display: none;"/>
											</c:if>
											</td>
											<td>
											<logic:present name="bean" property="flag">
											<html:link
													action="/IGPRR0102_Disp.do?prtype=WD1&prid=${bean.prid}&instanceID=${IGSMR0402Form.instanceID}&jump=86">
									 			${bean.prtitle }(报送空表)
									 		</html:link>
									 		</logic:present>
									 		<logic:notPresent name="bean" property="flag">
											<html:link
													action="/IGPRR0102_Disp.do?prtype=WD1&prid=${bean.prid}&instanceID=${IGSMR0402Form.instanceID}&jump=86">
									 			${bean.prtitle }
									 		</html:link>
									 		</logic:notPresent>
									 		</td>
									 		<td><ig:ProcessParticipantForStatusWriteTag prid="${bean.prid }" prstatus="${bean.prstatus }"/></td>
									 		<td>${bean.fillinusername }</td>
									 		<td>${bean.fillintime }</td>
									 		<td>${bean.exanimeusername }</td>
									 		<td>${bean.examinetime }</td>
									 		<c:if test="${bean.prstatus=='Y' }">
									 		<td>已驳回</td>
									 		</c:if>
									 		<c:if test="${bean.prstatus=='W' }">
									 		<td>未审批</td>
									 		</c:if>
									 		<c:if test="${bean.prstatus=='C' }">
									 		<td>已关闭</td>
									 		</c:if>
									 		<c:if test="${bean.prstatus=='Y' }">
									 		<td>${bean.rejecttime }</td>
									 		</c:if>
									 		<c:if test="${bean.prstatus!='Y'}">
									 		<td></td>
									 		</c:if>
									 		<c:if test="${bean.prstatus=='W' }">
									 		<input type="hidden" name="prstatus" value="${bean.prstatus }" styleId="prstatus" />
									 		</c:if>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
						<div class="action"
							style="margin-left: 12px; clear: left; float: left;">
							<img src="images/confirm.gif" width="16" height="16" /> <a
								title='审批通过' id="button13"
								href="javascript:checkForm('1',this.form);">审批通过</a>
						</div>
						<div class="action">
							<img src="images/confirm.gif" width="16" height="16" /> <a
								title='驳回' id="button13"
								href="javascript:checkForm('2',this.form)">驳回</a>
						</div>
						<div class="action" >
							<img src="images/confirm.gif" width="16" height="16" /><a
								title='导出PDF' id="button13"
								href="javascript:checkForm('3',this.form)">导出PDF</a>
						</div>
						<html:hidden property="instanceID" value="${IGSMR0402Form.instanceID }"/>
					</html:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html:html>