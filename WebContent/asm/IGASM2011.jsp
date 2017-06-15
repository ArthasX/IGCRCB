<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2011" toScope="request" />
<bean:define id="title"  toScope="request" value="导入对象历史版本界面"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
    function toback(){
        form.action = getAppRootUrl() + "/IGASM2007.do";
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
<p class="fonts1">资产管理 &gt;&gt; 
		导入管理&gt;&gt; 
		对象管理&gt;&gt; 
		历史版本</p>
<div class="back">
	<html:link href="javascript:toback();">
			返回
	</html:link>
</div>
</div>



<div class="title">
<div class="name">导入对象基本信息</div>
</div>

 <div id="results_list">
                    <table class="table_style">
                        <tr>
                         	<th width="10%">实体名</th>
	                        <th width="15%">版本号</th>
	                        <th width="20%">顶级CI类型</th>
	                        <th width="10%">导入文件名</th>
	                        <th width="18%">导入时间</th>
                        </tr>
                        <tr>
                         <td align="center">
                            ${IGASM20111VO.importVersionInfo.impeiname}
                          </td>
                          <td align="center">${IGASM20111VO.importVersionInfo.impversion}</td>
                          <td align="center">${IGASM20111VO.importVersionInfo.eiImportProgrammeTB.impTypename}</td>
                          <td>${IGASM20111VO.importVersionInfo.impfilename}</td>
					 	  <td>${IGASM20111VO.importVersionInfo.impcreatetime}</td>
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
			<th width="50%">历史版本</th>
			<th width="50%">导入时间</th>     
		 </tr>
		 <logic:present name="IGASM20111VO" property="importVersionInfoList">
			<logic:iterate id="bean" name="IGASM20111VO" property="importVersionInfoList"
				indexId="index">
				<tr>
		       		<td>
				       ${bean.impversion}版
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
	<html:form styleId="form"  action="/IGASM2007" onsubmit="return checkSubmit(this);">
		<html:submit property="btn_back" styleClass="button" value="返回" />
	</html:form>
</div>

</div>
</div>
</div>


</div>
</body>
</html:html>