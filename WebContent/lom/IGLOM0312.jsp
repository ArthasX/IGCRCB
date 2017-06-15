<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0312" toScope="request" />
<bean:define id="title" value="冲抵计财部借款画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	function deleteRec(){
        var frm = window.document.forms[0];
        if(frm.acid) {
	        if(frm.acid.length > 0){
	        	var bchecked = false;
	        	var pos = 0;
	            for(var i=0; i<frm.acid.length; i++ ){
	                if (frm.acid[i].checked){
	                    bchecked = true;
	                    pos = i;
	                }
	            }
	            if (!bchecked) {
	            	alert("请选择预支费用！");
	                return false;
	            } else {
	            	if(parseFloat($F("money"),10) > parseFloat(frm.amount[pos].value,10)) {
						alert("汇总金额不能大于预支金额！");
			              return false;
					}
	            	if(parseFloat($F("money"),10) < parseFloat(frm.amount[pos].value,10)) {
		            	var count = parseFloat((parseFloat(frm.amount[pos].value,10) - parseFloat($F("money"),10)),10).toFixed(2);
	            		if( window.confirm("汇总金额小于预支金额，是否同意从库存金额中扣除" + count + "冲抵计财部借款")) {
	                        return true;
	                    } else {
	                        return false;
	                    }
					}
		        }
	        } else {
	          if ($("acid").checked == false){
	              alert("请选择预支费用！");
	              return false;
	          } else {
	        	  if(parseFloat($F("money"),10) > parseFloat(frm.amount.value,10)) {
						alert("汇总金额不能大于预支金额！");
			              return false;
					}
	            	if(parseFloat($F("money"),10) < parseFloat(frm.amount.value,10)) {
		            	var count = parseFloat((parseFloat(frm.amount.value,10) - parseFloat($F("money"),10)),10).toFixed(2);
	            		if( window.confirm("汇总金额小于预支金额，是否同意从库存金额中扣除" + count + "冲抵计财部借款")) {
	                        return true;
	                    } else {
	                        return false;
	                    }
					}
		      }
	        }
        } else {
        	alert("没有可选择的记录！");
            return false;
        }
        if( window.confirm("您是否确认冲抵计财部借款？")){
            return true;
        } else {
            return false;
        }
	}
	
	</script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form"
	action="/IGLOM0307_Credit" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 预支管理 &gt;&gt; 冲抵计财部借款</p>
	</div>
	<div class="title">
	<div class="name">预支费用选择</div>
	</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="5%"><label></label></th>
			<th width="10%">计财记账日期</th>
			<th width="12%">预支金额</th>
			<th width="13%">预支方式</th>
			<th width="15%">支票号</th>
			<th width="20%">预支审批号</th>
			<th width="30%">用途说明</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGLOM03021VO" property="advanCescostList">
			<logic:iterate id="bean" name="IGLOM03021VO"
				property="advanCescostList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><html:radio property="acid" value="${bean.acid}" /></td>
					<!-- 计财记账日期 -->
					<td>
					<div class="nowrapDiv">${bean.acdate}</div>
					</td>
					<!-- 预支金额 -->
					<td>
					<div class="nowrapDiv">${bean.acamount}<input type="hidden"
						name="amount" value="${bean.acamount}"></div>
					</td>
					<!-- 预支方式 -->
					<td>
					<div class="nowrapDiv"><ig:cseCodeValue
						codeIndex="<%=CodeUtils.ADVANCESCOST_ACTYPE%>"
						codeValue="${bean.actype}" /></div>
					</td>
					<!-- 支票号 -->
					<td>
					<div class="nowrapDiv">${bean.acchequenum}</div>
					</td>
					<!-- 预支审批号 -->
					<td>
					<div class="nowrapDiv">${bean.acserial}</div>
					</td>
					<!-- 用途说明 -->
					<td>
					<div class="nowrapDiv">${bean.accomment}</div>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><logic:present name="IGLOM03021VO"
		property="advanCescostList">
		<bean:size id="size" name="IGLOM03021VO" property="advanCescostList" />
		<c:if test="${size > 0}">
		<label>汇总金额：</label>
		<html:text property="money" styleId="money"
			errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
		<html:submit property="btn_search" value="冲抵" styleClass="button"
			onclick="return deleteRec();" />
		</c:if>
	</logic:present></div>
</html:form></div>
</div>
<div class="zishiying"></div>

</div>

</div>
</body>
</html:html>