<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="org.apache.commons.lang.StringUtils"%>
<%@ page import="com.deliverik.infogovernor.prr.bl.IGPRR01BLType"%>
<%@page import="com.deliverik.framework.workflow.WorkFlowConstDefine"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>


<%
String tdStartTag = "";
String textSize = "32";
String textAreaSize = "25";
String lastrowwidth = "";
String trStartTag = "";
String trEndTag = "";
int columnNum = 0;
boolean privateIsNull = true;
%>
			<bean:define id="useridprr" name="IGPRR01021VO" property="userid" type="java.lang.String" />
			<bean:define id="roleidprr" name="IGPRR01021VO" property="roleid" type="java.lang.Integer" />
			<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
				<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
				<logic:equal value="评估得分" name="psid" property="pidlabel">
					<%-- <c:set var="prjpidid" value="${psid.pidid}"></c:set> --%>
					<c:set var="prjpidid" value="${index}"></c:set>
				</logic:equal>
			</logic:iterate>
			
			<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
				<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
				<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
				<bean:define id="processLinkageDefList" name="psid" property="processLinkageDefList" type="java.util.List" />
				
				<%-- <logic:lessEqual value="${prjpidid}" name="psid" property="pidid"> --%>
				<c:if test="${index <= prjpidid }">
				<logic:present name="psid">
				<% 
				if("2".equalsIgnoreCase(psid.getPidaccess()) || "3".equalsIgnoreCase(psid.getPidaccess()) || "4".equalsIgnoreCase(psid.getPidaccess())){
					String rowwidth = StringUtils.isEmpty(psid.getRowwidth())?"0":psid.getRowwidth().trim();
					rowwidth = StringUtils.isEmpty(rowwidth)?"0":rowwidth;
					tdStartTag = "<td>";
					textSize = "32";
					textAreaSize = "25";
					if(StringUtils.isEmpty(lastrowwidth)){
						trStartTag = "<tr>";
						if("0".equals(rowwidth)){
							tdStartTag = "<td colspan=\"3\">";
						}
					}
					if("0".equalsIgnoreCase(lastrowwidth)){
						trStartTag = "</tr><tr>";
						if("0".equals(rowwidth)){
							tdStartTag = "<td colspan=\"3\">";
						}
					}
					if("1".equalsIgnoreCase(lastrowwidth)){
						if("0".equals(rowwidth)){
							if(columnNum == 0){
								trStartTag = "</tr><tr>";
							}else{
								trStartTag = "<td></td><td></td></tr><tr>";
							}
							tdStartTag = "<td colspan=\"3\">";
						}else{
							if(columnNum == 0){
								trStartTag = "</tr><tr>";
							}else{
								trStartTag = "";
							}
						}
					}
					if("0".equalsIgnoreCase(rowwidth)){
						columnNum = 0;
					}else{
						columnNum = (columnNum+1)%2;
					}
					lastrowwidth = rowwidth;
					if("0".equals(rowwidth)){
						textSize = "82";
						textAreaSize = "60";
					}
				}
				%>
				<logic:notEqual value="<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>" name="psid" property="pidaccess">
				<%=trStartTag %>
				<th>
					<label for="Name" onmouseover="selStation('${psid.pidlabel}');" onmouseout="chide();" >
						<strong>
							<logic:equal value="1" name="psid" property="pidrequired">
								<span class="red">*</span>
							</logic:equal>
							${psid.pidlabel}：</strong>
					</label>
				</th>
				<%=tdStartTag %>
				</logic:notEqual>
					<ig:formToTag 
						name="IGPRR0102Form" 
						pidid="${pidid }" 
						property="pivarvalue[${index}]" 
						formType="${psid.pidtype }" 
						pidaccess="${psid.pidaccess }"
						pidmode="${psid.pidmode }"
						size="<%= textSize%>"	
						userid="${IGPRR01021VO.userid }"
						roleid="${IGPRR01021VO.roleid }"
						orgid="${IGPRR01021VO.roleid }"
						options="${psid.pidoption }"	
						privatescope="${psid.privatescope}"
						piddefault="${psid.piddefault }"
						pdid="${psid.pdid }"
						ccid="${psid.ccid }"
						pidlabel="${psid.pidlabel }"
						piid="${psid.piid }"
						pidrequired="${psid.pidrequired }"
						textAreaSize="<%=textAreaSize %>"
						hasattach="${psid.hasattach }"
						piddisplay="${psid.piddisplay }"
						pidwidth="${psid.pidwidth }"
						pidrows="${psid.pidrows }"
						piduse="${psid.piduse }"
						showline="${psid.showline }"
						value="${psid.pidvalue}"
						pidunit="${psid.pidunit}"
						remarks="${psid.remarks}"
						pidcomment="${psid.pidcomment}"
						titledisplay="${psid.titledisplay }"
						pidhide="${psid.pidhide }"
						jsfunction="${psid.jsfunction }"
						selecedlast="${psid.selecedlast }"
						numbertype="${psid.numbertype }"
						align="${psid.align }"
						showstyles="${psid.showstyles}"/>
					<html:hidden property="pivarname" value="${psid.pidname}" /> 
					<html:hidden property="pivarlabel" value="${psid.pidlabel}" /> 
					<html:hidden property="pivartype" value="${psid.pidtype}" /> 
					<html:hidden property="pidid" value="${psid.pidid}" />
					<html:hidden property="pidaccess" value="${psid.pidaccess}" />
					<html:hidden property="piid" value="${psid.piid}" />
					<html:hidden property="pidmode" value="${psid.pidmode}" />
					<html:hidden property="privatescope" value="${psid.privatescope}" />
					<%-- <html:hidden property="pidcomment" value="${psid.pidcomment}" /> --%>
					</td>
				</logic:present>
				<%-- </logic:lessEqual> --%>
				</c:if>
			</logic:iterate>
			
			
	