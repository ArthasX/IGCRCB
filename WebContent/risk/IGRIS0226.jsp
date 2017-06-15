<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGRIS0206" toScope="request" />
<bean:define id="title" value="检查工作执行画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->

<script type="text/javascript">	
<!--
	
	function confirmDisp(){
		var count=0;
		count=checkAndCreate();
		if(count==0){
			alert("请您先选择要提交的记录！");
			return false;
		}
		if(count==9){
			 return false;
		}
		if(window.confirm("您确定要提交吗？")){
		 	return true;			
		 } else {
			return false;
		 }

	}
	
	function checkAndCreate(){
		var count=0;
		var check = document.getElementsByName("rcr_id");
		var results = document.getElementsByName("rcrresult");
		var comments = document.getElementsByName("rcrcomment");
		var names = document.getElementsByName("name");

		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				if((results[i].value).trim()==""){
					alert("请选择结果！");
					return 9;
				}
				if((comments[i].value).trim()!=""){
					if((comments[i].value).strlen()>128){
						alert("检查项名称为‘"+names[i].value+"’的说明不能多于40个汉字！");
						return 9;
					}
				}
				
			}
		}
		
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				count=1;
				createHiddenInput("rcrids",check[i].value);
				createHiddenInput("rcrresults",results[i].value);
				createHiddenInput("rcrcomments",comments[i].value);
				createHiddenInput("filenum",i);
			}
		}
	
	    return count;
	}
	
	function createHiddenInput(name,value){
	    var inputElement=document.createElement("input");   
	    inputElement.name=name;   
	    inputElement.value=value;     
	    inputElement.type="hidden";
	    inputElement.id=name;
	    document.getElementById("form0206").appendChild(inputElement); 
	}
	
	function ischeck(){
		var rcrid = "";
		<logic:present name="IGRIS0203Form" property="isCheckrcrid">
			rcrid = '${IGRIS0203Form.isCheckrcrid}';
		</logic:present>
		var objs = document.getElementsByName("rcr_id");
		for(var i=0;i<objs.length;i++){
			if(objs[i].value==rcrid){
				objs[i].checked = true;
				break;
			}
		}
	}
	function selectUser1(){
		
			openSubWindow('/IGSYM0205_Disp.do?', 'newpage', '800', '600');
		
	}
	function selectUser(){
		openSubWindow('/IGSYM0205_Disp.do?flag=rcru', 'newpage', '800', '600');
	}
	function showIncident(){
		var ccid = "106";
		var cid = "";
		var syscode = "";
		if(null==syscode || ""==syscode){
			syscode = ccid;
		}else{
			ccid = syscode.substring(0,3);
		}

		url = "IGSYM1505_TREE.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;

		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			$("rccategory").value="";
			$("rccategoryname").value="";
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
			$("rccategory").value=treesyscode;
			$("rccategoryname").value=name;
			
		}		
		
	}	
	window.onload=function(){
		var obj = document.getElementById("table_list");
		var date=new Date();
		var mon=((date.getMonth()+1).toString().length==1?"0"+(date.getMonth()+1):(date.getMonth()+1));
		var day=date.getDate().toString().length==1?"0"+date.getDate():date.getDate();
		var h=date.getHours().toString().length==1?"0"+date.getHours():date.getHours();
		var min=date.getMinutes().toString().length==1?"0"+date.getMinutes():date.getMinutes();
		var time=date.getYear()+"/"+mon+"/"+day+" "+h+":"+min;
		for(var i=1;i<obj.rows.length;i++){
			var q=obj.rows[i].cells[10];
			//if(q.innerHTML.indexOf("发起")!=-1){
			var cell_time = obj.rows[i].cells[4];
			var value = cell_time.innerHTML;
			if(time>value){
				obj.rows[i].cells[0].innerHTML = "<img src='images/cs1.png' align='middle' style='cursor:pointer;'  border='0' id='cs' />";
			}
			//}
		}
	};

	
