<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ page import="com.csebank.lom.util.CodeUtils"%>
<html:html>
<bean:define id="id" value="IGLOM0104" toScope="request"/>
<bean:define id="title" value="接待客人管理画面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	WebCalendar.timeShow   = false  ;        //是否返回时间

	function deleteRec(){
        var message ='<bean:message key="IGCO10000.E002"/>';
        var confirmMsg ='<bean:message key="IGCO10000.W002" arg0="接待客人信息" />';
        var frm = window.document.forms[0];
        if(frm.deleteRgid) {
	        if(frm.deleteRgid.length > 0){
	            var bchecked = false;
	            for( i=0; i<frm.deleteRgid.length; i++ ){
	                if (frm.deleteRgid[i].checked == true){
	                    bchecked = true;
	                }
	            }
	            if (!bchecked) {
	            	alert(message);
	                return false;
	            }
	        } else {
	          if ($("deleteRgid").checked == false){
	              alert(message);
	              return false;
	          }  
	        }
        } else {
        	alert("没有可删除的数据！");
            return false;
        }

        if( window.confirm(confirmMsg)){
            form.action = getAppRootUrl() + "/IGLOM0104_Delete.do";
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
<div id="container"> 
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
            <html:form styleId="form" action="/IGLOM0104_Disp" onsubmit="return checkSubmit(this);">
          	<div id="location">
                <div class="image"></div>
                    <p class="fonts1">后勤管理 &gt;&gt; 接待管理 &gt;&gt; 
                    <logic:equal name="IGLOM0104Form" property="flag" value="">
                    	接待工作管理
                    </logic:equal>
                    <logic:equal name="IGLOM0104Form" property="flag" value="1">
                    	接待月度汇总 &gt;&gt; 接待工作明细
                    </logic:equal>
                    <logic:equal name="IGLOM0104Form" property="flag" value="2">
                    	接待客人查询
                    </logic:equal>
                    <logic:equal name="IGLOM0104Form" property="flag" value="3">
                    	部门接待汇总 &gt;&gt; 接待工作明细 
                    </logic:equal>
                    &gt;&gt; 详细信息</p>
             
                    <logic:equal name="IGLOM0104Form" property="flag" value="">
                		<div class="back"><html:link action="/IGLOM0103_Back.do">返回</html:link></div> 
                    </logic:equal>
                    <logic:equal name="IGLOM0104Form" property="flag" value="1">
                    	<div class="back"><html:link action="/IGLOM0111_Back.do">返回</html:link></div> 
                    </logic:equal>
                     <logic:equal name="IGLOM0104Form" property="flag" value="2">
                		<div class="back"><html:link action="/IGLOM0114_Back.do">返回</html:link></div> 
                    </logic:equal>
                     <logic:equal name="IGLOM0104Form" property="flag" value="3">
                		<div class="back"><html:link action="/IGLOM0113_Back.do">返回</html:link></div> 
                    </logic:equal>

            </div>

			    <div class="title">
			        <div class="name">基本信息</div>
			    </div>
			    <div id="results_list">
			        <table width="100%" class="table_style">
			            <tr>
			                <th width="15%" >接待工作名称</th>
			                <th width="15%" >申请部门</th>
			                <th width="13%" >开始日期</th>
			                <th width="13%" >结束日期</th>
			                <th width="8%" >住宿标准</th>
			                <th width="9%" >住宿费用</th>
			                <th width="12%" >其他参与部门</th>
			                <th width="15%" >内容描述</th>
			            </tr>
			            <tr>
			               <td align="center">${IGLOM01041VO.recptionData.rname}</td>
			               <td align="center">${IGLOM01041VO.recptionData.organizationTB.orgname}</td>
			               <td align="center">${IGLOM01041VO.recptionData.rstime}</td>
			               <td align="center">${IGLOM01041VO.recptionData.retime}</td>
			               <td align="center"><ig:cseCodeValue codeIndex="<%=CodeUtils.LODGE_STANDARD%>" codeValue="${IGLOM01041VO.recptionData.rlodgestandard}" /></td>
			               <td align="center">${IGLOM01041VO.recptionData.rlodgecost}</td>
			               <td align="center">${IGLOM01041VO.recptionData.rpporg}</td>
			               <td align="center">${IGLOM01041VO.recptionData.rdescription}</td>
			             
			            </tr>
			        </table>
		        </div>
				<div class="title">
				   <div class="name">客人信息</div>
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
					           <th width="15%">接待客人姓名</th>
					           <th width="15%">职务</th>
					           <th width="15%">联系方式</th>
					           <th width="30%">单位</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGLOM01041VO" property="recptionGuestList" >
			                    <logic:iterate id="bean" name="IGLOM01041VO" property="recptionGuestList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <td>
			                            	<logic:equal name="IGLOM0104Form" property="flag" value="">
												<c:if test="${IGLOM01041VO.recptionData.rstatus == '1'}">
					                            	<html:checkbox property="deleteRgid" value="${bean.rgid}"/>
												</c:if>
											</logic:equal>
			                            </td>
			                            <!-- 客人姓名 -->
			                            <td>
			                                <div class="nowrapDiv">
                                              <html:link action="/IGLOM0102_Edit_Disp.do?rgid=${bean.rgid}">${bean.rgname}</html:link>
			                                </div>
			                            </td>
			                            <!-- 职务 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.rgpost}</div>
			                            </td>
			                            <!-- 联系方式 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.rgtel}</div>
			                            </td>
			                            <!-- 单位 -->
			                            <td>
                                            <div class="nowrapDiv">${bean.rgunit}</div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			       </table>
			     </div>
			     <div id="operate">
			     	
                    <logic:equal name="IGLOM0104Form" property="flag" value="">
						<c:if test="${IGLOM01041VO.recptionData.rstatus == '1'}">
                            <logic:present name="IGLOM01041VO" property="recptionGuestList" >
													
							<input type="button" class="button" value="增加"  onclick="window.location='IGLOM0102_Disp.do?rid=${IGLOM01041VO.recptionData.rid}';" />      
                            <html:submit property="btn_delete" value="删除所选" styleClass="button" onclick="return deleteRec();" />
                            </logic:present>
						</c:if>
					</logic:equal>	
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>
		        <html:hidden property="rid" styleId="rid" name="IGLOM0104Form"/>
		        <html:hidden property="flag" styleId="flag" name="IGLOM0104Form"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>

</div>

</div>
</body>
</html:html>