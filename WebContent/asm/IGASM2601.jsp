<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM2601" toScope="request"/>
<bean:define id="title" value="服务商资源池统计" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	    WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
	    WebCalendar.format     = "yyyy/mm/dd"  //回传日期的格式
	    WebCalendar.timeShow   = false          //是否返回时间
	    WebCalendar.drag       = true          //是否允许拖动
	    WebCalendar.darkColor  = "#020DB4";    //控件的暗色
	    WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
	    WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
	    WebCalendar.wordColor  = "#000080";    //控件的文字颜色
	    WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
	    WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
	    WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
	    WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色

	function checkForm(){
		if($F('beginTime_q').trim()==""){
			alert("请选择登记开始时间！");
			return false;
		} else {
			if($F('endTime_q').trim()==""){
				alert("请选择登结束时间！");
				return false;
			}else{
				return true;
			}
		}
	}

	</script>

<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    <!--sidebar  左菜单--> 
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
<html:form styleId="form" action="/IGASM2601"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>    
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div class="conditions_border1">
                          <div>
	                        <label><span class="red">*</span>时间：从</label><html:text property="beginTime_q" styleId="beginTime_q" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('beginTime_q'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label>到</label><html:text property="endTime_q" styleId="endTime_q" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('endTime_q'))" border="0"/>
                        	<html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkForm();"/>
                          </div>
                    </div>
		      </div>
		     
          </div>
                           
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
				
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                 <tr>
					           <th width="5%">序号</th>
					           <th width="20%">单位名称</th>
					           <th width="15%">地址</th>
					           <th width="10%">联系人</th>
					           <th width="10%">联系方式</th>
					           <th width="10%">注册资金</th>
					           <th width="15%">公司资质</th>
					           <th width="15%">成功案例</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGASM26011VO" property="entityItemAndConfigItemVWInfoList" >     
			                    <logic:iterate id="bean" name="IGASM26011VO" property="entityItemAndConfigItemVWInfoList" type="com.deliverik.infogovernor.asset.model.IG342Info" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            
										<!--序号 -->
			                            <td>
			                            <div class="nowrapDiv">
			                               ${index +1}
			                            </div>
			                            </td>
										<!-- 单位名称-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="einame">&nbsp;</logic:empty>
			                                ${bean.einame}
			                                </div>
			                            </td>
										<!--地址 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="address">&nbsp;</logic:empty>
			                                ${bean.address}
			                                </div>
			                            </td>
			                            <!-- 联系人-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="linkman">&nbsp;</logic:empty>
			                                ${bean.linkman}
			                                </div>
			                            </td>
										<!--联系方式-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="phone">&nbsp;</logic:empty>
			                                ${bean.phone}
			                                </div>
			                            </td>
			                            <!-- 注册资金-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="fund">&nbsp;</logic:empty>
			                                ${bean.fund}
			                                </div>
			                            </td>
										<!-- 公司资质 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="aptitude">&nbsp;</logic:empty>
			                                ${bean.aptitude}
			                                </div>
			                            </td>
			                             <!-- 成功案例-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="succeedcase">&nbsp;</logic:empty>
			                                ${bean.succeedcase}
			                                </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			             </logic:present> 
			       </table>
			       <div id="operate">
	             <jsp:include page="/include/paging.jsp" />
                </div>
			     </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>

</div>
</body>
</html:html>