<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.drm.vo.IGDRM16021VO"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html:html>
<bean:define id="id" value="IGDRM1605" toScope="request" />
<bean:define id="title" value="事件影响范围画面" toScope="request" />
<!-- URL:IGDRM1605_Search.do -->
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
.ellips{
width:100%; 
white-space:nowrap; 
text-overflow:ellipsis; 
overflow:hidden;
}
</style>
<body>
	<div id="maincontent">

		<!--container 左菜单 右侧内容-->
		<div id="container">
			<!--content  右侧内容-->
			<div>
				<div id="content">
					<div>
						<!-- id="location" -->
						<div id="results_list">

							<%-- <ig:message /> --%>
							<table class="table_style" id="table1" cellspacing="0"
								cellpadding="0" style="border-collapse: collapse;" width="800px">
								<tr>

									<th width="5%" align="center">选择</th>
									<th width="20%" align="center">事件等级名称</th>
									<th width="20%" align="center">事件描述</th>
									<th width="30%" align="center">影响范围（省、自治区、直辖市）</th>
<!-- 									<th width="20%" align="center">业务中断金融机构</th> -->
									<th width="30%" align="center">业务中断时间</th>
								</tr>
								<logic:present name="IGDRM16021VO" property="eventssScopesMap">
									<logic:iterate id="map" name="IGDRM16021VO"	property="eventssScopesMap" indexId="index1">

										<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
										<tr>

											<td align="center" style="border: 1px solid #ccc;">
											    <img src="images/select_asset.gif" border="0" style="cursor: pointer;" alt="选择" onclick="javaScript:setRankValue(
                                                  '${fn:split(map.key,"_")[0]}');"/>

													</td>
											<td align="center" style="border: 1px solid #ccc;" title="${fn:split(map.key,"_")[0]}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${fn:split(map.key,"_")[0]}</div></td>
											<td align="center" style="border: 1px solid #ccc;" title="${fn:split(map.key,"_")[2]}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${fn:split(map.key,"_")[2]}</div></td>
											<td colspan="3" style="padding: 0px;border: 0px;">
												<table class="table_style" style="border:0px;" >
													<bean:size id="arrCount" name="list" />
													<logic:iterate id="bean" name="list">
														<tr>
															<td style=" border: 1px solid #ccc;" align="center" width="20%" title="${bean.impscope}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.impscope}</div></td>
<%-- 															<td style=" border: 1px solid #ccc;" align="center" width="20%" title="${bean.impbus}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.impbus}</div></td> --%>
															<td style=" border: 1px solid #ccc;" align="center" width="20%" title="${bean.imptime}"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.imptime}</div></td>
														</tr>
													</logic:iterate>
													<c:if test="${arrCount==0 }">
														<tr>
															<td style=" border: 1px solid #ccc;" align="center" width="20%">&nbsp;</td>
<!-- 															<td style=" border: 1px solid #ccc;" align="center" width="20%">&nbsp;</td> -->
															<td style=" border: 1px solid #ccc;" align="center" width="20%">&nbsp;</td>
														</tr>
													</c:if>
												</table>
											</td>

										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
					</div>
				</div>
				<div class="zishiying"></div>
				<div class="enter">
				<input type="button" class="button" onclick="setRankValue('');" value="清空"/>
				<input type="button" class="button" onclick="window.close()" value="关闭"/>
				</div>
			</div>
		</div>
		<script type="text/javascript">
		
		function setRankValue(rankName){
			
		    if(!window.opener.closed){
		    window.opener.setRankValue(rankName);
		    }
		    window.close();
		}
		</script>
</body>
</html:html>