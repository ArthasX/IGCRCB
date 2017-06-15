<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGLOG0105" toScope="request"/>
<bean:define id="title" value="告警屏蔽设定画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		window.onunload = function(){ 
        	this.opener.location.href = getAppRootUrl()+'/IGLOG0101_Search.do';    
		};

	
		//画面再表示
		function confirmDisp(){
	    	//if($F('ip_eq').trim()==""){
	    	//	alert("请输入ip地址！");
	    	//	return false;
	    	//}
	    	window.close();
			return true;
		}

	</script>
<body>
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<div> 
 <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="formwrapper">
            	<fieldset>
            	<legend>屏蔽规则录入</legend>
		         <html:form styleId="IGLOG0101Form" action="/IGLOG0101_Filter" onsubmit="return checkSubmit(this);" >
		            <div >
		                <label for="Name"><strong>IP</strong>：</label>
		                <html:text name="IGLOG0101Form" property="ip_eq"  value="${IGLOG0101VO.syslogbean.deviceip}" />
		            </div>
		            <div>
		                <label for="Name"><strong>级别</strong>：</label>
		                <html:select property="priority_eq" value="${IGLOG0101VO.syslogbean.rulelevel}">
		               		<ig:optionsCollection ccid="SYSLOGALARM_PRIORITY" isMakeBlankRow="true" isCodeLabel="true" />
		                </html:select>
		            </div>
		            
		            <div>
		                <label for="Name"><strong>内容</strong>：</label>
		                <html:textarea cols="30" rows="6" name="IGLOG0101Form" property="content" value="${IGLOG0101VO.syslogbean.alarmmsg}" errorStyleClass="inputError imeActive" />
		            </div>
			        
		            <div class="enter">
		            	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp;
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
		                <input type="button" class="button" value="取消" onclick="window.close();">
		            </div>
 		         </html:form>
 		      </fieldset>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>
