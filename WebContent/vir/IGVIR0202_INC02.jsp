﻿﻿<%@page import="org.apache.commons.lang.StringUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@page import="com.deliverik.infogovernor.prr.vo.IGPRR01021VO"%>
<%
IGPRR01021VO vo = (IGPRR01021VO)request.getSession().getAttribute("IGPRR01021VO");
%>
<script src="js/prr/<%= (vo != null &&  vo.getProcess() != null && StringUtils.isNotEmpty(vo.getProcess().getPrpdid()) )? vo.getProcess().getPrpdid().substring(0,5) : "" %>.js" charset="GBK"></script>
<script type="text/javascript">
var tableValueArray = new Array();
var columnNameInfo = null;
var processObj = null;
var cpidid = null;
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

function loadFromXML(){
	var xmlStr=document.all.FlowXML.value;
	  if(xmlStr!=null&&xmlStr!=''&&xmlStr!='null'){
	  var xmlDoc = new ActiveXObject('MSXML2.DOMDocument');
		 xmlDoc.async = false;
		 xmlDoc.loadXML(xmlStr);
		 var xmlRoot = xmlDoc.documentElement; 
		 document.all.FlowXML.value = xmlRoot.xml;
	 }
}
var gid='IGPRR0102';
var num = 0;
var pdid;
function selectRole(){
	var roleid = document.getElementById("ppidstr").value;
	var pdid = document.getElementById("pdid").value;
	var prid = document.getElementById("prid").value;
	document.location.replace(getAppRootUrl() + "/IGPRR0102_Disp.do?&pdid="+pdid+"&roleid="+roleid.split("_")[1]+"&prid="+prid + "&ppidstr=" + roleid);
}
function changePrRolename(){
	var obj = IGPRR0102Form.ppidstr;
	IGPRR0102Form.prrolename.value = obj.options[obj.selectedIndex].text;
}
function selectEntityItem(index){
    num = index;
    openSubIGCOM0302();
}

function selectProject(index){
	num = index;
	openSubWindow('/IGFIN0108_Disp.do', '_blank','1000','600');
}
function openSVCPage(obj,index){
	processObj = obj.parentElement.childNodes[0];
	num = index;
	openSubWindow('/IGSVC0107_Disp.do', '_blank','1000','600');
}

function setParams(prcorid,prcortype,prcortitle){
	var id = processObj.parentElement.parentElement.id;
	var value="";
	var rvalue = $("pivarvalue[" + num + "]").value;
	var str1 = "";
	var str2 = "",str3 = "";
	var infos = rvalue.split("_processValue_");
	if(infos != null && infos.length > 0){
		str1 = infos[0];
		if(infos.length > 1){
			str2 = infos[1];
		}
		if(infos.length > 2){
			str3 = infos[2];
		}
	}
	if(prcorid == ""){
		processObj.value = "";
	} else {
		value = id + "_id_" + prcorid + "_svc_" + prcortype + "_name=" + prcortitle;
        processObj.value = prcortitle;
	}
	if(str2 != ""){
		var tempstr = "";
		var adds = str2.split("#");
		if(adds != null){
			var flag = true;
			for(var i=0;i<adds.length;i++){
				if(adds[i].split("_id_")[0] == id){
					if(value != ""){
						tempstr += "#" + value;
					}
					flag = false;
				}else{
					tempstr += "#" + adds[i];
				}
			}
			if(flag){
				tempstr += "#" + value;
			}
		}
		if(tempstr != ""){
			str2 = tempstr.substring(1);
		}else{
			str2 = "";
		}
		
	}else{
		if(value != ""){
			str2 = value;
		}
	}
	var cvalue = str1;
	if(str2 != ""){
		cvalue += "_processValue_" + str2;
	}
	if(str3 != ""){
		cvalue += "_processValue_" + str3;
	}
	$("pivarvalue[" + num + "]").value = cvalue;
	num = 0;
}
function setPrjParams(pid,pcode,pname){
	if("" == pid){
		$("pivarvalue[" + num + "]").value = "";
		$("pivarprjname[" + num + "]").value = "";
	} else {
		$("pivarvalue[" + num + "]").value = pid + "_prj_" + pname;
		$("pivarprjname[" + num + "]").value = pname;
	}
	num = 0;
}
function selectRoleOnIGSYM0306(index,pdid){
    num = index;
    openSubIGSYM0306(pdid);
}
function setRoleParams(roleid,rolename) {
	if("" == roleid){
		$("pivarvalue[" + num + "]").value = "";
		$("pivarrolename[" + num + "]").value = "";
	} else {
		$("pivarvalue[" + num + "]").value = roleid + "_role_" + rolename;
		$("pivarrolename[" + num + "]").value = rolename;
	}
	num = 0;
}
function setRadio(index,obj){
	$("pivarvalue[" + index + "]").value = obj.value;
}

