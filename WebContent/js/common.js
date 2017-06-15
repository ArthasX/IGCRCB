var enableEnterJump = true;
var oneTimeNotJump  = true;
var ajaxAction = "/ajax.do";
var OpenWindow ;
//
function onKeyDownHandler(){

	//
	if( !isLoadComplete() ) return false;
	//F5,ctrl+R
	if(event.keyCode == 116 || (event.ctrlKey && event.keyCode == 82) ) {
		event.keyCode = 0;
		return false;
	}

	str = navigator.appName.toUpperCase();
	if(str.indexOf("EXPLORER") >= 0){
		// Enter
		if(event.keyCode == 13 && enableEnterJump && oneTimeNotJump){
			if(document.activeElement.type != null &&(
		       document.activeElement.type.toLowerCase() == "button" ||
		       document.activeElement.type.toLowerCase() == "submit" ||
		       document.activeElement.type.toLowerCase() == "textarea" )){
			}else{
				if(document.activeElement.type != null){
					event.keyCode = 0x09;
				}
			}
        }else if( event.keyCode == 0x25 && event.altKey == true ) {
			//ALT
            return false ;

		}else{
	        //
	        if( document.activeElement.type != null &&
	        	(document.activeElement.type.toLowerCase() == "text" || document.activeElement.type.toLowerCase() == "password" || document.activeElement.type.toLowerCase() == "textarea") &&
	        	document.activeElement.readOnly == false){

	        	return true;
	        }
			// BackSpace
			if( event.keyCode == 8 ) {
				return false ;
			}

			oneTimeNotJump = true;
		}
	}
}

//
function onClickHandler(){

  //
  if( !isLoadComplete() ) return false;

}

function skip(nam){
	var frmno = 0;

	for(frmno=0; frmno < document.forms.length; frmno=frmno+1)

		for(var i=0; i < document.forms[frmno].length; i=i+1)
			if(nam == document.forms[frmno].elements[i].name){
				//alert(document.forms[frmno].elements[i].className);
				//if(document.forms[frmno].elements[i].currentStyle.backgroundColor == "#d4d0c8" ){


					if(i+1 < document.forms[frmno].length){
						if(frmno+1 < document.forms.length)

							document.forms[frmno+1].elements[0].focus();
						else
							document.forms[frmno].elements[0].focus();
					}

					document.forms[frmno].elements[i+1].focus();
					break;
				//}
		}
}


function viewCommnent(name){

	var windowX_Max = 1024;
  var comObj=document.all[name].style;
  var arwObj=document.all[name + "ft"].style;

	var boxwidth = document.all[name].currentStyle.width;
	boxwidth = parseInt(boxwidth.substring(0, boxwidth.length-2));
	var pointX = window.event.clientX + document.body.scrollLeft;

	myX =  22;
	myY = -29;
	arwX= -33;
	arwY= -28;

	if(pointX + myX + boxwidth > windowX_Max){
		myX = (boxwidth+30)*-1 ;
		arwObj.filter="fliph";
	}else{
		arwObj.filter="";

	}


  if(comObj.display == 'none'){
   comObj.display = "block";
   arwObj.display = "block";
  }else{
   comObj.display = "none";
   arwObj.display = "none";
  }
  comObj.left = myX + window.event.clientX + document.body.scrollLeft + "px";
  comObj.top  = myY + window.event.clientY + document.body.scrollTop  + "px";
  arwObj.left = arwX+ window.event.clientX + document.body.scrollLeft + "px";
  arwObj.top  = arwY+ window.event.clientY + document.body.scrollTop  + "px";
}

//
function back_link(){
	for(var i=0;i<document.forms.length;i++){
		for(var i2=0;i2<document.forms[i].elements.length;i2++){
			if( document.forms[i].elements[i2].value == '' ){
				document.forms[i].elements[i2].click();
				return;
			}
		}
	}
}

//
var cancel_confirmd = false;
function cancel_confirm(){

	if( !cancel_confirmd && edit_page ){
		cancel_confirmd = window.confirm(edit_cancel_confirm_message);
		return cancel_confirmd;
	} else {
		return true;
	}
}

//
function checkChangeValue(){
	if( hdnDefaultValueElement ){
		return (hdnDefaultValueElement.value != getAllValues() );
	} else {
		return false;
	}
}

//
function saveDefaultValue(){
	var defaultValues = getAllValues();
	if( hdnDefaultValueElement.value =="" )
		hdnDefaultValueElement.value = defaultValues;
}

//
var hdnDefaultValueElement;
function getAllValues(){
	var values="";
	for(var i=0;i<document.forms.length;i++){
		for(var j=0;j<document.forms[i].elements.length;j++){
			element = document.forms[i].elements[j];
			if(element.name=='hdn_default_value') {
				hdnDefaultValueElement = element;
			} else {
				values += element.value;
			}
		}
	}
	return values;
}

// 判断页面是否加载完成
function isLoadComplete(){
	return (window.document.readyState == 'complete');
}

// 
var submitted = false;
function checkSubmit(form) {
	
	if( !isLoadComplete() ) return false;
	if(submitted) {
		return false;
	}
	submitted = true;
	document.body.style.cursor = "wait";
}

function execAjaxEx(type, inputVal, updateId){

	execAjax(type, 'value=' + encodeURIComponent(inputVal), updateId);
}

function htmlFilter(obj){

	if(window.clipboardData)
	obj.innerText += window.clipboardData.getData('Text');
	
	return false;
}

function execAjax(type, urlParam, updateId){

	// xmlHttpRequest
	// 

	if(updateId == null || updateId == ""){
		// 
		new Ajax.Request(
			getAppRootUrl() + ajaxAction,
			{ parameters: urlParam + '&type=' + type}
			);
	}else{
		new Ajax.Updater(
			updateId,
			getAppRootUrl() + ajaxAction,
			{ parameters: urlParam + '&type=' + type ,onSuccess:  function(req, json){onComplete(req, json, updateId);} }
			);
	}
}

// Ajax
function onComplete (req, json, updateId){
	// id
	$(updateId).value = req.responseText;
}

function execAjaxEname(inputVal, updateId){
	execAjaxEx('ename', inputVal, updateId);
}

function execAjaxCcname(ccid, ccname){
	var type = 'ccname';
	var param = $H({ccid:ccid}).toQueryString();
	execAjax(type, param, ccname);
}

function execAjaxCvalue(ccid, cid,cvalue){
	var type = 'cvalue';
	var param = $H({ccid:ccid, cid:cid}).toQueryString();
	execAjax(type, param, cvalue);
}


