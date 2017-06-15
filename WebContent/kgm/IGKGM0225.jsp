<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGKGM0225" toScope="request" />
<bean:define id="title" value="知识审批画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> 
.file { font: 10pt; color: black; } 
#busSysBox span{margin-right: 5px;}
</style>
<script src="js/json.js" type="text/javascript"></script>
<script src="js/jquery-1.9.1.min.js" type="text/javascript"></script>
<script type="text/javascript">
	var jq = jQuery.noConflict(true);
</script>
<script type="text/javascript">

//将字符串中间的多余空格都替换为1个空格
function mytrim(str){
	return str.replace(/[\s]+/g," ");
}

//去掉字符串两边的空格
function mytrim2(str){
	for(var  i  =  0  ;  i<str.length  &&  str.charAt(i)==" "  ;  i++  )  ;
	for(var  j  =str.length;  j>0  &&  str.charAt(j-1)==" "  ;  j--)  ;
	if(i>j)  return  "";  
	return  str.substring(i,j);  
}

//删除附件
function delFile(attid){
	 if( window.confirm("您是否确定删除附件？")){
		 document.getElementById(attid).innerHTML="";
		var delFileValue = document.forms[0].delFiles.value;
		delFileValue=delFileValue+attid+"|";
		document.forms[0].delFiles.value=delFileValue;
     } 
}

