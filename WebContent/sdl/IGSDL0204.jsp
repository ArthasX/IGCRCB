<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@page import="com.deliverik.framework.workflow.WorkFlowConstDefine"%>
<html:html>
<!--javascript-->
<script type="text/javascript">
var gid='IGSCH0302';



function toback(){
	form.action = getAppRootUrl() + "/IGSCH0101_Disp.do?btn_back=1";
	form.submit();
}

</script>
<bean:define id="id" value="IGSDL0204" toScope="request" />
<bean:define id="title" value="定时任务查看" toScope="request" />
<bean:define id="bean1" name="IGSCH01011VO"  property="quartzJobs"/>
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
        <p class="fonts1"><ig:navigation extname1="${urlable}"/></p>
    </div>
       <div id="formwrapper">
         
		   <div class="title">
			<div class="name">任务信息</div>
			</div>
         <table cellspacing="2" class="table_style7">
          <tr>
            <th width="10%"><strong>任务名称</strong>：</th>
            <td width="40%"><bean:write name="bean1" property="qjname" /></td>
            <th width="10%"><strong>任务描述</strong>：</th>
            <td width="40%"><bean:write name="bean1" property="qjdesc" /></td>
           </tr>
          <tr>
            <th><strong>执行人员</strong>：</th>
            <td><bean:write name="bean1" property="qjimplusername" /></td>
            <th><strong>创建人员</strong>：</th>
            <td><bean:write name="bean1" property="qjcrtusername" /></td>
          </tr>
          <tr>
            <th><strong>开始时间</strong>：</th>
            <td><bean:write name="bean1" property="qjcrttime" /></td>
            <th><strong>结束时间</strong>：</th>
            <td><bean:write name="bean1" property="qjendtime" /></td>
          </tr>
          <tr>
            <th><strong>相关资产</strong>：</th>
            <td>
            	<a href="javascript:void(0)" onclick="openSubIGCOM0303('${bean1.qjassetid}','')">
				${IGSCH01011VO.einame }</a>
			</td>
             <th><strong>策略类别</strong>：</th>
            <td>
            	${IGSCH01011VO.cvalue }
            </td>
          </tr>
          <tr>
            <th><strong>调度方式</strong>：</th>
            <td><ig:codeValue ccid="STRATEGY_WORK_CODE" cid="${bean1.qjtype}" /></td>
             <th><strong>执行时间</strong>：</th>
            <td><bean:write name="bean1" property="qjperiodinfo" /></td>
          </tr>
        </table>

 <bean:define id="bean2" name="IGSCH01011VO"  property="quartzProcessRecord"/> 
    	 <div class="title">
			<div class="name">工作信息</div>
			</div>
         <table cellspacing="2" class="table_style7">

          <tr>
            <th width="10%"><strong>工作类型</strong>：</th>
            <td width="40%"><bean:write name="bean2" property="qprpdname" /></td>
            <th width="10%"><strong>工作名称</strong>：</th>
            <td width="40%"><bean:write name="bean2" property="qprtitle" /></td>
          </tr>
         
          <tr>
            <th><strong>相关资产</strong>：</th>
			<td colspan="3">
				<logic:present name="IGSCH01011VO" property="quartzPieList">
				<logic:iterate id="entity" name="IGSCH01011VO" property="quartzPieList"
					indexId="index" type="com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity">
				<a href="javascript:void(0)" onclick="openSubIGCOM0303('<%=entity.getQeiid() %>','')">
				<%=entity.getEntityItemTB().getEiname() %> </a>&nbsp;&nbsp;
				</logic:iterate>
				</logic:present>
			</td>
          </tr>
            <tr>
            <th><strong>紧急程度</strong>：</th>
            <td><ig:codeValue ccid="IMPACT_GRADE_CODE"
						cid="${bean2.qprurgency}" /></td>
            <th><strong>影响程度</strong>：</th>
            <td><ig:codeValue ccid="IMPACT_GRADE_CODE"
						cid="${bean2.qprimpact}" /></td>
          </tr>
          <logic:present name="IGSCH01011VO" property="quartzProcessInfoList">
			<logic:iterate id="bean" name="IGSCH01011VO" property="quartzProcessInfoList" indexId="index" type="com.deliverik.infogovernor.scheduling.model.QuartzProcessInfo">
				<%if(index.intValue()%2==0) {%>
				<tr>
				<%} %>
					<th>
					${bean.qpivarlabel}：
					</th>
					<td>
					<% if(bean.getQpivarvalue().contains("_prj_")){ %>
							<%=bean.getQpivarvalue().split("_prj_")[1] %>
						<% } else if(bean.getQpivarvalue()!=null&&bean.getQpivarvalue().contains("N/A") 
								&& (!WorkFlowConstDefine.PROCESS_PIVRLABEL.equals(bean.getQpivarlabel()))
								&& WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(bean.getQpivartype())){ %>
							<logic:present name="IGSCH01011VO" property="quartzProcessInfoEntityList">
								<logic:iterate id="entity" name="IGSCH01011VO" property="quartzProcessInfoEntityList"
									type="com.deliverik.infogovernor.scheduling.model.QuartzProcessInfoEntity">
									<% if(bean.getQpiid().equals(entity.getQpiid())){ %>
										<a href="javascript:void(0)" onclick="openSubIGCOM0303('<%=entity.getQeiid() %>','')">
										<%=entity.getEntityItemTB().getEiname() %> </a>&nbsp;&nbsp;
									<% } %>
							</logic:iterate>
							</logic:present>
						<% } else if(bean.getQpivarvalue().contains("_svc_")){ %>
							<a href="javascript:openRelatedProcess('<%=bean.getQpivarvalue().split("_svc_")[0] %>','<%=bean.getQpivarvalue().split("_svc_")[1].split("_name=")[0] %>')">
							<%=bean.getQpivarvalue().split("_svc_")[1].split("_name=")[1] %></a>
						<% } else {
							if((bean.getQpivarvalue()!=null&&!bean.getQpivarvalue().contains("N/A"))
									&& (!WorkFlowConstDefine.PROCESS_PIVRLABEL.equals(bean.getQpivarlabel()))
									&& (!WorkFlowConstDefine.PROCESS_PIVRTYPE.equals(bean.getQpivartype()))){ %>
										${bean.qpivarvalue}
								<%	}
								 } %>
					</td>
				<%if(index.intValue()%2!=0){%>
				</tr>
				<%} %>
			</logic:iterate>
			
		</logic:present>
		<tr>
            <th ><strong>工作描述</strong>：</th>
            <td colspan="3"><pre><bean:write name="bean2" property="qprdesc" /></pre></td>

        </tr>
         <tr>
		  <th ><strong>附件</strong>：</th>
		  <td colspan="3">
			<logic:present name="IGSCH01011VO" property="attachmentList">
				<logic:iterate id="bean" name="IGSCH01011VO" property="attachmentList" indexId="index">
					<!-- 附件 -->
					<a href="downloadSchFile.do?attId=${bean.attid}&type=sdl">
					<bean:define id="attname" name="bean" property="attname" />
					<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>
					</a>
					&nbsp;&nbsp;&nbsp;&nbsp;
				</logic:iterate>
			</logic:present>
		  </td>
		  </tr>
         </table>
         <div class="enter"><html:button property="btn_back" styleClass="button" value="返回" onclick="window.location='IGSDL0203_BACK.do';" /></div>
	
    </div>
     </div>
</div>
</div>
</div>
</body>
</html:html>