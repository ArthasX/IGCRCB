<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0202" toScope="request" />
<bean:define id="title" value="预算查询画面" toScope="request" />
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

function setParentValue(bid,btitle){
    if(!window.opener.closed){
        window.opener.setParamIGFIN0202(bid,btitle);
    }
    window.close();
}

function clearParentValue(){
    if(!window.opener.closed){
        window.opener.setParamIGFIN0202("","");
    }
    window.close();
}
</script>
<body style="background-image: none;background-color: #FFFFFF;">
<!--container  内容-->
   <div id="location">
       <div class="image"></div>
        <p class="fonts1">服务管理 &gt;&gt; 预算管理 &gt;&gt; 预算查询</p>
    </div>
   <div id="search">
    <html:form styleId="form" action="/IGFIN0202" onsubmit="return checkSubmit(this);">
         <div class="img"></div>
          <div class="conditions">
      <div>
       <span>类型：</span><html:select name="IGFIN0202Form" property="btype" style="width: 100px;" errorStyleClass="inputError">
            <ig:optionsCollection ccid="BUDGET_TYPE_CATEGORY_CODE" isMakeBlankRow="true" isCodeLabel="true" />
             </html:select>&nbsp;&nbsp;
        <span>时间：</span><span>从</span><html:text name="IGFIN0202Form" property="bopentime" styleId="bopentime" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
   		<img src="images/date.gif" align="middle" onClick="calendar($('bopentime'))" border="0"/>&nbsp;&nbsp;
        <span>到</span><html:text name="IGFIN0202Form" property="bclosetime" styleId="bclosetime" errorStyleClass="inputError imeDisabled" size="10" readonly="true"/>
         <img src="images/date.gif" align="middle" onClick="calendar($('bclosetime'))" border="0"/>&nbsp;&nbsp;
         <span>预算名称：</span>
       <html:text name="IGFIN0202Form" property="btitle" styleId="btitle" errorStyleClass="inputError imeDisabled" size="10" />
       <html:submit property="btn_search" styleClass="button" value="查询" />
       </div>
      </div>
    </html:form>  
    </div>
     <div id="results_list"><ig:message />
       <table border="0" cellpadding="0" cellspacing="0"  class="table_style">
						<!-- header部 -->
							<tr>
								<th width="5%">序号</th>
								<th width="10%">类型</th>
								<th width="15%">预算名称</th>
								<th width="15%">项目名称</th>
								<th width="35%">说明</th>
								<th width="10%">起始时间</th>
								<th width="10%">结束时间</th>
						
							</tr>
						
						<!-- body部 -->
                            <logic:present name="IGFIN02011VO" property="budgetDataList">
								<logic:iterate id="bean" name="IGFIN02011VO"
									property="budgetDataList" indexId="index">
									<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,'');" onclick="setParentValue('${bean.bid}','${bean.btitle}');" >
										<!-- 编号 -->
										<td>
										<logic:empty name="bean"
											property="bid">&nbsp;</logic:empty>${PagingDTO.viewStartCount+index}
										</td>
										<!-- 类型-->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="btype">&nbsp;</logic:empty> <ig:codeValue ccid="BUDGET_TYPE_CATEGORY_CODE" cid= "${bean.btype}" isChild="true"/></div>
										</td>
										<!-- 预算名称 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="btitle">&nbsp;</logic:empty> ${bean.btitle}</div>
										</td>
										<!-- 费用名称 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="pname">&nbsp;</logic:empty> ${bean.pname}</div>
										</td>
										<!-- 说明 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="bdesc">&nbsp;</logic:empty> ${bean.bdesc}</div>
										</td>
										<!-- 起始时间 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="bopentime">&nbsp;</logic:empty> ${bean.bopentime}</div>
										</td>
										<!-- 结束时间 -->
										<td>
										<div class="nowrapDiv"><logic:empty name="bean"
											property="bclosetime">&nbsp;</logic:empty> ${bean.bclosetime}</div>
										</td>
									</tr>
								</logic:iterate>
							</logic:present>
					</table>
     </div>
     <div id="operate">
	<jsp:include page="/include/paging.jsp" />
	</div>
	<div class="enter">
		<input type="button" name="btn_clear" value="清空" onclick="clearParentValue()" class="button">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</body>
</html:html>