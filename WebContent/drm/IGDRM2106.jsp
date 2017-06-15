<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM2106" toScope="request" />
<bean:define id="title" value="业务系统" toScope="request" />

<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	

	WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
	WebCalendar.format     = "yyyy/mm/dd"  //回传日期的格式
	WebCalendar.timeShow   = false          //是否返回时间
	WebCalendar.drag       = true          //是否允许拖动
	WebCalendar.darkColor  = "#014DB4";    //控件的暗色
	WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
	WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
	WebCalendar.wordColor  = "#000080";    //控件的文字颜色
	WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
	WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
	WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
	WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色

function relationRec(){
	var message ='<bean:message key="IGCO10000.E002"/>';
	var confirmMsg ="确定关联选中资产?";
	var frm = window.document.forms[0];
	if(frm.relationEiid) {
		if(frm.relationEiid.length > 0){
			var bchecked = false;
			for(var i=0; i<frm.relationEiid.length; i++ ){
				if (frm.relationEiid[i].checked == true){
					bchecked = true;
				}
			}
			if (!bchecked) {
            	alert("请选择要关联资产！");
                return false;
            }
        } else {
			if ($("relationEiid").checked == false){
				alert("请选择要关联资产！");
				return false;
			}  
		}
	} else {
		alert("没有可关联的资产！");
		return false;
	}
	if( window.confirm(confirmMsg)){
		form.action = getAppRootUrl() + "/IGDRM0402_Relation.do";
		return true;
	} else {
		return false;
	}
}

function checkForm(){
	if($F('ename').trim()==""){
		alert("请选择所属模型！");
		return false;
	} else {
		return true;
	}
}

