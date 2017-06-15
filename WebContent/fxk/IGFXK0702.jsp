<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFXK0702" toScope="request" />
<bean:define id="title" value="新增提示基本信息画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type=text/javascript src="ueditor/ueditor.config.bbs.js"></script>  
<script type=text/javascript src="ueditor/ueditor.all.js"></script>
<script language="JavaScript" src="/js/prototype-1.5.0.js" type="text/javascript" charset="gbk"></script>
<style>

fieldset div {
	
	margin-bottom:2px;
	margin-top: 2px;
	margin-left: 0px;
}
.table_s{
text-align:center;
border-collapse:collapse;
margin:4px;
}
.table_s th{
border-bottom:#cccccc 1px solid;
background-color:#eeeeee;
height:17px;
margin:2px;
color:	#000000;
}

</style>
<script type="text/javascript">
window.UEDITOR_HOME_URL = "/ueditor";
var editor = new UE.ui.Editor();
var userNum=0;
var orgNum=0;
var attachFileNum=0;
var attach="";
 function addFile() 
 {	
 	currRow= tb.insertRow();
	cell=currRow.insertCell();
	cell.innerHTML= "<input type='file' name='fileList["+attachFileNum+"].file' class='inputbutton' contentEditable='false'><input type='button' class='delbutton' value='\u5220\u9664' onclick='deleteitem(this)'>";
	attachFileNum++;
 }
 function deleteAttach(td,obj){
	  //alert(obj);  
	  if(window.confirm("确定要删除附件吗？")){
	 var attachLink = document.getElementById("attach"+obj);
	 attachLink.linkName="";
	  //alert(attachLink);
     if(attach==""){
   	  attach = obj;
     }
     else{
     attach = attach+'_'+obj;	 
     } 
	  //alert(attach);
	  var curRow= td.parentNode.parentNode;
		tb2.deleteRow(curRow.rowIndex); 
	  }
 }
 function deleteitem(obj)
 {
	var curRow= obj.parentNode.parentNode;
	tb.deleteRow(curRow.rowIndex);
 }
	
	function deleteitem(obj){
		var curRow= obj.parentNode.parentNode;
		tb.deleteRow(curRow.rowIndex);
	}
	//删除附件
	//删除附件
	function delFile(attid){
		 if( window.confirm("您是否确定删除附件？")){
			document.getElementById(attid).style.display = "none";
			if($("deletekeys").value !=""){
				$("deletekeys").value = $("deletekeys").value + ','+attid;
			}else{
				$("deletekeys").value = attid;
			}
		 }
	}
	
	function setOrg(url){
		 
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].aporgid.value = "";
			document.forms[0].aporgname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].aporgid.value = temp.split("|")[0];
			document.forms[0].aporgname.value = temp.split("|")[1];
		}		

	} 
	
	//获取下发人员
	function setParamRoleUser(userid,username,a,orgid,orgname){
		var uid=userid.split(",,,,");//用户id
		var oid=orgid.split(",");
		var uname=username.split(",");//用户名
		var oname=orgname.split(",");//机构名
		var len=uid.length;
		var nameArray = document.getElementsByName('usid');  
		
	  
		//拆分存储用户id
		for(var i=0 ; i< len ; i++){
		   var flag="true";
		   for(var j=0;j<nameArray.length;j++){
		         if(nameArray[j].value==uid[i]){  
		        	 alert("当前选择的"+uname[i]+"用户已存在.");
		             flag=false;
		         }  
		    } 
		   if(flag){
			add(uid[i],uname[i],oid[i],oname[i],userNum);
			userNum++;
		   }
		}
	}
	

	//添加人员
	 function add(userid,username,orgid,orgname,num){
			var tb = document.getElementById("usera");
			var tr = tb.insertRow(tb.rows.length - 1);
			var td = null;
			td = tr.insertCell(0);
			td.innerHTML = userid;
			td = tr.insertCell(1);
			td.innerHTML = username;
			td = tr.insertCell(2);
			td.innerHTML = orgname;
			td =tr.insertCell(3);
			td.innerHTML += "<input type=\"button\"  onclick=\"del(this);\" style=\"background: url(images/delete.gif);width: 16px; height: 16px; border: 0;cursor:pointer\"  />";
			td.innerHTML +="<input type=\"hidden\" value=\""+userid+"\" name=\"usid\"/>";
			td.innerHTML +="<input type=\"hidden\" value=\""+username+"\" name=\"usname\"/>";
			td.innerHTML +="<input type=\"hidden\" value=\""+orgname+"\" name=\"aporgname\"/>";
			td.innerHTML +="<input type=\"hidden\" value=\""+orgid+"\" name=\"aporgid\"/>";
			
		}
	function del(obj){ 
		var rowIndex = obj.parentElement.parentElement.rowIndex;
		obj.parentElement.parentElement.parentElement.deleteRow(rowIndex);
	}
	
	function confirmDisp(){
		if($("rwname").value.trim()==""){
			alert("请输入风险提示名称！");
			return false;
		}
		if($F('rwname').strlen()>64){
			alert("风险提示名称不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
			return false;
		}
		if($F('rwcontext').strlen()>256){
			alert("风险提示不能大于80个汉字！");
			return false;
		} 
		
		var deliver=$F('sudividetype');
		var apname=document.getElementsByName("aporgname");
		if(deliver==0){
			alert("请选择下发方式!");
			return false;
		}else{
			if(apname.length<=0&&deliver==1){
			alert("请选择接收人员");
			return false;
			}else if(apname.length<=0&&deliver==2){
				alert("请选择接收部门");
				return false;
			}
			
		} 
			
		
	}
	function tableShow(sel){
		
		 if(sel.value=='1'){
			jQuery("#orgta").hide();
			jQuery("#userta").show();
			jQuery("#orgtr").prevAll().remove();
			jQuery("#usertr").prevAll().remove();
			var addtr = "<tr><th width=\"25%\">人员ID</th><th width=\"25%\">人员姓名</th><th width=\"25%\">机构名称</th><th width=\"25%\">删除</th></tr>";
			jQuery("#usertr").before(addtr);
		}
		else if(sel.value=='2'){
			jQuery("#orgta").show();
			jQuery("#userta").hide();
			jQuery("#orgtr").prevAll().remove();
			jQuery("#usertr").prevAll().remove();
			var addtr = "<tr><th style=\"display:none\" width=\"25%\">机构ID</th><th width=\"25%\">机构名称</th><th width=\"25%\">删除</th></tr>";
			jQuery("#orgtr").before(addtr);
		}
	}
	function setUsers(stype){
		
		if(stype=='1'){
			window.openSubWindow("/IGSYM0406.do","_blank",800,600);
			
		}else if(stype=='2'){
			window.openSubWindow("/IGSYM0101_S.do","_blank",800,600);
		}else{
			alert("请选择下发方式");			
		}
			
	 
	}
	//获取接收部门
	function setParamRole(orgid,orgname){
		var oid=orgid.split(",");//用户名
		var oname=orgname.split(",");//机构名
		var len=oid.length;
		//拆分存储用户id
		for(var i=0 ; i< len ; i++){
			addorg(oid[i],oname[i],orgNum);
			orgNum++;
		}
	}
	
	//添加部门
	 function addorg(orgid,orgname,num){
			var tb = document.getElementById("orgtraa");
			var tr = tb.insertRow(tb.rows.length - 1);
			var td = null;
	
	
			td = tr.insertCell(0);
			td.innerHTML = orgname;
			td =tr.insertCell(1);
			td.innerHTML += "<input type='button'  onclick='del(this);' style=\"background: url(images/delete.gif);width: 16px; height: 16px; border: 0;cursor:pointer\"   />";
			td.innerHTML +="<input  type=\"hidden\" value=\""+orgid+"\" name=\"aporgid\"/>";
			td.innerHTML +="<input type=\"hidden\" value=\""+orgname+"\" name=\"aporgname\"/>";
		}

//-->
	</script><body>
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
<p class="fonts1"><ig:navigation/></p>
</div>
<div id="formwrapper"><html:form styleId="form"
	action="/IGFXK0702_Add.do" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset><legend>风险提示下发</legend>
	 
	<div><label for="Name"><strong>下发者姓名</strong>：</label> 
	<p class="p2">&nbsp;&nbsp;<bean:write property="nusername" name="IGFXK0700Form"/></p><br />
	</div>
	<div>
	<label for="Name"><strong>下发者部门</strong>：</label> 
	<p class="p2">&nbsp;&nbsp;<bean:write property="norgname" name="IGFXK0700Form"/></p><br />
	</div>
	
	<div>
		<label for="Name"><strong>下发人员联系方式</strong>：</label> 
		<p class="p2">&nbsp;&nbsp;<bean:write property="ntel" name="IGFXK0700Form"/></p><br />
	</div>
	<div>
		<label for="Name"><strong><span class="red">*</span>风险提示名称</strong>：</label>
		<html:text property="rwname"  size="18" name="IGFXK0700Form" style="width:300px;" errorStyleClass="inputError imeActive" tabindex="1" /><br />
	</div>
	<div>
		<label for="Name"><strong>下发日期</strong>：</label> 
		<html:text property="ntime" name="IGFXK0700Form" styleId="ntime" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="calendar($('ntime'))" border="0" style="cursor: hand" /><br/>
	</div>
	<%-- <div>
		<label for="Name"><strong>接收人员部门</strong>：</label> 
		<html:text property="aporgname" styleId="aporgname" readonly="true" name="IGFXK0700Form"/>
		<img src="images/tree.gif" style="cursor: hand;" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');" alt="请选择机构"/>
		<html:hidden property="aporgid" styleId="aporgid"/>
	</div> --%>
	
	<div>
		<label for="Name"><span class="red">*</span><strong>下发方式</strong>：</label>
							<select name="sudividetype" id="sudividetype" onchange="tableShow(this);" style="width: 100px;">
							<option value="0"></option>
							<option value="2">按部门下发</option>
							<option value="1">按人员下发</option>
							</select>&nbsp;&nbsp;
							<input type="button" name="btn_sud" value="选择" onclick="setUsers($F('sudividetype'));" class="button">
						<br>
		
		
	</div>
	<div>
		<label for="Name"><strong>风险提示描述</strong>：</label> 
		<div class="fxts">
				
		<html:textarea styleId="myEditor" property="rwcontext" style="float: left;height:200px;width:700px;margin-left:140px;"></html:textarea>
					<script type="text/javascript">
					    editor.render("myEditor");
					</script> 
				<br />
		    </div>
	 <div id="orgta">
	 	 <label style="margin-top:0px;margin-bottom:0px" for="Name"><span class="red">*</span><strong>接收部门</strong>：</label>
			<table class="table_s" id="orgtraa">
				<tr>
				    <th style="display:none" width="25%">机构ID</th>
					<th width="25%">部门名称</th>
					<th width="25%">删除</th>
				</tr>
							<tr id="orgtr"></tr>
						</table>
					</div>
					
	<div id="userta" style="display: none">
	 <label class="table_s" style="padding:3px" for="Name"><span class="red">*</span><strong>接收人员</strong>：</label>
		<table class="table_s" id="usera">
			<tr>
				<th width="25%">人员ID</th>
				<th width="25%">人员姓名</th>
				<th width="25%">部门名称</th>
				<th width="25%">删除</th>
			</tr>
			<tr id="usertr"></tr>
		</table>
	</div>
				
	
	<div style="padding-left: 50px">
	   <img src="images/attachment.png" />
	   <a href="javascript:addFile();" id="aAddAttach">添加附件</a>
   
	<table id="tb">
	</table>
	</div>
	
	<div >    
            <input type='hidden' name='exattkey'/>

     </div>
     </fieldset>
	<div class="enter"><html:submit property="btn_insert" value="下发"
		styleClass="button" onclick="return confirmDisp();" /> <html:reset
		property="btn_clear" styleClass="button" value="重置" /></div>
	<%-- <html:hidden property="nid"/>
	<html:hidden property="nattkey"/>	
    <html:hidden property="attachDel"/>
    <html:hidden property="deletekeys"/> --%>
	<html:hidden property="nuserid"/>
    <html:hidden property="norgid"/>
    <html:hidden property="ntel"/>
	<html:hidden property="norgname"/>
	<html:hidden property="ntime"/>
	<html:hidden property="nusername"/>
	<html:hidden property="apuserid" />
    
</html:form>
</div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>