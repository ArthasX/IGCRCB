<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.deliverik.infogovernor.prr.bl.IGPRR01BLType"%>
<%@page import="com.deliverik.framework.workflow.WorkFlowConstDefine"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@page import="com.deliverik.infogovernor.common.ProcessDefineTypeValueBean"%>
<%@page import="com.deliverik.infogovernor.prr.vo.IGPRR01021VO"%>
<%
IGPRR01021VO vo = (IGPRR01021VO)request.getSession().getAttribute("IGPRR01021VO");
String psdname = ProcessDefineTypeValueBean.getConfigInfo(vo.getProcess().getPrid());
String tdStartTag = "";
String textSize = "32";
String textAreaSize = "25";
String lastrowwidth = "";
String trStartTag = "";
String trEndTag = "";
int columnNum = 0;
boolean privateIsNull = true;
%>
<script><!--
/*------------------JS校验通用方法开始------------------*/
/*
*功能：校验联系电话
*配置：标题#联系电话
*/
function checkPhoneNumber(obj) {
    var reg1 = /^(0[0-9]{2,3}-)?([2-9][0-9]{6,7})+(-[0-9]{1,4})?$/;
    var reg2 = /^((\+86)|(86))?(1)\d{10}$/;
    if (obj.value.trim() != "") {
        var Valid = reg2.exec(obj.value.trim()) || reg1.exec(obj.value.trim());
        if (!Valid) {
            alert("请输入正确的电话（3-4位区号(必须以0开头)，7-8位直播号（不能以1开头），1-4位分机号，区号、直拨号、分机号之间用‘-’分割）！\n");
            obj.value = "";
            return false;
        }
    }
}

/*
*功能：邮政编码校验
*配置：在需要邮政编码校验的表单上配置该js方法
*/
function checkZipcode(obj) {
    var reg = /^([0-9]{6})$/;
    if (obj.value != "") {
        var Valid = reg.exec(obj.value);
        if (!Valid) {
            alert("请输入正确的邮政编码！\n");
            obj.value = "";
        }
    }
}

/*
 *功能：判断表单内容数值类型为正整数（PDF模板中定义为正整数的表单）
 *配置：在需要正整数验证的表单上配置该JS事件，非法输入时在焦点移开的时候进行提示。
 *说明：1）小键盘输入“-”时提示“不可以输入负数”同时清空内容。
 *          2）小键盘输入“.”时提示“不可以输入小数”同时自动取整。
 *          3）当数字前有无意义的“0”时自动去掉。
 */
function checkNumZero(obj){
	if(obj.value == "-"){
		alert("该表单不可以输入负数");
		obj.value = "";
	}else if(obj.value.indexOf(".") > 0){
		alert("该表单不可以输入小数");
		obj.value = obj.value.substring(0,obj.value.indexOf("."));
	}else if(obj.value.indexOf("0") == 0 && obj.value.length >= 2){
		obj.value = obj.value.substring(1,obj.value.length);
	}
}

/*
*功能：判断表单内容数值类型非负数
*配置：在需要正整数验证的表单上配置该JS事件，非法输入时在焦点移开的时候进行提示。
*说明：1）小键盘输入“-”时提示“不可以输入负数”同时清空内容。
*          2）当数字前有无意义的“0”时自动去掉。
*/
function checkNumNotNegative(obj){
	if(obj.value == "-"){
		alert("该表单不可以输入负数");
		obj.value = "";
	}else if(obj.value.indexOf("0") == 0 && obj.value.indexOf(".") !=1 && obj.value.length >= 2){
		obj.value = obj.value.substring(1,obj.value.length);
	}
}
/*
 *功能：补齐小数限定位数，但是未填写完整的尾部的“0”
 *配置：在checkDate()方法内对需要进行小数末尾处理的表单调用本方法
 *参数：obj 当前处理的数字控件对象
 * 	  bits 小数尾部应有的位数
 */
