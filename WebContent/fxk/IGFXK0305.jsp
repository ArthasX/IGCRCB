<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.List"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<script type="text/javascript">

function windowclose(){
	window.close();
}
</script>

<html:html>
<bean:define id="id" value="IGFXK0303" toScope="request" />
<bean:define id="title" value="计划任务详细信息" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
	<div id="location" style="width:762px;margin-left: 10px;">
		<div class="image" ></div>
		<p class="fonts1">计划任务详细信息</p>
	</div>
		 <div id="formwrapper">
		         <html:form styleId="form" action="/IGFXK0304_Edit" onsubmit="return checkSubmit(this);">
                      <ig:message/>
		           <fieldset style="width: 730px;">
						<legend>计划任务详细信息</legend>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>工作名称</strong>：</label>
                            <html:text property="riskname" name="IGFXK0302Form"  tabindex="1" readonly="true"></html:text>
							
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong>工作说明</strong>：</label>
                            <html:textarea readonly="true" name="IGFXK0302Form" property="riskdesc" tabindex="2" errorStyleClass="inputError imeActive"  />
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>负责人</strong>：</label>
                              
                              <html:text readonly="true" property="riskpeople" style="width: 100px; vertical-align:middle;" />
	    						
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>工作开始时间</strong>：</label>
                            	<html:text property="riskstart" styleId="riskstart" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
                            <br>
                        </div>

                         <div>
                            <label for="Name"><strong><span class="red">*</span>工作完成时间</strong>：</label>
                            	<html:text property="riskend" styleId="riskend" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
                            <br>
                        </div>
                        
                         <div>
                            <label for="Name"><strong><span class="red">*</span>工作提醒时间</strong>：</label>
                            	<html:text property="allocationtime" styleId="allocationtime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
                            <br>
                        </div>
                        
                        <html:hidden property="pvrownumber" name="IGFXK0302Form" />
                        <html:hidden property="prid" name="IGFXK0302Form" />
                        <html:hidden property="pidid" name="IGFXK0302Form" />
                        <html:hidden property="mode" name="IGFXK0302Form" />
		            </fieldset>
		            <div style="margin-left: 300px">
		                <html:button property="btn_clear" styleClass="button" value="关闭" onclick="windowclose();" />
		            </div>
		         </html:form>
		    </div><!-- 修改DIV结束 -->
	
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	
</div>
</div>

</body>
</html:html>
