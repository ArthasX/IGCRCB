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
<bean:define id="id" value="IGASM1404" toScope="request" />
<bean:define id="title" value="服务记录配置信息编辑画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		var gid='IGASM1404';
		WebCalendar.timeShow  = false;          //是否返回时间
		var servicepos = 0;
		var entitypos= 0;
		function confirmDisp(){
			var message1 = '<bean:message key="IGCO10000.W003" arg0="服务记录配置信息" />';
			var muchCivalue = document.getElementById("civalue["+entitypos+"]").value;
			var reg=new RegExp("###<br />","g");  
        	$("civalue[0]").value = $("civalue[0]").value.replace(reg,""); 
        	$("civalue[1]").value = $("civalue[1]").value.replace(reg,""); 
        	$("civalue[2]").value = $("civalue[2]").value.replace(reg,""); 
        	$("civalue[3]").value = $("civalue[3]").value.replace(reg,""); 
			if(document.getElementById("civalue["+entitypos+"]").value==""){
				alert("请选择资产！");
				return false;
			}else if($("civalue[0]").value == '' || $("civalue[1]").value == '' || $("civalue[2]").value == '' || $("civalue[3]").value == '') {
				alert("请选择资产！");
				return false;
            }else if(document.getElementById("civalue["+servicepos+"]").value==""){
				alert("请选择服务商！");
				return false;
			}else if(muchCivalue.strlen()>1900){
				alert("请选择资产的总长度不能大于"+Math.floor(1500/strByteFlag)+"个汉字！");
				return false;
			}
			
			<logic:present name="IGASM14041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM14041VO" property="configItemVWInfoMap" indexId="number">
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
							}
							if(!flag){
								alert("请选择${bean.cname}！");
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
					<logic:notEqual name="bean" property="cattach" value="5">
					<logic:notEqual name="bean" property="cattach" value="6">
						<logic:equal value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim() == ""){
							alert("请输入${bean.cname}！");
							return false;
						}
						if($F('civalue[${ADcheckCount}]').trim().strlen()>1900){
							alert("${bean.cname}不能大于"+Math.floor(1500/strByteFlag)+"个汉字！");
							return false;
						}
						</logic:equal>
						<logic:notEqual value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim().strlen()>1900){
							alert("${bean.cname}不能大于"+Math.floor(1500/strByteFlag)+"个汉字！");
							return false;
						}
						</logic:notEqual>
						</logic:notEqual>


						<logic:equal name="bean" property="cattach" value="6">
						<logic:equal value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim() == ""){
							alert("请输入${bean.cname}！");
							return false;
						}
						if($F('civalue[${ADcheckCount}]').trim().strlen()>1500){
							alert("${bean.cname}不能大于"+Math.floor(1500/strByteFlag)+"个汉字！");
							return false;
						}
						</logic:equal>
						<logic:notEqual value="1" name="bean" property="crequired">
						if($F('civalue[${ADcheckCount}]').trim().strlen()>1500){
							alert("${bean.cname}不能大于"+Math.floor(1500/strByteFlag)+"个汉字！");
							return false;
						}
						</logic:notEqual>
						</logic:equal>
						<logic:equal name="bean" property="cattach" value="7">
							<logic:equal value="1" name="bean" property="crequired">
							if($F('civalue[${ADcheckCount}]').trim() == ""){
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
					<c:set var="ADcheckCount" value="${ADcheckCount+1}"/>
				</logic:iterate>
			</logic:iterate>
		</logic:present>
			
			
            if( window.confirm(message1)){
                var reg=new RegExp("###<br />","g");  
            	$("civalue[0]").value = $("civalue[0]").value.replace(reg,""); 
            	$("civalue[1]").value = $("civalue[1]").value.replace(reg,""); 
            	$("civalue[2]").value = $("civalue[2]").value.replace(reg,""); 
            	$("civalue[3]").value = $("civalue[3]").value.replace(reg,""); 
            	if($("civalue[0]").value == '' || $("civalue[1]").value == '' || $("civalue[2]").value == '' || $("civalue[3]").value == '') {
					alert("请选择资产！");
					return false;
                }
                return true;
            } else {
                return false;
            }
		}
		
        function toback(){
        	form.action = getAppRootUrl() + "/IGASM1404.do?org.apache.struts.taglib.html.CANCEL=1";
        	form.submit();
        }
		var flag=0;
        function selectEntity(param,index){
        	flag = index;
        	openSubWindow('/IGCOM0327_SELECT.do'+param , '', '850', '600');
        }
        function selectService(param,index){
        	flag = index;
        	openSubIGCOM0327PARAM(param);
        }

        var num = 0;
        function selectEntityItem(obj,index){
            num = index;
            openSubIGCOM0327PARAM("?esyscoding="+obj);
       }

        function setParamIGCOM0327(eid, elabel, ename, eiid, eilabel, einame ,ecategory) {
			if(flag != 0 && num != 0){
				alert("操作错误,请从新选择！");
				flag = 0;
				num = 0;
				return;
			}
            if(flag != 0){
	        	$("civalue["+(parseInt(flag)-1)+"]").value=eiid;
	        	$("civalue["+flag+"]").value=einame;
  				$("civalue["+(parseInt(flag)+1)+"]").value=eid;
  				$("civalue["+(parseInt(flag)+2)+"]").value=ecategory;
  				flag = 0;
            }
			if(num != 0){
				if(einame == "" && eilabel =="" ){
		            $("civalue["+num+"]").value = "";
		            $("entityItemCivalue["+num+"]").value = "";
	            }else{
		            $("civalue["+num+"]").value = einame;
		            $("entityItemCivalue["+num+"]").value = einame+"("+eiid+")";
	            }
	            num = 0;
  			}
        }
        
        function setMuchParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
			if(flag != 0 && num != 0){
				alert("操作错误,请从新选择！");
				flag = 0;
				num = 0;
				return;
			}
            if(flag != 0){
	        	$("civalue["+(parseInt(flag)-1)+"]").value=eiid;
	        	$("civalue["+flag+"]").value=einame;
  				$("civalue["+(parseInt(flag)+1)+"]").value=eid;
  				$("civalue["+(parseInt(flag)+2)+"]").value=ecategory;
  				flag = 0;
            }
			if(num != 0){
				if(einame == "" && eilabel =="" ){
		            $("civalue["+num+"]").value = "";
		            $("entityItemCivalue["+num+"]").value = "";
	            }else{
		            $("civalue["+num+"]").value = einame;
		            $("entityItemCivalue["+num+"]").value = einame+"("+eiid+")";
	            }
	            num = 0;
  			}
	
			var einames  = einame.split("<br />");
			var eiids  = eiid.split("<br />");
			var str = "";
			for(var i=0;i<einames.length;i++){
				if(einames[i] != ""){
						str+="<input type='text' id='einames["+ i +"]' name='muchCivalue' size='30' value='"+einames[i]+"' readonly='readonly' class='input1'/>";
						str+="<a href='javascript:deleteEntityItem("+ i + ",1," +eiids[i] + ")' id='a["+ i +"]'>删除<br /></a>";
				}
			}
			
			muchCivalue.innerHTML=str;
        }

        function deleteEntityItem(num,flag,eiid) {

        	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=removeSlectedEntityItem&eiid=' + eiid,
				 onSuccess:  function(req, json){
				 	var result = req.responseText;
					if(result != null && result.trim() != ""){	
						var eiid = $("civalue["+(parseInt(flag)-1)+"]").value.split("<br />");
			        	var new_eiid = "";
			        	for(var i = 0; i < eiid.length - 1; i++) {
			            	if(i != num) {
			        			new_eiid += eiid[i] + "<br />";
			                } else if(i == num){
			                	new_eiid += "###<br />";
			                }
			            }
			        	$("civalue["+(parseInt(flag)-1)+"]").value = new_eiid;
			        	var einame = $("civalue["+flag+"]").value.split("<br />");
			        	var new_einame = "";
			        	for(var i = 0; i < einame.length - 1; i++) {
			            	if(i != num) {
			        			new_einame += einame[i] + "<br />";
			                } else if(i == num){
			                	new_einame += "###<br />";
			                }
			            }
			        	$("civalue["+flag+"]").value = new_einame;
			        	var eid = $("civalue["+(parseInt(flag)+1)+"]").value.split("<br />");
			        	var new_eid = "";
			        	for(var i = 0; i < eid.length - 1; i++) {
			            	if(i != num) {
			        			new_eid += eid[i] + "<br />";
			                } else if(i == num){
			                	new_eid += "###<br />";
			                }
			            }
			        	$("civalue["+(parseInt(flag)+1)+"]").value = new_eid;
			        	var ecategory = $("civalue["+(parseInt(flag)+2)+"]").value.split("<br />");
			        	var new_ecategory = "";
			        	for(var i = 0; i < ecategory.length - 1; i++) {
			            	if(i != num) {
			        			new_ecategory += ecategory[i] + "<br />";
			                } else if(i == num){
			                	new_ecategory += "###<br />";
			                }
			            }
			        	$("civalue["+(parseInt(flag)+2)+"]").value = new_ecategory;
			            $("einames["+ num +"]").outerHTML = "";
			            $("a["+ num +"]").outerHTML = "";
					} else {
						alert("删除失败！");
						return false;
					}
			     }
				});
        }
        
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body >
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
 <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 服务记录配置编辑</p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<html:form styleId="form" action="/IGASM1404"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name">服务记录基本信息</div>
	</div>
	<div id="results_list">
	<table class="table_style">
		<tr>
			<th width="15%">模型名称</th>
			<th width="15%">服务记录编号</th>
			<th width="20%">服务记录名称</th>
			<th width="18%">服务记录说明</th>
			<th width="7%">管理人</th>
			<th width="10%">登记日</th>
			
		</tr>
		<tr>
			<td>${IGASM14041VO.entityData.ename}</td>
			<td>${IGASM14041VO.entityData.eilabel}</td>
			<td>${IGASM14041VO.entityData.einame}</td>
			<td>${IGASM14041VO.entityData.eidesc}</td>
			<td>${IGASM14041VO.entityData.eiusername}</td>
			<td>${IGASM14041VO.entityData.eiinsdate}</td>
			
		</tr>
	</table>
