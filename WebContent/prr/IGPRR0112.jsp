<%@page import="com.deliverik.infogovernor.prr.vo.IGPRR01021VO"%>
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
<%
	IGPRR01021VO vo = (IGPRR01021VO)request.getSession().getAttribute("IGPRR01021VO");
	String lastrowwidth = "";
	String trStartTag = "";
	String trEndTag = "";
	String tdStartTag = "";
	String textSize = "32";
	String textAreaSize = "25";
	int columnNum = 0;
	boolean privateIsNull = true;
%>
<html>
<bean:define id="id" value="IGPRR0112" toScope="request" />
<bean:define id="title" value="流程信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<logic:present name="IGPRR01021VO" property="process">
<script src="js/prr/<%= (vo != null &&  vo.getProcess() != null && StringUtils.isNotEmpty(vo.getProcess().getPrpdid()) )? vo.getProcess().getPrpdid().substring(0,5) : "" %>.js" charset="GBK"></script>
</logic:present>
<style>
.a1:link{
   color:#bb0500;
   text-decoration:none;
}
.a1:visited{
   color:#bb0500;
   text-decoration: none;
}
.a1:hover{
   color:#bb0500;
   text-decoration:underline;
}
.a1:active{
   color:#bb0500;
   text-decoration: none;
}
</style>
<script type="text/javascript">
	var gid = 'IGPRR0112';

	function ShowpProcessFlow(prid, pdid) {
		window
				.showModalDialog(getAppRootUrl() + '/IGPRR0111_Disp.do?prid='
						+ prid, null,
						"dialogWidth:1000px;dialogHeight:600px;status:no;help:no;resizable:yes");
	}
	function selStation(locationid){
        var Obj = document.getElementById("blockCity");
			tt = document.createElement('div');
			tt.setAttribute('id',"blockCity");
        tt.innerHTML = "";
           if (locationid!=null && locationid!="")
           {
                    tt.innerHTML += locationid+"<br />";
                    tt.style.left = event.x;
                   tt.style.top = event.y + document.documentElement.scrollTop - 40;
                   tt.style.display = "block";
           }    
       
   }
	function chide(){
    }
	
	function openProcessInfoLog(prid){
		openSubWindow("/IGPRR0123.do?prid="+prid,"_blank",1100,600);
	}
	var arr_pididObj = new Array();
	var arr_pidlabelObj = new Array();
	//定义表单全路径实体对象
	function pidObj(pidid, pidlabel, pididPar) {
		this.pidid = pidid;
		this.pidlabel = pidlabel;
		this.pidlabelFull = null;
		if(pididPar) {
			this.pididPar = pididPar;
		} else {
			this.pididPar = null;
		}
	}
	//通用表单
	<logic:present name="IGPRR01021VO" property="processInfoDefmap">
	<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
	<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
	<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
	<bean:define id="processLinkageDefList" name="psid" property="processLinkageDefList" type="java.util.List" />
	<logic:present name="psid">
		arr_pididObj['${pidid}'] = new pidObj('${psid.pidid}', '${psid.pidlabel}');
	</logic:present>
	</logic:iterate>
	</logic:present>
	//递归拼接表单名全路径
	function getFullPidlabel(pidid) {
		var obj = arr_pididObj[pidid];
		if(!obj) return "";
		if(obj.pididPar) {
			return getFullPidlabel(obj.pididPar) + "#" + obj.pidlabel;
		} else{
			return obj.pidlabel;
		}
	}
	//将表单全路径赋予实体
	for(var obj in arr_pididObj) {
		if(arr_pididObj[obj] instanceof pidObj) {
			arr_pididObj[obj].pidlabelFull = getFullPidlabel(obj);
		}
	}
	//填充表单全路径集合
	for(var obj in arr_pididObj) {
		if(arr_pididObj[obj] instanceof pidObj) {
			arr_pidlabelObj[arr_pididObj[obj].pidlabelFull] = obj;
		}
	}
	//根据表单名获取通用表单控件
	function getFormObj(pidlabel) {
		return $("pidid" + arr_pidlabelObj[pidlabel]);
	}
	//取得表格行号
	function getTableRownum(obj,tableFlag){
		var rownum = "";
		var rownums = null;
		if("1" == tableFlag){
			var thisTD = obj.parentElement;
			var tb = obj.parentElement.parentElement.parentElement;
			if(tb.rows[0].name == "titlerow"){
				if(tb.rows.length > 2){
					rownums = tb.rows[2].cells[thisTD.cellIndex].childNodes;
				};
			}else{
				if(tb.rows.length > 1){
					rownums = tb.rows[1].cells[thisTD.cellIndex].childNodes;
				};
			};
		}else{
			var thisTD = obj.parentElement;
			var tr = thisTD.parentElement;
			if(tr.cells.length > thisTD.cellIndex + 1){
				rownums = tr.cells[thisTB.cellIndex + 1].childNodes;
			};
		}
		if(rownums != null && rownums.length > 0){
			for(var i=0;i<rownums.length;i++){
				if(rownums[i].name == "column_rownumber"){
					rownum = rownums[i].value;
				};
			};
		}
		return rownum;
	}

	//=====组装表单全路径集合开始
	var arr_pididObj = new Array();
	var arr_pidlabelObj = new Array();
	//定义表单全路径实体对象
	function pidObj(pidid, pidlabel, pididPar) {
		this.pidid = pidid;
		this.pidlabel = pidlabel;
		this.pidlabelFull = null;
		if(pididPar) {
			this.pididPar = pididPar;
		} else {
			this.pididPar = null;
		}
	}
	//递归拼接表单名全路径
	function getFullPidlabel(pidid) {
		var obj = arr_pididObj[pidid];
		if(!obj) return "";
		if(obj.pididPar) {
			return getFullPidlabel(obj.pididPar) + "#" + obj.pidlabel;
		} else{
			return obj.pidlabel;
		}
	}
	//表格式表单的子表单
	<logic:present name="AD_columnInfoMap">
	<logic:iterate id="map" name="AD_columnInfoMap" indexId="index" >
	<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
	<bean:define id="lst_psid" name="map" property="value" type="java.util.List" />
	<logic:iterate id="psid" name="lst_psid" indexId="index" >
	if("rawdef" == "${pidid}"){
		arr_pididObj['${psid.pidid}']= new pidObj('${psid.pidid}', '${psid.pidlabel}');
	}else{
		arr_pididObj['${psid.pidid}']= new pidObj('${psid.pidid}', '${psid.pidlabel}', '${pidid}');
	}
	</logic:iterate>
	</logic:iterate>
	</logic:present>
	//将表单全路径赋予实体
	for(var obj in arr_pididObj) {
		if(arr_pididObj[obj] instanceof pidObj) {
			arr_pididObj[obj].pidlabelFull = getFullPidlabel(obj);
		}
	}
	//填充表单全路径集合
	for(var obj in arr_pididObj) {
		if(arr_pididObj[obj] instanceof pidObj) {
			arr_pidlabelObj[arr_pididObj[obj].pidlabelFull] = obj;

		}
	}
	//根据表单名获取通用表单控件
	function getFormObj(pidlabel) {
		return $("pidid" + arr_pidlabelObj[pidlabel]);
	}
	//根据表单名获取表格式表单中的子表单表单控件
	function getTableFormObj(pidlabel, rownumber) {
//			return $(arr_pidlabelObj[pidlabel] + "_" + obj.rownumber);
			return $(arr_pidlabelObj[pidlabel] + "_" + rownumber);
	}
	//根据表单名获取表格式表单中的check子表单的所有选项对象
	function getTableFormCheckBox(pidlabel, rownumber){
		var obj = getTableFormObj(pidlabel, rownumber);
		var arr = new Array();
		if(obj != null){
			var spans = obj.parentElement.childNodes;
			if(spans != null && spans.length > 0){
				for(var i=0;i<spans.length;i++){
					var checks = spans[i].childNodes;
					if(checks != null && checks.length > 0){
						for(var k=0;k<checks.length;k++){
							if(checks[k].type == "checkbox"){
								arr[arr.length] = checks[k];
							};
						};
					};
				};
			};
		}
		return arr;
	}

	//根据表单名获取常规表单中的选项对象
	function getFormCheckBox(pidlabel){
	    var obj = getFormObj(pidlabel);
	    var arr = new Array();
	    if(obj != null){
	        var spans = obj.parentElement.childNodes;
	        if(spans != null && spans.length > 0){
	            for(var i=0;i<spans.length;i++){
	                var checks = spans[i].childNodes;
	                if(checks != null && checks.length > 0){
	                    for(var k=0;k<checks.length;k++){
	                        if(checks[k].type == "checkbox"){
	                            arr[arr.length] = checks[k];
	                        };
	                    };
	                };
	            };
	        };
	    }
	    return arr;
	}

	//将表格式表单的复选框变为只读或可写
	function disableTableCheckBox(objs,flag){
		if(objs != null && objs.length > 0){
			for(var i=0;i<objs.length;i++){
				objs[i].disabled = flag;
				if(flag){
					objs[i].checked = false;
					getTarget(objs[i].parentElement).value = "";
					//清空“其他”并设置为只读
					var showvalue = getShowTarget(objs[i].parentElement);
					showvalue.value = "";
					showvalue.style.display="none";
				};
			};
		};
	}

	//将常规表单的复选框变为只读或可写
	function disableCheckBox(objs,flag){
	    if(objs != null && objs.length > 0){
	        for(var i=0;i<objs.length;i++){
	            objs[i].disabled = flag;
	            if(flag){
	                objs[i].checked = false;
	                //清空“其他”并设置为只读
	                var showvalue = getNomalShowTarget(objs[i]);
	                if (showvalue !=null){
		                showvalue.value = "";
		                showvalue.style.display="none";
	                };
	            };
	        };
	    };
	}

	//根据表单名获取表格式表单中的子表单表单控件集合
	function getTableFormObjs(pidlabel) {
		var arr_objs = new Array();
		var j = 0;
		var inputs = document.getElementsByTagName("INPUT");
		for(var i=0; i<inputs.length; i++) {
			if(inputs[i].id && inputs[i].id.indexOf(arr_pidlabelObj[pidlabel] + "_") > -1) {
				arr_objs[j++] = inputs[i];
			};
		}
		inputs = document.getElementsByTagName("TEXTAREA");
		for(var i=0; i<inputs.length; i++) {
			if(inputs[i].id && inputs[i].id.indexOf(arr_pidlabelObj[pidlabel] + "_") > -1) {
				arr_objs[j++] = inputs[i];
			};
		}
		return arr_objs;
	}

	//根据表单名获取单附件
	function getSingalFileObj(pidlabel, rownumber) {
		var obj;
		if(rownumber) {
			obj = getTableFormObj(pidlabel, rownumber);
		} else {
			obj = getFormObj(pidlabel);
		}
		//return obj.parentElement.childNodes[0].childNodes[0].childNodes[0].childNodes[0].childNodes[1];
		var temps =  obj.parentElement.childNodes[0].rows[0].cells[0].childNodes;
		var returnObj = null;
		for(var i=0;i<temps.length;i++){
			if(temps[i].type == "file"){
				returnObj = temps[i];
				break;
			};
		}
		return returnObj;
	}

	//取得附件类型表单的文本框对象
	function getSingalFileTextObj(pidlabel, rownumber) {
		var obj;
	    if(rownumber) {
	        obj = getTableFormObj(pidlabel, rownumber);
	    } else {
	        obj = getFormObj(pidlabel);
	    }
	    var temps =  obj.parentElement.childNodes[0].rows[0].cells[0].childNodes;
	    var returnObj = null;
	    for(var i=0;i<temps.length;i++){
	        if(temps[i].type == "text"){
	            returnObj = temps[i];
	            break;
	        };
	    }
	    return returnObj;
	}

	//取得文本域div
	function getEditDiv(obj){
	    return obj.parentElement.childNodes[0];
	}
	
	function init(){
		<logic:present name="IGPRR01021VO" property="processStatusDef">
		<bean:define id="processStatusDef" name="IGPRR01021VO" property="processStatusDef"/>
		<logic:notEmpty name="processStatusDef" property="jsfunction">
			${processStatusDef.jsfunction}();
		</logic:notEmpty>
		</logic:present>
	}

