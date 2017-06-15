﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<script type="text/javascript">
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
	var roleid = document.getElementById("prroleid").value;
	var pdid = document.getElementById("pdid").value;
	var prid = document.getElementById("prid").value;
	document.location.replace(getAppRootUrl() + "/IGPRR0102_Disp.do?pdid="+pdid+"&roleid="+roleid+"&prid="+prid);
}
function changePrRolename(){
	var obj = IGPRR0102Form.prroleid;
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
function openSVCPage(index){
	num = index;
	openSubWindow('/IGSVC0107_Disp.do', '_blank','1000','600');
}
function setParams(prcorid,prcortype,prcortitle){
	if(prcorid == ""){
		$("pivarvalue[" + num + "]").value = "";
		$("pivarprname[" + num + "]").value = "";
	} else {
        $("pivarvalue[" + num + "]").value = prcorid + "_svc_" + prcortype + "_name=" + prcortitle;
	    $("pivarprname[" + num + "]").value = prcortitle;
	}
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
	$("pivarvalue[" + index + "]").value = obj.value;
	$("pivarradio_Other[" + index + "]").value = obj.value;
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
function checkForm(btnid,action,type,code){
	//提交时相关表单校验
	var linkageCheck = true;
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'type=searchObjectForCheck&btnid='+btnid+'&pdid='+pdid,
		 onSuccess:  function(req, json){
		 var result=req.responseText;
			if(result != null && result != ""){
				var temp = result.split("#");
    			if(temp !=null){
        			if(temp.length>0){
	        			for(var i=0;i<temp.length;i++){
	        				var blname = temp[i].split("|")[0];
	        			    var initiativepidid = temp[i].split("|")[1];
	        		    	var passivitypidid = temp[i].split("|")[2];
	        		    	//校验失败的场合
	        		    	if(!checkLinkage(blname,initiativepidid,passivitypidid)){
	            		    	linkageCheck = false;
	            		    	return;
	        		    	}
	        			}
        			}
    			}
			} 		
	     }
		});
	if(!linkageCheck){
		return;
	}
	var isInit = IGPRR0102Form.isInit.value;
	var go="1";
	if(IGPRR0102Form.rlcomment){
		if($F('rlcomment').strlen()>3000){
			alert("处理记录不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
			go="0";
		}
	}
		 
	if(action!="<%=IGPRDCONSTANTS.BUTTON_TERMINATE%>"){
		if(code != "3") {
			<logic:present name="IGPRR01021VO" property="processInfoDefmap">
				<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
					<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
					<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
					<logic:present name="psid">
						<logic:equal name="psid" property="pidaccess" value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>">
							<logic:equal value="1" name="psid" property="pidrequired">
								if($F('pivarvalue[${index}]').trim() == ""){
									alert("请输入${psid.pidlabel}！");
									go="0";
									return;
								}
							</logic:equal>
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
			$("action").value = action;
			form.submit();
		}
		go="0";
	}
	if(go=="1"){
		if(code == "3"){
			IGPRR0102Form.log_type.value = type;
			$("action").value = action;
			IGPRR0102Form.submit();
		}else{
			if( window.confirm("您是否确认提交？")){
				IGPRR0102Form.log_type.value = type;
				$("action").value = action;
				IGPRR0102Form.submit();
			}
		}
	}
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
	checkForm('<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.BUTTON_UPDATE%>','<%=IGPRDCONSTANTS.RECORDLOG_TYPE_CL %>','3');
}
function assignOA(prid, prstatus, psdid, usertype){
	if("super" == usertype) {
		window.location.href = "IGPRR0113_Disp.do?flag=0&psdmode=2&prid=" + prid + "&prstatus=" + prstatus + "&psdid=" + psdid;
	} else {
		window.location.href = "IGPRR0113_Admin.do?flag=1&roleid=" + $F("prroleid") + "&prid=" + prid + "&prstatus=" + prstatus + "&psdid=" + psdid;
	}
}
function assignNormal(prid, prstatus, psdid, usertype){
	if("super" == usertype) {
		window.location.href = "IGPRR0113_Disp.do?psdmode=1&prid=" + prid + "&prstatus=" + prstatus + "&psdid=" + psdid;
	} else {
		window.location.href = "IGPRR0113_Admin.do?flag=0&roleid=" + $F("prroleid") + "&prid=" + prid + "&prstatus=" + prstatus + "&psdid=" + psdid;
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
			parameters: 'type=grantDutyPerson&prid=${IGPRR0102Form.prid}&roleid='+$F("prroleid"),
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
			parameters: 'type=noticeRoleManager&prid=${IGPRR0102Form.prid}&roleid='+$F("prroleid"),
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
function selectTree(index,ccidinfo){
	num = index;
	var ccid = ccidinfo.split("_tree_")[0];
	url = "IGSYM1505_TREE.do" + "?ccid="+ccid;
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
	num = 0;
}
</script>