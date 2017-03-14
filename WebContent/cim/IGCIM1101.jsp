<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCIM1101" toScope="request"/>
<bean:define id="title" value="业务系统配置导出" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	 	function exportDetailInfo(eiid){
			location.href="IGAIM0148.do?EIID="+eiid;
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
            <html:form styleId="form" action="/IGCIM1101"
             onsubmit="return checkSubmit(this);">

            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">
						<ig:navigation extname1="${urlable}"/> 
                    </p>
            </div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
			                <label>业务系统名称：</label><html:text property="einame" styleId="einame" errorStyleClass="inputError imeDisabled" size="10" />&nbsp;&nbsp; 
		         			<html:submit property="btn_search" value="查询" styleClass="button"/>
                          </div>
		     </div>
          </div>
                               
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table class="table_style">
			            <!-- header部 -->
			      
			                <tr>
					           <th width="13%">业务系统编号</th>
					           <th width="20%">业务系统名称</th>
					           <th width="20%">业务系统描述</th>
					           <th width="9%">登记人</th>
					           <th width="8%">登记时间</th>
					           <th width="8%">配置导出</th>
			                </tr>
			            <!-- body部 -->
			         
			                <logic:present name="IGCIM11011VO" property="entityDataList" >
			                    <logic:iterate id="bean" name="IGCIM11011VO" property="entityDataList" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>">
			                            <!-- 编号 -->
			                            <td>
			                                <div class="nowrapDiv">
                                                ${bean.eilabel}
			                                </div>
			                            </td>
			                            <!-- 名称 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.einame}
			                                </div>
			                            </td>
			                            <!-- 说明 -->
			                            <td>
			                                <div class="nowrapDiv">
			                                ${bean.eidesc}
			                                </div>
			                            </td>
			                            <!-- 管理人 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.eiusername}
                                            </div>
			                            </td>
			                            <!-- 登记日 -->
			                            <td>
                                            <div class="nowrapDiv">
                                            ${bean.eiinsdate}
                                            </div>
			                            </td>
			                            <!-- 详细信息 -->
			                            <td>
			                                <div align="center">
                                                <html:link action="/IGCIM1102_Disp.do?eiid=${bean.eiid}"><img src="images/excel.gif" alt='<bean:message bundle="asmResources" key="img.IGCIM0121.ConfigImport.alt"/>' width="16" height="16"  border="0"/></html:link>
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
                <html:hidden property="ecategory" styleId="ecategory" value="${IGCIM1101Form.ecategory}"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>