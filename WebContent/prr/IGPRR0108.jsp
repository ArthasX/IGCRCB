<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/tags/struts-html" prefix="html"%>
<%@ taglib uri="/tags/struts-bean" prefix="bean"%>
<%@ taglib uri="/tags/struts-logic" prefix="logic"%>
<%@ taglib uri="/tags/ig-tags" prefix="ig"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.deliverik.framework.workflow.IGPRDCONSTANTS"%>
<%@ page import="com.deliverik.infogovernor.prr.bl.IGPRR01BLType"%>
<script>
function submit_fb(cruid,prid,buttonname){
	if( window.confirm("您是否确认查看？")){
	    window.location.href = getAppRootUrl() + "/IGPRR0114_UPDATE.do?cruid="+cruid+"&prid="+prid;
	}
}
</script>
	<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
			<logic:equal name="IGPRR01021VO" property="isRoleManager" value="true">
			<logic:equal name="IGPRR01021VO" property="showExecutor" value="true">
				<div class="action">
					<img src="images/zxr.gif" width="22"
						height="16" />
					<!-- 130225Begin 流程可分派机构相关修改-按钮显示修改 -->
					<logic:equal value="2" name="IGPRR0102Form" property="psdassign">
						<a href="###" onclick="orgManager('${IGPRR01021VO.process.prid}','${IGPRR01021VO.status}','${IGPRR0102Form.pporgid }')"
							 title="根据机构查询">执行人</a>&nbsp;&nbsp;
					</logic:equal>
					<logic:notEqual value="2" name="IGPRR0102Form" property="psdassign">
						<a href="###" onclick="roleManager('${IGPRR01021VO.process.prid}','<%=IGPRR01BLType.PROCESS_PEOPLE%>');" title="根据角色查询">执行人</a>&nbsp;&nbsp;
					</logic:notEqual>
					<!-- 130225End  -->
				</div>
			</logic:equal>
			</logic:equal>
		</logic:present>	
		<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		<c:if test="${IGPRR01021VO.isRoleManager == 'true' && IGPRR01021VO.processStatusDef.psdmode == '2' && IGPRR01021VO.hasDutyPerson}">
			<div class="action">
				<img src="images/qsgz1.gif" width="16"
					height="16" />
				<!-- 130225Begin 流程可分派机构相关修改-按钮显示修改 -->
				<logic:equal value="2" name="IGPRR0102Form" property="psdassign">
					<a href="###" onclick="grantDutyPersonOrg('${IGPRR0102Form.pporgid}');" title="给部门值班人授权">授权提交</a>&nbsp;&nbsp;
				</logic:equal>
				<logic:notEqual value="2" name="IGPRR0102Form" property="psdassign">
					<a href="###" onclick="grantDutyPerson('${IGPRR01021VO.process.prid}');" title="给角色值班人授权">授权提交</a>&nbsp;&nbsp;
				</logic:notEqual>
				<!-- 130225End  -->
			</div>
		</c:if>
		</logic:present>	
		<logic:present name="IGPRR01021VO" property="lst_ParticipantVisibleButtonVWInfo">
		<c:if test="${IGPRR01021VO.dutyPerson && IGPRR01021VO.processStatusDef.psdmode == '2'}">
			<div class="action">
				<img src="images/tz.gif" width="16"
					height="16" />
				<!-- 130225Begin 流程可分派机构相关修改-按钮显示修改 -->
				<logic:equal value="2" name="IGPRR0102Form" property="psdassign">
					<a href="###" onclick="noticeOrgManager('${IGPRR0102Form.pporgid}');" title="给部门负责人发短信">通知</a>&nbsp;&nbsp;
				</logic:equal>
				<logic:notEqual value="2" name="IGPRR0102Form" property="psdassign">
					<a href="###" onclick="noticeRoleManager('${IGPRR01021VO.process.prid}');" title="给角色负责人发短信">通知</a>&nbsp;&nbsp;
				</logic:notEqual>
				<!-- 130225End -->
			</div>
		</c:if>
		</logic:present>	
	</logic:present>
	<logic:present name="IGPRR01021VO" property="superFlag">
		<logic:equal name="IGPRR01021VO" property="superFlag" value="1">
		<logic:equal name="IGPRR01021VO" property="isRoleManager" value="true">
			<div class="action">
				<img src="images/fp_1.gif" width="16"
					height="16" />
				<a href="###" onclick="assignNormal('${IGPRR01021VO.process.prid}', '${IGPRR01021VO.status}', '${IGPRR01021VO.processStatusDef.psdid}', 'super');">分派</a>&nbsp;&nbsp;
			</div>
		</logic:equal>
		</logic:equal>
		<logic:equal name="IGPRR01021VO" property="superFlag" value="2">
		<logic:equal name="IGPRR01021VO" property="isRoleManager" value="true">
			<div class="action">
				<img src="images/fp_1.gif" width="16"
					height="16" />
				<a href="###" onclick="assignOA('${IGPRR01021VO.process.prid}', '${IGPRR01021VO.status}', '${IGPRR01021VO.processStatusDef.psdid}', 'super');">分派</a>&nbsp;&nbsp;
			</div>
		</logic:equal>
		</logic:equal>
	</logic:present>
	<logic:notEqual value="C" name="IGPRR01021VO" property="status">
		<logic:notEqual value="#" name="IGPRR01021VO" property="status">
		<logic:present name="IGPRR01021VO" property="isAdmin">
			<logic:equal name="IGPRR01021VO" property="isAdmin" value="true">
				<div class="action"><img src="images/zz.gif" width="16" height="16" />
					<a href="###" onclick="checkForm('','','','<%=IGPRDCONSTANTS.BUTTON_TERMINATE%>')">中止</a>
				</div>
				<div class="action"><img src="images/js.gif" width="22" height="16" />
					<a href="###" onclick="assignNormal('${IGPRR01021VO.process.prid}', '${IGPRR01021VO.status}', '${IGPRR01021VO.processStatusDef.psdid}');">角色调整</a>&nbsp;&nbsp;
				</div>
				<div class="action"><img src="images/ry.gif" width="24" height="16" />
					<a href="###" onclick="assignOA('${IGPRR01021VO.process.prid}', '${IGPRR01021VO.status}', '${IGPRR01021VO.processStatusDef.psdid}');">人员调整</a>&nbsp;&nbsp;
				</div>
			</logic:equal>
		</logic:present>
		</logic:notEqual>
	</logic:notEqual>
	<logic:equal value="<%=IGPRDCONSTANTS.PROCESS_START_STATUS%>" name="IGPRR01021VO" property="status">
		<logic:present name="IGPRR01021VO" property="isInitiator">
			<logic:equal name="IGPRR01021VO" property="isInitiator" value="1">
				<div class="action"><img src="images/zz.gif" width="13" height="13" />
					<a href="###" onclick="checkForm('','','','<%=IGPRDCONSTANTS.BUTTON_TERMINATE%>')">中止</a>
				</div>
			</logic:equal>
		</logic:present>
	</logic:equal>
	<c:if test="${param.islook=='0' }">
		<div class="action">
		<img src="images/qr.gif" width="16" height="16" />
		<a href="###" onclick="submit_fb('${param.cruid }','${param.prid }');">确认</a>
		</div>
	</c:if>