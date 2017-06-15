<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html:html>
<bean:define id="id" value="IGDRM0203" toScope="request"/>
<bean:define id="title" value="添加场景" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<style>
	.nowrapDiv{
/* 		margin-left: 0px; */
		text-align:center;
	}
</style>
<body>
	<div id="location">
                <div class="image"></div>
                  <p class="fonts1" id = "navi">选择场景 </p>
     </div> 
<div id="maincontent" style="width:800px;margin: 0 auto;">
        <html:form styleId="form" action="/IGDRM0201_Search">
    
     <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
                	&nbsp;&nbsp;
	                <label >场景名称：</label>
	                <input name="ename" id="ename" value="${IGDRM0201Form.ename}" class="imeDisabled" size="35"/> 
	             	<html:button property="btn_search"  styleClass="button" value="查询" onclick="selectFlow()"></html:button>
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
                        <th width="3%">
                        <label> <input type="checkbox" name="checkbox" id="checkbox" onclick="selectAll('checkbox','addEiids')"/>
                        </label>
                        </th> 
<!--                         <th width="15%" class = "tdname">分类</th> -->
                        <th width="15%" class = "tdname" >编号</th>
                        <th width="15%" class = "tdname">名称</th>
                        <th width="10%">管理人</th>
	                </tr>
	       
	            <!-- body部 -->
	       
	                <logic:present name="IGDRM02011VO" property="entityItemVWInfoList" >
	                    <logic:iterate id="bean" name="IGDRM02011VO" property="entityItemVWInfoList" indexId="index">
	                        <tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" >
                                      <!-- 选择 -->
                                      <td>
                                      <label>
                                      <input type="checkbox" name="addEiids" value="${bean.eiid}"/>
									  </label>
                                      </td>
                                      <!-- 名称 -->
<!--                                       <td> -->
<!--                                           <div class="nowrapDiv"> -->
<%--                                           <logic:empty name="bean" property="ename">&nbsp;</logic:empty> --%>
<%--                                           ${bean.ename} --%>
<!--                                           </div> -->
<!--                                       </td> -->
	                            <!-- 编号 -->
	                            <td>
	                                <div class="nowrapDiv" >
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
	                            <!-- 管理人 -->
	                            <td>
	                                <div class="nowrapDiv">
	                                <logic:empty name="bean" property="eiusername">&nbsp;</logic:empty>
	                                ${bean.eiusername}
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
                <div class="enter">
                	<input type="button" name="btn_save" value="添加所选" class="button" onclick="sceneADD()">
                    <input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button">
                </div>
	    </div>
	    <html:hidden name="IGDRM0201Form" property="esyscoding" styleId="esyscoding"/>
	    <input type="hidden" name="eiids" value="${eiids}" id="eiids"/>
    </html:form>


</div>
<script type="text/javascript">
//全选
function selectAll(name,obj) { 
	var checks = document.getElementsByName(obj);
	if(document.getElementById(name).checked){
		for(var i=0;i < checks.length;i++) 
		{ 
			checks[i].checked = true; 
		} 
	}else{
		for(var i=0;i < checks.length;i++) 
		{ 
			checks[i].checked = false; 
		} 
	}
}

function selectFlow(eiidStr){
	var ename = document.getElementById("ename").value;
	var eiids = document.getElementById("eiids").value;
// 	document.forms[0].action = getAppRootUrl() + "/IGDRM0201_Search.do?eiids="+eiids+"&ename="+ename;  
	document.forms[0].submit();
}
//添加场景的Ajax
function sceneADD(){
	var res;
	var addEiid  = [];
	var items = jQ('[name = "addEiids"]:checkbox:checked');
	for (var i = 0; i < items.length; i++) {
		addEiid.push(items.get(i).value);  
	}
	jQuery.ajax({
		url:getAppRootUrl()+"/IGDRM0201_ADD.do",
		data:{addEiids:addEiid},
		async: false, 
		cache:false,
		dataType:"text",
		success:function(data){
				try{
					res = data;
					window.opener.returnAddFlowXml(res);
				} catch(err){
					alert("error");
				}
		}
	});
	window.close();
}
</script>
</body>
</html:html>