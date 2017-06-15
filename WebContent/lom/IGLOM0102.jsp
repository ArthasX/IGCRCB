<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGLOM0102" toScope="request" />
<bean:define id="title" value="接待客人登记画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		function timeShow(){
			time.style.display="";
	    }

		function confirmDisp(){
			var message = '';
            if ('${IGLOM0102Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="接待客人基本信息" />';
            } else {
                message = '<bean:message key="IGCO10000.W003" arg0="接待客人基本信息" />';
            }
            if($F('rgname').trim()==""){
	    		alert("请输入接待客人姓名！");
	    		return false;
	    	}
	    	if($F('rgname').strlen()>32){
	    		alert("接待客人姓名不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	if($F('rgpost').strlen()>64){
	    		alert("职务不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	if($F('rgtel').strlen()>128){
	    		alert("联系方式不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	if($F('rgunit').strlen()>128){
	    		alert("单位不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
	    		return false;
	    	}

			if( window.confirm(message)){
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
<div id="container"> <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">后勤管理&gt;&gt; 接待管理 &gt;&gt; 接待工作管理 &gt;&gt; 详细信息 &gt;&gt;
	                <logic:equal name="IGLOM0102Form" property="mode" value="0">
	                                             接待客人登记
	                </logic:equal>
					<logic:equal name="IGLOM0102Form" property="mode" value="1">
					  接待客人变更
					</logic:equal>
                </p>
                <div class="back"><a href="IGLOM0104_Disp.do?rid=${IGLOM0102Form.rid}" target="_self">返回</a></div> 
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGLOM0102" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
               	<fieldset>
					<logic:equal name="IGLOM0102Form" property="mode" value="0">
					    <legend> 接待客人登记</legend>
					</logic:equal>
					<logic:equal name="IGLOM0102Form" property="mode" value="1">
	                    <legend> 接待客人变更</legend>
					</logic:equal>
    				
	   					<div>
	             			<label for="Name"><strong><span class="red">*</span>客人姓名</strong>：</label>
	             			<html:text property="rgname" name="IGLOM0102Form"  size="18" tabindex="1" errorStyleClass="inputError" />
	             		</div>
	    				<div>
	              			<label for="Name"><strong>职务</strong>：</label>
	              			<html:text property="rgpost" name="IGLOM0102Form"  size="18" tabindex="2" errorStyleClass="inputError" />
	              		</div>
	    				<div>
	              			<label for="Name"><strong>联系方式</strong>：</label>
	              			<html:text property="rgtel" name="IGLOM0102Form"  size="18" tabindex="4" errorStyleClass="inputError" />
	              		</div>
	    				<div>
	              			<label for="Name"><strong>单位</strong>：</label>
	              			<html:text property="rgunit" name="IGLOM0102Form"  size="18" tabindex="3" style="width:300px;" errorStyleClass="inputError" />
	              		</div>
              		            	
               	</fieldset>
              		  			
				<div class="enter">
					<c:if test="${IGLOM0101Form.rstatus != '2' }">
				    	<html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
				    	<html:reset property="btn_clear" styleClass="button" value="重置" />
			    	</c:if>
				</div>
		    
		        <html:hidden property="rgid" styleId="rgid" name="IGLOM0102Form"/>
		        <html:hidden property="rid" styleId="rid" name="IGLOM0102Form"/>
		        <html:hidden property="rgdate" styleId="rgdate" name="IGLOM0102Form"/>
			    <html:hidden property="mode" styleId="mode" name="IGLOM0102Form"/>
			    
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>