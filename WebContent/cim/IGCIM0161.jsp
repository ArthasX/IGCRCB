<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM0161" toScope="request"/>
<bean:define id="title" value="解析状况查询画面" toScope="request"/>

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
					<html:form action="IGCIM0161" method="POST">
				<div class="conditions">
					<table>
						<tr>
							<td>日志名称:</td>
							<td><html:text property="logName" style="width:100px"/> 
								<html:hidden property="warnType" value="2"/>
								</td>
							
							<td>CI类型:</td>
							<td>
								<html:select property="ciType">
									<html:option value=""> </html:option>
									<html:optionsCollection name="IGCIM01611VO" property="ciTypes" label="impTypename" value="impTypeid"/>
								</html:select>
								<html:hidden property="warnType" value="2"/>
								
							</td>
							<td>日志状态:</td>
							<td><html:select property="logStatus">
								 	<ig:optionsCollection ccid="LOG_STATUS" isMakeBlankRow="true" isCodeLabel="true"/>
								</html:select>
							</td>
							<td>记录时间:</td>
							<td>
							<html:text property="sDate" styleId="txtSdate" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
							<img src="images/date.gif" align="middle" onClick="calendar($('sDate'))" border="0"/>
							到
							<html:text property="eDate" styleId="txtEdate" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
							<img src="images/date.gif" align="middle" onClick="calendar($('eDate'))" border="0"/>
							</td>
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
	       		<th width="8%">序号</th>
	       		<th width="12%">日志名称</th>
	       		<th width="12%">CI类型</th>
	       		<th width="12%">服务器IP</th>
	       		<th width="10%">日志状态</th>
	       		<th width="16%">日志日期</th>
	       		<th width="30%">日志信息</th>
	       	</tr>
	       	 <logic:present name="IGCIM01611VO" property="soc0153List" >
	       	 	<logic:iterate id="bean" name="IGCIM01611VO" property="soc0153List" indexId="index">
	       	 		<tr>
	       	 			<td>${PagingDTO.viewStartCount+index}</td>
	       	 			<td>${bean.logName}</td>
	       	 			<td>${bean.soc0113TB.impTypename}</td>
	       	 			<td>${bean.serverIP }</td>
	       	 			<td><ig:codeValue ccid="LOG_STATUS" cid="${bean.logStatus }"/></td>
	       	 			<td>${bean.logDate }</td>
	       	 			<td title="${bean.logContent }" style="cursor: default;"><div style="width:100%; white-space:nowrap; text-overflow:ellipsis; overflow:hidden;">${bean.logContent }</div></td>
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