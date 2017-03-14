<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRD0113" toScope="request" />
<bean:define id="title" value="流程变量查询画面" toScope="request" />
<%
	String path = request.getParameter("path");
%>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		
		function setParentValue(id,type,name,option){
			if(!window.opener.closed){
                window.opener.setVariableLogic(id, type,name,option);
            }
            window.close();
		}
       	
</script>
<body style="background-color: white; background-image: none;">
<div id="maincontent">
<div id="contentainer">
<html:form styleId="form" action="/IGPRD0113_Disp.do">
<div id="location">
<div class="image"></div>
<p class="fonts1">流程变量查询</p>
</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
<!--			<th width="5%">序号</th>-->
			<th width="15%">变量ID</th>
			<th width="15%">变量名称</th>
			<th width="10%">变量类型</th>
			<th width="20%">取值范围</th>
            <th width="10%">默认值</th>
			<th width="25%">变量说明</th>
		</tr>
		<logic:present name="IGPRD01101VO" property="processInfoDefList">
			<logic:iterate id="bean" name="IGPRD01101VO"
				property="processInfoDefList" indexId="index">
				<logic:equal property="pidtype" name="bean" value="7">
				<tr onmouseover="mouseOver(this);"
					onmouseout="mouseOut(this,'');"
					onclick="setParentValue('${bean.pidid}','${bean.pidtype}','${bean.pidname}','${bean.pidoption}')">
<!--					<td>${index+1}</td>-->
					<td>${bean.pidid}</td>
					<td><logic:empty name="bean" property="pidname">&nbsp;</logic:empty>${bean.pidname}</td>
					<td>
						<ig:codeValue ccid="PROCESSINFODEF_TYPE_CODE_WD" cid="${bean.pidtype}" />
					</td>
					<td><logic:empty name="bean" property="pidoption">&nbsp;</logic:empty>${bean.pidoption}</td>
					<td><logic:empty name="bean" property="piddefault">&nbsp;</logic:empty>${bean.piddefault}</td>
					<td><logic:empty name="bean" property="piddesc">&nbsp;</logic:empty>${bean.piddesc}</td>
				</tr>
				</logic:equal>
				<logic:equal property="pidtype" name="bean" value="3">
				<tr onmouseover="mouseOver(this);"
					onmouseout="mouseOut(this,'');"
					onclick="setParentValue('${bean.pidid}','${bean.pidtype}','${bean.pidname}','${bean.pidoption}')">
<!--					<td>${index+1}</td>-->
					<td>${bean.pidid}</td>
					<td><logic:empty name="bean" property="pidname">&nbsp;</logic:empty>${bean.pidname}</td>
					<td>
						<ig:codeValue ccid="PROCESSINFODEF_TYPE_CODE_WD" cid="${bean.pidtype}" />
					</td>
					<td><logic:empty name="bean" property="pidoption">&nbsp;</logic:empty>${bean.pidoption}</td>
					<td><logic:empty name="bean" property="piddefault">&nbsp;</logic:empty>${bean.piddefault}</td>
					<td><logic:empty name="bean" property="piddesc">&nbsp;</logic:empty>${bean.piddesc}</td>
				</tr>
				</logic:equal>
				<logic:equal property="pidtype" name="bean" value="A">
				<tr onmouseover="mouseOver(this);"
					onmouseout="mouseOut(this,'');"
					onclick="setParentValue('${bean.pidid}','${bean.pidtype}','${bean.pidname}','${bean.pidoption}')">
<!--					<td>${index+1}</td>-->
					<td>${bean.pidid}</td>
					<td><logic:empty name="bean" property="pidname">&nbsp;</logic:empty>${bean.pidname}</td>
					<td>
						<ig:codeValue ccid="PROCESSINFODEF_TYPE_CODE_WD" cid="${bean.pidtype}" />
					</td>
					<td><logic:empty name="bean" property="pidoption">&nbsp;</logic:empty>${bean.pidoption}</td>
					<td><logic:empty name="bean" property="piddefault">&nbsp;</logic:empty>${bean.piddefault}</td>
					<td><logic:empty name="bean" property="piddesc">&nbsp;</logic:empty>${bean.piddesc}</td>
				</tr>
				</logic:equal>
				<logic:equal property="pidtype" name="bean" value="R">
				<tr onmouseover="mouseOver(this);"
					onmouseout="mouseOut(this,'');"
					onclick="setParentValue('${bean.pidid}','${bean.pidtype}','${bean.pidname}','${bean.pidoption}')">
<!--					<td>${index+1}</td>-->
					<td>${bean.pidid}</td>
					<td><logic:empty name="bean" property="pidname">&nbsp;</logic:empty>${bean.pidname}</td>
					<td>
						<ig:codeValue ccid="PROCESSINFODEF_TYPE_CODE_WD" cid="${bean.pidtype}" />
					</td>
					<td><logic:empty name="bean" property="pidoption">&nbsp;</logic:empty>${bean.pidoption}</td>
					<td><logic:empty name="bean" property="piddefault">&nbsp;</logic:empty>${bean.piddefault}</td>
					<td><logic:empty name="bean" property="piddesc">&nbsp;</logic:empty>${bean.piddesc}</td>
				</tr>
				</logic:equal>
				<logic:equal property="pidtype" name="bean" value="2">
				<tr onmouseover="mouseOver(this);"
					onmouseout="mouseOut(this,'');"
					onclick="setParentValue('${bean.pidid}','${bean.pidtype}','${bean.pidname}','${bean.pidoption}')">
<!--					<td>${index+1}</td>-->
					<td>${bean.pidid}</td>
					<td><logic:empty name="bean" property="pidname">&nbsp;</logic:empty>${bean.pidname}</td>
					<td>
						<ig:codeValue ccid="PROCESSINFODEF_TYPE_CODE_WD" cid="${bean.pidtype}" />
					</td>
					<td><logic:empty name="bean" property="pidoption">&nbsp;</logic:empty>${bean.pidoption}</td>
					<td><logic:empty name="bean" property="piddefault">&nbsp;</logic:empty>${bean.piddefault}</td>
					<td><logic:empty name="bean" property="piddesc">&nbsp;</logic:empty>${bean.piddesc}</td>
				</tr>
				</logic:equal>
				<logic:equal property="pidtype" name="bean" value="B">
				<tr onmouseover="mouseOver(this);"
					onmouseout="mouseOut(this,'');"
					onclick="setParentValue('${bean.pidid}','${bean.pidtype}','${bean.pidname}','${bean.pidoption}')">
<!--					<td>${index+1}</td>-->
					<td>${bean.pidid}</td>
					<td><logic:empty name="bean" property="pidname">&nbsp;</logic:empty>${bean.pidname}</td>
					<td>
						<ig:codeValue ccid="PROCESSINFODEF_TYPE_CODE_WD" cid="${bean.pidtype}" />
					</td>
					<td><logic:empty name="bean" property="pidoption">&nbsp;</logic:empty>${bean.pidoption}</td>
					<td><logic:empty name="bean" property="piddefault">&nbsp;</logic:empty>${bean.piddefault}</td>
					<td><logic:empty name="bean" property="piddesc">&nbsp;</logic:empty>${bean.piddesc}</td>
				</tr>
				</logic:equal>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
	<html:hidden property="pidmode" name="IGPRD0110Form" styleId="pidmode"/>
</html:form></div>
</div>
</body>
</html:html>