function setEntity(url){
   	var esyscode = jQ("#esyscode").val();
   	if(esyscode) url = url + "&esyscoding=" + esyscode ;
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].ename.value = "";
		document.forms[0].esyscoding.value = "";
		return false;
	}
	
	if(null!=temp && temp.split("|").length>1){
		var syscode_eid = temp.split("|")[0];
		var name = temp.split("|")[1];
		var syscode;
		var eid;
		if(syscode_eid.split("_").length>1){
			eid = syscode_eid.split("_")[1];
			syscode = syscode_eid.split("_")[0] +"_"+ syscode_eid.split("_")[2];
		}
		document.forms[0].ename.value = name;
		document.forms[0].esyscoding.value = syscode;
	}		
}
function setDefAssetDomain(){
	var esyscoding = document.forms[0].esyscoding.value;
	var ename = document.forms[0].ename.value;
	if((esyscoding==null || esyscoding=="") && (ename==null || ename=="")){
		var id = '<%=request.getAttribute("defassetsys") %>';
		var name = '<%=request.getAttribute("defassetname") %>';

		if(null!=id && null!=name && "null"!=id && "null"!=name){
			var syscode_eid = id;
			var syscode;
			var eid;
			if(syscode_eid.split("_").length>1){
				eid = syscode_eid.split("_")[0];
				syscode = syscode_eid.split("_")[1];
			}
			document.forms[0].esyscoding.value = syscode;
			document.forms[0].ename.value = name;
		}		
	}
}
function setUseRoleDomain(){
	var url = "IGSYM0101_TREE.do";
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].usesyscoding.value = "";
		document.forms[0].useorgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].usesyscoding.value = temp.split("|")[0];
		document.forms[0].useorgname.value = temp.split("|")[1];
	}		
}
function clearForm(){
	if('close'=='${status}'){
		window.opener.location.href = window.opener.location.href
	 	window.close();
	} 
	if(location.href.search("Disp.do")>-1){
		document.forms[0].eiupdtime_from.value = '';
		document.forms[0].eiupdtime_to.value = '';
		document.forms[0].einame.value = '';
	}
}
function setParentValue(eid, elabel, ename, eiid, eilabel, einame,ecategory,eiversion,esyscoding,id){
    if(!window.opener.closed){
    	var pidid = jQ("#pidid").val();
    	if(pidid=="" || pidid==null){
    		window.opener.setParamDRM2101(eid, elabel, ename, eiid, eilabel, einame ,ecategory,eiversion,esyscoding,id);
    	}else{
            window.opener.setParamDRM2101(eid, elabel, ename, eiid, eilabel, einame , ecategory, pidid,eiversion,esyscoding,id);
	 	}
    }
    window.close();
}
</script>
<body onLoad="clearForm()">
	<div id="maincontent">
		<div id="container">
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div id="content">
					<html:form styleId="form" action="/IGDRM2101_BsInit" onsubmit="return checkSubmit(this);">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1">
								<ig:navigation extname1="${urlable}" /> >> 业务系统选择
							</p>
						</div>
						<div id="search">
							<div class="img"></div>
							<div class="conditions">
								<div>
									<span style="font-size: 15px;"><strong>查询条件</strong></span>
								</div>
								<div class="conditions_border1">
									<div style="margin-top: 4px;">
										<html:hidden property="eiorgsyscoding" />
										<span class="subscribe"><span class="red">*</span>所属模型：</span>
										<html:text property="ename" styleId="ename" errorStyleClass="inputError imeDisabled" size="15" readonly="true" />
										<img src="images/tree.gif" style="cursor: hand;" alt="选择资产管理内容" width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=999&type=0&socVWflag=yes&esyscoding=${IGDRM2101Form.esyscoding}');" />
										<html:hidden property="esyscoding" styleId="esyscoding" />
										&nbsp;&nbsp;<span class="subscribe">名称：</span>
										<html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10"></html:text>
										&nbsp;&nbsp; <span class="subscribe">登记日：</span>
										<html:text property="eiupdtime_from" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
										<img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from'))" border="0" />
										<span>--</span>
										<html:text property="eiupdtime_to" styleId="eiupdtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true" />
										<img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to'))" border="0" />
										&nbsp;&nbsp;
										<html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkForm();" />
									</div>
								</div>
							</div>
						</div>
						<div id="results_list">
							<!--  message -->
							<ig:message />
							<!--  /message -->
							<table width="100%" class="table_style">
								<!-- header部 -->
								<tr>
									<th width="5%">选择</th> 
									<th width="30%">资产名称</th>
									<th width="20%">资产编号</th>
									<th width="15%">所属模型</th>
									<th width="15%">管理人</th>
									<th width="15%">登记日</th>
								</tr>
								<!-- body部 -->
								<logic:present name="IGDRM21011VO" property="entityVWItemList">
									<logic:iterate id="bean" name="IGDRM21011VO" property="entityVWItemList" indexId="index">
										<tr class="<ig:rowcss index="${index}"/>">
											<td>
											  <div class="nowrapDiv">
												  <img src="images/select_asset.gif" style="cursor: pointer;" border="0" alt="<bean:message bundle="comResources" key="img.IGCOM0302.select.alt"/>" onclick="javaScript:setParentValue(
	                                                  '${bean.eid}',
	                                                  '',
	                                                  '',         
	                                                  '${bean.eiid}',
	                                                  '${bean.eilabel}',
	                                                  '${bean.einame}',
	                                                  '',
	                                                  '${bean.eiversion}',
	                                                  '${bean.esyscoding}',
	                                                  '${bean.id}'        
	                                              );"/>
                                         	  </div>
                                            </td>
											<!-- 名称 -->
											<td>
												<div class="nowrapDiv">${bean.einame}</div>
											</td>
											<!-- 序列号 -->
											<td>
												<div class="nowrapDiv">${bean.eilabel}
													<logic:empty name="bean" property="eilabel">&nbsp;</logic:empty>
													${bean.eilabel}
												</div>
											</td>
											<!-- 所属模型 -->
											<td>
												<ig:GetMOdelNameByEiid eiid="${bean.eiid}" id="${bean.id}" /></td>
											<!-- 管理人 -->
											<td>
												<div class="nowrapDiv">
													<logic:empty name="bean" property="eiusername">&nbsp;</logic:empty>
													${bean.eiusername}
												</div>
											</td>
											<!-- 登记日 -->
											<td>
												<div class="nowrapDiv">
													<logic:empty name="bean" property="eiinsdate">&nbsp;</logic:empty>
													${bean.eiinsdate}
												</div>
											</td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
						<div id="operate">
							<!-- paging -->
							<jsp:include page="/include/paging.jsp" />
							<!-- /paging -->
						</div>
						<div class="enter">
							<input id="parent" type="button" name="btn_clear" value="清空" onclick="setParentValue('','','','','')" class="button">
							<input type="button" class="button" value="关闭" onclick="window.close();">
						</div>
						<input type="hidden" name="esyscode" id="esyscode" value="${IGDRM2101Form.esyscode}" />
						<input type="hidden" name="pidid" id="pidid" value="${IGDRM2101Form.pidid}" />
					</html:form>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>
	</div>
</body>
</html:html>