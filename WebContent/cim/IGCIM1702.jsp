<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM1702" toScope="request"/>
<bean:define id="title" value=" 新增用户预警查询" toScope="request"/>

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
			<html:form action="IGCIM1702" method="POST">
				<div class="img"></div>
				<div class="conditions">
						数据库名称:<html:text property="logName" size="15"/> 
						CI类型:<html:select property="ciType">
									<html:option value=""> </html:option>
									<html:optionsCollection name="IGCIM17021VO" property="ciTypes" label="impTypename" value="impTypeid"/>
								</html:select>
								<html:hidden property="warnType" value="4"/>&nbsp;&nbsp;
						服务器IP:<html:text property="serverIP" size="15"></html:text>&nbsp;&nbsp;&nbsp;
					
						记录时间:从<html:text property="sDate" styleClass="txtDate" styleId = "txtSdate" size="12" readonly="true" /><img src="images/date.gif" align="middle" onClick="calendar($('sDate'))" border="0"/>&nbsp;&nbsp;
							到 <html:text property="eDate" styleClass="txtDate" styleId="txtEdate" size="12" readonly="true" /><img src="images/date.gif" align="middle" onClick="calendar($('eDate'))" border="0"/>&nbsp;&nbsp;
							<html:submit  styleClass="button" value="查询"/>
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
	       		<th width="12%">数据库名称</th>
	       		<th width="12%">CI类型</th>
	       		<th width="10%">服务器IP</th>
	       		<th width="10%">预警类型</th>
	       		<th width="24%">预警信息</th>
	       		<th width="12%">预警时间</th>
	       	</tr>
	       	 <logic:present name="IGCIM17021VO" property="soc0153List" >
	       	 
	       	 	<logic:iterate id="bean" name="IGCIM17021VO" property="soc0153List" indexId="index">
	       	 		<tr>
	       	 			<td>${PagingDTO.viewStartCount+index}</td>
	       	 			<td>${bean.logName}</td>
	       	 			<td>${bean.soc0113TB.impTypename}</td>
	       	 			<td>${bean.serverIP }</td>
	       	 			<td><ig:codeValue ccid="LOG_UPSTATUS" cid="${bean.logStatus }"/></td>
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