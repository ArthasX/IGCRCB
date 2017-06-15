<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGCIM2005" toScope="request" />
<bean:define id="title" toScope="request">
	关系管理页面
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
	var gid = 'IGCIM2005';
	function deleteRec() {
		var arg0 = '<bean:message bundle="asmResources" key="message.IGCIM0126.001"/>';
		var alterMessage = '<bean:message bundle="asmResources" key="message.IGCIM0126.002"/>';
		var message = '<bean:message key="IGCO10000.E002"/>';
		var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="'+arg0+'" />';
		var frm = window.document.forms[0];
		if (frm.deleteEirid) {
			if (frm.deleteEirid.length > 0) {
				var bchecked = false;
				for (i = 0; i < frm.deleteEirid.length; i++) {
					if (frm.deleteEirid[i].checked == true) {
						bchecked = true;
					}
				}
				if (!bchecked) {
					alert(message);
					return false;
				}
			} else {
				if ($("deleteEirid").checked == false) {
					alert(alterMessage);
					return false;
				}
			}
		} else {
			alert(message);
			return false;
		}
		if (window.confirm(confirmMsg)) {
			form.action = getAppRootUrl() + "/IGCIM2005_Del.do";
			return true;
		} else {
			return false;
		}
	}

	function toback() {
		if (backurl) {
			form.action = getAppRootUrl() + "/" + backurl;
		} else {
			form.action = getAppRootUrl() + "/IGCIM2005.do?btn_back=1";
		}
		form.submit();
	}
	var backurl = '${backurl}';
</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container">


			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">

					<div id="location">
						<div class="image"></div>
						<p class="fonts1">
							<ig:navigation extname1="${urlable}" />
							&gt;&gt; 关系信息
						</p>
						<div class="back">
							<html:link href="javascript:toback();">
								<bean:message bundle="asmResources"
									key="button.IGCIM0126.btn_toback" />
							</html:link>
						</div>
					</div>
					<html:form styleId="form" action="/IGCIM2005"
						onsubmit="return checkSubmit(this);">
						<div class="title">
							<div class="name">
								设备基本信息
							</div>
						</div>
						<div id="results_list">
							<table class="table_style">
								<tr>
									<th width="10%"><bean:message bundle="asmResources"
											key="label.IGCIM0126.ModelName" /></th>
									<th width="15%"><bean:message bundle="asmResources"
											key="label.IGCIM0126.UserNO" /></th>
									<th width="20%">设备名称</th>
<!--								<th width="10%"><bean:message bundle="asmResources" key="label.IGCIM0126.UserOrgan" /></th>-->
									<th width="18%">设备说明</th>
									<th width="7%"><bean:message bundle="asmResources"
											key="label.IGCIM0126.UserManager" /></th>
<!--									<th width="8%"><bean:message bundle="asmResources" key="label.IGCIM0126.UserMarkDay" /></th>-->
									<th width="12%"><bean:message bundle="asmResources"
											key="label.IGCIM0126.UpdateTime" /></th>
								</tr>
								<tr>
									<td align="center">${IGCIM20051VO.entityData.ename}</td>
									<td align="center">${IGCIM20051VO.entityData.eilabel}</td>
									<td align="center">${IGCIM20051VO.entityData.einame}</td>
<!--									<td>${IGCIM20051VO.eiorgname}</td>-->
									<td>${IGCIM20051VO.entityData.eidesc}</td>
									<td align="center">${IGCIM20051VO.entityData.eiusername}</td>
<!--									<td align="center">${IGCIM20051VO.entityData.eiinsdate}</td>-->
									<td align="center">${IGCIM20051VO.entityData.eiupdtime}</td>
								</tr>
							</table>
						</div>

						<div class="title">
							<div class="name">
								设备关系信息
							</div>
						</div>
						<div class="message">
							<ig:message />
						</div>
						<logic:present name="IGCIM20051VO" property="flag">
							<logic:equal value="true" name="IGCIM20051VO" property="flag">
								<div id="results_list">
									<logic:present name="IGCIM20051VO"	property="parEntityRelationMap">
										<div id="TabbedPanels1" class="TabbedPanels">
											<ul class="TabbedPanelsTabGroup">
												<logic:iterate id="map" name="IGCIM20051VO"	property="parEntityRelationMap" indexId="number">
													<li class="TabbedPanelsTab">${map.key}</li>
												</logic:iterate>

											</ul>
											<div class="TabbedPanelsContentGroup">
												<logic:present name="IGCIM20051VO"	property="parEntityRelationMap">
													<logic:iterate id="map" name="IGCIM20051VO"	property="parEntityRelationMap" indexId="number">
														<bean:define id="category" name="map" property="key" />
														<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
														<div class="TabbedPanelsContent">
															<div class="record_list">
																<table class="table_style2">
																	<tr>
																		<th width="8%"></th>
																		<th width="12%"><bean:message bundle="asmResources"	key="label.IGCIM0126.RelevanceNO" /></th>
																		<th width="13%"><bean:message bundle="asmResources"	key="label.IGCIM0126.RelevanceName" /></th>
																		<th width="12%"><bean:message bundle="asmResources"	key="label.IGCIM0126.RelevanceAssetRelationship" /></th>
																		<th width="14%"><bean:message bundle="asmResources"	key="label.IGCIM0126.RelevanceMarkDay" /></th>
																		<th width="33%"><bean:message bundle="asmResources" key="label.IGCIM0126.RelevanceAssetRamark" /></th>
																	</tr>
																	<logic:iterate id="bean" name="list" indexId="index">
