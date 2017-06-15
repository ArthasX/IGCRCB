<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGFIN0107" toScope="request" />
<bean:define id="title" value="预算查询" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">  
<!--
function getBudgetBid(){
	 if(!window.opener.closed){
		 var obj = document.getElementsByName("yscheck");
		 var data = new Array();
		 var index=0;
		 for(var i=0;i<obj.length;i++){
			 if(obj[i].checked){
				 var idx = obj[i].value;
				 var bid = document.getElementById("bid"+idx).value;
				 var btitle = document.getElementById("btitle"+idx).value;
				 var bsub1 = document.getElementById("sub1"+idx).value;
				 var bsub2 = document.getElementById("sub2"+idx).value;
				 var bsub3 = document.getElementById("sub3"+idx).value;
				 var bsub4 = document.getElementById("sub4"+idx).value;
				 var bsub5 = document.getElementById("sub5"+idx).value;
				 var bsub6 = document.getElementById("sub6"+idx).value;
				 var bsub7 = document.getElementById("sub7"+idx).value;
				 data[index]=new Array(bid,btitle,bsub1,bsub2,bsub3,bsub4,bsub5,bsub6,bsub7);
				 index++;
			 }
		 }
		window.opener.setPanrentParem(data);
	 }
	window.close();
}

-->
</script>
<body>

 <div id="location">
     <div class="image"></div>
      <p class="fonts1">预算查询</p>
  </div>  
     <div id="results_list">
       <table class="table_style">
						<tr>
							<th width="2%" ></th>
							<th width="5%">预算年度</th>
							<th width="10%">预算类别</th>
							<th width="20%">预算名称</th>
							<th width="8%">预算金额</th>
							<th>开发</th>
							<th>硬件</th>
							<th>软件</th>
							<th>工程</th>
							<th>其他</th>
							<th>实施</th>
							<th>其他</th>
						</tr>
						<logic:present name="IGFIN01013VO" property="pbsummaryList">
							<logic:iterate id="bean" name="IGFIN01013VO" property="pbsummaryList" indexId="idx">
								<tr>
									<td>
										<input type="checkbox" name="yscheck" value="${idx+1 }" />
										<input type="hidden" name="bid${idx+1 }" value="${bean.bid }"/>
									</td>
									<td>${bean.byear}</td>
									<td>${bean.btype}</td>
									<td>${bean.btitle}<input type="hidden" name="btitle${idx+1 }" value="${bean.btitle }"/></td>
									<td><bean:write name="bean" property="bamount" format="########.##" /></td>
									<td>${bean.sub1}<input type="hidden" name="sub1${idx+1 }" value="${bean.sub1 }"/></td>
									<td>${bean.sub2}<input type="hidden" name="sub2${idx+1 }" value="${bean.sub2 }"/></td>
									<td>${bean.sub3}<input type="hidden" name="sub3${idx+1 }" value="${bean.sub3 }"/></td>
									<td>${bean.sub4}<input type="hidden" name="sub4${idx+1 }" value="${bean.sub4 }"/></td>
									<td>${bean.sub5}<input type="hidden" name="sub5${idx+1 }" value="${bean.sub5 }"/></td>
									<td>${bean.sub6}<input type="hidden" name="sub6${idx+1 }" value="${bean.sub6 }"/></td>
									<td>${bean.sub7}<input type="hidden" name="sub7${idx+1 }" value="${bean.sub7 }"/></td>
								</tr>
							</logic:iterate>
						</logic:present>
					</table>
     </div>
     <div id="operate" style="text-align:center;">
    	 <input type="button" class="button" value="添加所选" onclick="getBudgetBid();">
		<input type="button" class="button" value="关闭" onclick="window.close();">
	</div>
</body>
</html:html>