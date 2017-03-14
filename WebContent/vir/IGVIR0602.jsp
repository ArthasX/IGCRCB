<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.deliverik.infogovernor.util.ASMHelper"%>
<html:html>
<bean:define id="id" value="IGVIR0602" toScope="request"/>
<bean:define id="title"  value="虚拟化关系分析" toScope="request"/>
	
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		var gid='IGVIR0602';
		WebCalendar.timeShow   = false;          //是否返回时间
		function confirmDisp(){
			var arg0= '<bean:message bundle="asmResources" key="message.IGVIR0602.001"/>';
			var alertMessage= '<bean:message bundle="asmResources" key="message.IGVIR0602.002"/>';
			var alertMax= '<bean:message bundle="asmResources" key="message.IGVIR0602.003"/>';
			var alertCount= '<bean:message bundle="asmResources" key="message.IGVIR0602.004"/>';
			var alertSelect= '<bean:message bundle="asmResources" key="message.IGVIR0602.005"/>';
			var message1 = '<bean:message key="IGCO10000.W003" arg0="'+arg0+'" />';

			<logic:present name="IGVIR06021VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGVIR06021VO" property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
				<logic:iterate id="bean" name="list" indexId="index">
					<logic:equal name="bean" property="cattach" value="1">
						<logic:equal value="1" name="bean" property="crequired">
							<logic:equal value="" name="bean" property="civalue">
							if($F('attachFile[${ADcheckCount}]').trim() == ""){
								alert('<bean:message bundle="asmResources" key="message.IGVIR0602.002"/>'+"${bean.cname}");
								return false;
							} 
							</logic:equal>
						</logic:equal>
					</logic:equal>
					<logic:equal name="bean" property="cattach" value="5">
						var flag = false;
						var submitValue = "";
						var check=document.getElementsByName("cb_civalue[${ADcheckCount}]");
						<logic:equal value="1" name="bean" property="crequired">
							for(var i=0;i<check.length;i++){
								if(check[i].checked==true){
									if(submitValue != ""){
										submitValue = submitValue + "；" + check[i].value;
									} else {
										submitValue = check[i].value;
									}
									flag = true;
								}
							}
							if(submitValue.strlen()>128){
								alert("${bean.cname}"+ '<bean:message bundle="asmResources" key="message.IGVIR0602.003"/>'+Math.floor(128/strByteFlag)+'<bean:message bundle="asmResources" key="message.IGVIR0602.004"/>');
								submitValue = "";
								return false;
							}
							if(flag){
								document.getElementById("civalue[${ADcheckCount}]").value = submitValue;
							}
							if(!flag){
								alert(alertSelect+"${bean.cname}！");
								return false;
							}
						</logic:equal>
						<logic:notEqual value="1" name="bean" property="crequired">
							for(var i=0;i<check.length;i++){
								if(check[i].checked==true){
									if(submitValue != ""){
										submitValue = submitValue + "；" + check[i].value;
									} else {
										submitValue = check[i].value;
									}
									flag = true;
								}
							}
							if(submitValue.strlen()>128){
								alert("${bean.cname}"+'<bean:message bundle="asmResources" key="message.IGVIR0602.003"/>'+Math.floor(128/strByteFlag)+'<bean:message bundle="asmResources" key="message.IGVIR0602.004"/>');
								submitValue = "";
								return false;
							}
							if(flag){
								document.getElementById("civalue[${ADcheckCount}]").value = submitValue;
							} else {
								document.getElementById("civalue[${ADcheckCount}]").value = "";
							}
						</logic:notEqual>
					</logic:equal>
					<logic:notEqual name="bean" property="cattach" value="1">
					<logic:notEqual name="bean" property="cattach" value="5">
					<logic:notEqual name="bean" property="cattach" value="6">
						<logic:equal value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim() == ""){
							alert(alertMessage+"${bean.cname}！");
							return false;
						}
						if($F('civalue[${ADcheckCount}]').trim().strlen()>128){
							alert("${bean.cname}"+alertMax+Math.floor(128/strByteFlag)+alertCount);
							return false;
						}
						</logic:equal>
						<logic:notEqual value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim().strlen()>128){
							alert("${bean.cname}"+'<bean:message bundle="asmResources" key="message.IGVIR0602.003"/>'+Math.floor(128/strByteFlag)+'<bean:message bundle="asmResources" key="message.IGVIR0602.004"/>');
							return false;
						}
						</logic:notEqual>
					</logic:notEqual>
					<logic:equal name="bean" property="cattach" value="6">
						<logic:equal value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim() == ""){
							alert(alertMessage+"${bean.cname}！");
							return false;
						}
						if($F('civalue[${ADcheckCount}]').trim().strlen()>1500){
							alert("${bean.cname}"+'<bean:message bundle="asmResources" key="message.IGVIR0602.003"/>'+Math.floor(1500/strByteFlag)+'<bean:message bundle="asmResources" key="message.IGVIR0602.004"/>');
							return false;
						}
						</logic:equal>
						<logic:notEqual value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim().strlen()>1500){
							alert("${bean.cname}"+'<bean:message bundle="asmResources" key="message.IGVIR0602.003"/>'+Math.floor(1500/strByteFlag)+'<bean:message bundle="asmResources" key="message.IGVIR0602.004"/>');
							return false;
						}
						</logic:notEqual>
				</logic:equal>
					</logic:notEqual>
					</logic:notEqual>
					<c:set var="ADcheckCount" value="${ADcheckCount+1}"/>
				</logic:iterate>
			</logic:iterate>
		</logic:present>
            if( window.confirm(message1)){
                return true;
            } else {
                return false;
            }
		}
		
        function toback(){
        	//form.action = getAppRootUrl() + "/IGAIM0124.do?org.apache.struts.taglib.html.CANCEL=1";
        	//form.submit();
        	form.action = getAppRootUrl() + "/IGVIR0601_Disp.do?EIID=${IGVIR06021VO.entityData.eiid}";
        	form.submit();
        }
        var num = 0;
        function selectEntityItem(obj,index){
            num = index;
            openSubIGCOM0327PARAM("?esyscoding="+obj+"&flag=false");
       }
        function setParamIGCOM0327(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
        	if(einame == "" && eilabel =="" ){
	            $("civalue["+num+"]").value = "";
	            $("entityItemCivalue["+num+"]").value = "";
            }else{
	            $("civalue["+num+"]").value = einame;
	            $("entityItemCivalue["+num+"]").value = einame+"("+eiid+")";
            }
        	num = 0;
        }
        
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<script type="text/javascript">
//验证
function checkSub(obj){
	if(jQuery(obj).find("#einame").val()){
		if(jQuery(obj).find("#einame").val().trim().length>128){
			alert("设备名称过长");
			return false;
		}
	}else{
		alert("请填写设备名称");
		return false;
	}
		
}
</script>
<!--container 左菜单 右侧内容-->
<div id="container">
     

    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1">
                	<ig:navigation extname1="${urlable}"/> &gt;&gt; 虚拟化配置编辑
                </p>
                <div class="back">
	                <html:link href="javascript:toback();">
	                	<bean:message bundle="asmResources" key="button.IGVIR0602.btn_toback"/>	
	                </html:link>
                </div> 
            </div>

		    <html:form styleId="form" action="/IGVIR0602" enctype="multipart/form-data" onsubmit="return checkSub(this);">
                 <div class="title">
                     <div class="name">虚拟化基本信息</div>
                 </div>
                 <div id="results_list">
				    <table class="table_style">
						<tr>
                            <th width="10%"><bean:message bundle="asmResources" key="label.IGVIR0602.ModelName"/></th>
                            <th width="15%"><bean:message bundle="asmResources" key="label.IGVIR0602.UserNO"/></th>
                            <th width="20%"><bean:message bundle="asmResources" key="label.IGVIR0602.UserName"/></th>
                            <!--<th width="10%"><bean:message bundle="asmResources" key="label.IGVIR0602.UserOrgan"/></th>-->
                            <th width="18%"><bean:message bundle="asmResources" key="label.IGVIR0602.UserRemark"/></th>
                            <th width="7%"><bean:message bundle="asmResources" key="label.IGVIR0602.UserManager"/></th>
                            <th width="8%"><bean:message bundle="asmResources" key="label.IGVIR0602.UserMarkDay"/></th>
                            
						</tr>
						
						<tr>
						  <td align="center">${IGVIR06021VO.entityData.ename}</td>
						  <td align="center">${IGVIR06021VO.entityData.eilabel}</td>
						  <td align="center"><input name="einame" id="einame" class="input1"  type="text" value="${IGVIR06021VO.entityData.einame}" size="20"/></td>
						  <!--<td>${IGVIR06021VO.eiorgname}</td>-->
						  <td><input name="eidesc" id="eidesc" class="input1"  type="text" value="${IGVIR06021VO.entityData.eidesc}" size="20"/></td>
						  <td align="center">${IGVIR06021VO.entityData.eiusername}</td>
						  <td align="center">${IGVIR06021VO.entityData.eiupdtime}</td>
						  
						</tr>
                     </table>
                  </div>
               
    <div class="title">
        <div class="name">虚拟化配置信息</div>
    </div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGVIR06021VO" property="flag">
	<logic:equal value="true" name="IGVIR06021VO" property="flag">	
	<logic:present name="IGVIR06021VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGVIR06021VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGVIR06021VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGVIR06021VO"
				property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
						<th width="15%"><bean:message bundle="asmResources" key="label.IGVIR0602.ConfigName"/></th>
						<th width="30%"><bean:message bundle="asmResources" key="label.IGVIR0602.ConfigInfo"/></th>
						<th width="25%"><bean:message bundle="asmResources" key="label.IGVIR0602.ConfigRemark"/></th>
						<th width="20%"><bean:message bundle="asmResources" key="label.IGVIR0602.Attachment"/></th>
						<!-- <th width="10%"><bean:message bundle="asmResources" key="label.IGVIR0602.Version"/></th> -->
						<!--th width="9%">更新时间</th-->
						<th></th>
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" <logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>>
							<!-- 名称 -->
							<td>
							<div class="nowrapDiv">
							<logic:equal value="1" name="bean" property="crequired">
								<span class="red">*</span>
							</logic:equal>
							<logic:empty name="bean"
								property="cname">&nbsp;</logic:empty> ${bean.cname}</div>
							</td>
							
							<!-- 编辑内容 start-->
							<td <logic:equal name="bean" property="cattach" value="5">align="left" style="padding-left: 100px;"
							</logic:equal><logic:notEqual name="bean" property="cattach" value="5">align="center"</logic:notEqual>>
							<div class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<html:file property="attachFile[${ADcount}]"
									styleId="attachFile[${ADcount}]" size="25"
									errorStyleClass="inputError imeDisabled"
									onkeydown="return false;" styleClass="imeDisabled" />
								<html:hidden property="civalue[${ADcount}]" styleId="civalue" />
							</logic:equal> 
							<logic:equal name="bean" property="cattach" value="0">
									<html:text property="civalue[${ADcount}]" styleId="civalue"
										size="40" errorStyleClass="inputError"
										styleClass="input1" />
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="2">
								<html:select property="civalue[${ADcount}]" style="width:53.5%;" errorStyleClass="inputError imeActive">
									<html:options collection="ADlist${ADmapcount}" property="value" name="" labelProperty="label" />
								</html:select>
								<c:set var="ADmapcount" value="${ADmapcount+1}"/>
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="3">
								<html:text property="civalue[${ADcount}]" styleId="civalue[${ADcount}]" 
								errorStyleClass="inputError imeDisabled" size="20" readonly="true" />
								<img src="images/date.gif" align="middle" 
								onclick="calendar($('civalue[${ADcount}]'))" border="0" style="cursor: hand" />
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="4">
								<html:text property="civalue[${ADcount}]" styleId="civalue[${ADcount}]" 
								errorStyleClass="inputError imeDisabled" size="30" readonly="true" />
								<img src="images/seek.gif" border="0" width="16" height="16" alt='<bean:message bundle="asmResources" key="img.IGVIR0602.find.alt"/>' onclick="selectEntityItem('${bean.coption}','${ADcount}')" style="cursor: hand"/> <br />
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="5">
								<logic:present name="IGVIR0602Form" property="civalue[${ADcount}]">
									<bean:define id="civalue" name="IGVIR0602Form" property="civalue[${ADcount}]" type="java.lang.String" />
									<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
										<bean:define id="cb_civalue" name="checkboxbean" property="value" type="java.lang.String" />
											<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" 
											<%=ASMHelper.isChecked(civalue,cb_civalue)?"checked='checked'":"" %> />${checkboxbean.value}
											<br />
									</logic:iterate>
								</logic:present>
								<logic:notPresent name="IGVIR0602Form" property="civalue[${ADcount}]">
									<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
										<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" />${checkboxbean.value}
										<br />
									</logic:iterate>
								</logic:notPresent>
								<html:hidden property="civalue[${ADcount}]"/>
								<c:set var="ADmapcount" value="${ADmapcount+1}"/>
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="6">
									<html:textarea property="civalue[${ADcount}]" styleId="civalue" 
										errorStyleClass="inputError" rows="5" cols="25" />
							</logic:equal>
							</div>
							</td>
							<!-- 编辑内容 end-->
							
							<!-- 配置项说明 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cdesc">&nbsp;</logic:empty> ${bean.cdesc}</div>
							</td>
							<!-- 附件 -->
							<td align="center">
							<div class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<a
									href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
								${bean.civalue} </a>
							</logic:equal></div>
							</td>
							<!-- 版本号 -->
							<!-- 
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="civersion">&nbsp;</logic:empty> ${bean.civersion}</div>
							</td>
							 -->
							<!-- 更新时间 -->
							<td align="center">
							<!--div class="nowrapDiv"><logic:empty name="bean"
								property="ciupdtime">&nbsp;</logic:empty> ${bean.ciupdtime}</div-->
						<html:hidden property="ciid" styleId="ciid" value="${bean.ciid}" />
						<html:hidden property="cid" styleId="cid" value="${bean.cid}" />
						<html:hidden property="clabel" styleId="clabel" value="${bean.clabel}" />
						<html:hidden property="ciattach" styleId="ciattach" value="${bean.cattach}" />
						<html:hidden property="eid" styleId="eid" value="${bean.eid}" />
						<html:hidden property="esyscoding" styleId="esyscoding" value="${bean.esyscoding}" />
						<html:hidden property="entityItemCivalue[${ADcount}]" styleId="entityItemCivalue[${ADcount}]"/>
						<html:hidden property="civalue_bak[${ADcount}]" styleId="civalue_bak[${ADcount}]" />
							</td>
						</tr>
						
						<c:set var="ADcount" value="${ADcount+1}"/>
					</logic:iterate>
				</table>
				</div>
				</div>
			</logic:iterate>
		</logic:present></div>
		</div>
		<script type="text/javascript">
			<!--
			var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
			//-->
		</script>
	</logic:present>
	</logic:equal>
	</logic:present>
	<div class="enter">
	<logic:present name="IGVIR06021VO" property="flag">
	<logic:equal value="true" name="IGVIR06021VO" property="flag">
	<html:submit property="btn_insert"  styleClass="button"  onclick="return confirmDisp();"  >
		<bean:message bundle="asmResources" key="button.IGVIR0602.btn_save"/>
	</html:submit>
	</logic:equal>
	</logic:present>
	<html:cancel styleClass="button" onclick="toback()">
		<bean:message bundle="asmResources" key="button.IGVIR0602.btn_toback"/>
	</html:cancel>
	</div>
	<html:hidden property="eiid" styleId="eiid" value="${IGVIR0602Form.eiid}"/>
	<html:hidden property="eiversion" styleId="eiversion" value="${IGVIR06021VO.entityData.eiversion}"/>
	<html:hidden property="eiorgsyscoding" styleId="eiorgsyscoding" value="${IGVIR06021VO.entityData.eiorgsyscoding}" />
	</html:form>
		</div>
    </div>
</div>


</div>
</body>
</html:html>