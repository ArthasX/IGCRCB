<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.deliverik.infogovernor.util.ASMHelper"%>
<html:html>
<bean:define id="id" value="IGASM2815" toScope="request"/>
<bean:define id="title" value="检查项详细信息" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		var gid='IGASM2804';
		WebCalendar.timeShow   = false;          //是否返回时间
		function confirmDisp(ident){
			var message1 = '<bean:message key="IGCO10000.W003" arg0="检查项配置信息" />';

			<logic:present name="IGASM28041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM28041VO" property="configItemVWInfoMap" indexId="number">
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
        		 form.action = getAppRootUrl() + "/IGASM2801.do";
        	 }else{
        		 form.action = getAppRootUrl() + "/IGASM2814.do";      		 
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
    			form.action = getAppRootUrl() + "/IGASM2804.do?delfile["+fileid+"]="+1+"&ident="+0;
    	        form.submit();
    		 }
        }
        function selectVersion(){
	 	      var a = document.getElementById("selecteiversion").value;
		      var eiid=document.getElementById("eiid").value;
		      window.location.href="IGASM2804_Disp.do?eiid="+eiid+"&eiversion="+a;
        }
	    function searchuser(){	
	  		openSubWindow('/IGSYM1905_Disp.do?', '_blank','1000','600','center:1');
	  	}
	  	function setIGCYB0101Params(username,orgname,orgid,useremail,userphone,usermobile,userid){
	  		jQuery("*[name='civalue[1]']").val(username);
	  		document.getElementById("hiddenmguserid").value = userid;
	  	}
	    //页面是否可编辑判断
	  	 function identyflag(){
	       	  var loolsign=${looksign};	
	    	  // 1 编辑查询  0 仅查看
	       	  var flag = ${identyFlag};
	       	  //判断有无更改权限  true 可改，false 不可
	          var e=jQuery("#eiversion").val();
	       	  //当前资产最高版本
	 		  var currentEiversion = jQuery("#selecteiversion").val();
	 		  //当前选择的版本  
	       	  if(loolsign==1){
				  if(flag && e==currentEiversion){
					  var img="<img  id=\"img01\" src=\"images/seek.gif\" border=\"0\" style=\"cursor: pointer;\" onclick=\"searchuser();\"/>";
					  jQuery("*[name='civalue[1]']").attr({readonly:"true"});
					  jQuery("*[name='civalue[1]']").after(img);
				  }else{
				   jQuery("input,textarea",jQuery("#identify").get(0)).css({border:"0px",overflow:"hidden"}).attr({readonly:"true"});
					  jQuery("select",jQuery("#identify").get(0)).each(function(i,t){
						  t= jQuery(t);
						  t.hide();
						  t.before("<span>"+t.val()+"</span>");
					  });
					  jQuery("#btn_insert").hide();
					  jQuery("#btn_save").hide();
					  jQuery("#img01").hide();
				  }
	       	  }else{
	       		jQuery("input,textarea",jQuery("#identify").get(0)).css({border:"0px",overflow:"hidden"}).attr({readonly:"true"});
	     		  jQuery("select",jQuery("#identify").get(0)).each(function(i,t){
	     			  t= jQuery(t);
	     			  t.hide();
	     			  t.before("<span>"+t.val()+"</span>");
	     		  });
	     		  jQuery("#btn_insert").hide();
	     		  jQuery("#btn_save").hide();
	     		  jQuery("#img01").hide();
	       	
	    	   }
	  	  }	 
	      function changCheckToRisk(){
	    	  jQuery("#checkToRisk").toggle();
	      }
	      function changeCheckToZb(){
	    	  jQuery("#checkToZb").toggle();
	      }
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body onload="identyflag();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">


    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 检查项属性编辑 </p>
            </div>

		    <html:form styleId="form" action="/IGASM2804" enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
                 <div class="title">
                     <div class="name">检查项基本信息</div>
                 </div>
                 <div id="results_list">
                  <table class="table_style"  >
						<!-- header部 -->
						
							<tr>
								<th width="10%">风险领域</th>
								<th width="10%">风险子域</th>
								<th width="8%" >风险项</th>
								<th width="8%">检查项编号</th>
								<th width="16%">检查项名称</th>
								<th width="12%">检查项说明</th>
								<th width="6%">登记人</th>
								<th width="6%">登记日期</th>
								<th width="8%">更新时间</th>
							</tr>
						
						 <logic:present name="IGASM28041VO" property="itemList" >
		               <logic:iterate id="bean" name="IGASM28041VO" property="itemList" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">
										<td>${bean.riskly }</td>
										<td>${bean.riskarea}</td>
										<td>${bean.riskitem}</td>
										<td>${bean.eilabel}</td>
										<td>${bean.einame }</td>
										<td title="${bean. eidesc}" style='cursor:hand'>
											<ig:SubstringShowEllipsisWriteTag len="20" showEllipsis="true">
												${bean. eidesc}
											</ig:SubstringShowEllipsisWriteTag>
										</td>
										<td>${bean.eiusername }</td>
										<td>${bean.eiinsdate }</td>
										<td>${bean.eiupdtime }</td>
									</tr>
									<html:hidden property="eiid" styleId="eiid" value="${bean.eiid}"/>
								    <html:hidden property="eiversion" styleId="eiversion" value="${bean.eiversion}"/>
								    <html:hidden property="eiorgsyscoding" styleId="eiorgsyscoding" value="${bean.eiorgsyscoding}" />
									</logic:iterate>
									</logic:present>
					</table>
                  </div>
                    
                  <div class="title">
                      <div class="name">检查项属性信息</div>
                  </div>
    <div class="message"><ig:message /></div>
    <logic:present name="IGASM28041VO" property="flag">
    <logic:equal value="true" name="IGASM28041VO" property="flag">	
	<logic:present name="IGASM28041VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM28041VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
					<li >
					<html:select property="selecteiversion" onchange="selectVersion();" style="border:1px solid #CCCCCC;">
					<option value="">版本选择&nbsp&nbsp当前版本${IGASM2804Form.selecteiversion}.0 </option>
					 <logic:present name="IGASM28041VO" property="checkVersionMap" >
					<%-- <html:optionsCollection name="IGASM27041VO" property="checkVersionMap" label="${versionMap.value}" value="${versionMap.value}"/> --%>
		               <logic:iterate id="versionMap" name="IGASM28041VO" property="checkVersionMap" indexId="index">
						<option value="${versionMap.value}">版本选择&nbsp&nbsp第&nbsp&nbsp ${versionMap.value} &nbsp&nbsp版</option>
					   </logic:iterate>
					  </logic:present>
					</html:select>
					</li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup" id="identify"><logic:present
			name="IGASM28041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM28041VO"
				property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2">
					<tr>
						<th width="4%"></th>
						<th width="15%" align="left">属性名称</th>
						<th width="40%" align="left">属性内容</th>
						<th width="15%" align="left">附件</th>
						<th width="20%" align="left">说明</th>
						<th width="10%">版本号</th>
						<!--th width="9%">更新时间</th -->
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
								<br />
							</logic:equal>
							<logic:equal name="bean" property="cattach" value="5">
								<logic:present name="IGASM2804Form" property="civalue[${ADcount}]">
									<bean:define id="civalue" name="IGASM2804Form" property="civalue[${ADcount}]" type="java.lang.String" />
									<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
										<bean:define id="cb_civalue" name="checkboxbean" property="value" type="java.lang.String" />
											<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" 
											<%=ASMHelper.isChecked(civalue,cb_civalue)?"checked='checked'":"" %> />${checkboxbean.value}
											<br />
									</logic:iterate>
								</logic:present>
								<logic:notPresent name="IGASM2804Form" property="civalue[${ADcount}]">
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
							
							<!-- 附件 -->
							<td align="left">
							<div id = "file[${ADcount}]" class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<a
									href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
								${bean.civalue} </a>
								<html:hidden property="delfile[${ADcount}]" styleId="delfile[${ADcount}]" />
								<c:if test="${bean.civalue > ''}">
									<img src="images/delate.gif" align="middle" onClick="delFile('${ADcount}')" border="0" style="cursor: hand" alt="删除"/>
								</c:if>
							</logic:equal></div>
							</td>
							<!-- 配置项说明 -->
							<td align="left">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="cdesc">&nbsp;</logic:empty> ${bean.cdesc}</div>
							</td>
							<!-- 版本号 -->
							<td align="center">
							<div class="nowrapDiv"><logic:empty name="bean"
								property="civersion">&nbsp;</logic:empty> ${bean.civersion}.0</div>
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
	 <div class="title">
              <div class="name">检查项关系信息</div>
     </div>
	<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
		<li class="TabbedPanelsTab"  style="width:150px" onclick="changCheckToRisk()">所属领域风险点</li>
		</ul>
			<div class="TabbedPanelsContentGroup">
			<div class="TabbedPanelsContent">
				<div class="record_list" id="checkToRisk">
				<table class="table_style2">
					<tr>
						<th width="10%" align="center">风险点编号</th>
						<th width="20%" align="center">风险点名称</th>
						<th width="20%" align="center">风险点说明</th>
						<th width="10%" align="center">风险级别</th>
						<th width="12%" align="center">风险严重等级</th>
						<th width="15%" align="center">风险发生可能性</th>
						<th width="13%" align="center">风险点标志</th>
					</tr>
					  <logic:present name="IGASM28041VO" property="checkToRiskRelateList" >
	               <logic:iterate id="bean" name="IGASM28041VO" property="checkToRiskRelateList" indexId="index">
						<tr>
							<td>${bean.eilabel }</td>
							<td>${bean.einame }</td>
							<td>${bean.eidesc }</td>
							<td>${bean.levels }</td>
							<td>${bean.grad}</td>
							<td>${bean.poss}</td>
							<td>${bean.risksign }</td>
						</tr>
								
					</logic:iterate>
					</logic:present>
					</table>
					</div>
			</div>
		
		</div>
		</div>
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
		<li class="TabbedPanelsTab" style="width:150px;" onclick="changeCheckToZb();">所属领域风险指标</li>
		</ul>
			<div class="TabbedPanelsContentGroup">
			<div class="TabbedPanelsContent">
				<div class="record_list" id="checkToZb">
				<table class="table_style2">
					<tr>
						<th width="10%" align="center">指标编号</th>
						<th width="30%" align="center">指标名称</th>
						<th width="30%" align="center">指标说明</th>
						<th width="10%" align="center">阈值</th>
						<th width="20%" align="center">是否关键指标</th>
					</tr>
					<logic:present name="IGASM28041VO" property="riskToZhRelateList" >
	               <logic:iterate id="bean" name="IGASM28041VO" property="riskToZhRelateList" indexId="index">
						<tr>
							<td>${bean.eilabel }</td>
							<td>${bean.einame }</td>
							<td>${bean.eidesc }</td>
							<td>${bean.threshold}</td>
							<td>${bean.keyindex }</td>
						</tr>
								
					</logic:iterate>
					</logic:present>
					</table>
					</div>
			</div>
		
		</div>
		</div>
    <div class="enter">
    <logic:present name="IGASM28041VO" property="flag">
    <logic:equal value="true" name="IGASM28041VO" property="flag">
    <html:hidden property="ident"/>
	<html:hidden property="hiddenmguserid"/>    
	<html:submit property="btn_insert"  styleId="btn_save" value="保存" styleClass="button" onclick="return confirmDisp(0);"/>
	<html:submit property="btn_insert"  styleId="btn_insert" value="提交 " styleClass="button" onclick="return confirmDisp(1);" />
    </logic:equal>
    </logic:present>
    <%-- <html:cancel styleClass="button" value="返回"/> --%>
     <html:hidden property="selecteiversion"    styleId="selecteiversion" value="${IGASM2804Form.selecteiversion}"/>
    </div>
	</html:form>
		</div>
    </div>
</div>


</div>
</body>
</html:html>