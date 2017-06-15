<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGASM0101" toScope="request" />
<bean:define id="title" value="模型查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<%

	Map<Integer,String> stopbuttonmap = new HashMap<Integer,String>();
	Map<Integer,String> startbuttonmap = new HashMap<Integer,String>();
	if(null!=request.getAttribute("stopbuttonMap")){
		stopbuttonmap = (Map)request.getAttribute("stopbuttonMap");
	}
	if(null!=request.getAttribute("startbuttonMap")){
		startbuttonmap = (Map)request.getAttribute("startbuttonMap");
	}
	
%>

<!-- /header1 -->
<script type="text/javascript">	
	//画面再表示
	function redisplay1(){
		$("ekey1").value = "";
		$("ekey2").value = "";
		form.action = getAppRootUrl() + "/IGASM0101_ReDisp.do";
		form.submit();
	}
	function redisplay2(){
		$("ekey2").value = "";
		form.action = getAppRootUrl() + "/IGASM0101_ReDisp.do";
		form.submit();
	}
	function redisplay3(){
		form.action = getAppRootUrl() + "/IGASM0101_ReDisp.do";
		form.submit();
	}

	function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="模型基本信息" />';
        var frm = window.document.forms[0];
        if(frm.deleteEid.length > 0){
            var bchecked = false;
            for( i=0; i<frm.deleteEid.length; i++ ){
                if (frm.deleteEid[i].checked == true){
                    bchecked = true;
                }
            }
            if (!bchecked) {
            	alert(message);
                return false;
            }
        } else {
          if ($("deleteEid").checked == false){
              alert(message);
              return false;
          }  
        }

        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGASM0101_Del.do";
            return true;
        } else {
            return false;
        }
	}
	 function setEntity(url){

			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].eparname.value = "";
				document.forms[0].esyscoding_q.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
				var syscode_eid = temp.split("|")[0];
				var name = temp.split("|")[1];
				var syscode;
				var eid;
				if(syscode_eid =="999")
				{
					eid = "";
					syscode = syscode_eid;
					
				}else if(syscode_eid.split("_").length>1){
					eid = syscode_eid.split("_")[0];
					syscode = syscode_eid.split("_")[1];
				}
				document.forms[0].eparname.value = name;
			//	document.forms[0].eparcoding_q.value = syscode;
				document.forms[0].esyscoding_q.value = syscode;
			}		
			
		}
	 function changeStatus(eid,estatus){
			if(confirm("是否改变状态？")){
				var form = document.getElementById("form");
				form.action="changeEntityStatus.do?eid="+eid+"&estatus="+estatus;
				form.submit();
			}
	 }
	 function checkform(){
		 if($F("eparname") == ""){
			 alert("请选择上级模型！");
			 return false;
		 }
		 return true;
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
          <html:form styleId="form" action="/IGASM0101" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
            <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                   <div>
            		<span>模型名称：</span><html:text property="ename" styleId="ename" errorStyleClass="inputError imeDisabled" size="10"/>&nbsp;&nbsp;
					<span class="red">*</span><span>上级模型：</span><html:text property="eparname" styleId="eparname" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
					<img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGSYM1203_ENTITY_TREE.do?levelnode=999&socflag=yes');"/>
					<html:hidden property="esyscoding_q"/>
					<html:submit property="btn_search" onclick="return checkform();" styleClass="button" value="查询" />
                   </div>
                   </div>
                </div>
                
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table class="table_style">
						<!-- header部 -->
						
							<tr>
								<th width="6%">
<!--								<label> <input type="checkbox"-->
<!--									name="checkbox" id="checkbox" /> </label>-->
								序号
								</th>
								<th width="30%">模型名称</th>
								<th width="40%" >模型说明</th>

								<th width="6%">模型状态</th>
								<th width="6%">调整</th>
								<th width="6%">修改</th>
								<th width="6%">详细信息</th>
							</tr>
						
						<!-- body部 -->
						
                            <logic:present name="IGASM01011VO" property="entityDataList">
								<logic:iterate id="bean" name="IGASM01011VO"
									property="entityDataList" indexId="index">
									<bean:define id="entityid" name="bean" property="eid"  toScope="request" />							
									<tr class="<ig:rowcss index="${index}"/>">

											
										<td>
											<div class="nowrapDiv">${PagingDTO.viewStartCount+index}
											</div>
										</td>

										<!-- 名称 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="ename">&nbsp;</logic:empty> ${bean.ename}</div>
										</td>
										<!-- 说明 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="elabel">&nbsp;</logic:empty> ${bean.edesc}</div>
										</td>
										

										<!-- 状态 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="estatus">&nbsp;</logic:empty> <ig:codeValue
											ccid="ENTITY_STATUS_CODE" cid="${bean.estatus}" /></div>
										</td>
										<!-- 调整-->
										<td>
										<logic:notEqual name="bean" property="eparcoding"  value="999">
										<%if(stopbuttonmap.get(entityid).equals("1")){ %>
										<logic:equal name="bean" property="estatus"  value="1">
											<a href="javascript:changeStatus('${bean.eid}',${bean.estatus});"><img src="images/stop.gif" border="0" alt="停用"/></a>
						      			</logic:equal>
						   
										<%}%>      
										<%if(startbuttonmap.get(entityid).equals("1")){ %>
										<logic:equal name="bean" property="estatus"  value="2">
											<a href="javascript:changeStatus('${bean.eid}',${bean.estatus});"><img src="images/start.gif" border="0" alt="启用"/></a>
						      			</logic:equal>
										<%}%> 
										
										</logic:notEqual>

										</td>
										
										<!-- 修改  -->
										<td valign="middle">
										<logic:notEqual name="bean" property="eparcoding"  value="999">
										<div align="center">
										<html:link action="/IGASM0102_Edit_Disp.do?eidStr=${bean.eid}">
											<img src="images/edit.gif" alt="修改" width="16" height="16"
												border="0" />
										</html:link>
										</div>
										</logic:notEqual>
										</td>
										
										<!-- 详细 -->
										<td>
										<div align="center"><html:link
											action="/IGASM0106_Disp.do?eid=${bean.eid}">
											<img src="images/xx.gif" alt="显示详细信息" width="16" height="16"
												border="0" />
										</html:link></div>
										</td>
									</tr>
									
									
								</logic:iterate>
							</logic:present>
					</table>
				</div>
				<div id="operate">
	             <jsp:include page="/include/paging.jsp" />
                </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>