<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html" %>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic" %>
<%@ taglib uri="http://www.deliverik.com/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<logic:notEmpty name="IGDRM04012VO" property="configurationList">
<html:form action="/IGDRM0401_Config.do" method="POST">
			<logic:present name="IGDRM04012VO" property="configurationList" >
			<tr>
				<c:set var="codeIndex" value="0"></c:set>
					<logic:iterate id="entityItem" name="IGDRM04012VO" property="configurationList" indexId="index">
						<c:choose>
							<c:when test="${brFlag==null }">
								<c:set var="brFlag" value="false"></c:set>
							</c:when>
							<c:when test="${brFlag!=null }">
								<c:choose>
									<c:when test="${brFlag=='ture'||entityItem.cunit=='1' }">
										</tr><tr>
										<c:set var="brFlag" value="false"></c:set>
										<c:if test="${entityItem.cunit=='1'}">
											<c:set var="brFlag" value="ture"></c:set>
										</c:if>
									</c:when>
									<c:when test="${brFlag=='false'}">
										<c:set var="brFlag" value="ture"></c:set>
									</c:when>
								</c:choose>
							</c:when>
						</c:choose>
						
						<th>
							<label for="Name"><strong>
							<c:if test="${entityItem.crequired =='1'}">
								<span class="red">*</span></c:if>
								<html:hidden property="cids" value="${entityItem.cid }"/>
								${entityItem.cname }:&nbsp;&nbsp;
							</strong></label>
						</th>

						<td <c:if test="${entityItem.cunit=='1'}"> colspan="3" </c:if> >
							
						<c:choose>
							<c:when test="${entityItem.cattach=='2'}">
								<html:select property="civalues" >
									<logic:notEmpty name="entityItem" property="coption">
										<c:set var="codeIndex" value="${codeIndex+1 }"></c:set>
									</logic:notEmpty>
								</html:select>
							</c:when>
							<c:when test="${entityItem.cattach=='6' }">
							
								<html:textarea property="civalues" value="">
								</html:textarea>
							</c:when>
							<c:when test="${entityItem.cattach=='9' }">
								<logic:notEmpty name="entityItem" property="coption">
<%-- 									<logic:iterate id="codedetail" name="IGDRM04012VO" property="codeList[${codeIndex }]"> --%>
<%-- 										<html:radio property="civalues" styleId="rdo_${entityItem.cid }" value="${codedetail.cid }">${codedetail.cvalue }</html:radio> --%>
<%-- 									</logic:iterate> --%>
									<html:hidden property="civalues"/>
									<c:set var="codeIndex" value="${codeIndex+1 }"></c:set>
								</logic:notEmpty>
							</c:when>
							<c:when test="${entityItem.cattach=='1' }">
									<html:file property="files" size="40" />
									<html:hidden property="civalues" value="ciattach"/>
							
							</c:when>
							<c:when test="${entityItem.cattach=='0' }">
								<html:text property="civalues" ></html:text>
							</c:when>
						</c:choose>
						</td>
					</logic:iterate>
				</tr>
		</logic:present>
			</html:form>			
	</logic:notEmpty>				
	<logic:notEmpty name="IGDRM04012VO" property="configItemList">
		<html:form action="/IGDRM0404" styleId="tempForm" enctype="multipart/form-data">
		<logic:present name="IGDRM04012VO" property="configItemList" >
		<tr>
		<c:set var="codeIndex" value="0"></c:set>
			<logic:iterate id="entityItem" name="IGDRM04012VO" property="configItemList"  indexId="index">
				<c:choose>
					<c:when test="${brFlag==null }">
						<c:set var="brFlag" value="false"></c:set>
					</c:when>
					<c:when test="${brFlag!=null }">
						<c:choose>
							<c:when test="${brFlag=='ture'||entityItem.cunit=='1' }">
								</tr><tr>
								<c:set var="brFlag" value="false"></c:set>
								<c:if test="${entityItem.cunit=='1'}">
									<c:set var="brFlag" value="ture"></c:set>
								</c:if>
							</c:when>
							<c:when test="${brFlag=='false'}">
								<c:set var="brFlag" value="ture"></c:set>
							</c:when>
						</c:choose>
					</c:when>
				</c:choose>
				
				<th>
					<label for="Name"><strong>
						<c:if test="${entityItem.crequired =='1'}">
							<span class="red">*</span>
						</c:if>
						<html:hidden property="cids" value="${entityItem.cid }"/>${entityItem.cname }&nbsp;&nbsp;
					</strong></label>
				</th>

				<td <c:if test="${entityItem.cunit=='1'}"> colspan="3" </c:if> >
					
				<c:choose>
					<c:when test="${entityItem.cattach=='2'}">
						<logic:notEmpty name="entityItem" property="civalue">
						<html:select property="civalue" value="${entityItem.civalue }">
							<logic:notEmpty name="entityItem" property="coption">
								<c:set var="codeIndex" value="${codeIndex+1 }"></c:set>
							</logic:notEmpty>
						</html:select>
						</logic:notEmpty>
					</c:when>
					<c:when test="${entityItem.cattach=='6' }">
					
						<html:textarea property="civalue" value="${entityItem.civalue }">
						</html:textarea>
					</c:when>
					<c:when test="${entityItem.cattach=='9' }">
						<logic:notEmpty name="entityItem" property="coption">