function checkNumFloat(obj,bits){
	if (obj.rownumber.indexOf("#") > -1) {
		return;
	}else if(obj.value !="" && obj.value.indexOf(".") < 0){
		obj.value = obj.value + "." + getFloatZeros(bits);
	}else if(obj.value !="" && obj.value.indexOf(".") > 0){
		obj.value = obj.value + getFloatZeros(bits - (obj.value.length - obj.value.indexOf(".") - 1));
	}
}
/*
 *功能：获取小数末尾缺位的“0”的个数
 *参数：bits 应添加“0”的位数
 *返回值：zeros 末尾应该添加的n个“0”
 */
function getFloatZeros(bits){
	var zeros = "";
	for(var i = 0; i < bits; i++){
		zeros += "0";
	}
	return zeros;
}

/*
* 功能：常规单选其他类型的表单取消选中
* 参数：常规的单选其他值对象
*/
function clearNormalRadioValue(obj, isDisabled){
	obj.value="";
    var haha=obj.parentElement.childNodes;
    if(haha != null && haha.length > 0){
        for(var i=0;i<haha.length;i++){
            var checks = haha[i].childNodes;
            if(checks != null && checks.length > 0){
                for(var k=0;k<checks.length;k++){
                    if(checks[k].type == "radio"){
                        checks[k].checked=false;
                        checks[k].disabled=isDisabled;
                    }
                }
            }
        }
    }
    //其他内容的清空和隐藏
    var othertext = getNomalShowTarget(obj);
    othertext.value = "";
    othertext.style.display="none";
}

/*
*功能：设置单选按钮为非选中状态
*参数说明：obj 单选按钮对象
*/
function setRadioNotChoosed(obj){
    obj.value="";
    var objs = obj.parentElement.childNodes;
    if(objs != null){
        for(var i=0;i<objs.length;i++){
            var imgs = objs[i].childNodes;
            for(var k=0;k<imgs.length;k++){
                if(imgs[k].name == "radioImg"){
                    imgs[k].src = "images/rb01.gif";
                }
            }
        }
    }
}
/*------------------JS校验通用方法结束------------------*/

/*
*功能：报表PDF预览
*/
function preview(prid,pdid){
    window.open(getAppRootUrl() +"/PreviewPdf.do?prid="+prid+"&pdid="+pdid,
            'newwindow','height=600,width=800,top=0,left=0,toolbar=no,menubar=no,scrollbars=yes, resizable=yes,location=yes, status=no');
}

//审批意见保存
function goIGSMR0201(prid,pidid, obj,tableFlag){
	var rownum = "";
	if("N" != tableFlag){
		rownum = getTableRownum(obj,tableFlag);
	}
	var url="IGSMR0200_Disp.do?url=IGSMR0201_Disp.do&prid=" + prid + "&pidid=" + pidid + "&rownumber=" + rownum;
	var objs = window.showModalDialog(url,null,"dialogWidth:600px;dialogHeight:400px;status:no;help:no;resizable:no;");		
    if(objs != null){ 
    	alert(objs[0]);
        if(objs[1] == "1") {
        	obj.src = "images/deldata.png";
        } else {
        	obj.src = "images/modify.png";
        }
	}
}
//审批意见查看
function goIGSMR0202(prid,pidid,obj,tableFlag){
	var rownum = "";
	if("N" != tableFlag){
		rownum = getTableRownum(obj,tableFlag);
	}
	var url="IGSMR0200_Disp.do?url=IGSMR0202_Disp.do&prid=" + prid + "&pidid=" + pidid + "&rownumber=" + rownum;
	window.showModalDialog(url,null,"dialogWidth:600px;dialogHeight:400px;status:no;help:no;resizable:no;");
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
			}
		}else{
			if(tb.rows.length > 1){
				rownums = tb.rows[1].cells[thisTD.cellIndex].childNodes;
			}
		}
	}else{
		var thisTD = obj.parentElement;
		var tr = thisTD.parentElement;
		if(tr.cells.length > thisTD.cellIndex + 1){
			rownums = tr.cells[thisTB.cellIndex + 1].childNodes;
		}
	}
	if(rownums != null && rownums.length > 0){
		for(var i=0;i<rownums.length;i++){
			if(rownums[i].name == "column_rownumber"){
				rownum = rownums[i].value;
			}
		}
	}
	return rownum
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
//		return $(arr_pidlabelObj[pidlabel] + "_" + obj.rownumber);
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
						}
					}
				}
			}
		}
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
                        }
                    }
                }
            }
        }
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
				if(showvalue!=null){
					showvalue.value = "";
					showvalue.style.display="none";
				}
			}
		}
	}
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
                }
            }
        }
    }
}