/*
// 
//
// uri   
// wName  
// width  
// height 
*/
function openSubWindow(uri, wName, width, height){
	if(width == "")
		width = "800";
	if(height == "")
		height = "600";
	var iTop = (window.screen.availHeight-30-width)/2;       //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-height)/2;           //获得窗口的水平位置;
	var subwin =  window.open(getAppRootUrl() + uri, wName, 'width='+ width + ',height=' + height + ',scrollbars=yes,resizable=yes,status=yes,top='+iTop+',left='+iLeft+',').focus();
	return subwin;
}

function openSubIGCOM0301(enable,ecategory){
	var param = "";
	param = $H({enable: enable, ecategory: ecategory}).toQueryString();
	openSubWindow('/IGCOM0301_Disp.do?' + param , '', '800', '600');
}

function openSubIGCOM0302(){
	openSubWindow('/IGCOM0302_Disp.do' , '', '850', '600');
}

function openSubIGKGM0206(){
	openSubWindow('/IGKGM0206_Disp.do?resetFlag=1' , '', '1010', '600');
}

function openSubIGKGM0206Parm(obj){
	openSubWindow('/IGKGM0206_Disp.do?resetFlag=1&' + obj , '', '1010', '600');
}

function openSubIGCOM0302PARAM(param){
	openSubWindow('/IGCOM0302_Disp.do'+param , '', '850', '600');
}

function openSubIGCOM0327PARAM(param){
	openSubWindow('/IGCOM0327_Disp.do'+param , '', '850', '600');
}

function openSubIGCOM0329PARAM(param){
	openSubWindow('/IGCOM0329_Disp.do'+param , '', '850', '600');
}

function openSubIGASM1104(eiid){
	openSubWindow('/IGASM1104_Disp.do?eiid='+eiid, '', '800', '600');
}

function openSubIGASM1105(cur_room_eiid,cur_room_x_value,cur_room_y_value){
	param = $H({cur_room_eiid: cur_room_eiid,cur_room_x_value:cur_room_x_value,
		cur_room_y_value:cur_room_y_value}).toQueryString();
	openSubWindow('/IGASM1105_Disp.do?' + param, '', '800', '600');
}

function openSubIGASM1114(eiid){
	param = $H({eiid: eiid}).toQueryString();
	openSubWindow('/IGASM1114_Disp.do?' + param, '', '800', '600');
}

function openSubIGASM1115(cur_container_eiid,cur_container_u_value){
	param = $H({cur_container_eiid: cur_container_eiid,
		cur_container_u_value:cur_container_u_value}).toQueryString();
	openSubWindow('/IGASM1115_Disp.do?' + param, '', '800', '600');
}

function openSubIGASM1116(eiid,civersion){
	param = $H({eiid: eiid,civersion:civersion}).toQueryString();
	openSubWindow('/IGASM1116_Disp.do?' + param, '', '800', '600');
}

function openSubIGCOM0303(eiid,civersion){
	param = $H({eiid: eiid,civersion:civersion}).toQueryString();
	// 为武警poc修改2014 0312
	//openSubWindow('/IGCOM0303_Disp.do?' + param, '_blank', '1050', '600');
	
	openSubWindow('/IGCOM0328_Disp.do?' + param, '_blank', '1050', '600');
}
function openSubIGCOM0303ForER(id,eiid){
	var url = "IGDRM0430_Disp.do?flag=open&id="+id+"&eiid="+eiid;
	window.showModalDialog(url,null,"dialogWidth:1100px;dialogHeight:600px;status:no;help:no;resizable:yes");
}
function openSubIGCOM0328(eiid,civersion){
	param = $H({eiid: eiid,civersion:civersion}).toQueryString();
	openSubWindow('/IGCOM0328_Disp.do?' + param, '_blank', '1024', '600');
}
function openSubIGCOM0303_Relation(eiid,civersion){
	param = $H({eiid: eiid,civersion:civersion}).toQueryString();
	openSubWindow('/IGCOM0303_Relation.do?' + param + '&screenWidth='+window.screen.width, '_blank', '800', '600');
}
function openSubIGCOM0304(){
	openSubWindow('/IGCOM0304_Disp.do', '_blank', '800', '600');
}

function openSubIGASM0341(){
	openSubWindow('/IGASM0341.do', '_blank', '800', '600');
}

function openSubIGASM0344(){
	openSubWindow('/IGASM0344_Disp.do', '_blank', '800', '600');
}
function openSubIGASM0346(eirootmark, eiid, eiversion, eismallversion){
	
	var queryParam = $H({eirootmark:eirootmark, eiid:eiid, eiversion:eiversion, eismallversion:eismallversion}).toQueryString();
	openSubWindow('/IGCIM0146_Disp.do?' + queryParam, 'IGCIM0146', '800', '600');
}

function openSubIGAIM0146(eirootmark, eiid, eiversion, eismallversion){
	var queryParam = $H({eirootmark:eirootmark, eiid:eiid, eiversion:eiversion, eismallversion:eismallversion}).toQueryString();
	openSubWindow('/IGAIM0146_Disp.do?' + queryParam, 'IGAIM0146', '1000', '800');
}

function openSubIGMTM0603(eirootmark, eiid, eiversion, eismallversion){
	openSubWindow('/IGMTM0603_Disp.do?eiid='+eiid,'IGMTM0603', '1000', '800');
}

function openSubIGCIM0149(eirootmark, eiid, eiversion, eismallversion){
	var queryParam = $H({eirootmark:eirootmark, eiid:eiid, eiversion:eiversion, eismallversion:eismallversion}).toQueryString();
	openSubWindow('/IGCIM0149_Disp.do?' + queryParam, 'IGCIM0149', '1000', '800');
}
function openSubIGEMO0101(eiid){
	var queryParam = $H({eiid:eiid}).toQueryString();
	openSubWindow('/IGEMO0101_Disp.do?' + queryParam, 'IGEMO0101', '1000', '800');
}
function openSubIGWarn0101(eirootmark, eiid, eiversion, eismallversion){
	var queryParam = $H({eirootmark:eirootmark, eiid:eiid, eiversion:eiversion, eismallversion:eismallversion}).toQueryString();
	openSubWindow('/IGAIM0150_Disp.do?' + queryParam, 'IGAIM0150', '1000', '800');
}
function openSubIGCIM0137(eiid){
	var queryParam = $H({eiid:eiid}).toQueryString();
	openSubWindow('/IGCIM0137_Disp.do?' + queryParam, 'IGCIM0137', '1024', '800');
}

function openSubIGSYM0306(pdid){
	openSubWindow('/IGSYM0306_Disp.do?pdid='+pdid , '', '850', '600');
}

function openSubIGPRR0106(rlid){
	openSubWindow('/IGPRR0106_Disp.do?rlid='+rlid,'_blank','800','600');
}

function downloadASMFile(eiid, ciid){

	var param = "";
	var type = "asm";
	param = $H({type: type, eiid: eiid, ciid:ciid}).toQueryString();
	openSubWindow('/download.do?' + param, '','800','600');
}

