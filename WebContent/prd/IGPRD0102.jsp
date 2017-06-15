<%@page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.deliverik.infogovernor.prd.form.IGPRD0102Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<html:html>
<bean:define id="id" value="IGPRD0102" toScope="request"/>
<logic:equal name="IGPRD0102Form" property="mode" value="0">
<bean:define id="title" value="流程基本信息登记画面" toScope="request"/>
</logic:equal>
<logic:equal name="IGPRD0102Form" property="mode" value="1">
<bean:define id="title" value="流程基本信息变更画面" toScope="request"/>
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		var title = "主题简述";
		var desc = "内容描述";
	    function toback(){
	        IGPRD0102Form.action = getAppRootUrl() + "/IGPRD0101_Back.do";
	        IGPRD0102Form.submit();
	    }

	    function checkForm(){
				if($F('pdname').trim() == ""){
		    		alert("请输入流程名称！");
		    		return false;
		    	}
		    	if($F('pdname').strlen()>128){
		    		alert("流程名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		    		return false;
		    	}
		    	if($F('ptitlename').trim() == ""){
		    		alert("请输入"+title+"！");
		    		return false;
		    	}
		    	if(document.getElementById("ptitle").checked){
		    		if($F('ptitlename').strlen()>32){
			    		alert(title+"不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
			    		return false;
			    	}
			    }
		    	if($F('pdescname').trim() == ""){
		    		alert("请输入"+desc+"！");
		    		return false;
		    	}
		    	if(document.getElementById("pdesc").checked){
		    		if($F('pdescname').strlen()>32){
			    		alert(desc+"不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
			    		return false;
			    	}
			    }
		    	if($F('serialgenerator').strlen()>32){
		    		alert("工单号生成BL不能大于32个字符！");
		    		return false;
			    }
		    	if($F('messagegenerator').strlen()>32){
		    		alert("提醒信息生成BL不能大于32个字符！");
		    		return false;
			    }
		    	if($F('pddesc').strlen()>64){
		    		alert("流程说明不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
		    		return false;
		    	}else {
		    		var message = '';
		            if ('${IGPRD0102Form.mode}' == '0'){
		                message = '<bean:message key="IGCO10000.W001" arg0="流程基本信息" />';
		            } else {
		                message = '<bean:message key="IGCO10000.W003" arg0="流程基本信息" />';
		            }
					if( window.confirm(message)){
						document.getElementById("ptitleaccess").value = document.getElementById("ptitle").checked==true?<%=IGPRDCONSTANTS.PROCESSTITLE_DEFAULT %>:<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>;
						document.getElementById("pdescaccess").value= document.getElementById("pdesc").checked==true?<%=IGPRDCONSTANTS.PROCESSTITLE_DEFAULT %>:<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>;
						return true;
					} else {
						return false;
					}
		    	}
	    	
	    }
	    function initValue(){
		  	<c:if test = "${IGPRD0102Form.mode == '0'}">
    			
	    			document.getElementById("ptitlename").value = title;
	    			document.getElementById("pdescname").value = desc;
	    			document.getElementById("ptitle").checked=true;
	    			document.getElementById("pdesc").checked=true;
    		</c:if>
    		<c:if test = "${IGPRD0102Form.mode == '1'}">
		    		document.getElementById("ptitle").checked=true;
					document.getElementById("pdesc").checked=true;
	    			<c:if test = "${IGPRD0102Form.ptdid == null}">
						document.getElementById("ptitlename").value = title;
						document.getElementById("pdescname").value = desc;
					</c:if>
					<c:if test = "${IGPRD0102Form.ptdid != null}">
						<c:if test = "${IGPRD0102Form.ptitleaccess == '1'}">
							document.getElementById("ptitle").checked=false;
						</c:if>
						<c:if test = "${IGPRD0102Form.pdescaccess == '1'}">
							document.getElementById("pdesc").checked=false;
						</c:if>
					</c:if>
			</c:if>
    		document.getElementById("pdname").focus();
		}
	    function selectTree(){
	    	var url = "IGSYM1505_TREE.do" + "?ccid=126&selecedlast=1";
	    	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	    	if("_resetall"==temp){
	    		$("pdservicecatalog").value = "";
	    		$("pdservicecatalogname").value = "";
	    	}else if(null!=temp && temp.split("|").length>1){
	    		var id = temp.split("|")[0];
	    		var name = temp.split("|")[1];
	    		var treeccid;
	    		var treecid;
	    		var treesyscode;
	    		
	    		if(id.split("_").length>1){
	    			treeccid = id.split("_")[0];
	    			treecid = id.split("_")[1];
	    			treesyscode = id.split("_")[2];
	    		}else{
	    			treeccid = id.split("_")[0];
	    			treecid = "";
	    			treesyscode = "";
	    		}
	     
	    		if(treesyscode!=null && name!=null && treesyscode != ''){
	    			$("pdservicecatalog").value = treesyscode;
	    			$("pdservicecatalogname").value = name;
	    		}else{
	    			$("pdservicecatalog").value = '';
	    			$("pdservicecatalogname").value = '';
	    		}
	    		
	    	}		
	    }

	</script>
<body onload="initValue()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
			
            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation />
	                <logic:equal name="IGPRD0102Form" property="mode" value="0">
		                &gt;&gt;流程登记
	                </logic:equal>
					<logic:equal name="IGPRD0102Form" property="mode" value="1">
					<logic:equal value="" name="IGPRD0102Form" property="pttype">
				        &gt;&gt;流程变更
	                </logic:equal>
					</logic:equal>
                </p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
                <logic:equal name="IGPRD0102Form" property="mode" value="1">
                </logic:equal>
            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGPRD0102"  onsubmit="return checkSubmit(this);">
            	
				<!--  message -->
				<ig:message/>
				<!--  /message -->  
				 <logic:notPresent name="IGPRD0102Form" property="pttype">
							 <fieldset>
								<logic:equal name="IGPRD0102Form" property="mode" value="0">
								    <legend>基本信息添加</legend>
								</logic:equal>
								<logic:equal name="IGPRD0102Form" property="mode" value="1">
				                          <legend>基本信息变更</legend>
								</logic:equal>
							
			                    <div>
									<label for="Name"><strong><span class="red">*</span>流程名称</strong>：</label>
									<html:text name="IGPRD0102Form" property="pdname" styleId="pdname" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="1"/>
									<br>
			    				</div>
			    				<div>
									<label for="Name"><strong><span class="red">*</span>流程日志权限</strong>：</label>
									<html:select name="IGPRD0102Form" property="permission" styleId="permission" tabindex="1">
										<html:option value="<%=IGPRDCONSTANTS.RECORDLOG_PERMISSION_NO %>">无权限控制</html:option>
										<html:option value="<%=IGPRDCONSTANTS.RECORDLOG_PERMISSION_YES %>">同角色可见</html:option>
									</html:select>
									<br>
			    				</div>
			    				<html:hidden property="pttype" value="WD"/>
				       			<div>
								    <label for="Name"><strong>工单号生成BL</strong>：</label>
								    <html:text name="IGPRD0102Form" property="serialgenerator" styleId="serialgenerator" tabindex="3" size="18" style="width:450px;" errorStyleClass="inputError"/>
								    <br>
			    				</div>
				       			<div>
								    <label for="Name"><strong>提醒信息生成BL</strong>：</label>
								    <html:text name="IGPRD0102Form" property="messagegenerator" styleId="messagegenerator" tabindex="3" size="18" style="width:450px;" errorStyleClass="inputError"/>
								    <br>
			    				</div>
				       			<div>
								    <label for="Name"><strong>流程说明</strong>：</label>
								    <html:text name="IGPRD0102Form" property="pddesc" styleId="pddesc" tabindex="4" size="41" style="width:450px;" errorStyleClass="inputError"/>
								    <br>
			    				</div>
			  					<div>
			                        <label for="actname"><strong>发布位置</strong>：</label>
						            <html:select property="pdactname" errorStyleClass="inputError imeActive" styleId="pdactname">
						                <html:options collection="actionLabelValueList" property="value" name="" labelProperty="label" />
						            </html:select>
			                    </div>
			                    <div>
			                    	<label><strong>服务目录分类</strong>：</label>
			                    	<html:text property="pdservicecatalogname" styleId="pdservicecatalog" style="width:200px;"  readonly="true"/>
			                    	<html:hidden property="pdservicecatalog" styleId="pdservicecatalog"/>
			                    	<img src="images/seek.gif" alt="查询" onclick="selectTree();" style="cursor: hand"/>
			                    </div>
			    			</fieldset>
		    				
			    			<fieldset>
								<logic:equal name="IGPRD0102Form" property="mode" value="0">
								    <legend>基本表单信息设定</legend>
								</logic:equal>
								<logic:equal name="IGPRD0102Form" property="mode" value="1">
				                          <legend>基本表单信息变更</legend>
								</logic:equal>
			    				<div>
									<label for="Name"><strong><span class="red">*</span>主题简述</strong>：</label>
									<input type="checkbox" id="ptitle" />可见 &nbsp;&nbsp;显示名称：
									<html:text name="IGPRD0102Form" maxlength="32" property="ptitlename" styleId="pdname" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="1"/>
									&nbsp;&nbsp;
									<br>
			    				</div>
			    				<div>
									<label for="Name"><strong><span class="red">*</span>内容描述</strong>：</label>
									<input type="checkbox" id="pdesc" />可见 &nbsp;&nbsp;显示名称：
									<html:text name="IGPRD0102Form" maxlength="32" property="pdescname" styleId="pdname" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="1"/>
									&nbsp;&nbsp;
									<br>
			    				</div>
			    			</fieldset>
				 </logic:notPresent>
				 <logic:present name="IGPRD0102Form" property="pttype"> 
				 	  <logic:notEmpty  name="IGPRD0102Form" property="pttype">
						 	<fieldset>
								<logic:equal name="IGPRD0102Form" property="mode" value="0">
								    <legend>基本信息添加</legend>
								</logic:equal>
								<logic:equal name="IGPRD0102Form" property="mode" value="1">
				                          <legend>基本信息变更</legend>
								</logic:equal>
							
			                    <div>
									<label for="Name"><strong><span class="red">*</span>流程名称</strong>：</label>
									<html:text name="IGPRD0102Form" property="pdname" styleId="pdname" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="1"/>
									<br>
			    				</div>
			    				<div>
									<label for="Name"><strong><span class="red">*</span>流程日志权限</strong>：</label>
									<html:select name="IGPRD0102Form" property="permission" styleId="permission" tabindex="1">
										<html:option value="<%=IGPRDCONSTANTS.RECORDLOG_PERMISSION_NO %>">无权限控制</html:option>
										<html:option value="<%=IGPRDCONSTANTS.RECORDLOG_PERMISSION_YES %>">同角色可见</html:option>
									</html:select>
									<br>
			    				</div>
			    				<html:hidden property="pttype" name="IGPRD0102Form"/>
				       			<div>
								    <label for="Name"><strong>工单号生成BL</strong>：</label>
								    <html:text name="IGPRD0102Form" property="serialgenerator" styleId="serialgenerator" tabindex="3" size="18" style="width:450px;" errorStyleClass="inputError"/>
								    <br>
			    				</div>
				       			<div>
								    <label for="Name"><strong>提醒信息生成BL</strong>：</label>
								    <html:text name="IGPRD0102Form" property="messagegenerator" styleId="messagegenerator" tabindex="3" size="18" style="width:450px;" errorStyleClass="inputError"/>
								    <br>
			    				</div>
				       			<div>
								    <label for="Name"><strong>流程说明</strong>：</label>
								    <html:text name="IGPRD0102Form" property="pddesc" styleId="pddesc" tabindex="4" size="41" style="width:450px;" errorStyleClass="inputError"/>
								    <br>
			    				</div>
			    				<div>
			                        <label for="actname"><strong>发布位置</strong>：</label>
						            <html:select property="pdactname" errorStyleClass="inputError imeActive" styleId="pdactname" style="width:205px;" >
						                <html:options collection="actionLabelValueList" property="value" name="" labelProperty="label" />
						            </html:select>
			                    </div>
			                    <div>
			                    	<label><strong>服务目录分类</strong>：</label>
			                    	<html:text property="pdservicecatalogname" styleId="pdservicecatalog" style="width:200px;"  readonly="true"/>
			                    	<html:hidden property="pdservicecatalog" styleId="pdservicecatalog"/>
			                    	<img src="images/seek.gif" alt="查询" onclick="selectTree();" style="cursor: hand"/>
			                    </div>
			    			</fieldset>
		    				
			    			<fieldset>
								<logic:equal name="IGPRD0102Form" property="mode" value="0">
								    <legend>基本表单信息设定</legend>
								</logic:equal>
								<logic:equal name="IGPRD0102Form" property="mode" value="1">
				                          <legend>基本表单信息变更</legend>
								</logic:equal>
			    				<div>
									<label for="Name"><strong><span class="red">*</span>主题简述</strong>：</label>
									<input type="checkbox" id="ptitle" />可见 &nbsp;&nbsp;显示名称：
									<html:text name="IGPRD0102Form" maxlength="32" property="ptitlename" styleId="pdname" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="1"/>
									&nbsp;&nbsp;
									<br>
			    				</div>
			    				<div>
									<label for="Name"><strong><span class="red">*</span>内容描述</strong>：</label>
									<input type="checkbox" id="pdesc" />可见 &nbsp;&nbsp;显示名称：
									<html:text name="IGPRD0102Form" maxlength="32" property="pdescname" styleId="pdname" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="1"/>
									&nbsp;&nbsp;
									<br>
			    				</div>
			    			</fieldset>
				 	  </logic:notEmpty>
				 </logic:present>
				
                
                    
				<div class="enter">
				
					<%if(request.getAttribute("isInUse")==null || !IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"  />
				    <%} %>	
				</div>
		        <html:hidden property="pdid" styleId="pdid" name="IGPRD0102Form"/>
		        <html:hidden property="ptid" styleId="ptid" name="IGPRD0102Form"/>
		        <html:hidden property="mode" styleId="mode" name="IGPRD0102Form"/>
		        <html:hidden property="ptdid" styleId="mode" name="IGPRD0102Form"/>
		        <html:hidden property="ptitleaccess" styleId="mode" name="IGPRD0102Form"/>
		        <html:hidden property="pdescaccess" styleId="mode" name="IGPRD0102Form"/>
		        <html:hidden property="pttype" styleId="pttype" name="IGPRD0102Form" />
		        <html:hidden property="pdname_bak" styleId="pdname_bak" name="IGPRD0102Form"/>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>

</body>
</html:html>