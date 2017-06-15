<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.deliverik.infogovernor.util.ASMHelper"%>
<html:html>
<bean:define id="id" value="IGASM2404" toScope="request"/>
<bean:define id="title" value="发票配置信息编辑画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		var gid='IGASM2404';
		var proCount ='';
		WebCalendar.timeShow   = false;          //是否返回时间
		function confirmDisp(ident){
			var message1 = '<bean:message key="IGCO10000.W003" arg0="发票配置信息" />';

			<logic:present name="IGASM24041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM24041VO" property="configItemVWInfoMap" indexId="number">
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
        	form.action = getAppRootUrl() + "/IGASM2404.do?org.apache.struts.taglib.html.CANCEL=1";
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
    			form.action = getAppRootUrl() + "/IGASM2404.do?delfile["+fileid+"]="+1+"&ident="+0;
    	        form.submit();
    		 }
      }

    	function addPro(){
     		if(proCount==''){
    			alert("已达到最大明细金额数！");
    			return;
    		}

     		if(proCount.indexOf('|IG_0172')!=-1){
     			proCount=proCount.replace('|IG_0172', '');
    			document.getElementById("LABEL_IG_0172").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0173')!=-1){
     			proCount=proCount.replace('|IG_0173', '');
    			document.getElementById("LABEL_IG_0173").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0174')!=-1){
     			proCount=proCount.replace('|IG_0174', '');
    			document.getElementById("LABEL_IG_0174").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0175')!=-1){
     			proCount=proCount.replace('|IG_0175', '');
    			document.getElementById("LABEL_IG_0175").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0176')!=-1){
     			proCount=proCount.replace('|IG_0176', '');
    			document.getElementById("LABEL_IG_0176").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0177')!=-1){
     			proCount=proCount.replace('|IG_0177', '');
    			document.getElementById("LABEL_IG_0177").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0178')!=-1){
     			proCount=proCount.replace('|IG_0178', '');
    			document.getElementById("LABEL_IG_0178").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0179')!=-1){
     			proCount=proCount.replace('|IG_0179', '');
    			document.getElementById("LABEL_IG_0179").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0180')!=-1){
     			proCount=proCount.replace('|IG_0180', '');
    			document.getElementById("LABEL_IG_0180").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0181')!=-1){
     			proCount=proCount.replace('|IG_0181', '');
    			document.getElementById("LABEL_IG_0181").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0182')!=-1){
     			proCount=proCount.replace('|IG_0182', '');
    			document.getElementById("LABEL_IG_0182").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0183')!=-1){
     			proCount=proCount.replace('|IG_0183', '');
    			document.getElementById("LABEL_IG_0183").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0184')!=-1){
     			proCount=proCount.replace('|IG_0184', '');
    			document.getElementById("LABEL_IG_0184").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0185')!=-1){
     			proCount=proCount.replace('|IG_0185', '');
    			document.getElementById("LABEL_IG_0185").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0186')!=-1){
     			proCount=proCount.replace('|IG_0186', '');
    			document.getElementById("LABEL_IG_0186").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0187')!=-1){
     			proCount=proCount.replace('|IG_0187', '');
    			document.getElementById("LABEL_IG_0187").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0188')!=-1){
     			proCount=proCount.replace('|IG_0188', '');
    			document.getElementById("LABEL_IG_0188").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0189')!=-1){
     			proCount=proCount.replace('|IG_0189', '');
    			document.getElementById("LABEL_IG_0189").style.display='';
    			return;
     		}
     		if(proCount.indexOf('|IG_0190')!=-1){
     			proCount=proCount.replace('|IG_0190', '');
    			document.getElementById("LABEL_IG_0190").style.display='';
    			return;
     		}
         }
    	function pics(){
       	 var pics = "${IGASM24041VO.picsXml}";
       	 openIntegrationWindow(pics, "pics", "1000", "600");
        }
        
        function picu(){
       	 var picu = "${IGASM24041VO.picuXml}";
       	 openIntegrationWindow(picu, "picu", "1000", "600");
        }
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 发票配置编辑 </p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>

		    <html:form styleId="form" action="/IGASM2404" enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
                 <div class="title">
                     <div class="name">发票基本信息</div>
                 </div>
                 <div id="results_list">
				    <table class="table_style">
						<tr>
<!--                            <th width="10%">模型名称</th>-->
                            <th width="10%">费用编号</th>
                            <th width="20%">费用名称</th>
<!--                            <th width="10%">发票所属机构</th>-->
                            <th width="23%">费用摘要</th>
                            <th width="7%">管理人</th>
                            <th width="8%">登记日</th>
                            
						</tr>
						<tr>
<!--							<td align="center">-->
<!--                            ${IGASM24041VO.entityData.ename}-->
<!--                          </td>-->
						  <td align="center">${IGASM24041VO.entityData.eilabel}</td>
						  <td align="center">${IGASM24041VO.entityData.einame}</td>
