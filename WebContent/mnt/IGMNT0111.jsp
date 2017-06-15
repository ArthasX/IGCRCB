<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGMNT0111" toScope="request"/>
<bean:define id="title"  toScope="request">
<bean:message bundle="mntResources" key="ietitle.IGMNT0111"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	</script>
<body >
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
<div id="contentWrap">
      

    <div id="location">
        <div class="image"></div>
        <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
    </div>
    <div>
		<div id="results_list">
               <!--  message -->
               <ig:message/>
               <!--  /message -->  
		<fieldset>
		<legend><bean:message bundle="mntResources" key="navigation.IGMNT0107.asmsearch"/></legend>   
		<table width="80%" class="table_style">
	            <!-- header部 -->
	                <tr>
                        <th width="7%"><bean:message bundle="mntResources" key="title.IGMNT0107.mtId"/></th> 
                        <th width="15%"><bean:message bundle="mntResources" key="title.IGMNT0107.mtSsn" /></th> 
                        <th width="8%"><bean:message bundle="mntResources" key="title.IGMNT0107.mtCname"/></th>
                        <th width="10%"><bean:message bundle="mntResources" key="title.IGMNT0107.mtKpi"/></th>
                        <th width="30%"><bean:message bundle="mntResources" key="title.IGMNT0107.mtoName"/></th>
                        <th width="14%"><bean:message bundle="mntResources" key="title.IGMNT0107.mtStartTime"/></th>
                        <th width="7%"><bean:message bundle="mntResources" key="title.IGMNT0107.mtInterval"/></th>
                        <th width="7%"><bean:message bundle="mntResources" key="title.IGMNT0107.mtSearCurve"/></th>
	                </tr>
	       
	            <!-- body部 -->
	       
	                <logic:present name="IGMNT01071VO" property="soc0304List" >
	                <bean:size id="size" name="IGMNT01071VO" property="soc0304List"/>
	                    <c:if test="${size==0}"><tr><td colspan="8"><strong><bean:message bundle="mntResources" key="message.IGMNT0111.001"/></strong></td></tr></c:if>
	                    <logic:iterate id="bean" name="IGMNT01071VO" property="soc0304List" indexId="index">
	                       <tr class="<ig:rowcss index="${index}"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');">
	                        	<!-- 监控任务ID-->
								<td>
								${bean.mtId}
								</td>
								<!--存储序列号 -->
								<td>
								${bean.mtSsn}
								</td>
								<!-- 组件类别-->
								<td>
								${bean.mtCname}
								</td>
								<!-- KPI-->
								<td>
								${bean.mtKpi}
								</td>
								<!-- 对象名称-->
								<td>
								${bean.mtObjNames}
								</td>
								<!-- 开始时间-->
								<td>
								${bean.mtStartTime}
								</td>
								<!-- 采集间隔-->
								<td>
								${bean.mtInterval}
								</td>
								<!-- 采集次数
								<td>
								${bean.mtNum}
								</td>
								-->
								<!-- 查看曲线-->
								<td>
								<c:if test="${bean.mtUserId==IGMNT01071VO.userId}">
								<html:link action="/IGMNT0108_Disp.do?mtId=${bean.mtId}&isExitFlag=0" target="_blank">
								<img src="images/chart_curve.png" width="16" height="16" border="0" alt="<bean:message bundle="mntResources" key="img.IGMNT0104.sear.alt" />"/>
								</html:link>
								</c:if>
								<c:if test="${bean.mtUserId!=IGMNT01071VO.userId}">
								<html:link action="/IGMNT0108_Disp.do?mtId=${bean.mtId}&isExitFlag=1" target="_blank">
								<img src="images/chart_curve.png" width="16" height="16" border="0" alt="<bean:message bundle="mntResources" key="img.IGMNT0104.sear.alt" />"/>
								</html:link>
								</c:if>
								</td>
	                        </tr>
	                    </logic:iterate>
	                </logic:present>
	       </table>
	       </fieldset>
		</div>
		</div>
</div>
<div class="zishiying"></div>

</div>
</div>
</body>
</html:html>