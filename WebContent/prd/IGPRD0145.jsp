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
<bean:define id="id" value="IGPRD0145" toScope="request" />
<bean:define id="title" value="查询条件配置页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
.boxfield{
	width:485px;
	float: left;
	margin-left:10px;
}
.selectBoxLeft,.selectBoxRight{
	width:200px;
	height:400px;
}
</style>
<script type="text/javascript">	

jQ(document).ready(function(){
	jQ(".info_add").click(function(){
		jQ(this).parent().parent().find(".selectBoxLeft option:selected").appendTo(jQ(this).parent().parent().find(".selectBoxRight"));
	});
	jQ(".info_addAll").click(function(){
		jQ(this).parent().parent().find(".selectBoxLeft option").appendTo(jQ(this).parent().parent().find(".selectBoxRight"));
	});
	jQ(".info_del").click(function(){
		jQ(this).parent().parent().find(".selectBoxRight option:selected").appendTo(jQ(this).parent().parent().find(".selectBoxLeft"));
	});
	jQ(".info_delAll").click(function(){
		jQ(this).parent().parent().find(".selectBoxRight option").appendTo(jQ(this).parent().parent().find(".selectBoxLeft"));
	});
	jQ(".selectBoxLeft").dblclick(function(){
		jQ(this).find(":selected").appendTo(jQ(this).parent().parent().find(".selectBoxRight"));
	});
	jQ(".selectBoxRight").dblclick(function(){
		jQ(this).find(":selected").appendTo(jQ(this).parent().parent().find(".selectBoxLeft"));
	});
});
function checkForm(){
	if(window.confirm("是否确认提交？")){
		var showColumn = document.getElementById("showColumn");
		var query = document.getElementById("query");
		for(var i=0;i<showColumn.options.length;i++){
			createHiddenInputForm("processQueryShowColumns",showColumn.options[i].value,form);
		}
		for(var i=0;i<query.options.length;i++){
			createHiddenInputForm("processQuerys",query.options[i].value,form);
		}
		return true;
	}else{
		return false;
	}
}
function editWidth(){
	if(window.confirm("是否确认提交？")){
		var showColumn = document.getElementById("showColumn");
		var query = document.getElementById("query");
		for(var i=0;i<showColumn.options.length;i++){
			createHiddenInputForm("processQueryShowColumns",showColumn.options[i].value,form);
		}
		for(var i=0;i<query.options.length;i++){
			createHiddenInputForm("processQuerys",query.options[i].value,form);
		}
		form.action = "IGPRD0145_Width.do";
		return true;
	}else{
		return false;
	}
}

</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRD0145.do" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="查询配置"/></p>
<div class="back"><a href="IGPRD0101_Back.do" target="_self">返回</a></div> 
</div>
<div class="boxfield">
<fieldset>
	<legend>显示列</legend>
	<table>
		<tr>
			<td>
				<select size="15" class="selectBoxLeft">
					<logic:present name="IGPRD01451VO" property="queryShowColumnMap">
						<logic:iterate id="map" name="IGPRD01451VO" property="queryShowColumnMap">
							<option value="${map.key }#100">${map.value }</option>
						</logic:iterate>
					</logic:present>
				</select>
			</td>
			<td>
				<input type="button" style="width:30px;" class="info_add" title="添加" value=">"/><br />
		       	<input type="button" style="width:30px;" class="info_addAll" title="全部添加" value=">>"/><br />
	        	<input type="button" style="width:30px;" class="info_del" title="删除" value="<"/><br />
		       	<input type="button" style="width:30px;" class="info_delAll" title="全部删除" value="<<"/><br />
			</td>
			<td>
				<select size="15" id="showColumn" class="selectBoxRight">
					<logic:present name="IGPRD01451VO" property="queryShowColumnList">
						<logic:iterate id="bean" name="IGPRD01451VO" property="queryShowColumnList">
							<option value="${bean.stype }#${bean.sflag }#${bean.sname}#${bean.width}">${bean.sname }</option>
						</logic:iterate>
					</logic:present>
				</select>
			</td>
		</tr>
	</table>
</fieldset>
</div>
<div class="boxfield">
<fieldset>
	<legend>查询条件</legend>
	<table>
		<tr>
			<td>
				<select size="15" class="selectBoxLeft">
					<logic:present name="IGPRD01451VO" property="queryMap">
						<logic:iterate id="map" name="IGPRD01451VO" property="queryMap">
							<option value="${map.key }">${map.value }</option>
						</logic:iterate>
					</logic:present>
				</select>
			</td>
			<td>
				<input type="button" style="width:30px;" class="info_add" title="添加" value=">"/><br />
		       	<input type="button" style="width:30px;" class="info_addAll" title="全部添加" value=">>"/><br />
	        	<input type="button" style="width:30px;" class="info_del" title="删除" value="<"/><br />
		       	<input type="button" style="width:30px;" class="info_delAll" title="全部删除" value="<<"/><br />
			</td>
			<td>
				<select size="15" id="query" class="selectBoxRight">
					<logic:present name="IGPRD01451VO" property="queryList">
						<logic:iterate id="bean" name="IGPRD01451VO" property="queryList">
							<option value="${bean.qtype }#${bean.qflag }#${bean.qname}">${bean.qname }</option>
						</logic:iterate>
					</logic:present>
				</select>
			</td>
		</tr>
	</table>
</fieldset>
</div>
<br/>
<div class="enter">
		<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return checkForm();"/>
		<html:submit property="btn_insert" value="列宽定义" styleClass="button" onclick="return editWidth();"/>
	<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse"))){ %>
		<html:reset property="btn_clear" styleClass="button" value="重置" />
	<%} %>
</div>
<html:hidden property="pdid" styleId="pdid" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>