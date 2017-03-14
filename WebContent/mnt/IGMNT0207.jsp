<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGMNT0207" toScope="request"/>
<bean:define id="title"  toScope="request">
	<bean:message bundle="mntResources" key="ietitle.IGMNT0207"/>
</bean:define>

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
		var alterOrgan= '<bean:message bundle="mntResources" key="message.IGMNT0207.001"/>';
		if($F('eiorgname').trim()==""){
			alert(alterOrgan);
			return false;
		} else {
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
            <html:form styleId="form" action="/IGMNT0207"
             onsubmit="return checkSubmit(this);">

            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">
                    <bean:message bundle="mntResources" key="label.IGMNT0207.navi"/>
                    </p>
            </div>
           <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
                          <label><bean:message bundle="mntResources" key="label.IGMNT0207.SYMMID"/>:
                          </label>&nbsp;&nbsp;<html:text property="symmid" styleId="symmid" errorStyleClass="inputError imeDisabled" size="12"/> 
	                        <label><bean:message bundle="mntResources" key="label.IGMNT0207.DateTime_f"/>:</label><html:text property="dataitmes_f" styleId="dataitmes_f" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('dataitmes_f'))" border="0"/>
	                        &nbsp;&nbsp;<label><bean:message bundle="mntResources" key="label.IGMNT0207.DateTime_t"/>:</label><html:text property="dataitmes_t" styleId="dataitmes_t" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('dataitmes_t'))" border="0"/>
		         			<html:submit property="btn_search" styleClass="button">
		         				<bean:message bundle="mntResources" key="button.IGMNT0207.btn_search"/>	
		         			</html:submit>
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
					           <th width="35%"><bean:message bundle="mntResources" key="label.IGMNT0207.SYMMID"/></th>
					           <th width="35%"><bean:message bundle="mntResources" key="label.IGMNT0207.DateTime"/></th>
					           <th width="30%"><bean:message bundle="mntResources" key="label.IGMNT0207.SymType"/></th>
					         </tr>
			  
			            <!-- body部 -->
			            
			                <logic:present name="IGMNT02071VO" property="soc0306List" >
			                    <logic:iterate id="bean" name="IGMNT02071VO" property="soc0306List" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">
										<!-- 编号 -->
										<td>
										<div class="nowrapDiv">${bean.symmid}</div>
										</td>
										<!-- 名称 -->
										<td>
										<div class="nowrapDiv">${bean.dataitmes}</div>
										</td>
										<!-- 说明 -->
										<td>
										<div class="nowrapDiv">${bean.symtype}</div>
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