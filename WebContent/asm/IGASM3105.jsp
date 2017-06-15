<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM3105" toScope="request" />
<bean:define id="title" value="风险指标配置信息历史版本画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	var gid='IGASM3105';
    function toback(){
        form.action = getAppRootUrl() + "/IGASM3105_Back.do?btn_back=1";
        form.submit();
    }
	</script>
<body >
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container">
<!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1"><ig:navigation extname1="${urlable}"/>&gt;&gt; 历史版本</p>
<div class="back"><html:link href="javascript:toback();">返回</html:link></div>
</div>



<div class="title">
<div class="name">风险指标基本信息</div>
</div>
 <div id="results_list">
                    <table class="table_style">
                        <tr>
                         	<th width="10%">模型名称</th>
	                        <th width="15%">风险指标编号</th>
	                        <th width="20%">风险指标名称</th>
	                        <th width="10%">风险指标所属机构</th>
	                        <th width="18%">风险指标说明</th>
	                        <th width="7%">管理人</th>
	                        <th width="8%">登记日</th>
	                        
                        </tr>
                        <tr>
                         <td align="center">
                            ${IGASM31051VO.entityData.ename}
                          </td>
                          <td align="center">${IGASM31051VO.entityData.eilabel}</td>
                          <td align="center">${IGASM31051VO.entityData.einame}</td>
                          <td>${IGASM31051VO.eiorgname}</td>
					 	  <td>${IGASM31051VO.entityData.eidesc}</td>
                         <td align="center">${IGASM31051VO.entityData.eiusername}</td>
                         <td align="center">${IGASM31051VO.entityData.eiinsdate}</td>
                         
                        </tr>
                     </table>
             </div>

<div class="title">
<div class="name">历史版本信息</div>
</div>
<div class="message"><ig:message /></div>
 <div id="results_list">
    <table width="100%" class="table_style" >
      <!-- header部 -->
		 <tr>
			<th width="50%">版本号</th>
			<th width="50%">修改时间</th>
		 </tr>
		 <logic:present name="IGASM31051VO" property="configItemVersionTime">
			<logic:iterate id="bean" name="IGASM31051VO" property="configItemVersionTime"
				indexId="index">
				<tr>
		       		<td>
				       <c:if test="${IGASM31051VO.flag==true}">
				          <a href='javascript:openVersionInfoDetail(${IGASM31051VO.entityData.eiid},${bean.civersion},${bean.cismallversion})'>${bean.civersion}版 </a>
				       </c:if>
				       <c:if test="${IGASM31051VO.flag!=true}">${bean.civersion}版 </c:if>
		       		</td>
		       		<td>
		          		${bean.ciupdtime}
		       		</td>
		       </tr>
			</logic:iterate>
		</logic:present>
     </table>
 </div>
 
<div class="enter">
	<html:form styleId="form"  action="/IGASM3105_Back" onsubmit="return checkSubmit(this);">
	<c:if test="${IGASM31051VO.flag==true}">
    	<logic:present name="IGASM31051VO" property="configItemVersionTime">
			<bean:size id="num" name="IGASM31051VO" property="configItemVersionTime"/>
				<c:if test="${num > 1}">
			    	<html:button property="btn_compare" styleClass="button" value="版本比较" onclick="openEiVersionWindow('${IGASM31051VO.entityData.eiid}');" />	
    			</c:if>
		</logic:present>
	</c:if>
		<html:submit property="btn_back" styleClass="button" value="返回"/>
	</html:form>
</div>
</div>
</div>
</div>


</div>
</body>
</html:html>