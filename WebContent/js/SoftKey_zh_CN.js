// JavaScript Document'

function SoftKeyboard(obj) {
	var t=obj.offsetTop+0;
	var l=obj.offsetLeft+0;
	oPopUp = window.createPopup();
	var popBody = oPopUp.document.body;
	popBody.style.backgroundColor = "#FFFF99";
	popBody.style.border = "solid   black   1px";
	WriteToPopup(oPopUp, obj);
	oPopUp.show(210, -100, 150, 120, obj);
}

function clear(obj) {
	obj.value='';
}

function WriteToPopup(oPopUp, obj) {
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
		outStr += 'myReg = /^\-{0,1}([0-9]{1,13}\.{0,1})?([0-9]{1,2})?$/;';
		outStr += 'return myReg.test(str);';
		outStr += '}';
		outStr += 'function setStr(obj,str){';
		outStr += 'var objId=parent.document.getElementById("'+obj.id+'");';
		outStr += 'var showValue = objId.value;';
		outStr += 'var flag = 1;';
		outStr += 'if(str!="."){';
		outStr += 'if(showValue.substring(0,1)=="-"){';
		outStr += 'if(showValue.length==14){';
		outStr += 'alert("此处为数字,整数位最多13位,小数位最多2位!");';
		outStr += 'flag=0;';
		outStr += '}';
		outStr += '}else{';
		outStr += 'if(showValue.length==13){';
		outStr += 'alert("此处为数字,整数位最多13位,小数位最多2位!");';
		outStr += 'flag=0;';
		outStr += '}';
		outStr += '}';
		outStr += '}';
		outStr += 'if(str=="-" && showValue.length>0){';
		outStr += 'alert("此处为数字,整数位最多13位,小数位最多2位!");';
		outStr += 'flag=0;';
		outStr += '}';
		outStr += 'if(flag==1){';
		outStr += 'showValue+=str;';
		outStr += 'if(checkFloatNum(showValue)){';
		outStr += 'alert("此处为数字,整数位最多13位,小数位最多2位!");';
		outStr += '}else{';
		outStr += 'objId.value=showValue;';
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
		outStr += '<TR align="center" >';
		outStr += '<TD colspan="3" onClick=clearStr() BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">后退</TD>';
		outStr += '</TR>';
		outStr += '</TABLE>';
		outStr += '</body></html>';
		oPopUp.document.write(outStr);
}

function SoftKeyboardWD(obj) {
	var t=obj.offsetTop+0;
	var l=obj.offsetLeft+0;
	oPopUp = window.createPopup();
	var popBody = oPopUp.document.body;
	popBody.style.backgroundColor = "#FFFF99";
	popBody.style.border = "solid   black   1px";
	WriteToPopupWD(oPopUp, obj);
	oPopUp.show(810, 260, 150, 160, obj);
}

function WriteToPopupWD(oPopUp, obj) {
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
		outStr += 'myReg = /^\-{0,1}([0-9]{1,13}\.{0,1})?([0-9]{1,2})?$/;';
		outStr += 'return myReg.test(str);';
		outStr += '}';
		outStr += 'function setComp(){';
		outStr += 'parent.setNum(tnum.value);';
		outStr += '}';
		outStr += 'function setStr(obj,str){';
		outStr += 'var objId=document.getElementById("tnum");';
		outStr += 'var showValue = objId.value;';
		
		outStr += 'var flag = 1;';
		outStr += 'if(str!="."){';
		outStr += 'if(showValue.substring(0,1)=="-"){';
		outStr += 'if(showValue.length==14){';
		outStr += 'alert("此处为数字,整数位最多13位,小数位最多2位!");';
		outStr += 'flag=0;';
		outStr += '}';
		outStr += '}else{';
		outStr += 'if(showValue.length==13){';
		outStr += 'alert("此处为数字,整数位最多13位,小数位最多2位!");';
		outStr += 'flag=0;';
		outStr += '}';
		outStr += '}';
		outStr += '}';
		outStr += 'if(str=="-" && showValue.length>0){';
		outStr += 'alert("此处为数字,整数位最多13位,小数位最多2位!");';
		outStr += 'flag=0;';
		outStr += '}';
		outStr += 'if(flag==1){';
		outStr += 'showValue+=str;';
		outStr += 'if(checkFloatNum(showValue)){';
		outStr += 'alert("此处为数字,整数位最多13位,小数位最多2位!");';
		outStr += '}else{';
		outStr += 'objId.value=showValue;';
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
		outStr += 'var objId=document.getElementById("tnum");';
		outStr += 'var showValue = objId.value;';
		outStr += 'if(showValue.length > 0){ showValue = showValue.substring(0,showValue.length-1);}';
		outStr += 'objId.value=showValue;';
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
		outStr += '<TR align="center">';
		outStr += '<TD colspan="3"><input type="text" id="tnum" style="width: 140"/></TD>';
		outStr += '</TR>';
		outStr += '<TR align="center">';
		outStr += '<TD colspan="3" onClick=setComp() BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">确定</TD>';
		outStr += '</TR>';
		outStr += '<TR align="center" >';
		outStr += '<TD colspan="3" onClick=clearStr() BGCOLOR="EEEEEE" style="cursor: hand" onmouseover="mouseOver(this)" onmouseout="mouseOut(this)">后退</TD>';
		outStr += '</TR>';
		outStr += '</TABLE>';
		outStr += '</body></html>';
		oPopUp.document.write(outStr);
}
