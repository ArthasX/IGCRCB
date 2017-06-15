<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<!--javascript-->
<script type="text/javascript">
var gid='IGSCH0302';


function toback(){
	form.action = getAppRootUrl() + "/IGSCH0101_Disp.do?btn_back=1";
	form.submit();
}

</script>
<bean:define id="id" value="IGSCH0104" toScope="request" />
<bean:define id="title" value="定时任务查看" toScope="request" />
<bean:define id="bean" name="IGSCH01011VO"  property="quartzJobs"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<jsp:include page="/include/header2.jsp" />
<div id="container">
<!--container 左菜单 右侧内容-->
   <div id="contentWrap">
   <div id="content">
   <div id="location">
       <div class="image"></div>
        <p class="fonts1">流程管理 &gt;&gt; 任务调度 &gt;&gt; 任务信息查看</p>
          <div class="back"><a href="IGSCH0101_BACK.do" target="_self">返回</a></div>
    </div>
       <div id="formwrapper">
      	<div class="title">
			<div class="name">任务信息</div>
			</div>
         <table cellspacing="2" class="table_style7">
          <tr>
            <th width="10%"><strong>任务名称</strong>：</th>
            <td width="40%"><bean:write name="bean" property="qjname" /></td>
            <th width="10%"><strong>任务描述</strong>：</th>
            <td width="40%"><bean:write name="bean" property="qjdesc" /></td>
            </tr>
          <tr>
            <th><strong>执行人员</strong>：</th>
            <td><bean:write name="bean" property="qjimplusername" /></td>
            <th><strong>创建人员</strong>：</th>
            <td><bean:write name="bean" property="qjcrtusername" /></td>
          </tr>
          <tr>
            <th><strong>开始时间</strong>：</th>
            <td><bean:write name="bean" property="qjcrttime" /></td>
            <th><strong>结束时间</strong>：</th>
            <td><bean:write name="bean" property="qjendtime" /></td>
          </tr>
          <tr>
            <th><strong>调度方式</strong>：</th>
            <td><ig:codeValue ccid="STRATEGY_WORK_CODE" cid="${bean.qjtype}" /></td>
            <th><strong>周期类型</strong>：</th>
            <td><bean:write name="bean" property="qjperiodinfo" /></td>
          </tr>
           <tr>
            <th><strong>短信内容</strong>：</th>
            <td colspan="3"><pre><bean:write name="bean" property="qjinfo" /></pre></td>
          </tr>
        </table>
	<div class="enter"><html:button property="btn_back" styleClass="button" value="返回" onclick="window.location='IGSCH0101.do';" /></div>
    </div>
     </div>
</div>
</div>
</div>
</body>
</html:html>