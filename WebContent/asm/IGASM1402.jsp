<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM1402" toScope="request"/>
<bean:define id="title" value="服务记录基本信息登记画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
         var gid='IGASM1402';
		 function checkForm(){
		    	if($F('ename').trim()==""){
		    		alert("请选择模型名称！");
		    		return false;
		    	}
		    	if($F('eilabel').trim()==""){
		    		alert("请输入服务记录编号！");
		    		return false;
		    	}
		    	if($F('einame').trim()==""){
		    		alert("请输入服务记录名称！");
		    		return false;
		    	}
		    	if($F('eiinsdate').trim()==""){
		    		alert("请输入登记日！");
		    		return false;
		    	}if($F('eilabel').strlen()>32){
		    		alert("服务记录编号不能大于32个字符！");
		    		return false;
		    	}if($F('einame').strlen()>120){
		    		alert("服务记录名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
		    		return false;
		    	}if($F('eidesc').strlen()>256){
		    		alert("服务记录说明不能大于"+Math.floor(256/strByteFlag)+"个汉字！");
		    		return false;
		    	}else {
		    		var message = '<bean:message key="IGCO10000.W001" arg0="服务记录基本信息" />';
					if( window.confirm(message)){
						return true;
					} else {
						return false;
					}
		    	}
		    }

	   // function setOrg(url){
		   	 
	    //	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	   // 	if(null!=temp && temp.split("|").length>1){
	   // 		document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
	   // 		document.forms[0].eiorgname.value = temp.split("|")[1];
	   // 	}		

	  //  }
//	    function setRoleDomain(url){
//			url = url+"?roletype=A";
//			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
//			if(null!=temp && temp.split("|").length>1){
//				document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
//				document.forms[0].eiorgname.value = temp.split("|")[1];
//			}		

//		}
	    function setEntity(url){
		    	url = url+"?roletype=IGAC04&subtype=999009";
				var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
				if("_resetall"==temp){
					document.forms[0].ename.value = "";
					document.forms[0].eid.value = "";
					document.forms[0].esyscoding.value = "";
					return false;
				}
				if(null!=temp && temp.split("|").length>1){
					var syscode_eid = temp.split("|")[0];
					var name = temp.split("|")[1];
					var syscode;
					var eid;
					if(syscode_eid =="999")
					{
						alert("资产模型不可用！请选择其他模型！");
						return false;
						
					}else if(syscode_eid.split("_").length>1){
						eid = syscode_eid.split("_")[0];
						syscode = syscode_eid.split("_")[1];
					}
					document.forms[0].ename.value = name;
					document.forms[0].eid.value = eid;
					document.forms[0].esyscoding.value = syscode;
				}		
		}
	    function searchMaxEntityItemLable(){
			var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ parameters: 'ecategorykey=FWJL&type=eilable',
				 onSuccess:  function(req, json){
				 	var result = req.responseText;
					if(result != null && result.trim() != ""){	
						document.getElementById("eilabel").value = result;
					} else {
						document.getElementById("labelMessage").innerText = "获取编号失败！";
					}
			     }
				});
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
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGASM1402" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <logic:equal name="IGASM1402Form" property="mode" value="0">
			            <legend>服务记录基本信息添加</legend>
			            </logic:equal>
	                    <logic:equal name="IGASM1402Form" property="mode" value="1">
	                    <legend>服务记录基本信息变更</legend>
	                    </logic:equal>
                        <div>
                            <label for="Name"><strong><span class="red">*</span>模型名称</strong>：</label>
                            <html:text property="ename" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/>
                             <img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGSYM0304_ASSET.do');"/>
                            <br>
                        </div><!--
                        <div><label for="Name"><strong><span class="red">*</span>所属机构</strong>：</label>
							<html:text property="eiorgname" readonly="true" errorStyleClass="inputError imeActive"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0304.do');" alt="请选择机构"/>
							<html:hidden property="eiorgsyscoding"/>
							<br/>
							</div>
			            --><div>
			                <label for="Name"><strong><span class="red">*</span>服务记录编号</strong>：</label>
			                <html:text property="eilabel" tabindex="1" style="width:125px;" errorStyleClass="inputError" readonly="true"/>
			                <html:link onclick="searchMaxEntityItemLable()" href="javascript:void(0)">获取编号</html:link><span class="red" id="labelMessage"></span>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>服务记录名称</strong>：</label>
			                <html:text property="einame" style="width:200px;" errorStyleClass="inputError imeActive" tabindex="2"/>
			                <br>
			            </div>
			            <div>
			                <label for="Name"><strong>服务记录说明</strong>：</label>
			                <html:text property="eidesc" styleId="eidesc" tabindex="3" style="width:450px;" errorStyleClass="inputError"/>
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
		                <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
		            </div>
		             <html:hidden property="esyscoding"/>
			         <html:hidden property="eid"/>
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