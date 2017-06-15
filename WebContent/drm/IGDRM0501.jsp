<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html:html>
<bean:define id="id" value="IGDRM0501" toScope="request" />
<logic:empty name="IGDRM0501Form" property="eiid">
<bean:define id="title" value="专项预案定义" toScope="request" />
</logic:empty>
<logic:notEmpty name="IGDRM0501Form" property="eiid">
<bean:define id="title" value="专项预案维护" toScope="request" />
</logic:notEmpty>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css">
#entBox  th{
	background-color: #EEEEEE;
	border-bottom: 1px solid #ccc;
}
#entBox  td{
	border-bottom: 1px solid #d3d3d3;
}

#entBox{
	width: 95%;
	text-align: center;
	padding: 5px;
	margin: 0 auto;
	margin-top: 2px;
}
.entb{
	margin: auto;
	width: 100%;
/* 	border-collapse: collapse; */
/* 	border: 1px solid #f3f3f3; */
}
.entb th{
	width: 15%;
	text-align: right;
/* 	vertical-align: top; */
/* 	border-collapse: collapse; */
}
.entb td{
	width: 35%;
/* 	border: 1px solid #f3f3f3; */
	text-align: left;
/* 	border-collapse: collapse; */
}
.entb select{
	width: 170px;
}
.entb input{
	margin-left: 5px;
	height: auto;
}
.entb textarea{
	width: 85%;
	height: 100px;
}
</style>
<script type="text/javascript">
var gid = 'IGDRM0501';//当前页面设置gid
//"归档部门"机构树选择设置
function setOrg(url) {
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp) {
		document.forms[0].eiorgsyscoding.value = "";
		document.forms[0].eiorgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1) {
		document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
		document.forms[0].eiorgname.value = temp.split("|")[1];
	}
}
//"专项预案类型"类型树选择设置
function selectTree(ccidinfo, selecedlast){
	var ccid = ccidinfo.split("_tree_")[0];
	url = "IGSYM1505_TREE.do" + "?ccid="+ccid + "&selecedlast=" + selecedlast+"&pageName=0801";

	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		$("docvalue").value = "";
// 		$("docshow").value = "";
		//"专项预案编号"属性设置
		$("eilabel").value = '';
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
		//选择顶级的专项预案类型时存在问题
		if(treesyscode==''){
			treesyscode = id;
		}
			
		if(treesyscode!=null && name!=null && treesyscode != ''){
			$("docvalue").value = treesyscode + "_tree_" + name;
			$("docshow").value = name;
			//"专项预案编号"属性设置
			//设置请求的Action
			igAjax.ajaxAction = "/IGDRM0501_Label.do";
			//是否异步 false-同步 true-异步
			igAjax.asynchronous = false;
			//提交方式 "POST" "GET"
			igAjax.method = "POST";
			//参数列表
			igAjax.parameters = {
				"esyscoding":treesyscode
			};
			var xml = "";
			//回调函数
			igAjax.back = function(req, json){
				 var result=req.responseText;
				 if(result != null && result != ""){
					 xml = result;
				 };
			};
			//执行
			igAjax.doAjax();
			
			$("eilabel").value = xml;
		}else{
			$("docvalue").value = '';
			$("docshow").value = '';
			//"专项预案编号"属性设置
			$("eilabel").value = '';
		}
	}
	if($("docshow").onchange){
		$("docshow").onchange();
	}
}

</script>
<body onload="hideJSYA()">
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
	<p class="fonts1">
		<ig:navigation/><logic:notEmpty name="IGDRM0501Form" property="eiid">&gt;&gt;专项预案详细信息</logic:notEmpty>
	</p>
	<logic:present name="IGDRM05011VO" property="entityItemVW" >
	<div class="back">
		<a href="javascript:void(0);" onclick="toback()">返回</a>
	</div>
	</logic:present>
	</div>
	<div id="mainBox">
	<html:form action="/IGDRM0501" styleId="form" enctype="multipart/form-data"  onsubmit="return checkSubmit(this);">
	<fieldset>
		<logic:empty name="IGDRM0501Form" property="eiid">
			<legend>专项预案定义</legend>
		</logic:empty>
		<logic:notEmpty name="IGDRM0501Form" property="eiid">
			<legend>专项预案详细信息</legend>
		</logic:notEmpty>
		<div id ="entBox">
			<html:hidden property="eiid" styleId="eiid" />
