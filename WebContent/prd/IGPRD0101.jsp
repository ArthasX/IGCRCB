<%@page import="com.deliverik.infogovernor.prd.form.IGPRD0101Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGPRD0101" toScope="request" />
<bean:define id="title" value="流程查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
	<script type="text/javascript">	
	    
	    function toDel(pdid,pdstatus,flag){
	    	if( window.confirm("您是否确认修改状态？")){
	    		IGPRD0101Form.action = getAppRootUrl() + "/IGPRD0102_Change.do?pdid="+pdid+"&pdstatus="+pdstatus+"&flag="+flag;
	    		IGPRD0101Form.submit();
			}
	    }

	    function fun_Upg(pdid) {
            if( window.confirm("您是否确认进行升版处理？")){
                IGPRD0101Form.action = getAppRootUrl() + "/IGPRD0101_Upg.do?pdid="+pdid;
                IGPRD0101Form.submit();
            }
        }
        
	    function toTest(pdid,name){
		    var pdstatus = "<%=IGPRDCONSTANTS.PD_STATUS_TESTABLE %>";
	    	if( window.confirm("您是否确认将该" + name + "设置为测试状态？")){
	    		IGPRD0101Form.action = getAppRootUrl() + "/IGPRD0102_Test.do?pdid="+pdid+"&pdstatus="+pdstatus;
	    		IGPRD0101Form.submit();
			}
	    }
	    function addGeneralVar(){
	    	IGPRD0101Form.action = getAppRootUrl() + "/IGPRD0119.do";
	    	IGPRD0101Form.submit();
	    }
	    function fun_Copy(pdid) {
	    	if( window.confirm("您是否确认进行复制处理？")){
	    		IGPRD0101Form.action = getAppRootUrl() + "/IGPRD0101_Copy.do?pdid="+pdid;
	    		IGPRD0101Form.submit();
			}
		}
		function fun_history(pdid){
			IGPRD0101Form.action = getAppRootUrl() + "/IGPRD0101_histroy.do?pdid="+pdid;
    		IGPRD0101Form.submit();
		}
		function fun_Import(){
	        if($F("xmlFile") == "") {
	        	alert("请选择XML文件！");
	            return false;
	        }
	        if( window.confirm("请确认是否进行导入操作？")){
	            form.action = getAppRootUrl() + "/IGPRD0101_Import.do";
	            return true;
	        } else {
	            return false;
	        }
		}
		function fun_Export(){
	        if( window.confirm("请确认是否进行导出操作？")){
	            return true;
	        } else {
	            return false;
	        }
		}
		function fun_Add(pttype){
			if(!pttype)
			{
				pttype="WD";
			}
		
			IGPRD0101Form.action = getAppRootUrl() + "/IGPRD0102_Disp.do?pttype="+pttype;
    		IGPRD0101Form.submit();
		}
		function openTest(){
			openSubWindow("/IGPRD0202_Disp.do?pdid=0104001","_blak",1000,650);
		}
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRD0101" styleId="form" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation /></p>
	</div>
		<div id="search" align="left">
		<div class="img"></div>
		<div class="conditions">
		<div>
		<span>XML文件：</span>
		<span><html:file property="xmlFile" styleId="xmlFile"
			errorStyleClass="inputError imeDisabled" size="30"/>
		</span><html:submit property="btn_import" styleClass="button" value="导入" onclick="return fun_Import();" />
		
			<logic:equal value="<%=IGPRDCONSTANTS.PRTYPE_YEAR%>" name="IGPRD0101Form" property="pttype">
		          <html:button property="btn_add" styleClass="button" value="报表定义" onclick="return fun_Add('${IGPRD0101Form.pttype}');" />
		    </logic:equal>
            <logic:notEqual value="<%=IGPRDCONSTANTS.PRTYPE_YEAR%>" name="IGPRD0101Form" property="pttype">
             	<logic:equal value="<%=IGPRDCONSTANTS.PRTYPE_SEASON%>" name="IGPRD0101Form" property="pttype">
	              	<html:button property="btn_add" styleClass="button" value="报表定义" onclick="return fun_Add('${IGPRD0101Form.pttype}');" />
	             </logic:equal>
             	<logic:notEqual value="<%=IGPRDCONSTANTS.PRTYPE_SEASON%>" name="IGPRD0101Form" property="pttype">
	              	<logic:equal value="<%=IGPRDCONSTANTS.PRTYPE_IRREGULAR%>" name="IGPRD0101Form" property="pttype">
		               <html:button property="btn_add" styleClass="button" value="报表定义" onclick="return fun_Add('${IGPRD0101Form.pttype}');" />
		            </logic:equal>
	              	<logic:notEqual value="<%=IGPRDCONSTANTS.PRTYPE_IRREGULAR%>" name="IGPRD0101Form" property="pttype">
		               	<html:button property="btn_add" styleClass="button" value="流程定义" onclick="return fun_Add('${IGPRD0101Form.pttype}');" />
		            </logic:notEqual>
	              	<%-- <logic:notEqual value="<%=IGPRDCONSTANTS.PRTYPE_MONTH%>" name="IGPRD0101Form" property="pttype">
		               	<html:button property="btn_add" styleClass="button" value="流程定义" onclick="return fun_Add('${IGPRD0101Form.pttype}');" />
		            </logic:notEqual> --%>
             	</logic:notEqual>
            </logic:notEqual>
		<html:hidden property="pttype" name="IGPRD0101Form"/>
		</div>
		</div>
		
		</div>

	<div id="results_list">
	<ig:message/>
	<%
		IGPRD0101Form form = (IGPRD0101Form)session.getAttribute("IGPRD0101Form");
		String pttype = form.getPttype();
	%>
	<table class="table_style">
		<tr>
			<!-- 自定义流程查看表头 -->
			<logic:notPresent  name="IGPRD0101Form" property="pttype">
				<th width="5%">定义ID</th>
				<th width="4%">版本</th>
				<th width="9%">流程名称</th>
				<th width="6%">状态</th>
				<th width="4%" colspan="2">管理</th>
				<th width="6%">表单管理</th>
				<th width="6%">角色范围</th>
				<!-- <th width="6%">机构范围</th> -->
				<th width="6%">查看权限</th>
				<th width="6%">查询条件</th>
				<th width="6%">状态列表</th>
