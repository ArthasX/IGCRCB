<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<html:html>
<bean:define id="id" value="IGPRD0165" toScope="request" />
<bean:define id="title" value="表单初始化配置" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function toback(pdid) {
		form.action = getAppRootUrl() + "/IGPRD0104_Back.do?pdid=" + pdid + "&ppsdid=${IGPRD0165Form.ppsdid}";
		form.submit();
	}
	function add(pdid, psdid, ppsdid) {
		form.action = getAppRootUrl() + "/IGPRD0166_Disp.do?pdid=" + pdid
				+ "&psdid=" + psdid + "&ppsdid=" + ppsdid;
		form.submit();
	}
	function checkDel() {
		if (window.confirm("请确认是否删除？")) {
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
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<html:form styleId="form" action="/IGPRD0165_Disp.do">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1"><ig:navigation /> &gt;&gt;
								状态列表 &gt;&gt; 表单初始化配置</p>
							<div class="back">
								<a href="IGPRD0104_Back.do?pdid=${IGPRD0165Form.pdid}&ppsdid=${IGPRD0165Form.ppsdid}" target="_self">返回</a>
							</div>
						</div>
						<div id="results_list">
							<ig:message />
							<table class="table_style4" align="left">
								<tr>
									<th width="15%">调用的BL</th>
									<th width="25%">任务描述</th>
									<th width="5%">修改</th>
									<th width="5%">删除</th>
								</tr>
								<logic:present name="IGPRD01651VO"
									property="lst_IG373Info">
									<logic:iterate id="bean" name="IGPRD01651VO"
										property="lst_IG373Info" indexId="index">
										<tr>
											<td>${bean.piidblid}</td>
											<td>${bean.piiddec}</td>
											<td><html:link
													action="/IGPRD0166_Init.do?piidid=${bean.piidid}&pdid=${IGPRD0165Form.pdid}&psdid=${IGPRD0165Form.psdid}&ppsdid=${IGPRD0165Form.ppsdid}">
													<img src="images/edit.gif" width="16" height="16"
														border="0" alt="修改" />
												</html:link></td>
											<td><html:link
													action="/IGPRD0165_Del.do?piidid=${bean.piidid}&pdid=${IGPRD0165Form.pdid}&psdid=${IGPRD0165Form.psdid}&ppsdid=${IGPRD0165Form.ppsdid}"
													onclick="return checkDel();">
													<img src="images/delete.gif" width="16" height="16"
														border="0" alt="删除" />
												</html:link></td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
					</html:form>
					<div id="operate">
						<div class="content">
							<div align="left">
								<logic:present name="IGPRD01651VO" property="lst_IG373Info">
									<bean:size id="num" name="IGPRD01651VO" property="lst_IG373Info"/>
									<c:if test="${num == 0}">
										<html:submit property="btn_add" value="增加" styleClass="button"
											onclick="return add('${IGPRD0165Form.pdid}','${IGPRD0165Form.psdid}','${IGPRD0165Form.ppsdid}');" />
									</c:if>
								</logic:present>
								<html:submit property="btn_back" styleClass="button" value="返回"
									onclick="javascript:toback('${IGPRD0165Form.pdid}')" />
							<html:hidden name="IGPRD0165Form" property="pdid" />
							<html:hidden name="IGPRD0165Form" property="psdid" />
							<html:hidden name="IGPRD0165Form" property="ppsdid" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html:html>
