<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM1308" toScope="request" />
<bean:define id="title" value="设备使用分布情况统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function exportExcel() {
	var type = "<%=request.getAttribute("searchType")%>";

	if("1"==type){
		
		//新进设备统计
		document.forms[0].action = getAppRootUrl() + "/IGASM1308.do?report1=1";
		document.forms[0].submit();
	}else{
		//设备存量统计
		document.forms[0].action = getAppRootUrl() + "/IGASM1308.do?report=1";
		document.forms[0].submit();
	}
	
}

	</script>
<body style="background-color: white; background-image: none;" >
<div id="maincontent"><!--header  头部和 一级菜单--> 
<div id="container"><!--sidebar  左菜单--> 
<div id="location">
<div class="image"></div>
<p class="fonts1">设备使用分布情况统计</p>
</div>

<html:form styleId="form" action="/IGASM1308"
	onsubmit="return checkSubmit(this);">
	<html:hidden property="ciupdtime_from"/>
	<html:hidden property="ciupdtime_to"/>
</html:form> 

<div id="results_list">
<ig:message />
<table class="table_style">
	<tr>
		<th>序号</th>
		<th>使用机构</th>
		<th>数量</th>
		<th>所占总量比例</th>
	</tr>
	<!-- body部 -->
	<logic:present name="IGASM13031VO" property="equDistributingCountList">
		<logic:iterate id="bean" name="IGASM13031VO"
			property="equDistributingCountList" indexId="index">
			<tr class="<ig:rowcss index="${index}"/>">
				<td>
				<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
				</td>
				<td>
				<div class="nowrapDiv">
					${bean.orgname}
				</div>
				</td>
				<td>
				<div class="nowrapDiv">
					${bean.count}
				</div>
				</td>
				<td>
				<div class="nowrapDiv">${bean.proportion}</div>
				</td>
			</tr>
		</logic:iterate>
	</logic:present>
	<logic:present name="IGASM13031VO" property="equDistributingCountList">
		<tr>
		    <td><strong>合计</strong></td>
			<td></td>
			<td><span class="red"><bean:write name="IGASM13031VO" property="total"/></span></td>
			<td></td>
		</tr>
	</logic:present>
</table>
</div>
 	<div id="operate">
		        <div class="content">
			            <div class="enter">
			            	<input type="button" name="btn_close" value="导出"  onclick="exportExcel()" class="button">
			                <input type="button" name="btn_close" value="关闭"  onclick="window.close()" class="button">
			            </div>
		        </div> 
	    </div>
</div>
</div>
</body>
</html:html>