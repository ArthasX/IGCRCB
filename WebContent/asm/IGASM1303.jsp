<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM1303" toScope="request" />
<bean:define id="title" value="机房设备统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->


<script type="text/javascript">	

	
	</script>
<body >
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
	<div id="search">
<html:form styleId="form" action="/IGASM1303"
	onsubmit="return checkSubmit(this);">
	<div class="img"></div>
	<div class="conditions">
	
	<div>
	<span>所属机房：</span> 
	<html:select property="roomeiid_q"  errorStyleClass="inputError imeActive" >
		<html:options collection="room_list" property="value" name="" labelProperty="label" />
	</html:select>
	&nbsp;&nbsp;

	<span>
	<input type="hidden" name="ciupdtime_from" />
	<html:submit property="btn_search" styleClass="button" value="查询" />
	 </span>
	</div>
	</div>
</html:form> 
	</div>
<div id="results_list">
<ig:message />
<table class="table_style">
	<tr>
		<th width="5%">序号</th>
		<th width="20%">所属机房名称</th>
		<th width="20%">所属模型</th>
		<th width="15%">设备编号</th>
		<th width="10%">设备型号</th>
		<th width="20%">所属机柜名称</th>
		<th width="10%">所在位置</th>
		
		
		
	</tr>
	<!-- body部 -->
	<logic:present name="IGASM13021VO" property="roomandcontainerList">
		<logic:iterate id="bean" name="IGASM13021VO"
			property="roomandcontainerList" indexId="index">
			<tr class="<ig:rowcss index="${index}"/>">
				<td>
				<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
				</td>
				
				<td>
				<div class="nowrapDiv">
					${bean.room_name}</div>
				</td>
				
				<td>
				<div class="nowrapDiv">
					${bean.ename}</div>
				</td>
				
				<td>
				<div class="nowrapDiv">
					${bean.eilabel}</div>
				</td>

				<td>
				<div class="nowrapDiv">
					${bean.model}</div>
				</td>
				
				<td>
				<div class="nowrapDiv">
					${bean.container_name}</div>
				</td>
				
				<td>
				<div class="nowrapDiv">
					${bean.position}</div>
				</td>
				
			</tr>
		</logic:iterate>
	</logic:present>
	
</table>
</div>
	<div id="operate"> 
	<jsp:include page="/include/paging.jsp" />
	</div>
</div>
</div>
</div>
</div>
</body>
</html:html>