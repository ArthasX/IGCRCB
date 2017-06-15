<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGSYM1702" toScope="request" />
<bean:define id="title" value="流程策略查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	function checkStrategy(obj, psdname, prurgency) {

		var cvalue = obj.value;
		if(cvalue.indexOf("-") != -1 || parseFloat(cvalue) <= 0 ){
			alert(psdname + "状态，优先级为" + prurgency + "的预期解决时间必须大于0！");
			obj.value = "";
			obj.focus();
			return false;
		}
		if(cvalue != "" && cvalue.indexOf(".") != -1){
			alert(psdname + "状态，优先级为" + prurgency + "的预期解决时间必须为正整数！");
			obj.value = "";
			obj.focus();
			return false;
		}
	}
//-->
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGSYM1702"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 流程策略设定</p>
	<div class="back"><a href="IGSYM1701_Back.do" target="_self">返回</a></div> 
	</div>
	<div id="results_list">
		<table class="table_style6" align="left">
				<tr>
					<th width="20%">
						类型名称
					</th>
					<td width="20%">
					${IGSYM17021VO.processDefinition.pdname}
					</td>
					<th width="20%">
						当前策略版本
					</th>
					<td width="20%">
					<c:if test="${IGSYM17021VO.maxPsdversion > 0 }">
						${IGSYM17021VO.maxPsdversion}版
					</c:if>
					</td>
				</tr>	
				<tr>
					<th width="20%">
						历史策略版本
					</th>
					<td width="60%" colspan="3">
						<c:if test="${IGSYM17021VO.maxPsdversion > 0 }">
							<c:forEach begin="1" end="${IGSYM17021VO.maxPsdversion}" var="version">
								<c:choose>
									<c:when test="${IGSYM1702Form.psdversion != version}">
										<html:link action="/IGSYM1702_Disp.do?pdid=${IGSYM1702Form.pdid}&ptid=${IGSYM1702Form.ptid}&psdversion=${version}" >
											${version}版
										</html:link>
									</c:when>
									<c:otherwise>
										<font class="txMessageWar">${version}版</font>
									</c:otherwise>
								</c:choose>
								
								&nbsp;&nbsp;
							</c:forEach>
						</c:if>
					</td>
				</tr>	
		</table>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="20%" rowspan="2">状态</th>
			<logic:present name="IGSYM17021VO" property="prurgencyList">
				<bean:size id="prurgencySize" name="IGSYM17021VO" property="prurgencyList"/>
				<th width="80%" colspan="${prurgencySize}">优先级（分钟）</th>
			</logic:present>
			<logic:notPresent name="IGSYM17021VO" property="prurgencyList">
				<th width="80%">优先级（分钟）</th>
			</logic:notPresent>
		</tr>
		<tr>
	        <logic:present name="IGSYM17021VO" property="prurgencyList">
				<logic:iterate id="bean" name="IGSYM17021VO" property="prurgencyList" indexId="index">
					<th width="10%">${bean.label}</th>
				</logic:iterate>
			</logic:present>
		</tr>
		<logic:present name="IGSYM17021VO" property="prstatusList">
			<logic:iterate id="bean" name="IGSYM17021VO" property="prstatusList" indexId="index">
				<tr>
					<td>${bean.label}</td>
					<logic:present name="IGSYM17021VO" property="prurgencyList">
						<logic:iterate id="prurgency" name="IGSYM17021VO" property="prurgencyList" indexId="index">
							<td>
								<c:if test="${IGSYM1702Form.psdversion == IGSYM17021VO.maxPsdversion}">
									<html:text name="IGSYM1702Form" property="strategy(${bean.value}#${prurgency.value})" 
										style="width:80px;text-align:center" onclick="SoftKeyboard($('strategy(${bean.value}#${prurgency.value})'),9)"
										styleId="strategy(${bean.value}#${prurgency.value})" readonly="true"
										onblur="checkStrategy(this,'${bean.label}','${prurgency.label}');"/>
								</c:if>
								<c:if test="${IGSYM1702Form.psdversion != IGSYM17021VO.maxPsdversion}">
									<html:text name="IGSYM1702Form" property="strategy(${bean.value}#${prurgency.value})" 
										style="width:80px;text-align:center" onclick="SoftKeyboard($('strategy(${bean.value}#${prurgency.value})'),9)"
										styleId="strategy(${bean.value}#${prurgency.value})" readonly="true"/>
								</c:if>
							</td>
						</logic:iterate>
					</logic:present>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<logic:present name="IGSYM17021VO" property="prurgencyList">
		<c:if test="${IGSYM1702Form.psdversion == IGSYM17021VO.maxPsdversion}">
			<div align="center">
			<span>
				<html:submit property="btn_save" value="保存" styleClass="button"/>
				<html:reset property="btn_save" value="重置" styleClass="button"/>
			</span>
			</div>
		</c:if>
	</logic:present>
	<html:hidden property="pdid" styleId="pdid" name="IGSYM1702Form"/>
	<html:hidden property="ptid" styleId="ptid" name="IGSYM1702Form"/>
	<html:hidden property="psdversion" styleId="psdversion" name="IGSYM1702Form"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>