function confirmCheck(){

	if($F('kntitle').strlen()==0){
		alert("标题不能为空！");
		return false;
	}

	if($F('knfaultcause').strlen()==0){
		alert("问题描述不能为空！");
		return false;
	}

	if($F('knsolveway').strlen()==0){
		alert("解决办法不能为空！");
		return false;
	}
	var knkeysChecks = document.getElementsByName("knkeys");
	var isSelect = "N";
	for(var i=0;i<knkeysChecks.length;i++){
		if(knkeysChecks[i].checked){
			isSelect = "Y";
		}
	}
	if($F('knkey_p').strlen()==0 && isSelect=="N"){
		alert("关键字不能为空！");
		return false;
	}
	if($F('kntitle').strlen()>200){
		alert("标题不能大于"+Math.floor(200/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('knkey_p').strlen()>128){
		alert("关键字不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('knfaultcause').strlen()>1000){
		alert("问题描述不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('knsolveway').strlen()>1000){
		alert("解决办法不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('kndes').strlen()>1000){
		alert("知识描述不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('knapproverole').trim()==""){
		alert("请选择知识审批人！");
		return false;
	}
	if(confirm("是否确认提交")){
		checkAndCreate_Knowledge();
		var url = "IGKGM0201_CHECKPASS.do";
		document.forms[0].action=url;
		document.forms[0].submit();
		return true;
	}else{
		return false;
	}
		
}

function confirmDisp(){

	if($F('kntitle').strlen()==0){
		alert("标题不能为空！");
		return false;
	}

	if($F('knfaultcause').strlen()==0){
		alert("问题描述不能为空！");
		return false;
	}

	if($F('knsolveway').strlen()==0){
		alert("解决办法不能为空！");
		return false;
	}
	var knkeysChecks = document.getElementsByName("knkeys");
	var isSelect = "N";
	for(var i=0;i<knkeysChecks.length;i++){
		if(knkeysChecks[i].checked){
			isSelect = "Y";
		}
	}
	if($F('knkey_p').strlen()==0 && isSelect=="N"){
		alert("关键字不能为空！");
		return false;
	}
	if($F('kntitle').strlen()>200){
		alert("标题不能大于"+Math.floor(200/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('knkey_p').strlen()>128){
		alert("关键字不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}

	if($F('knfaultcause').strlen()>1000){
		alert("问题描述不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('knsolveway').strlen()>1000){
		alert("解决办法不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('kndes').strlen()>1000){
		alert("知识描述不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
		return false;
	}

	if($F('knapproverole').trim()==""){
		alert("请选择知识审批人！");
		return false;
	}
	
	if(confirm("是否确认保存")){
		checkAndCreate_Knowledge();
		checkAndCreate();
		return true;
	}else{
		return false;
	}
		
}


var prNum = 0;
var num = 0;
function addPr() 
{	
	var cell=tbPr.insertRow().insertCell();
	cell.innerHTML= "<input type='text' name='processName["+prNum+"]' size='40' readonly='true' errorStyleClass='inputError imeActive'><img src='images/seek.gif' border='0' width='16' height='16' alt='查询' onclick=\"selectProcess("+prNum+")\" style='cursor: hand'/>&nbsp;&nbsp;<img src='images/delate.gif' alt='删除' onclick=\"deletePr(this)\" style='cursor: hand'/><input type='hidden' name='processId["+prNum+"]'/>";
	prNum++;
}


function deletePr(obj)
{
	var curRow= obj.parentNode.parentNode;
	tbPr.deleteRow(curRow.rowIndex);
}

function selectProcess(index){
	num = index;
	openSubWindow('/IGSVC0107_Disp.do?prActive=NA', '_blank','1000','600');
}

function checkAndCreate(){
	var count=0;
	var prkeys = document.getElementsByName("prkey");

	for(var i=0;i<prkeys.length;i++){
		if(prkeys[i].checked==true){
			count=1;
			createHiddenInput("prkkeys",prkeys[i].value);

		}
	}
	return count;
}

function addFile() {
	currRow=tb.insertRow();
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='file' class='inputbutton' name='attachFile["+num+"]'><input type='hidden' name='rlattkey'/><input type='button' class='delbutton' value='删除' onclick='deleteitem(this)'>";
	num++;
}

function deleteitem(obj){
	var curRow= obj.parentNode.parentNode;
	tb.deleteRow(curRow.rowIndex);
}

function setOrg(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].radorgcoding.value = "";
		document.forms[0].radorg.value = "";
		return false;
	}
	
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].radorgcoding.value = temp.split("|")[0];
		document.forms[0].radorg.value = temp.split("|")[1];
	}		

}



function showTecknowlegyArea(){
	var ccid = '255';
	var url = "IGSYM1202_TREE_BY_STATUS.do?ccid="+ccid;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");

	if("_resetall"==temp){
		$("kntelarea").value = "";
		$("kntelareaname").value = "";
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

		if(treesyscode!=null && name!=null){
			$("kntelarea").value = treesyscode;
			$("kntelareaname").value = name;
		}
		
	}		

}


function showDataFrom(){
	var ccid = "254";
	var cid = "";
	var syscode = "";
	if(null==syscode || ""==syscode){
		syscode = ccid;
	}else{
		ccid = syscode.substring(0,3);
	}

	url = "IGSYM1202_TREE_BY_STATUS.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("knorigin").value="";
		$("knoriginname").value="";
			return false;
		}
	if(null!=temp && temp.split("|").length>1){
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
		$("knorigin").value=treesyscode;
		$("knoriginname").value=name;
		
	}		
	
}

function showIncident(){
	var ccid = "252";
	var cid = "";
	var syscode = "";
	if(null==syscode || ""==syscode){
		syscode = ccid;
	}else{
		ccid = syscode.substring(0,3);
	}

	url = "IGSYM1202_TREE_BY_STATUS.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("knclass").value="";
		$("knclassname").value="";
			return false;
		}
		
	if(null!=temp && temp.split("|").length>1){
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
		$("knclass").value=treesyscode;
		$("knclassname").value=name;
		
	}		
	
}

function setParams(prid,prtype,prtitle){
	if("" == prid){
		$("processId[" + num + "]").value = "";
		$("processName[" + num + "]").value = "";
		$("processName[" + num + "]").onclick = "";
		$("processName[" + num + "]").style.cursor = "";
	} else {
		var tags = document.getElementsByTagName("INPUT");
		for(var i = 0; i < tags.length; i++){
			if(tags[i].name.indexOf("processId") == 0) {
				if(tags[i].value == prid){
				 	alert("选择的流程已添加！");
				 	return false;
				}
			}
		}
		$("processId[" + num + "]").value = prid;
		$("processName[" + num + "]").value = prtitle;
		$("processName[" + num + "]").onclick = function (){openRelatedProcess(prid,prtype);};
		$("processName[" + num + "]").style.cursor = "hand";
		if($("kntitle").value == ""){
			$("kntitle").value=prtitle;
		}
	}
num = 0;
}

function checkAndCreate_Knowledge(){
	var count = 0;
	var total = 0;
	var check = document.getElementsByName("system_add");
	
	for(var i=0;i<check.length;i++){
		if(check[i].checked==true){
			count=1;
			createHiddenInput("kaicodes",check[i].value);
		}else if(check[i].checked==false){
			createHiddenInput("kaicodes","");
		}
	}
    return count;
}

function updKnkey_p(obj) {
	if(!obj.checked && $F('knkey_p').trim() != "") {
		var str_array = $F('knkey_p').split(" ");
		var str = "";
		for(var i = 0; i < str_array.length; i++) {
			if(str_array[i] != obj.value && str_array[i] != " " && str_array[i] != "") {
				str += str_array[i];
				str += " ";
			}
		}
		$('knkey_p').value = str.trim();
	}
}

var  defknapproverole;

function knappchange(){
	alert("不允许更改知识审批人");
	$('knapproverole').value = defknapproverole;
}

function filterKnkey_p(){
	var check = document.getElementsByName("knkeys");

	
	var str = $F('knkey_p');
	
	for(var i=0;i<check.length;i++){
		str = str.replace(check[i].value.trim(),"");		
	}
	var str_array = str.split(" ");
	str="";
	for(var i = 0; i < str_array.length; i++) {
			str += str_array[i].trim();
			str += " ";
	}
	
	$('knkey_p').value = str.trim();

	defknapproverole = $F('knapproverole');
}

function goPage(){
	var url = "IGKGM0214_CHECK.do";
	var knid = document.getElementsByName("knid")[0].value;
	var knversion = document.getElementsByName("knversion")[0].value;
	document.forms[0].action=url+"?knid="+knid+"&knversion="+knversion+"&knflag=0";
	document.forms[0].submit();
}
function openBusinessSystem(){
	var paramObj = [];
	
	jq("#busSysBox span").each(function(i,t){
		t = jq(t);
		paramObj.push({syscoding:t.next().val().split("_")[0],cvalue:t.text()});
	});
	
	var param = "";
	if(paramObj.length>0){
		param = JSON.stringify(paramObj);
		param = encodeURI(encodeURI(param));
	}
	
	var temp = window.showModalDialog(getAppRootUrl() + "/IGKGM0233_Disp.do?exitsbussys="+param,
            null,"dialogWidth:800px;dialogHeight:500px;status:no;help:no;resizable:no");
	var result = jq.parseJSON(temp);
	
	jq("#busSysBox span ,#busSysBox :hidden").remove();
	jq(result).each(function(i,t){
		jq("#busSysBox").prepend("<span>"+t.cvalue+"</span><input type='hidden' name='kaicodes' value ='"+t.syscoding+"_"+t.cvalue+"' />");
	});
	
}
</script>
<style>
.aaa a:link{
   color:#34699b;
   text-decoration:none;
}
.aaa a:visited{
   color:#34699b;
   text-decoration: none;
}
.aaa a:hover{
   color:#0066cc;
   text-decoration:underline;
}
.aaa a:active{
   color:#34699b;
   text-decoration: none;
}
</style>

<body onload="filterKnkey_p();">
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
        <p class="fonts1">流程管理 &gt;&gt; 知识库 &gt;&gt; 知识审批 &gt;&gt;知识入库</p>
        <div class="back"><a href="javascript:goPage()" target="_self">返回</a></div>
      </div>
      	<div class="image"></div>
	
	</div>
   	  <div id="formwrapper">
       	<html:form styleId="form" action="/IGKGM0203_EDIT"
	               onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	               
	    <ig:message />
	               
        <fieldset>
        <legend>参考案例</legend>
         <logic:present name="IGKGM02011VO" property="knowledgeProcessList">
			<bean:size id="num" name="IGKGM02011VO" property="knowledgeProcessList"/>
			<c:if test="${num > 0}">
			
			<div class="record_list">
			<table>
				<logic:iterate id="bean" name="IGKGM02011VO" property="knowledgeProcessList">
					<tr>
						
						<td style="padding-left: 12px;">
							<a href="javascript:openRelatedProcess('${bean.processRecord.prid}','${bean.processRecord.prtype}');">${bean.processRecord.prtitle}</a><br/>
						</td>
					</tr>
				</logic:iterate>
			</table>
			</div>
			 <div  class="aaa">
	     	<img src="images/addasm.gif" alt="查询" style="cursor: hand"/>
		      <a href="javascript:addPr();" id="aAddPr">添加流程</a> <br />
		    <table id="tbPr">
		    </table>
	     </div>
			</c:if>
			<c:if test="${num == 0}">
			 <div  class="aaa">
	     	<img src="images/addasm.gif" alt="查询" style="cursor: hand"/>
		      <a href="javascript:addPr();" id="aAddPr">添加流程</a> <br />
		    <table id="tbPr">
		    </table>
	     </div>
			</c:if>
		</logic:present>
	   </fieldset>
	               
        <fieldset>
        <legend>基本信息</legend>
 

        <div>
          	<label for="Name"><span class="red">*</span><strong>标题</strong>：</label>
          	<html:text name="IGKGM0201Form"  property="kntitle" styleId="kntitle" errorStyleClass="inputError imeDisabled" size="30" readonly="true"/>      
          	<html:hidden name="IGKGM0201Form"   property="knid" styleId="knid" />   
          	<html:hidden name="IGKGM0201Form"   property="knversion" styleId="knversion" />   
          	<html:hidden name="IGKGM0201Form"   property="knproffer" styleId="knproffer" />  
          	<html:hidden name="IGKGM0201Form"   property="knproffername" styleId="knproffername" /> 
          	<html:hidden name="IGKGM0201Form"   property="knproffertime" styleId="knproffertime" />   
		    <html:hidden name="IGKGM0201Form"   property="knstatus" styleId="knstatus" />      
		    <html:hidden name="IGKGM0201Form"   property="knreject" styleId="knreject" />                     	
          	<br /> 
        </div>
        <div>
           <label for="Name"><span class="red">*</span><strong>关键字</strong>：</label>
             <logic:present name="IGKGM02011VO" property="defaultKeyList">
             <logic:iterate id="bean" name="IGKGM02011VO" property="defaultKeyList" indexId="index">
             <html:multibox name="IGKGM0201Form" property="knkeys" onclick="updKnkey_p(this)">${bean}</html:multibox>
              ${bean}
             </logic:iterate>
              <br />
             </logic:present>
             <html:text  name="IGKGM0201Form"   property="knkey_p"  style="width:200px;"/>
          
                          注：请选择或填写关键字                      
            <br /> 
        </div>        
        <div>
			<label for="Name"><strong>分类</strong>：</label>
			<html:text name="IGKGM0201Form" property="knclassname" readonly="true" styleId="knclassname" errorStyleClass="inputError imeDisabled" size="30" />
			<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>	<br/>
			<html:hidden property="knclass"/>	
    	</div>
    	<div>
			<label for="Name"><strong>来源</strong>：</label>
			<html:text name="IGKGM0201Form" property="knoriginname" readonly="true" styleId="knoriginname" errorStyleClass="inputError imeDisabled" size="30" />
			<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showDataFrom()" style="cursor: hand"/>	<br/>
			<html:hidden property="knorigin"/>	
    	</div>

        <div><label for="Name"><strong>部门</strong>：</label> <html:text
		property="kndepartment" errorStyleClass="inputError imeActive" name="IGKGM0201Form" styleId="radorg" readonly="true"/> 
		<img src="images/tree.gif" style="cursor: hand;" alt="选择部门" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');"/>
		<html:hidden property="kndepartment" styleId="radorgcoding" name="IGKGM0201Form"/>
	 	<br />
	   </div>

    	<div>
			<label for="Name"><strong>业务系统</strong>：</label>
				<div style="float:left;clear: none;width:700px;margin-left:0px;">
				<div style="margin-left:0px;" id ="busSysBox">
					<logic:present name="IGKGM02011VO" property="knowledgeAppImpactList">
						<logic:iterate id="bean" name="IGKGM02011VO" property="knowledgeAppImpactList">
							<span> ${fn:split(bean.kaicode,"_")[1] }</span> <input type="hidden" name = "kaicodes" value ="${bean.kaicode }"/>
						</logic:iterate>
					</logic:present>
					<input type="button" value="添加" class="button" onclick="openBusinessSystem();"/>
				</div>
			</div>
    	</div>
    	
    	<div>
			<label for="Name"><strong>技术领域</strong>：</label>
			<html:text name="IGKGM0201Form" property="kntelareaname" readonly="true" styleId="kntelareaname" errorStyleClass="inputError imeDisabled" size="30" />
			<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showTecknowlegyArea()" style="cursor: hand"/>	<br/>
			<html:hidden property="kntelarea"/>	
    	</div>
    	
    	<bean:define id="roleList" name="IGKGM02011VO" property="roleList"></bean:define>
    	<div><label for="Name"><strong><span class="red">*</span>知识审批人</strong>：</label> <html:select
			property="knapproverole" errorStyleClass="inputError imeActive" onchange="knappchange();">
			<html:option value=""></html:option>
			<html:options  collection="roleList" property="roleid" labelProperty="rolename"/>
		</html:select>
		<br />
		</div>
    	
    	</fieldset>
    	
    	<fieldset>
        <legend>知识内容</legend>
        <div>
            <label for="Name"><strong><span class="red">*</span>问题描述</strong>：</label>
            <html:textarea name="IGKGM0201Form" property="knfaultcause" cols="50" rows="6" tabindex="7" errorStyleClass="inputError imeActive"/>
          	<br />
        </div>
       	<div>
            <label for="Name"><strong><span class="red">*</span>解决办法</strong>：</label>
            <html:textarea name="IGKGM0201Form" property="knsolveway" cols="50" rows="6" tabindex="7" errorStyleClass="inputError imeActive"/>
          	<br />
	   	</div>
        <div>
          	<label for="Name"><strong>知识描述</strong>：</label>
          	<html:textarea name="IGKGM0201Form" property="kndes" cols="50" rows="6" tabindex="7" errorStyleClass="inputError imeActive"/>
          	<br /> 
        </div>
        <div>
        	<label for="Name"><strong>附件</strong>：</label>
        	
      
       	
        <logic:present name="IGKGM02011VO" property="knowledge">
        	  <bean:define id="knowledge" name="IGKGM02011VO" property="knowledge" type="com.deliverik.infogovernor.kgm.model.Knowledge"/>
        	   <logic:present name="knowledge" property="attachmentList">
        	   <table id="tb2">
			<logic:iterate id="attachment" name="knowledge" property="attachmentList">
					<span id='${attachment.attid}'  class="aaa">
						<html:link
							action="downloadSvcFile.do?attId=${attachment.attid}&type=kgm&filePrefix=${knowledge.knserial}">
							<bean:define id="attname" name="attachment" property="attname" />
							<%if(attname.toString().substring(attname.toString().indexOf("_")+1).startsWith(knowledge.getKnserial())) {%>
							<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
							<%} else{%>
							${knowledge.knserial}_<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
							<%} %>
						</html:link>

					<img src="images/delate.gif" align="middle" onClick="delFile('${attachment.attid}')" border="0" style="cursor: hand" alt="删除"/><br/>
					</span>
					</logic:iterate>
					</table>
					</logic:present>
					</logic:present>
			
		</div>
        <div style="padding-left: 50px"  class="aaa"><img src="images/attachment.gif" /><a
		href="javascript:addFile();" id="aAddAttach">添加附件</a>
		<table id="tb">
		</table>
		</div>
	   </fieldset>
    	<div class="enter">
    		<input type="hidden" name="delFiles" />
			<html:submit property="btn_check" value="审批通过" styleClass="button"  onclick="return confirmCheck();"  />
		
		<div class="Placeholder"></div>
		</div>
		<html:hidden property="knattkey" styleId="knattkey" name="IGKGM0201Form"/>
    	</html:form>
      </div>
  	</div>
   </div>
</div>
</body>
</html:html>