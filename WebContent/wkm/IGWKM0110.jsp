<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.infogovernor.wkm.vo.IGWKM01011VO"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG259Info"%>
<%@ page import="com.deliverik.framework.workflow.prd.model.IG380Info"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<html:html>
<bean:define id="id" value="IGWKM0110" toScope="request" />
<logic:notEmpty name="IGWKM0110Form" property="prtype" >
<bean:define id="type" name="IGWKM0110Form" property="prtype" />
</logic:notEmpty >
<bean:define id="title" value="工作查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<html:form action="/IGWKM0110" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation/></p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span>编号：&nbsp;&nbsp;</span>
		<html:text property="prserialnum" size="12" />
		<span>&nbsp;&nbsp;名称：</span>
		<html:text property="prtitle"/>
		<span>&nbsp;&nbsp;时间：从</span>
		<html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
		<span>&nbsp;&nbsp;到</span>
		<html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
		<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
	</div>
	<div>
	<span>发起者：</span>
		<html:text property="prusername" style="width:90px"/>
		<span>&nbsp;&nbsp;内容：</span>
		<span><html:text errorStyleClass="inputError imeActive" property="prdesc" size="40" /></span>&nbsp;&nbsp;
		<span>&nbsp;&nbsp;评估工作分类：</span>
		<html:select property="prtype" style="width: 100px;">
		<logic:present name="AD_pts" scope="session">
			<html:option value=""></html:option>
    		<html:options collection="AD_pts" property="value" labelProperty="label"/>
    	</logic:present>
    </html:select>
	<html:submit styleClass="button" value="查询" /></div>
	<html:hidden property="selectstatus" name="selectstatus" value="1"/>
	</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="2%"></th>
			<th width="2%"></th>
			<th width="8%"><a href="IGWKM0110.do?orderVal=prserialnum">编号
			<logic:equal name="IGWKM0110Form" property="order" value="prserialnum">
				<logic:equal name="IGWKM0110Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0110Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="18%"><a href="IGWKM0110.do?orderVal=prtitle">名称			
			<logic:equal name="IGWKM0110Form" property="order" value="prtitle">
				<logic:equal name="IGWKM0110Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0110Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			
			<th width="8%"><a href="IGWKM0110.do?orderVal=prusername">发起者
			<logic:equal name="IGWKM0110Form" property="order" value="prusername">
				<logic:equal name="IGWKM0110Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0110Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="10%"><a href="IGWKM0110.do?orderVal=propentime">发起时间
			<logic:equal name="IGWKM0110Form" property="order" value="propentime">
				<logic:equal name="IGWKM0110Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0110Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			<th width="10%"><a href="IGWKM0110.do?orderVal=prclosetime">关闭时间
			<logic:equal name="IGWKM0110Form" property="order" value="prclosetime">
				<logic:equal name="IGWKM0110Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0110Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
			
			<th width="12%"><a href="###">当前处理人</a></th>
			<th width="10%"><a href="IGWKM0110.do?orderVal=prstatus">状态
			<logic:equal name="IGWKM0110Form" property="order" value="prstatus">
				<logic:equal name="IGWKM0110Form" property="sing" value="ASC">
					<img src="images/timeup.gif" border="0">
				</logic:equal>
				<logic:equal name="IGWKM0110Form" property="sing" value="DESC">
					<img src="images/timedown.gif" border="0">
				</logic:equal>
			</logic:equal></a></th>
		</tr>
		<logic:present name="IGWKM01101VO" property="processList">
			<logic:iterate id="bean" name="IGWKM01101VO" property="processList"
				indexId="index">
				<bean:define id="prtype" name="bean" property="prtype" />
				
					<tr style='cursor:hand' bgcolor="<ig:ProcessOverdueLevelBgColorTag prid="${bean.prid }"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
					onclick="doLook(getAppRootUrl()+'/IGPRR0102_Disp.do?prid=<bean:write name="bean" property="prid" />&jump=10');">
					<td>
					<ig:ProcessInfoValueLevelImgTag pdname="${bean.prpdname}"  prid="${bean.prid}" />
					</td>
					<td>
						<ig:ProcessOverdueLevelImgTag prstatus="${bean.prstatus}" prid="${bean.prid}" />
					</td>
					<td><bean:write name="bean" property="prserialnum" />
					</td>
					<td><bean:write name="bean"
						property="prtitle" />
					</td>
					<td><bean:write name="bean"
						property="prusername" />
					</td>
					<td><bean:write name="bean"
						property="propentime" />
					</td>
					<td><bean:write name="bean"
						property="prclosetime" />
					</td>
					
					<td title="<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />">
						<ig:SubstringShowEllipsisWriteTag len="8" showEllipsis="true">
							<ig:ProcessParticipantForStatusWriteTag prstatus="${bean.prstatus }" prid="${bean.prid }" />
						</ig:SubstringShowEllipsisWriteTag>
						
					</td>
					<td>	
						<ig:processDefineTypeValue prid="${bean.prid}"/>
					</td>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	</html:form>
</div>
</div>
</div>


</div>
</body>
</html:html>
