<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>

<html:html>
<bean:define id="id" value="IGDBM1200" toScope="request" />
<bean:define id="title" value="工作查询画面" toScope="request" />
<!-- header1 -->
<jsp:include page="/include/header1.jsp" />
<!-- /header1 -->
<link type="text/css" href="css/cs_style.css" rel="stylesheet" />

<body>
<div id="maincontent">
<!--header  头部和 一级菜单-->
<!--container 左菜单 右侧内容-->
<div id="container">
<html:form action="/IGDBM1200_page.do" styleId="form" onsubmit="return checkSubmit(this);">
	<html:hidden property="prpdid"/>
	<html:hidden property="propentime_like"/>
	<html:hidden property="prstatus"/>
	<html:hidden property="other"/>
	<html:hidden property="month"/>
	<html:hidden property="prActive"/>
	<html:hidden property="varnames"/>
	<html:hidden property="varvalues"/>
	<html:hidden property="rcrrealtime_like"/>
	<html:hidden property="rcclass"/>
	<html:hidden property="rcrtestmode"/>
	<html:hidden property="ppuserid"/>
	<html:hidden property="esyscoding"/>
	<html:hidden property="prclose"/>
	<html:hidden property="pivarvalue"/>
	<html:hidden property="countid"/>
	<html:hidden property="type"/>
    <div id="location" style="margin-top:10px">
        <div class="image"></div>
            <p id="titl" class="fonts1">工作查询</p>
    </div>
	<div id="results_list">
	
	<logic:empty name="prFalg">
	<table class="table_style">
		<tr>
			<th width="10%">编号</th>
			<th width="30%">名称</th>
			<th width="10%">类型</th>
			<th width="10%">发起者</th>
			<th width="10%">发起时间</th>
			<th width="10%">关闭时间</th>
			<th width="15%">状态</th>
		</tr>
		<logic:present name="IGDBM12001VO" property="prList">
			<logic:iterate id="bean" name="IGDBM12001VO" property="prList">
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,''); " onclick="javascript:openRelatedProcess('${bean.prid}','${bean.prtype}');">
					<td>	
							${bean.prserialnum}
				
					</td>
					<td>
		
							${bean.prtitle}
					</td>
					<td>
							${bean.prpdname}
					
					</td>
					<td>
							${bean.prusername}
					</td>
					<td>
							${bean.propentime}
					</td>
					<td>	
							${bean.prclosetime}
					</td>
					<td><ig:processDefineTypeValue prid="${bean.prid}"/></td>
				</tr>
			</logic:iterate>
		</logic:present>
		<!-- 118资产显示 -->
	<logic:present name="IGDBM12001VO" property="assetList">
	<logic:iterate id="bean" name="IGDBM12001VO" property="assetList">
				<tr onmouseover="mouseOver(this);" onmouseout="mouseOut(this,''); " onclick="">
					<td>	
							${bean.eilabel}</a>
					</td>
					<td>
							${bean.einame}
					</td>
					<td>
							${bean.esyscoding}
					</td>
					<td>
							${bean.eiusername}
					</td>
					<td>
							${bean.eiinsdate}
					</td>
					<td>	
							${bean.eiupdtime}
					</td>
					<td>	
							${bean.eistatus}
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
	</table>
	</logic:empty>
	<logic:notEmpty name="prFalg">
	<table class="table_style">
		<logic:equal value="999017" name="esyscoding">
		<tr>
			<th width="10%">风险领域</th>
			<th width="10%">风险子域</th>
			<th width="10%" >风险项</th>
			<th width="8%">风险点编号</th>
			<th width="14%">风险点名称</th>
			<th width="6%">风险级别</th>
			<th width="10%">风险严重等级</th>
			<th width="12%">风险发生可能性</th>
			<th width="6%">管理人</th>
		</tr>
		<logic:present name="IGDBM12001VO" property="riskPointList">
			<logic:iterate id="bean" name="IGDBM12001VO" property="riskPointList">
				<tr class="<ig:rowcss index="${index}"/>">
<%-- 						<td> <input type="checkbox"   style="width:20px;" name="deleteEiid" value="${bean.eiid}"/></td> --%>
						<td>
							${bean.riskly }
						</td>
							
						<td>
							${bean.riskarea}
						</td>
							
						<td>
							${bean.riskitem}
						</td>
						<td>
						<a href="javascript:void(0)" onclick="checkitemrisk('${bean.eiid}','${bean.eiversion }')">${bean.eilabel}</a>
<%-- 						${bean.eilabel} --%>
						</td>
						
						<td>
							${bean.einame }
							
						</td>
						<td>
							${bean.levels }
						</td>
						<td>
							${bean.grad }
						</td>
						<td>
							${bean.poss }
						</td>
						<td>
							
							${bean.mguserid}
						</td>
					</tr>
			</logic:iterate>
		</logic:present>
		</logic:equal>
		<logic:equal value="999018" name="esyscoding">
		
		<tr>
		 	<th width="2%">
             <label>
             <input type="checkbox" style="width:20px;" name="allbox" id="allbox" onclick="selectAll('allbox','deleteEiid')"/>
             </label>
           	</th>
			<th width="10%">风险领域</th>
			<th width="10%">风险子域</th>
			<th width="8%" >风险项</th>
			<th width="8%">检查项编号</th>
			<th width="16%">检查项名称</th>
			<th width="12%">检查项说明</th>
			<th width="6%">管理人</th>
			<th width="6%">登记日</th>
			<th width="8%">建议检查频度</th>
		</tr>
	
	 <logic:present name="IGDBM12001VO" property="checkItemList" >
            <logic:iterate id="bean" name="IGDBM12001VO" property="checkItemList" indexId="index">
				<tr class="<ig:rowcss index="${index}"/>">

					<td> <input type="checkbox"   style="width:20px;" name="deleteEiid" value="${bean.eiid}"/></td>
					<td>
						${bean.riskly }
					</td>
						
					<td>
						${bean.riskarea}
					</td>
						
					<td>
						${bean.riskitem}
					</td>
					<td>
						<a href="javascript:void(0)" onclick="checkitem('${bean.eiid}','${bean.eiversion }')">${bean.eilabel}</a>
