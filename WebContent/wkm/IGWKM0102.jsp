<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.wkm.vo.IGWKM01011VO"%>
<%@ page import="java.util.Map"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<%
IGWKM01011VO vo = (IGWKM01011VO) request.getAttribute("vo");
Map<String,String> nameURLMap = null;
if(vo != null){
	nameURLMap = vo.getNameURLMap();
}
%>
<html:html>
<bean:define id="id" value="IGWKM0102" toScope="request" />
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
<html:form action="/IGWKM0102" styleId="form" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">流程管理 &gt;&gt; 工作管理 &gt;&gt; 本月工作</p>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<tr>
			<th width="3%"></th>
			<th width="10%">工单号
			</th>
			<th width="16%">名称
			</th>
			<th width="12%">类别
			</th>
			<th width="11%">类型
			</th>
			<th width="7%">发起者
			</th>
			<th width="12%">发起时间
			</th>
			<th width="12%">关闭时间
			</th>
			<th width="10%">状态
			</th>
			<th width="7%">影响程度
			</th>
			
		</tr>
		<logic:present name="IGWKM01011VO" property="processList">
			<logic:iterate id="bean" name="IGWKM01011VO" property="processList"
				indexId="index">
				<bean:define id="prtype" name="bean" property="prtype" />
				<tr  onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" onclick="doLook('<%=nameURLMap.get(prtype) %>${bean.prid}&bkmode=1');" >
					<td>
					<logic:notEmpty name="bean" property="prurgency">

						 <img
							src="images/<bean:write name="bean" property="prurgency" />.gif" alt="紧急程度：<ig:codeValue ccid="${bean.prtype}URGENCY_GRADE_CODE"
							cid="${bean.prurgency}" />"
							border="0" />
					</logic:notEmpty>
					</td>
					
					<td><bean:write name="bean" property="prserialnum" />
					</td>
					<td><bean:write name="bean"
						property="prtitle" />
					</td>
					<td>
					<logic:equal name="bean" property="prtype"  value="<%=IGPROCESSType.NEW_WORK_PRTYPE_1 %>">
						指派工作
					</logic:equal>
					<logic:equal name="bean" property="prtype"  value="<%=IGPROCESSType.NEW_WORK_PRTYPE_2 %>">
						个人工作
					</logic:equal>
					<logic:equal name="bean" property="prtype"  value="<%=IGPROCESSType.SELF_DEFINING_WORK_PRTYPE %>">
						自定义工作
					</logic:equal>
					<logic:equal name="bean" property="prtype"  value="<%=IGPROCESSType.SKILL_SUPPORT_PRTYPE %>">
						技术支持
					</logic:equal>
					</td>
					<td>
					<bean:write name="bean" property="prpdname" />
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
					<td>	
						<logic:equal value="WD" name="bean" property="prtype">
						<ig:processDefineTypeValue prid="${bean.prid}"/>
						<logic:equal value="C" property="prsubstatus" name="bean">(中止)</logic:equal>
						</logic:equal>
						<logic:notEqual value="WD" name="bean" property="prtype">
						    <logic:notEqual value="" property="prsubstatus" name="bean">
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />(<ig:codeValue ccid="${bean.prtype}SUB" cid="${bean.prsubstatus}"/>)
							</logic:notEqual>
							<logic:equal value="" property="prsubstatus" name="bean">
								<ig:codeValue ccid="${bean.prtype}" cid="${bean.prstatus}" />
							</logic:equal>
						</logic:notEqual>
					</td>
					<td>
						<ig:codeValue ccid="IMPACT_GRADE_CODE"
							cid="${bean.primpact}" />

					</td>
				
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>
