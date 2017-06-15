<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>

<bean:define id="id" value="IGASM2502" toScope="request"/>
<bean:define id="title" value="服务记录明细" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script>
 function toback(){
	 form.action = getAppRootUrl() + "/IGASM2501.do";
     form.submit();
        }
 </script>
<body onLoad="SwitchMenu('sub1');">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    <!--sidebar  左菜单--> 
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
<html:form styleId="form" action="/IGASM2501"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">外包管理 &gt;&gt; 服务记录 &gt;&gt; 服务记录明细</p>
                    <div class="back"><html:link href="javascript:toback();">返回</html:link></div>
            </div>    
              <logic:present name="IGASM25011VO" property="entityItemRelationDetailVWInfo" >                  
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
				
			       <table width="100%" class="table_style">
			       	<tr>
			       		<td colspan="7">
			       			<font style="font-weight:bold;"><bean:write name="IGASM25011VO" property="einame_like" />&nbsp;&nbsp;</font> 
			       		</td>
			       	</tr>
			            <!-- header部 -->
			                 <tr>
					           <th width="10%">服务记录编号</th>
					           <th width="10%">服务记录名称</th>
					           <th width="10%">服务时间(登记时间)</th>
					           <th width="10%">服务类型</th>
					           <th width="10%">服务性质</th>
					           <th width="10%">服务评价</th>
					           <th width="10%">评分</th>
			                </tr>
			            <!-- body部 -->			  
			                
			                    <logic:iterate id="bean" name="IGASM25011VO" property="entityItemRelationDetailVWInfo" type="com.deliverik.infogovernor.asset.model.IG344Info" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            
										<!--服务记录编号 -->
			                            <td>
			                                <div class="nowrapDiv">
                                               ${bean.eilabel}
			                                </div>
			                            </td>
										<!-- 服务记录名称-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="einame">&nbsp;</logic:empty>
			                                ${bean.einame}
			                                </div>
			                            </td>
										<!--服务时间(登记时间)-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="eiinsdate">&nbsp;</logic:empty>
			                                ${bean.eiinsdate}
			                                </div>
			                            </td>
			                            <!-- 服务类型-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="civalue">&nbsp;</logic:empty>
			                                ${bean.civalue}
			                                </div>
			                            </td>
										<!--服务性质 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="civalue1">&nbsp;</logic:empty>
			                                ${bean.civalue1}
			                                </div>
			                            </td>
			                            <!-- 服务评价-->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="civalue2">&nbsp;</logic:empty>
			                                ${bean.civalue2}
			                                </div>
			                            </td>
										<!--评分 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="civalue3">&nbsp;</logic:empty>
			                                ${bean.civalue3}
			                                </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			               		<tr class="<ig:rowcss index="${index}"/>">
			                            <td width="20%">
			                               <div class="nowrapDiv">
												<font style="font-weight:bold;">服务次数累计</font>
			                                </div>
			                            </td>
			                            <td> <div class="nowrapDiv">
			                            <font style="font-weight:bold;"><bean:write name="IGASM25011VO" property="fwcsSumCount"/></font>
			                            </div>
			                            </td>
			                            <td></td>
										<!-- 平均分 -->
										 <td width="20%">
			                            </td>
			                            <td> 
			                            	<div class="nowrapDiv">
												<font style="font-weight:bold;">平均分</font>
			                                </div>
			                            </td>
			                            <td>
			                            	<div class="nowrapDiv">
			                            	<font style="font-weight:bold;"><bean:write name="IGASM25011VO" property="fwpjfSumStore"/></font>
			                            	</div>
			                            </td>
			                            <td>
			                            </td>
			                  </tr>
			       </table>
			     </div>
               </logic:present> 
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>

</div>
</body>
</html:html>