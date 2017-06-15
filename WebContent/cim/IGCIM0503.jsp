<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGCIM0501" toScope="request"/>
<bean:define id="title"  toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGCIM0501"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	    WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
	    WebCalendar.format     = "yyyy/mm/dd"  //回传日期的格式
	    WebCalendar.timeShow   = false          //是否返回时间
	    WebCalendar.drag       = true          //是否允许拖动
	    WebCalendar.darkColor  = "#014DB4";    //控件的暗色
	    WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
	    WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
	    WebCalendar.wordColor  = "#000080";    //控件的文字颜色
	    WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
	    WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
	    WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
	    WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色

	function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var arg0  = '<bean:message bundle="asmResources" key="message.IGCIM0101.001"/>';
        var alertMsg = '<bean:message bundle="asmResources" key="message.IGCIM0101.002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="'+arg0+'" />';
        var frm = window.document.forms[0];
        if(frm.deleteEiid) {
	        if(frm.deleteEiid.length > 0){
	            var bchecked = false;
	            for( i=0; i<frm.deleteEiid.length; i++ ){
	                if (frm.deleteEiid[i].checked == true){
	                    bchecked = true;
	                }
	            }
	            if (!bchecked) {
	            	alert(message);
	                return false;
	            }
	        } else {
	          if ($("deleteEiid").checked == false){
	              alert(message);
	              return false;
	          }  
	        }
        } else {
        	alert(alertMsg);
            return false;
        }
        

        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGCIM0101_Del.do";
            return true;
        } else {
            return false;
        }
	}

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
	function setDefRoleDomain(){
		//var eiorgsyscoding = document.forms[0].eiorgsyscoding.value;
		//var eiorgname = document.forms[0].eiorgname.value;
		//if((eiorgsyscoding==null || eiorgsyscoding=="") && (eiorgname==null || eiorgname=="")){
		//	var name = '<%=request.getAttribute("deforgname") %>';
		//	var id = '<%=request.getAttribute("deforgsys") %>';

		//	if(null!=id && null!=name && "null"!=id && "null"!=name){
		//		document.forms[0].eiorgsyscoding.value = id;
		//		document.forms[0].eiorgname.value = name;
		//	}		
		//}
		
	}
	function checkForm(){
		var alertOrgan = '<bean:message bundle="asmResources" key="message.IGCIM0101.003"/>';
		var alertModel = '<bean:message bundle="asmResources" key="message.IGCIM0101.004"/>';
		//if($F('eiorgname').trim()==""){
		//	alert(alertOrgan);
		//	return false;
		//}else {
			return true;
		//}
	}

	 function setDefAssetDomain(){
			//var esyscoding = document.forms[0].esyscoding.value;
			//var ename = document.forms[0].ename.value;
			//if((esyscoding==null || esyscoding=="") && (ename==null || ename=="")){
			//	var id = '<%=request.getAttribute("defassetsys") %>';
			//	var name = '<%=request.getAttribute("defassetname") %>';

			//	if(null!=id && null!=name && "null"!=id && "null"!=name){
			//		var syscode_eid = id;
			//		var syscode;
			//		var eid;
			//		if(syscode_eid.split("_").length>1){
			//			eid = syscode_eid.split("_")[0];
			//			syscode = syscode_eid.split("_")[1];
			//		}
			//		document.forms[0].esyscoding.value = syscode;
			//		document.forms[0].ename.value = name;
			//	}		
			//}
			
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


	</script>

<body onLoad="setDefRoleDomain();setDefAssetDomain();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
   
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
<html:form styleId="form" action="/IGCIM0503"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                  <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>    
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div class="conditions_border1">
                          <div>
                          <!-- 
                          <label><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0101.organ"/></label><html:text property="eiorgname" readonly="true"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.scope.alt"/>' width="16" height="16" border="0" onclick="setRoleDomain();"/>
							&nbsp;&nbsp;
							 -->
							<html:hidden property="eiorgsyscoding"/>
							
							<!-- 
                          	<label><bean:message bundle="asmResources" key="label.IGCIM0101.usseOrgan"/></label><html:text property="useorgname" readonly="true"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.useOrgan.alt"/>' width="16" height="16" border="0" onclick="setUseRoleDomain();"/>
							&nbsp;&nbsp;
							-->
							<html:hidden property="usesyscoding"/>
							 
			               <!-- <label><span class="red">*</span><bean:message bundle="asmResources" key="label.IGCIM0101.model"/></label><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			                <img src="images/tree.gif" style="cursor: hand;" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.assetInfo.alt"/>' width="16" height="16" border="0" onclick="setEntity();"/>
			                <html:hidden property="esyscoding"/>-->
			                <label><bean:message bundle="asmResources" key="label.IGCIM0503.model"/></label>
			                <html:select property="esyscoding" value="${IGCIM05031VO.esyscoding}" style="width: 120px;" errorStyleClass="inputError" tabindex="5" >
	                           <ig:optionsCollection ccid="STORAGE_CMDB" isMakeBlankRow="true" isCodeLabel="true" />
	                        </html:select>
			                <label>&nbsp;&nbsp;<bean:message bundle="asmResources" key="title.IGCIM0503.storagename"/></label>
			                <html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" >
			                <script type="text/javascript">printBRByScreenWidth();</script></html:text>&nbsp;&nbsp; 
	                        
	                        <label><bean:message bundle="asmResources" key="label.IGCIM0501.markDayFrom"/></label><html:text property="eiupdtime_from2" styleId="eiupdtime_from2" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from2'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label><bean:message bundle="asmResources" key="label.IGCIM0501.markDayTo"/></label><html:text property="eiupdtime_to2" styleId="eiupdtime_to2" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to2'))" border="0"/>
                        
                        <html:submit property="btn_search"   styleClass="button" onclick="return checkForm();">
                        		<bean:message bundle="asmResources" key="button.IGCIM0101.btn_search"/>
                        </html:submit>
                        <!-- 
                        <html:button property="btn_add"   styleClass="button" onclick="location.href='IGCIM0102_Disp.do'">
                        		<bean:message bundle="asmResources" key="button.IGCIM0101.btn_add"/>
                        </html:button>
                         -->
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
					            <!--<th width="12%"><bean:message bundle="asmResources" key="title.IGCIM0503.storageID"/></th>
					            -->
					            <th width="18%"><bean:message bundle="asmResources" key="title.IGCIM0503.storagename"/></th>
								<th width="18%"><bean:message bundle="asmResources" key="title.IGCIM0503.storageType"/></th>
								<th width="18%"><bean:message bundle="asmResources" key="title.IGCIM0501.getTime"/></th>
								<th width="12%"><bean:message bundle="asmResources" key="title.IGCIM0501.relationTree"/></th>
								<th width="12%"><bean:message bundle="asmResources" key="title.IGCIM0501.topology"/></th>
								<th width="12%"><bean:message bundle="asmResources" key="title.IGCIM0501.logic"/></th>
								<th width="12%"><bean:message bundle="asmResources" key="label.IGCIM0503.DMX_ANALYSIS"/></th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGCIM05031VO" property="entityDataList" >
			                	<bean:define id="vo"  name="IGCIM05031VO" />
			                	<bean:define id="showRelation"  name="IGCIM05031VO" property="showRelationMap"/>
			                    <logic:iterate id="bean" name="IGCIM05031VO" property="entityDataList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <!-- 存储ID 
			                            <td>
			                                <div class="nowrapDiv">
			                                 ${bean.eiid}
			                                </div>
			                            </td>
			                            -->
			                            <!-- 存储名 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                 <!--<html:link action="/IGCIM0108_Disp.do?eiid=${bean.eiid}">${bean.einame}</html:link>-->
			                                 ${bean.einame}
			                                </div>
			                            </td>
			                            <!-- 所属模型(设备类型) -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="ename">&nbsp;</logic:empty>
			                                ${bean.ename}
			                                </div>
			                            </td>
			                            <!-- 最后采集时间 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="eiinsdate">&nbsp;</logic:empty>
                                            ${bean.eiupdtime}
                                            </div>
			                            </td>
			                            <!-- 包含关系图 -->
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
			                            <!-- 拓扑图 -->
			                            <td>
			                                <div class="nowrapDiv">
			                               		<c:if test='${fn:substring(bean.esyscoding,0,9)=="999001001"|| fn:substring(bean.esyscoding,0,9)=="999001006"||fn:substring(bean.esyscoding,0,9)=="999001009"}'>
				                                <logic:notEqual name="bean" property="eircount" value="0">
	                                                <a href="javascript:void(0)" onclick="openSubIGCOM0310('${bean.eiid}')"><img src="images/relationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.relationshipDiagram.alt"/>' width="16" height="16"  border="0"/></a>
				                                </logic:notEqual>
				                                <logic:equal name="bean" property="eircount" value="0">
	                                                <img src="images/unrelationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.norelationship.alt"/>' width="16" height="16"  border="0"/>
				                                </logic:equal>
				                                </c:if>
				                                <c:if test='${fn:substring(bean.esyscoding,0,9)!="999001001"&& fn:substring(bean.esyscoding,0,9)!="999001006"&&fn:substring(bean.esyscoding,0,9)!="999001009"}'>
	                                                <img src="images/unrelationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.norelationship.alt"/>' width="16" height="16"  border="0"/>
				                                </c:if>
				                               
			                                </div>
			                            </td>
			                            <!-- 逻辑图 -->
		                           		 <td>
			                                <div class="nowrapDiv">
			                                	<logic:equal name="showRelation" property="${bean.eiid}" value="Y">
	                                            	<a href="javascript:void(0)" onclick="checkEIRelationInfo('${bean.eiid}','${vo.domainid}','${vo.domainversion}','${bean.eiversion}','${bean.eismallversion}','${vo.createtime}')"><img src="images/relationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.logicdiagram.alt"/>' width="16" height="16"  border="0"/></a>
			                                	</logic:equal>
			                                	<logic:notEqual name="showRelation" property="${bean.eiid}" value="Y">
			                                		<img src="images/unrelationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.nologicdiagram.alt"/>' width="16" height="16"  border="0"/>
			                                	</logic:notEqual>
			                                </div>
			                            </td>
			                             <!-- DMX配置分析 -->
		                           		 <!-- 拓扑关系图 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <c:if test="${fn:substring(bean.esyscoding,0,12)!='999001009001'}"><img src="images/unrecord_(copy)_16x16.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0100.norelationship.alt"/>' width="16" height="16"  border="0"/></c:if>
			                                <c:if test="${fn:substring(bean.esyscoding,0,12)=='999001009001'}"><a href="javascript:void(0)" onclick="openSubIGCOM0300('${bean.eiid}','${bean.einame}')"><img src="images/record_(copy)_16x16.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0100.relationship.alt"/>' width="16" height="16"  border="0"/></a></c:if>
			                                </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
                            <logic:present name="IGCIM05031VO" property="entityDataList" ></logic:present>
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>
                <html:hidden property="ecategory" styleId="ecategory" value="${IGCIM0101Form.ecategory}"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>