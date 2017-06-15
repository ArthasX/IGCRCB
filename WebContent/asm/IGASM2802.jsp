<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM2802" toScope="request"/>
<bean:define id="title" value="检查项基本信息登记画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<!-- /header1 -->
<script type="text/javascript">	
  		var gid='IGASM2802';
		function checkForm(){
		 var flag   = true;
		 var ename  = document.getElementById("ename").value;
		 if(ename==""||ename==null){
		   		alert("请选择风险分类！");
		   		flag=false;
		   		return;
		   	}
		 var inputs = document.getElementsByTagName("input");
		 var asss=$('table :input');
		 if(asss[1].value==null || asss[1].value==""){
			 alert("检查项编号不能为空");
			 flag=false;
			 return;
		 }
		 if(asss[2].value==null || asss[2].value==""){
			 alert("检查项名称不能为空");
			 flag=false;
			 return;
		 }
		 if(asss[3].value==null||asss[3].value==""){
			 alert("检查项管理人不能为空");
			 flag=false;
			 return;
		 }
		 if(asss[10].value.strlen()>3000){
		  		alert("检查项说明内容长度不能大于1000个汉字！");
		  		flag=false;
		  		return;
		  	}
		  	var objs=document.getElementsByTagName("select");
		  	if(objs[0].value==null||objs[0].value==""){
		  		alert("请选择建议检查频度");
		  		flag=false;
		  		return;
		  	}
		
		
		//检查项名称校验设置不大于80个汉字
		if(asss[2].value.strlen()>240){
			alert("检查项名称不能大于"+Math.floor(240/strByteFlag)+"个汉字！");
			return false;
		}
	   
		
			var message = '<bean:message key="IGCO10000.W001" arg0="检查项基本信息" />';
			if( window.confirm(message)){
				flag=true;				
			} else {
				flag=false;
		  		return;
			}
			if(flag){
		  		form.action = "IGASM2802.do";
		  		form.submit();
		  		}
		}
	var eilabelvalue;
   function setEntity(url){
   	url = url+"?roletype=IGAC14&subtype=999018&selecedlast=1";
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.forms[0].ename.value = "";
		document.forms[0].eid.value = "";
		document.forms[0].esyscoding.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		var syscode_eid = temp.split("|")[0];
		var name = temp.split("|")[1];
		var syscode;
		var eid;
		if(syscode_eid =="999")
		{
			alert("资产模型不可用！请选择其他模型！");
			return false;
			
		}else if(syscode_eid.split("_").length>1){
			eid = syscode_eid.split("_")[0];
			syscode = syscode_eid.split("_")[1];
		}
		//获取风险点编号前几位,类似“IG-D0101”
		var eilabelcode=getEilabel(syscode);
		eilabelvalue=eilabelcode;
		searchMaxEntityItemLable();
		document.forms[0].ename.value = name;
		document.forms[0].eid.value = eid;
		document.forms[0].esyscoding.value = syscode;
	}		
	}

	function searchMaxEntityItemLable(){
		if(eilabelvalue==undefined){
			alert("请选择风险分类！");
			return;
		}
		var url = getAppRootUrl() +"/ajaxForEilabel.do";
		jQuery.ajax({
			   type: "POST",
			   url: url,
			   data: "ecategorykey="+eilabelvalue,
			   success: function(msg){
				   var result = msg;
				   if(result != null && result.trim() != ""){	
						document.getElementById("eilabel").value = result;
					} else {
						document.getElementById("labelMessage").innerText = "获取编号失败！";
					}
			   }
			});
	}
	function searchuser(){	
		openSubWindow('/IGSYM1905_Disp.do?', '_blank','1000','600','center:1');
	}
	function setIGCYB0101Params(username,orgname,orgid,useremail,userphone,usermobile,userid){
		
		document.getElementById("mgusername").value = username;
		document.getElementById("mguserid").value = userid;
	}
	function onExcel(){
		form.action = "IGASM2814_Disp.do";
		form.submit();
	}
	function getEilabel(syscode){
		//syscode(999017001001001)中的999017后的前三位,二级分类序号
		var firstLevalCode=syscode.substring(6,9);
		var firstLeval=getsecondLeval(firstLevalCode);
		var secondLevalCode=syscode.substring(10,12);
		var thirdLevalCode=syscode.substring(13,15);
		var eilabel=firstLeval+'-X'+secondLevalCode+thirdLevalCode;
		return eilabel;
	}
	function getsecondLeval(firstLevalCode){
		var flag;
		if(firstLevalCode=='001'){
			flag='IG';
		}
		if(firstLevalCode=='002'){
			flag='RM';
		}
		if(firstLevalCode=='003'){
			flag='ISM';
		}
		if(firstLevalCode=='004'){
			flag='IDT';
		}
		if(firstLevalCode=='005'){
			flag='RUN';
		}
		if(firstLevalCode=='006'){
			flag='BCM';
		}
		if(firstLevalCode=='007'){
			flag='OSM';
		}
		if(firstLevalCode=='008'){
			flag='AUM';
		}
		return flag;
	} 
	</script>
