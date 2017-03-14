<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<%@ page import="com.deliverik.infogovernor.util.CodeDefine" %>
<html:html>
<bean:define id="id" value="IGPRD0146" toScope="request" />
<bean:define id="title" value="查询配置页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
.edit_table_style{    
    margin:0 auto;    
    border-collapse:collapse;     
    text-align:center; 
    table-layout:fixed;  

}    
.edit_table_style th{ 
	color:#000000;   
    border-top:1px solid #CCCCCC;
    border-bottom:1px solid #CCCCCC;
    background-color:#EEEEEE;
    height:20px;      
}  
.edit_table_style td{ 
	color:#000000;   
    border-bottom:1px solid #CCCCCC;
    height:20px;      
}   
.borderTD{
	width:1px;
	background-color:#ccc;
	cursor: col-resize;
} 
</style>
<script type="text/javascript">	
<!--
var tb = null;
jQ(document).ready(function(){
	tb = jQ(".edit_table_style")[0];
	jQ(".borderTD").mousedown(function(e){
		var evenObj = e.target;
		jQ(document).bind("mousemove",function(e){
			if(evenObj){
				var $target = jQ(evenObj).prev();
				var left = $target.position().left;
				var right = e.clientX;
				var width = right - left;
				if(width > 0){
					$target.width(width);
					$target.find("input[name='columnWidth']").val(width);
					var cellIndex = $target[0].cellIndex;
					tb.rows[1].cells[cellIndex].innerHTML = width;
				}
			}
		}).mouseup(function(e){
			jQ(document).unbind("mousemove");
		});
	});
	jQ(".contentTD").bind("dblclick",editWidth);
});
var editWidth = function(e){
	var width = this.innerHTML;
	this.innerHTML = "<input type='text' style='width:100%;border:none;text-align:center;' flag='2' onkeydown='return columnValueNumber();' onchange='changeNumber(this);' name='showWidth' value='" + width + "'/>";
	jQ(this).unbind("dblclick");
};
function changeNumber(obj){
	var td = obj.parentElement;
	var cellIndex = td.cellIndex;
	var target = tb.rows[0].cells[cellIndex];
	var width = obj.value ? parseInt(obj.value) : 0;
	jQ(target).find("input[name='columnWidth']").val(width);
	jQ(target).width(width);
	td.innerHTML = width;
	jQ(td).bind("dblclick",editWidth);
}
function checkForm(){
	if(window.confirm("是否确认提交？")){
		return true
	}else{
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
<html:form styleId="form" action="/IGPRD0146.do" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="查询配置"/></p>
<div class="back"><a href="IGPRD0145_Disp.do?pdid=${IGPRD0146Form.pdid }" target="_self">返回</a></div> 
</div>
<div id="results_list" style="overflow-x:auto;overflow-y: hidden; ">
	<table class="edit_table_style">
		<logic:present name="IGPRD01461VO" property="queryShowColumnList">
			<tr>
				<td style="width:1px; background-color:#ccc;"></td>
				<logic:iterate id="bean" name="IGPRD01461VO" property="queryShowColumnList">
					<th style="width:${bean.width}px;">
						${bean.sname }
						<input type="hidden" name="columnWidth" value="${bean.width }"/>
						<input type="hidden" name="sid" value="${bean.sid }"/>
					</th>
					<td class="borderTD"></td>
				</logic:iterate>
			</tr>
			<tr>
				<td style="width:1px; background-color:#ccc;"></td>
				<logic:iterate id="bean" name="IGPRD01461VO" property="queryShowColumnList">
					<td style="width:${bean.width}px;" class="contentTD">
						${bean.width}
					</td>
					<td class="borderTD"></td>
				</logic:iterate>
			</tr>
		</logic:present>
	</table>
	<br/>
	<br/>
</div>
<br/>
<div class="enter">
	<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse"))){ %>
		<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return checkForm();"/>
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