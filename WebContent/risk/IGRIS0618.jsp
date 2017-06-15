<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.util.ASMHelper"%>
<html:html>
<bean:define id="id" value="IGRIS0618" toScope="request" />
<bean:define id="title" value="检查项属性编辑" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		var gid='IGRIS0604';
		WebCalendar.timeShow   = false;          //是否返回时间
		function confirmDisp(ident){
			var message1 = '<bean:message key="IGCO10000.W003" arg0="检查项配置信息" />';

			<logic:present name="IGRIS06041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGRIS06041VO" property="configItemVWInfoMap" indexId="number">
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
									if($F('civalue[${ADcheckCount}]').trim().strlen()>128){
										alert("${bean.cname}不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
										return false;
									}
								</logic:equal>
								<logic:notEqual value="1" name="bean" property="crequired">
									if($F('civalue[${ADcheckCount}]').trim().strlen()>128){
										alert("${bean.cname}不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
										return false;
									}
								</logic:notEqual>
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
       	 var looksign=${looksign};
       	 if(looksign=="1"){
       		 form.action = getAppRootUrl() + "/IGRIS0601.do";
       	 }else if(looksign=="2"){
       		 form.action = getAppRootUrl() + "/IGRIS0601_OPTION.do";
       	 }else{
       		 form.action = getAppRootUrl() + "/IGRIS0601_OPTION.do"; 
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
        //删除附件
    	function delFile(fileid){
    		 if( window.confirm("您是否确定删除附件？")){
    			form.action = getAppRootUrl() + "/IGRIS0604.do?delfile["+fileid+"]="+1+"&ident="+0;
    	        form.submit();
    		 }
        }
       
	    function searchuser(){	
	  		openSubWindow('/IGSYM1905_Disp.do?', '_blank','1000','600','center:1');
	  	}
	  	function setIGCYB0101Params(username,orgname,orgid,useremail,userphone,usermobile,userid){
	  		jQuery("*[name='civalue[1]']").val(username);
	  		document.getElementById("hiddenmguserid").value = userid;
	  	}
	      function changCheckToRisk(){
	    	  jQuery("#checkToRisk").toggle();
	      }
	      function changeCheckToZb(){
	    	  jQuery("#checkToZb").toggle();
	      }
	      function setEntity(obj) {
	  		var temp = obj.value;
	  		var name = obj.options[obj.selectedIndex].text; 
	  		if (null != temp && temp != '') {
	  		    var syscode_eid = temp.split("|")[0];
	  			var syscode;
	  			var eid;
	  			if (syscode_eid == "999") {
	  				alert("资产模型不可用！请选择其他模型！");
	  				return false;

	  			} else if (syscode_eid.split("_").length > 1) {
	  				eid = syscode_eid.split("_")[0];
	  				syscode = syscode_eid.split("_")[1];
	  			}
	  			var eilabelcode=getEilabel(syscode);
	  			eilabelvalue=eilabelcode;
	  			searchMaxEntityItemLable();
	  			//获取风险点编号前几位,类似“IG-D0101”
	  			document.forms[0].eid.value = eid;
	  			document.forms[0].esyscoding.value = syscode;
	  			document.forms[0].eilabel.value = eilabel;
	  		}
	  	}
	    //改变检查项id
		function changeType(obj){
			//!!!!!!!!!!!!!!注意 将下拉框的值传给隐藏 检查项id 文本框
	    	jQuery("input[name='civalue[4]']").val(obj.value);
		}
		//自动给下拉框赋值
		function getType(){
			//!!!!!!!!!!!!!!注意 隐藏 检查项id文本框
			jQuery("input[name='civalue[4]']").parent().parent().hide();
			jQuery("input[name='civalue[5]']").attr("width",12);
			var checkitemId = document.getElementsByName("civalue[4]")[0].value;
			var selectObj = document.getElementById("_eid");
			for(var i=0;i<selectObj.length;i++){//给select赋值  
		          if(checkitemId==selectObj.options[i].value){  
		        	  selectObj.options[i].selected=true;
		          };
		    };
		    var eiids = document.getElementById("eiids").value;  
		}
		var attachFileNum = 0;
		var attach = "";
		function addFile() {
			currRow = tb.insertRow();
			cell = currRow.insertCell();
			cell.innerHTML = "<input type='file' name='fileList["+attachFileNum+"].file' class='inputbutton' contentEditable='false'><input type='button' class='delbutton' value='\u5220\u9664' onclick='deleteitem(this)'>";
			attachFileNum++;
		}
		function deleteAttach(td, obj) {
			//alert(obj);  
			if (window.confirm("确定要删除附件吗？")) {
				var attachLink = document.getElementById("attach" + obj);
				attachLink.linkName = "";
				//alert(attachLink);
				if (attach == "") {
					attach = obj;
				} else {
					attach = attach + '_' + obj;
				}
				//alert(attach);
				var curRow = td.parentNode.parentNode;
				tb2.deleteRow(curRow.rowIndex);
			}
		}
		function deleteitem(obj) {
			var curRow = obj.parentNode.parentNode;
			tb.deleteRow(curRow.rowIndex);
		}

		function deleteitem(obj) {
			var curRow = obj.parentNode.parentNode;
			tb.deleteRow(curRow.rowIndex);
		}
		//删除附件
		//删除附件
		function delFile(attid) {
			if (window.confirm("您是否确定删除附件？")) {
				document.getElementById(attid).style.display = "none";
				if ($("deletekeys").value != "") {
					$("deletekeys").value = $("deletekeys").value + ',' + attid;
				} else {
					$("deletekeys").value = attid;
				}
			}
		}
	</script>
<style>
	.input {
	width: 368px;
	margin-left: 1px;
	border: 1px solid #ccc;
	line-height: 20px;
	font-size: 12px;
}
</style>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<%-- <script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script> --%>
<body onload="getType();">
	<div id="maincontent">
		<!--header  头部和 一级菜单-->
		<!--container 左菜单 右侧内容-->
		<div id="container">


			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">

					<div id="location">
						<div class="image"></div>
						<p class="fonts1">
							<ig:navigation extname1="${urlable}" />
							&gt;&gt; 检查项属性编辑
						</p>
						<div class="back">
							<html:link href="javascript:toback();">返回</html:link>
						</div>
					</div>

					<div id="formwrapper">
						<html:form styleId="form" action="/IGRIS0604_Sub"
							enctype="multipart/form-data"
							onsubmit="return checkSubmit(this);">
							<!--  message -->
							<ig:message />
							<!--  /message -->
							<fieldset>
								<legend>检查项基本信息修改</legend>

								<logic:present name="IGRIS06041VO" property="flag">
									<logic:equal value="true" name="IGRIS06041VO" property="flag">
										<logic:present name="IGRIS06041VO"
											property="configItemVWInfoMap">
											<logic:present name="IGRIS06041VO"
												property="configItemVWInfoMap">
												<logic:iterate id="map" name="IGRIS06041VO"
													property="configItemVWInfoMap" indexId="number">
													<bean:define id="list" name="map" property="value"
														type="java.util.ArrayList" />
													<table width=""
														style="margin-left: 60px; margin-top: 20px;">

														<tr>
															<td height="20px" align="right" width=""
																style="background-color: #EEEEEE;padding-left: 3px"><span class="red">* </span><strong>检查项分类：</strong></td>
															<td><html:hidden property="eiid"
																	value="${bean.eiid}" /> <select style="width: 130px;"
																id="_eid" onchange="changeType(this)">
																	<logic:iterate id="labelAndValue"
																		name="labelAndValueList">
																		<option
																			value="<bean:write name="labelAndValue" property="value"/>">
																			<bean:write name="labelAndValue" property="label" />
																		</option>
																	</logic:iterate>
															</select></td>
															<td></td>
														</tr>
														<logic:iterate id="bean" name="list" indexId="index">
															<tr>
																<!-- 名称 -->
																<td align="right" style="background-color: #EEEEEE;">
																	<logic:equal value="1" name="bean" property="crequired">
																		<span class="red">*</span>
																	</logic:equal> 
																	<logic:empty name="bean" property="cname">
																		&nbsp;
																	</logic:empty>
																	<strong>${bean.cname}：</strong>
																</td>
																<!-- 内容 -->
																<td align="left"
																	<logic:equal name="bean" property="cattach" value="5">align="left" style="padding-left: 100px;"
							</logic:equal>
																	<logic:notEqual name="bean" property="cattach" value="5">align="center"</logic:notEqual>>
																	<logic:equal name="bean" property="cattach" value="1">
																		<logic:notEmpty name="IGRIS0604Form" property="attachmentList">	
														                <table id="tb2"> 
																	    <logic:iterate id="attachment" name="IGRIS0604Form" property="attachmentList"
																	              indexId="index">
																        		<tr id="${attachment.attid}">
																        			<td>
																		        		<img src="images/attachment.png" />			         
																						<html:link action="/IGRIS0602_loadFIle.do?attid=${attachment.attid}"  styleId='attach${attachment.attid}'>				       
																						<bean:define id="attname" name="attachment" property="attname" />						       
																						<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>						  							
																						</html:link> &nbsp;&nbsp;  &nbsp;&nbsp; 									
																						<img src="images/delate.gif" align="middle" onClick="delFile('${attachment.attid}')" border="0" style="cursor: hand" alt="删除"/><br/>						    				
																					</td>
																				</tr>		
																				<tr><td></td><td></td></tr>					
																	    </logic:iterate>
																	    </table>
																	    </logic:notEmpty>	
																	</logic:equal> <logic:equal name="bean" property="cattach" value="0">
																		
																		<html:text styleClass="input" property="civalue[${ADcount}]"
																			styleId="civalue" size="40"
																			errorStyleClass="inputError" tabindex="2"/>
																	</logic:equal> <logic:equal name="bean" property="cattach" value="2">
																		<html:select property="civalue[${ADcount}]"
																			style="width:53.5%;"
																			errorStyleClass="inputError imeActive">
																			<html:options collection="ADlist${ADmapcount}"
																				property="value" name="" labelProperty="label" />
																		</html:select>
																		<c:set var="ADmapcount" value="${ADmapcount+1}" />
																	</logic:equal> <logic:equal name="bean" property="cattach" value="3">
																		<html:text styleClass="inputDisable" property="civalue[${ADcount}]"
																			styleId="civalue[${ADcount}]"
																			errorStyleClass="inputError imeDisabled" size="12"
																			readonly="true" />
																		<img src="images/date.gif" align="middle"
																			onclick="calendar($('civalue[${ADcount}]'))"
																			border="0" style="cursor: hand" />
																	</logic:equal> <logic:equal name="bean" property="cattach" value="4">
																		<html:text styleClass="input" property="civalue[${ADcount}]"
																			styleId="civalue[${ADcount}]"
																			errorStyleClass="inputError imeDisabled" size="30"
																			readonly="true" />
																		<img src="images/seek.gif" border="0" width="16"
																			height="16" alt="查询"
																			onclick="selectEntityItem('${bean.coption}','${ADcount}')"
																			style="cursor: hand" />
																		<html:checkbox property="isUpgrade[${ADcount}]"
																			styleId="isUpgrade[${ADcount}]" value="1">
																			<span style="vertical-align: middle;">是否关系升级</span>
																		</html:checkbox>
																		<br />
																	</logic:equal> <logic:equal name="bean" property="cattach" value="5">
																		<logic:present name="IGRIS0604Form"
																			property="civalue[${ADcount}]">
																			<bean:define id="civalue" name="IGRIS0604Form"
																				property="civalue[${ADcount}]"
																				type="java.lang.String" />
																			<logic:iterate id="checkboxbean"
																				name="ADlist${ADmapcount}">
																				<bean:define id="cb_civalue" name="checkboxbean"
																					property="value" type="java.lang.String" />
																				<input type="checkbox" name="cb_civalue[${ADcount}]"
																					value="${checkboxbean.value}"
																					<%=ASMHelper.isChecked(civalue,cb_civalue)?"checked='checked'":"" %> />${checkboxbean.value}
											<br />
																			</logic:iterate>
																		</logic:present>
																		<logic:notPresent name="IGRIS0604Form"
																			property="civalue[${ADcount}]">
																			<logic:iterate id="checkboxbean"
																				name="ADlist${ADmapcount}">
																				<input type="checkbox" name="cb_civalue[${ADcount}]"
																					value="${checkboxbean.value}" />${checkboxbean.value}
										<br />
																			</logic:iterate>
																		</logic:notPresent>
																		<html:hidden property="civalue[${ADcount}]" />
																		<c:set var="ADmapcount" value="${ADmapcount+1}" />
																	</logic:equal> <logic:equal name="bean" property="cattach" value="6">
																		<html:textarea property="civalue[${ADcount}]" 
																			styleId="civalue" errorStyleClass="inputError"
																			cols="50" rows="8"/>
																	</logic:equal> <logic:equal name="bean" property="cattach" value="7">
																		<html:text styleClass="input" property="civalue[${ADcount}]"
																			styleId="civalue[${ADcount}]"
																			errorStyleClass="inputError imeDisabled" size="17"
																			readonly="true" />
																		<img src="images/softkeyboard.gif" align="middle"
																			onClick="SoftKeyboard($('civalue[${ADcount}]'))"
																			border="0" style="cursor: hand" />
																		<a href="javascript:clear($('civalue[${ADcount}]'));">清空</a>
																		<br />
																	</logic:equal>
																</td>

																<!-- 更新时间 -->
																<td align="center">
																	<!--div class="nowrapDiv"><logic:empty name="bean"
								property="ciupdtime">&nbsp;</logic:empty> ${bean.ciupdtime}</div-->
																	<html:hidden property="ciid" styleId="ciid"
																		value="${bean.ciid}" /> <html:hidden property="cid"
																		styleId="cid" value="${bean.cid}" /> <html:hidden
																		property="clabel" styleId="clabel"
																		value="${bean.clabel}" /> <html:hidden
																		property="ciattach" styleId="ciattach"
																		value="${bean.cattach}" /> <html:hidden
																		property="eid" styleId="eid" value="${bean.eid}" /> <html:hidden
																		property="esyscoding" styleId="esyscoding"
																		value="${bean.esyscoding}" /> <html:hidden
																		property="entityItemCivalue[${ADcount}]"
																		styleId="entityItemCivalue[${ADcount}]" /> <html:hidden
																		property="civalue_bak[${ADcount}]"
																		styleId="civalue_bak[${ADcount}]" />
																</td>
															</tr>

															<c:set var="ADcount" value="${ADcount+1}" />
														</logic:iterate>
													</table>
												</logic:iterate>
											</logic:present>
											<!-- <script type="text/javascript">			var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
			</script> -->
										</logic:present>
									</logic:equal>
								</logic:present>
								<div>
								<img src="images/attachment.gif" />
								<a href="javascript:addFile();" id="aAddAttach">添加附件</a>&nbsp;&nbsp;&nbsp;
								<table id="tb">
								</table>
								</div>
							</fieldset>
							<div class="enter">
								<logic:present name="IGRIS06041VO" property="flag">
									<logic:equal value="true" name="IGRIS06041VO" property="flag">
										<html:hidden property="ident" />
										<html:hidden property="hiddenmguserid" />
										<html:submit property="btn_insert" styleId="btn_save"
											value="保存" styleClass="button"
											onclick="return confirmDisp(0);" />
										<html:submit property="btn_insert" styleId="btn_insert"
											value="提交 " styleClass="button"
											onclick="return confirmDisp(1);" />
									</logic:equal>
								</logic:present>
								<%-- <html:cancel styleClass="button" value="返回"/> --%>
								<html:hidden property="selecteiversion"
									styleId="selecteiversion"
									value="${IGRIS0604Form.selecteiversion}" />
							</div>
							<html:hidden property="delfile"/>
							<html:hidden property="nattkey"/>	
						    <html:hidden property="deletekeys"/>
						    <html:hidden property="eiids"/>
						</html:form>
					</div>
				</div>
			</div>
		</div>


	</div>
</body>
</html:html>