<!-- 				<th width="6%">表单联动</th> -->
				<th width="6%">通知策略</th>
				<th width="6%">历史版本</th>
				<th width="6%">设置页面</th>
				<th width="4%">升版</th>
				<th width="4%">复制</th>
				<th width="4%">导出</th>
			</logic:notPresent>
			<logic:present  name="IGPRD0101Form" property="pttype">
			<!-- 监管报表查看表头（非自定义流程查看） -->
			<%if(IGPRDCONSTANTS.PRTYPE_YEAR.equals(pttype) || IGPRDCONSTANTS.PRTYPE_SEASON.equals(pttype) || IGPRDCONSTANTS.PRTYPE_IRREGULAR.equals(pttype) || IGPRDCONSTANTS.PRTYPE_MONTH.equals(pttype)) { %>
				<th width="5%">定义ID</th>
				<th width="4%">版本</th>
				<th width="20%">报表名称</th>
				<th width="7%">状态</th>
				<th width="6%" colspan="2">管理</th>
				<th width="6%">表单管理</th>
				<th width="6%">角色范围</th>
				<th width="6%">查看权限</th>
				<th width="6%">状态列表</th>
				<th width="6%">通知策略</th>
				<th width="6%">历史版本</th>
				<th width="5%">升版</th>
				<th width="5%">复制</th>
				<th width="5%">导出</th>
			<%}else{ %>
				<th width="5%">定义ID</th>
				<th width="4%">版本</th>
				<th width="9%">流程名称</th>
				<th width="6%">状态</th>
				<th width="4%" colspan="2">管理</th>
				<th width="6%">表单管理</th>
				<th width="6%">角色范围</th>
				<!-- <th width="6%">机构范围</th> -->
				<th width="6%">查看权限</th>
				<th width="6%">查询条件</th>
				<th width="6%">状态列表</th>
<!-- 				<th width="6%">表单联动</th> -->
				<th width="6%">通知策略</th>
				<th width="6%">历史版本</th>
				<th width="6%">设置页面</th>
				<th width="4%">升版</th>
				<th width="4%">复制</th>
				<th width="4%">导出</th>
			<%} %>
			</logic:present>
			
		
			
		</tr>
		<logic:present name="IGPRD01011VO" property="processDefinitionList">
			<logic:iterate id="bean" name="IGPRD01011VO"
				property="processDefinitionList" indexId="index" type="com.deliverik.framework.workflow.prd.model.IG380Info">
				<tr>
					<!-- 自定义流程查看信息 -->
					<logic:notPresent  name="IGPRD0101Form" property="pttype">
					<td>
							<% 
								String showid = "";
								String version = "";
							    if(StringUtils.isNotEmpty(bean.getPdid()) && bean.getPdid().length() == 7){
							    	showid = String.valueOf(bean.getPdid().substring(0,5));
							    	version = String.valueOf(bean.getPdid().substring(5,7));
							    } 
							%>
							<%=showid%>
						</td>
						<td>
							<%=version%>&nbsp;版
						</td>
						<td>
							<logic:empty name="bean" property="pdname">&nbsp;</logic:empty><html:link
							action="/IGPRD0102_Edit_Disp.do?pdid=${bean.pdid}&mode=1">${bean.pdname}</html:link>
						</td>
						<td>
							<logic:empty name="bean" property="pdstatus">&nbsp;</logic:empty>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_ENABLE %>" name="bean" property="pdstatus">已启用</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_DISABLE %>" name="bean" property="pdstatus">已停用</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_TESTABLE %>" name="bean" property="pdstatus">测试中</logic:equal>
						</td>
						<td>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_DISABLE %>" name="bean" property="pdstatus">
								<html:link href="javascript:toTest('${bean.pdid}','流程')"><img src="images/test.gif" width="16" height="16" border="0" alt="测试" /></html:link>
							</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_TESTABLE %>" name="bean" property="pdstatus">
								<html:link  href="javascript:toDel('${bean.pdid}','i','TEST')"><img src="images/stop.gif" width="16" height="16" border="0" alt="停用" /></html:link>
							</logic:equal>
						</td>
						<td>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_DISABLE %>" name="bean" property="pdstatus">
								<html:link  href="javascript:toDel('${bean.pdid}','a','CHANGE')"><img src="images/start.gif" width="16" height="16" border="0" alt="启用" /></html:link>
							</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_TESTABLE %>" name="bean" property="pdstatus">
								<html:link  href="javascript:toDel('${bean.pdid}','a','CHANGE')"><img src="images/start.gif" width="16" height="16" border="0" alt="启用" /></html:link>
							</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_ENABLE %>" name="bean" property="pdstatus">
								<html:link  href="javascript:toDel('${bean.pdid}','i','CHANGE')"><img src="images/stop.gif" width="16" height="16" border="0" alt="停用" />
							</html:link></logic:equal>
						</td>
						<td>
							<html:link action="/IGPRD0110.do?pdid=${bean.pdid}&flag=flase&viewhistory=0&tableColumn=N"><img
								src="images/xx.gif" width="16" height="16" border="0" alt="表单信息" />
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0124_Disp.do?pdid=${bean.pdid}"><img
								src="images/sqcd.gif" width="16" height="16" border="0" alt="角色范围" />
							</html:link>
						</td>
						<%-- <td>
							<html:link action="/IGPRD0131_Disp.do?pdid=${bean.pdid}">
								<img src="images/sqorg.gif" width="16" height="16" border="0" alt="机构范围" />
							</html:link>
						</td> --%>
						<td>
							<html:link action="/IGPRD0171_Disp.do?pdid=${bean.pdid}"><img
								src="images/tbq.png" width="16" height="16" border="0" alt="查看权限" />
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0145_Disp.do?pdid=${bean.pdid }">
								<img src="images/page_white_edit.png" width="16" height="16" border="0" alt="查询条件" />
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0104.do?pdid=${bean.pdid}"><img
								src="images/list.gif" width="16" height="16" border="0" alt="状态列表" />
							</html:link>
						</td>
