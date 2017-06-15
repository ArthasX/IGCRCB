<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRR0137" toScope="request" />
<bean:define id="title" value="抄阅人页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
function toSave(prid){
	var status${index} = document.getElementsByTagName("INPUT");
		var noHasStatusUser${index} = true;
		for(var i=0;i<status${index}.length;i++){
   		if(status${index}[i].type=="checkbox" &&
		   		 status${index}[i].checked){
   			noHasStatusUser${index} = false;
   		}
   	}
		if(noHasStatusUser${index}) {
   		alert("请选择抄阅人！");	 
       	return false;
	}

	    if( window.confirm("您是否确认提交？")){
		    document.forms[0].action = getAppRootUrl() + "/IGPRR0114_SAVE.do";
		    document.forms[0].submit();
	    }
	    else {
		    return;
	    }
	}

	function setOrg(url){
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall" == temp){
			document.forms[0].orgid_q.value = "";
			document.forms[0].orgname_q.value = "";
			return false;
		}
		if(null != temp && temp.split("|").length > 1){
			document.forms[0].orgid_q.value = temp.split("|")[0];
			document.forms[0].orgname_q.value = temp.split("|")[1];
			return false;
		}
	}

	//全选
    function selectAll(name,obj) { 
        var checks = document.getElementsByName(obj);
        if(document.getElementById(name).checked){
            for(var i=0;i < checks.length;i++) 
            { 
                if(checks[i].parentElement.parentElement.parentElement.style.display == ""){
                    checks[i].checked = true;
                }else if(checks[i].parentElement.parentElement.parentElement.style.display == "none"){
                    checks[i].checked = false;
                }
            } 
        }else{
            for(var i=0;i < checks.length;i++) 
            { 
                checks[i].checked = false; 
            } 
        }
    }
    function fun_search(){
    	var obj = document.getElementById("username_q");
    	var org = document.getElementById("orgid_q");
    	var username_q = obj.value;
    	var orgid_q = org.value;
    	document.forms[0].action = getAppRootUrl() + "/IGPRR0114_Disp.do?username_q="+username_q+"&orgid_q="+orgid_q;
		document.forms[0].submit();
    } 
	</script>
	
	<style type="text/css">
	.table_style4{    
	    width:100%;    
	    margin:0 auto;    
	    border-collapse:collapse;     
	    text-align:center;    
	}    
	.table_style4 th{
		color:#000000;   
	    border-top:1px solid #CCCCCC; 
	    background-color:#EEEEEE; 
	    height:20px;    
	}
	</style>
<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGPRR0114_Disp" onsubmit="return checkSubmit(this);" >
<div id="location">
<div class="image"></div>
<p class="fonts1">参与者</p>
<div class="back"><a href="IGPRR0102_Disp.do?pdid=${IGPRR0102Form.pdid}&prroleid=${IGPRR0102Form.prroleid}&prid=${IGPRR0102Form.prid}" target="_self">返回</a></div>
</div>
<div id="results_list">
<div id="search">
	<div class="img"></div>
		<div class="conditions">
			<label id="label_user">&nbsp;&nbsp;用户ID：<html:text property="username_q" name="IGPRR0114Form" size="10"></html:text>&nbsp;&nbsp;</label>
			<label id="label_org">&nbsp;&nbsp;机构：<html:text property="orgname_q" name="IGPRR0114Form" size="20" readonly="readonly"></html:text>
			<img src="images/tree.gif" style="cursor: hand;" alt="选择机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');"/>&nbsp;&nbsp;
			<html:hidden property="orgid_q"/>
			</label>
			<input type="button" value="查询" class="button" onclick="return fun_search();" style="height:20px"/>
		</div>
</div>
<div style="padding-left: 10px">
<ig:message/>
</div>
<logic:present name="IGPRR01141VO" property="map_cru">
<div id="TabbedPanels1" class="TabbedPanels">
	<ul>
		<li class="TabbedPanelsTab" tabindex="0">选择参与人</li>
	</ul>
	<div class="TabbedPanelsContentGroup">
		<div class="TabbedPanelsContent">	
		<logic:present name="IGPRR01141VO" property="map_cru">
			<logic:iterate id="vo_map" name="IGPRR01141VO" property="map_cru" indexId="index">
			<bean:define id="rolename" name="vo_map" property="key"/>
				
				<div style="width:540px;" id="${index}">
				<div style="width:540px; float:left;">
				<TABLE class="table_style4" align="left">
				<TBODY>
				<TR>
				<TH width="80%" align="left"><LABEL><INPUT id="checkboxs_${index}" onclick="selectAll('checkboxs_${index}','checkbox_${index}')" name="checkboxs_${index}" value="" type="checkbox"></LABEL>${rolename}</TH>
				<TH width="20%"><img id="image_${index}" style="cursor:hand;" src="images/minus.gif" width="12" height="12" onclick="toggleElement('role_${index}','image_${index}', '1')"/></TH>
				</TR>
				</TBODY>
				</TABLE>
				</div>
					<bean:define id="vo_list" name="vo_map" property="value" type="java.util.ArrayList" />
						<logic:present name="vo_map" property="value" >
						<div id="role_${index}" style="width:540px;">
							<div id="role_${index}" style="width:540px;">
								<TABLE  align="left"  class="table_style14">
									<TBODY>													
											<TR bgcolor="#EEEEEE">
											  <TH width="5%"></TH>
										  <TH width="25%" >用户ID</TH>
										  <TH width="20%">姓名</TH>
										  <TH width="50%">机构</TH>
											</TR>													
									</TBODY>
								</TABLE>
							</div>	
							<logic:iterate id="bean" name="vo_list" >																	
										<div id="role_${index}" style="width:540px;">
											<TABLE  align="left"  class="table_style14">
												<TBODY>													
														<TR>
														  <TD width="5%"><LABEL><html:multibox styleId="checkbox_${index}" property="userid" value="${bean.userid}_${bean.roleid}_${bean.rolename }_${bean.username }"/></LABEL></TD>
													  <TD width="25%" >${bean.userid}</TD>
													  <TD width="20%">${bean.username}</TD>
													  <TD width="50%">${bean.orgname}</TD>
														</TR>													
												</TBODY>
											</TABLE>
										</div>								
							<br id="br_${index }"/>
							</logic:iterate>
							</div>
						</logic:present>
				</div>
			</logic:iterate>
		</logic:present>
		</div>
	</div>
</div>
<script type="text/javascript">
<!--
var TabbedPanels1 = new Spry.Widget.TabbedPanels("TabbedPanels1");
//-->
</script>
</logic:present>
</div>
<div id="operate">
<logic:present name="IGPRR01141VO"
	property="map_cru">
	<bean:size id="lst_count" name="IGPRR01141VO" property="map_cru"/>
	<div style="">
	<c:if test="${lst_count > 0}">
		<span><html:submit property="btn_commit" value="提交" styleClass="button"  onclick="return toSave(${IGPRR0102Form.prid});"/></span>
		<span><html:reset property="btn_reset" value="重置" styleClass="button"/></span>
	</c:if>
	</div>
</logic:present>
<logic:notPresent name="IGPRR01141VO"
	property="map_cru">
		<span class="red">可抄阅者不存在</span>
</logic:notPresent>
</div>
<html:hidden property="prid" styleId="prid" name="IGPRR0114Form"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>