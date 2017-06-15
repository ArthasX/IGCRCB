<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM2004" toScope="request" />
<bean:define id="title" value="模板配置信息查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<!-- /header1 -->

<!-- 其他bean -->

<script type="text/javascript">
	function confirmChange() {
		var msg = "是否改变状态？";
		if (confirm(msg)) {
			return true;
		}
		return false;
	}
</script>
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">
			<div id="contentWrap">
				<!--content  右侧内容-->
				<div id="content" style="padding-top: -10px;">
					<div id="formwrapper">
						<html:form styleId="IGDRM2004Form" action="/IGDRM2004">
							<div id="location">
								<div class="image"></div>
								<p class="fonts1">
									<ig:navigation extname1="${urlable}" />
								</p>
							</div>
							<div id="search">
								<div class="img"></div>
								<div class="conditions">
									<div style="margin-top: 10px;">
										<span class="subscribe"><b>模板名称:</b></span>
										<html:text property="ename_q"></html:text>
										<html:submit property="btn_search" styleClass="button"
											value="查询"></html:submit>
									</div>
								</div>

							</div>
						</html:form>
						<div id="results_list">
							<ig:message />
							<table class="table_style">
								<tr>
									<th width="4%">序号</th>
									<th style="text-align: left !important;">模板名称</th>
									<th style="text-align: left !important;">模板描述</th>
									<th width="8%">状态</th>
									<th width="4%">调整</th>
									<th width="4%">修改</th>
									<th width="4%">复制</th>
									<th width="4%">详细</th>
								</tr>
								<logic:present name="IGDRM20041VO" property="soc0117List">
									<logic:iterate id="info" name="IGDRM20041VO"
										property="soc0117List" indexId="index">
										<tr class="<ig:rowcss index="${index}"/>">
											<td>${PagingDTO.viewStartCount + index}</td>
											<td style="text-align: left !important;">${info.ename}</td>
											<td style="text-align: left !important;">${info.edesc}</td>
											<logic:equal name="info" property="estatus" value="1">
												<td>模板可用</td>
												<td><html:link
														action="/IGDRM2004_Stop.do?eid=${info.eid}"
														onclick="return confirmChange();">
														<img src="images/stop.gif" alt="停用" width="16" height="16"
															border="0" />
													</html:link></td>
											</logic:equal>
											<logic:equal name="info" property="estatus" value="2">
												<td>模板停用</td>
												<td><html:link
														action="/IGDRM2004_Start.do?eid=${info.eid}"
														onclick="return confirmChange();">
														<img src="images/start.gif" alt="启用" width="16"
															height="16" border="0" />
													</html:link></td>
											</logic:equal>
											<td><html:link action="/IGDRM2001_Edit.do?eid=${info.eid}">
													<img src="images/edit.gif" alt="修改" width="16" height="16"
														border="0" />
												</html:link></td>
											<td><html:link action="/IGDRM2004_Copy.do?eid=${info.eid}">
													<img src="images/bdld.gif" alt="复制" width="16" height="16"
														border="0" />
												</html:link></td>
											<td><html:link action="/IGDRM2005.do?eid=${info.eid}">
													<img src="images/xx.gif" alt="显示详细信息" width="16"
														style="cursor: hand;" height="16" border="0" />
												</html:link></td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
						<div id="operate">
							<!-- paging -->
							<jsp:include page="/include/paging.jsp" />
						</div>
					</div>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>
	</div>
</body>
</html:html>