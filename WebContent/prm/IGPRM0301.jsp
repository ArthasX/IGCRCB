<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.deliverik.infogovernor.prm.vo.IGPRM03011VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG007Info"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<%
String pdid = request.getParameter("pdid");
IGPRM03011VO vo = (IGPRM03011VO)request.getAttribute("vo");
List<IG007Info> processInfoDefList = vo.getProcessInfoDefList();
Map<String,String> typeMap = vo.getTypeMap();
%>
<html:html>
<bean:define id="id" value="IGPRM0301" toScope="request" />
<bean:define id="title" value="变量查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<script type="text/javascript">
function deleteItem(){
	var idArray = document.getElementsByName("pidid");
	var checkboxLength = idArray.length;
	if(idArray == null || checkboxLength == 0){
		document.getElementById("msg").innerHTML = "<font color='red'>未选择任何变量</font>"
		return false;
	}
	for(var i = 0; i < checkboxLength; i++){
		if(idArray[i].checked){
			if(confirm("确认删除所选项?")){
				return true;
			}
			return false;
		}
	}
	document.getElementById("msg").innerHTML = "<font color='red'>未选择任何项目</font>"
	return false;
}
</script>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/deleteIG007"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">系统管理 &gt;&gt; 流程类型 &gt;&gt; 变量列表</p>
<div class="back"><html:link href="IGPRM0201_Disp.do">返回</html:link></div>
</div>
 	<div id="results_list">
	<table width="600"><tr><td style="word-break: break-all;"><ig:message /></td></tr></table>
       <table class="table_style">
			<tr>
				<th width="5%">选择</th>
				<th width="10%">变量名称</th>
				<th width="10%">显示名称</th>
                <th width="10%">变量类型</th>
                <th width="20%">取值范围</th>
                <th width="10%">默认值</th>
                <th width="22%">描述</th>
                <th width="13%">是否必填</th>
			</tr>
			<%for(IG007Info processInfoDef : processInfoDefList) {%>
			<tr>
                <td><input type="checkbox" name="pidid" value="<%=processInfoDef.getPidid() %>" /></td>
                <td><%=processInfoDef.getPidname()==null?"":processInfoDef.getPidname() %></td>
                <td><%=processInfoDef.getPidlabel()==null?"":processInfoDef.getPidlabel() %></td>
				<td>
				<ig:codeValue ccid="PROCESSINFODEF_TYPE_CODE" cid="<%=processInfoDef.getPidtype() %>" />
				</td>
				<td><%=processInfoDef.getPidoption()==null?"":processInfoDef.getPidoption() %></td>
				<td><%=processInfoDef.getPiddefault()==null?"":processInfoDef.getPiddefault() %></td>
				<td><%=processInfoDef.getPiddesc()==null?"":processInfoDef.getPiddesc() %></td>
				<td><%="1".equals(processInfoDef.getPidrequired())?"是":"否" %></td>
			</tr>
			<%} %>
		</table>
    </div>
    <div class="enter">
		<span id="msg"></span>
    </div>
	<div class="enter">
		<input name="pdid" type="hidden" value="<%=pdid %>">
        <input name="delete" type="submit" class="button" value="删除所选" onclick="return deleteItem();" />
        <input name="creat" type="button" class="button" value="新增" onclick="window.location='IGPRM0302_Disp.do?pdid=<%=pdid %>';" />
        <input type="button" name="gttc" value="选择共通变量" class="button" onclick="location='IGPRD0117.do?gtbl=basic&pdid=<%=pdid %>'">
        <logic:equal value="1" name="vo" property="addDefaultApprover">
        <input name="add" type="button" class="button" value="缺省审批人" onclick="window.location='IGPRM0304_Disp.do?pdid=<%=pdid %>';" />
        </logic:equal>
        <logic:equal value="2" name="vo" property="addDefaultApprover">
        <input name="add" type="button" class="button" value="缺省审批人" onclick="window.location='IGPRM0304_Disp.do?pdid=<%=pdid %>&prtype=<%=IGPROCESSType.SERVICE_PRTYPE%>';" />
        </logic:equal>
        <logic:equal value="1" name="vo" property="addDefaultApproveDispatcher">
        <input name="add" type="button" class="button" value="缺省审批分派人" onclick="window.location='IGPRM0305_Disp.do?pdid=<%=pdid %>';" />
        </logic:equal>
    	<input name="return" type="button" class="button" value="返回" onclick="window.location='IGPRM0201_Disp.do';" />
    </div>
</html:form>
</div>
</div>
</div>


</div>
</body>
</html:html>