<style>
input {
width:250px;
margin-left:1px;
border:1px solid #ccc;
height:20px;
line-height: 20px;
font-size: 12px;
}
textarea {
	width:255px;
	padding:1px;
	border:1px solid #ccc;
	margin:1px;
	font-family:'Tahoma';	
	font-size:12px;
	font-weight: normal;
}
select {
width:258px;
margin-left:-2px;
margin-top:-2px;
height:40px;
border: solid #ccc;
} 
#shade{
border:solid 1px #ccc;
width:253px;
height:17px;
overflow:hidden;
margin-left:1px;

}
.333select{
width:255px;
	padding:1px;
	border:1px solid #ccc;
	margin:1px;
	font-family:'Tahoma';	
	font-size:12px;
	font-weight: normal;
}
	</style>
	
<body>
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
            
		    <div id="formwrapper">
		         <html:form styleId="form" action="/IGASM2802" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <logic:equal name="IGASM2802Form" property="mode" value="0">
			            <legend>检查项基本信息添加</legend>
			            </logic:equal>
	                    <logic:equal name="IGASM2802Form" property="mode" value="1">
	                    <legend>检查项基本信息变更</legend>
	                    </logic:equal>
	                    
			            
			          
			            
            <table  width="850px" style="margin-left:60px;margin-top:20px;">
            	<tr>
            	<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>风险分类：</strong></td>
            	<td align="left" width="250px"> <html:text property="ename" styleId="ename" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/></td>
            	<td align="left" width="40px"><img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGSYM0304_ASSET.do');"/></td>
            	<td align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*&nbsp&nbsp</span><strong>检查项编号：</strong></td>
            	<td align="left" width="250px"> <html:text property="eilabel" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/></td>
            	<td align="left" width="60px"><a href="javascript:searchMaxEntityItemLable()">获取编号</a></td>
            	</tr>
            <tr>
	           <logic:present name="IGASM28071VO" property="soc0109List" >
	              <logic:iterate id="bean" name="IGASM28071VO" property="soc0109List" indexId="index">
	              
				<c:if test="${bean.cattach =='2'}">
				<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>${bean.cname }：</strong></td>
				<td align="left" width="250px"> 
				<div id="shade">
				<html:select property="civalue" style="border:1px solid #ccc;height:22px;width:255px;">
				<option value=""></option>
				<logic:present name="IGASM28071VO" property="checkfrequencyList" >
	            	  <logic:iterate id="cv" name="IGASM28071VO" property="checkfrequencyList" indexId="index1"> 
						<option value="${cv.ccdvalue }"> ${cv.ccdvalue} </option>
				      </logic:iterate>
				</logic:present> 
				</html:select>
				</div>
				</td>
            	<td align="left" width="40px"></td>
				</c:if> 
				
				<c:if test="${bean.cattach == '0' && bean.cname == '检查项管理人' }">	
				<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>${bean.cname }：</strong></td>
				<td align="left" width="250px"> 
				<html:text property="mgusername" errorStyleClass="inputError imeActive"  tabindex="2"/>
				<html:hidden property="civalue" />
				<html:hidden property="mguserid"/>
				</td>
            	<td align="left" width="40px">
            	<img  id="img01" src="images/seek.gif" border="0" style="cursor: pointer;" onclick="searchuser();"/>
            	</td>
            	</c:if>
            	
            	<c:if test="${bean.cattach == '0' && bean.cname != '检查项管理人' && bean.cname != '检查项名称' }">	
				<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>${bean.cname }：</strong></td>
				<td align="left" width="250px"> <html:text property="civalue" errorStyleClass="inputError imeActive"  tabindex="2"/></td>
            	<td align="left" width="40px"></td>
            	</c:if>
            	<c:if test="${bean.cattach == '0' && bean.cname == '检查项名称' }">	
				<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>${bean.cname }：</strong></td>
				<td align="left" width="250px"> <html:text property="civalue" errorStyleClass="inputError imeActive"  tabindex="2"/></td>
            	<td align="left" width="40px"></td>
            	</c:if>
            	<c:if test="${bean.cattach == '6' }">	
				<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>${bean.cname }：</strong></td>
				<td align="left" width="250px"> <html:textarea property="civalue" errorStyleClass="inputError imeActive" style="height:50px;width:250px;"  tabindex="5"/></td>
            	<td align="left" width="40px"></td>
            	</c:if>
				<c:if test="${index%2>0 }">
					</tr><tr>
				</c:if> 
				</logic:iterate>
			  </logic:present> 
		        </tr>
		        </table>
		            
	            </fieldset>
	            <div class="enter">
	                <html:button property="btn_insert" value="提交" styleClass="button"  onclick="checkForm();"  />
	                <html:reset property="btn_ext" value="重置" styleClass="button" />
	            </div>
                   <html:hidden property="eid" styleId="eid"/>
                  <html:hidden property="esyscoding"/>
                   <html:hidden property="mode" styleId="mode"/>
	         </html:form>
		    </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>