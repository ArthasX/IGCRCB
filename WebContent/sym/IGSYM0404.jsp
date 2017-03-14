<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@page import="java.util.List"%>
<html:html>
<bean:define id="id" value="IGSYM0404" toScope="request" />
<bean:define id="title" value="授权管理菜单授权画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function deleteRec(obj){
		var message = '请选择添加对象。';
		var confirmMsg = '请确认是否要进行菜单添加处理?';
		if(checkNum(obj)==0){
			alert(message);
            return false;
		}
        if(window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGSYM0404.do";
            return true;
        } else {
            return false;
        }
	}

function clickFirst(firstNum,obj)
{
	//是否以firstNum开头
	var myReg = new RegExp('^' + firstNum.substring(0, firstNum.length - 1));
	var childs = document.getElementsByName("actionids");
	for(var i=0; i<childs.length; i++)
	{
		if(myReg.test(childs[i].id))
		{
			childs[i].checked=obj.checked;
		}
	}
}

function clickSecond(firstNum,secondNum,obj)
{
	if(obj.checked)
	{
		document.getElementById(firstNum).checked=true;
		clickFirst(secondNum,obj);
	}
	else{
		clickFirst(secondNum,obj);
		var isChecked=false;
		var childs=document.getElementsByName("actionids");
		//是否以firstNum开头
		var myReg = new RegExp('^' + firstNum.substring(0, firstNum.length - 1));
		for(var i=0; i<childs.length; i++){
			if(myReg.test(childs[i].id) && childs[i].id!=firstNum)
			{
				if(childs[i].checked){
					isChecked=true;
					break;
				}
			}
		}
		document.getElementById(firstNum).checked=isChecked;
	}
}

function clickThird(firstNum,secondNum,obj)
{
	selectBut(obj);
	if(obj.checked)
	{
		document.getElementById(firstNum).checked=true;
		document.getElementById(secondNum).checked=true;
	}
	else{
		var isChecked=false;
		var childs=document.getElementsByName("actionids");
		//是否以secondNum开头
		var myReg = new RegExp('^' + secondNum.substring(0, secondNum.length - 1));
		for(var i=0; i<childs.length; i++){
			if(myReg.test(childs[i].id) && childs[i].id!=secondNum)
			{
				if(childs[i].checked){
					isChecked=true;
					break;
				}
			}
		}
		document.getElementById(secondNum).checked=isChecked;
		if(!isChecked)
		clickSecond(firstNum,secondNum,document.getElementById(secondNum));
	}
}

function selectBut(thirdNum){
	var childs=document.getElementsByName("actionids");
	//是否以thirdNum开头
	var myReg = new RegExp('^' + thirdNum);
	for(var i=0; i<childs.length; i++){
		if(myReg.test(childs[i].id) && childs[i].id!=thirdNum.id)
		{
			childs[i].checked=thirdNum.checked;
		}
	}
}


function clickBut(firstNum,secondNum,thirdNum,obj)
{
	if(obj.checked)
	{
		document.getElementById(firstNum).checked=true;
		document.getElementById(secondNum).checked=true;
		document.getElementById(thirdNum).checked=true;
	}
	else{
		var isChecked=false;
		var childs=document.getElementsByName("actionids");
		//是否以secondNum开头
		var myReg = new RegExp('^' + secondNum.substring(0, secondNum.length - 1));
		for(var i=0; i<childs.length; i++){
			if(myReg.test(childs[i].id) && childs[i].id!=secondNum)
			{
				if(childs[i].checked){
					isChecked=true;
					break;
				}
			}
		}
		document.getElementById(secondNum).checked=isChecked;
		if(!isChecked)
		clickSecond(firstNum,secondNum,document.getElementById(secondNum));
	}
}

function dispsub(tId)
{
	var t = document.getElementById(tId);
	//Change Img
	var objimg = document.getElementById(tId+"Arrow");
	if (objimg.src.match('Right'))
	{
		objimg.src = objimg.src.replace('Right','Down');
	}
	else
	{
		objimg.src = objimg.src.replace('Down','Right');
	}

	if(t.style.display=='none')
	{	
		t.style.display='';
	}
	else{
		t.style.display='none';
	}
}

//-->
	</script><body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">  <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
<div class="back"><a href="IGSYM0403_RE.do" target="_self">返回</a></div>
</div>
	<div class="role_title">被授权角色</div>
	<div id="results_list">

	<table class="table_style6" align="left" >
			<tr>
				<th width="22%">
				角色名称
				</th>
				<td ><bean:write name="IGSYM0404Form" property="rolename"/>
				</td>
				
			</tr>
		
			
	</table>
	</div>


