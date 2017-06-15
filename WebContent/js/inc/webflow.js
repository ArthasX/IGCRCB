

function newFlow(){
	if(document.all.FlowXML.value!='') {
	   if(!confirm('不保存旧流程，创建新流程吗？\n\nDon\'t save the old flow,and Create a new flow?')) return;
	}
	workFlowDialog(null,'Flow');	
}
function newStep(){
	if(document.all.FlowXML.value=='') {
	   alert('请先创建新流程！\n\nPlease create a new flow at first!');
	   return;
	}
	workFlowDialog(null,'NormalStep');
}
function newAction(){
	if(document.all.FlowXML.value=='') {
	   alert('请先创建新流程！\n\nPlease create a new flow at first!');
	   return;
	}
	workFlowDialog(null,'Action');
}
function editFlow(){
	if(document.all.FlowXML.value=='') {
	   alert('请先创建新流程！\n\nPlease create a new flow at first!');
	   return;
	}
	var xmlDoc = new ActiveXObject('MSXML2.DOMDocument');
    xmlDoc.async = false;
    xmlDoc.loadXML(document.all.FlowXML.value);
    var xmlRoot = xmlDoc.documentElement;
    var Flow = xmlRoot.getElementsByTagName("FlowConfig").item(0);

	workFlowDialog(Flow.getElementsByTagName("BaseProperties").item(0).getAttribute("flowId"),'Flow');
}
function editStep(stepId,stepType){
	workFlowDialog(stepId,stepType);
}
function editAction(actionId){
	workFlowDialog(actionId,'Action');
}
function delFlow(){
	clearVML();
	clearXML();
	drawTreeView();
}
function delStep(stepId){
	removeXMLNode(stepId);
	drawTreeView();

	FOCUSEDOBJID = '';
	FOCUSEDOBJTYPE = '';
}
function delAction(actionId){
    removeXMLNode(actionId);
	drawTreeView();

	FOCUSEDOBJID = '';
	FOCUSEDOBJTYPE = '';
}

var CONST_LAY_LOWEST = '0';
var CONST_LAY_LOWER = '10';
var CONST_LAY_MIDDLE = '20';
var CONST_LAY_TOPPER = '30';
var CONST_LAY_TOPPEST = '40';

var AUTODRAW = true;
var FOCUSEDOBJID = '';
var FOCUSEDOBJTYPE = '';

