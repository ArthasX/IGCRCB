<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGAIM0211" toScope="request" />
<bean:define id="title"  toScope="request" >
	<bean:message bundle="asmResources" key="ietitle.IGCIM0211"/>
</bean:define>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
    function toback(){
        form.action = getAppRootUrl() + "/IGAIM0207_back.do";
        form.submit();
    }
</script>
<script src="<html:rewrite forward='SpryTabbedPanels.js'/>"></script>
<body>
<div id="maincontent"><!--header  头部和 一级菜单--> <jsp:include
	page="/include/header2.jsp" /> <!--container 左菜单 右侧内容-->
<div id="container"> <!--content  右侧内容-->
<div id="contentWrap">
<div id="content">

<div id="location">
<div class="image"></div>
<p class="fonts1">
	<bean:define id="urlable">
		<bean:message bundle="asmResources" key="navigation.IGASM.historyVersion"/>
	</bean:define>
	<ig:navigation extname1="${urlable}" />
		</p>
<div class="back">
	<html:link href="javascript:toback();">
			 <bean:message bundle="asmResources" key="button.IGCIM0211.btn_toback"/> 
	</html:link>
</div>
</div>



<div class="title">
<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0211.ImportVersionInfo"/></div>
</div>

 <div id="results_list">
                    <table class="table_style">
                        <tr>
                         	<th width="10%"><bean:message bundle="asmResources" key="label.IGCIM0211.Impeiname"/></th>
	                        <th width="15%"><bean:message bundle="asmResources" key="label.IGCIM0211.Impversion"/></th>
	                        <th width="20%"><bean:message bundle="asmResources" key="label.IGCIM0211.Impcitype"/></th>
	                        <th width="10%"><bean:message bundle="asmResources" key="label.IGCIM0211.Impfilename"/></th>
	                        <th width="18%"><bean:message bundle="asmResources" key="label.IGCIM0211.Impcreatetime"/></th>
                        </tr>
                        <tr>
                         <td align="center">
                            ${IGCIM02111VO.importVersionInfo.impeiname}
                          </td>
                          <td align="center">${IGCIM02111VO.importVersionInfo.impversion}</td>
                          <td align="center">${IGCIM02111VO.importVersionInfo.soc0113TB.impTypename}</td>
                          <td>${IGCIM02111VO.importVersionInfo.impfilename}</td>
					 	  <td>${IGCIM02111VO.importVersionInfo.impcreatetime}</td>
                        </tr>
                     </table>
             </div>

<div class="title">
<div class="name"><bean:message bundle="asmResources" key="label.IGCIM0211.historyVersionInfo"/></div>
</div>
<div class="message"><ig:message /></div>
 <div id="results_list">
    <table width="100%" class="table_style" >
      <!-- header部 -->
		 <tr>
			<th width="50%"><bean:message bundle="asmResources" key="label.IGCIM0211.VersionInfo"/></th>
			<th width="50%"><bean:message bundle="asmResources" key="label.IGCIM0211.Impcreatetime"/></th>     
		 </tr>
		 <logic:present name="IGCIM02111VO" property="importVersionInfoList">
			<logic:iterate id="bean" name="IGCIM02111VO" property="importVersionInfoList"
				indexId="index">
				<tr>
		       		<td>
				       ${bean.impversion}<bean:message bundle="asmResources" key="label.IGCIM0211.Vesion"/>
		       		</td>
		       		<td>
		          		${bean.impcreatetime}
		       		</td>
		       </tr>
			</logic:iterate>
		</logic:present>
     </table>
 </div>
 
<div class="enter">
	<html:form styleId="form"  action="/IGAIM0207_back" onsubmit="return checkSubmit(this);">
		<html:submit property="btn_back" styleClass="button" >
			<bean:message bundle="asmResources" key="button.IGCIM0211.btn_toback"/> 
		</html:submit>
	</html:form>
</div>

</div>
</div>
</div>


</div>
</body>
</html:html>