<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGRIS0215" toScope="request" />
<bean:define id="title" value="检查项查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />

<!-- /header1 -->
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

	function setParentValue(rcid, rcname){
	    if(!window.opener.closed){
	        window.opener.setRcname(rcid,rcname);
	    }
	    window.close();
	}
	function clearParentValue(){
	    if(!window.opener.closed){
	        window.opener.setRcname("", "");
	    }
	    window.close();
	}
//-->
	</script>
<body style="background-color: white; background-image: none;" >
<div id="maincontent">
<div id="contentainer">
<html:form styleId="form" action="/IGRIS0201_Result"
	onsubmit="return checkSubmit(this);">
<div id="location">
<div class="image"></div>
<p class="fonts1">检查项查询</p>
</div>

<div id="search">
	<div class="img"></div>
	<div class="conditions">
	<div>
	<span>检查项名称：</span>
	<html:text property="rcname_q" styleId="rcname_q" errorStyleClass="inputError imeDisabled" size="15" maxlength="32"  tabindex="1"/>
	
	<html:submit property="btn_search" styleClass="button" value="查询" />
	</div>
	</div>
</div>
	<div id="results_list">
	<ig:message />
	<table class="table_style">
			<tr>
				
				<th width="10%">选择</th>
				<th width="20%">检查项名称</th>
				<th width="20%">开始时间</th>
				<th width="20%">结束时间</th>
				<th width="20%">状态</th>


			</tr>
			<logic:present name="IGRIS02011VO" property="riskCheckDataList">
				<logic:iterate id="bean" name="IGRIS02011VO"
					property="riskCheckDataList" indexId="index">

					<tr  class="<ig:rowcss index="${index}"/>">
						
						<td>
							<div class="nowrapDiv">
                                             
                                <img src="images/select_asset.gif" border="0" alt="选择" onclick="javaScript:setParentValue(
                                    '${bean.rcid}',
                                    '${bean.rcname}');"/>
                                              
                           </div>
						</td>
						<td>
							<html:link action="/IGRIS0201_ResultRead.do?rcid=${bean.rcid}">
								${bean.rcname}
							</html:link>	
						</td>

						<td>${bean.rcstartdate}</td>

						<td>${bean.rcenddate}</td>
						
						<td>
							  <logic:equal name="bean" property="rcstatus"  value="1">已审核
						      </logic:equal>
						      <logic:equal name="bean" property="rcstatus"  value="0">未审核
						      </logic:equal>
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
	<input id="parent" type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
	<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</html:form></div>
</div>
<div class="zishiying"></div>

</body>
</html:html>