<!-- 						<td> -->
<%-- 							<html:link action="/IGPRD0125_Disp.do?pdid=${bean.pdid}"><img --%>
<!-- 								src="images/bdld.gif" width="16" height="16" border="0" alt="表单联动" /> -->
<%-- 							</html:link> --%>
<!-- 						</td> -->
						<td>
							<html:link action="/IGPRD0158_Disp.do?pdid=${bean.pdid}"><img
								src="images/work.gif" width="16" height="16" border="0" alt="通知策略" >
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0140.do?pdid=${bean.pdid}"><img
								src="images/notepad_16x16.gif" width="16" height="16" border="0" alt="历史版本" />
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0168_Disp.do?pdid=${bean.pdid}&pdname=${bean.pdname}&pddesc=${bean.pddesc}"><img
								src="images/igprd0102.png" width="16" height="16" border="0" alt="设置页面" />
							</html:link>
						</td>
						<td>
							<html:link href="javascript:void(0)" onclick="fun_Upg('${bean.pdid}')"><img
								src="images/upgrade.gif" width="16" height="16" border="0" alt="升版" />
							</html:link>
						</td>
						<td>
							<html:link href="javascript:void(0)" onclick="fun_Copy('${bean.pdid}')"><img
								src="images/copy.gif" width="16" height="16" border="0" alt="复制" />
							</html:link>
						</td>
						<td>
							<html:link action="IGPRD0101_Export.do?pdid_export=${bean.pdid}" onclick="return fun_Export()"><img
								src="images/batch.gif" width="16" height="16" border="0" alt="导出" />
							</html:link>
						</td>
					</logic:notPresent>
					<logic:present  name="IGPRD0101Form" property="pttype">
										<!-- 监管报表查看信息（非自定义流程查看） -->
					<%if(IGPRDCONSTANTS.PRTYPE_YEAR.equals(pttype) || IGPRDCONSTANTS.PRTYPE_SEASON.equals(pttype) || IGPRDCONSTANTS.PRTYPE_IRREGULAR.equals(pttype)|| IGPRDCONSTANTS.PRTYPE_MONTH.equals(pttype)) { %>
						<td>
							<% 
								String showid = "";
								String version = "";
							    if(StringUtils.isNotEmpty(bean.getPdid()) && bean.getPdid().length() == 7){
							    	showid = String.valueOf(bean.getPdid().substring(0,5));
							    	version = String.valueOf(bean.getPdid().substring(5,7));
							    } 
							%>
							<%=showid%>
						</td>
						<td>
							<%=version%>&nbsp;版
						</td>
						<td>
							<logic:empty name="bean" property="pdname">&nbsp;</logic:empty><html:link
								action="/IGPRD0102_Edit_Disp.do?pdid=${bean.pdid}&mode=1">${bean.pdname}</html:link>
						</td>
						<td>
							<logic:empty name="bean" property="pdstatus">&nbsp;</logic:empty>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_ENABLE %>" name="bean" property="pdstatus">已启用</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_DISABLE %>" name="bean" property="pdstatus">已停用</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_TESTABLE %>" name="bean" property="pdstatus">测试中</logic:equal>
						</td>
						<td>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_DISABLE %>" name="bean" property="pdstatus">
								<html:link href="javascript:toTest('${bean.pdid}','报表')"><img src="images/test.gif" width="16" height="16" border="0" alt="测试" /></html:link>
							</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_TESTABLE %>" name="bean" property="pdstatus">
								<html:link  href="javascript:toDel('${bean.pdid}','i','TEST')"><img src="images/stop.gif" width="16" height="16" border="0" alt="停用" /></html:link>
							</logic:equal>
						</td>
						<td>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_DISABLE %>" name="bean" property="pdstatus">
								<html:link  href="javascript:toDel('${bean.pdid}','a','CHANGE')"><img src="images/start.gif" width="16" height="16" border="0" alt="启用" /></html:link>
							</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_TESTABLE %>" name="bean" property="pdstatus">
								<html:link  href="javascript:toDel('${bean.pdid}','a','CHANGE')"><img src="images/start.gif" width="16" height="16" border="0" alt="启用" /></html:link>
							</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_ENABLE %>" name="bean" property="pdstatus">
								<html:link  href="javascript:toDel('${bean.pdid}','i','CHANGE')"><img src="images/stop.gif" width="16" height="16" border="0" alt="停用" />
							</html:link></logic:equal>
						</td>
						<td>
							<html:link action="/IGPRD0110.do?pdid=${bean.pdid}&flag=flase&viewhistory=0&tableColumn=N"><img
								src="images/xx.gif" width="16" height="16" border="0" alt="表单信息" />
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0124_Disp.do?pdid=${bean.pdid}"><img
								src="images/sqcd.gif" width="16" height="16" border="0" alt="角色范围" />
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0171_Disp.do?pdid=${bean.pdid}"><img
								src="images/tbq.png" width="16" height="16" border="0" alt="查看权限" />
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0104.do?pdid=${bean.pdid}"><img
								src="images/list.gif" width="16" height="16" border="0" alt="状态列表" />
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0158_Disp.do?pdid=${bean.pdid}"><img
								src="images/work.gif" width="16" height="16" border="0" alt="通知策略" >
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0140.do?pdid=${bean.pdid}"><img
								src="images/notepad_16x16.gif" width="16" height="16" border="0" alt="历史版本" />
							</html:link>
						</td>
						<td>
							<html:link href="javascript:void(0)" onclick="fun_Upg('${bean.pdid}')"><img
								src="images/upgrade.gif" width="16" height="16" border="0" alt="升版" />
							</html:link>
						</td>
						<td>
							<html:link href="javascript:void(0)" onclick="fun_Copy('${bean.pdid}')"><img
								src="images/copy.gif" width="16" height="16" border="0" alt="复制" />
							</html:link>
						</td>
						<td>
							<html:link action="IGPRD0101_Export.do?pdid_export=${bean.pdid}" onclick="return fun_Export()"><img
								src="images/batch.gif" width="16" height="16" border="0" alt="导出" />
							</html:link>
						</td>
					<%}else{ %>
						<td>
							<% 
								String showid = "";
								String version = "";
							    if(StringUtils.isNotEmpty(bean.getPdid()) && bean.getPdid().length() == 7){
							    	showid = String.valueOf(bean.getPdid().substring(0,5));
							    	version = String.valueOf(bean.getPdid().substring(5,7));
							    } 
							%>
							<%=showid%>
						</td>
						<td>
							<%=version%>&nbsp;版
						</td>
						<td>
							<logic:empty name="bean" property="pdname">&nbsp;</logic:empty><html:link
							action="/IGPRD0102_Edit_Disp.do?pdid=${bean.pdid}&mode=1">${bean.pdname}</html:link>
						</td>
						<td>
							<logic:empty name="bean" property="pdstatus">&nbsp;</logic:empty>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_ENABLE %>" name="bean" property="pdstatus">已启用</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_DISABLE %>" name="bean" property="pdstatus">已停用</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_TESTABLE %>" name="bean" property="pdstatus">测试中</logic:equal>
						</td>
						<td>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_DISABLE %>" name="bean" property="pdstatus">
								<html:link href="javascript:toTest('${bean.pdid}','流程')"><img src="images/test.gif" width="16" height="16" border="0" alt="测试" /></html:link>
							</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_TESTABLE %>" name="bean" property="pdstatus">
								<html:link  href="javascript:toDel('${bean.pdid}','i','TEST')"><img src="images/stop.gif" width="16" height="16" border="0" alt="停用" /></html:link>
							</logic:equal>
						</td>
						<td>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_DISABLE %>" name="bean" property="pdstatus">
								<html:link  href="javascript:toDel('${bean.pdid}','a','CHANGE')"><img src="images/start.gif" width="16" height="16" border="0" alt="启用" /></html:link>
							</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_TESTABLE %>" name="bean" property="pdstatus">
								<html:link  href="javascript:toDel('${bean.pdid}','a','CHANGE')"><img src="images/start.gif" width="16" height="16" border="0" alt="启用" /></html:link>
							</logic:equal>
							<logic:equal value="<%=IGPRDCONSTANTS.PD_STATUS_ENABLE %>" name="bean" property="pdstatus">
								<html:link  href="javascript:toDel('${bean.pdid}','i','CHANGE')"><img src="images/stop.gif" width="16" height="16" border="0" alt="停用" />
							</html:link></logic:equal>
						</td>
						<td>
							<html:link action="/IGPRD0110.do?pdid=${bean.pdid}&flag=flase&viewhistory=0&tableColumn=N"><img
								src="images/xx.gif" width="16" height="16" border="0" alt="表单信息" />
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0124_Disp.do?pdid=${bean.pdid}"><img
								src="images/sqcd.gif" width="16" height="16" border="0" alt="角色范围" />
							</html:link>
						</td>
						<%-- <td>
							<html:link action="/IGPRD0131_Disp.do?pdid=${bean.pdid}">
								<img src="images/sqorg.gif" width="16" height="16" border="0" alt="机构范围" />
							</html:link>
						</td> --%>
						<td>
							<html:link action="/IGPRD0171_Disp.do?pdid=${bean.pdid}"><img
								src="images/tbq.png" width="16" height="16" border="0" alt="查看权限" />
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0145_Disp.do?pdid=${bean.pdid }">
								<img src="images/page_white_edit.png" width="16" height="16" border="0" alt="查询条件" />
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0104.do?pdid=${bean.pdid}"><img
								src="images/list.gif" width="16" height="16" border="0" alt="状态列表" />
							</html:link>
						</td>
<!-- 						<td> -->
<%-- 							<html:link action="/IGPRD0125_Disp.do?pdid=${bean.pdid}"><img --%>
<!-- 								src="images/bdld.gif" width="16" height="16" border="0" alt="表单联动" /> -->
<%-- 							</html:link> --%>
<!-- 						</td> -->
						<td>
							<html:link action="/IGPRD0158_Disp.do?pdid=${bean.pdid}"><img
								src="images/work.gif" width="16" height="16" border="0" alt="通知策略" >
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0140.do?pdid=${bean.pdid}"><img
								src="images/notepad_16x16.gif" width="16" height="16" border="0" alt="历史版本" />
							</html:link>
						</td>
						<td>
							<html:link action="/IGPRD0168_Disp.do?pdid=${bean.pdid}&pdname=${bean.pdname}&pddesc=${bean.pddesc}"><img
								src="images/igprd0102.png" width="16" height="16" border="0" alt="设置页面" />
							</html:link>
						</td>
						<td>
							<html:link href="javascript:void(0)" onclick="fun_Upg('${bean.pdid}')"><img
								src="images/upgrade.gif" width="16" height="16" border="0" alt="升版" />
							</html:link>
						</td>
						<td>
							<html:link href="javascript:void(0)" onclick="fun_Copy('${bean.pdid}')"><img
								src="images/copy.gif" width="16" height="16" border="0" alt="复制" />
							</html:link>
						</td>
						<td>
							<html:link action="IGPRD0101_Export.do?pdid_export=${bean.pdid}" onclick="return fun_Export()"><img
								src="images/batch.gif" width="16" height="16" border="0" alt="导出" />
							</html:link>
						</td>
					<%} %>
					</logic:present>
					
					
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><jsp:include page="/include/paging.jsp" /></div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>
