<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.wkm.extwa.bl.IGEXWTA01BLType"%>
<html:html>
<bean:define id="id" value="IGEXTWA0103" toScope="request" />
<bean:define id="title" value="工作查看页面" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
<!--
<%-- 提交表单--%>
var gid='IGEXTWA0103'; 
function goPage(url){
	document.forms[0].action=url+"?bkmode="+'<bean:write name="IGEXTWA0103Form" property="bkmode" />';
	document.forms[0].submit();
}
//-->
</script>
<logic:present name="IGEXTWA01031VO">
	<bean:define id="process" name="IGEXTWA01031VO" property="process" />
</logic:present>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGEXTWA0103_Disp"
	styleId="form" onsubmit="return checkSubmit(this);">
	<%-- 工作编号--%>
	<html:hidden property="prid" />
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">查看</p>
	<div class="back">
	<logic:notEqual name="IGEXTWA0103Form" value="1" property="bkmode">
	<a href="IGWKM0101_BACK.do?prtype=WA" target="_self">返回</a>
	</logic:notEqual>
	<logic:equal name="IGEXTWA0103Form" value="1" property="bkmode">
	<a href="IGWKM0102.do" target="_self">返回</a>
	</logic:equal>
	</div>
	</div>
	  <logic:present name="process">
	 <div id="results_list">
		<table width="603" border="0" cellspacing="0" cellpadding="0">
		  <tr>
		    <td width="50"/></td>
		    <td width="26" height="41" align="center" valign="middle">
		    	<img src="images/wkm/extwa/person.gif" width="26" height="42" />
		    </td>
		    <td width="75" align="center" valign="middle">
		    <img src="images/wkm/extwa/one.gif" width="61" height="15" />
		    </td>
		    
		    <td width="26" height="41" align="center" valign="middle">
		    <logic:equal name="process" property="prstatus" value="P">
		    	<img src="images/wkm/extwa/person1.gif" width="26" height="42" />
		    </logic:equal>
		    <logic:notEqual name="process" property="prstatus" value="P">
		    	<img src="images/wkm/extwa/person.gif" width="26" height="42" />
		    </logic:notEqual>
		    </td>
		    <td width="75" align="center">
		    <img src="images/wkm/extwa/two.gif" width="61" height="15" />
		    </td>
		    
		    <td width="26" height="41" align="center" valign="middle">
		    <logic:equal name="process" property="prstatus" value="E">
		    	<img src="images/wkm/extwa/person1.gif" width="26" height="42" />
		    </logic:equal>
		    <logic:notEqual name="process" property="prstatus" value="E">
		    	<img src="images/wkm/extwa/person.gif" width="26" height="42" />
		    </logic:notEqual>
		    </td> 
		    <td width="75" align="center" valign="middle">
		    <img src="images/wkm/extwa/three.gif" width="61" height="33" />
		    </td>
		    
		    <td width="26" align="center" valign="middle">
		    <logic:equal name="process" property="prstatus" value="V">
		    	<img src="images/wkm/extwa/person1.gif" width="26" height="42" />
		    </logic:equal>
		    <logic:notEqual name="process" property="prstatus" value="V">
		    	<img src="images/wkm/extwa/person.gif" width="26" height="42" />
		    </logic:notEqual>
		    </td>
		    <td width="75" align="center" valign="middle">
		    <img src="images/wkm/extwa/four.gif" width="61" height="15" />
		    </td>
		    
		    <td width="48" align="left" valign="middle">
		    <logic:equal name="process" property="prstatus" value="C">
		    	<img src="images/wkm/extwa/circle1.gif" width="48" height="48" />
		    </logic:equal>
		    <logic:notEqual name="process" property="prstatus" value="C">
		    	<img src="images/wkm/extwa/circle.gif" width="48" height="48" />
		    </logic:notEqual>
		    </td>
		  </tr>
		</table>
	</div>
	</logic:present>
	<logic:present name="personinfo">
	<div class="title">
	<div class="name">参与人员</div>
	</div>
	<div class="record_list">
	<table cellspacing="2">
		<tr>
			<td><bean:write name="personinfo" filter="false"/></td>
		</tr>
	</table>
	</div>
	</logic:present>
	<jsp:include page="/include/IGEXTWA.jsp">
		<jsp:param name="vo" value="IGEXTWA01031VO"/>
	</jsp:include>
	<div class="title">
	<div class="name"></div>
	</div>
	<div class="record_list"><!--  message --> <ig:message /> <!--  /message -->
	<logic:present name="IGEXTWA01031VO" property="actionnameList">
		<logic:iterate id="but" name="IGEXTWA01031VO" property="actionnameList">
			<logic:equal name="but"
				value="<%=IGEXWTA01BLType.PROCESS_ACTION_ADDCOMMENT%>">
				<div class="action"><img src="images/icon2_074.gif" width="16"
					height="16" /><a href="javascript:goPage('IGEXTWA0106_Disp.do')">更新信息</a></div>
			</logic:equal>
			<logic:equal name="but"
				value="<%=IGEXWTA01BLType.PROCESS_ACTION_IMPLEMENTORS%>">
				<div class="action"><img src="images/clr.gif" width="16"
					height="16" /><a href="javascript:goPage('IGEXTWA0104_Disp.do')">调整处理人</a></div>
			</logic:equal>
			<logic:equal name="but"
				value="<%=IGEXWTA01BLType.PROCESS_ACTION_VERIFIORS%>">
				<div class="action"><img src="images/shr.gif" width="16"
					height="16" /><a href="javascript:goPage('IGEXTWA0105_Disp.do')">添加审核人</a></div>
			</logic:equal>
			<logic:equal name="but"
				value="<%=IGEXWTA01BLType.PROCESS_ACTION_IMPLEMENT%>">
				<div class="action"><img
					src="images/Developpers_Icons_031.gif" width="16" height="16" /><a
					href="javascript:goPage('IGEXTWA0107_Disp.do')">申请审核</a></div>
			</logic:equal>
			<logic:equal name="but"
				value="<%=IGEXWTA01BLType.PROCESS_ACTION_VERIFY%>">
				<div class="action"><img src="images/icon2_089.gif" width="16"
					height="16" /><a href="javascript:goPage('IGEXTWA0108_Disp.do')">审核</a></div>
			</logic:equal>
			<logic:equal name="but"
				value="<%=IGEXWTA01BLType.PROCESS_ACTION_TERMINATE%>">
				<div class="action"><img src="images/zz.gif" width="16"
					height="16" /><a href="javascript:goPage('IGEXTWA0110_Disp.do')">中止</a></div>
			</logic:equal>
			<logic:equal name="but"
				value="<%=IGEXWTA01BLType.PROCESS_ACTION_MANAGER%>">
				<div class="action"><img src="images/fp.gif" width="16"
					height="16" /><a href="javascript:goPage('IGEXTWA0112_Disp.do')">调整执行人</a></div>
			</logic:equal>
		</logic:iterate>
	</logic:present>
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>