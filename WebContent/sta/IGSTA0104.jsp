<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGSTA0104" toScope="request"/>
<bean:define id="title" value="合同钻取画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">


	</script>

<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">

    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <html:form styleId="form" action="/IGSTA0103_FetchData"
             onsubmit="return checkSubmit(this);">

                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table class="table_style">
			            <!-- header部 -->

			                <tr>
					           <th width="14%" >合同编号</th>
					           <th width="15%">合同名称</th>
					           <th width="12%">合同类别</th>
					           <th width="10%">服务商</th>
					           <th width="7%">经手人</th>
					           <th width="10%">签订时间</th>
					           <th width="7%">合同款</th>
					           <th width="7%">已付款</th>
					           <th width="7%">详细信息</th>
			                </tr>
			  
			            <!-- body部 -->
			            
			                <logic:present name="IGSTA01031VO" property="entityItemCompactVWInfoList" >
			                    <logic:iterate id="bean" name="IGSTA01031VO" property="entityItemCompactVWInfoList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <!-- 编号 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                ${bean.eilabel}
			                                </div>
			                            </td>
			                            <!-- 名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="einame">&nbsp;</logic:empty>
			                                ${bean.einame}
			                                </div>
			                            </td>
			                            <!-- 合同类别 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="compacttype">&nbsp;</logic:empty>
			                                ${bean.compacttype}
			                                </div>
			                            </td>
			                            <!-- 服务商 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="facilitator">&nbsp;</logic:empty>
                                           	 ${fn:substringBefore(bean.facilitator,"(")}
                                            </div>
			                            </td>
			                           <!-- 经手人 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="operator">&nbsp;</logic:empty>
                                            ${bean.operator}
                                            </div>
			                            </td>
			                            <!-- 签订日 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="condudetime">&nbsp;</logic:empty>
                                            ${bean.condudetime}
                                            </div>
			                            </td>
			                            <!-- 合同款 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                 <logic:empty name="bean" property="contractpayment">&nbsp;</logic:empty>
                                            ${bean.contractpayment}
			                                </div>
			                            </td>
			                             <!-- 已付款 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                 <logic:empty name="bean" property="countmoney">&nbsp;</logic:empty>
                                            ${bean.countmoney}
			                                </div>
			                            </td>
			                            <!-- 详细信息 -->
			                            <td>
			                                <div align="center">
                                               <img src="images/xx.gif" alt="显示详细信息" style="cursor: pointer;"; onclick="openSubIGCOM0303('${bean.eiid}','${bean.eiversion}');" width="16" height="16"  border="0"/>
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