<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@page import="com.deliverik.infogovernor.drm.vo.IGDRM0710VO"%>
<html:html>
<bean:define id="id" value="IGDRM0710" toScope="request" />
<bean:define id="title" value="演练评估管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/risk.css" rel="stylesheet" />
<script type="text/javascript" src="js/swfobject.js"></script>
<style type="text/css">
	.tdTtitle {
/* 		width: 173px; */
		background-color: #FDEDF0;
		font-size: 10;
		font-family: 宋体;
		color: #AB0215;
		vertical-align:middle;
		font-weight: bold;
		text-align: right;
		padding-right: 5px;
	}
	
	.tdContent {
/* 		width: 328px; */
		font-size: 10;
		font-family: 宋体;
		background-color: #ECEDEF;
		vertical-align:middle;
		font-weight: bold;
		font-weight: normal;
		word-break:break-all;
		word-warp:break-word;
		padding-left:1em;
		line-height: 16px;
		
	}
	
	.qiehuan-menubox { 
		width:418px;
		height:23px;
		float:left; 
		position:relative;
		left:0px;
	}
	.liClass{
		 width:136px; 
		 height:23px;
		 float:left;
		 line-height:23px;
		 font-size:12px;
		 color:#ffffff;
		 text-align:center;
		 background:url(images/zshmenu1-1.png);
		 font-weight: bold;
		}
		
	.ellips{
		width:500px; 
		white-space:nowrap; 
		text-overflow:ellipsis; 
		overflow:hidden;
		}
	.buttonDiv{
		background-color: #68778E;
		width:133px;
		height:28px;
		font-family: 宋体;
		font-size: 12;
		font-weight: bold;
		color: #FFFFFF;
		text-align: center;
		line-height: 28px;
		display: inline-block;
		margin-left: 10px;
		float: left;
		cursor:pointer;
	}
	.outLegendDiv{
		float: left;
		display: inline-block;
	}
	.legendDiv{
		display: inline-block;
		width:10px;
		height:10px;
		float: left;
		margin-left: 10px;
	}
</style>
<body>
		
	<div id="maincontent">
		<!-- header  头部和 一级菜单-->
		<jsp:include page="/include/header2.jsp" />
		<!--container 左菜单 右侧内容-->
		<div id="container" >
		
			<!--content  基本信息内容-->
			<div id="baseContent">
<!-- 				基本信息题目 -->
				<div  style="width: 989px;height: 28px;">
					<div class="back" style="display: inline-block;">
						<html:link href="javascript:toBack();" style="color:#BB0500;">返回</html:link>
					</div> 
					<div style="background-color: #BB0116;width:133px;height:28px;font-family: 宋体;font-size: 12;font-weight: bold;color: #FFFFFF;text-align: center;line-height: 28px;display: inline-block;">
						基本信息
					</div>
					
				</div>
