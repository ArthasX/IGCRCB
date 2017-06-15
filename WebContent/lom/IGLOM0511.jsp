<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0511" toScope="request"/>
<bean:define id="title" value="接待工作查询画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
	WebCalendar.timeShow   = false  ;        //是否返回时间
	function checkSearch(){
		if(!checkDateWithTimeShow("rtime_from","rtime_to")){
			alert("开始日期不能晚于结束日期！");
			return false;
		}else{
			return true;
		}

	}
	
	 function setParentValue(rid,rname){
         if(!window.opener.closed){
             window.opener.setParentValue(rid,rname);
         }
         window.close();
     }
	 function clearParentValue(){
         if(!window.opener.closed){
        	 window.opener.setParentValue("","");
         }
         window.close();
     }
</script>

<body style="background-color: white; background-image: none;" >
<div id="maincontent">
<div id="container">
	<div id="location">
		<div class="image"></div>
			<p class="fonts1">接待工作查询</p>
	</div>
            <html:form styleId="form" action="/IGLOM0103_Search" onsubmit="return checkSubmit(this);">
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
			         
		                 <label>日期：从</label>
		                 <html:text property="rtime_from" styleId="rtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
		                 <img src="images/date.gif" align="middle" onClick="calendar($('rtime_from'))" border="0" />&nbsp;&nbsp;
		                 <label>到</label>
		                 <html:text property="rtime_to" styleId="rtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                     <img src="images/date.gif" align="middle" onClick="calendar($('rtime_to'))" border="0"/>
			        	 
			        	 <html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkSearch();"/>
		     		</div>
          		</div> 
          		
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>
					       
					           <th width="30%">接待工作名称</th>
					           <th width="30%">申请部门</th>
					           <th width="20%">接待人数规模</th>
					           <th width="20%">接待标准</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGLOM01031VO" property="recptionList" >
			                    <logic:iterate id="bean" name="IGLOM01031VO" property="recptionList" indexId="index">
			                        <tr onmouseover="mouseOver(this);" 
										onmouseout="mouseOut(this,'');" 
										onclick="setParentValue('${bean.rid}','${bean.rname}')">
			                            
			                            <!-- 接待工作名称 -->
			                            <td>
			                                <div class="nowrapDiv">
                                              ${bean.rname}
			                                </div>
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
			                            
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			                <div class="enter">
							<html:button property="btn_add" value="关闭" styleClass="button" onclick="window.close();"  />
							<input id="parent" type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
							</div>
			    </div>
            </html:form>
 
    <div class="zishiying"></div>

</div>

</div>
</body>
</html:html>