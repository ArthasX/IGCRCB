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
	function piliang(){
		var count=0;
		count=checkAndCreate1();
		if(count==0){
			alert("请您先选择要发起的工作！");
			return false;
		}
		if(count==9){
			alert("您选择的工作其中存在已经发起工作，请重新选择！");
			return false;
		}
		if(window.confirm("您确定要提交吗？")){
			document.getElementById("form0206").action = getAppRootUrl() + '/IGRIS0203_BATCH.do';
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
				count=1;
				createHiddenInput("rcrids",check[i].value);
				createHiddenInput("rcrresults",results[i].value);
				createHiddenInput("rcrcomments",comments[i].value);
				createHiddenInput("filenum",jQuery(comments[i]).parent().find("input[name='filenums']").val());
			}
		}
	
	    return count;
	}
	
	function checkAndCreate1(){
		var count=0;
		var check = document.getElementsByName("rcr_id");
		var results = document.getElementsByName("rcrresult");
		var assignprid = document.getElementsByName("assignprid");
		var comments = document.getElementsByName("rcrcomment");
		var names = document.getElementsByName("name");

		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				var inputNode = check[i].parentElement.parentElement.parentElement.lastChild.firstChild.nextSibling;
				if(typeof(inputNode.value) != "undefined"){
					return 9;
				}
			}
		}
		
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				count=1;
				createHiddenInput("rcrids",check[i].value);
				createHiddenInput("rcrresults",results[i].value);
				createHiddenInput("rcrcomments",comments[i].value);
				createHiddenInput("filenum",jQuery(comments[i]).parent().find("input[name='filenums']").val());
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
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
			parameters: 'type=getFindData&flag=0',
			onSuccess:  function(req, json){
			var result=req.responseText;
				rcname =result;
				if(result != null && result != ""){
					var results = result.split("#");
					document.getElementById("rcclass").value = results[0];
					document.getElementById("rcrplandate_from").value = results[1];
					document.getElementById("rcrplandate_to").value = results[2];
					document.getElementById("rcusername").value = results[3];
				}
		    }
		});
		
	};

	 function toback(){
		 form0206.action = getAppRootUrl() + "/IGCOM0202.do?linkID=IGRIS0205";
		 form0206.submit();
	 }
//-->
</script>
<script type="text/javascript">	
function showArea(id, name){
    removeShowRlComment();
	var text = jQuery("#"+id).val();
	if(text){
		var event = window.event;
		//新激活图层
	    var newDiv = document.createElement("div");
	    newDiv.id = "rlshowvaluediv";
	    newDiv.style.top = (event.clientY + document.documentElement.scrollTop) + "px";
	    newDiv.style.left = (parseInt(document.body.scrollWidth) - 340) / 2 + "px"; // 屏幕居中
	    var str = "<div id='title'><div id='fountDiv'>"+name+"</div><div id='imgDiv' onclick='removeShowRlComment();'><img src='images/title-delete.gif' width='20' height='20'/></div></div>";
	    newDiv.innerHTML = str + "<div id='content'><pre>" + text + "</pre></div>";
	    document.body.appendChild(newDiv);   
	} 
}

function removeShowRlComment(){
	if(jQuery("#rlshowvaluediv").length > 0){
		jQuery("#rlshowvaluediv").remove();
	}
}
function zhipai(assignprid,cwrid){
	
	var href= 'IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01140&ptid=8&parameters='+assignprid+'&cwrid='+cwrid;
	var rcrid = assignprid;
	var rcclass = document.getElementById("rcclass").value;
	var rcrplandate_from = document.getElementById("rcrplandate_from").value;
	var rcrplandate_to = document.getElementById("rcrplandate_to").value;
	var rcusername = document.getElementById("rcusername").value;

	var rcname = '';
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
		parameters: 'type=getFindData&rcrid=' +rcrid + '&rcclass=' +rcclass+ '&rcrplandate_from=' +rcrplandate_from + '&rcrplandate_to=' +rcrplandate_to + '&rcusername=' +rcusername + '&flag=1',
		onSuccess:  function(req, json){
		var result=req.responseText;
			rcname =result;
			if(result != null && result != ""){
				//检查工作名称
				rcname = result;
			}
	    }
	});
	window.location.href= href;
	
}


