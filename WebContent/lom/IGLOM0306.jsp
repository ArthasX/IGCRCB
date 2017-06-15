<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.03 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0306" toScope="request"/>
<bean:define id="title" value="还款管理画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	


	
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
            <html:form styleId="form" action="/IGLOM0306" onsubmit="return checkSubmit(this);">
          	<div id="location">
                <div class="image"></div>
                    <p class="fonts1">后勤管理 &gt;&gt; 预支管理 &gt;&gt; 还款管理</p>
            	</div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
            		
            		 	<span>&nbsp;&nbsp;&nbsp;&nbsp;借款人：</span><html:text property="lpduser_q" styleId="lpduser_q" errorStyleClass="inputError imeDisabled" size="18"/>&nbsp;&nbsp;
					    <label>借款日期：从</label>
		                 <html:text property="time_from" styleId="rtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
		                 <img src="images/date.gif" align="middle" onClick="calendar($('rtime_from'))" border="0" />&nbsp;&nbsp;
		                 <label>到</label>
		                 <html:text property="time_to" styleId="rtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                     <img src="images/date.gif" align="middle" onClick="calendar($('rtime_to'))" border="0"/>
			        	   <label for="Name">借款状态：</label>
		                <span> 
			           <html:select property="spType" style="width: 100px;" errorStyleClass="inputError imeActive" >
			           <html:options collection="sp_status" property="value" name="" labelProperty="label" /></html:select>
		                </span>&nbsp;&nbsp;
			        	
			        	<html:submit property="btn_search" value="查询" styleClass="button"/>
		     		</div>
          		</div> 
          		
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>
					           <th width="5%">
					             <label>
					             </label>
					           </th>
					           <th width="10%">借款人</th>
					           <th width="15%">借款人机构</th>
					           <th width="10%">借款日期</th>
					           <th width="10%">借款金额</th>
					           <th width="10%">状态</th>
					           <th width="10%">审批人</th>
					           <th width="20%">用途</th>
					           <th width="10%">还款</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGLOM03061VO" property="loanPayDetailList" >
			                    <logic:iterate id="bean" name="IGLOM03061VO" property="loanPayDetailList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
			                            	<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
			                            </td>
			                            <!-- 借款人 -->
			                            <td>
			                                <div class="nowrapDiv">${bean.lpduser}</div>
			                            </td>
			                            <!-- 借款人机构 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.organizationTB.orgname}</div>
			                            </td>
			                            <!-- 借款日期 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.lpddate}</div>
			                            </td>
			                            <!-- 借款金额 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.lpdamount}</div>
			                            </td>
			                            <!--状态 -->
		                            	<td>
                                           	<div class="nowrapDiv">
                                           		<ig:cseCodeValue codeIndex="<%=CodeUtils.LOANPAYDETAIL_LPDSTATUS%>" codeValue="${bean.lpdstatus}" />
                                           	</div>
                                       	</td>
			                            <!-- 审批人 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.lpdpersionname}</div>
			                            </td>
			                            <!-- 用途 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.lpdcomment}</div>
			                            </td>
			                            <!-- 还款   -->
			                            <td><div align="center"><html:link action="/IGLOM0313.do?ldid=${bean.lpdid}"><img src="images/loanpay.gif" alt="还款" width="16" height="16"  border="0"/></html:link></div></td>
			                           
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
                            <logic:present name="IGLOM03061VO" property="loanPayDetailList" >
			                   
                            </logic:present>
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>
			    <html:hidden property="lpdstatus_q" styleId="lpdstatus_q" name="IGLOM0306Form"/>
			    <html:hidden property="lpdtype_q" styleId="lpdtype_q" name="IGLOM0306Form"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>

</div>

</div>
</body>
</html:html>