function setRadio_other(index,obj,obj2){
	$("pivarvalue[" + index + "]").value = obj.value;
	if(obj2 == 'other'){
		$("pivarvalue_Other[" + index + "]").value = "";
		$("pivarvalue_Other[" + index + "]").style.display = "";
	}else{
		$("pivarvalue_Other[" + index + "]").style.display = "none";
	}
}
function setOnChage_other(index,obj){
	$("pivarvalue[" + index + "]").value = "cv_cev_" + obj.value;
}

function setCheckbox(index,obj){
	var checkboxvalue = $("pivarvalue[" + index + "]").value;
	if(obj.checked){
		if(checkboxvalue == ""){
			checkboxvalue = obj.value;
		}else{
			checkboxvalue = checkboxvalue+"#"+obj.value;
		}
	}else{
		var afterDelValue = "";
		var str = checkboxvalue.split("#");
		for(var i=0; i<str.length;i++){
			if(str[i] != obj.value){
				if(i == 0){
					afterDelValue = str[i];
				}else{
					afterDelValue += "#"+str[i];
				}
			}
		}
		checkboxvalue = afterDelValue;
	}
	$("pivarvalue[" + index + "]").value = checkboxvalue;
}

function resetForm(){
	IGPRR0102Form.reset();
}
function checkLinkage(blname,initiativepidid,passivitypidid){
	var passivityobj = document.getElementById(passivitypidid);
	var initiativeobj = document.getElementById(initiativepidid);
	var passivityValue ;
	var initiativeValue ;
	if(initiativeobj != null){
		initiativeValue = initiativeobj.value;
	}
	if(passivityobj != null){
		passivityValue = passivityobj.value;
	}
var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
	parameters: 'type=checkLinkage&blname='+blname+'&initiativeValue='+initiativeValue+'&passivityValue='+passivityValue,
	 onSuccess:  function(req, json){
	 var result=req.responseText;
		if(result != null && result != ""){
			alert(result);
			return false;
		}else{
			return true;	
		}	
    }
	});
}
function checkCurrentProcessUser() {
	if(!$("ppidstr")) {
		return true;
	}
	var userid = '${IGPRR01021VO.userid}';
	var ppid_str = $F("ppidstr");
	var index1 = ppid_str.indexOf("_");
	var index2 = ppid_str.indexOf("_", index1+2);
	if($("ppidstr") && userid == ppid_str.substring(index2+1)) {
		return true;
	}
	return false;
}
function getCurrentProcessUser() {
	var obj = IGPRR0102Form.ppidstr;
	if(obj.type == "hidden") {
		return obj.previousSibling.data;
	}
	return obj.options[obj.selectedIndex].text;
}
function checkForm(vbrequired,vbrecord,btnid,action,type,code,showConfirm){
	packagingTableValue();
	var isInit = IGPRR0102Form.isInit.value;
	var go="1";
	if(vbrecord=="<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_YES%>"){
		if($('rlcomment')&&$F('rlcomment').trim() == ""){
			alert("处理记录不能为空！");
			go="0";
		}
	}
	if(IGPRR0102Form.rlcomment){
		if($F('rlcomment').strlen()>3000){
			alert("处理记录不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
			go="0";
		}
	if(IGPRR0102Form.pdid.value=="0101001" && action=="<%=IGPRDCONSTANTS.BUTTON_BUTTON2%>"){
			if($F('rlcomment').trim() == ""){
				alert("处理记录不能为空！");
				go="0";
			}
  		}
	}
	if (go=="1") {
		if(action!="<%=IGPRDCONSTANTS.BUTTON_TERMINATE%>"){
			if(code != "3") {
				<logic:present name="IGPRR01021VO" property="processInfoDefmap">
					<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
						<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
						<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
						<logic:present name="psid">
							<logic:equal name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
							<logic:equal value="8" name="psid" property="pidtype">
							var rq = '${psid.pidrequired}';
							if(vbrequired=="<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_NO%>"){
							    rq = '0';
							}
							  var tableCheck = checkTableForm('${psid.pidid}','${psid.pidname}',rq);
							  if(!tableCheck){
								  go = "0";
								  return false;
							  }
							</logic:equal>
							<logic:notEqual value="8" name="psid" property="pidtype">
								if(action!="<%=IGPRDCONSTANTS.BUTTON_UPDATE%>"){
									if(vbrequired=="<%=IGPRDCONSTANTS.BUTTON_CHECKREQUIRED_YES%>"){
										<logic:equal value="1" name="psid" property="pidrequired">
										<logic:equal value="P" name="psid" property="pidtype">
											var tb = document.getElementById("people_${psid.pidid}");
											if(tb.rows.length < 2){
												alert("请选择人员！");
												go = "0";
												return false;
											}
										</logic:equal>
										<logic:notEqual value="P" name="psid" property="pidtype">
										if(!showConfirm && $F('pivarvalue[${index}]').trim() == ""){
											alert("请输入${psid.pidlabel}！");
											go="0";
											return false;
										}
										</logic:notEqual>
										</logic:equal>
									}
								}
								<logic:equal value="7" name="psid" property="pidtype">
									if(checkFloatNum($F('pivarvalue[${index}]'))){
							    		alert("${psid.pidlabel}为数字,整数位最多13位,小数位最多2位!");
										go="0";
										return false;
									}
								</logic:equal>
								if($F('pivarvalue[${index}]').strlen()>3000){
									alert("${psid.pidlabel}不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
									go="0";
									return false;
								}
								</logic:notEqual>
							</logic:equal>
						</logic:present>
					</logic:iterate>
				</logic:present>
	
				var input11 = document.getElementsByTagName('input');  
				  for (var i = 0; i < input11.length; i++) {   
				      var type11 = input11[i].type;  //取Type
				      var value11 = input11[i].value;
				      if(type11=='file'){
					      if(value11.indexOf(".exe")!=-1){
						      alert("请选择有效的附件文件！");
						      go="0";
					      }
				      }
				 }
			}
		}else{//中止流程
			if( window.confirm("您是否确认中止流程？")){
				//移除表格类表单要添加列模板table wangtingzhi  
				deleteTemplate();
				$("action").value = action;
				IGPRR0102Form.submit();
			}
			go="0";
		}
	}
	<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
	<logic:iterate id="bean" name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
	if('${bean.vbid}'==btnid){
		<logic:notEmpty name="bean" property="vbacturl">
			if(!${bean.vbacturl}('${IGPRR0102Form.prid}','${IGPRR0102Form.pdid}')) {
				go="0";
			};
		</logic:notEmpty>
	}
	</logic:iterate>
	</logic:present>
	
	
	// 校验申请虚机信息
	var checkRes = checkVMInfo();
	if(!checkRes){
		go = "0";
	}
	
	if(go=="1"){
		if(code == "3"){
			//移除表格类表单要添加列模板table wangtingzhi  
			deleteTemplate();
			IGPRR0102Form.log_type.value = type;
			$("action").value = action;
			IGPRR0102Form.submit();
		}else{
			if(showConfirm){
				//移除表格类表单要添加列模板table wangtingzhi  
				deleteTemplate();
				IGPRR0102Form.log_type.value = type;
				$("action").value = action;
				IGPRR0102Form.submit();
			} else {
				if(checkCurrentProcessUser()) {
					if(!window.confirm("您是否确认提交？")) {
						return false;
					}
				} else {
					if(action >= "1") {
						if(!window.confirm("您是否确认代替" + getCurrentProcessUser() +"处理？")) {
							return false;
						}
					} else {
						if(!window.confirm("您是否确认提交？")) {
							return false;
						}
					}
				}
				//移除表格类表单要添加列模板table wangtingzhi  
				deleteTemplate();
				
				// 保存虚拟信息
				saveVM();
				
				IGPRR0102Form.log_type.value = type;
				$("action").value = action;
				IGPRR0102Form.submit();
				return false;
			}
		}
	} else if(go=="0") {
		 return false;
	}
	
}

function affirm(vbrequired,vbrecord,btnid,action,type,code){
	packagingTableValue();
	var isInit = IGPRR0102Form.isInit.value;
	var go="1";
	if(vbrecord=="<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_YES%>"){
		if($F('rlcomment').trim() == ""){
			alert("处理记录不能为空！");
			go="0";
		}
	}
	if(IGPRR0102Form.rlcomment){
		if($F('rlcomment').strlen()>3000){
			alert("处理记录不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
			go="0";
		}

	}
	if (go=="1") {
		if(action!="<%=IGPRDCONSTANTS.BUTTON_TERMINATE%>"){
			if(code != "3") {
				<logic:present name="IGPRR01021VO" property="processInfoDefmap">
					<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
						<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
						<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
						<logic:present name="psid">
							<logic:equal name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
							<logic:notEqual value="8" name="psid" property="pidtype">
								<logic:equal value="7" name="psid" property="pidtype">
									if(checkFloatNum($F('pivarvalue[${index}]'))){
							    		alert("${psid.pidlabel}为数字,整数位最多13位,小数位最多2位!");
										go="0";
										return;
									}
								</logic:equal>
								if($F('pivarvalue[${index}]').strlen()>3000){
									alert("${psid.pidlabel}不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
									go="0";
									return;
								}
								</logic:notEqual>
							</logic:equal>
						</logic:present>
					</logic:iterate>
				</logic:present>
	
				var input11 = document.getElementsByTagName('input');  
				  for (var i = 0; i < input11.length; i++) {   
				      var type11 = input11[i].type;  //取Type
				      var value11 = input11[i].value;
				      if(type11=='file'){
					      if(value11.indexOf(".exe")!=-1){
						      alert("请选择有效的附件文件！");
						      go="0";
					      }
				      }
				 }
			}
		}else{//中上流程
			if( window.confirm("您是否确认中止流程？")){
				//移除表格类表单要添加列模板table wangtingzhi  
				deleteTemplate();
				$("action").value = action;
				IGPRR0102Form.submit();
			}
			go="0";
		}
	}
	<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
	<logic:iterate id="bean" name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
	if('${bean.vbid}'==btnid){
		<logic:notEmpty name="bean" property="vbacturl">
			if(!${bean.vbacturl}('${IGPRR0102Form.prid}','${IGPRR0102Form.pdid}')) {
				go="0";
			};
		</logic:notEmpty>
	}
	</logic:iterate>
	</logic:present>
	
	// 校验申请虚机信息
	var checkRes = checkVMInfo();
	if(!checkRes){
		go = "0";
	}
	
	if(go=="1"){
		if(code == "3"){
			//移除表格类表单要添加列模板table wangtingzhi  
			deleteTemplate();
			IGPRR0102Form.log_type.value = type;
			$("action").value = action;
			IGPRR0102Form.submit();
		}else{
			if( window.confirm("您是否确认提交？")){
				
				// 保存虚拟信息
				saveVM();
				
				//移除表格类表单要添加列模板table wangtingzhi  
				deleteTemplate();
				IGPRR0102Form.log_type.value = type;
				$("action").value = action;
				IGPRR0102Form.submit();
			}
		}
	}
	
}

/*
 * 校验：申请虚机信息
 */
function checkVMInfo(){
	var prstatus = '${IGPRR01021VO.process.prstatus}';
	var checkRes = true;
	
	if (prstatus != "Y") {
		return checkRes;
	}
	var dataCenterNames = document.getElementsByName("datacenterNames");
	var networkNames = document.getElementsByName("networkNames");
	
	for (var i = 0; i < dataCenterNames.length; i++) {
		if(dataCenterNames[i].value === ""){
			alert("虚机信息中序号为【" + (i+1) + "】的数据中心不能为空！");
			checkRes = false;
			break;
		} else if (networkNames[i].value === "") {
			alert("虚机信息中序号为【" + (i+1) + "】的所在网络不能为空！");
			checkRes = false;
			break;
		}
	}

	return checkRes;
}

/*
 * 功能：虚拟资源申请保存虚机信息
 */
function saveVM(){
	var prstatus = '${IGPRR01021VO.process.prstatus}';
	
	if (prstatus != "Y") {
		return;
	}
	
	// 设置为同步方式提交数据
	jQuery.ajaxSetup({  
		    async:false  
		});
	// 提交数据
	jQuery.post(getAppRootUrl() + "/IGVIR0202_SaveVM.do", jQuery("#form").serialize(),
		function(data) {
			//getFormObj("项目主键").value = data;
// 		   alert("项目主键：" + data);
		} 		
	);
}

function ShowpProcessFlow(prid){
	window.showModalDialog(getAppRootUrl() + '/IGPRR0111_Disp.do?prid='+prid,null,"dialogWidth:1000px;dialogHeight:600px;status:no;help:no;resizable:yes");
}
function toSave(){
    if(window.confirm("您是否确认提交？")){
	    return true;
    } else {
        return false;
    }
}
function selectRoleUser(roleid){
	openSubWindow('/IGSYM0405.do?roleida='+roleid , 'newpage', '800', '600');
}
function setParamRoleUser(userid,username,roleid,orgid,orgname){
	var check=document.getElementsByName("roleids");
	for(var i=0;i<check.length;i++){
		if(check[i].value==roleid){
			document.getElementsByName("ppuserids")[i].value = userid;
			document.getElementsByName("ppusernames")[i].value = username;
			document.getElementsByName("pporgids")[i].value = orgid;
			document.getElementsByName("pporgnames")[i].value = orgname;
			break;
		}
	}
}
function roleManager(prid,people){
	$("people_code").value = people;
	$("psdmode_code").value = ${IGPRR01021VO.processStatusDef.psdmode};
	var flag = checkForm('<%=IGPRDCONSTANTS.BUTTON_CHECKREQUIRED_YES %>','<%=IGPRDCONSTANTS.BUTTON_CHECKRECORD_NO %>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>');
	if(!flag) {
		$("people_code").value = "";
	};
}
function assignOA(prid, prstatus, psdid, usertype){
	if("super" == usertype) {
		window.location.href = "IGPRR0113_Disp.do?flag=0&psdmode=2&prid=" + prid + "&prstatus=" + prstatus + "&psdid=" + psdid;
	} else {
		window.location.href = "IGPRR0113_Admin.do?flag=1&roleid=" + $F("ppidstr").split("_")[1] + "&prid=" + prid + "&prstatus=" + prstatus + "&psdid=" + psdid;
	}
}
function assignNormal(prid, prstatus, psdid, usertype){
	if("super" == usertype) {
		window.location.href = "IGPRR0113_Disp.do?psdmode=1&prid=" + prid + "&prstatus=" + prstatus + "&psdid=" + psdid;
	} else {
		window.location.href = "IGPRR0113_Admin.do?flag=0&roleid=" + $F("ppidstr").split("_")[1] + "&prid=" + prid + "&prstatus=" + prstatus + "&psdid=" + psdid;
	}
}
//表单联动 主动表单变化时，被动表单内容变化
var changeValue = function(obj){
    return function()
  {
    	  var initiativepidid = obj.id.replace("pidid","");
    	 var passivityValue;
    	 var passivitypidid;
    	 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'type=searchValue&objvalue='+obj.value+'&initiativepidid='+initiativepidid,
    		 onSuccess:  function(req, json){
    		 var result=req.responseText;
    			if(result != null && result != ""){
        			var temp = result.split("#");
        			if(temp !=null && temp.length>0){
            			
	        			for(var i=0;i<temp.length;i++){
	        				passivitypidid = temp[i].split("|")[0];
	       				 passivityValue = temp[i].split("|")[1];
	       				var passivityobj = document.getElementById(passivitypidid);
	       				if(passivityobj !=null){
	       					passivityobj.value = passivityValue;
	       				}
	        			}
        			}

    			} 		
    	     }
    		});
    };
}
// 表单联动 主动表单变化时，被动表单下拉列表内容变化
var changeOptions = function(obj){
    return function()
  {
    	 var initiativepidid = obj.id.replace("pidid","");
    	 var passivityValue;
    	 var passivitypidid;
    	 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'type=searchValue&objvalue='+obj.value+'&initiativepidid='+initiativepidid,
    		 onSuccess:  function(req, json){
    		 var result=req.responseText;
    			if(result != null && result != ""){
        			var temp = result.split("#");
        			if(temp !=null && temp.length>0){
	        			for(var i=0;i<temp.length;i++){
	        				passivitypidid = temp[i].split("|")[0];
	       				    passivityValue = temp[i].split("|")[1];
		       				var passivityobj = document.getElementById(passivitypidid);
		       				var opts = passivityValue.split("%")
	       				    if(opts !=null && opts.length>0){
	       				    	passivityobj.options.length=0;
	       				    	for(var j=0;j<opts.length;j++){
	       				    		passivityobj.options.add(new Option(opts[j].split(",")[1],opts[j].split(",")[0]));
	       				    	}
	       				    }
	        			}
        			}
    			} 		
    	     }
    		});
    };
}
function grantDutyPerson(){
	if( window.confirm("请确认是否要进行授权操作?")){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=grantDutyPerson&prid=${IGPRR0102Form.prid}&roleid='+$F("ppidstr").split("_")[1],
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					alert(result);
					return true;
				}else{
					alert("授予部门管理员提交权限失败！");
					return false;	
				}	
		    }
			});
		
		return true;
	} else {
		return false;
	}
}
function noticeRoleManager(){
	if( window.confirm("请确认是否要短信通知部门负责人?")){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=noticeRoleManager&prid=${IGPRR0102Form.prid}&roleid='+$F("ppidstr").split("_")[1],
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					alert(result);
					return true;
				}else{
					alert("部门负责人短信通知失败！");
					return false;	
				}	
		    }
			});
		return true;
	} else {
		return false;
	}
}
function selectTree(index,ccidinfo,selectTree){
	num = index;
	var ccid = ccidinfo.split("_tree_")[0];
	url = "IGSYM1505_TREE.do" + "?ccid="+ccid + "&selectTree=" + selectTree;
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("pivarvalue[" + num + "]").value = "";
		$("pivartreename[" + num + "]").value = "";
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
			$("pivarvalue[" + num + "]").value = treesyscode + "_tree_" + name;
			$("pivartreename[" + num + "]").value = name;
		}else{
			$("pivarvalue[" + num + "]").value = '';
			$("pivartreename[" + num + "]").value = '';
		}
	}
	if($("pivartreename[" + num + "]").onchange){
		$("pivartreename[" + num + "]").onchange();
	}
	num = 0;
}