<!--						  <td>${IGASM24041VO.eiorgname}</td>-->
						  <td>${IGASM24041VO.entityData.eidesc}</td>
						  <td align="center">${IGASM24041VO.entityData.eiusername}</td>
						  <td align="center">
                           ${IGASM24041VO.entityData.eiinsdate}
                      </td>
						</tr>
                     </table>
                  </div>
                    
                  <div class="title">
                      <div class="name">发票配置信息</div>
                  </div>
    <div class="message"><ig:message /></div>
    <logic:present name="IGASM24041VO" property="flag">
    <logic:equal value="true" name="IGASM24041VO" property="flag">	
	<logic:present name="IGASM24041VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM24041VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGASM24041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM24041VO"
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
<!--						<th width="20%" align="left">配置项说明</th>-->
<!--						<th width="15%" align="left">附件</th>-->
<!--						<th width="10%">版本号</th>-->
						<!--th width="9%">更新时间</th>-->
						<th></th>
					</tr>
					<logic:iterate id="bean" name="list" indexId="index">
					<bean:define id="hiddenValue" value="n" />
					<logic:equal name="bean" property="cseq" value="1">
						<bean:define id="hiddenValue" value="y" />
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0172">
						<logic:equal name ="bean" property="civalue" value="">
								<script>proCount=proCount+'|IG_0172';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0173">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0173';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0174">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0174';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0175">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0175';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0176">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0176';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0177">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0177';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0178">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0178';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0179">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0179';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0180">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0180';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0181">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0181';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0182">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0182';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0183">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0183';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0184">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0184';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0185">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0185';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0186">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0186';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0187">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0187';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0188">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0188';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0189">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0189';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					<logic:equal name ="bean" property="clabel" value="IG_0190">
						<logic:equal name ="bean" property="civalue" value="">
							<script>proCount=proCount+'|IG_0190';</script>
							<bean:define id="hiddenValue" value="y" />
						</logic:equal>
					</logic:equal>
					
						<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" id = "LABEL_${bean.clabel }"
									<logic:equal name="hiddenValue"  value="y">style="display: none;"</logic:equal>
								>
							<!-- 占位调整格式使用 -->
							<td></td>
							<!-- 名称 -->
							<td align="left">
							<div class="nowrapDiv">
							<logic:equal value="1" name="bean" property="crequired">
								<span class="red">*</span>
							</logic:equal>
							<logic:empty name="bean"
								property="cname">&nbsp;</logic:empty> ${bean.cname}</div>
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
									<html:text property="civalue[${ADcount}]" styleId="civalue"
										size="40" errorStyleClass="inputError"
										styleClass="input_left" />
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
								<img src="images/seek.gif" border="0" width="16" height="16" alt="查询" onclick="selectEntityItem('${bean.coption}','${ADcount}')" style="cursor: hand"/> 
								<html:checkbox property="isUpgrade[${ADcount}]" styleId="isUpgrade[${ADcount}]" value="1"><span style="vertical-align: middle;">是否关系升级</span></html:checkbox>
								<br/>
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="5">
								<logic:present name="IGASM2404Form" property="civalue[${ADcount}]">
									<bean:define id="civalue" name="IGASM2404Form" property="civalue[${ADcount}]" type="java.lang.String" />
									<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
										<bean:define id="cb_civalue" name="checkboxbean" property="value" type="java.lang.String" />
											<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" 
											<%=ASMHelper.isChecked(civalue,cb_civalue)?"checked='checked'":"" %> />${checkboxbean.value}
											<br />
									</logic:iterate>
								</logic:present>
								<logic:notPresent name="IGASM2404Form" property="civalue[${ADcount}]">
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
	                        		<a href="javascript:clear($('civalue[${ADcount}]'));">清空</a>
	                        		<logic:equal name ="bean" property="clabel" value="IG_0171">
										<a href ="javascript:addPro();"><img src="images/addinfo.png" border="0" align="middle" style="cursor: hand" width="18" height="18"></a>
									</logic:equal>
									<br/>
							</logic:equal>
							</div>
							</td>
							<!-- 配置项说明 -->
							<!-- 附件 -->
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
    <logic:present name="IGASM24041VO" property="flag">
    <logic:equal value="true" name="IGASM24041VO" property="flag">
    <html:hidden property="ident"/>
	<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp(0);" />
    </logic:equal>
    </logic:present>
<!--    <logic:notEqual value="true" name="IGASM24041VO" property="image_flag">-->
<!--		<html:button property="btn_insert" value="上传影像" styleClass="button" onclick="picu();"/>-->
<!--		<html:button property="btn_insert" value="查看影像" styleClass="button" onclick="pics();"/>-->
<!--    </logic:notEqual>-->
    <html:cancel styleClass="button" value="返回"/>
    </div>
    <html:hidden property="eiid" styleId="eiid" value="${IGASM2404Form.eiid}"/>
    <html:hidden property="eiversion" styleId="eiversion" value="${IGASM24041VO.entityData.eiversion}"/>
    <html:hidden property="eiorgsyscoding" styleId="eiorgsyscoding" value="${IGASM24041VO.entityData.eiorgsyscoding}" />
	</html:form>
		</div>
    </div>
</div>


</div>
</body>
</html:html>