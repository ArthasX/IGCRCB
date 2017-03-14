<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0202" toScope="request" />
<bean:define id="title" value="物品管理 页面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">

	//删除所选
	function deleteRec(obj){
		var message = '<bean:message key="IGCO10000.E002"/>';
		var confirm = '<bean:message key="IGLOM0001.I001"/>';
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
	    if(window.confirm(confirm)){
	        return true;
	    } else {
	        return false;
	    }
	}

	function showIncident(){
	
			var ccid = "216";
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
				$("gcategory").value="";
				$("gcategoryname").value="";
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
	
				
				$("gcategory").value=treesyscode;
				$("gcategoryname").value=name;
				
				
			}		
			
		}
</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"><!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">后勤管理 &gt;&gt; 物品管理 &gt;&gt; 物品管理</p>
</div>
<div id="search">
<html:form action="/IGLOM0202">
<div class="img"></div>
<div class="conditions">

<span>物品种类：</span>
		<html:text property="gcategoryname" size="18" readonly="true"/> 
		<img src="images/tree.gif" border="0" width="16" height="16" alt="查询" onclick="showIncident()" style="cursor: hand"/>
		<html:hidden property="gcategory" />&nbsp;&nbsp;<span>物品名称：</span><html:text property="gname_q" />&nbsp;&nbsp;
<input type="submit" value="查询" class="button" />


</div>
</html:form>
</div>

<ig:message/>
<table class="table_style">
	<tr>
<!--		<th width="10%">-->
<!--			<input type="checkbox" name="checkbox" id="checkbox" onclick="selectAll('checkbox','deleteGoodid')"/>-->
<!--		</th>-->
		<th width="10%">物品编号</th>
		<th width="15%">物品名称</th>
		<th width="15%">物品种类</th>
		<th width="10%">单位</th>
		<th width="7%">状态</th>
		<th width="10%">状态改变原因</th>
		<th width="10%">预警提示数量</th>
		<th width="12%">内部转移定价(%)</th>
		<th width="10%">修改</th>
	</tr>
	
	<logic:present name="IGLOM02021VO" property="goodsList">
		<logic:iterate id="bean" name="IGLOM02021VO" property="goodsList" indexId="index">
			<tr>
<!--				<td>-->
<!--					<input type="checkbox" name="deleteGoodid" value="${bean.gid}"/>-->
<!--				</td>-->
				<td>${bean.gcode}</td>
				<td>${bean.gname}</td>
				<td>
					<ig:projectTypeValue ptype="${bean.gcategory}" />
				</td>
				<td>${bean.gunit}</td>
				<td>
					<ig:cseCodeValue codeIndex="<%=CodeUtils.GOODS_STATUS%>" codeValue="${bean.gstatus}" />
				</td>
				<td>
					${bean.greason}
				</td>
				<td>${bean.gwarningnum}</td>
				<td>
					${bean.gprice}
				</td>
				<td>
					<a href="IGLOM0201_Edit.do?gid=${bean.gid}">
						<img src="images/edit.gif" width="16" height="16" border="0" alt="修改" />
					</a>
				</td>
			</tr>
		</logic:iterate>
	</logic:present>

</table>
</div>

<div id="operate">
	<jsp:include page="/include/paging.jsp" />
</div>

</div>
</div>
</div>

</body>
</html:html>