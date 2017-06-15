<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGDRM1705" toScope="request" />
<bean:define id="title" value="培训记录" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style>
.atttb{
	border: 0px;
	border-collapse: collapse;
	margin-left: 0px;
	
}
.atttb td{
	height: 20px;
	line-height: 20px;
}
a img{
	border: 0px;
}
.errBox{
	border: 1px solid red;
}
</style>
<script type="text/javascript">	
<!--
	//删除所选
	function confirmDisp(){
			if($("trname").value.trim() == ""){
				alert("培训名称不能为空！");
				return false;
			}
			if($F('trname').strlen()>64){
				alert("培训名称不能大于"+Math.floor(64/strByteFlag)+"字！");
				return false;
			}
			if($("tpname").value.trim() == ""){
				alert("培训计划不能为空！");
				return false;
			}
			if($("trstime").value.trim() == ""){
				alert("计划开始时间不能为空！");
				return false;
			}
			if($("tretime").value.trim() == ""){
				alert("计划结束时间不能为空！");
				return false;
			}
			if($("tpcontent").value.trim() == ""){
				alert("培训内容不能为空！");
				return false;
			}
			if($F('tpcontent').strlen()>512){
				alert("培训内容不能大于"+Math.floor(512/strByteFlag)+"字！");
				return false;
			}
			if($("trside").value.trim() == ""){
				alert("培训地点不能为空！");
				return false;
			}
			if($("trlecturer").value.trim() == ""){
				alert("培训讲师不能为空！");
				return false;
			}
			if(!checkTable()){
				return false;
			}
			
			if( window.confirm("是否确认提交？")){
				return true;
			} else {
				return false;
			}
	}
	
function checkTable(){
	
	var result = true;
	jQ(".table_style2").find("input").removeClass("errBox");
	jQ(".table_style2").find("input").each(function(i,t){
		t = jQ(t);
		if(t.attr("readonly")){
			return true;
		}
		if(!t.val()){
			result = false;
			alert("请输入"+t.attr("title"));
			t.addClass("errBox");
			return false;
		}
		
	})
	return result;
}	
	
function setOrg(url){
	var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
	if("_resetall"==temp){
		document.getElementById("tarorgid").value="";
		document.forms[0].tarorgname.value = "";
		return false;
	}
	if(null!=temp && temp.split("|").length>1){
		document.getElementById("tarorgid").value = temp.split("|")[0];
		document.forms[0].tarorgname.value = temp.split("|")[1];
	}		
}
//校验登录名：只能输入2-16个字符、可带数字、“_”、“.”的字串    
function checkUserid(str){      
	var patrn=/^([a-zA-Z0-9]|[._]){2,16}$/;
	if (!patrn.test(str)){
		return true;
	}else{
		return false;  
	}    
}  
//-->
//删除附件
function delFile(attid){
	 if( window.confirm("是否删除附件？")){
		document.getElementById(attid).style.display = "none";
		var delkey=document.getElementById("predelkey");
		if(delkey.value != ""){
			delkey.value = delkey.value + ','+attid;
		}else{
			delkey.value = attid;
		}
	 }
}

function toBack(){
	if(jQ("#backUrl").val()==1){
		window.location.href = getAppRootUrl()+"/IGDRM1701_Back.do?mode=1";
	}else{
		window.location.href = getAppRootUrl()+"/IGDRM1701_Back.do";
	}
}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
		<logic:notEmpty name="IGDRM1702Form" property="trid">
			<div class="back">
				<html:link href="javascript:toBack();">返回</html:link>
			</div> 
		</logic:notEmpty>
</div>
<div id="formwrapper">
<html:form styleId="form" action="/IGDRM1702.do" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<!--  message -->
	<ig:message />
	<!--  /message -->
	<fieldset> 
		<legend>培训记录信息</legend>
		<html:hidden property="trid"/>
	<div><label for="Name"><strong><span class="red">*</span>培训名称</strong>：</label>
		<html:text property="trname" size="18"
		style="width:300px;" errorStyleClass="inputError imeActive"
		tabindex="2" > </html:text>
		<br/>
	</div>
	<div><label for="Name"><strong><span class="red">*</span>培训计划名称</strong>：</label>
		<html:text property="tpname" size="18"
		style="width:300px;" errorStyleClass="inputError imeActive"
		tabindex="2" > </html:text>
		<br/>
	</div>
	<div><label for="Name"><strong><span class="red">*</span>培训地点</strong>：</label>
		<html:text property="trside" size="18"
		style="width:300px;" errorStyleClass="inputError imeActive"
		tabindex="2" > </html:text>
		<br/>
	</div>
		<div><label for="Name"><strong><span class="red">*</span>培训讲师</strong>：</label>
		<html:text property="trlecturer" size="18"
		style="width:300px;" errorStyleClass="inputError imeActive"
		tabindex="2" > </html:text>
		<br/>
		</div>
	<div><label for="Name"><strong><span class="red">*</span>计划开始时间</strong>：</label>
	<html:text property="trstime" styleId="trstime" readonly="true"/> 
