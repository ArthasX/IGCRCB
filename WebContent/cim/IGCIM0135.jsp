<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM0135" toScope="request"/>
<bean:define id="title" value="按人员查询" toScope="request"/>

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
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="人员基本信息" />';
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
            form.action = getAppRootUrl() + "/IGCIM0135_Del.do";
            return true;
        } else {
            return false;
        }
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

		//if($F('eiorgname').trim()==""){
			//alert("请选择所属机构！");
			//return false;
		//}
		//else if($F('ename').trim()==""){
			//alert("请选择所属模型！");
			//return false;
		//} 
		//else {
			return true;
		//}
	}

	function searchBussies(eiid){
		//location.href="IGCIM0150_Disp.do?EIID="+eiid;
		var url="/IGAIM0148.do?EIID="+eiid;
		var obj = window.showModalDialog("<%=request.getContextPath()%>" + url,null,"dialogWidth:1000px;dialogHeight:700px;status:no;help:no;resizable:yes");
		if(obj != null){ 
			window.parent.location.href = obj;
		}
	}
		
	function setEntity(){
    	<logic:notPresent name="ADrolemanager">
		var url = "IGSYM0304_ASSET.do?roletype=IGCI01&subtype=999010";
		</logic:notPresent>
		<logic:present name="ADrolemanager">
		<logic:equal name="ADrolemanager" value="true">
		var url = "IGSYM1203_ENTITY_TREE.do?levelnode=999010";
		</logic:equal>
		</logic:present>
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			// document.forms[0].ename.value = "";
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
			//document.forms[0].ename.value = name;
		//	document.forms[0].eid.value = eid;
			document.forms[0].esyscoding.value = syscode;
		}		
	}
 	function setDefAssetDomain(){
		var esyscoding = document.forms[0].esyscoding.value;
		//var ename = document.forms[0].ename.value;
		if(esyscoding==null || esyscoding==""){
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
				//document.forms[0].ename.value = name;
			}		
		}
	}
	</script>

<body onLoad="setDefAssetDomain();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
<html:form styleId="form" action="/IGCIM0135"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>   
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
<!--                          	<label><span class="red">*</span>所属机构：</label><html:text property="eiorgname" readonly="true"></html:text>-->
<!--								<img src="images/tree.gif" style="cursor: hand;" alt="选择管理范围" width="16" height="16" border="0" onclick="setRoleDomain();"/>-->
<!--								<html:hidden property="eiorgsyscoding"/>&nbsp;&nbsp;-->
 			                <html:hidden property="esyscoding"/> 
			                <label>&nbsp;&nbsp;人员姓名：</label><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp; 
	                        
<%-- 	                        <label>业务系统名称：</label><html:text property="businessName" styleId="businessName" errorStyleClass="inputError imeDisabled" size="12"/>  --%>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
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
			                	<th width="16%" >业务系统名称</th>
					           <th width="20%">管理人姓名</th>
					           <th width="17%" >联系方式</th>
					           <th width="10%">登记人</th>
					           <th width="10%">登记日</th>
					           <th width="7%">状况信息</th>
			                </tr>
			            <!-- body部 -->		
			                <logic:present name="IGCIM01351VO" property="soc0119InfoList" >
			                    <logic:iterate id="bean" name="IGCIM01351VO" property="soc0119InfoList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <!-- 业务系统名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.parEntityItemVW.einame}
			                                </div>
			                            </td>
			                            <!-- 姓名 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.cldEntityItemVW.einame}
			                                </div>
			                            </td>
			                            <!-- 说明 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.cldEntityItemVW.eidesc}
			                                </div>
			                            </td>
			                            <!-- 管理人 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.cldEntityItemVW.eiusername}
                                            </div>
			                            </td>
			                            <!-- 登记日 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.cldEntityItemVW.eiinsdate}
                                            </div>
			                            </td>
			                            <!-- 包含关系图 -->
			                            <td>
			                                <div class="nowrapDiv">
	                                            <a href="javascript:void(0)" onclick="searchBussies(${bean.parEntityItemVW.eiid})"><img src="images/relationships.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0101.belongrelationshipDiagram.alt"/>' width="16" height="16"  border="0"/></a>
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
                <html:hidden property="ecategory" styleId="ecategory" value="${IGCIM0135Form.ecategory}"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>