<%@page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.wkm.vo.IGWKM01011VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG380Info"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<html:html>
<bean:define id="id" value="IGFXK0303" toScope="request" />
<bean:define id="title" value="风险计划查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function see(prid,rownum,mode){
		openSubWindow('/IGFXK0304_Disp.do?mode='+mode+'&prid='+prid+'&pvrownumber='+rownum, 'newpage', '800', '600');
	}
	function windowback(){
		document.forms[0].action = getAppRootUrl() + "/IGFXK0303_Back.do";
		document.forms[0].submit();
	}
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGFXK0303_Search" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
		<div class="image"></div>
		<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
		<div class="img"></div>
		   <div class="conditions">
		    <div>
	                <span style="font-size:15px;"><strong>查询条件</strong></span>
	    
	                </div>
		<div  style="margin-top:4px"><span  class="subscribe">计划编号：</span>
		<html:text property="risknum_l" name="IGFXK0301Form" size="12" />
		
		<span class="subscribe">计划标题：</span>
		<html:text property="title_l" name="IGFXK0301Form" size="12" />
		<span class="subscribe">登记人：</span>
		<html:text property="prusername_l" name="IGFXK0301Form" size="12" style="width:90px"/>
		<span class="subscribe">风险计划类型：</span>
		<html:select property="risktype_q" style="width: 100px; vertical-align:middle;">
	    	<html:options collection="lvFXTYPEList" property="value" labelProperty="label"/>
	    </html:select>
	    <html:submit styleClass="button" value="查询" />
		<br>
		</div>
		<div  style="margin-top:12px">
		<span class="subscribe">计划开始日期：</span>
		<html:text property="riskstart_ge" styleId="riskstart_ge" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('riskstart_ge'))" border="0" style="cursor: hand" />
		<span>--</span><html:text property="riskstart_le" styleId="riskstart_le" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('riskstart_le'))" border="0" style="cursor: hand" />
		
		
		</div>
		</div>
	</div>
	
	<div id="results_list"><ig:message />
		<table class="table_style">
			<tr>
				<th width="8%">计划编号</th>
				<th width="8%">计划标题</th>
				<th width="8%">风险计划类型</th>
				<th width="8%">计划完成情况</th>
				
				<th width="8%">工作名称</th>
				<th width="8%">工作说明</th>
				<th width="8%">负责人</th>
				<th width="8%">工作开始日期</th>
				<th width="8%">工作完成日期</th>
				<th width="8%">状态</th>
				<th width="8%">详细信息</th>
			</tr>
			<logic:present name="IGFXK03011VO" property="infomap">
			
			<logic:iterate id="bean" name="IGFXK03011VO" property="infomap" indexId="index">
			<bean:define id="RiskprojectvwTB" name="bean" property="key" type="com.deliverik.infogovernor.fxk.model.entity.RiskprojectvwTB"/>
			<bean:define id="innerMap" name="bean" property="value"  type="java.util.Map"/>
			
			<logic:iterate id="row" name="innerMap" indexId="index2" >
			<bean:define id="rownum" name="row" property="key" type="java.lang.String"/>
			<bean:define id="key_valuemap" name="row" property="value" type="java.util.Map"/>
			<logic:equal name="index2" value="0">
			
			<bean:size id="map_size" name="innerMap"/>
				<tr>
					<td rowspan="${map_size}">
					<a href="javascript:doLook('IGPRR0102_Disp.do?prtype=WD&prid=${RiskprojectvwTB.prid}&jump=61')">${RiskprojectvwTB.risknum}</a> 
					</td>
					<td rowspan="${map_size}"> ${RiskprojectvwTB.prtitle} </td>
					<td rowspan="${map_size}"> ${RiskprojectvwTB.risktype} </td>
					<td rowspan="${map_size}"> ${RiskprojectvwTB.riskcompletion} </td>
					<td>
						<%=key_valuemap.get("工作名称") %>
					</td>
					<td>
						<%=key_valuemap.get("工作说明") %>
					</td>
					<% 
						String people="";
						if(key_valuemap.get("负责人")!=null&&!"".equals(key_valuemap.get("负责人"))){
						    try{
						        people=((String)key_valuemap.get("负责人")).split("_")[2];
						    }catch( Exception e){
						        people=(String)key_valuemap.get("负责人");
						    }
						}
						
					%>
					<td><%=people %></td>
					<td>
						<%=key_valuemap.get("工作开始日期") %>
					</td>
					<td>
						<%=key_valuemap.get("工作完成日期") %>
					</td>
					<td>
						<%=key_valuemap.get("状态") %>
					</td>
					<td>
						<bean:define id="status1">
							<%=key_valuemap.get("状态") %>
						</bean:define>
						<logic:equal value="已完成" name="status1"  >
								<img src="images/xx.gif" border="0" alt="详细信息" onclick="see(${RiskprojectvwTB.prid},${rownum},1)"/>
						</logic:equal>
						<logic:notEqual value="已完成" name="status1">
							<logic:equal value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS%>" name="RiskprojectvwTB" property="prstatus">
								<img src="images/xx.gif" border="0" alt="详细信息" onclick="see(${RiskprojectvwTB.prid},${rownum},1)"/>
							</logic:equal>
							<logic:notEqual value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS%>" name="RiskprojectvwTB" property="prstatus">
								<img src="images/xx.gif" border="0" alt="修改" onclick="see(${RiskprojectvwTB.prid},${rownum},0)"/>
							</logic:notEqual>
						</logic:notEqual>
					</td>
				</tr>
			</logic:equal>
			<logic:notEqual  name="index2" value="0">
				<tr>
					<td>
						<%=key_valuemap.get("工作名称") %>
					</td>
					<td>
						<%=key_valuemap.get("工作说明") %>
					</td>
					<% 
						String people="";
						if(key_valuemap.get("负责人")!=null&&!"".equals(key_valuemap.get("负责人"))){
						    try{
						        people=((String)key_valuemap.get("负责人")).split("_")[2];
						    }catch( Exception e){
						        people=(String)key_valuemap.get("负责人");
						    }
						}
						
					%>
					<td><%=people %></td>
					<td>
						<%=key_valuemap.get("工作开始日期") %>
					</td>
					<td>
						<%=key_valuemap.get("工作完成日期") %>
					</td>
					<td>
						<%=key_valuemap.get("状态") %>
					</td>
					<td>
						<bean:define id="status1">
							<%=key_valuemap.get("状态") %>
						</bean:define>
						<logic:equal value="已完成" name="status1">
								<img src="images/xx.gif" border="0" alt="详细信息" onclick="see(${RiskprojectvwTB.prid},${rownum},1)"/>
						</logic:equal>
						<logic:notEqual value="已完成" name="status1">
							<logic:equal value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS%>" name="RiskprojectvwTB" property="prstatus">
								<img src="images/xx.gif" border="0" alt="详细信息" onclick="see(${RiskprojectvwTB.prid},${rownum},1)"/>
							</logic:equal>
							<logic:notEqual value="<%=IGPRDCONSTANTS.PROCESS_END_STATUS%>" name="RiskprojectvwTB" property="prstatus">
								<img src="images/xx.gif" border="0" alt="修改" onclick="see(${RiskprojectvwTB.prid},${rownum},0)"/>
							</logic:notEqual>
						</logic:notEqual>
					</td>
				</tr>
			</logic:notEqual>
			</logic:iterate>
			
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
</div>
</div>

</body>
</html:html>
