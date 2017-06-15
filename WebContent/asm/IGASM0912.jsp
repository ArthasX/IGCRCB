<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0912" toScope="request"/>
<bean:define id="title" value="服务商基本信息变更画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
         var gid='IGASM0912';
		 function checkForm(){
			 	if($F('eiorgname').trim()==""){
					alert("请选择所属机构！");
					return false;
				}
		    	if($F('eilabel').trim()==""){
		    		alert("请输入服务商编号！");
		    		return false;
		    	}
		    	if($F('einame').trim()==""){
		    		alert("请输入服务商名称！");
		    		return false;
		    	}if($F('eilabel').strlen()>32){
		    		alert("服务商编号不能大于32个字符！");
		    		return false;
		    	}if($F('einame').strlen()>120){
		    		alert("服务商名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
		    		return false;
		    	}if($F('eidesc').strlen()>256){
		    		alert("服务商说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
		    		return false;
		    	}if($F('eiuserid').trim() == "" || $F('eiusername').trim() == ""){
		    		alert("请选择管理人！");
		    		return false;
		    	}else {
		    		var message = '<bean:message key="IGCO10000.W003" arg0="服务商基本信息" />';
					if( window.confirm(message)){
						return true;
					} else {
						return false;
					}
		    	}
		    }
		 function setRoleDomain(url){
				url = url+"?roletype=IGAC04";
				var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
				if("_resetall"==temp){
					document.forms[0].eiorgsyscoding.value = "";
					document.forms[0].eiorgname.value = "";
					return false;
				}
				if(null!=temp && temp.split("|").length>1){
					document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
					document.forms[0].eiorgname.value = temp.split("|")[1];
				}		

			}
	    function setOrg(url){
		   	 
	    	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	    	if("_resetall"==temp){
				document.forms[0].eiorgsyscoding.value = "";
				document.forms[0].eiorgname.value = "";
				return false;
			}
	    	if(null!=temp && temp.split("|").length>1){
	    		document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
	    		document.forms[0].eiorgname.value = temp.split("|")[1];
	    	}		
		}
	    function toback(){
	        form.action = getAppRootUrl() + "/IGASM0901_Back.do?";
	        form.submit();
	    }
	    function selectRoleUser(){
			openSubWindow('/IGSYM0408.do?roletype=IGAC04' , 'newpage', '800', '600');
		}
		function setParamRoleUser(userid,username,roleid,orgid,orgname){
			$("eiuserid").value = userid;
			$("eiusername").value = username;
		}
	</script>
<body >
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
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGASM0912" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <legend>服务商基本信息变更</legend>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>模型名称</strong>：</label>
                            <html:text name="IGASM0912Form" property="ename" errorStyleClass="inputError imeActive" readonly="true" tabindex="2" styleClass="inputDisable"/>
                            <br>
                        </div>
                        <div><label for="Name"><strong><span class="red">*</span>所属机构</strong>：</label>
							<html:text name="IGASM0912Form" property="eiorgname" readonly="true" errorStyleClass="inputError imeActive"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0304.do');" alt="请选择机构"/>
							<br/>
							</div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>服务商编号</strong>：</label>
			                <html:text name="IGASM0912Form" property="eilabel" tabindex="1" errorStyleClass="inputError" readonly="true" styleClass="inputDisable"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>服务商名称</strong>：</label>
			                <html:text name="IGASM0912Form" property="einame" size="18" style="width:300px;" errorStyleClass="inputError imeActive" tabindex="2"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong>服务商说明</strong>：</label>
			                <html:text name="IGASM0912Form" property="eidesc" styleId="eidesc" size="30" tabindex="3" style="width:450px;" errorStyleClass="inputError"/>
			                <br>
			            </div>
			            <logic:present name="IGASM0912Form" property="roleManager">
			            <logic:equal value="true" name="IGASM0912Form" property="roleManager">
			            <div>
                            <label for="Name"><strong><span class="red">*</span>管理人</strong>：</label>
                            <html:text  name="IGASM0912Form" property="eiusername" styleId="eiusername" size="12" tabindex="4" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            <a href="javascript:void(0)" onclick="selectRoleUser();"><img src="images/seek.gif" alt="查询" width="16" height="16" border="0" /></a>
                            <br>
                        </div>
                        </logic:equal>
                        </logic:present>
                        <logic:present name="IGASM0912Form" property="roleManager">
                        <logic:notEqual value="true" name="IGASM0912Form" property="roleManager">
			            <div>
                            <label for="Name"><strong><span class="red">*</span>管理人</strong>：</label>
                            <html:text  name="IGASM0912Form" property="eiusername" styleId="eiusername" size="12" tabindex="4" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            <br>
                        </div>
                        </logic:notEqual>
                        </logic:present>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>登记日</strong>：</label>
                            <html:text  name="IGASM0912Form" property="eiinsdate" styleId="eiinsdate" size="12" tabindex="5" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
                            <br>
                        </div>
		            </fieldset>
		            <div class="enter">
		            	<logic:present name="IGASM0912Form" property="permission">
		            	<logic:equal value="true" name="IGASM0912Form" property="permission">
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
		                <html:reset property="btn_insert" value="重置" styleClass="button" />
		                </logic:equal>
		                </logic:present>
		            </div>
		            <html:hidden property="eiid" name="IGASM0912Form" styleId="eiid"/>
		            <html:hidden property="eid" name="IGASM0912Form" styleId="eid"/>
		            <html:hidden property="esyscoding" name="IGASM0912Form" styleId="esyscoding"/>
		            <html:hidden property="eiorgsyscoding" name="IGASM0912Form" styleId="eiorgsyscoding"/>
		            <html:hidden property="eiupdtime" name="IGASM0912Form" styleId="eiupdtime"/>
		            <html:hidden property="eistatus" name="IGASM0912Form" styleId="eistatus"/>
		            <html:hidden property="eiversion" name="IGASM0912Form" styleId="eiversion"/>
		            <html:hidden property="eilabelbak" name="IGASM0912Form" styleId="eilabelbak"/>
		            <html:hidden property="eiuserid" name="IGASM0912Form" styleId="eiuserid"/>
		            <html:hidden property="eismallversion" name="IGASM0912Form" styleId="eismallversion" value="0"/>
		         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>