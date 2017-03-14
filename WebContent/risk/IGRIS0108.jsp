<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<html:html>
<bean:define id="id" value="IGRIS0108" toScope="request" />
<bean:define id="title" value="审计项查看页面" toScope="request" />
<jsp:include page="/include/header1.jsp" />
<script type="text/javascript">
</script>
<body>
<div id="maincontent">
   <div id="location">
       <div class="image"></div>
        <p class="fonts1">审计项查看</p>
    </div>
       <div id="formwrapper">
		   <div class="title">
			<div class="name">审计项信息</div>
			</div>
         <table cellspacing="2" class="table_style7">
          <tr>
            <th width="10%"><strong>版本名称</strong>：</th>
            <td width="40%">${IGRIS01051VO.riskAuditDef.raversion}</td>
            <th width="10%"><strong>审计项名称</strong>：</th>
            <td width="40%">${IGRIS01051VO.riskAuditDef.radname}</td>
           </tr>
          <tr>
            <th><strong>责任人</strong>：</th>
            <td>${IGRIS01051VO.riskAuditDef.radusername}</td>
            <th><strong>责任部门</strong>：</th>
            <td>${IGRIS01051VO.riskAuditDef.radorg}</td>
          </tr>
          <tr>
            <th><strong>风险程度</strong>：</th>
            <td><ig:codeValue ccid="RADRISKLEVEL_CODE" cid="${IGRIS01051VO.riskAuditDef.radrisklevel}" /></td>
            <th><strong>控制频率</strong>：</th>
            <td><ig:codeValue ccid="RADFREQUENCY_CODE" cid="${IGRIS01051VO.riskAuditDef.radfrequency}" /></td>
          </tr>
          <tr>
            <th><strong>控制手段</strong>：</th>
            <td><ig:codeValue ccid="RADMODE_CODE" cid="${IGRIS01051VO.riskAuditDef.radmode}" /></td>
             <th><strong>控制类型</strong>：</th>
            <td><ig:codeValue ccid="RADTYPE_CODE" cid="${IGRIS01051VO.riskAuditDef.radtype}" /></td>
          </tr>
          <tr>
            <th><strong>说明</strong>：</th>
            <td colspan="3">${IGRIS01051VO.riskAuditDef.raddesc}</td>
          </tr>
        </table>
         <div class="enter"><html:button property="btn_back" styleClass="button" value="关闭" onclick="window.close();" /></div>
    </div>
     </div>
</body>
</html:html>