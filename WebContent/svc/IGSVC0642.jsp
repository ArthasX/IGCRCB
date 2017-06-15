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
<bean:define id="id" value="IGSVC0642" toScope="request" />
<bean:define id="title" value="流程数量统计" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->

<script type="text/javascript">
	function conmit(url){
		form.action = url;
		return true;
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
        <p class="fonts1"><ig:navigation extname1="故障类型统计"/></p>
    </div>
	 <html:form styleId="form" action="/IGSVC0642.do" onsubmit="return checkSubmit(this);">
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
       			<html:submit styleClass="button" onclick="return conmit('IGSVC0642.do');">查询</html:submit>
       			&nbsp;&nbsp;
       			<html:submit styleClass="button" onclick="return conmit('IGSVC0642_Export.do');">导出</html:submit>
       		</div>
     	 </div>
    </div>
    <div id="results_list">
    	<table class="table_style">
    		<tr>
    			<th width="25%"></th>
    			<th width="25%">事件</th>
    			<th width="25%">问题</th>
    			<th width="25%">变更</th>
    		</tr>
    		<logic:present name="IGSVC06421VO">
    			<tr>
    				<td>未关闭</td>
    				<td>${IGSVC06421VO.countI_E }</td>
    				<td>${IGSVC06421VO.countP_E }</td>
    				<td>${IGSVC06421VO.countC_E }</td>
    			</tr>
    			<tr>
    				<td>已关闭</td>
    				<td>${IGSVC06421VO.countI_C }</td>
    				<td>${IGSVC06421VO.countP_C }</td>
    				<td>${IGSVC06421VO.countC_C }</td>
    			</tr>
    			<tr>
    				<td><span class="red">总计</span></td>
    				<td><span class="red">${IGSVC06421VO.countI }</span></td>
    				<td><span class="red">${IGSVC06421VO.countP }</span></td>
    				<td><span class="red">${IGSVC06421VO.countC }</span></td>
    			</tr>
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