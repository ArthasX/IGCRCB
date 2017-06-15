<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html:html>
<bean:define id="id" value="IGKGM0218" toScope="request" />
<bean:define id="title" value="关联流程页面 " toScope="request" />
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">

</script>
<body>
<div id="maincontent">
<div id="container">
     
    <!--content  右侧内容-->
    <div id="contentWrap">
        <div id="content">
          <html:form styleId="form" action="/IGKGM0205" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">查看</p>
            		
            </div>
            <br/>
         
            <div class="results_list">
				<ig:message />
				<table  class="table_style" style="width: 980px;">
					<tr>
						<th width="50%">关联类型</th>
						<th width="50%">相关引用</th>
										
					</tr>
					<logic:present name="IGKGM02051VO" property="knowledgeProcessList">
						
						<logic:iterate id="bean" name="IGKGM02051VO" property="knowledgeProcessList" indexId="index">
							
							<tr>
								<c:if test="${bean.connecttype == '0'}">
								
								<td>流程</td>
								<td>
						
									<a href="javascript:openRelatedProcess('${bean.processRecord.prid}','${bean.processRecord.prtype}');">${bean.processRecord.prtitle }</a><br/>
							
								</td>
								
								
								</c:if>
								
								<c:if test="${bean.connecttype == '2'}">
								
								<td>服务工单</td>
								<td>
						
									<a href="javascript:openRelatedProcess('${bean.serviceForm.sfid}','SF');">${bean.serviceForm.sftitle}</a><br/>
							
								</td>
						
								</c:if>
								
							</tr>
							
						</logic:iterate>
						</logic:present> 
		
				</table>
	
	

			</div>
	<div align="center"><input type="button"
	class="button" value="关闭" onclick="window.close();"></div>
    </html:form>
    </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>