function setFocusedObjLay(xmlRoot,oldObjId,newObjId,objType,newLay){
   var Steps = xmlRoot.getElementsByTagName("Steps").item(0);
   var Actions = xmlRoot.getElementsByTagName("Actions").item(0);
	     
   if(objType=='Action'){
	   for ( var i = 0;i < Actions.childNodes.length;i++ ) {
		   Action = Actions.childNodes.item(i);
		   aId = Action.getElementsByTagName("BaseProperties").item(0).getAttribute("id"); 
		   if(aId == newObjId){			  
			  document.getElementById(newObjId).style.zIndex = newLay;
			  Action.getElementsByTagName("VMLProperties").item(0).setAttribute("zIndex",newLay);
		   }
	   }   	
       
   }else{
	   if(oldObjId!='' && newObjId!='' && newObjId!=oldObjId){
		   var fromStep = document.getElementById(oldObjId);
		   var toStep = document.getElementById(newObjId);

		   var fromStepWidth = parseInt(fromStep.style.width);
		   var fromStepHeight = parseInt(fromStep.style.height);
		   var fromStepX = parseInt(fromStep.style.left);
		   var fromStepY = parseInt(fromStep.style.top);

		   var toStepWidth = parseInt(toStep.style.width);
		   var toStepHeight = parseInt(toStep.style.height);	   
		   var toStepX = parseInt(toStep.style.left);
		   var toStepY = parseInt(toStep.style.top);

		   var flag = ifRepeatStep(fromStepX,fromStepY,fromStepWidth,fromStepHeight,toStepX,toStepY,toStepWidth,toStepHeight);
	   }else{
		   var flag = false;
	   }

	   for ( var i = 0;i < Steps.childNodes.length;i++ ) {
		   Step = Steps.childNodes.item(i);
		   sId = Step.getElementsByTagName("BaseProperties").item(0).getAttribute("id");
		   if(newObjId == sId){
			  document.getElementById(sId).style.zIndex = newLay;
			  Step.getElementsByTagName("VMLProperties").item(0).setAttribute("zIndex",newLay);			  
		   }

		   if(oldObjId == sId && flag){ 
			  document.getElementById(oldObjId).style.zIndex = parseInt(newLay)-10;
			  Step.getElementsByTagName("VMLProperties").item(0).setAttribute("zIndex",parseInt(newLay)-1);	   
		   }
	   }
	   
	   for ( var i = 0;i < Actions.childNodes.length;i++ ) {
		   Action = Actions.childNodes.item(i);
		   aId = Action.getElementsByTagName("BaseProperties").item(0).getAttribute("id"); 
		   fromStep = Action.getElementsByTagName("BaseProperties").item(0).getAttribute("from");
		   toStep = Action.getElementsByTagName("BaseProperties").item(0).getAttribute("to");
		   if(fromStep == newObjId || toStep == newObjId){			  
			  document.getElementById(aId).style.zIndex = newLay;
			  Action.getElementsByTagName("VMLProperties").item(0).setAttribute("zIndex",newLay);
		   }else{
			  document.getElementById(aId).style.zIndex = CONST_LAY_MIDDLE;
			  Action.getElementsByTagName("VMLProperties").item(0).setAttribute("zIndex",parseInt(newLay)-1);
		   }	
	   }   		   
   } 

   return xmlRoot;
}
function objFocusedOn(objId,type){
	
   var FlowXML = document.all.FlowXML;
   if(FlowXML.value!=''){
	   var xmlDoc = new ActiveXObject('MSXML2.DOMDocument');
       xmlDoc.async = false;
       xmlDoc.loadXML(FlowXML.value);
   
       var xmlRoot = xmlDoc.documentElement;
	   var Flow = xmlRoot.getElementsByTagName("FlowConfig").item(0);
	   
	   if(type=='Action'){
		   focusedOnColor = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("actionFocusedStrokeColor");		   
	   }else{
		   focusedOnColor = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("stepFocusedStrokeColor");			   
	   }  
	   xmlRoot = setFocusedObjLay(xmlRoot,FOCUSEDOBJID,objId,type,CONST_LAY_TOPPEST);AUTODRAW = false;FlowXML.value = xmlRoot.xml;AUTODRAW = true;
	   document.getElementById(objId).style.zIndex = CONST_LAY_TOPPEST;
	   document.getElementById(objId).StrokeColor = focusedOnColor;

	   if(FOCUSEDOBJID == objId && MOVEFLAG) return;
	   objFocusedOff();
	   FOCUSEDOBJID = objId;
	   FOCUSEDOBJTYPE = type;
   }
}
function objFocusedOff(){   
   if(FOCUSEDOBJID=='') return; 

   var FlowXML = document.all.FlowXML;
   if(FlowXML.value!=''){
	   var xmlDoc = new ActiveXObject('MSXML2.DOMDocument');
       xmlDoc.async = false;
       xmlDoc.loadXML(FlowXML.value);
       var xmlRoot = xmlDoc.documentElement;
	   var Flow = xmlRoot.getElementsByTagName("FlowConfig").item(0);	  
	   if(FOCUSEDOBJTYPE == 'Action'){
		   focusedOffColor = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("actionStrokeColor");
	   }else{
		   if(FOCUSEDOBJTYPE == 'BeginStep' || FOCUSEDOBJTYPE == 'EndStep'){
			   focusedOffColor = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("sStepStrokeColor");
		   }else{
			   focusedOffColor = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("stepStrokeColor");
		   }
	   }
	   document.getElementById(FOCUSEDOBJID).StrokeColor = focusedOffColor;
	   FOCUSEDOBJID = '';
	   FOCUSEDOBJTYPE = '';
   }
   
}

function moveStep(moveId){	
	dragIt(moveId,"FlowVML");
}

