<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags/struts-html" prefix="html" %>
<%@ taglib uri="/tags/struts-bean" prefix="bean" %>
<%@ taglib uri="/tags/struts-logic" prefix="logic" %>
<%@ taglib uri="/tags/ig-tags" prefix="ig" %>
<html:html>
<bean:define id="id" value="IGASM3115" toScope="request"/>
<bean:define id="title" value="风险指标展示查询画面" toScope="request"/>

<!-- header1 -->
<jsp:include page="/include/header1.jsp"/>
<!-- /header1 -->
	<script type="text/javascript">
///////////////////////////////////////////////
//功能：合并表格
//参数：tb－－需要合并的表格ID
//参数：colLength－－需要对前几列进行合并，比如，
//想合并前两列，后面的数据列忽略合并，colLength应为2
//缺省表示对全部列合并
//data: 2005.11.6
///////////////////////////////////////////////
function uniteTable(tb,colLength){
	//检查表格是否规整
	//if (!checkTable(tb)) return;
	var i=0;
	var j=0;
	var rowCount=tb.rows.length; // 行数
	var colCount=tb.rows[0].cells.length; // 列数
	var obj1=null;
	var obj2=null;
	//为每个单元格命名
	for (i=0;i<rowCount;i++){
		for (j=0;j<colCount;j++){
			if (j==8 || j==9) continue;
			tb.rows[i].cells[j].id="tb__" + i.toString() + "_" + j.toString();
		}
	}
	//逐列检查合并
	for (i=0;i<colCount;i++){
		if (i==colLength) return;
		if (i==3 || i==4 || i==5) continue;
		obj1=document.getElementById("tb__0_"+i.toString())
		for (j=1;j<rowCount;j++){
			obj2=document.getElementById("tb__"+j.toString()+"_"+i.toString());
			if (obj1.innerText == obj2.innerText){
				obj1.rowSpan++;
				obj2.parentNode.removeChild(obj2);
			}else{
				obj1=document.getElementById("tb__"+j.toString()+"_"+i.toString());
			}
		}
	}
}
</script>
<body onload="uniteTable(mainTable,3)">
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
                <p class="fonts1"><ig:navigation extname1="${urlable}"/>  </p>
            </div>
		 <div id="results_list">
					    <table class="table_style" id="mainTable">
							<tr>
	                            <th width="30%">风险领域(一级分类)</th>
	                            <th width="25%">风险子域(二级分类)</th>
	                            <th width="25%">风险项</th>
	                            <th width="20%">数量</th>
	                            
							</tr>
							<logic:present name="IGASM31071VO" property="riskIndexShowList" >
		              		<logic:iterate id="bean" name="IGASM31071VO" property="riskIndexShowList" indexId="index">
							<tr>
								<td>${bean.riskly }</td>
								<td>${bean.riskarea}</td>
								<td>${bean.riskitem}</td>
								<td><a href="IGASM3116_Disp.do?esyscoding=${bean.esyscoding }">${bean.risknum }</a></td>
								<%-- <td>${bean.esyscoding }</td> --%>
							</tr>
							</logic:iterate>
							</logic:present>
					
							</table>
	
		</div>
		</div>
  </div>
 </div>
</div>
</body>
</html:html>