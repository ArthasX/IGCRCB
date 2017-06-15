<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0312" toScope="request"/>
<bean:define id="title" value="设备上缴查询画面" toScope="request"/>

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
	
	    function payRec(){
	        var message ='<bean:message key="IGCO10000.E018"/>';
	        var confirmMsg ='<bean:message key="IGCO10000.W004" arg0="设备上缴" />';
	        var result = "";
	        var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ asynchronous:false,parameters: 'type=getSlectedEntityItemNum',
				 onSuccess:  function(req, json){
				 	result = req.responseText;
			     }
				});
	        if(result != null && result.trim() != ""){
				if(result > '0') {
					if( window.confirm(confirmMsg)){
			            form.action = getAppRootUrl() + "/IGASM0313_Disp.do?type=I";
			            return true;
			        } else {
			            return false;
			        }
				} else if(result == '0') {
					alert("请选择要上缴的设备！");
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
	

	function setRoleDomain(url){
		url = url+"?roletype=IGAC01";
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
			alert("请选择使用机构！");
			return false;
		} 
		if($F('esyscoding').trim()==""){
			alert("请选择所属模型！");
			return false;
		}
			return true;
	}
	 function setEntity(url){
		 url = url+"?roletype=IGAC01&subtype=999001&isItDrivers=t";
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
   <html:form styleId="form" action="/IGASM0312"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">                  
                          <div>
                          	<label><span class="red">*</span>使用机构：</label><html:text property="eiorgname" readonly="true"></html:text>
								<img src="images/tree.gif" style="cursor: hand;" alt="选择管理范围" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0304.do');"/>&nbsp;&nbsp; 
								<html:hidden property="eiorgsyscoding"/>
			                <label><span class="red">*</span>所属模型：</label><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			               <img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGSYM0304_ASSET.do');"/>
			                <html:hidden property="esyscoding"/>
			                
			                <label>&nbsp;&nbsp;设备名称：</label><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp; 
			                <br/>
	                        <label>登记日：从</label><html:text property="eiupdtime_from" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label>到</label><html:text property="eiupdtime_to" styleId="eiupdtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to'))" border="0"/>
                            <html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkForm();"/>
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
					          <th width="2%">
					             <label>
					             <input type="checkbox" name="allbox" id="allbox" onclick="doSelectAll('allbox','payEiid')"/>
					             </label>
					           </th>
					           
					           <th width="18%">设备名称</th>
					           <th width="18%">序列号</th>
					           <th width="22%">说明</th>
					           <th width="7%">状态</th>
					           <th width="7%">管理人</th>
					           <th width="9%">登记日</th>
					           <th width="9%">购买日</th>
					           <th width="8%">上缴</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGASM03121VO" property="entityDataList" >
			                    <logic:iterate id="bean" name="IGASM03121VO" property="entityDataList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                           
			                        	<td>
			                                 <html:multibox property="payEiid" value="${bean.eiid}" onclick="selectEntityItem(this)"/>
			                            </td>
			                            <!-- 编号 -->
			                            
			                            <!-- 名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="einame">&nbsp;</logic:empty>
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
			                                <logic:empty name="bean" property="eidesc">&nbsp;</logic:empty>
			                                ${bean.eidesc}
			                                </div>
			                            </td>
			                            <!-- 状态 -->
			                            <td>
			                                <div class="nowrapDiv">    
			                                <logic:empty name="bean" property="eistatus">&nbsp;</logic:empty>
			                                <ig:codeValue ccid="EQUIPMENT_STATUS_CODE" cid="${bean.eistatus}"/>                            
			                                </div>
			                            </td>
	
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
			                             <!-- 购买日 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="buytime">&nbsp;</logic:empty>
                                            ${bean.buytime}
                                            </div>
			                            </td>
			                            <!-- 上缴 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="eiinsdate">&nbsp;</logic:empty>
                                            	<a href="IGASM0313_Disp.do?type=S&eiid=${bean.eiid}&eiiorgid=${bean.eiorgsyscoding}&eiversion=${bean.eiversion}"><img src="images/paid.gif" border="0" width="16" height="16" alt="上缴" /></a>
                                            </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
							<logic:present name="IGASM03121VO" property="entityDataList" >
                            <html:submit property="btn_pay" value="批量上缴" styleClass="button" onclick="return payRec();" />
                            </logic:present>
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>
                <html:hidden property="ecategory" styleId="ecategory" value="${IGASM0312Form.ecategory}"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>