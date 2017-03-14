<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM04022" toScope="request"/>
<bean:define id="title" value="资产管理画面" toScope="request"/>

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

	function relationRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ="确定关联选中资产?";
        var frm = window.document.forms[0];
        if(frm.relationEiid) {
	        if(frm.relationEiid.length > 0){
	            var bchecked = false;
	            for( i=0; i<frm.relationEiid.length; i++ ){
	                if (frm.relationEiid[i].checked == true){
	                    bchecked = true;
	                }
	            }
	            if (!bchecked) {
	            	alert("请选择要关联资产！");
	                return false;
	            }
	        } else {
	          if ($("relationEiid").checked == false){
	              alert("请选择要关联资产！");
	              return false;
	          }  
	        }
        } else {
        	alert("没有可关联的资产！");
            return false;
        }
        

        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGDRM0402_Relation.do";
            return true;
        } else {
            return false;
        }
	}

// 	function setRoleDomain(){
// 		var url = "IGSYM0101_TREE.do";
// 		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
// 		if("_resetall"==temp){
// 			document.forms[0].eiorgsyscoding.value = "";
// 			document.forms[0].eiorgname.value = "";
// 			return false;
// 		}
// 		if(null!=temp && temp.split("|").length>1){
// 			document.forms[0].eiorgsyscoding.value = temp.split("|")[0];
// 			document.forms[0].eiorgname.value = temp.split("|")[1];
// 		}		
// 	}
// 	function setDefRoleDomain(){
// 		var eiorgsyscoding = document.forms[0].eiorgsyscoding.value;
// 		var eiorgname = document.forms[0].eiorgname.value;
// 		if((eiorgsyscoding==null || eiorgsyscoding=="") && (eiorgname==null || eiorgname=="")){
<%-- 			var name = '<%=request.getAttribute("deforgname") %>'; --%>
<%-- 			var id = '<%=request.getAttribute("deforgsys") %>'; --%>

// 			if(null!=id && null!=name && "null"!=id && "null"!=name){
// 				document.forms[0].eiorgsyscoding.value = id;
// 				document.forms[0].eiorgname.value = name;
// 			}		
// 		}
		
// 	}
	function checkForm(){
// 		if($F('eiorgname').trim()==""){
// 			alert("请选择所属机构！");
// 			return false;
// 		}else
		if($F('ename').trim()==""){
			alert("请选择所属模型！");
			return false;
		} else {
			return true;
		}
	}

	 function setEntity(url){
	    	var esyscode = jQ("#esyscode").val();
	    	if(esyscode) url = url + "&esyscoding=" + esyscode ;
			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].ename.value = "";
				document.forms[0].esyscoding.value = "";
// 				document.forms[0].ecategory.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){

				var syscode_eid = temp.split("|")[0];
				var name = temp.split("|")[1];
				var syscode;
				var eid;
				if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[1];
					syscode = syscode_eid.split("_")[0] +"_"+ syscode_eid.split("_")[2];
// 					ecategory = syscode_eid.split("_")[2];
// 				document.forms[0].ecategory.value = ecategory;
				}
				document.forms[0].ename.value = name;
// 				document.forms[0].eparcoding.value = syscode;
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
			var url = "IGSYM0101_TREE.do";
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
	 function clearForm(){
		 if('close'=='${status}'){
   			window.opener.location.href = window.opener.location.href
		 	window.close();
		 } 
		 if(location.href.search("Disp.do")>-1){
// 		 document.forms[0].eiorgname.value = '';
// 		 document.forms[0].eiorgsyscoding.value = '';
// 		 document.forms[0].ename.value = '';
// 		 document.forms[0].esyscoding.value = '';
		 document.forms[0].eiupdtime_from.value = '';
		 document.forms[0].eiupdtime_to.value = '';
		 document.forms[0].einame.value = '';
		 }
		 
	 }