function downloadSvcFile(attid){
	var param = "";
	var type = "svc";
	param = $H({type: type, attId: attid}).toQueryString();
	openSubWindow('/downloadSvcFile.do?' + param, '','800','600');
}
// foward
// uri 
function forward(uri){
	window.location.href= getAppRootUrl() + uri;
}


// ADAM
// '/adam' 
function getAppRootUrl(){
	var lct = location.href;
	var arr = lct.split("/",4);
	return "/" + arr[3];
}


// 
function startCheckOpenerClosed(){
	if(window.parent.document.getElementsByTagName("frame")){	
	}else{
		var id=window.opener.gid;
		setInterval( "checkOpenerClosed('" + id + "')", 1500 );
	}
}
function openSubIGASM1109(eiid,jitype){
	param = $H({eiid: eiid,jitype:jitype}).toQueryString();
	openSubWindow('/IGASM1114_Flex_Disp.do?' + param, '', '800', '600');
}
function openSubIGCOM0300(eiid, storageID){
	var params = $H({eiid: eiid, storageID:storageID}).toQueryString();
	openSubWindow('/IGCIM0100_Disp.do?' + params,'_blank','1440','900');
}
function openSubIGCOM0310(eiid, domainid, domainversion, updatetime){
	var params = $H({eiid: eiid, domainid:domainid, domainversion:domainversion, updatetime:updatetime}).toQueryString();
	openSubWindow('/IGCOM0310.do?' + params,'_blank','850','800');
}
function openSubIGCOM0318_Relation(srpareiid_eq,srdomainid_eq,srdomainversion_eq,srparversion_eq,srparsmallversion_eq,srcreatetime_eq){
	param = $H({srpareiid_eq:srpareiid_eq,srdomainid_eq:srdomainid_eq,srdomainversion_eq:srdomainversion_eq,srparversion_eq:srparversion_eq,srparsmallversion_eq:srparsmallversion_eq,srcreatetime_eq:srcreatetime_eq}).toQueryString();
	openSubWindow('/IGCOM0318_Relation.do?' + param + '&screenWidth='+window.screen.width, '_blank', '850', '800');
}
function openSubIGCOM0316(eiid,civersion,eismallversion){
	param = $H({eiid: eiid, civersion:civersion, cismallversion:eismallversion}).toQueryString();
	openSubWindow('/IGCOM0316_Disp.do?' + param, '_blank', '800', '600');
}
function openSubIGCOM0321(eiid, domainid, domainversion, updatetime){
	var params = $H({eiid: eiid, domainid:domainid, domainversion:domainversion, updatetime:updatetime}).toQueryString();
	openSubWindow('/IGCOM0321.do?' + params,'_blank','800','600');
}
function openSubIGCOM0324(eiid, domainid, domainversion, updatetime){
	var params = $H({eiid: eiid, domainid:domainid, domainversion:domainversion, updatetime:updatetime}).toQueryString();
	openSubWindow('/IGCOM0324.do?' + params, '_blank', '800', '600');
}
function checkOpenerClosed(id){
	//
	if(window.opener.closed){
		window.close();
	}
	//
	if(window.opener.gid != id){
		window.close();
	}
}


//
function mouseWheelHandler() {

	//
	//
	if(document.activeElement && document.activeElement.type != null){
		var type = document.activeElement.type.toLowerCase().substring(0,6); 
		if(type == "select")
			return false;
	}
}

function closeWin(){
	if(cancel_confirm()){
		window.opener=self;
		window.close();
	}
}

var requireId = null;

//
function requiredCheck(){
	var bl = true;

	if(requireId == null)
		return bl;
		
	bl = requiredSubCheck();
	
	requireId.each( function(obj) {
		if($(obj).value == null || $(obj).value == ""){
			Element.addClassName($(obj), "inputError");
			bl = false;
		}
	} );
	
	if(!bl)
		alert('');
	
	return bl;
}

//
function requiredSubCheck(){
	return true;
}

//
function clearErrorClass(id){
	if (Element.hasClassName($(id), "inputError")) 
		Element.removeClassName($(id), "inputError");
}

//附件路径清空
function cleanFile(obj,obj1){

	document.getElementById(obj).outerHTML='<input type="file" name="' + obj +'" size="25" value="" onkeydown="return false;" id="' + obj+ '" class="imeDisabled">';
	
}

//删除附件
function delFile(obj1,obj2,message){
	 if( window.confirm(message)){
		 document.getElementById(obj1).value = "1";
		 document.getElementById(obj2).style.display = "none";
     } 
}

window.document.onmousewheel = mouseWheelHandler;
window.document.onkeydown = onKeyDownHandler;
window.document.onclick = onClickHandler;
//history.forward();


//全选
function selectAll(name,obj) { 
	var checks = document.getElementsByName(obj);
	if(document.getElementById(name).checked){
		for(var i=0;i < checks.length;i++) 
		{ 
			checks[i].checked = true; 
		} 
	}else{
		for(var i=0;i < checks.length;i++) 
		{ 
			checks[i].checked = false; 
		} 
	}
}

//全选
function selectAllNoDisable(name,obj) { 
	var checks = document.getElementsByName(obj);
	if(document.getElementById(name).checked){
		   for(var i=0;i < checks.length;i++) 
		   {
			if(!checks[i].disabled){
				checks[i].checked = true; 
			}
		   } 
	}else{
		for(var i=0;i < checks.length;i++) 
		   { 
			if(!checks[i].disabled){
				checks[i].checked = false; 
			}
		   } 
	}
}

//判断是否选中
function checkNum(obj){
	var count=0;
	var check=document.getElementsByName(obj);
	if(check != null) {
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				count=1;
				break;
			}
		}
	}
	return count;
}
//获取选中行数
function getNum(obj){
	var count=0;
	var check=document.getElementsByName(obj);
	if(check != null) {
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				count++;
			}
		}
	}
	return count;
}

//改变角色名称(流程管理)
function changeRolename(){
	var obj = document.forms[0].roleid;
	if(obj.selectedIndex!=-1){
		document.forms[0].rlrolename.value = obj.options[obj.selectedIndex].text;
	}
}

//改变角色名称(企业定时任务)
function changeImplRole(){
	var obj = document.forms[0].qjimplrole;
	if(obj.selectedIndex!=-1){
		document.forms[0].qjimplroleid.value = obj.options[obj.selectedIndex].value;
		document.forms[0].qjimplrolename.value = obj.options[obj.selectedIndex].text;
	}
	document.forms[0].qjimplusername.value = "";
	document.forms[0].qjimpluser.value = "";
}

//创建隐藏表单
function   createHiddenInput(name,value){   
	var inputElement=document.createElement("input");   
	inputElement.name=name;   
	inputElement.value=value;     
	inputElement.type="hidden";
	inputElement.id=name;
	document.forms[0].appendChild(inputElement);   
}

