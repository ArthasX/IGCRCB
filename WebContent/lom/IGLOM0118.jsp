<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0118" toScope="request"/>
<bean:define id="title" value="外出就餐工作明细画面" toScope="request"/>
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
                    <p class="fonts1">后勤管理 &gt;&gt; 就餐管理 &gt;&gt; 外餐月度汇总 &gt;&gt; 外出就餐明细</p>
                <div class="back"><html:link action="/IGLOM0117.do?year=${IGLOM0118Form.year}">返回</html:link></div> 
            	</div>
          		
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>
					          
					          <th width="15%">申请部门名称</th>
					           <th width="10%">申请时间</th>
					           <th width="10%">就餐人数</th>
					           <th width="10%">就餐金额</th>
					           <th width="10%">发票编号</th>
					           <th width="10%">其他参与者</th>
					           <th width="25%">描述信息</th>
					           <th width="10%">物品信息</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGLOM01111VO" property="dealList" >
			           
			                    <logic:iterate id="bean" name="IGLOM01111VO" property="dealList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                           
			                            <!-- 申请机构 -->
			                             <td>
			                                <div class="nowrapDiv">${bean.deptName}</div>
			                            </td>
			                             <td>
			                                <div class="nowrapDiv">${bean.dealTime}</div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv"><ig:cseCodeValue codeIndex="<%=CodeUtils.RECPTION_RSCALE%>" codeValue="${bean.dealScale}" /></div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">${bean.dealCash}</div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">${bean.invoiceNumber}</div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">${bean.otherJoiner}</div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">${bean.dealDesc}</div>
			                            </td>
                                        <!-- 物品信息 -->
			                            <td>
			                            <div align="center">
			                             <html:link action="/IGLOM0260_Disp.do?rid=${bean.rid}&goorg=${bean.organizationTB.orgsyscoding}&lomid=lom0118">
			                                <img src="images/stock.gif" alt="显示物品信息" width="16" height="16"  border="0"/>
			                             </html:link>
			                             </div>
			                             </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
                            <logic:present name="IGLOM01111VO" property="dealList" >
                            
                            </logic:present>
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>
		        <html:hidden property="year" styleId="year" name="IGLOM0118Form"/>
		        <html:hidden property="month" styleId="month" name="IGLOM0118Form"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>

</div>

</div>
</body>
</html:html>