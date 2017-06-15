<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRJ0104" toScope="request" />
<bean:define id="title" value="调整负责人页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
<!--
	//按钮操作提示
	function submitForm(flag){
        var message = '<bean:message key="IGCO10000.E002"/>';
        var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="负责人" />';
        var mode="0";
        var count=0;
		if(flag=="1"){
			message = '请选择添加负责人。';
			confirmMsg = '请确认是否要进行负责人添加处理?';
			mode="1";
		}
        if(window.confirm(confirmMsg)){
//			if(mode==0){
//				if(getNum("roleid_del")==$("tab_del").rows.length-1){
//					alert("请至少保留一个角色！");
//		            return false;
//				}
//			}
			count=checkAndCreate(flag);
			if(count==2){
				alert("请选择人员！");
	            return false;
			}
			if(count==0){
				alert(message);
	            return false;
			}
            form.action = getAppRootUrl() + "/IGPRJ0104.do?mode="+mode;
            return true;
        } else {
            return false;
        }
	}
	function checkAndCreate(flag){
		var count=0;
		if(flag==1){
			var check=document.getElementsByName("roleid_add");
			var userids=document.getElementsByName("ppuserid");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
					//createHiddenInput("roleids",check[i].value);
					if(userids[i].value == ""){
						count=2;
						return count;
					}
					createHiddenInput("userids",userids[i].value);
				}
			}
		}else{
			var check=document.getElementsByName("roleid_del");
			var userids=document.getElementsByName("userid_del");
			for(var i=0;i<check.length;i++){
				if(check[i].checked==true){
					count=1;
					//createHiddenInput("roleids",check[i].value);
					createHiddenInput("userids",userids[i].value);
				}
			}
		}
		return count;
	}	

	function selectRoleUser(roleid){
		openSubWindow('/IGSYM0406.do?roleida='+roleid , 'newpage', '800', '600');
	}
	function setParamRoleUser(userid,username,roleid,orgid,orgname){
		var check=document.getElementsByName("roleid_add");
		for(var i=0;i<check.length;i++){
			if(check[i].value==roleid){
				if(userid.trim()!=""&&orgname.trim()!=""){
					check[i].checked = true;
				}else{
					check[i].checked = false;
				}
				document.getElementsByName("ppuserid")[i].value = userid;
				document.getElementsByName("ppusername")[i].value = username;
				document.getElementsByName("pporgid")[i].value = orgid;
				document.getElementsByName("pporgname")[i].value = orgname;
				break;
			}
		}
	}
//-->
	</script>
<link rel="stylesheet" href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRJ0104" onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">负责人</p>
<div class="back"><a href="IGPRJ0101_Detail.do?pid=<bean:write name="IGPRJ0104Form" property="pid" />" target="_self">返回</a></div> 
</div>
	<div class="role_title">现有负责人（负责人不能为空且不能多于3人）</div>
	<div id="results_list"><!--  message --> <ig:message /> <!--  /message -->
	<table id="tab_del" class="table_style" align="left">
			<tr>
				<th width="10%" ><label> <input type="checkbox"
					name="checkbox1" id="checkbox1" onclick="selectAll('checkbox1','roleid_del')"/> </label>
				</th>
				<th width="90%">负责人</th>
			</tr>
			<logic:present name="IGPRJ0104VO" property="principalList">
				<logic:iterate id="bean" name="IGPRJ0104VO"
					property="principalList" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td><label>
						<input type="checkbox" name="roleid_del" value="${bean}">
						 </label>
						</td>
						<td>
							<ig:userNameValue userid="${bean}" />
							<input type="hidden" name="userid_del" value="${bean}">
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<logic:present name="IGPRJ0104VO"
		property="principalList">
		<span> <html:submit property="btn_delete" value="删除所选"
			styleClass="button" onclick="return submitForm('0');" /></span>
	</logic:present>
	</div>
	<div class="role_title">可选角色</div>

	<logic:present name="IGPRJ0104VO" property="roleMap">
		<div id="TabbedPanels1" class="TabbedPanels">
		<ul class="TabbedPanelsTabGroup">
			<logic:iterate id="map" name="IGPRJ0104VO" property="roleMap" indexId="number">
				<li class="TabbedPanelsTab">
					<ig:codeValue ccid="ROLE_CATEGORY_CODE" cid="${map.key}" />
				</li>
			</logic:iterate>
		</ul>
		<div class="TabbedPanelsContentGroup">
		<logic:present name="IGPRJ0104VO" property="roleMap">
			<logic:iterate id="map" name="IGPRJ0104VO" property="roleMap" indexId="number">
				<bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
				<div class="TabbedPanelsContent">
				<div class="record_list">
				<table class="table_style" align="left">
					<tr>
						<th width="8%">
						</th>
						<th width="20%">角色</th>
						<th width="40%">负责人</th>
						<th width="32%">机构</th>
					</tr>
				<logic:iterate id="bean" name="list" indexId="index">
					<tr class="<ig:rowcss index="${index}"/>">
						<td>
							<label>
								<input type="checkbox" name="roleid_add" value="${bean.roleid}">
							</label>
						</td>
						<td>
							${bean.rolename}
							<input type="hidden" name="rolename" value="${bean.rolename}">
						</td>
						<td>
							<input type="text" name="ppusername" size="40" style="text-align: center" readonly="readonly"/>
							<input type="hidden" name="ppuserid"/>
							<a href="javascript:void(0)" onclick="selectRoleUser('${bean.roleid}');">
								<img src="images/seek.gif" alt="查询" width="16" height="16" border="0" />
							</a>
						</td>
						<td>
							<input type="text" name="pporgname" size="40" style="text-align: center" readonly="readonly" />
							<input type="hidden" name="pporgid" />
						</td>
					</tr>
				</logic:iterate>
				</table>
				</div>
				</div>
			</logic:iterate>
		</logic:present></div>
		</div>
	<script type="text/javascript">
	<!--
	var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
	//-->
	</script>
	</logic:present>
	<div id="operate">
	<logic:present name="IGPRJ0104VO" property="roleMap">
		<span> 
			<html:submit property="btn_delete" value="添加所选" styleClass="button"  onclick="return submitForm('1');"/>
		</span>
	</logic:present>
	</div>
	<html:hidden property="pid" />
</html:form></div>
</div>
</div>


</div>
</body>
</html:html>