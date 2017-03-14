<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM0606" toScope="request"/>
<bean:define id="title" value="演练计划管理" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
	function checkForm(){
		return true;
	}
</script>

<body onLoad="">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
        
	<html:form styleId="form" action="/IGDRM0605" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
				<p class="fonts1">应急演练 >> 演练计划管理 >> 演练计划查询</p>
                    
            </div>   
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
                          
                           <label><span class="red"></span>演练计划编号：</label> 
                           
                           <html:text property="dserial" styleId="dserial" errorStyleClass="inputError imeActive" readonly="" tabindex="1"/>
			               
			               <label>&nbsp;&nbsp;演练计划名称：</label>
			               
			               <html:text property="dname" styleId="dname" errorStyleClass="inputError imeDisabled" size="12" tabindex="2"/>

<%--                           <label>&nbsp; &nbsp; 创建日期 :</label> <html:select property="crttimestart" styleId="crttimestart" value="${crttimestart }" style="width: 60px;" errorStyleClass="inputError"> --%>
<%-- 	 							<ig:optionsCollection ccid="YEAR_CODE"  isMakeBlankRow="false" isCodeLabel="true" /> --%>
<%-- 	 										</html:select>年&nbsp;&nbsp; --%>
                           	<span>&nbsp;&nbsp;时间：从</span>
							<html:text property="propentime" styleId="propentime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
							<img src="images/date.gif" align="middle" onclick="calendar($('propentime'))" border="0" style="cursor: hand" />
					
							<span>&nbsp;&nbsp;到</span>
							<html:text property="prclosetime" styleId="prclosetime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
							<img src="images/date.gif" align="middle" onclick="calendar($('prclosetime'))" border="0" style="cursor: hand" />
                           
                           <html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkForm();"/>
	                       <!-- 是否具有审批权限 -->
	                       <html:hidden property = "isAdmin" value="${IGDRM0602Form.isAdmin}" />
	                       
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
					           <th width="10%">演练计划编号</th>
					           <th width="13%">演练计划名称</th>
					           <th width="10%">制定人</th>
					           <th width="6%">创建时间</th>	
					           <th width="10%">演练中</th>
					           <th width="10%">完成数量</th>
					          <!--  <th width="5%">修订</th>
					           <th width="5%">删除</th> -->
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGDRM06021VO" property="searchDrillplanMap" >
			                    <logic:iterate id="bean" name="IGDRM06021VO" property="searchDrillplanMap" indexId="index">
			                       <tr class="<ig:rowcss index="${index}" />"  style='cursor:hand' onmouseover="mouseOver(this);" onmouseout="mouseOut(this);" 
			                       onclick="doLook(getAppRootUrl()+'/IGDRM0605_SEE.do?did=${bean['DID']}');">
			                            <td >
			                            	${bean['DSERIAL']}
			                            </td>
			                            <td>
				                            ${bean['DNAME']}
			                            </td>
			                            <td>
				                            ${bean['DUSERNAME']}
			                            </td>
			                            <td>
			                            	${bean['CRTTIME']}
			                            </td>
			                          
			                              <td>
			                            	<c:if test="${bean['DRILLINGCOUNT']==NULL}">
			                            		0
			                            	</c:if>
			                            	<c:if test="${bean['DRILLINGCOUNT']!=NULL}">
			                            		${bean['DRILLINGCOUNT']}
			                            	</c:if>
			                            </td>
			                              <td>
				                            	<c:if test="${bean['COMPLETECOUNT']==NULL}">
				                            	0
				                            	</c:if>
				                            	<c:if test="${bean['COMPLETECOUNT']!=NULL}">
				                            	${bean['COMPLETECOUNT']}
				                            	</c:if>
				                            	
												/${bean['TOTALITEM']}
			                            </td>
			                            <%-- <td>
			                            		<html:link action="/IGDRM0601_EditDisp.do?did=${bean.did}">
													<img src="images/edit.gif" width="16" height="16"  border="0" alt="修订"/>
			                            		</html:link>
			                           	</td>
			                            <td>
			                            		<html:link action="/IGDRM0602_Dele.do?&did=${bean.did}">
			                            			<img src="images/delete.gif" width="16" height="16"  border="0" alt="删除"/>
			                            		</html:link>
			                            	
			                            </td>
			                            <td style="display:none;">
			                            	<c:if test="${IGDRM0602Form.isAdmin!='T'}">
					                            <c:if test="${bean.judgestatus=='#' or bean.judgestatus=='f'}">
					                            	<html:link action="/IGDRM0602_ToJudge.do?did=${bean.did}">
														送审
					                            	</html:link>
					                            </c:if>
					                       	</c:if>
			                            	<c:if test="${IGDRM0602Form.isAdmin=='T'}">
					                            <c:if test="${bean.judgestatus=='a'}">
					                            	<html:link action="/IGDRM0602_Judge.do?did=${bean.did}&isthrough=T">
														审批通过
					                            	</html:link>
					                            	<html:link action="/IGDRM0602_Judge.do?did=${bean.did}&isthrough=F">
														驳回
					                            	</html:link>
					                            </c:if>
					                       	</c:if>
				                        </td> --%>
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