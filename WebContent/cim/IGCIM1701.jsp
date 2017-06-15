<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM1701" toScope="request"/>
<bean:define id="title" value="表空间预警查询" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 	<div id="location">
                <div class="image"></div>
                  <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
     </div> 

    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
			<div id="search">
				<div class="img"></div>
					<html:form action="IGCIM1701" method="POST">
				<div class="conditions">
					<html:hidden property="warnType" value="3"/>
					<table>
						<tr>
							<td>表空间名称:</td>
							<td><html:text property="logName"/> 
							</td>
							<td>CI类型:</td>
							<td>
								<html:select property="ciType">
									<html:option value=""> </html:option>
									<html:optionsCollection name="IGCIM17011VO" property="ciTypes" label="impTypename" value="impTypeid"/>
								</html:select>
								<html:hidden property="warnType" value="3"/>
							</td>
							
							<td>记录时间:从</td>
							<td><html:text property="sDate" styleClass="txtDate" styleId = "txtSdate" size="12" readonly="true" /><img src="images/date.gif" align="middle" onClick="calendar($('sDate'))" border="0"/>&nbsp;&nbsp;
							到 <html:text property="eDate" styleClass="txtDate" styleId="txtEdate" size="12" readonly="true" /><img src="images/date.gif" align="middle" onClick="calendar($('eDate'))" border="0"/>&nbsp;&nbsp;</td>
							<td><html:submit  styleClass="button" value="查询"/></td>
						</tr>
					</table>
		        </div>
					</html:form>
		    </div>
		    <div id="results_list">
			<!--  message -->
				<ig:message/>
			<!--  /message -->     
	       <table width="100%" class="table_style">
	       	<tr>
	       		<th width="5%">序号</th>
	       		<th width="10%">表空间名称</th>
	       		<th width="12%">CI类型</th>
	       		<th width="8%">总大小</th>
	       		<th width="8%">已使用</th>
	       		<th width="8%">剩余</th>
	       		<th width="8%">使用率</th>
	       		<th width="19%">预警信息</th>
	       		<th width="12%">预警时间</th>
	       	</tr>
	       	 <logic:present name="IGCIM17011VO" property="soc0153List" >
	       	 	<logic:iterate id="bean" name="IGCIM17011VO" property="soc0153List" indexId="index">
	       	 		<tr>
	       	 			<td>${PagingDTO.viewStartCount+index}</td>
	       	 			<td>${bean.logName}</td>
	       	 			<td>${bean.soc0113TB.impTypename }</td>
	       	 			<td>${bean.totalSize }</td>
	       	 			<td>${bean.userSize }</td>
	       	 			<td>${bean.surplusSize }</td>
	       	 			<td>${bean.userRatio }</td>
	       	 			<td title="${bean.logContent }"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.logContent }</div></td>
	       	 			<td>${bean.logDate }</td>
	       	 			
	       	 		</tr>
	       	 	</logic:iterate>
	       	 	
	       	 </logic:present>
	       </table>
		 </div>
		<div id="operate">
			 <!-- paging -->
				<jsp:include page="/include/paging.jsp"/>
			 <!-- /paging -->
		</div>
    </div>
</div>


</div>
	<script type="text/javascript">	
	
	</script>

</body>
</html:html>