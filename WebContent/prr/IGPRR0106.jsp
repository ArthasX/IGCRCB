<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>

<html>
<bean:define id="id" value="IGPRR0106" toScope="request" />
<bean:define id="title" value="表单日志信息" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">
var gid='IGPRR0106';


</script>
<STYLE>
v\:* { Behavior: url(#default#VML) }
</STYLE>

<body>
<div id="maincontent">
<div id="container">
<html:form action="/IGPRR0106_Disp" styleId="form" onsubmit="return checkSubmit(this);">
	
	
<div id="location" style="margin-top: 10px">
<div class="image"></div>
<p class="fonts1">表单日志信息</p>
</div>

				<div class="results_list" >
				<ig:message />
				<table class="table_style" style="width:98%;margin-top:8px">
					<tr>
						<th width="10%">表单名称</th>
						<th width="10%">填写内容</th>
						<th width="20%">附件</th>
					</tr>
					<logic:present name="IGPRR01061VO" property="varLogList">
						<logic:iterate id="bean" name="IGPRR01061VO" property="varLogList" indexId="index" type="com.deliverik.framework.workflow.prr.model.IG113Info">	
							<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
								<td>
									${bean.pivarlabel}

								</td>
								<td>
									<%if(("4".equals(bean.getPivartype()) || "5".equals(bean.getPivartype()) || 
											"6".equals(bean.getPivartype())) || "R".equals(bean.getPivartype()) && !"".equals(bean.getPivarvalue())){ %>
										${bean.pishowvarname}
									<%}else{%>
										${bean.pivarvalue}
									<%}%>
								</td>
								<td>
								<logic:present name="IGPRR01061VO" property="attachmentMap">
									<logic:notEmpty	name="IGPRR01061VO" property="attachmentMap">
											<bean:define id="a" name="IGPRR01061VO" property="attachmentMap" type="java.util.Map" />
											
											<logic:iterate id="map" name="IGPRR01061VO"	property="attachmentMap" indexId="number">
											<bean:define id="category" name="map" property="key"/>
											<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
												
											
											<logic:equal name="map" property="key" value="${bean.pivarname}">
												<logic:iterate id="attachment" name="list" indexId="number">
												
													<html:link
														action="downloadSvcFile.do?attId=${attachment.attid}&type=svc">
														<bean:define id="attname" name="attachment" property="attname" />
														<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
													</html:link>
													<br />
												</logic:iterate>
											</logic:equal>
												
											</logic:iterate>
										
									</logic:notEmpty>
								</logic:present>
								</td>
							</tr>
							
						</logic:iterate>
					
					</logic:present>
					
				</table>
				
				</div>

	
</html:form></div>
</div>

</body>
</html>

