<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0103" toScope="request"/>
<bean:define id="title" value="接待工作管理画面" toScope="request"/>
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
            form.action = getAppRootUrl() + "/IGLOM0103_Delete.do";
            return true;
        } else {
            return false;
        }
	}
	
    function setRoleDomain(url){
		url = url+"?roletype=IGAC01";
		var temp = window.showModalDialog(url,null,"dialogWidth:400px;dialogHeight:500px;status:no;help:no;resizable:yes");
		if("_resetall"==temp){
			document.forms[0].rapporgid_q.value = "";
			document.forms[0].rapporgname.value = "";
			return false;
		}
		if(null!=temp && temp.split("|").length>1){
			document.forms[0].rapporgid_q.value = temp.split("|")[0];
			document.forms[0].rapporgname.value = temp.split("|")[1];
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
				form.action="IGLOM0103_Change.do?rid="+rid+"&rstatus="+rstatus;
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
            <html:form styleId="form" action="/IGLOM0103" onsubmit="return checkSubmit(this);">
          	<div id="location">
                <div class="image"></div>
                    <p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 接待工作管理</p>
            	</div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
			             <label>申请部门：</label>
			             <html:text property="rapporgname" readonly="true" size="16"></html:text>
						 <img src="images/tree.gif" style="cursor: hand;" alt="选择申请部门" width="16" height="16" border="0" onclick="setRoleDomain('IGSYM0101_TREE.do');"/>
						 <html:hidden property="rapporgid_q"/>&nbsp;&nbsp; 
						
						 <label>状态：</label>
							<span> 
								<html:select property="rstatus_q" style="width: 50px;" errorStyleClass="inputError imeActive" >
								<html:options collection="recption_status" property="value" name="" labelProperty="label" /></html:select>
							</span>&nbsp;&nbsp;
						
		                 <label>开始日期：从</label>
		                 <html:text property="rtime_from" styleId="rtime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
		                 <img src="images/date.gif" align="middle" onClick="calendar($('rtime_from'))" border="0" />&nbsp;&nbsp;
		                 <label>到</label>
		                 <html:text property="rtime_to" styleId="rtime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                     <img src="images/date.gif" align="middle" onClick="calendar($('rtime_to'))" border="0"/>&nbsp;&nbsp;
			        	 
			             
						<br>
		                 <label>结束日期：从</label>
		                 <html:text property="retime_from" styleId="retime_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
		                 <img src="images/date.gif" align="middle" onClick="calendar($('retime_from'))" border="0" />&nbsp;&nbsp;
		                 <label>到</label>
		                 <html:text property="retime_to" styleId="retime_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                     <img src="images/date.gif" align="middle" onClick="calendar($('retime_to'))" border="0"/>&nbsp;&nbsp;
				         
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
					           <th width="13%">接待工作名称</th>
					           <th width="15%">申请部门</th>
					           <th width="10%">接待规模</th>
					           <th width="10%">接待标准</th>
					           <th width="12%">开始日期</th>
					           <th width="10%">结束日期</th>
					           <th width="10%">费用总额</th>
					           <th width="5%">状态</th>
					           <th width="15%">详细信息</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGLOM01031VO" property="recptionAmountList" >
			                    <logic:iterate id="bean" name="IGLOM01031VO" property="recptionAmountList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
			                            <c:if test="${bean.rstatus == '1' }">
				                            <html:checkbox property="deleteRid" value="${bean.rid}"/>
				                        </c:if>
			                            </td>
			                            <!-- 接待工作名称 -->
			                            <td>
			                                <div class="nowrapDiv">
                                              <html:link action="/IGLOM0101_Edit_Disp.do?rid=${bean.rid}&rstatus=${bean.rstatus}">${bean.rname}</html:link>
			                                </div>
			                            </td>
			                            <!-- 申请机构 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.rapporgname}</div>
			                            </td>
			                            <!-- 接待人数规模 -->
			                            <td>
			                                <div class="nowrapDiv"><ig:cseCodeValue codeIndex="<%=CodeUtils.RECPTION_RSCALE%>" codeValue="${bean.rscale}" /></div>
			                            </td>
			                            <!-- 接待标准 -->
			                            <td>
			                                <div class="nowrapDiv"><ig:cseCodeValue codeIndex="<%=CodeUtils.RECPTION_RSTANDARD%>" codeValue="${bean.rstandard}" /></div>
			                            </td>
			                            <!-- 开始日期 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.rstime}</div>
			                            </td>
			                            <!-- 结束日期 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.retime}</div>
			                            </td>
			                              <!-- 费用总额 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.amount}</div>
			                            </td>
			                            <!-- 状态  进行中:1   结束:2 -->
			                            <td><a href="javascript:changeStatus('${bean.rid}','${bean.rstatus}');"><c:if test="${bean.rstatus == '1' }"><img src="images/stop.gif" border="0" alt="结束" /></c:if></a><c:if test="${bean.rstatus == '2' }"><div class="nowrapDiv"><ig:cseCodeValue codeIndex="<%=CodeUtils.RECPTION_STATUS%>" codeValue="${bean.rstatus}" /></div></c:if></td>
			                            <td><div align="center"><!-- 详细信息 --><html:link action="/IGLOM0104_Disp.do?rid=${bean.rid}"><img src="images/xx.gif" alt="显示详细信息" width="16" height="16"  border="0"/></html:link>&nbsp;<!-- 食堂信息 --><html:link action="/IGLOM0580.do?rid_mon=${bean.rid}&rstatus=${bean.rstatus}"><img src="images/eatery.gif" alt="显示食堂信息" width="16" height="16"  border="0"/></html:link>&nbsp;<!-- 物品信息 --><html:link action="/IGLOM0260_Disp.do?rid=${bean.rid}&rstatus=${bean.rstatus}&goorg=${bean.orgsyscoding}&lomid=lom0103"><img src="images/stock.gif" alt="显示物品信息" width="16" height="16"  border="0"/></html:link></div></td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
                            <logic:present name="IGLOM01031VO" property="recptionAmountList" >
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