<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="birt" uri="/WEB-INF/tlds/birt.tld" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html:html>
<bean:define id="id" value="IGSYM1407" toScope="request" />
<bean:define id="title" toScope="request" >
Birt Viewer 2.5
</bean:define>
<head>
 <link href="styles/baobiao.css" rel="stylesheet" type="text/css" />
 <script src="js/alerts/jquery.js" type="text/javascript"></script>
<script src="js/alerts/jquery.ui.draggable.js" type="text/javascript"></script>
<script src="js/alerts/jquery.alerts.js" type="text/javascript"></script>
<link href="js/alerts/jquery.alerts.css" rel="stylesheet" type="text/css" media="screen" />
<jsp:include page="/include/header1.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript">	
	WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
	WebCalendar.format     = "yyyy/mm/dd"  //回传日期的格式
	WebCalendar.timeShow   = false          //是否返回时间
	WebCalendar.drag       = true          //是否允许拖动
	WebCalendar.darkColor  = "#014DB4";    //控件的暗色
	WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
	WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
	WebCalendar.wordColor  = "#000080";    //控件的文字颜色
	WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
	WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
	WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
	WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色

	var num="1";
	function moshi(num){
			$('bydayDiv').style.display="none";
			$('bymouthDiv').style.display="none";
			$('byCdayDiv').style.display="none";
			$('byCmouthDiv').style.display="none";
			$('bycountDiv').style.display="none";
			$('three1').className="";
			$('three2').className="";
			$('three3').className="";
			$('three4').className="";
			$('three5').className="";
		if(num=='1'){
			$('bydayDiv').style.display="";
			$('three'+num).className="hover";
		}
		if(num=='2'){
			$('bymouthDiv').style.display="";
			$('three'+num).className="hover";
		}
		if(num=='3'){
			$('byCdayDiv').style.display="";
			$('three'+num).className="hover";
		}
		if(num=='4'){
			$('byCmouthDiv').style.display="";
			$('three'+num).className="hover";
		}
		if(num=='5'){
			$('bycountDiv').style.display="";
			$('three'+num).className="hover";
		}
	}

	var objCount;//选择对象数量
	function chgurlPicture(num,action){
		objCount=0;
		var alertSelectTime='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectTime"/>';
		var alertSelectKPI='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectKPI"/>';
		var alertSelectObj='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectObj"/>';
		var alertSelectObjCount='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectObjCount"/>';
		var alertSelectObjCount2='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectObjCount2"/>';
		var alertSelectTotalMonth='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectTotalMonth"/>';
		var alertSelectStartTime='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectStartTime"/>';
		var alertSelectEndTime='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectEndTime"/>';
		var alertSelectDate='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectDate"/>';
		var alertSelectMonth='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectMonth"/>';
		var alertTime='<bean:message bundle="rptResources" key="message.IGSYM1407.alertTime"/>';
		
		var flag=false;
		$('mode').value=num;
		//$('birti').src="IGSYM1408.do?dataid=${IGSYM1407Form.dataid}&reportpath=${IGSYM1407Form.reportpath}&dateFrom="+String('${IGSYM1407Form.dateFrom}')+"&dateTo="+String('${IGSYM1407Form.dateTo}');
		var url="dataid=${IGSYM1407Form.dataid}&reportpath=${IGSYM1407Form.reportpath}";
		var reportPath="${IGSYM1407Form.reportpath}";
		var kpi=reportPath.substring(reportPath.lastIndexOf("/")+1,reportPath.lastIndexOf("."));
		var goUrl="IGSYM1408.do?";//访问性能报表所走的
		var goExport="type=generateCustomDoc&kpi="+kpi+"&";//生成自定义报告的
		if(num==1){//日趋势
			url+="&timetype="+$('timetype1').value;
			//var reg=new RegExp("/","g"); //创建正则RegExp对象    
			//url+="&dateFrom="+$('byday_date').value.replace(reg,"-");
			url+="&dateFrom="+$('byday_date').value;
			//url+="&dateTo="+$('byday_date').value.replace(reg,"-");
			var cbValue="";
			var cb=document.getElementsByName("checkbox1");
			for(i=0;i<cb.length;i++){
				if(cb[i].checked){
					flag=true;
					if(cbValue==""){
						cbValue="&checkboxs="+cb[i].value;
					}else{
						cbValue+=","+cb[i].value;
					}
				}
			}
			url+=cbValue;
			
			if($('byday_date').value==""){
				alert(alertSelectTime);
				return;
			}
			if($('timetype1').value!="none"&&flag==false){
				alert(alertSelectKPI);
				return;
			}

			var device=getObjName("objectName1");//取得对象名
			if(objCount>5){//最多选5个对象
				alert(alertSelectObjCount);
				return;
			}
			if(device==""){
				alert(alertSelectObj);
				return;
			}else if(device!=null){
				url+="&device="+device;
			}
			
			url+="&mode=1";
		}
		if(num==2){//月趋势
			url+="&timetype="+$('timetype2').value;
			//var reg=new RegExp("/","g"); //创建正则RegExp对象    
			//url+="&dateFrom="+$('bymouth_date').value.replace(reg,"-").substring(0,7);
			url+="&dateFrom="+$('bymouth_date').value.substring(0,7);
			//url+="&dateTo="+$('byday_date').value.replace(reg,"-");
			var cbValue="";
			var cb=document.getElementsByName("checkbox2");
			for(i=0;i<cb.length;i++){
				if(cb[i].checked){
					flag=true;
					if(cbValue==""){
						cbValue="&checkboxs="+cb[i].value;
					}else{
						cbValue+=","+cb[i].value;
					}
				}
			}
			url+=cbValue;
			
			if($('bymouth_date').value==""){
				alert(alertSelectTotalMonth);
				return;
			}
			if(flag==false){
				alert(alertSelectKPI);
				return;
			}

			var device=getObjName("objectName2");//取得对象名
			if(objCount>5){//最多选5个对象
				alert(alertSelectObjCount);
				return;
			}
			if(device==""){
				alert(alertSelectObj);
				return;
			}else if(device!=null){
				url+="&device="+device;
			}
			
			url+="&mode=2";
		}
		if(num==3){//日对比
			var compareDate="";
			var cds=document.getElementById("cds1").options;
			if(cds.length==0){
				alert(alertSelectDate);
				return;
			}
			for(i=0;i<cds.length;i++){
				if(compareDate==""){
					compareDate="&compareDate="+cds[i].value;
				}else{
					compareDate+=","+cds[i].value;
				}
			}
			url+=compareDate;
			url+="&timeFrom="+$('bycday_timeFrom').value;
			url+="&timeTo="+$('bycday_timeTo').value;
			url+="&mode=3";

			var device=getObjName("objectName3");//取得对象名
			if(objCount>1){//最多选1个对象
				alert(alertSelectObjCount2);
				return;
			}
			if(device==""){
				alert(alertSelectObj);
				return;
			}else if(device!=null){
				url+="&device="+device;
			}
			
		}
		if(num==4){//月对比
			var compareDate="";
			var cds=document.getElementById("cms1").options;
			if(cds.length==0){
				alert(alertSelectMonth);
				return;
			}
			for(i=0;i<cds.length;i++){
				if(compareDate==""){
					compareDate="&compareDate="+cds[i].value.substring(0,7);
				}else{
					compareDate+=","+cds[i].value.substring(0,7);
				}
			}
			url+=compareDate;
			url+="&mode=4";

			var device=getObjName("objectName4");//取得对象名
			if(objCount>1){//最多选1个对象
				alert(alertSelectObjCount2);
				return;
			}
			if(device==""){
				alert(alertSelectObj);
				return;
			}else if(device!=null){
				url+="&device="+device;
			}
			
		}
		if(num==5){//查询统计
			url+="&timetype="+$('timetype3').value;
			url+="&dateFrom="+$('bycount_dateFrom').value;
			url+="&dateTo="+$('bycount_dateTo').value;

			var cbValue="";
			var cb=document.getElementsByName("checkbox3");
			for(i=0;i<cb.length;i++){
				if(cb[i].checked){
					flag=true;
					if(cbValue==""){
						cbValue="&checkboxs="+cb[i].value;
					}else{
						cbValue+=","+cb[i].value;
					}
				}
			}
			if($('bycount_dateFrom').value==""){
				alert(alertSelectStartTime);
				return;
			}
			if($('bycount_dateTo').value==""){
				alert(alertSelectEndTime);
				return;
			}
			if($('bycount_dateFrom').value>=$('bycount_dateTo').value){
				alert(alertTime);
				return;
			}
			var device=getObjName("objectName5");//取得对象名
			if(objCount>5){//最多选5个对象
				alert(alertSelectObjCount);
				return;
			}
			if(device==""){
				alert(alertSelectObj);
				return;
			}else if(device!=null){
				url+="&device="+device;
			}
			
			if($('timetype3').value!="none"&&flag==false){
				alert(alertSelectKPI);
				return;
			}
			url+=cbValue;
			url+="&mode=5";

		}	
			if(action=='export'){
			//alert(goExport+url);
			exportDoc(goExport+url)
			}else{
			document.getElementById("picture").style.display= "";
			document.getElementById("listing").style.display= "none";
			$('birtiOne').src=goUrl+url;
			}
	}

	var objCountTwo;
	function chgurlListing(num,action){
		objCountTwo=0;
		var alertSelectTime='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectTime"/>';
		var alertSelectKPI='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectKPI"/>';
		var alertSelectObj='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectObj"/>';
		var alertSelectObjCount='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectObjCount"/>';
		var alertSelectObjCount2='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectObjCount2"/>';
		var alertSelectTotalMonth='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectTotalMonth"/>';
		var alertSelectStartTime='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectStartTime"/>';
		var alertSelectEndTime='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectEndTime"/>';
		var alertSelectDate='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectDate"/>';
		var alertSelectMonth='<bean:message bundle="rptResources" key="message.IGSYM1407.alertSelectMonth"/>';
		var alertTime='<bean:message bundle="rptResources" key="message.IGSYM1407.alertTime"/>';
		
		var flag=false;
		$('mode').value=num;
		//$('birti').src="IGSYM1408.do?dataid=${IGSYM1407Form.dataid}&reportpath=${IGSYM1407Form.reportpath}&dateFrom="+String('${IGSYM1407Form.dateFrom}')+"&dateTo="+String('${IGSYM1407Form.dateTo}');
		var urlTwo="dataid=${IGSYM1407Form.dataid}&reportpath=${IGSYM1407Form.reportpathTable}";
		var reportPath="${IGSYM1407Form.reportpath}";
		var kpi=reportPath.substring(reportPath.lastIndexOf("/")+1,reportPath.lastIndexOf("."));
		var goUrl="IGSYM1408.do?";//访问性能报表所走的
		var goExport="type=generateCustomDoc&kpi="+kpi+"&";//生成自定义报告的
		if(num==1){//日趋势
			urlTwo+="&timetype="+$('timetype1').value;
			//var reg=new RegExp("/","g"); //创建正则RegExp对象    
			//url+="&dateFrom="+$('byday_date').value.replace(reg,"-");
			urlTwo+="&dateFrom="+$('byday_date').value;
			//url+="&dateTo="+$('byday_date').value.replace(reg,"-");
			var cbValue="";
			var cb=document.getElementsByName("checkbox1");
			for(i=0;i<cb.length;i++){
				if(cb[i].checked){
					flag=true;
					if(cbValue==""){
						cbValue="&checkboxs="+cb[i].value;
					}else{
						cbValue+=","+cb[i].value;
					}
				}
			}
			urlTwo+=cbValue;
			
			if($('byday_date').value==""){
				alert(alertSelectTime);
				return;
			}
			if($('timetype1').value!="none"&&flag==false){
				alert(alertSelectKPI);
				return;
			}

			var device=getObjName("objectName1");//取得对象名
			if(objCountTwo>5){//最多选5个对象
				alert(alertSelectObjCount);
				return;
			}
			if(device==""){
				alert(alertSelectObj);
				return;
			}else if(device!=null){
				urlTwo+="&device="+device;
			}
			
			urlTwo+="&mode=1";
		}
		if(num==2){//月趋势
			urlTwo+="&timetype="+$('timetype2').value;
			//var reg=new RegExp("/","g"); //创建正则RegExp对象    
			//url+="&dateFrom="+$('bymouth_date').value.replace(reg,"-").substring(0,7);
			urlTwo+="&dateFrom="+$('bymouth_date').value.substring(0,7);
			//url+="&dateTo="+$('byday_date').value.replace(reg,"-");
			var cbValue="";
			var cb=document.getElementsByName("checkbox2");
			for(i=0;i<cb.length;i++){
				if(cb[i].checked){
					flag=true;
					if(cbValue==""){
						cbValue="&checkboxs="+cb[i].value;
					}else{
						cbValue+=","+cb[i].value;
					}
				}
			}
			urlTwo+=cbValue;
			
			if($('bymouth_date').value==""){
				alert(alertSelectTotalMonth);
				return;
			}
			if(flag==false){
				alert(alertSelectKPI);
				return;
			}

			var device=getObjName("objectName2");//取得对象名
			if(objCountTwo>5){//最多选5个对象
				alert(alertSelectObjCount);
				return;
			}
			if(device==""){
				alert(alertSelectObj);
				return;
			}else if(device!=null){
				urlTwo+="&device="+device;
			}
			
			urlTwo+="&mode=2";
		}
		if(num==3){//日对比
			var compareDate="";
			var cds=document.getElementById("cds1").options;
			if(cds.length==0){
				alert(alertSelectDate);
				return;
			}
			for(i=0;i<cds.length;i++){
				if(compareDate==""){
					compareDate="&compareDate="+cds[i].value;
				}else{
					compareDate+=","+cds[i].value;
				}
			}

			urlTwo+=compareDate;
			urlTwo+="&timeFrom="+$('bycday_timeFrom').value;
			urlTwo+="&timeTo="+$('bycday_timeTo').value;
			urlTwo+="&mode=3";
			
			var device=getObjName("objectName3");//取得对象名
			if(objCountTwo>1){//最多选1个对象
				alert(alertSelectObjCount2);
				return;
			}
			if(device==""){
				alert(alertSelectObj);
				return;
			}else if(device!=null){
				urlTwo+="&device="+device;
			}
			
		}
		if(num==4){//月对比
			var compareDate="";
			var cds=document.getElementById("cms1").options;
			if(cds.length==0){
				alert(alertSelectMonth);
				return;
			}
			for(i=0;i<cds.length;i++){
				if(compareDate==""){
					compareDate="&compareDate="+cds[i].value.substring(0,7);
				}else{
					compareDate+=","+cds[i].value.substring(0,7);
				}
			}

			urlTwo+=compareDate;
			urlTwo+="&mode=4";
			
			var device=getObjName("objectName4");//取得对象名
			if(objCountTwo>1){//最多选1个对象
				alert(alertSelectObjCount2);
				return;
			}
			if(device==""){
				alert(alertSelectObj);
				return;
			}else if(device!=null){
				urlTwo+="&device="+device;
			}
			
		}
		if(num==5){//查询统计

			urlTwo+="&timetype="+$('timetype3').value;
			urlTwo+="&dateFrom="+$('bycount_dateFrom').value;
			urlTwo+="&dateTo="+$('bycount_dateTo').value;
			var cbValue="";
			var cb=document.getElementsByName("checkbox3");
			for(i=0;i<cb.length;i++){
				if(cb[i].checked){
					flag=true;
					if(cbValue==""){
						cbValue="&checkboxs="+cb[i].value;
					}else{
						cbValue+=","+cb[i].value;
					}
				}
			}
			if($('bycount_dateFrom').value==""){
				alert(alertSelectStartTime);
				return;
			}
			if($('bycount_dateTo').value==""){
				alert(alertSelectEndTime);
				return;
			}
			if($('bycount_dateFrom').value>=$('bycount_dateTo').value){
				alert(alertTime);
				return;
			}
			var device=getObjName("objectName5");//取得对象名
			if(objCountTwo>5){//最多选5个对象
				alert(alertSelectObjCount);
				return;
			}
			if(device==""){
				alert(alertSelectObj);
				return;
			}else if(device!=null){
				urlTwo+="&device="+device;
			}
			
			if($('timetype3').value!="none"&&flag==false){
				alert(alertSelectKPI);
				return;
			}

			urlTwo+=cbValue;
			urlTwo+="&mode=5";
		}	
			if(action=='export'){
			//alert(goExport+url);
			}else{
			//alert(goUrl+url);
			document.getElementById("picture").style.display= "none";
			document.getElementById("listing").style.display= "";
			$('birtiTwo').src=goUrl+urlTwo;	
			}
	}


	function exportDoc(url){
		var alertInputRaName='<bean:message bundle="rptResources" key="message.IGSYM1407.alertInputRaName"/>';
		var alertRaName='<bean:message bundle="rptResources" key="message.IGSYM1407.alertRaName"/>';
		var alertExportSuc='<bean:message bundle="rptResources" key="message.IGSYM1407.alertExportSuc"/>';
		var alertExportErr='<bean:message bundle="rptResources" key="message.IGSYM1407.alertExportErr"/>';
		var raName="";
		var titleMsg="Prompt Dialog";
		var promptMsg=alertRaName;
		jPrompt(promptMsg, '', titleMsg, function(r) {
			if( r!=null&&r.trim()!=""){
				 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
						parameters: url+'&raName='+r,
						 onSuccess:  function(req, json){
						 var result=req.responseText;
						 if(result!=null&&result!=""&&result==200){
							alert(alertExportSuc);
						 }else if(result==500){
							 alert("error 500");
						 }else{
							alert(alertExportErr);
						 }
					    }
					});
			}else if(r!=null&&r.trim()==""){
				alert(alertInputRaName);
			}
		});
	}

	
	function getObjName(obj){
		var objName=document.getElementById(obj);
		if(objName){
			var device="";
			var n=0;
			for(i=0;i<objName.length;i++){
				if(objName[i].selected){
					if(device==""){
						device+=objName[i].value;
					}else{
						device+=","+objName[i].value;
					}
					n++;
					//if(n==5){//对象最多选5个
						//break;
					//}
				}
			}
			objCount=n;
			objCountTwo=n;
			return device;
		}else{
			return null;
		}
	}
	
	function addsel(){//添加日期select
		var val=$F('bycmouth_date');
		if(val != "" && $('cms1').options.length <5){
			$('cms1').options.add(new Option(val,val));
		}else{
			//alert('No Date yet');
		}
	}
	function delsel(){//删除选中select
		if($('cms1').options.length > 0){
			for(var i=0;i<$('cms1').options.length;i++){
				if($('cms1').options[i].selected){
					$('cms1').options[i]=null;//付null即删除
				}
			}
		}else{
			//alert('unless have one item');
		}
	}
	function addvalue(){
		var val1=$F('bycday_date');
		if(val1 != "" && $('cds1').options.length <5){
			$('cds1').options.add(new Option(val1,val1));
		}
	}
	function delvalue(){
		if($('cds1').options.length > 0){
			for(var i=0;i<$('cds1').options.length;i++){
				if($('cds1').options[i].selected){
					$('cds1').options[i]=null;//付null即删除
				}
			}
		}else{
			//alert('unless have one item');
		}
	}
	function change(num){
		if(num==1){
			var cb=document.getElementsByName("checkbox1");
			if($('timetype1').value=="none"){
				for(i=0;i<cb.length;i++){
					cb[i].setAttribute('disabled','true');
				}
			}else{
				for(i=0;i<cb.length;i++){
					cb[i].removeAttribute('disabled');
				}
			}
		}
		if(num==5){
			var cb=document.getElementsByName("checkbox3");
			if($('timetype3').value=="none"){
				for(i=0;i<cb.length;i++){
					cb[i].setAttribute('disabled','true');
				}
			}else{
				for(i=0;i<cb.length;i++){
					cb[i].removeAttribute('disabled');
				}
			}
		}
	}

	//容量添加超链接
	 function collectLink(num){
		var confirmCollect='<bean:message bundle="rptResources" key="message.IGRPT0301.confirmCollect"/>';
		if(confirm(confirmCollect)){ 
		//传递的参数
		var rclReportType='01';
		var rclObjName='${IGSYM1407Form.dataid}';
		var rclTemName='${IGSYM1407Form.reportname}';
		var rclTemDesc='${IGSYM1407Form.objectType}';
		var objType='${IGSYM1407Form.fatherName}';
		var rclTemTitle='${IGSYM1407Form.rfdTitle}';
		var rclCaType=num;
		
		var paramter='type=addReportCustomLink&rclReportType='+rclReportType
		+'&rclObjName='+rclObjName+'&rclTemName='+rclTemName+'&rclTemDesc='+rclTemDesc
		+'&rclCaType='+rclCaType+'&objType='+objType+'&rclTemTitle='+rclTemTitle;
		var result="";
		var collected='<bean:message bundle="rptResources" key="message.IGRPT0301.collected"/>';
		var collectsuc='<bean:message bundle="rptResources" key="message.IGRPT0301.collectSuccess"/>';
		 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: paramter,
				 onSuccess:  function(req, json){
	  			 result=req.responseText;
	  			 if(result!=null&&result!=""){
					if(result=='exists'){
						alert(collected);
					}else if(result=='insert'){
						alert(collectsuc);
					}
		  		 }
		 	}
			});
		return result;
		}
	 }
