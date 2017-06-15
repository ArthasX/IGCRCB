<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.deliverik.infogovernor.util.ASMHelper"%>
<html:html>
<bean:define id="id" value="IGASM0504" toScope="request"/>
<bean:define id="title" value="文档配置信息编辑画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
		var gid='IGASM0504';
		WebCalendar.timeShow   = false;          //是否返回时间
		function confirmDisp(ident){
			var message1 = '<bean:message key="IGCO10000.W003" arg0="文档属性信息" />';

			<logic:present name="IGASM05041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM05041VO" property="configItemVWInfoMap" indexId="number">
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
        	form.action = getAppRootUrl() + "/IGCRC1301.do";
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
    			form.action = getAppRootUrl() + "/IGASM0504.do?delfile["+fileid+"]="+1+"&ident="+0;
    	        form.submit();
    		 }
      }
      
function init(){
	if($("civalue[2]") != null){
		var img = "<img style=\"cursor: hand;\" onclick=\"selectTree('124_tree_文档分类','1');\" alt=\"查询\" src=\"images/seek.gif\" complete=\"complete\"/>";
		var input = "<input name=\"show[2]\" class=\"input_left\" type=\"text\" size=\"40\" readOnly=\"true\"/>";
		jQuery("*[name='civalue[2]']").attr({style:"display:none;"});
		jQuery("*[name='civalue[2]']").before(input);
		jQuery("*[name='civalue[2]']").before(img);
		$("show[2]").value = $("civalue[2]").value.substring(15);
	}
}
      
      function selectVersion(){
			var a = document.getElementById("selecteiversion").value;
			var eiid=document.getElementById("eiid").value;
			
			if(document.getElementById("eiversion").value !=  a){
				window.location.href="IGASM0509_Disp.do?eiid="+eiid+"&eiversion="+a;
			}else{
				window.location.href="IGASM0504_Disp.do?eiid="+eiid+"&eiversion="+a;
    		}
	      }
      
      //选树顺序调整现在是第三个是文档分类
      function selectTree(ccidinfo,selecedlast){
    		var ccid = ccidinfo.split("_tree_")[0];
    		url = "IGSYM1505_TREE.do" + "?ccid="+ccid + "&selecedlast=" + selecedlast;

    		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

    		if("_resetall"==temp){
    			$("civalue[2]").value = "";
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
    				$("civalue[2]").value = treesyscode + "_tree_" + name;
    				$("show[2]").value = name;
    			}else{
    				$("civalue[2]").value = '';
    				$("show[2]").value = '';
    			}
    			
    		}		
    		if($("show[2]").onchange){
    			$("show[2]").onchange();
    		}
    	}
	</script>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body onload="init()">
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 文档属性编辑 </p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>

		    <html:form styleId="form" action="/IGASM0504" enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
                 <div class="title">
                     <div class="name">文档基本信息</div>
                 </div>
                 <div id="results_list">
				    <table class="table_style">
						<tr>
                            <th width="20%">文档名称</th>
                            <th width="20%">提交部门</th>
                            <th width="20%">文档说明</th>
                            <th width="20%">管理人</th>
                            <th width="20%">登记日</th>
                            
						</tr>
						<tr>
						  <td align="center">${IGASM05041VO.entityData.einame}</td>
						  <td>${IGASM05041VO.eiorgname}</td>
						  <td>${IGASM05041VO.entityData.eidesc}</td>
						  <td align="center">${IGASM05041VO.entityData.eiusername}</td>
						  <td align="center">
                           ${IGASM05041VO.entityData.eiinsdate}
                      </td>
						</tr>
                     </table>
                  </div>
                    
                  <div class="title">
                      <div class="name">文档属性信息</div>
                  </div>
    <div class="message"><ig:message /></div>
    <logic:present name="IGASM05041VO" property="flag">
    <logic:equal value="true" name="IGASM05041VO" property="flag">	
	<logic:present name="IGASM05041VO" property="configItemVWInfoMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGASM05041VO"
				property="configItemVWInfoMap" indexId="number">
				<li class="TabbedPanelsTab" tabindex="0"><ig:codeValue
					ccid="CONFIGURATION_CATEGORY_CODE" cid="${map.key}" /></li>
					<li>
					<html:select property="selecteiversion" onchange="selectVersion();">
					<option value="">版本选择&nbsp&nbsp当前版本${IGASM0504Form.selecteiversion}.0 </option>
					 <logic:present name="IGASM05041VO" property="checkVersionMap" >
					 <logic:iterate id="versionMap" name="IGASM05041VO" property="checkVersionMap" indexId="index">
						<option value="${versionMap.value}">版本选择&nbsp&nbsp第&nbsp&nbsp ${versionMap.value} &nbsp&nbsp版</option>
					   </logic:iterate>
					  </logic:present>
					</html:select>
					</li>
			</logic:iterate>

		</ul>
		<div class="TabbedPanelsContentGroup"><logic:present
			name="IGASM05041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGASM05041VO"
				property="configItemVWInfoMap" indexId="number">
				<bean:define id="list" name="map" property="value"
					type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style2" id = "tab1">
					<tr>
						<th width="4%"></th>
						<th width="25%" align="left">属性名称</th>
						<th width="40%" align="left">属性内容</th>
						<th width="25%" align="left">附件</th>
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
								<logic:present name="IGASM0504Form" property="civalue[${ADcount}]">
									<bean:define id="civalue" name="IGASM0504Form" property="civalue[${ADcount}]" type="java.lang.String" />
									<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
										<bean:define id="cb_civalue" name="checkboxbean" property="value" type="java.lang.String" />
											<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" 
											<%=ASMHelper.isChecked(civalue,cb_civalue)?"checked='checked'":"" %> />${checkboxbean.value}
											<br />
									</logic:iterate>
								</logic:present>
								<logic:notPresent name="IGASM0504Form" property="civalue[${ADcount}]">
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
<!-- 							配置项说明 -->
<!-- 							<td align="left"> -->
<%-- 							<div class="nowrapDiv"><logic:empty name="bean" --%>
<%-- 								property="cdesc">&nbsp;</logic:empty> ${bean.cdesc}</div> --%>
<!-- 							</td> -->
							<!-- 附件 -->
							<td align="left">
							<div id = "file[${ADcount}]" class="nowrapDiv"><logic:equal name="bean"
								property="cattach" value="1">
								<a id = "fileA"
									href="javascript:downloadFile('${bean.eiid}','${bean.ciid}');">
								${bean.civalue} </a>
								<html:hidden property="delfile[${ADcount}]" styleId="delfile[${ADcount}]" />
								<c:if test="${bean.civalue > ''}">
									<img src="images/delate.gif" align="middle" onClick="delFile('${ADcount}')" border="0" style="cursor: hand" alt="删除"/>
								</c:if>
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
    <logic:present name="IGASM05041VO" property="flag">
    <logic:equal value="true" name="IGASM05041VO" property="flag">
    <html:hidden property="ident"/>
	<!--<html:submit property="btn_insert" value="保存" styleClass="button" onclick="return confirmDisp(0);" />-->
	<html:submit property="btn_insert" value="提交 " styleClass="button" onclick="return confirmDisp(1);" />
    </logic:equal>
    </logic:present>
    <html:button property="btn_back" styleClass="button" value="返回" onclick="toback()"/>
    </div>
    <html:hidden property="eiid" styleId="eiid" value="${IGASM0504Form.eiid}"/>
    <html:hidden property="eiversion" styleId="eiversion" value="${IGASM05041VO.entityData.eiversion}"/>
    <html:hidden property="eiorgsyscoding" styleId="eiorgsyscoding" value="${IGASM05041VO.entityData.eiorgsyscoding}" />
	<html:hidden property="isModify" styleId="isModify" value="1" />
	</html:form>
		</div>
    </div>
</div>


</div>
<script type="text/javascript">

function downloadFile(eiid, ciid){
	var param = "";
	var type = "asm";
	param = $H({type: type, eiid: eiid, ciid:ciid}).toQueryString();
	openSubWindow('/download.do?flag=1&' + param, '','800','600');
}

</script>
</body>
</html:html>