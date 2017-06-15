<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGSMR0704" toScope="request" />
<bean:define id="title" value="不定期报表审批" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
</style>
<script type="text/javascript">

</script>
<body>
	<div id="maincontent">
		<!--container 左菜单 右侧内容-->
		<!-- 新增加流程菜单 结束 -->
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />

		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<div id="location">
						<div class="image"></div>
						<p class="fonts1">
							<ig:navigation />
						</p>
					</div>
					<html:form action="/IGSMR0702_SECOND" styleId="form">

						<table class="table_style">
							<tr>
								<th width="25%">不定期报表说明</th>
								<th width="25%">发起时间</th>
								<th width="25%">发起人</th>
								<th width="25%">填报限制时间</th>
							</tr>
							<logic:present name="IGSMR07021VO" property="second_list">
								<logic:iterate id="bean" name="IGSMR07021VO"
									property="second_list">
									<tr onmouseover="mouseOver(this);"
										onmouseout="mouseOut(this,'');"
										onclick="doLook('IGSMR0704_Disp.do?instanceID=${bean.instanceID}');">
										<td>${bean.reportdesc }</td>
										<td>${bean.inittime }</td>
										<td>${bean.username }</td>
										<td>${bean.limittime }</td>
									</tr>
								</logic:iterate>
							</logic:present>
						</table>
					</html:form>
				</div>
			</div>
		</div>
	</div>
</body>
</html:html>