//创建隐藏表单
function   createHiddenInputForm(name,value,formid){   
    var inputElement=document.createElement("input");   
    inputElement.name=name;   
    inputElement.value=value;     
    inputElement.type="hidden";
    inputElement.id=name;
    formid.appendChild(inputElement);   
}

//开始日期小于结束日期
function checkDate(beginDateTextId,endDateTextId){
	var popentime = document.getElementById(beginDateTextId).value;
	var pclosetime = document.getElementById(endDateTextId).value;
	if("" == popentime || "" == pclosetime){
		return true;
	}
	var beginYear = popentime.split("/")[0];
	var closeYear = pclosetime.split("/")[0];
	var beginMonth = popentime.split("/")[1];
	var closeMonth = pclosetime.split("/")[1];
	var beginDay = popentime.split("/")[2];
	var closeDay = pclosetime.split("/")[2];
	
	if(Number(beginYear) == Number(closeYear)){
		if(Number(beginMonth) == Number(closeMonth)){
			if(Number(beginDay) > Number(closeDay)){
				return false;
			}
		} else if (Number(beginMonth) > Number(closeMonth)){
			return false;
		}
		
	} else if(Number(beginYear) > Number(closeYear)){
		return false;
	}
	return true;
}
//开始日期小于结束日期
function checkDateValue(popentime,pclosetime){
	if("" == popentime || "" == pclosetime){
		return true;
	}
	var beginYear = popentime.split("/")[0];
	var closeYear = pclosetime.split("/")[0];
	var beginMonth = popentime.split("/")[1];
	var closeMonth = pclosetime.split("/")[1];
	var beginDay = popentime.split("/")[2];
	var closeDay = pclosetime.split("/")[2];
	
	if(Number(beginYear) == Number(closeYear)){
		if(Number(beginMonth) == Number(closeMonth)){
			if(Number(beginDay) > Number(closeDay)){
				return false;
			}
		} else if (Number(beginMonth) > Number(closeMonth)){
			return false;
		}

	} else if(Number(beginYear) > Number(closeYear)){
		return false;
	}
	return true;
}

function checkDateByContent(beginDate,endDateText){
	var popentime = beginDate;
	var pclosetime = endDateText;

	if("" == popentime || "" == pclosetime){
		return true;
	}
	var beginYear = popentime.split("/")[0];
	var closeYear = pclosetime.split("/")[0];
	var beginMonth = popentime.split("/")[1];
	var closeMonth = pclosetime.split("/")[1];
	var beginDay = popentime.split("/")[2];
	var closeDay = pclosetime.split("/")[2];

	if(Number(beginYear) == Number(closeYear)){
		if(Number(beginMonth) == Number(closeMonth)){
			if(Number(beginDay) > Number(closeDay)){
				return false;
			}
		} else if (Number(beginMonth) > Number(closeMonth)){
			return false;
		}

	} else if(Number(beginYear) > Number(closeYear)){
		return false;
	}
	return true;
}
//校验手机格式
function isMobile(str)  
{  
	var patrn = /^[0-9]{11}$/;
	if(patrn.exec(str)) {
		return false;
	}
	return true;
}

var attachFileNum=0;
function addFile() 
{
	currRow=tb.insertRow();
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='file' id='attachFile"+attachFileNum+"' name='attachFile["+attachFileNum+"]' class='inputbutton' contentEditable='false'><input type='button' class='delbutton' value='\u5220\u9664' onclick='deleteitem(this)'>";
	attachFileNum++;
}

function deleteitem(obj)
{
	var curRow= obj.parentNode.parentNode;
	tb.deleteRow(curRow.rowIndex);
}


var attachFileNumMuti=0;
//var att=new Array();
function addFileMuti(tbr) 
{
	var att1=tbr+"_"+attachFileNumMuti;
	currRow=eval(tbr).insertRow();
	cell=currRow.insertCell();
	var cwidth = cell.offsetWidth;
	var fileInputWidth = 450;
	if(cwidth != null && cwidth < 400){
		fileInputWidth = 200;
	}
	cell.innerHTML= "<input type='file' id='attachFileMuti["+attachFileNumMuti+"]' attr="+tbr+" style='width:" + fileInputWidth + "px;' name='attachFileMuti["+attachFileNumMuti+"]' class='fileMuti' contentEditable='false'><input type='button' class='delbutton' value='\u5220\u9664' onclick='deleteitemMuti(this,"+tbr+")'><input type='hidden' name='att' value='"+att1+"'>";
	attachFileNumMuti++;
	
}
function addSingleFileMuti(tbr) 
{
	var att1=tbr+"_"+attachFileNumMuti;
	var tb = document.getElementById(tbr);
	var currRow=tb.insertRow();
	var cell=currRow.insertCell();
	var cwidth = cell.offsetWidth;
	var fileInputWidth = 450;
	if(cwidth != null && cwidth < 400){
		fileInputWidth = 200;
	}
	cell.innerHTML= "<input type='file' id='attachFileMuti["+attachFileNumMuti+"]' attr="+tbr+" style='width:" + fileInputWidth + "px;' name='attachFileMuti["+attachFileNumMuti+"]' class='fileMuti' contentEditable='false'><input type='hidden' name='att' value='"+att1+"'>";
	attachFileNumMuti++;
	
}
var delFileMutiStr='';
function delFileMuti(delF) 
{
	if(delFileMutiStr.length<1){
		delFileMutiStr=delF;
	}else{
		delFileMutiStr=delFileMutiStr+'#'+delF;
	}
	document.getElementById('delFileMutiStr').Value=delFileMutiStr;
	alert(delFileMutiStr);
}
//删除附件
var delFileMutiStr='';
function delFile(attid,piid){
		 document.getElementById(attid).style.display = "none";
		 document.getElementById(attid + "IMG").style.display = "none";
		 //document.getElementById("content1").value=Sendid;

		 if(delFileMutiStr.length<1){
				delFileMutiStr=attid+'_'+piid;
			}else{
				delFileMutiStr=delFileMutiStr+'#'+attid+'_'+piid;
			}
			document.getElementById('delFileMutiStr').value=delFileMutiStr;
			//alert(delFileMutiStr);
}

//单附件删除
function singleFileDel(attid,piid,pidlabel){
	delFile(attid,piid);
	addSingleFileMuti(pidlabel);
}

function deleteitemMuti(obj,tbr)
{//alert(obj.value);
	var curRow= obj.parentNode.parentNode;
	eval(tbr).deleteRow(curRow.rowIndex);
	//eval(tbr).deleteRow(curRow.rowIndex);
}

