<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.sym.bl.IGSYM03BLImpl"%>
<%@ page import="com.deliverik.infogovernor.svc.bl.IGPROCESSType"%>
<html:html>
<bean:define id="id" value="IGPRM0304" toScope="request" />
<bean:define id="title" value="审批人页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript"><!--	
	function checkNotSelect(obj) {
		var ret = 0; 
		var array = document.getElementsByName(obj); 
		for(var i=0;i<array.length;i++){
			if(array[i].checked==true){
				ret ++;
			}
		}
		if(ret == array.length){
			return true;
		} else {
			return false;
		}
	}

	//按钮操作提示
	function deleteRec(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="审批人" />';
        var mode="0";
        var count=0;
		if(flag=="1"){
			message = '请选择添加审批人。';
			confirmMsg = '请确认是否要进行审批人添加处理?';
			mode="1";
		}
		if(flag=="0"){
			if(document.getElementsByName('pproleid_del_three')!=null && document.getElementsByName('pproleid_del_three').length>0){
						
				if(document.getElementsByName('pproleid_del_two')!=null && document.getElementsByName('pproleid_del_two').length>0){
					if(checkNum('pproleid_del_three')==0){
						if(checkNum('pproleid_del_two')!=0&&checkNum('pproleid_del_one')==0&&checkNotSelect("pproleid_del_two")){
							alert("三级审批人存在！二级审批人不可删除");
							return false;
						}else if(checkNum('pproleid_del_one')!=0&&checkNum('pproleid_del_two')==0&&checkNotSelect("pproleid_del_one")){
							alert("三级和二级审批人存在！一级审批人不可删除");
							return false;
						}else if(checkNum('pproleid_del_one')!=0&&checkNum('pproleid_del_two')!=0){
							if(checkNotSelect("pproleid_del_one") || checkNotSelect("pproleid_del_two")) {
								alert("三级审批人存在！一级审批人和二级审批人都不可删除");
								return false;
							}
						}
					}else{
						if(checkNum('pproleid_del_one')!=0&&checkNum('pproleid_del_two')==0&&checkNotSelect("pproleid_del_one")){
							alert("二级审批人存在！一级审批人不可删除");
							return false;
						}

						var check_two = document.getElementsByName("pproleid_del_two");
						var twocount = 0;
						for(var i=0;i<check_two.length;i++){
							if(check_two[i].checked==true){
								twocount++;
							}
						}
						if(document.getElementsByName('pproleid_del_two').length > twocount){
							var check=document.getElementsByName("pproleid_del_one");
							var checkcount = 0;
							for(var i=0;i<check.length;i++){
								if(check[i].checked==true){
									checkcount++;
									if(check.length==1){
										alert("二级审批人存在！一级审批人不可为空");
										return false;
									}
									
								}
							}
							if(checkcount==check.length){
								alert("二级审批人存在！一级审批人不可为空");
								return false;
							}
						}

						
						
						var check_three = document.getElementsByName("pproleid_del_three");
						var threecount = 0;
						for(var i=0;i<check_three.length;i++){
							if(check_three[i].checked==true){
								threecount++;
							}
						}
						if(document.getElementsByName('pproleid_del_three').length > threecount){
							var check=document.getElementsByName("pproleid_del_two");
							var checkcount = 0;
							for(var i=0;i<check.length;i++){
								if(check[i].checked==true){
									checkcount++;
									if(check.length==1){
										alert("三级审批人存在！二级审批人不可为空");
										return false;
									}
									
								}
							}
							if(checkcount==check.length){
								alert("三级审批人存在！二级审批人不可为空");
								return false;
							}
						}
						
					}
					
				}
				
			}else{
				
				if(document.getElementsByName('pproleid_del_two')!=null  && document.getElementsByName('pproleid_del_two').length>0){
					if(checkNum('pproleid_del_two')==0){
						if(checkNum('pproleid_del_one')!=0&&checkNotSelect("pproleid_del_one")){
							alert("二级审批人存在！一级审批人不可删除");
							return false;
						}
					}
				}
				var check_two = document.getElementsByName("pproleid_del_two");
				var twocount = 0;
				for(var i=0;i<check_two.length;i++){
					if(check_two[i].checked==true){
						twocount++;
					}
				}
				if(document.getElementsByName('pproleid_del_two').length > twocount){
					var check=document.getElementsByName("pproleid_del_one");
					var checkcount = 0;
					for(var i=0;i<check.length;i++){
						if(check[i].checked==true){
							checkcount++;
							if(check.length==1){
								alert("二级审批人存在！一级审批人不可为空");
								return false;
							}
							
						}
					}
					if(checkcount==check.length){
						alert("二级审批人存在！一级审批人不可为空");
						return false;
					}
				}
			}		
		}
		if(flag=="1"){
			if(checkNum('pproleid_add_one')!=0){
				if(checkNum('pproleid_add_three')!=0){
					if(checkNum('pproleid_add_two')==0 && document.getElementsByName('pproleid_del_two').length==0){
						alert("不能直接增加三级审批人！请先选择二级审批人");
						return false;
					}
				}			        
			}else{
				if(checkNum('pproleid_add_three')!=0 && checkNum('pproleid_add_two')!=0&& document.getElementsByName('pproleid_del_one').length==0){
					alert("不能直接增加三级与二级审批人！请先选择一级审批人");
					return false;
				}
				if(checkNum('pproleid_add_two')!=0 && document.getElementsByName('pproleid_del_one').length==0){
					alert("不能直接增加二级审批人！请先选择一级审批人");
					return false;
				}
				if(checkNum('pproleid_add_three')!=0 && checkNum('pproleid_add_two')==0 && document.getElementsByName('pproleid_del_two').length==0){
					alert("不能直接增加三级审批人！请先选择一级审批人与二级审批人");
					return false;
				}
			}
			<logic:equal name="IGPRM0304Form" property="prtype" value="<%=IGPROCESSType.SERVICE_PRTYPE%>">
			if(checkRoledomain("_one")) {
				return false;
				};
			if(checkRoledomain("_two")) {
					return false;
				};
			if(checkRoledomain("_three")) {
					return false;
				};
			</logic:equal>
		}
        if(window.confirm(confirmMsg)){
			/*if(mode==0){
				if(getNum("roleid_del")==$("tab_del").rows.length-1){
					alert("请至少保留一个角色！");
		            return false;
				}
			}
			*/
			count=checkAndCreate(flag);
			if(count == -1) {
				alert("缺省审批人不能超过个！");
	            return false;
			}
			if(count==0){
				alert(message);
	            return false;
			}
            form.action = getAppRootUrl() + "/IGPRM0304.do?mode="+mode;
            return true;
        } else {
            return false;
        }
	}

	function checkAndCreate(flag){
		var count=0;
		if(flag==1){
			var oneArray = document.getElementsByName("pproleid_add_one"); 
			var twoArray = document.getElementsByName("pproleid_add_two"); 
			var threeArray = document.getElementsByName("pproleid_add_three"); 
			for(var i=0;i<oneArray.length;i++){
				if(oneArray[i].checked==true){
					count ++;
				}
			}
			for(var i=0;i<twoArray.length;i++){
				if(twoArray[i].checked==true){
					count ++;
				}
			}
			for(var i=0;i<threeArray.length;i++){
				if(threeArray[i].checked==true){
					count ++;
				}
			}

			if(count == 0 ){
	            return 0;
			} else {
				createAreaInputForAdd("_one" );
				createAreaInputForAdd("_two" );
				createAreaInputForAdd("_three" );
			}
			
		}else{
			var oneArray = document.getElementsByName("pproleid_del_one"); 
			var twoArray = document.getElementsByName("pproleid_del_two"); 
			var threeArray = document.getElementsByName("pproleid_del_three"); 
			for(var i=0;i<oneArray.length;i++){
				if(oneArray[i].checked==true){
					count = 1;
					break;
				}
			}
			for(var i=0;i<twoArray.length;i++){
				if(twoArray[i].checked==true){
					count = 1;
					break;
				}
			}
			for(var i=0;i<threeArray.length;i++){
				if(threeArray[i].checked==true){
					count = 1;
					break;
				}
			}
			
			if(count == 0 ){
	            return 0;
			} else {
				createAreaInputForDel("_one" );
				createAreaInputForDel("_two" );
				createAreaInputForDel("_three" );
			}
		}
		return count;
	}	
	function createAreaInputForAdd(index_str) {
		var check=document.getElementsByName("pproleid_add" + index_str);
		var rolenames=document.getElementsByName("pprolename_add" + index_str);
		var userids=document.getElementsByName("ppuserid_add" + index_str);
		var usernames=document.getElementsByName("ppusername_add" + index_str);
		var orgids=document.getElementsByName("pporgid_add" + index_str);
		var orgnames=document.getElementsByName("pporgname_add" + index_str);
		for(var i=0;i<check.length;i++){
			if(check[i].checked==true){
				createHiddenInput("roleids" + index_str,check[i].value);
				createHiddenInput("rolenames" + index_str,rolenames[i].value);
				createHiddenInput("ppuserids" + index_str,userids[i].value);
				createHiddenInput("ppusernames" + index_str,usernames[i].value);
				createHiddenInput("pporgids" + index_str,orgids[i].value);
				createHiddenInput("pporgnames" + index_str,orgnames[i].value);
			}
		}
	}
	
	function createAreaInputForDel(index_str) {
		var check=document.getElementsByName("pproleid_del" + index_str);
		var rolenames=document.getElementsByName("pprolename_del" + index_str);
		var userids=document.getElementsByName("ppuserid_del" + index_str);
		var usernames=document.getElementsByName("ppusername_del" + index_str);
		var orgids=document.getElementsByName("pporgid_del" + index_str);
		var orgnames=document.getElementsByName("pporgname_del" + index_str);
		for(var i=0;i<check.length;i++){
			if(check[i].checked == false){
				createHiddenInput("roleids" + index_str,check[i].value);
				createHiddenInput("rolenames" + index_str,rolenames[i].value);
				createHiddenInput("ppuserids" + index_str,userids[i].value);
				createHiddenInput("ppusernames" + index_str,usernames[i].value);
				createHiddenInput("pporgids" + index_str,orgids[i].value);
				createHiddenInput("pporgnames" + index_str,orgnames[i].value);
			}
		}
	}
	
	var area = "";
	
	function selectRoleUser(roleid,index){
		if(index == '1') {
			area = "_one";
		} else if(index == '2') {
			area = "_two";
		} else if(index == '3') {
			area = "_three";
		}
		openSubWindow('/IGSYM0405.do?roleida='+roleid , 'newpage', '800', '600');
	}
	function setParamRoleUser(userid,username,roleid,orgid,orgname){
		var check=document.getElementsByName("pproleid_add" + area);
		for(var i=0;i<check.length;i++){
			if(check[i].value==roleid){
				document.getElementsByName("ppuserid_add" + area)[i].value = userid;
				document.getElementsByName("ppusername_add" + area)[i].value = username;
				document.getElementsByName("pporgid_add" + area)[i].value = orgid;
				document.getElementsByName("pporgname_add" + area)[i].value = orgname;
				area = null;
				break;
			}
		}
	}

	function checkRoledomain(index_str) {
		var check = document.getElementsByName("pproleid_add" + index_str);
		var rolenames = document.getElementsByName("pprolename_add" + index_str);
		var userids=document.getElementsByName("ppuserid_add" + index_str);
		var roledomains = document.getElementsByName("roledomain_add" + index_str);
		for(var i=0;i<check.length;i++){
			if(check[i].checked){
				if(roledomains[i].value == "<%=IGSYM03BLImpl.GROUP_ROLE_MARK%>" && userids[i].value == "") {
					if(index_str == "_one") {
						alert("一级审批：" + rolenames[i].value + "角色必须指定相关人员！");
					} else if(index_str == "_two") {
						alert("二级审批：" + rolenames[i].value + "角色必须指定相关人员！");
					} else if(index_str == "_three") {
						alert("三级审批：" + rolenames[i].value + "角色必须指定相关人员！");
					}
					return true;
				}
			}
		}
		return false;
	}