<!-- 				内容 -->
				<div id="baseContent" style="width: 989px; border: thin;border-width: 1px;border-color: #CACACA;border-style: solid;">
					<table style="width:933px; margin:0 auto; margin-top: 17px; margin-bottom: 17px;">
					<bean:define id="detailMap" property="drillDetailMap" name="IGDRM0710VO"></bean:define>
						<tbody>
						<c:if test="${prid!=emprid}">
							<tr height="22px">
								<td width="14%" class="tdTtitle"> 演练流程名称</td>
								<td width="36%" class="tdContent" title="${detailMap.DRILLNAME }"> <div style="width: 330px" class="ellips">${detailMap.DRILLNAME }</div></td>
								<td width="14%" class="tdTtitle"> 发起者</td>
								<td width="36%" class="tdContent" title="${detailMap.AUTHOR }"> <div style="width: 330px" class="ellips"> ${detailMap.AUTHOR }</div></td>
							</tr>
						
							<tr height="22px">
								<td class="tdTtitle"> 应急预案名称</td>
								<td class="tdContent" title="${detailMap.PLANNAME }"> <div style="width: 330px" class="ellips"> ${detailMap.PLANNAME }</div> </td>
								<td class="tdTtitle"> 应急场景</td>
								<td class="tdContent" title="${detailMap.SENCENAME }"> <div style="width: 330px" class="ellips"> ${detailMap.SENCENAME }</div></td>
							</tr>
							
							<tr height="22px">
								<td class="tdTtitle"> 开始时间</td>
								<td class="tdContent" title="${detailMap.OPENTIME }"> <div style="width: 330px" class="ellips"> ${detailMap.OPENTIME }</div></td>
								<td class="tdTtitle"> 结束时间</td>
								<td class="tdContent" title="${detailMap.CLOSETIME }"> <div style="width: 330px" class="ellips"> ${detailMap.CLOSETIME }</div></td>
							</tr>
							
							<tr height="22px">
								<td class="tdTtitle"> 演练形式</td>
								<td class="tdContent" title="${detailMap.DRILLFORMALITY }"> <div style="width: 330px" class="ellips"> ${detailMap.DRILLFORMALITY }</div></td>
								<td class="tdTtitle"> 执行部门</td>
								<td class="tdContent" title="${detailMap.DEPARTMENT }"> <div style="width: 330px" class="ellips"> ${detailMap.DEPARTMENT }</div></td>
							</tr>
							
							<tr >
								<td class="tdTtitle"> 演练内容</td>
								<td colspan="3" class="tdContent" title="${detailMap.DRILLCONTENT }">
										 ${detailMap.DRILLCONTENT }
								</td>
							</tr>
							
							<tr>
								<td class="tdTtitle"> 演练目的</td>
								<td colspan="3" class="tdContent" title="${detailMap.DRILLOBJECTIVE }">
										 ${detailMap.DRILLOBJECTIVE }
								</td>
							</tr>
						</c:if>
						<c:if test="${prid==emprid}">
							<tr height="22px">
								<td width="14%" class="tdTtitle"> 指挥流程名称</td>
								<td width="36%" class="tdContent" title="${detailMap.DRILLNAME }"> <div style="width: 330px" class="ellips">${detailMap.DRILLNAME }</div></td>
								<td width="14%" class="tdTtitle"> 发起者</td>
								<td width="36%" class="tdContent" title="${detailMap.AUTHOR }"> <div style="width: 330px" class="ellips"> ${detailMap.AUTHOR }</div></td>
							</tr>
						
							<tr height="22px">
								<td class="tdTtitle"> 应急预案名称</td>
								<td class="tdContent" title="${detailMap.PLANNAME }"> <div style="width: 330px" class="ellips"> ${detailMap.PLANNAME }</div> </td>
								<td class="tdTtitle"> 应急场景</td>
								<td class="tdContent" title="${detailMap.SENCENAME }"> <div style="width: 330px" class="ellips"> ${detailMap.SENCENAME }</div></td>
							</tr>
							
							<tr height="22px">
								<td class="tdTtitle"> 开始时间</td>
								<td class="tdContent" title="${detailMap.OPENTIME }"> <div style="width: 330px" class="ellips"> ${detailMap.OPENTIME }</div></td>
								<td class="tdTtitle"> 结束时间</td>
								<td class="tdContent" title="${detailMap.CLOSETIME }"> <div style="width: 330px" class="ellips"> ${detailMap.CLOSETIME }</div></td>
							</tr>
							
							<tr height="22px">
								<td class="tdTtitle"> 恢复所需时间</td>
								<td class="tdContent" title="${detailMap.DRILLFORMALITY }"> <div style="width: 330px" class="ellips"> ${detailMap.DRILLFORMALITY }分钟</div></td>
								<td class="tdTtitle"> 业务恢复确认</td>
								<td class="tdContent" title="${detailMap.DEPARTMENT }"> <div style="width: 330px" class="ellips"> ${detailMap.DEPARTMENT }</div></td>
							</tr>
							
							<tr >
								<td class="tdTtitle"> 业务受影响范围</td>
								<td colspan="3" class="tdContent" title="${detailMap.DRILLCONTENT }">
										 ${detailMap.DRILLCONTENT }
								</td>
							</tr>
							
							<tr>
								<td class="tdTtitle"> 业务恢复描述</td>
								<td colspan="3" class="tdContent" title="${detailMap.DRILLOBJECTIVE }">
										 ${detailMap.DRILLOBJECTIVE }
								</td>
							</tr>
						
						</c:if>
						</tbody>
					</table>
				</div>
			</div>
<!-- 			评估内容 -->
			<div id="contentWarp" style="margin-top: 18px;">
<!--	评估题目 -->
				<div  style="width: 989px;height: 28px;">
					<logic:present property="evaluationContentList" name="IGDRM0710VO"> 
						<div  id="emergcmdButton" class="buttonDiv"  style="background-color:#BB0116;" onclick="tabClick('emergcmdButton','emergcmdRulerContent')">
							指挥流程评估
						</div>
					</logic:present>
					<div  id="senceButton" class="buttonDiv"  onclick="tabClick('senceButton','senceRulerContent')">
							处置流程评估
					</div>
					<div  id="evaluateButton" class="buttonDiv"  onclick="tabClick('evaluateButton','evaluateContent')">
							评估报告
					</div >
					<div style="float: right;">
						<div class="action"  style="background-color: #ffffff;border-style: none;" id="emDiv">
							<logic:notPresent name="IGDRM0710VO" property="emEvaluationContent">
								<img width="16" height="16" src="images/p002.png" >
								指挥流程未评估
							</logic:notPresent>
							<logic:present  name="IGDRM0710VO" property="emEvaluationContent">
								<img width="16" height="16" src="images/p001.png" >
								指挥流程已评估
							</logic:present>
							
						</div>
						
						<div class="action"  style="background-color: #ffffff;border-style: none;" id="seDiv">
							<logic:notPresent name="IGDRM0710VO" property="seEvaluationContent">
								<img width="16" height="16" src="images/p002.png" >
								处置流程未评估
							</logic:notPresent>
							<logic:present  name="IGDRM0710VO" property="seEvaluationContent">
								<img width="16" height="16" src="images/p001.png" >
								处置流程已评估
							</logic:present>
						</div>
					
						<div class="action"  style="background-color: #ffffff;border-style: none;" id="evDiv">
							<logic:notPresent name="IGDRM0710VO" property="evaluationInfo">
								<img width="16" height="16" src="images/p002.png" >
								评估报告未填写
							</logic:notPresent>
							<logic:present  name="IGDRM0710VO" property="evaluationInfo">
								<img width="16" height="16" src="images/p001.png" >
								评估报告已填写
							</logic:present>
						</div>
					</div>
				</div>
			</div>
