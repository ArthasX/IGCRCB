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
<bean:define id="id" value="IGWIM0205" toScope="request" />
<bean:define id="title" value="我的工作查询画面" toScope="request" />
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
          <html:form styleId="form" action="/IGWIM0201_FirstPage" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
                <div id="results_list">
					<ig:message />
                    <table class="table_style"  >
						<!-- header部 -->
							<tr>
								<th width="2%"></th>
								<th width="30%"><span style="color: #b90216">工作名称</span></th>
								<th width="15%"><span style="color: #b90216">负责人</span></th>
								<th width="15%"><span style="color: #b90216">周期</span></th>
								<th width="15%"><span style="color: #b90216">执行确认</span></th>
								<th width="15%"><span style="color: #b90216">发起时间</span></th>
							</tr>
						<logic:present name="IGWIM02011VO" property="wiList" >
			               <logic:iterate id="bean" name="IGWIM02011VO" property="wiList" indexId="index">
							<tr class="<ig:rowcss index="${index}"/>">
							 <td></td>
			            <td>${bean.wdname}
							<c:if test="${myuserid!=bean.leaderid}">${bean.wistatus}
								</c:if>
								<c:if test="${myuserid==bean.leaderid}">
									<a href="javascript:void(0)" onclick="cycleWork('${bean.wiid}')">${bean.wistatus}</a>
								</c:if>
						</td>
						<td>${bean.leadername}</td>
						<td>
						<c:if test="${bean.cycle == 'day'}">每日</c:if>
						<c:if test="${bean.cycle == 'week'}">每周</c:if>
						<c:if test="${bean.cycle == 'month'}">每月</c:if>
						<c:if test="${bean.cycle == 'quarter'}">每季度</c:if>
						<c:if test="${bean.cycle == 'halfyear'}">每半年</c:if>
						<c:if test="${bean.cycle == 'year'}">每年</c:if>
						</td>
						<td>
							<a href="javascript:void(0)" onclick="todayWork('${bean.wiid}','${titledate}')">未执行</a>
						</td>
						<td>${bean.crtdate}</td>
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

//周期工作确认
function cycleWork(wiid){
	openSubWindow('/IGWIM0201_Cycle_Init.do?wiid='+wiid+'&openFlag=3', '_blank','1000','600','center:1');
}
//当日工作确认
function todayWork(wiid,titleDate){
	openSubWindow('/IGWIM0201_Today_Init.do?wiid='+wiid+'&titleDate='+titleDate+'&openFlag=3', '_blank','1000','600','center:1');
}
</script>
</body>
</html:html>