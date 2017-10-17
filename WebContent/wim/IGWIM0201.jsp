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
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGWIM0201" toScope="request" />
<bean:define id="title" value="工作查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
          <html:form styleId="form" action="/IGWIM0201" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                <p class="fonts1">流程管理 &gt;&gt; 工作管理 &gt;&gt; 工作查看</p>
            </div>
            <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                   <div style="margin-top:4px">
                    <span class="subscribe"><span class="red">*</span>工作时间：</span><html:text property="workDate" styleId="workDate" name="IGWIM0201Form" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                    <img src="images/date.gif" align="middle" onClick="calendar($('workDate'))" border="0"/>
                    <span>
					<span class="subscribe">部门：</span>
					<html:select property="orgsyscoding" styleId="orgsyscoding" style="width:120px">
						<logic:present name="IGWIM02011VO" property="orgMap" >
			               <logic:iterate id="bean" name="IGWIM02011VO" property="orgMap" indexId="index">
							<option value="${bean.key}">${bean.value}</option>
						   </logic:iterate>
						</logic:present>
					</html:select>
					<span class="subscribe">人员：</span>
					<html:select property="userid" styleId="userid" style="width:80px">
						<logic:present name="IGWIM02011VO" property="userOrgList" >
							<logic:iterate id="bean" name="IGWIM02011VO" property="userOrgList" indexId="index">
								<option value="${bean.userid}" aa="${bean.orgsyscoding}">${bean.username}</option>
						   </logic:iterate>
						</logic:present>
					</html:select>
					
					
					<select id="tempSelect" style="display: none;">
						<logic:present name="IGWIM02011VO" property="userOrgList" >
			               <logic:iterate id="bean" name="IGWIM02011VO" property="userOrgList" indexId="index">
							<option value="${bean.userid}" aa="${bean.orgsyscoding}">${bean.username}</option>
						   </logic:iterate>
						</logic:present>
					</select>
						
					<html:submit property="btn_search" style="30-left:5px" styleClass="button" value="查询" onclick="onSearch()"/>
                   </div>
                   </div>
                </div>
                
                <div id="results_list">
					<ig:message />
                    <table class="table_style"  >
						<!-- header部 -->
							<tr>
							   <logic:iterate id="bean" name="IGWIM02011VO" property="dateList" indexId="index">
							   		<c:if test="${index==0 }">
										<th width="20%">${bean}</th>
							   		</c:if>
							   		<c:if test="${index!=0 }">
							   			<c:if test="${index!=8 }">
											<th width="11%">${bean}</th>
							   			</c:if>
							   		</c:if>
							   </logic:iterate>
							</tr>
							<tr height="28px;">
								<td width="20%"><strong>工作名称</strong></td>
								<td width="11%"><strong>星期一</strong></td>
								<td width="11%"><strong>星期二</strong></td>
								<td width="11%"><strong>星期三</strong></td>
								<td width="11%"><strong>星期四</strong></td>
								<td width="11%"><strong>星期五</strong></td>
								<td width="11%"><strong>星期六</strong></td>
								<td width="11%"><strong>星期日</strong></td>
							</tr>
							<logic:iterate id="bean" name="IGWIM02011VO" property="dateList" indexId="dataListIndex">
							<c:if test="${dataListIndex==8 }">
								<c:set var="data8" value="${bean}"></c:set>
							</c:if>
							</logic:iterate>
							<logic:iterate id="data" property="dateToWeekYearList" name="IGWIM02011VO" indexId="dataIndex">
								<c:if test="${dataIndex==0 }">
									<c:set var="data0" value="${data}"></c:set>
								</c:if>
								<c:if test="${dataIndex==1 }">
									<c:set var="data1" value="${data}"></c:set>
								</c:if>
								<c:if test="${dataIndex==2 }">
									<c:set var="data2" value="${data}"></c:set>
								</c:if>
								<c:if test="${dataIndex==3 }">
									<c:set var="data3" value="${data}"></c:set>
								</c:if>
								<c:if test="${dataIndex==4 }">
									<c:set var="data4" value="${data}"></c:set>
								</c:if>
								<c:if test="${dataIndex==5 }">
									<c:set var="data5" value="${data}"></c:set>
								</c:if>
								<c:if test="${dataIndex==6 }">
									<c:set var="data6" value="${data}"></c:set>
								</c:if>
							</logic:iterate>
						<logic:present name="IGWIM02011VO" property="wiList" >
			               <logic:iterate id="bean" name="IGWIM02011VO" property="wiList" indexId="index">
							<tr class="<ig:rowcss index="${index}"/>">
							<td>
								<!-- 超时提醒图标显示在工作名称前  wangliang 2017年8月5日-->
								<c:set var="sign" value="0"></c:set>	<!-- 定义是否显示超时提醒图标标识（0：不显示，1：显示） -->	
								<logic:iterate id="overTimes" name="IGWIM02011VO" property="dateToWeekYearList" indexId="idx">
									<c:if test="${overTimes>=bean.overtime}">
										<c:set var="sign" value="1"></c:set>	
									</c:if>
								</logic:iterate>
								<c:if test="${sign==1 }">
									<img alt="超时提醒" src="images/wim/overtime1.png" >
								</c:if>
								<!-- 超时提醒图标显示在工作名称前  wangliang 2017年8月5日-->
 							
								${bean.wdname}&nbsp;&nbsp;&nbsp;
							<!-- 查看 -->
							<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
