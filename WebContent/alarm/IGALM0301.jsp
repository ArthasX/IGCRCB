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
<bean:define id="id" value="IGALM0301" toScope="request" />
<bean:define id="title" value="监控对象配置" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	

	 function changeStatus(id,status){
		if(confirm("是否改变状态？")){
			var form = document.getElementById("form");
			form.action="IGALM0301_ChangeStatus.do?serverid="+id+"&alarmstatus="+status;
			form.submit();
		}
	 }

    function toback(){
        form.action = getAppRootUrl() + "/IGALM0102_SEARCH1.do";
        form.submit();
    }
	</script>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
          <html:form styleId="form" action="/IGALM0301_Search" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
               	 	<c:if test="${IGALM03011VO.flag != 'yes'}">
                    	<p class="fonts1">监控管理 &gt;&gt; ITO &gt;&gt; 监控对象配置</p>
                  	</c:if>
                  	<c:if test="${IGALM03011VO.flag == 'yes'}">
                    	<p class="fonts1">监控管理&gt;&gt; ITO &gt;&gt; 指标模板管理 &gt;&gt; 监控对象配置</p>
                  	</c:if>
                    
                    <c:if test="${IGALM03011VO.flag == 'yes'}">
                   		<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
                    </c:if>
            </div>
            <c:if test="${IGALM03011VO.flag != 'yes'}">
            	<div id="search">
                   <div class="img"></div>
                   <div class="conditions">
	                   <div>
	            		<span>监控对象名称：</span><html:text property="servername_like" styleId="servername" errorStyleClass="inputError imeDisabled" size="10"/>&nbsp;&nbsp;
						<span>IP：</span><html:text property="ip_like" styleId="ip_like" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp;
						<html:submit property="btn_search" styleClass="button" value="查询" />
	                   </div>
                   </div>
                </div>
               </c:if>
                
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table class="table_style">
						<!-- header部 -->
						
							<tr>
								<th width="6%">
<!--								<label> <input type="checkbox"-->
<!--									name="checkbox" id="checkbox" /> </label>-->
								序号
								</th>
								<th width="14%">对象名称</th>
								<th width="14%" >单网卡IP</th>
								<th width="14%" >双网卡IP</th>
								<th width="14%" >对象类型</th>
								<th width="14%">规则个数</th>
								<th width="14%">状态</th>
								<th width="10%">规则配置</th>
							</tr>
						
						<!-- body部 -->
						
                            <logic:present name="IGALM03011VO" property="crm06InfoList">
								<logic:iterate id="bean" name="IGALM03011VO" property="crm06InfoList" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">

											
										<td>
											<div class="nowrapDiv">${PagingDTO.viewStartCount+index}
											</div>
										</td>

										<!-- 名称 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="servername">&nbsp;</logic:empty> ${bean.servername}</div>
										</td>
										
										<!-- IP -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="ip">&nbsp;</logic:empty> ${bean.ip}</div>
										</td>
										
										<!-- IP2 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="ip2">&nbsp;</logic:empty> ${bean.ip2}</div>
										</td>
										
										<!-- 类别 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="servertype">&nbsp;</logic:empty> ${bean.servertype}</div>
										</td>
										
										<!-- 规则个数 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="tempcounts">&nbsp;0</logic:empty> ${bean.tempcounts}</div>
										</td>
										

										<!-- 状态 -->
										<td>
										<logic:equal name="bean" property="alarmstatus"  value="0"><!-- 停用状态 -->
											<a href="javascript:changeStatus(${bean.serverid},${bean.alarmstatus});"><img src="images/stop.gif" border="0" alt="停用"/></a>
						      			</logic:equal>
						   
										<logic:equal name="bean" property="alarmstatus"  value="1"><!-- 启用状态 -->
											<a href="javascript:changeStatus(${bean.serverid},${bean.alarmstatus});"><img src="images/start.gif" border="0" alt="启用"/></a>
						      			</logic:equal>
										

										</td>
										
										<!-- 规则配置  -->
										<td valign="middle">
										<div align="center">
										<html:link action="/IGALM0302_Disp.do?serverid=${bean.serverid}&ip=${bean.ip}&ip2=${bean.ip2}&type=${bean.servertype}&servername=${bean.servername}&flag=${IGALM03011VO.flag}">
											<img src="images/edit.gif" alt="规则配置" width="16" height="16"
												border="0" />
										</html:link>
										</div>
										</td>
																	
									</tr>
								</logic:iterate>
							</logic:present>
					</table>
				</div>
				<div id="operate">
	             <jsp:include page="/include/paging.jsp" />
                </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>