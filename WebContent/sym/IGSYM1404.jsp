<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGSYM1404" toScope="request"/>
<bean:define id="title" value="报表信息变更画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	function selectRfdtype(){
		var ccid = "217";
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
			$("rfdtype").value="";
			$("rfdtypename").value="";
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

			$("rfdtype").value=treesyscode;
			$("rfdtypename").value=name;
			
		}		
		
	}
	    function checkForm(){

	    	var frm = window.document.forms[0];
	    	if($F('rfdtitle').trim() == ""){
	    		alert("请输入显示名称！");
	    		return false;
	    	}
	    	if($F('rfdtype').trim() == ""){
	    		alert("请选择报表分类！");
	    		return false;
	    	}
	    	if($F('rfdtitle').strlen()>128){
	    		alert("显示名称不能大于"+Math.floor(128/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	var myReg = /^[0-9a-zA-Z_]*$/;
			if(!myReg.test($F('rfdfilename'))) {
				alert("发布名称只能输入字母或数字！");
	    		return false;
			}
	    	if($F('rfdfilename').strlen()>32){
	    		alert("发布名称不能大于32个字符！");
	    		return false;
	    	}
	    	if($F('rfdpictype').trim() == ""){
	    		alert("请选择图形类型！");
	    		return false;
	    	}
	    	if($F('rfdfilemodel').trim() == ""&&(document.getElementById("rfdfilename_b").style.display!="none")){
	    		alert("请选择报表模板！");
	    		return false;
	    	}
	    	
		    /*
	    		当报表模板=工单数量统计 1 	流程类型不能为空
	    		当报表模板=特定表单统计：2  流程类型、流程表单 不能为空
	    		当报表模板=树形表单统计：3流程类型、流程表单 不能为空
	    		当报表模板=人员工作量统计4 流程类型、流程状态不能为空
	
	    	*/
	    	//rfdfilemodel 报表模板 1工单数量统计、2特定表单统计、3树形表单统计、4人员工作量统计
	    	//rfdfilemodel报表模板
	    	var isFlag="${IGSYM1402Form.isFlag}";
	    	if(isFlag == "0")
	    	{
	    		if($F('rfdfilemodel').trim() == ""){
		    		alert("请选择报表模板！");
		    		return false;
		    	}
		    	var filemodel = document.getElementById("rfdfilemodel").value;
		    	
		    	if(filemodel==1){
		    		var temp = false;
		    		for(var i=0;i<frm.prtypes.length;i++)
		    		{
		    			if(frm.prtypes[i].checked==true)
		    			{
		    				temp = true;
		    			}
		    		}
		    		if(!temp)
		    		{
		    			alert("请选流程类型！");
		    			return false;
		    		}
		    	}else if (filemodel==2){
		    		if($F('prtype').trim() == ""){
			    		alert("请选流程类型！");
			    		return false;
			    	}
		    		if($F('pidid').trim() == ""){
			    		alert("请选流程表单！");
			    		return false;
			    	}
		    	}else if(filemodel==3){
		    		if($F('prtype').trim() == ""){
			    		alert("请选流程类型！");
			    		return false;
			    	}
		    		if($F('pidid').trim() == ""){
			    		alert("请选流程表单！");
			    		return false;
			    	}
		    	}else if(filemodel==4){
		    		if($F('prtype').trim() == ""){
			    		alert("请选流程类型！");
			    		return false;
			    	}
		    		//流程状态不能为空 prstatus
		    		var temp = false;
		    		for(var i=0;i<frm.prstatus.length;i++)
		    		{
		    			if(frm.prstatus[i].checked==true)
		    			{
		    				temp = true;
		    			}
		    		}
		    		if(!temp)
		    		{
		    			alert("请选流程状态！");
		    			return false;
		    		}

		    		// 当报表模板选择“4：人员工作量统计”时，不可登记折线和饼图的报表。
	                var rfdpictype = document.getElementById("rfdpictype").value;
	                if (rfdpictype == 2 || rfdpictype == 3){
	                    alert("人员工作量统计不提供折线图和饼形图的报表，请您在图形类型中选择表格或柱形图！");
	                    return false;
	                }
		    	}
	    	}
		    	
	    	if($F('rfddesc').strlen()>512){
	    		alert("说明不能大于"+Math.floor(512/strByteFlag)+"个汉字！");
	    		return false;
	    	}else {
	    		var message = '<bean:message key="IGCO10000.W003" arg0="报表信息" />';
				if( window.confirm(message)){
					return true;
				} else {
					return false;
				}
	    	}
	    }

	    
	    function showDiv(isFlag){
		    if("0"==isFlag){
		    	document.getElementById("rfdfilename_a").style.display="none";
		    	document.getElementById("rfdfilename_b").style.display="";
		    }
		    if("1"==isFlag){
		    	document.getElementById("prstatus_b").style.display="none";
		    	document.getElementById("pidid_b").style.display="none";
		    	document.getElementById("rank_a").style.display="none";
		    	document.getElementById("rfdfilename_a").style.display="";
		    	document.getElementById("rfdfilename_b").style.display="none";
		    	document.getElementById("prtype_c").style.display="none";
		    	document.getElementById("prtype_d").style.display="none";
		    }
	    }
	    
	    //动态生成状态列表
	    function innerPrStatusHTML(psdname, psdcode){
			var psdnames  = psdname.split("<br/>");
			var psdcodes  = psdcode.split("<br/>");
			var str = "<label for='Name'><strong><span class='red'>*</span>流程状态</strong>：</label>";
			var selectCount=1;
			var prstatus='${IGSYM1402Form.prstatuss}';
			var pss=prstatus.split("#");
			var flag=true;
			for(var i=0;i<psdnames.length;i++){
				if(psdnames[i] != ""){
					for(var j=0;j<pss.length;j++){
						if(pss[j]==psdcodes[i]){
							str+="<input type='checkbox' id='prstatus' name='prstatus' value='"+psdcodes[i]+"' checked='checked'/>"+psdnames[i];
							flag=false;
						}
					}
					if(flag){
						str+="<input type='checkbox' id='prstatus' name='prstatus' value='"+psdcodes[i]+"'/>"+psdnames[i];
					}
					flag=true;
						
					if(selectCount%4==0){
						str+="<br/>";
					}
						selectCount++;
				}
			}
			$("prstatus_b").innerHTML=str;
		 }

		 
		//动态生成表单列表
	    function innerPrInfoHTML(pidname, pidid){
			var pidnames  = pidname.split("<br/>");
			var pidids  = pidid.split("<br/>");
			var pidid_a='${IGSYM1402Form.pidid}';
			//var pidid_b=pidid_a.split("_")[1];
			var str = "<label for='Name'><strong><span class='red'>*</span>流程表单</strong>：</label>";
			 str += "<select name='pidid' onchange='getShowRank()' id='pidid' style='width: 130px;'>";
			str+="<option value=''></option>";
			for(var i=0;i<pidnames.length;i++){
				if(pidnames[i] != ""){
					//var pidids_b=pidids[i].split("_")[1];
					//if(pidid_b==pidids_b){
					if(pidid_a==pidids[i]){
						str+="<option value='"+pidids[i]+"' selected='selected'>"+pidnames[i]+"</option>";
					}else{
						str+="<option value='"+pidids[i]+"'>"+pidnames[i]+"</option>";
					}
					if(i==pidnames.length){
						str+="</select>";
					}
				}
			}
			$("pidid_b").innerHTML=str;
			getShowRank();
		 }

		 //是否显示树形级别
		 function getShowRank(){
			var pidid=document.getElementById("pidid").value;
			var pidids=pidid.split("_");
			if(pidids!=null&&pidids.length>1){
				if("T"==pidids[1]){
					document.getElementById("rank_a").style.display="";
				}else{
					document.getElementById("rank_a").style.display="none";
				}
			}
		 }

		 function inti(){
			 var isFlag="${IGSYM1402Form.isFlag}";
			    if("0"==isFlag){
			    	showLabel(0);
			    	document.getElementById("radio_a").checked=true;
			    	document.getElementById("rfdfilename_a").style.display="none";
			    	document.getElementById("rfdfilename_b").style.display="";
			    	document.getElementById("prstatus_b").style.display="";
			    	document.getElementById("pidid_b").style.display="";
			    	getShowRank();
			    }
			    if("1"==isFlag){
			    	document.getElementById("radio_b").checked=true;
			    	document.getElementById("prstatus_b").style.display="none";
			    	document.getElementById("pidid_b").style.display="none";
			    	document.getElementById("rank_a").style.display="none";
			    	document.getElementById("rfdfilename_a").style.display="";
			    	document.getElementById("rfdfilename_b").style.display="none";
			    }
		}
			
		//“流程类型、流程状态、流程表单”三个表单随“报表模板”联动显示
	    function showLabel(time){
	    	var filemodel =null;
	    	//0 页面初始加载
	    	if(0 ==time ){
	    		 filemodel="${IGSYM1402Form.rfdfilemodel}";
	    	}else {
	    		// 报表模板切换时需清空各联动表单值并隐藏
                document.getElementById("prtype_d").style.display="none";
                document.getElementById("prtype_c").style.display="none";
                document.getElementById("prstatus_b").style.display="none";
                document.getElementById("pidid_b").style.display="none";
                document.getElementById("rank_a").style.display="none";
                var frm = window.document.forms[0];
                for(var i=0;i<frm.prtypes.length;i++){
                    frm.prtypes[i].checked=false;
                }
                frm.prtype.value="";
                
	    		//rfdfilemodel 报表模板 1工单数量统计、2特定表单统计、3树形表单统计、4人员工作量统计
	            filemodel = document.getElementById("rfdfilemodel").value;
	    	}
	    	
	    	if(1==filemodel)
	    	{
	    		//流程类型显示、复选
				innerPrTypeHTML_checkbox();
	    	}
	    	else if (2==filemodel)
	    	{
	    		//当报表模板=特定表单统计
	    		//流程类型显示、下拉单选，流程表单显示、下拉单选，且流程表单的值域为所选流程类型的下拉、单选、复选类型的表单。IG007
				//流程类型显示、下拉单选
	    		innerPrTypeHTML_select();
	    		//流程表单显示、下拉单选
	    		//流程表单显示 根据选择的流程状态动态选择流程表单 流程表单默认显示
	    		document.getElementById("pidid_b").style.display="";
	    		document.getElementById("prstatus_b").style.display="none";
	    		var str = "<label for='Name'><strong><span class='red'>*</span>流程表单</strong>：</label>";
	    		 str+="<select name='pidid'  id='pidid'   style='width: 130px;'>";
	    		if(0 == time)
	    		{
	    			str+="<option value='${IGSYM1402Form.pidid}'></option></select>";
	    		}
	    		else 
	    		{
	    			str+="<option value=''></option></select>";
	    		}
	    		$("pidid_b").innerHTML=str;
	    		getPidid();
	    	}
	    	else if(3 ==filemodel)
	    	{
	    		//当报表模板=树形表单统计：
	    		//流程类型显示、下拉单选，流程表单显示、下拉单选，且流程表单的值域为所选流程类型的树类型的表单
	    		innerPrTypeHTML_select();
	    		document.getElementById("pidid_b").style.display="";
	    		document.getElementById("prstatus_b").style.display="none";
	    		var str = "<label for='Name'><strong><span class='red'>*</span>流程表单</strong>：</label>";
		    	 str+="<select name='pidid'  id='pidid'   style='width: 130px;'>";
		    	 if(0 == time)
		    	{
		    			str+="<option value='${IGSYM1402Form.pidid}'></option></select>";
		    	}
		    	else 
		    	{
		    			str+="<option value=''></option></select>";
		    	}
	    		$("pidid_b").innerHTML=str;
	    		getPidid();
	    	}
	    	else if(4 ==filemodel)
	    	{
	    		innerPrTypeHTML_select();	
	    		
	    		if(time == 0)
	    		{
		    		var prtype = "${IGSYM1402Form.prtype}";
 		    		//var prtype =document.getElementById("prtype").value;
 		    		//alert(prtype);
 		    		if(prtype)
 		    		{
 		    			//document.getElementById("prtype").value=prtype;
 		    			getPidid_2(prtype);
 		    		}
 		    		else 
 		    		{
 		    			fun_clearPrstatus();
 		    		}
	    		}
	    		else 
	    		{
	    			document.getElementById("prtype").value="";
	    			getPidid();
	    		}
	    	}
	    }
	    //动态生成类型列表 20121115 复选
	    function innerPrTypeHTML_checkbox()
	    {
	    	document.getElementById("prtype_d").style.display="";
	    	document.getElementById("prtype_c").style.display="none";
	    	document.getElementById("prstatus_b").style.display="none";
	    	document.getElementById("pidid_b").style.display="none";
	    	var frm = window.document.forms[0];
	    	var pdids = "${IGSYM1402Form.prtype}";
	    	var pdid=pdids.split("#");
	    	 for(var i = 0; i < pdid.length;i++) {
	    		 for(var j = 0; j < frm.prtypes.length;j++) {
	    			
	    			 if(pdid[i]==frm.prtypes[j].value)
			    	{
	    				 frm.prtypes[j].checked = true;	 
			    	}
	    		 }
	    		 
	    		 
	    	 }
	    }
	    //根据流程类型查询流程表单 人员工做量统计初始化
	    
	    function getPidid_2(prtype)
	    {
	    	var filemodel = document.getElementById("rfdfilemodel").value;
	    	if(prtype && filemodel == 4)
	    	{
	    		goAjax("LCZT",prtype,fun_LCZT);	
	    	}
	    }
	    //根据流程类型查询流程表单
	    function getPidid()
	    {
	    	var prtype = document.getElementById("prtype").value;
	    	var filemodel = document.getElementById("rfdfilemodel").value;
	    	if(!prtype && filemodel == 4)
    		{
	    		fun_clearPrstatus();
	    	
    		}
	    	else if(!prtype && (filemodel==2 || filemodel ==3))
	    	{
	    		//清空流程表单
	    		fun_clearPidid();
	    	}
	    	//特定表单统计
	       	else if(prtype && filemodel ==2)
	    	{
	    		goAjax("LCBD",prtype,fun1);	    		
	    	}
	    	//树形表单统计：
	    	else if(prtype && filemodel == 3)
	    	{
	    		goAjax("LCBDT",prtype,fun1);	  
	    	}
	    	//人员工作量统计
	    	else if(prtype && filemodel == 4)
	    	{
	    		goAjax("LCZT",prtype,fun_LCZT);	
	    	}
	    	
	    }
	    //流程状态为空
	    function fun_clearPrstatus()
	    {
	    	//人员工作量统计 流程类型为空的时候 流程状态为空
    		document.getElementById("prstatus_b").style.display="";
    		document.getElementById("pidid_b").style.display="none";
    		var str = "<label for='Name'><strong><span class='red'>*</span>流程状态</strong>：</label>";
    		$("prstatus_b").innerHTML=str;
	    }
	  //ajax 请求
	    function goAjax(type,pdid,fun)
	    {	    	
	    	var objAjaxOne = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, 
				parameters: 'type='+type+'&pdid='+pdid,
				 onSuccess: fun });
	    }
	    
	    //动态生成类型列表 20121115 下拉
	    function innerPrTypeHTML_select()
	    {
	    	document.getElementById("prtype_d").style.display="none";
	    	document.getElementById("prtype_c").style.display="";
	    }
	    
	    //报表模板为特定表单统计，会调函数
	    function fun1(req, json)
	    {
	    	 var result=req.responseText;
				if(result != null && result != ""){
					res=result;
					var ig007Array=result.split("###");
					if(ig007Array!=null&&ig007Array.length > 0){
						var pidname="";
						var pidid="";
						var selectCount = 0;
						 for(var i = 0; i < ig007Array.length;i++) {
							 pidname += ig007Array[i].split("##")[0]+"<br/>";
							 pidid += ig007Array[i].split("##")[1]+"<br/>";
			                  selectCount ++;
					         }
				            innerPrInfoHTML(pidname, pidid);
					}
				}else{
					return "";	
				}
	    }
	    
	    //报表类型为人员工作量统计
	    function fun_LCZT(req, json)
	    {
	    	//alert(2);
	   		 var result=req.responseText;
			  if(result != null && result != ""){
					res=result;
					var ig333Array=result.split("###");
					if(ig333Array!=null&&ig333Array.length > 0){
						var psdname="";
						var psdcode="";
						 for(var i = 0; i < ig333Array.length;i++) {
							 psdname += ig333Array[i].split("##")[0]+"<br/>";
							 psdcode += ig333Array[i].split("##")[1]+"<br/>";
					     }
						 innerPrStatusHTML(psdname, psdcode);
					}
				}else{
					return "";	
				}
	    }
		    
	    //清空流程表单
	    function fun_clearPidid()
	    {
	    	document.getElementById("pidid_b").style.display="";
    		document.getElementById("prstatus_b").style.display="none";
    		var str = "<label for='Name'><strong><span class='red'>*</span>流程表单</strong>：</label>";
	    	str+="<select name='pidid'  id='pidid'   style='width: 130px;'>";
	    	str+="<option value=''></option></select>";
    		$("pidid_b").innerHTML=str;
	    }
		    
	</script>
<body onload="inti();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 报表信息变更</p>
                <div class="back"><a href="IGSYM1401_Back.do" target="_self">返回</a></div>
            </div>
            <div id="formwrapper">
            <html:form styleId="form" action="/IGSYM1402_EDIT" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					    <legend>报表信息</legend>
					 <div>
						<label for="Name"><strong><span class="red">*</span>报表类型</strong>：</label>
						 <logic:equal value="0" name="IGSYM1402Form" property="isFlag">
							 <input  type="radio" name="isFlag" id="radio_a" value="0" onclick="showDiv(0)"/>定制报表
						 </logic:equal>
						  <logic:equal value="1" name="IGSYM1402Form" property="isFlag">
						 	 <input type="radio" name="isFlag" id="radio_b" value="1" onclick="showDiv(1)"/>常规报表
						  </logic:equal>
						 
					</div>
                    <div>
						<label for="Name"><strong><span class="red">*</span>显示名称</strong>：</label>
						<html:text name="IGSYM1402Form" property="rfdtitle" styleId="rfdtitle" size="8" style="width:200px;" errorStyleClass="inputError" tabindex="1"/>
						<br>
    				</div>
                   <div>
						<label for="Name"><strong><span class="red">*</span>报表分类</strong>：</label>
						<html:text name="IGSYM1402Form" property="rfdtypename" styleId="rfdtypename" style="width:100px;" errorStyleClass="inputError" tabindex="2" readonly="true"/>
						<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="selectRfdtype()" style="cursor: hand"/>
						<html:hidden name="IGSYM1402Form" property="rfdtype" styleId="rfdtype"/>
						<br>
    				</div>
	       			<div id="rfdfilename_a">
					    <label for="Name"><strong><span class="red">*</span>发布名称</strong>：</label>
					    <html:text name="IGSYM1402Form" property="rfdfilename" styleId="rfdfilename" size="8" style="width:200px;" errorStyleClass="inputError" tabindex="3" readonly="true" styleClass="inputDisable"/>
					    <br>
    				</div>
<!--     				<div id="rfdfilename_b" style="display: none;"> -->
						
    				<div id="type"><label for="Name"><strong><span class="red">*</span>图形类型</strong>：</label> 
						 <html:select name="IGSYM1402Form"  property="rfdpictype" style="width: 130px;" errorStyleClass="inputError" >
						 <ig:optionsCollection ccid="RFDPICTYPE" isMakeBlankRow="true" isCodeLabel="true" />
						 </html:select>
					</div>
					<div id="rfdfilename_b" >
                        <label for="Name"><strong><span class="red">*</span>报表模版</strong>：</label>
                        <html:select name="IGSYM1402Form"  property="rfdfilemodel" style="width: 130px;"
                        onchange="showLabel()"  errorStyleClass="inputError">
                         <ig:optionsCollection ccid="RFDFILEMODEL" isMakeBlankRow="true" isCodeLabel="true"/>
                         </html:select>
                        <br>
                    </div>

<!-- 					流程类型下拉单选					 -->
					 <div id="prtype_c"  style="display: none;">
					 	<label for="Name"><strong><span class='red'>*</span>流程类型</strong>：</label>
						 <html:select name="IGSYM1402Form" styleId="prtype" onchange="getPidid()" property="prtype" style="width: 130px;" errorStyleClass="inputError">
		 					<html:options collection="ADPrTypeList" property="value" name="" labelProperty="label"/>
		 				 </html:select>
					 </div>
<!-- 					 流程类型复选-->
					<div id="prtype_d"  style="display: none;">
						<label for="Name"><strong><span class='red'>*</span>流程类型</strong>：</label>
						<c:set value="${0 }" var= "num"/>
						<logic:iterate id="bean" name="ADPrTypeList">
							<c:if test="${num==4 }">
								<c:set value="${0 }" var= "num"/>
								<br/>
							</c:if>
							<logic:notEmpty name="bean" property="value">
								<html:checkbox property="prtypes" value="${bean.value }">${bean.label}</html:checkbox>
								<c:set value="${num+1 }" var= "num"/>
							</logic:notEmpty>
						</logic:iterate>
					
					 </div>
					 <div id="prstatus_b">
					 </div>
					 <div id="pidid_b">
					 </div>
					<div id="rank_a" style="display: none;">
					<label for="Name"><strong>树形级别</strong>：</label>
					<c:if test="${IGSYM1402Form.rank==0}">
					<input type="radio" name="rank" value="0" checked="checked"/>1级
					 <input type="radio" name="rank" value="1"/>2级
					</c:if>
					<c:if test="${IGSYM1402Form.rank==1}">
					<input type="radio" name="rank" value="0" />1级
					 <input type="radio" name="rank" value="1" checked="checked"/>2级
					</c:if>
					 
					<br>
					</div>
	       			<div>
					    <label for="Name"><strong>说明</strong>：</label>
					    <html:textarea name="IGSYM1402Form" property="rfddesc" cols="60" rows="6" errorStyleClass="inputError imeActive"  tabindex="4"/>
					    <br>
    				</div>
    				</fieldset>
				<div class="enter">
				    <html:submit property="btn_insert" value="提交" styleClass="button"  onclick="return checkForm();"/>
				    <html:reset property="btn_clear" styleClass="button" value="重置"/>
				</div>
				<html:hidden property="rfdid" name="IGSYM1402Form" styleId="rfdid"/>
				<html:hidden property="rfdfilename" name="IGSYM1402Form" styleId="rfdfilename"/>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>