//-->
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGPRM0304"
	onsubmit="return checkSubmit(this);">
	<div id="location">
<div class="image"></div>
<p class="fonts1">审批人</p>
<div class="back"><a href="IGPRM0301_Disp.do?pdid=<bean:write name="IGPRM0304Form" property="pdid" />" target="_self">返回</a></div> 
</div>
	<div id="formwrapper"><ig:message/>
	<fieldset><legend>一级审批人</legend>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="46%" valign="top">
			<div class="role_title" style="margin-left: 5px">可选角色</div>
			<table class="table_style8">
				<tr>
					<th width="10%"><input type="checkbox" name="checkbox_add_one"
						id="checkbox_add_one"
						onclick="selectAll('checkbox_add_one','pproleid_add_one')" /></th>
					<th width="30%">角色</th>
					<th width="30%">审批人</th>
					<th width="30%">机构</th>
				</tr>
				<logic:present name="IGPRM03041VO" property="roleList_one">
					<logic:iterate id="bean" name="IGPRM03041VO"
						property="roleList_one" indexId="index">
						<tr class="<ig:rowcss index="${index}"/>">
							<td><input type="checkbox" name="pproleid_add_one"
								value="${bean.roleid}"></td>
							<td>${bean.rolename}<input type="hidden"
								name="pprolename_add_one" value="${bean.rolename}"><input type="hidden"
								name="roledomain_add_one" value="${bean.roledomain}"></td>
							<td><input type="text" name="ppusername_add_one" size="6"
								style="text-align: center" readonly="readonly" /><input
								type="hidden" name="ppuserid_add_one" /> <a
								href="javascript:void(0)"
								onclick="selectRoleUser('${bean.roleid}','1');"><img
								src="images/seek.gif" alt="查询" width="16" height="16" border="0" /></a>
							</td>
							<td><input type="text" name="pporgname_add_one" size="18"
								style="text-align: center" readonly="readonly" /><input
								type="hidden" name="pporgid_add_one" /></td>
							<td>&nbsp;</td>
						</tr>
					</logic:iterate>
				</logic:present>
			</table>
			</td>
			<td width="2%"></td>
			<td width="46%" valign="top">
			<div class="role_title" style="margin-left: 5px">现有审批人</div>
			<table class="table_style8">
				<tr>
					<th width="10%"><input type="checkbox" name="checkbox_del_one"
						id="checkbox_del_one"
						onclick="selectAll('checkbox_del_one','pproleid_del_one')" /></th>
					<th width="28%">角色</th>
					<th width="30%">审批人</th>
					<th width="30%">机构</th>
					<td width="2%"></td>
				</tr>
				<logic:present name="IGPRM03041VO" property="approvorsList_one">
					<logic:iterate id="bean" name="IGPRM03041VO"
						property="approvorsList_one" indexId="index">
						<tr class="<ig:rowcss index="${index}"/>">
							<td><input type="checkbox" name="pproleid_del_one"
								value="${bean.pproleid}"></td>
							<td>${bean.pprolename}<input type="hidden"
								name="pprolename_del_one" value="${bean.pprolename}"></td>
							<td>${bean.ppusername}<input type="hidden"
								name="ppusername_del_one" value="${bean.ppusername}"><input type="hidden"
								name="ppuserid_del_one" value="${bean.ppuserid}"></td>
							<td>${bean.pporgname}<input type="hidden" name="pporgname_del_one"
								value="${bean.pporgname}"><input type="hidden" name="pporgid_del_one"
								value="${bean.pporgid}"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</table>
			</td>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend>二级审批人</legend>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="46%" valign="top">
			<div class="role_title" style="margin-left: 5px">可选角色</div>
			<table class="table_style8">
				<tr>
					<th width="10%"><input type="checkbox" name="checkbox_add_two"
						id="checkbox_add_two"
						onclick="selectAll('checkbox_add_two','pproleid_add_two');" /></th>
					<th width="30%">角色</th>
					<th width="30%">审批人</th>
					<th width="30%">机构</th>
				</tr>
				<logic:present name="IGPRM03041VO" property="roleList_two">
					<logic:iterate id="bean" name="IGPRM03041VO"
						property="roleList_two" indexId="index">
						<tr class="<ig:rowcss index="${index}"/>">
							<td><input type="checkbox" name="pproleid_add_two"
								value="${bean.roleid}"></td>
							<td>${bean.rolename}<input type="hidden"
								name="pprolename_add_two" value="${bean.rolename}"><input type="hidden"
								name="roledomain_add_two" value="${bean.roledomain}"></td>
							<td><input type="text" name="ppusername_add_two" size="6"
								style="text-align: center" readonly="readonly" /><input
								type="hidden" name="ppuserid_add_two" /> <a
								href="javascript:void(0)"
								onclick="selectRoleUser('${bean.roleid}','2');"><img
								src="images/seek.gif" alt="查询" width="16" height="16" border="0" /></a>
							</td>
							<td><input type="text" name="pporgname_add_two" size="18"
								style="text-align: center" readonly="readonly" /><input
								type="hidden" name="pporgid_add_two" /></td>
							<td>&nbsp;</td>
						</tr>
					</logic:iterate>
				</logic:present>
			</table>
			</td>
			<td width="2%"></td>
			<td width="46%" valign="top">
			<div class="role_title" style="margin-left: 5px">现有审批人</div>
			<table class="table_style8">
				<tr>
					<th width="10%"><input type="checkbox" name="checkbox_del_two"
						id="checkbox_del_two"
						onclick="selectAll('checkbox_del_two','pproleid_del_two')" /></th>
					<th width="28%">角色</th>
					<th width="30%">审批人</th>
					<th width="30%">机构</th>
					<td width="2%"></td>
				</tr>
				<logic:present name="IGPRM03041VO" property="approvorsList_two">
					<logic:iterate id="bean" name="IGPRM03041VO"
						property="approvorsList_two" indexId="index">
						<tr class="<ig:rowcss index="${index}"/>">
							<td><input type="checkbox" name="pproleid_del_two"
								value="${bean.pproleid}"></td>
							<td>${bean.pprolename}<input type="hidden"
								name="pprolename_del_two" value="${bean.pprolename}"></td>
							<td>${bean.ppusername}<input type="hidden"
								name="ppusername_del_two" value="${bean.ppusername}"><input type="hidden"
								name="ppuserid_del_two" value="${bean.ppuserid}"></td>
							<td>${bean.pporgname}<input type="hidden" name="pporgname_del_two"
								value="${bean.pporgname}"><input type="hidden" name="pporgid_del_two"
								value="${bean.pporgid}"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</table>
			</td>
		</tr>
	</table>
	</fieldset>
	<fieldset><legend>三级审批人</legend>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td width="46%" valign="top">
			<div class="role_title" style="margin-left: 5px">可选角色</div>
			<table class="table_style8">
				<tr>
					<th width="10%"><input type="checkbox"
						name="checkbox_add_three" id="checkbox_add_three"
						onclick="selectAll('checkbox_add_three','pproleid_add_three')" /></th>
					<th width="30%">角色</th>
					<th width="30%">审批人</th>
					<th width="30%">机构</th>
				</tr>
				<logic:present name="IGPRM03041VO" property="roleList_three">
					<logic:iterate id="bean" name="IGPRM03041VO"
						property="roleList_three" indexId="index">
						<tr class="<ig:rowcss index="${index}"/>">
							<td><input type="checkbox" name="pproleid_add_three"
								value="${bean.roleid}"></td>
							<td>${bean.rolename}<input type="hidden"
								name="pprolename_add_three" value="${bean.rolename}"><input type="hidden"
								name="roledomain_add_three" value="${bean.roledomain}"></td>
							<td><input type="text" name="ppusername_add_three" size="6"
								style="text-align: center" readonly="readonly" /><input
								type="hidden" name="ppuserid_add_three" /> <a
								href="javascript:void(0)"
								onclick="selectRoleUser('${bean.roleid}','3');"><img
								src="images/seek.gif" alt="查询" width="16" height="16" border="0" /></a>
							</td>
							<td><input type="text" name="pporgname_add_three" size="18"
								style="text-align: center" readonly="readonly" /><input
								type="hidden" name="pporgid_add_three" /></td>
							<td>&nbsp;</td>
						</tr>
					</logic:iterate>
				</logic:present>
			</table>
			</td>
			<td width="2%"></td>
			<td width="46%" valign="top">
			<div class="role_title" style="margin-left: 5px">现有审批人</div>
			<table class="table_style8">
				<tr>
					<th width="10%"><input type="checkbox"
						name="checkbox_del_three" id="checkbox_del_three"
						onclick="selectAll('checkbox_del_three','pproleid_del_three')" /></th>
					<th width="28%">角色</th>
					<th width="30%">审批人</th>
					<th width="30%">机构</th>
					<td width="2%"></td>
				</tr>
				<logic:present name="IGPRM03041VO" property="approvorsList_three">
					<logic:iterate id="bean" name="IGPRM03041VO"
						property="approvorsList_three" indexId="index">
						<tr class="<ig:rowcss index="${index}"/>">
							<td><input type="checkbox" name="pproleid_del_three"
								value="${bean.pproleid}"></td>
							<td>${bean.pprolename}<input type="hidden"
								name="pprolename_del_three" value="${bean.pprolename}"></td>
							<td>${bean.ppusername}<input type="hidden"
								name="ppusername_del_three" value="${bean.ppusername}"><input type="hidden"
								name="ppuserid_del_three" value="${bean.ppuserid}"></td>
							<td>${bean.pporgname}<input type="hidden" name="pporgname_del_three"
								value="${bean.pporgname}"><input type="hidden" name="pporgid_del_three"
								value="${bean.pporgid}"></td>
						</tr>
					</logic:iterate>
				</logic:present>
			</table>
			</td>
		</tr>
	</table>
	</fieldset>
	<div class="enter"><html:submit property="btn_add" value="添加所选"
		styleClass="button" onclick="return deleteRec('1');" /><html:submit
		property="btn_delete" value="删除所选" styleClass="button"
		onclick="return deleteRec('0');" /></div>
	</div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRM0304Form" />
	<html:hidden property="prtype" styleId="prtype" name="IGPRM0304Form" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>