function wenti(assignprid,cwrid){
	
	var href= 'IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01021&ptid=8&parameters='+assignprid+'&cwrid='+cwrid;
	var rcrid = assignprid;
	var rcclass = document.getElementById("rcclass").value;
	var rcrplandate_from = document.getElementById("rcrplandate_from").value;
	var rcrplandate_to = document.getElementById("rcrplandate_to").value;
	var rcusername = document.getElementById("rcusername").value;

	var rcname = '';
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
		parameters: 'type=getFindData&rcrid=' +rcrid + '&rcclass=' +rcclass+ '&rcrplandate_from=' +rcrplandate_from + '&rcrplandate_to=' +rcrplandate_to + '&rcusername=' +rcusername + '&flag=1',
		onSuccess:  function(req, json){
		var result=req.responseText;
			rcname =result;
			if(result != null && result != ""){
				//检查工作名称
				rcname = result;
			}
	    }
	});
	window.location.href= href;
	
}
function chakan(assignprid,cwrid){
	
	var href= 'IGPRR0102_Disp.do?prid='+ assignprid +'&jump=473&cwrid=' +cwrid;
	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
		parameters: 'type=saveBack&cwrid='+cwrid,
		onSuccess:  function(req, json){
	    }
	});
	window.location.href= href;
}

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
<style type="text/css">
.rlcomment{cursor: hand;}
#rlshowvaluediv{
	word-wrap:break-word;
	position:absolute;
	z-index: 9999;
	width: 400px;
	min-height: 50px;
	background-color: #eee;
	border:1px solid #ccc;
}
#rlshowvaluediv #title{
	width:395px;
	height:23px;
	line-height:23px;
	font-weight: bold;
	background:url(images/title-23.gif);
	padding-left:5px;
}
#rlshowvaluediv #title #fountDiv{
	width:100px;
	height:23px;
	float: left;
}
#rlshowvaluediv #title #imgDiv{
	width:30px;
	height:23px;
	float: right;
	padding-top:3px;
	cursor: hand;
}
#rlshowvaluediv #content{
	width:395px;
	padding:5px;
	line-height: 20px;
}
</style>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1">检查任务管理&gt;&gt; 检查任务查询&gt;&gt; 检查工作查询  </p>
<div class="back">
	<html:link href="javascript:toback();">返回</html:link>
