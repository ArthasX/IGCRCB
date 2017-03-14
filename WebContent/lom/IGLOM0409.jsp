<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0409" toScope="request"/>
<bean:define id="title" value="发票部门统计明细画面" toScope="request"/>
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
		            <html:form styleId="form" action="/IGLOM0409" onsubmit="return checkSubmit(this);">
			          	<div id="location">
			                <div class="image"></div>
			                    <p class="fonts1">后勤管理 &gt;&gt;  发票管理 &gt;&gt; 发票部门统计 &gt;&gt; 发票部门统计明细</p>
			                <div class="back"><html:link action="/IGLOM0405.do">返回</html:link></div> 
			            </div>
			          		
			            <div id="results_list">
							<!--  message -->
							<ig:message/>
							<!--  /message -->     
					        <table width="100%" class="table_style">
					            <!-- header部 -->
				                <tr>
						           <th width="13%">发票类型</th>
								   <th width="20%">开票日期</th>
								   <th width="10%">发票号码</th>
								   <th width="10%">金额</th>
								   <th width="10%">申请开票部门</th>
								   <th width="8%">状态</th>
				                </tr>
					            <!-- body部 -->			  
				                <logic:present name="IGLOM04021VO" property="invoiceList" >
				                    <logic:iterate id="bean" name="IGLOM04021VO" property="invoiceList" indexId="index">
				                        <tr class="<ig:rowcss index="${index}"/>">
				                            <!-- 发票工作类型 -->
				                             <td>
				                                <div class="nowrapDiv">
				                                <ig:cseCodeValue codeIndex="<%=CodeUtils.INVOICE_ITYPE%>" codeValue="${bean.itype}" />
				                                </div>
				                            </td>
				                            <!-- 开票日期 -->
				                            <td>
				                                <div class="nowrapDiv">
				                                <logic:empty name="bean" property="idate">&nbsp;</logic:empty>
				                                ${bean.idate}
				                                </div>
				                            </td>
				                            <!-- 发票号码 -->
				                            <td>
				                                <div class="nowrapDiv">
				                                <logic:empty name="bean" property="inum">&nbsp;</logic:empty>
				                                ${bean.inum}
				                                </div>
				                            </td>
				                            <!-- 金额 -->
				                            <td>
				                                <div class="nowrapDiv">
				                                <logic:empty name="bean" property="iamount">&nbsp;</logic:empty>
				                                ${bean.iamount}                                 
				                                </div>
				                            </td>
				                            <!-- 申请开票部门-->
				                            <td>
				                                <div class="nowrapDiv">
				                                <logic:empty name="bean" property="ireqemp">&nbsp;</logic:empty>
				                                ${bean.organizationTB.orgname}                                
				                                </div>
				                            </td>
				                            <!-- 状态 -->
				                             <td>
				                                <div class="nowrapDiv">
				                                <ig:cseCodeValue codeIndex="<%=CodeUtils.INVOICE_ISTATUS%>" codeValue="${bean.istatus}" />
				                                </div>
				                            </td>
				                        </tr>
				                    </logic:iterate>
				                </logic:present>
					       </table>
					     </div>
					     <div id="operate">
			                <logic:present name="IGLOM04021VO" property="invoiceList" >
			                </logic:present>
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