<div class="role_title">菜单列表</div>
<div id="results_list"><ig:message /> <html:form styleId="form"
	action="/IGSYM0404" onsubmit="return checkSubmit(this);">
	<html:hidden  property="rolename"/>
	<input type="hidden" name="flag" value="1">
	<logic:present name="IGSYM04041VO" property="actionList">
		<logic:iterate id="list" name="IGSYM04041VO" property="actionList"
			indexId="index">
			<logic:iterate id="firstMap" name="list">
				<bean:define id="firstKey" name="firstMap" property="key" />
				<bean:define id="firstValue" name="firstMap" property="value" />
				<table width="100%" border="0" cellspacing="2" cellpadding="0">
					<tr class="first">
						<td>
						<table border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="40">&nbsp;</td>
								<td width="60">${firstKey.actlabel}</td>
								<td width="20"><label> <html:multibox
									styleId="${firstKey.actsortid}s" property="actionids"
									value="${firstKey.actname}"
									onclick="clickFirst('${firstKey.actsortid}s',this)" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; </label></td>
								<td>&nbsp;</td>
							</tr>
						</table>
						</td>
					</tr>
					<%
						for (int i = 0, j = 6; i < ((List) firstValue).size(); i = i + j) {
					%>
					<tr>
						<td>
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
							<tr class="second">
								<logic:iterate id="secondList" name="firstValue"
									offset="<%=String.valueOf(i)%>" length="<%=String.valueOf(j)%>">
									<logic:iterate id="secondMap" name="secondList">
										<bean:define id="secondKey" name="secondMap" property="key" />
										<bean:define id="secondValue" name="secondMap"
											property="value" />
										<td width="58">&nbsp;</td>
										<td width="85">${secondKey.actlabel}</td>
										<td width="20"><label> <html:multibox
											styleId="${secondKey.actsortid}s" property="actionids"
											value="${secondKey.actname}"
											onclick="clickSecond('${firstKey.actsortid}s','${secondKey.actsortid}s',this)" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										</label></td>
									</logic:iterate>
								</logic:iterate>
								<td>&nbsp;</td>
							</tr>
							<tr class="third">
								<logic:iterate id="secondList" name="firstValue"
									offset="<%=String.valueOf(i)%>" length="<%=String.valueOf(j)%>">
									<logic:iterate id="secondMap" name="secondList">
										<bean:define id="secondKey" name="secondMap" property="key" />
										<bean:define id="secondValue" name="secondMap"
											property="value" />
										<td valign="top" colspan="3" align="right"><logic:iterate
											id="thirdList" name="secondValue">
											<logic:iterate id="thirdMap" name="thirdList">
												<bean:define id="thirdKey" name="thirdMap" property="key" />
												<bean:define id="thirdValue" name="thirdMap"
													property="value" />
												<%
													if (((java.util.List) thirdValue).size() > 0) {
												%>
												<img style="cursor: hand;"
													onclick="dispsub('${thirdKey.actname}')"
													id="${thirdKey.actname}Arrow" src="images/ArrowDown.gif"
													width="16" height="16" />
												<%
													}
												%>${thirdKey.actlabel}<html:multibox
													styleId="${thirdKey.actsortid}s" property="actionids"
													value="${thirdKey.actname}"
													onclick="clickThird('${firstKey.actsortid}s','${secondKey.actsortid}s',this)" />&nbsp;&nbsp;&nbsp;&nbsp;
												<br />
												<%
													if (((List) thirdValue).size() > 0) {
												%>
												<table width="100%" cellspacing="0" cellpadding="0"
													border="0" id="${thirdKey.actname}" style="display: none">
													<tr align="center">
														<td align="right"><logic:iterate id="but"
															name="thirdValue">
										${but.actlabel}<html:multibox styleId="${but.actsortid}s"
																property="actionids" value="${but.actname}"
																onclick="clickBut('${firstKey.actsortid}s','${secondKey.actsortid}s','${thirdKey.actsortid}s',this)" />
															<br />
														</logic:iterate></td>
													</tr>
												</table>
												<%
													}
												%>
											</logic:iterate>
										</logic:iterate></td>
									</logic:iterate>
								</logic:iterate>
								<td>&nbsp;</td>
							</tr>
						</table>
						</td>
					</tr>
					<%
						}
					%>
				</table>
			</logic:iterate>
		</logic:iterate>
	</logic:present>
	<div class="enter">
	<logic:present
				name="IGSYM04041VO" property="actionList">
				<span><html:submit property="btn_delete" value="添加所选" styleClass="button" style="height:20px;"
					onclick="return deleteRec('actionids');" /></span>
				<span><html:reset value="重置"
				styleClass="button" style="height:20px;" /></span>
			</logic:present>
	</div>
	<html:hidden property="roleid" styleId="roleid" />
</html:form>
</div>
</div>
</div>
</div>
</div>
</body>
</html:html>