function redrawVML(){
   var FlowXML = document.all.FlowXML;
   var FlowVML = document.all.FlowVML;
   if(FlowXML.value!=''){
	   var xmlDoc = new ActiveXObject('MSXML2.DOMDocument');
       xmlDoc.async = false;
       xmlDoc.loadXML(FlowXML.value);
       var xmlRoot = xmlDoc.documentElement;
	   var Flow = xmlRoot.getElementsByTagName("FlowConfig").item(0);       
	   var Steps = xmlRoot.getElementsByTagName("Steps").item(0);
       var Actions = xmlRoot.getElementsByTagName("Actions").item(0);

	   var StepColor = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("stepStrokeColor");
	   var StepTextColor = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("stepTextColor");
	   var ActionColor = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("actionStrokeColor");
	   var sStepColor = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("sStepStrokeColor");
	   var sStepTextColor = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("sStepTextColor");	
	   var StepShadowColor = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("stepShadowColor");
	   var IsStepShadow = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("isStepShadow");
	   var StepColor1 = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("stepColor1");
	   var StepColor2 = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("stepColor2");
	   var IsStep3D = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("isStep3D");
	   var Step3DDepth = Flow.getElementsByTagName("VMLProperties").item(0).getAttribute("step3DDepth");
	   
	   
	   var isFocusedId = Steps.getAttribute("isFocusedId");
       var vmlHTML = '';
	   //draw steps
	   var psdtype,nIndex,nId,nText,nType,nIsFocused,nTextColor,nStrokeColor,nShadowColor,nIsShadow,nWidth,nHeight,nX,nY,nStrokeWeight,nTextWeight,nColor1,nColor2,nIs3D,n3DDepth;
	   for ( var i = 0;i < Steps.childNodes.length;i++ )
	   {
		   Step = Steps.childNodes.item(i);
		   nId = Step.getElementsByTagName("BaseProperties").item(0).getAttribute("id");
		   nText = Step.getElementsByTagName("BaseProperties").item(0).getAttribute("text");
		   nType = Step.getElementsByTagName("BaseProperties").item(0).getAttribute("stepType");
		   psdtype = Step.getElementsByTagName("BaseProperties").item(0).getAttribute("psdtype");
		   nIndex = Step.getElementsByTagName("VMLProperties").item(0).getAttribute("zIndex");if(nIndex=='') nIndex = CONST_LAY_LOWEST;
		   if(nType=='BeginStep' || nType=='EndStep'){
			   nTextColor = "blue";
			   if(isFocusedId == nId) {
				   nStrokeColor = "yellow";		       	   
			   } else {
				   nStrokeColor = sStepColor;	
			   }	
		      
		   }else{
			   nTextColor = StepTextColor;
			   if(isFocusedId == nId) {
				   nStrokeColor = "yellow";		       	   
			   } else {
				   nStrokeColor = StepColor;
			   }		       	   
		   }
		   nShadowColor = StepShadowColor;
		   nIsShadow = IsStepShadow;
		   nWidth = Step.getElementsByTagName("VMLProperties").item(0).getAttribute("width");
		   nHeight = Step.getElementsByTagName("VMLProperties").item(0).getAttribute("height");
		   nX = Step.getElementsByTagName("VMLProperties").item(0).getAttribute("x");
		   nY = Step.getElementsByTagName("VMLProperties").item(0).getAttribute("y");
		   nStrokeWeight = Step.getElementsByTagName("VMLProperties").item(0).getAttribute("strokeWeight");
		   nTextWeight = Step.getElementsByTagName("VMLProperties").item(0).getAttribute("textWeight");
		   stepCustomColor1 = Step.getElementsByTagName("VMLProperties").item(0).getAttribute("color1");
		   stepCustomColor2 = Step.getElementsByTagName("VMLProperties").item(0).getAttribute("color2");
		   nColor1 = StepColor1;
		   nColor2 = StepColor2;
		   if (stepCustomColor1 != null){
			   nColor1 = stepCustomColor1;
		   }
		   if (stepCustomColor2 != null){
			   nColor2 = stepCustomColor2;		   	
		   }
		   nIs3D = IsStep3D;
		   n3DDepth = Step3DDepth;

		   vmlHTML+= getStepHTML(nType,nIndex,nId,nText,nTextColor,nStrokeColor,nShadowColor,nIsShadow,nWidth,nHeight,nX,nY,nStrokeWeight,nTextWeight,nColor1,nColor2,nIs3D,n3DDepth,psdtype);
	   } 
	   clearVML();
	   drawObject(vmlHTML);
	   vmlHTML = '';
	   
	   //draw actions
	   var removeFlag = false;
	   var lIndex,lId,lText,lType,lIsFocused,lFromStep,lToStep,lStrokeColor,lStrokeWeight,lStartArrow,lEndArrow;
	   for ( var i = 0;i < Actions.childNodes.length;i++ )
	   {
		   Action = Actions.childNodes.item(i);
		   lId = Action.getElementsByTagName("BaseProperties").item(0).getAttribute("id");
		   lText = Action.getElementsByTagName("BaseProperties").item(0).getAttribute("text");
		   lType = Action.getElementsByTagName("BaseProperties").item(0).getAttribute("actionType");
		   lIndex = Action.getElementsByTagName("VMLProperties").item(0).getAttribute("zIndex");if(lIndex=='') lIndex = CONST_LAY_LOWER;
		   lFromStep = Action.getElementsByTagName("BaseProperties").item(0).getAttribute("from");
		   lToStep = Action.getElementsByTagName("BaseProperties").item(0).getAttribute("to");	
		   lStartArrow = Action.getElementsByTagName("VMLProperties").item(0).getAttribute("startArrow");
		   lEndArrow = Action.getElementsByTagName("VMLProperties").item(0).getAttribute("endArrow");	
		   lStrokeWeight = Action.getElementsByTagName("VMLProperties").item(0).getAttribute("strokeWeight");
		   lStrokeColor = ActionColor;
		   
		   result = getActionHTML(lType,lIndex,lId,lText,document.getElementById(lFromStep),document.getElementById(lToStep),lStrokeColor,lStrokeWeight,lStartArrow,lEndArrow)
		   
		   if(result!='') {
			   vmlHTML+= result;
		   }else{
			   Actions.removeChild(Action);
			   removeFlag = true;
		   }
	   } 
       drawObject(vmlHTML);
	   if(removeFlag) FlowXML.value = xmlRoot.xml;
   }
}
function clearXML(){
   var FlowXML = document.all.FlowXML;
   AUTODRAW = false;
   FlowXML.value = '';
}
function clearVML(){
   var FlowVML = document.all.FlowVML;
   FlowVML.innerHTML = '';
   
   FOCUSEDOBJID = '';
   FOCUSEDOBJTYPE = '';
}
function drawObject(ObjHTML){
   var FlowVML = document.all.FlowVML;
   FlowVML.innerHTML+= ObjHTML;
}
function removeXMLNode(objId){
   var FlowXML = document.all.FlowXML;
   if(FlowXML.value!=''){
	   xmlDoc = new ActiveXObject('MSXML2.DOMDocument');
       xmlDoc.async = false;
       xmlDoc.loadXML(FlowXML.value);
   
       var xmlRoot = xmlDoc.documentElement;
	   var Steps = xmlRoot.getElementsByTagName("Steps").item(0);
       var Actions = xmlRoot.getElementsByTagName("Actions").item(0);
	   
	   var findFlag = false;
	   for ( var i = 0;i < Steps.childNodes.length;i++ )
	   {
		   Step = Steps.childNodes.item(i);
		   id = Step.getElementsByTagName("BaseProperties").item(0).getAttribute("id");
		   if(id==objId) {
			   Steps.removeChild(Step);
			   findFlag = true;break;
		   }
	   }
	   if (!findFlag) {
	     for ( var i = 0;i < Actions.childNodes.length;i++ ){
		   Action = Actions.childNodes.item(i);
		   id = Action.getElementsByTagName("BaseProperties").item(0).getAttribute("id");
		   if(id==objId) {
			   Actions.removeChild(Action);
			   findFlag = true;break;
		   }
	     }
	   }

	   if (findFlag) {AUTODRAW = true;FlowXML.value = xmlRoot.xml;}
   }
}



