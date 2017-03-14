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
				<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
				<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
				<bean:define id="processLinkageDefList" name="psid" property="processLinkageDefList" type="java.util.List" />
				<logic:present name="psid">
				<logic:notEqual value="<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>" name="psid" property="pidaccess">
				</logic:notEqual>
					<ig:formToTag 
						name="IGPRR0102Form" 
						pidid="${pidid }" 
						property="pivarvalue[${index}]" 
						formType="${psid.pidtype }" 
						pidaccess="1"
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
					</td>
				</logic:present>
			</logic:iterate>