<!-- 			应急指挥 -->
			<logic:present property="evaluationContentList" name="IGDRM0710VO"> 
			<div id="emergcmdRulerContent" style="width: 970px; margin-bottom:50px; border: thin;border-width: 1px;border-color: #CACACA;border-style: solid;padding-top: 10px;padding-left: 19px;">
				<input type="hidden" id="emprid" value="${emprid}"/> 
				<div id="emergcmdRulerDashBoard">
						
				</div>
				<div style="width: 100%;margin-top: 5px;">
					<div class="outLegendDiv"><div style="background-color: #E38313;" class="legendDiv"></div><span style="font-family: 宋体;margin-left: 3px;">事件评估</span></div>
					<div class="outLegendDiv"><div style="background-color: #EBA903;" class="legendDiv"></div><span style="font-family: 宋体;margin-left: 3px;">事件宣告</span></div> 
					<div class="outLegendDiv"><div style="background-color: #95AC26;" class="legendDiv"> </div><span style="font-family: 宋体;margin-left: 3px;">预案调用</span></div>
					<div class="outLegendDiv"><div style="background-color: #579E36;" class="legendDiv"> </div><span style="font-family: 宋体;margin-left: 3px;">资源协调</span></div>
					<div class="outLegendDiv"><div style="background-color: #F14E51;" class="legendDiv"> </div><span style="font-family: 宋体;margin-left: 3px;">应急处置</span></div>
					<div class="outLegendDiv"><div style="background-color: #5F32B1;" class="legendDiv"> </div><span style="font-family: 宋体;margin-left: 3px;">业务验证</span></div>
					<div class="outLegendDiv"><div style="background-color: #12B5D1;" class="legendDiv"> </div><span style="font-family: 宋体;margin-left: 3px;">恢复宣告</span></div>
				</div>
				<div  class="qiehuan-menubox" style="margin-top: 10px;"> 
					<ul >
						<li class="liClass">&nbsp;意见列表</li> 
					</ul>
				</div>
				<div class="Contentbox" style="width: 952px;">
						<div id="con_f_1">
							<div class="Contentbox-qiehuan">
								<div id="fxj" class="k"> 
									<table class="table_style"  id="emTable">
										<thead >
											<th width="3%" >序号</th>
											<th width="8%" >节点名称</th>
											<th width="13%" >参与人</th>
											<th width="15%" >开始时间</th>
											<th width="15%" >结束时间</th>
											<th width="6%" >实际用时</th>
											<th width="30%" >评估内容</th>
											<th width="10%" >评估人</th>
										</thead>
										<tbody>
										<logic:present name="IGDRM0710VO"
											property="evaluationContentList">
											<logic:iterate id="bean" name="IGDRM0710VO"
												property="evaluationContentList" indexId="index" type="com.deliverik.infogovernor.drm.model.EvaluationContentInfo" >
												<c:if test="${bean.sortId != 0 }">
													<tr>
														<td align="center">${bean.sortId }</td>
														<td align="center">${bean.stepName }</td>
														<td align="center" title="${bean.peoples }">
															<%if(bean.getPeoples()!=null&&bean.getPeoples().length()>6) {%>
															<%=bean.getPeoples().substring(0,4) %>...
															<%	}else{%>
																<%=bean.getPeoples() %>
															<%}%>
														</td>
														<td align="center">${bean.startTime }</td>
														<td align="center">${bean.stopTime }</td>
														<td align="center">${bean.factUseTime }</td>
														<td align="center" title="${bean.suggestion }">
														<%if(bean.getSuggestion()!=null&&bean.getSuggestion().length()>15) {%>
															<%=bean.getSuggestion().substring(0,15) %>...
															<%	}else{%>
																<%=bean.getSuggestion() %>
															<%}%>
														</td>
														<td align="center">${bean.evpeople }</td>
													</tr>
												</c:if>
											</logic:iterate>
										</logic:present>
									</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					<div style="margin-top: 50px;height: 160px;">
						<table >
							<tr>
								<td width="6%" style="text-align: right;">评估意见</td>
								<td width="90%">
								<logic:present name="IGDRM0710VO" property="emEvaluationContent">
									<bean:define id="emEvaluationContent" property="emEvaluationContent" name="IGDRM0710VO"></bean:define>
									<html:textarea property="emEvaluationContent" styleId="emEvaluationContent" rows="6" cols="120" 
										name="IGDRM0710VO" value="${emEvaluationContent.suggestion}" readonly="true"  style="border:1px solid #CCCCCC;"/>
								</logic:present> 
								<logic:notPresent name="IGDRM0710VO" property="emEvaluationContent">
									<html:textarea property="emEvaluationContent" styleId="emEvaluationContent" rows="6" cols="120" 
										name="IGDRM0710VO"  style="border:1px solid #CCCCCC;"/>
								</logic:notPresent>
								</td>
							</tr>
						</table>
						<logic:notPresent name="IGDRM0710VO" property="emEvaluationContent">
								<div class="action" onclick="saveSuggestion('em')" style="cursor: pointer; margin-left: 860px;"  id="saveEmSuggestion" >
									<img width="16" height="16" src="images/icon2_089.gif">
									<a title="提交" style="color: #ffffff">提交</a>
								</div>
						</logic:notPresent>
					</div>
			</div>
			</logic:present>