//-->
</script>
<style type="text/css"> 
.subscribe{
	background-color:url(images/sub_bg.gif) 0 0 no-repeat; 
	width:84px;
	font:12px "Trebuchet MS",Arial, Helvetica, sans-serif;
	background-color:#EEEEEE;
	color:#000000;
	text-align:right;
	text-transform:uppercase;
	text-decoration:none;
	padding-top:2px;
	display:inline-block;
	padding-bottom:1px;
	margin-left:2px;
	line-height:18px;
	height:18px;
	vertical-align:middle;
	position: relative;
	top: -2px;
}
.input1 {
width:100px;
margin-left:1px;
border:1px solid #ccc;
}
</style>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
	</div>
	<div style="margin-top:-10px;">
	<html:form action="/IGRIS0203_sel" enctype="multipart/form-data">
	<div>
	<span class="subscribe">检查项类型：</span>
	<html:select property="rcclass" styleId="rcclass" style="width:102px;">
		<ig:optionsCollection ccid="RISKCHECK_CLASS_CODE" isMakeBlankRow="true" isCodeLabel="true" />
	</html:select> 
	<span class="subscribe" style="width:88px;">计划检查时间：</span>
	<html:text styleClass="input1" property="rcrplandate_from" styleId="rcrplandate_from"
		errorStyleClass="inputError imeDisabled" size="18" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="showTime(document.forms[0].rcrplandate_from)"
		border="0" style="cursor: hand" />
	--
	<html:text styleClass="input1" property="rcrplandate_to" styleId="rcrplandate_to"
		errorStyleClass="inputError imeDisabled" size="18" readonly="true"/>
	<img src="images/date.gif" align="middle" onclick="showTime(document.forms[0].rcrplandate_to)"
		border="0" style="cursor: hand" />
	<span class="subscribe" style="width:68px;">责任人：</span>
	<html:text styleClass="input1" property="rcusername" size="18" errorStyleClass="inputError imeActive" /> 
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	<div style="margin-top:12px;">
	<span class="subscribe">合作执行人：</span>
	<html:text styleClass="input1" property="ciiop" size="18" errorStyleClass="inputError imeActive" /> 
	<html:hidden property="rccategory"/>
	</div>
	</html:form> 
	</div>
</div>
</div>
</div>

<html:form styleId="form0206" action="/IGRIS0203_Insert" onsubmit="return checkSubmit(this);" enctype="multipart/form-data">
	<div id="results_list">
	<ig:message />
	
	<table class="table_style" id="table_list">
			<tr>
				<th width="3%"></th>
				<th width="3%"><label> <input type="checkbox"
					name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','rcr_id')"/> </label>
				</th>
				<th width="10%">检查项名称</th>
				<th width="10%">计划检查时间</th>
				<th width="10%">计划结束时间</th>
				<th width="7%">责任组</th>
				<th width="7%">责任人</th>
				<th width="12%">结果</th>
				<th width="17%">说明</th>
				<th width="17%">附件</th>
				<th width="5%">问题</th>
			</tr>
			<logic:present name="IGRIS02013VO" property="igris02012voList">
				<logic:iterate id="beanvo" name="IGRIS02013VO" property="igris02012voList" indexId="index">
					<bean:define id="bean1" name="beanvo" property="riskCheckResult" ></bean:define>
					<bean:define id="bean" name="bean1" property="riskCheck" ></bean:define>
						<tr class="<ig:rowcss index="${index}"/>">
							<td >
								
							</td>
							<td height="20">
								<label>
								<input type="checkbox" name="rcr_id" value="${bean1.rcrid}">
							 	</label>
							</td>
							<td>
								<html:link action="/IGRIS0203_Read.do?rcid=${bean.rcid} " title="${bean.rcdesc}">
									${bean.rcname}
								</html:link>
							</td>
							<td>${bean1.rcrplandate}</td>
							<td><bean:write name="beanvo" property="endDate" /></td>
							<td>${bean.rcrolename}</td>
							<td>${bean.rcusername}</td>
							<td>
								<html:select property="rcrresult" styleId="rcrresult">
	                      			<ig:optionsCollection ccid="RISKCHECKRESULT_CODE" isMakeBlankRow="true" isCodeLabel="true" />
	                    		</html:select>
							</td>
							<td>
								<html:textarea property="rcrcomment" cols="20" rows="2" value="" errorStyleClass="inputError imeActive">
								</html:textarea>
							</td>
							<td>
								<input type="file" name="attachFile[${index}]" onkeydown="return false;" class="imeDisabled" size="15">
								<input type="hidden" name="name" value="${bean.rcname}">
							</td>
							<td id="question">
								<logic:empty name="bean1" property="prid" >
									<a href="IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01021&ptid=8&actname=ACT04RIS0202&parameters=${bean1.rcrid}">发起</a>
								</logic:empty>
								<logic:notEmpty name="bean1" property="prid">
									<a href="IGPRR0102_Disp.do?prid=${bean1.prid}&jump=472" >
									查看
									</a>
								</logic:notEmpty>
							</td>
						</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<logic:present name="IGRIS02013VO" property="igris02012voList">
	<div class="enter">
		<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" /> 
		<html:reset property="btn_clear" styleClass="button" value="重置" />
	</div>
	</logic:present>
	<div id="operate">
		<jsp:include page="/include/paging.jsp" />
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>

</body>
</html:html>