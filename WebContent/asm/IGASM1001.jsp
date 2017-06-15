<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="org.apache.struts.util.LabelValueBean"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<html:html>
<bean:define id="id" value="IGASM1001" toScope="request"/>
<bean:define id="title" value="通用查询画面" toScope="request"/>

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
		function setEntity(url){

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

		function setCname(id,civaluename){
			
			 var esys = document.forms[0].esyscoding.value;
			 if(esys==null || esys==""){
				alert("请先选择属性的‘所属模型’！");
				return false;
			 }else{
				 var url = "IGASM1001_GETCNAME.do?esyscoding="+esys;
				 var temp = window.showModalDialog(url,null,"dialogWidth:800px;dialogHeight:500px;status:no;help:no;resizable:yes");
				 if("_reset_cname"==temp){
					 document.forms[0].cname[id].value = "";
					 document.forms[0].civalue[id].value = "";
  
					 document.getElementById(civaluename).innerHTML = "";
					 document.getElementById("c"+id).style.display="";
					 
				 }else{
					 if(null!=temp && temp.split("_").length>1){
						 var cname = temp.split("_")[0];
						 var cattach = temp.split("_")[1];
						 var coption = temp.split("_")[2];
						 document.forms[0].cname[id].value = cname;
						 if(cattach!=null && cattach=="2"){
							 var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{ parameters: 'coption='+ coption + '&type=ccdvalue',
								 onSuccess:  function(req, json){
								 //alert(req.responseText);
								 var result=req.responseText;
								 
									if(result!=null && result!=""){
										
										var len = result.split(";");
										var innerHtml="<select id='cvalue["+id+"]' name='cvalue["+id+"]' onchange='addSelect("+id+")'>";
										
										for(var i=0,j=len.length;i<j;i++){
											if(len[i].split("_").length>1){
												innerHtml+="<option value='"+len[i].split("_")[0]+"'>"+len[i].split("_")[1]+"</option>";
											}else{
												innerHtml+="<option value=''></option>";
											}
											
											
										}				
										innerHtml+="</select>";		
										
										document.getElementById(civaluename).innerHTML=innerHtml;
										document.getElementById("c"+id).style.display="none";
									}
											
							     }

								});
	 
						 }else if(cattach!=null && cattach=="3"){
							 document.forms[0].cattach.value = cattach;
							 var innerHtml = "<input type='text' readonly='true' id='cvalue["+id+"]' name='cvalue["+id+"]' size='10' onchange='addSelect("+id+")'/>&nbsp;&nbsp;";
							 innerHtml+="<img border=0  style='cursor: hand' src=images/date.gif  onclick=calendar($('cvalue["+id+"]')) />"
							 document.getElementById(civaluename).innerHTML=innerHtml;
							 document.getElementById("c"+id).style.display="none";
						 }else{
							 document.forms[0].cattach.value = cattach;
							 var innerHtml = "<input type='text' id='cvalue["+id+"]' name='cvalue["+id+"]' size='10' onchange='addSelect("+id+")'/>&nbsp;&nbsp;";
							
							 document.getElementById(civaluename).innerHTML=innerHtml;
							 document.getElementById("c"+id).style.display="none";
						 }
						 
					 }
				 } 
				 
			 }
			

		}
		function addSelect(id){
			document.forms[0].civalue[id].value = document.getElementById("cvalue["+id+"]").value;
		}
		function setDefualt(){
			document.forms[0].ename.value = "";
			document.forms[0].esyscoding.value = "";
			
			document.forms[0].cname[0].value = "";
			document.forms[0].civalue[0].value = "";

			document.forms[0].cname[1].value = "";
			document.forms[0].civalue[1].value = "";

			document.forms[0].cname[2].value = "";
			document.forms[0].civalue[2].value = "";

			document.forms[0].cname[3].value = "";
			document.forms[0].civalue[3].value = "";
		}
		function opetion(){
			var cattach = document.forms[0].cattach.value;
			if(cattach!=null && cattach=="3"){
				var num = 4;
				for(var i=0;i<num;i++){
					var civalue = document.getElementById("cvalue["+i+"]");
					if(civalue!=null && civalue.value!=""){
						document.forms[0].civalue[i].value = document.getElementById("cvalue["+i+"]").value;
					}
					
				}
			}

			document.forms[0].action= getAppRootUrl() + "/IGASM1001.do";
			document.forms[0].submit();
			
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
            <html:form styleId="form" action="/IGASM1001"
             onsubmit="return checkSubmit(this);">
             <input type="hidden" name="cattach" />
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
             <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
		             <div>
                       		<label>所属机构：</label><html:text property="eiorgname" readonly="true"></html:text>
								<img src="images/tree.gif" style="cursor: hand;" alt="选择管理范围" width="16" height="16" border="0" onclick="setOrg('IGSYM0101_TREE.do');"/>
								<html:hidden property="eiorgsyscoding" />&nbsp;&nbsp;
			               <label>所属模型：</label><html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" size="15" readonly="true"/>
			                 <img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGSYM1201_ENTITY_TREE.do?levelnode=999&type=0&socflag=yes');"/>
			                <html:hidden property="esyscoding"/>&nbsp;&nbsp;
			                <label>资产名称：</label><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10"/>&nbsp;&nbsp; 
	                        <br>
	                        
		    		 </div>
		    		 <div>
                           <label>配置查询1：&nbsp;</label>
                           	 <label>属性名：</label><html:text property="cname[0]" styleId="cname" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
                            <img src="images/tree.gif" style="cursor: hand;" alt="选择属性名" width="16" height="16" border="0" onclick="setCname('0','civalue0');"/>
                            <label>&nbsp;&nbsp;属性值：</label><span id="c0"><html:text property="civalue[0]" styleId="civalue" errorStyleClass="inputError imeDisabled" size="10" />
                            </span>
                            <span id="civalue0"></span>
                           <br>
                           <script type="text/javascript">
                           if(window.screen.width > 1024){
								document.write("<label style=margin-left: 25px>");
							} else {
								document.write("<label>");
							}
                           </script>
                           	配置查询2：&nbsp;<%="</label>" %>
                            <label>属性名：</label><html:text property="cname[1]" styleId="cname" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
                            	<img src="images/tree.gif" style="cursor: hand;" alt="选择属性名" width="16" height="16" border="0" onclick="setCname('1','civalue1');"/>
                            <label>&nbsp;&nbsp;属性值：</label><span id="c1" ><html:text property="civalue[1]" styleId="civalue" errorStyleClass="inputError imeDisabled" size="10" />
                            </span>
                            <span id="civalue1"></span>
		         </div>
		         <div>
                          <label>配置查询3：&nbsp;</label>
                            <label>属性名：</label><html:text property="cname[2]" styleId="cname" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
                            	<img src="images/tree.gif" style="cursor: hand;" alt="选择属性名" width="16" height="16" border="0" onclick="setCname('2','civalue2');"/>
                            <label>&nbsp;&nbsp;属性值：</label><span id="c2" ><html:text property="civalue[2]" styleId="civalue" errorStyleClass="inputError imeDisabled" size="10" />
                            </span>
                            <span id="civalue2"></span> 
                           <br>
                             <script type="text/javascript">
	                           if(window.screen.width > 1024){
									document.write("<label style=margin-left: 25px>");
								} else {
									document.write("<label>");
								}
                           	</script>
                           	配置查询4：&nbsp;<%="</label>" %>
                            <label>属性名：</label><html:text property="cname[3]" styleId="cname" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
                            	<img src="images/tree.gif" style="cursor: hand;" alt="选择属性名" width="16" height="16" border="0" onclick="setCname('3','civalue3');"/> 
                            <label>&nbsp;&nbsp;属性值：</label><span id="c3" ><html:text property="civalue[3]" styleId="civalue" errorStyleClass="inputError imeDisabled" size="10" />
                            </span>
                            <span id="civalue3"></span>              
		         </div >
		         <div>
		         			<label>登记日：从</label><html:text property="eiupdtime_from" styleId="eiupdtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_from'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label>到</label><html:text property="eiupdtime_to" styleId="eiupdtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiupdtime_to'))" border="0"/>	
		          <html:button property="btn_search" value="查询" styleClass="button" style="margin-top:6px; margin-left:60px;" onclick="opetion();"/>
		         </div>
		         <div style="height:5px"></div>
		         </div>
          		</div>
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table  class="table_style">
			            <!-- header部 -->

			                <tr>
					           <th width="12%">资产编号</th>
					           <th width="23%">资产名称</th>
					           <th width="20%">资产说明</th>
					           <th width="7%">管理人</th>
					           <th width="8%">登记日</th>
					           <th width="8%">详细信息</th>
					           <th width="8%">关系信息</th>
					           <!-- <th width="7%">关系图</th> -->
					           <th width="7%">历史版本</th>
			                </tr>

			            <!-- body部 -->
			                <logic:present name="IGASM10011VO" property="socEntityDataList" >
			                    <logic:iterate id="bean" name="IGASM10011VO" property="socEntityDataList" indexId="index">
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
			                            <!-- 详细信息 -->
			                            <td>
			                                
                                                <html:link action="/IGASM1004_Disp.do?eiid=${bean.eiid}"><img src="images/xx.gif" alt="显示详细信息" width="16" height="16"  border="0"/></html:link>
			                                
			                            </td>
			                            <!-- 关系信息 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
                                                <html:link action="/IGASM1006_Disp.do?eiid=${bean.eiid}"><img src="images/record_(copy)_16x16.gif" alt="关系信息" width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                              <!-- 关系图 -->
<%-- 			                            <td>
			                                <div class="nowrapDiv">
	                                            <logic:notEqual name="bean" property="eircount" value="0">
	                                                <a href="javascript:void(0)" onclick="openSubIGCOM0305('${bean.eiid}')"><img src="images/relationships.gif" alt="关系图" width="16" height="16"  border="0"/></a>
				                                </logic:notEqual>
				                                <logic:equal name="bean" property="eircount" value="0">
	                                                <img src="images/unrelationships.gif" alt="没有建立关系" width="16" height="16"  border="0"/>
				                                </logic:equal>
			                                </div>
			                            </td> --%>
			                            <!-- 历史版本 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                <html:link action="/IGASM1005_Disp.do?operType=tongji&eiid=${bean.eiid}&civersion="><img src="images/notepad_16x16.gif" alt="历史版本" width="16" height="16"  border="0"/></html:link>
			                                </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present> 
			       </table>
			     </div>
			     <html:hidden property="pageType"  value="tongyong" />
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