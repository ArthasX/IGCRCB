
function getSelectValue(listName){
   if(listName.selectedIndex!=-1){return listName.options[listName.selectedIndex].value}
   else{return ''}
}

function getSelectText(listName){
   if(listName.selectedIndex!=-1){return listName.options[listName.selectedIndex].innerText}
   else{return ''}
}

function addSelectOption(listName,optText,optValue,optSelected){
  var oOption = document.createElement("OPTION")
  listName.options.add(oOption)
  oOption.innerText = optText
  oOption.value = optValue
  oOption.selected = optSelected
  
}

function emptyList(list){
  for(var i=0;list.length=0;i++){list.remove(i)}
}

function copyList(list1,list2){
  emptyList(list2)
  for (i=0;i<list1.length ;i++ )
  {
	 addSelectOption(list2,list1.options[i].innerText,list1.options[i].value)
  }
}

function selectListAll(listName){
	for (var i=0;i<listName.length ;i++ )
	{
		listName.options[i].selected = true
	}
}

function selectListNone(listName){
	listName.selectedIndex = -1
}

function List2list_addOne(list1,list2){
  var a = list1
  var b = list2
  
  if (a.selectedIndex!=-1){
	 var flag = '0'
	 for(var i=0;i<b.length;i++){
	   if(b.options[i].value==a.options[a.selectedIndex].value) flag = '1'
	 }

	 if(flag == '0'){
	   var oOption = document.createElement("OPTION")
	   b.options.add(oOption)
	   oOption.innerText = a.options[a.selectedIndex].innerText
	   oOption.value = a.options[a.selectedIndex].value	 
	 }	
	 a.remove(a.selectedIndex)  
  }
}

function List2list_delOne(list1,list2){
  List2list_addOne(list2,list1)
}

function List2list_addAll(list1,list2){
  var a = list1
  var b = list2

  for(var i=0;i<a.length;i++){
	 var flag = '0'
	 for(var j=0;j<b.length;j++){
	   if(b.options[j].value==a.options[i].value) flag = '1'
	 }

	 if(flag == '0'){
	   var oOption = document.createElement("OPTION")
	   b.options.add(oOption)
	   oOption.innerText = a.options[i].innerText
	   oOption.value = a.options[i].value	  
	 }	   	  
  }
  emptyList(a)
}

function List2list_delAll(list1,list2){
  List2list_addAll(list2,list1)
}


function getRadioGroupValue(RadioGroup){
   for(var i=0;i<RadioGroup.length;i++)
      {if (RadioGroup[i].checked){return RadioGroup[i].value}}
   return ""
}

function setRadioGroupValue(RadioGroup,SetValue){
   if (SetValue!='')
   {
	  for(var i=0;i<RadioGroup.length;i++)
      {if (RadioGroup[i].value == SetValue){RadioGroup[i].checked = true;return true}}
	  return false
   }
   else {return false}   
}

function getSingleCheckBoxValue(checkBoxName){
  if(checkBoxName.checked){return checkBoxName.value}
  else{return ""}
}

function setSingleCheckBoxValue(checkBoxName,setValue){
  if (setValue!='')
   {
	  if (checkBoxName.value == setValue){checkBoxName.checked = true;return true}
	  else{checkBoxName.checked = false;return false}
   }
   else {return false}  
}


function Ltrim(str)
{
   return str.replace(/ +/,"")
}

function Rtrim(str)
{
   return str.replace(/ +$/,"")
}

function STR2Int(Str){
  if(Str==''){return 0}
  else{return parseInt(Str)}
}

function Trans00Format(time){
  var timeStr = ''+time
  if(timeStr.length==1){return '0'+timeStr}
  else{return timeStr}
}


function checkNumberHelp(obj,AlertTxt){
  if(obj.value!=''){
	  if(!validCharCheck(obj.value,'0123456789')){if(AlertTxt!=''){alert(AlertTxt)};try{obj.focus()}catch(e){};obj.value='';return false;}
  }
}

function checkIntRangeHelp(obj,DefaultValue,AlertTxt,MaxInt,MinInt){
  if(obj.value=='' || isNaN(parseInt(obj.value))) {obj.value = DefaultValue;return false}
  obj.value = parseInt(parseFloat(obj.value))+''
  if(MaxInt!=null){
	  if(MaxInt < parseInt(obj.value)){
		  if(AlertTxt!='') alert(AlertTxt)
		  obj.value = DefaultValue
		  try{obj.focus()}catch(e){}
		  return false
      }
  }
  if(MinInt!=null){
	  if(MinInt > parseInt(obj.value)){
		  if(AlertTxt!='') alert(AlertTxt)
		  obj.value = DefaultValue 
		  try{obj.focus()}catch(e){}
		  return false
      }
  }
}