<!--场景流程 -->	
			<div id="senceRulerContent" style="width: 970px; margin-bottom:50px;   border: thin; border-width: 1px; border-color: #CACACA; border-style: solid; padding-top: 10px; padding-left: 19px;">
				<input type="hidden" id="seprid" value="${seprid}" />
				<div id="senceDashBoard"></div>
				<div  class="qiehuan-menubox" style="margin-top: 10px;"> 
					<ul >
						<li class="liClass">&nbsp;意见列表</li> 
					</ul>
					
				</div>
				<div class="Contentbox" style="width: 952px;">
					<div id="con_f_1" >
						<div class="Contentbox-qiehuan">
							<div  class="k">
								<table width="952" class="table_style" id="seTable">
									<thead>
										<th width="3%" >序号</th>
										<th width="8%" >节点名称</th>
										<th width="13%" >参与人</th>
										<th width="15%" >开始时间</th>
										<th width="15%" >结束时间</th>
										<th width="6%" >实际用时</th>
										<th width="30%" >评估内容</th>
										<th width="10%" >评估人</th>
									</thead>
									<tbody>
									<logic:present name="IGDRM0710VO"
										property="senceContentList">
										<logic:iterate id="bean" name="IGDRM0710VO"
											property="senceContentList" indexId="index" type="com.deliverik.infogovernor.drm.model.EvaluationContentInfo">
											<c:if test="${bean.sortId != 0 }">
											<tr>
												<td align="center">${bean.sortId }</td>
												<td align="center">${bean.stepName }</td>
												<td align="center" title="${bean.peoples }">
													<%if(bean.getPeoples()!=null&&bean.getPeoples().length()>6) {%>
															<%=bean.getPeoples().substring(0,4) %>...
													<%	}else{%>
																<%=bean.getPeoples() %>
															<%}%>
												</td>
												<td align="center">${bean.startTime }</td>
												<td align="center">${bean.stopTime }</td>
												<td align="center">${bean.factUseTime }</td>
												<td align="center" title="${bean.suggestion }">
													<%if(bean.getSuggestion()!=null&&bean.getSuggestion().length()>15) {%>
															<%=bean.getSuggestion().substring(0,15) %>...
													<%	}else{%>
																<%=bean.getSuggestion() %>
													<%}%>
												</td>
												<td align="center">${bean.evpeople }</td>
											</tr>
											</c:if>
										</logic:iterate>
									</logic:present>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
				<div style="margin-top: 50px;height: 160px;">
						<table>
							<tr>
								<td width="6%" style="text-align: right;">评估意见</td>
								<td width="90%">
								<logic:present name="IGDRM0710VO" property="seEvaluationContent">
									<bean:define id="seEvaluationContent" property="seEvaluationContent" name="IGDRM0710VO"></bean:define>
									<html:textarea property="seEvaluationContent" styleId="seEvaluationContent" rows="6" cols="120" 
										name="IGDRM0710VO" value="${seEvaluationContent.suggestion}"   style="border:1px solid #CCCCCC;"/>
								</logic:present> 
								<logic:notPresent name="IGDRM0710VO" property="seEvaluationContent">
									<html:textarea property="seEvaluationContent" styleId="seEvaluationContent" rows="6" cols="120" 
										name="IGDRM0710VO"  style="border:1px solid #CCCCCC;"/>
								</logic:notPresent>
								</td>
							</tr>
						</table>
						<logic:notPresent name="IGDRM0710VO" property="seEvaluationContent">
								<div class="action" onclick="saveSuggestion('se')" style="cursor: pointer; margin-left: 860px;"  id="saveSeSuggestion" >
									<img width="16" height="16" src="images/icon2_089.gif">
									<a title="提交" style="color: #ffffff">提交</a>
								</div>
						</logic:notPresent>
				</div>
			</div>
