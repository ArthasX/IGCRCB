<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<logic:present name="LOGIN_USER">
	<link type="text/css" href="js/menu/menu.css"
		rel="stylesheet" />
	
	<script type="text/javascript" src="js/menu/jquery.js"></script>
	<script>
		jQuery.noConflict();//jquery与prototype冲突
	</script>

	<script type="text/javascript" src="js/menu/menu.js"></script>
	<script type="text/javascript" src="js/menu/jquery-bgiframe.js"></script>
	<script type="text/javascript">
	<!--
	javascript:window.history.forward(1);
	<%-- 打开用户信息修改页面 --%>
	function openNewWindow(userid){
		openIntegrationWindow('/IGSYM0204.do',"newpage","1000","600");
		
	}
	function quit(){
		if(window.confirm("您确定要退出系统吗？")){
			window.location="./IGCOM0102.do";
		}
	}
	function show(url){
		var obj = window.showModalDialog("<%=request.getContextPath()%>" + url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if(obj != null){ 
			window.location.href = obj;
		}
    }
    function checkinout(flag){
		var url = null;
		//签到
		if(flag == 1){
			url = '/IGUCI0101_Disp.do';
			}else{
				//签出
				if(flag == 2){
					url = '/IGUCI0102_Disp.do'
					}
				}
		openSubWindow(url, 'newpage', '800', '300');
		//window.open(getAppRootUrl() + uri, wName, 'width='+ width + ',height=' + height + ',scrollbars=yes,resizable=yes,status=yes,top='+iTop+',left='+iLeft+',').focus();
        }
   function sms(){
	   var url = "/IGSYM1803_Disp.do";
	   openSubWindow(url, '_blank', '550', '300');	
   }
	//-->
</script>
	<logic:present name="UserPermission">
		<logic:iterate id="list" name="UserPermission" property="actionList"
			indexId="index">
			<logic:iterate id="firstMap" name="list">
				<bean:define id="firstKey" name="firstMap" property="key" />
				<bean:define id="firstValue" name="firstMap" property="value" />
				<c:if test="${firstMap.key.actsortid == firstactid}">
					<bean:size id="actsize" name="firstValue" />
				</c:if>
			</logic:iterate>
		</logic:iterate>
		<div id="head"
			<c:if test="${(actsize != null && actsize == 0) }">
			style="height: 65px"
		</c:if>>
		<div id="logo">
		<div>
		<table border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td><a href="javascript:openNewWindow()"><img style="margin-left: -10px"
					src="js/menu/images/mycenter.gif" border="0" alt="用户中心"></a>
				</td>
				<td align="left" style="color: #000000">
					<logic:equal name="LOGIN_USER" property="userid" value="admin">用户</logic:equal>
					<logic:notEqual name="LOGIN_USER" property="userid" value="admin">
						<bean:write name="LOGIN_USER" property="orgname" />
					</logic:notEqual> ：<bean:write name="LOGIN_USER" property="username" />
				</td>
				<%-- <logic:equal name="MNT_AUTH" value="yes">
			    	<td><a href="javascript:sms()"><img src="js/menu/images/add_step.gif" border="0" alt="短信规则"></a></td>
			   	</logic:equal> --%>
			</tr>
			<tr>
				<td><a href="javascript:quit()"><img style="margin-left: -10px"
					src="js/menu/images/out.gif" border="0" alt="退出"></a>
				</td>
				<td align="left">
					<a href="javascript:quit()" style="color:#000000">退出</a>
				</td>
			</tr>
			<tr>
				<td align="right">
				<div id="pica" style="display: none; float: right;"><img
					src="js/menu/images/qd01.gif" onclick="checkinout(1)" alt="签到" style="cursor: hand"></div>
				<div id="picb" style="display: none; float: right;"><img
					src="js/menu/images/qd02.gif"></div>
				</td>
				<td></td>
				<td>
				<div id="picc" style="display: none; float: right;"><img
					src="js/menu/images/qt01.gif" onclick="checkinout(2)" alt="签出" style="cursor: hand"></div>
				<div id="picd" style="display: none; float: right;"><img
					src="js/menu/images/qt02.gif" ></div>
				</td>
			</tr>
		</table>
		</div>
		</div>
		<div id="topbar">
		<ul>
			<ig:HomePageTitle/>
			<logic:iterate id="list" name="UserPermission" property="actionList"
				indexId="index">
				<logic:iterate id="firstMap" name="list">
					<bean:define id="firstKey" name="firstMap" property="key" />
					<bean:define id="firstValue" name="firstMap" property="value" />
					<li>
						<c:choose>
							<c:when test="${firstMap.key.acturltype == '1' }">
								<a id="${firstMap.key.actsortid}" href="###" onclick="show('${firstMap.key.acturl}&actname=${firstMap.key.actname}')" class="subscribe">
								<span>&nbsp;&nbsp;${firstMap.key.actlabel}</span></a>
							</c:when>
							<c:when test="${firstMap.key.acturltype == '2' }">
								<a id="${firstMap.key.actsortid}" href="###" onclick="openIntegrationWindow('${firstMap.key.acturl}&actname=${firstMap.key.actname}','${firstMap.key.actname}')" class="subscribe">
								<span>&nbsp;&nbsp;${firstMap.key.actlabel}</span></a>
							</c:when>
							<c:otherwise>
								<html:link action="${firstMap.key.acturl}&actname=${firstMap.key.actname}" styleClass="subscribe" styleId="${firstMap.key.actsortid}">
									<span>&nbsp;&nbsp;${firstMap.key.actlabel}</span>
								</html:link>
							</c:otherwise>
						</c:choose>
					</li>
				</logic:iterate>
			</logic:iterate>
		</ul>
		</div>
		<c:if test="${actsize != null && actsize > 0}">
			<div id="menu">
			<ul class="menu">
				<logic:iterate id="list" name="UserPermission" property="actionList"
					indexId="index">
					<logic:iterate id="firstMap" name="list">
						<bean:define id="firstKey" name="firstMap" property="key" />
						<bean:define id="firstValue" name="firstMap" property="value" />
						<c:if test="${firstMap.key.actsortid == firstactid}">
							<bean:size id="size" name="firstValue" />
							<logic:iterate id="secondList" name="firstValue" indexId="num">
								<logic:iterate id="secondMap" name="secondList">
									<bean:define id="secondKey" name="secondMap" property="key" />
									<bean:define id="secondValue" name="secondMap" property="value" />
									<c:choose>
										<c:when test="${size > 12}">
											<c:if test="${num < 10 }">
												<li id="${secondMap.key.actsortid}">
													<c:choose>
														<c:when test="${secondMap.key.acturl != null && secondMap.key.acturl > ''}">
															<html:link action="${secondMap.key.acturl}&actname=${secondMap.key.actname}" styleClass="parent">
																<span>${secondMap.key.actlabel}</span>
															</html:link>
														</c:when>
														<c:otherwise>
															<a href="###"><span>${secondMap.key.actlabel}</span></a>
														</c:otherwise>
													</c:choose>
												</li>
												<bean:size id="thirdListCount1" name="secondValue"/>
												<c:if test="${thirdListCount1 > 0}">
												<ul id="bgiframe${num}">
												<script type="text/javascript">      
													jQuery(document).ready(function() {   
														  jQuery('#bgiframe${num}').bgiframe();   
														});     
												</script>
													<logic:iterate id="thirdList" name="secondValue" indexId="num_third1">
														<logic:iterate id="thirdMap" name="thirdList">
															<bean:define id="thirdKey" name="thirdMap" property="key" />
															<bean:define id="thirdValue" name="thirdMap"
																property="value" />
															<li>
																<c:choose>
																	<c:when test="${thirdMap.key.acturl != null && thirdMap.key.acturl > ''}">
																		
																		<c:choose>
																			<c:when test="${thirdMap.key.acturltype == '1' }">
																				<a href="###" onclick="show('${thirdMap.key.acturl}&actname=${thirdMap.key.actname}')">
																				<span>${thirdMap.key.actlabel}</span></a>
																			</c:when>
																			<c:otherwise>
																				<html:link action="${thirdMap.key.acturl}&actname=${thirdMap.key.actname}">
																					<span>${thirdMap.key.actlabel}</span>
																				</html:link>
																			</c:otherwise>
																		</c:choose>
																		
																	</c:when>
																	<c:otherwise>
																		<a href="###"><span>${thirdMap.key.actlabel} </span></a>
																	</c:otherwise>
																</c:choose>	
															</li>
															
															<!-- 四层菜单Begin -->
															<bean:size id="fourListCount1" name="thirdValue"/>
															<c:if test="${fourListCount1 > 0}">
																<ul id="bgiframe${num_third1}">
																<script type="text/javascript">      
																	jQuery(document).ready(function() {   
																		  jQuery('#bgiframe${num_third1}').bgiframe({left:'1'});   
																		});     
																</script>
																<logic:iterate id="fourList" name="thirdValue" indexId="num_four">
																	<li>
																		<c:choose>
																			<c:when test="${fourList.acturltype == '1' }">
																				<a href="###" onclick="show('${fourList.acturl}&actname=${fourList.actname}')">
																				<span>${fourList.actlabel}</span></a>
																			</c:when>
																			<c:otherwise>
																				<html:link action="${fourList.acturl}&actname=${fourList.actname}">
																					<span>${fourList.actlabel}</span>
																				</html:link>
																			</c:otherwise>
																		</c:choose>
																	</li>
																</logic:iterate>
																
																</ul>
															</c:if>
															<!-- 四层菜单End -->	
																				
														</logic:iterate>
													</logic:iterate>
												</ul>
												</c:if>
											</c:if>
											<c:if test="${num >= 10}">
												<c:if test="${num == 10}">
													<li class="last" id = "${secondactid}"><a href="###"><span>其它</span></a>
													<ul id="bgiframeqita">
													<script type="text/javascript">      
													jQuery(document).ready(function() {   
														  jQuery('#bgiframeqita').bgiframe();   
														});     
												</script>
												</c:if>
												<li>
													<c:choose>
														<c:when test="${secondMap.key.acturl != null && secondMap.key.acturl > ''}">
															<html:link action="${secondMap.key.acturl}&actname=${secondMap.key.actname}" styleClass="parent">
																<span>${secondMap.key.actlabel}</span>
															</html:link>
														</c:when>
														<c:otherwise>
															<a href="###" class="parent"><span>${secondMap.key.actlabel}</span></a>
														</c:otherwise>
													</c:choose>
													<bean:size id="thirdListCount2" name="secondValue"/>
													<c:if test="${thirdListCount2 > 0}">
														<div>
															<ul>
																<logic:iterate id="thirdList" name="secondValue"  indexId="num_third2">
																	<logic:iterate id="thirdMap" name="thirdList">
																		<bean:define id="thirdKey" name="thirdMap" property="key" />
																		<bean:define id="thirdValue" name="thirdMap"
																			property="value" />
																		<li>
																			<c:choose>
																				<c:when test="${thirdMap.key.acturl != null && thirdMap.key.acturl > ''}">
																					<html:link action="${thirdMap.key.acturl}&actname=${thirdMap.key.actname}">
																						<span>${thirdMap.key.actlabel}</span>
																					</html:link>
																				</c:when>
																				<c:otherwise>
																					<a href="###"><span>${thirdMap.key.actlabel}</span></a>
																				</c:otherwise>
																			</c:choose>
																		</li>
																		
																		<!-- 四层菜单Begin -->
																		<bean:size id="fourListCount2" name="thirdValue"/>
																		<c:if test="${fourListCount2 > 0}">
																			<ul id="bgiframe${num_third2}">
																			<script type="text/javascript">      
																				jQuery(document).ready(function() {   
																					  jQuery('#bgiframe${num_third2}').bgiframe({left:'1px'});   
																					});     
																			</script>
																			<logic:iterate id="fourList" name="thirdValue" indexId="num_four">
																				<li>
																					<c:choose>
																						<c:when test="${fourList.acturltype == '1' }">
																							<a href="###" onclick="show('${fourList.acturl}&actname=${fourList.actname}')">
																							<span>${fourList.actlabel}</span></a>
																						</c:when>
																						<c:otherwise>
																							<html:link action="${fourList.acturl}&actname=${fourList.actname}">
																								<span>${fourList.actlabel}</span>
																							</html:link>
																						</c:otherwise>
																					</c:choose>
																				</li>
																			</logic:iterate>
																			
																			</ul>
																		</c:if>
																		<!-- 四层菜单End -->	
															
																	</logic:iterate>
																</logic:iterate>
															</ul>
														</div>
													</c:if>
												</li>
												<c:if test="${(num + 1)== size}">
													</ul>
													</li>
												</c:if> 
											</c:if>
										</c:when>
										<c:otherwise>
											<li id="${secondMap.key.actsortid}"
													<c:if test="${size <= 11 && size == num + 1}">
													 class="last"
													</c:if>>
													<c:choose>
														<c:when test="${secondMap.key.acturl != null && secondMap.key.acturl > ''}">
															<html:link action="${secondMap.key.acturl}&actname=${secondMap.key.actname}" styleClass="parent">
																<span>${secondMap.key.actlabel}</span>
															</html:link>
														</c:when>
														<c:otherwise>
															<a href="###"><span>${secondMap.key.actlabel}</span></a>
														</c:otherwise>
													</c:choose>
												</li>
												<bean:size id="thirdListCount3" name="secondValue"/>
												<c:if test="${thirdListCount3 > 0}">
												
												<ul id="bgiframe${num}">
												<script type="text/javascript">      
													jQuery(document).ready(function() {   
														  jQuery('#bgiframe${num}').bgiframe();   
														});     
												</script>
													<logic:iterate id="thirdList" name="secondValue"   indexId="num_third3">
														<logic:iterate id="thirdMap" name="thirdList">
															<bean:define id="thirdKey" name="thirdMap" property="key" />
															<bean:define id="thirdValue" name="thirdMap"
																property="value" />
															
														
															<c:if test="${(thirdMap.key.actname=='ACT01CHC0301') or (thirdMap.key.actname=='ACT01CHC0302') or (thirdMap.key.actname=='ACT01CHC0304') or (thirdMap.key.actname=='ACT01CHC0201') or (thirdMap.key.actname=='ACT01CHC0203') or (thirdMap.key.actname=='ACT01CHC0111')}">
																<ofm:menuAuth oaroleid="1,2,5">	
																
																<li>
																<c:choose>
																	<c:when test="${thirdMap.key.acturl != null && thirdMap.key.acturl > ''}">
																		<c:choose>
																			<c:when test="${thirdMap.key.acturltype == '1' }">
																				<a href="###" onclick="show('${thirdMap.key.acturl}&actname=${thirdMap.key.actname}')">
																				<span>${thirdMap.key.actlabel}</span></a>
																			</c:when>
																			<c:otherwise>
																				<html:link action="${thirdMap.key.acturl}&actname=${thirdMap.key.actname}">
																					<span>${thirdMap.key.actlabel}</span>
																				</html:link>
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<a href="###"><span>${thirdMap.key.actlabel}</span></a>
																	</c:otherwise>
																</c:choose>
																</li>
																</ofm:menuAuth>
															</c:if>
															
															<c:if test="${(thirdMap.key.actname!='ACT01CHC0301') and (thirdMap.key.actname!='ACT01CHC0302') and (thirdMap.key.actname!='ACT01CHC0304') and (thirdMap.key.actname!='ACT01CHC0201') and (thirdMap.key.actname!='ACT01CHC0203') and (thirdMap.key.actname!='ACT01CHC0111')}">
																
																<li>
																<c:choose>
																	<c:when test="${thirdMap.key.acturl != null && thirdMap.key.acturl > ''}">
																		<c:choose>
																			<c:when test="${thirdMap.key.acturltype == '1' }">
																				<a href="###" onclick="show('${thirdMap.key.acturl}&actname=${thirdMap.key.actname}')">
																				<span>${thirdMap.key.actlabel}</span></a>
																			</c:when>
																			<c:otherwise>
																				<html:link action="${thirdMap.key.acturl}&actname=${thirdMap.key.actname}">
																					<span>${thirdMap.key.actlabel}</span>
																				</html:link>
																			</c:otherwise>
																		</c:choose>
																	</c:when>
																	<c:otherwise>
																		<a href="###"><span>${thirdMap.key.actlabel}</span></a>
																	</c:otherwise>
																</c:choose>
																</li>
															</c:if>
															
															<!-- 四层菜单Begin -->
															<bean:size id="fourListCount3" name="thirdValue"/>
															<c:if test="${fourListCount3 > 0}">
																<ul id="bgiframe${num_third3}">
																<script type="text/javascript">      
																	jQuery(document).ready(function() {   
																		  jQuery('#bgiframe${num_third3}').bgiframe({left:'-1px'});   
																		});     
																</script>
																<logic:iterate id="fourList" name="thirdValue" indexId="num_four">
																	<li>
																		<c:choose>
																			<c:when test="${fourList.acturltype == '1' }">
																				<a href="###" onclick="show('${fourList.acturl}&actname=${fourList.actname}')">
																				<span>${fourList.actlabel}</span></a>
																			</c:when>
																			<c:otherwise>
																				<html:link action="${fourList.acturl}&actname=${fourList.actname}">
																					<span>${fourList.actlabel}</span>
																				</html:link>
																			</c:otherwise>
																		</c:choose>
																	</li>
																</logic:iterate>
																
																</ul>
															</c:if>
															<!-- 四层菜单End -->	
															
														</logic:iterate>
													</logic:iterate>
												</ul>
												</c:if>
										</c:otherwise>
									</c:choose> 
								</logic:iterate> 
							</logic:iterate> 
						</c:if> 
					</logic:iterate> 
				</logic:iterate>
			</ul>
			</div>
		</c:if>
		</div>
	<script type="text/javascript">
		if(document.getElementById){
			//一级菜单超链接样式
		    if("${light}" == "1") {
			    //非设定首页
			    var firstactid = document.getElementById("001");
			    if(firstactid){
			    	firstactid.className = "at_sub";
			    }
		    } else {
			    //一级菜单超链接样式
			    var firstactid = document.getElementById("${firstactid}");
			    if(firstactid){
			    	firstactid.className = "at_sub";
			    }
		    }
		    //二级菜单样式
		    var secondactid = document.getElementById("${secondactid}");
		    if(secondactid){
		    	secondactid.className = "current";
		    }
		}
	</script>
	</logic:present>
</logic:present>