<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGDUT0302" toScope="request" />
<bean:define id="title" value="值班情况汇总画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script type="text/javascript">	
	 function search(){
		 var obj = $F("dptime");
		 if(obj == '' || obj == null){
			 alert("请选择日期！");
			 return false;
		 }
	 }
	 function changeDrresult(drid){
			if($F(drid).strlen()>256){
				alert("结果说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
				return;
			}else{
				if(confirm("是否确认修改结果说明？")){
				var form = document.forms[0];
				document.getElementById("drresult").value = document.getElementById(drid).value;
				document.getElementById("drid").value = drid;
				document.forms[0].action = getAppRootUrl() + "/changeDrresult.do";
		        document.forms[0].submit();
		        }
			}
		}
</script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGDUT0302"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; 值班情况汇总</p>
	<div class="back"><a href="IGDUT0301_Disp.do" target="_self">返回</a>
	</div>

	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div><label for="Name"><span class="red">*</span>日期：</label> <html:text
		property="dptime" readonly="true" /> <img src="images/date.gif"
		onClick="calendar($('dptime'))" border="0" />&nbsp;&nbsp; <html:submit
		property="btn_search" styleClass="button" value="查询"
		onclick="return search();" /></div>
	</div>
	</div>
	<logic:present name="IGDUT03021VO" property="voList">
		<div id="formwrapper"><logic:present name="IGDUT03021VO"
			property="dutyPlanAM">
			<fieldset><legend>白班</legend>
			<div class="record_list">
			<table cellspacing="2" class="table_style1">
				<tr>
					<th width="10%">遗留问题：</th>
					<td><pre>${IGDUT03021VO.dutyPlanAM.dpquestion}</pre></td>
				</tr>
				<tr>
					<th width="10%">总结：</th>
					<td><pre>${IGDUT03021VO.dutyPlanAM.dpinfo}</pre></td>
				</tr>
			</table>
			</div>
			</fieldset>
		</logic:present> <logic:present name="IGDUT03021VO" property="dutyPlanPM">
			<fieldset><legend>夜班</legend>
			<div class="record_list">
			<table cellspacing="2" class="table_style1">
				<tr>
					<th width="10%">遗留问题：</th>
					<td><pre>${IGDUT03021VO.dutyPlanPM.dpquestion}</pre></td>
				</tr>
				<tr>
					<th width="10%">总结：</th>
					<td><pre>${IGDUT03021VO.dutyPlanPM.dpinfo}</pre></td>
				</tr>
			</table>
			</div>
			</fieldset>
		</logic:present></div>
	</logic:present>
	<html:hidden property="drid" styleId="drid"/>
	<html:hidden property="drresult" styleId="drresult"/>
</html:form> <logic:present name="IGDUT03021VO" property="voList">
	<div id="TabbedPanels1" class="TabbedPanels">
	<ul class="TabbedPanelsTabGroup">
		<logic:present name="IGDUT03021VO" property="voList">
			<logic:iterate id="vo" name="IGDUT03021VO" property="voList"
				indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="DUTY_TYPE" cid="${vo.dutyResult.dadtype}" /></li>
			</logic:iterate>
		</logic:present>
	</ul>
	<div class="TabbedPanelsContentGroup"><logic:present
		name="IGDUT03021VO" property="voList">
		<logic:iterate id="vo" name="IGDUT03021VO" property="voList"
			indexId="number">
			<div class="TabbedPanelsContent">
			<div class="record_list">
			<table class="table_style2">
				<tr>
					<th width="4%"></th>
					<th width="15%">检查名称</th>
					<th width="10%">计划检查时间</th>
					<th width="15%">实际检查时间</th>
					<th width="15%">检查结果</th>
					<th width="25%">结果说明</th>
					<th width="8%">检查人</th>
					<th width="8%">修改说明</th>
					
				</tr>
				<tr>
					<td>
					<div class="nowrapDiv"><c:if
						test="${vo.dutyResult.drcontent != 0001 && vo.dutyResult.drcontent != ''}">
						<img src="images/red_light.gif" border="0" />
					</c:if> <bean:define id="limdtime" value="${vo.dutyResult.drlimdtime}" />
					<bean:define id="cretime" value="${vo.dutyResult.drcretime}" /> 
					<%if(cretime == null || "".equals(cretime)) {%>
						<!-- <img src="images/yellow_light.gif" border="0" /> -->
					<%} else if(limdtime.compareTo(cretime) < 0) {%>
						<img src="images/yellow_light.gif" border="0" /> 
					<%} %>
					</div>
					</td>
					<!-- 检查名称 -->
					<td>
					<div class="nowrapDiv">${vo.dutyResult.dadname}</div>
					</td>

					<!-- 计划检查时间 -->
					<td>
					<div class="nowrapDiv">${vo.dutyResult.dattime}</div>
					</td>

					<!-- 实际检查时间 -->
					<td>
					<div class="nowrapDiv">${vo.dutyResult.drfilltime}</div>
					</td>

					<!-- 检查结果 -->
					<td>
					<div class="nowrapDiv"><ig:codeValue
						ccid="${vo.dutyResult.dadcontent}"
						cid="${vo.dutyResult.drcontent}" isCcidCode="true" /></div>
					</td>

					<!-- 结果说明 -->
					<td>
					<div class="nowrapDiv">
					<input type="text" id="${vo.dutyResult.drid}" name="drresult" size="40" value="${vo.dutyResult.drresult}" class="input1">
					</div>
					</td>

					<!-- 检查人 -->
					<td>
					<div class="nowrapDiv">${vo.dutyResult.drusername}</div>
					</td>
					
					<!-- 修改结果说明 -->
					<td>
						<a href="javascript:changeDrresult('${vo.dutyResult.drid}')">
							修改说明
						</a>
					</td>
				</tr>
				<logic:present name="vo" property="dutyResultList">
					<logic:iterate id="bean" name="vo" property="dutyResultList">
						<tr>
							<td>
							<div class="nowrapDiv"><c:if
								test="${bean.drcontent != 0001 && bean.drcontent != ''}">
								<img src="images/red_light.gif" border="0" />
							</c:if> <bean:define id="limdtime" value="${bean.drlimdtime}" /> 
							<bean:define id="cretime" value="${bean.drcretime}" /> 
							<%if(cretime == null || "".equals(cretime)) {%>
								<!-- <img src="images/yellow_light.gif" border="0" />  -->
							<%}else if(limdtime.compareTo(cretime) < 0) {%>
								<img src="images/yellow_light.gif" border="0" /> 
							<%} %>
							</div>
							</td>
							<!-- 检查名称 -->
							<td>
							<div class="nowrapDiv">${bean.dadname}</div>
							</td>

							<!-- 计划检查时间 -->
							<td>
							<div class="nowrapDiv">${bean.dattime}</div>
							</td>

							<!-- 实际检查时间 -->
							<td>
							<div class="nowrapDiv">${bean.drfilltime}</div>
							</td>

							<!-- 检查结果 -->
							<td>
							<div class="nowrapDiv"><ig:codeValue
								ccid="${bean.dadcontent}" cid="${bean.drcontent}"
								isCcidCode="true" /></div>
							</td>

							<!-- 结果说明 -->
							<td>
							<div class="nowrapDiv">
							<input type="text" id="${bean.drid}" name="drresult" size="40" value="${bean.drresult}" class="input1">
							</div>
							</td>

							<!-- 检查人 -->
							<td>
							<div class="nowrapDiv">${bean.drusername}</div>
							</td>
							
							<!-- 修改结果说明 -->
							<td>
								<a href="javascript:changeDrresult('${bean.drid}')">
									修改说明
								</a>
							</td>
						</tr>
					</logic:iterate>
				</logic:present>
			</table>
			</div>
			</div>
		</logic:iterate>
	</logic:present></div>
	</div>
	<script type="text/javascript">
<!--
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
//-->
</script>
</logic:present></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>