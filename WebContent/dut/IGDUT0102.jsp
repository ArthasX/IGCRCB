<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGDUT0102" toScope="request" />
<bean:define id="title" value="值班检查管理画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	 function changeStatus(dadid,dadstatus){
			if(confirm("是否改变状态？")){
				var form = document.getElementById("form");
				form.action="IGDUT0102_Change.do?dadid="+dadid+"&dadstatus="+dadstatus;
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
          <html:form styleId="form" action="/IGDUT0102" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; 值班检查管理</p>
            </div>
            <div id="search">
                   <div class="img"></div>
                   <div class="conditions">
                   <div>
                    <span>&nbsp;&nbsp;检查分类：</span>
                    <span><html:select property="dadtype">
                    		<ig:optionsCollection ccid="DUTY_TYPE" isMakeBlankRow="true" isCodeLabel="true" type="${IGDUT0102Form.dadcategory}"/>
                    	  </html:select>
                    </span>
            		<span>&nbsp;&nbsp;&nbsp;&nbsp;检查名称：</span><html:text property="dadname" styleId="dadname" errorStyleClass="inputError imeDisabled" size="18"/>&nbsp;&nbsp;
					
					<html:submit property="btn_search" styleClass="button" value="查询" />
                   </div>
                   </div>
                </div>
                
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table class="table_style">
						<!-- header部 -->
						
							<tr>
								<th width="8%">
<!--								<label> <input type="checkbox" name="checkbox" id="checkbox" /> </label>-->
								序号
								</th>
								<th width="12%">检查分类</th>
								<th width="20%">检查名称</th>
								<th width="20%">检查结果</th>
								<th width="20%">检查项排序</th>
								<th width="10%">状态</th>
								<th width="8%">修改</th>
							</tr>
						
						<!-- body部 -->
						
                            <logic:present name="IGDUT01021VO" property="dutyAuditList">
								<logic:iterate id="bean" name="IGDUT01021VO" property="dutyAuditList" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">
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
										
										<!-- 检查项排序 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="dadorderby">&nbsp;</logic:empty>${bean.dadorderby}</div>
										</td>
										
										<!-- 状态  在用:0  停用:1 -->
										<td>
											<a href="javascript:changeStatus('${bean.dadid}','${bean.dadstatus}');">
											
											    <c:if test="${bean.dadstatus == 1 }">
													<img src="images/stop.gif" border="0" alt="停用" />
											    </c:if>
											    <c:if test="${bean.dadstatus == 2 }">
													<img src="images/start.gif" border="0" alt="启用" />
											    </c:if>
											
											</a>
										</td>
										
										<!-- 修改  -->
										<td valign="middle">
										<div align="center">
										<html:link action="/IGDUT0101_Edit_Disp.do?dadid=${bean.dadid}">
											<img src="images/edit.gif" alt="修改" width="16" height="16" border="0" />
										</html:link>
										</div>
										</td>
									</tr>
									
									
								</logic:iterate>
							</logic:present>
					</table>
				</div>
				<div id="operate">
	             <jsp:include page="/include/paging.jsp" />
                </div>
				<html:hidden property="dadcategory" styleId="dadcategory" name="IGDUT0102Form"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>