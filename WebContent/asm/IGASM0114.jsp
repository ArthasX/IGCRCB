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
<bean:define id="id" value="IGASM0114" toScope="request" />
<bean:define id="title" value="资产模型默认值编辑画面" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		var gid='IGASM0114';
		WebCalendar.timeShow   = false;          //是否返回时间
		function confirmDisp(){
			var message1 = '<bean:message key="IGCO10000.W003" arg0="配置信息" />';
			if($F('ename').trim()==""){
	    		alert("请输入备件模型名称！");
	    		return false;
	    	}
			<logic:present name="IGASM01141VO" property="map_IG612Info">
			<logic:iterate id="map" name="IGASM01141VO" property="map_IG612Info" indexId="number">
				<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
				<logic:iterate id="bean" name="list" indexId="index">
					<logic:equal name="bean" property="cattach" value="5">
						var flag = false;
						var submitValue = "";
						var check=document.getElementsByName("cb_civalue[${ADcheckCount}]");
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
								document.getElementById("cvalue[${ADcheckCount}]").value = submitValue;
							} else {
								document.getElementById("cvalue[${ADcheckCount}]").value = "";
							}
					</logic:equal>
					<logic:notEqual name="bean" property="cattach" value="1">
					<logic:notEqual name="bean" property="cattach" value="5">
					<logic:notEqual name="bean" property="cattach" value="6">
						if($F('cvalue[${ADcheckCount}]').trim().strlen()>128){
							alert("${bean.cname}不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
							return false;
						}
					</logic:notEqual>
					<logic:equal name="bean" property="cattach" value="6">
					if($F('cvalue[${ADcheckCount}]').trim().strlen()>1500){
						alert("${bean.cname}不能大于"+Math.floor(1500/strByteFlag)+"个汉字！");
						return false;
					}
					</logic:equal>
					<logic:equal name="bean" property="cattach" value="7">
						if(checkFloatNum($F('cvalue[${ADcheckCount}]').trim())){
							alert("${bean.cname}为数字,整数位最多13位,小数位最多2位!");
							return false;
						}
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
        	form.action = getAppRootUrl() + "/IGSIM0401_Back.do";
        	form.submit();
        }
        var num = 0;
        function selectEntityItem(obj,index){
            num = index;
			openSubIGCOM0302PARAM("?esyscoding="+obj);
       }
        function setParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
        	if(einame == "" && eilabel =="" ){
	            $("cvalue["+num+"]").value = "";
	            $("entityItemCvalue["+num+"]").value = "";
            }else{
	            $("cvalue["+num+"]").value = einame;
	            $("entityItemCvalue["+num+"]").value = einame+"("+eiid+")";
            }
        	num = 0;
        }
      //删除附件
    	function deleteFile(fileid){
    		 if( window.confirm("您是否确定删除附件？")){
    			form.action = getAppRootUrl() + "/IGASM0114.do?delfile["+fileid+"]="+1+"&ident="+0;
    	        form.submit();
    		 }
      }

    	function downloadMODELFile(eid, cid){

    		var param = "";
    		var type = "model";
    		param = $H({type: type, eid: eid, cid:cid}).toQueryString();
    		openSubWindow('/download.do?' + param, '','800','600');
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
<p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 信息修改</p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>

<html:form styleId="form" action="/IGASM0114"
	enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
	<div class="title">
	<div class="name">备件模型</div>
	</div>
	<div style="padding-left: 30px;">
	<label for="Name"><strong><span class="red">*</span>备件模型名称</strong>：</label>
	<html:text name="IGASM0114Form" property="ename" size="18" style="width:200px;" errorStyleClass="inputError" tabindex="2"/>
	<br>
	</div>
	<div style="padding-left: 30px;">
    <label for="Name"><strong>&nbsp;&nbsp;备件模型说明</strong>：</label>
    <html:text name="IGASM0114Form" property="edesc" styleId="edesc" tabindex="3" size="41" style="width:450px;" errorStyleClass="inputError"/>
    <br>
	</div>
	<div class="title">
	<div class="name">配置信息</div>
	</div>
	<div class="message"><ig:message /></div>
	<logic:present name="IGASM01141VO" property="map_IG612Info">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM01141VO"
				property="map_IG612Info" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGASM01141VO" property="map_IG612Info">
			<logic:iterate id="map" name="IGASM01141VO"
				property="map_IG612Info" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
						<th width="20%">配置项名称</th>
						<th width="40%">配置项内容</th>
						<th width="20%">配置项说明</th>
						<th width="20%">附件</th>
						<th></th>
					</tr>
					<logic:iterate id="bean" name="list" indexId="index" type="com.deliverik.framework.asset.model.IG612Info">
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
							<!-- 名称 -->
							<td>
							<div class="nowrapDiv">
							<logic:empty name="bean"
								property="cname">&nbsp;</logic:empty> ${bean.cname}</div>
							</td>
							<!-- 内容 -->
							<td <logic:equal name="bean" property="cattach" value="5">align="left" style="padding-left: 100px;"
							</logic:equal><logic:notEqual name="bean" property="cattach" value="5">align="center"</logic:notEqual>>
							<div class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<html:file property="attachFile[${ADcount}]"
									styleId="attachFile[${ADcount}]" size="25"
									errorStyleClass="inputError imeDisabled"
									onkeydown="return false;" styleClass="imeDisabled" /><img src="images/empty.gif" align="middle" onClick="cleanFile('attachFile[${ADcount}]','cvalue[${ADcount}]')" border="0" style="cursor: hand"/>
								<html:hidden property="cvalue[${ADcount}]" styleId="cvalue" />
							</logic:equal> 
							<logic:equal name="bean" property="cattach" value="0">
									<html:text property="cvalue[${ADcount}]" styleId="cvalue"
										size="40" errorStyleClass="inputError"
										styleClass="input1" />
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="2">
								<html:select property="cvalue[${ADcount}]" style="width:53.5%;" errorStyleClass="inputError imeActive">
									<html:options collection="ADlist${ADmapcount}" property="value" name="" labelProperty="label" />
								</html:select>
								<c:set var="ADmapcount" value="${ADmapcount+1}"/>
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="3">
								<html:text property="cvalue[${ADcount}]" styleId="cvalue[${ADcount}]" 
								errorStyleClass="inputError imeDisabled" size="20" readonly="true" />
								<img src="images/date.gif" align="middle" 
								onclick="calendar($('cvalue[${ADcount}]'))" border="0" style="cursor: hand" />
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="4">
								<html:text property="cvalue[${ADcount}]" styleId="cvalue[${ADcount}]" 
								errorStyleClass="inputError imeDisabled" size="30" readonly="true" />
								<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="selectEntityItem('${bean.coption}','${ADcount}')" style="cursor: hand"/> <br />
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="5">
								<logic:present name="IGASM0114Form" property="cvalue[${ADcount}]">
									<bean:define id="cvalue" name="IGASM0114Form" property="cvalue[${ADcount}]" type="java.lang.String" />
									<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
										<bean:define id="cb_civalue" name="checkboxbean" property="value" type="java.lang.String" />
											<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" 
											<%=ASMHelper.isChecked(cvalue,cb_civalue)?"checked='checked'":"" %> />${checkboxbean.value}
											<br />
									</logic:iterate>
								</logic:present>
								<logic:notPresent name="IGASM0114Form" property="cvalue[${ADcount}]">
									<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
										<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" />${checkboxbean.value}
										<br />
									</logic:iterate>
								</logic:notPresent>
								<html:hidden property="cvalue[${ADcount}]"/>
								<c:set var="ADmapcount" value="${ADmapcount+1}"/>
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="6">
									<html:textarea property="cvalue[${ADcount}]" styleId="cvalue" 
										errorStyleClass="inputError" rows="5" cols="25" />
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="7">
									<html:text property="cvalue[${ADcount}]" styleId="cvalue[${ADcount}]" errorStyleClass="inputError imeDisabled" size="17" readonly="true" /> 
	                        		<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('cvalue[${ADcount}]'))" border="0" style="cursor: hand"/>
	                        		<a href="javascript:clear($('cvalue[${ADcount}]'));">清空</a><br/>
							</logic:equal>
							</div>
							</td>
							<!-- 配置项说明 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cdesc">&nbsp;</logic:empty> ${bean.cdesc}</div>
							</td>
							<!-- 附件 -->
							<td align="center">
							<div id = "file[${ADcount}]" class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<a
									href="javascript:downloadMODELFile('${IGASM0114Form.eid}','${bean.cid}');">
									<%if(!"".equals(bean.getCvalue()) && bean.getCvalue() != null){
										out.print(bean.getCvalue().split("_")[0]); }%>
								 </a>
								
								<c:if test="${bean.cvalue > ''}">
									<img src="images/delate.gif" align="middle" onClick="deleteFile('${ADcount}')" border="0" style="cursor: hand" alt="删除"/>
								</c:if>
							</logic:equal></div>
							</td>
							<td align="center">
								<html:hidden property="delfile" styleId="delfile" />
								<html:hidden property="cid" styleId="cid" value="${bean.cid}" />
								<html:hidden property="clabel" styleId="clabel" value="${bean.clabel}" />
								<html:hidden property="ciattach" styleId="ciattach" value="${bean.cattach}" />
								<html:hidden property="eid" styleId="eid" />
								<html:hidden property="entityItemCvalue[${ADcount}]" styleId="entityItemCvalue[${ADcount}]"/>
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
	<div class="enter">
		<html:submit property="btn_insert" value="保存" styleClass="button" onclick="return confirmDisp();" />
	</div>
</html:form></div>
</div>
</div>
</div>
</body>
</html:html>