<%-- 			<html:hidden property="eid" value="${IGDRM05011VO.configurationList[0].eid }"/>${IGDRM05011VO.configurationList[0].eid } --%>
<%-- 			<html:hidden property="esyscoding" value="${IGDRM05011VO.configurationList[0].esyscoding }"/> --%>
			<table class="entb">
				<tr>
					<th>
						<label for="Name"><strong><span class="red">*</span>专项预案类型:&nbsp;&nbsp;</strong> </label>	</th>
					<td >
						<input id="txtType" value="${IGDRM0501Form.ename}"  readonly="true"/>
						<logic:notPresent  name="IGDRM05011VO" property="entityItemVW" >
						
						<img width="16" height="16" style="cursor: hand;" onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=999050&type=0&socflag=yes');" alt="专项预案类型" src="images/seek.gif"/>
						<html:hidden property="esyscoding" styleId="esyscoding"/>
						<html:hidden property="eid" styleId="eid"/>
						</logic:notPresent>
					</td>
					
					<th> <label for="Name"><strong><span class="red">*</span>专项预案编号:&nbsp;&nbsp;</strong> </label></th>
					<td><html:text property="eilabel" styleId="eilabel" styleClass="inputDisable" errorStyleClass="inputError imeActive" readonly="true" />
					
					</td>
				</tr>
				<tr>
					<th> <label for="Name"><strong><span class="red">*</span>专项预案名称:&nbsp;&nbsp;</strong> </label></th>
					<td><html:text property="einame" style="width:85%;"></html:text></td>
					<th> <label for="Name"><strong><span class="red">*</span>创建日期:&nbsp;&nbsp;</strong> </label></th>
					<td>
						<html:text property="eiinsdate" styleId="eiinsdate" value="${IGDRM0501Form.eiinsdate}" readonly="true" />
						<logic:notPresent  name="IGDRM05011VO" property="entityItemVW" >
						<img align="middle" onclick="calendar($('eiinsdate'))" src="images/date.gif" border="0"/>
						</logic:notPresent>
					</td>
				</tr>
				
				<tr>				
					<th> <label for="Name"><strong><span class="red">*</span>所属部门:&nbsp;&nbsp;</strong> </label></th>
					<td colspan="3">
						<html:text property="eiorgname" styleId="eiorgname" size="48" styleClass="inputDisable" value="${IGDRM05011VO.entityItemVW.organizationTB.orgname}" readonly="true"></html:text>
						<logic:notPresent  name="IGDRM05011VO" property="entityItemVW" >
						<img width="16" height="16" style="cursor: hand;" onclick="setOrg('IGSYM0101_ROLETREE.do');" alt="所属部门" src="images/tree.gif" border="0"/>
						<html:hidden property="eiorgsyscoding" styleId="eiorgsyscoding"/>
						</logic:notPresent>
					</td>
				</tr>
				<tr>
				<th> <label for="Name"><strong>专项预案说明:&nbsp;&nbsp;</strong> </label></th>
					<td colspan="3">
						<html:textarea property="eidesc" styleId="eidesc" value="${IGDRM05011VO.entityItemVW.eidesc}"></html:textarea>
					</td>
				</tr>
		<logic:empty name="IGDRM05011VO" property="configItemList">
			<logic:present name="IGDRM05011VO" property="configurationList">
				<tr>
					<c:set var="codeIndex" value="0"></c:set>
						<logic:iterate id="entityItem" name="IGDRM05011VO" property="configurationList" indexId="index">
							<c:choose>
								<c:when test="${brFlag==null }">
									<c:set var="brFlag" value="false"></c:set>
								</c:when>
								<c:when test="${brFlag!=null }">
									<c:choose>
										<c:when test="${brFlag=='ture'||entityItem.cunit=='1' }">
											</tr><tr>
											<c:set var="brFlag" value="false"></c:set>
											<c:if test="${entityItem.cunit=='1'}">
												<c:set var="brFlag" value="ture"></c:set>
											</c:if>
										</c:when>
										<c:when test="${brFlag=='false'}">
											<c:set var="brFlag" value="ture"></c:set>
										</c:when>
									</c:choose>
								</c:when>
							</c:choose>
							
							<th>
								<label for="Name"><strong>
								<c:if test="${entityItem.cid=='CI500000000001' or entityItem.cid=='CI500000000002'}">
									<html:hidden property="cids" value="${entityItem.cid }"/>
								</c:if>
								<c:if test="${entityItem.cid!='CI500000000001' and entityItem.cid!='CI500000000002'}">
									<span id="th${entityItem.cid}">
									<c:if test="${entityItem.crequired =='1'}">
									<span class="red">*</span>
									</c:if>
									<html:hidden property="cids" value="${entityItem.cid }"/>
									<logic:notEqual value="附件" name="entityItem" property="cname">
										${entityItem.cname }&nbsp;&nbsp;:
									</logic:notEqual>
								</span>
								</c:if>
								</strong> </label>
							</th>

							<td <c:if test="${entityItem.cunit=='1'}"> colspan="3" </c:if> >
								
							<c:choose>
								<c:when test="${entityItem.cattach=='2'}">
