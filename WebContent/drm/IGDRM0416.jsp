<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDRM0416" toScope="request"/>
<bean:define id="title" value="分类配置详细画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
    function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="分类配置信息" />';
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
        form.action = getAppRootUrl() + "/IGDRM0414_Disp.do?route=1";
        form.submit();
    }

    function toback(){
    	form.action = getAppRootUrl() + "/IGDRM0416.do?btn_back=1";
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
			form.action="changeConfigStatus.do?cid="+cid+"&cstatus="+cstatus+"&eid="+eid;
			form.submit();
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
            <html:form styleId="form" action="/IGDRM0416" onsubmit="return checkSubmit(this);">
           <div id="location">
                <div class="image"></div>
                <p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 详细信息</p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>

			    <div class="title">
			        <div class="name">基本信息</div>
			    </div>
			    <div id="results_list">
			        <table width="100%" class="table_style">
			            <tr>
			                <th width="30%" >分类名称</th>
			                <th width="40%" >分类说明</th>
			                <th width="30%" >分类状态</th>
			            </tr>
			            <tr>
			               <td align="center">${IGDRM04121VO.entityData.ename}</td>
			               <td align="center">${IGDRM04121VO.entityData.edesc}</td>
			               <td align="center">
			                  
			                    <ig:codeValue ccid="EMERGENCY_ENTITY_STATUS_CODE" cid="${IGDRM04121VO.entityData.estatus}"/>                                
			                    
			               </td>
			             
			            </tr>
			        </table>
		        </div>
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
			                   <th width="8%"></th>
			                   <th width="7%">序号</th>
					           <th width="20%" align="left">配置项名称</th>
					           <th width="25%" align="left">配置项说明</th>
					           <th width="10%" align="left">配置项单位</th>
					           <th width="10%">配置项状态</th>
					           <th width="10%">配置项类别</th>
					           <th width="5%">调整</th>
					           <th width="5%">修改</th>
			                </tr>
			            <!-- body部 -->
			           <logic:present name="IGDRM04161VO" property="configurationMap">
						<bean:define id="countMap" name="IGDRM04161VO" property="configurationMap" type="java.util.Map" />
			           			<logic:iterate id="map" name="IGDRM04161VO" property="configurationMap" indexId="num">
						           <bean:define id="list" name="map" property="value" type="java.util.ArrayList" />
						           <bean:define id="name" name="map" property="key"/>
						          
						           <tr class="ParentEntityTR">
						           <td colspan="10" align="left"><img src="images/ee.gif" border="0"/>&nbsp;&nbsp;<bean:write name="map" property="key"/></td>           
						           </tr>
						           
			                    <logic:iterate id="bean" name="list" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                        	 <td align="center">
			                        	 </td>
			                            <td align="center">
			                              	<%=index+1 %>
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
			                            <!-- 状态 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="cstatus">&nbsp;</logic:empty>
			                                <ig:codeValue ccid="CONFIGURATION_STATUS_CODE" cid="${bean.cstatus}"/>                              
			                                </div>
			                            </td>
			                            
			                            <!-- 类别 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="ccategory">&nbsp;</logic:empty>
			                                <ig:codeValue ccid="CONFIGURATION_CATEGORY_CODE" cid="${bean.ccategory}"/>                              
			                                </div>
			                            </td>
	                                    <!-- 调整-->
										<td>
										<%if(num==countMap.size()-1){ %>
										<logic:empty name="bean" property="clabel">
										<logic:equal name="bean" property="cstatus"  value="1">
											<a href="javascript:changeStatus('${bean.cid}','${bean.cstatus}');"><img src="images/stop.gif" border="0" alt="停用"/></a>
						      			</logic:equal>

										<logic:equal name="bean" property="cstatus"  value="2">
											<a href="javascript:changeStatus('${bean.cid}','${bean.cstatus}');"><img src="images/start.gif" border="0" alt="启用"/></a>
						      			</logic:equal>
										</logic:empty>
										</td>
			                             <%} %>
	                                    <!-- 修改  -->
										<td>
										<%if(num==countMap.size()-1){ %>
										<div align="center">
										<logic:empty name="bean" property="clabel">
										<html:link action="/IGDRM0414_Edit_Disp.do?cidStr=${bean.cid}&route=1">
											<img src="images/edit.gif" alt="修改" width="16" height="16"
												border="0" />
										</html:link>
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
			                <!-- /paging -->
	                        <html:submit property="btn_back" styleClass="button" value="返回"/>
			            </div>
    		    </div>
                <html:hidden property="eid" styleId="eid" value="${IGDRM04121VO.entityData.eid}"/>
		    </html:form>
        </div>
    </div>
</div>


</div>
</body>
</html:html>