<!-- 	<img src="images/date.gif" align="middle" onClick="calendar($('trstime'))" border="0"/> -->
	<br />
	</div>
	<div><label for="Name"><strong><span class="red">*</span>计划结束时间</strong>：</label>
	<html:text property="tretime"  styleId="tretime" readonly="true" />
<!-- 	<img src="images/date.gif" align="middle" onClick="calendar($('tretime'))" border="0"/> -->
	 <br />
	</div>
	<div><label for="Name"><span class="red">*</span><strong>培训内容</strong>：</label> 
		<span style="line-height: 25px;">${IGDRM1702Form.tpcontent }</span>
	</div>
	
	<div><label for="Name"><strong>附件</strong>：</label>
		<logic:present name="IGDRM17021VO" property="attachmentList">
				<table>
			<logic:iterate id="att" name="IGDRM17021VO" property="attachmentList">
				<tr>
					<td><html:link action="download.do?attId=${att.attid}&type=svc">
						<bean:define id="attname" name="att" property="attname" />
						<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
					</html:link>
<%-- 					<a href="javascript:delFile('${att.attid }')"> --%>
<!-- 						<img alt="删除" src="images/delate.gif"/> -->
<!-- 					</a> -->
					</td>
				</tr>
				
			</logic:iterate>
			</table>
		</logic:present>
	</div>
	

	
	</fieldset>
	<fieldset>
	<legend>培训人员</legend>
	<div class="record_list">
		<table class="table_style2">
			<tr>
				<th width="4%"></th>
				<th width="22%">姓名</th>
				<th width="22%">联系方式</th>
				<th width="22%">所属机构</th>
			</tr>
			<logic:present name="IGDRM17021VO" property="trainparticipantList">
				<logic:iterate id="bean" name="IGDRM17021VO" property="trainparticipantList">
					<tr>
					<td></td>
					<td><input type="text" name="tpaname" title="姓名" value="${bean.tpaname }"/></td>
					<td><input type="text" name="tpatel" title="联系方式" value="${bean.tpatel }"/></td>
					<td><input type="text" name="tpaorg" title="所属机构" value="${bean.tpaorg }"/></td>
				</tr>
				</logic:iterate>
			</logic:present>
		</table>
	</div>
	</fieldset>
	<div class="enter"><html:button property="btn_Back" styleClass="button" onclick="toBack()">返回</html:button> </div>
	<input type="hidden" id = "backUrl" value = "${backUrl }"/>		
	<input type="hidden" name="predelkey" id="predelkey" value="">
</html:form></div>
</div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>

<script type="text/javascript">

jQ(function(){
	jQ(":input,textarea").attr("readonly","true").css("border","0px");
	
})

	function delUser(obj){
		if(jQ(obj).parent().parent().prev().find("th").length>0){
			alert("首行不能删除!");
			return;
		}
		jQ(obj).parent().parent().remove();
	}
	function addUser(obj,flag){
		if(!flag){
			var _thisTR = jQ(obj).parent().parent();
			_thisTR.before(_thisTR.prev().clone(true));
			_thisTR.prev().find(":input").val('');
		}else{
			window.addTr = jQ(obj).parent().parent();
			openSubWindow('/IGDRM1703.do', '_pblank','1050','600');
		}
	}
	
	function setParticipant(result){
		if(window.addTr&&result.length>0){
			for(var i=0;i<result.length;i++){
				addTr.before(addTr.prev().clone(true));
				addTr.prev().find(":input[name='tpaname']").val(result[i][1]).attr("readonly","readonly");
				addTr.prev().find(":input[name='tpatel']").val(result[i][6]).attr("readonly","readonly");
				addTr.prev().find(":input[name='tpaorg']").val(result[i][3]).attr("readonly","readonly");
			}
		}
	}

</script>
</html:html>