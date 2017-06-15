<%@page import="com.deliverik.infogovernor.common.ProcessDefineTypeValueBean"%>
<%@page import="com.deliverik.infogovernor.prr.vo.IGPRR01021VO"%>
<%@page import="com.deliverik.infogovernor.smr.bl.IGSMRCONSTANT"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@page import="com.deliverik.framework.workflow.WorkFlowConstDefine"%>
<%@page import="java.util.List"%>
<html xmlns:v="urn:schemas-microsoft-com:vml">
<bean:define id="id" value="IGSMR0401" toScope="request" />
<bean:define id="title" value="报表信息" toScope="request" />
<jsp:include page="/include/header1.jsp" />

<link rel="stylesheet" href="<html:rewrite forward='pdimgstyle.css'/>" type="text/css">
<script src="<html:rewrite forward='context.js'/>"  ></script>
<script src="<html:rewrite forward='webflow.js'/>" charset="gb2312"></script>
<script src="<html:rewrite forward='function.js'/>"></script>
<script src="<html:rewrite forward='shiftlang.js'/>" ></script>
<script src="<html:rewrite forward='movestep.js'/>"></script>

<STYLE>
v\:* { Behavior: url(#default#VML) }
</STYLE>
<style>
html{
overflow-x:auto;
overflow-y:auto;
}
</style>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<script type="text/javascript">
var formFileArr = new Array();
var assetFormArr = new Array();
function initAttFormFile(){
	if(formFileArr.length > 0){
		for(var i=0;i<formFileArr.length;i++){
			addSingleFileMuti(formFileArr[i]);
		}
	}
	if(assetFormArr.length > 0){
		for(var k=0;k<assetFormArr.length;k++){
			var params = assetFormArr[k].split("_");
			addSingleEntity(params[0],params[1],params[2],params[3],params[4]);
		}
	}
	   <logic:present name="IGPRR01021VO" property="processStatusDef">
	    <bean:define id="processStatusDef" name="IGPRR01021VO" property="processStatusDef"/>
	    <logic:notEmpty name="processStatusDef" property="jsfunction">
	        ${processStatusDef.jsfunction}();
	    </logic:notEmpty>
	    </logic:present>
	    var temp = '${IGPRR0102Form.psdid}';
	    //在填报节点显示保存按钮
	    if(temp.substr(7,10)=='003'&&jQuery("div[class = 'enter']").find('div').length != 1){
	    	jQuery("#saveform").show();
	    	jQuery("#aAddDiv").show();
	    	jQuery("a[name = 'fileDelButton']").show();
	    }
}
function selectOrgTree(index){
	num = index;
	var temp = window.showModalDialog('IGSYM0101_ROLETREE.do',null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("pivarvalue[" + num + "]").value = '';
		$("pivartreename[" + num + "]").value = '';
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		$("pivarvalue[" + num + "]").value = temp.split("|")[0]+"_OrgTree_"+temp.split("|")[1];
		$("pivartreename[" + num + "]").value = temp.split("|")[1];
	}
	num = 0;
}
function showbutton(){
	<%
		IGPRR01021VO vo = (IGPRR01021VO)request.getSession().getAttribute("IGPRR01021VO");
		String psdname = ProcessDefineTypeValueBean.getConfigInfo(vo.getProcess().getPrid());
		if(psdname.equals(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE)){
			%>
				document.getElementById('save').style.display='none';
			<%
		}
	%>
}
/*
 * 删除附件功能
 *attid 附件的id
 */
function delTableFile(attid){
	if(window.confirm("您确定要删除此附件吗？")){
	 	jQuery.ajax({
			url : "IGSMR0401_DEL.do",
			data : {attid:attid},
			type : "POST",
			async : true,
			dataType:"text",
			success:function(data){
				if(data == "success"){
					jQuery("#"+attid+"delButton").parent().remove();
				}
			}
		});
	}
}
</script>
<body onload="initAttFormFile();">
<script type="text/javascript" src="js/tableform.js?areaflag=Y"></script>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<jsp:include page="/prr/IGPRR0107.jsp"/>	
<jsp:include page="/smr/IGSMR0404.jsp" />
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRR0102.do?instanceID=${instanceID}" styleId="form"
	onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation />&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;报表信息（${IGPRR01021VO.process.prpdname}——<ig:processDefineTypeValue prid="${IGPRR01021VO.process.prid}"/>）
	</p>
	<ig:ProcessBackUrlTag jump="${IGPRR0102Form.jump}"/>
    </div>
	<div id="formwrapper"><ig:message />
	 <jsp:include page="/include/IGSMR00.jsp" />
	 <html:hidden property="prstatus" value="${IGPRR01021VO.status}"/>
	<logic:present name="IGPRR01021VO">
	<logic:equal name="IGPRR01021VO" property="hid" value="1">
	<logic:present name="IGPRR01021VO" property="processInfoDefmap">
		<div>
		<div style="display:none;">
			<html:select property="ppidstr" styleId = "ppidstr"  name="IGPRR0102Form">
				<html:options collection="ADroleList" property="value" name="" labelProperty="label"/>
			</html:select>
		</div>
		<table cellspacing="2" class="table_style_report">
			<tr style="display:none">
				<th width="15%"></th><td width="35%"></td><th width="15%"></th><td width="35%">
				<input type="hidden" id="delFileMutiStr" name="delFileMutiStr" value=""/>
				<input type="hidden" id="addTableColumnFileStr" name="addTableColumnFileStr" value=""/>
				<input type="hidden" id="delTableColumnFileStr" name="delTableColumnFileStr" value=""/>
				</td>
			</tr>
			<jsp:include page="/smr/IGSMR0403.jsp"></jsp:include>
		</table>
		</div>
	</logic:present>
	</logic:equal>
	</logic:present>
	<div>
		<logic:present name="IGPRR01021VO" property="recordLogMap">
			<logic:iterate id="map" name="IGPRR01021VO" property="recordLogMap">
				<logic:iterate id="recordLog" name="map" property="value">
					<logic:present name="recordLog" property="attachmentList">
						<logic:iterate id="attachment" name="recordLog" property="attachmentList">
							<span style="display: block;margin-right: 10px;height: 20px;line-height: 20px;">
							<html:link action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
								<bean:define id="attname" name="attachment" property="attname" />
								<%= attname.toString().substring(attname.toString().indexOf("_")+1) %>
							</html:link>
								<a onclick="delTableFile(${attachment.attid})" id="${attachment.attid}delButton"  style="cursor: pointer;display: none" name="fileDelButton" ><img src="images/delate.gif" alt="删除" align="middle" border="0"/></a>
							</span>
						</logic:iterate>
					</logic:present>
				</logic:iterate>
			</logic:iterate>
		</logic:present>
	</div>
	<div id="aAddDiv" style="display: none;clear: both;"><img src="images/attachment.gif" />
	<a href="javascript:addFile();" id="aAddAttach">添加附件</a>&nbsp;&nbsp;&nbsp;
	<table id="tb">
	</table>
	</div>
	</div>
	<div id="formwrapper">
	<div class="enter">
	<div id="saveform" class="action" style="cursor:pointer;display:none"  onclick="checkForm('<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_NO %>','<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_NO %>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>')">
			<img src="images/gengxin.png" width="16" height="16" />
			<a href="###">保存</a>
	</div>
	<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		<logic:iterate id="bean" name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		  <c:if test="${bean.vbid != '02' && bean.vbid != '05' && bean.vbid != '06' && bean.vbid != '07'}">
			<div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
				<a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" onclick="checkForm('${bean.vbrequired}','${bean.vbrecord}','${bean.vbid}','${bean.vbid}','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>')">${bean.vbname}</a>
			</div>
		  </c:if>
		  <c:if test="${bean.vbid == '02'}">
		  	<div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
				<a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" onclick="affirm('${bean.vbrequired}','${bean.vbrecord}','${bean.vbid}','${bean.vbid}','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>')">${bean.vbname}</a>
			</div>
		  </c:if>
		  <c:if test="${bean.vbid == '05'}">
		    <div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
              <logic:equal name="IGPRR01021VO" property="isMoreRelevantProcess" value="1">
                  <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" 
                onclick="showChooseProcessPage('${IGPRR01021VO.process.prid}','${IGPRR01021VO.process.prtype}','${IGPRR0102Form.pdid}','${IGPRR0102Form.psdid}','${IGPRR01021VO.roleid}','','IGPRR0102_Disp.do?prid=${IGPRR01021VO.process.prid}')">${bean.vbname}</a>
              </logic:equal>
              <logic:notEqual name="IGPRR01021VO" property="isMoreRelevantProcess" value="1">
                  <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" 
                onclick="showInitProcessPage('${IGPRR01021VO.process.prid}','${IGPRR01021VO.relevantPdid}','','IGPRR0102_Disp.do?prid=${IGPRR01021VO.process.prid}')">${bean.vbname}</a>
              </logic:notEqual>
            </div>
		  </c:if>
		  <c:if test="${bean.vbid == '06'}">
		    <div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
              <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="###" 
              onclick="javascript:openSubIGKGM0206Parm('selectDisp=0&prid=${IGSVC0206Form.prid}');">${bean.vbname}</a>
            </div>
		  </c:if>
		  <c:if test="${bean.vbid == '07'}">
		    <div class="action"><img src="images/${bean.vbimage}" width="16" height="16" />
              <a title='${bean.vbdesc}' id ="button${bean.vbid}" href="IGPRR0114_Disp.do?prid=${IGPRR01021VO.process.prid}">${bean.vbname}</a>
            </div>
		  </c:if>
		</logic:iterate>
	</logic:present>
	<jsp:include page="/prr/IGPRR0108.jsp"></jsp:include>

	</div>
	<div class="Placeholder"></div>
	</div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRR0102Form" />
	<html:hidden property="prid" styleId="prid" name="IGPRR0102Form" />
	<html:hidden property="psdid" styleId="psdid" name="IGPRR0102Form" />
	<html:hidden property="action" styleId="action" name="IGPRR0102Form" />
	<html:hidden property="isInit" styleId="isInit" name="IGPRR0102Form" />
	<html:hidden property="pts" styleId="pts" name="IGPRR0102Form" />
	<html:hidden property="log_type" styleId="log_type" name="IGPRR0102Form" />
	<html:hidden property="tempRoleManager" styleId="tempRoleManager" name="IGPRR0102Form" />
	<html:hidden property="people_code" styleId="people_code" name="IGPRR0102Form" />
	<html:hidden property="psdmode_code" styleId="psdmode_code" name="IGPRR0102Form" />
	<html:hidden property="pieids" value=""/>
	<html:hidden property="roleid" styleId="roleid" name="IGPRR0102Form" />
	<html:hidden property="assign_orgsyscoding" styleId="assign_orgsyscoding" name="IGPRR0102Form" />
	<html:hidden property="eiorgcode" styleId="eiorgcode" name="IGPRR0102Form" />
	<html:hidden property="rlcomment" name="IGPRR0102Form" value="" styleId="rlcomment"/>
</html:form></div>
<iframe id="iframe1" name="iframe1" width="0px" height="0px" onload="relevantProcess(${IGPRR01021VO.isMoreRelevantProcess})"></iframe>
</div>
</div>
</div>
<%IGPRR01021VO vo1 = (IGPRR01021VO)request.getSession().getAttribute("IGPRR01021VO");%>
<script src="js/smr/<%=vo1.getProcess().getPrpdid().substring(0,5)%>.js" charset="GBK"></script>
<script>
	function checkStrLen(obj){
		if(!obj.value){
			if(obj.nextSibling.value.strlen()>3000){
				obj.nextSibling.value = "";
				obj.innerHTML = "";
				alert("输入的汉字不能大于"+Math.floor(3000/strByteFlag)+"个汉字！请重新输入。");
			}
		}else{
			if(obj.value.strlen()>3000){
				obj.value = "";
				alert("输入的汉字不能大于"+Math.floor(3000/strByteFlag)+"个汉字！请重新输入。");
			}
		}
	}
</script>

</body>

</html>