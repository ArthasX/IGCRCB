<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.asset.EntityItemKeyWords" %>
<%@ page import="com.deliverik.infogovernor.util.ASMHelper"%>
<html:html>
<bean:define id="id" value="IGCIM0905" toScope="request" />
<bean:define id="title"  value="属性信息"  toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	


		
		var gid='IGCIM0104';
		var arg0= '<bean:message bundle="asmResources" key="message.IGCIM0104.005"/>';
		WebCalendar.timeShow   = false;          //是否返回时间
		function confirmDisp(){		
			var message1 = '<bean:message key="IGCO10000.W003" arg0="'+arg0+'"  />';	 
			<logic:present name="IGCIM01041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGCIM01041VO" property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
				<logic:iterate id="bean" name="list" indexId="index">
					<logic:equal name="bean" property="cattach" value="1">
						<logic:equal value="1" name="bean" property="crequired">
							<logic:equal value="" name="bean" property="civalue">
							if($F('attachFile[${ADcheckCount}]').trim() == ""){
								alert('<bean:message bundle="asmResources" key="message.IGCIM0104.001"/>'+"${bean.cname}！");
								return false;
							} 
							</logic:equal>
						</logic:equal>
					</logic:equal>
					<logic:equal name="bean" property="cattach" value="8">
						<logic:equal value="1" name="bean" property="crequired">
							<logic:equal value="" name="bean" property="civalue">
							if($F('attachFileXML[${ADcheckCount}]').trim() == ""){
								alert('<bean:message bundle="asmResources" key="message.IGCIM0104.001"/>'+"${bean.cname}！");
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
								alert("${bean.cname}"+'<bean:message bundle="asmResources" key="message.IGCIM0104.002"/>'+Math.floor(128/strByteFlag)+'<bean:message bundle="asmResources" key="message.IGCIM0104.003"/>');
								submitValue = "";
								return false;
							}
							if(flag){
								document.getElementById("civalue[${ADcheckCount}]").value = submitValue;
							} else {
								alert('<bean:message bundle="asmResources" key="message.IGCIM0104.004"/>'+"${bean.cname}！");
								return false;
							}
						</logic:equal>
						<logic:notEqual value="1" name="bean" property="crequired">
							var flag = false;
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
								alert("${bean.cname} "+'<bean:message bundle="asmResources" key="message.IGCIM0104.002"/>'+Math.floor(128/strByteFlag)+'<bean:message bundle="asmResources" key="message.IGCIM0104.003"/>');
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
					<logic:notEqual name="bean" property="cattach" value="8">
						<logic:notEqual name="bean" property="cseq" value="1">
							<logic:notEqual name="bean" property="cattach" value="5">
								<logic:notEqual name="bean" property="cattach" value="6">
								<logic:equal value="1" name="bean" property="crequired">
									if($F('civalue[${ADcheckCount}]').trim() == ""){
										alert('<bean:message bundle="asmResources" key="message.IGCIM0104.001"/>'+"${bean.cname}！");
										return false;
									}
									if($F('civalue[${ADcheckCount}]').trim().strlen()>128){
										alert("${bean.cname}"+'<bean:message bundle="asmResources" key="message.IGCIM0104.002"/>'+Math.floor(128/strByteFlag)+'<bean:message bundle="asmResources" key="message.IGCIM0104.003"/>');
										return false;
									}
								</logic:equal>
								<logic:notEqual value="1" name="bean" property="crequired">
								if($F('civalue[${ADcheckCount}]').trim().strlen()>128){
									alert("${bean.cname}"+'<bean:message bundle="asmResources" key="message.IGCIM0104.002"/>'+Math.floor(128/strByteFlag)+'<bean:message bundle="asmResources" key="message.IGCIM0104.003"/>');
									return false;
								}
								</logic:notEqual>
								</logic:notEqual>

								<logic:equal name="bean" property="cattach" value="6">
								<logic:equal value="1" name="bean" property="crequired">
								if($F('civalue[${ADcheckCount}]').trim() == ""){
									alert('<bean:message bundle="asmResources" key="message.IGCIM0104.001"/>'+"${bean.cname}！");
									return false;
								}
								if($F('civalue[${ADcheckCount}]').trim().strlen()>1500){
									alert("${bean.cname}"+'<bean:message bundle="asmResources" key="message.IGCIM0104.002"/>'+Math.floor(1500/strByteFlag)+'<bean:message bundle="asmResources" key="message.IGCIM0104.003"/>');
									return false;
								}
								</logic:equal>
								<logic:notEqual value="1" name="bean" property="crequired">
								if($F('civalue[${ADcheckCount}]').trim().strlen()>1500){
									alert("${bean.cname}"+'<bean:message bundle="asmResources" key="message.IGCIM0104.002"/>'+Math.floor(1500/strByteFlag)+'<bean:message bundle="asmResources" key="message.IGCIM0104.003"/>');
									return false;
								}
								</logic:notEqual>
								</logic:equal>

								
							</logic:notEqual>
						</logic:notEqual>
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
		var backUrl='${backUrl}';
        function toback(){
        	if(backUrl){
        		form.action = getAppRootUrl() + "/"+backUrl;
        	}else{
	        	form.action = getAppRootUrl() + "/IGCIM0901_Back.do";
        	}
        	form.submit();
        }
        var num = 0;
        function selectEntityItem(obj,index){
            num = index;
			openSubIGCOM0302PARAM("?esyscoding="+obj);
       }
        function setParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
            if(einame == "" && eilabel =="" ){
	            $("civalue["+num+"]").value = "";
	            $("entityItemCivalue["+num+"]").value = "";
            }else{
	            $("civalue["+num+"]").value = einame;
	            $("entityItemCivalue["+num+"]").value = einame+"("+eiid+")";
            }
            num = 0;
        }
        function goLook(id,v,sv,name){
        	
    		var url = "/IGAIM0141.do?eiid="+id+"&eiversion="+v+"&eismallversion="+sv+"&filename="+name;
    		openSubWindow(url, '_blank', '800', '600');
    		
        }

        
		function saveXML(id){
			document.forms[0].action =  getAppRootUrl()+"/IGAIM0104_SAVE.do?eiid="+id;
			document.forms[0].submit();
        }
        
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
	
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">
	<ig:navigation extname1="${urlable}"/> &gt;&gt; 属性信息
	</p>
