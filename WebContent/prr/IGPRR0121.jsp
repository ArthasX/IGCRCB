<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGPRR0121" toScope="request" />
<bean:define id="title" value="参与者画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
<script type="text/javascript">	
	function toSave(){
		if(checkNum('urids') == 0){
			alert("请选择参与者！");
	        return false;
		}
	    if(window.confirm("您是否确认保存？")){
	        return true;
	    } else {
	        return false;
	    }
	}
	
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> 
<jsp:include
 	page="/include/header2.jsp" /> 	
	<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form styleId="form" action="/IGPRR0121" onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
		<p class="fonts1">添加参与者</p>
	<div class="back"><a href="IGPRR0102_Disp.do">返回</a></div>
	</div>
	<div id="results_list">
<!-- 	<div id="search"> -->
<!-- 		<div class="img"></div> -->
<!-- 		<div class="conditions"> -->
<!-- 			<div> -->
<!-- 				<label id="label_user">&nbsp;&nbsp;姓名：<input type="text" name="username_q" id="username_q"  size="10"/>&nbsp;&nbsp;</label> -->
<!-- 				<label id="label_org">&nbsp;&nbsp;机构：<input type="text" name="orgname_q" id="orgname_q" size="20" readonly="readonly"/> -->
<!-- 				<img src="images/tree.gif" style="cursor: hand;" alt="选择机构" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');"/>&nbsp;&nbsp; -->
<!-- 				</label> -->
<!-- 				<input type="hidden" name="orgid_q" id="orgid_q"/> -->
<!-- 				<input type="button" value="查询" class="button" onclick="return fun_search();" style="height:20px"/> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	<div style="padding-left: 10px">
	<ig:message/>
	</div>
	<table class="table_style">
		<tr>
			<th width="10%">参与者</th>
			
			<th width="10%">用户ID</th>
			<th width="10%">用户姓名</th>
			<th width="15%">所属机构</th>
			
			<th width="12%">角色</th>
		</tr>
		<logic:present name="IGPRR01211VO" property="lst_UserRoleInfo">
			<logic:iterate id="bean" name="IGPRR01211VO" property="lst_UserRoleInfo"
				indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">
					<td><label><html:multibox property="urids" value="${bean.urid}" />
					</label>${bean.urid}</td>
					<td>${bean.userid}</td>
					<td>${bean.username}</td>
					<td>${bean.orgname}</td>
					<td>${bean.rolename}</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div id="operate">
		<logic:present name="IGPRR01211VO" property="lst_UserRoleInfo">
			<span>
				<html:submit property="btn_save" value="保存" styleClass="button" onclick="return toSave();" />
			</span>
		</logic:present>
	</div>
	<html:hidden property="prid" name="IGPRR0121Form" styleId="prid"/>
	<html:hidden property="prstatus" name="IGPRR0121Form" styleId="prstatus"/>
	<html:hidden property="pporgid" name="IGPRR0121Form" styleId="pporgid"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>
</body>
</html:html>