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
<bean:define id="id" value="IGSMR0308" toScope="request" />
<bean:define id="title" value="更多" toScope="request" />
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
                <p class="fonts1">监管报表</p>
            </div>
<html:form action="/IGSMR0304_DISP" styleId="form" >
        	<div id="results_list">
        <table class="table_style" > 
        <tr> 
             <th width="18%">报表组名</th>
                <th width="24%" align="left">报表名</th>
                <th width="15%">处理人</th>
                <th width="14%">发起人</th>
                <th width="15%">填报时间限制</th>
                <th width="14%">状态</th>
           </tr>
	       <logic:present name="IGSMR03041VO" property="map_more">
			<logic:iterate id="map_more" name="IGSMR03041VO" property="map_more">
			<bean:define id="reportdesc" name="map_more" property="key"/>
			<bean:define id="list" name="map_more" property="value"/>
			<bean:size id="listsize" name="list"/>
			<logic:iterate id="info" name="list" indexId="index">
			<tr> 
			<c:if test="${index==0 }">	 
			<td rowspan="${listsize}" valign="middle">
			${reportdesc}
			</td>
			</c:if>
			<td align="left">
			<logic:present name="info" property="flag">
			<html:link action="/IGPRR0102_Disp.do?prtype=WD1&prid=${info.prid}&jump=96" style="text-decoration:underline;">
		 		${info.prtitle}(报送空表)
		 		</html:link>
		 		</logic:present>
		 		<logic:notPresent name="info" property="flag">
			<html:link action="/IGPRR0102_Disp.do?prtype=WD1&prid=${info.prid}&jump=96" style="text-decoration:underline;">
		 		${info.prtitle}
		 		</html:link>
		 		</logic:notPresent>
			</td>
			<td>
			<ig:ProcessParticipantForStatusWriteTag prid="${info.prid }" prstatus="${info.prstatus }"/>
			</td>
			<td >
			${info.username }
			</td>
			<td >
			${info.limittime }
			</td>
			<td >
			${info.psdname }
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