<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.03 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0319" toScope="request"/>
<bean:define id="title" value="借款信息画面" toScope="request"/>
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
            <html:form styleId="form" action="/IGLOM0314" onsubmit="return checkSubmit(this);">
          	<div id="location">
                <div class="image"></div>
	               <c:if test="${IGLOM0304Form.flag == '1' }">
                    <p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 接待月度汇总 &gt;&gt; 接待工作明细 &gt;&gt; 借款信息</p>
		           		<div class="back"><html:link action="/IGLOM0111_Back.do">返回</html:link></div> 
		           </c:if>
	               <c:if test="${IGLOM0304Form.flag == '2' }">
                    <p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 部门接待汇总 &gt;&gt; 接待工作明细 &gt;&gt; 借款信息</p>
		           		<div class="back"><html:link action="/IGLOM0113_Back.do">返回</html:link></div> 
		           </c:if>
		            <c:if test="${IGLOM0304Form.flag == '3' }">
                    <p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 接待客人查询 &gt;&gt; 借款信息</p>
		           		<div class="back"><html:link action="/IGLOM0114_Back.do">返回</html:link></div> 
		           </c:if>
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
					           <th width="20%">借款金额</th>
					           <th width="30%">用途</th>
					           <th width="10%">状态</th> 
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGLOM03041VO" property="loanPayDetailList" >
			                    <logic:iterate id="bean" name="IGLOM03041VO" property="loanPayDetailList" indexId="index">
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
			                            <!-- 用途 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.lpdcomment}</div>
			                            </td>
			                            <!--状态 -->
		                            	<td>
                                           	<div class="nowrapDiv">
                                           		<ig:cseCodeValue codeIndex="<%=CodeUtils.LOANPAYDETAIL_LPDSTATUS%>" codeValue="${bean.lpdstatus}" />
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
			    <html:hidden property="rid_q" styleId="rid_q" name="IGLOM0304Form"/>
			    <html:hidden property="lpdstatus_q" styleId="lpdstatus_q" name="IGLOM0304Form"/>
			    <html:hidden property="lpdtype_q" styleId="lpdtype_q" name="IGLOM0304Form"/>
			    <html:hidden property="rstatus" styleId="rstatus" name="IGLOM0304Form"/>
			    <html:hidden property="flag" styleId="flag" name="IGLOM0304Form"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>

</div>

</div>
</body>
</html:html>