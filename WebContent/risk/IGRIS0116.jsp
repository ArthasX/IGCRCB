<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%
	String contextPath = request.getContextPath();
%>
<html:html>
<bean:define id="id" value="IGRIS0116" toScope="request" />
<bean:define id="title" value="风险检查结果画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
//-->
</script>
<body>
<div id="maincontent">
<div id="location">
<div class="image"></div>
<p class="fonts1">检查结果查询</p>
</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="10%">计划检查日期</th>
				<th width="10%">实际检查日期</th>
				<th width="10%">责任组</th>
				<th width="10%">责任人</th>
				<th width="10%">执行人</th>
				<th width="5%">结果</th>
				<th width="20%">说明</th>
				<th width="10%">附件</th>
			</tr>
			<logic:present name="IGRIS01151VO" property="attachmentMap">
			<logic:iterate id="map" name="IGRIS01151VO" property="attachmentMap"
				indexId="index">
				<bean:define id="bean" name="map" property="key" />
					<tr class="<ig:rowcss index="${index}"/>">
						
						<td>${bean.rcrplandate}</td>
						<td>${bean.rcrrealtime}</td>
						<td>${bean.riskCheck.rcrolename}</td>
						<td>${bean.riskCheck.rcusername}</td>
						<td>${bean.rcrusername}</td>
						<td><ig:codeValue ccid="RISKCHECKRESULT_CODE" cid="${bean.rcrresult}" /></td>
						<td>${bean.rcrcomment}</td>
						<td>
						<logic:present name="map" property="value">
						<bean:define id="attachmentList" name="map" property="value" />
						<logic:iterate id="attachment" name="attachmentList"
						indexId="number">
						<logic:notEmpty name="attachment" property="attname">
						<html:link
							action="downloadFinFile.do?attId=${attachment.attid}&type=risk">
							<bean:define id="attname" name="attachment" property="attname" />
							<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
						</html:link>
						</logic:notEmpty>
					</logic:iterate>
					</logic:present>			
					</td>					
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div class="enter">
        <input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button">
	</div>
</div>
<div class="zishiying"></div>
</body>
</html:html>