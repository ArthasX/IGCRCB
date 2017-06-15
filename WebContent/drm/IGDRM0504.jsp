<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.deliverik.infogovernor.util.ASMHelper"%>
<html:html>
<bean:define id="id" value="IGDRM0504" toScope="request"/>
<bean:define id="title" value="专项预案编辑页面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<script type="text/javascript" src="js/jquery-1.9.1.min.js">
</script>
<script>

var jQ = jQuery.noConflict(true);
</script>
<!-- /header1 -->
<script type="text/javascript">	
var gid = 'IGDRM0504';
WebCalendar.timeShow = false;//是否返回时间
		//保存或提交校验
		function confirmDisp(ident){
			//资产基本创建校验
			if($F('einame').trim()==""){
				alert("请输入专项预案名称！");
				return false;
			}
			if($F('einame').strlen()>120){
				alert("专项预案名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
				return false;
			}
			if($F('eiorgname').trim()==""){
				alert("请选择所属部门！");
				return false;
			}
	
			var versionIdent = 0;
			var message1 = '<bean:message key="IGCO10000.W003" arg0="专项预案配置信息" />';

			<logic:present name="IGDRM05041VO" property="configItemVWInfoMap">
			<logic:iterate id="map" name="IGDRM05041VO" property="configItemVWInfoMap" indexId="number">
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
        	form.action = getAppRootUrl() + "/IGDRM0502_Back.do";
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
    			form.action = getAppRootUrl() + "/IGDRM0504.do?delfile["+fileid+"]="+1+"&ident="+0;
    	        form.submit();
    		 }
      }
      
    	//"文档类型"类型树选择设置
    	function selectTree(obj,ccidinfo, selecedlast){
    		obj = jQuery(obj);
    		var ccid = ccidinfo.split("_tree_")[0];
    		url = "IGSYM1505_TREE.do" + "?ccid="+ccid + "&selecedlast=" + selecedlast+"&pageName=0801";
    		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
    		if("_resetall"==temp){
    			obj.prev().val('') ;
    			obj.next().val('') ;
    			//"文档编号"属性设置	
//     			jQuery("#eilabel").val('');
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
    				obj.next().val(treesyscode + "_tree_" + name);
    				obj.prev().val(name);
    				//设置请求的Action
    				jQuery.ajax({
    					url:getAppRootUrl()+"/IGDRM0504_Label.do",
    					type:"POST",
    					data:{esyscoding:treesyscode},
    					success:function(result){
							//如果选择的专项预案资产类型和原来一样,则使用原来的编号否则使用新的标号
							var oldEilabel = jQuery("#oldEilabel").val();
							if(result&&result.substring(0,result.lastIndexOf("/"))==oldEilabel.substring(0,oldEilabel.lastIndexOf("/"))){
								jQuery("#eilabel").val('');
								jQuery("#eilabelTd").text(oldEilabel);
							}else{
								jQuery("#eilabel").val(result);
								jQuery("#eilabelTd").text(result);
								
							}
								
    					}
    				});    				
    				
    			}else{
    				//"专项预案资产编号"属性设置
    				jQuery("#eilabel").val('') ;
    				jQuery("#eilabelTd").text(jQuery("#oldEilabel").val());
    				obj.next().val('');
    				obj.prev().val('');
    			}
    		}
    	}
function toEdit(eiid){
	window.location.href = getAppRootUrl()+'/IGASM0512_Disp.do?eiid='+eiid;
}
function setOrg(url) {
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp) {
		document.forms[0].eiorgsyscoding.value = "";
		document.forms[0].eiorgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1) {
		document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
		document.forms[0].eiorgname.value = temp.split("|")[1];
	}
}

// 参与部门多选树
function setChkOrg(obj){
	var temp = window.showModalDialog('IGORGTREE.do',null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		jQuery(obj).prev().val('');
		return false;
	}
	if(null!=temp){
		jQuery(obj).prev().val(temp);
	}
}
	</script>
