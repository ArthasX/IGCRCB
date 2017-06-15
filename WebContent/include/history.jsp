<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>

<!-- 追加リクエストパラメータ -->
<bean:parameter name="eiid" id="eiid" value=""/>
<bean:parameter name="eiversion" id="eiversion" value=""/>
<bean:parameter name="civersion" id="civersion" value=""/>
<bean:parameter name="action" id="action" value=""/>
<bean:parameter name="flag" id="flag" value=""/>
<c:if test="${flag == 1}">
<script type="text/javascript">
	function openEiVersionWindow(eiid){
		openSubWindow('/IGCOM0307.do?eiid=' + eiid + '&screenWidth='+window.screen.width, 'igasm0305',window.screen.width,window.screen.height);
	}
</script>
</c:if>
<div id="information">
	<table cellspacing="0" style="table-layout:fixed;">
	    <tr>
	       <td>
	          <c:if test="${eiversion == 0}">
                                    当前显示版本：${eiversion} &nbsp;&nbsp;
	          </c:if>
              <c:if test="${eiversion > 0}">
                                    当前显示版本：${civersion} &nbsp;&nbsp;
              </c:if>
		                最新版本号：${eiversion}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		      <c:if test="${flag == 1}">
		      	<a href="javascript:void(0)" onclick="openEiVersionWindow('${eiid}')">版本比较</a>
		      </c:if>
	       </td>
	    </tr>
		<tr>
			<td>
				<c:if test="${eiversion > 0 }">
					<c:forEach begin="1" end="${eiversion}" var="version">
						
						<c:choose>
							<c:when test="${civersion != version}">
								<html:link action="/${action}.do?eiid=${eiid}&civersion=${version}" >
									${version}版
								</html:link>
							</c:when>
							<c:otherwise>
								<font class="txMessageWar">${version}版</font>
							</c:otherwise>
						</c:choose>
						
						&nbsp;&nbsp;
					</c:forEach>
				</c:if>
			</td>
		</tr>
	</table>
</div>