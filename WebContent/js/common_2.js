var hasSubmitted = false;
var waitMsg = " 正在操作中，请稍候...";
var deleteMsg =" 正在删除数据，请稍候...";
var confirmMsg = " 确定要删除数据吗?";
var currentId="";                                 //当前选中Tr的ID

document.write("<DIV ID='dek' style='POSITION:absolute;margin:0px;VISIBILITY:hidden;Z-INDEX:200;'></DIV>");
/*****************************************************************************/
//
// 以下用于在向后台提交的时候,显示提示框
//
/*****************************************************************************/
document.write("<div id=splashLayer align=center style='position: absolute;width:500px;height:200px;left:50%;top:50%;margin-left:-250px;margin-top:-100px;visibility:hidden;'><table width=250 border=0 align=center cellpadding=0 cellspacing=1 bordercolor=#FF0000 bgcolor=#000000><tr bgcolor=#FFFFFF><td height=60 style='font-size:12px;' id=infoTD align=center bordercolor=#1860A8 bgcolor=#DEE8F6>"+waitMsg+"</td></tr></table></div>");
function showSplash(info)
{
	if (info != undefined)
	{
		document.getElementById("infoTD").innerHTML = info;
	}
	hiddenAllSelect();	
	document.getElementById("splashLayer").style.visibility="visible";
}
function hideSplash()
{
	document.getElementById("splashLayer").style.visibility="hidden";
	showAllSelect();
}
function hiddenAllSelect()
{
	var allSelectS = document.getElementsByTagName("select");
	for(i = 0; i < allSelectS.length; i++)
	{
		var obj = allSelectS[i];
		obj.style.visibility="hidden";
	}
}
function showAllSelect()
{
	var allSelectS = document.getElementsByTagName("select");
	for(i = 0; i < allSelectS.length; i++)
	{
		var obj = allSelectS[i];
		obj.style.visibility="visible";
	}
}

/*****************************************************************************/
//
// 表单提交控制
//
/*****************************************************************************/
function getFormByName(formName) 
{
  var theForm = null;
  for (var i=0; i<document.forms.length; i++) {
    theForm = document.forms[i];
    if (theForm.attributes["name"].value == formName) 
    {
    	return theForm;
    } 
  }
  var theForms = document.all.tags("FORM");
  var eachForm = null;
  for (var i=0; i<theForms.length; i++) {
    eachForm = theForms[i];
    if (eachForm.name == formName) return eachForm; 
  }
  return null;
}

function getFieldByNameInForm(fieldName, theForm) 
{
  var elms = theForm.elements;
  var eachField = null;
  var found = new Array();
  var count = 0;
  for (var i=0; i<elms.length; i++) {
    eachField = elms[i];
    if (eachField.name == fieldName) {
      if (eachField.type != "radio") 
        return eachField;
      else {
        found[count] = eachField;
        count++;
      }
    }
  }
  if (found.length > 0)
    return found;
  else
    return null;
}

function openWindow(theURL)
{
	if(isSubmmitted()){
    window.open(theURL,'','resizable=yes,left=180,top=150,width=500,height=300');		
	hasSubmitted = true;
	}else{
		alert(waitMsg);
	}	
}

function isSubmmitted()
{
	return !hasSubmitted;
}
/**********************************************************************
* 普通提交表单
* 当且仅当第4个参数为false的时候不显示splash
* @param formName             表单的名称(name)
* @param actionValue          动作的值
* @param actionFieldName      表单中动作字段(隐藏域)的name
* @param splashTag            是否显示等待框的splash的boolean变量true/false，
* @                           这个参数可以不输入，不输入默认为false
**********************************************************************/
function doSubmit(formName , actionValue, actionFieldName,splashTag) 
{
	var theForm = getFormByName(formName);
	getFieldByNameInForm(actionFieldName, theForm).value = actionValue;
	if(isSubmmitted()){
		theForm.submit();
		hasSubmitted = true;
		
		var argLength = arguments.length;
		if (argLength == 3){
			showSplash(waitMsg);
		}
		else{
			var showSplashTag = arguments[3];
			if (showSplashTag != false){
				showSplash(waitMsg);
			}		
		}
	}else{
	  alert(waitMsg);
	}
}
/**********************************************************************
* 用于显示数据明细（查看明细或者编辑）的时候，提交表单
* 当且仅当第6个参数为false的时候不显示splash
* @param formName             表单的名称(name)
* @param actionValue          动作的值
* @param actionFieldName      表单中动作字段(隐藏域)的name
* @param itemValue            特定字段的值
* @param itemFieldName        表单中特定字段(隐藏域)的name，一般该字段为对应表主键
* @param splashTag            是否显示等待框的splash的boolean变量true/false，
* @                           这个参数可以不输入，不输入默认为false
**********************************************************************/
function doLinkSubmit(formName , actionValue, actionFieldName, itemValue, itemFieldName,splashTag) {
	var theForm = getFormByName(formName);
	getFieldByNameInForm(actionFieldName, theForm).value = actionValue;
	getFieldByNameInForm(itemFieldName, theForm).value = itemValue;
	if(isSubmmitted()){
		theForm.submit();
		hasSubmitted = true;
		var argLength = arguments.length;
		if (argLength == 5){
			showSplash(waitMsg);
		}
		else{
			var showSplashTag = arguments[5];
			if (showSplashTag != false){
				showSplash(waitMsg);
			}		
		}
	}else{
	  alert(waitMsg);
	}
}