<%-- 								<c:if test="${entityItem.cid=='CI500000000001' or entityItem.cid=='CI500000000002'}"> --%>
<%-- 								<html:hidden property="civalues" value="否"/> --%>
<%-- 								</c:if> --%>
								</c:when>
								
								<c:when test="${entityItem.cattach=='6' }">
									<html:textarea property="civalues" styleId="${entityItem.cid}">
									</html:textarea>
								</c:when>
								<c:when test="${entityItem.cattach=='9' }">
									<logic:notEmpty name="entityItem" property="coption">
										<logic:iterate id="codedetail" name="IGDRM05011VO" property="codeList[${codeIndex }]">
											<html:radio property="civalues" styleId="rdo_${entityItem.cid }" value="${codedetail.cid }">${codedetail.cvalue }</html:radio>
										</logic:iterate>
										<html:hidden property="civalues"/>
										<c:set var="codeIndex" value="${codeIndex+1 }"></c:set>
									</logic:notEmpty>
								</c:when>
								<c:when test="${entityItem.cattach=='1' }">
									
									<html:file property="files" size="40" styleId="${entityItem.cid}"/>
									<html:hidden property="civalues" value="ciattach"/>
								</c:when>
								<c:when test="${entityItem.cattach=='0' }">
									<logic:notEqual value="参与部门" name="entityItem" property="cname">
										<html:text property="civalues" >
										</html:text>
									</logic:notEqual>
									<logic:equal value="参与部门" name="entityItem" property="cname">
										<html:text property="civalues" readonly="true">
										</html:text>
										<img width="16" height="16" style="cursor: hand;" onclick="setChkOrg(this);" alt="参与部门" src="images/tree.gif" border="0"/>
									</logic:equal>
								</c:when>
							</c:choose>
							</td>
						</logic:iterate>
					</tr>
				</logic:present>
		</logic:empty>
		<logic:notEmpty name="IGDRM05011VO" property="configItemList">
				<bean:define id="configItemList" name="IGDRM05011VO" property="configItemList"/>
						<logic:present name="configItemList" >
				<tr>
					<c:set var="codeIndex" value="0"></c:set>
						<logic:iterate id="entityItem" name="configItemList"  indexId="index">
							<c:choose>
								<c:when test="${brFlag==null }">
									<c:set var="brFlag" value="false"></c:set>
								</c:when>
								<c:when test="${brFlag!=null }">
									<c:choose>
										<c:when test="${brFlag=='ture'||entityItem.cunit=='1' }">
											</tr><tr>
											<c:set var="brFlag" value="false"></c:set>
											<c:if test="${entityItem.cunit=='1'}">
												<c:set var="brFlag" value="ture"></c:set>
											</c:if>
										</c:when>
										<c:when test="${brFlag=='false'}">
											<c:set var="brFlag" value="ture"></c:set>
										</c:when>
									</c:choose>
								</c:when>
							</c:choose>
							
							<th>
								<label for="Name"><strong>
									<c:if test="${entityItem.cid!='CI500000000001' and entityItem.cid!='CI500000000002'}">
									<span id="th${entityItem.cid}">
									<c:if test="${entityItem.crequired =='1'}">
									<span class="red">*</span>
									</c:if>
									<html:hidden property="cids" value="${entityItem.cid }"/>
										<logic:notEqual value="附件" name="entityItem" property="cname">${entityItem.cname }:</logic:notEqual> 
									</span>
									</c:if>
									</strong></label>
							</th>

							<td <c:if test="${entityItem.cunit=='1'}"> colspan="3" </c:if> >
								
							<c:choose>
								<c:when test="${entityItem.cattach=='2'}">
