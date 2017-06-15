<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>

<html:html>
<bean:define id="id" value="IGPRD0126" toScope="request"/>
<bean:define id="title" value="流程级联登记画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	function confirmDisp(){
		
		if($("initiativepidid").value.trim()==""){
			alert("请选择主动表单！");
			return false;
		}
		if($('passivitypidname').value.trim()==""){	
			alert("请选择被动表单！");
			return false;
			
		}
		if($F('initiativepidid') == $F('passivitypidid')){
			alert("主动表单和被动菜单不能为同一个！请重新选择！");
			$('passivitypidid').value = "";
            $("passivitypidname").value = "";
            return false;
		}
		if($("pldesc").value.trim()==""){
			alert("请填写表单联动描述！");
			return false;
		}
		if($("plblname").value.trim()==""){
			alert("请填写表单联动调用bl！");
			return false;
		}
		if($("pljsevent").value.trim()==""){
			alert("请填写表单联动js名称！");
			return false;
		}
		
		if($("pljtype").value.trim()==""){
			alert("请选择表单联动类型！");
			return false;
		}

		if($F('pldesc').strlen()>64){
			alert("表单联动描述"+Math.floor(64/strByteFlag)+"个汉字！");
			return false;
		}
		if($F('plblname').strlen()>32){
			alert("表单联动调用bl不能长于32位！");
			return false;
		}
		if($F('pljsevent').strlen()>32){
			alert("表单联动js名称不能长于32位！");
			return false;
		}
		else{
			return true;
			}
		
	}
	
	function setInitial(pidid){
		 var url = "IGPRD0125_Setinitial.do?pidmode=0&pdid="+pidid;
		 var temp = window.showModalDialog(url,this,"dialogWidth:400px;dialogHeight:500px;center:yes;scroll:yes;status:no;help:no;resizable:yes");
	}
	function setPassivitypid(pidid){
		 var url = "IGPRD0125_Setpassivity.do?pidmode=0&pdid="+pidid;
		 var temp = window.showModalDialog(url,this,"dialogWidth:400px;dialogHeight:500px;center:yes;scroll:yes;status:no;help:no;resizable:yes");
	}
	function setPid(pidid,pidname){
		if(pidid == "" && pidname == ""){
            $('initiativepidid').value = "";
            $("initiativepidname").value = "";
     }else{
            $('initiativepidid').value = pidid;
            $("initiativepidname").value = pidname;
     }
	}
	function setPid_p(pidid,pidname){
		if(pidid == "" && pidname == ""){
            $('passivitypidid').value = "";
            $("passivitypidname").value = "";
     }else{
            $('passivitypidid').value = pidid;
            $("passivitypidname").value = pidname;
     }
	}
	function addsubmit(pdid){
		if(confirmDisp()){
		if( window.confirm("是否确认增加该级联？")){
			IGPRD0125Form.action = getAppRootUrl() + "/IGPRD0125_Insert.do?pdid="+pdid;
			IGPRD0125Form.submit();
		}
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
                <p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 表单联动管理 &gt;&gt;表单联动登记
	            </p>
	            <div class="back"><a href="IGPRD0125_Disp.do?pdid=${IGPRD0125Form.pdid}" target="_self">返回</a></div> 
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGPRD0125_Insert" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					   <legend>表单联动登记</legend>
                    <div>
						<label for="Name"><strong><span class="red">*</span>主动表单</strong>：</label>
						<html:text name="IGPRD0125Form" property="initiativepidname" styleId="pldesc" size="20" style="width:150px;" errorStyleClass="inputError" tabindex="1" readonly="true"/>
						<html:hidden property="initiativepidid"/>
						<img src="images/seek.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setInitial('${IGPRD0125Form.pdid}');" alt="请选择主动表单"/>
						<br>
    				</div>
                    <div>
						<label for="Name"><strong><span class="red">*</span>联动表单</strong>：</label>
						<html:text name="IGPRD0125Form" property="passivitypidname" styleId="pldesc" size="20" style="width:150px;" errorStyleClass="inputError" tabindex="2" readonly="true"/>
						<html:hidden property="passivitypidid"/>	
						<img src="images/seek.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setPassivitypid('${IGPRD0125Form.pdid}');" alt="请选择联动表单"/>
						<br>
    				</div>
                    <div>
						<label for="Name"><strong><span class="red">*</span>表单联动描述</strong>：</label>
							<html:textarea name="IGPRD0125Form" property="pldesc" styleId="pldesc" rows="3" style="width:180px;" errorStyleClass="inputError" tabindex="3"></html:textarea>
						<br>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>表单联动调用bl</strong>：</label>
							<html:text name="IGPRD0125Form" property="plblname" styleId="plblname" size="20" style="width:150px;" errorStyleClass="inputError" tabindex="4"/>
						<br>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>表单联动js名称</strong>：</label>
							<html:text name="IGPRD0125Form" property="pljsevent" styleId="pljsevent" size="20" style="width:150px;" errorStyleClass="inputError" tabindex="4"/>
						<br>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>表单联动类型</strong>：</label>
							<html:select name="IGPRD0125Form" property="pljtype">
								<ig:optionsCollection ccid="PROCESS_LINK_CODE" isMakeBlankRow="true" isCodeLabel="true"/>
							</html:select>
						<br>
    				</div>
	       			<html:hidden property="pdid"/>
    				</fieldset>
				<div class="enter">
				    <input name="add" type="button" class="button" value="提交" onclick="addsubmit('${IGPRD0125Form.pdid}');" /> 
				    <html:reset property="btn_clear" styleClass="button" value="重置" />
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