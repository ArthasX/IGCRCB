<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGRDP0101" toScope="request"/>
<bean:define id="title" value="远程部署升级任务查看页面" toScope="request"/>
<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">	

	    WebCalendar.yearFall   = 50;           //定义年下拉框的年差值
	    WebCalendar.format     = "yyyy/mm/dd"  //回传日期的格式
	    WebCalendar.timeShow   = false          //是否返回时间
	    WebCalendar.drag       = true          //是否允许拖动
	    WebCalendar.darkColor  = "#014DB4";    //控件的暗色
	    WebCalendar.lightColor = "#FFFFFF";    //控件的亮色
	    WebCalendar.btnBgColor = "#FFFFF5";    //控件的按钮背景色
	    WebCalendar.wordColor  = "#000080";    //控件的文字颜色
	    WebCalendar.wordDark   = "#DCDCDC";    //控件的暗文字颜色
	    WebCalendar.dayBgColor = "#E6E6FA";    //日期数字背景色
	    WebCalendar.todayColor = "#FF0000";    //今天在日历上的标示背景色
	    WebCalendar.DarkBorder = "#D4D0C8";    //日期显示的立体表达色
	

		function checkForm(){
		}
	    
	    function deploy(taskid){
	    	form.action = 'IGRDP0101_RDP.do?taskid='+taskid;
	    	form.submit();
	    }
	    
	    function toResult(taskid){
	    	form.action = 'IGRDP0102_Search.do?taskid='+taskid;
	    	form.submit();
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
            <html:form styleId="form" action="/IGRDP0101_Search"
             onsubmit="return checkSubmit(this);">

            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">
						远程部署&gt;&gt; 远程升级 &gt;&gt;升级任务查看
                    </p>
            </div>
                <div id="search">
		             <div class="img"></div>
		             <div class="conditions">
                          <div>
                         	<label for="Name">任务名称：</label>
							<html:text property="taskName_like" size="18" style="width:120px;" errorStyleClass="inputError" tabindex="2"/>
							&nbsp;&nbsp;	
							<label>业务系统:</label>
							<html:select styleId="bsmid" property="bsmid" style="width: 120px;" errorStyleClass="inputError">
								<html:option value=""></html:option>
								<html:options collection="bsms" property="eiid" name="" labelProperty="einame"/>
							</html:select>
							&nbsp;&nbsp;			                
			                <label>执行日期:</label>
	                        <label>从</label><html:text property="time_from" styleId="time_from" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
	                        <img src="images/date.gif" align="middle" onClick="calendar($('time_from'))" border="0"/>
	                        &nbsp;&nbsp;
	                        <label>到</label><html:text property="time_to" styleId="time_to" errorStyleClass="inputError imeDisabled" size="12" readonly="true"/> 
                            <img src="images/date.gif" align="middle" onClick="calendar($('time_to'))" border="0"/>
                             &nbsp;&nbsp;
		         			<html:submit property="btn_search" styleClass="button" onclick="return checkForm();">
		         				查询
		         			</html:submit>
                          </div>
		     </div>
		     
          </div>
                               
                <div id="results_list">
					<!--  message -->
					<ig:message/>
					<!--  /message -->     
			       <table class="table_style">
			            <!-- header部 -->
			                <tr>
					           <th width="24%">任务名称</th>
					           <th width="24%">执行时间</th>
					           <th width="24%">业务系统</th>
					           <th width="14%">部署升级</th>
					           <th width="14%">执行结果</th>
			                </tr>
			                
			            <!-- body部 -->
			                <logic:present name="IGRDP01011VO" property="tasks" >
			                    <logic:iterate id="bean" name="IGRDP01011VO" property="tasks" indexId="index">
			                        <tr class="<ig:rowcss index="${index}"/>" >
			                            <td>
			                            	<div class="nowrapDiv">
			                                <logic:empty name="bean" property="taskName">&nbsp;</logic:empty>
			                                ${bean.taskName}
			                                </div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">
				                                <c:if test="${bean.state == 0}">
				                            		未开始
				                           	 	</c:if>
                                                <c:if test="${bean.state != 0}">
				                            		${bean.excutetime}
				                           	 	</c:if>
			                                </div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">
			                                	<logic:empty name="bean" property="bsmname">&nbsp;</logic:empty>
			                               		 ${bean.bsmname}
			                                </div>
			                            </td>
			                            <td>
			                                <div class="nowrapDiv">
			                               		<c:if test="${bean.state == 0}">
				                               		<html:link action="/IGRDP0101_RDP.do?taskid=${bean.id}">
				                                		<img src="images/zhichu.gif" alt="部署升级" width="16" height="16" border="0"/>
													</html:link>
												</c:if>
												<c:if test="${bean.state == 1}">
				                            		<span style="color: green;">已执行</span>
				                           	 	</c:if>
				                           	 	<c:if test="${bean.state == 2}">
				                            		<span style="color: red;">已执行</span>
				                           	 	</c:if>
											<!--<html:button property="btn_detail" styleClass="button" onclick="deploy('${bean.id}');" style="height:20px;width:70px;">部署升级</html:button>-->
			                                </div>
			                            </td>
			                            <td>
                                            <div class="nowrapDiv">
                                            <c:if test="${bean.state != 0}">
                                            	<html:link action="/IGRDP0102_Search.do?taskid=${bean.id}">
                                            		<img src="images/zhiding.gif" alt="查看结果" width="16" height="16" border="0"/>
                                            	</html:link>
												<!--<html:button property="btn_detail" styleClass="button" onclick="toResult('${bean.id}');" style="height: 20px;width:70px;">查看</html:button>-->
											</c:if>
											<c:if test="${bean.state == 0}">
				                            	---
				                           	</c:if>
                                            </div>
			                            </td>
			                        </tr>
			                    </logic:iterate>
			                </logic:present>
			  
			       </table>
			     </div>
			     <div id="operate">
                            <logic:present name="IGCIM01211VO" property="entityDataList" >
                            <html:submit property="btn_delete"  styleClass="button" onclick="return deleteRec();" >
                            	<bean:message bundle="asmResources" key="button.IGCIM0121.btn_deleteSelect"/>	
                            </html:submit>
                            </logic:present>
			                <!-- paging -->
			                <jsp:include page="/include/paging.jsp"/>
			                <!-- /paging -->
			    </div>
                <html:hidden property="ecategory" styleId="ecategory" value="${IGCIM0121Form.ecategory}"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>
</div>
</body>
</html:html>