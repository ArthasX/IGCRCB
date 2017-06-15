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
<html:html>
<bean:define id="id" value="IGCIM0805" toScope="request" />
<bean:define id="title" value="定时任务查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
	WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
	WebCalendar.format     = "yyyy/mm/dd";  //回传日期的格式
	WebCalendar.timeShow   = false;          //是否返回时间
	WebCalendar.drag       = true;          //是否允许拖动
	WebCalendar.darkColor  = "#014DB4";    //控件的暗色
	WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
	WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
	WebCalendar.wordColor  = "#000080";    //控件的文字颜色
	WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
	WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
	WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
	WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色        //是否返回时间
	
	function openEiWaitTaskDetail(uuid,servername,platformname){
	 	//IGAIM0210
	 	openSubWindow( '/IGCIM0806_INIT.do?uuid='+ uuid+'&servername='+servername+'&platformname='+platformname,'_blank','800','600');
	}

	function showHistory(uuid,servername){
		var url = "/IGCIM0807_Search.do?uuid="+uuid+"&disp=true&servername="+servername;
		openSubWindow(url, '_blank', '800', '600');	
	}

</script>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
          <html:form styleId="form" action="/IGCIM0805_Search" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">配置管理 &gt;&gt;配置采集&gt;&gt;定时任务查询</p>
            </div>
            <br/>
            <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                   <div>
			        <span>任务类型：</span>
			        <c:if test="${IGCIM13011VO.xmlFlag == 'yes'}">
				        <html:select property="typename" name="IGCIM0805Form">
				        	<html:option value=""></html:option>
				        	<logic:iterate id="name" name="IGCIM13011VO" property="typeNames">
				        		<html:option value="${name}">${name}</html:option>
				        	</logic:iterate>
				        </html:select>
			        </c:if>
			        <c:if test="${IGCIM13011VO.xmlFlag == 'no'}">
			        	<select>
			        		<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
			        	</select>
			        </c:if>
			        &nbsp;&nbsp;&nbsp;
			        <!-- 
			        <span>执行时间：</span><html:text property="starttime" styleId="starttime"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			        &nbsp;&nbsp;
			         -->
			        <span>计划执行时间：</span>
			        <html:text property="newstarttime" styleId="newstarttime"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			        <img src="images/date.gif" align="middle" onClick="calendar($('newstarttime'))" border="0"/>
			        &nbsp;&nbsp;&nbsp;
			        <span>状态：</span><html:select property="executstatus">
			        	<html:option value=""></html:option>
			        	<html:option value="1">启动</html:option>
			        	<html:option value="2">停止</html:option>
			        	<!--<html:option value="0">错误</html:option>-->
			        </html:select>&nbsp;&nbsp;&nbsp;
			        <c:if test="${IGCIM13011VO.xmlFlag == 'yes'}">
                    	<html:submit property="btn_search" styleClass="button" value="查询" />
                    </c:if>
                    <c:if test="${IGCIM13011VO.xmlFlag == 'no'}">
                    	<html:submit property="btn_search" styleClass="button" value="查询" disabled="true"/>
                    </c:if>
                   </div>
                   </div>
                </div>
                <br/>
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table class="table_style">
						<!-- header部 -->
						 
							<tr>
								<th width="5%">序号</th>
								<th width="15%">服务名</th>
								<th width="13%">平台名</th>
								<th width="13%">类型</th>
								<th width="11%">计划执行时间</th>
								<th width="11%">计划终止时间</th>
								<th width="11%">最新执行时间</th>
								<th width="11%">最新终止时间</th>
								<th width="5%">状态</th>
								<th width="5%">配置</th>
							</tr>
							<logic:present name="IGCIM13011VO" property="timerTaskList">
								<logic:iterate id="bean" name="IGCIM13011VO" property="timerTaskList" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">
										<!-- 序号 -->
										<td>
											<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
										</td>
										<td>
											<div class="nowrapDiv">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<a href="javascript:showHistory('${bean.uuid}','${bean.servername}')" >${bean.servername}</a></div>
										</td>
										<td>
											<div class="nowrapDiv">${bean.platformname }</div>
										</td>
										<td>
											<div class="nowrapDiv">${bean.typename }</div>
										</td>
										<td>
											<div class="nowrapDiv">${bean.starttime }</div>
										</td>
										<td>
											<div class="nowrapDiv">${bean.stoptime }</div>
										</td>
										<td>
											<div class="nowrapDiv">${bean.newstarttime }</div>
										</td>
										<td>
											<div class="nowrapDiv">${bean.newstoptime }</div>
										</td>
										<td align="center">
											<div class="nowrapDiv">
												<c:if test="${bean.executstatus == '0'}">错误</c:if>
												<c:if test="${bean.executstatus == '1'}"><img src="images/start.gif" border="0" alt="启动"/></c:if>
												<c:if test="${bean.executstatus == '2'}"><img src="images/stop.gif" border="0" alt="停用"/></c:if>
											</div>
										</td>
										<td>
											<div class="nowrapDiv">
												<a href="#" onclick="openEiWaitTaskDetail('${bean.uuid }','${bean.servername}','${bean.platformname }')"><img src="images/modify.png" alt='配置' width="16" height="16"  border="0"/></a>
												
											</div>
										</td>
									</tr>
								</logic:iterate>
							</logic:present>
							
						<!-- body部 -->
						</table>
				</div>
				<div id="operate" align="right">
	             <jsp:include page="/include/paging.jsp" />
                </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>