<!-- 							<a href="javascript:void(0)" onclick="cycleWorkLook('${bean.wiid}')">${bean.wistatus}</a> -->
							<!-- 处理 ,如果当前登录人为负责人或者科技部领导，则可以点击查看-->
								<c:if test="${powerUserid!=bean.leaderid}">
								<!-- ${bean.wistatus} -->
								<!-- 如果是普通用户，则只能查看状态，不能点击 -->
								<c:if test="${permission=='3' }">
								${bean.wistatus}
								</c:if>
								<!-- 如果是科技领导和中心负责人 -->
								<c:if test="${permission!='3' }">
									<a href="javascript:void(0)" onclick="cycleWorkLook('${bean.wiid}')">${bean.wistatus}</a>
								</c:if>
								</c:if>
								<c:if test="${powerUserid==bean.leaderid}">
									<a href="javascript:void(0)" onclick="cycleWorkLook('${bean.wiid}')">${bean.wistatus}</a>
								</c:if>
							</c:if>
							<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
							<!-- 处理 ,如果当前登录人为负责人或者科技部领导，则可以点击查看-->
								<c:if test="${powerUserid!=bean.leaderid}">
								<!-- ${bean.wistatus} -->
								<!-- 如果是普通用户，则只能查看状态，不能点击 -->
								<c:if test="${permission=='3' }">
								${bean.wistatus}
								</c:if>
								<!-- 如果是科技领导和中心负责人 -->
								<c:if test="${permission!='3' }">
									<a href="javascript:void(0)" onclick="cycleWorkLook('${bean.wiid}')">${bean.wistatus}</a>
								</c:if>
								</c:if>
								<c:if test="${powerUserid==bean.leaderid}">
									<a href="javascript:void(0)" onclick="cycleWork('${bean.wiid}')">${bean.wistatus}</a>
								</c:if>
							</c:if>
							</td>
							<td>
							<c:if test="${data0<=data8}">
							<!-- 当前日期，大于开始时间，否则显示空白  并且发起日期等于日期栏日期-->
							<c:if test="${data0>=bean.begindate&&data0>=bean.crtDate}">
								<c:if test="${bean.week1==0}">
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data0<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>	
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									未执行
									</c:if>							
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">	
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
										<span style="display: block;line-height: 21px;float:left;width:70px;text-align:right;"><a href="javascript:void(0)" onclick="todayWork('${bean.wiid}','${data0}')">未执行</a></span>
										<c:if test="${data0>=bean.overtime}">
											<img alt="超时提醒" src="images/wim/overtime1.png" >
										</c:if>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data0<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>								
									</c:if>
								</c:if>
								<c:if test="${bean.week1!=0}">
								<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data0<=bean.confirmdate }">
									已执行
									</c:if>
									</c:if>
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									已执行
									</c:if>	
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">	
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data0}')">已执行</a>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data0<=bean.confirmdate }">
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data0}')">已执行</a>
									</c:if>
									</c:if>								
									</c:if>
								</c:if>
							</c:if>
							</c:if>
							</td>
							<td>
							<c:if test="${data1<=data8}">
							<!-- 当前日期，大于开始时间，否则显示空白 -->
							<c:if test="${data1>=bean.begindate&&data1>=bean.crtDate}">
								<c:if test="${bean.week2==0}">
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									未执行
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data1<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>	
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									<span style="display: block;line-height: 21px;float:left;width:70px;text-align:right;"><a href="javascript:void(0)" onclick="todayWork('${bean.wiid}','${data1}')">未执行</a></span>
										<c:if test="${data1>=bean.overtime}">
