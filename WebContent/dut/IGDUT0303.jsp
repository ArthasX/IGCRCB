<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGDUT0303" toScope="request" />
<bean:define id="title" value="值班情况汇总画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		var gid='IGSVC0203';
		function selectDad(index){
			openSubWindow('/IGDUT0104_Disp.do?dadcategory=${IGDUT0302Form.dadcategory}', '_blank','1000','600');
		}

		function setParams(dadid,dadname){
			$("dadid").value = dadid;
			$("dadname_q").value = dadname;
		}

	 //查询条件非空校验
	 function search(){
		 //检查名称
		 if($F("dadname_q").trim() == "" || $F("dadid").trim() == ""){
			 alert("请选择检查名称！");
			 return false;
		 }

		 //时间段查询
		 if($F('dopentime').trim()==""){
			 alert("请选择周期开始时间！");
			 return false;
		 }
		 if($F('dclosetime').trim()==""){
			 alert("请选择周期结束时间！");
			 return false;
		 }
		 if(!checkDateWithTimeShow("dopentime","dclosetime")){
			 alert("周期开始时间不能晚于结束时间！");
			 return false;
		 }
	 }
</script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGDUT0303"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; 值班情况汇总</p>

	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div><label for="Name"><span class="red">*</span>检查名称：</label> <html:text
		property="dadname_q" styleId="dadname_q"
		errorStyleClass="inputError imeDisabled" readonly="true" /><img
		src="images/seek.gif" border="0" width="16" height="16" alt="查询"
		onclick="selectDad()" style="cursor: hand" /> <html:hidden
		name="IGDUT0302Form" property="dadid" styleId="dadid" /> <span
		class="red">*</span> <span>时间：从</span><span><html:text
		property="dopentime" readonly="true"
		errorStyleClass="inputError imeActive" /></span> <img src="images/date.gif"
		align="middle" onClick="calendar($('dopentime'))" border="0" /> <span>&nbsp;&nbsp;到</span><span><html:text
		property="dclosetime" readonly="true"
		errorStyleClass="inputError imeActive" /></span> <img src="images/date.gif"
		align="middle" onClick="calendar($('dclosetime'))" border="0" /> <html:submit
		property="btn_search" styleClass="button" value="查询"
		onclick="return search();" /></div>
	</div>
	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table class="table_style">
		<!-- header -->

		<tr>
			<th width="5%"><!--								<label> <input type="checkbox" name="checkbox" id="checkbox" /> </label>
								序号--></th>
			<th width="10%">值班日期</th>
			<th width="10%">计划检查时间</th>
			<th width="12%">实际检查时间</th>
			<th width="22%">检查结果</th>
			<th width="28%">结果说明</th>
			<th width="10%">检查人</th>
		</tr>

		<!-- body部 -->

		<logic:present name="IGDUT03031VO" property="dutyResultList">
			<logic:iterate id="bean" name="IGDUT03031VO"
				property="dutyResultList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td>
					<div class="nowrapDiv"><c:if
						test="${bean.drcontent != 0001 }">
						<img src="images/red_light.gif" border="0" title="有异常情况出现" />
					</c:if><bean:define id="limdtime" value="${bean.drlimdtime}" /> <bean:define
						id="cretime" value="${bean.drcretime}" /> <%if(cretime == null || "".equals(cretime)) {%>
					<img src="images/yellow_light.gif" title="未按规定时间填报" border="0" /> <%} else if(limdtime.compareTo(cretime) < 0) {%>
					<img src="images/yellow_light.gif" title="未按规定时间填报" border="0" /> <%} %>
					</div>
					</td>

					<!-- 检查日期 -->
					<td>
					<div class="nowrapDiv"><logic:empty name="bean"
						property="dptime">&nbsp;</logic:empty> ${bean.dptime}</div>
					</td>

					<!-- 计划检查时间 -->
					<td>
					<div class="nowrapDiv"><logic:empty name="bean"
						property="dattime">&nbsp;</logic:empty> ${bean.dattime}</div>
					</td>

					<!-- 实际检查时间 -->
					<td>
					<div class="nowrapDiv"><logic:empty name="bean"
						property="drcretime">&nbsp;</logic:empty> ${bean.drcretime}</div>
					</td>

					<!-- 检查结果 -->
					<td>
					<div class="nowrapDiv"><logic:empty name="bean"
						property="drcontent">&nbsp;</logic:empty><ig:codeValue
						ccid="${bean.dadcontent}" cid="${bean.drcontent}"
						isCcidCode="true" /></div>
					</td>

					<!-- 结果说明 -->
					<td>
					<div class="nowrapDiv"><logic:empty name="bean"
						property="drresult">&nbsp;</logic:empty>${bean.drresult}</div>
					</td>

					<!-- 检查人 -->
					<td>
					<div class="nowrapDiv"><logic:empty name="bean"
						property="drusername">&nbsp;</logic:empty> ${bean.drusername}</div>
					</td>
				</tr>


			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><jsp:include page="/include/paging.jsp" /></div>
	<html:hidden property="dadcategory" styleId="dadcategory"
		name="IGDUT0302Form" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>