function getStepHTML(stepType,z_index,id,text,textColor,strokeColor,shadowColor,isShadow,width,height,X,Y,strokeWeight,textWeight,color1,color2,is3D,step3DDepth,psdtype){
	 var stepHTML = '';
	   var styleHTML = 'id='+id+' style="z-index:'+z_index+';position:absolute;width:'+width+';height:'+height+';left:'+X+';top:'+Y+';" strokecolor="'+strokeColor+'" strokeweight="'+strokeWeight+'" onmouseover=\'this.style.cursor="hand";\' onmousedown=\'cleancontextMenu();objFocusedOn(this.id,"'+stepType+'");moveStep(this);\' oncontextmenu=\'objFocusedOn(this.id,"'+stepType+'");stepContextMenu("'+id+'","'+stepType+'");return false;\'';
	   var textStyleHTML = 'style="text-align:center;word-break:break-all;color:'+textColor+'; font-size:'+textWeight+';"';
	   var shadowHTML = '<v:shadow on="'+isShadow+'" type="single" color="'+shadowColor+'" offset="5px,5px"/>';
	   var gradientHTML = '<v:fill type="gradient" color="'+color1+'" color2="'+color2+'" />';
	   var step3DHTML = '<v:extrusion on="'+is3D+'" backdepth="'+step3DDepth+'" />';
	   var img = "bgperson.gif";
	   var endimg = "end.gif";
	   if(strokeColor == "yellow") {
		   if(psdtype == '1') {
			   img = "fpperson1.gif";
		   } else {
			   img = "bgperson1.gif";
		   }
		   if(stepType=='EndStep') {
			   endimg = "end1.gif";
		   }
	   } else {
		   if(psdtype == '1') {
			   img = "fpperson.gif";
		   }
	   }
	   
	   if(stepType=='BeginStep' || stepType=='EndStep'){
		   if(stepType=='EndStep') {
			   var endStyleHTML = 'id='+id+' title="'+id+'" style="z-index:'+z_index+';position:absolute;width:100px;height:200px;left:'+X+';top:'+Y+';" strokecolor="'+strokeColor+'" strokeweight="'+strokeWeight+'" onmouseover=\'this.style.cursor="hand";\' onmousedown=\'cleancontextMenu();objFocusedOn(this.id,"'+stepType+'");moveStep(this);\' oncontextmenu=\'objFocusedOn(this.id,"'+stepType+'");stepContextMenu("'+id+'","'+stepType+'");return false;\'';
			   stepHTML = '<v:Oval '+endStyleHTML+'stroked=false ,fill=true><v:imagedata src="images/wkm/prr/'+endimg+'"/></v:Oval>';
		   } else {
			   stepHTML = '<v:Oval '+styleHTML+'stroked=false ,fill=true><v:imagedata src="images/wkm/prr/'+img+'"/><v:TextBox inset="6pt,42pt,6pt,10pt" '+textStyleHTML+'>'+text+'</v:TextBox></v:Oval>';
		   }
	   }else{
		   stepHTML = '<v:RoundRect '+styleHTML+'stroked=false ,fill=true><v:imagedata src="images/wkm/prr/'+img+'"/><v:TextBox inset="2pt,42pt,2pt,5pt" '+textStyleHTML+'>'+text+'</v:TextBox></v:RoundRect>';
	   }

	   return stepHTML;
}
function getActionHTML(actionType,z_index,id,actionText,fromStep,toStep,strokeColor,strokeWeight,startArrow,endArrow){
   var actionHTML = '';

   if(actionType == 'Line'){
      actionHTML = '<v:line id='+id+' title="'+id+'" style="z-index:'+z_index+';position:absolute;" '+getActionPoints(actionType,fromStep,toStep)+' strokecolor="'+strokeColor+'" strokeweight="'+strokeWeight+'" onmousedown=\'cleancontextMenu();objFocusedOn(this.id,"Action");\' oncontextmenu=\'objFocusedOn(this.id,"Action");return false;\'><v:stroke StartArrow="'+startArrow+'" EndArrow="'+endArrow+'"/></v:line>';
   }else{
      actionHTML = '<v:PolyLine id='+id+' title="'+id+'" filled="false" Points="'+getActionPoints(actionType,fromStep,toStep)+'" style="z-index:'+z_index+';position:absolute;" strokecolor="'+strokeColor+'" strokeweight="'+strokeWeight+'" onmousedown=\'cleancontextMenu();\' oncontextmenu=\'return false;\'><v:stroke StartArrow="'+startArrow+'" EndArrow="'+endArrow+'"/></v:PolyLine>';
   }

   return actionHTML;
}
function ifRepeatStep(fromStepX,fromStepY,fromStepWidth,fromStepHeight,toStepX,toStepY,toStepWidth,toStepHeight){
  return (fromStepX + fromStepWidth >= toStepX) && (fromStepY + fromStepHeight >= toStepY) && (toStepX + toStepWidth >= fromStepX) && (toStepY + toStepHeight >= fromStepY);
}
function getActionPoints(actionType,fromStep,toStep){
   if (fromStep==null || toStep==null) return '';

   var pointsHTML = '';

   var fromStepWidth = parseInt(fromStep.style.width);
   var fromStepHeight = parseInt(fromStep.style.height);
   var toStepWidth = parseInt(toStep.style.width);
   var toStepHeight = parseInt(toStep.style.height);
   var fromStepX = parseInt(fromStep.style.left);
   var fromStepY = parseInt(fromStep.style.top);
   var toStepX = parseInt(toStep.style.left);
   var toStepY = parseInt(toStep.style.top);

   fromCenterX = fromStepX + parseInt(fromStepWidth/2);
   fromCenterY = fromStepY + parseInt(fromStepHeight/2);
   //ToStep Center X,Y
   toCenterX = toStepX + parseInt(toStepWidth/2);
   toCenterY = toStepY + parseInt(toStepHeight/2);
   
   if(actionType=='Line' && fromStep!=toStep){
     toStepX1 = toStepX;
     toStepY1 = toStepY;
     toStepX2 = toStepX + toStepWidth;
     toStepY2 = toStepY;
     toStepX3 = toStepX;
     toStepY3 = toStepY + toStepHeight;
     toStepX4 = toStepX + toStepWidth;
     toStepY4 = toStepY + toStepHeight;
   
     if (toStepX>fromStepX && toStepY>fromStepY) {toX = toStepX1;toY = toStepY1;}
     if (toStepX<fromStepX && toStepY>fromStepY) {toX = toStepX2;toY = toStepY2;}
     if (toStepX>fromStepX && toStepY<fromStepY) {toX = toStepX3;toY = toStepY3;}
     if (toStepX<fromStepX && toStepY<fromStepY) {toX = toStepX4;toY = toStepY4;}

     pointsHTML = 'from="'+fromX+','+fromY+'" to="'+toX+','+toY+'"';     
   }else{

     if(fromStep!=toStep){
	   if (ifRepeatStep(fromStepX,fromStepY,fromStepWidth,fromStepHeight,toStepX,toStepY,toStepWidth,toStepHeight)) {
			return "";
	   } 

	   point2X = fromCenterX;
	   point2Y = toCenterY;
	   
	   if (toCenterX > fromCenterX) {		  
		   absY = toCenterY>=fromCenterY?toCenterY-fromCenterY:fromCenterY-toCenterY;
		   if (parseInt(fromStepHeight/2)>=absY) {
			   point1X = fromStepX + fromStepWidth;
			   point1Y = toCenterY;
			   point2X = point1X;
			   point2Y = point1Y;
		   }else{
			   point1X = fromCenterX;
			   point1Y = fromCenterY<toCenterY?fromStepY+fromStepHeight:fromStepY;
		   }
		   absX = toCenterX-fromCenterX;
		   if (parseInt(fromStepWidth/2)>=absX) {
			   point3X = fromCenterX;
			   point3Y = fromCenterY<toCenterY?toStepY:toStepY+toStepHeight;
			   point2X = point3X;
			   point2Y = point3Y;
		   }else{
			   point3X = toStepX;
			   point3Y = toCenterY;
		   }		   
	   }
	   if (toCenterX < fromCenterX) {
		   absY = toCenterY>=fromCenterY?toCenterY-fromCenterY:fromCenterY-toCenterY;
		   if (parseInt(fromStepHeight/2)>=absY) {
			   point1X = fromStepX;
			   point1Y = toCenterY;
			   point2X = point1X;
			   point2Y = point1Y;
		   }else{
			   point1X = fromCenterX;
			   point1Y = fromCenterY<toCenterY?fromStepY+fromStepHeight:fromStepY;
		   }
		   absX = fromCenterX-toCenterX;
		   if (parseInt(fromStepWidth/2)>=absX) {
			   point3X = fromCenterX;
			   point3Y = fromCenterY<toCenterY?toStepY:toStepY+toStepHeight;
			   point2X = point3X;
			   point2Y = point3Y;
		   }else{
			   point3X = toStepX + toStepWidth;
			   point3Y = toCenterY;
		   }		   
	   }
	   if (toCenterX == fromCenterX) {
		   point1X = fromCenterX;
		   point1Y = fromCenterY>toCenterY?fromStepY:fromStepY+fromStepHeight;
		   point3X = fromCenterX;
		   point3Y = fromCenterY>toCenterY?toStepY+toStepHeight:toStepY;
		   point2X = point3X;point2Y = point3Y;
	   }
	   if (toCenterY == fromCenterY) {
		   point1X = fromCenterX>toCenterX?fromStepX:fromStepX+fromStepWidth;
		   point1Y = fromCenterY;
		   point3Y = fromCenterY;
		   point3X = fromCenterX>toCenterX?toStepX+toStepWidth:toStepX;
		   point2X = point3X;point2Y = point3Y;
	   }	   

	   pointsHTML = point1X+','+point1Y+' '+point2X+','+point2Y+' '+point3X+','+point3Y;
	   
	 }else{
	   var constLength = 30;
	   point0X = fromStepX+fromStepWidth-constLength;
	   point0Y = fromStepY+fromStepHeight;
	   point1X = point0X;
	   point1Y = point0Y+constLength;
	   point2X = fromStepX+fromStepWidth+constLength;
	   point2Y = point1Y;
	   point3X = point2X;
	   point3Y = point0Y-constLength;
	   point4X = fromStepX+fromStepWidth;
	   point4Y = point3Y;

	   pointsHTML = point0X+','+point0Y+' '+point1X+','+point1Y+' '+point2X+','+point2Y+' '+point3X+','+point3Y+' '+point4X+','+point4Y;
	 }

   }
   return pointsHTML;
}