<%-- 								<c:if test="${entityItem.cid!='CI500000000001' and entityItem.cid!='CI500000000002'}"> --%>
									<logic:notEmpty name="entityItem" property="civalue">
									<html:select property="civalues" value="${entityItem.civalue }">
										<logic:notEmpty name="entityItem" property="coption">
											<c:set var="codeIndex" value="${codeIndex+1 }"></c:set>
										</logic:notEmpty>
									</html:select>
									</logic:notEmpty>
<%-- 									</c:if> --%>
								</c:when>
								<c:when test="${entityItem.cattach=='6' }">
									<logic:notEmpty name="entityItem" property="civalue">
									<html:textarea property="civalues" value="${entityItem.civalue }">
									</html:textarea>
									</logic:notEmpty>
								</c:when>
								<c:when test="${entityItem.cattach=='9' }">
									<logic:notEmpty name="entityItem" property="coption">
										<logic:iterate id="codedetail" name="IGDRM05011VO" property="codeList[${codeIndex }]">
											<html:radio property="civalues" styleId="rdo_${entityItem.cid }" value="${codedetail.cid }">${codedetail.cvalue }</html:radio>
										</logic:iterate>
										<html:hidden property="civalues"/>
										<c:set var="codeIndex" value="${codeIndex+1 }"></c:set>
									</logic:notEmpty>
								</c:when>
								<c:when test="${entityItem.cattach=='1' }">
									<c:if test="${entityItem.civalue==null }">
										<div style="display: none;">
											<html:file property="files" size="40" />
											<html:hidden property="civalues" styleClass = "attBox" value="ciattach"/>
											</div>
									</c:if>
									<logic:notEmpty name="entityItem" property="civalue">
										<a href="javascript:downloadASMFile('${entityItem.eiid}','${entityItem.ciid}');">
												${entityItem.civalue}
										</a>
									</logic:notEmpty>
								</c:when>
								<c:when test="${entityItem.cattach=='0' }">
									<html:text property="civalues" value="${entityItem.civalue }"></html:text>
								</c:when>
							</c:choose>
							</td>
						</logic:iterate>
					</tr>
				</logic:present>
		</logic:notEmpty>		
				
			</table>
			<html:hidden property="einame" styleId="einame" value="${IGDRM0501Form.ename}"/>
			
			<logic:present name="IGDRM05011VO" property="entityItemVW" >
<%-- 			<html:button property="btn_return" value="返回" styleClass="button" onclick="toback();" /> --%>
			</logic:present>
			<logic:notPresent name="IGDRM05011VO" property="entityItemVW" >
			<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" />
			</logic:notPresent>
		</div>
		</fieldset>
		</html:form>
		<div id="attrBox"></div>
	</div>
	<div class="zishiying"></div>
</div>
</div>
</div>
</div>
</body>
<script >
//wym
function setChkOrg(obj){
	var temp = window.showModalDialog('IGORGTREE.do',null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		jQuery(obj).prev().val('');
		return false;
	}
	if(null!=temp){
		jQuery(obj).prev().val(temp);
	}
}

