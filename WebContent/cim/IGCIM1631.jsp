<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGCIM1631" toScope="request"/>
<bean:define id="title"  toScope="request" value="密码关联关系">
	
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">

	//逻辑图信息显示
	function checkEIRelationInfo(srpareiid,srdomainid,srdomainversion,srparversion,srparsmallversion,srcreatetime){
		openSubIGCOM0318_Relation(srpareiid,srdomainid,srdomainversion,srparversion,srparsmallversion,srcreatetime);
	}
	

	function setRoleDomain(){
		<logic:notPresent name="ADrolemanager">
		var url = "IGSYM0304.do?roletype=IGCI01";
		</logic:notPresent>
		<logic:present name="ADrolemanager">
		<logic:equal name="ADrolemanager" value="true">
		var url = "IGSYM0101_TREE.do";
		</logic:equal>
		</logic:present>
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].eiorgsyscoding.value = "";
			document.forms[0].eiorgname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
			document.forms[0].eiorgname.value = temp.split("|")[1];
		}		
	}

	 function setEntity(){
		 var alertMessage = '<bean:message bundle="asmResources" key="message.IGCIM0101.005"/>';
			var url = "IGCIM1203_ENTITY_TREE.do?levelnode=999";

			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				 document.forms[0].ename.value = "";
//				 document.forms[0].eid.value = "";
				 document.forms[0].esyscoding.value = "";
				 return false;
			 }
			if(null!=temp && temp.split("|").length>1){
				var syscode_eid = temp.split("|")[0];
				var name = temp.split("|")[1];
				var syscode;
				var eid;
				if(syscode_eid =="999")
				{
					alert(alertMessage);
					return false;
					
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].ename.value = name;
			//	document.forms[0].eid.value = eid;
				document.forms[0].esyscoding.value = syscode;
			}		
		}
	 function setUseRoleDomain(){
			<logic:notPresent name="ADrolemanager">
			var url = "IGSYM0304.do?roletype=IGCI01";
			</logic:notPresent>
			<logic:present name="ADrolemanager">
			<logic:equal name="ADrolemanager" value="true">
			var url = "IGSYM0101_TREE.do";
			</logic:equal>
			</logic:present>
			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].usesyscoding.value = "";
				document.forms[0].useorgname.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				document.forms[0].usesyscoding.value = temp.split("|")[0];
				document.forms[0].useorgname.value = temp.split("|")[1];
			}		
		}

	 function selectEntityItem(){
	     	openSubWindow('/IGCIM0906_Disp.do?flag=false', '', '850', '600');
	     }

	 function setParamIGCIM0906(eirootmark, einame) {
         $("eirootmark_eq").value = eirootmark;
         $("topCi").value = einame;
     }

	 function showRelationInfo(eiid,eiversion,eismallversion,relationType){
		// openSubWindow("/IGCIM1634_Disp.do?eiid="+eiid+"&eiversion="+eiversion+"&eismallversion="+eismallversion+"&relationType="+relationType,'','800','600');
		var url="/IGCIM1634_Disp.do?eiid="+eiid+"&eiversion="+eiversion+"&eismallversion="+eismallversion+"&relationType="+relationType;
		var obj = window.showModalDialog("<%=request.getContextPath()%>" + url,null,"dialogWidth:800px;dialogHeight:600px;status:no;help:no;resizable:yes");
		if(obj != null){ 
			window.parent.location.href = obj;
		}
	 }
	
	</script>

<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
   
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
<html:form styleId="form" action="/IGCIM1631">
            <div id="location">
                <div class="image"></div>
                  <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>    
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div class="conditions_border1">
                          <div><label><span class="red">*</span>密码类型:</label>
                          	<html:select property="esyscoding" style="margin:0px" errorStyleClass="inputError" >
                          		<ig:optionsCollection isMakeBlankRow="false" ccid="USERS_CCID"/> 
                          	</html:select>
			                <label>&nbsp;&nbsp;<bean:message bundle="asmResources" key="label.IGCIM0101.deviceName"/></label><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" ><script type="text/javascript">printBRByScreenWidth();</script></html:text>&nbsp;&nbsp; 
			                <label>&nbsp;&nbsp;所在主机IP:</label><html:text property="ip" styleId="ip" errorStyleClass="inputError imeDisabled" size="10" ><script type="text/javascript">printBRByScreenWidth();</script></html:text>&nbsp;&nbsp; 
	                        <label><bean:message bundle="asmResources" key="label.IGCIM0101.markDayFrom"/></label><html:text property="eiupdtime_from" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label><bean:message bundle="asmResources" key="label.IGCIM0101.markDayTo"/></label><html:text property="eiupdtime_to" styleId="eiupdtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to'))" border="0"/>
                        &nbsp;
        
                        <html:submit property="btn_search"   styleClass="button">
                        		<bean:message bundle="asmResources" key="button.IGCIM0101.btn_search"/>
                        </html:submit>
                        </div>
                    </div>
		      </div>
		     
          </div>
                               
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>
					           <th width="4%">
					             <label>
					             </label>
					           </th>
                               <th>名称</th>
                               <th>所在主机IP</th>
                               <th>CI分类</th>
                               <th>最新版本</th>
                               <th>更新时间</th>
                               <th>CI关系</th>
                               <th>密码关系</th>
                               <th>密码拓扑</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGCIM16311VO" property="soc0163List" >
			                	<bean:define id="vo"  name="IGCIM16311VO" />
			                    <logic:iterate id="bean" name="IGCIM16311VO" property="soc0163List" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                        	<td></td>
			                        	<td>
											${bean.einame }
			                        	</td>
			                        	<td>
											 ${bean.ip}
			                        	</td>
			                        	<td>
											 ${bean.ename}
			                        	</td>
			                        	<td>
			                        		${bean.eiversion }.${bean.eismallversion } 
			                        	</td>
			                        	<td>
											${bean.eiupdtime }
			                        	</td>
			                        	 <td>
			                                <div class="nowrapDiv">
				                                <c:if test='${bean.eirootmark != null && bean.eirootmark != ""}'>
	                                                <a href="javascript:void(0)" onclick="openSubIGAIM0146('${bean.eirootmark}','${bean.eiid}','${bean.eiversion}','${bean.eismallversion}','0')"><img src="images/relationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.belongrelationshipDiagram.alt"/>' width="16" height="16"  border="0"/></a>
				                                </c:if>
				                                <c:if test='${bean.eirootmark == null || bean.eirootmark == ""}'>
	                                                <img src="images/unrelationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.nobelongrelationship.alt"/>' width="16" height="16"  border="0"/>
				                                </c:if>
			                                </div>
			                            </td>
			                        	<td>
											<div align="center">
                                                <html:link action="/IGCIM1632_Disp.do?eiid=${bean.eiid}"><img src="images/node-select-all.png" alt='密码关系' width="16" height="16"  border="0"/></html:link>
			                                </div>
			                        		
			                        	</td>
			                        	<td>
			                        			<div align="center">
	                                                <a href="javascript:void(0)" onclick="showRelationInfo('${bean.eiid}','${bean.eiversion}','${bean.eismallversion}','168')"><img src="images/chart_curve.png" alt='密码拓扑' width="16" height="16"  border="0"/></a>
				                                </div>
			                        	</td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>