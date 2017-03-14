<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0415" toScope="request" />
<bean:define id="title" value="授权管理报表授权画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function deleteRec(obj,flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="角色" />';
        var mode="0";
		if(flag=="1"){
			message = '请选择添加对象。';
			confirmMsg = '请确认是否要进行角色添加处理?';
			mode="1";
		}
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
        if(window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGSYM0415.do?mode="+mode;
            return true;
        } else {
            return false;
        }
	}

//-->
</script>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGSYM0415"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
<div class="back"><a href="IGSYM0415_RE.do" target="_self">返回</a></div>
</div>
	<div class="role_title">被授权角色</div>
	<div id="results_list">

	<table class="table_style6" align="left" >
			<tr>
				<th width="22%">
				角色名称
				</th>
				<td ><bean:write name="IGSYM0415Form" property="rolename"/>
				<html:hidden property="roleid" styleId="roleid" />
				</td>				
			</tr>	
			
	</table>
	</div>
	<div class="role_title">已授权报表</div>
	<div id="results_list"><!--  message --><ig:message /><!--  /message -->
	
	<table class="table_style4" align="left">
		
			<tr>
				<th width="10%">
				<label> <input type="checkbox"
					name="checkbox" id="checkbox" onclick="selectAll('checkbox','rfdidy')"/> </label>
					</th>
				<th width="32%">
				报表名
				</th>
				<th width="46%">
				报表说明
				</th>				
			</tr>
		
			<logic:present name="IGSYM04151VO" property="ownList">
				<logic:iterate id="bean" name="IGSYM04151VO"
					property="ownList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						
						<td><label><html:checkbox
							property="rfdidy" value="${bean.rfdid}" /> </label>
						</td>
						<td><logic:empty name="bean"
							property="rfdtitle">&nbsp;</logic:empty>${bean.rfdtitle}
						</td>
						<td><logic:empty name="bean"
							property="rfddesc">&nbsp;</logic:empty>${bean.rfddesc}
						</td>
												
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGSYM04151VO"
		property="ownList">
		<span> <html:submit property="btn_delete" value="删除所选" 
			styleClass="button" onclick="return deleteRec('rfdidy','0');" /></span>
	</logic:present>
	</div>
	
	<!-- ================== -->

	<div class="role_title">未授权报表</div>
	<div id="results_list">
	
	<table class="table_style4" align="left">
		
		<tr>
			<th width="10%">
			<label> <input type="checkbox"
				name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','rfdids')"/> </label>
				</th>
			<th width="32%">
			报表名
			</th>
			<th width="46%">
			报表说明
			</th>
		</tr>
		
		<logic:present name="IGSYM04151VO" property="yroleList">
			<logic:iterate id="bean" name="IGSYM04151VO"
				property="yroleList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><label><html:checkbox
						property="rfdids" value="${bean.rfdid}" /> </label>
					</td>
					<td><logic:empty name="bean"
						property="rfdtitle">&nbsp;</logic:empty>${bean.rfdtitle}
					</td>
					<td><logic:empty name="bean"
						property="rfddesc">&nbsp;</logic:empty>${bean.rfddesc}
					</td>	
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGSYM04151VO"
		property="yroleList">
		<span> <html:submit property="btn_delete" value="添加所选"
			styleClass="button" onclick="return deleteRec('rfdids','1');" /></span>
	</logic:present>
	</div>
	<html:hidden property="rfdid" styleId="rfdid" />
	<html:hidden property="roleid" styleId="roleid" />

</html:form>
<div class="Placeholder"></div>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>