function selectPeople(pidid,roletype,index){
	if(roletype == "N/A"){
		roletype = "";
	}
	cpidid = pidid;
	num = index;
	openSubWindow('/IGPRR0303_Disp.do?roletype=' + roletype , '_pblank','1050','600');
}
function setParticipant(obj){
	var tb = document.getElementById("people_" + cpidid);
	var tr,td1,td2,td3,td4,td5;
	var count = 0;
	if(obj != null && obj.length > 0){
		for(var k=0;k<obj.length;k++){
			for(var n=0;n<tb.rows.length;n++){
				if(obj[k][0] == tb.rows[n].name){
					alert("用户 \"" + obj[k][1] + "\" 在列表中已存在，请重新选择！");
					return true;
				}
			}
		}
		for(var i=0;i<obj.length;i++){
			tr = tb.insertRow();
			tr.name = obj[i][0];
			td1 = tr.insertCell();
			td1.innerHTML = obj[i][1] + 
							'<input type="hidden" name="par_userid" value="' + obj[i][0] + '" />' + 
							'<input type="hidden" name="par_username" value="' + obj[i][1] + '" />';
			td2 = tr.insertCell();
			td2.innerHTML = obj[i][3] +
							'<input type="hidden" name="par_orgid" value="' + obj[i][2] + '" />' +
							'<input type="hidden" name="par_orgname" value="' + obj[i][3] + '" />';
			td3 = tr.insertCell();
			td3.innerHTML = obj[i][5] + 
							'<input type="hidden" name="par_roleid" value="' + obj[i][4] + '" />' + 
							'<input type="hidden" name="par_rolename" value="' + obj[i][5] + '" />';
			td4 = tr.insertCell();
			td4.innerHTML = obj[i][6] + 
							'<input type="hidden" name="par_phone" value="' + obj[i][6] + '" />';
			td5 = tr.insertCell();
			td5.style.textAlign = "center";
			td5.innerHTML = '<a href="javascript:void(0);" onclick="deleteParticipant(this);">删除</a>' +
							'<input type="hidden" name="par_pidid" value="' + cpidid + '"/>';
			count ++;
		}
	}
	num = 0;
	cpidid = null;
}
function deleteParticipant(obj,index,piuid){
	if(piuid > 0){
		if($F("pivarvalue[" + index + "]") != "" && $F("pivarvalue[" + index + "]").split("_participantValue_").length == 2){
			$("pivarvalue[" + index + "]").value += "#" + piuid;
		}else{
			$("pivarvalue[" + index + "]").value += "_participantValue_" + piuid;
		}
	}
	var tr = obj.parentElement.parentElement;
	tr.parentElement.deleteRow(tr.rowIndex);
}

