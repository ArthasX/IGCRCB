<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0206" toScope="request" />
<bean:define id="title" value="费用查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<style type="text/css"> .file { font: 10pt; color: black; } </style>
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



function check(obj){
	if (!isNaN(obj.value) || "" == obj.value)   
    {   
       return true;   
    }    
    else    
    {   
       alert("编号应为数字类型！");   
       document.getElementById("strExamount").value = "";
       return false;   
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
   
   <div id="location">
       <div class="image"></div>
        <p class="fonts1">服务管理 &gt;&gt; 预算管理 &gt;&gt; 费用查询</p>
    </div>
      <div id="search">
      <html:form styleId="form" action="/IGFIN0206" onsubmit="return checkSubmit(this);">
         <div class="img"></div>
          <div class="conditions">
      <div>
       <span>金额：</span><html:text property="strExamount" styleId="examount" errorStyleClass="inputError imeDisabled" size="12" onblur="check(this);"/>&nbsp;&nbsp;
        <span>时间：</span><span>从</span><html:text property="exopentime" styleId="exopentime" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
   		<img src="images/date.gif" align="middle" onClick="calendar($('exopentime'))" border="0"/>&nbsp;&nbsp;
        <span>到</span><html:text property="exclosetime" styleId="exclosetime" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
         <img src="images/date.gif" align="middle" onClick="calendar($('exclosetime'))" border="0"/>&nbsp;&nbsp;
        
         <span>费用名称：</span><html:text property="exapvname" styleId="exapvname" errorStyleClass="inputError imeDisabled" size="10" />
       <span>&nbsp;&nbsp;预算名称：</span><html:text property="btitle" styleId="btitle" errorStyleClass="inputError imeDisabled" size="10" />
       <span>
       <html:submit property="btn_search" styleClass="button" value="查询" />
       </span> 
       </div>
      </div>
      </html:form>
    </div>
    
        
    
     <div id="results_list"> <ig:message />
       <table class="table_style">
						
					
							<tr>
								<th width="5%">序号</th>
								<th width="25%">预算名称</th>
								<th width="25%">费用名称</th>
								<th width="11%">费用金额（元）</th>
								<th width="12%">发生时间</th>
								<th width="12%">登记时间</th>

							</tr>
						
						
						<!-- body部 -->
						
                            <logic:present name="IGFIN02012VO" property="expenseDataList">
								<logic:iterate id="bean" name="IGFIN02012VO"
									property="expenseDataList" indexId="index" type="com.deliverik.infogovernor.fin.model.Expense">
									<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="doLook('IGFIN0207_Disp.do?eid=<bean:write name="bean" property="exid" />');" >
										<!-- 编号 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="exid">&nbsp;</logic:empty>${PagingDTO.viewStartCount+index}</div>
										</td>
										<!-- 预算名称-->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="btitle">&nbsp;</logic:empty> ${bean.btitle}</div>
										</td>
										<!-- 费用名称-->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="exapvname">&nbsp;</logic:empty> ${bean.exapvname}</div>
										</td>
										<!-- 费用金额 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="examount">&nbsp;</logic:empty> <bean:write name="bean" property="examount" format="##.##"/></div>
										</td>
										<!-- 说明 -->
										
										<!-- 发生时间 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="exopentime">&nbsp;</logic:empty> ${bean.exopentime}</div>
										</td>
										<!-- 登记时间 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="exclosetime">&nbsp;</logic:empty> ${bean.exclosetime}</div>
										</td>
										<!-- 详细情况 -->
										
									</tr>
								</logic:iterate>
							</logic:present>
						
					</table>
     </div>
	<div id="operate">
        <jsp:include page="/include/paging.jsp" />
	</div>
</div>
</div>
</div>
</div>
</body>
</html:html>