/**********************************************************************
* 用于删除时候提交表单，提交表单的时候给出提示删除确认的提示信息
* 当且仅当第6个参数为false的时候不显示splash
* @param formName             表单的名称(name)
* @param actionValue          动作的值
* @param actionFieldName      表单中动作字段(隐藏域)的name
* @param itemValue            特定字段的值
* @param itemFieldName        表单中特定字段(隐藏域)的name，一般该字段为对应表主键
* @param splashTag            是否显示等待框的splash的boolean变量true/false，
* @                           这个参数可以不输入，不输入默认为false
**********************************************************************/
function doLinkSubmitForDelete(formName,actionValue, actionFieldName, itemValue, itemFieldName,splashTag)
{
	var theForm = getFormByName(formName);
  	getFieldByNameInForm(actionFieldName, theForm).value = actionValue;
  	getFieldByNameInForm(itemFieldName, theForm).value = itemValue;
	if(isSubmmitted()){
		if(confirm(confirmMsg)) {
			theForm.submit();
			hasSubmitted = true;
			var argLength = arguments.length;
			if (argLength == 5){
				showSplash(waitMsg);
			}
			else{
				var showSplashTag = arguments[5];
				if (showSplashTag != false){
					showSplash(waitMsg);
				}		
			}
		}
	}else{
		alert(waitMsg);
	}	
}

/*****************************************************************************/
//
// 以下主要用于显示文字的全部内容,如果文字比指定长度长的时候显示Tip
//
/*****************************************************************************/

Xoffset=10;     // modify these values to ...
Yoffset= 20;    // change the popup position.
function showTip(msg,limitLength){
	var skn=document.getElementById('dek').style;
	var iex=(document.all),yyy=-1000;	
	if (msg.toString().length <= limitLength)
	{
		return;	
	}
	var content="<TABLE BGCOLOR=#DEE8F6 BORDER=0 CELLPADDING=2 CELLSPACING=0><TR><TD width='300px' style='word-break:break-all;'>"+msg+"</TD></TR></TABLE>";
	yyy=Yoffset;
	if(iex){
		document.all("dek").innerHTML=content;
		skn.visibility="visible"
		skn.left=event.x+document.body.scrollLeft + Xoffset;
		skn.top= event.y+document.body.scrollTop+yyy
	}
	else {
		document.getElementById('dek').innerHTML=content;
		skn.visibility="visible"
		skn.left=event.pageX + Xoffset;
		skn.top= event.pageY + yyy
	}
}
function hideTip(){
	var skn=document.getElementById('dek').style;	
	yyy=-1000;
	skn.visibility="hidden";
}

/*****************************************************************************/
//
// 设定选中行的颜色
//
/*****************************************************************************/
function setColor(trID)   
{   
	if (currentId == '')
	{
		currentId=trID.id;
		document.getElementById(currentId).className='selectedTr';	 
	}
	else 
	{
		document.getElementById(currentId).className='normalTr';	
		currentId=trID.id;
		document.getElementById(currentId).className='selectedTr';
	}
}

