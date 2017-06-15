<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<html:html>
<bean:define id="id" value="IGPRD0114" toScope="request" />
<bean:define id="title" value="参与者页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//设定分派角色
	function setAssignRole(){
		var flag = true;
		var role = document.getElementsByName("ppdid");
		for(var i = 0; i < role.length; i++){ 
	        if(role[i].checked){
	        	flag = false;
	        	break;
		    }      
        }
		if(flag) {
			alert("请选择分派部门！");
           	return false;
		}
        if(window.confirm("请确认是否要进行分派部门设定处理?")){
            return true;
        } else {
            return false;
        }
	}

	//清除分派角色
	function clearAssignRole(){
        if(window.confirm("请确认是否要进行分派部门清除处理?")){
            document.getElementById("mode").value = "1";
            return true;
        } else {
            return false;
        }
	}

	//初始化
	function initRadio(){
		var role = document.getElementsByName("ppdid");
		for(var i = 0; i < role.length; i++){ 
			<logic:present name="IGPRD01141VO" property="processParticipantDefList">
			<logic:iterate id="bean" name="IGPRD01141VO" property="processParticipantDefList" indexId="index">
	        if(role[i].value == "${bean.ppdid}" && "${bean.ppdsuper}" == "1"){
	        	role[i].checked = true;
	        	break;
		    }      
			</logic:iterate>
			</logic:present>
        }
	}
//-->
	</script>
<body onload="initRadio()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRD0114" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 状态列表 &gt;&gt; 主办部门</p>
<div class="back"><a href="IGPRD0104_Back.do?pdid=${IGPRD0114Form.pdid}" target="_self">返回</a></div> 
</div>
	<div class="role_title">主办部门</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="tab_del" class="table_style4" align="left" style="width: 40%">
			<tr>
				<th width="30%"></th>
				<th width="70%">部门名称</th>
			</tr>
			<logic:present name="IGPRD01141VO" property="processParticipantDefList">
				<logic:iterate id="bean" name="IGPRD01141VO" property="processParticipantDefList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
							<html:radio property="ppdid" value="${bean.ppdid}" name="IGPRD0114Form" styleId="ppdid"/>
						 	</label>
						</td>
						<td>
							<c:if test="${bean.roleid!=null}">
								${bean.role.rolename}
							</c:if>
							<c:if test="${bean.orgid!=null}">
								${bean.org.orgname}
							</c:if>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRD01141VO" property="processParticipantDefList">
		<span>
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
		<html:submit property="btn_set" value="设定"
			styleClass="button" onclick="return setAssignRole();" />
		<html:submit property="btn_clear" value="清除"
			styleClass="button" onclick="return clearAssignRole();" />
		<%} %>	
		</span>
	</logic:present>
	</div>
	<html:hidden property="pdid"  name="IGPRD0114Form" styleId="pdid"/>
	<html:hidden property="psdid"  name="IGPRD0114Form" styleId="psdid"/>
	<html:hidden property="mode"  name="IGPRD0114Form" styleId="mode"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>