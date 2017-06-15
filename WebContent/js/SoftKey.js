// JavaScript Document'
function SoftKeyboard(obj) {
	showKeyboard(obj,0,2);
}

function SoftKeyboardFlag(obj,index,decimals){
	if(index == null || index == "" || (index + "").trim() == ""){
		index = 0;
	}
	showKeyboard(obj,index,decimals);
}

function showKeyboard(obj,index,decimals){
	var t=obj.offsetTop+0;
	var l=obj.offsetLeft+0;
	oPopUp = window.createPopup();
	var popBody = oPopUp.document.body;
	popBody.style.backgroundColor = "#FFFF99";
	popBody.style.border = "solid   black   1px";
	WriteToPopup(oPopUp, obj,index,decimals);
	oPopUp.show(window.event.x, window.event.y + 10, 150, 120, document.body);
}

function clear(obj) {
	obj.value='';
}

function WriteToPopup(oPopUp, obj,index,decimals) {
	var myRegStrArr = new Array();
	var message = "";
	if(decimals) {
		message = "此处为数字，整数位最多13位，小数位最多" + decimals + "位！";
		myRegStrArr[0] = 'myReg = /^\-{0,1}([0-9]{1,13}\.{0,1})?([0-9]{1,' + decimals + '})?$/;';
		
	} else {
		message = "此处为数字，整数位最多13位，小数位最多2位！";
		myRegStrArr[0] = 'myReg = /^\-{0,1}([0-9]{1,13}\.{0,1})?([0-9]{1,2})?$/;';
	}
	myRegStrArr[1] = 'myReg = /^\-{0,1}([0-9]{0,13})$/;';
	myRegStrArr[2] = 'myReg = /^[0-9]{1,13}$/;';
	if(1 == index){
		message = "此处为整数，最多13位(不包括负号)！";
	}else if(2 == index){
		message = "此处为非负整数，最多13位！";
	}
	var outStr = '<html><head><meta http-equiv="Content-Type" content="text/html; charset=gb2312"><style>';
	    outStr += '*{font-size: 16px; font-weight:800; font-family: 宋体;color:#666666}';
		outStr += '</style>';
		outStr += '<SCRIPT>';
		outStr += 'function checkFloatNum(value){';
		outStr += 'if(value!=""){';
		outStr += 'if(!checkFloatNumber(value)){';
		outStr += 'value = "";';
		outStr += 'return true;';
		outStr += '}';
		outStr += 'else{';
		outStr += 'return false;';
		outStr += '}';
		outStr += '	}else{';
		outStr += 'return false;';
		outStr += '}';
		outStr += '}';
		outStr += 'function checkFloatNumber(str){';
		outStr += myRegStrArr[index];
		outStr += 'return myReg.test(str);';
		outStr += '}';
		outStr += 'function setStr(obj,str){';
		outStr += 'var objId=parent.document.getElementById("'+obj.id+'");';
		outStr += 'var showValue = objId.value;';
		outStr += 'var flag = 1;';
		outStr += 'if(showValue == "0"){';
		outStr += 'if(str != "."){';
		outStr += 'alert("' + message + '");';
		outStr += 'flag=0;';
		outStr += '}';
		outStr += '}';
		outStr += 'if(str!="."){';
		outStr += 'if(showValue.substring(0,1)=="-"){';
		outStr += 'if(showValue.length==14){';
		outStr += 'alert("' + message + '");';
		outStr += 'flag=0;';
		outStr += '}';
		outStr += '}else{';
		outStr += 'if(showValue.length==13){';
		outStr += 'alert("' + message + '");';
		outStr += 'flag=0;';
		outStr += '}';
		outStr += '}';
		outStr += '}';
		outStr += 'if(str=="-" && showValue.length>0){';
		outStr += 'alert("' + message + '");';
		outStr += 'flag=0;';
		outStr += '}';
		outStr += 'if(flag==1){';
		outStr += 'showValue+=str;';
		outStr += 'if(checkFloatNum(showValue)){';
		outStr += 'alert("' + message + '");';
		outStr += '}else{';
		outStr += 'objId.value=showValue;if(objId.onchange){objId.onchange();}';
		outStr += '}';
		outStr += '}';
		outStr +='}';
		outStr += 'function mouseOver(obj){';
		outStr += 'obj.bgColor="#6699FF";';
		outStr +='}';
		outStr += 'function mouseOut(obj){';
		outStr += 'obj.bgColor="#EEEEEE";';
		outStr +='}';
		outStr += 'function clearStr(){';
		outStr += 'var objId=parent.document.getElementById("'+obj.id+'");';
		outStr += 'var showValue = objId.value;';
		outStr += 'if(showValue.length > 0){ showValue = showValue.substring(0,showValue.length-1);}';
		outStr += 'objId.value=showValue;';
		outStr += 'if(objId.onchange){objId.onchange();};';
		outStr +='}';

		outStr += '</SCRIPT>';
		outStr += '</head><body style="margin:2;filter:Alpha(opacity=100);   border:1   solid   #3C97C6;overflow:hidden;">';
		outStr += '<TABLE BGCOLOR="FFFFFF" width="100%" height="100%" cellspacing="1">';
		outStr += '<TR align="center">';
		outStr += '<TD onClick=setStr(this,"1") width="33%" BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">1</TD>';
		outStr += '<TD onClick=setStr(this,"2") width="33%" BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">2</TD>';
		outStr += '<TD onClick=setStr(this,"3") width="34%" BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">3</TD>';
		outStr += '</TR>';
		outStr += '<TR align="center">';
		outStr += '<TD onClick=setStr(this,"4") BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">4</TD>';
		outStr += '<TD onClick=setStr(this,"5") BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">5</TD>';
		outStr += '<TD onClick=setStr(this,"6") BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">6</TD>';
		outStr += '</TR>';
		outStr += '<TR align="center">';
		outStr += '<TD onClick=setStr(this,"7") BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">7</TD>';
		outStr += '<TD onClick=setStr(this,"8") BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">8</TD>';
		outStr += '<TD onClick=setStr(this,"9") BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">9</TD>';
		outStr += '</TR>';
		outStr += '<TR align="center">';
		outStr += '<TD onClick=setStr(this,"0") BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">0</TD>';
		outStr += '<TD onClick=setStr(this,".") BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">.</TD>';
		outStr += '<TD onClick=setStr(this,"-") BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">-</TD>';
		outStr += '</TR>';
		outStr += '</TR>';
		outStr += '<TR align="center" >';
		outStr += '<TD colspan="3" onClick=clearStr() BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">后退</TD>';
		outStr += '</TR>';
		outStr += '</TABLE>';
		outStr += '</body></html>'
		oPopUp.document.write(outStr);
}
