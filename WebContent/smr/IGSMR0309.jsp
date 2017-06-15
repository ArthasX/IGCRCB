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
<bean:define id="id" value="IGSMR0309" toScope="request" />
<bean:define id="title" value="报表历史查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
</style>
<script type="text/javascript">
	function checkForm(formobj) {
		var alids = new Array();
		var idnum = 0;
		var selects = document.getElementsByName("prids");
		var prpdids = document.getElementsByName("prpdids");
		if (null != selects && selects.length > 0) {
			for ( var i = 0; i < selects.length; i++) {
				var checkbox = selects[i];
				if (checkbox.checked) {
					prpdids[i].checked = true;
					alids[idnum] = checkbox.value;
					idnum += 1;
				}
			}
		}

		if (null != alids && alids.length > 0) {

		} else {
			alert("请选择报表！");
			return;
		}

		if (window.confirm("是否确认导出？")) {
			formobj.action = getAppRootUrl() + "/IGSMR0305_EXPORT.do";
			formobj.submit();
			formobj.action = getAppRootUrl() + "/IGSMR0305_SEARCH.do";
		} else {
			return;
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
				<html:form action="/IGSMR0305_SEARCH" styleId="form">	
					<div id="location">
						<div class="image"></div>
						<p class="fonts1">
							<ig:navigation />
						</p>
						
					</div>
					<div id="search">
									
					 <div class="img"></div>
					 <div class="conditions">
                       <span>类型</span>：
                       <html:select property="prtype" name="IGSMR0304Form">
                        <html:option value=""></html:option>
                       <html:option value="WD1">年报</html:option>
                       <html:option value="WD2">季报</html:option>
                       <html:option value="WD3">不定期报表</html:option>
                       <html:option value="WD4">月报</html:option>
                       </html:select>
                       &nbsp;&nbsp;
                        <span>报表名</span>：
                        <html:text property="prtitle" name="IGSMR0304Form"></html:text>
                        &nbsp;&nbsp;
                         <span>发起时间：从</span><html:text property="prstarttime" styleId="prstarttime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="showTime($('prstarttime'))" border="0" style="cursor: hand" /> &nbsp;&nbsp;
		<span>到</span><html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="showTime($('prclosetime'))" border="0" style="cursor: hand" />
		     			<html:submit property="btn_search" styleClass="button" value="查询" />
		     			</div>
		     			
		     			</div>
		     			<div id="results_list">
		     			
						<table class="table_style">
							<tr>
								<th width="5%"><input id="checkbox" name="checkbox" type="checkbox" onclick="selectAll('checkbox','prids');"/></th>
								<th width="30%">报表名</th>
								<th width="20%">填报人</th>
								<th width="20%">报表审批人</th>
								<th width="10%">发起人</th>
								<th width="15%">发起时间</th>
							</tr>
							<logic:present name="IGSMR03051VO" property="list_rhs">
								<logic:iterate id="bean" name="IGSMR03051VO" property="list_rhs">
									<tr>
									<td>
										<input name="prids" type="checkbox" value="${bean.prid}" id="prids"/>
										<input name="prpdids" type="checkbox" value="${bean.prpdid}" id="prpdids" style="display: none;"/>
									</td>
									
									<td align="left" style="padding-left: 10px;" onmouseover="mouseOver(this);"
																onmouseout="mouseOut(this,'');"
																onclick="doLook('IGPRR0102_Disp.do?prtype=${bean.prtype}&prid=${bean.prid}');">
									${bean.prtitle }
									</td>		
									<td>
									${bean.fillinname }			
								 	</td>
								 	<td>
								 	${bean.reportapprovename }
								 	</td>
								 	<td>
								 	${bean.prusername }
									</td>
								 	<td>
								 	${bean.prstarttime }
								 	</td>
									</tr>                                       
				            	</logic:iterate>    
					        </logic:present>
						</table>
						</div>
						<div class="action" >
							<img src="images/confirm.gif" width="16" height="16" /><a
								title='导出PDF' id="button13"
								href="javascript:checkForm(this.form)">导出PDF</a>
						</div>
					<div id="operate">
						<jsp:include page="/include/paging.jsp" />
					</div>
		     	</html:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html:html>