<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<html:html>
<bean:define id="id" value="IGDRM0411" toScope="request" />
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
		form.action = getAppRootUrl() + "/IGDRM0411_ReDisp.do";
		form.submit();
	}
	function redisplay2(){
		$("ekey2").value = "";
		form.action = getAppRootUrl() + "/IGDRM0411_ReDisp.do";
		form.submit();
	}
	function redisplay3(){
		form.action = getAppRootUrl() + "/IGDRM0411_ReDisp.do";
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
            form.action = getAppRootUrl() + "/IGDRM0411_Del.do";
            return true;
        } else {
            return false;
        }
	}
	  function setEntity(url){

			var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
			if("_resetall"==temp){
				document.forms[0].eparname.value = "";
				document.forms[0].eparcoding.value = "";
// 				document.forms[0].ecategory.value = "";
				return false;
			}
			if(null!=temp && temp.split("|").length>1){
// 				document.forms[0].eidStr.value = temp.split("|")[0];
// 				document.forms[0].eid.value = temp.split("|")[0];
				document.forms[0].eparname.value = temp.split("|")[1];
				document.forms[0].eparcoding.value = temp.split("|")[2];
			
			}		
			
		}
	 function changeStatus(eid,estatus){
			var flag ;
	    	jQ.ajax({
				url:getAppRootUrl()+"/IGDRM0402_Ajax.do?erid="+eid,
				type:"POST",
				dataType:"text",
				async:false,
				success:function(result){
					flag = result;
				}
			});
	    	if(flag == 'true'){
	    		alert("当前模型下已经关联资产，请先解除关联！");
	    	}else{
			if(confirm("是否改变状态？")){
				var form = document.getElementById("form");
				form.action="changeEntityStatus.do?eid="+eid+"&estatus="+estatus;
				form.submit();
			}
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
          <html:form styleId="form" action="/IGDRM0411" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
            </div>
            <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                   <div>
            		<span>模型名称：</span><html:text property="ename" styleId="ename" errorStyleClass="inputError imeDisabled" size="10"/>&nbsp;&nbsp;
					<span>上级模型：</span><html:text property="eparname" styleId="eparname" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
					<img src="images/tree.gif" style="cursor: hand;" alt="资产模型" width="16" height="16" border="0" onclick="setEntity('IGDRM0412_Tree.do?esyscoding=allTree');"/>
					<html:hidden property="eparcoding" styleId="eparcoding"/>
					<html:submit property="btn_search" styleClass="button" value="查询" />
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
								<th width="10%" align="center">模型名称</th>
								<th width="10%" align="center">对应资产分类</th>
								<th width="30%"  align="center">模型说明</th>

								<th width="6%">模型状态</th>
<!-- 								<th width="6%"  align="center">状态</th> -->
								<th width="6%"  align="center">状态</th>
								
								<th width="6%"  align="center">修改</th>
<!-- 								<th width="6%"  align="center">删除</th> -->
							</tr>
						
						<!-- body部 -->
						
                            <logic:present name="IGDRM04111VO" property="erEntityList">
								<logic:iterate id="bean" name="IGDRM04111VO"
									property="erEntityList" indexId="index">
									<bean:define id="entityid" name="bean" property="erid"  toScope="request" />							
									<tr class="<ig:rowcss index="${index}"/>">

											
										<td>
											<div class="nowrapDiv">${PagingDTO.viewStartCount+index}
											</div>
										</td>
										<!-- 名称 -->
										<td align="left">
										<div class="nowrapDiv"><logic:empty name="bean"
											property="ername">&nbsp;</logic:empty> ${bean.ername}</div>
										</td>
										<!-- 对应资产分类 -->
										<td align="left">
										<div class="nowrapDiv">
										<logic:empty name="bean" property="esyscoding">&nbsp;</logic:empty>
										<logic:notEmpty name="bean" property="esyscoding">
										
										<ig:GetModelNameByEid eid='${fn:split(bean.esyscoding,"_")[1]}' id='${fn:split(bean.esyscoding,"_")[0]}'/>
										</logic:notEmpty>
											
										</div>
										</td>
										<!-- 说明 -->
										<td align="left">
										<div class="nowrapDiv"><logic:empty name="bean"
											property="erdesc">&nbsp;</logic:empty> ${bean.erdesc}</div>
										</td>
										

 										<!--状态 -->
										<td>
											<div class="nowrapDiv">
											<logic:notEmpty name="bean" property="erparcode">
											<c:if test="${bean.erstatus == '1'}">已启用</c:if>
											<c:if test="${bean.erstatus != '1'}">已停用</c:if>
											</logic:notEmpty>
											</div>
										</td>
										<!-- 调整-->
										<td align="center">
											<logic:notEmpty name="bean" property="erparcode">
										<logic:equal name="bean" property="erstatus"  value="1">
											<a href="javascript:changeStatus('${bean.erid}',${bean.erstatus});"><img src="images/stop.gif" border="0" alt="停用"/></a>
						      			</logic:equal>
						   
										<logic:notEqual name="bean" property="erstatus"  value="1">
											<a href="javascript:changeStatus('${bean.erid}',${bean.erstatus});"><img src="images/start.gif" border="0" alt="启用"/></a>
						      			</logic:notEqual>
										</logic:notEmpty>
										<!-- 修改  -->
										<td align="center">
										<logic:notEmpty name="bean" property="erparcode">
										<div align="center">
										<html:link action="/IGDRM0412_Edit_Disp.do?eidStr=${bean.erid}">
											<img src="images/edit.gif" alt="修改" width="16" height="16"
												border="0" />
										</html:link>
										</div>
										</logic:notEmpty>
										</td>
<!-- 										<td align="center"> -->
<%-- 										<logic:notEmpty name="bean" property="erparcode"> --%>
<!-- 										<div align="center"> -->
<%-- 											<img src="images/delete.gif" alt="删除" width="16" height="16" border="0" onclick="deleteEM(${bean.erid})" /> --%>
<!-- 										</div> -->
<%-- 										</logic:notEmpty> --%>
<!-- 										</td> -->
										
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