<!-- 			评估报告 -->
			<div id="evaluateContent" style="width: 970px;margin-bottom:50px;  border: thin; border-width: 1px; border-color: #CACACA; border-style: solid; padding-top: 10px; padding-left: 19px;">
				<div  class="qiehuan-menubox" style="margin-top: 10px; width: 950px;"> 
					<ul >
						<li class="liClass">&nbsp;意见列表</li> 
					</ul>
					<div style="float: right;">
						流程类型:
						<select style="border: 1px solid #CCCCCC; " onchange="evaluationListChange(this)" id="evaluateSelect">
							<c:if test="${emprid!=''}">
								<option value="${emprid}_em">演练指挥流程</option>
							</c:if>
							<option value="${seprid}_se">演练处置流程</option>
						</select>
					</div>
					
				</div>
				<div class="Contentbox" style="width: 952px;">
						<div id="con_f_1">
							<div class="Contentbox-qiehuan">
								<div id="fxj" class="k"> 
									<table class="table_style"  id="evTable">
										<thead >
											<th width="5%" >序号</th>
											<th width="10%" >节点名称</th>
											<th width="55%" >评估内容</th>
											<th width="10%" >评估时间</th>
											<th width="10%" >评估人</th>
										</thead>
										<tbody>
										<logic:present name="IGDRM0710VO"
											property="evaluationList">
											<logic:iterate id="bean" name="IGDRM0710VO"
												property="evaluationList" indexId="index" type="com.deliverik.infogovernor.drm.model.EvaluationContentInfo" >
												<c:if test="${bean.sortId != 0 }">
													<tr>
														<td align="center">${bean.sortId }</td>
														<td align="center">${bean.stepName }</td>
														<td align="center" title="${bean.suggestion }" >
															<%if(bean.getSuggestion()!=null&&bean.getSuggestion().length()>15) {%>
															<%=bean.getSuggestion().substring(0,15) %>...
													<%	}else{%>
																<%=bean.getSuggestion() %>
													<%}%>
														</td>
														<td align="center">${bean.doTime }</td>
														<td align="center" title="${bean.evpeople }">
														${bean.evpeople }
														</td>
													</tr>
												</c:if>
											</logic:iterate>
										</logic:present>
									</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
					
					<div  class="qiehuan-menubox" style="width: 950px; margin-top: 10px;"> 
						<ul >
							<li class="liClass">&nbsp;演练评估</li> 
						</ul>
					</div>
					<div id="evContent" style="width: 930px; border: thin; border-width: 1px; border-color: #CACACA; border-style: solid; padding-top: 10px; padding-left: 19px;">
						<table style="margin-top: 40px;margin-left: 30px;">
						<logic:present name="IGDRM0710VO" property="evaluationInfo">
							<bean:define id="evaluationInfo" property="evaluationInfo" name="IGDRM0710VO"></bean:define>
							<tr>
								<td width="10%" align="right" style="vertical-align: top;"><span style="color: red">*</span>评估内容</td>
								<td width="90%" colspan="3">
									<textarea rows="5" cols="100" style="border: 1px solid #CCCCCC; " id="stepNameText">${evaluationInfo.stepName}</textarea>
								</td>
							</tr>
							<tr>
								<td width="10%" align="right" style="vertical-align: middle;"><span style="color: red">*</span>评估负责人</td>
								<td width="40%">
									<input type="text" value="${evaluationInfo.evpeople }" style="border: 1px solid #CCCCCC; " id="evpeopleText">
								</td>
								<td width="10%" align="right" style="vertical-align: middle;"><span style="color: red">*</span>评估参与人</td>
								<td width="40%">
									<input type="text" value="${evaluationInfo.peoples }" style="border: 1px solid #CCCCCC; " id="peoplesText">
								</td>
							</tr>
							<tr>
								<td width="10%" align="right" style="vertical-align: top;"><span style="color: red">*</span>评估意见</td>
								<td width="90%" colspan="3">
									<textarea rows="5" cols="100" style="border: 1px solid #CCCCCC; " id="suggestionText">${evaluationInfo.suggestion}</textarea>
								</td>
							</tr>
							<tr>
								<td width="10%" align="right" style="vertical-align: top;"><span style="color: red">*</span>改进措施</td>
								<td width="90%" colspan="3">
									<textarea rows="5" cols="100" style="border: 1px solid #CCCCCC; " id="fingerPrintText">${evaluationInfo.fingerPrint}</textarea>
								</td>
							</tr>
						</logic:present>
						<logic:notPresent name="IGDRM0710VO" property="evaluationInfo">
							<tr>
								<td width="10%" align="right" style="vertical-align: top;" ><span style="color: red">*</span>评估内容</td>
								<td width="90%" colspan="3">
									<textarea rows="5" cols="100" id="evContentTextArea" style="border: 1px solid #CCCCCC; "></textarea>
								</td>
							</tr>
							<tr>
								<td width="10%" align="right" style="vertical-align: middle;"><span style="color: red">*</span>评估负责人</td>
								<td width="40%">
									<input type="text" id="evpeople" style="border: 1px solid #CCCCCC; width: 310px;">
								</td>
								<td width="10%" align="right" style="vertical-align: middle;"><span style="color: red">*</span>评估参与人</td>
								<td width="40%">
									<input type="text" id="evpeoples" style="border: 1px solid #CCCCCC; width: 310px;">
								</td>
							</tr>
							<tr>
								<td width="10%" align="right" style="vertical-align: top;"><span style="color: red">*</span>评估意见</td>
								<td width="90%" colspan="3">
									<textarea rows="5" cols="100" id="evSuggestionContent" style="border: 1px solid #CCCCCC; "></textarea>
								</td>
							</tr>
							<tr>
								<td width="10%" align="right" style="vertical-align: top;"><span style="color: red">*</span>改进措施</td>
								<td width="90%" colspan="3">
									<textarea rows="5" cols="100" id="evFingerPrint" style="border: 1px solid #CCCCCC; "></textarea>
								</td>
							</tr>
						</logic:notPresent>
						</table>
						
					</div>
					
					<div style="height: 66px;">
					<logic:present name="IGDRM0710VO" property="evaluationInfo">
							<div class="action"  style="cursor: pointer; margin-left: 886px; margin-top: 10px;"  id="saveEvSuggestionUpdate"  onclick="saveEvSuggestion('update')">
									<img width="16" height="16" src="images/icon2_089.gif">
									<a title="提交" style="color: #ffffff">提交</a>
							</div>							
					</logic:present>
								
					<logic:notPresent name="IGDRM0710VO" property="evaluationInfo">
							<div class="action"  style="cursor: pointer; margin-left: 886px; margin-top: 10px;"  id="saveEvSuggestionInsert"  onclick="saveEvSuggestion('insert')">
									<img width="16" height="16" src="images/icon2_089.gif">
									<a title="提交" style="color: #ffffff">提交</a>
							</div>					
					</logic:notPresent>
					</div>
					
			</div>
			<input  type="hidden"  id="prid" value="${prid}">
	</div>
	
