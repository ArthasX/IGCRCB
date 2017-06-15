<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html:html>
<bean:define id="id" value="IGCIM0911" toScope="request"/>
<bean:define id="title"  toScope="request">
	网络设备端口查询
</bean:define>
<jsp:include page="/include/header1.jsp"/>
<script type="text/javascript">
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
<html:form styleId="form" action="/IGCIM0911" >
<div id="location">
    <div class="image"></div>
    <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
</div>
<div id="search">
        <div class="img"></div>
        <div class="conditions">
                   <div class="conditions_border1">
            <label>&nbsp;&nbsp;端口名称:</label>
            <html:text property="eilabel_lk_devname" styleId="eilabel_lk_devname" errorStyleClass="inputError imeDisabled" size="30" />
            <label>&nbsp;&nbsp;设备IP地址:</label>
            <html:text property="eilabel_lk_ip" styleId="eilabel_lk_ip" errorStyleClass="inputError imeDisabled" size="30" />
            <label>&nbsp;&nbsp;端口状态:</label>
            <select name="civalue_eq" id="civalue_eq" >
   				<option value=""></option>
   				<option value="UP">UP</option> 
   				<option value="DOWN">DOWN</option>
  			</select>
                 <html:submit property="btn_search" styleClass="button">
                 		<bean:message bundle="asmResources" key="button.IGCIM0101.btn_search"/>
                 </html:submit>
                 </div>
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
					           <th width="10%">序号</th>
					           <th width="25%">设备IP地址</th>
					           <th width="25%">端口名称</th>
					           <th width="20%">端口状态</th>
					           <th width="20%">更新时间</th>
			                </tr>
			            <!-- body部 -->			  
			                <logic:present name="IGCIM09111VO" property="netDeviceList" >
			                    <logic:iterate id="bean" name="IGCIM09111VO" property="netDeviceList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <!-- 序号 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${PagingDTO.viewStartCount+index}
			                                </div>
			                            </td>
			                            <!-- IP地址 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${fn:substringBefore(bean.eilabel, "_")}
			                                </div>
			                            </td>
			                            <!-- 端口名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${fn:substringAfter(bean.eilabel, "_")}
			                                </div>
			                            </td>
			                            <!-- 设备状态 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.civalue}
			                                </div>
			                            </td>
			                            <!-- 更新时间 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.eiupdtime}
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
			    </div>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>

</div>
</body>
</html:html>