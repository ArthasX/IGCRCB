<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0519" toScope="request"/>
<bean:define id="title" value="餐卡管理画面" toScope="request"/>
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
	
	 function changeStatus(icid,desc){
			if(confirm("是否改变当前餐卡状态？")){
				var form = document.getElementById("form");
				form.action="IGLOM0519_Change.do?icid="+icid+"&desc="+desc;
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
            <html:form styleId="form" action="/IGLOM0519" onsubmit="return checkSubmit(this);">
          	<div id="location">
                <div class="image"></div>
                    <p class="fonts1">后勤管理 &gt;&gt; 食堂管理 &gt;&gt; 餐卡管理</p>
            	</div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
		             	 <label>餐卡名称：</label>
		                 <html:text property="typename" styleId="typename" errorStyleClass="inputError imeDisabled" size="12" /> 
		                 
			             <label>状态：</label>
							<span> 
								<html:select property="status" style="width: 50px;" errorStyleClass="inputError imeActive" >
								<html:options collection="card_status" property="value" name="" labelProperty="label" /></html:select>
							</span>&nbsp;&nbsp;
						<html:submit property="btn_search" value="查询" styleClass="button" />
		     		</div>
          		</div> 
          		
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table width="100%" class="table_style">
			            <!-- header -->
			                <tr>
			                   <th width="10%">序号</th>
					           <th width="30%">餐卡名称</th>
					           <th width="15%">餐券面值</th>
					           <th width="15%">补贴</th>
					           <th width="10%">状态</th>
					           <th width="10%">调整</th>
					           <th width="10%">修改</th>
			                </tr>
			            <!-- body -->			  
			                <logic:present name="IGLOM05181VO" property="lunchCardList" >
			                    <logic:iterate id="bean" name="IGLOM05181VO" property="lunchCardList" indexId="index">
			                        <tr>
			                            <td>${PagingDTO.viewStartCount+index}</td>
										<td><bean:write name="bean" property="typename" /></td>
										<td><bean:write name="bean" property="type" /></td>
										<td><bean:write name="bean" property="typecode" /></td>
			                            <td>
			                            <c:if test="${bean.desc == '0' }">停用</c:if>
			                            <c:if test="${bean.desc == '1' }">启用</c:if>
			                            </td>
			                            <td>
			                            <a href="javascript:changeStatus('${bean.icid}','${bean.desc}');">
			                            <c:if test="${bean.desc == '0' }"><img src="images/start.gif" border="0" alt="启用" /></c:if>
			                            <c:if test="${bean.desc == '1' }"><img src="images/stop.gif" border="0" alt="停用" /></c:if>
			                            </a>
			                            </td>
			                            <td>							
												<html:link action="/IGLOM0519_Edit_Disp.do?icid=${bean.icid}">
													<img src="images/edit.gif" width="16" height="16" border="0"/>
												</html:link>			
										</td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
                   <jsp:include page="/include/paging.jsp"/>
			     </div>

            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>

</div>

</div>
</body>
</html:html>