<style type="text/css">
#entBox  th{
	background-color: #EEEEEE;
	border-bottom: 1px solid #ccc;
}
#entBox  td{
	border-bottom: 1px solid #d3d3d3;
}

#entBox{
	width: 95%;
	text-align: center;
	padding: 5px;
	margin: 0 auto;
	margin-top: 2px;
}
.entb{
	margin: auto;
	width: 100%;
/* 	border-collapse: collapse; */
/* 	border: 1px solid #f3f3f3; */
}
.entb th{
	width: 15%;
	text-align: right;
/* 	vertical-align: top; */
/* 	border-collapse: collapse; */
}
.entb td{
	width: 35%;
/* 	border: 1px solid #f3f3f3; */
	text-align: left;
/* 	border-collapse: collapse; */
}
.entb select{
	width: 170px;
}
.entb input{
	margin-left: 5px;
	height: auto;
}
.entb textarea{
	width: 85%;
	height: 100px;
}
.longtextdiv{
	clear:left;
	margin-bottom:2px;
	margin-top: 2px;
	margin-left: 50px;
}
</style>
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 专项预案配置编辑 </p>
                <div class="back"><html:link href="javascript:toBack();">返回</html:link></div> 
            </div>

		    <html:form styleId="form" action="/IGDRM0504" enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
		    <div class="message"><ig:message /></div>
		    <fieldset>
		    	<legend>专项预案维护</legend>
		    	<div id ="entBox">
		    		<table class="entb">
						<tr>
                            <th><label for="Name"><strong>专项预案类型 :</strong></label></th>
                            <td><input type="text" class="inputDisable" readonly="readonly" value = "${IGDRM05041VO.entityData.ename}" /></td>
                           <th><label for="Name"><strong>专项预案编号 :</strong></label></th>
                            <td align="center">
						  		<span  id="eilabelTd"><input type="text" class="inputDisable" readonly="readonly" value="${IGDRM05041VO.entityData.eilabel}" /></span>
						  		<input type="hidden" id="oldEilabel" value="${IGDRM05041VO.entityData.eilabel}"/>	
						  		<html:hidden property="eilabel" styleId="eilabel"/>
					  		</td>
                        </tr>
                        <tr>
                         <th><label for="Name"></a><strong><span class="red">*</span>专项预案名称 :</strong></label></th>
                            <td align="center">
						  		<input type="text" name="einame" id="einame" style="width:85%;" value="${IGDRM05041VO.entityData.einame}"/>
						  	</td>
                            
                            <th><label for="Name"><strong>创建时间 :</strong></label></th>
                            <td>
                            	<input type="text" class="inputDisable" readonly="readonly" value="${IGDRM05041VO.entityData.eiinsdate}" />
                            </td>
						</tr>
						<tr>
							<th><label for="Name"><strong><span class="red">*</span>所属部门 :</strong></label></th>
						  	<td align="center" colspan="3">
						  		<html:text property="eiorgname" styleId="eiorgname" size="48" styleClass="inputDisable" value="${IGDRM05041VO.eiorgname}" errorStyleClass="inputError imeActive" readonly="true"></html:text>
								<img width="16" height="16" style="cursor: hand;" onclick="setOrg('IGSYM0101_ROLETREE.do');" alt="所属部门" src="images/tree.gif" border="0"/>
						  	</td>
						</tr>
						<tr>
						<th> <label for="Name"><strong>专项预案说明:&nbsp;&nbsp;</strong> </label></th>
							<td colspan="3">
								<html:textarea property="eidesc" styleId="eidesc" value="${IGDRM05041VO.entityData.eidesc}"></html:textarea>
							</td>
						</tr>
                     <logic:present name="IGDRM05041VO" property="flag">
					    <logic:equal value="true" name="IGDRM05041VO" property="flag">	
						<logic:present name="IGDRM05041VO" property="configItemVWInfoMap">
					
							<logic:present	name="IGDRM05041VO" property="configItemVWInfoMap">
								<logic:iterate id="map" name="IGDRM05041VO"	property="configItemVWInfoMap" indexId="number">
									<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
										<logic:iterate id="bean" name="list" indexId="index">
											<tr cid= "${bean.cid}" onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);" <logic:equal name="bean" property="cseq" value="1">style="display: none;"</logic:equal>>
												<!-- 占位调整格式使用 -->
												<!-- 名称 -->
												<th align="left">
												<label for="Name">
													<div class="longtextdiv">
														<logic:equal value="1" name="bean" property="crequired">
															<span class="red">*</span>
														</logic:equal>
														<logic:empty name="bean" property="cname">&nbsp;
														</logic:empty>
															${bean.cname } :
													</div>
													</label>
												</th>
												
												<!-- 内容 -->
												<td align="left" colspan="3"
													<logic:equal name="bean" property="cattach" value="5">align="left" style="padding-left: 100px;"</logic:equal>
													<logic:notEqual name="bean" property="cattach" value="5">align="center"</logic:notEqual>>
												<!-- 附件 -->
												<logic:equal name="bean" property="cattach" value="1">
													<html:hidden property="civalue[${ADcount}]" styleId="civalue" />
													<!-- 显示附件内容-2014/09/27 -->
													<logic:notEmpty name="bean" property="civalue" >
														<div id = "file[${ADcount}]" class="nowrapDiv">
															<a href="javascript:downloadASMFile('${bean.eiid}','${bean.ciid}');">
																${bean.civalue}
															</a>
															<html:hidden property="delfile[${ADcount}]" styleId="delfile[${ADcount}]" />
															<c:if test="${bean.civalue > ''}">
																<img src="images/delate.gif" align="middle" onClick="delFile('${ADcount}')" border="0" style="cursor: hand" alt="删除"/>
															</c:if>
														</div>
													</logic:notEmpty>
													<logic:empty name="bean" property="civalue" >
														<html:file property="attachFile[${ADcount}]" styleId="attachFile[${ADcount}]" size="25"	errorStyleClass="inputError imeDisabled"
															onkeydown="return false;" styleClass="imeDisabled" />
															<img src="images/empty.gif" align="middle" onClick="cleanFile('attachFile[${ADcount}]','civalue[${ADcount}]')" border="0" style="cursor: hand"/>
													</logic:empty>
												</logic:equal>
												<!-- 文本框 -->
												<logic:equal name="bean" property="cattach" value="0">
													<logic:notEqual value="参与部门" name="bean" property="cname">
														<html:text property="civalue[${ADcount}]" styleId="civalue" size="40" errorStyleClass="inputError" styleClass="input_left" />
													</logic:notEqual>
													<logic:equal value="参与部门" name="bean" property="cname">
														<html:text property="civalue[${ADcount}]" styleId="civalue" size="40" errorStyleClass="inputError" styleClass="input_left" readonly="true" />
														<img width="16" height="16" style="cursor: hand;" onclick="setChkOrg(this);" alt="参与部门" src="images/tree.gif" border="0"/>
													</logic:equal>
												</logic:equal>
												<!-- 下拉列表 -->
												<logic:equal name="bean" property="cattach" value="2">
					
												<input type="text" value="civalue[${ADcount}]"/>
													<html:select property="civalue[${ADcount}]" style="width:53.5%;" errorStyleClass="inputError imeActive">
														<html:options collection="ADlist${ADmapcount}" property="value" name="" labelProperty="label" />
													</html:select>
													<c:set var="ADmapcount" value="${ADmapcount+1}"/>
												</logic:equal>
												<!-- 日期控件 -->
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
													<logic:present name="IGADRM0504Form" property="civalue[${ADcount}]">
														<bean:define id="civalue" name="IGADRM0504Form" property="civalue[${ADcount}]" type="java.lang.String" />
														<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
															<bean:define id="cb_civalue" name="checkboxbean" property="value" type="java.lang.String" />
																<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" 
																<%=ASMHelper.isChecked(civalue,cb_civalue)?"checked='checked'":"" %> />${checkboxbean.value}
																<br />
														</logic:iterate>
													</logic:present>
													<logic:notPresent name="IGADRM0504Form" property="civalue[${ADcount}]">
														<logic:iterate id="checkboxbean" name="ADlist${ADmapcount}">
															<input type="checkbox" name="cb_civalue[${ADcount}]" value="${checkboxbean.value}" />${checkboxbean.value}
															<br />
														</logic:iterate>
													</logic:notPresent>
													<html:hidden property="civalue[${ADcount}]"/>
													<c:set var="ADmapcount" value="${ADmapcount+1}"/>
												</logic:equal>
												<!-- 文本域 -->
												<logic:equal name="bean" property="cattach" value="6">
														<html:textarea property="civalue[${ADcount}]" styleId="civalue" 
															errorStyleClass="inputError" rows="5" cols="70" />
												</logic:equal>
												<!-- 数字控件 -->
												<logic:equal name="bean" property="cattach" value="7">
														<html:text property="civalue[${ADcount}]" styleId="civalue[${ADcount}]" errorStyleClass="inputError imeDisabled" size="17" readonly="true" /> 
						                        		<img src="images/softkeyboard.gif" align="middle" onClick="SoftKeyboard($('civalue[${ADcount}]'))" border="0" style="cursor: hand"/>
						                        		<a href="javascript:clear($('civalue[${ADcount}]'));">清空</a><br/>
												</logic:equal>
												</td>
												<!-- 配置项说明 -->
												<html:hidden property="ciid" styleId="ciid" value="${bean.ciid}" />
												<html:hidden property="cid" styleId="cid" value="${bean.cid}" />
												<html:hidden property="clabel" styleId="clabel" value="${bean.clabel}" />
												<html:hidden property="ciattach" styleId="ciattach" value="${bean.cattach}" />
												<html:hidden property="eid" styleId="eid" value="${bean.eid}" />
												<html:hidden property="esyscoding" styleId="esyscoding" value="${bean.esyscoding}" />
												<html:hidden property="entityItemCivalue[${ADcount}]" styleId="entityItemCivalue[${ADcount}]"/>
												<html:hidden property="civalue_bak[${ADcount}]" styleId="civalue_bak[${ADcount}]" />
											</tr>
											<c:set var="ADcount" value="${ADcount+1}"/>
										</logic:iterate>
								</logic:iterate>
							</logic:present>
						</logic:present>
						</logic:equal>
					</logic:present>
					</table>
				</div>
				    <div style="margin:0 auto;text-align: center;">
				    <logic:present name="IGDRM05041VO" property="flag">
				    <logic:equal value="true" name="IGDRM05041VO" property="flag">
				    <html:hidden property="ident"/>
					<html:submit property="btn_insert" value="保存" styleClass="button" onclick="return confirmDisp(0);" />
					<html:submit property="btn_insert" value="提交 " styleClass="button" onclick="return confirmDisp(1);" />
				    </logic:equal>
				    </logic:present>
				    </div>
				    <html:hidden property="eiid" styleId="eiid" value="${IGDRM0504Form.eiid}"/>
				    <html:hidden property="eiversion" styleId="eiversion" value="${IGDRM05041VO.entityData.eiversion}"/>
				    <html:hidden property="eiorgsyscoding" styleId="eiorgsyscoding" value="${IGDRM05041VO.entityData.eiorgsyscoding}" />
		    </fieldset>
		    	</div>
			</html:form>
		</div>
    </div>
</div>


</div>
</body>
<script>
jQuery(".longtextdiv:contains(系统架构)").parent().parent().attr("rowSpan","2");
jQuery(".longtextdiv:contains(系统架构)").parent().parent().parent().next().find("th").hide();
function toBack(){
	window.location.href = getAppRootUrl()+"/IGDRM0502_Back.do";
}
jQ(function(){
	jQ("tr[cid='CI500000000001'],tr[cid='CI500000000002']").hide();
})
</script>
</html:html>