//====>130225Begin
//选择执行人
function orgManager(prid, prstatus,pporgid){
	 window.location.href ="IGPRR0121_Disp.do?prid="+prid+
   	"&prstatus=" + prstatus+"&pporgid=" + pporgid;
}
//给部门值班人授权
function grantDutyPersonOrg(orgid){
	if( window.confirm("请确认是否要进行授权操作?")){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=grantDutyPersonOrg&prid=${IGPRR0102Form.prid}&orgid=${IGPRR0102Form.pporgid}',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					alert(result);
					return true;
				}else{
					alert("授予部门值班人提交权限失败！");
					return false;	
				}	
		    }
			});
		
		return true;
	} else {
		return false;
	}
}
//给部门负责人发短信
function noticeOrgManager(orgid){
	if( window.confirm("请确认是否要短信通知部门负责人?")){
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=noticeOrgManager&prid=${IGPRR0102Form.prid}&orgid=${IGPRR0102Form.pporgid}',
			 onSuccess:  function(req, json){
			 var result=req.responseText;
				if(result != null && result != ""){
					alert(result);
					return true;
				}else{
					alert("部门负责人短信通知失败！");
					return false;	
				}	
		    }
			});
		return true;
	} else {
		return false;
	}
}
function checkTableForm(pidid,pidname,pidrequired){
	if(columnNameInfo == null){
		packagingTableColumnDef();
	}
	var pids = columnNameInfo[pidid];
	var len = 0;
	for(var pidkey in pids){
		if(pids[pidkey]["pidtype"] == "8"){
			var flag = checkTableForm(pidkey,pidname,pidrequired);
			if(!flag){
				return false;
			}
		}else{
			if(tableValueArray != null){
				var values = tableValueArray[pidkey];
				if(values != null && values.length > 0){
					for(var i=0;i<values.length;i++){
						if(values[i] != null){
							if(values[i].trim() == ""){
								if("1" == pidrequired && "1" == pids[pidkey]["pidrequired"]){
									alert("请输入" + pidname + pids[pidkey]["pidname"] + "！");
									return false;
								}
							}else{
								if(values[i].strlen()>3000){
									alert(pidname + pids[pidkey]["pidname"] + "不能大于" +Math.floor(3000/strByteFlag)+"个汉字！");
									return false;
								}
							}
						}
					}
				}
			}
		}
	}
	return true;
}
function packagingTableColumnDef(){
	columnNameInfo = new Array();
	<logic:present name="AD_columnInfoMap" scope="session">
		<logic:iterate id="map" name="AD_columnInfoMap">
			var columnNames = new Array();
			<bean:define id="list" name="map" property="value"/>
			<logic:iterate id="bean" name="list">
				var columnInfo = new Array();
				columnInfo["pidname"] = "${bean.pidname }";
				columnInfo["pidrequired"] = "${bean.pidrequired}";
				columnInfo["pidtype"] = "${bean.pidtype}";
				columnNames["${bean.pidid }"] = columnInfo;
			</logic:iterate>
			columnNameInfo["${map.key }"] = columnNames;
		</logic:iterate>
	</logic:present>
}
function packagingTableValue(){
	tableValueArray = new Array();
	var pidids = document.getElementsByName("column_pidid");
	var values = document.getElementsByName("column_value");
	if(pidids != null){
		for(var i=0;i<pidids.length;i++){
			if((values[i].rownumber + "").indexOf("#") < 0){
				if(tableValueArray[pidids[i].value] == null){
					var temp = new Array();
					temp[temp.length] = values[i].value;
					tableValueArray[pidids[i].value] = temp;
				}else{
					tableValueArray[pidids[i].value][tableValueArray[pidids[i].value].length] = values[i].value;
				}
			}
		}
	}
}
//====>130225End
//==>联想阳光雨露Begin
//指定分派页过滤机构码
function setAssign_orgsyscoding(){
	var orgsyscoding = "";
	var pidvalue = "";
	<logic:present name="IGPRR01021VO" property="processInfoDefmap">
		<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
			<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
			<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
			<logic:present name="psid">
				<logic:equal value="门店所属机构标识" name="psid" property="pidname">
					//orgId = '${index}';
					pidvalue = '${psid.pidvalue}';
					//orgsyscoding = document.getElementById('pivarvalue[' + orgId + ']').value ;
				</logic:equal>
			</logic:present>
		</logic:iterate>
	</logic:present>
	document.getElementById('assign_orgsyscoding').value = pidvalue;
}
//指定资产过滤机构码
function setEiorgcode(){
	var orgsyscoding = "";
	var pidvalue = "";
	<logic:present name="IGPRR01021VO" property="processInfoDefmap">
		<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
			<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
			<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
			<logic:present name="psid">
				<logic:equal value="门店所属机构标识" name="psid" property="pidname">
					//orgId = '${index}';
					pidvalue = '${psid.pidvalue}';
					//orgsyscoding = document.getElementById('pivarvalue[' + orgId + ']').value ;
				</logic:equal>
			</logic:present>
		</logic:iterate>
	</logic:present>
	document.getElementById('eiorgcode').value = pidvalue;
}
	

//==>联想阳光雨露End
</script>