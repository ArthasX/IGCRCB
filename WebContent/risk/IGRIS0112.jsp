<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<html:html>
<bean:define id="id" value="IGRIS0112" toScope="request" />
<bean:define id="title" value="审计人" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		var gid='IGRIS0112';
		function toback(){
	        form.action = getAppRootUrl() + "/IGRIS0109_Back.do";
	        form.submit();
	    }
	    
		function selectUser(pos){
			openSubWindow('/IGSYM0205_Disp.do?pos=' + pos, 'newpage', '800', '600');
		}
		
		function setParamUser(userid,username,pos){
			var check=document.getElementsByName("position");
			for(var i=0;i<check.length;i++){
				if(check[i].value == pos){
					document.getElementsByName("raruserid")[i].value = userid;
					$("rarusername[" + pos + "]").value = username;
					break;
				}
			}
		}

		function toRadDetail(radid){
	    	openSubWindow('/IGRIS0108_Disp.do?radid=' + radid, '_blank', '800', '600');
	    }
		<%Map<String,Integer> countMap = new HashMap<String,Integer>(); %>
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGRIS0112" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">服务管理 &gt;&gt; 风险审计 &gt;&gt; 审计人设定</p>
	<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
	</div>
	<div id="results_list">
	<ig:message/>
	<table class="table_style">
		<tr>
			<th width="10%">编号</th>
			<th width="70%" colspan="${IGRIS01121VO.radMaxLevel}">审计项目</th>
            <th width="20%">审计人</th>
		</tr>
		<logic:present name="IGRIS01121VO" property="riskAuditDefResultVWInfoList">
			<logic:iterate id="bean" name="IGRIS01121VO"
				property="riskAuditDefResultVWInfoList" indexId="index" type="com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo">
				<tr>
					<td align="left"><%String radparcode = bean.getRadparcode();
						if(countMap.containsKey(radparcode)) {
							countMap.put(radparcode,countMap.get(radparcode) + 1);
						} else {
							countMap.put(radparcode,1);
						}%><% String levelCode = countMap.get(radparcode).toString();
								int level = Integer.parseInt(bean.getRadlevel());
								for(int i = level - 1; i > 0; i--) {
									String parcode = radparcode.substring(0 , radparcode.length() -3);
									radparcode = radparcode.substring(0 , radparcode.length() -3);
									levelCode = countMap.get(parcode) + "." +levelCode;
								}
						%><%=levelCode%></td>
					<c:if test="${bean.radlevel > 1}">
					<logic:iterate id="count" name="IGRIS01121VO" property="radMaxLevelList" length="${bean.radlevel - 1}"><td width="10%">&nbsp;</td></logic:iterate>
					</c:if>
					<td colspan="${IGRIS01121VO.radMaxLevel - bean.radlevel + 1}" align="left"><logic:empty name="bean" property="radname">&nbsp;</logic:empty><html:link href="javascript:toRadDetail('${bean.radid}')">${bean.radname}</html:link>
						<html:hidden property="radid" styleId="radid" name="IGRIS0112Form" value="${bean.radid}"/>
						<html:hidden property="rarid" styleId="rarid" name="IGRIS0112Form" value="${bean.rarid}"/>
						<html:hidden property="raruserid" styleId="raruserid" name="IGRIS0112Form" value="${bean.raruserid}"/>
						<input type="hidden" name="position" value="${index}">
					</td>
					<td><html:text property="rarusername[${index}]" styleId="civalue" size="6" style="text-align: center" readonly="true" />
					<a href="javascript:void(0)" onclick="selectUser('${index}');"><img src="images/seek.gif" alt="查询" width="16" height="16" border="0" /></a>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	<logic:present name="IGRIS01121VO" property="riskAuditDefResultVWInfoList">
	<logic:notEmpty name="IGRIS01121VO" property="riskAuditDefResultVWInfoList">
	<html:submit property="btn_insert" value="保存" styleClass="button"/>
	<html:reset property="btn_reset" value="重置" styleClass="button"/>
	</logic:notEmpty>
	</logic:present>
	</div>
	<html:hidden property="raiid" styleId="raiid" name="IGRIS0112Form"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
