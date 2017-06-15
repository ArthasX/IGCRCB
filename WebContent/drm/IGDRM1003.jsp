<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDRM1003" toScope="request"/>
<bean:define id="title" value="数据定义详细画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
jQ(function(){
	var statusVal = jQ("#status").html();
	if(statusVal!=""){
		var jFont1 =jQ(".fonts1");
		jFont1.html(jFont1.html()+"增加");
	}
	if(!jQ("#ccdesc").text()){
		jQ("#ccdesc").text(jQ("#ccname").val());
	}
		
});
    function deleteRec(ccid,cid,cdstatus){
    	if( window.confirm("您是否确认提交？")){
        	$("tempccid").value = ccid;
        	$("tempcid").value = cid;
        	$("cdstatus").value = cdstatus;
            var form = window.document.forms[0];
            if("${orgFlag}"){
    			form.action = getAppRootUrl() + "/IGDRM1001_Del.do?orgFlag=" + "${orgFlag}";
    		} else {
    			form.action = getAppRootUrl() + "/IGDRM1001_Del.do";
    		}
            form.submit();
    	}
    }
    function addRole(ccid,cid,cdstatus,syscoding){
            var form = window.document.forms[0];
            form.action = getAppRootUrl() + "/IGDRM1002_Disp.do?syscoding="+syscoding;
            form.submit();
    }
	function add(){
		if("${orgFlag}"){
			form.action = getAppRootUrl() + "/IGDRM1004_Disp.do?route=1&clevel="+jQuery("#clevel").val()+"&orgFlag=" + "${orgFlag}";
		} else {
			form.action = getAppRootUrl() + "/IGDRM1004_Disp.do?route=1&clevel="+jQuery("#clevel").val();
		}
		form.submit();
	}

	function toback(){
		 var syscoding = "${IGDRM10011VO.codeDetail.psyscoding}";
		 var cid = "${IGDRM10011VO.codeDetail.pcid}";
		 if(syscoding){
			 form.action = getAppRootUrl() + "/IGDRM1001_DISP.do?ccid=230&orgFlag=1&syscoding="+syscoding+"&cid="+cid;
		 }else{
			 var syscode ="${IGDRM10011VO.codeDetail.syscoding}";
			 if(syscode){
				 if(syscode.length==6){
					 form.action = getAppRootUrl() + "/IGDRM1001_DISP.do?ccid=230&clevel=1&orgFlag=1";
				 }
			 }else{
				 
			 form.action = getAppRootUrl() + "/IGDRM1003_Disp.do?orgFlag=1";
			 }
		 }
		form.submit();
	}

    function setCode(url){

		var ccid = document.forms[0].ccid.value;
		var ccname = document.forms[0].ccname.value;
		var cid = document.forms[0].cid.value;
		var syscode = document.forms[0].psyscoding.value;
		if(null==syscode || ""==syscode){
			syscode = ccid;
		}else{
			ccid = syscode.substring(0,3);
		}

		url = url + "?ccid="+ccid+"&cid="+cid+"&syscode="+syscode;
// 		console.log(url);

		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		//alert(temp);
		if(null!=temp && temp.split("|").length>1){
			var id = temp.split("|")[0];
			var name = temp.split("|")[1];
			var treeccid;
			var treecid;
			var treesyscode;
			
			if(id.split("_").length>1){
				treeccid = id.split("_")[0];
				treecid = id.split("_")[1];
				treesyscode = id.split("_")[2];
			}else{
				treeccid = id.split("_")[0];
				treecid = "";
				treesyscode = "";
			}

			if(null!=treecid && ""!=treecid){
				if("${orgFlag}"){
					window.location="IGDRM1001_DISP.do?ccid="+treeccid+"&cid="+treecid+"&orgFlag="+"${orgFlag}";
	    		} else {
	    			window.location="IGDRM1001_DISP.do?ccid="+treeccid+"&cid="+treecid;
	    		}
			}else{
				if("${orgFlag}"){
					window.location="IGDRM1001_DISP.do?ccid="+treeccid+"&clevel=1&orgFlag="+"${orgFlag}";
	    		} else {
					window.location="IGDRM1001_DISP.do?ccid="+treeccid+"&clevel=1";
	    		}
			}
			
		}		
		
	}

    function deleteCode(ccid,cid,cdstatus,syscoding){
    	var alert= '您确认删除该条记录及其子记录吗？';
    	if(window.confirm(alert)){
        	$("tempccid").value = ccid;
        	$("tempcid").value = cid;
        	$("cdstatus").value = cdstatus;
        	$("syscoding").value = syscoding;
        	if("${orgFlag}"){
    			form.action = getAppRootUrl() + "/IGDRM1001_RealDel.do?orgFlag=" + "${orgFlag}";
    		} else {
    			form.action = getAppRootUrl() + "/IGDRM1001_RealDel.do";
    		}
            form.submit();
    	}

    }
