<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM0301" toScope="request"/>
<bean:define id="title" value="设备管理画面" toScope="request"/>

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
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="设备基本信息" />';
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
        	alert("没有可删除的数据！");
            return false;
        }
        

        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGASM0301_Del.do";
            return true;
        } else {
            return false;
        }
	}

	function setRoleDomain(){
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
			alert("请选择所属机构！");
			return false;
		}else if($F('ename').trim()==""){
			alert("请选择所属模型！");
			return false;
		} else {
			return true;
		}
	}

	 function setEntity(){
	    	<logic:notPresent name="ADrolemanager">
			var url = "IGSYM0304_ASSET.do?roletype=IGAC01&subtype=999001";
			</logic:notPresent>
			<logic:present name="ADrolemanager">
			<logic:equal name="ADrolemanager" value="true">
			var url = "IGSYM1203_ENTITY_TREE.do?levelnode=999001";
			</logic:equal>
			</logic:present>
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
	 function setUseRoleDomain(){
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
<html:form styleId="form" action="/IGASM0301"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>    
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
		             	<div>
		           <span style="font-size:15px;"><strong>查询条件</strong></span>
	                   </div>
                          <div class="conditions_border1">
                          <div style="margin-top:4px;">
                        <lable class="subscribe"><span class="subscribe"><span class="red">*</span>所属机构：</span></lable><html:text property="eiorgname" readonly="true"></html:text>
							<img src="images/tree.gif" style="cursor: hand;" alt="选择管理范围" width="16" height="16" border="0" onclick="setRoleDomain();"/>
							<html:hidden property="eiorgsyscoding"/>
							
<%--                           	<label>使用机构：</label><html:text property="useorgname" readonly="true"></html:text> --%>
<!-- 							<img src="images/tree.gif" style="cursor: hand;" alt="选择使用机构" width="16" height="16" border="0" onclick="setUseRoleDomain();"/> -->
							<html:hidden property="usesyscoding"/>&nbsp;&nbsp;
							
			                <span class="subscribe"><span class="red">*</span>所属模型：</span><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			                <img src="images/tree.gif" style="cursor: hand;" alt="选择资产管理内容" width="16" height="16" border="0" onclick="setEntity();"/>
			                <html:hidden property="esyscoding"/>
			               <span class="subscribe">设备名称：</span><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" ></html:text>&nbsp;&nbsp; 
	                           &nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;                    
	                        <html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkForm();"/>
                          </div>
                          <div style="margin-top:12px;">
	                        <span class="subscribe">登记日：</span><html:text property="eiupdtime_from" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from'))" border="0"/>
	                      
	                        <span>--</span><html:text property="eiupdtime_to" styleId="eiupdtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to'))" border="0"/>
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
					           <th>
					             <label>
					             <input type="checkbox" name="allbox" id="allbox" onclick="selectAll('allbox','deleteEiid')"/>
					             </label>
					           </th>
                               
					           <th width="13%">设备名称</th>
					          <th width="11%">序列号</th>
					           <th width="13%">所属模型</th>
					        
					           <th width="11%">管理人</th>
					           <th width="11%">登记日</th>
					           <th width="11%">购买日</th>
					           <th width="13%">详细信息</th>
					      
					           <!-- 
					           <th width="5%">关系图</th>
					            -->
					           <th width="11%">历史版本</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGASM03011VO" property="entityDataList" >
			                    <logic:iterate id="bean" name="IGASM03011VO" property="entityDataList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
			                            <c:if test="${ADmode == 'A'}">
			                            	<c:if test="${ADrolemanager == 'true'}">
			                                	<html:checkbox property="deleteEiid" value="${bean.eiid}"/>
			                            	</c:if>
			                            	<c:if test="${ADrolemanager != 'true'}">
				                            <c:if test="${LOGIN_USER.userid == bean.eiuserid}">
				                            	<html:checkbox property="deleteEiid" value="${bean.eiid}"/>
				                            </c:if>
				                            </c:if>
			                            </c:if>
			                            <c:if test="${ADmode == 'B'}">
			                            	<html:checkbox property="deleteEiid" value="${bean.eiid}"/>
			                            </c:if>
			                            </td>
			                            
			                           
			                            <!-- 名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                 <html:link action="/IGASM0321_Disp.do?eiid=${bean.eiid}">${bean.einame}</html:link>
			                               
			                                </div>
			                            </td>
			                           <!-- 序列号 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                 <logic:empty name="bean" property="ename">&nbsp;</logic:empty>
			                                ${bean.serial}
			                                </div>
                                             
			                            </td>
			                            
			                            <!-- 所属模型 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="ename">&nbsp;</logic:empty>
			                                ${bean.ename}
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
			                            <!-- 详细信息 -->
			                            <td>
			                                <div align="center">
                                                <html:link action="/IGASM0304_Disp.do?eiid=${bean.eiid}"><img src="images/xx.gif" alt="显示详细信息" width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                           
			                            <!-- 关系图 -->
			                            <!-- 
			                            <td>
			                                <div class="nowrapDiv">
				                                <logic:notEqual name="bean" property="eircount" value="0">
	                                                <a href="javascript:void(0)" onclick="openSubIGCOM0305('${bean.eiid}')"><img src="images/relationships.gif" alt="关系图" width="16" height="16"  border="0"/></a>
				                                </logic:notEqual>
				                                <logic:equal name="bean" property="eircount" value="0">
	                                                <img src="images/unrelationships.gif" alt="没有建立关系" width="16" height="16"  border="0"/>
				                                </logic:equal>
			                                </div>
			                            </td>
			                             -->
			                            <!-- 历史版本 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                <html:link action="/IGASM0305_Disp.do?eiid=${bean.eiid}&civersion="><img src="images/notepad_16x16.gif" alt="历史版本" width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
                            <logic:present name="IGASM03011VO" property="entityDataList" >
                            <html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec();" />
                            </logic:present>
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>
                <html:hidden property="ecategory" styleId="ecategory" value="${IGASM0301Form.ecategory}"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>