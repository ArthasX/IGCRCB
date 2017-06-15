<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1202" toScope="request"/>
<bean:define id="title" value="机柜基本信息登记画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
         var gid='IGASM1202';

		//画面再表示
		function redisplay1(){
			$("ekey1").value = "";
			$("ekey2").value = "";
			form.action = getAppRootUrl() + "/IGASM1202_ReDisp.do";
			form.submit();
		}
		function redisplay2(){
			$("ekey2").value = "";
			form.action = getAppRootUrl() + "/IGASM1202_ReDisp.do";
			form.submit();
		}
		function redisplay3(){
			form.action = getAppRootUrl() + "/IGASM1202_ReDisp.do";
			form.submit();
		}

		function confirmDisp(){
			var message = '<bean:message key="IGCO10000.W001" arg0="机柜基本信息" />';
			if( window.confirm(message)){
				return true;
			} else {
				return false;
			}
		}

	    function selectEntity(){
	    	openSubIGCOM0301('1','008');
	    }

	    function setParamIGCOM0301(eid, elabel,ename) {
            $("eid").value = eid;
			$("elabel").value = elabel;
            $("ename").value = ename;           
		}
	</script>
<body onload="$('elabel').focus();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/>
                </p>
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGASM1202" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <logic:equal name="IGASM1202Form" property="mode" value="0">
			            <legend>机柜基本信息添加</legend>
			            </logic:equal>
	                    <logic:equal name="IGASM1202Form" property="mode" value="1">
	                    <legend>机柜基本信息变更</legend>
	                    </logic:equal>
	                    <div>
	                        <label for="Name"><strong><span class="red">*</span>模型编号</strong>：</label>
	                        <html:text property="elabel" size="18" style="width:85" tabindex="1" errorStyleClass="inputError imeActive" />
	                        <html:button property="btn_entity" styleClass="button" value="查询" onclick="selectEntity();"/>
	                        <br>
	                    </div>
                        <div>
                            <label for="Name"><strong>模型名称</strong>：</label>
                            <html:text property="ename" size="18" style="width:300px;" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/>
                            <br>
                        </div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>机柜编号</strong>：</label>
			                <html:text property="eilabel" size="18" style="width:85" tabindex="1" errorStyleClass="inputError imeActive" />
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>名称</strong>：</label>
			                <html:text property="einame" size="18" style="width:300px;" errorStyleClass="inputError imeActive" tabindex="2"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong>说明</strong>：</label>
			                <html:text property="eidesc" styleId="eidesc" size="30" tabindex="3" style="width:450px;" errorStyleClass="inputError"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong>状态</strong>：</label>
			                <html:select property="eistatus" style="width: 120px;" errorStyleClass="inputError" tabindex="4">
			                    <ig:optionsCollection ccid="ENTITY_ITEM_STATUS_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
			                </html:select>
			                <br>
			            </div>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>登记日</strong>：</label>
                            <html:text property="eiinsdate" styleId="eiinsdate" size="12" tabindex="5" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiinsdate'))" border="0"/>
                            <br>
                        </div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
		            </div>
                    <html:hidden property="eid" styleId="eid"/>
                    <html:hidden property="eiid" styleId="eiid"/>
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