</script>
<script language="javascript">
var str = "";
document.writeln("<div id=\"_contents\" style=\"padding:6px; background-color:#E3E3E3; font-size: 12px; border: 1px solid #777777; position:absolute; left:?px; top:?px; width:?px; height:?px; z-index:1; visibility:hidden\">");
str += "\u65f6<select id=\"_hour\">";
for (h = 0; h <= 9; h++) {
    str += "<option value=\"0" + h + "\">0" + h + "</option>";
}
for (h = 10; h <= 23; h++) {
    str += "<option value=\"" + h + "\">" + h + "</option>";
}
str += "</select> \u5206<select id=\"_minute\">";
for (m = 0; m <= 9; m++) {
    str += "<option value=\"0" + m + "\">0" + m + "</option>";
}
for (m = 10; m <= 59; m++) {
    str += "<option value=\"" + m + "\">" + m + "</option>";
}
str += "</select> \u79d2<select id=\"_second\">";
for (s = 0; s <= 9; s++) {
    str += "<option value=\"0" + s + "\">0" + s + "</option>";
}
for (s = 10; s <= 59; s++) {
    str += "<option value=\"" + s + "\">" + s + "</option>";
}
str += "</select> <input name=\"queding\" type=\"button\" onclick=\"_select()\" value=\"\u786e\u5b9a\" style=\"font-size:12px\" /></div>";
document.writeln(str);
var _fieldname;
function _SetTime(tt) {
    _fieldname = tt;
    var ttop = tt.offsetTop;    //TT控件的定位点高
    var thei = tt.clientHeight;    //TT控件本身的高
    var tleft = tt.offsetLeft;    //TT控件的定位点宽
    while (tt = tt.offsetParent) {
        ttop += tt.offsetTop;
        tleft += tt.offsetLeft;
    }
    document.getElementById("_contents").style.top = ttop + thei + 4;
    document.getElementById("_contents").style.left = tleft;
    document.getElementById("_contents").style.visibility = "visible";
}
function _select() {
    _fieldname.value = document.getElementById("_hour").value + ":" + document.getElementById("_minute").value + ":" + document.getElementById("_second").value;
    document.getElementById("_contents").style.visibility = "hidden";
}
function initReportTask(){
	var moshiNum="${IGSYM1407Form.rclCaType}";
	if(moshiNum!=null&&moshiNum!=""){
		moshi(moshiNum);
	}
}
</script>

