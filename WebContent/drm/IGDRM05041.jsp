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
<bean:define id="id" value="IGDRM05041" toScope="request"/>
<bean:define id="title" value="专项预案详细信息" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
</script>
<style type="text/css">
#entBox th{
	background-color: #EEEEEE;
	border-bottom: 1px solid #ccc;
}
#entBox td{
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
}
.entb td{
	width: 35%;
/* 	border: 1px solid #f3f3f3; */
	text-align: left;
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 专项预案详细信息 </p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>

		    <html:form styleId="form" action="/IGDRM0504" enctype="multipart/form-data" onsubmit="return checkSubmit(this);">
		    <div class="message"><ig:message /></div>
		    <fieldset>
		    	<legend>专项预案详细信息</legend>
		    	<div id ="entBox">
		    		<table class="entb">
						<tr>
                            <th><label for="Name">
                            <strong>专项预案类型 :</strong></label></th>
                            <td><input type="text" class="inputDisable" readonly="readonly" value = "${IGDRM05041VO.entityData.ename}" /></td>
                           <th><label for="Name"><strong>专项预案编号 :</strong></label></th>
                            <td align="center">
						  		<span  id="eilabelTd"><input type="text" class="inputDisable" readonly="readonly" value="${IGDRM05041VO.entityData.eilabel}" /></span>
						  		<input type="hidden" id="oldEilabel" value="${IGDRM05041VO.entityData.eilabel}"/>	
						  		<html:hidden property="eilabel" styleId="eilabel"/>
					  		</td>
                        </tr>
                        <tr>
                         <th><label for="Name"><strong><span class="red">*</span>专项预案名称 :</strong></label></th>
                            <td align="center">
						  		<input type="text" name="einame" id="einame" readonly="true" style="width:85%;" value="${IGDRM05041VO.entityData.einame}"/>
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
						  	</td>
						</tr>
						<tr>
						<th> <label for="Name"><strong>专项预案说明:&nbsp;&nbsp;</strong> </label></th>
							<td colspan="3">
								<html:textarea property="eidesc" styleId="eidesc" value="${IGDRM05041VO.entityData.eidesc}" readonly="true"></html:textarea>
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
													<div class="nowrapDiv" style="">
														<logic:equal value="1" name="bean" property="crequired">
															<span class="red">*</span>
														</logic:equal>
														<logic:empty name="bean" property="cname">&nbsp;</logic:empty>
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
<%-- 																<img src="images/delate.gif" align="middle" onClick="delFile('${ADcount}')" border="0" style="cursor: hand" alt="删除"/> --%>
															</c:if>
														</div>
													</logic:notEmpty>
													<logic:empty name="bean" property="civalue" >
														<html:file property="attachFile[${ADcount}]" styleId="attachFile[${ADcount}]" size="25"	errorStyleClass="inputError imeDisabled"
															onkeydown="return false;" styleClass="imeDisabled" />
<%-- 															<img src="images/empty.gif" align="middle" onClick="cleanFile('attachFile[${ADcount}]','civalue[${ADcount}]')" border="0" style="cursor: hand"/> --%>
													</logic:empty>
												</logic:equal>
												<!-- 文本框 -->
												<logic:equal name="bean" property="cattach" value="0">
													<logic:notEqual value="参与部门" name="bean" property="cname">
														<html:text property="civalue[${ADcount}]" styleId="civalue" size="40" errorStyleClass="inputError" styleClass="input_left" />
													</logic:notEqual>
													<logic:equal value="参与部门" name="bean" property="cname">
														<html:text property="civalue[${ADcount}]" styleId="civalue" size="40" errorStyleClass="inputError" styleClass="input_left" readonly="true" />
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
														<html:textarea property="civalue[${ADcount}]" styleId="civalue"  readonly="true" 
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
<%-- 				    <html:button property="btnCancel" styleClass="button"  onclick="toBack()" value="返回"/> --%>
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
jQuery(".nowrapDiv:contains(系统架构)").parent().parent().attr("rowSpan","2");
jQuery(".nowrapDiv:contains(系统架构)").parent().parent().parent().next().find("th").hide();

function toback(){
	window.location.href = getAppRootUrl()+"/IGDRM0502_Search_Back.do";
}
jQuery(".red").hide();
</script>
</html:html>