var isUse;
function flowContextMenu(){
  var menuSrc = '<menu>';
  if("1"!=isUse){
	  menuSrc+= '<entity id="c0"><description>增加</description><image>js/inc/contextMenu/images/add_obj.gif</image><fontcolor>'+MenuTextColor_enable+'</fontcolor><onClick>cleancontextMenu();goToADD();</onClick><contents></contents></entity>';
  }
  
  menuSrc+= '<entity id="c1"><description>保存流程图</description><image>js/inc/contextMenu/images/save.gif</image><fontcolor>'+MenuTextColor_enable+'</fontcolor><onClick>cleancontextMenu();goToSAVE();</onClick><contents></contents></entity>';
  menuSrc+= '<entity id="c2"><description>刷新</description><image>js/inc/contextMenu/images/refresh_vml.gif</image><fontcolor>'+MenuTextColor_enable+'</fontcolor><onClick>cleancontextMenu();redrawVML();</onClick><contents></contents></entity></menu>';
  //showContextMenu(menuSrc);
}

function stepContextMenu(stepId,stepType){
  
  var menuSrc = '<menu>';
  if(stepType!='EndStep'){
	  menuSrc+= '<entity id="c0"><description>前处理</description><image>js/inc/contextMenu/images/edit_obj1.gif</image><fontcolor>'+MenuTextColor_enable+'</fontcolor><onClick>cleancontextMenu();goToPRE("'+tempPdid+'","'+stepId+'");</onClick><contents></contents></entity>';
	  menuSrc+= '<entity id="c1"><description>参与者</description><image>js/inc/contextMenu/images/edit_obj2.gif</image><fontcolor>'+MenuTextColor_enable+'</fontcolor><onClick>cleancontextMenu();goToPP("'+tempPdid+'","'+stepId+'");</onClick><contents></contents></entity>';
	  menuSrc+= '<entity id="c2"><description>规则</description><image>js/inc/contextMenu/images/edit_obj3.gif</image><fontcolor>'+MenuTextColor_enable+'</fontcolor><onClick>cleancontextMenu();goToRULE("'+tempPdid+'","'+stepId+'");</onClick><contents></contents></entity>';
  }
  if(stepType!='BeginStep' && stepType!='EndStep' && "1"!=isUse){
	  menuSrc+= '<entity id="c3"><description>删除</description><image>js/inc/contextMenu/images/del_obj.gif</image><fontcolor>'+MenuTextColor_enable+'</fontcolor><onClick>cleancontextMenu();doDel("'+stepId+'");</onClick><contents></contents></entity>';
  } 
  menuSrc+= '<entity id="c4"><description>刷新</description><image>js/inc/contextMenu/images/refresh_vml.gif</image><fontcolor>'+MenuTextColor_enable+'</fontcolor><onClick>cleancontextMenu();redrawVML();</onClick><contents></contents></entity></menu>';

  //showContextMenu(menuSrc);

}

