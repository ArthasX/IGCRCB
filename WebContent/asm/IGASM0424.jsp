<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGASM0424" toScope="request"/>
<bean:define id="title" value="合同统计页" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	    WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
	    WebCalendar.format     = "yyyy/mm/dd"  //回传日期的格式
	    WebCalendar.timeShow   = false          //是否返回时间
	    WebCalendar.drag       = true          //是否允许拖动
	    WebCalendar.darkColor  = "#014DB4";    //控件的暗色
	    WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
	    WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
	    WebCalendar.wordColor  = "#000080";    //控件的文字颜色
	    WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
	    WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
	    WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
	    WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色


	function checkForm(){
		
		return true;
	}
	function exptexl(){
		location.href="IGASM0420_Export.do";
	}
	</script>

<body onLoad="">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">

    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <html:form styleId="form" action="/IGASM0424"
             onsubmit="return checkSubmit(this);">

            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
            <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
			                <label>服务商名称：</label><html:text property="facilitator" styleId="facilitator"  errorStyleClass="inputError imeDisabled" size="15"/>
			                <label>合同名称：</label><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10"/>&nbsp;&nbsp; 
	                        <label>合同编号：</label><html:text property="eilabel" styleId="eilabel" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp;
	                        <br>
	                        <label>实际付款日期：从</label><html:text property="time_from" styleId="time_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('time_from'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label>到</label><html:text property="time_to" styleId="time_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('time_to'))" border="0"/>
		        			
		        			&nbsp;&nbsp; 
		        			<html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkForm();"/>
		        			&nbsp;&nbsp;
                          </div>
		     </div>
		     
          </div>
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table class="table_style">
			            <!-- header部 -->
			     
			                <tr>
					           <th width="10%">合同编号</th>
					           <th width="20%">合同名称</th>
					           <th width="20%">服务商</th>
					           <th width="10%">实际付款金额</th>
					           <th width="10%">付款所占比例</th>
					           <th width="10%">合同总金额</th>
					           <th width="10%">已付款金额</th>
					           <th width="10%">未付款金额</th>
			                </tr>

			            <!-- body部 -->

			                <logic:present name="IGASM04241VO" property="entityItemCompactVWList" >
			                    <logic:iterate id="bean" name="IGASM04241VO" property="entityItemCompactVWList" indexId="index">
			                        <tr>
			                            <!-- 编号 -->
			                            <td>
			                            	${bean.eilabel}
			                            </td>
			                            <!-- 名称 -->
			                            <td>
			                            	${bean.einame}
			                            </td>
			                            <!-- 服务商 -->
			                            <td>
			                            	${bean.facilitator}
			                            </td>
			                            <!-- 时间段内实际付款金额 -->
			                            <td>
			                            	${bean.ekey1}
			                            </td>
			                            <!-- 时间段内金额所占比例 -->
			                            <td>
				                            <c:if test="${bean.contractpayment != 0}">
			                            		<fmt:formatNumber value=" ${bean.ekey1 / bean.contractpayment *100}" pattern="#,##,###,###"/>%
				                            </c:if>
				                            <c:if test="${bean.contractpayment == 0}">
				                            	${bean.contractpayment}
				                            </c:if>
			                            </td>
			                            <!-- 合同总额 -->
			                            <td>
			                            	${bean.contractpayment}
			                            </td>
			                            <!-- 已付款额 -->
			                            <td>
                                                ${bean.countmoney}
			                            </td>
			                            <!-- 未付款  -->
			                            <td>
			                                <!-- 
			                                ${bean.ekey1 / bean.contractpayment *100}%
			                                 -->
			                                ${ bean.contractpayment -bean.countmoney}
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present> 
			       </table>
			     </div>
			     <div id="operate">
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>