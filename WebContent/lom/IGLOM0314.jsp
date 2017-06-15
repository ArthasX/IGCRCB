<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.03 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0314" toScope="request"/>
<bean:define id="title" value="借款信息画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间

	function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="借款信息" />';
        var frm = window.document.forms[0];
        if(frm.deleteLpdid) {
	        if(frm.deleteLpdid.length > 0){
	            var bchecked = false;
	            for( i=0; i<frm.deleteLpdid.length; i++ ){
	                if (frm.deleteLpdid[i].checked == true){
		                
	                    bchecked = true;
	                }
	            }
	            if (!bchecked) {
	            	alert(message);
	                return false;
	            }
	        } else {
	          if ($("deleteLpdid").checked == false){
	              alert(message);
	              return false;
	          }  
	        }
        } else {
        	alert("没有可删除的数据！");
            return false;
        }
        
        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGLOM0314_Delete.do";
            return true;
        } else {
            return false;
        }
	}
	
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
                    <p class="fonts1">后勤管理 &gt;&gt; 接待管理&gt;&gt; 接待工作管理 &gt;&gt; 借款信息</p>
                	<div class="back"><html:link action="/IGLOM0103_Back.do">返回</html:link></div> 
            	</div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
            		
            		 	<span>&nbsp;&nbsp;&nbsp;&nbsp;借款人：</span><html:text property="lpduser_q" styleId="lpduser_q" errorStyleClass="inputError imeDisabled" size="18"/>&nbsp;&nbsp;
					
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
					           <th width="20%">借款金额</th>
					           <th width="30%">用途</th>
					           <th width="10%">状态</th> 
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGLOM03041VO" property="loanPayDetailList" >
			                    <logic:iterate id="bean" name="IGLOM03041VO" property="loanPayDetailList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
			     						<c:if test="${IGLOM0304Form.flag != '1'}">
				                            <!-- flag1汇总明细, 借款管理lpdstatus_q为空且待审批1可以删除 -->
				                            <c:if test="${IGLOM0304Form.rstatus == '1' }">
					                            <html:checkbox property="deleteLpdid" value="${bean.lpdid}"/>
					                        </c:if>
				                        </c:if>
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
			    
			     		<c:if test="${IGLOM0304Form.rstatus == '1'}">
                            <input type="button" class="button" value="增加"  onclick="window.location='IGLOM0303_Disp.do?rid=${IGLOM0304Form.rid_q}';" />
                            <logic:present name="IGLOM03041VO" property="loanPayDetailList" >
                            	<html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec();" /> 
                            </logic:present>
			     		</c:if>
     
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