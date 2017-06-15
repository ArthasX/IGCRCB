<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.03 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGLOM0307" toScope="request" />
<bean:define id="title" value="冲抵计财部借款画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间

	function deleteRec(){
        var message ='请选择发票记录！';
        var confirmMsg ='您是否确认进行预支费用选择操作？';
        var frm = window.document.forms[0];
        if(frm.deleteLpdid) {
	        if(frm.deleteLpdid.length > 0){
	            var bchecked = false;
	            for( i=0; i<frm.deleteLpdid.length; i++ ){
	                if (frm.deleteLpdid[i].checked == true){
	                    bchecked = true;
	                }
	            }
	            if (!bchecked) {
	            	alert(message);
	                return false;
	            }
	        } else {
	          if ($("deleteLpdid").checked == false){
	              alert(message);
	              return false;
	          }  
	        }
        } else {
        	alert("没有符合条件的记录！");
            return false;
        }
        
        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGLOM0307_Pay.do";
            return true;
        } else {
            return false;
        }
	}

	function addMoney(obj,money) {
		if(obj.checked) {
			$("money").value = parseFloat((parseFloat($F("money"),10) + parseFloat(money,10)),10).toFixed(2);
		} else {
			$("money").value = parseFloat((parseFloat($F("money"),10) - parseFloat(money,10)),10).toFixed(2);
		}
	}
	
	</script>

<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGLOM0307"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 预支管理 &gt;&gt; 冲抵计财部借款</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions"><label>发票日期：从</label> <html:text
		property="lpdinvoicedate_from" styleId="lpdinvoicedate_from"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
	<img src="images/date.gif" align="middle"
		onClick="calendar($('lpdinvoicedate_from'))" border="0" />&nbsp;&nbsp;
	<label>到</label> <html:text property="lpdinvoicedate_to"
		styleId="lpdinvoicedate_to" errorStyleClass="inputError imeDisabled"
		size="12" readonly="true" /> <img src="images/date.gif"
		align="middle" onClick="calendar($('lpdinvoicedate_to'))" border="0" />
	<html:submit property="btn_search" value="查询" styleClass="button" /></div>
	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<th width="5%"><label> </label></th>
			<th width="15%">借款人</th>
			<th width="15%">发票日期</th>
			<th width="10%">发票金额</th>
			<th width="65%">用途</th>
		</tr>
		<!-- body部 -->
		<logic:present name="IGLOM03071VO" property="loanPayDetailList">
			<logic:iterate id="bean" name="IGLOM03071VO"
				property="loanPayDetailList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><html:checkbox property="deleteLpdid"
						value="${bean.lpdid}"
						onclick="addMoney(this,'${bean.lpdinvoiceamount}')" /></td>
					<!-- 借款人 -->
					<td>
					<div class="nowrapDiv">${bean.lpduser}</div>
					</td>
					<!-- 发票日期 -->
					<td>
					<div class="nowrapDiv">${bean.lpdinvoicedate}</div>
					</td>
					<!-- 发票金额 -->
					<td>
					<div class="nowrapDiv">${bean.lpdinvoiceamount}</div>
					</td>
					<!-- 用途 -->
					<td>
					<div class="nowrapDiv">${bean.lpdcomment}</div>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><logic:present name="IGLOM03071VO"
		property="loanPayDetailList">
		<bean:size id="size" name="IGLOM03071VO" property="loanPayDetailList" />
		<c:if test="${size > 0}">
			<label>汇总金额：</label>
			<html:text property="money" styleId="money"
				errorStyleClass="inputError imeDisabled" size="12" readonly="true"
				value="0.00" />
			<html:submit property="btn_delete" value="预支费用选择" styleClass="button"
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