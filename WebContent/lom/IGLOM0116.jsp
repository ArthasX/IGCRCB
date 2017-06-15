<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0116" toScope="request"/>
<bean:define id="title" value="外出就餐管理画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间

	function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="接待工作信息" />';
        var frm = window.document.forms[0];
        if(frm.deleteRid) {
	        if(frm.deleteRid.length > 0){
	            var bchecked = false;
	            for( i=0; i<frm.deleteRid.length; i++ ){
	                if (frm.deleteRid[i].checked == true){
		                
	                    bchecked = true;
	                }
	            }
	            if (!bchecked) {
	            	alert(message);
	                return false;
	            }
	        } else {
	          if ($("deleteRid").checked == false){
	              alert(message);
	              return false;
	          }  
	        }
        } else {
        	alert("没有可删除的数据！");
            return false;
        }
        
        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGLOM0107_Delete.do";
            return true;
        } else {
            return false;
        }
	}
	
    function setRoleDomain(url){
		url = url+"?roletype=IGAC01";
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].rapporgid.value = "";
			document.forms[0].deptName.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].rapporgid.value = temp.split("|")[0];
			document.forms[0].deptName.value = temp.split("|")[1];
		}		

	}

	function checkSearch(){
		if(!checkDateByContent("rtime_from","rtime_to")){
			alert("开始日期开始不能晚于结束日期！");
			return false;
		}else{
			return true;
		}
		if(!checkDateByContent("retime_from","retime_to")){
			alert("结束日期开始不能晚于结束日期！");
			return false;
		}else{
			return true;
		}

	}
	
	 function changeStatus(rid,rstatus){
			if(confirm("是否结束当前接待工作？")){
				var form = document.getElementById("form");
				form.action="IGLOM0107_Change.do?rid="+rid+"&rstatus="+rstatus;
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
            <html:form styleId="form" action="/IGLOM0107" onsubmit="return checkSubmit(this);">
          	<div id="location">
                <div class="image"></div>
                    <p class="fonts1">后勤管理 &gt;&gt; 就餐管理 &gt;&gt; 外出就餐管理</p>
            	</div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
			             <label>申请部门：</label>
			             <html:text property="deptName" readonly="true" size="16"></html:text>
						 <img src="images/tree.gif" style="cursor: hand;" alt="选择申请部门" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0101_TREE.do');"/>
						 <html:hidden property="rapporgid"/>&nbsp;&nbsp; 
						
		                 <label>日期：从</label>
		                 <html:text property="rtime_from" styleId="rtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
		                 <img src="images/date.gif" align="middle" onClick="calendar($('rtime_from'))" border="0" />&nbsp;&nbsp;
		                 <label>到</label>
		                 <html:text property="rtime_to" styleId="rtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                     <img src="images/date.gif" align="middle" onClick="calendar($('rtime_to'))" border="0"/>

			        	 <html:submit property="btn_search" value="查询" styleClass="button" onclick="return checkSearch();"/>
		     		</div>
          		</div> 
          		
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header部 -->
			                <tr>
					           <th width="5%">
					             <label>
					             </label>
					           </th>
					           <th width="18%">申请部门名称</th>
					           <th width="10%">申请时间</th>
					           <th width="7%">就餐人数</th>
					           <th width="10%">就餐金额</th>
					           <th width="10%">发票编号</th>
					           <th width="10%">其他参与者</th>
					           <th width="20%">描述信息</th>
					        
					           <th width="10%">物品信息</th>
			                </tr>
			           <logic:present name="IGLOM01031VO" property="dealList" >
			           
			                    <logic:iterate id="bean" name="IGLOM01031VO" property="dealList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
			                            <c:if test="${bean.rstatus == '1' }">
				                            <html:checkbox property="deleteRid" value="${bean.rid}"/>
				                        </c:if>
			                            </td>
			                           
			                           
			                            <!-- 申请机构 -->
			                            <td>
                                           
                                            
                                            <html:link action="/IGLOM0115_Edit_Disp.do?rid=${bean.rid}&rstatus=${bean.rstatus}">${bean.deptName}</html:link>
			                            </td>
			                             <td>
			                                <div class="nowrapDiv">${bean.dealTime}</div>
			                            </td>
			                           <td>
			                                <div class="nowrapDiv"><ig:cseCodeValue codeIndex="<%=CodeUtils.RECPTION_RSCALE%>" codeValue="${bean.dealScale}" /></div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">${bean.dealCash}</div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">${bean.invoiceNumber}</div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">${bean.otherJoiner}</div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">${bean.dealDesc}</div>
			                            </td>
			                         
                                        <!-- 物品信息 -->
			                            <td><div align="center"><html:link action="/IGLOM0260_Disp.do?rid=${bean.rid}&rstatus=${bean.rstatus}&goorg=${bean.rapporgid}&lomid=lom0107"><img src="images/stock.gif" alt="显示物品信息" width="16" height="16"  border="0"/></html:link></div></td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
                            <logic:present name="IGLOM01031VO" property="dealList" >
                            <html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec();" />
                            </logic:present>
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>

            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>

</div>

</div>
</body>
</html:html>