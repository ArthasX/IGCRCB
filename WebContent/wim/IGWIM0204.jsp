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
<bean:define id="id" value="IGWIM0204" toScope="request" />
<bean:define id="title" value="工作信息统计查询画面" toScope="request" />
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
          <html:form styleId="form" action="/IGWIM0201_Count" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                <p class="fonts1">流程管理 &gt;&gt; 工作管理 &gt;&gt; 工作统计分析</p>
            </div>
            <div id="search">
               <div class="img"></div>
               <div class="conditions">
                  <div style="margin-top:4px">
					<span class="subscribe">工作名称：</span>
					<html:text property="wdname" styleId="wdname"  errorStyleClass="inputError imeDisabled" />
					
					<span class="subscribe">周期：</span>
					<html:select property="cycle" styleId="cycle" style="width:75px">
						<html:option value="" ></html:option>
						<html:option value="day" >每日</html:option>
						<html:option value="week" >每周</html:option>
						<html:option value="month" >每月</html:option>
						<html:option value="quarter" >每季度</html:option>
						<html:option value="halfyear" >每半年</html:option>
						<html:option value="year" >每年</html:option>
					</html:select>
					
					<span class="subscribe">工作状态：</span>
					<html:select property="wistatus" styleId="wistatus" style="width:75px">
						<html:option value="" ></html:option>
						<html:option value="0" >未执行</html:option>
						<html:option value="1" >执行中</html:option>
						<html:option value="2" >已执行</html:option>
						<html:option value="3" >结束</html:option>
						<html:option value="4" >中止</html:option>
					</html:select>
					
					<span class="subscribe">发起人：</span>
					<html:text property="initiatorId" styleId="initiatorId"  errorStyleClass="inputError imeDisabled" />
					
					<html:submit property="btn_search" style="30-left:5px" styleClass="button" value="查询" onclick="onSearch()"/>
					<html:button property="btn_search" style="30-left:5px" styleClass="button" value="导出" onclick="onExport()"/>
                  </div>
                  
                  <div style="margin-top:12px">
					
					
					<span class="subscribe">负责人：</span>
					<html:text property="leaderName" styleId="leaderName"  errorStyleClass="inputError imeDisabled" />
					
					<span class="subscribe">执行人：</span>
					<html:text property="excutorName" styleId="excutorName"  errorStyleClass="inputError imeDisabled" />
					
					 <span class="subscribe">工作开始日期：</span>
                       <html:text property="begindate_from" styleId="begindate_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                       <img src="images/date.gif" align="middle" onClick="calendar($('begindate_from'))" border="0"/>
                     
                       <span>--</span>
                       <html:text property="begindate_to" styleId="begindate_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                       <img src="images/date.gif" align="middle" onClick="calendar($('begindate_to'))" border="0"/>
					
                  </div>
                    
              </div>
            </div>
                
                <div id="results_list">
					<ig:message />
                    <table class="table_style"  >
						<!-- header部 -->
							<tr>
								<th width="7%">工作名称</th>
								<th width="4%">周期</th>
								<th width="4%">发起人</th>
								<th width="4%">负责人</th>
								<th width="9%">执行人</th>
								<th width="5%">工作状态</th>
								<th width="8%">工作开始日期</th>
								<th width="8%">工作发起日期</th>
								<th width="6%">日期栏日期</th>
								<th width="8%">执行确认日期</th>
								<th width="7%">工作执行情况</th>
								<th width="5%">执行时间</th>	
								<th width="8%">执行情况描述</th>
							</tr>
						<logic:present name="IGWIM02011VO" property="wiList" >
			               <logic:iterate id="bean" name="IGWIM02011VO" property="wiList" indexId="index">
							<tr class="<ig:rowcss index="${index}"/>">
								<td>${bean.WDNAME}</td>
								<td>
									<c:choose>
										<c:when test="${bean.CYCLE=='day'}">
											每日
										</c:when>
										<c:when test="${bean.CYCLE=='week'}">
											每周
										</c:when>
										<c:when test="${bean.CYCLE=='month'}">
											每月
										</c:when>
										<c:when test="${bean.CYCLE=='quarter'}">
											每季度
										</c:when>
										<c:when test="${bean.CYCLE=='halfyear'}">
											每半年
										</c:when>
										<c:when test="${bean.CYCLE=='year'}">
											每年
										</c:when>
									</c:choose>
								</td>
								<td>${bean.INITIATORID}</td>
								<td>${bean.LEADERNAME}</td>
								<td>${bean.EXCUTORNAME}</td>
								<td>${bean.WISTATUS}</td>
								<td>${bean.BEGINDATE}</td>
								<td>${bean.CRTDATE}</td>
								<td>${bean.TITLEDATE}</td>
								<td>${bean.ACTUALDEALWITHDATE}</td>
								<td>${bean.BTNACTION}</td>
								<td>${bean.EXCUTETIME}</td>
								<td>${bean.WLDESCRIPTION}</td>
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
	document.forms[0].submit();
	return true;
}

function onExport(){
	var actionStr = document.forms[0].action;
	document.forms[0].action = getAppRootUrl() + "/IGWIM0201_Export.do";
	document.forms[0].submit();
	document.forms[0].action =  actionStr;
}

</script>
</body>
</html:html>