//根据表单名获取表格式表单中的子表单表单控件集合
function getTableFormObjs(pidlabel) {
	var arr_objs = new Array();
	var j = 0;
	var inputs = document.getElementsByTagName("INPUT");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].id && inputs[i].id.indexOf(arr_pidlabelObj[pidlabel] + "_") > -1) {
			arr_objs[j++] = inputs[i];
		}
	}
	inputs = document.getElementsByTagName("TEXTAREA");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].id && inputs[i].id.indexOf(arr_pidlabelObj[pidlabel] + "_") > -1) {
			arr_objs[j++] = inputs[i];
		}
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
	var returnObj;
	if (obj.parentElement.childNodes[0].rows != null){
		var temps =  obj.parentElement.childNodes[0].rows[0].cells[0].childNodes;
		for(var i=0;i<temps.length;i++){
			if(temps[i].type == "file"){
				returnObj = temps[i];
				break;
			}
		}
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
    var returnObj;
    for(var i=0;i<temps.length;i++){
        if(temps[i].type == "text"){
            returnObj = temps[i];
            break;
        }
    }
    return returnObj;
}

//取得文本域div
function getEditDiv(obj){
    return obj.parentElement.childNodes[0];
}
function recordLogValue(){
	var temp = window.showModalDialog(getAppRootUrl() + "/IGSMR0807_Disp.do",null,"dialogWidth:520px;dialogHeight:300px;status:no;help:no;resizable:yes");
	if(temp){
		document.getElementById("rlcomment").value = temp;
		return true;
	}else {
		alert("请填写审批意见！");
		return false;
	}
}
//=====组装表单全路径集合结束
--></script>

<%--是否有提交按钮--%>
<bean:define id="hasHandleButton" value="0"/>
<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
	<logic:iterate id="bean" name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		<c:if test="${bean.vbid > '1'}">
			<c:set var="hasHandleButton" value="1"></c:set>
		</c:if>
	</logic:iterate>
</logic:present>

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
				<logic:notEqual value="<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>" name="psid" property="pidaccess">
				<%=trStartTag %>
				<%if("Y".equals(psid.getTitledisplay()) || "T".equals(psid.getTitledisplay())){
					out.print("<td colspan=\"4\">");
					%>
					<c:if test="${hasHandleButton == '1'}">
						<div>
							<ig:ProcessExamineIdeaTag prid ="${IGPRR01021VO.process.prid}" pidid="${psid.pidid}" needidea="${psid.needidea }" psdname="<%=psdname %>"/>
						</div>
					</c:if>
					<%
				}else{%>
				<th>
					<label for="Name">
						<strong>
							<logic:equal value="1" name="psid" property="pidrequired">
								<span class="red">*</span>
							</logic:equal>
							${psid.pidlabel}
						</strong>
						<c:if test="${hasHandleButton == '1'}">
							<ig:ProcessExamineIdeaTag prid ="${IGPRR01021VO.process.prid}" pidid="${psid.pidid}" needidea="${psid.needidea }" psdname="<%=psdname %>"/>
						</c:if>
					</label>
				</th>
				<%
				out.print(tdStartTag);
				} %>
				</logic:notEqual>
					<ig:formToTag 
						name="IGPRR0102Form" 
						prid="${IGPRR01021VO.process.prid }"
						psdname="<%=psdname %>"
						pidid="${pidid }" 
						property="pivarvalue[${index}]" 
						formType="${psid.pidtype }" 
						pidaccess="${psid.pidaccess }"
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
						showrownum="${psid.showrownum }"
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