<%-- 																		<logic:equal name="bean" property="parflag" value="0"> --%>
																			<tr onmouseover="mouseOverNoHand(this);"onmouseout="mouseOutNoHand(this);">
																				<td align="center">
																					<html:checkbox property="deleteEirid" value="${bean.brid}" />
																				</td>
																				<!-- 编号 -->
																				<td align="center">
																					<div class="nowrapDiv">${bean.cldEntityItemVW.eilabel}
																					</div>
																				</td>
																				<!-- 名称 -->
																				<td align="center">
																					<div class="nowrapDiv">
																						<logic:empty name="bean" property="cldEntityItemVW.einame">&nbsp;</logic:empty>
																						<html:link 	href="javascript:openSubIGCOM0328('${bean.cldEntityItemVW.eiid}','${bean.cldEntityItemVW.eiversion}');">
                                    														${bean.cldEntityItemVW.einame}
                            															 </html:link>
																					</div>
																				</td>
																				<!-- 关系 -->
																				<td align="center">
																					<div class="nowrapDiv">
																						<logic:empty name="bean" property="brassetrelation">&nbsp;</logic:empty>
																						<ig:codeValue ccid="ENTITYITEM_RELATION_CODE" cid="${bean.brassetrelation}" />
																					</div>
																				</td>
																				<!-- 登记时间 -->
																				<td align="center">
																					<div class="nowrapDiv">
																						<logic:empty name="bean" property="brcreatetime">&nbsp;</logic:empty>
																						${bean.brcreatetime}
																					</div>
																				</td>
																				<!-- 说明 -->
																				<td align="center">
																					<div class="nowrapDiv">
																						<logic:empty name="bean" property="brdes">&nbsp;</logic:empty>
																						${bean.brdes}
																					</div>
																				</td>
																				<!-- FS关系 -->
<%-- 																				<c:if test="${category=='001'}"> --%>
<!-- 																					<td align="center"> -->
<!-- 																						<div class="nowrapDiv"> -->
<%-- 																							<html:link --%>
<%-- 																								action="/IGCIM0129_Disp.do?eiid=${bean.cldEntityItemVW.eiid}&pareiid=${IGCIM20051VO.entityData.eiid}&parversion=${IGCIM20051VO.entityData.eiversion}&parsmallversion=${IGCIM20051VO.entityData.eismallversion}&flag=0"> --%>
<!-- 																								<img src="images/record_(copy)_16x16.gif" -->
<%-- 																									alt='<bean:message bundle="asmResources" key="img.IGCIM2005.FSRelation.alt"/>' --%>
<!-- 																									width="16" height="16" border="0" /> -->
<%-- 																							</html:link> --%>
<!-- 																						</div> -->
<!-- 																					</td> -->
<%-- 																				</c:if> --%>
																			</tr>