<div class="back"><html:link href="javascript:toback();">
					      	<bean:message bundle="asmResources" key="button.IGCIM0104.btn_toback"/> 
				  </html:link></div>
</div>

<html:form styleId="form" action="/IGCIM0905"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name">设备基本信息</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="8%"><bean:message bundle="asmResources" key="label.IGCIM0104.ModelName"/></th>
			<th width="12%"><bean:message bundle="asmResources" key="label.IGCIM0104.DeviceNO"/></th>
			<th width="18%"><bean:message bundle="asmResources" key="label.IGCIM0104.DeviceName"/></th>
			<!--<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0104.DeviceOrgan"/></th>
			<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0104.DeviceRemark"/></th>-->
			<th width="10%"><bean:message bundle="asmResources" key="label.IGCIM0104.DeviceManager"/></th>
			<th width="10%"><bean:message bundle="asmResources" key="title.IGCIM0101.markDay"/></th>
			
		</tr>
		<tr>
			<td align="center">${IGCIM01041VO.entityData.ename}</td>
			<td>${IGCIM01041VO.entityData.eilabel}</td>
			<td>${IGCIM01041VO.entityData.einame}</td>
			<!--<td>${IGCIM01041VO.eiorgname}</td>
			<td>${IGCIM01041VO.entityData.eidesc}</td>-->
			<!--<td><ig:codeValue ccid="EQUIPMENT_STATUS_CODE" cid="${IGCIM01041VO.entityData.eistatus}"/></td>-->
			<td>${IGCIM01041VO.entityData.eiusername}</td>
			<td>${IGCIM01041VO.entityData.eiupdtime}</td>
			
		</tr>
	</table>
