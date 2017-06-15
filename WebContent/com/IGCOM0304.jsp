<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGCOM0304" toScope="request"/>
<bean:define id="title" value="基础数据查询" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	
	    var gid='IGCOM0304';
        function setParentValue(ccid, ccname, cid, cname){
            if(!window.opener.closed){
                window.opener.setParamIGCOM0304(ccid, ccname, cid, cname);
            }
            window.close();
        }
        function clearParentValue(){
            if(!window.opener.closed){
                window.opener.setParamIGCOM0304("", "", "", "");
            }
            window.close();
        }
        function search(){
            form.submit();
        }

	</script>

<body onload="startCheckOpenerClosed();">
<div id="container">
    <div id="location">
        <div class="image"></div>
            <p class="fonts1">基础数据查询</p>
    </div>

    <html:form styleId="form" action="/IGCOM0304" onsubmit="return checkSubmit(this);">
        <div id="search">
            <div class="img"></div>
            <div class="conditions">
                <div>
	                <label>数据分类：</label><html:select property="ccid" style="width: 120px;" onchange="javascript:search();">
                      <html:optionsCollection name="ADCodeCategory" label="label" value="value"/>
                    </html:select>
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
                        <th width="10%">行号</th>
                        <th width="10%">数据分类编号</th>
                        <th width="35%">数据分类名称</th>
                        <th width="10%">数据编号</th>
                        <th width="35%">数据说明</th>
                    </tr>
                <!-- body部 -->
		      
		           <logic:present name="IGCOM0304VO" property="codeDetailList" >
		               <logic:iterate id="bean" name="IGCOM0304VO" property="codeDetailList" indexId="index">
		                   <tr class="<ig:rowcss index="${index}"/>">
		                       <!-- 编号 -->
		                       <td>
		                           <div class="nowrapDiv">
		                               <a href="javaScript:setParentValue(
		                                   '${bean.ccid}',
		                                   '${bean.codeCategory.ccname}',
		                                   '${bean.cid}',
		                                   '${bean.cvalue}'			
		                               )">
		                                ${(PagingDTO.viewPage-1)*PagingDTO.pageDispCount + index+1}
		                               </a>
		                           </div>
		                       </td>
		                       <!-- 数据分类编号 -->
		                       <td>
		                           <div class="nowrapDiv">
		                           ${bean.ccid}
		                           </div>
		                       </td>
		                       <!-- 数据分类名称 -->
		                       <td>
		                           <div class="nowrapDiv">
		                           ${bean.codeCategory.ccname}
		                           </div>
		                       </td>
                               <!-- 数据编号 -->
                               <td>
                                   <div class="nowrapDiv">
                                   ${bean.cid}
                                   </div>
                               </td>
                               <!-- 数据说明 -->
                               <td>
                                   <div class="nowrapDiv">
                                   ${bean.cvalue}
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
                	<input type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
                    <input type="button" name="btn_close" value="关闭" onclick="window.close()" class="button">
                </div>
        </div>
    </html:form>
</div>


</body>
</html:html>