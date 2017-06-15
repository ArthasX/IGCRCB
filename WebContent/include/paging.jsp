<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>

<bean:parameter name="reqParams" id="reqParams" value=""/>

<logic:present name="PagingDTO">
    [共<strong><bean:write name="PagingDTO" property="totalCount" /></strong>条]&nbsp;
	<c:if test="${PagingDTO.totalPage > 1 }">
        [<strong>${PagingDTO.viewPage}/${PagingDTO.totalPage}</strong>]&nbsp;
        <c:if test="${PagingDTO.viewPage > 1 }">
	    <html:link href="${PagingDTO.actionPath}?fromCount=0&PAGING=PAGING&${reqParams}'" >
			<img src="images/page1.gif" border="0" alt="首页"/> 
		</html:link>
        &nbsp;
        <html:link href="${PagingDTO.actionPath}?fromCount=${(PagingDTO.viewPage-2) * PagingDTO.pageDispCount}&PAGING=PAGING&${reqParams}'" >
            <img src="images/page3.gif" border="0" alt="上一页"/> 
        </html:link>
		</c:if>
        <c:if test="${PagingDTO.viewPage == 1 }">
            <img src="images/main_54.gif" border="0" alt="首页"/> 
        &nbsp;
            <img src="images/main_56.gif" border="0" alt="上一页"/>
        </c:if>
		&nbsp;
        <c:if test="${PagingDTO.viewPage < PagingDTO.totalPage }">
        <html:link href="${PagingDTO.actionPath}?fromCount=${(PagingDTO.viewPage) * PagingDTO.pageDispCount}&PAGING=PAGING&${reqParams}'" >
            <img src="images/page2.gif" border="0" alt="下一页"/>
        </html:link>
        &nbsp;
		<html:link href="${PagingDTO.actionPath}?fromCount=${(PagingDTO.totalPage-1) * PagingDTO.pageDispCount}&PAGING=PAGING&${reqParams}'" >
			<img src="images/page4.gif" border="0" alt="尾页"/>
		</html:link>
		&nbsp;
		<html:link href="###" onclick="skipPage()">			
            <img src="images/page5.gif" border="0" alt="转到"/>
        </html:link>
		第<input type="text" name="skipPageNum" value="${PagingDTO.viewPage}" size="3" style="text-align:center;line-height:9px;height:9px;width:25px;margin-bottom:4px"/>页
		<script type="text/javascript">	
		<!--
			function skipPage() {
				var myReg = /^[1-9][0-9]{0,8}$/;
				if(myReg.test($F("skipPageNum").trim())) {
					if($F("skipPageNum").trim() > ${PagingDTO.totalPage}) {
						alert("要跳转的页（第" + $F("skipPageNum").trim() + "页）超出最大页数（共" + ${PagingDTO.totalPage} + "页）");
						$("skipPageNum").value = '${PagingDTO.viewPage}';
						return false;
					}
					var count = parseInt($F("skipPageNum").trim() - 1) * parseInt(${PagingDTO.pageDispCount});
					window.location.href = "${PagingDTO.actionPath}?fromCount=" + count + "&PAGING=PAGING&${reqParams}'";
				} else {
					alert("请输入正确的页号！");
					$("skipPageNum").value = '${PagingDTO.viewPage}';
					return false;
				}
			}
		//-->
		</script>
		</c:if>
        <c:if test="${PagingDTO.viewPage == PagingDTO.totalPage }">
            <img src="images/main_58.gif" border="0" alt="下一页"/>
            &nbsp;
            <img src="images/main_60.gif" border="0" alt="尾页"/>
            &nbsp;
            
            <html:link href="###" onclick="skipPage()">
            	<img src="images/page5.gif" border="0" alt="转到"/>
        	</html:link>
            
            第<input type="text" name="skipPageNum" value="${PagingDTO.viewPage}" size="3" style="text-align:center;line-height:9px;height:9px;width:25px;margin-bottom:4px"/>页
			<script type="text/javascript">	
			<!--
				function skipPage() {
					var myReg = /^[1-9][0-9]{0,8}$/;
					if(myReg.test($F("skipPageNum").trim())) {
						if($F("skipPageNum").trim() > ${PagingDTO.totalPage}) {
							alert("要跳转的页（第" + $F("skipPageNum").trim() + "页）超出最大页数（共" + ${PagingDTO.totalPage} + "页）");
							$("skipPageNum").value = '${PagingDTO.viewPage}';
							return false;
						}
						var count = parseInt($F("skipPageNum").trim() - 1) * parseInt(${PagingDTO.pageDispCount});
						window.location.href = "${PagingDTO.actionPath}?fromCount=" + count + "&PAGING=PAGING&${reqParams}'";
					} else {
						alert("请输入正确的页号！");
						$("skipPageNum").value = '${PagingDTO.viewPage}';
						return false;
					}
				}
			//-->
			</script>
        </c:if>
	</c:if>
    <c:if test="${PagingDTO.totalPage == 0 }">
        [<strong>0/0</strong>]&nbsp;
    </c:if>
    <html:hidden property="fromCount" styleId="fromCount" value="${PagingDTO.fromCount}"/>
</logic:present>