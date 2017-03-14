<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>

<html:html>
<bean:define id="id" value="IGPRD0105" toScope="request"/>
<logic:equal name="IGPRD0105Form" property="mode" value="0">
<bean:define id="title" value="流程状态信息登记画面" toScope="request"/>
</logic:equal>
<logic:equal name="IGPRD0105Form" property="mode" value="1">
<bean:define id="title" value="流程状态信息变更画面" toScope="request"/>
</logic:equal>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	
		var assignStatus = new Array();
		
	    function toback(){
	    	IGPRD0105Form.action = getAppRootUrl() + "/IGPRD0104_Back.do?viewhistory=1";
	    	IGPRD0105Form.submit();
	    }

	    function checkForm(){
	    	if($F('psdname').trim() == ""){
	    		alert("请输入状态名称！");
	    		return false;
	    	}
	    	if($F('psdtype').trim() == ""){
	    		alert("请选择状态类型！");
	    		return false;
	    	}
	    	if($F('psdmode').trim() == ""){
	    		alert("请选择状态模式！");
	    		return false;
	    	}
	    	if($F('psdname').strlen()>32){
	    		alert("状态名称不能大于"+Math.floor(32/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	if($F('psddesc').strlen()>64){
	    		alert("状态说明不能大于"+Math.floor(64/strByteFlag)+"个汉字！");
	    		return false;
	    	}
	    	
	    	if($F('psdtype')=="2") {
	    	    if($F('psdmode')!="2") {
		    	    alert("并行节点必须是OA模式，请重新选择状态模式。");
	    	        return false;
	    	    }
	    	}
	    	if(checkAssign()){
	    		return false;
	    	}
    		var message = '';
            if ('${IGPRD0105Form.mode}' == '0'){
                message = '<bean:message key="IGCO10000.W001" arg0="状态基本信息" />';
	        } else {
	            message = '<bean:message key="IGCO10000.W003" arg0="状态基本信息" />';
	        }
			if( window.confirm(message)){
				return true;
			} else {
				return false;
			}
	    	
	    }
	    function searchButton(id,pbdid){
	    	var obj = document.getElementById("assignName_" + id);
        	var pbid = document.getElementById("assignPbd_" + id);
        	pbid.options.length = 0;
        	var varItemEmpty = new Option("", "");
        	pbid.options.add(varItemEmpty);
        	if("" == obj.value){
            	return;
            }
		    var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'type=searchButtonList&psdid='+obj.value,
	   		 onSuccess:  function(req, json){
	   		 var result=req.responseText;
	   			if(result != null && result != ""){
	       			var temp = result.split(";");
	       			if(temp !=null && temp.length>0){
		        		for(var i=0;i<temp.length;i++){
		        			var content = temp[i].split("#");
		        			var varItem = new Option(content[1], content[0]);    
							if(pbdid!=''&&content[0]==pbdid){
								varItem.selected = true;
							} 
		        			pbid.options.add(varItem);
		        		}
	       			}
	
	   			} 		
	   	     }
	   		});
		}

	    function setButton(obj){
		    if("" == obj.value){
			    return;}
		    var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, parameters: 'type=searchButtonList&psdid='+obj.value,
	   		 onSuccess:  function(req, json){
	   		 var result=req.responseText;
	   			if(result != null && result != ""){
	   				var selectedValue = document.getElementById("assignpbdid").value;
	   				
		        	var pbid = document.getElementById("pbid");
		        	pbid.options.length = 0;
		        	var varItemEmpty = new Option("", "");
		        	pbid.options.add(varItemEmpty);
	       			var temp = result.split(";");
	       			
	       			if(temp !=null && temp.length>0){
		        		for(var i=0;i<temp.length;i++){
		        			var content = temp[i].split("#");
		        			var varItem = new Option(content[1], content[0]);      
		        			pbid.options.add(varItem);
		        		}
	       			}
	       			pbid.value = selectedValue;
	   			} 		
	   	     }
	   		});
		}
		
	    function showModeDIV(obj){
	    	if(obj.value == "1"){
	    		document.getElementById("div_psdassign").style.display="";
	    		document.getElementById("assignInfo").style.display="";
	    	}
	    	else
	    	{
	    		document.getElementById("div_psdassign").style.display="none";
	    		document.getElementById("assignInfo").style.display="none";
	    		$("psdassign").value = "0";
	    		document.getElementById("div_assignInfo").innerHTML = '<table id="table_assignInfo" style="margin-left:120px;"></table>';
	    	}	
	    }

	    function setDefaultDIV(){
	    	if($F("psdflag") == "1"){
	    		document.getElementById("div_psdassign").style.display="";
	    		document.getElementById("assignInfo").style.display="";
	    	} else {
	    		document.getElementById("div_psdassign").style.display="none";
	    		document.getElementById("assignInfo").style.display="none";
	    		$("psdassign").value = "0";
	    		document.getElementById("div_assignInfo").innerHTML = '<table id="table_assignInfo" style="margin-left:120px;"></table>';
	    	}
	    }
	    
	    var number = 0;
	    
	    function addAssignInfo(){
	    	number ++;
	    	var tb = document.getElementById("table_assignInfo");
	    	var rowIndex = tb.rows.length;
	    	var td1,td2,td3,td4,td5,td6,td7;
	    	var tr = tb.insertRow(rowIndex);
	    	td1 = tr.insertCell(0);
			td2 = tr.insertCell(1);
			td3 = tr.insertCell(2);
			td4 = tr.insertCell(3);
			td5 = tr.insertCell(4);
			td6 = tr.insertCell(5);
			td7 = tr.insertCell(6);
	    	var s = ''; 
	    	td1.innerHTML = '<span class="red">*</span>分派状态：';
	    	s += '<select name="assignpsdids" id="assignName_'+ number +'" onchange="searchButton('+ number + ',\'\');"><option value=""></option>';
	    	for(var i=0;i<assignStatus.length;i++){
	    		s += '<option value="'+ assignStatus[i][0] +'">' + assignStatus[i][1] + '</option>';
	    	}
	    	s += '</select>';
	    	td2.innerHTML = s;
	    	td3.innerHTML = '<span class="red">*</span>分派按钮：';
	    	td4.innerHTML = '<select name="assignpbdids" id="assignPbd_'+ number +'"><option value=""></option></select>';
	    	td5.innerHTML = '<span class="red">*</span>必须分派：';
	    	td6.innerHTML = '<select name="assignflags"><option value="1">是</option><option value="0">否</option></select>';
	    	td7.innerHTML = '<a href="javascript:deleteAssignInfo('+ number +');">删除</a>';
	    	tr.id = 'tr_'+number;
	    }
	    function initAssignStatus(){
	    	<logic:present name="IGPRD01051VO" property="processStatusDefList">
		    	<logic:iterate id="bean" name="IGPRD01051VO" property="processStatusDefList">
		    		 var temp = new Array();
		    		 temp[0] = '${bean.psdid}';
		    		 temp[1] = '${bean.psdname}';
		    		 assignStatus[assignStatus.length]=temp;
		    	</logic:iterate>
			</logic:present>
			var tb = document.getElementById("table_assignInfo");
			var td1,td2,td3,td4,td5,td6,td7;
			var tr;
			var s,s1;
			<logic:present name="IGPRD01051VO" property="apList">
				<logic:iterate id="bean" name="IGPRD01051VO" property="apList">
					number ++;
					tr = tb.insertRow(tb.rows.length);
					td1 = tr.insertCell(0);
					td2 = tr.insertCell(1);
					td3 = tr.insertCell(2);
					td4 = tr.insertCell(3);
					td5 = tr.insertCell(4);
					td6 = tr.insertCell(5);
					td7 = tr.insertCell(6);
					td1.innerHTML = '<span class="red">*</span>分派状态：';
					s = ''; 
					s1 = '';
					s += '<select name="assignpsdids" id="assignName_'+ number +'" onchange="searchButton('+ number + ',\'\');"><option value=""></option>';
			    	for(var i=0;i<assignStatus.length;i++){
			    		if(assignStatus[i][0]=='${bean.assignpsdid}'){
				    		s += '<option value="'+ assignStatus[i][0] +'" selected="true">' + assignStatus[i][1] + '</option>';
			    		}else{
			    			s += '<option value="'+ assignStatus[i][0] +'">' + assignStatus[i][1] + '</option>';
			    		}
			    	}
			    	s += '</select>';
			    	td2.innerHTML = s;
			    	td3.innerHTML = '<span class="red">*</span>分派按钮：';
			    	td4.innerHTML = '<select name="assignpbdids" id="assignPbd_'+ number +'"><option value=""></option></select>';
			    	td5.innerHTML = '<span class="red">*</span>必须分派：';
			    	s1 += '<select name="assignflags" value="${bean.assignflag}">';
			    	if('1' != '${bean.assignflag}'){
			    		s1 += '<option value="1" >是</option><option value="0" selected="true">否</option>';
			    	}else{
			    		s1 += '<option value="1" >是</option><option value="0">否</option>';
			    	}
			    	s1 += '</select>';
			    	td6.innerHTML = s1;
			    	td7.innerHTML = '<a href="javascript:deleteAssignInfo('+ number +');">删除</a>';
			    	tr.id = 'tr_'+number;
			    	searchButton(number,'${bean.assignpbdid}');
				</logic:iterate>
			</logic:present>
	    }
	    function deleteAssignInfo(id){
	    	var tb = document.getElementById("table_assignInfo");
	    	var idx = document.getElementById("tr_"+id).rowIndex;
	    	tb.deleteRow(idx);
	    }
	    function checkAssign(){
	    	var objs = document.getElementsByName("assignpsdids");
	    	var pbdobjs = document.getElementsByName("assignpbdids");
	    	if(objs!=null){
	    		for(var i=0;i<objs.length;i++){
	    			if(objs[i].value==''){
	    				alert("请选择分派状态！");
	    				return true;
	    			}
	    			if(pbdobjs[i].value==''){
	    				alert("请选择分派按钮！")
	    				return true;
	    			}
	    		}
	    	}
	    	return false;
	    }
	</script>