<%-- 						${bean.eilabel} --%>
					</td>
					
					
					
					<td title="${bean.einame }">
						<ig:SubstringShowEllipsisWriteTag len="10" showEllipsis="true">
							${bean.einame }
						</ig:SubstringShowEllipsisWriteTag>
					</td>
					<td title="${bean. eidesc}">
						<ig:SubstringShowEllipsisWriteTag len="10" showEllipsis="true">
							${bean. eidesc}
						</ig:SubstringShowEllipsisWriteTag>
					</td>
					<td>
						${bean.mguserid }
					</td>
					<td>
						${bean.eiinsdate }
					</td>
					<td>
						${bean.checkfrequency }
					</td>
				</tr>
				
				</logic:iterate>
				</logic:present>
		</logic:equal>
		
		<logic:equal value="999020" name="esyscoding">
		<tr>
			<th width="86px" >
				<a href="IGASM3201.do?orderVal=prserialnum">风险事件名称
			</th>
			
			<th width="86px">
				<a href="IGASM3201.do?orderVal=prtitle">风险点名称			
			</th>
			
			<th width="86px"><a href="IGASM3201.do?orderVal=prstatus">风险严重等级
			</th>
			
			<th width="100px"><a href="IGASM3201.do?orderVal=prusername">风险发生可能性
			</th>
			
			<th width="60px">风险级别</th>
			
			<th width="90px"><a href="IGASM3201.do?orderVal=prclosetime">风险识别时间
			</th>
			
			<th width="86px"><a href="IGASM3201.do?orderVal=propentime">应对任务名称
			</th>
			
			<th width="60px"><a href="IGASM3201.do?orderVal=prclosetime">应对策略
			</th>
			
			<th width="60px"><a href="IGASM3201.do?orderVal=prclosetime">应对目标
			</th>
			
			<th width="60px"><a href="IGASM3201.do?orderVal=prclosetime">应对部门
			</th>
			
			<th width="86px"><a href="IGASM3201.do?orderVal=prclosetime">应对负责人
			</th>
			
			<th width="86px"><a href="IGASM3201.do?orderVal=prclosetime">抄送风控人员
			</th>
			
			<th width="56px"><a href="IGASM3201.do?orderVal=prclosetime">评审结果
			</th>
			
			<th width="60px"><a href="IGASM3201.do?orderVal=prclosetime">状态
			</th>
		</tr>
		<logic:present name="IGDBM12001VO" property="riskcaseList">
			<logic:iterate id="bean" name="IGDBM12001VO" property="riskcaseList"
				indexId="index">
				<tr class="alarmcolor_level" style='cursor:hand' onclick="checkForm('${bean.EIID}');">
					<td>
						${bean.fcname}
					</td>
					<td title="${bean.fcriskname}">
						<ig:SubstringShowEllipsisWriteTag len="10" showEllipsis="true">
							${bean.fcriskname}
						</ig:SubstringShowEllipsisWriteTag>
					</td>
					<td>
						${bean.fcseveritylevel}
					</td>
					<td>
						${bean.fcpossibility}
					</td>
					<td>
						${bean.fclevel}
					</td>
					<td>
						${bean.riskcatchtime}
					</td>
					<td>
						${bean.fcrisktask}
					</td>
					<td onmouseover="showPolicy('${bean.EIID}');">
						<ig:codeValue ccid="RISK_POLICY" cid="${bean.fcpolicy}"/>
					</td>
					<td>
						${bean.fcoperatoraim}
					</td>
					<td>
						${bean.fcoperatordept}
					</td>
					<td>
						${bean.fcoperator}
					</td>
					<td>
						${bean.fcccoperator}
					</td>
					<td>
						<ig:codeValue ccid="RISK_REVIEW_RESULT" cid="${bean.riskreviewresult}"/>
					</td>
					<td>
						<ig:codeValue ccid="RISK_STATUS" cid="${bean.EISTATUS}"/>
					</td>
				</tr>
			</logic:iterate>
		</logic:present>
		
		</logic:equal>
		</table>
	</logic:notEmpty>
	</div>
	
	<div id="operate">
	<jsp:include page="/include/paging.jsp" />
		<div class="enter">
			<input type="button" class="button" value="关闭" onclick="window.close();">
		</div>
	</div>
	</html:form>
	<script type="text/javascript">
	
	</script>
</div>
</div>

</body>

<script type="text/javascript">
jQuery(function(){
	if('${prFalg}'){
			document.forms[0].action = getAppRootUrl()+"/IGDBM1200_page_RiskRiskrepository.do";
		if('999017'=='${esyscoding}'){
			jQuery("#titl").html("风险点查询");
		}else{
			jQuery("#titl").html("检查项查询");
		}
	}
	
})

function checkitem(eid,version){
	window.location.href="IGASM2815_Disp.do?eiid="+eid+"&eiversion="+version+"&looksign=1";
}
function checkitemrisk(eid,version){
	window.location.href="IGASM2715_Disp.do?eiid="+eid+"&eiversion="+version+"&looksign=1";
}
</script>
</html:html>
