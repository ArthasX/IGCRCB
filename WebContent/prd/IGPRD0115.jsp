<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<html:html>
<bean:define id="id" value="IGPRD0115" toScope="request" />
<bean:define id="title" value="规则定义" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
	<script type="text/javascript">	
	    function addRule(){
	    	if( window.confirm("您是否确认保存？")){
		        return true;
			} else {
		        return false;
			}
	    }
	    function toDel(ptdid){
	    	if( window.confirm("您是否确认删除？")){
	    		IGPRD0115Form.action = getAppRootUrl() + "/IGPRD0115_Del.do?ptdid="+ptdid;
	    		IGPRD0115Form.submit();
			} else {
		        return false;
			}
	    }
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRD0115" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 规则定义</p>
	<div class="back">
		<a href="IGPRD0104_Back.do?pdid=${IGPRD0115Form.pdid}&ppsdid=${IGPRD0115Form.ppsdid}" target="_self">返回</a>
	</div> 
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="15%">当前状态</th>
			<th width="15%">跃迁状态</th>
			<th width="50%">跃迁规则</th>
			<th width="10%">删除</th>
		</tr>
		<logic:present name="IGPRD01151VO" property="processTransitionDefList">
			<logic:iterate id="bean" name="IGPRD01151VO"
				property="processTransitionDefList" indexId="index">
				<tr>
					<td>${bean.fromPSDTB.psdname}</td>
					<td>${bean.toPSDTB.psdname}</td>
					<td>并行节点</td>
					<td>
					<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
					<html:link href="javascript:toDel('${bean.ptdid}')">
						<img src="images/delete.gif" width="16" height="16" border="0"
							alt="删除" />
					</html:link>
					<%} %>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="formwrapper">
	<fieldset>
	<div><label for="Name"><strong>当前状态</strong>：</label>
	<p class="p2">${IGPRD01151VO.processStatusDef.psdname}</p>
	<br />
	</div>
	<div><label for="Name"><strong>跃迁状态</strong>：</label> <logic:present
		name="processStatusDefList">
		<html:select property="tpsdid" errorStyleClass="inputError imeActive"
			styleId="tpsdid" name="IGPRD0115Form">
			<html:options collection="processStatusDefList" property="value"
				name="" labelProperty="label" />
		</html:select>
	</logic:present> <br />
	</div>
	</fieldset>
	<html:hidden property="fpsdid" styleId="fpsdid" name="IGPRD0115Form"/>
	<html:hidden property="pdid" styleId="pdid"  name="IGPRD0115Form"/> 
	<html:hidden property="ppsdid" styleId="ppsdid" name="IGPRD0115Form"/>
	<div class="enter">
	<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
	<html:submit property="btn_add" styleClass="button" value="保存" onclick="return addRule()"/>
	<%} %>
	</div>
	</div>
</html:form>
</div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>