</div>

	<div class="title">
	<div class="name">服务记录配置信息</div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGASM14041VO" property="flag">
	<logic:equal value="true" name="IGASM14041VO" property="flag">	
	<logic:present name="IGASM14041VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM14041VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGASM14041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM14041VO"
				property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
						<th width="4%"></th>
						<th width="15%" align="left">配置项名称</th>
						<th width="35%" align="left">配置项内容</th>
						<th width="20%" align="left">配置项说明</th>
						<th width="15%" align="left">附件</th>
						<th width="10%">版本号</th>
						<!--th width="9%">更新时间</th-->
						<th></th>
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" <logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>>
							<!-- 占位调整格式使用 -->
							<td></td>
							<!-- 名称 -->
							<td align="left">
							<div class="nowrapDiv">
							<logic:equal value="1" name="bean" property="crequired">
								<span class="red">*</span>
							</logic:equal>
							<logic:empty name="bean"
								property="cname">&nbsp;</logic:empty> ${bean.cname}
								<logic:equal name="bean" property="clabel" value="<%=EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ENAME%>">
								<logic:equal name="IGASM14041VO" property="entityData.eiversion" value="0">
								<img src="images/seek.gif" width="16" height="16" alt="查询" onclick="selectEntity('?ecategory=','1');" style="cursor: hand"/>
								</logic:equal>
								</logic:equal></div>
							</td>
							<!-- 内容 -->
							<td align="left" <logic:equal name="bean" property="cattach" value="5">align="left" style="padding-left: 100px;"
							</logic:equal><logic:notEqual name="bean" property="cattach" value="5">align="center"</logic:notEqual>>
							<div class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<html:file property="attachFile[${ADcount}]"
									styleId="attachFile[${ADcount}]" size="25"
									errorStyleClass="inputError imeDisabled"
									onkeydown="return false;" styleClass="imeDisabled" /><img src="images/empty.gif" align="middle" onClick="cleanFile('attachFile[${ADcount}]','civalue[${ADcount}]')" border="0" style="cursor: hand"/>
								<html:hidden property="civalue[${ADcount}]" styleId="civalue" />
							</logic:equal> 
							<logic:equal name="bean" property="cattach" value="0">
								<logic:equal name="bean" property="clabel" value="<%=EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ENAME%>">
								<logic:notEmpty name="IGASM1404Form" property="civalues">
									<logic:iterate name="IGASM1404Form" id="muchCivalues" property="civalues"  >
										<input type='text' name='muchCivalue' size='30' value='${muchCivalues}' readonly='readonly' class='input1' /><br/>
									</logic:iterate>
								</logic:notEmpty>
								<html:hidden property="civalue[${ADcount}]" />
								<!--
								<html:text property="civalue[${ADcount}]" styleId="civalue"
										size="40" errorStyleClass="inputError"
										styleClass="input" readonly="true"/>
								-->
								<span id="muchCivalue">
								<logic:empty name="IGASM1404Form" property="civalues">
								 	<input type="text" name="muchCivalueTmp" size="30" readonly="readonly" class="input_left" />
								 </logic:empty>
								</span>
								<logic:equal name="IGASM14041VO" property="entityData.eiversion" value="0">
									<script>
										entitypos = ${ADcount-1};
									</script>
								</logic:equal>
								</logic:equal>
								<logic:equal name="bean" property="clabel" value="<%=EntityItemKeyWords.ENTITY_DEFAULT_SERVICE_ENAME%>">
									<html:text property="civalue[${ADcount}]" styleId="civalue"
										size="30" errorStyleClass="inputError"
										styleClass="input_left" readonly="true"/>
								<logic:equal name="IGASM14041VO" property="entityData.eiversion" value="0">
								<script>
								servicepos = ${ADcount-1};
								</script>
								<img src="images/seek.gif" width="16" height="16" alt="查询" onclick="selectService('?ecategory=005','${ADcount}');" style="cursor: hand"/>
								</logic:equal>
								</logic:equal>
								<logic:notEqual name="bean" property="clabel" value="<%=EntityItemKeyWords.ENTITY_DEFAULT_DEVICE_ENAME%>">
								<logic:notEqual name="bean" property="clabel" value="<%=EntityItemKeyWords.ENTITY_DEFAULT_SERVICE_ENAME%>">
									<html:text property="civalue[${ADcount}]" styleId="civalue"
										size="30" errorStyleClass="inputError"
										styleClass="input_left" />
								</logic:notEqual>
								</logic:notEqual>
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
								errorStyleClass="inputError imeDisabled" size="20" readonly="true" />
								<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="selectEntityItem('${bean.coption}','${ADcount}')" style="cursor: hand"/>
								<html:checkbox property="isUpgrade[${ADcount}]" styleId="isUpgrade[${ADcount}]" value="1"><span style="vertical-align: middle;">是否关系升级</span></html:checkbox>
								<br />
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="5">
								<logic:present name="IGASM1404Form" property="civalue[${ADcount}]">
									<bean:define id="civalue" name="IGASM1404Form" property="civalue[${ADcount}]" type="java.lang.String" />
									<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
										<bean:define id="cb_civalue" name="checkboxbean" property="value" type="java.lang.String" />
											<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" 
											<%=ASMHelper.isChecked(civalue,cb_civalue)?"checked='checked'":"" %> />${checkboxbean.value}
											<br />
									</logic:iterate>
								</logic:present>
								<logic:notPresent name="IGASM1404Form" property="civalue[${ADcount}]">
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
							<!-- 配置项说明 -->
							<td align="left">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cdesc">&nbsp;</logic:empty> ${bean.cdesc}</div>
							</td>
							<!-- 附件 -->
							<td align="left">
							<div id = "file[${ADcount}]" class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<a
									href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
								${bean.civalue} </a>
								
							</logic:equal></div>
							</td>
							<!-- 版本号 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="civersion">&nbsp;</logic:empty> ${bean.civersion}</div>
							</td>
							<!-- 更新时间 -->
							<td align="center">
							<!--div class="nowrapDiv"><logic:empty name="bean"
								property="ciupdtime">&nbsp;</logic:empty> ${bean.ciupdtime}</div-->
							<html:hidden property="ciid" styleId="ciid" value="${bean.ciid}" />
						<html:hidden property="cid" styleId="cid" value="${bean.cid}" />
						<html:hidden property="clabel" styleId="clabel"
							value="${bean.clabel}" />
						<html:hidden property="ciattach" styleId="ciattach"
							value="${bean.cattach}" />
						<html:hidden property="eid" styleId="eid"
							value="${bean.eid}" />
						<html:hidden property="esyscoding" styleId="esyscoding"
							value="${bean.esyscoding}" />
						<html:hidden property="entityItemCivalue[${ADcount}]" styleId="entityItemCivalue[${ADcount}]" />
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
	<logic:present name="IGASM14041VO" property="flag">
	<logic:equal value="true" name="IGASM14041VO" property="flag">
	<logic:equal name="IGASM14041VO" property="entityData.eiversion" value="0">
	<html:submit property="btn_insert" value="保存" styleClass="button" onclick="return confirmDisp();" /> 
	</logic:equal>
	</logic:equal>
	</logic:present>
	<html:cancel styleClass="button" value="返回" /></div>
	<html:hidden property="eiid" styleId="eiid" value="${IGASM1404Form.eiid}" />
	<html:hidden property="eiversion" styleId="eiversion" value="${IGASM14041VO.entityData.eiversion}" />
	<html:hidden property="eiorgsyscoding" styleId="eiorgsyscoding" value="${IGASM14041VO.entityData.eiorgsyscoding}" />
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>