function toback(){
	window.location.href  = getAppRootUrl() + "/IGDRM0502_Back.do";
   
}
jQ(function(){
	if(jQ("#eiid").val()){
		jQ("#btn_insert").hide();
		jQ("#btn_back").show();
		jQ(":input").attr("readonly","true");
// 		jQ(":input").attr("readonly","true").css("border","0px");
		jQ(".imgIcon").hide();
	}
});
function toBack(){
	window.location.href = getAppRootUrl()+"/IGDRM0502_Back.do";
}
function setEntity(url){

	 var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	 if("_resetall"==temp){
		 document.getElementById("esyscoding").value = "";
			document.getElementById("txtType").value = "";
			document.getElementById("eid").value="";
			return false;
	 }
		if(null!=temp && temp.split("|").length>1){
			var syscode_eid = temp.split("|")[0];
			var name = temp.split("|")[1];
			var syscode;
			var eid;
			 if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
			}
			if(syscode =="999050")
			{
				alert("专项预案类型不可用！请选择其他类型！");
				return false;
			}
			document.getElementById("txtType").value = name;
			document.getElementById("esyscoding").value = syscode ; 
			document.getElementById("eid").value = eid;
			searchMaxEntityItemLable();
		}			
		
	}
function searchMaxEntityItemLable(){
	
	var eid = document.getElementById("eid").value ;
	if(eid!=null&&eid!=''&&eid!='CM50000000'){
// 		jQ.ajax({
// 			url:getAppRootUrl() + "/IGDRM0501_Label.do",
// 			data:{eid:eid},
// 			type:"POST",
// 			dataType:"text",
// 			success:function(result){
				
// 			}
// 		})
	var objAjax = new Ajax.Request(getAppRootUrl() + "/IGDRM0501_Label.do",{ parameters: 'eid='+eid,
		 onSuccess:  function(req, json){
		 	var result = req.responseText;
			if(result){	
				document.getElementById("eilabel").value = result;
				//技术类的预案有“系统构架”和“附件”表单
				if(result.substring(0,2)=="JS"){
					jQuery("#CI500000010001").parent().parent().show();
					jQuery("#CI500000010002").parent().parent().show();
					jQuery("#CI500000010001").parent().prev().attr("rowSpan","2");
					jQuery("#CI500000010002").parent().prev().hide();
				}else{
					jQuery("#CI500000010001").parent().parent().hide();
					jQuery("#CI500000010002").parent().parent().hide();
				}
				
			} 
	     }
		});
	}else{
		alert("请先选择专项预案类型！");
	}
}
//"登记"按钮点击触发校验
function confirmDisp() {
	//专项预案类型配置校验
	if($F('txtType').trim()==""){
		alert("请选择专项预案类型！");
		return false;
	}
	//资产基本创建校验
	if($F('einame').trim()==""){
		alert("请输入专项预案名称！");
		return false;
	}
	if($F('einame').strlen()>120){
		alert("专项预案名称不能大于"+Math.floor(120/strByteFlag)+"个汉字！");
		return false;
	}
	if($F('eilabel').trim()==""){
		alert("请选择专项预案类型以确认专项预案编号！");
		return false;
	}
	if($F('eiinsdate').trim()==""){
		alert("请选择创建日期！");
		return false;
	}
	if($F('eiorgname').trim()==""){
		alert("请选择所属部门！");
		return false;
	}
	if(jQuery("#esyscoding").val()=="999050001"){
		
		if(jQuery("#CI500000010001").val()==""){
			alert("请输入系统架构！");
			return false;
		}
		if(jQuery("#CI500000010001").val().strlen()>3000){
			alert("系统架构不能大于"+Math.floor(3000/strByteFlag)+"个汉字！");
			return false;
		}
		
	}
// 	if(!jQuery("[name='files']").val()){
// 		alert("请选择专项预案附件！");
// 		return false;
// 	}
	//资产配置项创建校验
	var message = '<bean:message key="IGCO10000.W001" arg0="专项预案信息" />';
	if(window.confirm(message)){
		return true;
	} else {
		return false;
	}
}

function hideJSYA(){
	
//隐藏技术类预案独有的两个表单
jQuery("#CI500000010001").parent().parent().hide();
jQuery("#CI500000010002").parent().parent().hide();
if(!'${IGDRM05011VO.entityItemVW}'){
// jQuery("#thCI500000010002").parent().parent().hide();
// jQuery("#thCI500000010001").parent().parent().hide();
	
}else{
	jQuery("#thCI500000010001").parent().parent().parent().attr("rowSpan","2");
	jQuery("#thCI500000010002").parent().parent().parent().hide();
	jQuery(".red").hide();
	
}

}
</script>


</html:html>