</script>
<body>
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/> &gt;&gt; 数据详细信息</p>
                <div class="back"><html:link href="javascript:toback();">返回</html:link></div> 
            </div>
            <html:form styleId="form" action="/IGDRM1001_DISP" onsubmit="return checkSubmit(this);">
             	<html:hidden name="IGDRM1001Form" property="ccid" styleId="ccid" value="${IGDRM10011VO.codeCategoryDefInfo.ccid}"/>
                <html:hidden name="IGDRM1001Form" property="ccname" styleId="ccname" value="${IGDRM10011VO.codeCategoryDefInfo.ccname}"/>
                <bean:define id="cc_name"  value="${IGDRM10011VO.codeCategoryDefInfo.ccname}" toScope="request"></bean:define>
                <html:hidden name="IGDRM1001Form" property="pcid" styleId="pcid" value="${IGDRM10011VO.codeDetail.cid}"/>
                <html:hidden name="IGDRM1001Form" property="cid" styleId="cid" value="${IGDRM10011VO.codeDetail.cid}"/>
                <html:hidden name="IGDRM1001Form" property="pcvalue" styleId="pcvalue" value="${IGDRM10011VO.codeDetail.cvalue}"/>
                <html:hidden name="IGDRM1001Form" property="cdstatus" styleId="cdstatus" value=""/>
                <html:hidden name="IGDRM1001Form" property="tempcid" styleId="tempcid" value=""/>
                <html:hidden name="IGDRM1001Form" property="tempccid" styleId="tempccid" value=""/>
                <html:hidden name="IGDRM1001Form" property="syscoding" styleId="syscoding" value=""/>
                <html:hidden name="IGDRM1001Form" property="clevel" styleId="clevel"/>
                <html:hidden name="IGDRM1001Form" property="psyscoding" styleId="psyscoding" value="${IGDRM10011VO.codeDetail.syscoding}"/>
			    <div class="title">
			        <div class="name">上级数据信息     </div>
			    </div>
			    <div id="results_list" style="width:60%;">
			        <table width="100%" class="table_style">
			            <tr>
<!-- 			                <th width="10%" >快速定位</th> -->
			                <!--  th width="10%" >数据编号</th -->
			                <th width="20%" >内容</th>
			                <th width="20%">更新时间</th>
<!-- 			                <th width="10%" >状态</th> -->
 			            </tr>
			            <tr>
<!-- 			               <td><img src="images/tree.gif" style="cursor: hand;" alt='快速定位'width="16" height="16" border="0" onclick="setCode('IGSYM1505_TREE.do');"/></td> -->
			               <!--  td height="20" align="center">${IGDRM10011VO.codeDetail.businesscode}</td -->
			               <td align="center" id="ccdesc">${IGDRM10011VO.codeDetail.cvalue}</td>
			               <td align="center">${IGDRM10011VO.codeDetail.updtime}</td>
<!-- 			               <td align="center"> -->
<%-- 			                    <ig:codeValue ccid="ENABLED_STATUS_CODE" cid="${IGDRM10011VO.codeDetail.cdstatus}"/>                                 --%>
<!-- 			               </td> -->
			            </tr>
			        </table>
		        </div>
				<div class="title">
				   <div class="name">数据详细信息</div>
				</div>  
                <div id="results_list">
                    <!--  message -->
                    <ig:message/>
                    <!--  /message -->     
			        <table class="table_style">
			            <!-- header部 -->
			                <tr>
                               <th width="5%" >序号</th>
					           <!--  th width="10%" >数据编号</th -->
					           <th width="20%" >内容</th>
<!-- 					           <th width="10%" >状态</th> -->
					           <th width="20%">更新时间</th>