//开始日期小于结束日期(带小时分)
function checkDateWithTimeShow(beginDateTextId,endDateTextId){
	var popentime = document.getElementById(beginDateTextId).value;
	var pclosetime = document.getElementById(endDateTextId).value;
	if("" == popentime || "" == pclosetime){
		return true;
	}
	var beginYear = popentime.split("/")[0];
	var closeYear = pclosetime.split("/")[0];
	var beginMonth = popentime.split("/")[1];
	var closeMonth = pclosetime.split("/")[1];
	var beginDay = popentime.split("/")[2].replace(/:/g,"").replace(" ","");
	var closeDay = pclosetime.split("/")[2].replace(/:/g,"").replace(" ","");
	
	if(Number(beginYear) == Number(closeYear)){
		if(Number(beginMonth) == Number(closeMonth)){
			if(Number(beginDay) >= Number(closeDay)){
				return false;
			}
		} else if (Number(beginMonth) > Number(closeMonth)){
			return false;
		}

	} else if(Number(beginYear) > Number(closeYear)){
		return false;
	}
	return true;
}

//开始日期小于或等于结束日期(带小时分)
function checkDateWithTimeShowForLE(beginDateTextId,endDateTextId){
	var popentime = document.getElementById(beginDateTextId).value;
	var pclosetime = document.getElementById(endDateTextId).value;
	if("" == popentime || "" == pclosetime){
		return true;
	}
	var beginYear = popentime.split("/")[0];
	var closeYear = pclosetime.split("/")[0];
	var beginMonth = popentime.split("/")[1];
	var closeMonth = pclosetime.split("/")[1];
	var beginDay = popentime.split("/")[2].replace(/:/g,"").replace(" ","");
	var closeDay = pclosetime.split("/")[2].replace(/:/g,"").replace(" ","");
	
	if(Number(beginYear) == Number(closeYear)){
		if(Number(beginMonth) == Number(closeMonth)){
			if(Number(beginDay) > Number(closeDay)){
				return false;
			}
		} else if (Number(beginMonth) > Number(closeMonth)){
			return false;
		}

	} else if(Number(beginYear) > Number(closeYear)){
		return false;
	}
	return true;
}

//判断元素是否重复
function isRepeat(elementName) {
	var elements = document.getElementsByName(elementName);
	var array = new Array(elements.length);
	for(var i = 0; i < elements.length; i++){
		array[i] = elements[i].value;
	}
	if(checkRepeat(array)){
		return true;
	}
}
function checkRepeat(obj) { 
    return /(\x0f[^\x0f]+)\x0f[\s\S]*\1/.test("\x0f"+ obj.join("\x0f\x0f") +"\x0f"); 
} 

function collapseAll(){
    var display = "";
    var className = "";
    if($("img").src.indexOf("close")>0){
    	display = "none";
    	className = "menutitle";
    	$("img").src="images/all_open.gif";
    	$("img").alt="\u5168\u90E8\u5C55\u5F00";
    }else{
    	display = "block";
	 	className = "menutitle1";
	 	$("img").src="images/all_close.gif";
	 	$("img").alt="\u5168\u90E8\u6298\u53E0";
    }
	 if(document.getElementById){
         var el = document.getElementById("masterdiv").getElementsByTagName("div"); //DynamicDrive.com change
             for (var i=0; i<el.length; i++){
                el[i].className = className;
             }
         var ar = document.getElementById("masterdiv").getElementsByTagName("span"); //DynamicDrive.com change
             for (var j=0; j<ar.length; j++){
                 if (ar[j].className=="submenu") //DynamicDrive.com change
                     ar[j].style.display = display;
             }
    }
}

function openRelatedIncident(prid,prtype){
	if(prtype=="S"){
		openSubWindow('/IGSVC0803_Disp.do?prid='+prid+'&prtype='+prtype, 'new','900','600');
	}else{
		openSubWindow('/IGSVC0203_Disp.do?prid='+prid+'&prtype='+prtype, 'new','900','600');
	}
		
}

function openRelatedProcess(prid,prtype){
	if(prtype=="S"){
		openSubWindow('/IGSVC0803_Disp.do?prid='+prid+'&prtype='+prtype, '_blank','900','650');
	} else if(prtype=="I"){
		openSubWindow('/IGSVC0203_Disp.do?prid='+prid+'&prtype='+prtype, '_blank','900','650');
	} else if(prtype=="P"){
		openSubWindow('/IGSVC0303_Disp.do?prid='+prid+'&prtype='+prtype, '_blank','900','650');
	} else if(prtype=="C" ){
		openSubWindow('/IGSVC0403_Disp.do?prid='+prid+'&prtype='+prtype, '_blank','900','650');
	} else if(prtype=="D" ){
		openSubWindow('/IGSVC0503_Disp.do?prid='+prid+'&prtype='+prtype, '_blank','900','650');
	} else if(prtype=="WA"){
		openSubWindow('/IGEXTWA0103_Disp.do?prid='+prid+'&prtype='+prtype, '_blank','900','650');
	} else if(prtype=="WB"){
		openSubWindow('/IGEXTWB0103_Disp.do?prid='+prid+'&prtype='+prtype, '_blank','900','650');
	} else if(prtype=="WD"){
		openSubWindow('/IGPRR0112_Disp.do?prid='+prid, '_blank','1100','650');
	} else if(prtype=="SF") {
		openSubWindow('/IGSVC1004_Open.do?sfid='+prid, '_blank','900','650');
	} else if(prtype=="WS"){
		openSubWindow('/IGSVC1103_Disp.do?prid='+prid+'&prtype='+prtype, '_blank','900','650');
	} else if(prtype=="GD"){
		openSubWindow('/IGSVC1004_Disp.do?sfid='+prid+'&tempFlag=yes', '_blank','900','650');
	}else {
		openSubWindow('/IGPRR0112_Disp.do?prid='+prid, '_blank','900','650');
	}
}

function openRelatedProcessAssessment(prid,prtype,assessmentstatus,prtitle){
	if(prtype=="I"){
		doLook('IGSVC0230_Goto.do?prid='+prid+'&prtype='+prtype +'&assessmentstatus='+assessmentstatus );
	} else if(prtype=="P"){
		doLook('IGSVC0330_Goto.do?prid='+prid+'&prtype='+prtype +'&assessmentstatus='+assessmentstatus );
	} else if(prtype=="C" ){
		doLook('IGSVC0435_Goto.do?prid='+prid+'&prtype='+prtype +'&assessmentstatus='+assessmentstatus );
	} else if(prtype=="D" ){
		doLook('IGSVC0230_Goto.do?prid='+prid+'&prtype='+prtype +'&assessmentstatus='+assessmentstatus );
	} 
}

function openKnowledgeByKnid(knid, knversion){
	openSubWindow("/IGKGM0215_Detail.do?knid=" + knid + "&knversion=" + knversion,"Knowledge","1000","600");
}

function openRelatedProblem(prid,prtype){
	openSubWindow('/IGSVC0303_Disp.do?prid='+prid+'&prtype='+prtype, 'new','900','600');
}
function openHistoryPage(url){
	openSubWindow(url, '_blank','1000','600');
}

