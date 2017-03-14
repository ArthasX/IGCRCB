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
<bean:define id="id" value="MSS00004" toScope="request" />
<bean:define id="title" value="规则模板管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<%

%>

<!-- /header1 -->
<script type="text/javascript">	
	//删除所选
	function deleteRec(obj){
		var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="条件模板" />';
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
	    if(window.confirm(confirmMsg)){
	        form.action = getAppRootUrl() + "/IGLOG0042_Del.do";
	        return true;
	    } else {
	        return false;
	    }
	}


	function changeStatus(ruletempid){
		var isUse = false;

		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false,parameters:'type=checkExist&ruletempid='+ruletempid,
			 onSuccess:  function(req, json){
			 var result = req.responseText;
			 if(result == "yes"){
				 isUse = true;
			  }
		     }
		});
		if(isUse){
			alert("该规则正被使用，不能停止");
			return;
		}
		if(confirm("是否改变状态？")){
			var form = document.getElementById("form");
			form.action="changeTempstate.do?ruletempid=" + ruletempid ;
			form.submit();
		}
	}
	</script><body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGLOG0041"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">监控管理 &gt;&gt; 监控配置 &gt;&gt; 规则模板管理</p>
</div>
	<div id="search">
		<div class="img"></div>
		<div class="conditions">
			<div>
				<span>模板名称：</span>
				<span>
				<html:text property="ruletempname" name="IGLOG0041Form"></html:text>
				</span>&nbsp;&nbsp;&nbsp;
				
				<span>所属设备IP：</span>
				<span>
				<html:text property="deviceip" name="IGLOG0041Form"></html:text>
				</span>&nbsp;&nbsp;&nbsp;
				
				<span>状态：</span>
				<html:select name="IGLOG0041Form" property="tempstates" style="width: 85px;" errorStyleClass="inputError">
				    <html:option value=""></html:option>
				    <html:option value="1">启用</html:option>
				    <html:option value="0">停用</html:option>
				</html:select>
				
				<br/>
				<span>所属设备类型：</span>
				<html:select name="IGLOG0041Form" property="typeid" style="width: 85px;" errorStyleClass="inputError" tabindex="4">
          	 		<html:option value=""></html:option>
          	 		<html:option value="0000">通用</html:option>
           			<ig:optionsCollection ccid="SYSLOG_DEVICETYPE" isMakeBlankRow="false" isCodeLabel="true"/>
    			</html:select>&nbsp;&nbsp;&nbsp;
    			
    			<span>描述：</span>
    			<span>
    				<html:text property="summary" name="IGLOG0041Form" style="width: 185px;"></html:text>
    			</span>
				
				&nbsp;&nbsp;&nbsp;&nbsp;
				<html:submit property="btn_search" styleClass="button" value="查询" />
			</div>
		</div>
	</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
	
			<tr>
				<th width="3%"><label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteId')"/> </label>
				</th>
				<th width="11%">名称</th>
				<th width="10%">条件</th>
				<th width="11%">设备类型</th>
				<th width="10%">条件个数</th>
				<th width="33%">描述</th>
				<th width="10%">状态</th>
				<th width="9%">修改/详细</th>
			</tr>
			
			<logic:present name="IGLOG0041VO" property="mss00004InfoList">
			
				<logic:iterate id="bean" name="IGLOG0041VO"
					property="mss00004InfoList" indexId="index" type="com.deliverik.infogovernor.syslog.model.Mss00004VWInfo">
					<tr class="<ig:rowcss index="${index}"/>">
						<td>
							<html:checkbox property="deleteId" value="${bean.ruletempid}"/>
						</td>
						<td>
							<div class="nowrapDiv">
			                	<logic:empty name="bean" property="ruletempname">&nbsp;</logic:empty> ${bean.ruletempname}
			            	</div>
						</td>
						<td>
							<div class="nowrapDiv">
								<logic:equal name="bean" property="rulecondition" value="0">
								与
								</logic:equal>
								<logic:equal name="bean" property="rulecondition" value="1">
								或
								</logic:equal>
			            	</div>
						</td>
						<td>
							<div class="nowrapDiv">
								<c:if test="${bean.typeid == '0000'}">通用</c:if>
			                	<ig:codeValue ccid="SYSLOG_DEVICETYPE" cid="${bean.typeid}"/>
			            	</div>
						</td>
						<td>
						<div class="nowrapDiv">
							<logic:empty name="bean" property="conditionCount">
								0
							</logic:empty>
							<logic:notEmpty name="bean" property="conditionCount">
								${bean.conditionCount}
							</logic:notEmpty>
			                	
		            	</div>
		            	</td>
		            	<td>
		            	<div class="nowrapDiv">
		            		<logic:empty name="bean" property="ruletempname">&nbsp;</logic:empty> ${bean.summary}
		            	</div>
						</td>
						<td>
							<div class="nowrapDiv">
								<logic:equal name="bean" property="tempstate" value="0">
								<a href="javascript:changeStatus('${bean.ruletempid}');"> <img
									src="images/stop.gif" border="0"
									alt="停用" />
								</a>
								</logic:equal> 
								<logic:equal name="bean" property="tempstate" value="1">
									<a href="javascript:changeStatus('${bean.ruletempid}');"> <img
										src="images/start.gif" border="0"
										alt="启用" />
									</a>
								</logic:equal>
			            	</div>
						</td>
						<td><html:link action="/IGLOG0043_EDIT_DISP.do?ruletempid=${bean.ruletempid}">
									<img src="images/edit.gif" alt="修改" width="16" height="16" border="0"/>
							</html:link>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
			
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGLOG0041VO"
		property="mss00004InfoList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return deleteRec('deleteId');" /></span>
	</logic:present>  
    <!-- paging -->
    <jsp:include page="/include/paging.jsp"/>
    <!-- /paging -->
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>