<!-- 					           <th width="15%">增加下级</th> -->
                               <th width="10%">操作</th>
                               <c:if test="${orgFlag==1}">
                               <th width="10%">角色管理</th>
                               </c:if>
                               <th width="10%">删除</th>
			                </tr>
			            <!-- body部 -->
			           
			                <logic:present name="IGDRM10011VO" property="codeDetailList" >
			                <bean:define id="code" value="${IGDRM10011VO.codeDetail.syscoding}"/>
			                <bean:define id="len" value="${IGDRM10011VO.codeCategoryDefInfo.pcflag}"/>
			                    <logic:iterate id="bean" name="IGDRM10011VO" property="codeDetailList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <!-- 序号 -->
                                            <td align="center">
			                               	${index+1}
			                            	</td>
			                            <!-- 数据编号 
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="businesscode">&nbsp;</logic:empty>
                                            ${bean.businesscode}
			                                </div>
			                            </td>
			                            <!-- 内容 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
	                                            <logic:equal name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="1">
                                                <html:link action="/IGDRM1004_Edit_Disp.do?ccid=${bean.ccid}&cid=${bean.cid}&route=1&orgFlag=${orgFlag}">${bean.cvalue}</html:link>
                                                </logic:equal>
                                                <logic:equal name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="2">
                                                ${bean.cvalue}
                                                </logic:equal>
                                                
                                                <logic:equal name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="3">
                                                <html:link action="/IGDRM1004_Edit_Disp.do?ccid=${bean.ccid}&cid=${bean.cid}&route=1&orgFlag=${orgFlag}">${bean.cvalue}</html:link>
                                                </logic:equal>
			                                </div>
			                            </td>
			                            <!-- 状态 -->
<!-- 			                            <td align="center"> -->
<!-- 			                                <div class="nowrapDiv"> -->
<%--                                                   <ig:codeValue ccid="ENABLED_STATUS_CODE" cid="${bean.cdstatus}"/> --%>
<!-- 			                                </div> -->
<!-- 			                            </td> -->
			                            <!-- 更新时间 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="updtime">&nbsp;</logic:empty>
			                                ${bean.updtime}                           
			                                </div>
			                            </td>
			                            <!-- 增加下级 -->
<!--                                         <td> -->
<%--                                         	<logic:equal name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="1"> --%>
<%-- 	                                        	<logic:equal name="bean" property="cdstatus" value="1"> --%>
<!-- 	                                            <div align="center"> -->
<%-- 	                                            <%if((code.length()-3)/2<Integer.parseInt(len)-1){%> --%>
<%-- 	                                                <html:link action="/IGDRM1001_DISP.do?ccid=${bean.ccid}&cid=${bean.cid}&orgFlag=${orgFlag}&syscoding=${bean.syscoding}"><img src="images/addinfo.gif" alt='增加下级' width="16" height="16"  border="0"/></html:link> --%>
<%-- 	                                            <%} %> --%>
<!-- 	                                            </div> -->
<%-- 	                                            </logic:equal> --%>
<%--                                             </logic:equal> --%>
<%--                                             <logic:notEqual name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="1"> --%>
<%--                                             	<logic:equal name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="3"> --%>
<%--                                             		<logic:equal name="bean" property="cdstatus" value="1"> --%>
<!-- 		                                            <div align="center"> -->
<%-- 		                                            <%if((code.length()-3)/2<Integer.parseInt(len)-1){%> --%>
<%-- 		                                                <html:link action="/IGDRM1001_DISP.do?ccid=${bean.ccid}&cid=${bean.cid}&orgFlag=${orgFlag}&syscoding=${bean.syscoding}"><img src="images/addinfo.gif" alt='增加下级' width="16" height="16"  border="0"/></html:link> --%>
<%-- 		                                            <%} %> --%>
<!-- 		                                            </div> -->
<%-- 		                                            </logic:equal> --%>
<%--                                             	</logic:equal> --%>
                                            	
<%--                                             	<logic:notEqual name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="3"> --%>
<!--                                             		 <div align="center"> -->
<%-- 		                                            <%if((code.length()-3)/2<Integer.parseInt(len)-1){%> --%>
<%-- 		                                                <html:link action="/IGDRM1001_DISP.do?ccid=${bean.ccid}&cid=${bean.cid}&orgFlag=${orgFlag}&syscoding=${bean.syscoding}"><img src="images/addinfo.gif" alt='增加下级' width="16" height="16"  border="0"/></html:link> --%>
<%-- 		                                            <%} %> --%>
<!-- 		                                            </div> -->
                                            		
