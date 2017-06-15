<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM0406" toScope="request"/>
<bean:define id="title" value="模型配置详细画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
    function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="模型配置信息" />';
        var frm = window.document.forms[0];
        if(frm.deleteCid.length > 0){
            var bchecked = false;
            for( i=0; i<frm.deleteCid.length; i++ ){
                if (frm.deleteCid[i].checked == true){
                    bchecked = true;
                }
            }
            if (!bchecked) {
                alert(message);
                return false;
            }
        } else {
          if ($("deleteCid").checked == false){
              alert(message);
              return false;
          }  
        }
        if( window.confirm(confirmMsg)){
            return true;
        } else {
            return false;
        }
    }

    function add(){
        var url = "/IGAIM0404_Disp.do?route=1";
        openSubWindow(url, '_blank', '600', '400');	
    	//form.action = getAppRootUrl() + "/IGAIM0404_Disp.do?route=1";
        //form.submit();
    }

    function toback(){
    	form.action = getAppRootUrl() + "/IGAIM0406.do?btn_back=1";
    	form.submit();
    }
    function changeStatus(cid,cstatus){
		if(confirm("是否改变状态？")){
			var eid = document.forms[0].eid.value;
			var form = document.getElementById("form");
			//alert("cid="+cid);
			//alert("cstatus="+cstatus);
			//alert("eid="+eid);

			//return false;
			form.action="IGAIM0406_ChangeConfigStatus.do?cid="+cid+"&cstatus="+cstatus+"&eid="+eid;
			form.submit();
		}
 	}
    function changeEntityStatus(eid,estatus){
		if(confirm("是否改变状态？")){
			var form = document.getElementById("form");
			form.action="IGAIM0406_ChangeEntityStatus.do?eid="+eid+"&estatus="+estatus;
			form.submit();
		}
 	}

 	function modify(eid){
 		var url = "/IGAIM0402_Edit_Disp.do?eidStr="+eid;
		//var temp = window.showModalDialog(url,null,"dialogWidth:600px;dialogHeight:400px;status:no;help:no;resizable:yes");
		openSubWindow(url, '_blank', '600', '400');	
 	}

 	function modifyCI(cid,route){
		var url = "/IGAIM0404_Edit_Disp.do?cidStr="+cid+"&route="+route;
		openSubWindow(url, '_blank', '600', '400');	
 	}