</div>

	<div class="title">
	<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0104.DeviceConfigInfo"/></div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGCIM01041VO" property="flag">
	<logic:equal value="true" name="IGCIM01041VO" property="flag">	
	<logic:present name="IGCIM01041VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGCIM01041VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" id="${map.key}" ><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGCIM01041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGCIM01041VO"
				property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
						<th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0104.ConfigName"/></th>
						<th width="30%"><bean:message bundle="asmResources" key="label.IGCIM0104.ConfigInfo"/></th>
						<th width="10%"></th>
						<th width="20%"><bean:message bundle="asmResources" key="label.IGCIM0104.ConfigRemark"/></th>
						<th width="17%"><bean:message bundle="asmResources" key="label.IGCIM0104.Attachment"/></th>
						<!-- <th width="8%"><bean:message bundle="asmResources" key="label.IGCIM0104.Version"/></th> -->
						<!--th width="9%">更新时间</th-->
						<th></th>
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout ="mouseOutNoHand(this);" <logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>>
							<!-- 名称 -->
							<td>
							<div class="nowrapDiv">
							<logic:equal value="1" name="bean" property="crequired">
								<span class="red">*</span>
							</logic:equal>
							<logic:empty name="bean" property="cname">&nbsp;
							</logic:empty> ${bean.cname}</div>
							</td>
							<!-- 内容 -->
							<td <logic:equal name="bean" property="cattach" value="5">align="left" style="padding-left: 100px;"
							</logic:equal><logic:notEqual name="bean" property="cattach" value="5">align="center"</logic:notEqual>>
							<div class="nowrapDiv">
							<logic:equal name="bean" property="cattach" value="1">
								<html:text property="attachFile[${ADcount}]"
									styleId="attachFile[${ADcount}]" size="25"
									errorStyleClass="inputError imeDisabled"
									readonly="true" styleClass="input1" disabled="true"/>
								<html:hidden property="civalue[${ADcount}]" styleId="civalue" />
							</logic:equal> 
							<logic:equal name="bean" property="cattach" value="8">
								<html:text property="attachFileXML[${ADcount}]"
									styleId="attachFileXML[${ADcount}]" size="25"
									errorStyleClass="inputError imeDisabled"
									readonly="true" styleClass="input1" disabled="true"/>
								<html:hidden property="civalue[${ADcount}]" styleId="civalue" />
							</logic:equal> 
							<logic:equal name="bean" property="cattach" value="0">
								<logic:equal name="bean" property="clabel" value="<%=EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS%>">
									<ig:codeValue ccid="EQUIPMENT_STATUS_CODE" cid="${bean.civalue}"/>
								</logic:equal>
								<logic:notEqual name="bean" property="clabel" value="<%=EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS%>">
									<html:text property="civalue[${ADcount}]" styleId="civalue"
										size="40" errorStyleClass="inputError"
										readonly="true" styleClass="input1" disabled="true"/>
								</logic:notEqual>
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="2">
								<html:select property="civalue[${ADcount}]" style="width:53.5%;" errorStyleClass="inputError imeActive" disabled="true">
									<html:options collection="ADlist${ADmapcount}" property="value" name="" labelProperty="label" />
								</html:select>
								<c:set var="ADmapcount" value="${ADmapcount+1}"/>
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="3">
								<html:text property="civalue[${ADcount}]" styleId="civalue[${ADcount}]" 
								errorStyleClass="inputError imeDisabled" size="20" readonly="true" styleClass="input1" disabled="true"/>
								<!--<img src="images/date.gif" align="middle" 
								onclick="calendar($('civalue[${ADcount}]'))" border="0" style="cursor: hand" />
							--></logic:equal>
							<logic:equal name="bean" property="cattach" value="4">
								<html:text property="civalue[${ADcount}]" styleId="civalue[${ADcount}]" 
								errorStyleClass="inputError imeDisabled" size="30" readonly="true" styleClass="input1" disabled="true"/>
								<!--<img src="images/seek.gif" border="0" width="16" height="16" alt='<bean:message bundle="asmResources" key="img.IGCIM0104.find.alt"/>' onclick="selectEntityItem('${bean.coption}','${ADcount}')" style="cursor: hand"/>--> <br />
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="5">
								<logic:present name="IGCIM0104Form" property="civalue[${ADcount}]">
									<bean:define id="civalue" name="IGCIM0104Form" property="civalue[${ADcount}]" type="java.lang.String" />
									<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
										<bean:define id="cb_civalue" name="checkboxbean" property="value" type="java.lang.String" />
											<input type="checkbox" disabled="disabled" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" 
											<%=ASMHelper.isChecked(civalue,cb_civalue)?"checked='checked'":"" %> />${checkboxbean.value}
											<br />
									</logic:iterate>
								</logic:present>
								<logic:notPresent name="IGCIM0104Form" property="civalue[${ADcount}]">
									<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
										<input type="checkbox" disabled="disabled" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" />${checkboxbean.value}
										<br />
									</logic:iterate>
								</logic:notPresent>
								<html:hidden property="civalue[${ADcount}]"/>
								<c:set var="ADmapcount" value="${ADmapcount+1}"/>
							</logic:equal>
							
							<logic:equal name="bean" property="cattach" value="6">
									<html:textarea property="civalue[${ADcount}]" styleId="civalue" 
										errorStyleClass="inputError" rows="5" cols="25" readonly="true" disabled="true"/>
							</logic:equal>
							
							</div>
							</td>
							
							<td align="left">
