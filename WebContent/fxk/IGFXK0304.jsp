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
function setUserid(){
	
	openSubWindow('/IGSYM0205.do?', 'newpage', '800', '600');
}
function setParamUser(userid, username, par){
    $('riskpeople').value = username;
}
function windowclose(){
	window.opener.windowback();
	window.close();
}
function checkForm(){
	if(jQuery("input[name='riskname']").val()==''||jQuery("input[name='riskname']").val()==undefined)
		 {
   		 alert("请输入工作名称");
   		 return false;
   	 }
	if(jQuery("select[name='riskpeople']").val()==''||jQuery("select[name='riskpeople']").val()==undefined)
		 {
   		 alert("请选择负责人！");
   		 return false;
   	 }
	if(jQuery("input[name='riskstart']").val()==''||jQuery("input[name='riskstart']").val()==undefined)
		 {
   		 alert("请输入工作开始时间！");
   		 return false;
   	 }
	if(jQuery("input[name='riskend']").val()==''||jQuery("input[name='riskend']").val()==undefined)
	 {
		 alert("请输入工作完成时间！");
		 return false;
	 }
	if(jQuery("input[name='allocationtime']").val()==''||jQuery("input[name='allocationtime']").val()==undefined)
	 {
		 alert("请输入工作提醒时间！");
		 return false;
	 }
	var start = jQuery("input[name='riskstart']").val();
	var end = jQuery("input[name='riskend']").val();
	if(start > end){
		alert("工作完成时间不能早于工作开始时间");
		return false;
	}
	form.submit();
	//return true;
}
</script>

<html:html>
<bean:define id="id" value="IGFXK0303" toScope="request" />
<bean:define id="title" value="计划任务修改" toScope="request" />

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
		<div class="image"></div>
		<p class="fonts1">计划任务修改</p>
	</div>
		 <div id="formwrapper">
		         <html:form styleId="form" action="/IGFXK0304_Edit">
                      <ig:message/>
		            <fieldset style="width: 730px;">
						<legend>计划任务修改</legend>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>工作名称</strong>：</label>
                            <html:text property="riskname" name="IGFXK0302Form"  tabindex="1"></html:text>
							
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong>工作说明</strong>：</label>
                            <html:textarea name="IGFXK0302Form" property="riskdesc" tabindex="2" errorStyleClass="inputError imeActive"  />
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>负责人</strong>：</label>
                              
                              <html:select property="riskpeople" style="width: 100px; vertical-align:middle;">
	    						<html:options collection="userLabelLst" property="value" labelProperty="label"/>
	    					  </html:select>
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>工作开始时间</strong>：</label>
                            	<html:text property="riskstart" styleId="riskstart" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
								<img src="images/date.gif" align="middle" onclick="calendar($('riskstart'))" border="0" style="cursor: hand" />
                            <br>
                        </div>

                         <div>
                            <label for="Name"><strong><span class="red">*</span>工作完成时间</strong>：</label>
                            	<html:text property="riskend" styleId="riskend" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
								<img src="images/date.gif" align="middle" onclick="calendar($('riskend'))" border="0" style="cursor: hand" />
                            <br>
                        </div>
                        
                         <div>
                            <label for="Name"><strong><span class="red">*</span>工作提醒时间</strong>：</label>
                            	<html:text property="allocationtime" styleId="allocationtime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
								<img src="images/date.gif" align="middle" onclick="showTime($('allocationtime'))" border="0" style="cursor: hand" />
                            <br>
                        </div>
                        
                        <html:hidden property="pvrownumber" name="IGFXK0302Form" />
                        <html:hidden property="prid" name="IGFXK0302Form" />
                        <html:hidden property="pidid" name="IGFXK0302Form" />
                        <html:hidden property="mode" name="IGFXK0302Form" />
		            </fieldset>
		            <div style="margin-left: 300px">
		                <html:button property="btn_insert" value="提交" styleClass="button"  onclick="checkForm();"  />
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
