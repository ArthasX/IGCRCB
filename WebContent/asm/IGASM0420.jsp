<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGASM0420" toScope="request"/>
<bean:define id="title" value="合同应付款登记画面" toScope="request"/>

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
            <html:form styleId="form" action="/IGASM0420"
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
		        			<label>付款完毕：</label>
		        			<html:select property="payed" style="width:50px">
		        				<html:option value=""></html:option>
		        				<html:option value="1">是</html:option>
		        				<html:option value="0">否</html:option>
		        			</html:select>
		        			&nbsp;&nbsp; 
		        			<html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkForm();"/>
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
					           <th width="10%">合同名称</th>
					           <th width="10%">合同类型</th>
					           <th width="10%">服务商</th>
					           <th width="10%">合同总额</th>
					           <th width="10%">已付款额</th>
					           <th width="5%">详细信息</th>
					           <th width="5%">付款登记</th>
			                </tr>

			            <!-- body部 -->

			                <logic:present name="IGASM04201VO" property="entityItemCompactVWList" >
			                    <logic:iterate id="bean" name="IGASM04201VO" property="entityItemCompactVWList" indexId="index">
			                        <tr>
			                            <!-- 编号 -->
			                            <td>
			                            	${bean.eilabel}
			                            </td>
			                            <!-- 名称 -->
			                            <td>
			                            	${bean.einame}
			                            </td>
			                            <!-- 类型 -->
			                            <td>
			                            	${bean.compacttype}
			                            </td>
			                            <!-- 服务商 -->
			                            <td>
			                            	${bean.facilitator}
			                            </td>
			                            <!-- 合同总额 -->
			                            <td>
			                            	${bean.contractpayment}
			                            </td>
			                            <!-- 已付款额 -->
			                            <td>
			                            	${bean.countmoney}
			                            </td>
			                            <!-- 详细信息 -->
			                            <td>
			                                <div align="center">
                                                <html:link action="/IGASM0423_Disp.do?eiid=${bean.eiid}"><img src="images/xx.gif" alt="显示详细信息" width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                            <!-- 付款登记  -->
			                            <td>
			                                <div align="center">
                                                <html:link action="/IGASM0421_Disp.do?eiid=${bean.eiid}"><img src="images/compact_money.png" alt="付款登记" width="16" height="16"  border="0"/></html:link>
			                                </div>
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