<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDUT0202" toScope="request" />
<bean:define id="title" value="值班人画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">

function submitForm(obj){
	var count = 0;
	if(1 == obj){
		var dayShiftUserids = document.getElementsByName("dayShiftUserids");
		for(var i=0;i<dayShiftUserids.length;i++){
			if(dayShiftUserids[i].checked==true){
				count++;
			}
		}
		var nightShiftUserids = document.getElementsByName("nightShiftUserids"); 
		for(var i=0;i<nightShiftUserids.length;i++){
			if(nightShiftUserids[i].checked==true){
				count++;
			}
		}
		if(0 == count){
			alert("请选择值班人");
			count = 0;
			return false;
		}
	}
	if(0 == obj){
		var dayShiftDutyUserids = document.getElementsByName("dayShiftDutyUserids");
		for(var i=0;i<dayShiftDutyUserids.length;i++){
			if(dayShiftDutyUserids[i].checked==true){
				count++;
			}
		}
		var nightShiftDutyUserids = document.getElementsByName("nightShiftDutyUserids"); 
		for(var i=0;i<nightShiftDutyUserids.length;i++){
			if(nightShiftDutyUserids[i].checked==true){
				count++;
			}
		}
		if(0 == count){
			alert("请选择值班人");
			count = 0;
			return false;
		}
	}
	if(window.confirm("是否调整值班人？")){
        form.action = getAppRootUrl() + "/IGDUT0202.do?mode="+obj;
        return true;
    } else {
        return false;
    }
}

function doback(){
	var backForm = document.getElementById("backForm");
	backForm.submit();
}
</script>
<!-- /header1 -->
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
              <p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; 值班人</p>
              <div class="back">
              	<a href="javascript:doback();">返回</a>
              </div>
       </div>
       
      <div id="formwrapper">
      <ig:message/>
      <form action="IGDUT0201_Disp.do" id="backForm">
      	<html:hidden property="forward" value="0"/>
      	<html:hidden property="dadcategory" value="${IGDUT0202Form.dadcategory}"/>
      	<html:hidden property="showYear" value="${IGDUT0202Form.showYear}"/>
      	<html:hidden property="showMonth" value="${IGDUT0202Form.showMonth}"/>
      </form>
      
      <html:form styleId="form" action="/IGDUT0202" onsubmit="return checkSubmit(this);">
      <fieldset><legend>白班值班人</legend>
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="46%" valign="top">
			<div class="role_title" style="margin-left: 5px">白班可选人员</div>
			<table class="table_style8">
				<tr>
					<th width="10%"></th>
					<th width="40%">用户ID</th>
					<th width="50%">用户姓名</th>
				</tr>
				<logic:present name="IGDUT02021VO" property="dayShiftUsers">
					<logic:iterate id="bean" name="IGDUT02021VO" property="dayShiftUsers">
					<tr>
						<td><input type="checkbox" name="dayShiftUserids"
							value="1__${bean.userid},,,,<ig:userNameValue userid="${bean.userid}"/>" 
							<logic:equal name="IGDUT02021VO" property="dayShift" value="0">
								disabled="disabled"
							</logic:equal>></td>
						<td>${bean.userid}</td>
						<td>
							<ig:userNameValue userid="${bean.userid}" />
						</td>
						<td></td>
					</tr>
					</logic:iterate>
				</logic:present>
					
			</table>
			</td>
			<td width="2%"></td>
			<td width="46%" valign="top">
			<div class="role_title" style="margin-left: 5px">白班现有值班人</div>
			<table class="table_style8">
				<tr>
					<th width="10%"></th>
					<th width="40%">用户ID</th>
					<th width="48%">用户姓名</th>
					<td width="2%"></td>
				</tr>
				<logic:present name="IGDUT02021VO" property="dayShiftDutyUsers">
					<logic:iterate id="bean" name="IGDUT02021VO" property="dayShiftDutyUsers">
					<tr>
						<td>
							<input type="checkbox" name="dayShiftDutyUserids" value="1__${bean.userid}" 
							<logic:equal name="IGDUT02021VO" property="dayShift" value="0">
								disabled="disabled"
							</logic:equal>></td>
						<td>${bean.userid}</td>
						<td>
							<ig:userNameValue userid="${bean.userid}" />
						</td>
						<td></td>
					</tr>
					</logic:iterate>
				</logic:present>
			</table>
			</td>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend>夜班值班人</legend>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="46%" valign="top">
			<div class="role_title" style="margin-left: 5px">夜班可选人员</div>
			<table class="table_style8">
				<tr>
					<th width="10%"></th>
					<th width="40%">用户ID</th>
					<th width="50%">用户姓名</th>
				</tr>
				<logic:present name="IGDUT02021VO" property="nightShiftUsers">
					<logic:iterate id="bean" name="IGDUT02021VO" property="nightShiftUsers">
					<tr>
						<td><input type="checkbox" name="nightShiftUserids"
							value="2__${bean.userid},,,,<ig:userNameValue userid="${bean.userid}" />"></td>
						<td>${bean.userid}</td>
						<td>
							<ig:userNameValue userid="${bean.userid}" />
						</td>
						<td>&nbsp;</td>
					</tr>
					</logic:iterate>
				</logic:present>
			</table>
			</td>
			<td width="2%"></td>
			<td width="46%" valign="top">
			<div class="role_title" style="margin-left: 5px">夜班现有值班人</div>
			<table class="table_style8">
				<tr>
					<th width="10%"></th>
					<th width="40%">用户ID</th>
					<th width="48%">用户姓名</th>
					<td width="2%"></td>
				</tr>
				<logic:present name="IGDUT02021VO" property="nightShiftDutyUsers">
					<logic:iterate id="bean" name="IGDUT02021VO" property="nightShiftDutyUsers">
					<tr>
						<td><input type="checkbox" name="nightShiftDutyUserids"
							value="2__${bean.userid}"></td>
						<td>${bean.userid}</td>
						<td>
							<ig:userNameValue userid="${bean.userid}" />
						</td>
						<td></td>
					</tr>
					</logic:iterate>
				</logic:present>
			</table>
			</td>
		</tr>
	</table>
	</fieldset>
	
	<div class="enter">
		<html:submit property="btn_add" value="添加所选" styleClass="button" onclick="return submitForm('1');" />
		<html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return submitForm('0');" />
	</div> 
		<html:hidden property="dptime" name="IGDUT0202Form" />
		<html:hidden property="dadcategory" name="IGDUT0202Form" />
		<html:hidden property="forward" value="0"/>
      	<html:hidden property="dadcategory" name="IGDUT0202Form"/>
      	<html:hidden property="showYear" name="IGDUT0202Form"/>
      	<html:hidden property="showMonth" name="IGDUT0202Form"/>
      	<html:hidden property="dayshift" name="IGDUT0202Form"/>
		</html:form>
    </div>
</div>
</div>
</div>
</div>
</body>
</html:html>