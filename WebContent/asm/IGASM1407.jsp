<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1407" toScope="request"/>
<logic:equal name="IGASM1407Form" property="mode" value="0">
<bean:define id="title" value="服务记录关系登记画面" toScope="request"/>
</logic:equal>
<logic:equal name="IGASM1407Form" property="mode" value="1">
<bean:define id="title" value="服务记录关系编辑画面" toScope="request"/>
</logic:equal>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
        var gid='IGASM1407';
		function confirmDisp(){
			var msgConfirm = '';
			var message1 = '<bean:message key="IGCO10000.W001" arg0="服务记录关系信息"/>';
			var message2 = '<bean:message key="IGCO10000.W003" arg0="服务记录关系信息" />';

		    if ('${IGASM1407Form.mode}' == '0'){
		    	msgConfirm = message1;
		    } else {
		    	msgConfirm = message2;
		    }
			
			if( window.confirm(msgConfirm)){
				return true;
			} else {
				return false;
			}
		}
		
        function selectEntityItem(){
            openSubIGCOM0302();
        }

        function setParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
            $("cldeid").value = eid;
            $("elabel").value = elabel;
            $("cldeiid").value = eiid;
            $("eilabel").value = eilabel;
            $("einame").value = einame;
            
        }
        
        function toback(){
            form.action = getAppRootUrl() + "/IGASM1407.do?org.apache.struts.taglib.html.CANCEL=1";
            form.submit();
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 关系管理 &gt;&gt; 
                    <logic:equal name="IGASM1407Form" property="mode" value="0">
                                                    关系登记
                    </logic:equal>
                    <logic:equal name="IGASM1407Form" property="mode" value="1">
                                                    关系编辑
                    </logic:equal>
                </p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>

		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGASM1407" onsubmit="return checkSubmit(this);">
                    <!--  message -->
                    <ig:message/>
                    <!--  /message -->     
		            <fieldset>
	                    <logic:equal name="IGASM1407Form" property="mode" value="0">
			            <legend>服务记录关系信息添加</legend>
			            </logic:equal>
	                    <logic:equal name="IGASM1407Form" property="mode" value="1">
	                    <legend>服务记录关系信息变更</legend>
	                    </logic:equal>
                        <div>
                            <label for="Name"><strong>服务记录模型编号(父)</strong>：</label>
                            <html:text property="pareilabel" size="18" style="width:85"  styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="1"/>
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong>服务记录编号(父)</strong>：</label>
                            <html:text property="pareiid" size="18" style="width:85"  styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="1"/>
                            <br>
                        </div>
                        <div>
                            <label for="Name"><strong>服务记录名称(父)</strong>：</label>
                            <html:text property="pareiname" size="18" style="width:300px;" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/>
                            <br>
                        </div>
	                    <div>
	                        <label for="Name"><strong><span class="red">*</span>模型编号(子)</strong>：</label>
	                        <logic:equal name="IGASM1407Form" property="mode" value="0">
	                        <html:text property="elabel" size="18" style="width:85" errorStyleClass="inputError imeActive" tabindex="1"/>
	                        <html:button property="btn_entity" styleClass="button" value="查询" onclick="selectEntityItem();"/>
	                        </logic:equal>
	                        <logic:equal name="IGASM1407Form" property="mode" value="1">
	                        <html:text property="elabel" size="18" style="width:85"  styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="1"/>
	                        </logic:equal>                        
	                        <br>
	                    </div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>配置项编号(子)</strong>：</label>
	                        <logic:equal name="IGASM1407Form" property="mode" value="0">
			                <html:text property="eilabel" size="18" style="width:85" errorStyleClass="inputError imeActive" tabindex="1"/>
			                </logic:equal>
	                        <logic:equal name="IGASM1407Form" property="mode" value="1">
	                        <html:text property="eilabel" size="18" style="width:85"  styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="1"/>
	                        </logic:equal>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong>配置项名称(子)</strong>：</label>
			                <html:text property="einame" size="18" style="width:300px;" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/>
			                <br>
			            </div>
	                    <div>
	                        <label for="Name"><strong><span class="red">*</span>关系</strong>：</label>
	                        <html:select property="eirrelation" style="width: 120px;" errorStyleClass="inputError" tabindex="4">
	                            <ig:optionsCollection ccid="ENTITY_ITEM_RELATION_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
	                        </html:select>
	                        <br>
	                    </div>
			            <div>
			                <label for="Name"><strong>说明</strong>：</label>
			                <html:text property="eirdesc" size="30" styleId="eirdesc" tabindex="3" style="width:450px;" errorStyleClass="inputError"/>
			                <br>
			            </div>
		            </fieldset>
		            <div class="enter">
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return confirmDisp();"  />
		                <html:cancel styleClass="button" value="返回"/>
		            </div>
		             <html:hidden property="pareiid" styleId="pareiid"/>
                    <html:hidden property="eiridStr" styleId="eiridStr"/>
                    <html:hidden property="cldeiid" styleId="cldeiid"/>
                    <html:hidden property="cldeid" styleId="cldeid"/>
                    <html:hidden property="mode" styleId="mode"/>
                    <html:hidden property="eirinfo" styleId="eirinfo"/>
		         </html:form>
		    </div>
        </div>
    </div>
</div>


</div>
</body>
</html:html>