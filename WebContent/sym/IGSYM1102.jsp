<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGSYM1102" toScope="request"/>
<logic:equal name="IGSYM1102Form" property="mode" value="0">
<bean:define id="title" value="数据分类信息登记画面" toScope="request"/>
</logic:equal>
<logic:equal name="IGSYM1102Form" property="mode" value="1">
<bean:define id="title" value="数据分类信息变更画面" toScope="request"/>
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		function confirmDisp(){
			var message = '';
            if ('${IGSYM1102Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="数据分类信息" />';
            } else {
                message = '<bean:message key="IGCO10000.W003" arg0="数据分类信息" />';
            }
            if($F('ccid').strlen()>3){
            	alert("编号不能大于3个字符！");
    			return false;
    		}
            if($F('ccname').strlen()>128){
            	alert("名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
    			return false;
    		}
            if($F('pcflag').strlen()>1){
            	alert("最大级数不能大于1个字符！");
    			return false;
    		}
            if($F('ccinfo').strlen()>40){
            	alert("说明不能大于"+Math.floor(40/strByteFlag)+"个汉字！");
    			return false;
    		}
			if( window.confirm(message)){
				return true;
			} else {
				return false;
			}
		}
		
	    function toback(){
	        form.action = getAppRootUrl() + "/IGSYM1102.do?org.apache.struts.taglib.html.CANCEL=1";
	        form.submit();
	    }
	</script>
<body onload="$('ccid').focus();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">系统管理 &gt;&gt; 基础数据 &gt;&gt; 
	                <logic:equal name="IGSYM1102Form" property="mode" value="0">
	                                             分类登记
	                </logic:equal>
					<logic:equal name="IGSYM1102Form" property="mode" value="1">
					分类查询 &gt;&gt; 分类变更
					</logic:equal>
                </p>
                <logic:equal name="IGSYM1102Form" property="mode" value="1">
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
                </logic:equal>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGSYM1102" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					<logic:equal name="IGSYM1102Form" property="mode" value="0">
					    <legend>数据分类信息添加</legend>
					</logic:equal>
					<logic:equal name="IGSYM1102Form" property="mode" value="1">
	                          <legend>数据分类信息变更</legend>
					</logic:equal>
                    <div>
	                    <label for="Name"><strong><span class="red">*</span>编号</strong>：</label>
	                    <logic:equal name="IGSYM1102Form" property="mode" value="0">
	                    <html:text name="IGSYM1102Form" property="ccid" size="41" style="width:300px" errorStyleClass="inputError" tabindex="1"/>
	                    </logic:equal>
						<logic:equal name="IGSYM1102Form" property="mode" value="1">
						<html:text name="IGSYM1102Form" property="ccid" size="41" style="width:300px" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="1"/>
						</logic:equal>
                        <br>
					</div>
                    <div>
						<label for="Name"><strong><span class="red">*</span>名称</strong>：</label>
						<html:text name="IGSYM1102Form" property="ccname" size="41" style="width:300px;" errorStyleClass="inputError" tabindex="2"/>
						<br>
    				</div>
    				 <div>
						<label for="Name"><strong><span class="red">*</span>最大级数</strong>：</label>
						<html:text name="IGSYM1102Form" property="pcflag" style="width:20px;" errorStyleClass="inputError" tabindex="3"/>
						<br>
    				</div>
    				<div>
					    <label for="Name"><strong><span class="red">*</span>编辑标识</strong>：</label>
					    <html:select name="IGSYM1102Form" property="cceditable" style="width: 100px;" errorStyleClass="inputError" tabindex="4">
					        <ig:optionsCollection ccid="EDIT_STATUS_CODE" isMakeBlankRow="false" isCodeLabel="true"/>
					    </html:select>
					    <br>
    				</div>
	       			<div>
					    <label for="Name"><strong>说明</strong>：</label>
					    <html:text name="IGSYM1102Form" property="ccinfo" styleId="ccdesc" tabindex="5" size="41" style="width:300px;" errorStyleClass="inputError"/>
					    <br>
    				</div>
              </fieldset>
                
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
				    <logic:equal name="IGSYM1102Form" property="mode" value="1">
				    <html:cancel styleClass="button" value="返回"/>
				    </logic:equal>
				</div>
		        <html:hidden property="mode" styleId="mode"/>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>