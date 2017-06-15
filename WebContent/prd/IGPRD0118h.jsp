<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<html:html>
<bean:define id="id" value="IGPRD0118h" toScope="request" />
<bean:define id="title" value="缺省规则定义" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
		var number=0;//流程变量总数
		var curnum=0;//当前操作的流程变量号
		ZD_mark=true;//header1.jsp中定义用来记录日历使用位置.
		var h1 = "<label>表单名称：</label>";
		var h2 = "<input type='text' name='vname' readonly='true'></input>";
		var h3 = "<img id='"+number+"' name='imgname' src='images/tree.gif' style='cursor: hand;' alt='选择流程变量' width='16' height='16' border='0' onClick='selectVariable(\""+"<bean:write name='IGPRD0109Form' property='pdid'/>"+"\", this);'/>";
		var h4 = "<select name='logicSign' style='width: 80px'><option value=''></option></select>";
		var h5 = "<input type='text' name='vvalue' readonly='readonly'></input>";
		var h6 = "<input style='margin-left: 70' type='button' class='delbutton' value='删除' onclick='deleteitem(this);deleteVariable()'>";
		var h7 = "<input type='hidden' name='variableID'></input>";
		var h8 = "<input type='hidden' name='vtype'></input>";
		var  v = "";//下拉框逻辑符号
		var  l = "";//日期逻辑符号
		var  p = "";//下拉框
		var  h = "";//删除button
	    function toback(){
	    	IGPRD0109Form.action = getAppRootUrl() + "/IGPRD0104_Back.do?viewhistory=1";
	    	IGPRD0109Form.submit();
	    }
	    function toDel(ptdid){
	    	if( window.confirm("您是否确认删除？")){
	    		IGPRD0109Form.action = getAppRootUrl() + "/IGPRD0109_Del.do?ptdid="+ptdid;
	    		IGPRD0109Form.submit();
			}
	    }
	  	//增加
		function toAdd(){
			for(var i=0;i<number;i++){
			    if(document.getElementsByName("vvalue")[i].value==""){
				    alert("请输入"+document.getElementsByName("vname")[i].value+"的规则值!");
				    return false;
			    }
			    
			    if(document.getElementsByName("vtype")[i].value=="7"){
				    if(checkFloatNum(document.getElementsByName("vvalue")[i].value)){
			    		alert(document.getElementsByName("vname")[i].value+"为数字,整数位最多13位,小数位最多2位!");
						return false;
					}
			    }
		    }
			var beginStep = "<%=IGPRDCONSTANTS.PROCESS_START_STATUS %>"; 
			//开始状态作为起点时，不能存在需要多个参与者同时发起的规则
			if(beginStep=="${IGPRD01091VO.processStatusDef.psdcode}"){
				if(getNum("roleidArray")>1){
					alert("当前状态为发起，请不要设定需要多个参与者同时发起的规则！");
			        return false;
				}
			}
			
	    	var pid = document.getElementsByName('roleAAA');   
	    	//是否选择动作
		    var flag = true; 
	        for(var i = 0; i < pid.length; i++){
		        if(pid[i].checked){
		        	flag = false;
		        	break;
			    }
	        }
			if(flag) {
				alert("请选择所选相应操作！");
				return false;
			}
		    if(window.confirm("您是否确认增加？")){
		    	var pid = document.getElementsByName('roleAAA');   
		        for(var i = 0; i < pid.length; i++){ 
			        if(pid[i].checked){
			        	createHiddenInputForm("condArray",pid[i].value,IGPRD0109Form);
				    }      
		        }
		        return true;
		    } else {
		        return false;
		    }
		}

		function selectRole(){
		    openSubIGSYM0306("${IGPRD0109Form.pdid}");
		}
		function setRoleParams(roleid,rolename) {
			document.getElementsByName("vvalue")[curnum].value = roleid;
		}

		function addVariable() 
		{
			h3 = "<img id='"+number+"' name='imgname' src='images/tree.gif' style='cursor: hand;' alt='选择流程变量' width='16' height='16' border='0' onClick='selectVariable(\""+"<bean:write name='IGPRD0109Form' property='pdid'/>"+"\", this);'/>";
			currRow=tb.insertRow();
			cell=currRow.insertCell();
			cell.innerHTML = h1+h2+h3+h4+h5+h6+h7+"<img name='softimg' style='display: none'/>";
			number++;
		}
		function selectVariable(pdid, obj) 
		{
			curnum=obj.id;
			openSubWindow('/IGPRD0113_Disp.do?pidmode=0&pdid='+pdid, 'newpage', '800', '600');
		}
		function setVariableLogic(id, type, name,option) 
		{
			for(var i=0;i<number;i++){
				if(document.getElementsByName("imgname")[i].id==curnum){
					if(type==7){
						tb.deleteRow(curnum);
						currRow=tb.insertRow(curnum);
						cell=currRow.insertCell();
						h3 = "<img id='"+curnum+"' name='imgname' src='images/tree.gif' style='cursor: hand;' alt='选择流程变量' width='16' height='16' border='0' onClick='selectVariable(\""+"<bean:write name='IGPRD0109Form' property='pdid'/>"+"\", this);'/>";
						h = "<input style='margin-left: 14' type='button' class='delbutton' value='删除' onclick='deleteitem(this);deleteVariable()'>";
						p = "<input type='text' name='vvalue' readonly='readonly'></input>"+"<img id='"+curnum+"' name='softimg' src='images/softkeyboard.gif' align='middle' onClick='SoftKeyboardWD($("+"hnum"+"));setCurnum(this)' border='0' style='cursor: hand'/>";
						v = "<select name='logicSign' style='width: 80px'><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN1 %>+"'>等于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN2 %>+"'>不等于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN3 %>+"'>大于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN4 %>+"'>小于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN5 %>+"'>大于等于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN6 %>+"'>小于等于</option></select>";
						cell.innerHTML = h1+h2+h3+v+p+h+h7+h8;
					}else if(type==3){
						tb.deleteRow(curnum);
						currRow=tb.insertRow(curnum);
						cell=currRow.insertCell();
						h3 = "<img id='"+curnum+"' name='imgname' src='images/tree.gif' style='cursor: hand;' alt='选择流程变量' width='16' height='16' border='0' onClick='selectVariable(\""+"<bean:write name='IGPRD0109Form' property='pdid'/>"+"\", this);'/>";
						h = "<input style='margin-left: 54' type='button' class='delbutton' value='删除' onclick='deleteitem(this);deleteVariable()'>";
						v = "<select name='logicSign' style='width: 80px'><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN1 %>+"'>等于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN2 %>+"'>不等于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN3 %>+"'>大于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN4 %>+"'>小于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN5 %>+"'>大于等于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN6 %>+"'>小于等于</option></select>";
						l = "<img id='"+curnum+"' name='softimg' src='images/date.gif' align='middle' onclick='showDate($("+"hdate"+"));setCurnum(this) ' border='0' style='cursor: hand' />";
						cell.innerHTML = h1+h2+h3+v+h5+l+h+h7+h8;
					}else if(type=='A'){
						tb.deleteRow(curnum);
						currRow=tb.insertRow(curnum);
						cell=currRow.insertCell();
						h3 = "<img id='"+curnum+"' name='imgname' src='images/tree.gif' style='cursor: hand;' alt='选择流程变量' width='16' height='16' border='0' onClick='selectVariable(\""+"<bean:write name='IGPRD0109Form' property='pdid'/>"+"\", this);'/>";
						h = "<input style='margin-left: 54' type='button' class='delbutton' value='删除' onclick='deleteitem(this);deleteVariable()'>";
						v = "<select name='logicSign' style='width: 80px'><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN1 %>+"'>等于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN2 %>+"'>不等于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN3 %>+"'>大于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN4 %>+"'>小于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN5 %>+"'>大于等于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN6 %>+"'>小于等于</option></select>";
						l = "<img id='"+curnum+"' name='softimg' src='images/date.gif' align='middle' onclick='showTime($("+"hdate"+"));setCurnum(this) ' border='0' style='cursor: hand' />";
						cell.innerHTML = h1+h2+h3+v+h5+l+h+h7+h8;
					}else if(type=='R'){
						tb.deleteRow(curnum);
						currRow=tb.insertRow(curnum);
						cell=currRow.insertCell();
						h3 = "<img id='"+curnum+"' name='imgname' src='images/tree.gif' style='cursor: hand;' alt='选择流程变量' width='16' height='16' border='0' onClick='selectVariable(\""+"<bean:write name='IGPRD0109Form' property='pdid'/>"+"\", this);'/>";
						h = "<input style='margin-left: 54' type='button' class='delbutton' value='删除' onclick='deleteitem(this);deleteVariable()'>";
						v = "<select name='logicSign' style='width: 80px'><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN1 %>+"'>等于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN2 %>+"'>不等于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN3 %>+"'>大于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN4 %>+"'>小于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN5 %>+"'>大于等于</option><option value='"+<%=IGPRDCONSTANTS.LOGICSIGN6 %>+"'>小于等于</option></select>";
						l = "<img id='"+curnum+"' name='softimg' src='images/seek.gif' align='middle' onclick='selectRole();' border='0' style='cursor: hand' />";
						cell.innerHTML = h1+h2+h3+v+h5+l+h+h7+h8;
					}else{
						tb.deleteRow(curnum);
						currRow=tb.insertRow(curnum);
						cell=currRow.insertCell();
						
						h3 = "<img id='"+curnum+"' name='imgname' src='images/tree.gif' style='cursor: hand;' alt='选择流程变量' width='16' height='16' border='0' onClick='selectVariable(\""+"<bean:write name='IGPRD0109Form' property='pdid'/>"+"\", this);'/>";

						if(option.indexOf('#')==-1){
							p="<input type='text' name='vvalue' value='"+option+"'></input>";
							h = "<input style='margin-left: 70' type='button' class='delbutton' value='删除' onclick='deleteitem(this);deleteVariable()'>";
						}else{
							var temp="";
							var ss = new Array(); 
							ss = option.split("#");
							for(j=0;j<ss.length;j++){
								temp += ("<option value='"+ss[j]+"'>"+ss[j]+"</option>");
							}
							p="<select name='vvalue'>"+temp+"</select>";
							h = "<input style='margin-left: 165' type='button' class='delbutton' value='删除' onclick='deleteitem(this);deleteVariable()'>";
						}
						v = "<select name='logicSign' style='width: 80px'><option value="+<%=IGPRDCONSTANTS.LOGICSIGN1 %>+">等于</option></select>";
						p=p+"<img name='softimg' style='display: none'/>";
						cell.innerHTML = h1+h2+h3+v+p+h+h7+h8;
					}
					document.getElementsByName("vname")[i].value=name;
					document.getElementsByName("variableID")[i].value=id;
					//document.getElementsByName("vtype")[i].value=type;
				}
			}
		}
		function setCurnum(obj) 
		{
			curnum=obj.id;	
		}
		function deleteVariable() 
		{
			number--;
			for(var i=0;i<number;i++){
				document.getElementsByName("imgname")[i].setAttribute("id", i);
				document.getElementsByName("softimg")[i].setAttribute("id", i);
			}
		}
		function setDate() 
		{
			document.getElementsByName("vvalue")[curnum].value=document.getElementById("hdate").value;
		}
		function setNum(str) 
		{
			document.getElementsByName("vvalue")[curnum].value=str;
			document.getElementById("hnum").value = str;
		}
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRD0109" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation /> &gt;&gt; 历史版本 &gt;&gt; 状态列表 &gt;&gt; 缺省规则定义</p>
	<div class="back"><a href="IGPRD0104_Back.do?viewhistory=1&pdid=<bean:write name="IGPRD0109Form" property="pdid"/>" target="_self">返回</a></div> 
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style">
		<tr>
			<th width="10%">序号</th>
			<th width="15%">当前状态</th>
			<th width="15%">跃迁状态</th>
			<th width="50%">跃迁规则</th>
			<th width="10%">删除</th>
		</tr>
		<logic:present name="IGPRD01091VO" property="processTransitionDefList">
			<logic:iterate id="bean" name="IGPRD01091VO"
				property="processTransitionDefList" indexId="index">
				<tr>
					<td>${index+1}</td>
					<td>${bean.fromPSDTB.psdname}</td>
					<td>${bean.toPSDTB.psdname}</td>
					<td>${bean.ptdcondinfo}</td>
					<td>
					<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
					<html:link href="javascript:toDel('${bean.ptdid}')">
						<img src="images/delete.gif" width="16" height="16" border="0"
							alt="删除" />
					</html:link>
					<%} %>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="formwrapper">
	
	<fieldset>
	<div><label for="Name"><strong>当前状态</strong>：</label>
	<p class="p2">${IGPRD01091VO.processStatusDef.psdname}</p>
	<br />
	</div>
	<div><label for="Name"><strong>跃迁状态</strong>：</label> <logic:present
		name="processStatusDefList">
		<html:select property="tpsdid" errorStyleClass="inputError imeActive"
			styleId="tpsdid" name="IGPRD0109Form">
			<html:options collection="processStatusDefList" property="value"
				name="" labelProperty="label" />
		</html:select>
	</logic:present> <br />
	</div>
	<div><label for="Name"><strong>跃迁规则</strong>：</label></div>
	<logic:present name="IGPRD01091VO" property="participantDefaultButtonDefInfoList">
		<logic:iterate id="bean" name="IGPRD01091VO"
			property="participantDefaultButtonDefInfoList" indexId="index">
			<logic:notEqual name="bean" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_CONFIRM %>">
				<logic:notEqual name="bean" property="pbdid" value="<%=IGPRDCONSTANTS.BUTTON_UPDATE %>">
					<input name="roleidArray" type="hidden" value="AAA" />
					<input name="roleAAA" type="radio" value="${bean.pbdid}" />
					<span>${bean.pdbdname}</span>
				</logic:notEqual>
			</logic:notEqual>
		</logic:iterate>
	</logic:present>
	
	<div>
		<img src="images/attachment.gif" />
		<a href="javascript:addVariable();">表单条件</a>
		<br>
		<table id="tb">
		</table>
	</div>
	</fieldset>
	<html:hidden property="fpsdid" styleId="fpsdid" name="IGPRD0109Form"/>
	<html:hidden property="pdid" styleId="pdid"  name="IGPRD0109Form"/> 
	</div>

<html:hidden property="flag" name="IGPRD0109Form" styleId="flag" value="1"/>
</html:form>
<input type="hidden" id="hdate" name="hdate" value="" style="width: 50" />
<input type="hidden" id="hnum" name="hnum" value="" />
</div>

</div>
<div class="zishiying"></div>
</div>

</div>

</body>
</html:html>