<%-- 							<logic:iterate id="codedetail" name="IGDRM04012VO" property="codeList[${codeIndex }]"> --%>
<%-- 								<html:radio property="civalue" styleId="rdo_${entityItem.cid }" value="${codedetail.cid }">${codedetail.cvalue }</html:radio> --%>
<%-- 							</logic:iterate> --%>
							<html:hidden property="civalue"/>
							<c:set var="codeIndex" value="${codeIndex+1 }"></c:set>
						</logic:notEmpty>
					</c:when>
					<c:when test="${entityItem.cattach=='1' }">
						<html:hidden property="civalue" styleId="civalue" value="${entityItem.civalue }" />
						<!-- 显示附件内容-2014/09/27 -->
						<logic:notEmpty name="entityItem" property="civalue" >
							<div id = "file[${codeIndex}]" class="nowrapDiv">
								<a href="javascript:downloadASMFile('${entityItem.eiid}','${entityItem.ciid}');">${entityItem.civalue}</a>
								<html:hidden property="delfile[${codeIndex}]" styleId="delfile[${codeIndex}]" />
								<c:if test="${entityItem.civalue > ''}">
									<img src="images/delate.gif" align="middle" onClick="delFile('${codeIndex}')" border="0" style="cursor: hand" alt="删除"/>
								</c:if>
							</div>
						</logic:notEmpty>
						<logic:empty name="entityItem" property="civalue" >
							<html:file property="attachFile[${codeIndex}]" styleId="attachFile[${codeIndex}]" size="25"	errorStyleClass="inputError imeDisabled" onkeydown="return false;" styleClass="imeDisabled" />
							<img src="images/empty.gif" align="middle" onClick="cleanFile('attachFile[${codeIndex}]','civalue[${codeIndex}]')" border="0" style="cursor: hand"/>
						</logic:empty>
					</c:when>
					<c:when test="${entityItem.cattach=='0' }">
						<html:text property="civalue" value="${entityItem.civalue }"></html:text>
					</c:when>
				</c:choose>
				<html:hidden property="ciid" styleId="ciid" value="${entityItem.ciid}" />
				<html:hidden property="cid" styleId="cid" value="${entityItem.cid}" />
				<html:hidden property="clabel" styleId="clabel" value="${entityItem.clabel}" />
				<html:hidden property="ciattach" styleId="ciattach" value="${entityItem.cattach}" />
				<html:hidden property="eid" styleId="eid" value="${entityItem.eid}" />
				<html:hidden property="esyscoding" styleId="esyscoding" value="${entityItem.esyscoding}" />
<%-- 				<html:hidden property="entityItemCivalue[${codeIndex}]" styleId="entityItemCivalue[${codeIndex}]"/> --%>
<%-- 				<html:hidden property="civalue_bak[${codeIndex}]" styleId="civalue_bak[${codeIndex}]" /> --%>
				</td>
			</logic:iterate>
		</tr>
	</logic:present>
	</html:form>			
	</logic:notEmpty>				
		