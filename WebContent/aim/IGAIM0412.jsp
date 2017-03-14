<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.deliverik.framework.utility.CommonDefineUtils" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGCIM0412" toScope="request" />
<bean:define id="title" value="模型导出" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />


<!-- /header1 -->
<script type="text/javascript">	
	function setEntity(){
	 var alertMessage = '<bean:message bundle="asmResources" key="message.IGCIM0101.005"/>';
		var url = "IGCIM1203_ENTITY_TREE.do?levelnode=999";

		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			 document.forms[0].eparname.value = "";
//			 document.forms[0].eid.value = "";
			 document.forms[0].esyscoding_q.value = "";
			 return false;
		 }
		if(null!=temp && temp.split("|").length>1){
			var syscode_eid = temp.split("|")[0];
			var name = temp.split("|")[1];
			var syscode;
			var eid;
			if(syscode_eid =="999")
			{
				eid = "";
				syscode = syscode_eid;
			}else if(syscode_eid.split("_").length>1){
				eid = syscode_eid.split("_")[0];
				syscode = syscode_eid.split("_")[1];
			}
			document.forms[0].eparname.value = name;
		//	document.forms[0].eid.value = eid;
			document.forms[0].esyscoding_q.value = syscode;
		}		
	}
</script>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
 

    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
          <html:form styleId="form" action="/IGAIM0412_Disp" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
                 <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                   <div>
            		<span>模型名称：</span><html:text property="ename" styleId="ename" errorStyleClass="inputError imeDisabled" size="10"/>&nbsp;&nbsp;
					<span>上级模型：</span><html:text property="eparname" styleId="eparname" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
					<img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity();"/>
					<html:hidden property="esyscoding_q"/>
					<html:submit property="btn_search" styleClass="button" value="查询" />
                   </div>
                   </div>
                </div>
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table class="table_style">
						<!-- header部 -->
						
							<tr>
								<th width="5%">
								序号
								</th>
								<!-- <th width="24%">模型名称</th> by wangxing -->
								<th width="14%" >一级模型</th>
								<th width="14%" >二级模型</th>
								<th width="14%" >三级模型</th>
								<th width="14%" >四级模型</th>
								<th width="14%" >五级模型</th>
								
								<!-- <th width="19%">模型说明</th>  -->
								<th width="14%">模型状态</th>
								<th width="11%">生成模板</th>
							</tr>
						
						<!-- body部 -->
						
                            <logic:present name="IGCIM04011VO" property="entityDataList">
								<logic:iterate id="bean" name="IGCIM04011VO"
									property="entityDataList" indexId="index">
									<bean:define id="entityid" name="bean" property="eid"  toScope="request" />		
									<bean:define id="esyscoding" name="bean" property="esyscoding"  toScope="request" />						
									<tr class="<ig:rowcss index="${index}"/>">

											
										<td>
											<div class="nowrapDiv">${PagingDTO.viewStartCount+index}
											</div>
										</td>

										<!-- 名称 
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="ename">&nbsp;</logic:empty> ${bean.ename}</div>
										</td>
										-->
										<!-- 一级模型 -->
										<td>
										<div class="nowrapDiv">
										<%if(esyscoding.toString().length() == (3 + CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH)){ %>
											<logic:empty name="bean" property="ename">&nbsp;</logic:empty>${bean.ename}
										<%}else{ %>
											&nbsp;
										<%} %>
										</div>
										</td>
										<!-- 二级模型 -->
										<td>
										<div class="nowrapDiv">
										<%if(esyscoding.toString().length() == (3 + CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH*2)){ %>
											<logic:empty name="bean" property="ename">&nbsp;</logic:empty>${bean.ename}
										<%}else{ %>
											&nbsp;
										<%} %>
										</div>
										</td>
										<!-- 三级模型 -->
										<td>
										<div class="nowrapDiv">
										<%if(esyscoding.toString().length() == (3 + CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH*3)){ %>
											<logic:empty name="bean" property="ename">&nbsp;</logic:empty>${bean.ename}
										<%}else{ %>
											&nbsp;
										<%} %>
										</div>
										</td>
										<!-- 四级模型 -->
										<td>
										<div class="nowrapDiv">
										<%if(esyscoding.toString().length() == (3 + CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH*4)){ %>
											<logic:empty name="bean" property="ename">&nbsp;</logic:empty>${bean.ename}
										<%}else{ %>
											&nbsp;
										<%} %>
										</div>
										</td>
										<!-- 五级模型 -->
										<td>
										<div class="nowrapDiv">
										<%if(esyscoding.toString().length() == (3 + CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH*5)){ %>
											<logic:empty name="bean" property="ename">&nbsp;</logic:empty>${bean.ename}
										<%}else{ %>
											&nbsp;
										<%} %>
										</div>
										</td>
										
										<!-- 说明
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="elabel">&nbsp;</logic:empty> ${bean.edesc}</div>
										</td>
										 -->

										<!-- 状态 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="estatus">&nbsp;</logic:empty> <ig:codeValue
											ccid="ENTITY_STATUS_CODE" cid="${bean.estatus}" /></div>
										</td>
										
										<!-- 生成模板  -->
										<td valign="middle">
										<div align="center">
										<html:link action="/IGAIM0412_Export.do?esyscoding=${bean.esyscoding}">
											<img src="images/excel.gif" alt="生成模板" width="16" height="16"
												border="0" />
										</html:link>
										</div>

										</td>
										
									</tr>
									
									
								</logic:iterate>
							</logic:present>
					</table>
				</div>
				<div id="operate">
	             <jsp:include page="/include/paging.jsp" />
                </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>