</script>
<body onLoad="clearForm()">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<%-- <jsp:include page="/include/header2.jsp" /> --%>
<!--container 左菜单 右侧内容-->
<div id="container">
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
<html:form styleId="form" action="/IGDRM0402_Entity_Search"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/>  >> 应急资源选择</p>
            </div>    
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
		             	<div>
		           <span style="font-size:15px;"><strong>查询条件</strong></span>
	                   </div>
                          <div class="conditions_border1">
                          <div style="margin-top:4px;">
<!--                         <lable class="subscribe"><span class="subscribe"><span class="red">*</span>所属机构：</span> -->
<!--                         </lable> -->
<%--                         <html:text property="eiorgname" readonly="true"></html:text> --%>
<!-- 							<img src="images/tree.gif" style="cursor: hand;" alt="选择管理范围" width="16" height="16" border="0" onclick="setRoleDomain();"/> -->
							<html:hidden property="eiorgsyscoding"/>
<%-- 							<html:hidden property="usesyscoding"/>&nbsp;&nbsp; --%>
							
			                <span class="subscribe"><span class="red">*</span>所属模型：</span>
			                <html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			                <img src="images/tree.gif" style="cursor: hand;" alt="选择资产管理内容" width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=999&type=0&socVWflag=yes');"/>
			                <html:hidden property="esyscoding" styleId="esyscoding"/>
			               &nbsp;&nbsp;<span class="subscribe">资产名称：</span><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" ></html:text>&nbsp;&nbsp; 
<!--                           </div> -->
<!--                           <div style="margin-top:12px;"> -->
	                        <span class="subscribe">登记日：</span><html:text property="eiupdtime_from" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from'))" border="0"/>
	                      
	                        <span>--</span><html:text property="eiupdtime_to" styleId="eiupdtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to'))" border="0"/>
	                        &nbsp;&nbsp;<html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkForm();"/>
                          </div>
                    </div>
		      </div>
          </div>
<%--           ${IGDRM0402Form.get } --%>
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>
					           <th>
					             <label>
					             <input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','relationEiid')"/>
					             </label>
					           </th>
                               
					           <th width="30%">资产名称</th>
					          <th width="20%">资产编号</th>
					           <th width="15%">所属模型</th>
					        
					           <th width="15%">管理人</th>
					           <th width="15%">登记日</th>
			                </tr>
			            <!-- body部 -->			
			                <logic:present name="IGDRM04021VO" property="entityVWItemList" >
			                    <logic:iterate id="bean" name="IGDRM04021VO" property="entityVWItemList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
				                            	<html:checkbox property="relationEiid" value="${bean.id}_${bean.eiid }"/>
			                            </td>
			                           
			                            <!-- 名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                 ${bean.einame}
			                               
			                                </div>
			                            </td>
			                           <!-- 序列号 -->
			                            <td>
			                                <div class="nowrapDiv">${bean.eilabel}
			                                 <logic:empty name="bean" property="eilabel">&nbsp;</logic:empty>
			                                ${bean.eilabel}
			                                </div>
                                             
			                            </td>
			                            
			                            <!-- 所属模型 -->
			                            <td>
			                                <div class="nowrapDiv">
<%-- 			                                <logic:empty name="bean" property="ename">&nbsp;</logic:empty> --%>
<%-- 			                                ${bean.ename} --%>
<!-- 			                                </div> -->
										<ig:GetMOdelNameByEiid eiid="${bean.eiid}" id="${bean.id}"/>
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
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
                            <logic:present name="IGDRM04021VO" property="entityVWItemList" >
                            <html:submit property="btn_delete" value="选择" styleClass="button" onclick="return relationRec();" />
                            </logic:present>
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>
<%--                 <html:hidden property="ecategory" styleId="ecategory" value="${IGASM0301Form.ecategory}"/> --%>
                <html:hidden property="ercode" styleId="ercode" value="${IGDRM0402Form.ercode}"/>
                <html:hidden property="erid" styleId="erid" value="${IGDRM0402Form.erid}"/>
                <input type="hidden" name= "esyscode" id="esyscode" value="${IGDRM0402Form.esyscode}"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>