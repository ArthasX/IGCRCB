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
<bean:define id="id" value="IGSVC0636" toScope="request" />
<bean:define id="title" value="部门服务统计画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
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
        <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
    </div>
     <div id="search">
 <html:form styleId="form" action="/IGSVC0636" onsubmit="return checkSubmit(this);">
         <div class="img"></div>
          <div class="conditions">
      <div>
     	 <span>年：</span>
		<html:select property="year" name="IGSVC0636Form">
			<ig:optionsCollection ccid="YEAR_CODE" isMakeBlankRow="false"/>
		</html:select>
		&nbsp;&nbsp;
		<span>月：</span>
		<html:select property="month" name="IGSVC0636Form">
			<ig:optionsCollection ccid="MONTH_CODE" isMakeBlankRow="false"/>
		</html:select>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<html:submit styleClass="button">查询</html:submit>
       </div>
      </div>
    </html:form>
    </div>
        
     
     <div id="results_list">
     <ig:message />
      	 <table  class="table_style" id="caseListTable">
      	 	<tr>
      	 		<th width="20%">部门</th>
      	 		<th width="20%">故障</th>
      	 		<th width="20%">服务请求</th>
      	 		<th width="20%">工单</th>
      	 		<th width="20%">汇总</th>
      	 	</tr>
      	 	<logic:present name="IGSVC06361VO" property="organizationServiceList">
      	 		<logic:iterate id="bean" name="IGSVC06361VO" property="organizationServiceList">
      	 			<tr>
      	 				<td>${bean.orgname }</td>
      	 				<td>${bean.incidentCount }</td>
      	 				<td>${bean.serviceCount }</td>
      	 				<td>${bean.gdCount }</td>
      	 				<td><span class="red">${bean.totalCount }</span></td>
      	 			</tr>
      	 		</logic:iterate>
      	 		<tr>
      	 			<td><span class="red">总计</span></td>
      	 			<td><span class="red">${IGSVC06361VO.icount }</span></td>
      	 			<td><span class="red">${IGSVC06361VO.scount }</span></td>
      	 			<td><span class="red">${IGSVC06361VO.gcount }</span></td>
      	 			<td><span class="red">${IGSVC06361VO.totalCount }</span></td>
      	 		</tr>
      	 	</logic:present>
      	 </table>
     </div>
     <div id="operate">
	</div>
</div>
</div>
  </div>
</div>
</body>
</html:html>