/*****************************************************************************/
//
// 页面的常用方法
//
/*****************************************************************************/
function getRadioValue(radioName)
{
	var i,myObj; 
	var myObj=document.getElementsByName(radioName); 
	for(i=0;i<myObj.length;i++){ 
		if(myObj[i].checked)return myObj[i].value; 
	}
	return null;
}
function moveCursor(upObjId,downObjId,leftObjId,rightObjId)
{
	if (event.keyCode == 38 && document.getElementById(upObjId))
	{
		document.getElementById(upObjId).select();
	}
	if (event.keyCode == 40 && document.getElementById(downObjId))
	{
		document.getElementById(downObjId).select();
	}
	if (event.keyCode == 37 && document.getElementById(leftObjId))
	{
		document.getElementById(leftObjId).select();
	}
	if (event.keyCode == 39 && document.getElementById(rightObjId))
	{
		document.getElementById(rightObjId).select();
	}		
}
//等同于document.getElementById(objId);
function $(objId) {
	return ele(objId);
}
//等同于document.getElementById(objId);
function ele(objId)
{
	return document.getElementById(objId);
}
function checkNull(_value)
{
	if(_value==null || _value=="") return true;
	return false;
}
function replaceAll(text,sourceText,replaceText){
     var pose=text.indexOf(sourceText);
     if(pose==-1)
       return text;
     else{
        var head=text.substring(0,pose+1);
        head=head.replace(sourceText,replaceText);
        var tail=text.substring(pose+1,text.length);
        head=head+replaceAll(tail,sourceText,replaceText);
        return head;
     }
}
function toUpperCase(formElement)
{
  formElement.value = formElement.value.toUpperCase();
}
function convertChar(parameter){
       parameter=replaceAll(parameter,"%","%25");
       parameter=replaceAll(parameter,"#","%23");
       parameter=replaceAll(parameter,"&","%26");
       parameter=replaceAll(parameter,"+","%2B");
       return parameter;
}
function showError(msg)
{
	if ($('error')){
		$('error').innerText = msg;
		$('error').style.color="#FF0000";		
	}
}

/**********************************************************************
* 用于限定TextArea的最大长度
* @param textareaId            textarea表单元素的Id
* @param maxLength             最大长度
**********************************************************************/
function LengthLimiter(textareaId,maxLength) 
{ 
	this.textAreaObj = document.getElementById(textareaId);
	this.maxLength = maxLength;
	this.attacthLimit();
}
LengthLimiter.prototype.attacthLimit = function()
{
	var maxLengthTemp = this.maxLength;
	var textAreaObjTemp = this.textAreaObj;
	if(window.addEventListener){
		this.textAreaObj.addEventListener("input",function(){
			if (textAreaObjTemp.value.length > maxLengthTemp) {
				textAreaObjTemp.value = textAreaObjTemp.value.substr(0,maxLengthTemp);
			}
		},false);
	}
	else{
		this.textAreaObj.attachEvent("onpropertychange",function(){
			if (textAreaObjTemp.value.length > maxLengthTemp) {
				textAreaObjTemp.value = textAreaObjTemp.value.substr(0,maxLengthTemp);
			}			
		});
	}
}

/**********************************************************************
* 主要用于空格限定
* @param inputId            表单中text/textarea元素的Id
**********************************************************************/
function BlankTrimer(inputId) 
{ 
	this.inputObj = document.getElementById(inputId);
	this.attachTrimer(inputId);		
}
BlankTrimer.prototype.attachTrimer = function()
{
	var inputObjTemp = this.inputObj;

	if(window.addEventListener){
		this.inputObj.addEventListener("input",function(){
			inputObjTemp.value = trim(inputObjTemp.value);
		},false);
	}
	else{		
		this.inputObj.attachEvent("onchange",function(){
			inputObjTemp.value = trim(inputObjTemp.value);
		});
	}	
}

function ltrim(str) { 
	for(var k = 0; k < str.length && isWhitespace(str.charAt(k)); k++);
	return str.substring(k, str.length);
}
function rtrim(str) {
	for(var j=str.length-1; j>=0 && isWhitespace(str.charAt(j)) ; j--) ;
	return str.substring(0,j+1);
}
function trim(str) {
	return ltrim(rtrim(str));
}
function isWhitespace(charToCheck) {
	var whitespaceChars = " \t\n\r\f";
	return (whitespaceChars.indexOf(charToCheck) != -1);
}


function checkAll(startIndex,endIndex,checkTagPrefix)
{
	for(i=startIndex; i< endIndex;i++)
	{
		var e = document.getElementById(checkTagPrefix+i.toString());
		e.checked=true;
	}	
}
function cancleAll(startIndex,endIndex,checkTagPrefix)
{
	for(i=startIndex; i< endIndex;i++)
	{
		var e = document.getElementById(checkTagPrefix+i.toString());
		e.checked=false;
	}
}


