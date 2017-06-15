<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.drm.vo.IGDRM15011VO"%>
<html:html>
<bean:define id="id" value="IGDRM1514" toScope="request" />
<bean:define id="title" value="培训计划查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
    var delAttachList = "1";
<!--
	

//条件查询
function searchFunction(){
	 form.action = getAppRootUrl() + "/IGDRM1511_Disp.do";
	
	return true;
}

//-->
WebCalendar.timeShow   = true;          //是否返回时间
	</script>
<body>
	<div id="maincontent">
		<div >
			<!--content  右侧内容-->
			<div id="contentWrap">
				<div >
					<html:form styleId="form" action="/IGDRM1514"
						onsubmit="return checkSubmit(this);">
						<div id="location">
							<div class="image"></div>
							<p class="fonts1">
								选择培训计划
							</p>
						</div>

						<div id="search">
							<div class="img"></div>
							<div class="conditions">
							
							         <span>创建时间：</span> 
							         <span> <html:text name="IGDRM1514Form" property="startTimeBegin" styleId="startTimeBegin" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
												<img src="images/date.gif" align="middle" onclick="calendar($('startTimeBegin'))" border="0" style="cursor: hand;"/>
												<span>&nbsp;&nbsp;<font style="font-weight: bold;">到</font></span>
												<html:text name="IGDRM1514Form" property="startTimeEnd" styleId="startTimeEnd" errorStyleClass="inputError imeDisabled" size="16" readonly="true"/>
												<img src="images/date.gif" align="middle" onclick="calendar($('startTimeEnd'))" border="0" style="cursor: hand;"/>
									</span>
							         <span>创建人：</span> 
							         <span> <html:text
											property="tpusername" styleId="tpusername"
											errorStyleClass="inputError imeDisabled" size="15"
											maxlength="32" tabindex="1" />
									</span>
									<br/>
									<span>创建部门：</span> 
							         <span> <html:text
											property="tporgname" styleId="tporgname"
											errorStyleClass="inputError imeDisabled" size="15"
											maxlength="32" tabindex="1" />
									</span>
									
									
									<span> <html:submit property="btn_search"
												styleClass="button" value="查询" />
										</span>
							
							</div>
						</div>
						<div id="results_list">
							<ig:message />
							<table class="table_style" id="table1">
								<tr>
									<th width="2%"></th>
									<th width="13%" align="left">培训计划名称</th>
									<th width="13%" align="left">发起部门</th>
									<th width="9%" align="left">发起人</th>
									<th width="9%" align="left">发起时间</th>
									

								</tr>
								<logic:present name="IGDRM15141VO" property="trainplanInfoList">
									<logic:iterate id="bean" name="IGDRM15141VO"
										property="trainplanInfoList" indexId="index">
										<tr class="<ig:rowcss index="${index}"/>">
											<td align="left"><img src = "images/select_asset.gif" title="选择" style="cursor:pointer;" onclick="selPlan('${bean.tpid}','${bean.tpname }')" /> </td>
											<td align="left">${bean.tpname}</td>
											<td align="left">${bean.tporgname}</td>
											<td align="left">${bean.tpusername}</td>
											<td align="left">${bean.tptime}</td>
										</tr>
									</logic:iterate>
								</logic:present>
							</table>
						</div>
						<div id="operate">
						
						</div>
					</html:form>
				</div>
			</div>
			<div class="zishiying"></div>
		</div>
	</div>
</body>
<script>
	function selPlan(tpid,tpname){
		if(window.opener&&!window.opener.closed){
			window.opener.setPlan(tpid,tpname);
			window.close();
		}
	}

</script>

</html:html>