<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGDUT0104" toScope="request"/>
<bean:define id="title" value="检查项查询" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
        var gid='IGDUT0104';

        function setParentValue(dadid,dadname){
            if(!window.opener.closed){
                window.opener.setParams(dadid, dadname);
             }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParams("", "");
             }
            window.close();
        }
	</script>

<body onload="startCheckOpenerClosed();">
<div id="maincontent">
<div id="container">
        <html:form styleId="form" action="/IGDUT0104" onsubmit="return checkSubmit(this);">

    <div id="location">
        <div class="image"></div>
            <p class="fonts1">检查项查询</p>
    </div>
    
        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
                    <span>&nbsp;&nbsp;检查分类：</span>
                    <span><html:select property="dadtype">
                    		<ig:optionsCollection ccid="DUTY_TYPE" isMakeBlankRow="true" isCodeLabel="true" type="${IGDUT0104Form.dadcategory}"/>
                    	  </html:select>
                    </span>
            		<span>&nbsp;&nbsp;&nbsp;&nbsp;检查名称：</span><html:text property="dadname" styleId="dadname" errorStyleClass="inputError imeDisabled" size="18"/>&nbsp;&nbsp;
					
					<html:submit property="btn_search" styleClass="button" value="查询" />
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
								<th width="8%">
								序号
								</th>
								<th width="12%">检查分类</th>
								<th width="20%">检查名称</th>
								<th width="20%">检查结果</th>
							</tr>
						<!-- body部 -->
                            <logic:present name="IGDUT01041VO" property="dutyAuditList">
								<logic:iterate id="bean" name="IGDUT01041VO" property="dutyAuditList" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>" onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="setParentValue('${bean.dadid}','${bean.dadname}');">
										<td>
											<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
										</td>
										<!-- 检查分类 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="dadtype">&nbsp;</logic:empty><ig:codeValue 
											ccid="DUTY_TYPE" cid="${bean.dadtype}" /></div>
										</td>
										<!-- 检查名称 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="dadname">&nbsp;</logic:empty> ${bean.dadname}</div>
										</td>
										<!-- 检查结果 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="dadcontent">&nbsp;</logic:empty><ig:codeValue 
											ccid="DUTY_CONTENT" cid="${bean.dadcontent}" /></div>
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
                	<input type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
                    <input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button">
                </div>
	    </div>
	    <html:hidden name="IGDUT0104Form" property="dadcategory" styleId="dadcategory"/>
    </html:form>
</div>


</div>
</body>
</html:html>