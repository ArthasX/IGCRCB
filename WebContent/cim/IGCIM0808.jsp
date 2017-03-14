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
<bean:define id="id" value="IGCIM0808" toScope="request" />
<bean:define id="title" value="手动采集画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
	function starts(){
		form.action = getAppRootUrl() +"/IGCIM0808_Edit.do?editAction=start";
		document.forms[0].submit();
	}
	function stops(){
		form.action = getAppRootUrl() +"/IGCIM0808_Edit.do?editAction=stop";
		document.forms[0].submit();
	}
	function search(){
		form.action = getAppRootUrl() +"/IGCIM0808_Edit.do?editAction=search";
		document.forms[0].submit();
	}
</script>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
     <div id="contentWrap">
     	<div id="content">
     		<html:form styleId="form" action="/IGCIM0808_Edit" onsubmit="return checkSubmit(this);">
     			<div id="location">
                <div class="image"></div>
                    <p class="fonts1">配置管理 &gt;&gt;配置采集&gt;&gt;手动采集</p>
            	</div>
            	<br/>
            	<div id="search">
            		<div class="img"></div>
                   	<div class="conditions">
                   	<div><label>&nbsp;&nbsp; 服务名： </label> 
                   		<html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" maxlength="21" size="21" ></html:text>&nbsp;&nbsp;
                   		<label>&nbsp;&nbsp; 服务类型： </label> 
                   		<html:select property="pluginNmae" style="pedorder">
                   			<html:option value="All">全部</html:option>
                   			<html:option value="HostCF">HostCF</html:option>
                   			<html:option value="Websphere Middleware">Websphere Middleware</html:option>
                   			<html:option value="TuxedoCF">TuxedoCF</html:option>
                   			<html:option value="NetworkCI">NetworkCI</html:option>
                   			<html:option value="DB2 Database">DB2 Database</html:option>
                   			<html:option value="OracleCF">OracleCF</html:option>
                   			<html:option value="Jboss Middleware">Jboss Middleware</html:option>
                   			<html:option value="Apache Middleware">Apache Middleware</html:option>
                   			<html:option value="WindowsCF">WindowsCF</html:option>
                   			<html:option value="VmwareCF">VmwareCF</html:option>
                   			<html:option value="InformixCF">InformixCF</html:option>
                   			<html:option value="Tomcat Middleware">Tomcat Middleware</html:option>
                   			<html:option value="Weblogic Middleware">Weblogic Middleware</html:option>
                   		</html:select>
                   		<label>&nbsp;&nbsp; 状态： </label> 
                   		<html:select property="serverstatus" style="pedorder">
                   			<html:option value="0">全部</html:option>
                   			<html:option value="1">启用</html:option>
                   			<html:option value="2">停用</html:option>
                   		</html:select>
                   		<input type="submit" name="btn_search" value="查询" class="button" onclick="search();">
						</div>
                   </div>
            	</div>
            	<br/>
            	<div id="results_list">
            		<ig:message />
            		<table class="table_style">
            			<tr>
								<th width="5%"><label><input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','eitids')"/></label></th>
								<th width="6%">序列号</th>
								<th width="25%">服务名</th>
								<th width="15%">服务类型</th>
								<th width="30%">平台名</th>
								<th width="30%">状态</th>
								
						</tr>
						<logic:present name="IGCIM18011VO" property="hqServerTBList">
							<logic:iterate id="bean" name="IGCIM18011VO" property="hqServerTBList" indexId="index">
								<tr class="<ig:rowcss index="${index}"/>">
									<td>
										<html:checkbox property="eitids" value="${bean.serverName}" name="IGCIM0808Form" styleId="eitids"/>
									</td>
									<td>
										<div class="nowrapDiv">${index+1}</div>
									</td>
									<td>
										<div class="nowrapDiv">${bean.serverName }</div>
									</td>
									<td>
										<div class="nowrapDiv">${bean.pluginName }</div>
									</td>
									<td>
										<div class="nowrapDiv">${bean.plantformName}</div>
									</td>
									<td>
										<div class="nowrapDiv">
											<logic:equal name="bean" property="enable" value="true">
												<img alt='<bean:message bundle="asmResources" key="img.IGCIM0207.logic.start"/>' src="images/start.gif">
											</logic:equal>
											<logic:equal name="bean" property="enable" value="false">
												<img alt='<bean:message bundle="asmResources" key="img.IGCIM0207.logic.stop"/>' src="images/stop.gif">
											</logic:equal>
										</div>
									</td>
								</tr>
							</logic:iterate>
						</logic:present>
            		</table>
            	</div>

                <div id="operate">
					<html:button property="btn_start" styleClass="button" onclick="starts();">
						<bean:message bundle="asmResources" key="img.IGASM0101.start.alt"/>
					</html:button>
					<html:button property="btn_stop" styleClass="button" onclick="stops();">
						<bean:message bundle="asmResources" key="img.IGASM0101.stop.alt"/>
					</html:button>
				</div>
     		</html:form>
     	</div>
     </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>