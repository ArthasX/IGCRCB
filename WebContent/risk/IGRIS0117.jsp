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
<bean:define id="id" value="IGRIS0117" toScope="request" />
<bean:define id="title" value="审计报告" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
	<script type="text/javascript">	
	    function toRadDetail(radid){
	    	openSubWindow('/IGRIS0108_Disp.do?radid=' + radid, '_blank', '800', '600');
	    }
	</script>
	<%Map<String,Integer> countMap = new HashMap<String,Integer>(); %>
<style>
html{
overflow:auto;
}
body{
overflow-x:auto;
overflow-y:auto;
}
a{
color: #000000;
text-decoration:none;  
}
a:hover{
color: #0066CC;
text-decoration:underline; 
}
</style>
<body>
<html:form action="/IGRIS0117" styleClass="form"
	onsubmit="return checkSubmit(this);">
	<div id="report">
	<div class="image"></div>
	<p class="fonts1">服务管理 &gt;&gt; 风险审计 &gt;&gt; 审计报告</p>
	</div>
	<table class="table_style9" width="${100 + 300 * 5 + 250 + 60 + (IGRIS01171VO.radrisklevelSizeColspan + IGRIS01171VO.radfrequencySizeColspan + IGRIS01171VO.radmodeSizeColspan + IGRIS01171VO.radtypeSizeColspan + IGRIS01171VO.rarplanscoreSizeColspan + IGRIS01171VO.rarexecscoreSizeColspan + IGRIS01171VO.raroverallscoreSizeColspan) * 60}" >
		<tr>
			<th rowspan="2" width="100">编号</th>
			<th rowspan="2" colspan="${IGRIS01171VO.radMaxLevel}" width="300">审计项目</th>
			<th rowspan="2" width="300">描述</th>
		    <th colspan="${IGRIS01171VO.radrisklevelSizeColspan}" width="${IGRIS01171VO.radrisklevelSizeColspan * 60}">风险程度</th>
		    <th colspan="2" width="250">责任人</th>
		    <th colspan="${IGRIS01171VO.radfrequencySizeColspan}" width="${IGRIS01171VO.radfrequencySizeColspan * 60}">控制频率</th>
		    <th colspan="${IGRIS01171VO.radmodeSizeColspan}" width="${IGRIS01171VO.radmodeSizeColspan * 60}">控制手段</th>
		    <th colspan="${IGRIS01171VO.radtypeSizeColspan}" width="${IGRIS01171VO.radtypeSizeColspan * 60}">控制类型</th>
		    <th rowspan="2" width="60">评估人</th>
		    <th colspan="${IGRIS01171VO.rarplanscoreSizeColspan}" width="${IGRIS01171VO.rarplanscoreSizeColspan * 60}">制度建设有效性</th>
		    <th rowspan="2" width="300">制度建设评价</th>
		    <th colspan="${IGRIS01171VO.rarexecscoreSizeColspan}" width="${IGRIS01171VO.rarexecscoreSizeColspan * 60}">制度执行有效性</th>
		    <th rowspan="2" width="300">制度执行评价</th>
		    <th colspan="${IGRIS01171VO.raroverallscoreSizeColspan}"  width="${IGRIS01171VO.raroverallscoreSizeColspan * 60}">总体评分</th>
		    <th rowspan="2" width="300">总体评价</th>
		</tr>
		<tr>
		    <logic:present name="IGRIS01171VO" property="radrisklevelList">
		    	<logic:iterate id="bean" name="IGRIS01171VO" property="radrisklevelList">
		    	<th><logic:empty name="bean" property="cvalue">&nbsp;</logic:empty>${bean.cvalue}</th>
		    	</logic:iterate>
		    </logic:present>
		    <logic:empty name="IGRIS01171VO" property="radrisklevelList">
		    <th>&nbsp;</th>
		    </logic:empty>
		    <th>部门</th>
		    <th>姓名</th>
		    <logic:present name="IGRIS01171VO" property="radfrequencyList">
		    	<logic:iterate id="bean" name="IGRIS01171VO" property="radfrequencyList">
		    	<th><logic:empty name="bean" property="cvalue">&nbsp;</logic:empty>${bean.cvalue}</th>
		    	</logic:iterate>
		    </logic:present>
		    <logic:empty name="IGRIS01171VO" property="radfrequencyList">
		    <th>&nbsp;</th>
		    </logic:empty>
		    <logic:present name="IGRIS01171VO" property="radmodeList">
		    	<logic:iterate id="bean" name="IGRIS01171VO" property="radmodeList">
		    	<th><logic:empty name="bean" property="cvalue">&nbsp;</logic:empty>${bean.cvalue}</th>
		    	</logic:iterate>
		    </logic:present>
		    <logic:empty name="IGRIS01171VO" property="radmodeList">
		    <th>&nbsp;</th>
		    </logic:empty>
		    <logic:present name="IGRIS01171VO" property="radtypeList">
		    	<logic:iterate id="bean" name="IGRIS01171VO" property="radtypeList">
		    	<th><logic:empty name="bean" property="cvalue">&nbsp;</logic:empty>${bean.cvalue}</th>
		    	</logic:iterate>
		    </logic:present>
		    <logic:empty name="IGRIS01171VO" property="radtypeList">
		    <th>&nbsp;</th>
		    </logic:empty>
		    <logic:present name="IGRIS01171VO" property="rarplanscoreList">
		    	<logic:iterate id="bean" name="IGRIS01171VO" property="rarplanscoreList">
		    	<th><logic:empty name="bean" property="cvalue">&nbsp;</logic:empty>${bean.cvalue}</th>
		    	</logic:iterate>
		    </logic:present>
		    <logic:empty name="IGRIS01171VO" property="rarplanscoreList">
		    <th>&nbsp;</th>
		    </logic:empty>
		    <logic:present name="IGRIS01171VO" property="rarexecscoreList">
		    	<logic:iterate id="bean" name="IGRIS01171VO" property="rarexecscoreList">
		    	<th><logic:empty name="bean" property="cvalue">&nbsp;</logic:empty>${bean.cvalue}</th>
		    	</logic:iterate>
		    </logic:present>
		    <logic:empty name="IGRIS01171VO" property="rarexecscoreList">
		    <th>&nbsp;</th>
		    </logic:empty>
		    <logic:present name="IGRIS01171VO" property="raroverallscoreList">
		    	<logic:iterate id="bean" name="IGRIS01171VO" property="raroverallscoreList">
		    	<th><logic:empty name="bean" property="cvalue">&nbsp;</logic:empty>${bean.cvalue}</th>
		    	</logic:iterate>
		    </logic:present>
		    <logic:empty name="IGRIS01171VO" property="raroverallscoreList">
		    <th>&nbsp;</th>
		    </logic:empty>
  		</tr>
		<logic:present name="IGRIS01171VO" property="riskAuditDefResultVWInfoList">
					<c:set var="num" value="0"/>
			<logic:iterate id="bean" name="IGRIS01171VO"
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
					<logic:iterate id="count" name="IGRIS01171VO" property="radMaxLevelList" length="${bean.radlevel - 1}"><td>&nbsp;</td></logic:iterate>
					</c:if>
					<td colspan="${IGRIS01171VO.radMaxLevel - bean.radlevel + 1}" align="left"><logic:empty name="bean" property="radname">&nbsp;</logic:empty><html:link href="javascript:toRadDetail('${bean.radid}')">${bean.radname}</html:link></td>
					<td><pre><logic:empty name="bean" property="raddesc">&nbsp;</logic:empty>${bean.raddesc}</pre></td>
					<logic:present name="IGRIS01171VO" property="radrisklevelList">
		    			<logic:iterate id="codedetail" name="IGRIS01171VO" property="radrisklevelList">
		    				<td><logic:empty name="bean" property="radrisklevel">&nbsp;</logic:empty><logic:equal name="codedetail" property="cid" value="${bean.radrisklevel}">√</logic:equal></td>
		    			</logic:iterate>
		    		</logic:present>
		    		<logic:empty name="IGRIS01171VO" property="radrisklevelList">
				    	<td>&nbsp;</td>
				    </logic:empty>
					<td><logic:empty name="bean" property="radorg">&nbsp;</logic:empty>${bean.radorg}</td>
					<td><logic:empty name="bean" property="radusername">&nbsp;</logic:empty>${bean.radusername}</td>
					<logic:present name="IGRIS01171VO" property="radfrequencyList">
		    			<logic:iterate id="codedetail" name="IGRIS01171VO" property="radfrequencyList">
		    				<td><logic:empty name="bean" property="radfrequency">&nbsp;</logic:empty><logic:equal name="codedetail" property="cid" value="${bean.radfrequency}">√</logic:equal></td>
		    			</logic:iterate>
		    		</logic:present>
		    		<logic:empty name="IGRIS01171VO" property="radfrequencyList">
				    	<td>&nbsp;</td>
				    </logic:empty>
				    <logic:present name="IGRIS01171VO" property="radmodeList">
		    			<logic:iterate id="codedetail" name="IGRIS01171VO" property="radmodeList">
		    				<td><logic:empty name="bean" property="radmode">&nbsp;</logic:empty><logic:equal name="codedetail" property="cid" value="${bean.radmode}">√</logic:equal></td>
		    			</logic:iterate>
		    		</logic:present>
		    		<logic:empty name="IGRIS01171VO" property="radmodeList">
				    	<td>&nbsp;</td>
				    </logic:empty>
				    <logic:present name="IGRIS01171VO" property="radtypeList">
		    			<logic:iterate id="codedetail" name="IGRIS01171VO" property="radtypeList">
		    				<td><logic:empty name="bean" property="radtype">&nbsp;</logic:empty><logic:equal name="codedetail" property="cid" value="${bean.radtype}">√</logic:equal></td>
		    			</logic:iterate>
		    		</logic:present>
		    		<logic:empty name="IGRIS01171VO" property="radtypeList">
				    	<td>&nbsp;</td>
				    </logic:empty>
					<td><logic:empty name="bean" property="rarusername">&nbsp;</logic:empty>${bean.rarusername}</td>
					<logic:present name="IGRIS01171VO" property="rarplanscoreList">
		    			<logic:iterate id="codedetail" name="IGRIS01171VO" property="rarplanscoreList">
		    				<td><logic:empty name="bean" property="rarplanscore">&nbsp;</logic:empty><logic:equal name="codedetail" property="cid" value="${bean.rarplanscore}">√</logic:equal></td>
		    			</logic:iterate>
		    		</logic:present>
		    		<logic:empty name="IGRIS01171VO" property="rarplanscoreList">
				    	<td>&nbsp;</td>
				    </logic:empty>
				    <td><pre><logic:empty name="bean" property="rarplandesc">&nbsp;</logic:empty>${bean.rarplandesc}</pre></td>
				    <logic:present name="IGRIS01171VO" property="rarexecscoreList">
		    			<logic:iterate id="codedetail" name="IGRIS01171VO" property="rarexecscoreList">
		    				<td><logic:empty name="bean" property="rarexecscore">&nbsp;</logic:empty><logic:equal name="codedetail" property="cid" value="${bean.rarexecscore}">√</logic:equal></td>
		    			</logic:iterate>
		    		</logic:present>
		    		<logic:empty name="IGRIS01171VO" property="rarexecscoreList">
				    	<td>&nbsp;</td>
				    </logic:empty>
				    <td><pre><logic:empty name="bean" property="rarexecdesc">&nbsp;</logic:empty>${bean.rarexecdesc}</pre></td>
				    <logic:present name="IGRIS01171VO" property="raroverallscoreList">
		    			<logic:iterate id="codedetail" name="IGRIS01171VO" property="raroverallscoreList">
		    				<td><logic:empty name="bean" property="raroverallscore">&nbsp;</logic:empty><logic:equal name="codedetail" property="cid" value="${bean.raroverallscore}">√</logic:equal></td>
		    			</logic:iterate>
		    		</logic:present>
		    		<logic:empty name="IGRIS01171VO" property="raroverallscoreList">
				    	<td>&nbsp;</td>
				    </logic:empty>
				    <td><pre><logic:empty name="bean" property="raroveralldesc">&nbsp;</logic:empty>${bean.raroveralldesc}</pre></td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	<div class="enter"><html:button property="btn_back" styleClass="button" value="关闭" onclick="window.close();" /></div>
	<html:hidden property="raiid" styleId="raiid" name="IGRIS0117Form"/>
	<div style="height: 30px;"></div>
</html:form>
</body>
</html:html>
