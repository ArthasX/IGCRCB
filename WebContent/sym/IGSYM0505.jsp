<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ page import="com.deliverik.infogovernor.sym.model.Notice" %>
<html:html>
<bean:define id="id" value="IGSYM0505" toScope="request" />
<bean:define id="title" value="通知详细内容" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<body>
<div id="maincontent">
<div id="container">
<html:form styleId="form" 
	onsubmit="return checkSubmit(this);">
<div id="location" style="margin-top:10px">
<div class="image"></div>
<p class="fonts1">通知详细内容</p>
</div>		
	<div id="results_list">
	
	<% 
	  String path=request.getContextPath();
      Notice notice=(Notice)request.getAttribute("notice");
	  String ntime=notice.getNtime();
	  String nusername=notice.getNusername();
	  String nname=notice.getNname();
	  String norgname=notice.getNorgname();
	  String ndesc=notice.getNdesc();
	  String exattkey=notice.getNattkey();
	  
	%>

         <table border='0'>
            <tr>
              <td colspan="2">发布时间：<%=ntime %></td>
            </tr>
            <tr>
              <td colspan="2">发布者：<%=nusername %></td>
            </tr>
            <tr>
              <td colspan="2">通知名称：<%=nname %></td>
            </tr>
             <tr>
              <td colspan="2">发布者部门：<%=norgname %></td>
            </tr>
            <tr>
            	<td align="left" valign="top" style="white-space:nowrap;">通知内容：</td>
            	<td align="left" valign="top" style="word-wrap: break-word; word-break: normal;" ><pre><%=ndesc %></pre></td>
            </tr>
            
            <%if(exattkey!=null){
              if(!"".equals(exattkey)){
            %>
             <tr>
              <td colspan="2"><b> 附件下载:</b></td>  
              </tr> 
           
                 <logic:notEmpty name="notice" property="attachmentList">	         	   
				    <logic:iterate id="attachment" name="notice" property="attachmentList"
				              indexId="index">
				            <tr><td colspan="2"> 
				            <img src="images/plusfile.gif" />
						       <html:link action="/IGSYM0502_loadFIle.do?attid=${attachment.attid}">				       
						       <bean:define id="attname" name="attachment" property="attname" />
						        
							<%=attname.toString().substring(attname.toString().indexOf("_")+1) %>					  							
								</html:link><br>	
								</td>
								</tr>
				    </logic:iterate> <br>
				    </logic:notEmpty>	
 
             <% }}%>
         </table>

	</div>
</html:form></div>
</div>
</body>
</html:html>
