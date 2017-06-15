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
<bean:define id="id" value="IGLOM0302" toScope="request" />
<bean:define id="title" value="预支费用查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间

	function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="预支费用信息" />';
        var frm = window.document.forms[0];
        if(frm.deleteAcid) {
	        if(frm.deleteAcid.length > 0){
	            var bchecked = false;
	            for( i=0; i<frm.deleteAcid.length; i++ ){
	                if (frm.deleteAcid[i].checked == true){
	                    bchecked = true;
	                }
	            }
	            if (!bchecked) {
	            	alert(message);
	                return false;
	            }
	        } else {
	          if ($("deleteAcid").checked == false){
	              alert(message);
	              return false;
	          }  
	        }
        } else {
        	alert("没有可删除的数据！");
            return false;
        }
        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGLOM0302_Delete.do";
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
<div id="content"><html:form styleId="form" action="/IGLOM0302"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">后勤管理 &gt;&gt; 预支管理 &gt;&gt; 预支费用查询</p>
	</div>
	<div id="search">
	<div class="img"></div>
	<div class="conditions"><label>登记日期：从</label> <html:text
		property="acdate_from" styleId="acdate_from"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
	<img src="images/date.gif" align="middle"
		onClick="calendar($('acdate_from'))" border="0" />&nbsp;&nbsp; <label>到</label>
	<html:text property="acdate_to" styleId="acdate_to"
		errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
	<img src="images/date.gif" align="middle"
		onClick="calendar($('acdate_to'))" border="0" /> <span>&nbsp;&nbsp;状态：</span><span><html:select
		property="acstatus_q">
		<html:options collection="AD_advancescost_acstatus" property="value" name="" labelProperty="label" />
	</html:select></span> <html:submit property="btn_search" value="查询" styleClass="button" /></div>
	</div>

	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table width="100%" class="table_style">
		<!-- header部 -->
		<tr>
			<!--					           <th width="5%">-->
			<!--					             <label>-->
			<!--					             </label>-->
			<!--					           </th>-->
			<th width="10%">登记日期</th>
			<th width="10%">计财记账日期</th>
			<th width="10%">预支金额</th>
			<th width="10%">预支方式</th>
			<th width="10%">支票号</th>
			<th width="15%">预支审批号</th>
			<th width="10%">状态</th>
			<th width="25%">用途说明</th>
			<!--					           <th width="5%">修改</th>-->
		</tr>
		<!-- body部 -->
		<logic:present name="IGLOM03021VO" property="advanCescostList">
			<logic:iterate id="bean" name="IGLOM03021VO"
				property="advanCescostList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<!--			                            <td><html:checkbox property="deleteAcid" value="${bean.acid}"/></td>-->
					<!-- 登记日期 -->
					<td>
					<div class="nowrapDiv">${bean.acinsdate}</div>
					</td>
					<!-- 计财记账日期 -->
					<td>
					<div class="nowrapDiv">${bean.acdate}</div>
					</td>
					<!-- 预支金额 -->
					<td>
					<div class="nowrapDiv">${bean.acamount}</div>
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
					<!-- 预支费用状态 -->
					<td>
					<div class="nowrapDiv"><ig:cseCodeValue
						codeIndex="<%=CodeUtils.ADVANCESCOST_ACSTATUS%>"
						codeValue="${bean.acstatus}" /></div>
					</td>
					<!-- 用途说明 -->
					<td>
					<div class="nowrapDiv">${bean.accomment}</div>
					</td>
					<!-- 修改 -->
					<!--			                            <td><div class="nowrapDiv"><html:link action="/IGLOM0301_Edit_Disp.do?acid=${bean.acid}"><img src="images/edit.gif" alt="修改" width="16" height="16"  border="0"/></html:link></div></td>-->
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate"><!--                            <logic:present name="IGLOM03021VO" property="advanCescostList" >-->
	<!--                            <html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec();" />-->
	<!--                            </logic:present>--> <!-- paging --> <jsp:include
		page="/include/paging.jsp" /> <!-- /paging --></div>
</html:form></div>
</div>
<div class="zishiying"></div>

</div>

</div>
</body>
</html:html>