<%-- 																		</logic:equal> --%>
<%-- 																		<logic:equal name="bean" property="parflag" value="1"> --%>
<!-- 																			<tr onmouseover="mouseOverNoHand(this);" -->
<!-- 																				onmouseout="mouseOutNoHand(this);"> -->
<%-- 																				<td align="center"><logic:notEqual name="bean" --%>
<%-- 																						property="eirstatus" value="C"> --%>
<%-- 																						<logic:notEqual name="category" value="012"> --%>
<%-- 																							<html:checkbox property="deleteEirid" --%>
<%-- 																								value="${bean.eirid}" /> --%>
<%-- 																						</logic:notEqual> --%>
<%-- 																					</logic:notEqual></td> --%>
<!-- 																				编号 -->
<!-- 																				<td align="center"> -->
<%-- 																					<div class="nowrapDiv">${bean.parEntityItemVW.eilabel} --%>
<!-- 																					</div> -->
<!-- 																				</td> -->
<!-- 																				名称 -->
<!-- 																				<td align="center"> -->
<!-- 																					<div class="nowrapDiv"> -->
<%-- 																						<logic:empty name="bean" --%>
<%-- 																							property="parEntityItemVW.einame">&nbsp;</logic:empty> --%>
<%-- 																						<html:link --%>
<%-- 																							href="javascript:openSubIGCOM0328('${bean.parEntityItemVW.eiid}', --%>
<%--                                                    '${bean.parEntityItemVW.eiversion}');"> --%>
<%--                                                    ${bean.parEntityItemVW.einame}</html:link> --%>
<!-- 																					</div> -->
<!-- 																				</td> -->
<!-- 																				关系 -->
<!-- 																				<td align="center"> -->
<!-- 																					<div class="nowrapDiv"> -->
<%-- 																						<logic:empty name="bean" property="eirrelation">&nbsp;</logic:empty> --%>
<%-- 																						<ig:codeValue ccid="ENTITY_ITEM_RELATION_CODE" --%>
<%-- 																							cid="${bean.eirrelation}" /> --%>
<!-- 																					</div> -->
<!-- 																				</td> -->
<!-- 																				登记时间 -->
<!-- 																				<td align="center"> -->
<!-- 																					<div class="nowrapDiv"> -->
<%-- 																						<logic:empty name="bean" property="eirupdtime">&nbsp;</logic:empty> --%>
<%-- 																						${bean.eirupdtime} --%>
<!-- 																					</div> -->
<!-- 																				</td> -->
<!-- 																				说明 -->
<!-- 																				<td align="center"> -->
<!-- 																					<div class="nowrapDiv"> -->
<%-- 																						<logic:empty name="bean" property="eirdesc">&nbsp;</logic:empty> --%>
<%-- 																						${bean.eirdesc} --%>
<!-- 																					</div> -->
<!-- 																				</td> -->
<!-- 																			</tr> -->
<%-- 																		</logic:equal> --%>
																	</logic:iterate>
																</table>
															</div>
														</div>
													</logic:iterate>
												</logic:present>
											</div>
										</div>
										<script type="text/javascript">
										<!--
											var TabbedPanels1 = new Spry.Widget.TabbedPanels(
													"TabbedPanels1");
										//-->
										</script>
									</logic:present>
								</div>
							</logic:equal>
						</logic:present>
						<div class="enter">
							<logic:present name="IGCIM20051VO" property="flag">
								<logic:equal value="true" name="IGCIM20051VO" property="flag">
									<html:submit property="btn_add" styleClass="button">
										<bean:message bundle="asmResources"
											key="button.IGCIM0126.btn_add" />
									</html:submit>
									<logic:present name="IGCIM20051VO"
										property="parEntityRelationMap">
										<html:submit property="btn_delete" styleClass="button"
											onclick="return deleteRec();">
											<bean:message bundle="asmResources"
												key="button.IGCIM0126.btn_deleteSelect" />
										</html:submit>
									</logic:present>
								</logic:equal>
							</logic:present>
							<%--                      <html:submit property="btn_back" styleClass="button" > --%>
							<%--                      	<bean:message bundle="asmResources" key="button.IGCIM0126.btn_toback"/> --%>
							<%--                      </html:submit> --%>
							<html:button property="btn_back" styleClass="button"
								onclick="toback()">返回</html:button>
						</div>
						<html:hidden property="pareid" styleId="pareid"
							value="${IGCIM20051VO.entityData.eid}" />
						<html:hidden property="pareiid" styleId="pareiid"
							value="${IGCIM20051VO.entityData.eiid}" />
						<html:hidden property="pareilabel" styleId="pareilabel"
							value="${IGCIM20051VO.entityData.eilabel}" />
						<html:hidden property="pareiname" styleId="pareiname"
							value="${IGCIM20051VO.entityData.einame}" />
						<html:hidden property="parversion" styleId="parversion"
							value="${IGCIM20051VO.entityData.eiversion}" />
						<html:hidden property="parsmallversion" styleId="parsmallversion"
							value="${IGCIM20051VO.entityData.eismallversion}" />
					</html:form>
				</div>
			</div>
		</div>


	</div>
</body>
<script type="text/javascript">
	jQuery(function() {
		if (backurl) {
			jQuery(":checkbox").hide();
			jQuery(":submit").hide();
		}

	})
</script>
</html:html>