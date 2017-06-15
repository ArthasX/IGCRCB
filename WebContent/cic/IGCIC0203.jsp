<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html:html>
<bean:define id="id" value="IGCIC0203" toScope="request" />
<bean:define id="title" value="对比明细画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
.case {
	margin: 2px;
}
.case  div{
	margin: 0px;
}
.case ul {
	margin: 0px;
	padding: 0px; overflow : hidden;
	zoom: 1;
	overflow: hidden;
}

.case ul li {
	float: left;
	width: 470px;
	margin-bottom: 10px;
}

.dvblock {

	border: 1px solid #ccc;
	float: left;
	margin-right: 10px;
	height: 251px; 
	width: 450px
}

.dvblock .dvTitle {
	width: 100%;
	background-image: url("images/bg_titlevim101.png");
	font-size: 14px;
	height: 25px;
	vertical-align: middle;
	line-height: 25px;
}

.dvblock .dvTitle .titText {
	float: left;
	width: 70%;
	text-align: left;
	text-indent: 15px;
	color: #1C87E1;
	font-weight: 800;
}
.dvContentTitle{
	width: 100%;
	height:10px;
}

.dvContent {
	width: 100%;
	height:202px;
	overflow: scroll;
	overflow-x: hidden;
}
</style>
<script type="text/javascript">
<!--
	
//-->
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
					<div id="location">
							<div class="image"></div>
							<p class="fonts1">
								<ig:navigation extname1="${urlable}" />
							</p>
							<div class="back"><a href="IGCIC0202.do?cpid=${cpid }" target="_self">返回</a></div> 
					</div>
					<div id="results_list">
						<ig:message />
						<logic:present name="IGCIC02031VO" property="cic0203ShowMap">
							<!-- 遍历第一次Map start -->
							<logic:iterate id="bean" name="IGCIC02031VO" property="cic0203ShowMap">
								<bean:define id="key" name="bean" property="key"></bean:define>
								<fieldset>
									<legend>${key }</legend>
									<div class="case">
									<ul>
									<logic:present name="bean" property="value" >
										<!-- 遍历第二层Map start -->
										<logic:iterate id="sub" name="bean" property="value">
											<bean:define id="subvalue" name="sub" property="value"></bean:define>
											<bean:define id="isbase" name="subvalue" property="isBase"></bean:define>
													<li>
														<div class="dvblock" >
															<div class=dvTitle>
																<div class=titText>${sub.key }</div>
															</div>
															<div >
															<table class="table_style">
																	<tbody>
																		<tr>
																				<th>对象名</th>
																			<th>属性名</th>
																			<th>源对象属性值</th>
																			<th>目标对象属性值</th>
																			<th style="width: 20px;"></th>
																		</tr>
																		</tbody>
																</table>
															</div>
															<div class=dvContent>
																<table class="table_style" >
																	<tbody>
																		<logic:present name="subvalue"  property="crvwLst">
																		<logic:iterate id="vo" name="subvalue"  property="crvwLst"  >
																			<bean:define id="vokey"  name="vo" property="key"/>
																			<logic:present name="vo" property="value">
																				<bean:define id="vovalue"  name="vo" property="value"/>
																				<bean:size id="vovaluesize" name="vovalue"/>
																				<logic:iterate id="vovalueIte" name="vovalue" indexId="index">
																					<tr >
																							<c:if test="${index == 0 }">
																								<td rowspan="${vovaluesize }" align="left">
																									${vokey }
																								</td>
																							</c:if>
																						<td align="left">
																							${vovalueIte.cname }
																						</td>
																						<c:if test="${ vovalueIte.configtype ==  '0'}">
																							<td align="left">${vovalueIte.svalue }</td>
																							<td align="left">${vovalueIte.tvalue }</td>
																						</c:if>
																						<c:if test="${ vovalueIte.configtype ==  '1'}">
																							<td align="center" colspan="2"><a target="_blank" href="IGCIC0204.do?crid=${vovalueIte.crid }">查看详细</a></td>
																						</c:if>
																						<td  style="width: 20px;"></td>
																					</tr>
																				</logic:iterate>
																			</logic:present>
																		</logic:iterate>
																		</logic:present>
																	</tbody>
																</table>
															</div>
														</div>
													</li>
										</logic:iterate>
									</logic:present>
									</ul>
								</div>
								</fieldset>
							</logic:iterate>
							<!-- 遍历第一次Map end -->
						</logic:present>
					</div>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>


	</div>
</body>
</html:html>