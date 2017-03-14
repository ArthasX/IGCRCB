<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGCIM0140" toScope="request"/>
<bean:define id="title" value="AB角缺失查询" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
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
<html:form styleId="form" action="/IGCIM0140"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>   
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
	                        <label>业务系统名称：</label><html:text property="eiName" styleId="businessName" errorStyleClass="inputError imeDisabled" size="12"/> 
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                         <label>登记日期:&nbsp;&nbsp;&nbsp;从</label><html:text property="sdate" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label><bean:message bundle="asmResources" key="label.IGCIM0101.markDayTo"/></label><html:text property="edate" styleId="eiupdtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to'))" border="0"/>
                       	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <html:submit property="btn_search" value="查询" styleClass="button"/>
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
			                	<th width="20%" >业务系统名称</th>
					           <th width="20%">管理员A</th>
					           <th width="20%" >管理员B</th>
					           <th width="20%">登记人</th>
					           <th width="20%">登记日</th>
<!-- 					           <th width="7%">状况信息</th> -->
			                </tr>
			            <!-- body部 -->		
			                <logic:present name="IGCIM01401VO" property="platformManagerList" >
			                    <logic:iterate id="bean" name="IGCIM01401VO" property="platformManagerList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <!-- 业务系统名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.eiName}
			                                </div>
			                            </td>
			                            <!-- 管理员A -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <c:if test="${bean.magea != ''}">
			                                 ${fn:substringBefore(bean.magea, "(")}
			                                </c:if>
			                                </div>
			                            </td>
			                            <!-- 管理员B -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <c:if test="${bean.mageb != ''}">
			                                ${fn:substringBefore(bean.mageb, "(")}
			                                </c:if>
			                                </div>
			                            </td>
			                            <!-- 登记人员 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.eiUserName}
                                            </div>
			                            </td>
			                            <!-- 登记日 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.eiInsDate}
                                            </div>
			                            </td>
			                            <!-- 包含关系图 -->
<!-- 			                            <td> -->
<!-- 			                                <div class="nowrapDiv"> -->
<%-- <%-- 	                                            <a href="javascript:void(0)" onclick="searchBussies(${bean.parEntityItemVW.eiid})"><img src="images/relationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.belongrelationshipDiagram.alt"/>' width="16" height="16"  border="0"/></a> --%> 
<!-- 			                                </div> -->
<!-- 			                            </td> -->
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
<%--                 <html:hidden property="ecategory" styleId="ecategory" value="${IGCIM0135Form.ecategory}"/> --%>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>