<!-- 											<img alt="超时提醒" src="images/wim/overtime1.png" > -->
										</c:if>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data1<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>	
									</c:if>
								</c:if>
								<c:if test="${bean.week2!=0}">
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									已执行
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data1<=bean.confirmdate }">
									已执行
									</c:if>
									</c:if>	
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data1}')">已执行</a>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data1<=bean.confirmdate }">
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data1}')">已执行</a>
									</c:if>
									</c:if>	
									</c:if>
								</c:if>
							</c:if>
							</c:if>
							</td>
							<td>
							<c:if test="${data2<=data8}">
							<!-- 当前日期，大于开始时间，否则显示空白 -->
							<c:if test="${data2>=bean.begindate&&data2>=bean.crtDate }">
								<c:if test="${bean.week3==0}">
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									未执行
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data2<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>	
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									<span style="display: block;line-height: 21px;float:left;width:70px;text-align:right;"><a href="javascript:void(0)" onclick="todayWork('${bean.wiid}','${data2}')">未执行</a></span>
										<c:if test="${data2>=bean.overtime}">
<!-- 											<img alt="超时提醒" src="images/wim/overtime1.png" > -->
										</c:if>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data2<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>	
									</c:if>
								</c:if>
								<c:if test="${bean.week3!=0}">
								<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">
								<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">									
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data2}')">已执行</a>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data2<=bean.confirmdate }">
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data2}')">已执行</a>
									</c:if>
									</c:if>	
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">	
									已执行
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data2<=bean.confirmdate }">
									已执行
									</c:if>
									</c:if>
									</c:if>
								</c:if>
							</c:if>
							</c:if>
							</td>	
							<td>
							<c:if test="${data3<=data8}">
							<!-- 当前日期，大于开始时间，否则显示空白 -->
							<c:if test="${data3>=bean.begindate&&data3>=bean.crtDate }">
								<c:if test="${bean.week4==0}">
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									未执行
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data3<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									<span style="display: block;line-height: 21px;float:left;width:70px;text-align:right;"><a href="javascript:void(0)" onclick="todayWork('${bean.wiid}','${data3}')">未执行</a></span>
										<c:if test="${data3>=bean.overtime}">
<!-- 											<img alt="超时提醒" src="images/wim/overtime1.png" > -->
										</c:if>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data3<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>	
									</c:if>
								</c:if>
								<c:if test="${bean.week4!=0}">
								<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">									
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data3}')">已执行</a>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data3<=bean.confirmdate }">
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data3}')">已执行</a>
									</c:if>
									</c:if>	
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">	
									已执行
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data3<=bean.confirmdate }">
									已执行
									</c:if>
									</c:if>
									</c:if>
								</c:if>							</c:if>
							</c:if>
							</td>	
							<td>
							<c:if test="${data4<=data8}">
							<!-- 当前日期，大于开始时间，否则显示空白 -->
							<c:if test="${data4>=bean.begindate&&data4>=bean.crtDate }">
								<c:if test="${bean.week5==0}">
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									未执行
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data4<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									<span style="display: block;line-height: 21px;float:left;width:70px;text-align:right;"><a href="javascript:void(0)" onclick="todayWork('${bean.wiid}','${data4}')">未执行</a></span>
										<c:if test="${data4>=bean.overtime}">
<!-- 											<img alt="超时提醒" src="images/wim/overtime1.png" > -->
										</c:if>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data4<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>	
									</c:if>
								</c:if>
								<c:if test="${bean.week5!=0}">
								<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">									
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data4}')">已执行</a>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data4<=bean.confirmdate }">
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data4}')">已执行</a>
									</c:if>
									</c:if>	
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">	
									已执行
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data4<=bean.confirmdate }">
									已执行
									</c:if>
									</c:if>
									</c:if>
								</c:if>	
							</c:if>
								</c:if>
							</td>	
							<td>
							<c:if test="${data5<=data8}">
							<!-- 当前日期，大于开始时间，否则显示空白 -->
							<c:if test="${data5>=bean.begindate&&data5>=bean.crtDate }">
								<c:if test="${bean.week6==0}">
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data5<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>	
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									未执行
									</c:if>	
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									<span style="display: block;line-height: 21px;float:left;width:70px;text-align:right;"><a href="javascript:void(0)" onclick="todayWork('${bean.wiid}','${data5}')">未执行</a></span>
										<c:if test="${data5>=bean.overtime}">