function actionContextMenu(actionId){
  var menuSrc = '<menu><entity id="c0"><description>Edit Action['+actionId+']</description><image>inc/contextMenu/images/edit_obj.gif</image><fontcolor>'+MenuTextColor_enable+'</fontcolor><onClick>cleancontextMenu();editAction("'+actionId+'");</onClick><contents></contents></entity>';
  menuSrc+= '<entity id="c1"><description>Delete Action['+actionId+']</description><image>inc/contextMenu/images/del_obj.gif</image><fontcolor>'+MenuTextColor_enable+'</fontcolor><onClick>cleancontextMenu();delAction("'+actionId+'");</onClick><contents></contents></entity>';
  menuSrc+= '<entity id="c2"><description>Refresh</description><image>inc/contextMenu/images/refresh_vml.gif</image><fontcolor>'+MenuTextColor_enable+'</fontcolor><onClick>cleancontextMenu();redrawVML();</onClick><contents></contents></entity></menu>';
  //showContextMenu(menuSrc);
}

function showContextMenu(menuSrc){
  xmlMenu = new ActiveXObject('MSXML2.DOMDocument');
  xmlMenu.async = false;
  xmlMenu.loadXML(menuSrc);
  var root = xmlMenu.documentElement; 
  
  if(root==null || root.xml==null){
	  return;
  }
  
  var menuText=''+root.xml+'';
 
  loadContextMenu(menuText,'js/inc/contextMenu/contextmenu.xsl');

}

var dialogURL = "";
function workFlowDialog(id,type){
	
	switch (type){
        case 'NormalStep': dialogURL = id==null?'_stepdialog.html':'_stepdialog.html?stepid='+id;break;
	    case 'BeginStep': dialogURL = id==null?'_stepdialog.html':'_stepdialog.html?stepid='+id;break;
	    case 'EndStep': dialogURL = id==null?'_stepdialog.html':'_stepdialog.html?stepid='+id;break;
	    case 'Action': dialogURL = id==null?'_actiondialog.html':'_actiondialog.html?actionid='+id;break;
		case 'Flow': dialogURL = id==null?'_flowdialog.html':'_flowdialog.html?flowid='+id;break;		
	} 
	var dialog = window.showModalDialog(dialogURL, window, "dialogWidth:373px; dialogHeight:460px; center:yes; help:no; resizable:no; status:no") ;
	drawTreeView();
}
function drawTreeView(){
  document.all.treeview.src="_flowtree.html";
}


