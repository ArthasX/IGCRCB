<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGRDP0103" toScope="request"/>
<bean:define id="title" value="日志详细画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->

<script type="text/javascript">	

	function load(){
	}
	
    function checkForm(){
    }
</script>
<body onload="load();">
<div id="maincontent">
<div id="container"> 
 <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">远程部署&gt;&gt; 远程升级 &gt;&gt;升级任务查看&gt;&gt;日志查看
                </p>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGRDP0101_Insert" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					<legend>任务信息</legend>
					${IGRDP01021VO.log }
    			</fieldset>

				<div class="enter">
					<html:button property="btn_close" onclick="javasript:window.close();" styleClass="button">关闭</html:button>
				</div>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>