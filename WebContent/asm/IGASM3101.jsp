<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM3101" toScope="request"/>
<bean:define id="title" value="风险指标画面" toScope="request"/>

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
	    
	    jQuery(document).ready(function() {
	    	var managername="<%=request.getParameter("managername")%>";
	   	   var eiStartDate ="<%=request.getParameter("eiStartDate")%>";
	   	    var euStartDate= "<%=request.getParameter("euStartDate")%>";
	    	   if(managername=="null"){
	    		   if(eiStartDate=="null"){
	    			   if(euStartDate=="null"){
	    	    		   document.getElementById("div_0.0").style.display="none";
	    	    	   }		    	   }
	    	   }
	    	   if(managername==''){
	    		   if(eiStartDate==''){
	    			   if(euStartDate==''){
	    	    		   document.getElementById("div_0.0").style.display="none";
	    	    	   }		    	   }
	    	   }
	    	});
	
	function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="风险指标基本信息" />';
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
            form.action = getAppRootUrl() + "/IGASM3101_Del.do";
            return true;
        } else {
            return false;
        }
	}
	function setRoleDomain(){
		<logic:notPresent name="ADrolemanager">
		var url = "IGSYM0304.do?roletype=IGAC15";
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
	
	function searchuser(){	
		openSubWindow('/IGSYM1905_Disp.do?', '_blank','1000','600','center:1');
	}
	function setIGCYB0101Params(username,orgname,orgid,useremail,userphone,usermobile,userid){
		document.getElementById("managername").value = username;
		document.getElementById("mguserid").value = userid;
	}
	
	
	 function setEntity(){
		 	<logic:notPresent name="ADrolemanager">
			var url = "IGSYM0304_RISK.do?roletype=IGAC15&subtype=999019";
			</logic:notPresent>
			<logic:present name="ADrolemanager">
			<logic:equal name="ADrolemanager" value="true">
			var url = "IGSYM1203_ENTITY_TREE.do?levelnode=999019";
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
	 function checkitem(eid,version){
			window.location.href="IGASM3104_Disp.do?eiid="+eid+"&eiversion="+version+"&looksign=1";
		}
	 function onExcel(){
			form.action = "IGASM3101_Excel.do";
			form.submit();
		}
	function onSearch(){

		    
			form.action = "IGASM3101.do";
			form.submit();
		
		}
	function onShow(){
		document.getElementById("div_0.0").style.display="";
		document.getElementById("label_img").innerHTML = "<img src=\"images/backup.gif\" align=\"middle\" alt=\"收起\" onclick=\"onHidden()\" style=\"cursor: hand;\" border=\"0\"/>";
	}
	
	function onHidden(){
		document.getElementById("div_0.0").style.display="none";
		document.getElementById("label_img").innerHTML = "<img src=\"images/moreSearch.gif\" align=\"middle\" alt=\"更多搜索条件\" onclick=\"onShow()\" style=\"cursor: hand;\" border=\"0\"/>";
	}
	
	function condition(){
		var hiddendiv = jQuery(".conditions").find("div[id^='div_']:hidden");
		hiddendiv.each(function(i,o){
			o=jQuery(o);
			var e=o.find("input:not(:empty),select[value!='']").length;
			if(e>0){
				onShow();
			}
		});
	}
	</script>
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />
<body onload="condition();">
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">

    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <html:form styleId="form" action="/IGASM3101"
             onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
		             	<div style="margin-top:4px">
							<span style="font-size:15px;"><strong>查询条件</strong></span>
							<label id="label_img" style="margin-left:736px;margin-top:-1px;">
					    		<img src="images/moreSearch.gif" align="middle" alt="更多搜索条件" onclick="onShow()" style="cursor: hand;" border="0"/>
					   	    </label>
						</div>
                          <div style="margin-top:4px">
                          	<span class="subscribe">指标名称：</span>
                   			<html:text property="einame" styleId="einame" readonly="readonly"  size="16"/>
                         	<span class="subscribe">指标编号：</span>
                   			<html:text property="eilabel" styleId="eilabel" readonly="readonly"  size="16"/>            
							<label><span class="subscribe">指标分类：</span></label>
							<html:text property="ename" styleId="ename"  errorStyleClass="inputError imeDisabled" style="width:75px" size="15" readonly="true"/>
			                <img src="images/tree.gif" style="cursor: hand;" alt="选择指标分类" width="16" height="16" border="0" onclick="setEntity();"/>
			                <html:hidden property="esyscoding"/>
			                <span class="subscribe">指标用途：</span>
                   			<html:text property="indexused" styleId="indexused" readonly="readonly"  size="16"/> 			                
	                        <html:submit property="btn_search" value="查询" styleClass="button" onclick="onSearch()"/>
	                        <br/>
	                        <div style="margin-top:12px">
	                        <span class="subscribe">阈值：</span>
	                        <html:text property="zbfz" styleId="zbfz" readonly="readonly" size="16"/>
	                        <%-- 
	                        <html:select property="zbfz" name="IGASM3101Form">
			             		<option value=""></option>
							    <logic:present name="IGASM31011VO" property="thresholdList" >
									 <html:optionsCollection name="IGASM31011VO" property="thresholdList" label="ccdvalue" value="ccdvalue"/>
								</logic:present>
           			 		</html:select>
           			 		 --%>
                         	<span class="subscribe">指标责任人：</span>
                   			<html:text property="dutyuser" styleId="dutyuser" readonly="readonly"  size="16"/> 
	                        <span class="subscribe">指标责任部门：</span>
                   			<html:text property="dutydepartment" styleId="dutydepartment" style="width:98px" readonly="readonly"  size="16"/>
                         	<span class="subscribe">是否关键指标：</span>
                         	 <html:select property="keyindex" name="IGASM3101Form">
			             		<option value=""></option>
							    <logic:present name="IGASM31011VO" property="keyIndexList" >
									 <html:optionsCollection name="IGASM31011VO" property="keyIndexList" label="ccdvalue" value="ccdvalue"/>
								</logic:present>
           			 		</html:select>
           			 		<input type="button" value="导出" class="button" onclick="onExcel()">
           			 		
                   			<br/>
                   			</div>
                   			 <div id="div_0.0"  style="margin-top:12px" >
                   			<span class="subscribe">指标管理人：</span>
                   			<html:text property="managername" styleId="managername" readonly="readonly" style="width:81px" size="16"/>
            				<img  id="img01" src="images/seek.gif" border="0" style="cursor: pointer;" onclick="searchuser();"/>
	                        <label><span class="subscribe">登记日期：</span></label><html:text property="eiStartDate" styleId="eiStartDate" errorStyleClass="inputError imeDisabled" style="width:70px" size="8" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('eiStartDate'))" border="0"/> 
	                        <label>至</label><html:text property="eiEndDate" styleId="eiEndDate" errorStyleClass="inputError imeDisabled" style="width:70px" size="8" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('eiEndDate'))" border="0"/>
                            
                            <label><span class="subscribe">更新日期：</span></label><html:text property="euStartDate" styleId="euStartDate" errorStyleClass="inputError imeDisabled" style="width:65px" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('euStartDate'))" border="0"/> 
	                        <label>至</label><html:text property="euEndDate" styleId="euEndDate" errorStyleClass="inputError imeDisabled" style="width:65px" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('euEndDate'))" border="0"/>
		         			<html:hidden property="mguserid" styleId="mguserid"/>
		         			</div>
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
					          	<th width="2%">
					             <label>
					             <input type="checkbox" style="width:20px;" name="allbox" id="allbox" onclick="selectAll('allbox','deleteEiid')"/>
					             </label>
					           </th>
					           
					           
					           <th width="12%">风险领域</th>
					           <th width="12%">风险子域</th>
					           <th width="12%">风险项</th>
                               <th width="10%">指标编号</th>
                               <th width="10%">指标名称</th>
					           <th width="7%">指标用途</th>
					           <th width="7%">阈值</th>
					           <th width="5%">是否关键指标</th>
					           <th width="5%">指标管理人</th>
					           <th width="5%">指标责任部门</th>
					           <th width="7%">指标责任人</th>
			                </tr>
			            <!-- body部 -->
			         
			                <logic:present name="IGASM31011VO" property="searchRiskIndexSearchVWList" >
			                    <logic:iterate id="bean" name="IGASM31011VO" property="searchRiskIndexSearchVWList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <!-- 风险领域 -->
			                            <td> <input type="checkbox"   style="width:20px;" name="deleteEiid" value="${bean.eiid}"/></td>
			                            <td>
			                                <div class="nowrapDiv">
                                                <logic:empty name="bean" property="riskly">&nbsp;</logic:empty>${bean.riskly}
			                                </div>
			                            </td>
			                            
			                            <!-- 风险子域-->
			                            <td>
			                                <div class="nowrapDiv">
			                                	<logic:empty name="bean" property="riskarea">&nbsp;</logic:empty>${bean.riskarea}
			                                </div>
			                            </td>
			                            
			                            <!-- 风险项-->
			                            <td>
			                                <div class="nowrapDiv">
			                                	<logic:empty name="bean" property="riskitem">&nbsp;</logic:empty>${bean.riskitem}
			                                </div>
			                            </td>
			                            
			                            <!--指标编号-->
			                            <td>
			                                <div class="nowrapDiv">
			                                	<a href="javascript:void(0)" onclick="checkitem('${bean.eiid}','${bean.eiversion }')">${bean.eilabel}</a>
			                                </div>
			                            </td>
			                            
			                            <!-- 指标名称-->
			                            <td>
                                            <div class="nowrapDiv">
                                            	<logic:empty name="bean" property="einame">&nbsp;</logic:empty>${bean.einame}
                                            </div>
			                            </td>
			                            
			                            <!-- 指标用途 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            	<logic:empty name="bean" property="indexused">&nbsp;</logic:empty>${bean.indexused}
                                            </div>
			                            </td>
			                            
			                            <!-- 阈值 -->
			                            <td>
			                                <div align="center">
                                                <logic:empty name="bean" property="zbfz">&nbsp;</logic:empty>${bean.zbfz}
			                                </div>
			                            </td>
			                            
			                            <!-- 是否关键指标 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                 <logic:empty name="bean" property="keyindex">&nbsp;</logic:empty>${bean.keyindex}
			                                </div>
			                            </td>
			                            
			                            <!-- 指标管理人 -->
			                            <td>
			                                <div class="nowrapDiv">
	                                             <logic:empty name="bean" property="mgusername">&nbsp;</logic:empty>${bean.mgusername}
			                                </div>
			                            </td>
			                            
			                            <!-- 指标责任部门 -->
			                            <td>
			                                <div align="center">
                                                <logic:empty name="bean" property="dutydepartment">&nbsp;</logic:empty>${bean.dutydepartment}
			                                </div>
			                            </td>
			                            
			                            <!-- 指标责任人 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                 <logic:empty name="bean" property="dutyuser">&nbsp;</logic:empty>${bean.dutyuser}
			                                </div>
			                            </td>
			                            
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			  
			       </table>
			     </div>
			     <div id="operate">
						  <logic:present name="IGASM31011VO" property="searchRiskIndexSearchVWList" >
						  		<html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec();" />
						  </logic:present>
							<jsp:include page="/include/paging.jsp"/>
                </div>
			    
                <html:hidden property="ecategory" styleId="ecategory" value="${IGASM3101Form.ecategory}"/>
                
                
                
                
                
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>