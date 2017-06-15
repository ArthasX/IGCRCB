<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGVIR0606" toScope="request"/>
<bean:define id="title"  toScope="request">
	数据存储配置查看
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
            form.action = getAppRootUrl() + "/IGAIM0101_Del.do";
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
		/**
		var eiorgsyscoding = document.forms[0].eiorgsyscoding.value;
		var eiorgname = document.forms[0].eiorgname.value;
		if((eiorgsyscoding==null || eiorgsyscoding=="") && (eiorgname==null || eiorgname=="")){
			var name = '<%=request.getAttribute("deforgname") %>';
			var id = '<%=request.getAttribute("deforgsys") %>';

			if(null!=id && null!=name && "null"!=id && "null"!=name){
				document.forms[0].eiorgsyscoding.value = id;
				document.forms[0].eiorgname.value = name;
			}		
		}
		*/
	}
	function checkForm(){
		var alertOrgan = '<bean:message bundle="asmResources" key="message.IGCIM0101.003"/>';
		var alertModel = '<bean:message bundle="asmResources" key="message.IGCIM0101.004"/>';
		if($F('eiorgname').trim()==""){
			alert(alertOrgan);
			return false;
		}else {
			return true;
		}
	}

	 function setEntity(){
		 var alertMessage = '<bean:message bundle="asmResources" key="message.IGCIM0101.005"/>';
			var url = "IGCIM1203_ENTITY_TREE.do?levelnode=999001001";

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
	 function setDefAssetDomain(){
			var esyscoding = document.forms[0].esyscoding.value;
			var ename = document.forms[0].ename.value;
			if((esyscoding==null || esyscoding=="") && (ename==null || ename=="")){
				var id = '<%=request.getAttribute("defassetsys") %>';
				var name = '<%=request.getAttribute("defassetname") %>';

				if(null!=id && null!=name && "null"!=id && "null"!=name){
					var syscode_eid = id;
					var syscode;
					var eid;
					if(syscode_eid.split("_").length>1){
						eid = syscode_eid.split("_")[0];
						syscode = syscode_eid.split("_")[1];
					}
					document.forms[0].esyscoding.value = syscode;
					document.forms[0].ename.value = name;
				}		
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

	 function initEname(){
		 	if("设备资产"==document.forms[0].ename.value){
				document.forms[0].ename.value = "主机";
				document.forms[0].esyscoding.value = "999001001";
		 	}
		}
	</script>

<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
   
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
<html:form styleId="form" action="/IGVIR0606"
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
			                <html:hidden property="esyscoding" value="999001029004"/>
			                <label>&nbsp;&nbsp;<bean:message bundle="asmResources" key="label.IGCIM0101.deviceName"/></label><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" ><script type="text/javascript">printBRByScreenWidth();</script></html:text>&nbsp;&nbsp; 
	                        <label><bean:message bundle="asmResources" key="label.IGCIM0101.markDayFrom"/></label><html:text property="eiupdtime_from" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label><bean:message bundle="asmResources" key="label.IGCIM0101.markDayTo"/></label><html:text property="eiupdtime_to" styleId="eiupdtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to'))" border="0"/>
                        &nbsp;
                        <html:submit property="btn_search"   styleClass="button" onclick="return checkForm();">
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
					           
                                <th width="4%">序号</th>
					           <th width="16%"><bean:message bundle="asmResources" key="title.IGCIM0101.devicename"/></th>
					           <!--<th width="17%">序列号</th>-->
					           <th width="8%"><bean:message bundle="asmResources" key="title.IGCIM0101.model"/></th>
					           <!--<th width="10%">设备状态</th>-->
					           <!--<th width="8%"><bean:message bundle="asmResources" key="title.IGCIM0101.manager"/></th>-->
					           <th width="8%"><bean:message bundle="asmResources" key="title.IGCIM0101.newversion"/></th>
					           <th width="8%"><bean:message bundle="asmResources" key="title.IGCIM0101.markDay"/></th>
					           <!--<th width="8%"><bean:message bundle="asmResources" key="title.IGCIM0101.rawci" /></th>-->
					           <th width="8%">属性查看</th>
<%-- 							   <th width="8%"><bean:message bundle="asmResources" key="title.IGCIM0101.relationship"/></th> --%>
					           <th width="8%"><bean:message bundle="asmResources" key="title.IGCIM0101.belongrelationship"/></th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGVIR06061VO" property="entityDataList" >
			                	<bean:define id="vo"  name="IGVIR06061VO" />
			                	<bean:define id="showRelation"  name="IGVIR06061VO" property="showRelationMap"/>
			                    <logic:iterate id="bean" name="IGVIR06061VO" property="entityDataList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                        
			                            <td>${PagingDTO.viewStartCount+index}</td>
			                           
			                            <!-- 名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                 ${bean.einame}
			                               
			                                </div>
			                            </td>
			                           <!-- 序列号 
			                            <td>
			                                <div class="nowrapDiv">
			                                 <logic:empty name="bean" property="ename">&nbsp;</logic:empty>
			                                ${bean.serial}
			                                </div>
                                             
			                            </td>
			                            -->
			                            <!-- 所属模型(设备类型) -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="ename">&nbsp;</logic:empty>
			                                ${bean.ename}
			                                </div>
			                            </td>
			                          
			                            <!-- 版本 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="eiversion">&nbsp;</logic:empty>
                                            ${bean.eiversion}.${bean.eismallversion}
                                            </div>
			                            </td>
			                            
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="eiinsdate">&nbsp;</logic:empty>
                                            ${bean.eiupdtime}
                                            </div>
			                            </td>
			                            
			                           <!-- 详细信息 -->
			                            <td>
			                                <div align="center">
                                                <html:link action="/IGCIM0905_Disp.do?eiid=${bean.eiid}&backUrl=IGVIR0606_Back.do"><img src="images/xx.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.displayInfo.alt"/>' width="16" height="16"  border="0"/></html:link>
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
<%--                 <html:hidden property="ecategory" styleId="ecategory" value="${IGCIM0101Form.ecategory}"/> --%>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>