<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.List" %>
<%@ page import="com.deliverik.framework.user.model.Organization" %>
<%@ page import="com.deliverik.framework.workflow.prr.model.IG160Info" %>
<%@ page import="com.deliverik.infogovernor.svc.vo.IGSVC05131VO" %>
<html:html>
<bean:define id="id" value="IGVIR1401" toScope="request" />
<bean:define id="title" value="资源申请统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<script type="text/javascript">
	function conmit(url){
		form.action = url;
		form.submit();
	}
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
        <p class="fonts1"><ig:navigation extname1="资源申请统计"/></p>
    </div>
	 <html:form styleId="form" action="/IGVIR1401.do" onsubmit="return checkSubmit(this);">
     <div id="search">
         <div class="img"></div>
          <div class="conditions">
       		<div>
       			<span>时间&nbsp;&nbsp;从：</span>
       			<html:text property="propentime_from" readonly="true" onclick="showDate(this);"/>
       			&nbsp;&nbsp;
       			<span>到：</span>
       			<html:text property="propentime_to" readonly="true" onclick="showDate(this);"/>
       			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       			<html:button property="button" styleClass="button" onclick="conmit('IGVIR1401.do');">查询</html:button>
       			&nbsp;&nbsp;
       			<html:button  property="button" styleClass="button" onclick="conmit('IGVIR1401_Export.do');">导出</html:button>
       		</div>
     	 </div>
    </div>
    <div id="results_list">
    	<table class="table_style">
    		<tr>
    			<th width="20%">部门名称</th>
    			<th width="20%">申请数量</th>
    			<th width="20%">未关闭数量</th>
    			<th width="20%">已关闭数量</th>
    			<th width="20%">虚机数量</th>
    		</tr>
    		<logic:present name="IGVIR14011VO" property="vmApplyStatisticsDataMap">
    			<logic:iterate id="map" name="IGVIR14011VO" property="vmApplyStatisticsDataMap">
    				<tr>
    					<td>${map.key }</td>
    					<logic:present name="map" property="value">
    						<logic:iterate id="count" name="map" property="value">
    							<td>${count }</td>
    						</logic:iterate>
    					</logic:present>
    				</tr>
    			</logic:iterate>
    		</logic:present>
    	</table>
   	</div>
	</html:form>
</div>
</div>
</div>
</div>
</body>
</html:html>