<%--                                             	</logic:notEqual> --%>

<%--                                             </logic:notEqual> --%>
<!--                                         </td> -->
			                            <!-- 操作 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
                                                <logic:equal name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="1">
                                                    <html:link href="javascript:deleteRec('${bean.ccid}','${bean.cid}','${bean.cdstatus}');">
                                                    <logic:equal name="bean" property="cdstatus" value="1">
                                                    <img src="images/stop.gif" alt='停用' width="16" height="16"  border="0"/>
                                                    </logic:equal>
                                                    <logic:equal name="bean" property="cdstatus" value="0">
                                                    <img src="images/start.gif" alt='启用'  width="16" height="16"  border="0"/>
                                                    </logic:equal>
                                                    </html:link>
                                                </logic:equal>
                                                
                                                <logic:notEqual name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="1">
						                        	 <logic:equal name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="3">
							                            <html:link href="javascript:deleteRec('${bean.ccid}','${bean.cid}','${bean.cdstatus}');">
	                                                    <logic:equal name="bean" property="cdstatus" value="1">
	                                                    <img src="images/stop.gif" alt='停用' width="16" height="16"  border="0"/>
	                                                    </logic:equal>
	                                                    <logic:equal name="bean" property="cdstatus" value="0">
	                                                    <img src="images/start.gif" alt='启用'  width="16" height="16"  border="0"/>
	                                                    </logic:equal>
	                                                    </html:link>
						                       		</logic:equal>
	                       						</logic:notEqual>
			                                </div>
			                            </td>
			                            <c:if test="${orgFlag==1}">
			                            <td>
			                            	<div class="nowrapDiv">
                                                <logic:equal name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="1">
                                                    <html:link href="javascript:addRole('${bean.ccid}','${bean.cid}','${bean.cdstatus}','${bean.syscoding}');">
														<img src="images/sq.gif" alt='角色管理'  width="16" height="16"  border="0"/>
                                                    </html:link>
                                                </logic:equal>
                                                
                                                <logic:notEqual name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="1">
						                        	 <logic:equal name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="3">
							                            <html:link href="javascript:addRole('${bean.ccid}','${bean.cid}','${bean.cdstatus}','${bean.syscoding}');">
							                            	<img src="images/sq.gif" alt='角色管理'  width="16" height="16"  border="0"/>
	                                                    </html:link>
						                       		</logic:equal>
	                       						</logic:notEqual>
			                                </div>
			                            </td>
                             		    </c:if>
			                            
			                            <td>
			                            	<html:link href="javascript:deleteCode('${bean.ccid}','${bean.cid}','${bean.cdstatus}','${bean.syscoding}');"><img src="images/delete.gif" alt='删除'  width="16" height="16"  border="0"/></html:link>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
	                </table>
		        </div>

                <div id="operate">
			        <div class="content">
			            <div class="enter">
                            <logic:equal name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="1">
	                             <bean:define id="code" value="${IGDRM10011VO.codeDetail.syscoding}"/>
				                <bean:define id="len" value="${IGDRM10011VO.codeCategoryDefInfo.pcflag}"/>
	                             <%if((code.length()-3)/3<Integer.parseInt(len)){%>
		                        <html:submit property="btn_add"  styleClass="button" onclick="return add();" >
		                        	增加
		                        </html:submit>
		                        <%}%>
	                        </logic:equal>
	                        <logic:notEqual name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="1">
	                        	 <logic:equal name="IGDRM10011VO" property="codeCategoryDefInfo.cceditable" value="3">
		                             <bean:define id="code" value="${IGDRM10011VO.codeDetail.syscoding}"/>
					                <bean:define id="len" value="${IGDRM10011VO.codeCategoryDefInfo.pcflag}"/>
		                             <%if((code.length()-3)/3<Integer.parseInt(len)){%>
			                        <html:submit property="btn_add"  styleClass="button" onclick="return add();" >
			                        	增加
			                        </html:submit>
			                        <%}%>
	                       		</logic:equal>
	                        </logic:notEqual>
	                       
	                        <html:submit property="btn_back" styleClass="button"  onclick="javascript:toback();">
	                        	返回
	                        </html:submit>
			            </div>
			        </div> 
    		    </div>
               
		    </html:form>
        </div>
    </div>
</div>


</div>
</body>
</html:html>