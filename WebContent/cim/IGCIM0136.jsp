<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM0136" toScope="request"/>
<bean:define id="title" value="数据库表分析" toScope="request"/>

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
		if($F('tableName').strlen()>128){
			alert("表名称输入不得超过128个字符！");
			return false;
		}else if($F('tableSpaceName').strlen()>128){
			alert("表空间名称输入不得超过128个字符！");
			return false;
		} else if($F('instanceName').strlen()>128){
			alert("实例名称输入不得超过128个字符！");
			return false;
		} else if($F('businessName').strlen()>128){
			alert("业务系统名称输入不得超过128个字符！");
			return false;
		} 
		else {
			return true;
		}
	}
	</script>

<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
<html:form styleId="form" action="/IGCIM0136"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>   
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
							<label>业务系统名称：</label><html:text property="businessName" styleId="businessName" errorStyleClass="inputError imeDisabled" size="10"/> 
                        	&nbsp;&nbsp; 
	                        <label>实例名称：</label><html:text property="instanceName" styleId="instanceName" errorStyleClass="inputError imeDisabled" size="10" />
                        	 &nbsp;&nbsp;
                        	<label>表空间名称：</label><html:text property="tableSpaceName" styleId="tableSpaceName" errorStyleClass="inputError imeDisabled" size="10" />
                        	&nbsp;&nbsp;
                        	<label>表名称：</label><html:text property="tableName" styleId="tableName" errorStyleClass="inputError imeDisabled" size="10" />
                        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        	<html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkForm();"/>
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
			                   <th width="10%">序号</th>	
					           <th width="17%">业务系统名称</th>
					           <th width="17%" >实例名称</th>
					           <th width="17%" >表空间名称</th>
					           <th width="30%">表名称</th>
					           <th width="10%">记录数</th>
			                </tr>
			            <!-- body部 -->		
			                <logic:present name="IGCIM01361VO" property="tableSpaceInfoList" >
			                    <logic:iterate id="bean" name="IGCIM01361VO" property="tableSpaceInfoList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                        	<td>
										<div class="nowrapDiv">${(PagingDTO.viewPage-1)*PagingDTO.pageDispCount + index+1}</div>
										</td>
			                           <!-- 业务系统名称 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.businessName}
                                            </div>
			                            </td>
			                            <!-- 实例名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.instanceName}
			                                </div>
			                            </td>
			                            <!-- 表空间名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.tableSpaceName}
			                                </div>
			                            </td>
			                            <!-- 表名 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                ${bean.tableName}
			                                </div>
			                            </td>
			                            <!-- 字节数 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.numRows}
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