function quickInputHelp(obj,defaultValue){
	if(obj.value==defaultValue) obj.value = ''
}

function autoBlurHelp(inputObj,inputLength,focusObj){
  if (inputObj.value.length == inputLength) {inputObj.blur();focusObj.focus()}
}

function editCellHelp (CellId,Cell,ClassName,Maxlength,DefaultValue,AlertTxt,MaxNumber,MinNumber) {
   if (CellId!='' && CellId!=null){
     if (document.all) {
       var sizeText = Maxlength==''?Cell.innerText.length:Maxlength
       Cell.innerHTML = '&nbsp;<INPUT ID="'+CellId+'" class="'+ClassName+'" maxlength="'+Maxlength+'"  onclick="event.cancelBubble = true;" onchange="checkIntRangeHelp(this,'+DefaultValue+',\''+AlertTxt+'\','+MaxNumber+','+MinNumber+')";setCellHelp(this.parentElement, this.value)" onblur="setCellHelp(this.parentElement, this.value)" value="'+Cell.innerText+'" size="'+sizeText+'">'
       document.all(CellId).focus()
       document.all(CellId).select()
     }
     else if (document.getElementById) {
            Cell.normalize()
            var input = document.createElement('INPUT')
            input.setAttribute('value', Cell.firstChild.nodeValue)
            input.setAttribute('size', Cell.firstChild.nodeValue.length)
            input.onchange = function (evt) { 
               setCellHelp(this.parentNode, this.value) }
            input.onclick = function (evt) { 
               evt.cancelBubble = true
               if (evt.stopPropagation) evt.stopPropagation() }
            Cell.replaceChild(input, Cell.firstChild)
            input.focus()
            input.select()
     }
   }
}

function setCellHelp (Cell, Value) {
   if (document.all)
      Cell.innerText = Value;
   else if (document.getElementById)
      Cell.replaceChild(document.createTextNode(Value), Cell.firstChild);
}


function validCharCheck(objStr,Letters){  
  for (var i=0; i<objStr.length; i++){
   var CheckChar = objStr.charAt(i)
   if (Letters.indexOf(CheckChar) == -1) return false
  }
  return true
}

function novalidCharCheck(objStr,Letters){
  for (var i=0; i<objStr.length; i++){
   var CheckChar = objStr.charAt(i)
   if (Letters.indexOf(CheckChar) >= 0) return false
  }
  return true
}

function intRangeCheck(objStr,MaxInt,MinInt){  
  if(objStr=='') return false
  if(MaxInt!=null){
	  if(MaxInt < parseInt(objStr)){		 
		  return false
      }
  }
  if(MinInt!=null){
	  if(MinInt > parseInt(objStr)){		  
		  return false
      }
  }
  return true
}


function validStrCheck(obj,validStr,AlertTxt){

	if (obj.value!='' && !validCharCheck(obj.value,validStr))
	{
		if (AlertTxt!='') alert(AlertTxt)
		obj.value = '';try{obj.focus()}catch(e){};return false
	}
	else {return true}

}

function novalidStrCheck(obj,novalidStr,AlertTxt){
	if (obj.value!='' && !novalidCharCheck(obj.value,novalidStr))
	{
		if (AlertTxt!='') alert(AlertTxt)
		obj.value = '';try{obj.focus()}catch(e){};return false
	}
	else {return true}
}

function emptyStrCheck(obj,AlertTxt){
	if (obj.value=='')
	{
		if (AlertTxt!='') alert(AlertTxt)
		obj.value = '';try{obj.focus()}catch(e){};return false
	}
	else {return true}
}

function validIPCheck(obj,objTxt){
  var ipStr = obj.value
  if (ipStr == '') {alert(objTxt+' - ip 地址不能为空!');obj.value = '';try{obj.focus()}catch(e){};return false;}

  var flag = true
  var ip = ipStr.split('.')
  if (ip.length!=4) {alert(objTxt+' - ip 地址不正确!'); flag = false}
  else{
    for (var i=0;i<ip.length;i++){
	   var j = i+1
	   if (!validCharCheck(ip[i],'0123456789')) {alert(objTxt+' - ip 地址段 ('+j+') 必须为整数。');flag = false;break}
	   if (!intRangeCheck(ip[i],255,0)) { alert(objTxt+' - ip 地址段 ('+j+') 数值有误!\nip 地址段范围：0-255 。');flag = false;break}	
	}
  }
  if (flag==false) {obj.value = '';try{obj.focus()}catch(e){};}	
  return flag
}

function validEmailCheck(email){
}