<%-- 								<logic:equal name="bean" property="cattach" value="8"> --%>
<%-- 									<logic:notEmpty name="bean" property="civalue" > --%>
<%-- 									<html:button property="btn_look" styleClass="button"  onclick="goLook('${IGCIM01041VO.entityData.eiid}','${bean.civersion}','${bean.cismallversion}','${bean.civalue}');" > --%>
<%-- 									          <bean:message bundle="asmResources" key="button.IGCIM0104.btn_view"/>  --%>
<%-- 									</html:button> --%>
<%-- 									</logic:notEmpty> --%>
<%-- 								</logic:equal> --%>
							</td>
							
							
							
							<!-- 配置项说明 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cdesc">&nbsp;</logic:empty> ${bean.cdesc}</div>
							</td>
							<!-- 附件 -->
							<td align="center">
							<div class="nowrapDiv"><logic:equal name="bean" property="cattach" value="1">
								<a href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
								${bean.civalue} </a>
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="8">
								${bean.civalue}
							</logic:equal>
							</div>
							</td>
							<!-- 版本号 -->
							<!-- 
							<td align="center">
							<div class="nowrapDiv">
							<logic:empty name="bean" property="civersion">&nbsp;</logic:empty> 
							<logic:notEmpty name="bean" property="civersion">
								${bean.civersion}<c:if test="${IGCIM01041VO.entityData.emodeltype == '1'}">.${bean.cismallversion}</c:if>
							</logic:notEmpty>
							</div>
							</td>
							 -->
							<!-- 更新时间 -->
							<td align="center">
							<!--div class="nowrapDiv"><logic:empty name="bean"
								property="ciupdtime">&nbsp;</logic:empty> ${bean.ciupdtime}</div -->
								<html:hidden property="ciid" styleId="ciid" value="${bean.ciid}" />
								<html:hidden property="cid" styleId="cid" value="${bean.cid}" />
								<html:hidden property="clabel" styleId="clabel" value="${bean.clabel}" />
								<html:hidden property="ciattach" styleId="ciattach" value="${bean.cattach}" />
								<html:hidden property="eid" styleId="eid" value="${bean.eid}" />
								<html:hidden property="esyscoding" styleId="esyscoding" value="${bean.esyscoding}" />
								<html:hidden property="entityItemCivalue[${ADcount}]" styleId="entityItemCivalue[${ADcount}]" />
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
	<bean:define id="entityData" name="IGCIM01041VO" property="entityData" />
	<!--<logic:notEqual value="S" name="entityData" property="eistatus">
	<logic:present name="IGCIM01041VO" property="flag">
	<logic:equal value="true" name="IGCIM01041VO" property="flag">
	<html:submit property="btn_insert"   styleClass="button" onclick="return confirmDisp();" >
		<bean:message bundle="asmResources" key="button.IGCIM0104.btn_save"/> 
	</html:submit>
	</logic:equal>
	</logic:present>
	</logic:notEqual>
	--><html:button property="btn_back" styleClass="button" onclick="toback()">
	 	<bean:message bundle="asmResources" key="button.IGCIM0104.btn_toback"/>
	</html:button>
	</div>
	<html:hidden property="eiid" styleId="eiid" value="${IGCIM0104Form.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion" value="${IGCIM01041VO.entityData.eiversion}" />
	<html:hidden property="eismallversion" styleId="eismallversion" value="${IGCIM01041VO.entityData.eismallversion}" />
	<html:hidden property="emodeltype" styleId="emodeltype" value="${IGCIM01041VO.entityData.emodeltype}" />
	<html:hidden property="eiorgsyscoding" styleId="eiorgsyscoding" value="${IGCIM01041VO.entityData.eiorgsyscoding}" />
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>