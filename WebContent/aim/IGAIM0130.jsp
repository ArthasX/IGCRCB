<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGAIM0130" toScope="request"/>
<bean:define id="title"  toScope="request">
	<bean:message bundle="asmResources" key="ietitle.IGASM0808"/>
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
	
	//画面再表示

	function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var arg0= '<bean:message bundle="asmResources" key="message.IGASM0808.003"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="'+arg0+'" />';
        var frm = window.document.forms[0];
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

        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGASM0801_Del.do";
            return true;
        } else {
            return false;
        }
	}
	function setRoleDomain(){
		<logic:notPresent name="ADrolemanager">
		var url = "IGSYM0304.do?roletype=IGAC07";
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
		
	}
	function setOrg(url){
	   	 
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
	function checkForm(){
		var alterOrgan= '<bean:message bundle="asmResources" key="message.IGASM0808.001"/>';
		if($F('eiorgname').trim()==""){
			alert(alterOrgan);
			return false;
		} else {
			return true;
		}
	}

	 function setEntity(url){
		 var alterModel= '<bean:message bundle="asmResources" key="message.IGASM0808.002"/>';
		 var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		 	if("_resetall"==temp){
				document.forms[0].ename.value = "";
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
					alert(alterModel);
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
	</script>

<body onLoad="setDefRoleDomain();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <html:form styleId="form" action="/IGASM0808"
             onsubmit="return checkSubmit(this);">

            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">
                    <ig:navigation></ig:navigation>
                    </p>
            </div>
           <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
                          <label><span class="red">*</span><bean:message bundle="asmResources" key="label.IGASM0808.Organ"/></label><html:text property="eiorgname" readonly="true"></html:text>
								<img src="images/tree.gif" style="cursor: hand;" alt='<bean:message bundle="asmResources" key="img.IGASM0808.Scope.alt"/>'width="16" height="16" border="0" onclick="setRoleDomain();"/>
								<html:hidden property="eiorgsyscoding"/>&nbsp;&nbsp;
			                <label><bean:message bundle="asmResources" key="label.IGASM0808.Model"/></label><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			                 <img src="images/tree.gif" style="cursor: hand;" alt='<bean:message bundle="asmResources" key="img.IGASM0808.AssetModel.alt"/>' width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=999003');"/>
			                <html:hidden property="esyscoding"/>&nbsp;&nbsp;
			                <label><bean:message bundle="asmResources" key="label.IGASM0808.Name"/></label><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp; 
	                        
	                        <br/>
	                        <label><bean:message bundle="asmResources" key="label.IGASM0808.MarkDayFrom"/></label><html:text property="eiupdtime_from" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label><bean:message bundle="asmResources" key="label.IGASM0808.MarkDayTo"/></label><html:text property="eiupdtime_to" styleId="eiupdtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to'))" border="0"/>
		         			<html:submit property="btn_search" styleClass="button" onclick="return checkForm();">
		         				<bean:message bundle="asmResources" key="button.IGASM0808.btn_search"/>	
		         			</html:submit>
                          </div>
		     </div>
		     
          </div>
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table class="table_style">
			            <!-- header部 -->

			                <tr>
					           <th width="15%"><bean:message bundle="asmResources" key="label.IGASM0808.UserID"/></th>
					           <th width="20%"><bean:message bundle="asmResources" key="label.IGASM0808.UserName"/></th>
					           <th width="20%"><bean:message bundle="asmResources" key="label.IGASM0808.UserRemark"/></th>
					           <th width="7%"><bean:message bundle="asmResources" key="label.IGASM0808.UserManager"/></th>
					           <th width="8%"><bean:message bundle="asmResources" key="label.IGASM0808.UserMarkDay"/></th>
					           <th width="8%"><bean:message bundle="asmResources" key="label.IGASM0808.UserDetail"/></th>
					           <th width="8%"><bean:message bundle="asmResources" key="label.IGASM0808.RelationshipInfo"/></th>
					           <th width="7%"><bean:message bundle="asmResources" key="label.IGASM0808.RelationshioDiagram"/></th>
					       <!--<th width="7%"><bean:message bundle="asmResources" key="label.IGASM0808.HistoryVersion"/></th>-->
			                </tr>
			  
			            <!-- body部 -->
			            
			                <logic:present name="IGCIM01221VO" property="entityDataList" >
			                    <logic:iterate id="bean" name="IGCIM01221VO" property="entityDataList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <!-- 编号 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                ${bean.eilabel}
			                                </div>
			                            </td>
			                            <!-- 名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="einame">&nbsp;</logic:empty>
			                                ${bean.einame}
			                                </div>
			                            </td>
			                            <!-- 说明 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="eidesc">&nbsp;</logic:empty>
			                                ${bean.eidesc}
			                                </div>
			                            </td><!--
			                             状态 
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="eistatus">&nbsp;</logic:empty>
			                                <ig:codeValue ccid="ENTITY_ITEM_STATUS_CODE" cid="${bean.eistatus}"/>                                 
			                                </div>
			                            </td>
			                            -->
			                            <!-- 管理人 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="eiusername">&nbsp;</logic:empty>
                                            ${bean.eiusername}
                                            </div>
			                            </td>
			                            <!-- 登记日 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="eiinsdate">&nbsp;</logic:empty>
                                            ${bean.eiinsdate}
                                            </div>
			                            </td>
			                            <!-- 详细信息 -->
			                            <td>
			                                <div align="center">
                                                <html:link action="/IGASM0809_Disp.do?eiid=${bean.eiid}"><img src="images/xx.gif" alt='<bean:message bundle="asmResources" key="img.IGASM0808.DisplayDetail.alt"/>' width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                            <!-- 关系信息 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                <html:link action="/IGASM0811_Disp.do?eiid=${bean.eiid}"><img src="images/record_(copy)_16x16.gif" alt='<bean:message bundle="asmResources" key="img.IGASM0808.RelationshipInfo.alt"/>' width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                             <!-- 关系图 -->
			                            <td>
			                                <div class="nowrapDiv">
	                                            <logic:notEqual name="bean" property="eircount" value="0">
	                                                <a href="javascript:void(0)" onclick="openSubIGCOM0310('${bean.eiid}')"><img src="images/relationships.gif" alt='<bean:message bundle="asmResources" key="img.IGASM0808.RelationshipDiagram.alt"/>' width="16" height="16"  border="0"/></a>
				                                </logic:notEqual>
				                                <logic:equal name="bean" property="eircount" value="0">
	                                                <img src="images/unrelationships.gif" alt='<bean:message bundle="asmResources" key="img.IGASM0808.NoRelationship.alt"/>' width="16" height="16"  border="0"/>
				                                </logic:equal>
			                                </div>
			                            </td>
			                            <!-- 历史版本 -->
			                            <!--
			                            <td>
			                                <div class="nowrapDiv">
                                                <html:link action="/IGASM0810_Disp.do?eiid=${bean.eiid}&civersion="><img src="images/notepad_16x16.gif" alt='<bean:message bundle="asmResources" key="img.IGASM0808.HistoryVersion.alt"/>' width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                            -->
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
                <html:hidden property="ecategory" styleId="ecategory" value="${IGASM0801Form.ecategory}"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>