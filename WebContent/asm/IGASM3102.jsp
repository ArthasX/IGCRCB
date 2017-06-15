<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM3102" toScope="request"/>
<bean:define id="title" value="风险指标基本信息登记画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
<!-- /header1 -->
	<script type="text/javascript">	
         var gid='IGASM3102';

		 function checkForm(){
			 var flag   = true;
			 var ename  = document.getElementById("ename").value;
			 if(ename==""||ename==null){
			   		alert("请选择风险指标分类！");
			   		flag=false;
			   		return flag;
			   	}
			 
			 var asss = document.getElementsByName("civalue");
			 if(asss[0].value==null || asss[0].value==""){
				 alert("指标名称不能为空");
				 flag=false;
				 return;
			 }
			 if(asss[1].value==null || asss[1].value==""){
				 alert("指标用途不能为空");
				 flag=false;
				 return;
			 }
			 if(asss[5].value==null || asss[5].value==""){
				 alert("阈值不能为空");
				 flag=false;
				 return;
			 }
			 if(asss[7].value==null || asss[7].value==""){
				 alert("指标责任人不能为空");
				 flag=false;
				 return;
			 }
			 if(asss[8].value==null || asss[8].value==""){
				 alert("指标责任部门不能为空");
				 flag=false;
				 return;
			 }
			 
			 var einame="a";
			 var objs=document.getElementsByTagName("select");
			 if(objs[0].value==null||objs[0].value==""){
			  		alert("请选择是否关键指标");
			  		flag=false;
			  		return;
			 }
			 <%-- 现在阈值由原来的下拉列表变更成文本框
			 if(objs[1].value==null||objs[1].value==""){
			  		alert("请选择阈值");
			  		flag=false;
			  		return;
			 }
			 --%>
			 if(flag){
			  		form.action = "IGASM3102.do";
			  		form.submit();
			 }
		}
		 
		 function setRoleDomain(url){
				url = url+"?roletype=IGAC14";
				var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
				if("_resetall"==temp){
					document.forms[0].eiorgsyscoding.value = "";
					document.forms[0].eiorgname.value = "";
					return false;
				}
				if(null!=temp && temp.split("|").length>1){
					document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
					document.forms[0].eiorgname.value = temp.split("|")[1];
				}		
			}
	    function setOrg(url){
		   	 
	    	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	    	if("_resetall"==temp){
				document.forms[0].eiorgsyscoding.value = "";
				document.forms[0].eiorgname.value = "";
				return false;
			}
	    	if(null!=temp && temp.split("|").length>1){
	    		document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
	    		document.forms[0].eiorgname.value = temp.split("|")[1];
	    	}		
	    }
	    var eilabelvalue;
	    function setEntity(url){
	    	url = url+"?roletype=IGAC15&subtype=999019&selecedlast=1";
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
				alert("请选择指标分类！");
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
		//alert(userid);
		document.getElementById("mgusername").value = username;
		document.getElementById("mguserid").value = userid;
	}
	function onVlist(){
		form.action = "IGASM3101_Disp.do";
		form.submit();
	}
	function getEilabel(syscode){
		//syscode(999017001001001)中的999017后的前三位,二级分类序号
		var firstLevalCode=syscode.substring(6,9);
		var firstLeval=getsecondLeval(firstLevalCode);
		var secondLevalCode=syscode.substring(10,12);
		var thirdLevalCode=syscode.substring(13,15);
		var eilabel=firstLeval+'-R'+secondLevalCode+thirdLevalCode;
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

textarea {
	width:255px;
	padding:1px; 
	border:1px solid #ccc;
	margin:2px;
	font-family:'Tahoma';	
	font-size:12px;
	font-weight: normal;
}
	</style>
<body >
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
		         <html:form styleId="form" action="/IGASM3102" onsubmit="return checkSubmit(this);">
                      <!--  message -->
                      <ig:message/>
                      <!--  /message -->     
		            <fieldset>
	                    <logic:equal name="IGASM3102Form" property="mode" value="0">
			            <legend>风险指标基本信息添加</legend>
			            </logic:equal>
	                    <logic:equal name="IGASM3102Form" property="mode" value="1">
	                    <legend>风险指标基本信息变更</legend>
	                    </logic:equal>
	                    
			            
			<table  width="850px" style="margin-left:60px;margin-top:20px;">
            	<tr>
	            	<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>指标分类：</strong></td>
	            	<td align="left" width="250px"> <html:text property="ename" styleId="ename" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/></td>
	            	<td align="left" width="40px"><img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGSYM0304_ASSET.do');"/></td>
	            	<td align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>风险指标编号：</strong></td>
	            	<td align="left" width="250px"> <html:text property="eilabel" errorStyleClass="inputError imeActive" readonly="true" tabindex="2"/></td>
	            	<td align="left" width="60px"><a href="javascript:searchMaxEntityItemLable();">获取编号</a></td>
            	</tr>
            	<tr>
		         <logic:present name="IGASM31021VO" property="soc0109List" >
		              <logic:iterate id="bean" name="IGASM31021VO" property="soc0109List" indexId="index">
		              
					<c:if test="${bean.cattach =='0' && bean.cname == '指标名称'}">
						<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>${bean.cname }：</strong></td>
						<td align="left" width="250px"><html:text property="civalue" errorStyleClass="inputError imeActive"  tabindex="2"/></td>
		            	<td align="left" width="40px"></td>
					</c:if>
					 
					
					<c:if test="${bean.cattach =='2' && bean.cname == '是否关键指标'}">
						<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong><strong>${bean.cname }：</strong></td>
						<td align="left" width="250px"> 
						<div id="shade">
						<html:select property="civalue">
							<option value=""></option>
							<logic:present name="IGASM31021VO" property="keyIndexList" >
				            	  <logic:iterate id="cv" name="IGASM31021VO" property="keyIndexList" indexId="index2"> 
									<option value="${cv.ccdvalue }"> ${cv.ccdvalue} </option>
							      </logic:iterate>
							</logic:present> 
						</html:select>
						</div>
						</td>
		            	<td align="left" width="40px"></td>
					</c:if>
					
					<c:if test="${bean.cattach == '0' && bean.cname == '计算方法' }">	
						<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><strong>${bean.cname }：</strong></td>
						<td align="left" width="250px"><html:text property="civalue" errorStyleClass="inputError imeActive"  tabindex="2"/></td>
		            	<td align="left" width="40px"></td>
	            	</c:if>
					
					<c:if test="${bean.cattach == '0' && bean.cname == '评分标准' }">	
						<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><strong>${bean.cname }：</strong></td>
						<td align="left" width="250px"><html:text property="civalue" errorStyleClass="inputError imeActive"  tabindex="2"/></td>
		            	<td align="left" width="40px"></td>
	            	</c:if>
	            	
					<c:if test="${bean.cattach == '0' && bean.cname == '阈值' }">	
						<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>${bean.cname }：</strong></td>
						<td align="left" width="250px">
						<html:text property="civalue" errorStyleClass="inputError imeActive" tabindex="2"/>
						<%-- 2014/08/12 阈值不使用下拉列表而是文本框
						<html:select property="civalue">
							<option value=""></option>
							<logic:present name="IGASM31021VO" property="thresholdList" >
								<logic:iterate id="cv" name="IGASM31021VO" property="thresholdList" indexId="index3">
									<option value="${cv.ccdvalue }"> ${cv.ccdvalue} </option>
								</logic:iterate>
							</logic:present>
						</html:select>
						 --%>
						</td>
		            	<td align="left" width="40px"></td>
	            	</c:if>
	            	
	            	<c:if test="${bean.cattach =='0' && bean.cname == '指标管理人'}">
						<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>${bean.cname }：</strong></td>
						<td align="left" width="250px"> 
						<html:text property="mgusername" readonly="true" errorStyleClass="inputError imeActive"  tabindex="2"/>
						<html:hidden property="civalue" />
						<html:hidden property="mguserid"/>
						</td>
		            	<td align="left" width="40px">
		            	<img id="img01" src="images/seek.gif" border="0" style="cursor: pointer;" onclick="searchuser();"/>
		            	</td>
					</c:if>
					
					<c:if test="${bean.cattach == '0' && bean.cname == '指标责任人' }">	
						<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>${bean.cname }：</strong></td>
						<td align="left" width="250px"><html:text property="civalue" errorStyleClass="inputError imeActive"  tabindex="2"/></td>
		            	<td align="left" width="40px"></td>
	            	</c:if>
	            	
					<c:if test="${bean.cattach == '0' && bean.cname == '指标责任部门' }">	
						<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>${bean.cname }：</strong></td>
						<td align="left" width="250px"><html:text property="civalue" errorStyleClass="inputError imeActive"  tabindex="2"/></td>
		            	<td align="left" width="40px"></td>
	            	</c:if>
	            	       
	            	<c:if test="${bean.cattach == '0' && bean.cname == '指标用途' }">	
						<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>${bean.cname }：</strong></td>
						<td align="left" width="250px"><html:text property="civalue" errorStyleClass="inputError imeActive"  tabindex="2"/></td>
		            	<td align="left" width="40px"></td>
	            	</c:if>
	            	
	            	<c:if test="${bean.cattach == '6' }">	
						<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>${bean.cname }：</strong></td>
						<td align="left" width="250px"> <html:textarea property="civalue" errorStyleClass="inputError imeActive" style="height:50px;width:250px;"  tabindex="5"/></td>
		            	<td align="left" width="40px"></td>
	            	</c:if>
	            	       
	            	<c:if test="${bean.cattach == '0' && bean.cname != '指标名称' || bean.cname != '评分标准' || bean.cname != '指标管理人' || bean.cname == '指标责任人'|| bean.cname == '指标责任部门'|| bean.cname == '指标用途'} ">	
						<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red">*</span><strong>${bean.cname }：</strong></td>
						<td align="left" width="250px"><html:text property="civalue" errorStyleClass="inputError imeActive"  tabindex="2"/></td>
		            	<td align="left" width="40px"></td>
	            	</c:if>
	            <%-- 	     	
	            	<c:if test="${bean.cattach == '6' && bean.cname == '备注' }">	
						<td height="20px" align="right" width="130px" style="background-color: #EEEEEE; "><span class="red"></span><strong>${bean.cname }：</strong></td>
						<td align="left" width="250px"> <html:textarea property="civalue" errorStyleClass="inputError imeActive" style="height:50px;width:250px;"  tabindex="5"/></td>
		            	<td align="left" width="40px"></td>
	            	</c:if> --%>
	            	
					<c:if test="${index%2>0 }">
						</tr>
						<tr>
					</c:if>
					</logic:iterate>
				  </logic:present> 
				</tr> 
		      </table> 
		            </fieldset>
		            <div class="enter">
		                <html:button property="btn_insert" value="提交" styleClass="button"  onclick="checkForm()"  />
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