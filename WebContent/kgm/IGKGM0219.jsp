<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>


<html:html>
<bean:define id="id" value="IGKGM0219" toScope="request" />
<bean:define id="title" value="知识登记画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
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
function confirmDisp(){

	if(document.forms[0].kntitle.value==""){
		alert("标题不能为空！");
		return false;
	}
	if(document.forms[0].kntitle.value.strlen()>200){
		alert("标题不能大于"+Math.floor(200/strByteFlag)+"个汉字！");
		return false;
	}
	var knkeysChecks = document.getElementsByName("knkeys");
	var isSelect = "N";
	for(var i=0;i<knkeysChecks.length;i++){
		if(knkeysChecks[i].checked){
			isSelect = "Y";
		}
	}
	
	if(document.forms[0].knkey_p.value =="" && isSelect=="N"){
		alert("关键字不能为空！");
		return false;
	}

	
	if(document.forms[0].knkey_p.value.strlen()>128){
		alert("关键字不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}

	if(document.forms[0].kndes.value.strlen()>1000){
		alert("知识描述不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
		return false;
	}

	if($F('knapproverole').trim()==""){
		alert("请选择知识审批人！");
		return false;
	}

	if($F('knfaultcause').strlen()==0){
		alert("问题描述不能为空！");
		return false;
	}

	if(document.forms[0].knfaultcause.value.strlen()>1000){
		alert("问题描述不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
		return false;
	}
	
	if($F('knsolveway').strlen()==0){
		alert("解决办法不能为空！");
		return false;
	}
	
	if(document.forms[0].knsolveway.value.strlen()>1000){
		alert("解决办法不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
		return false;
	}
	
	if(confirm("是否确认保存")){
		checkAndCreate();
		checkAndCreate_Knowledge();
		return true;
	}else{
		return false;
	}
		
}

//保存并提交
function confirmCheck(){

	if(document.forms[0].kntitle.value==""){
		alert("标题不能为空！");
		return false;
	}
	if(document.forms[0].kntitle.value.strlen()>200){
		alert("标题不能大于"+Math.floor(200/strByteFlag)+"个汉字！");
		return false;
	}
	
	var knkeysChecks = document.getElementsByName("knkeys");
	var isSelect = "N";
	for(var i=0;i<knkeysChecks.length;i++){
		if(knkeysChecks[i].checked){
			isSelect = "Y";
		}
	}
	if(document.forms[0].knkey_p.value =="" && isSelect=="N"){
		alert("关键字不能为空！");
		return false;
	}

	if(document.forms[0].knkey_p.value.strlen()>128){
		alert("关键字不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
		return false;
	}

	if($F('knapproverole').trim()==""){
		alert("请选择知识审批人！");
		return false;
	}
	
	if($F('knfaultcause').strlen()==0){
		alert("问题描述不能为空！");
		return false;
	}

	if(document.forms[0].knfaultcause.value.strlen()>1000){
		alert("问题描述不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('knsolveway').strlen()==0){
		alert("解决办法不能为空！");
		return false;
	}
	
	if(document.forms[0].knsolveway.value.strlen()>1000){
		alert("解决办法不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
		return false;
	}

	if(document.forms[0].kndes.value.strlen()>1000){
		alert("知识描述不能大于"+Math.floor(1000/strByteFlag)+"个汉字！");
		return false;
	}
	
	if(confirm("是否确认提交")){
		var url = "IGKGM0201_PROINITCHECK.do";
		checkAndCreate_Knowledge();
		document.forms[0].action=url;
		document.forms[0].submit();
		return true;
	}else{
		return false;
	}
		
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

var num=0;
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

function setOrgFrom(url){
	 
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].knoriginid.value = "";
		document.forms[0].knorigin.value = "";
		return false;
	}
	
	if(null!=temp && temp.split("|").length>1){
		document.forms[0].knoriginid.value = temp.split("|")[0];
		document.forms[0].knorigin.value = temp.split("|")[1];
	}		

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
</script>

<body>
<div id="maincontent">
<!--container 左菜单 右侧内容-->
<div id="container">
    
   <!--content  右侧内容-->
   <div id="contentWrap">
   <div id="content">
      <div id="location">
       <div class="image"></div>
        <p class="fonts1">知识登记</p>
        
      </div>
      
   	  <div id="formwrapper">
       	<html:form styleId="form" action="/IGKGM0201_PROINITSAVE"
	               onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	               
	    <ig:message />
	               
        <fieldset>
        <legend>参考案例</legend>
         <div><label for="Name"><strong>参考案例</strong>：</label>
         <html:text name="IGKGM0201Form" property="process_name" readonly="true" styleId="process_name" errorStyleClass="inputError imeDisabled" size="30" />
         	<html:hidden name="IGKGM0201Form"   property="proid" styleId="proid" />   
		    <table id="tbPr">
		    </table>
	     </div>
	   </fieldset>
	     
	     
      <fieldset>
        <legend>基本信息</legend>
    
        <div>
          	<label for="Name"><span class="red">*</span><strong>标题</strong>：</label>
          	<html:text name="IGKGM0201Form"  property="kntitle" styleId="title" errorStyleClass="inputError imeDisabled" size="30" />                           	
          	<br /> 
        </div>
        
        <div>
           <label for="Name"><span class="red">*</span><strong>关键字</strong>：</label>
             <logic:present name="IGKGM02011VO" property="defaultKeyList">
             <logic:iterate id="bean" name="IGKGM02011VO" property="defaultKeyList" indexId="index">
                <input  name="knkeys" type="checkbox"  value="${bean}" />${bean}
             </logic:iterate>
              <br />
             </logic:present>
           <input name="knkey_p" type="text" style="width:200px;" value=""/>
                          注：请选择或填写关键字                      
            <br /> 
        </div>       
            

        <div>
			<label for="Name"><strong>分类</strong>：</label>
			<html:text name="IGKGM0201Form" property="knclassname" readonly="true" styleId="knclassname" errorStyleClass="inputError imeDisabled" size="30" /><img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>	<br/>
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
			<logic:present name="IGKGM0201Form" property="system_typeList">
			<table id="tb2">
			<bean:define id="count" name="IGKGM0201Form" property="system_typeList" type="java.util.List"/>
				<logic:iterate id="bean" name="IGKGM0201Form" property="system_typeList" indexId="index">
					<%
				if (index.intValue() == 0 && index.intValue() % 4 == 0) {
				%>
				<tr>
				<%} else if(index.intValue() > 0 && index.intValue() % 4 == 0) {%>
				</tr>
				<tr>
				<%} %>
					<td><input name="system_add" type="checkbox" value="${bean.value}"/>
					${bean.label }
					<input type="hidden" name="system" value="${bean.value}"></td>
					<%if(index.intValue() == count.size()-1){%>
				</tr>
				<%} %>
					
				</logic:iterate>
			</table>
			</logic:present>
    	</div>
    	
    	<div>
			<label for="Name"><strong>技术领域</strong>：</label>
			<html:text name="IGKGM0201Form" property="kntelareaname" readonly="true" styleId="kntelareaname" errorStyleClass="inputError imeDisabled" size="30" />
			<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showTecknowlegyArea()" style="cursor: hand"/>	<br/>
			<html:hidden property="kntelarea"/>	
    	</div>
    	<bean:define id="roleList" name="IGKGM02011VO" property="roleList"></bean:define>
    	<div><label for="Name"><strong><span class="red">*</span>知识审批人</strong>：</label> <html:select name="IGKGM0201Form"
			property="knapproverole" errorStyleClass="inputError imeActive">
			<html:option value=""></html:option>
			<logic:iterate id="roleList" name="roleList">
				<html:option value="${roleList.roleid}"><bean:write name="roleList" property="rolename" /></html:option>
			</logic:iterate>
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
	   	
        <div style="padding-left: 50px"><img src="images/attachment.gif" /><a
		href="javascript:addFile();" id="aAddAttach">添加附件</a>
		<table id="tb">
		</table>
		</div>
	   </fieldset>
    	<div class="enter">
    	    <html:submit property="btn_insert" value="保存" styleClass="button"  onclick="return confirmDisp();"  />
			<html:submit property="btn_check" value="提交" styleClass="button"  onclick="return confirmCheck();"  />
		
		<div class="Placeholder"></div>
		</div>
		<html:hidden property="knstatus" name="knstatus" value="5"/>
    	</html:form>
      </div>
  	</div>
   </div>
</div>
</div>
</body>
</html:html>