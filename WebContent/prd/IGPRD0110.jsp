<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS" %>
<html:html>
<bean:define id="id" value="IGPRD0110" toScope="request" />
<bean:define id="title" value="表单信息管理" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
	<script type="text/javascript">	
	    function toback(){
	    	IGPRD0111Form.action = getAppRootUrl() + "/IGPRD0101_Back.do";
	    	IGPRD0111Form.submit();
	    }
	   
	    function toDel(pidid){
	    	if( window.confirm("您是否确认删除？")){
	    		IGPRD0111Form.action = getAppRootUrl() + "/IGPRD0111_Del.do?pidid="+pidid;
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
				IGPRD0111Form.action = getAppRootUrl() + "/IGPRD0111_Order.do?pididorder="+orderValue;
	    		IGPRD0111Form.submit();
			}
		}
	</script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content"><html:form action="/IGPRD0111_Disp" styleId="form"
	onsubmit="return checkSubmit(this);">
	<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation /> &gt;&gt; 表单管理</p>
	<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
	</div>
	<div id="results_list"><ig:message />
	<table class="table_style" id="table1">
		<tr>
			<th width="4%">序号</th>
			<th style="display:none"></th>
			<th width="10%">表单名称</th>
			<th width="8%">表单类型</th>
			<th width="26%">取值范围</th>
            <th width="7%">默认值</th>
			<th width="15%">表单说明</th>
			<th width="5%">编辑列</th>
			<th width="4%">模式</th>
			<th width="4%">显示</th>
			<th width="4%">删除</th>
			<th width="6%">排序</th>
		</tr>
		<logic:present name="IGPRD01101VO" property="processInfoDefList">
			<logic:iterate id="bean" name="IGPRD01101VO"
				property="processInfoDefList" indexId="index">
				<tr>
					<td>${index+1}</td>
					<td style="display:none">${bean.pidid}</td>
					<td>
						<html:link action="/IGPRD0111_Edit_Disp.do?pidid=${bean.pidid}&mode=1">
							<logic:empty name="bean" property="pidlabel">&nbsp;</logic:empty>${bean.pidlabel}
						</html:link>
						<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
						<%} else {%>
<%-- 							<logic:empty name="bean" property="pidlabel">&nbsp;</logic:empty>${bean.pidlabel} --%>
						<%}%>
					</td>
					<td>
						<ig:codeValue ccid="PROCESSINFODEF_TYPE_CODE_WD" cid="${bean.pidtype}" />
					</td>
					<td><logic:empty name="bean" property="pidoption">&nbsp;</logic:empty>${bean.pidoption}</td>
					<td><logic:empty name="bean" property="piddefault">&nbsp;</logic:empty>${bean.piddefault}</td>
					<td><logic:empty name="bean" property="piddesc">&nbsp;</logic:empty>${bean.piddesc}</td>
					<td>
						<logic:equal name="bean" property="pidtype"  value="8">
							<html:link action="/IGPRD0178.do?pdid=${bean.pdid}&flag=flase&viewhistory=0&tableColumn=Y&ppidid=${bean.pidid}&piddisplay=${bean.piddisplay}">
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
						<logic:empty name="bean" property="rowwidth">
							<ig:codeValue ccid="PROCESSINFODEF_ROWWIDTH_CODE" cid="<%=IGPRDCONSTANTS.PIDROWWIDTH_FULL %>" />
						</logic:empty>
						<logic:notEmpty name="bean" property="rowwidth">
							<ig:codeValue ccid="PROCESSINFODEF_ROWWIDTH_CODE" cid="${bean.rowwidth}" />
						</logic:notEmpty>
					</td>
					
					<td>
					<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
					<html:link
						href="javascript:toDel('${bean.pidid}')">
						<img src="images/delete.gif" width="16" height="16" border="0"
							alt="删除" />
					</html:link>
					<%} %>
					</td>
					<td>
						&nbsp;
						<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
						<html:link href="javascript:toUp('${index+1}')">
							<img src="images/upinfo.gif" width="16" height="20" border="0" alt="向上" />
						</html:link>
						<html:link href="javascript:toDown('${index+1}')">
							<img src="images/downinfo.gif" width="16" height="20" border="0" alt="向下"/>
						</html:link>
						<%} %>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</div>
	<div class="enter">
	
	<%if(!IGPRDCONSTANTS.PROCESSDEFINITION_IS_IN_USE.equals(request.getAttribute("isInUse").toString())){ %>
	<html:submit styleClass="button" value="增加" />
	&nbsp;&nbsp;
	<html:button styleClass="button" property="but_save" onclick="javascript:saveorder();">排序保存</html:button>
<%-- 	&nbsp;&nbsp; --%>
<%-- 	<input type="button" name="gttc" value="选择通用表单" class="button" onclick="location='IGPRD0117.do?gtbl=ok&pdid=${IGPRD0110Form.pdid}'">  --%>
	<%} %>
	</div>
	<html:hidden property="pdid" styleId="pdid" name="IGPRD0110Form"/>
</html:form></div>
</div>
<div class="zishiying"></div>
</div>
</div>

</body>
</html:html>