</head>
<body onload="initReportTask()">
<html:form styleId="form" action="/IGSYM1407_Disp"
	onsubmit="return checkSubmit(this);">
<div class="r_main"><div class="Menubox2">
<ul>
		<li id="three1" onclick="moshi('1')"  class="hover"><bean:message bundle="rptResources" key="label.IGSYM1407.moshi1"/></li>
        <li id="three2" onclick="moshi('2')"><bean:message bundle="rptResources" key="label.IGSYM1407.moshi2"/></li>
        <li id="three3" onclick="moshi('3')"><bean:message bundle="rptResources" key="label.IGSYM1407.moshi3"/></li>
        <li id="three4" onclick="moshi('4')"><bean:message bundle="rptResources" key="label.IGSYM1407.moshi4"/></li>
        <li id="three5" onclick="moshi('5')"><bean:message bundle="rptResources" key="label.IGSYM1407.moshi5"/></li>
</ul>
</div>
<div class="Contentbox2" >
   <div id="con_three_1" >
     <div class="srccdt">
     <div id="bydayDiv" style="display:;" class="xserha">
     
     <table width="100%" height="68" border="0">
 	 <tr>
 	  <td width="10%" align="right" valign="middle" >
		  <label><bean:message bundle="rptResources" key="select.IGSYM1407.totalWay"/>：</label>
      </td>
 	  <td width="15%" align="left" valign="middle" >
		  <select id="timetype1" onchange="change('1')" style="width:90px">
		  <option value="none" ><bean:message bundle="rptResources" key="select.IGSYM1407.noTotal"/></option>
		  <option value="hour" ><bean:message bundle="rptResources" key="select.IGSYM1407.hourTotal"/></option>
		  </select>
      </td>
      <td width="27%" align="left" valign="middle" >
      <input type="checkbox" name="checkbox1" value="avg" disabled="disabled"/><bean:message bundle="rptResources" key="checkbox.IGSYM1407.avg"/>&nbsp;<input type="checkbox" name="checkbox1" value="sum" disabled="disabled"/><bean:message bundle="rptResources" key="checkbox.IGSYM1407.sum"/>&nbsp;
	  <input type="checkbox" name="checkbox1" value="max" disabled="disabled"/><bean:message bundle="rptResources" key="checkbox.IGSYM1407.max"/>&nbsp;<input type="checkbox" name="checkbox1" value="min" disabled="disabled"/><bean:message bundle="rptResources" key="checkbox.IGSYM1407.min"/>&nbsp;
      </td>
      <td width="8%"  rowspan="2" align="right" valign="middle">
       <logic:present name="objectNameList">
 	  	<label><bean:message bundle="rptResources" key="label.IGSYM1407.objName"/>：<br /><bean:message bundle="rptResources" key="select.IGSYM1407.fiveWarn"/></label>
 	  	</logic:present>
      </td>
      <td width="22%" align="right"  rowspan="2" valign="middle">
 	  <logic:present name="objectNameList">
    	<html:select property="objectName1" size="4" multiple="multiple" style="width:180px">
				<html:options collection="objectNameList" property="value" name="" labelProperty="label" />
		</html:select>
	  </logic:present>
      </td>
      <td width="14%" align="center" rowspan="2" valign="middle">
     	<img alt='<bean:message bundle="rptResources" key="button.IGSYM1407.export"/>' src="images/export.gif" style="cursor: hand" onclick="chgurlPicture('1','export')"/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.collect"/>' src="images/fav2.gif" style="cursor: hand" onclick="collectLink(1)"/><br/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.graphic"/>' src="images/graphic.gif" style="cursor: hand" onclick="chgurlPicture('1','url')"/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.listing"/>' src="images/listing.gif" style="cursor: hand" onclick="chgurlListing('1','url')"/>
      </td>
     </tr>
     <tr>
     <td width="10%" align="right" valign="middle" >
		  <label><bean:message bundle="rptResources" key="label.IGSYM1407.selectTime"/>：</label>
      </td>
      <td width="15%" align="left" valign="middle" colspan="2">
		 <html:text property="byday_date" styleId="byday_date" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
		 <img src="images/date.gif" onClick="showDate($('byday_date'))" border="0" style="cursor: hand;"/><br/>
      </td>
     </tr>
  </table>
	</div>
     <div id="bymouthDiv" style="display:none;" class="xserha">
     
      <table width="100%" height="68" border="0">
 	 <tr>
 	  <td width="10%" align="right" valign="middle" >
		  <label><bean:message bundle="rptResources" key="select.IGSYM1407.totalWay"/>：</label>
      </td>
 	  <td width="15%" align="left" valign="middle" >
 	  	<select id="timetype2"  style="width:90px">
		<option value="day"><bean:message bundle="rptResources" key="select.IGSYM1407.dayTotal"/></option>
		</select>
      </td>
      <td width="27%" align="left" valign="middle" >
      <input type="checkbox" name="checkbox2" value="avg"/><bean:message bundle="rptResources" key="checkbox.IGSYM1407.avg"/>&nbsp;<input type="checkbox" name="checkbox2" value="sum"/><bean:message bundle="rptResources" key="checkbox.IGSYM1407.sum"/>&nbsp;
	  <input type="checkbox" name="checkbox2" value="max"/><bean:message bundle="rptResources" key="checkbox.IGSYM1407.max"/>&nbsp;<input type="checkbox" name="checkbox2" value="min"/><bean:message bundle="rptResources" key="checkbox.IGSYM1407.min"/>&nbsp;
      </td>
      <td width="8%"  rowspan="2" align="right" valign="middle">
       <logic:present name="objectNameList">
 	  	<label><bean:message bundle="rptResources" key="label.IGSYM1407.objName"/>：<br /><bean:message bundle="rptResources" key="select.IGSYM1407.fiveWarn"/></label>
 	  	</logic:present>
      </td>
      <td width="22%" align="right"  rowspan="2" valign="middle">
 	  <logic:present name="objectNameList">
    	<html:select property="objectName2" size="4" multiple="multiple"  style="width:180px">
				<html:options collection="objectNameList" property="value" name="" labelProperty="label" />
		</html:select>
	  </logic:present>
      </td>
     <td width="14%" align="center" rowspan="2" valign="middle">
     	<img alt='<bean:message bundle="rptResources" key="button.IGSYM1407.export"/>' src="images/export.gif" style="cursor: hand" onclick="chgurlPicture('2','export')"/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.collect"/>' src="images/fav2.gif" style="cursor: hand" onclick="collectLink(2)"/><br/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.graphic"/>' src="images/graphic.gif" style="cursor: hand" onclick="chgurlPicture('2','url')"/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.listing"/>' src="images/listing.gif" style="cursor: hand" onclick="chgurlListing('2','url')"/>
      </td>
     </tr>
     <tr>
     <td width="10%" align="right" valign="middle" >
		  <label><bean:message bundle="rptResources" key="label.IGSYM1407.mothTotal"/>：</label>
      </td>
      <td width="15%" align="left" valign="middle" colspan="2">
		<html:text property="bymouth_date" styleId="bymouth_date" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
		 <img src="images/date.gif" onClick="showMonth($('bymouth_date'))" border="0" style="cursor: hand;"/>
      </td>
     </tr>
  </table>
	</div>
	
	<div id="byCdayDiv" style="display:none;" class="xserha">
	<table width="100%" height="68" border="0">
 	 <tr>
 	  <td width="20%" align="right" valign="middle" >
		  <label  style="font-size: 10px"><bean:message bundle="rptResources" key="label.IGSYM1407.selectDate"/>：</label>
		   <html:text size="10" property="bycday_date" styleId="bycday_date" style="inputError imeDisabled;font-size: 8px;" readonly="true"> </html:text>
		  <img src="images/date.gif"  onClick="showDate($('bycday_date'));" border="0" style="cursor: hand;"/>
      </td>
      <td width="6%" align="right" valign="middle"  rowspan="3">
 	  	<input type="button" value="  &gt;  " onclick="addvalue()" style="cursor: hand;"/>
      </td>
      <td width="9%" align="center" valign="middle"  rowspan="3">
 	  	 <label><bean:message bundle="rptResources" key="label.IGSYM1407.selectedDate"/>：<br/><bean:message bundle="rptResources" key="select.IGSYM1407.fiveWarn"/></label>
      </td>
      <td width="14%" align="right" valign="middle"  rowspan="3">
 	  	 <select multiple="multiple" id="cds1" size="4"  style="width:100px">
 	  	 <c:forEach var="cd" begin="0" end="4" items="${IGSYM1407Form.cds1}">
 	  	 	<option value="${cd}">${cd}</option>
 	  	 </c:forEach>
		</select>
      </td>
      <td width="3%" align="right" valign="middle"  rowspan="3">
 	  	<img src="images/close.gif" align="middle"" onClick="delvalue()" border="0" style="cursor: hand;"/>
      </td>
      <td width="8%" align="right" valign="middle"  rowspan="3">
 	  	<logic:present name="objectNameList">
 	  	<label><bean:message bundle="rptResources" key="label.IGSYM1407.objName"/>：<br /><bean:message bundle="rptResources" key="select.IGSYM1407.oneWarn"/></label>
 	  	</logic:present>
      </td>
      <td width="22%" align="right" valign="middle" rowspan="3">
 	  	<logic:present name="objectNameList">
    	<html:select property="objectName3" size="4" multiple="multiple"  style="width:180px">
				<html:options collection="objectNameList" property="value" name="" labelProperty="label" />
		</html:select>
		</logic:present>
     </td>
     <td width="14%" align="center" rowspan="3" valign="middle">
     	<img alt='<bean:message bundle="rptResources" key="button.IGSYM1407.export"/>' src="images/export.gif" style="cursor: hand" onclick="chgurlPicture('3','export')"/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.collect"/>' src="images/fav2.gif" style="cursor: hand" onclick="collectLink(3)"/><br/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.graphic"/>' src="images/graphic.gif" style="cursor: hand" onclick="chgurlPicture('3','url')"/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.listing"/>' src="images/listing.gif" style="cursor: hand" onclick="chgurlListing('3','url')"/>
      </td>
     </tr>
     <tr>
      <td width="20%" align="right" valign="middle">
      	<label style="font-size: 10px"><bean:message bundle="rptResources" key="label.IGSYM1407.startDate"/>：</label>
		<html:text style="font-size: 8px;" property="bycday_timeFrom" styleId="bycday_timeFrom" size="15" value="00:00:00" onclick="_SetTime(this)" readonly="true"/>
		</td>
		</tr>
     <tr>
     <td width="20%" align="right" valign="middle">
		<label style="font-size: 10px"><bean:message bundle="rptResources" key="label.IGSYM1407.endDate"/>：</label>
		<html:text style="font-size: 8px;" property="bycday_timeTo" styleId="bycday_timeTo" size="15" value="23:59:59" onclick="_SetTime(this)" readonly="true"/>
		</td>
     </tr>
  </table>
	</div>
	
	<div id="byCmouthDiv" style="display:none;" align="justify" class="xserha">
	<table width="100%" height="68" border="0">
 	 <tr>
 	  <td width="20%" align="right" valign="middle">
		  <label><bean:message bundle="rptResources" key="label.IGSYM1407.selectMonth"/>：</label>
		  <html:text property="bycmouth_date" styleId="bycmouth_date" errorStyleClass="inputError imeDisabled" size="8" readonly="true"/> 
		  <img src="images/date.gif" onClick="showMonth($('bycmouth_date'))" border="0" style="cursor: hand;"/>
      </td>
      <td width="6%" align="right" valign="middle">
 	  	<input type="button" onclick="addsel()" value="  >  " style="cursor: hand;"> 
      </td>
      <td width="9%" align="center" valign="middle">
 	  	 <label><bean:message bundle="rptResources" key="label.IGSYM1407.selectedMonth"/>：<br/><bean:message bundle="rptResources" key="select.IGSYM1407.fiveWarn"/></label>
      </td>
      <td width="14%" align="right" valign="middle">
 	  	 <select multiple="multiple" id="cms1" size="4" style="width:100px">
 	  	 <c:forEach var="cm" begin="0" end="4" items="${IGSYM1407Form.cms1}">
 	  	 	<option value="${cm}">${cm}</option>
 	  	 </c:forEach>
		</select> 
      </td>
      <td width="3%" align="right" valign="middle">
 	  	<img src="images/close.gif" align="middle" onClick="delsel()" border="0" style="cursor: hand;"/>
      </td>
      <td width="8%" align="right" valign="middle">
       <logic:present name="objectNameList">
 	  	<label><bean:message bundle="rptResources" key="label.IGSYM1407.objName"/>：<br /><bean:message bundle="rptResources" key="select.IGSYM1407.oneWarn"/></label>
 	  	</logic:present>
      </td>
      <td width="22%" align="right" valign="middle">
 	  <logic:present name="objectNameList">
    	<html:select property="objectName4" size="4" multiple="multiple"  style="width:180px">
				<html:options collection="objectNameList" property="value" name="" labelProperty="label" />
		</html:select>
	  </logic:present>
      </td>
      <td width="14%" align="center" rowspan="2" valign="middle">
     	<img alt='<bean:message bundle="rptResources" key="button.IGSYM1407.export"/>' src="images/export.gif" style="cursor: hand" onclick="chgurlPicture('4','export')"/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.collect"/>' src="images/fav2.gif" style="cursor: hand" onclick="collectLink(4)"/><br/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.graphic"/>' src="images/graphic.gif" style="cursor: hand" onclick="chgurlPicture('4','url')"/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.listing"/>' src="images/listing.gif" style="cursor: hand" onclick="chgurlListing('4','url')"/>
      </td>
     </tr>
  </table>
	</div>
	
	<div id="bycountDiv" style="display:none;" class="xserha">
	
	<table width="100%" height="68" border="0">
 	 <tr>
 	  <td width="10%" align="right" valign="middle" >
		  <label><bean:message bundle="rptResources" key="label.IGSYM1407.startDate"/>：</label>
      </td>
 	  <td width="15%" align="left" valign="middle" >
		  <html:text property="bycount_dateFrom" styleId="bycount_dateFrom" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
		  <img src="images/date.gif" onClick="showTime($('bycount_dateFrom'))" border="0" style="cursor: hand;"/>
		  
      </td>
      <td width="27%" align="left" valign="middle" >
     	  <label><bean:message bundle="rptResources" key="label.IGSYM1407.endDate"/>：</label>
		  <html:text property="bycount_dateTo" styleId="bycount_dateTo" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
		  <img src="images/date.gif" onClick="showTime($('bycount_dateTo'))" border="0" style="cursor: hand;"/>
      </td>
      <td width="8%"  rowspan="2" align="right" valign="middle">
       <logic:present name="objectNameList">
 	  	<label><bean:message bundle="rptResources" key="label.IGSYM1407.objName"/>：<br /><bean:message bundle="rptResources" key="select.IGSYM1407.fiveWarn"/></label>
 	  	</logic:present>
      </td>
      <td width="22%" align="right"  rowspan="2" valign="middle">
 	  <logic:present name="objectNameList">
    	<html:select property="objectName5" size="4" multiple="multiple"  style="width:180px">
				<html:options collection="objectNameList" property="value" name="" labelProperty="label" />
		</html:select>
	  </logic:present>
      </td>
     <td width="14%" align="center" rowspan="2" valign="middle">
     	<img alt='<bean:message bundle="rptResources" key="button.IGSYM1407.export"/>' src="images/export.gif" style="cursor: hand" onclick="chgurlPicture('5','export')"/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.collect"/>' src="images/fav2.gif" style="cursor: hand" onclick="collectLink(5)"/><br/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.graphic"/>' src="images/graphic.gif" style="cursor: hand" onclick="chgurlPicture('5','url')"/>
    	<img alt='<bean:message bundle="rptResources" key="img.IGRPT0301.listing"/>' src="images/listing.gif" style="cursor: hand" onclick="chgurlListing('5','url')"/>
      </td>
     </tr>
     <tr>
     <td width="10%" align="right" valign="middle" >
     	<label><bean:message bundle="rptResources" key="select.IGSYM1407.totalWay"/>：</label>
      </td>
     <td width="15%" align="left" valign="middle">
		<select id="timetype3" onchange="change('5')" style="width:90px;font-size: 10px;">
		<option value="none"><bean:message bundle="rptResources" key="select.IGSYM1407.noTotal"/></option>
		<option value="hour"><bean:message bundle="rptResources" key="select.IGSYM1407.hourTotal"/></option>
		<option value="day"><bean:message bundle="rptResources" key="select.IGSYM1407.dayTotal"/></option>
		</select>&nbsp;&nbsp;
     </td>
     <td width="27%" align="left" valign="middle">
     <input type="checkbox" name="checkbox3" value="avg" disabled="disabled"/><bean:message bundle="rptResources" key="checkbox.IGSYM1407.avg"/>&nbsp;<input type="checkbox" name="checkbox3" value="sum" disabled="disabled"/><bean:message bundle="rptResources" key="checkbox.IGSYM1407.sum"/>&nbsp;
	 <input type="checkbox" name="checkbox3" value="max" disabled="disabled"/><bean:message bundle="rptResources" key="checkbox.IGSYM1407.max"/>&nbsp;<input type="checkbox" name="checkbox3" value="min" disabled="disabled"/><bean:message bundle="rptResources" key="checkbox.IGSYM1407.min"/>&nbsp;
     </td>
     </tr>
  </table>
	</div>
</div>
   </div>
   <div class="chart" id="picture">
	<iframe id="birtiOne" width="100%" height="384" frameborder="0" scrolling="auto" src="" ></iframe>
   </div>
    <div class="chart" id="listing">
	<iframe id="birtiTwo" width="100%" height="384" frameborder="0" scrolling="auto" src="" ></iframe>
   </div>
   
</div>
</div>
<html:hidden property="mode"/><!-- 点击5查询个中 哪个 -->
<!-- 下为 birt viewer 框架 -->
<iframe id="birti" width="750" height="331" frameborder="0" scrolling="auto" src="" >
</iframe>
</html:form>
</body>
</html:html>