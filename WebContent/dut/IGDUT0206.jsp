<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGDUT0206" toScope="request" />
<bean:define id="title" value="值班启动画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<script type="text/javascript">	
	 function changeStatus(dpid,dptime,currentdate){
		 if(!checkDateValue(currentdate,dptime)){
			 if(confirm("值班日期小于当前日期，是否启动？")){
					var form = document.getElementById("form");
					form.action="IGDUT0206_Change.do?dpid="+dpid;
					form.submit();

			 }
		 }else{
			 if(confirm("是否启动当前值班计划？")){
					var form = document.getElementById("form");
					form.action="IGDUT0206_Change.do?dpid="+dpid;
					form.submit();
			 }
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
          <html:form styleId="form" action="/IGDUT0206_Disp" onsubmit="return checkSubmit(this);">
            <div id="location">
                <div class="image"></div>
                    <p class="fonts1">服务管理 &gt;&gt; 值班管理 &gt;&gt; 值班启动</p>
            </div>
                
                <div id="results_list">
					<!--  message -->
					<ig:message />
					<!--  /message -->
                    <table class="table_style">
						<!-- header部 -->
						
							<tr>
								<th width="8%">
<!--								<label> <input type="checkbox" name="checkbox" id="checkbox" /> </label>-->
								序号
								</th>
								<th width="12%">值班日期</th>
								<th width="20%">白班/夜班</th>
								<th width="28%">值班人</th>
								<th width="10%"></th>
							</tr>
						
						<!-- body部 -->
						
                            <logic:present name="IGDUT02061VO" property="voList">
								<logic:iterate id="vo" name="IGDUT02061VO" property="voList" indexId="index">
									<tr class="<ig:rowcss index="${index}"/>">
										<td>
											<div class="nowrapDiv">${PagingDTO.viewStartCount+index}</div>
										</td>

										<!-- 值班日期 -->
										<td>
										<div class="nowrapDiv">${vo.dutyPlan.dptime}</div>
										</td>
										
										<!-- 白班/夜班 -->
										<td>
										<div class="nowrapDiv"><ig:codeValue 
											ccid="DUTY_PLANTYPE" cid="${vo.dutyPlan.dptype}" /></div>
										</td>
										
										<!-- 值班人 -->
										<td>
										<div class="nowrapDiv">${vo.name}</div>
										</td>
										
										<!--启动 -->
										<td>
											<a href="javascript:changeStatus('${vo.dutyPlan.dpid}','${vo.dutyPlan.dptime}','${IGDUT0206Form.currentdate}');">
												启动
											</a>
										</td>
									</tr>
									
									
								</logic:iterate>
							</logic:present>
					</table>
				</div>
				<html:hidden property="dadcategory" styleId="dadcategory" name="IGDUT0206Form"/>
            </html:form>
        </div>
    </div>
    <div class="zishiying"></div>
</div>


</div>
</body>
</html:html>