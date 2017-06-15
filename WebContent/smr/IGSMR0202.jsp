<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<%@page import="com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT"%><html:html>
<bean:define id="id" value="IGSMR0202" toScope="request" />
<bean:define id="title" value="审批意见查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	//链接审批意见查询地址示例
	function url(prid, piid) {
		var url = "IGSMR0202_Disp.do?prid=" + prid + "&piid=" + piid;
		window
				.showModalDialog(url, null,
						"dialogWidth:800px;dialogHeight:600px;status:no;help:no;resizable:no;");
	}
</script>
<body>
	<div id="maincontent">
		<!--container 左菜单 右侧内容-->
		<div id="container" style="width: 600px; margin-left: 10px;">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<div id="formwrapper" style="width: 570px;">
						<div class="title">
							<div class="name">审批意见</div>
						</div>
						<div id="results_list">
							<table class="table_style">
								<tr>
									<th width="10%">审批人</th>
									<th width="15%">驳回状态</th>
									<th width="20%">填写时间</th>
									<th width="55%">审批意见</th>
								</tr>
								<logic:present name="IGSMR02021VO"
									property="lstApproveSuggestionInfo">
									<logic:iterate id="bean" name="IGSMR02021VO"
										property="lstApproveSuggestionInfo">
										<tr>
											<td class="nowrapDiv">${bean.username}</td>
											<td class="nowrapDiv">${bean.psdname}</td>
											<td class="nowrapDiv">${bean.inserttime}</td>
											<td class="nowrapDiv">${bean.suggestion}</td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
					</div>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>
	</div>
</body>
</html:html>