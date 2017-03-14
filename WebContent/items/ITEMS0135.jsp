<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.items.util.DefineUtils" %>
<%@ page import="com.csebank.items.util.CSEHelper" %>
<html:html>
<bean:define id="id" value="ITEMS0135" toScope="request" />
<bean:define id="title" value="结账清单" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<script type="text/javascript">
function checkForm(obj){
	if($F('outtime_f').trim()==""){
		alert("请选择开始时间！");
		return false;
	}
	if($F('outtime_t').trim()==""){
		alert("请选择结束时间！");
		return false;
	}
	if(0 == obj){
		document.forms[0].action = getAppRootUrl() + "/ITEMS0135.do?path=page";
	} else if (1 == obj){
		document.forms[0].action = getAppRootUrl() + "/ITEMS0135.do?path=excel";
	} else if (2 == obj){
		document.forms[0].action = getAppRootUrl() + "/ITEMS0136.do?reqorg=all&path=page&mode=1&outtime_f=" 
		+ $F('outtime_f').trim() + "&outtime_t=" + $F('outtime_t').trim();
	} 
	
	document.forms[0].submit();
}
</script>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
<html:form action="/ITEMS0135">
<div class="img"></div>
<div class="conditions">
	<div>
		<span class="red">*</span><span>出库时间：从</span><html:text property="outtime_f" styleId="outtime_f" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('outtime_f'))"
			border="0" style="cursor: hand" />
<span>&nbsp;&nbsp;到</span><html:text property="outtime_t" styleId="outtime_t" errorStyleClass="inputError imeDisabled" size="16" 
            readonly="true" />
			<img src="images/date.gif" align="middle" onclick="calendar($('outtime_t'))"
			border="0" style="cursor: hand" />
		<span><html:button property="serch" value="查询" onclick="checkForm(0);" styleClass="button"/></span>
		<span><html:button property="serch" value="导出" onclick="checkForm(1);" styleClass="button"/></span>
	</div>
</div>
</html:form>
</div>

 <div id="results_list">
 <ig:message />
        <table class="table_style">
            <tr>
                <th width="20%">机构名称</th>
                <th width="20%">未结账金额</th>
                <th width="20%">已结账金额</th>
                <th width="30%">合计</th>
                <th width="10%">明细</th>
            </tr>
            
         <logic:present name="ITEMS01011VO" property="paymentList">
			<logic:iterate id="bean" name="ITEMS01011VO" property="paymentList" indexId="index">
				<bean:define id="sumPayment" value="${bean.notpayment + bean.payment }"/>
				<bean:define id="notpayment" value="${bean.notpayment}"/>
				<bean:define id="payment" value="${bean.payment }"/>
            	<tr>
                 <td>${bean.orgname }</td>
                 <td><%=CSEHelper.round(notpayment,2)%></td>
                 <td><%=CSEHelper.round(payment,2)%></td>
                <td>
                	<%=CSEHelper.round(sumPayment,2)%>
				</td>
                
               	<td>
                	<a href="ITEMS0136.do?reqorg=${bean.reqorg }&path=page&mode=0&outtime_f=${ITEMS0135Form.outtime_f }&outtime_t=${ITEMS0135Form.outtime_t }">
                		<img src="images/look.gif" height="16" width="16" alt="查看明细" border="0"/>
                	</a>
               	</td>
            	</tr>
            </logic:iterate>
           </logic:present>
          </table>
       </div>
       <div class="enter">
       	<form action="/ITEMS0136">
          <html:button property="all" styleClass="button" value="全明细" onclick="checkForm(2);" />
         </form>
       </div>
	<div id="operate">
		<div class="operate_btn">
			<jsp:include page="/include/paging.jsp" />
		</div>
	</div>
</div>
</div>
</div>
</div>
</body>
</html:html>