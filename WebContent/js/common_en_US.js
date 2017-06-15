var enableEnterJump = true;
var oneTimeNotJump  = true;
var ajaxAction = "/ajax.do";

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
		       document.activeElement.type.toLowerCase() == "textarea")){
			}else{
			   event.keyCode = 0x09;
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

		for(i=0; i < document.forms[frmno].length; i=i+1)
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
	for(i=0;i<document.forms.length;i++){
		for(i2=0;i2<document.forms[i].elements.length;i2++){
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
	for(i=0;i<document.forms.length;i++){
		for(j=0;j<document.forms[i].elements.length;j++){
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

// 
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

function execAjax(type, urlParam, updateId){

	// xmlHttpRequest
	// 

	if(updateId == null || updateId == ""){
		// 
		var objAjax = new Ajax.Request(
			getAppRootUrl() + ajaxAction,
			{ parameters: urlParam + '&type=' + type}
			);
	}else{
		var objAjax = new Ajax.Updater(
			updateId,
			getAppRootUrl() + ajaxAction,
			{ parameters: urlParam + '&type=' + type ,onSuccess:  function(req, json){onComplete(req, json, updateId)} }
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

	window.open(getAppRootUrl() + uri, wName, 'width='+ width + ',height=' + height + ',scrollbars=yes,resizable=yes,status=yes,top='+iTop+',left='+iLeft+',').focus();
}

function openSubIGCOM0301(enable,ecategory){
	var param = "";
	param = $H({enable: enable, ecategory: ecategory}).toQueryString();
	openSubWindow('/IGCOM0301_Disp.do?' + param , '_blank', '800', '600');
}

function openSubIGCOM0302(){
	openSubWindow('/IGCOM0302_Disp.do' , '_blank', '850', '600');
}

function openSubIGAIM0146(eirootmark, eiid, eiversion, eismallversion){
	var queryParam = $H({eirootmark:eirootmark, eiid:eiid, eiversion:eiversion, eismallversion:eismallversion}).toQueryString();
	openSubWindow('/IGAIM0146_Disp.do?' + queryParam, 'IGAIM0146', '850', '800');
}

function openSubIGCIM0149(eirootmark, eiid, eiversion, eismallversion){
	var queryParam = $H({eirootmark:eirootmark, eiid:eiid, eiversion:eiversion, eismallversion:eismallversion}).toQueryString();
	openSubWindow('/IGCIM0149_Disp.do?' + queryParam, 'IGCIM0149', '1000', '800');
}

function openSubIGCIM0137(eiid){
	var queryParam = $H({eiid:eiid}).toQueryString();
	openSubWindow('/IGCIM0137_Disp.do?' + queryParam, 'IGCIM0137', '1024', '800');
}

function openSubIGSYM0306(pdid){
	openSubWindow('/IGSYM0306_Disp.do?pdid='+pdid , '_blank', '850', '600');
}

function openSubIGSYM1108(){
	openSubWindow('//IGSYM1108_Disp.do' , '_blank', '850', '600');
}

function openSubIGCOM0302PARAM(param){
	openSubWindow('/IGCOM0302_Disp.do'+param , '_blank', '850', '600');
}

function openSubIGASM1104(eiid){
	openSubWindow('/IGASM1104_Disp.do?eiid='+eiid, '_blank', '800', '600');
}

function openSubIGASM1105(cur_room_eiid,cur_room_x_value,cur_room_y_value){
	param = $H({cur_room_eiid: cur_room_eiid,cur_room_x_value:cur_room_x_value,
		cur_room_y_value:cur_room_y_value}).toQueryString();
	openSubWindow('/IGASM1105_Disp.do?' + param, '_blank', '800', '600');
}

function openSubIGASM1114(eiid){
	param = $H({eiid: eiid}).toQueryString();
	openSubWindow('/IGASM1114_Disp.do?' + param, '_blank', '800', '600');
}

function openSubIGASM1115(cur_container_eiid,cur_container_u_value){
	param = $H({cur_container_eiid: cur_container_eiid,
		cur_container_u_value:cur_container_u_value}).toQueryString();
	openSubWindow('/IGASM1115_Disp.do?' + param, '_blank', '800', '600');
}

function openSubIGASM1116(eiid,civersion){
	param = $H({eiid: eiid,civersion:civersion}).toQueryString();
	openSubWindow('/IGASM1116_Disp.do?' + param, '_blank', '800', '600');
}

function openSubIGCOM0303(eiid,civersion){
	param = $H({eiid: eiid,civersion:civersion}).toQueryString();
	openSubWindow('/IGCOM0303_Disp.do?' + param, '_blank', '800', '600');
}
function openSubIGCOM0316(eiid,civersion,eismallversion){
	param = $H({eiid: eiid, civersion:civersion, cismallversion:eismallversion}).toQueryString();
	openSubWindow('/IGCOM0316_Disp.do?' + param, '_blank', '800', '600');
}
function openSubIGCOM0303_Relation(eiid,civersion){
	param = $H({eiid: eiid,civersion:civersion}).toQueryString();
	openSubWindow('/IGCOM0303_Relation.do?' + param + '&screenWidth='+window.screen.width, '_blank', '800', '600');
}
function openSubIGCOM0318_Relation(srpareiid_eq,srdomainid_eq,srdomainversion_eq,srparversion_eq,srparsmallversion_eq,srcreatetime_eq){
	param = $H({srpareiid_eq:srpareiid_eq,srdomainid_eq:srdomainid_eq,srdomainversion_eq:srdomainversion_eq,srparversion_eq:srparversion_eq,srparsmallversion_eq:srparsmallversion_eq,srcreatetime_eq:srcreatetime_eq}).toQueryString();
	openSubWindow('/IGCOM0318_Relation.do?' + param + '&screenWidth='+window.screen.width, '_blank', '850', '800');
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

function openSubIGASM0346(eirootmark, eiid, eiversion, eismallversion,flag){
	var queryParam = $H({eirootmark:eirootmark, eiid:eiid, eiversion:eiversion, eismallversion:eismallversion,flag:flag}).toQueryString();
	openSubWindow('/IGASM0346_Disp.do?' + queryParam, 'IGASM0346', '800', '600');
}

function downloadASMFile(eiid, ciid){

	var param = "";
	var type = "asm";
	param = $H({type: type, eiid: eiid, ciid:ciid}).toQueryString();
	openSubWindow('/download.do?' + param, '_blank','800','600');
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
function openSubIGCOM0310(eiid, domainid, domainversion, updatetime,diskeiid){
	var params = $H({eiid: eiid, domainid:domainid, domainversion:domainversion, updatetime:updatetime,diskeiid:diskeiid}).toQueryString();
	openSubWindow('/IGCOM0310.do?' + params,'_blank','850','800');
}

function openSubIGCOM0321(eiid, domainid, domainversion, updatetime){
	var params = $H({eiid: eiid, domainid:domainid, domainversion:domainversion, updatetime:updatetime}).toQueryString();
	openSubWindow('/IGCOM0321.do?' + params,'_blank','800','600');
}

function openSubIGCOM0324(eiid, domainid, domainversion, updatetime){
	var params = $H({eiid: eiid, domainid:domainid, domainversion:domainversion, updatetime:updatetime}).toQueryString();
	openSubWindow('/IGCOM0324.do?' + params, '_blank', '800', '600');
}

function openSubIGCOM2108(eiid){
	openSubWindow('/IGCOM2108_Incidence.do?eiid='+eiid+'&screenWidth='+window.screen.width,'_blank','800','600');
}

function openSubIGCOM0309(parmStr,srpareiid_eq,srname){
	openSubWindow('/IGCOM0309_Filter_Disp.do?attrName='+parmStr+'&srpareiid_eq='+srpareiid_eq+'&srname='+srname,'_blank','800','600');
}

function openSubIGCOM0313(parmStr,eiid){
	openSubWindow('/IGCOM0313_Filter_Disp.do?attrName='+parmStr+'&eiid='+eiid,'_blank','800','600');
}

function openSubIGCOM0309Show(eiid){
	openSubWindow('/IGCOM0303_Relation_show.do?eiid='+eiid+'&screenWidth='+window.screen.width,'_blank','900','400');
}

function openSubIGPRR0106(rlid){
	openSubWindow('/IGPRR0106_Disp.do?rlid='+rlid,'_blank','800','600');
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
	if(document.activeElement.type != null){
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
	} )
	
	if(!bl)
		alert('');
	
	return bl;
}

//
function requiredSubCheck(){
	return true;
}

//
function clearErrorClass(id){
	if (Element.hasClassName($(id), "inputError")) 
		Element.removeClassName($(id), "inputError")
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
	cell.innerHTML= "<input type='file' name='attachFile["+attachFileNum+"]' class='inputbutton' contentEditable='false'><input type='button' class='delbutton' value='delete' onclick='deleteitem(this)'>";
	attachFileNum++;
}
var attachFileNumMuti=0;
//var att=new Array();
function addFileMuti(tbr) 
{
	var att1=tbr+"_"+attachFileNumMuti;
	currRow=eval(tbr).insertRow();
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='file' name='attachFileMuti["+attachFileNumMuti+"]'  style='width:270px;height:25px;color:#000000;font-size:12px;cursor:pointer;border:#333333 solid 1px;' contentEditable='false'><input type='button' style='width:65px;height:25px;color:#000000;font-size:12px;cursor:pointer;border:#333333 solid 1px;' value='delete' onclick='deleteitemMuti(this,"+tbr+")'><input type='hidden' name='att' value='"+att1+"'>";
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
function deleteitem(obj)
{
	var curRow= obj.parentNode.parentNode;
	tb.deleteRow(curRow.rowIndex);
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

//创建隐藏表单
function   createHiddenInputForm(name,value,formid){   
    var inputElement=document.createElement("input");   
    inputElement.name=name;   
    inputElement.value=value;     
    inputElement.type="hidden";
    inputElement.id=name;
    formid.appendChild(inputElement);   
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
	} else if(prtype=="C" || prtype=="D" || prtype=="WA" || prtype=="WB"){
		openSubWindow('/IGSVC0605.do?prid='+prid+'&type='+prtype, '_blank','900','650');
	} else if(prtype=="WD"){
		openSubWindow('/IGPRR0105.do?prid='+prid+'&prtype=ID', '_blank','900','650');
	} else if(prtype=="SF") {
		openSubWindow('/IGSVC1004_Open.do?sfid='+prid, '_blank','900','650');
	} else if(prtype=="ID") {
		openSubWindow('/IGPRR0105.do?prid='+prid+'&prtype=ID', '_blank','900','650');
	} else if(prtype=="CD") {
		openSubWindow('/IGPRR0105.do?prid='+prid+'&prtype=CD', '_blank','900','650');
	}
}

function openProcess(prid,prtype){
	if(prtype=="ID") {
		openSubWindow('/IGPRR0112_Disp.do?prid='+prid+'&prtype=ID', '_blank','1000','650');
	} else if(prtype=="CD") {
		openSubWindow('/IGPRR0112_Disp.do?prid='+prid+'&prtype=CD', '_blank','1000','650');
	}
}


function openRelatedProblem(prid,prtype){
	openSubWindow('/IGSVC0303_Disp.do?prid='+prid+'&prtype='+prtype, 'new','900','600');
}
function openHistoryPage(url){
	openSubWindow(url, '_blank','1024','600');
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
function doLookParent(url){
	window.parent.open(url);
}
function doLookOpen(url,urlparent){
	window.showModalDialog(url,null,"dialogWidth:1024px;dialogHeight:650px;status:no;help:no;resizable:yes");		
	window.parent.resetSVC0111();
	//刷新父窗口的子窗口
	window.parent.resetPortal0103();
	
}
function doLookOpenTab(url,urlparent,name){
	//window.showModalDialog(url,null,"dialogWidth:1024px;dialogHeight:650px;status:no;help:no;resizable:yes");
	var width = "1100";
	var height= "600";
	var iTop = (window.screen.availHeight-30-width)/2;       //获得窗口的垂直位置;
	var iLeft = (window.screen.availWidth-10-height)/2;           //获得窗口的水平位置;
	window.open(url, "_blank", 'width='+ width + ',height=' + height + ',scrollbars=yes,resizable=yes,status=yes,top='+iTop+',left='+iLeft+',').focus();
	
	//window.location = urlparent+'?srname='+name;
	//刷新父窗口的子窗口
	window.parent.resetPortal0103();
}

function mouseOver(obj){
	obj.className="table_hover";
}

function mouseOut(obj,name){
	obj.className=name;
}

function mouseOverNoHand(obj){
	obj.style.backgroundColor='#F8F8F8'
}

function mouseOutNoHand(obj){
	obj.style.backgroundColor=''
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
}

/***entityitem detail***/
function openSubIGCOM0305(eiid){
	openSubWindow('/IGCOM0305.do?eiid='+eiid,null,'800','600');
}

function stringReplaceAll(str,AFindText,ARepText){
raRegExp = new RegExp(AFindText,"g");
return str.replace(raRegExp,ARepText)
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
function printBRByScreenWidth(){
	if(screenWidth <= 1024){
		document.write("<br />");
	}
}


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
	var obj = window.showModalDialog(getAppRootUrl() + "/IGPRM0003.do?prid=" + prid + "&prtype=" + prtype,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	form.action = getAppRootUrl() + url;
	form.submit();
}

/**
* 服务工单快捷发起流程
*	prid：流程ID
*	prtype：流程类型
*	url：需要刷新的父页url
*/
function initServiceProcessQuick(prid, prtype, url){
	var obj = window.showModalDialog(getAppRootUrl() + "/IGPRM0004.do?prid=" + prid + "&prtype=" + prtype,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if('' != url) {
		form.action = getAppRootUrl() + url;
		form.submit();
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
  * 配置信息历史记录弹出画面
  * @param eiid 资产ID
  * @param civersion 资产大版本号
  * @param cismallversion 资产小版本号
  */
 function openVersionInfoDetail(eiid, civersion, cismallversion){
 	openSubWindow( '/IGCOM0308_DISP.do?eiid='+ eiid + '&civersion=' + civersion +'&cismallversion=' + cismallversion,"versioninfo","800","600");
 }
 
 /**
  * 报表预览
  *	rfdfilename：文件名
  *	rfdversion：当前版本
  */
  function preview_report(rfdfilename,rfdversion,rfdid){
 	 
 	 openSubWindow('/IGSYM1406_Disp.do?rfdfilename=' + rfdfilename + '&rfdversion=' + rfdversion + '&rfdid=' + rfdid, '_blank','800','600');

 	 //window.showModalDialog(getAppRootUrl() + "/IGSYM1406_Disp.do?rfdfilename=" + rfdfilename + "&rfdversion=" + rfdversion,null,"dialogWidth:1000px;dialogHeight:800px;status:no;help:no;resizable:yes");
 	}
  function checkFloatNum(value){
		if(value!=""){
			if(isNaN(value)){
				value = "";
				return true;
			}else if(!checkNumber(value)){
				value = "";
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}
  function checkNumber(str){
	 	myReg = /^-{0,1}[0-9]{1,13}(\.[0-9]{1,2})?$/;
	 	return myReg.test(str);
	}
  /**
   * 报表历史生成内容查看
   *	rfdfilename：文件名
   *	rfdversion：当前版本
   */
   function hg_report(rfdfilename,rfdversion,rfdid){
  	 
  	 openSubWindow('/IGCOM0216.do?rfdfilename=' + rfdfilename + '&rfdversion=' + rfdversion + '&rfdid=' +rfdid, '_blank','800','600');

  	 // window.showModalDialog(getAppRootUrl() +
		// "/IGSYM1406_Disp.do?rfdfilename=" + rfdfilename + "&rfdversion=" +
		// rfdversion,null,"dialogWidth:1000px;dialogHeight:800px;status:no;help:no;resizable:yes");
  	}
   function hg_report2(rfdfilename,rfdversion,rfdid){
	  	 
	  	 openSubWindow('/IGCOM0216_J.do?&rfdid='+rfdid , '_blank','800','600');

	  	 // window.showModalDialog(getAppRootUrl() +
			// "/IGSYM1406_Disp.do?rfdfilename=" + rfdfilename + "&rfdversion="
			// +
			// rfdversion,null,"dialogWidth:1000px;dialogHeight:800px;status:no;help:no;resizable:yes");
	  	}