</div>
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
	<html:text styleClass="input1" property="rcusername" styleId="rcusername" size="18" errorStyleClass="inputError imeActive"/> 
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	<%-- <div style="margin-top:12px;">
	<span class="subscribe">合作执行人：</span>
	<html:text styleClass="input1" property="ciiop" size="18" errorStyleClass="inputError imeActive" /> 
	<html:hidden property="rccategory"/>
	</div> --%>
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
				<th width="5%">检查项类型</th>
				<th width="10%">检查项名称</th>
				<th width="5%">处理人</th>
				<th width="8%">检查项说明</th>
				<th width="8%">检查方法</th>
				<th width="6%">完成情况</th>
				<th width="11%">检查结果</th>
				<th width="10%">结果说明</th>
				<th width="18%">附件</th>
				<th width="5%">问题</th>
				<th width="8%">指派工作</th>
				<!-- <th width="10%">计划检查时间</th>
				<th width="10%">计划结束时间</th>
				<th width="7%">责任组</th>
				<th width="7%">责任人</th>
				<th width="12%">结果</th>
				<th width="17%">说明</th> -->
				
				
			</tr>
			<logic:present name="IGRIS02013VO" property="igris02012voList">
				<logic:iterate id="beanvo" name="IGRIS02013VO" property="igris02012voList" indexId="index">
					<bean:define id="bean1" name="beanvo" property="riskCheckResult" ></bean:define>
					<%-- <bean:define id="bean" name="bean1" property="riskCheck" ></bean:define> --%>
						<tr class="<ig:rowcss index="${index}"/>">
							<td >
								
							</td>
							<td height="20">
								<label>
									<c:if test="${bean1.rcrresult != 'A' && bean1.rcrresult != 'B' && bean1.rcrresult != 'C'}">
										<input type="checkbox" name="rcr_id" value="${bean1.rcrid}">
									</c:if>
							 	</label>
							</td>
							<td>
								<c:if test="${bean1.rcrclass==1}" >机房</c:if>
								<c:if test="${bean1.rcrclass==2}" >网络</c:if>
								<c:if test="${bean1.rcrclass==3}" >系统</c:if>
								<c:if test="${bean1.rcrclass==4}" >桌面安全</c:if>
								<c:if test="${bean1.rcrclass==5}" >访问控制</c:if>
								<c:if test="${bean1.rcrclass==6}" >开发</c:if>
								<c:if test="${bean1.rcrclass==7}" >其他</c:if>
							</td>
							
							
							<td>
								${bean1.rcname}
							</td>
							
							<td>
								${bean1.rcrusername}
							</td>
							<td class="rlcomment" onclick="showArea('jcxsm_${index}','检查项说明')" >
									<ig:SubstringShowEllipsisWriteTag len="5" showEllipsis="true">
										${bean1.rcdesc}
									</ig:SubstringShowEllipsisWriteTag>
							
							<textarea style="display:none;" rows="6" cols="60" id="jcxsm_${index}">${bean1.rcdesc}</textarea></td>
							<td class="rlcomment" onclick="showArea('jcff_${index}','检查方法')" >
									<ig:SubstringShowEllipsisWriteTag len="5" showEllipsis="true">
										${bean1.rccommon}
									</ig:SubstringShowEllipsisWriteTag>
							<textarea style="display:none;" rows="6" cols="60" id="jcff_${index}">${bean1.rccommon}</textarea></td>
							<td>${bean1.rcrtestmode}</td>
							<td>
								<c:if test="${bean1.rcrresult != 'A' && bean1.rcrresult != 'B' && bean1.rcrresult != 'C'}">
									<html:select property="rcrresult" styleId="rcrresult">
										<%-- <html:option value="" ></html:option>
										<html:option value="A">正常</html:option>
										<html:option value="B">存在问题</html:option>
										<html:option value="C">存在重大问题</html:option> --%>
	                      			<ig:optionsCollection ccid="RISKCHECKRESULT_CODE" isMakeBlankRow="true" isCodeLabel="true" />
	                    		</html:select>
								</c:if>
								<c:if test="${bean1.rcrresult == 'A' || bean1.rcrresult == 'B' || bean1.rcrresult == 'C'}">
									<ig:codeValue ccid="RISKCHECKRESULT_CODE" cid="${bean1.rcrresult}" ></ig:codeValue>					
								</c:if>
							</td>
							<td>
								<c:if test="${bean1.rcrresult != 'A' && bean1.rcrresult != 'B' && bean1.rcrresult != 'C'}">
									<html:textarea property="rcrcomment" cols="11" rows="2" value="" errorStyleClass="inputError imeActive">
									</html:textarea>
								</c:if>
								<c:if test="${bean1.rcrresult == 'A' || bean1.rcrresult == 'B' || bean1.rcrresult == 'C'}">
									<bean:write name="bean1" property="rcrcomment"/> 				
								</c:if>
								<input type="hidden" name="filenums" value="${index}"/>
							</td>
							<td>
								<c:if test="${bean1.rcrresult != 'A' && bean1.rcrresult != 'B' && bean1.rcrresult != 'C'}">
									<input type="file" name="attachFile[${index}]" onkeydown="return false;" class="imeDisabled" size="15">
									<input type="hidden" name="name" value="${bean1.rcname}">
								</c:if>
								<c:if test="${bean1.rcrresult == 'A' || bean1.rcrresult == 'B' || bean1.rcrresult == 'C'}">
									<html:link action="/IGRIS0202_loadFIle.do?attid=${beanvo.attid}"  styleId='attach${beanvo.attid}'>
									${beanvo.attname}
									</html:link> 				
								</c:if>
							</td>
							<td id="question">
							
								<c:if test="${bean1.rcrresult != 'A' && bean1.rcrresult != 'B' && bean1.rcrresult != 'C'}">
									<logic:empty name="bean1" property="prid" >
									<a href="javascript:void(0)" onclick="wenti('${bean1.rcrid}','${cwrid}');">发起</a>
								</logic:empty>
									<logic:notEmpty name="bean1" property="prid">
										<a href="IGPRR0102_Disp.do?prid=${bean1.prid}&jump=473&cwrid=${cwrid}" >
											查看
										</a>
									</logic:notEmpty>
								</c:if>
								<c:if test="${bean1.rcrresult == 'A' || bean1.rcrresult == 'B' || bean1.rcrresult == 'C'}">
									<logic:notEmpty name="bean1" property="prid">
										<a href="IGPRR0102_Disp.do?prid=${bean1.prid}&jump=473&cwrid=${cwrid}" >
											查看
										</a>
									</logic:notEmpty>
								</c:if>
							</td>
							<td id="assignwork">
							
								<c:if test="${bean1.rcrresult != 'A' && bean1.rcrresult != 'B' && bean1.rcrresult != 'C'}">
									<logic:empty name="bean1" property="assignprid" >
										<a href="javascript:void(0)" onclick="zhipai('${bean1.rcrid}','${cwrid}');">发起</a>
									</logic:empty>
									<%-- <a href="IGCOM0202.do?linkID=IGWKM0104&psdcode=Z&pdid=01140&ptid=8&actname=ACT04RIS0302&parameters=${bean1.rcrid}&cwrid=${cwrid}">发起</a> --%>
									<logic:notEmpty name="bean1" property="assignprid">
									<a href="javascript:void(0)"  onclick="chakan('${bean1.assignprid}','${cwrid}');">
										查看
									</a>
									</logic:notEmpty>
								</c:if>
								<c:if test="${bean1.rcrresult == 'A' || bean1.rcrresult == 'B' || bean1.rcrresult == 'C'}">
									<logic:notEmpty name="bean1" property="assignprid">
										<a href="javascript:void(0)"  onclick="chakan('${bean1.assignprid}','${cwrid}');">
											查看
										</a>
									</logic:notEmpty>	
								</c:if>
								<input type="hidden" name="assignprid" value="${bean1.assignprid}"/>
							</td>
						</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<logic:present name="IGRIS02013VO" property="igris02012voList">
	<div class="enter">
		<html:submit property="btn_insert" value="提交" styleClass="button" onclick="return confirmDisp();" /> 
		  <html:submit property="btn_insert" value="批量发起" styleClass="button" onclick="return piliang();" /> 
		<html:reset property="btn_clear" styleClass="button" value="重置" />
	</div>
	</logic:present>
	<div id="operate">
		<jsp:include page="/include/paging.jsp" />
	</div>
	<input type="hidden" id="cwrid" name="cwrid" value="${cwrid}">
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
	
</div>

</body>
</html:html>