<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.utility.IGStringUtils" %>

<html:html>
<bean:define id="id" value="IGRIS0229" toScope="request" />
<bean:define id="title" value="检查项管理画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<script type="text/javascript">	
<!--
	//删除所选
	/*function deleteRec(obj){
		var message = '<bean:message key="IGCO10000.E002"/>';
	    var confirmMsg = '<bean:message key="IGCO10000.W002" arg0="风险检查基本信息" />';
		if(checkNum(obj)==0){
			alert(message);
	        return false;
		}
	    if(window.confirm(confirmMsg)){
	        form.action = getAppRootUrl() + "/IGSYM0101_Del.do";
	        return true;
	    } else {
	        return false;
	    }
	}*/

	

	function changeStatus(rcid,rcstatus,rcenddate,rcfrequency,rcstartdate){
		if(confirm("您是否确认改变状态？")){
			if("1"==rcstatus){
				if (rcfrequency == 'once' && !checkDateByContent('<%=IGStringUtils.getCurrentDate() %>',rcstartdate.split(" ")[0])) {
					alert("该检查策略的执行日期早于当前日期，不能启用！");
					return;
				}
				if(!checkDateByContent('<%=IGStringUtils.getCurrentDate() %>',rcenddate.split(" ")[0])){
					alert("该检查策略的结束日期早于当前日期，不能启用！");
					return;
				}else{
					var form = document.getElementById("form");
					form.action="IGRIS0201_Change.do?rcid="+rcid+"&rcstatus="+rcstatus;
					form.submit();
				}
			}else{
				var form = document.getElementById("form");
				form.action="IGRIS0201_Change.do?rcid="+rcid+"&rcstatus="+rcstatus;
				form.submit();
			}

		}
	}

	function showIncident(){
		var ccid = "106";
		var cid = "";
		var syscode = "";
		if(null==syscode || ""==syscode){
			syscode = ccid;
		}else{
			ccid = syscode.substring(0,3);
		}

		url = "IGSYM1505_TREE.do" + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;

		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			$("rccategory").value="";
			$("rccategoryname").value="";
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
			$("rccategory").value=treesyscode;
			$("rccategoryname").value=name;
			
		}		
		
	}
	

	function toback() {
		var looksign = "${looksign}";
		if (looksign == "1") {
			form.action = getAppRootUrl()
					+ "/IGCOM0202.do?linkID=IGRIS0201&actname=ACT04RIS0101";
		} else {
			form.action = getAppRootUrl()
					+ "/IGCOM0202.do?linkID=IGRIS0201&actname=ACT04RIS0101";
		}
		form.submit();
	}
//-->
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->

<!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">
<html:form styleId="form" action="/IGRIS0201_POINT.do" onsubmit="return checkSubmit(this);">
	
<div id="location">
	<div class="image"></div>
	<p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 检查项查看</p>

</div>
<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
		<span style="font-size:15px;"><strong>查询条件</strong></span>
	</div>
	<div>
	<span class="subscribe">检查项分类：</span>
	<html:select property="rcclass" styleId="rcclass" style="margin-left:-5px">
		<ig:optionsCollection ccid="RISKCHECK_CLASS_CODE" isMakeBlankRow="true" isCodeLabel="true" />
	</html:select> 
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<span class="subscribe">检查项名称：</span>
	<html:text property="rcname_q" styleId="rcname_q" errorStyleClass="inputError imeDisabled" size="15" maxlength="32"  tabindex="1" />

    <html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				<th width="5%">序号</th>
				<th width="10%">检查项分类</th>
				<th width="24%">检查项名称</th>
				<th width="10%">检查项说明</th>
				<th width="28%">检查方法</th>
				<th width="8%">状态</th>	
			</tr>
			<logic:present name="IGRIS02011VO" property="riskCheckDataList">
				<logic:iterate id="bean" name="IGRIS02011VO"
					property="riskCheckDataList" indexId="index">

					<tr class="<ig:rowcss index="${index}"/>">
						
						<td>
							<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
						</td>
						<td>
							<ig:codeValue ccid="RISKCHECK_CLASS_CODE" cid="${bean.rcclass}"/>						
						</td>
						<td>
							<%-- <html:link action="/IGRIS0201_Read.do?rcid=${bean.rcid}"> --%>
								${bean.rcname}
							<%-- </html:link>	 --%>
						</td>
						<td>${bean.rcdesc}</td>
						<td>${bean.rccommon}</td>
						<td>
							<c:if test="${IGRIS0201Form.isSecurityApproval == '1'}">
							<logic:equal name="bean" property="rcstatus"  value="1">
							启用
						    </logic:equal>
						   
						   
							<logic:equal name="bean" property="rcstatus"  value="0">
							停用
						    </logic:equal>
							</c:if>	
							<c:if test="${IGRIS0201Form.isSecurityApproval != '1'}">
							
							<logic:equal name="bean" property="rcstatus"  value="1">
							启用
						    </logic:equal>
						   
						   
							<logic:equal name="bean" property="rcstatus"  value="0">
							停用
						    </logic:equal>							
							</c:if>
						</td>
					</tr>
				</logic:iterate>
			</logic:present>
	</table>
	</div>
	<div id="operate">
	<!-- paging --> <jsp:include page="/include/paging.jsp" />
	</div>
		<div class="enter">
				<input type="button" class="button" value="关闭" onclick="window.close();">
		</div>
	<html:hidden property="csid" styleId="csid"/>
	

</html:form></div>
</div>
<div class="zishiying"></div>
</div>


</div>
</body>
</html:html>