/*
调用resetText清空文本框
，resetSelect选种option的第一个元素。
*/
function resetElements()
{
	resetText();
	resetSelect();
}
	
	
/*
把页面里所有在form标记中的，input组件的type="text"的值，清空。
*/
function resetText()
{
	
	for(var fi = 0;fi<document.forms.length;fi++)
	{
	var el = document.forms[fi].elements;

		for(var i = 0;i<el.length;i++)
		{
			//alert(el[i].type);
			if(el[i].type=="text")
			{
				el[i].value = "";
			}
			if(el[i].type=="textarea")
			{
				el[i].value = "";
			}
		}
	}
}
/*
选中页面里所有在form标记中的，select组件的第一个元素。
*/
function resetSelect()
{
//	alert(document.forms.length);
	for(var fi = 0;fi<document.forms.length;fi++)
	{
		var el = document.forms[fi].elements;
//		alert(el.length);
		for(var i = 0;i<el.length;i++)
		{
//			alert(el[i].type);
			if(el[i].type=="select-one")
			{
//				el[i].value = "4";
//				alert(el[i].options.length);
//				alert(el[i].options[0].selected);
				if(el[i].options.length>0)
					el[i].options[0].click();
					el[i].options[0].selected=true;
			}
		}
	}
}

//currentDate must be between beginDate and endDate
function isBetweenDate(beginDate,currentDate,endDate){
	var beginYear = beginDate.split("/")[0];
	var currentYear = currentDate.split("/")[0];
	var closeYear = endDate.split("/")[0];
	
	var beginMonth = beginDate.split("/")[1];
	var currentMonth = currentDate.split("/")[1];
	var closeMonth = endDate.split("/")[1];
	
	var beginDay = beginDate.split("/")[2];
	var currentDay = currentDate.split("/")[2];
	var closeDay = endDate.split("/")[2];
	
	if(Number(currentYear) > Number(beginYear) && Number(currentYear) < Number(closeYear)){
		return true;
	} else if (Number(currentYear) == Number(beginYear) && Number(currentYear) == Number(closeYear)) {
		if(Number(currentMonth) > Number(beginMonth) && Number(currentMonth) < Number(closeMonth)){
			return true;
		} else if (Number(currentMonth) == Number(beginMonth) && Number(currentMonth) == Number(closeMonth)){
			if(Number(currentDay) >= Number(beginDay) && Number(currentDay) <= Number(closeDay)){
				return true;
			}
		} else if (Number(currentMonth) == Number(beginMonth) && Number(currentMonth) < Number(closeMonth)){
			if(Number(currentDay) >= Number(beginDay)){
				return true;
			}
		} else if (Number(currentMonth) == Number(closeMonth) && Number(currentMonth) > Number(beginMonth)){
			if(Number(currentDay) <= Number(closeDay)){
				return true;
			}
		}
	} else if (Number(currentYear) == Number(beginYear) && Number(currentYear) < Number(closeYear)) {
		if(Number(currentMonth) > Number(beginMonth)){
			return true;
		} else if (Number(currentMonth) == Number(beginMonth)){
			if(Number(currentDay) >= Number(beginDay)){
				return true;
			}
		}
	} else if (Number(currentYear) == Number(closeYear) && Number(currentYear) > Number(beginYear)) {
		if(Number(currentMonth) < Number(closeMonth)){
			return true;
		} else if (Number(currentMonth) == Number(closeMonth)){
			if(Number(currentDay) <= Number(closeDay)){
				return true;
			}
		}
	}
	return false;
}

//查看
function doLook(url){
	window.location=url;
}

function mouseOver(obj){
	if(obj.bgColor == ""){
		obj.className="table_hover";
	}
}

function mouseOut(obj,name){
	if(obj.bgColor == ""){
		obj.className=name;
	}
}

function mouseOverNoHand(obj){
	obj.style.backgroundColor='#F8F8F8';
}

function mouseOutNoHand(obj){
	obj.style.backgroundColor='';
}

function isEmail(str)  
{   
	var reg = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;   
	return reg.test(str);  
} 

function isTel(s)
{
	var patrn=/^[+]{0,1}(\d){1,3}[ ]?([-]?((\d)|[ ]){1,12})+$/;
	return patrn.exec(s);
} 


/***check string byte*****/
var strByteFlag = 3;
String.prototype.strlen = function(){ 
	var text=this.replace(/[^\x00-\xff]/g,"***");
	 return text.length;
};

/***entityitemrelation***/
function openSubIGCOM0305(eiid){
	openSubWindow('/IGCOM0305.do?eiid='+eiid,null,'400','500');
}

function stringReplaceAll(str,AFindText,ARepText){
raRegExp = new RegExp(AFindText,"g");
return str.replace(raRegExp,ARepText);
}


/***use in select entityitem by relation ***/
function  getRelationEcategory(eirrelationcode,ecategory){
	var key = eirrelationcode.split("-")[0];
	var tempKey = eirrelationcode;
	if("-" != stringReplaceAll(eirrelationcode,ecategory, "")){
		tempKey = stringReplaceAll(tempKey,ecategory,"");
		key = stringReplaceAll(tempKey,"-","");
	}
	return key;
}

/**
 * 校验所填是否为正数或正浮点数
 * @author duchong
 */
function fIsNumber(str){
	myReg = /^[0-9]+[\.]?[0-9]{0,}$/;

	return myReg.test(str);
}
 /**
  * 校验所填是否为正整数
  * @author duchong
  */
 function checkIsNumber(str){
 	myReg = /^[1-9][0-9]{0,}$/;

 	return myReg.test(str);
 }
 /**
  * 获得字符串的字节长度。英文长度1，中文和全角标点长度2
  * @author duchong
  */
 function getByteLen(str){
	  var text=str.replace(/[^\x00-\xff]/g,"**");
	  return text.length;
}
 var screenWidth =  window.screen.width;


/**
 * 预支费用登记使用，允许输入浮点数
 */
function checkFloatNumForYZ(obj,name,mess){
	if(obj.value!=""){
		if(isNaN(obj.value)){
			alert(mess);
			obj.value = "";
			obj.focus();
			event.returnValue = false;
		}else if(!checkFloatNumberForYZ(obj.value)){
			alert(name);
			obj.value = "";
			obj.focus();
			event.returnValue = false;
		}
	}
}

function checkFloatNumberForYZ(str){
 	myReg = /^-?[0-9]{0,10}(\.[0-9]{0,2})?$/;
 	return myReg.test(str);
}



function checkFloatNum(obj,name,mess){
	if(obj.value!=""){
		if(isNaN(obj.value)){
			alert(mess);
			obj.value = "";
			obj.focus();
			event.returnValue = false;
		}else if(!checkFloatNumber(obj.value)){
			alert(name);
			obj.value = "";
			obj.focus();
			event.returnValue = false;
		}
	}
}

