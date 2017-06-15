<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM2501" toScope="request"/>
<bean:define id="title" value="服务记录统计" toScope="request"/>

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

<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    <!--sidebar  左菜单--> 
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
<html:form styleId="form" action="/IGASM2501"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">外包管理 &gt;&gt; 服务商管理 &gt;&gt; 服务记录统计</p>
            </div>    
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div class="conditions_border1">
                          <div>
	                        <label><span class="red">*</span>登记时间：从</label><html:text property="beginTime_q" styleId="beginTime_q" name="IGASM2501Form" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('beginTime_q'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label>到</label><html:text property="endTime_q" styleId="endTime_q" name="IGASM2501Form" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('endTime_q'))" border="0"/>
                            <label>&nbsp;&nbsp;服务商：</label><html:text property="einame_like" styleId="einame_like" name="IGASM2501Form" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp; 
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
					           <th width="20%">服务商名称</th>
					           <th width="10%">设备资产</th>
					           <th width="10%">平均分</th>
					           <th width="10%">应用资产</th>
					           <th width="10%">平均分</th>
					           <th width="10%">培训记录</th>
					           <th width="10%">平均分</th>
					           <th width="10%">合计次数</th>
					           <th width="10%">平均分</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGASM25011VO" property="entityItemRelationVWInfoList" >     
			                    <logic:iterate id="bean" name="IGASM25011VO" property="entityItemRelationVWInfoList" type="com.deliverik.infogovernor.asset.model.IG343Info" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            
										<!--服务商名称 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                <a href="IGASM2502.do?eiid=${bean.eiid }&beginTime=<bean:write name="IGASM25011VO" property="beginTime_q"/>&endTime=<bean:write name="IGASM25011VO" property="endTime_q"/>">${bean.einame}</a>
			                                </div>
			                            </td>
										<!-- 设备资产-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="civalue">&nbsp;</logic:empty>
			                                ${bean.civalue}
			                                </div>
			                            </td>
										<!--平均分 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="civalue1">&nbsp;</logic:empty>
			                                ${bean.civalue1}
			                                </div>
			                            </td>
			                            <!-- 应用资产-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="civalue2">&nbsp;</logic:empty>
			                                ${bean.civalue2}
			                                </div>
			                            </td>
										<!--平均分 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="civalue3">&nbsp;</logic:empty>
			                                ${bean.civalue3}
			                                </div>
			                            </td>
			                            <!-- 培训记录-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="einame3">&nbsp;</logic:empty>
			                                ${bean.einame3}
			                                </div>
			                            </td>
										<!--平均分 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="civalue4">&nbsp;</logic:empty>
			                                ${bean.civalue4}
			                                </div>
			                            </td>
			                             <!-- 合计次数-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="sumcount">&nbsp;</logic:empty>
			                                ${bean.sumcount}
			                                </div>
			                            </td>
										<!--平均分 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="sumstore">&nbsp;</logic:empty>
<%-- 			                               ${bean.civalue1+bean.civalue3+bean.civalue4} --%>
												${bean.sumstore}
			                                </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                  
			               		<tr class="<ig:rowcss index="${index}"/>">
			                            <td width="20%">
			                                <div class="nowrapDiv">
											共计
			                                </div>
			                            </td>
										<!--设备资产  -->
			                            <td width="20%"> <div class="nowrapDiv"><bean:write name="IGASM25011VO" property="sbSumCount"/></div>
			                            </td>
										<!-- 平均分 -->
			                            <td></td>
			                           <!-- 应用资产 --> 
			                            <td> <div class="nowrapDiv"> <bean:write name="IGASM25011VO" property="yySumCount"/></div>
			                            </td>
										<!--  平均分-->
			                            <td></td>
			                          <!--培训记录  -->  
			                            <td> <div class="nowrapDiv"><bean:write name="IGASM25011VO" property="pxSumCount"/></div>
			                            </td>
										<!-- 平均分 -->
			                            <td></td>
			                            <!-- 合计次数共计 --> 
			                            <td> <div class="nowrapDiv"><bean:write name="IGASM25011VO" property="hjSumCount"/></div>
			                            </td>
			                            <td>
			                            </td>
			                  </tr>
			             </logic:present> 
			       </table>
			       
			     </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>

</div>
</body>
</html:html>