
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDRM1001" toScope="request"/>
<bean:define id="title" value="角色查询" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
        function setParentValue(roleid){
    		document.forms[0].action = getAppRootUrl() + "/IGDRM1001_EDIT.do?roleid=" + roleid+"&esyscoding="+document.getElementById("syscoding").value;
    		document.forms[0].submit();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParamIGCOM0302("", "", "", "", "", "" ,"");
            }
            window.close();
        }
        function setEntity(url){

        	url = "IGFAP0101_ASSET.do"+"?roletype=IGBP14&subtype=999018";
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
				document.forms[0].esyscoding.value = syscode;
			}		
			
		}
    	function init(sign){
    		if("1" == sign) {
    			window.opener.location.href= getAppRootUrl() + "/IGDRM1002_Reback.do";
    			window.close();
    		}	
    	}
	</script>

<body onload="init(${sign});">
        <html:form styleId="form" action="/IGDRM1001" onsubmit="return checkSubmit(this);">

    <div id="location">
        <div class="image"></div>
            <p class="fonts1">角色查询</p>
    </div>
    
        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
                	<label><span class="red"></span>角色名称：</label> 
                           
                           <html:text property="rolename" styleId="rolename" errorStyleClass="inputError imeActive" readonly="" tabindex="1"/>
			               <html:hidden property="syscoding" styleId="syscoding" value="${IGDRM1002Form.syscoding}" />
                           <html:submit property="btn_search" value="查询" styleClass="button"/>
	             </div>
			</div>
		</div>
		<div id="results_list">
               <!--  message -->
               <ig:message/>
               <!--  /message -->     
	       <table width="26%" class="table_style">
	            <!-- header部 -->
	         
	                <tr>
	                		   <th width="2%"></th>
					           <th width="8%">角色名称</th>
					           <th width="8%">角色类型</th>
					           <th width="8%">角色说明</th>
	                </tr>
	       
	            <!-- body部 -->
	       
	                <logic:present name="IGDRM10022VO" property="rolelist" >
	                    <logic:iterate id="bean" name="IGDRM10022VO" property="rolelist" indexId="index">
	                        <tr  >
                                      <!-- 选择 -->
                                      <td>
                                          <div class="nowrapDiv">
                                             
                                              <img src="images/select_asset.gif" border="0" alt="选择" onclick="javaScript:setParentValue(
                                                  '${bean.roleid}'
                                              );" style="cursor:hand"/>
                                              
                                          </div>
                                      </td>
                                       <td >
			                            	${bean.rolename}
			                            </td>
			                            <td>
				                            <ig:codeValue ccid="ROLE_CATEGORY_CODE" cid="${bean.roletype}" />
			                            </td>
			                            <td>
				                            ${bean.roleinfo}
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
                <div class="enter">
<!--                 	<input type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button"> -->
                    <input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button">
                </div>
	    </div>
    </html:form>
</body>
</html:html>