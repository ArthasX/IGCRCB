<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0111" toScope="request"/>
<bean:define id="title" value="接待工作明细画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间
	
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
            <html:form styleId="form" action="/IGLOM0111" onsubmit="return checkSubmit(this);">
          	<div id="location">
                <div class="image"></div>
                    <p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 接待月度汇总 &gt;&gt; 接待工作明细</p>
                <div class="back"><html:link action="/IGLOM0106.do?year=${IGLOM0111Form.year}">返回</html:link></div> 
            	</div>
          		
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>
					           <th width="15%">接待工作名称</th>
					           <th width="15%">申请部门</th>
					           <th width="12%">接待人数规模</th>
					           <th width="12%">接待标准</th>
					           <th width="12%">开始日期</th>
					           <th width="12%">结束日期</th>
					           <th width="7%">状态</th>
					           <th width="15%">详细信息</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGLOM01111VO" property="recptionList" >
			                    <logic:iterate id="bean" name="IGLOM01111VO" property="recptionList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <!-- 接待工作名称 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.rname}</div>
			                            </td>
			                            <!-- 申请机构 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.organizationTB.orgname}</div>
			                            </td>
			                            <!-- 接待人数规模 -->
			                            <td>
			                                <div class="nowrapDiv"><ig:cseCodeValue codeIndex="<%=CodeUtils.RECPTION_RSCALE%>" codeValue="${bean.rscale}" /></div>
			                            </td>
			                            <!-- 接待标准 -->
			                            <td>
			                                <div class="nowrapDiv"><ig:cseCodeValue codeIndex="<%=CodeUtils.RECPTION_RSTANDARD%>" codeValue="${bean.rstandard}" /></div>
			                            </td>
			                            <!-- 开始日期 -->
			                            <td>
			                                <div class="nowrapDiv">${bean.rstime}</div>
			                            </td>
			                            <!-- 结束日期 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.retime}</div>
			                            </td>
			                            <!-- 状态  进行中:1   结束:2 -->
			                            <td>
			                                <div class="nowrapDiv"><ig:cseCodeValue codeIndex="<%=CodeUtils.RECPTION_STATUS%>" codeValue="${bean.rstatus}" /></div>
			                            </td>
			                            <!-- 详细信息 -->
			                            <td><div align="center"><html:link action="/IGLOM0104_Disp.do?rid=${bean.rid}&flag=1"><img src="images/xx.gif" alt="显示详细信息" width="16" height="16"  border="0"/></html:link>&nbsp;<!-- 食堂信息 --><html:link action="/IGLOM0581.do?rid_mon=${bean.rid}"><img src="images/eatery.gif" alt="显示食堂信息" width="16" height="16"  border="0"/></html:link>&nbsp;<!-- 物品信息 --><html:link action="/IGLOM0260_Disp.do?rid=${bean.rid}&goorg=${bean.organizationTB.orgsyscoding}&lomid=lom0111"><img src="images/stock.gif" alt="显示物品信息" width="16" height="16"  border="0"/></html:link></div></td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
                            <logic:present name="IGLOM01111VO" property="recptionList" >
                            
                            </logic:present>
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>
		        <html:hidden property="year" styleId="year" name="IGLOM0111Form"/>
		        <html:hidden property="month" styleId="month" name="IGLOM0111Form"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>

</div>

</div>
</body>
</html:html>