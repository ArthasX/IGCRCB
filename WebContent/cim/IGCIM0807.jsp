<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGCIM0807" toScope="request" />
<bean:define id="title" value="定时任务历史画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
//	WebCalendar.timeShow   = true;          //是否返回时间	
//    function toback(){
//    	form.action = getAppRootUrl() + "/IGCIM0805_Back.do";
//    	form.submit();
//    }

	function clearDate(){
		var disp = (<%=request.getAttribute("disp")%>);
		if(disp == true){
			$('collectdate').value = "";
			$('executstatus').value = "";
		}
	}
</script>
<body onload="clearDate()">
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<div>
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
        	 <div id="formwrapper">
          <!-- 
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">配置管理 &gt;&gt;配置采集&gt;&gt;采集历史查询</p>
                <div class="back">
            		<html:link href="javascript:toback();">
			    		<bean:message bundle="asmResources" key="button.IGCIM0104.btn_toback"/> 
					</html:link>
				</div>
            </div>
            -->
          
			
			<html:form styleId="form" action="/IGCIM0807_Search" onsubmit="return checkSubmit(this);">
            <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                   <div>
			        <span>执行时间：</span>
			        <html:text property="collectdate" styleId="collectdate"  errorStyleClass="inputError imeDisabled" size="15" />
			        <img src="images/date.gif" align="middle" onClick="calendar($('collectdate'))" border="0"/>
			        &nbsp;&nbsp;&nbsp;
			        <span>执行状态：</span><html:select property="executstatus">
			        	<html:option value=""></html:option>
			        	<html:option value="1">enable</html:option>
			        	<html:option value="2">disable</html:option>
			        	<!--<html:option value="0">错误</html:option>-->
			        </html:select>&nbsp;&nbsp;&nbsp;
			        
                    <html:submit property="btn_search" styleClass="button" value="查询" />
                   </div>
                   </div>
                </div>
                
                <div class="title">
					<div class="name"><%= (String)request.getSession().getAttribute("servername")%> 定时任务执行历史信息</div>
				</div>
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table class="table_style">
						<!-- header部 -->
						 
							<tr>
								<th width="10%">序号</th>
								<!-- <th width="20%">采集项</th> -->
								<th width="20%">执行时间</th>
								<th width="20%">服务状态</th>
								<th width="30%">执行信息</th>
							</tr>
							<logic:present name="IGCIM13012VO" property="historyList">
								<logic:iterate id="bean" name="IGCIM13012VO" property="historyList" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">
										<!-- 序号 -->
										<td>
											<div class="nowrapDiv">${PagingDTO.viewStartCount+index}
											</div>
										</td>
										<!-- 
										<td>
										<div class="nowrapDiv">${bean.name }</div>
										</td>
										 -->
										<td>
										<div class="nowrapDiv">${bean.collectdate }</div>
										</td>
										<td>
										<div class="nowrapDiv">
											<c:if test="${bean.executstatus == '0'}">error</c:if>
											<c:if test="${bean.executstatus == '1'}">enable</c:if>
											<c:if test="${bean.executstatus == '2'}">disable</c:if>
										</div>
										</td>
										<td>
										<div class="nowrapDiv">
											${bean.executmessage }
										</div>
										</td>
									</tr>
								</logic:iterate>
							</logic:present>
							
						<!-- body部 -->
						</table>
				</div>
				<div id="operate">
	             <jsp:include page="/include/paging.jsp" />
                </div>
            </html:form>
            </div>
            </div>
        </div>
    
    
    <div class="zishiying"></div>
    </div>
</div>



</body>
</html:html>