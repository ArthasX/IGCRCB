<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0310" toScope="request"/>
<bean:define id="title" value="设备报废查询画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	

    WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
    WebCalendar.format     = "yyyy/mm/dd";  //回传日期的格式
    WebCalendar.timeShow   = false;          //是否返回时间
    WebCalendar.drag       = true;          //是否允许拖动
    WebCalendar.darkColor  = "#014DB4";    //控件的暗色
    WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
    WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
    WebCalendar.wordColor  = "#000080";    //控件的文字颜色
    WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
    WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
    WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
    WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色

//画面再表示
function redisplay1(){
	$("ekey1").value = "";
	$("ekey2").value = "";
	form.action = getAppRootUrl() + "/IGASM0301_ReDisp.do";
	form.submit();
}
function redisplay2(){
	$("ekey2").value = "";
	form.action = getAppRootUrl() + "/IGASM0301_ReDisp.do";
	form.submit();
}
function redisplay3(){
	form.action = getAppRootUrl() + "/IGASM0301_ReDisp.do";
	form.submit();
}

function deleteRec(){
       var message ='<bean:message key="IGCO10000.E002"/>';
       var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="设备基本信息" />';
       var frm = window.document.forms[0];
       if(frm.deleteEiid.length > 0){
           var bchecked = false;
           for(var i=0; i<frm.deleteEiid.length; i++ ){//没有var XD-fixed
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
           form.action = getAppRootUrl() + "/IGASM0301_Del.do";
           return true;
       } else {
           return false;
       }
}

function setRoleDomain(url){
	<logic:notPresent name="ADrolemanager">
	var url = "IGSYM0304.do?roletype=IGAC01";
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
function checkForm(){

	if($F('eiorgname').trim()==""){
		alert("请输入所属机构！");
		return false;
	} else if($F('ename').trim()==""){
		alert("请选择所属类型！");
		return false;
	} else {
		return true;
	}
}
 function setEntity(url){
	 <logic:notPresent name="ADrolemanager">
		var url = "IGSYM0304_ASSET.do?roletype=IGAC01&subtype=999001&isItDrivers=t";
		</logic:notPresent>
		<logic:present name="ADrolemanager">
		<logic:equal name="ADrolemanager" value="true">
		var url = "IGSYM1203_ENTITY_TREE.do?levelnode=999001";
		</logic:equal>
		</logic:present>
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			 document.forms[0].ename.value = "";
//			 document.forms[0].eid.value = "";
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
				alert("资产模型不可用！请选择其他模型！");
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
 function view(ss){
        document.getElementById(ss).style.visibility="visible";
        document.getElementById(ss).style.top=window.event.y-5;
        document.getElementById(ss).style.left=window.event.x-5;
 }
 function subview(ss){
     document.getElementById(ss).style.visibility="visible";
 }
 function hide(tt){
     document.getElementById(tt).style.visibility="hidden";
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
 function issueCancle(){
	 var message ='<bean:message key="IGCO10000.E018"/>';
     var confirmMsg ='<bean:message key="IGCO10000.W004" arg0="设备撤销" />';
     var result = "";
     var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=getSlectedEntityItemNum',
			 onSuccess:  function(req, json){
			 	result = req.responseText;
		     }
			});
     if(result != null && result.trim() != ""){
			if(result > '0') {
				if( window.confirm(confirmMsg)){
					form.action = getAppRootUrl() + "/IGASM0315_BatchDisp.do?type=I";
		            return true;
		        } else {
		            return false;
		        }
			} else if(result == '0') {
				alert("请选择要撤销的设备！");
				return false;
			} else {
				alert("操作失败");
				return false;
			}
		} else {
			alert("操作失败");
			return false;
		}
 }
 function issueRec(){
     var message ='<bean:message key="IGCO10000.E018"/>';
     var confirmMsg ='<bean:message key="IGCO10000.W004" arg0="设备报废" />';
     var result = "";
     var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=getSlectedEntityItemNum',
			 onSuccess:  function(req, json){
			 	result = req.responseText;
		     }
			});
     if(result != null && result.trim() != ""){
			if(result > '0') {
				if( window.confirm(confirmMsg)){
					if(document.getElementById('eistatus').value=="N" || document.getElementById('eistatus').value=="R"){
						form.action = getAppRootUrl() + "/IGASM0311_BatchDisp.do?type=I";
					}else{
						form.action = getAppRootUrl() + "/IGASM0314_BatchDisp.do?type=I";
					}
		            return true;
		        } else {
		            return false;
		        }
			} else if(result == '0') {
				alert("请选择要报废的设备！");
				return false;
			} else {
				alert("操作失败");
				return false;
			}
		} else {
			alert("操作失败");
			return false;
		}
	}

 function selectEntityItem(obj){
     var type = "del";
     if(obj.checked) {
     	type = "add";
     }
		var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=selectEntityItem&eiid=' + obj.value + '&clicktype=' + type,
			 onSuccess:  function(req, json){
			 	var result = req.responseText;
				if(result != null && result.trim() != ""){	
				} else {
				}
		     }
			});
	}
	function doSelectAll(name,obj){
		selectAll(name,obj);
		var checks = document.getElementsByName(obj);
		for(var i=0;i < checks.length;i++){ 
			selectEntityItem(checks[i]);
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
            <html:form styleId="form" action="/IGASM0310"  onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
                          	<label><span class="red">*</span>所属机构：</label><html:text property="eiorgname" readonly="true"></html:text>
								<img src="images/tree.gif" style="cursor: hand;" alt="选择管理范围" width="16" height="16" border="0" onclick="setRoleDomain();"/>
								<html:hidden property="eiorgsyscoding"/>&nbsp;&nbsp;
			                <label><span class="red">*</span>所属模型：</label><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			               <img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity();"/>
			               &nbsp;&nbsp;
			                <label>状态：</label><html:select property="eistatus" style="width: 100px;">
                            	<!--<html:option value="N_R_P_S">&nbsp;</html:option>-->
                            	<html:option value="N">已入库</html:option>
                            	<html:option value="R">已上缴</html:option>
                            	<html:option value="P">预报废</html:option>
                            	<html:option value="S">已报废</html:option>
                            </html:select>
			                </div>
			                <div>
			                <html:hidden property="esyscoding"/>
			                <label>&nbsp;&nbsp;设备名称：</label><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp; 
	                        <label>登记日：从</label><html:text property="eiupdtime_from" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from'))" border="0" />&nbsp;&nbsp;
	                        <label>到</label><html:text property="eiupdtime_to" styleId="eiupdtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to'))" border="0" />&nbsp;&nbsp;
                          <html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkForm();"/>
                          </div>
		        
		       </div>
		     
          </div>
          
<!--          <div id="submenu110" class="subMenu" style="position:absolute; visibility:hidden; top: 10px; left: 10px; width: 50px; height:50px; background-color:#FDF9D5;  line-height:20px; padding :5px; filter: Alpha(opacity= 85); opacity:0.85;" onMouseOver="subview('submenu110')" onMouseOut="hide('submenu110')" >-->
<!--                 <html:link href="javascript:addCid();">报废</html:link><BR>-->
<!--                 <html:link href="javascript:deleteCid();">撤销</html:link>-->
<!--          </div>-->
         
                
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>
			                   <th width="2%">
					             <label>
					             <input type="checkbox" name="allbox" id="allbox" onclick="doSelectAll('allbox','issueEiid')"/>
					             </label>
					           </th>
					         
					           <th width="18%">设备名称</th>
					           <th width="18%">序列号</th>
					           <th width="16%">说明</th>
					           <th width="7%">状态</th>
					           <th width="7%">管理人</th>
					           <th width="9%">登记日</th>
					           <th width="9%">购买日</th>
					           <th colspan="2" width="14%">操作</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGASM03101VO" property="entityDataList" >
			                    <logic:iterate id="bean" name="IGASM03101VO" property="entityDataList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
			                            <logic:notEqual name="IGASM0310Form" property="eistatus"  value="S">
			                            
			                            <html:multibox property="issueEiid" value="${bean.eiid}" onclick="selectEntityItem(this)"/>
			                            
			                            </logic:notEqual>
			                            </td>
			                            <!-- 编号 -->
			                            
			                            <!-- 名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.einame}
			                                </div>
			                            </td>
			                             <!-- 序列号 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="serial">&nbsp;</logic:empty>
			                                ${bean.serial}
			                                </div>
			                            </td>
			                            <!-- 说明 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.eidesc}
			                                </div>
			                            </td>
			                            <!-- 状态 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <ig:codeValue ccid="EQUIPMENT_STATUS_CODE" cid="${bean.eistatus}"/>            
			                                </div>
			                            </td>
			                            <!-- 管理人 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.eiusername}
                                            </div>
			                            </td>
			                            <!-- 登记日 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.eiinsdate}
                                            </div>
			                            </td>
			                             <!-- 购买日 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="buytime">&nbsp;</logic:empty>
                                            ${bean.buytime}
                                            </div>
			                            </td>
			                            <!-- 报废 -->
                                         	<logic:equal name="bean" property="eistatus"  value="N">
                                         		<td colspan="2">
                                         			<div class="nowrapDiv">
                                         				<a href="IGASM0311_Disp.do?type=&eiid=${bean.eiid}&eiversion=${bean.eiversion}">预报废</a>
                                         			</div>
                                         		</td>
                                         	</logic:equal>
                            		
                                         	<logic:equal name="bean" property="eistatus"  value="R">
                                         		<td colspan="2">
                                         			<div class="nowrapDiv">
                                         				<a href="IGASM0311_Disp.do?type=&eiid=${bean.eiid}&eiversion=${bean.eiversion}">预报废</a>
                                         			</div>
                                         		</td>
                                         	</logic:equal>
                                         	
                                         	<logic:equal name="bean" property="eistatus"  value="P">
                                         		<td>
                                         			<div class="nowrapDiv">
                                        				<a href="IGASM0314_Disp.do?eiid=${bean.eiid}&eiversion=${bean.eiversion}"><!-- onmouseover="view('submenu110')" onmouseout="hide('submenu110')"-->报废</a>
                                         			</div>
                                         		</td>
                                         		<td>
                                         			<div class="nowrapDiv">
                                         				<a href="IGASM0315_Disp.do?eiid=${bean.eiid}&eiversion=${bean.eiversion}">撤销</a>
                                         			</div>
                                         		</td>
                                         	</logic:equal>
                                         	<logic:equal name="bean" property="eistatus"  value="S">
                                         		<td colspan="2">
                                         			<div class="nowrapDiv">
                                         				已报废
                                         			</div>
                                         		</td>
                                         	</logic:equal>
                                         
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
			     <logic:present name="IGASM03101VO" property="entityDataList" >
			     <logic:equal name="IGASM0310Form" property="eistatus"  value="P">
			     <html:submit property="btn_issue" value="批量报废" styleClass="button" onclick="return issueRec();" />
			     <html:submit property="btn_issue" value="批量撤销" styleClass="button" onclick="return issueCancle();" />
			     </logic:equal>
			     <logic:equal name="IGASM0310Form" property="eistatus"  value="N">
			     <html:submit property="btn_issue" value="批量预报废" styleClass="button" onclick="return issueRec();" />
			     </logic:equal>
			     <logic:equal name="IGASM0310Form" property="eistatus"  value="R">
			     <html:submit property="btn_issue" value="批量预报废" styleClass="button" onclick="return issueRec();" />
			     </logic:equal>
			     </logic:present>
		                <!-- paging -->
		                <jsp:include page="/include/paging.jsp"/>
		                <!-- /paging -->
			    </div>
                <html:hidden property="ecategory" styleId="ecategory" value="${IGASM0308Form.ecategory}"/>
            </html:form>
        </div>
    </div>
</div>

</div>
</body>
</html:html>