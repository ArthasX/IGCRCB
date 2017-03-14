<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGSMR0301" toScope="request" />
<bean:define id="title" value="我的填报" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> 

</style>
<script type="text/javascript">

</script>
<body>
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<!-- 新增加流程菜单 结束 -->
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />

<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
 <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation /></p>
            </div>
<html:form action="/IGSMR0301" styleId="form" >
        	<div id="results_list">
        <table class="table_style" > 
        <tr> 
              <th width="16%">年报说明</th>			 
			  <th width="16%">发起时间</th>
			  <th width="11%">发起人</th>
			  <th width="16%">填报限制时间</th>
			  <th width="26%" align="left">报表名</th>
			   <th width="15%">处理人</th>
           </tr>
	       <logic:present name="IGSMR03011VO" property="map_arq">
			<logic:iterate id="map_arq" name="IGSMR03011VO" property="map_arq">
			<bean:define id="reportdesc" name="map_arq" property="key"/>
			<bean:define id="list" name="map_arq" property="value"/>
			<bean:size id="listsize" name="list"/>
			<logic:iterate id="bean" name="list" >
			<bean:define id="inittime" value="${bean.inittime }"/>
			<bean:define id="username" value="${bean.username }"/>
			<bean:define id="limittime" value="${bean.limittime }"/>
			</logic:iterate>			
			<logic:iterate id="info" name="list" indexId="index">
			<tr> 
			<c:if test="${index==0 }">			 
			<td rowspan="${listsize}">
			${reportdesc}
			</td>
			<td rowspan="${listsize}">
			${inittime }
			</td>
			<td rowspan="${listsize}">
			${username }
			</td>
			<td rowspan="${listsize}">
			${limittime }
			</td>
			</c:if>	
			<td align="left">		
			<html:link action="/IGPRR0102_Disp.do?prtype=WD1&prid=${info.prid}&jump=84"  style="text-decoration:underline;">
		 		${info.prtitle}
		 	</html:link>
			</td>
			<td>
			<ig:ProcessParticipantForStatusWriteTag prid="${info.prid }" prstatus="${info.prstatus }"/>
			</td>
			</tr> 
			</logic:iterate>			                              
                </logic:iterate>
	        	</logic:present>
        </table> 
        </div>
</html:form>
</div></div></div>
</div>
</body>
</html:html>