</div>
<script type="text/javascript">
		var swfVersionStr = "11.1.0";
		var xiSwfUrlStr = "playerProductInstall.swf";
		var flashvars = {};
		var params = {};
		params.quality = "high";
		params.bgcolor = "#ffffff";
		params.allowscriptaccess = "sameDomain";
		params.allowfullscreen = "true";
		var attributes = {};
		params.wmode = "opaque";
		var emprid = '${emprid}';
		if(emprid){
			swfobject.embedSWF("images/drmswf/emergcmd_ruler.swf", "emergcmdRulerDashBoard",
					"953", "140", swfVersionStr, xiSwfUrlStr, flashvars, params,
					attributes);
			swfobject.createCSS("#emergcmdRulerDashBoard", "display:block;text-align:left;");
			jQuery("#senceRulerContent").hide();
		}else{
			jQuery("#senceButton").css("backgroundColor","#BB0116");
			jQuery("#emDiv").html("");
		}
		swfobject.embedSWF("images/drmswf/sence_ruler.swf", "senceDashBoard",
				"960", "350", swfVersionStr, xiSwfUrlStr, flashvars, params,
				attributes);
		swfobject.createCSS("#senceDashBoard", "display:block;text-align:left;");
		jQuery("#evaluateContent").hide();
	
		function getJSONData(type,flexType) {
			var result = "";
			//6,获取实时跟踪信息
			jQ.ajax({
				url : getAppRootUrl() + "/IGDRM0710_JSON.do?prid=${prid}&type="+ type+"&flexType="+flexType+"&emprid="+jQuery("#emprid").val(),
				async : false,
				dataType : "text",
				success : function(data) {
					result = data;
				}
			});
			return result;
		}

		//流程开始时间
		function getEmStartTimeData(showType) {
			return getJSONData(8,"em");
		}
		//流程已用时
		function getEmUseTimeData(showType) {
			return getJSONData(9,"em");
		}
		//停止时间
		function getEmStopTimeData(showType) {
			return getJSONData("overTime","em");
		}

		//流程图
		function getEmFlowData(showType) {
			return getJSONData("emergencyFlow","em");
		}
		
		//获取流程ID函数
		function getEmPridJSFunc() {
			return '${emprid}';
		}
		
		//流程开始时间
		function getSeStartTimeData(showType) {
			return getJSONData(8,"se");
		}
		//流程已用时
		function getSeUseTimeData(showType) {
			return getJSONData(9,"se");
		}
		//停止时间
		function getSeStopTimeData(showType) {
			return getJSONData("overTime","se");
		}

		//流程图
		function getSeFlowData(showType) {
			return getJSONData("flowMsg","se");
		}
		
		//获取流程ID函数
		function getSePridJSFunc() {
			return '${seprid}';
		}
		
		//获取Port端口号和IP函数
		function getSocketInfo() {
// 			return '192.168.0.154' + ":" + '${port}';
			return '${ip}'+":"+'${port}';
		}
		
	</script>
	<script type="text/javascript">
	//点击TAB按钮切换界面
		function tabClick(id,contentId){
			var emprid = '${emprid}';
			if(emprid){
				jQuery("#emergcmdButton").css("backgroundColor","#68778E");
				jQuery("#emergcmdRulerContent").hide();
			}
			jQuery("#senceButton").css("backgroundColor","#68778E");
			jQuery("#evaluateButton").css("backgroundColor","#68778E");
			jQuery("#"+id).css("backgroundColor","#BB0116");
			jQuery("#senceRulerContent").hide();
			jQuery("#evaluateContent").hide();
			jQuery("#"+contentId).show();
			evaluationListChange();
		}
		//点击节点显示评估页面
		function senceStepLabelClick(psdid,psdname,people,nodeStep,expectStartTime,expectUseTime,expectOverTime,factStartTime,factUseTime,factOverTime,flexType){
			//察看该节点是否已经评估过，如果评估了则不允许再评估。
			jQuery.ajax({
				url:getAppRootUrl()+"/IGDRM0710_ISEXIST.do",
				data:{psdid:psdid,flexType:flexType,prid:jQuery("#seprid").val()},
				async : true,
				type:"POST",
				dataType :"json",
				//成功回调函数
				success:function(obj){
						if(obj =="true"){
		 					var url=encodeURI(encodeURI('/IGDRM0711_Disp.do?psdid='+psdid+'&psdname='+psdname+'&people='+people+'&nodeStep='+nodeStep+'&expectStartTime='+expectStartTime+'&expectUseTime='+expectUseTime+'&expectOverTime='+expectOverTime+'&factStartTime='+factStartTime+'&factUseTime='+factUseTime+'&factOverTime='+factOverTime+'&flexType='+flexType));
		 					window.openSubWindow(url, '_blank', '720', '550');		
						}else{
							alert("该节点已评估完成！");
						}
					}
				});
     	}
		
		function emStepLabelClick(psdid,psdname,factUseTime,flexType){
			//察看该节点是否已经评估过，如果评估了则不允许再评估。
			jQuery.ajax({
				url:getAppRootUrl()+"/IGDRM0710_ISEXIST.do",
				data:{psdid:psdid,flexType:flexType,prid:jQuery("#emprid").val()},
				async : true,
				type:"POST",
				dataType :"json",
				//成功回调函数
				success:function(obj){
						if(obj =="true"){
							var  url=	encodeURI(encodeURI('/IGDRM0711_Disp.do?psdid='+psdid+'&psdname='+psdname+'&flexType='+flexType+'&emprid='+jQuery("#emprid").val()+'&factUseTime='+factUseTime));
							window.openSubWindow(url, '_blank', '720', '550');
						}else{
							alert("该节点已评估完成！");
						}
					}
				});
		}
		//保存内容
		function saveDetail(psdid,flexType,suggestionValue){
			var prid = "";
			var userid = '${LOGIN_USER.userid}';
			var index = 0;
			if(flexType == "em"){
				prid = jQuery("#emprid").val();
				index = jQuery("#emTable tbody tr").length;
			}else{
				prid = jQuery("#seprid").val();
				index = jQuery("#seTable tbody tr").length;
			}
			jQuery.ajax({
				url:getAppRootUrl()+"/IGDRM0710_SAVEDETAIL.do",
				data:{psdid:psdid,flexType:flexType,suggestionValue:suggestionValue,prid:prid,userid:userid,index:index+1},
				async : true,
				type:"POST",
				dataType :"json",
				//成功回调函数
				success:function(obj){
					if(flexType == "em"){
						jQuery("#emTable tbody tr").remove(); 
						if(obj){
							for(var i = 0;i<obj.length;i++){
								var emObj = obj[i];
								if(emObj.sortId!=0){
									var temp=emObj.suggestion;
									if(emObj.suggestion.length>15){
										temp=emObj.suggestion.substring(0,15)+"...";
									}
									var temp1=emObj.peoples;
									if(emObj.peoples.length>6){
										temp1=emObj.peoples.substring(0,4)+"...";
									}
									jQuery("#emTable tbody").append("<tr>"+
											"<td align='center'>"+emObj.sortId+"</td>"+
											"<td align='center'>"+emObj.stepName+"</td>"+
											"<td align='center'title='"+emObj.peoples+"'>"+temp1+"</td>"+
											"<td align='center'>"+emObj.startTime+"</td>"+
											"<td align='center'>"+emObj.stopTime+"</td>"+
											"<td align='center'>"+emObj.factUseTime+"</td>"+
											"<td align='center' title='"+emObj.suggestion+"'>"+temp+"</td>"+
											"<td align='center'>"+emObj.evpeople+"</td>"+
									"</tr>");
								}
								
							}
						}
					}else{
						jQuery("#seTable tbody tr").remove(); 
						if(obj){
							for(var i = 0;i<obj.length;i++){
								var ecObj = obj[i];
								if(ecObj.sortId!=0){
									var temp=ecObj.suggestion;
									if(ecObj.suggestion.length>15){
										temp=ecObj.suggestion.substring(0,15)+"...";
									}
									var temp1=ecObj.peoples;
									if(ecObj.peoples.length>6){
										temp1=ecObj.peoples.substring(0,4)+"...";
									}
									jQuery("#seTable tbody").append("<tr>"+
											"<td align='center'>"+ecObj.sortId+"</td>"+
											"<td align='center'>"+ecObj.stepName+"</td>"+
											"<td align='center' title='"+ecObj.peoples+"'>"+temp1+"</td>"+
											"<td align='center'>"+ecObj.startTime+"</td>"+
											"<td align='center'>"+ecObj.stopTime+"</td>"+
											"<td align='center'>"+ecObj.factUseTime+"</td>"+
											"<td align='center'title='"+ecObj.suggestion+"'>"+temp+"</td>"+
											"<td align='center'>"+ecObj.evpeople+"</td>"+
									"</tr>");
								}
								
							}
							
						}
					}
				}
			});
		}
		
		
		function saveSuggestion(flowType){
			var prid = "";
			//应急指挥
			var suggestionContent;
			if(flowType == "em"){
				prid = jQuery("#emprid").val();
				suggestionContent= jQuery("#emEvaluationContent").html();
			}else{
				prid = jQuery("#seprid").val();
				suggestionContent= jQuery("#seEvaluationContent").html();
			}
			if(!suggestionContent){
				alert("请输入评估内容！");
				return false;
			}
			
			if(suggestionContent.strlen()>2048){
				alert("评估内容不能大于"+Math.floor(2048/strByteFlag)+"个汉字！");
				return false;
			}
			jQuery.ajax({ 
				url:getAppRootUrl()+"/IGDRM0710_SAVESUGGESTION.do",
				data:{prid:prid,suggestionContent:suggestionContent,flowType:flowType},
				async : true,
				type:"POST",
				dataType :"json",
				//成功回调函数
				success:function(obj){
					if(flowType == "em"){
						jQuery("#saveEmSuggestion").hide();
						jQuery("#emEvaluationContent").attr("readonly","readonly");
						jQuery("#emDiv").html('<img width="16" height="16" src="images/p001.png">指挥流程已评估'); 
						alert("指挥流程评估意见提交成功！");
					}else{
						jQuery("#seEvaluationContent").attr("readonly","readonly");
						jQuery("#saveSeSuggestion").hide();
						jQuery("#seDiv").html('<img width="16" height="16" src="images/p001.png">处置流程已评估');
						alert("处置流程评估意见提交成功！");
					}
				}
			});
		}
		//点击流程类型改变数据
		function evaluationListChange(obj){
			var evprid = jQuery("#evaluateSelect").val();
			jQuery.ajax({
				url:getAppRootUrl()+"/IGDRM0710_CHANGEEVALUATION.do",
				data:{evprid:evprid},
				async : true,
				type:"POST",
				dataType :"json",
				//成功回调函数
				success:function(obj){
					jQuery("#evTable tbody tr").remove(); 
					if(obj){
						for(var i = 0;i<obj.length;i++){
							var emObj = obj[i];
							if(emObj.sortId!=0){
								var temp=emObj.suggestion;
								if(emObj.suggestion.length>15){
									temp=emObj.suggestion.substring(0,15)+"...";
								}
								jQuery("#evTable tbody").append("<tr>"+
										"<td align='center'>"+emObj.sortId+"</td>"+
										"<td align='center'>"+emObj.stepName+"</td>"+
										"<td align='center' title='"+emObj.suggestion+"'>"+temp+"</td>"+
										"<td align='center'>"+emObj.doTime+"</td>"+
										"<td align='center'>"+emObj.evpeople+"</td>"+
								"</tr>");
							}
							
						}
					}
				}
			});
		}
		
		function saveEvSuggestion(operate){
				var stepName="";
				var evpeople = "";
				var peoples = "";
				var suggestion = "";
				var fingerprint = "";
				var	prid = jQuery("#prid").val();
			if(jQuery("#evContentTextArea").val()!=null){
				stepName = jQuery("#evContentTextArea").val();
				evpeople = jQuery("#evpeople").val();
				peoples = jQuery("#evpeoples").val();
				suggestion = jQuery("#evSuggestionContent").val();
				fingerprint = jQuery("#evFingerPrint").val();
				
			}else{
				stepName = jQuery("#stepNameText").val();
				evpeople = jQuery("#evpeopleText").val();
				peoples = jQuery("#peoplesText").val();
				suggestion = jQuery("#suggestionText").val();
				fingerprint = jQuery("#fingerPrintText").val();
			}
			if(!stepName){
				alert("请输入评估内容！");
				return false;
			}
			
			if(!evpeople){
				alert("请输入评估负责人！");
				return false;
			}
			if(!peoples){ 
				alert("请输入评估参与人！");
				return false;
			}
			if(!suggestion){
				alert("请输入评估意见！");
				return false;
			}
			if(!fingerprint){
				alert("请输入改进措施！");
				return false;
			}
			
			if(stepName.strlen()>2048){
				alert("评估内容不能大于"+Math.floor(2048/strByteFlag)+"个汉字！");
				return false;
			}
			if(evpeople.strlen()>128){
				alert("评估负责人不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
				return false;
			}
			
			if(peoples.strlen()>1024){
				alert("评估参与人不能大于"+Math.floor(1024/strByteFlag)+"个汉字！");
				return false;
			}
			
			if(suggestion.strlen()>2048){
				alert("评估意见不能大于"+Math.floor(2048/strByteFlag)+"个汉字！");
				return false;
			}
			
			if(fingerprint.strlen()>256){
				alert("改进措施不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
				return false;
			}
			
			jQuery.ajax({
				url:getAppRootUrl()+"/IGDRM0710_SAVEALLDETAIL.do",
				data:{prid:prid,stepName:stepName,evpeople:evpeople,peoples:peoples,suggestion:suggestion,fingerprint:fingerprint,flexType:"all"},
				async : true,
				type:"POST",
				dataType :"json",
				//成功回调函数
				success:function(obj){
					if(obj){
						jQuery("#evDiv").html('<img width="16" height="16" src="images/p001.png">评估报告已填写');
						alert("评估报告提交成功！");
					}
				}
			});
	}	
		function toBack(){
			var prid = jQuery("#prid").val();
			var emprid = jQuery("#emprid").val();
			if(emprid == prid){
				window.location.href = getAppRootUrl()+"/IGDRM0713.do?prpdid=01386";
			}else{
				
				window.location.href = getAppRootUrl()+"/IGDRM0703.do?prpdid=01385";
			}
		}
	</script>
</body>
</html:html>