function checkFloatNumber(str){
 	myReg = /^[0-9]{0,10}(\.[0-9]{0,2})?$/;
 	return myReg.test(str);
}

function checkIntegerNumber(obj,name,mess){
	if(obj.value!=""){
		
	
		if(!checkIntegerNum(obj.value)){
			alert(name);
			obj.value = "";
			obj.focus();
			event.returnValue = false;
	  }
	}
}

function checkIntegerNum(str){
	myReg = /^[1-9][0-9]{0,2}?$/;
	return myReg.test(str);
}

/**
* 流程快捷发起
*	prid：流程ID
*	prtype：流程类型
*	url：需要刷新的父页url
*/
function initProcessQuick(prid, prtype, url){
	window.showModalDialog(getAppRootUrl() + "/IGPRM0003.do?prid=" + prid + "&prtype=" + prtype,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	window.location.href = url;
}

/**
* 服务工单快捷发起流程
*	prid：流程ID
*	prtype：流程类型
*	url：需要刷新的父页url
*/
function initServiceProcessQuick(prid, prtype, url){
	window.showModalDialog(getAppRootUrl() + "/IGPRM0004.do?prid=" + prid + "&prtype=" + prtype,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if('' != url) {
		window.location.href = url;
	}
}

/**
 * 版本比较弹出画面
 * @param eiid 资产ID
 */
function openEiVersionWindow(eiid){
	openSubWindow('/IGCOM0307.do?eiid=' + eiid + '&screenWidth='+window.screen.width, 'eiversion',window.screen.width,window.screen.height);
}
 
 /**
  * 版本比较弹出画面
  * @param eiid 资产ID
  */
 function openEiVersionWindow_SOC(eiid){
 	openSubWindow('/IGAIM1204.do?eiid=' + eiid + '&screenWidth='+window.screen.width, 'eiversion',window.screen.width,window.screen.height);
 }
 
/**
 * 配置信息历史记录弹出画面
 * @param eiid 资产ID
 * @param civersion 资产大版本号
 * @param cismallversion 资产小版本号
 */
function openVersionInfoDetail(eiid, civersion, cismallversion){
	openSubWindow( '/IGCOM0308_DISP.do?eiid='+ eiid + '&civersion=' + civersion +'&cismallversion=' + cismallversion,"versioninfo","800","600");
}
 
 /**
  * 配置信息历史记录弹出画面
  * @param eiid 资产ID
  * @param civersion 资产大版本号
  * @param cismallversion 资产小版本号
  */
 function openVersionInfoDetail_SOC(eiid, civersion, cismallversion){
 	openSubWindow( '/IGAIM1203_DISP.do?eiid='+ eiid + '&civersion=' + civersion +'&cismallversion=' + cismallversion,"versioninfo","800","600");
 }
 
 /**
 * 报表预览
 *	rfdfilename：文件名
 *	rfdversion：当前版本
 */
 function preview_report(rfdfilename,rfdversion,rfdid){
	 //openSubWindow( '/IGSYM1406_Disp.do?rfdfilename=' + rfdfilename + '&rfdversion=' + rfdversion,'统计分析','800','600');
	/// openSubWindow('/IGSYM1406_Disp.do?rfdfilename=' + rfdfilename + '&rfdversion=' + rfdversion + '&rfdid=' + rfdid, '_blank',window.screen.width,window.screen.height);
	 
	var uri =  '/IGSYM1406_Disp.do?rfdfilename=' + rfdfilename + '&rfdversion=' + rfdversion + '&rfdid=' + rfdid;
	OpenWindow = window.open(getAppRootUrl() + uri, '_blank', 'width='+ window.screen.width + ',height=' + window.screen.height + ',scrollbars=yes,resizable=yes,status=no,top='+0+',left='+0+',');
	lazyLoad();
	 //window.showModalDialog(getAppRootUrl() + "/IGSYM1406_Disp.do?rfdfilename=" + rfdfilename + "&rfdversion=" + rfdversion,null,"dialogWidth:1000px;dialogHeight:800px;status:no;help:no;resizable:yes");
	}
 function lazyLoad(){
	 try{
			OpenWindow.document.title = "report";
			
		}catch(err){
			setTimeout("lazyLoad()", 200);	
		}
 }
 function checkFloatNum(value){
	if(value!=""){
		if(isNaN(value)){
			value = "";
			return true;
		}else if(!checkFloatNumberCtr(value)){
			value = "";
			return true;
		}else{
			return false;
		}
	}else{
		return false;
	}
}

function checkFloatNumberCtr(str){
 	myReg = /^-{0,1}[0-9]{1,13}(\.[0-9]{1,2})?$/;
 	return myReg.test(str);
}

/**
 * 显示/隐藏页面元素
 */
function toggleElement(value,img, imgStyle) {
	
	Element.toggle(value); 
	
	if(img) {
		if(imgStyle == "1") {
			if($(img).readAttribute("src") == 'images/plus.gif'){
				$(img).src = "images/minus.gif";
			}else{
				$(img).src = "images/plus.gif";
			}
		} else {
			if($(img).readAttribute("src") == 'images/add_1.jpg'){
				$(img).src = "images/sub_1.jpg";
			}else{
				$(img).src = "images/add_1.jpg";
			}
		}
	}
	
}

/**
 * 密码长度在6-16之间，只能包含字母、数字和下划线 
 */
function checkPassword(str) {
	var patrn = /^\w{6,16}$/;    
	if (!patrn.test(str)){
		return true;
	}else{
		return false;  
	} 
}

function openIntegrationWindow(uri, wName, width, height){
//	if(uri.indexOf("http") == -1) {
//		uri = getAppRootUrl() + uri;
//	}
//	if(width && height) {
//		var iTop = (window.screen.availHeight-30-width)/2;       //获得窗口的垂直位置;
//		var iLeft = (window.screen.availWidth-10-height)/2;           //获得窗口的水平位置;
//		window.open(uri, wName, 'width='+ width + ',height=' + height + ',scrollbars=yes,resizable=yes,status=yes,top='+iTop+',left='+iLeft+',').focus();
//	} else {
//		window.open(uri, wName, 'width=1024,height=768,scrollbars=yes,resizable=yes,status=yes').focus();
//	}
	openSubWindow(uri, wName, width||1020, height||720);
}
//采集查询时，点击命令弹出详细信息。
/**
 * 版本比较弹出画面
 * @param eiid 资产ID
 */
function openCollectCommandDetail(keys,collecttime,tablename,host,type,ip){
	var keyValue=document.getElementById(""+keys).value; 
	openSubWindow('/IGCIM0112_Search.do?keys='+keyValue+'&collecttime='+collecttime+'&tablename='+tablename+'&host='+host+'&type='+type+'&ip='+ip, '_blank', window.screen.width,window.screen.height);
	//openSubWindow('/IGCIM0112_Search.do?keys=' + keys + '&screenWidth='+window.screen.width, 'eiversion',window.screen.width,window.screen.height);
}
function editDivContent(obj){
//	if(window.event.keyCode==13){ 
//		var value = obj.innerHTML;
//		if(value != ""){
//			value = value.replace(/<P>/g,""); 
//			value = value.replace(/<\/P>/g,"<br>");
//			obj.innerHTML = value;
//		}
//	}else 
	if(window.event.keyCode==8){
		//覆盖document的onkeydown事件
		if(window.event.stopPropagation){
			window.event.stopPropagation();
		}else{
			window.event.cancelBubble = true;
		}
	}
	

	
}
function getEditDivValue(obj,index){
	document.getElementById("pivarvalue[" + index + "]").value =  getEditValue(obj).replace(/<[^<>]+?>/g,'').replace(/\r/g,"<br>");
}
function getProcessDescValue(obj){
	document.getElementById("prdesc").value = getEditValue(obj);
}
function getProcessRlcommentValue(obj){
	document.getElementById("rlcomment").value = getEditValue(obj);
}
function getEditValue(obj){
	var value = obj.innerHTML;
	value = value.replace(/<\/P>/g,"_#_");
    value = value.replace(/<[^>]+>/g,"");
    while(value.indexOf("_#_") >= 0){
    	value = value.replace("_#_","\r");
    }
    return value;
}

function screenLayer(){
 	var el = document.getElementsByTagName("input");

		for(var i = 0;i<el.length;i++)
		{
			if(el[i].type=="button" || el[i].type=="submit" || el[i].type=="reset")
			{
				el[i].disabled=true;
			}
		}
		try
		{
			//显示请等候的DIV
			var bodyel = document.getElementsByTagName("body");
			bodyel[0].innerHTML +="<div id=\"disableAllButtonWaitDIV\" class=\"layer\"><div><div><img src=\"images/loding.gif\" /><br />\u64cd\u4f5c\u6267\u884c\u4e2d\uff0c\u8bf7\u60a8\u4e0d\u8981\u8fdb\u884c\u5176\u5b83\u64cd\u4f5c\uff0c\u8010\u5fc3\u7b49\u5019...<br><br></div></div><iframe src=\"javascript:false\" style=\"position:absolute; visibility:inherit; top:0px; left:0px; width:100%; height:100%; z-index:-2; filter='progid:DXImageTransform.Microsoft.Alpha(style=0,opacity=0)';\"></iframe></div>";

		}catch(ex)
		{
			//由于这不是一个主要功能所以隐藏这个异常
			//alert("函数发生异常。\n异常内容为:"+ex.description+"\n错误号："+ex.number); 
			//throw ex;
		}

 }

function isIP(strIP) { 
    var re=/^(\d+)\.(\d+)\.(\d+)\.(\d+)$/g;
    if(re.test(strIP)) 
    { 
       if( RegExp.$1 <256 && RegExp.$2<256 && RegExp.$3<256 && RegExp.$4<256) 
    	   return true; 
    } 
   return false; 
}
function openSubIGASM1109(eiid,jitype){
//	param = $H({eiid: eiid,jitype:jitype}).toQueryString();
	openSubWindow('/IGASM1114_Flex_Disp.do?jitype='+ jitype +'&eiid='+eiid, '', '800', '600');
}
String.prototype.trim = function(){return this.replace(/(^\s*)|(\s*$)/g,"");};
function isFunctionKey(keyCode){
	if(keyCode == 8
			|| keyCode == 9
			|| keyCode == 13){
		return true;
	}else{
		return false;
	}
}
function isNumberKeyCode(keyCode){
	if(keyCode < 58 && keyCode > 47){
		return true;
	}else if(keyCode > 95 && keyCode < 106){
		return true;
	}else{
		return false;
	}
}
/**
 * 数字校验
 * @returns 非法格式返回false  正确格式返回true
 */
function columnValueNumber(){
	//获取事件对象
	var e = event || window.event;
	//阻止冒泡
	if (window.event) {
		e.cancelBubble = true;
	} else {
		e.stopPropagation();
	} 
	//判断是否按下了shift键，如果是，本次无效
	if(e.shiftKey){
		return false;
	}
	//获取事件源对象
	var target = e.target || window.event.srcElement;
	//无伤害按钮，无视
	if(isFunctionKey(e.keyCode)){
		return true;
	}
	// 对于"-"的处理方式
	else if(e.keyCode == 189 || e.keyCode == 109){
		// 1"-"只能出现在首位
		if(target.value){
			return false;
		}
		// 2非负数出现"-"视为非法格式
		if(target.flag && target.flag == "2"){
			return false;
		}
	
	}
 	else if (target.value != "" && target.value == "0") {
		if (e.keyCode == 48) {
			return false;
		} else if (target.value.length == 1 && e.keyCode != 190
				&& e.keyCode != 110) {
			target.value = "";

		}
	}
	//对于首位 0 的处理
//	else if(e.keyCode == 48){
//		// 0只能出现在首位
//		if(target.value!=""&&target.value==0){
//			return false;
//		}
//		//如果小数位数为零，首位不允许出现
////		if(target.value == "" && (target.decimals == "" || target.decimals == "0")){
////			return false;
////		}
//	}
	//对于 "." 的处理类方式
	else if(e.keyCode == 190 || e.keyCode == 110){
		if(target.value==""){
			return false;
		}
		
		// 1 不允许出现第二个 "."
		if(target.value && target.value.indexOf(".") >= 0){
			return false;
		}
		// 2 整数不允许出现 "."
//		if(target.flag && (target.flag == "1" || target.flag == "2")){
//			return false;
//		}
		//2.小数位数为零，不允许出现小数点
		if(target.decimals == "" || target.decimals == "0"){
			return false;
		}
	}
	//其他处理规则：数字按格式校验；非数字视为非法字符
	else if(isNumberKeyCode(e.keyCode)){
		//数字的处理规则：如果出现 "."，控制"."后数字位数
		if(target.value && target.value.indexOf(".") >= 0){
			//取得小数位数
			var decimals = target.decimals;
			var str = target.value.substring(target.value.indexOf(".") + 1,target.value.length);
//			console.log(str);
			if(str && str.length >= decimals){
				return false;
			}else{
				return true;
			}
		}
	}else{
		return false;
	}
	return true;
}
function getCurrentDate(){
	var d = new Date();
	var vYear = d.getFullYear();
	var vMon = d.getMonth() + 1;
	var vDay = d.getDate();
	return vYear + "/" + (vMon < 10 ? "0" + vMon : vMon) + "/" + (vDay < 10 ? "0" + vDay : vDay);
}