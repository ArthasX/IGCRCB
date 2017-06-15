<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDRM1005" toScope="request"/>
<logic:equal name="IGDRM1004Form" property="mode" value="0">
<bean:define id="title" value="数据信息登记画面" toScope="request"/>
</logic:equal>

<logic:equal name="IGDRM1004Form" property="mode" value="1">
<bean:define id="title" value="数据信息变更画面" toScope="request"/>
</logic:equal>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
    var gid='IGDRM1004';
		function confirmDisp(){
			if($("cvalue").value.trim()==""){
				alert("请输入数据名称！");
				return false;
			}
			var message1 = '<bean:message key="IGCO10000.W001" arg0="数据信息" />';
            var message2 = '<bean:message key="IGCO10000.W003" arg0="数据信息" />';

            if($F('businesscode').strlen()>32){
            	alert("数据编号不能大于32个字符！");
    			return false;
    		}
            if($F('cvalue').strlen()>64){
            	alert("数据名称不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
    			return false;
    		}

			if ('${IGDRM1004Form.mode}' == '0'){
	            if( window.confirm(message1)){
	                return true;
	            } else {
	                return false;
	            }
			} else {
                if( window.confirm(message2)){
                    return true;
                } else {
                    return false;
                }
			}
		}

		function toback(){
			IGDRM1004Form.action = getAppRootUrl() + "/IGDRM1001_DISP.do?back=1";
            IGDRM1004Form.submit();
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
                <p class="fonts1">应急管理 &gt;&gt; 总体预案管理&gt;&gt;  组织架构关系管理 &gt;&gt;
                <logic:equal name="IGDRM1004Form" property="mode" value="0">
                                           数据登记 
                </logic:equal>
                <logic:equal name="IGDRM1004Form" property="mode" value="1">
                                            数据变更
                </logic:equal>                    
                </p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>

            <div id="formwrapper">
		         <html:form styleId="IGDRM1004Form" action="/IGDRM1004.do?orgFlag=${orgFlag}" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
                    <fieldset>
	                    <logic:equal name="IGDRM1004Form" property="mode" value="0">
	                    <html:hidden name="IGDRM1004Form" property="route" styleId="route" value="0"/>
	                    <legend>数据登记</legend>
	                    </logic:equal>
	                    <logic:equal name="IGDRM1004Form" property="mode" value="1">
			            <legend>数据变更</legend>
	                    </logic:equal>
						<html:hidden name="IGDRM1004Form" property="ccid" styleId="ccid"/>
						<html:hidden name="IGDRM1004Form" property="ccname" styleId="ccname"/>
						<html:hidden name="IGDRM1004Form" property="pcid" styleId="pcid"/>
                        <div>
                            <label for="Name"><strong>上级数据名称</strong>：</label>
                            <logic:empty name="IGDRM1004Form" property="pcvalue">
                             <html:text styleId="pcvalue" name="IGDRM1004Form" property="pcvalue" value="${IGDRM1004Form.ccname }" size="18" style="width:300"  styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="1"/>
                            </logic:empty>
                            <logic:notEmpty  name="IGDRM1004Form" property="pcvalue">
                            <html:text styleId="pcvalue" name="IGDRM1004Form" property="pcvalue" size="18" style="width:300"  styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="1"/>
                            </logic:notEmpty>
                            <br>
                        </div>
			            <div style="display:none">
			                <label for="Name"><strong>数据编号</strong>：</label>
	                        <html:text name="IGDRM1004Form" property="businesscode" size="5" style="width:20" tabindex="2" errorStyleClass="inputError" />
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>数据名称</strong>：</label>
			                <html:text name="IGDRM1004Form" property="cvalue" size="18" style="width:300px;" errorStyleClass="inputError imeActive" tabindex="3"/>
			                <br>
			            </div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" styleClass="button"  onclick="return confirmDisp();"  >
		                	提交
		                </html:submit>
		                <html:cancel styleId="btn_cancel" styleClass="button" >
		                	返回
		                </html:cancel>
		            </div>
                    <html:hidden property="mode" styleId="mode" value="${IGDRM1004Form.mode}"/>
                     <logic:equal name="IGDRM1004Form" property="mode" value="1">
                    <html:hidden name="IGDRM1004Form" property="pccid" value="${IGDRM1004Form.pccid}"/>
                    </logic:equal>
                     <logic:equal name="IGDRM1004Form" property="mode" value="0">
                    <html:hidden name="IGDRM1004Form" property="pccid" value="${IGDRM1004Form.ccid}"/>
                    </logic:equal>
                    <html:hidden name="IGDRM1004Form" property="clevel"/>
                    <html:hidden name="IGDRM1004Form" property="psyscoding"/>
                    <html:hidden name="IGDRM1004Form" property="cdstatus"/>
 		         </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>