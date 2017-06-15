<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM0504" toScope="request" />
<bean:define id="title" value="通知详细内容" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
function goToNoticeInfoDetail(k){
	
	openSubWindow('/IGSYM0504.do?nid='+k,"_blank","500","300");
	
}
</script>
<body>
<div id="maincontent">
<div id="container">
<html:form styleId="form" 
	onsubmit="return checkSubmit(this);">
<div id="location" style="margin-top:10px">
<div class="image"></div>
<p class="fonts1">通知详细内容</p>
</div>		
	<div id="results_list">
	<table class="table_style">
			<tr>
				<th width="11%">发布时间</th>
				<th width="10%">发布者</th>
				<th width="17%">通知名称</th>			
				<th width="10%">发布者部门</th>
				<th width="47%">通知内容</th>
				
			</tr>
			<logic:present name="IGSYM05011VO" property="noticecondList">
				<logic:iterate id="bean" name="IGSYM05011VO"
					property="noticecondList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="goToNoticeInfoDetail(${bean.nid})">
						<td>${bean.ntime}</td>
						<td>${bean.nusername}</td>
						<td>${bean.nname}</td>
						<td>${bean.norgname}</td>
						<td>${bean.ndesc}</td>
                        
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	
	</div>
	<div id="operate">
	 <!-- paging --> 
	<jsp:include page="/include/paging.jsp" />
	</div>
	<div class="enter">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</html:form></div>
</div>
</body>
</html:html>
