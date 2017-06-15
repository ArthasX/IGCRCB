<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGASM2012" toScope="request" />
<bean:define id="title"  toScope="request" value="Domain历史版本界面"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
    function toback(){
        form.action = getAppRootUrl() + "/IGASM2003.do";
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
<div class="name">Domain基本信息</div>
</div>

 <div id="results_list">
                    <table class="table_style">
                        <tr>
                         	<th width="10%">Domain名称</th>
	                        <th width="15%">版本号</th>
	                        <th width="20%">创建时间</th>
	                        <th width="10%">更新时间</th>
                        </tr>
                        <tr>
                         <td align="center">
                            ${IGASM20121VO.eiDomainDefInfo.name}
                          </td>
                          <td align="center">${IGASM20121VO.eiDomainDefInfo.version}</td>
                          <td align="center">${IGASM20121VO.eiDomainDefInfo.createtime}</td>
                          <td>${IGASM20121VO.eiDomainDefInfo.updatetime}</td>
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
			<th width="50%">版本时间</th>     
		 </tr>
		 <logic:present name="IGASM20121VO" property="eiDomainDefInfoList">
			<logic:iterate id="bean" name="IGASM20121VO" property="eiDomainDefInfoList"
				indexId="index">
				<tr>
		       		<td>
				       ${bean.version}版
		       		</td>
		       		<td>
		          		${bean.updatetime}
		       		</td>
		       </tr>
			</logic:iterate>
		</logic:present>
     </table>
 </div>
 
<div class="enter">
	<html:form styleId="form"  action="/IGASM2003" onsubmit="return checkSubmit(this);">
		<html:submit property="btn_back" styleClass="button" value="返回"/>
	</html:form>
</div>

</div>
</div>
</div>


</div>
</body>
</html:html>