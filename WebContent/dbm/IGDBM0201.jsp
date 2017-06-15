<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDBM0201" toScope="request" />
<bean:define id="title" value="全网IP过滤" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">
	var gid='IGDBM0201';
	function validateForm(){
		var message1 = '<bean:message key="IGCO10000.W001" arg0="IP地址" />';
		var myReg = /^(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9])\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[1-9]|0)\.(25[0-5]|2[0-4][0-9]|[0-1]{1}[0-9]{2}|[1-9]{1}[0-9]{1}|[0-9])$/;
		if($F('ip').trim() == ""){
    		alert("请输入IP地址！");
    		return false;
    	}
		if(!myReg.test($F('ip'))) {
			alert("IP地址格式不正确！");
    		return false;
	 	}
		if($F('ip').trim() == "255.255.255.255"){
		 	alert("IP地址格式不正确");
		 	return false;
	 	}
		 if(window.confirm(message1)){
		 	//Ajax判断添加是否重复
		 	var isRepeat = "";
		 	var objAjax = new Ajax.Request(getAppRootUrl() + ajaxAction,{asynchronous:false, method:'POST',
				parameters: 'type=isRepeatIP&ip='+$F('ip'),
				onSuccess:  function(req, json){
				 var result=req.responseText;
					if(result != null && result != ""){
						isRepeat = result;
				   	}	
			    }
			});
			if(isRepeat == "0"){
				alert("该IP地址已存在！");
				return false;
			}
           	return true;
         } else {
             return false;
         }
	}
	function deleteIpFilter(delId){
		var message1 = '<bean:message key="IGCO10000.W002" arg0="IP地址" />';
		if(window.confirm(message1)){
			var form = document.getElementById("IGDBM0201Form");
			form.action="IGDBM0201_Del.do?delId=" + delId;
			form.submit();
			form.action="IGDBM0201";
		}
	}
	function batchDelete(){
       var message ='请选择删除对象！';
       var confirmMsg ='请确认是否要进行IP过滤信息删除处理?';
       var obj = document.getElementsByTagName("INPUT");
       var bchecked = false;
       for(var i=0; i<obj.length; i++ ){
           if (obj[i].checked && obj[i].name == 'deleteID'){
               bchecked = true;
           }
       }
       if (!bchecked) {
       	alert(message);
           return false;
       }

       if( window.confirm(confirmMsg)){
           $('IGDBM0201Form').action = getAppRootUrl() + "/IGDBM0201_BatchDEL.do";
           $('IGDBM0201Form').submit();
           return true;
       } else {
           return false;
       }
	}
</script>
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<!--container 左菜单 右侧内容-->
	<div id="container">  <!--content  右侧内容-->
	    <div id="contentWrap">
	        <div id="content">
	        <div id="location">
	                <div class="image"></div>
	                <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
                     </div>
          <div id="results_list">
         	<html:form styleId="IGDBM0201Form" action="/IGDBM0201" onsubmit="return checkSubmit(this);">
                <fieldset>
		            <legend>新增IP地址</legend>
			            <div>
			                <label for="Name"><strong><span class="red">*</span>IP地址</strong>：</label>
			                <html:text name="IGDBM0201Form" property="ip" styleId="ip" size="18" style="width:300px;" tabindex="1"/>
			                <html:submit property="btn_insert" value="新增"  style="height:20px;" styleClass="button" onclick="return validateForm();"/>
			            </div>
	            </fieldset>
	            <!--  message --> <ig:message /> <!--  /message --> 
	 		         <table  class="table_style" >
			            <!-- header部 -->
			                <tr>
			                   <th width="5%"><input id="allbox" type="checkbox" onclick="selectAll('allbox','deleteID')" /></th>
					           <th width="10%">编号</th>
					           <th width="30%">IP地址</th>
                               <th width="30%">添加时间</th>
                               <th width="15%">删除</th>
			                </tr>
			            <!-- body部 -->
			                <logic:present name="IGDBM02011VO" property="ipFilterInfoList" >
			                    <logic:iterate id="bean" name="IGDBM02011VO" property="ipFilterInfoList" indexId="index">
			                        <tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');">
			                            <td>
			                              &nbsp;<input type="checkbox" name="deleteID" value="${bean.id}" />
			                            </td>
			                            <td>
			                                ${index+1}
			                            </td>
			                            <!-- IP地址 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="ip">&nbsp;</logic:empty>
			                                ${bean.ip}
			                                </div>
			                            </td>
                                        <!-- 添加时间 -->
                                        <td>
                                            <div class="nowrapDiv">
                                            <logic:empty name="bean" property="addtime">&nbsp;</logic:empty>
                                            ${bean.addtime}
                                            </div>
                                        </td>
                                        <!-- 删除 -->
                                        <td>
                                            <div class="nowrapDiv">
                                           		<html:link href="javascript:deleteIpFilter('${bean.id}');">
                                                    <img src="images/delete.gif" alt="删除" width="16" height="16"  border="0"/>
                                                </html:link>
                                            </div>
                                        </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
 			       </table>
				   </html:form>
				   <logic:present name="IGDBM02011VO" property="ipFilterInfoList" >
                   	<input type="button" value="批量删除" class="button" style="width: 80px;height: 20px;" onclick="return batchDelete()" />
	               </logic:present>
		       </div>
	        </div>
		</div>
		<div class="zishiying"></div>
	</div>
</div>
</body>
</html:html>
