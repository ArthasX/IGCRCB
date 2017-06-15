<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.text.DecimalFormat"%>
<%
	String contextPath = request.getContextPath();
%>
<html:html>
<bean:define id="id" value="IGPRJ0102" toScope="request" />
<bean:define id="title" value="项目登记" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">   
	function prjSubmit(){  
		if(checkDate("popentime","pclosetime")){
			
			if(document.getElementById("isUseBudget").value=="0001"){
				var count = document.getElementsByName("bid").length;
				if(count<1){
					alert('请选择预算！');
					return false;
				}
				if(checkys()){
					return false;
				}
			}
			
			if($F('pname').trim()==""){
				alert("项目名称不能为空！");
				return false;
			}
			if(document.getElementById("isUseBudget").value=="0002"){
				if(checkprys()){
					return false;
				}
				sum();
				if(parseFloat($F('plimit'))==0){
					alert('项目金额必须大于0！');
					return false;
				}
			}
			if($F('popentime').trim()==""){
				alert("开始时间不能为空！");
				return false;
			}
			if($F('pplanclosetime').trim()==""){
				alert("计划结束时间不能为空！");
				return false;
			}
			if($F('pclosetime').trim()==""){
				alert("实际结束时间不能为空！");
				return false;
			}
			if($F('pcode').trim()!=""){
			 	var regExp=/[\u4E00-\u9FA5]/g;
				if(regExp.test($('pcode').value)){
					alert("项目编号不能输入汉字");
					$('pcode').value = "";
					return false;
				}
			}
			if($F('pcode').strlen()>32){
				alert("项目编号不能大于32个字符！");
				return false;
			}
			if($F('pname').strlen()>128){
				alert("项目名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
				return false;
			}
			if($F('pdesc').strlen()>512){
				alert("项目简介不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				return false;
			}
			if($F('paim').strlen()>512){
				alert("项目目的的长度不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				return false;
			}
			if($F('ppurpose').strlen()>512){
				alert("项目用途的长度不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
				return false;
			}
			if(confirm("是否确认提交")){
				document.forms[0].submit();
			}
		}else{
			alert("开始时间需小于结束时间！");
		}
	}
	
	function checkNumber(obj,yscheckName,itemName){   
			var pindex = obj.value.indexOf(".")==-1?obj.value.length:obj.value.indexOf(".");
			var temp1 = obj.value.substr(0,pindex);
			var temp2 = obj.value.substr(pindex+1);
	        if(temp1.length > 6){
	        	alert(yscheckName+itemName+"整数部分最多可以输入6位数字！");
	            return true;   
	        }
	        if(temp2.length > 2){
	        	alert(yscheckName+itemName+"小数部分最多可以输入2位数字！");
	            return true;   
	        }
	       	return false;   
	}
	
	function sendRequest(){
		var bidobj = document.getElementsByName("bid");
		var bids='';
		if(bidobj.length>0){
			for(var i=0;i<bidobj.length;i++){
				if(i==0){
					bids= bidobj[i].value;
				}else{
					bids+=(','+bidobj[i].value);
				}
			}
		}
		var url = "/IGFIN0104.do?bids="+bids;
		openSubWindow(url,'_blank','1100','400');
	}

	function sum(){
		var isUse = document.getElementById("isUseBudget").value;
		var count = document.getElementsByName("bid").length;
		var bamount=0;
		if(isUse=='0001'){
			if(count<1){
				alert('请选择预算！');
				return;
			}
			if(checkys()){
				return;
			}
			var sub1 = document.getElementsByName("bzdevelop");
			var sub2 = document.getElementsByName("bzhardware");
			var sub3 = document.getElementsByName("bzsoftware");
			var sub4 = document.getElementsByName("bzproject");
			var sub5 = document.getElementsByName("bzelse");
			var sub6 = document.getElementsByName("bcimplement");
			var sub7 = document.getElementsByName("bcelse");
			var pb1 = 0;
			var pb2 = 0;
			var pb3 = 0;
			var pb4 = 0;
			var pb5 = 0;
			var pb6 = 0;
			var pb7 = 0;
			for(var i=0;i<sub1.length;i++){
				if(fIsNumber(sub1[i].value.trim()==''?0:sub1[i].value)&&
					fIsNumber(sub2[i].value.trim()==''?0:sub2[i].value)&&
					fIsNumber(sub3[i].value.trim()==''?0:sub3[i].value)&&
					fIsNumber(sub4[i].value.trim()==''?0:sub4[i].value)&&
					fIsNumber(sub5[i].value.trim()==''?0:sub5[i].value)&&
					fIsNumber(sub6[i].value.trim()==''?0:sub6[i].value)&&
					fIsNumber(sub7[i].value.trim()==''?0:sub7[i].value)){
					pb1+=parseFloat(sub1[i].value.trim()==''?0:sub1[i].value);
					pb2+=parseFloat(sub2[i].value.trim()==''?0:sub2[i].value);
					pb3+=parseFloat(sub3[i].value.trim()==''?0:sub3[i].value);
					pb4+=parseFloat(sub4[i].value.trim()==''?0:sub4[i].value);
					pb5+=parseFloat(sub5[i].value.trim()==''?0:sub5[i].value);
					pb6+=parseFloat(sub6[i].value.trim()==''?0:sub6[i].value);
					pb7+=parseFloat(sub7[i].value.trim()==''?0:sub7[i].value);
				}else{
					alert('使用预算金额必须为数字！');
					return;
				}
				
			}
			document.getElementById("pbzdevelop").value=pb1;
			document.getElementById("pbzhardware").value=pb2;
			document.getElementById("pbzsoftware").value=pb3;
			document.getElementById("pbzproject").value=pb4;
			document.getElementById("pbzelse").value=pb5;
			document.getElementById("pbcimplement").value=pb6;
			document.getElementById("pbcelse").value=pb7;
			bamount=pb1+pb2+pb3+pb4+pb5+pb6+pb7;
		}else{
			if(checkprys()){
				return;
			}
			var sub1 = document.getElementById("pbzdevelop").value;
			var sub2 = document.getElementById("pbzhardware").value;
			var sub3 = document.getElementById("pbzsoftware").value;
			var sub4 = document.getElementById("pbzproject").value;
			var sub5 = document.getElementById("pbzelse").value;
			var sub6 = document.getElementById("pbcimplement").value;
			var sub7 = document.getElementById("pbcelse").value;
			if(fIsNumber(sub1.trim()==''?0:sub1)&&
				fIsNumber(sub2.trim()==''?0:sub2)&&
				fIsNumber(sub3.trim()==''?0:sub3)&&
				fIsNumber(sub4.trim()==''?0:sub4)&&
				fIsNumber(sub5.trim()==''?0:sub5)&&
				fIsNumber(sub6.trim()==''?0:sub6)&&
				fIsNumber(sub7.trim()==''?0:sub7)){
				bamount = parseFloat(sub1.trim()==''?0:sub1) + 
						  parseFloat(sub2.trim()==''?0:sub2) + 
						  parseFloat(sub3.trim()==''?0:sub3) + 
						  parseFloat(sub4.trim()==''?0:sub4) + 
						  parseFloat(sub5.trim()==''?0:sub5) + 
						  parseFloat(sub6.trim()==''?0:sub6) + 
						  parseFloat(sub7.trim()==''?0:sub7);
			}else{
				alert('使用预算金额必须为数字！');
				return;
			}
		}
		document.getElementById("plimit").value = bamount+''.substring(0, bamount+''.indexOf('.')+3);
	}

	function isUseChange(isUse){
		var img = document.getElementById('img');
		var ysbox = document.getElementById('ysbox');
		var pb1 = document.getElementById("pbzdevelop");
		var pb2 = document.getElementById("pbzhardware");
		var pb3 = document.getElementById("pbzsoftware");
		var pb4 = document.getElementById("pbzproject");
		var pb5 = document.getElementById("pbzelse");
		var pb6 = document.getElementById("pbcimplement");
		var pb7 = document.getElementById("pbcelse");
		var sub1 = document.getElementsByName("bzdevelop");
		var sub2 = document.getElementsByName("bzhardware");
		var sub3 = document.getElementsByName("bzsoftware");
		var sub4 = document.getElementsByName("bzproject");
		var sub5 = document.getElementsByName("bzelse");
		var sub6 = document.getElementsByName("bcimplement");
		var sub7 = document.getElementsByName("bcelse");
		if(isUse=='0001'){
			img.style.display = 'inline';
			ysbox.style.display = 'block';
			pb1.readOnly=true;
			pb2.readOnly=true;
			pb3.readOnly=true;
			pb4.readOnly=true;
			pb5.readOnly=true;
			pb6.readOnly=true;
			pb7.readOnly=true;
			pb1.value='0.0';
			pb2.value='0.0';
			pb3.value='0.0';
			pb4.value='0.0';
			pb5.value='0.0';
			pb6.value='0.0';
			pb7.value='0.0';
		}else{
			img.style.display = 'none';
			ysbox.style.display = 'none';
			pb1.readOnly=false;
			pb2.readOnly=false;
			pb3.readOnly=false;
			pb4.readOnly=false;
			pb5.readOnly=false;
			pb6.readOnly=false;
			pb7.readOnly=false;
			for(var i=0;i<sub1.length;i++){
				sub1[i].value='0.0';
				sub2[i].value='0.0';
				sub3[i].value='0.0';
				sub4[i].value='0.0';
				sub5[i].value='0.0';
				sub6[i].value='0.0';
				sub7[i].value='0.0';
			}
		}
	}
	
	function setPanrentParem(parm){
		var tb = document.getElementById("ystable");
		var tr ;
		var td1,td2,td3,td4,td5,td6,td7,td8,td9,td10;
		var index =0;
		for(var i=0;i<parm.length;i++){
			var rowIndex = tb.rows.length;
			tr=tb.insertRow(rowIndex);
			td1 = tr.insertCell(0);
			td2 = tr.insertCell(1);
			td3 = tr.insertCell(2);
			td4 = tr.insertCell(3);
			td5 = tr.insertCell(4);
			td6 = tr.insertCell(5);
			td7 = tr.insertCell(6);
			td8 = tr.insertCell(7);
			td9 = tr.insertCell(8);
			td10 = tr.insertCell(9);
			td1.rowSpan=2;
			td10.rowSpan=2;
			td1.innerHTML=parm[i][1]+'<input type="hidden" name="bname_check" value="'+parm[i][1]+'" />';
			td2.innerHTML='可用预算';
			td3.innerHTML=parm[i][2]+'<input type="hidden" name="bzdevelop_check" value="'+parm[i][2]+'" />';
			td4.innerHTML=parm[i][3]+'<input type="hidden" name="bzhardware_check" value="'+parm[i][3]+'" />';
			td5.innerHTML=parm[i][4]+'<input type="hidden" name="bzsoftware_check" value="'+parm[i][4]+'" />';
			td6.innerHTML=parm[i][5]+'<input type="hidden" name="bzproject_check" value="'+parm[i][5]+'" />';
			td7.innerHTML=parm[i][6]+'<input type="hidden" name="bzelse_check" value="'+parm[i][6]+'" />';
			td8.innerHTML=parm[i][7]+'<input type="hidden" name="bcimplement_check" value="'+parm[i][7]+'" />';
			td9.innerHTML=parm[i][8]+'<input type="hidden" name="bcelse_check" value="'+parm[i][8]+'" />';
			td10.innerHTML='<a href="javascript:deletetrs('+parm[i][0]+')">删除</a>';
			tr.id=parm[i][0];
			tr=tb.insertRow(rowIndex+1);
			td2 = tr.insertCell(0);
			td3 = tr.insertCell(1);
			td4 = tr.insertCell(2);
			td5 = tr.insertCell(3);
			td6 = tr.insertCell(4);
			td7 = tr.insertCell(5);
			td8 = tr.insertCell(6);
			td9 = tr.insertCell(7);
			td2.innerHTML='使用预算<input type="hidden" name="bid" value="'+parm[i][0]+'" />';
			td3.innerHTML='<input type="text" name="bzdevelop" value="0.0" size="5">';
			td4.innerHTML='<input type="text" name="bzhardware" value="0.0" size="5"></td>';
			td5.innerHTML='<input type="text" name="bzsoftware" value="0.0" size="5">';
			td6.innerHTML='<input type="text" name="bzproject" value="0.0" size="5">';
			td7.innerHTML='<input type="text" name="bzelse" value="0.0" size="5">';
			td8.innerHTML='<input type="text" name="bcimplement" value="0.0" size="5">';
			td9.innerHTML='<input type="text" name="bcelse" value="0.0" size="5">';
			index+=2;
		}
	}
	function deletetrs(obj){
		var tb = document.getElementById("ystable");
		var idx = document.getElementById(obj).rowIndex;
		tb.deleteRow(idx);
		tb.deleteRow(idx);
	}
	
	function checkys(){
		var sub1 = document.getElementsByName("bzdevelop");
		var sub2 = document.getElementsByName("bzhardware");
		var sub3 = document.getElementsByName("bzsoftware");
		var sub4 = document.getElementsByName("bzproject");
		var sub5 = document.getElementsByName("bzelse");
		var sub6 = document.getElementsByName("bcimplement");
		var sub7 = document.getElementsByName("bcelse");
		var checksub1 = document.getElementsByName("bzdevelop_check");
		var checksub2 = document.getElementsByName("bzhardware_check");
		var checksub3 = document.getElementsByName("bzsoftware_check");
		var checksub4 = document.getElementsByName("bzproject_check");
		var checksub5 = document.getElementsByName("bzelse_check");
		var checksub6 = document.getElementsByName("bcimplement_check");
		var checksub7 = document.getElementsByName("bcelse_check");
		var checkbname = document.getElementsByName("bname_check");
		for(var i=0;i<sub1.length;i++){
			if(isNaN(sub1[i].value)){
				alert('请在'+checkbname[i].value+'资本金开发使用预算内输入数字！');
				return true;
			}
			if(sub1[i].value.trim()==''){
				alert(checkbname[i].value+'资本金开发使用预算必须大于0或等于0！');
				return true;
			}
			if(checkNumber(sub1[i],checkbname[i].value,'使用资本金开发')){
				return true;
			}
			if(parseFloat(sub1[i].value)>parseFloat(checksub1[i].value)){
				alert(checkbname[i].value+'资本金开发使用预算大于可用开发资本金！');
				return true;
			}
			if(isNaN(sub2[i].value)){
				alert('请在'+checkbname[i].value+'资本金硬件使用预算内输入数字！');
				return true;
			}
			if(sub2[i].value.trim()==''){
				alert(checkbname[i].value+'资本金硬件使用预算必须大于0或等于0！');
				return true;
			}
			if(checkNumber(sub2[i],checkbname[i].value,'使用资本金硬件')){
				return true;
			}
			if(parseFloat(sub2[i].value)>parseFloat(checksub2[i].value)){
				alert(checkbname[i].value+'资本金硬件使用预算大于可用资本金硬件！');
				return true;
			}
			if(isNaN(sub3[i].value)){
				alert('请在'+checkbname[i].value+'资本金软件使用预算内输入数字！');
				return true;
			}
			if(sub3[i].value.trim()==''){
				alert(checkbname[i].value+'资本金软件使用预算必须大于0或等于0！');
				return true;
			}
			if(checkNumber(sub3[i],checkbname[i].value,'使用资本金软件')){
				return true;
			}
			if(parseFloat(sub3[i].value)>parseFloat(checksub3[i].value)){
				alert(checkbname[i].value+'资本金软件使用预算大于可用资本金软件！');
				return true;
			}
			if(isNaN(sub4[i].value)){
				alert('请在'+checkbname[i].value+'资本金工程使用预算内输入数字！');
				return true;
			}
			if(sub4[i].value.trim()==''){
				alert(checkbname[i].value+'资本金工程使用预算必须大于0或等于0！');
				return true;
			}
			if(checkNumber(sub4[i],checkbname[i].value,'使用资本金工程')){
				return true;
			}
			if(parseFloat(sub4[i].value)>parseFloat(checksub4[i].value)){
				alert(checkbname[i].value+'资本金工程使用预算大于可用资本金工程！');
				return true;
			}
			if(isNaN(sub5[i].value)){
				alert('请在'+checkbname[i].value+'资本金其他使用预算内输入数字！');
				return true;
			}
			if(sub5[i].value.trim()==''){
				alert(+checkbname[i].value+'资本金其他使用预算必须大于0或等于0！');
				return true;
			}
			if(checkNumber(sub5[i],checkbname[i].value,'使用资本金其他')){
				return true;
			}
			if(parseFloat(sub5[i].value)>parseFloat(checksub5[i].value)){
				alert(checkbname[i].value+'资本金其他使用预算大于可用资本金其他！');
				return true;
			}
			if(isNaN(sub6[i].value)){
				alert('请在'+checkbname[i].value+'成本金实施使用预算内输入数字！');
				return true;
			}
			if(sub6[i].value.trim()==''){
				alert(checkbname[i].value+'成本金实施使用预算必须大于0或等于0！');
				return true;
			}
			if(checkNumber(sub6[i],checkbname[i].value,'使用成本金实施')){
				return true;
			}
			if(parseFloat(sub6[i].value)>parseFloat(checksub6[i].value)){
				alert(checkbname[i].value+'成本金实施使用预算大于可用成本金实施！');
				return true;
			}
			if(isNaN(sub7[i].value)){
				alert('请在'+checkbname[i].value+'成本金其他使用预算内输入数字！');
				return true;
			}
			if(sub7[i].value.trim()==''){
				alert(checkbname[i].value+'成本金其他使用预算必须大于0或等于0！');
				return true;
			}
			if(checkNumber(sub7[i],checkbname[i].value,'使用成本金其他')){
				return true;
			}
			if(parseFloat(sub7[i].value)>parseFloat(checksub7[i].value)){
				alert(checkbname[i].value+'成本金其他使用预算大于可用成本金其他！');
				return true;
			}
			if(parseFloat(sub1[i].value)+parseFloat(sub2[i].value)+parseFloat(sub3[i].value)+parseFloat(sub4[i].value)+parseFloat(sub5[i].value)+parseFloat(sub6[i].value)+parseFloat(sub7[i].value)==0.0){
				alert(checkbname[i].value+'使用预算必须大于0！');
				return true;
			}
		}
		return false;
	}
	function checkprys(){
		if($F("pbzdevelop").trim()==""){
			alert('项目资本金开发必须大于0或等于0！');
			return true;
		}
		if(isNaN($F("pbzdevelop"))){
			alert('项目资本金开发内请输入数字！');
			return true;
		}
		if(checkNumber($('pbzdevelop'),"",'项目资本金开发')){
			return true;
		}
		if($F("pbzhardware").trim()==""){
			alert('项目资本金软件必须大于0或等于0！');
			return true;
		}
		if(isNaN($F("pbzhardware"))){
			alert('项目资本金软件内请输入数字！');
			return true;
		}
		if(checkNumber($('pbzhardware'),"",'项目资本金软件')){
			return true;
		}
		if($F("pbzsoftware").trim()==""){
			alert('项目资本金硬件必须大于0或等于0！');
			return true;
		}
		if(isNaN($F("pbzsoftware"))){
			alert('项目资本金硬件内请输入数字！');
			return true;
		}
		if(checkNumber($('pbzsoftware'),"",'项目资本金硬件')){
			return true;
		}
		if($F("pbzproject").trim()==""){
			alert('项目资本金工程必须大于0或等于0！');
			return true;
		}
		if(isNaN($F("pbzproject"))){
			alert('项目资本金工程内请输入数字！');
			return true;
		}
		if(checkNumber($('pbzproject'),"",'项目资本金工程')){
			return true;
		}
		if($F("pbzelse").trim()==""){
			alert('项目资本金其他必须大于0或等于0！');
			return true;
		}
		if(isNaN($F("pbzelse"))){
			alert('项目资本金其他内请输入数字！');
			return true;
		}
		if(checkNumber($('pbzelse'),"",'项目资本金其他')){
			return true;
		}
		if($F("pbcimplement").trim()==""){
			alert('项目成本金实施必须大于0或等于0！');
			return true;
		}
		if(isNaN($F("pbcimplement"))){
			alert('项目成本金实施内请输入数字！');
			return true;
		}
		if(checkNumber($('pbcimplement'),"",'项目成本金实施')){
			return true;
		}
		if($F("pbcelse").trim()==""){
			alert('项目成本金其他必须大于0或等于0！');
			return true;
		}
		if(isNaN($F("pbcelse"))){
			alert('项目成本金其他内请输入数字！');
			return true;
		}
		if(checkNumber($('pbcelse'),"",'项目成本金其他')){
			return true;
		}
	}
</script>

<body onload="isUseChange('0001')">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
	 <!--content  右侧内容-->
	 
 <div id="contentWrap">
   <div id="content">
      <div id="location">
       <div class="image"></div>
        <p class="fonts1">服务管理 &gt;&gt; 项目管理 &gt;&gt; 项目登记</p>
       
     </div>
      
   <div id="formwrapper">
       <html:form action="/IGPRJ0102.do" method="post">
       <ig:message />
       
       	<fieldset>
        	<legend>预算信息</legend>
         <div>
            <label for="Name"><strong>使用预算</strong>：</label>
			<html:select property="isUseBudget" style="width: 100px;" errorStyleClass="inputError" onchange="isUseChange(this.value)">
            	<ig:optionsCollection ccid="Project_ISUSEBUDGET" isMakeBlankRow="false" isCodeLabel="true" />
             </html:select>	
             <img id="img" src="images/tree.gif" style="cursor: hand;" alt="选择预算" width="16" height="16" border="0" onclick="sendRequest();"/>
          <br />
     	  </div>
     	  
     	  <div id="ysbox">
     	  	<table class="table_style" id="ystable">
     	  		<tr>
					<th width="20%" style="background-color:#e4f8ed; ">分类</th>
					<th colspan="6" style="background-color:#e1edf9; ">资本金(万元)</th>
					<th colspan="2" style="background-color:#faecdf; ">成本金(万元)</th>
					<th style="background-color:#e4f8ed; ">操作</th>
				</tr>
				<tr>
					<th width="20%" style="background-color:#e4f8ed; ">类别</th>
					<th style="background-color:#e1edf9; "></th>
					<th style="background-color:#e1edf9; ">开发</th>
					<th style="background-color:#e1edf9; ">硬件</th>
					<th style="background-color:#e1edf9; ">软件</th>
					<th style="background-color:#e1edf9; ">工程</th>
					<th style="background-color:#e1edf9; ">其他</th>
					<th style="background-color:#faecdf; ">实施</th>
					<th style="background-color:#faecdf; ">其他</th>
					<th style="background-color:#e4f8ed; ">删除</th>
				</tr>		

     	  	</table>
     	  </div>
        </fieldset>
       
        <fieldset>
        <legend>项目信息</legend>
       
       <div>
            <label for="Name"><strong><span class="red">*</span>项目名称</strong>：</label>
             <html:text property="pname" size="40"/>
            <br />
       </div>
        <div>
            <label for="Name"><strong>项目编号</strong>：</label>
           <html:text property="pcode" size="40"/>
            <br />
       </div>
        <div>
            <label for="Name"><strong><span class="red">*</span>项目性质</strong>：</label>
			<html:select property="ppquality" style="width: 100px;" errorStyleClass="inputError">
            	<ig:optionsCollection ccid="Project_QUALITY" isMakeBlankRow="false" isCodeLabel="true" />
             </html:select>	
         </div>
         <div>
            <label for="Name"><strong><span class="red">*</span>项目类别</strong>：</label>
			<html:select property="ptype" style="width: 100px;" errorStyleClass="inputError">
            	<ig:optionsCollection ccid="Project_CATEGORY" isMakeBlankRow="false" isCodeLabel="true" />
             </html:select>	
         </div>
        <div>
            <label for="Name"><strong><span class="red">*</span>资本金</strong>：</label>
            <br />
            <div style=" margin-left:95px;">
            <table>
            	<tr>
            		<td>
	           			开发:<input type="text" id="pbzdevelop" name="pbzdevelop" value="0.0" size="16"/>(万元)
			        </td>
			    </tr>
			    <tr>
			        <td>
						硬件:<input type="text" id="pbzhardware" name="pbzhardware" value="0.0" size="16"/>(万元)
					</td>
				</tr>
			    <tr>
					<td>
						软件:<input type="text" id="pbzsoftware" name="pbzsoftware" value="0.0" size="16"/>(万元)
					</td>
				</tr>
			    <tr>
					<td>
						工程:<input type="text" id="pbzproject" name="pbzproject" value="0.0" size="16"/>(万元)
					</td>
				</tr>
			    <tr>
					<td>
						其他:<input type="text" id="pbzelse" name="pbzelse" value="0.0" size="16"/>(万元)
					</td>
				</tr>
        	</table>
        	</div>
        </div>
         <div>
            <label for="Name"><strong><span class="red">*</span>成本金</strong>：</label>
            <br />
            <div style=" margin-left:95px;">
            <table>
            	<tr>
            		<td>
			           	实施:<input type="text" id="pbcimplement" name="pbcimplement" value="0.0" size="16"/>(万元)
			        </td>
			    </tr>
			    <tr>
			        <td>
						其他:<input type="text" id="pbcelse" name="pbcelse" value="0.0" size="16"/>(万元)
					</td>
				</tr>
				</table>
			</div>
        </div>
        <div>
            <label for="Name"><strong><span class="red">*</span>项目金额</strong>：</label>
            <input type="text" id="plimit" name="plimit" size="16" readonly/>(万元)&nbsp;&nbsp;&nbsp;&nbsp;
            <input type="button" class="button" onclick="sum()" value="计算预算金额">
          	<br/>
        </div>
      
       <div>
          <label for="Name"><strong><span class="red">*</span>开始时间</strong>：</label>
          	 <html:text property="popentime" size="16" readonly="true" />
	                        <img src="<%=contextPath %>/images/date.gif" onClick="calendar($('popentime'))" style="cursor: hand" border=0 />
          <br />
        </div>
         <div>
          <label for="Name"><strong><span class="red">*</span>计划结束时间</strong>：</label>
          
			 <html:text property="pplanclosetime" size="16" readonly="true" />
                            <img src="<%=contextPath %>/images/date.gif" onClick="calendar($('pplanclosetime'))" style="cursor: hand" border=0 />
                           
          <br />
          
        </div>
        <div>
          <label for="Name"><strong><span class="red">*</span>实际结束时间</strong>：</label>
          
			 <html:text property="pclosetime" size="16" readonly="true" />
                            <img src="<%=contextPath %>/images/date.gif" onClick="calendar($('pclosetime'))" style="cursor: hand" border=0 />
                           
          <br />
          
        </div>
         <div>
            <label for="Name"><strong>项目简介</strong>：</label>
     		<html:textarea property="pdesc" cols="80" rows="6"></html:textarea>
          <br />
         </div>
          <div>
            <label for="Name"><strong>项目目的</strong>：</label>
             <html:textarea property="paim" cols="80" rows="6"></html:textarea>
            <br />
       	</div>
       	<div>
            <label for="Name"><strong>项目用途</strong>：</label>
             <html:textarea property="ppurpose" cols="80" rows="6"></html:textarea>
            <br />
       	</div>
        
        <div>
            <label for="Name"><strong>需求部门</strong>：</label>
            <html:select property="pbranch" style="width: 100px;" errorStyleClass="inputError">
            <ig:optionsCollection ccid="Project_NEEDBRANCH" isMakeBlankRow="false" isCodeLabel="true" />
             </html:select>
			<br>
        </div>
        </fieldset>
    <div class="enter">
   		<input name="pstatus" type="hidden" value="O" /> 
        <input name="save" type="button" class="button" value="提交" onclick="prjSubmit();" />
        <input name="cancel" type="reset" class="button" value="重置" />
    </div>
    </html:form>
     </div>
   </div>

   </div>
  </div>


</div>
</body>
</html:html>