<body onload="setDefaultDIV();initAssignStatus();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation /> &gt;&gt; 历史版本 &gt;&gt;状态列表 &gt;&gt;
	                <logic:equal name="IGPRD0105Form" property="mode" value="0">
	                                             状态登记
	                </logic:equal>
					<logic:equal name="IGPRD0105Form" property="mode" value="1">
					 状态变更
					</logic:equal>
                </p>
               
            <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 

            </div>

            <div id="formwrapper">
            <html:form styleId="form" action="/IGPRD0105" onsubmit="return checkSubmit(this);">
				<!--  message -->
				<ig:message/>
				<!--  /message -->     
                <fieldset>
					<logic:equal name="IGPRD0105Form" property="mode" value="0">
					    <legend>状态基本信息登记</legend>
					</logic:equal>
					<logic:equal name="IGPRD0105Form" property="mode" value="1">
	                    <legend> 状态基本信息变更</legend>
					</logic:equal>
    		
					
                    <div>
						<label for="Name"><strong><span class="red">*</span>状态名称</strong>：</label>
						<html:text name="IGPRD0105Form" property="psdname" styleId="psdname" size="20" style="width:200px;" errorStyleClass="inputError" tabindex="1"/>
						<br>
    				</div>
                    <div>
						<label for="Name"><strong><span class="red">*</span>状态类型</strong>：</label>
							<logic:equal name="IGPRD0105Form" property="mode" value="0">
								<html:select name="IGPRD0105Form" property="psdtype" styleId="psdtype" errorStyleClass="inputError" tabindex="2">
									<ig:optionsCollection ccid="PROCESS_NODE_TYPE_CODE" isMakeBlankRow="false" isCodeLabel="true" />
								</html:select>
							</logic:equal>
							<logic:equal name="IGPRD0105Form" property="mode" value="1">
								<html:select name="IGPRD0105Form" property="psdtype" styleId="psdtype" errorStyleClass="inputError" tabindex="2" disabled="true">
									<ig:optionsCollection ccid="PROCESS_NODE_TYPE_CODE" isMakeBlankRow="false" isCodeLabel="true" />
								</html:select>
							</logic:equal>
						<br>
    				</div>
                    <div>
						<label for="Name"><strong><span class="red">*</span>状态模式</strong>：</label>
							<logic:equal name="IGPRD0105Form" property="mode" value="0">
							<html:select name="IGPRD0105Form" property="psdmode" styleId="psdmode" errorStyleClass="inputError" tabindex="3">
								<ig:optionsCollection ccid="PROCESS_NODE_MODE_CODE" isMakeBlankRow="false" isCodeLabel="true" />
							</html:select>
							</logic:equal>
							<logic:equal name="IGPRD0105Form" property="mode" value="1">
								<html:select name="IGPRD0105Form" property="psdmode" styleId="psdmode" errorStyleClass="inputError" tabindex="3" disabled="true">
								<ig:optionsCollection ccid="PROCESS_NODE_MODE_CODE" isMakeBlankRow="false" isCodeLabel="true" />
							</html:select>
							</logic:equal>
						<br>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>可被分派</strong>：</label>
							<html:select name="IGPRD0105Form" property="psdflag" styleId="psdflag" errorStyleClass="inputError" tabindex="4" onchange="showModeDIV(this)">
								<ig:optionsCollection ccid="PROCESS_NODE_DYNAMIC_CODE" isMakeBlankRow="false" isCodeLabel="true" />
							</html:select>
							<span id="assignInfo" style="display:none;">
								<a href="javascript:addAssignInfo();">添加分派节点信息</a>
							</span>
						<br>
    				</div>
    				<div id="div_assignInfo">
    				<table id="table_assignInfo" style="margin-left:120px;">
    				</table>
    				</div>
    				<div style="display: none" id="div_psdassign">
						<label for="Name"><strong><span class="red">*</span>参与者类型</strong>：</label>
							<logic:equal name="IGPRD0105Form" property="mode" value="0">
							<html:select name="IGPRD0105Form" property="psdassign" styleId="psdassign" errorStyleClass="inputError" tabindex="5">
								<ig:optionsCollection ccid="PROCESSSTATUSDEF_PSDASSIGN" isMakeBlankRow="false" isCodeLabel="true" />
							</html:select>
							</logic:equal>
							<logic:equal name="IGPRD0105Form" property="mode" value="1">
							<html:select name="IGPRD0105Form" property="psdassign" styleId="psdassign" errorStyleClass="inputError" tabindex="5" disabled="true">
								<ig:optionsCollection ccid="PROCESSSTATUSDEF_PSDASSIGN" isMakeBlankRow="false" isCodeLabel="true" />
							</html:select>
							</logic:equal>
						<br>
					</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>参与者选择范围</strong>：</label>
							
							<html:select name="IGPRD0105Form" property="psdorg" styleId="psdorg" errorStyleClass="inputError" tabindex="6">
								<ig:optionsCollection ccid="PROCESSSTATUSDEF_PSDORG" isMakeBlankRow="false" isCodeLabel="true" />
							</html:select>
						<br>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>可调整参与者</strong>：</label>
						<html:select name="IGPRD0105Form" property="participantchange" styleId="participantchange" errorStyleClass="inputError" tabindex="5">
								<html:option value="0">否</html:option>
								<html:option value="1">是</html:option>
							</html:select>
    				</div>
    				<div>
						<label for="Name"><strong><span class="red">*</span>确认动作</strong>：</label>
							<html:select name="IGPRD0105Form" property="psdconfirm" styleId="psdconfirm" errorStyleClass="inputError" tabindex="7">
								<ig:optionsCollection ccid="PROCESSSTATUSDEF_PSDCONFIRM" isMakeBlankRow="false" isCodeLabel="true" />
							</html:select>
						<br>
    				</div>
    				<div>
                        <label for="Name"><strong>分派页面类型</strong>：</label>
                            <html:select name="IGPRD0105Form" property="assignPageType" styleId="assignPageType" errorStyleClass="inputError" tabindex="5">
                                <ig:optionsCollection ccid="ASSIGN_PAGE_TYPE" isMakeBlankRow="false" isCodeLabel="true" />
                            </html:select>
                    </div>
                    <div>
                    	<label for="Name"><strong>表单全局控制</strong>:</label>
                    	<html:select name="IGPRD0105Form" property="formGlobalControl" styleId="formGlobalControl" errorStyleClass="inputError" tabindex="6">
                    		<ig:optionsCollection ccid="FORMGLOBALCONTROL" isMakeBlankRow="false" isCodeLabel="true"/>
                    	</html:select>
                    </div>
	       			<div>
					    <label for="Name"><strong>状态说明</strong>：</label>
					    <html:text name="IGPRD0105Form" property="psddesc" styleId="psddesc" size="41" style="width:450px;" errorStyleClass="inputError" tabindex="8"/>
					    <br>
    				</div>
    				</fieldset>
				<html:hidden property="psdid" styleId="psdid" name="IGPRD0105Form"/>
		        <html:hidden property="pdid" styleId="pdid" name="IGPRD0105Form"/>
		        <html:hidden property="mode" styleId="mode" name="IGPRD0105Form"/>
            </html:form>
            </div>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>

</body>
</html:html>