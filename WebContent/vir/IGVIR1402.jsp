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
<bean:define id="id" value="IGVIR1402" toScope="request" />
<bean:define id="title" value="资源使用情况统计" toScope="request" />
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
        <p class="fonts1"><ig:navigation extname1="资源使用情况统计"/></p>
    </div>
	 <html:form styleId="form" action="/IGVIR1402.do" onsubmit="return checkSubmit(this);">
     <div id="search">
         <div class="img"></div>
          <div class="conditions">
       		<div>
       			<span>vCenter名称：</span>
       			<html:select property="vcid" style="width:150px;">
       				<html:option value=""></html:option>
       				<logic:present name="AD_vcnames">
       					<html:options collection="AD_vcnames" property="value" name="" labelProperty="label"/>
       				</logic:present>
       			</html:select>
       			&nbsp;&nbsp;&nbsp;&nbsp;
       			<span>IP地址：</span>
       			<html:text property="hostname"/>
       			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
       			<html:button property="button" styleClass="button" onclick="conmit('IGVIR1402.do');">查询</html:button>
       			&nbsp;&nbsp;
       			<html:button property="button" styleClass="button" onclick="conmit('IGVIR1402_Export.do');">导出</html:button>
       		</div>
     	 </div>
    </div>
    <div id="results_list">
    	<table class="table_style">
    		<tr>
    			<th width="14%">HostIP</th>
    			<th width="12%">CPU个数</th>
    			<th width="12%">内存信息</th>
    			<th width="12%">存储信息</th>
    			<th width="12%">CPU使用率</th>
    			<th width="12%">内存使用率</th>
    			<th width="12%">存储使用率</th>
    			<th width="12%">虚机个数</th>
    		</tr>
    		<logic:present name="IGVIR14021VO" property="hostMap">
    			<logic:iterate id="map" name="IGVIR14021VO" property="hostMap">
    				<logic:present name="map" property="value">
    					<logic:iterate id="bean" name="map" property="value">
    						<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" style="cursor:hand;" onclick="doLook('IGVIR1201.do?hostname=${map.key}_${bean.name }');">
		    					<td>${bean.name }</td>
		    					<td>${bean.cpuCores }</td>
		    					<td>${bean.memoryMB }MB</td>
		    					<td>${bean.capacity }GB</td>
		    					<td>${bean.cpuUseRate }</td>
		    					<td>${bean.memoryUseRate }</td>
		    					<td>${bean.diskUseRate }</td>
		    					<td>${bean.vm_num }</td>
		    				</tr>
    					</logic:iterate>
    				</logic:present>
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