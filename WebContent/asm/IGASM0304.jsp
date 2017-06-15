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
<bean:define id="id" value="IGASM0304" toScope="request" />
<bean:define id="title" value="设备配置信息编辑画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		var gid='IGASM0304';
		//WebCalendar.timeShow   = false;          //是否返回时间
		function confirmDisp(ident){		
			var message1 = '<bean:message key="IGCO10000.W003" arg0="设备配置信息" />';	 




			<logic:present name="IGASM03041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM03041VO" property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
				<logic:iterate id="bean" name="list" indexId="index">
					<logic:equal name="bean" property="cattach" value="1">
						<logic:equal value="1" name="bean" property="crequired">
							<logic:equal value="" name="bean" property="civalue">
							if($F('attachFile[${ADcheckCount}]').trim() == ""){
								alert("请输入${bean.cname}！");
								return false;
							} 
							</logic:equal>
						</logic:equal>
					</logic:equal>
					<logic:equal name="bean" property="cattach" value="8">
						<logic:equal value="1" name="bean" property="crequired">
							<logic:equal value="" name="bean" property="civalue">
							if($F('attachFileXML[${ADcheckCount}]').trim() == ""){
								alert("请输入${bean.cname}！");
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
								alert("${bean.cname}不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
								submitValue = "";
								return false;
							}
							if(flag){
								document.getElementById("civalue[${ADcheckCount}]").value = submitValue;
							} else {
								alert("请选择${bean.cname}！");
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
								alert("${bean.cname}不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
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
										if($F('civalue[${ADcheckCount}]')!=null && $F('civalue[${ADcheckCount}]').trim() == ""){
											alert("请输入${bean.cname}！");
											return false;
										}
										if($F('civalue[${ADcheckCount}]')!=null && $F('civalue[${ADcheckCount}]').trim().strlen()>128){
											alert("${bean.cname}不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
											return false;
										}
									</logic:equal>
									
									<logic:notEqual value="1" name="bean" property="crequired">
										if($F('civalue[${ADcheckCount}]')!=null && $F('civalue[${ADcheckCount}]').trim().strlen()>128){
											alert("${bean.cname}不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
											return false;
										}
									</logic:notEqual>
									
								</logic:notEqual>
								

								<logic:equal name="bean" property="cattach" value="6">
								<logic:equal value="1" name="bean" property="crequired">
								if($F('civalue[${ADcheckCount}]')!=null && $F('civalue[${ADcheckCount}]').trim() == ""){
									alert("请输入${bean.cname}！");
									return false;
								}
								if($F('civalue[${ADcheckCount}]')!=null && $F('civalue[${ADcheckCount}]').trim().strlen()>1500){
									alert("${bean.cname}不能大于"+Math.floor(1500/strByteFlag)+"个汉字！");
									return false;
								}
								</logic:equal>
								<logic:notEqual value="1" name="bean" property="crequired">
								if($F('civalue[${ADcheckCount}]')!=null && $F('civalue[${ADcheckCount}]').trim().strlen()>1500){
									alert("${bean.cname}不能大于"+Math.floor(1500/strByteFlag)+"个汉字！");
									return false;
								}
								</logic:notEqual>
								</logic:equal>
								
								<logic:equal name="bean" property="cattach" value="7">
									<logic:equal value="1" name="bean" property="crequired">
									if($F('civalue[${ADcheckCount}]')!=null && $F('civalue[${ADcheckCount}]').trim() == ""){
										alert("请输入${bean.cname}！");
										return false;
									}
									
									if(checkFloatNum($F('civalue[${ADcheckCount}]').trim())){
										alert("${bean.cname}为数字,整数位最多13位,小数位最多2位!");
										return false;
									}
									</logic:equal>
									<logic:notEqual value="1" name="bean" property="crequired">
									if(checkFloatNum($F('civalue[${ADcheckCount}]').trim())){
										alert("${bean.cname}为数字,整数位最多13位,小数位最多2位!");
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


			
		document.getElementById("ident").value = ident;
		
		
		 if( window.confirm(message1)){
             return true;
         } else {
             return false;
         }
          
		}
		
        function toback(){
        	form.action = getAppRootUrl() + "/IGASM0304.do?org.apache.struts.taglib.html.CANCEL=1";
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
        	
    		var url = "/IGASM0341.do?eiid="+id+"&eiversion="+v+"&eismallversion="+sv+"&filename="+name;
    		openSubWindow(url, '_blank', '800', '600');
    		
        }

        
		function saveXML(id){
			document.forms[0].action =  getAppRootUrl()+"/IGASM0304_SAVE.do?eiid="+id;
			document.forms[0].submit();
        }
		//删除附件
    	function delFile(fileid){
    		 if( window.confirm("您是否确定删除附件？")){
    			form.action = getAppRootUrl() + "/IGASM0304.do?delfile["+fileid+"]="+1+"&ident="+0;
    	        form.submit();
    		 }
        }
		
        function areaOptionSelectDisp(){        	
        	var area = '${area}';
        	var room = document.getElementById("room").value;
        	
        	var selectElement = document.getElementById("areaOption");
			if(room != ''){
				var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	        		parameters: 'type=getAreaOptionname&room='+room,
	        		onSuccess:  function(req, json){
	        		var result=req.responseText;
	        			if(result != ''){
	        				var rcname = result.split("#");
	        				var nullElemet = new Option("");
	        				nullElemet.value = "";
        					selectElement.options.add(nullElemet); 
        					
	        				for(var i=0;i<rcname.length;i++){
		        				var optionElemet = new  Option(rcname[i]);
		        				optionElemet.value = rcname[i];
	        					selectElement.options.add(optionElemet); 
	        				}
	        			}
	        			selectElement.value = null;
	        	    }
	        	});
				if(area!='' && area!=null){
					selectElement.value = area;
				}
			}else{
				selectElement.options.length=0; 
				selectElement.value = '';
			}       	
        }
        
        function areaOptionSelect(){        	
        	var room = document.getElementById("room").value;
        	
        	var selectElement = document.getElementById("areaOption");
			if(room != ''){
				var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	        		parameters: 'type=getAreaOptionname&room='+room,
	        		onSuccess:  function(req, json){
	        		var result=req.responseText;
	        			if(result != ''){
	        				var rcname = result.split("#");
	        				var nullElemet = new Option("");
	        				nullElemet.value = "";
        					selectElement.options.add(nullElemet); 
        					
	        				for(var i=0;i<rcname.length;i++){
		        				var optionElemet = new  Option(rcname[i]);
		        				optionElemet.value = rcname[i];
	        					selectElement.options.add(optionElemet); 
	        				}
	        			}
	        			selectElement.value = null;
	        	    }
	        	});
				
			}else{
				selectElement.options.length=0; 
			}       	
        }
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body onload="areaOptionSelectDisp();">
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 设备配置编辑</p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<html:form styleId="form" action="/IGASM0304"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name">设备基本信息</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="8%">模型名称</th>
			<th width="12%">设备编号</th>
			<th width="15%">设备名称</th>
			<th width="15%">设备所属机构</th>
			<th width="15%">设备说明</th>
			<th width="7%">管理人</th>
			<th width="8%">登记日</th>
			
		</tr>
		<tr>
			<td align="center">${IGASM03041VO.entityData.ename}</td>
			<td>${IGASM03041VO.entityData.eilabel}</td>
			<td>${IGASM03041VO.entityData.einame}</td>
			<td>${IGASM03041VO.eiorgname}</td>
			<td>${IGASM03041VO.entityData.eidesc}</td>
			<td>${IGASM03041VO.entityData.eiusername}</td>
			<td>${IGASM03041VO.entityData.eiinsdate}</td>
			
		</tr>
	</table>
</div>

	<div class="title">
	<div class="name">设备配置信息</div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGASM03041VO" property="flag">
	<logic:equal value="true" name="IGASM03041VO" property="flag">	
	<logic:present name="IGASM03041VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM03041VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGASM03041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM03041VO"
				property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
						<th width="3%"></th>
						<th width="12%" align="left">配置项名称</th>
						<th width="35%" align="left">配置项内容</th>
						<th width="8%"></th>
						<th width="20%" align="left">配置项说明</th>
						<th width="15%" align="left">附件</th>
						<th width="9%">版本号</th>
						<th></th>
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout ="mouseOutNoHand(this);" <logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>>
							<!-- 占位调整格式使用 -->
							<td></td>
							<!-- 名称 -->
							<td align="left">
							<div class="nowrapDiv">
							<logic:equal value="1" name="bean" property="crequired">
								<span class="red">*</span>
							</logic:equal>
							<logic:empty name="bean" property="cname">&nbsp;
							</logic:empty> ${bean.cname}</div>
							</td>
							<!-- 内容 -->
							<td align="left" <logic:equal name="bean" property="cattach" value="5">align="left"
							</logic:equal><logic:notEqual name="bean" property="cattach" value="5">align="center"</logic:notEqual>>
							<div class="nowrapDiv">
							<logic:equal name="bean" property="cattach" value="1">
								<html:file style="text-align:left;" property="attachFile[${ADcount}]"
									styleId="attachFile[${ADcount}]" size="25"
									errorStyleClass="inputError imeDisabled"
									onkeydown="return false;" styleClass="imeDisabled" /><img src="images/empty.gif" align="middle" onClick="cleanFile('attachFile[${ADcount}]','civalue[${ADcount}]')" border="0" style="cursor: hand"/>
								<html:hidden property="civalue[${ADcount}]" styleId="civalue" />
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="8">
								<html:file property="attachFileXML[${ADcount}]"
									styleId="attachFileXML[${ADcount}]" size="25"
									errorStyleClass="inputError imeDisabled"
									onkeydown="return false;" styleClass="imeDisabled" /><img src="images/empty.gif" align="middle" onClick="cleanFile('attachFileXML[${ADcount}]','civalue[${ADcount}]')" border="0" style="cursor: hand"/>
								<html:hidden property="civalue[${ADcount}]" styleId="civalue" />
							</logic:equal> 
							<logic:equal name="bean" property="cattach" value="0">
								<logic:equal name="bean" property="cid" value="6">
									<logic:equal name="bean" property="clabel" value="<%=EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS%>">
										<ig:codeValue ccid="EQUIPMENT_STATUS_CODE" cid="${bean.civalue}"/>
										<html:hidden property="civalue[${ADcount}]"/>
									</logic:equal>
									<logic:notEqual name="bean" property="clabel" value="<%=EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS%>">
										<html:text property="civalue[${ADcount}]" styleId="civalue"
											size="40" errorStyleClass="inputError"
											styleClass="input_left" readonly="true" />
									</logic:notEqual>
								</logic:equal>
								<logic:notEqual name="bean" property="cid" value="6">
									<logic:equal name="bean" property="clabel" value="<%=EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS%>">
										<ig:codeValue ccid="EQUIPMENT_STATUS_CODE" cid="${bean.civalue}"/>
										<html:hidden property="civalue[${ADcount}]"/>
									</logic:equal>
									<logic:notEqual name="bean" property="clabel" value="<%=EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS%>">
										<html:text property="civalue[${ADcount}]" styleId="civalue"
											size="40" errorStyleClass="inputError"
											styleClass="input_left" />
									</logic:notEqual>
								</logic:notEqual>
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="2">
								<logic:equal name="bean" property="clabel" value="IG_0037">
									<logic:equal name="IGASM03041VO" property="inJiguiFlg" value="Y">
										<bean:write name="IGASM0304Form" property="civalue[${ADcount}]" />
										<html:hidden property="civalue[${ADcount}]" styleId="civalue[${ADcount}]"/>
									</logic:equal>
									<logic:notEqual name="IGASM03041VO" property="inJiguiFlg" value="Y">
										<html:select property="civalue[${ADcount}]" style="width:53.5%;" errorStyleClass="inputError imeActive">
											<html:options collection="ADlist${ADmapcount}" property="value" name="" labelProperty="label" />
										</html:select>
									</logic:notEqual>
								</logic:equal>
								
								<logic:equal name="bean" property="clabel" value="IG_0016">
									<logic:equal name="IGASM03041VO" property="inJiguiFlg" value="Y">
										<bean:write name="IGASM0304Form" property="civalue[${ADcount}]" />
										<html:hidden property="civalue[${ADcount}]" styleId="civalue[${ADcount}]"/>
									</logic:equal>
									<logic:notEqual name="IGASM03041VO" property="inJiguiFlg" value="Y">
										<html:select property="civalue[${ADcount}]" style="width:53.5%;" errorStyleClass="inputError imeActive">
											<html:options collection="ADlist${ADmapcount}" property="value" name="" labelProperty="label" />
										</html:select>
									</logic:notEqual>
								</logic:equal>
								<logic:equal name="bean" property="clabel" value="IG_0012">
									<logic:equal name="IGASM03041VO" property="inJiguiFlg" value="Y">
										<bean:write name="IGASM0304Form" property="civalue[${ADcount}]" />
										<html:hidden property="civalue[${ADcount}]" styleId="civalue[${ADcount}]"/>
									</logic:equal>
									<logic:notEqual name="IGASM03041VO"  property="inJiguiFlg" value="Y">
										<html:select property="civalue[${ADcount}]" styleId="room" style="width:53.5%;" errorStyleClass="inputError imeActive" onchange="areaOptionSelect()" >
											<html:options collection="ADlist${ADmapcount}" property="value" name="" labelProperty="label" />
										</html:select>
									</logic:notEqual>
								</logic:equal>
								<logic:equal name="bean" property="clabel" value="IG_0013">
									<logic:equal name="IGASM03041VO" property="inJiguiFlg" value="Y">
										<bean:write name="IGASM0304Form" property="civalue[${ADcount}]" />
										<html:hidden property="civalue[${ADcount}]" styleId="civalue[${ADcount}]"/>
									</logic:equal>
									<logic:notEqual name="IGASM03041VO" property="inJiguiFlg" value="Y">
										<html:select property="civalue[${ADcount}]" styleId="areaOption" style="width:53.5%;" errorStyleClass="inputError imeActive">
											<html:options collection="ADlist${ADmapcount}" property="value" name="" labelProperty="label" />
										</html:select>
									</logic:notEqual>
								</logic:equal>
								
								<logic:notEqual name="bean" property="clabel" value="IG_0037">
								<logic:notEqual name="bean" property="clabel" value="IG_0016">
								<logic:notEqual name="bean" property="clabel" value="IG_0013">
								<logic:notEqual name="bean" property="clabel" value="IG_0012">
									<html:select property="civalue[${ADcount}]" style="width:53.5%;" errorStyleClass="inputError imeActive">
										<html:options collection="ADlist${ADmapcount}" property="value" name="" labelProperty="label" />
									</html:select>
								</logic:notEqual>
								</logic:notEqual>
								</logic:notEqual>
								</logic:notEqual>
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
								<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="selectEntityItem('${bean.coption}','${ADcount}')" style="cursor: hand"/> 
								<html:checkbox property="isUpgrade[${ADcount}]" styleId="isUpgrade[${ADcount}]" value="1"><span style="vertical-align: middle;">是否关系升级</span></html:checkbox>
								<br/>
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="5">
								<logic:present name="IGASM0304Form" property="civalue[${ADcount}]">
									<bean:define id="civalue" name="IGASM0304Form" property="civalue[${ADcount}]" type="java.lang.String" />
									<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
										<bean:define id="cb_civalue" name="checkboxbean" property="value" type="java.lang.String" />
											<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" 
											<%=ASMHelper.isChecked(civalue,cb_civalue)?"checked='checked'":"" %> />${checkboxbean.value}
											<br />
									</logic:iterate>
								</logic:present>
								<logic:notPresent name="IGASM0304Form" property="civalue[${ADcount}]">
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
							<logic:equal name="bean" property="cattach" value="7">
									<html:text property="civalue[${ADcount}]" styleId="civalue[${ADcount}]" errorStyleClass="inputError imeDisabled" size="17" readonly="true" /> 
	                        		<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('civalue[${ADcount}]'))" border="0" style="cursor: hand"/>
	                        		<a href="javascript:clear($('civalue[${ADcount}]'));">清空</a><br/>
							</logic:equal>
							</div>
							</td>
							<td align="left">
								<logic:equal name="bean" property="cattach" value="8">
									<logic:notEmpty name="bean" property="civalue" >
									<html:button property="btn_look" styleClass="button" value="查看" onclick="goLook('${IGASM03041VO.entityData.eiid}','${bean.civersion}','${bean.cismallversion}');" />
									</logic:notEmpty>
								</logic:equal>
							</td>
							<!-- 配置项说明 -->
							<td align="left">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cdesc">&nbsp;</logic:empty> ${bean.cdesc}</div>
							</td>
							<!-- 附件 -->
							<td align="left">
							
							<div id = "file[${ADcount}]" class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<a href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
								${bean.civalue} </a>
								<html:hidden property="delfile[${ADcount}]" styleId="delfile[${ADcount}]" />
								<c:if test="${bean.civalue > ''}">
									<img src="images/delate.gif" align="middle" onClick="delFile('${ADcount}')" border="0" style="cursor: hand" alt="删除"/>
								</c:if>
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="8">
								${bean.civalue}
							</logic:equal></div>
							</td>
							<!-- 版本号 -->
							<td align="center">
							<div class="nowrapDiv">
							<logic:empty name="bean" property="civersion">&nbsp;</logic:empty>
								${bean.civersion}<logic:notEqual name="bean" property="cismallversion" value=""><c:if test="${IGASM03041VO.entityData.emodeltype == '1' && (bean.civersion + bean.cismallversion) > 0}">.${bean.cismallversion}</c:if>
								</logic:notEqual>
							</div>
							</td>
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
	<bean:define id="entityData" name="IGASM03041VO" property="entityData" />
	<logic:notEqual value="S" name="entityData" property="eistatus">
	<logic:present name="IGASM03041VO" property="flag">
	<logic:equal value="true" name="IGASM03041VO" property="flag">
	<html:hidden property="ident"/>
	<!-- <html:submit property="btn_insert" value="保存" styleClass="button" onclick="return confirmDisp(0);" /> -->
	<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp(1);" />
	</logic:equal>
	</logic:present>
	</logic:notEqual>
	<html:cancel styleClass="button" value="返回" /></div>
	<html:hidden property="eiid" styleId="eiid" value="${IGASM0304Form.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion" value="${IGASM03041VO.entityData.eiversion}" />
	<html:hidden property="eismallversion" styleId="eismallversion" value="${IGASM03041VO.entityData.eismallversion}" />
	<html:hidden property="emodeltype" styleId="emodeltype" value="${IGASM03041VO.entityData.emodeltype}" />
	<html:hidden property="eiorgsyscoding" styleId="eiorgsyscoding" value="${IGASM03041VO.entityData.eiorgsyscoding}" />
</html:form></div>
</div>
</div>
</div>
</body>
</html:html>