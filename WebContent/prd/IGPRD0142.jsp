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
<bean:define id="id" value="IGPRD0142" toScope="request" />
<bean:define id="title" value="可调整参与者页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function addRec(){
        if(window.confirm("请确认是否要进行添加?")){
			IGPRD0142Form.action = getAppRootUrl() + "/IGPRD0142.do";
            return true;
        } else {
            return false;
        }
	}

	function checkAndCreate(flag){
		var count=0;
		if(flag==1){
			count = checkNum("roleids");
		}else{
			count = checkNum("psrdids");
		}
		return count;
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
<html:form styleId="form" action="/IGPRD0142" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 状态列表 &gt;&gt; 可调整参与者  </p>
<div class="back">
	<a href="IGPRD0104_Back.do?pdid=${IGPRD0142Form.pdid}&ppsdid=${IGPRD0142Form.ppsdid}" target="_self">返回</a>
</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="tab_del" class="table_style4" align="left">
			<tr>
				<th width="20%">
					<label> 
						<input type="checkbox" name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','ids')"/>
					</label>
				</th>
				<th width="60%">可选状态</th>
				<th width="20%"></th>
			</tr>
			<logic:present name="IGPRD01421VO" property="psdTBList">
				<logic:iterate id="bean" name="IGPRD01421VO" property="psdTBList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td height="20">
							<label>
								<logic:equal name="bean" property="isSelected" value="1">
									<input type="checkbox" name="ids" value="${bean.psdid}" checked="checked">
								</logic:equal>
								<logic:equal name="bean" property="isSelected" value="0">
									<input type="checkbox" name="ids" value="${bean.psdid}">
								</logic:equal>
						 	</label>
						</td>
						<td>
							${bean.psdname}
						</td>
						<td>
							
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
		<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
		<html:submit property="btn_delete" value="添加所选"
				styleClass="button" onclick="return addRec();" />
		<%} %>	
	</div>
	<html:hidden property="psdid" styleId="psdid" />
	<html:hidden property="pdid" styleId="pdid" />
	<html:hidden property="ppsdid" styleId="ppsdid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>