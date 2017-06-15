<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGSYM1106" toScope="request"/>
<bean:define id="title" value="数据详细画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
<script type="text/javascript">	
    function deleteRec(ccid,cid,cdstatus){
    	if( window.confirm("您是否确认提交？")){
        	$("tempccid").value = ccid;
        	$("tempcid").value = cid;
        	$("cdstatus").value = cdstatus;
            var form = window.document.forms[0];
            form.action = getAppRootUrl() + "/IGSYM1106_Del.do";
            form.submit();
    	}
    }

    function add(){
        form.action = getAppRootUrl() + "/IGSYM1104_Disp.do?route=1&clevel="+$("clevel").value;
        form.submit();
    }

    function toback(){
    	form.action = getAppRootUrl() + "/IGSYM1101_Disp.do";
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
		//alert(url);

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
				window.location="IGSYM1106_Disp.do?ccid="+treeccid+"&cid="+treecid;
			}else{
				window.location="IGSYM1106_Disp.do?ccid="+treeccid+"&clevel=1";
			}
			
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
                <div class="back"><html:link href="javascript:toback();">分类列表</html:link></div> 
            </div>

            <html:form styleId="form" action="/IGSYM1106" onsubmit="return checkSubmit(this);">
             	<html:hidden name="IGSYM1106Form" property="ccid" styleId="ccid" value="${IGSYM11061VO.codeCategoryInfo.ccid}"/>
                <html:hidden name="IGSYM1106Form" property="ccname" styleId="ccname" value="${IGSYM11061VO.codeCategoryInfo.ccname}"/>
                <bean:define id="cc_name"  value="${IGSYM11061VO.codeCategoryInfo.ccname}" toScope="request"></bean:define>
                <html:hidden name="IGSYM1106Form" property="pcid" styleId="pcid" value="${IGSYM11061VO.codeDetail.cid}"/>
                <html:hidden name="IGSYM1106Form" property="cid" styleId="cid" value="${IGSYM11061VO.codeDetail.cid}"/>
                <html:hidden name="IGSYM1106Form" property="pcvalue" styleId="pcvalue" value="${IGSYM11061VO.codeDetail.cvalue}"/>
                <html:hidden name="IGSYM1106Form" property="cdstatus" styleId="cdstatus" value=""/>
                <html:hidden name="IGSYM1106Form" property="tempcid" styleId="tempcid" value=""/>
                <html:hidden name="IGSYM1106Form" property="tempccid" styleId="tempccid" value=""/>
                <html:hidden name="IGSYM1106Form" property="clevel" styleId="clevel"/>
                <html:hidden name="IGSYM1106Form" property="psyscoding" styleId="psyscoding" value="${IGSYM11061VO.codeDetail.syscoding}"/>
			    <div class="title">
			        <div class="name">上级数据信息     </div>
			    </div>
			    <div id="results_list" style="width:60%;">
			        <table width="100%" class="table_style">
			            <tr>
			            	<th width="10%" >快速定位</th>
			                <th width="10%" >数据编号</th>
			                <th width="20%" >内容</th>
			                <th width="20%">更新时间</th>
			                <th width="10%" >状态</th>
 			            </tr>
			            <tr>
			               <td><img src="images/tree.gif" style="cursor: hand;" alt="快速定位" width="16" height="16" border="0" onclick="setCode('IGSYM1201_TREE.do');"/></td>
			               <td height="20" align="center">${IGSYM11061VO.codeDetail.businesscode}</td>
			               <td align="center">${IGSYM11061VO.codeDetail.cvalue}</td>
			               <td align="center">${IGSYM11061VO.codeDetail.updtime}</td>
			               <td align="center">
			                    <ig:codeValue ccid="ENABLED_STATUS_CODE" cid="${IGSYM11061VO.codeDetail.cdstatus}"/>                                
			               </td>
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
					           <th width="10%" >数据编号</th>
					           <th width="20%" >内容</th>
					           <th width="10%" >状态</th>
					           <th width="20%">更新时间</th>
					           <logic:notEqual name="IGSYM11061VO" property="codeCategoryInfo.ccid" value="274">
					           <th width="15%">增加下级</th>
                               </logic:notEqual>
                               <th width="15%">操作</th>
			                </tr>
			            <!-- body部 -->
			           
			                <logic:present name="IGSYM11061VO" property="codeDetailList" >
			                <bean:define id="code" value="${IGSYM11061VO.codeDetail.syscoding}"/>
			                <bean:define id="len" value="${IGSYM11061VO.codeCategoryInfo.pcflag}"/>
			                    <logic:iterate id="bean" name="IGSYM11061VO" property="codeDetailList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <!-- 序号 -->
                                            <td align="center">
			                               	${index+1}
			                            	</td>
			                            <!-- 数据编号 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="businesscode">&nbsp;</logic:empty>
                                            ${bean.businesscode}
			                                </div>
			                            </td>
			                            <!-- 内容 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
	                                            <logic:equal name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="1">
                                                <html:link action="/IGSYM1104_Edit_Disp.do?ccid=${bean.ccid}&cid=${bean.cid}&route=1">${bean.cvalue}</html:link>
                                                </logic:equal>
                                                <logic:equal name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="2">
                                                ${bean.cvalue}
                                                </logic:equal>
                                                
                                                <logic:equal name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="3">
                                                <html:link action="/IGSYM1104_Edit_Disp.do?ccid=${bean.ccid}&cid=${bean.cid}&route=1">${bean.cvalue}</html:link>
                                                </logic:equal>
			                                </div>
			                            </td>
			                            <!-- 状态 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
                                                  <ig:codeValue ccid="ENABLED_STATUS_CODE" cid="${bean.cdstatus}"/>
			                                </div>
			                            </td>
			                            <!-- 更新时间 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
			                                <logic:empty name="bean" property="updtime">&nbsp;</logic:empty>
			                                ${bean.updtime}                           
			                                </div>
			                            </td>
			                            <!-- 增加下级 -->
			                            <logic:notEqual name="IGSYM11061VO" property="codeCategoryInfo.ccid" value="274">
                                        <td>
                                        	<logic:equal name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="1">
	                                        	<logic:equal name="bean" property="cdstatus" value="1">
	                                            <div align="center">
	                                            <%if((code.length()-3)/3<Integer.parseInt(len)-1){%>
	                                                <html:link action="/IGSYM1106_Disp.do?ccid=${bean.ccid}&cid=${bean.cid}"><img src="images/addinfo.gif" alt="增加下级" width="16" height="16"  border="0"/></html:link>
	                                            <%} %>
	                                            </div>
	                                            </logic:equal>
                                            </logic:equal>
                                            <logic:notEqual name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="1">
                                            	<logic:equal name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="3">
                                            		<logic:equal name="bean" property="cdstatus" value="1">
		                                            <div align="center">
		                                            <%if((code.length()-3)/3<Integer.parseInt(len)-1){%>
		                                                <html:link action="/IGSYM1106_Disp.do?ccid=${bean.ccid}&cid=${bean.cid}"><img src="images/addinfo.gif" alt="增加下级" width="16" height="16"  border="0"/></html:link>
		                                            <%} %>
		                                            </div>
		                                            </logic:equal>
                                            	</logic:equal>
                                            	
                                            	<logic:notEqual name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="3">
                                            		 <div align="center">
		                                            <%if((code.length()-3)/3<Integer.parseInt(len)-1){%>
		                                                <html:link action="/IGSYM1106_Disp.do?ccid=${bean.ccid}&cid=${bean.cid}"><img src="images/addinfo.gif" alt="增加下级" width="16" height="16"  border="0"/></html:link>
		                                            <%} %>
		                                            </div>
                                            		
                                            	</logic:notEqual>

                                            </logic:notEqual>
                                        </td>
			                            </logic:notEqual>
			                            <!-- 操作 -->
			                            <td align="center">
			                                <div class="nowrapDiv">
                                                <logic:equal name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="1">
                                                    <html:link href="javascript:deleteRec('${bean.ccid}','${bean.cid}','${bean.cdstatus}');">
                                                    <logic:equal name="bean" property="cdstatus" value="1">
                                                    <img src="images/stop.gif" alt="停用" width="16" height="16"  border="0"/>
                                                    </logic:equal>
                                                    <logic:equal name="bean" property="cdstatus" value="0">
                                                    <img src="images/start.gif" alt="启用" width="16" height="16"  border="0"/>
                                                    </logic:equal>
                                                    </html:link>
                                                </logic:equal>
                                                
                                                <logic:notEqual name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="1">
						                        	 <logic:equal name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="3">
							                            <html:link href="javascript:deleteRec('${bean.ccid}','${bean.cid}','${bean.cdstatus}');">
	                                                    <logic:equal name="bean" property="cdstatus" value="1">
	                                                    <img src="images/stop.gif" alt="停用" width="16" height="16"  border="0"/>
	                                                    </logic:equal>
	                                                    <logic:equal name="bean" property="cdstatus" value="0">
	                                                    <img src="images/start.gif" alt="启用" width="16" height="16"  border="0"/>
	                                                    </logic:equal>
	                                                    </html:link>
						                       		</logic:equal>
	                       						</logic:notEqual>
			                                </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
	                </table>
		        </div>

                <div id="operate">
			        <div class="content">
			            <div class="enter">
                            <logic:equal name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="1">
	                             <bean:define id="code" value="${IGSYM11061VO.codeDetail.syscoding}"/>
				                <bean:define id="len" value="${IGSYM11061VO.codeCategoryInfo.pcflag}"/>
	                             <%if((code.length()-3)/3<Integer.parseInt(len)){%>
		                        <html:submit property="btn_add" value="增加" styleClass="button" onclick="return add();" />
		                        <%}%>
	                        </logic:equal>
	                        <logic:notEqual name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="1">
	                        	 <logic:equal name="IGSYM11061VO" property="codeCategoryInfo.cceditable" value="3">
		                             <bean:define id="code" value="${IGSYM11061VO.codeDetail.syscoding}"/>
					                <bean:define id="len" value="${IGSYM11061VO.codeCategoryInfo.pcflag}"/>
		                             <%if((code.length()-3)/3<Integer.parseInt(len)){%>
			                        <html:submit property="btn_add" value="增加" styleClass="button" onclick="return add();" />
			                        <%}%>
	                       		</logic:equal>
	                        </logic:notEqual>
	                       
	                        <html:submit property="btn_back" styleClass="button" value="返回"/>
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