</script>
<body >
<div id="maincontent">
<div >
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <html:form styleId="form" action="/IGAIM0406_Disp" onsubmit="return checkSubmit(this);">

			    <div class="title">
			        <div class="name">基本信息</div>
			    </div>
			    <div id="results_list">
			        <table width="100%" class="table_style">
			            <tr>
			            	<th width="17%" >模型编码</th>
			                <th width="17%" >模型名称</th>
			                <th width="17%" >模型说明</th>
			                <th width="17%" >模型状态</th>
			                <th width="16%">模型修改</th>
			                <th width="16%">模型导出</th>
			            </tr>
			            <tr height="36">
			           	   <td align="center">${IGCIM04021VO.entityData.eid}</td>
			               <td align="center">${IGCIM04021VO.entityData.ename}</td>
			               <td align="center">${IGCIM04021VO.entityData.edesc}</td>
			               <td align="center">
			               		<bean:define id="bean" name="IGCIM04021VO" property="entityData" toScope="request" />
										<logic:empty name="bean" property="elabel">
										<logic:notEqual name="bean" property="eparcoding"  value="999">
											<logic:equal name="IGCIM04021VO" property="stopFlag" value="1">
												<logic:equal name="bean" property="estatus"  value="1">
													<a href="javascript:changeEntityStatus('${bean.eid}',${bean.estatus});"><img src="images/start.gif" border="0" alt="停用"/></a>
						      					</logic:equal>
						   					</logic:equal>
						   					<logic:equal name="IGCIM04021VO" property="startFlag" value="1">
												<logic:equal name="bean" property="estatus"  value="2">
													<a href="javascript:changeEntityStatus('${bean.eid}',${bean.estatus});"><img src="images/stop.gif" border="0" alt="启用"/></a>
						      					</logic:equal>
						      				</logic:equal>
										
										</logic:notEqual>
										</logic:empty>
			               </td>
			               <td valign="middle">
			               		
										<logic:empty name="bean" property="elabel">
										<logic:notEqual name="bean" property="eparcoding"  value="999">
										<div align="center">
											<img src="images/edit.gif" alt="修改" width="16" height="16"
												border="0" onclick="modify('${IGCIM04021VO.entityData.eid}');"/>
										</div>
										</logic:notEqual>
										</logic:empty>
										</td>
			               <td valign="middle">
										<div align="center">
										<html:link action="/IGASM0112_Export.do?esyscoding=${IGCIM04021VO.entityData.esyscoding}">
											<img src="images/excel.gif" alt="生成模板" width="16" height="16"
												border="0" />
										</html:link>
										</div>

						  </td>
			             
			            </tr>
			        </table>
		        </div>
		        <br/>
				<div class="title">
				   <div class="name">配置项信息（按层次关系显示）</div>
				</div>  
                <div id="results_list">
                    <!--  message -->
                    <ig:message/>
                    <!--  /message -->     
			        <table class="table_style">
			            <!-- header部 -->
			                <tr>
			                   <th width="11%"></th>
			                   <th width="15%" align="left">序号</th>
					           <th width="17%" align="left">名称</th>
					           <th width="24%" align="left">说明</th>
					           <th width="10%" align="left">单位</th>
					           <!-- <th width="10%">配置项状态</th> -->
					           <th width="10%">类别</th>
					           <th width="7%">状态</th>
					           <th width="6%">修改</th>
			                </tr>
			            <!-- body部 -->
			           <logic:present name="IGCIM04061VO" property="configurationMap">
						<bean:define id="countMap" name="IGCIM04061VO" property="configurationMap" type="java.util.Map" />
			           			<logic:iterate id="map" name="IGCIM04061VO" property="configurationMap" indexId="num">
						           <bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
						           <bean:define id="name" name="map" property="key"/>
						          
						           <tr class="ParentEntityTR">
						           <td colspan="10" align="left"><img src="images/ee.gif" border="0"/>&nbsp;&nbsp;<bean:write name="map" property="key"/></td>           
						           </tr>
						           
			                    <logic:iterate id="bean" name="list" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                        	 <td align="center">
			                        	 </td>
			                            <td align="left">
			                              	${bean.cid }
			                            </td>
	
			                            <!-- 名称 -->
			                            <td align="left">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="cname">&nbsp;</logic:empty>
			                                ${bean.cname}
			                                </div>
			                            </td>
			                            <!-- 说明 -->
			                            <td align="left">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="cdesc">&nbsp;</logic:empty>
			                                ${bean.cdesc}
			                                </div>
			                            </td>
			                            <!-- 单位 -->
			                            <td align="left">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="cunit">&nbsp;</logic:empty>
			                                <ig:codeValue ccid="CONFIGURATION_UNIT_CODE" cid="${bean.cunit}"/>                              
			                                </div>
			                            </td>
			                            <!-- 状态 
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="cstatus">&nbsp;</logic:empty>
			                                <ig:codeValue ccid="CONFIGURATION_STATUS_CODE" cid="${bean.cstatus}"/>                              
			                                </div>
			                            </td>
			                              --> 
			                            
			                            <!-- 类别 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="ccategory">&nbsp;</logic:empty>
			                                <ig:codeValue ccid="CONFIGURATION_CATEGORY_CODE" cid="${bean.ccategory}"/>                              
			                                </div>
			                            </td>
	                                    <!-- 状态（调整）-->
										<td>
										<%if(num==countMap.size()-1){ %>
										<logic:empty name="bean" property="clabel">
										<logic:equal name="bean" property="cstatus"  value="1">
											<a href="javascript:changeStatus('${bean.cid}','${bean.cstatus}');"><img src="images/start.gif" border="0" alt="停用"/></a>
						      			</logic:equal>

										<logic:equal name="bean" property="cstatus"  value="2">
											<a href="javascript:changeStatus('${bean.cid}','${bean.cstatus}');"><img src="images/stop.gif" border="0" alt="启用"/></a>
						      			</logic:equal>
										</logic:empty>
										</td>
			                             <%} %>
			                             
	                                    <!-- 修改  -->
										<td>
										<%if(num==countMap.size()-1){ %>
										<div align="center">
										<logic:empty name="bean" property="clabel">
										<!--<html:link action="/IGAIM0404_Edit_Disp.do?cidStr=${bean.cid}&route=1">-->
										<img src="images/edit.gif" alt="修改" width="16" height="16"
												border="0" onclick="modifyCI('${bean.cid}','1');"/>
										<!--</html:link>-->
										</logic:empty>
										</div>
										<%} %>
										</td>
			                        </tr>
			                   		 </logic:iterate>
			                    </logic:iterate>
			                </logic:present>
	                </table>
		        </div>

                <div id="operate">
			            <div class="enter">
	                        <html:submit property="btn_add" value="增加" styleClass="button" onclick="return add();" />
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			            </div>
    		    </div>
                <html:hidden property="eid" styleId="eid" value="${IGCIM04021VO.entityData.eid}"/>
		    </html:form>
        </div>
    </div>
</div>


</div>
</body>
</html:html>