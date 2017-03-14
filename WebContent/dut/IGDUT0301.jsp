<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGDUT0301" toScope="request" />
<bean:define id="title" value="值班情况按日期汇总日历画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
function back(year,month){
	var form = document.getElementById("submitForm");
	form.action="IGDUT0301_Disp.do?forward=back&showYear=" + year + "&showMonth=" + month;
	form.submit();
}

function next(year,month){
	var form = document.getElementById("submitForm");
	form.action="IGDUT0301_Disp.do?forward=next&showYear=" + year + "&showMonth=" + month;
	form.submit();
}
</script>
<!-- /header1 -->
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
              <p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; 值班日期汇总</p>
       </div>
       <form id="submitForm" method="post" >
       <div id="results_list">
	      <table width="700" border="0" align="center" cellspacing="0" cellpadding="0" style="margin-top:40px;">
	    	<tr height="20">
			  	<td width="26">
			  		<a href="#" onclick="back(${IGDUT03011VO.calendarYear},${IGDUT03011VO.calendarMonth});">
				  		<img src="images/up.gif" alt="上月" border="0" />
				  	</a>
			  	</td>
				<td width="26">
					<a href="#" onclick="next(${IGDUT03011VO.calendarYear},${IGDUT03011VO.calendarMonth + 1});">
						<img src="images/next.gif" alt="下月" border="0" />
					</a>
				</td>
				<td width="145" align="left" style="font-size:14px; font-weight:bold">
				${IGDUT03011VO.calendarYear}年${IGDUT03011VO.calendarMonth + 1}月</td>
				<td width="226">&nbsp;</td>
				<td width="139">
					&nbsp;
				</td>
				<td width="138">
					&nbsp;
				</td>
		  	</tr>
		  </table>
        <table width="710" border="0" cellspacing="1" cellpadding="4"  bgcolor="#7CA8FE"  align="center" >
		  <tr height="20" align="center" style="font-size:14px;">
			<td width="100" bgcolor="#9DBEFF">星期日</td>
			<td width="100" bgcolor="#9DBEFF">星期一</td>
			<td width="100" bgcolor="#9DBEFF">星期二</td>
			<td width="100" bgcolor="#9DBEFF">星期三</td>
			<td width="100" bgcolor="#9DBEFF">星期四</td>
			<td width="100" bgcolor="#9DBEFF">星期五</td>
			<td width="100" bgcolor="#9DBEFF">星期六</td>
		  </tr>
		  <logic:iterate id="row" name="IGDUT03011VO" property="weekVOList">
		   <tr height="40">
		   <logic:iterate id="cell" name="row" property="cellVOList">
				<td bgcolor="${cell.bgColor}">
					<table width="100%" border="0" cellspacing="0" cellpadding="0" 
					<logic:equal name="cell" property="link" value="1">
						style="cursor: hand" 
						onclick="javascript:window.location='IGDUT0302.do?dptime=${cell.dptime}&dadcategory=${IGDUT0301Form.dadcategory}&showYear=${IGDUT03011VO.calendarYear}&showMonth=${IGDUT03011VO.calendarMonth}'"
					</logic:equal>
						>
	              		<tr height="20">
			                <td style="font-size:16px;">
			                		${cell.showDay}
			                </td>
			                <td>&nbsp;</td>
			                <td>&nbsp;</td>
	              		</tr>
			            <tr height="20">
			                <td colspan="3" align="center">
			                	${cell.redimg}&nbsp;
			                	${cell.yellowimg}&nbsp;
			                	<a onclick="javascript:window.location='IGDUT0402.do?datetime_from=${cell.dptime}&datetime_to=${cell.dptime}'">${cell.delayimg}</a>
			                </td>
			            </tr>
	            	</table>
	            </td>
            </logic:iterate>
		  </tr>
		  </logic:iterate>
		</table>
		
		<table width="400" border="0" cellspacing="5" cellpadding="0"  align="center" style="margin-top:10px;">
            <tr height="12" align="center">
			  <td width="20">
			  	<img src="images/red_light.gif">
			  </td>
              <td width="100" align="left">有异常情况出现</td>
			  <td width="20">
			  	<img src="images/yellow_light.gif">
			  </td>
              <td width="100" align="left">未按规定时间填报</td>
              <td width="20">
			  	<img src="images/sq.gif">
			  </td>
              <td width="100" align="left">有延时解锁登记</td>
            </tr>
          </table>
		</div>
		</form>
    </div>
</div>
</div>
</div>
</body>
</html:html>