<!-- 											<img alt="超时提醒" src="images/wim/overtime1.png" > -->
										</c:if>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data5<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>									
									</c:if>
								</c:if>
								<c:if test="${bean.week6!=0}">
								<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">									
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data5}')">已执行</a>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data5<=bean.confirmdate }">
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data5}')">已执行</a>
									</c:if>
									</c:if>	
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">	
									已执行
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data5<=bean.confirmdate }">
									已执行
									</c:if>
									</c:if>
									</c:if>
								</c:if>							
							</c:if>
								</c:if>
							</td>
							<td>							
							<c:if test="${data6<=data8}">
							<!-- 当前日期，大于开始时间，否则显示空白 -->
							<c:if test="${data6>=bean.begindate&&data6>=bean.crtDate}">
								<c:if test="${bean.week7==0}">
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data6<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>	
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									未执行
									</c:if>	
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">
									<span style="display: block;line-height: 21px;float:left;width:70px;text-align:right;"><a href="javascript:void(0)" onclick="todayWork('${bean.wiid}','${data6}')">未执行</a></span>
										<c:if test="${data6>=bean.overtime}">
<!-- 											<img alt="超时提醒" src="images/wim/overtime1.png" > -->
										</c:if>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data6<=bean.confirmdate }">
									未执行
									</c:if>
									</c:if>	
									</c:if>
								</c:if>
								<c:if test="${bean.week7!=0}">
								<c:if test="${fn:contains(bean.excutorid, powerUserid)==true}">
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">									
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data6}')">已执行</a>
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data6<=bean.confirmdate }">
									<a href="javascript:void(0)" onclick="todayWorkLook('${bean.wiid}','${data6}')">已执行</a>
									</c:if>
									</c:if>	
									</c:if>
									<c:if test="${fn:contains(bean.excutorid, powerUserid)==false}">
									
									<c:if test="${bean.wistatus != '结束' and bean.wistatus != '终止'}">	
									已执行
									</c:if>
									<c:if test="${bean.wistatus == '结束' or bean.wistatus == '终止'}">
									<c:if test="${data6<=bean.confirmdate }">
									已执行
									</c:if>
									</c:if>
									</c:if>
								</c:if>							
							</c:if>
								</c:if>
							</td>
						</tr>
						
						</logic:iterate>
					</logic:present>
					</table>
				</div>
				<div id="operate">
				
	             <jsp:include page="/include/paging.jsp" />
                </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
<script type="text/javascript">
//查询的校验
function onSearch(){
	if(!jQuery("#workDate").val()){
		alert("请输入工作时间！");
		return false;
	}
	return true;
}
//周期工作确认
function cycleWork(wiid){
	openSubWindow('/IGWIM0201_Cycle_Init.do?wiid='+wiid+'&openFlag=1', '_blank','1000','600');
}
//周期工作查看
function cycleWorkLook(wiid){
	openSubWindow('/IGWIM0201_Cycle_Init.do?wiid='+wiid+'&lookFlag=1', '_blank','1000','600');
}
//当日工作确认
function todayWork(wiid,titleDate){
	openSubWindow('/IGWIM0201_Today_Init.do?wiid='+wiid+'&titleDate='+titleDate+'&openFlag=1', '_blank','1000','600');
}
//当日工作确认过了，查看
function todayWorkLook(wiid,titleDate){
	openSubWindow('/IGWIM0201_Today_Init.do?wiid='+wiid+'&titleDate='+titleDate+'&lookFlag=1', '_blank','1000','600');
}
//标识
var sign = true;
jQuery(document).ready(function(){
	
	//选机构级联用户
	jQuery("#orgsyscoding").change(function () {
	    var orgsyscoding = jQuery(this).children('option:selected').val();
	    jQuery("#userid option").remove();
	    jQuery("#userid").append(jQuery("#tempSelect option[aa='"+orgsyscoding+"']").clone());
	});
	//初始化进页面，机构，人默认自己
	if('${myorg}'){
		jQuery("#orgsyscoding option[value="+'${myorg}'+"]").attr("selected","selected");
		//筛选人--开始
		jQuery("#userid option").remove();
		jQuery("#userid").append(jQuery("#tempSelect option[aa='"+'${myorg}'+"']").clone());
		//筛选人--结束
		//人设成自己
// 		jQuery("#userid option[value="+'${myuserid}'+"]").attr("selected","selected");
// 		jQuery("#userid").val("");
	}else{
		//查询条件给带回去
		jQuery("#orgsyscoding option[value="+'${IGWIM0201Form.orgsyscoding}'+"]").attr("selected","selected");
		//筛选人--开始
		var orgsyscoding = jQuery("#orgsyscoding option:selected").val();
		jQuery("#userid option").remove();
		jQuery("#userid").append(jQuery("#tempSelect option[aa='"+orgsyscoding+"']").clone());
		//筛选人--结束
		jQuery("#userid option[value="+'${IGWIM0201Form.userid}'+"]").attr("selected","selected");
	}
		jQuery("#workDate").val('${IGWIM0201Form.workDate}');

});

</script>
</body>
</html:html>