/*********************************************************************/
//
//   以下代码为屏蔽IE和Firefox的差异
//
/*********************************************************************/
function __firefox(){ 
HTMLElement.prototype.__defineGetter__("runtimeStyle", __element_style); 
window.constructor.prototype.__defineGetter__("event", __window_event); 
Event.prototype.__defineGetter__("srcElement", __event_srcElement); 
} 
function __element_style(){ 
return this.style; 
} 
function __window_event(){ 
return __window_event_constructor(); 
} 
function __event_srcElement(){ 
return this.target; 
} 
function __window_event_constructor(){ 
if(document.all){ 
return window.event; 
} 
var _caller = __window_event_constructor.caller; 
while(_caller!=null){ 
var _argument = _caller.arguments[0]; 
if(_argument){ 
var _temp = _argument.constructor; 
if(_temp.toString().indexOf("Event")!=-1){ 
return _argument; 
} 
} 
_caller = _caller.caller; 
} 
return null; 
} 
if(window.addEventListener){ 
__firefox(); 
} 

if(window.Event){// 修正Event的DOM
    /*
                                IE5        MacIE5        Mozilla        Konqueror2.2        Opera5
    event                        yes        yes            yes            yes                    yes
    event.returnValue            yes        yes            no            no                    no
    event.cancelBubble            yes        yes            no            no                    no
    event.srcElement            yes        yes            no            no                    no
    event.fromElement            yes        yes            no            no                    no
    
    */
    Event.prototype.__defineSetter__("returnValue",function(b){// 
        if(!b)this.preventDefault();
        return b;
    });
    Event.prototype.__defineSetter__("cancelBubble",function(b){// 设置或者检索当前事件句柄的层次冒泡
        if(b)this.stopPropagation();
        return b;
    });
    Event.prototype.__defineGetter__("srcElement",function(){
        var node=this.target;
        while(node.nodeType!=1)node=node.parentNode;
        return node;
    });
    Event.prototype.__defineGetter__("fromElement",function(){// 返回鼠标移出的源节点
        var node;
        if(this.type=="mouseover")
            node=this.relatedTarget;
        else if(this.type=="mouseout")
            node=this.target;
        if(!node)return;
        while(node.nodeType!=1)node=node.parentNode;
        return node;
    });
    Event.prototype.__defineGetter__("toElement",function(){// 返回鼠标移入的源节点
        var node;
        if(this.type=="mouseout")
            node=this.relatedTarget;
        else if(this.type=="mouseover")
            node=this.target;
        if(!node)return;
        while(node.nodeType!=1)node=node.parentNode;
        return node;
    });
    Event.prototype.__defineGetter__("offsetX",function(){
        return this.layerX;
    });
    Event.prototype.__defineGetter__("offsetY",function(){
        return this.layerY;
    });
}
if(window.Node){// 修正Node的DOM
    /*
                                IE5        MacIE5        Mozilla        Konqueror2.2        Opera5
    Node.contains                yes        yes            no            no                    yes
    Node.replaceNode            yes        no            no            no                    no
    Node.removeNode                yes        no            no            no                    no
    Node.children                yes        yes            no            no                    no
    Node.hasChildNodes            yes        yes            yes            yes                    no
    Node.childNodes                yes        yes            yes            yes                    no
    Node.swapNode                yes        no            no            no                    no
    Node.currentStyle            yes        yes            no            no                    no    
    */
    Node.prototype.replaceNode=function(Node){// 替换指定节点
        this.parentNode.replaceChild(Node,this);
    }
    Node.prototype.removeNode=function(removeChildren){// 删除指定节点
        if(removeChildren)
            return this.parentNode.removeChild(this);
        else{
            var range=document.createRange();
            range.selectNodeContents(this);
            return this.parentNode.replaceChild(range.extractContents(),this);
        }
    }
    Node.prototype.swapNode=function(Node){// 交换节点
        var nextSibling=this.nextSibling;
        var parentNode=this.parentNode;
        node.parentNode.replaceChild(this,Node);
        parentNode.insertBefore(node,nextSibling);
    }
}
if(window.HTMLElement){
    HTMLElement.prototype.__defineGetter__("all",function(){
        var a=this.getElementsByTagName("*");
        var node=this;
        a.tags=function(sTagName){
            return node.getElementsByTagName(sTagName);
        }
        return a;
    });
    HTMLElement.prototype.__defineGetter__("parentElement",function(){
        if(this.parentNode==this.ownerDocument)return null;
        return this.parentNode;
    });
    HTMLElement.prototype.__defineGetter__("children",function(){
        var tmp=[];
        var j=0;
        var n;
        for(var i=0;i<this.childNodes.length;i++){
            n=this.childNodes[i];
            if(n.nodeType==1){
                tmp[j++]=n;
                if(n.name){
                    if(!tmp[n.name])
                        tmp[n.name]=[];
                    tmp[n.name][tmp[n.name].length]=n;
                    }
                if(n.id)
                    tmp[n.id]=n;
                }
        }
        return tmp;
    });
    HTMLElement.prototype.__defineGetter__("currentStyle", function(){
        return this.ownerDocument.defaultView.getComputedStyle(this,null);
    });
    HTMLElement.prototype.__defineSetter__("outerHTML",function(sHTML){
        var r=this.ownerDocument.createRange();
        r.setStartBefore(this);
        var df=r.createContextualFragment(sHTML);
        this.parentNode.replaceChild(df,this);
        return sHTML;
    });
    HTMLElement.prototype.__defineGetter__("outerHTML",function(){
        var attr;
        var attrs=this.attributes;
        var str="<"+this.tagName;
        for(var i=0;i<attrs.length;i++){
            attr=attrs[i];
            if(attr.specified)
                str+=" "+attr.name+'="'+attr.value+'"';
            }
        if(!this.canHaveChildren)
            return str+">";
        return str+">"+this.innerHTML+"</"+this.tagName+">";
    });
    HTMLElement.prototype.__defineGetter__("canHaveChildren",function(){
        switch(this.tagName.toLowerCase()){
            case "area":
            case "base":
            case "basefont":
            case "col":
            case "frame":
            case "hr":
            case "img":
            case "br":
            case "input":
            case "isindex":
            case "link":
            case "meta":
            case "param":
                return false;
            }
        return true;
    });

    HTMLElement.prototype.__defineSetter__("innerText",function(sText){
        /*
		var parsedText=document.createTextNode(sText);
        this.innerHTML=parsedText;
        return parsedText;*/
		this.textContent=sText;
    });
    HTMLElement.prototype.__defineGetter__("innerText",function(){
        var r=this.ownerDocument.createRange();
        r.selectNodeContents(this);
        return r.toString();
    });
    HTMLElement.prototype.__defineSetter__("outerText",function(sText){
        var parsedText=document.createTextNode(sText);
        this.outerHTML=parsedText;
        return parsedText;
    });
    HTMLElement.prototype.__defineGetter__("outerText",function(){
        var r=this.ownerDocument.createRange();
        r.selectNodeContents(this);
        return r.toString();
    });
    HTMLElement.prototype.attachEvent=function(sType,fHandler){
        var shortTypeName=sType.replace(/on/,"");
        fHandler._ieEmuEventHandler=function(e){
            window.event=e;
            return fHandler();
            }
        this.addEventListener(shortTypeName,fHandler._ieEmuEventHandler,false);
    }
    HTMLElement.prototype.detachEvent=function(sType,fHandler){
        var shortTypeName=sType.replace(/on/,"");
        if(typeof(fHandler._ieEmuEventHandler)=="function")
            this.removeEventListener(shortTypeName,fHandler._ieEmuEventHandler,false);
        else
            this.removeEventListener(shortTypeName,fHandler,true);
    }
    HTMLElement.prototype.contains=function(Node){// 是否包含某节点
        do if(Node==this)return true;
        while(Node=Node.parentNode);
        return false;
    }
    HTMLElement.prototype.insertAdjacentElement=function(where,parsedNode){
        switch(where){
            case "beforeBegin":
                this.parentNode.insertBefore(parsedNode,this);
                break;
            case "afterBegin":
                this.insertBefore(parsedNode,this.firstChild);
                break;
            case "beforeEnd":
                this.appendChild(parsedNode);
                break;
            case "afterEnd":
                if(this.nextSibling)
                    this.parentNode.insertBefore(parsedNode,this.nextSibling);
                else
                    this.parentNode.appendChild(parsedNode);
                break;
         }
    }
    HTMLElement.prototype.insertAdjacentHTML=function(where,htmlStr){
        var r=this.ownerDocument.createRange();
        r.setStartBefore(this);
        var parsedHTML=r.createContextualFragment(htmlStr);
        this.insertAdjacentElement(where,parsedHTML);
    }
    HTMLElement.prototype.insertAdjacentText=function(where,txtStr){
        var parsedText=document.createTextNode(txtStr);
        this.insertAdjacentElement(where,parsedText);
    }
    HTMLElement.prototype.attachEvent=function(sType,fHandler){
        var shortTypeName=sType.replace(/on/,"");
        fHandler._ieEmuEventHandler=function(e){
            window.event=e;
            return fHandler();
            }
        this.addEventListener(shortTypeName,fHandler._ieEmuEventHandler,false);
    }
    HTMLElement.prototype.detachEvent=function(sType,fHandler){
        var shortTypeName=sType.replace(/on/,"");
        if(typeof(fHandler._ieEmuEventHandler)=="function")
            this.removeEventListener(shortTypeName,fHandler._ieEmuEventHandler,false);
        else
            this.removeEventListener(shortTypeName,fHandler,true);
    }
}