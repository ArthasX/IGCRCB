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
<bean:define id="id" value="IGPRD0165h" toScope="request" />
<bean:define id="title" value="表单初始化配置" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	function toback(pdid) {
		form.action = getAppRootUrl() + "/IGPRD0104_Back.do?viewhistory=1&pdid=" + pdid;
		form.submit();
	}
	function add(pdid, psdid) {
		form.action = getAppRootUrl() + "/IGPRD0166_Disp.do?pdid=" + pdid
				+ "&psdid=" + psdid;
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
								历史版本 &gt;&gt; 状态列表 &gt;&gt; 表单初始化配置</p>
							<div class="back">
								<html:link href="javascript:toback('${IGPRD0165Form.pdid}');">返回</html:link>
							</div>
						</div>
						<div id="results_list">
							<ig:message />
							<table class="table_style4" align="left">
								<tr>
									<th width="15%">调用的BL</th>
									<th width="25%">任务描述</th>
								</tr>
								<logic:present name="IGPRD01651VO"
									property="lst_IG373Info">
									<logic:iterate id="bean" name="IGPRD01651VO"
										property="lst_IG373Info" indexId="index">
										<tr>
											<td>${bean.piidblid}</td>
											<td>${bean.piiddec}</td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
					</html:form>
					<div id="operate">
						<div class="content">
							<div align="left">
								<html:submit property="btn_back" styleClass="button" value="返回"
									onclick="javascript:toback('${IGPRD0165Form.pdid}')" />
							<html:hidden name="IGPRD0165Form" property="pdid" />
							<html:hidden name="IGPRD0165Form" property="psdid" />
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html:html>
