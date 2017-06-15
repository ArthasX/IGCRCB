<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDRM0506" toScope="request"/>
<bean:define id="title" value="专项预案关系管理详细画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
    var gid='IGDRM0506';
	    function deleteRec(){
	        var message ='<bean:message key="IGCO10000.E002"/>';
	        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="专项预案关系信息" />';
	        var frm = window.document.forms[0];
	        if(frm.deleteEirid){
	        if(frm.deleteEirid.length > 0){
	            var bchecked = false;
	            for( i=0; i<frm.deleteEirid.length; i++ ){
	                if (frm.deleteEirid[i].checked == true){
	                    bchecked = true;
	                }
	            }
	            if (!bchecked) {
	                alert(message);
	                return false;
	            }
	        } else {
	          if ($("deleteEirid").checked == false){
	              alert(message);
	              return false;
	          }  
	        }
	        }else{
		        alert("不存在可以删除的数据！");
		              return false;
		    }
	        if( window.confirm(confirmMsg)){
	            form.action = getAppRootUrl() + "/IGDRM0506_Del.do";
	            return true;
	        } else {
	            return false;
	        }
	    }
	    
	    function toback(){
	        form.action = getAppRootUrl() + "/IGDRM0506.do?btn_back=1";
	        form.submit();
	    }
	    
	    function selectEntityItem(){
			/* if($F('tempeirrelation').trim()==""){
					alert("请选择关联关系！");
					return false;
			} */
       	 	var pareiid = jQ("#pareiid").val();
			openSubIGCOM0302PARAM('?&esyscoding=' + 999060 + '&queryflag='+'flag0507'+'&sp_eiid=' +pareiid);
		}
	    
	    function openSubIGCOM0302PARAM(param){
        	openSubWindow('/IGDRM0702_Disp.do'+param , '', '850', '600');
        }
	    function openSubIGCOM0303(eiid,civersion){
	    	param = $H({sp_eiid: eiid,civersion:civersion}).toQueryString();
	    	openSubWindow('/IGDRM0702_Detail.do?' + param, '_blank', '1050', '600');
	    }
	    function setParamIGCOM0302(eid, elabel, ename, eiid, eilabel, einame, ecategory) {
            $("cldeid").value = eid;
            $("elabel").value = elabel;
            $("cldeiid").value = eiid;
            $("eilabel").value = eilabel;
            $("einame").value = einame;
            
            var url = getAppRootUrl() + "/IGDRM0507.do";
            form.action = url;
            form.submit();
        }
	</script>
	<link rel="stylesheet"
	href="<html:rewrite forward='SpryTabbedPanels.css'/>" type="text/css">
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<style type="text/css">
#entBox th{
	background-color: #EEEEEE;
	border-bottom: 1px solid #ccc;
}
#entBox td{
	border-bottom: 1px solid #d3d3d3;
}
#entBox{
	width: 95%;
	text-align: center;
	padding: 5px;
	margin: 0 auto;
	margin-top: 2px;
}
.entb{
	margin: auto;
	width: 100%;
/* 	border-collapse: collapse; */
/* 	border: 1px solid #f3f3f3; */
}
.entb th{
	width: 15%;
	text-align: right;
/* 	vertical-align: top; */
}
.entb td{
	width: 35%;
/* 	border: 1px solid #f3f3f3; */
	text-align: left;
}
.entb select{
	width: 170px;
}
.entb input{
	margin-left: 5px;
	height: auto;
}
.entb textarea{
	width: 85%;
	height: 100px;
}
</style>
<body >
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
<div id="container">
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">

            <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/>&nbsp;&nbsp;&gt;&gt;&nbsp;&nbsp;关联场景</p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>
            <html:form styleId="form"  action="/IGDRM0506" onsubmit="return checkSubmit(this);">
            	<fieldset>
            		<legend>专项预案基本信息</legend>
	                <div id="entBox">
	                    <table class="entb">
	                        <tr>
	                            <th width=""><label for="Name"><strong>专项预案类型</strong></label></th>
								<td align="center">${IGDRM05061VO.entityData.ename}</td>
		                        <th width=""><label for="Name"><strong>专项预案编号</strong></label></th>
		                        <td align="center">${IGDRM05061VO.entityData.eilabel}</td>
		                    </tr>
		                    <tr>
		                        <th width=""><label for="Name"><strong>专项预案名称</strong></label></th>
		                        <td align="center">${IGDRM05061VO.entityData.einame}</td>
		                        <th width=""><label for="Name"><strong>创建时间</strong></label></th>
		                        <td>${IGDRM05061VO.entityData.eiinsdate}</td>
							</tr>
							<tr>
								<th width=""><label for="Name"><strong>专项预案所属机构</strong></label></th>
		                        <td>${IGDRM05061VO.eiorgname}</td>
	                        </tr>
	                        <tr>
						<th> <label for="Name"><strong>专项预案说明:&nbsp;&nbsp;</strong> </label></th>
							<td >
								${IGDRM05061VO.entityData.eidesc}
							</td>
						</tr>
	                     </table>
	                </div>
                </fieldset>
                
                <logic:present name="IGDRM05061VO" property="flag">
					<logic:equal value="true" name="IGDRM05061VO" property="flag">  
							<logic:present	name="IGDRM05061VO" property="parEntityItemRelationMap">
								<logic:iterate id="map" name="IGDRM05061VO"		property="parEntityItemRelationMap" indexId="number">
					                <fieldset>
					                	<legend>关联场景信息</legend>
					                	<br/>
			           					 <div id="results_list" style="margin:0 auto; width:95%;"> 
											<bean:define id="category" name="map" property="key"/>
											<bean:define id="list" name="map" property="value"	type="java.util.ArrayList" />
												<div class="record_list" style="margin:0px; width:100%;">
													<table class="table_style">
														<tr>
														    <th width="15%"></th>
															<th align="center">场景编号</th>
															<th align="center">场景名称</th>
															<!-- <th width="">关联资产关系</th> -->
															<th width="">登记时间</th>
														</tr>
														<logic:iterate id="bean" name="list" indexId="index">
															<logic:equal name="bean" property="parflag" value="0">
																<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
																<td align="center">
																		<logic:notEqual name="bean" property="eirstatus" value="C">
																		<logic:notEqual name="category" value="012">
										                                <html:checkbox property="deleteEirid" value="${bean.eirid}"/>
										                                </logic:notEqual>
										                                </logic:notEqual>
										                            </td>
																	<!-- 编号 -->
																	<td align="center">
																	<!-- <div class="nowrapDiv"> -->${bean.cldEntityItemVW.eilabel}
																	<!-- </div> -->
																	</td>
																	<!-- 名称 -->
																	<td align="center">
																	<!-- <div class="nowrapDiv"> -->
																	<logic:empty name="bean" property="cldEntityItemVW.einame">&nbsp;</logic:empty> 
																	<html:link 	href="javascript:openSubIGCOM0303('${bean.cldEntityItemVW.eiid}',
										                                                   '${bean.cldversion}');">
										                                                   ${bean.cldEntityItemVW.einame}</html:link>
																	<!-- </div> -->
																	</td>
										                            <!-- 登记时间 -->
										                            <td align="center">
										                                <!-- <div class="nowrapDiv"> -->
										                                <logic:empty name="bean" property="eirupdtime">&nbsp;</logic:empty>
										                               	${bean.eirupdtime}                             
										                                <!-- </div> -->
										                            </td>
																</tr>
															</logic:equal>
														<logic:equal name="bean" property="parflag" value="1">
															<tr onmouseover="mouseOverNoHand(this);" onmouseout="mouseOutNoHand(this);">
																<td align="center">
																	<logic:notEqual name="bean" property="eirstatus" value="C">
																	<logic:notEqual name="category" value="012">
									                                <html:checkbox property="deleteEirid" value="${bean.eirid}"/>
									                                </logic:notEqual>
									                                </logic:notEqual>
									                            </td>
																<!-- 编号 -->
																<td align="center">
																<div class="nowrapDiv">${bean.parEntityItemVW.eilabel}
																</div>
																</td>
																<!-- 名称 -->
																<td align="center">
																<div class="nowrapDiv"><logic:empty name="bean"
																	property="parEntityItemVW.einame">&nbsp;</logic:empty> <html:link
																	href="javascript:openSubIGCOM0303('${bean.parEntityItemVW.eiid}',
									                                                   '${bean.parversion}');">
									                                                   ${bean.parEntityItemVW.einame}</html:link>
																</div>
																</td>
																<!-- 关系 -->
									                            <td align="center">
									                                <div class="nowrapDiv">
									                                <logic:empty name="bean" property="eirrelation">&nbsp;</logic:empty>
									                               <ig:codeValue ccid="ENTITY_ITEM_RELATION_CODE" cid="${bean.eirrelation}"/>                                 
									                                </div>
									                            </td>
									                            <!-- 登记时间 -->
									                            <td align="center">
									                                <div class="nowrapDiv">
									                                <logic:empty name="bean" property="eirupdtime">&nbsp;</logic:empty>
									                               	${bean.eirupdtime}                             
									                                </div>
									                            </td>
																<!-- 说明 -->
																<td align="center">
																<div class="nowrapDiv"><logic:empty name="bean"
																	property="eirdesc">&nbsp;</logic:empty> ${bean.eirdesc}</div>
																</td>
															</tr>
														</logic:equal>
													</logic:iterate>
												</table>
											</div>
										</div>
									</fieldset>
								</logic:iterate>
							</logic:present>
					</logic:equal>   
				</logic:present>                 
	            <div class="enter">
	            <logic:present name="IGDRM05061VO" property="flag">
	            <logic:equal value="true" name="IGDRM05061VO" property="flag">
                     <%-- <html:submit property="btn_add" styleClass="button" value="增加"/> --%>
                     <html:button property="btn_add" onclick="selectEntityItem()" styleClass="button" value="增加"/>
                     <logic:present name="IGDRM05061VO" property="parEntityItemRelationMap" >
                     <html:submit property="btn_delete" styleClass="button" value="删除所选" onclick="return deleteRec();"/>
                     </logic:present>
                </logic:equal>
                </logic:present>
                     <html:submit property="btn_back" styleClass="button" value="返回"/>
	            </div>
                <html:hidden property="pareid" styleId="pareid" value="${IGDRM05061VO.entityData.eid}"/>
                <html:hidden property="pareiid" styleId="pareiid" value="${IGDRM05061VO.entityData.eiid}"/>
                <html:hidden property="pareilabel" styleId="pareilabel" value="${IGDRM05061VO.entityData.eilabel}"/>
                <html:hidden property="pareiname" styleId="pareiname" value="${IGDRM05061VO.entityData.einame}"/>
                <html:hidden property="tempeirrelation" styleId="tempeirrelation" value="01#050-060"/>
                <html:hidden property="eirrelationcode" styleId="eirrelationcode" value="050-060" />
                <html:hidden property="eirrelation" styleId="eirrelation" value="01" />
                <html:hidden property="parversion" styleId="parversion" value="${IGDRM05061VO.entityData.eiversion}" />
				<html:hidden property="parsmallversion" styleId="parsmallversion" value="${IGDRM05061VO.entityData.eismallversion}" />
				<input type="hidden" name="cldeid" id="cldeid"/>
                <input type="hidden" name="elabel" id="elabel"/>
                <input type="hidden" name="cldeiid" id="cldeiid"/>
                <input type="hidden" name="eilabel" id="eilabel"/>
                <input type="hidden" name="einame" id="einame"/>
            </html:form>  
		 </div>
     </div>
</div>


</div>
</body>
</html:html>