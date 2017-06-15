<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<%@ page import="com.deliverik.infogovernor.util.CodeDefine" %>
<html:html>
<bean:define id="id" value="IGPRD0145h" toScope="request" />
<bean:define id="title" value="查询条件配置页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function deleteRec(flag){
        var message = '删除';
        var objs = document.getElementsByName("pidid_del");
		if(flag=="1"){
			objs = document.getElementsByName("pidid_add");
			message = '添加';
		}
		if(objs==null){
			alert("没有要"+message+"的信息！");
			return false;
		}
		var countflag = true;
		for(var i=0;i<objs.length;i++){
			if(objs[i].checked){
				countflag = false;
				break;
			}
		}
		if(countflag){
			alert("请选择要"+message+"的信息！");
			return false;
		}
        if(window.confirm("是否确认"+message+"？")){
        	form.action = getAppRootUrl() + "/IGPRD0145.do?mode="+flag;
            return true;
        } else {
            return false;
        }
	}

//-->
	</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRD0145" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt;历史版本&gt;&gt; 查询条件配置</p>
<div class="back"><a href="IGPRD0140_Back.do" target="_self">返回</a></div> 
</div>
	<div class="role_title">现有条件</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="tab_del" class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label> 
						<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','pidid_del')"/>
					</label>
				</th>
				<th width="40%">表单名称</th>
				<th width="40%"></th>
			</tr>
			<logic:present name="IGPRD01451VO" property="pqList">
				<logic:iterate id="bean" name="IGPRD01451VO" property="pqList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
								<input type="checkbox" name="pidid_del" value="${bean.pqid}">
						 	</label>
						</td>
						<td>${bean.pidTB.pidname }</td>
						<td>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div class="role_title">可选条件</div>
	<div id="results_list">
	<table class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label>
						<input type="checkbox" name="checkbox2" id="checkbox2" onclick="selectAll('checkbox2','pidid_add')"/> 
					</label>
				</th>
				<th width="40%">表单名称</th>
				<th width="40%"></th>
			</tr>
			<logic:present name="IGPRD01451VO" property="pdList">
				<logic:iterate id="bean" name="IGPRD01451VO" property="pdList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
								<input type="checkbox" name="pidid_add" value="${bean.pidid}">
							</label>
						</td>
						
						<td>
							${bean.pidname}
						</td>
						<td>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<html:hidden property="pdid" styleId="pdid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>