</script>
<STYLE>
v\:* {
	Behavior: url(#default#VML)
}
</STYLE>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body onload="init();">
	<div id="maincontent">
		<div id="container">
			<html:form action="/IGPRR0112_Disp" styleId="form"
				onsubmit="return checkSubmit(this);">

				<div id="location" style="margin-top: 10px">
					<div class="image"></div>
					<p class="fonts1">工作信息</p>
				</div>
				<div id="formwrapper">
					<ig:message />
					<jsp:include page="/prr/IGPRR0136.jsp" />
					<logic:present name="IGPRR01021VO">
						<logic:equal name="IGPRR01021VO" property="hid" value="1">
							<logic:present name="IGPRR01021VO" property="processInfoDefmap">
								<div class="record_list">
									<table cellspacing="2" class="table_style1">
										<tr>
											<td width="15%"></td>
											<td width="35%"></td>
											<td width="15%"></td>
											<td width="35%"></td>
										</tr>
													<bean:define id="useridprr" name="IGPRR01021VO" property="userid" type="java.lang.String" />
													<bean:define id="roleidprr" name="IGPRR01021VO" property="roleid" type="java.lang.Integer" />
													<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
														<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
														<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
														<bean:define id="processLinkageDefList" name="psid" property="processLinkageDefList" type="java.util.List" />
														<logic:present name="psid">
														<% 
														if("2".equalsIgnoreCase(psid.getPidaccess()) || "3".equalsIgnoreCase(psid.getPidaccess()) || "4".equalsIgnoreCase(psid.getPidaccess())){
															String rowwidth = StringUtils.isEmpty(psid.getRowwidth())?"0":psid.getRowwidth().trim();
															rowwidth = StringUtils.isEmpty(rowwidth)?"0":rowwidth;
															tdStartTag = "<td>";
															textSize = "32";
															textAreaSize = "25";
															if(StringUtils.isEmpty(lastrowwidth)){
																trStartTag = "<tr>";
																if("0".equals(rowwidth)){
																	tdStartTag = "<td colspan=\"3\">";
																}
															}
															if("0".equalsIgnoreCase(lastrowwidth)){
																trStartTag = "</tr><tr>";
																if("0".equals(rowwidth)){
																	tdStartTag = "<td colspan=\"3\">";
																}
															}
															if("1".equalsIgnoreCase(lastrowwidth)){
																if("0".equals(rowwidth)){
																	if(columnNum == 0){
																		trStartTag = "</tr><tr>";
																	}else{
																		trStartTag = "<td></td><td></td></tr><tr>";
																	}
																	tdStartTag = "<td colspan=\"3\">";
																}else{
																	if(columnNum == 0){
																		trStartTag = "</tr><tr>";
																	}else{
																		trStartTag = "";
																	}
																}
															}
															if("0".equalsIgnoreCase(rowwidth)){
																columnNum = 0;
															}else{
																columnNum = (columnNum+1)%2;
															}
															lastrowwidth = rowwidth;
															if("0".equals(rowwidth)){
																textSize = "82";
																textAreaSize = "60";
															}
														}
														%>
														<bean:define id="pidaccess" value="1"/>
														<logic:notEqual value="<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>" name="psid" property="pidaccess">
														<bean:define id="pidaccess" value="2"/>
														<%=trStartTag %>
														<th>
															<label for="Name" onmouseover="selStation('${psid.pidlabel}');" onmouseout="chide();" >
																<strong>${psid.pidlabel}：</strong>
															</label>
														</th>
														<%=tdStartTag %>
														</logic:notEqual>
															<ig:formToTag 
																name="IGPRR0102Form" 
																pidid="${pidid }" 
																property="pivarvalue[${index}]" 
																formType="${psid.pidtype }" 
																pidaccess="${pidaccess }"
																pidmode="${psid.pidmode }"
																size="<%= textSize%>"	
																userid="${IGPRR01021VO.userid }"
																roleid="${IGPRR01021VO.roleid }"
																orgid="${IGPRR01021VO.roleid }"
																options="${psid.pidoption }"	
																privatescope="${psid.privatescope}"
																piddefault="${psid.piddefault }"
																pdid="${psid.pdid }"
																ccid="${psid.ccid }"
																pidlabel="${psid.pidlabel }"
																piid="${psid.piid }"
																pidrequired="${psid.pidrequired }"
																textAreaSize="<%=textAreaSize %>"
																hasattach="${psid.hasattach }"
																piddisplay="${psid.piddisplay }"
																pidwidth="${psid.pidwidth }"
																pidrows="${psid.pidrows }"
																piduse="${psid.piduse }"
																showline="${psid.showline }"
																value="${psid.pidvalue}"
																pidunit="${psid.pidunit}"
																remarks="${psid.remarks}"
																pidcomment="${psid.pidcomment}"
																titledisplay="${psid.titledisplay }"
																pidhide="${psid.pidhide }"
																jsfunction="${psid.jsfunction }"
																selecedlast="${psid.selecedlast }"
																numbertype="${psid.numbertype }"
																align="${psid.align }"
																showstyles="${psid.showstyles}"/>
															<html:hidden property="pivarname" value="${psid.pidname}" /> 
															<html:hidden property="pivarlabel" value="${psid.pidlabel}" /> 
															<html:hidden property="pivartype" value="${psid.pidtype}" /> 
															<html:hidden property="pidid" value="${psid.pidid}" />
															<html:hidden property="pidaccess" value="${psid.pidaccess}" />
															<html:hidden property="piid" value="${psid.piid}" />
															<html:hidden property="pidmode" value="${psid.pidmode}" />
															<html:hidden property="privatescope" value="${psid.privatescope}" />
															</td>
														</logic:present>
													</logic:iterate>
													<% 
													if(StringUtils.isEmpty(lastrowwidth)){
													}
													if("0".equalsIgnoreCase(lastrowwidth)){
														trEndTag = "</tr>";
													}
													if("1".equalsIgnoreCase(lastrowwidth)){
														if(columnNum == 0){
															trEndTag = "</tr>";
														}else{
															trEndTag = "<td></td><td></td></tr>";
														}
													}
													%>
													<%=trEndTag%>
									</table>
								</div>
							</logic:present>
						</logic:equal>
					</logic:present>
					<logic:present name="IGPRR01021VO" property="voList">
					<div style="margin-top: 10px; margin-right: 26px; float: right">
						<table>
							<tr>
								<td><a
									href="javascript:ShowpProcessFlow('${IGPRR01021VO.process.prid}');" class="a1">查看流程图</a>
								</td>
							</tr>
						</table>
					</div>
					</logic:present>
					<jsp:include page="/prr/IGPRR01021.jsp"></jsp:include>
					<div class="Placeholder"></div>

					<div class="enter">
						<input type="button" class="button" value="关闭"
							onclick="window.close();">
					</div>
				</div>
			</html:form>
		</div>
	</div>

</body>
</html>

