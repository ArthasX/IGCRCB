<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDRM1802" toScope="request"/>
<bean:define id="title" value="专项预案查询" toScope="request">
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
      
	</script>
<style>
	.nowrapDiv{
/* 		margin-left: 0px; */
		text-align:center;
	}
</style>
<body >
	<div id="location">
                <div class="image"></div>
                  <p class="fonts1" id = "navi"> 预案查询  </p>
     </div> 
<div id="maincontent" style="width:800px;margin: 0 auto;">
        <html:form styleId="form" action="/IGDRM1802" >
    
        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
	                <label id ="labeiname">专项预案名称:</label>
	                <html:text  property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="35"/> 
	             	<html:submit property="btn_search"  styleClass="button"><bean:message bundle="comResources" key="button.IGCOM0302.search"/></html:submit>
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
                        <th width="15%" class = "tdname">分类</th>
                        <th width="15%" class = "tdname" >编号</th>
                        <th width="15%" class = "tdname">名称</th>
                        <th width="10%">管理人</th>
	                </tr>
	       
	            <!-- body部 -->
	       
	                <logic:present name="IGDRM18021VO" property="planList" >
	                    <logic:iterate id="bean" name="IGDRM18021VO" property="planList" indexId="index">
	                        <tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="showPlan('${bean.eiid}')" >
                                      <!-- 名称 -->
                                      <td>
                                          <div class="nowrapDiv">
                                          <logic:empty name="bean" property="ename">&nbsp;</logic:empty>
                                          ${bean.ename}
                                          </div>
                                      </td>
	                            <!-- 编号 -->
	                            <td>
	                                <div class="nowrapDiv" >
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
	                            <!-- 管理人 -->
	                            <td>
	                                <div class="nowrapDiv">
	                                <logic:empty name="bean" property="eiusername">&nbsp;</logic:empty>
	                                ${bean.eiusername}
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
	    <html:hidden name="IGDRM1802Form" property="esyscoding" styleId="esyscoding"/>
	    <html:hidden name="IGDRM1802Form" property="searchFlag" styleId="searchFlag"/>
    </html:form>


</div>
</body>
<script type="text/javascript">

function showPlan(eiid){
	window.location.href=getAppRootUrl()+ "/IGDRM0702_Detail.do?sp_eiid="+eiid;
}
		
	

</script>
</html:html>