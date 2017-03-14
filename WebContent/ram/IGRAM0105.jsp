<%@page import="com.deliverik.framework.workflow.prr.model.entity.IG899TB"%>
<%@page import="com.deliverik.infogovernor.prr.vo.IGPRR01021VO"%>
<%@page import="com.deliverik.framework.workflow.prr.model.IG899Info"%>
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
<%@ page import="java.util.*" %>
<script type="text/javascript">
function historyScore(url){
	openSubWindow(url, 'newpage', '1200', '600');
}
function hide(){
	var showvalue = document.getElementById("hide");
	if("${IGPRR01021VO.process.prstatus}" == "W" || "${IGPRR01021VO.process.prstatus}" == "C")
	{
		showvalue.style.display="none";
	}
}
</script>
	<div id="hide">
	<div class="title">
		<div class="name">评估内容</div>
	</div>
	<table cellspacing="2" class="table_style1_1">
			<tr><td width="9%"></td><td width="45%"></td><td width="2%"></td><td width="2%"></td><td width="2%"></td><td width="45%"></td></tr> 
			<tr>
			 	<th width="9%">评分分类</th> <th width="45%">评分项</th><th width="10%" colspan="3">分数</th>
			 	
			 	<!-- <td style="width:1px"></td><td style="width:1px"></td> --><th >备注</th><td >
				 	<input type="hidden" id="delFileMutiStr" name="delFileMutiStr" value=""/>
					<input type="hidden" id="addTableColumnFileStr" name="addTableColumnFileStr" value=""/>
					<input type="hidden" id="delTableColumnFileStr" name="delTableColumnFileStr" value=""/>
			 	</td>
			</tr>

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
					<c:set var="prjpidid" value="${index}"></c:set>
				</logic:equal>
			</logic:iterate>
		

<c:set var="nums" value="1"></c:set>
	<% 
			Map<String,Integer> fenLeiMap = new HashMap<String,Integer>(); 
			String fenleiName = "";
			String fenleiStr = "";
			Integer prjs = 1;
		%>
		<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
			<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
			<% if(StringUtils.isNotEmpty(psid.getPiddesc())){
				fenleiStr = psid.getPidunit();			
				if(fenleiName.equals(fenleiStr)){
					prjs++;
				}else{
					fenleiName = fenleiStr;
					prjs = 1;
				}
				fenLeiMap.put(fenleiName, prjs);
			}
			%>
		</logic:iterate>
<%-- 		<c:set var="cutnum" value="0"></c:set> --%>

<%
					Set set = fenLeiMap.keySet();
					Iterator iter = set.iterator();
					List<String> itList = new ArrayList<String>();
					while (iter.hasNext()){
						itList.add((String)iter.next());
					}
					//while(iter.hasNext()){
						//for(int i=0;i<itList.size();i++){
							for(int i=0;i<itList.size();i++){
						//Object key = iter.next();
						%>
			<th rowspan = "<%=fenLeiMap.get(itList.get(i))+1 %>">
				<%-- <%=fenLeiMap.get(key.toString()) %> --%>
				<%= itList.get(i) %> 
			</th>
			<logic:iterate id="map" name="IGPRR01021VO" property="processInfoDefmap" indexId="index" >
				<bean:define id="pidid" name="map" property="key" type="java.lang.String" />
				<bean:define id="psid" name="map" property="value" type="com.deliverik.framework.workflow.prd.model.IG007Info" />
				<bean:define id="processLinkageDefList" name="psid" property="processLinkageDefList" type="java.util.List" />
				
				<c:if test="${index > prjpidid }">
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
				<logic:equal value="<%= (String)itList.get(i) %>" name="psid" property="pidunit">
				<logic:notEqual value="<%=IGPRDCONSTANTS.PROCESSTITLE_HIDE %>" name="psid" property="pidaccess">
				<%=trStartTag %>
				<td>
					<label for="Name" onmouseover="selStation('${psid.pidlabel}');" onmouseout="chide();" >
						<!-- <strong style="float:left"> -->
							<logic:equal value="1" name="psid" property="pidrequired">
								<span class="red">*</span>
							</logic:equal>
							${nums }&nbsp;${psid.pidlabel}：${psid.piddesc }<!-- </strong> -->
							<c:set var="nums" value="${nums+1 }"></c:set>
					</label>
				</td>
				<%=tdStartTag %>
				</logic:notEqual>
				<c:if test="${IGPRR01021VO.process.prstatus != 'C' }">
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
					<td>
					
					<bean:define id="privateValueFlag" value="1"/>
					<logic:present name="psid" property="processPrivateInfoList">
						<bean:define id="privateValueList" name="psid" property="processPrivateInfoList" />
						<logic:iterate id="privateValue" name="privateValueList">
							<logic:equal value="${IGPRR01021VO.userid }" name="privateValue" property="userid">
								<logic:equal value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>" name="psid" property="pidaccess">
									<bean:define id="privateValueFlag" value="2"/>
									<html:textarea cols="44" rows="2" name="IGPRR0102Form"  property="pidcomment[${index }]" value="${privateValue.ppicommect }"></html:textarea>
								</logic:equal>
								<logic:equal value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_HIDE %>" name="psid" property="pidaccess">
									<bean:define id="privateValueFlag" value="2"/>
									<html:hidden name="IGPRR0102Form"  property="pidcomment[${index }]" value="${privateValue.ppicommect }"/>
								</logic:equal>
								<logic:equal value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_READABLE %>" name="psid" property="pidaccess">
									<bean:define id="privateValueFlag" value="2"/>
									${privateValue.ppicommect }
									<html:hidden name="IGPRR0102Form"  property="pidcomment[${index }]" value="${privateValue.ppicommect }"/>
								</logic:equal>
							</logic:equal>
						</logic:iterate>
					</logic:present>
					<logic:equal value="1" name="privateValueFlag">
						<logic:equal value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>" name="psid" property="pidaccess">
							<html:textarea cols="44" rows="2" name="IGPRR0102Form"  property="pidcomment[${index }]" value=""></html:textarea>
						</logic:equal>
						<logic:notEqual value="<%=IGPRDCONSTANTS.PUBLIC_ACCESS_WRITEABLE %>" name="psid" property="pidaccess">
							<html:hidden name="IGPRR0102Form" property="pidcomment[${index }]"/>
						</logic:notEqual>
					</logic:equal>
					</c:if>
					</td>
					<c:if test="${IGPRR01021VO.process.prstatus == 'C' }">
						<td></td>
					</c:if> 
				
					</logic:equal>
				</logic:present>
				
				</c:if>
			</logic:iterate>
		
			<% 
			if(StringUtils.isEmpty(lastrowwidth)){
			}
			if("0".equalsIgnoreCase(lastrowwidth)){
				trEndTag = "</tr>";
			}
			if("1".equalsIgnoreCase(lastrowwidth)){
				if(columnNum == 0){
					trEndTag = "</tr>";
				}else{
					trEndTag = "<td></td><td></td></tr>";
				}
			}
			%>
			<%=trEndTag%>
			<%
				}
			%>
		</table>
</div>