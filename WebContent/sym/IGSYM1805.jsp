<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>

<html:html>
<bean:define id="id" value="IGSYM1805" toScope="request"/>
<bean:define id="title" value="短信规则IP" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	function checkForm() {
		form.submit();
		//return true;
	}
	function toDel(name) {
		
			var objs = document.getElementsByName(name);
			var id = "";
			var length = 0;
			if(objs!=null){	
				for(var i=0;i<objs.length;i++){
					if(objs[i].checked){
						id = objs[i].value;
						length++;
					}
				    }
				if(length<1)
				{
					alert("请至少选择一条信息");
				
				}
				else
				{
					if (window.confirm("是否删除所选")) 
					{	
					form.action = getAppRootUrl() + "/IGSYM1803_DELETE.do"; 
					return true;
					}
					else{
							return false;
						}
				}
			}
	}
	
	function toUpadate()
	{
		if($("deviceip").value.trim()==""){
			alert("请填写IP");
			return false;
		}
		if (window.confirm("是否添加一条规则")) 
		{
		form.action = getAppRootUrl() + "/IGSYM1803_Insert.do?isflag=yes"; 
		
		return true;
		}
		
		else
		{
		return false;
		}
	}
	
	function changeStatus(id,state){
		//"是否改变状态？"
		if(confirm("是否改变状态？")){
			
			var form = document.getElementById("form");
			form.action= getAppRootUrl()+"/IGSYM1803_ChangeState.do?id=" +id +"&state="+state;
			form.submit();
		}
	}

	 </script>
<body>
	<br>
	<html:form styleId="form" action="/IGSYM1803_Disp">

		<div>
			<div id="search">
				<div class="img"></div>
				<div style="text-align: left;">
				    IP： <html:text property="deviceip"
							styleId="deviceip" errorStyleClass="inputError imeDisabled"
							size="15" maxlength="16" tabindex="2">
						</html:text>&nbsp;&nbsp;
					<html:submit property="btn_search" styleClass="button"
							value="查询">
					</html:submit>
						
					<html:submit property="search" styleClass="button"
							value="新增" onclick="return toUpadate();">
					</html:submit>
				</div>
			</div>
			<div style="float: left; width: 100%;">
				<div id="ipInfoList">
					<table class="table_style" style="width: auto">
						<tr>
							<th style="text-align: left;width: 4%;"><logic:present name="IGSYM18021VO"
									property="ipInfoList">
									<label><input type="checkbox" name="allbox" id="allbox"
										onclick="selectAll('allbox','ids')" /></label>
								</logic:present>
							</th>
							<th>IP</th>
							<th>状态</th>
							<html:hidden property="state" value="0"/>
						</tr>
							<logic:present name="IGSYM18021VO" property="ipInfoList">
								<logic:iterate id="bean" name="IGSYM18021VO" property="ipInfoList"
									indexId="index">
									<tr>
										<td style="text-align: left;width: 4%;">
											<input type="checkbox" name="ids" value="${bean.id}">
										</td>
										
										<td >${bean.deviceip}</td>
										<td>
											<div class="nowrapDiv">
							                	<logic:empty name="bean" property="state">&nbsp;</logic:empty> 
							                	<logic:equal name="bean" property="state" value="1">
							                	<a href="javascript:changeStatus('${bean.id}','${bean.state}');"> <img
													src="images/stop.gif" border="0"
													alt="启用" />
												</a>
							                	</logic:equal>
							                	<logic:equal name="bean" property="state" value="0">
													<a href="javascript:changeStatus('${bean.id}','${bean.state}');"> <img
														src="images/start.gif" border="0"
														
														alt="停用" />
													</a>
												</logic:equal>
							            	</div>
										</td>
									</tr>
								</logic:iterate>
							</logic:present>
						</table>

						<table>
							<logic:present name="IGSYM18021VO" property="ipInfoList">
							<html:submit property="btn_delete" value="删除所选"
										styleClass="button" onclick="return toDel('ids');" />
							</logic:present>
						</table>
					<div id="operate">
						<!-- paging -->
						<div style="float: right; width: 80%; text-align: right;"><jsp:include
								page="/include/paging.jsp" /></div>
						<!-- /paging -->
					</div>

				</div>
			</div>
			<!-- </div> -->
		</div>
	</html:form>
	<div class="zishiying"></div>

</body>
</html:html>