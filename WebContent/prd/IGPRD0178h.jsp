<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<html:html>
<bean:define id="id" value="IGPRD0178h" toScope="request" />
<bean:define id="title" value="表格式表单管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
	<script type="text/javascript">	
	    function toDel(pidid){
	    	if( window.confirm("您是否确认删除？")){
	    		IGPRD0111Form.action = getAppRootUrl() + "/IGPRD0178_Del.do?pidid="+pidid;
	    		IGPRD0111Form.submit();
			}
	    }
	    function changeRow(){
	    	 alert(table.rows[1].cells[0].innerHTML);
		    
		}
		function toUp(indexselectid){
			var table = document.getElementById("table1");
			var rowtotalnum = table.rows.length;
			var coltotalnum = table.rows[0].cells.length;
			if(indexselectid == 1){
				alert("首行无法移动");
				return;
			}
			for(var i = 1; i< coltotalnum-1; i++){
				var tempvalue = table.rows[indexselectid-1].cells[i].innerHTML;
				table.rows[indexselectid-1].cells[i].innerHTML = table.rows[indexselectid].cells[i].innerHTML;
				table.rows[indexselectid].cells[i].innerHTML = tempvalue;
			}
		}

		function toDown(indexselectid){
			var table = document.getElementById("table1");
			var rowtotalnum = table.rows.length;
			var coltotalnum = table.rows[0].cells.length;
			if(indexselectid == rowtotalnum-1){
				alert("尾行无法移动");
				return;
			}
			for(var i = 1; i< coltotalnum-1; i++){
				var tempvalue = table.rows[parseInt(indexselectid)+1].cells[i].innerHTML;
				table.rows[parseInt(indexselectid)+1].cells[i].innerHTML = table.rows[indexselectid].cells[i].innerHTML;
				table.rows[indexselectid].cells[i].innerHTML = tempvalue;
			}
		}
		function saveorder(){
			var table = document.getElementById("table1");
			var rowtotalnum = table.rows.length;
			var coltotalnum = table.rows[0].cells.length;
			var orderValue = "";
			for(var i=1;i<rowtotalnum;i++){
				orderValue += table.rows[i].cells[0].innerHTML + ":" +table.rows[i].cells[1].innerHTML+"|";
			}
			if(orderValue == ""){
				alert("没有表单信息,无法排序");
				return;
			}
			if(confirm("您是否确认重新排序？")){
				IGPRD0111Form.action = getAppRootUrl() + "/IGPRD0178_Order.do?pididorder="+orderValue;
	    		IGPRD0111Form.submit();
			}
		}
		
		function showTable(){
			var pidid = document.getElementById("ppidid").value;
			var pdid = document.getElementById("pdid").value;
			var param = "pdid=" + pdid + "&pidid=" + pidid;
			openSubWindow('/IGPRD0173_Disp.do?' + param , '_mybank', '800', '600');
		}
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRD0179_Disp" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1">系统管理 &gt;&gt; 流程定义 &gt;&gt; 流程管理 &gt;&gt; 历史版本 &gt;&gt; 表单管理 &gt;&gt; 表格式表单管理</p>
	<div class="back">
	<html:link action="${IGPRD0110Form.backURL}">返回</html:link></div>
	</div>
	<div id="results_list"><ig:message />
	<bean:define id="showWidthFlag" value="1"/>
	<logic:present name="IGPRD01101VO" property="processInfoDef">
		<bean:define id="pid"  name="IGPRD01101VO" property="processInfoDef"/>
		<logic:equal value="1" name="pid" property="piddisplay">
			<bean:define id="showWidthFlag" value="2"/>
		</logic:equal>
	</logic:present>
	<table class="table_style" id="table1">
		<tr>
			<th width="4%">序号</th>
			<th style="display:none"></th>
			<th width="10%">列名称</th>
			<th width="8%">列类型</th>
			<th width="26%">取值范围</th>
            <th width="7%">默认值</th>
			<th width="15%">列说明</th>
			<th width="5%">编辑列</th>
			<th width="4%">模式</th>
			<th width="6%">
				<logic:equal value="2" name="showWidthFlag">
					宽度
				</logic:equal>
				<logic:equal value="1" name="showWidthFlag">
					显示
				</logic:equal>
			</th>
		</tr>
		<logic:present name="IGPRD01101VO" property="processInfoDefList">
			<logic:iterate id="bean" name="IGPRD01101VO"
				property="processInfoDefList" indexId="index">
				<tr>
					<td>${index+1}</td>
					<td style="display:none">${bean.pidid}</td>
					<td>
						<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
						<html:link action="/IGPRD0179_Edit_Disp.do?pidid=${bean.pidid}&mode=1&piddisplay=${IGPRD0110Form.piddisplay}">
							<logic:empty name="bean" property="pidlabel">&nbsp;</logic:empty>${bean.pidlabel}
						</html:link>
						<%} else {%>
							<logic:empty name="bean" property="pidlabel">&nbsp;</logic:empty>${bean.pidlabel}
						<%}%>
					</td>
					<td>
						<ig:codeValue ccid="TABLEFORM_PROCESSINFODEF_TYPE_CODE_WD" cid="${bean.pidtype}" />
					</td>
					<td><logic:empty name="bean" property="pidoption">&nbsp;</logic:empty>${bean.pidoption}</td>
					<td><logic:empty name="bean" property="piddefault">&nbsp;</logic:empty>${bean.piddefault}</td>
					<td><logic:empty name="bean" property="piddesc">&nbsp;</logic:empty>${bean.piddesc}</td>
					<td>
						<logic:equal name="bean" property="pidtype"  value="8">
							<html:link action="/IGPRD0178.do?pdid=${bean.pdid}&flag=flase&viewhistory=1&tableColumn=Y&ppidid=${bean.pidid}&piddisplay=${bean.piddisplay}">
							<img src="images/xx.gif" width="16" height="16" border="0" alt="编辑列" />
							</html:link>
						</logic:equal>
					</td>
					<td>
						<logic:empty name="bean" property="pidmode">
							<ig:codeValue ccid="PROCESSINFODEF_MODE_CODE" cid="0" />
						</logic:empty>
						<logic:notEmpty name="bean" property="pidmode">
							<ig:codeValue ccid="PROCESSINFODEF_MODE_CODE" cid="${bean.pidmode}" />
						</logic:notEmpty>
					</td>
					<td>
						<logic:equal value="1" name="showWidthFlag">
<!-- 							宽度 -->
							<logic:empty name="bean" property="rowwidth">
								<ig:codeValue ccid="PROCESSINFODEF_ROWWIDTH_CODE" cid="<%=IGPRDCONSTANTS.PIDROWWIDTH_FULL %>" />
							</logic:empty>
							<logic:notEmpty name="bean" property="rowwidth">
								<ig:codeValue ccid="PROCESSINFODEF_ROWWIDTH_CODE" cid="${bean.rowwidth}" />
							</logic:notEmpty>
						</logic:equal>
						<logic:equal value="2" name="showWidthFlag">
							${bean.pidwidth }
						</logic:equal>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	<html:button property="show" value="预览" styleClass="button" onclick="showTable();"/>
	</div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRD0110Form"/>
	<html:hidden property="ppidid" styleId="ppidid" name="IGPRD0110Form" />
	<html:hidden property="piddisplay" styleId="piddisplay" name="IGPRD0110Form" />
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>
