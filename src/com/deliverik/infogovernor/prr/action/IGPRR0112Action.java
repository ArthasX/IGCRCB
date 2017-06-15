/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.security.UserPermission;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0112Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01021VO;

/**
 * @Description: 关联流程查看Action
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
public class IGPRR0112Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRR0112Action.class);

	/**
	 * 流程处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGPRR0112Form form = (IGPRR0112Form)actionForm;
		
		//BL取得
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		
		String forward = "DISP";
		IGPRR01021VO vo = new IGPRR01021VO();
		//DTO生成
		IGPRR01DTO dto = new IGPRR01DTO();
		dto.setPsdid(form.getPsdid());
		dto.setRoleid(form.getRoleid());
		dto.setSerialNum(form.getPrserialnum());

		//判断是否为快捷发起
		if(req.getParameter("isServiceStart")==null){
			req.setAttribute("isServiceStart", "");
		}else{
			req.setAttribute("isServiceStart",req.getParameter("isServiceStart"));
		}

		dto.setPsdcode(form.getPsdcode());
		dto.setIgPRR0102Form(form);
		dto.setWorkFlowParameterInfo(form);
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========查看关联流程处理开始========");
			//Session清除
			req.getSession().removeAttribute("IGPRR01021VO");
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto.setPrid(form.getPrid());

			//处理
			dto = ctlBL.initIGPRR0102Action(dto);
			//如果是角色负责人
			if(dto.isRoleManager()){
				vo.setIsRoleManager("true");
			}else{
				vo.setIsRoleManager("false");
			}
			req.getSession().setAttribute("AD_columnInfoMap", dto.getColumnInfoMap());
			req.getSession().setAttribute("AD_tableColumnValueMap", dto.getTableColumnValueMap());
			//设置流程处理时间
			vo.setDealtime(dto.getDealtime());
			req.setAttribute("personinfo", dto.getStatus());
			vo.setPrList(dto.getPrList());
			vo.setProcess(dto.getProcess());
			vo.setProcessStatusDef(dto.getProcessStatusDef());//流程状态信息

			//如果角色下拉框只有一个角色则画面不显示下拉框
			if(dto.getLabelList() != null && dto.getLabelList().size() == 1 ) {
				vo.setDisp("1");
				form.setPrrolename(dto.getLabelList().get(0).getLabel());
				form.setPpidstr(dto.getLabelList().get(0).getValue());
			}else{
				vo.setDisp("0");
			}
			req.getSession().setAttribute("ADroleList", dto.getLabelList());
			
			//区分流程，返回时调用
			if(req.getParameter("prtype")!=null){
				form.setPts(String.valueOf(req.getParameter("prtype")));
				req.setAttribute("prtype", String.valueOf(req.getParameter("prtype")));
			}else{
				if(StringUtils.isEmpty(form.getPts())){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD);
					req.setAttribute("prtype", IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD);
				}
			}
			if(req.getParameter("ptid")!=null){
				if(String.valueOf(IGPRDCONSTANTS.PROCESS_DEFINITION_ID).equals(String.valueOf(req.getParameter("ptid")))){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_ID);
				}else if(String.valueOf(IGPRDCONSTANTS.PROCESS_DEFINITION_PD).equals(String.valueOf(req.getParameter("ptid")))){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_PD);
				}else if(String.valueOf(IGPRDCONSTANTS.PROCESS_DEFINITION_CD).equals(String.valueOf(req.getParameter("ptid")))){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_CD);
				}else if(String.valueOf(IGPRDCONSTANTS.PROCESS_DEFINITION_DD).equals(String.valueOf(req.getParameter("ptid")))){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_DD);
				}else if(String.valueOf(IGPRDCONSTANTS.PROCESS_DEFINITION_SD).equals(String.valueOf(req.getParameter("ptid")))){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_SD);
				}else if(String.valueOf(IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID).equals(String.valueOf(req.getParameter("ptid")))){
					form.setPts(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD);
				}
			}
			vo.setProcessTitleDefTB(dto.getPtdTB());
			vo.setRecordLogMap(dto.getRecordLogMap());
			vo.setUserid(dto.getUser().getUserid());
			vo.setRoleid(dto.getRoleid() == null? 0 : dto.getRoleid());
			vo.setRecordLogMap(dto.getRecordLogMap());
			vo.setHasCLRecord("1".equalsIgnoreCase(dto.getHasCLRecord())?"1":"0");
			
			vo.setProcessInfoDefmap(dto.getVarmap());//页面变量集合
			vo.setLst_ParticipantVisibleButtonVWInfo(dto.getLst_ParticipantVisibleButtonVWInfo());//页面按钮
			vo.setProcessParticipantDeflist(dto.getProcessParticipantDeflist());//当前参与者
			vo.setHid(dto.getHid());//扩展信息是否显示
			vo.setIg715InfoList(dto.getIg715InfoList());//相关服务工单
			vo.setIG512InfoList(dto.getLst_IG512Info());//相关流程
			vo.setOrgid(dto.getOrgid());
			vo.setPieMap(dto.getPieMap());  //表格类表单关联资产信息
			vo.setProcessInfoFormValueMap(dto.getProcessInfoFormValueMap()); //流程类表单值map
			vo.setParticipantFormValueMap(dto.getParticipantFormValueMap()); //人员类表单值map
			vo.setTextAreaMap(dto.getTextAreaMap());

			if(req.getAttribute("nodetype")!=null){
				vo.setNodetype(String.valueOf(req.getAttribute("nodetype")));
			}
			//如果没有该节点的处理角色,只能查看的标志.
			List<LabelValueBean>  roleList = dto.getLabelList();
			if((roleList.size()==1 && "".equals(roleList.get(0).getValue())) || roleList.size()==0){
				if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(dto.getPsdcode())){
					req.setAttribute("disp", "none");
				}
			}

			//流程结束时只能看到基本信息
			if(vo.getActionlist()==null){
				if(!IGPRDCONSTANTS.PROCESS_END_STATUS.equals(dto.getPsdcode())){
					req.setAttribute("disp", "none");
				}
			}
			
			vo.setProcessInfolist(dto.getProcessInfo());
			vo.setProcessInfoEntityList(dto.getProcessInfoEntityList());

			super.<IGPRR01021VO>setVO(req.getSession(), vo);
			

			//设置菜单高亮
			if("DISP".equals(forward)) {
				//获取菜单权限
				UserPermission perm = (UserPermission)req.getSession().getAttribute("UserPermission");
				
				//设置高亮菜单
				if(perm != null) {
					String actsortid = null;//获取指定菜单ID的ACTSORTID
					if(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_ID.equals(form.getPrtype())
							||IGPRDCONSTANTS.PROCESS_DEFINITION_ID.equals(req.getParameter("ptid"))) {
						actsortid = perm.getActsortid("ACT02SVC02");
					} else if(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_PD.equals(form.getPrtype())
							||IGPRDCONSTANTS.PROCESS_DEFINITION_PD.equals(req.getParameter("ptid"))) {
						actsortid = perm.getActsortid("ACT02SVC03");
					} else if(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_CD.equals(form.getPrtype())
							||IGPRDCONSTANTS.PROCESS_DEFINITION_CD.equals(req.getParameter("ptid"))) {
						actsortid = perm.getActsortid("ACT02SVC04");
					} else if(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_DD.equals(form.getPrtype())
							||IGPRDCONSTANTS.PROCESS_DEFINITION_DD.equals(req.getParameter("ptid"))) {
						actsortid = perm.getActsortid("ACT02SVC05");
					} else if(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_SD.equals(form.getPrtype())
							||IGPRDCONSTANTS.PROCESS_DEFINITION_SD.equals(req.getParameter("ptid"))) {
						actsortid = perm.getActsortid("ACT02SVC06");
					} else if(IGPRDCONSTANTS.PROCESS_DEFINITION_TYPE_WD.equals(form.getPrtype())
							||IGPRDCONSTANTS.PROCESS_DEFINITION_COMMON_TEMPLATE_ID.equals(req.getParameter("ptid"))) {
						actsortid = perm.getActsortid("ACT02SVC09");
					}
					if(StringUtils.isNotEmpty(actsortid)){
						setSessionAttribute(req, "firstactid", actsortid.substring(0, 2));
						setSessionAttribute(req, "secondactid", actsortid.substring(0, 4));
					}
				}
			}
//			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			if(StringUtils.isEmpty(vo.getStatus())){
				vo.setStatus("C");
			}
			req.getSession().setAttribute("IGPRR01021VO", vo);
			log.debug("========查看关联流程处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		
		return mapping.findForward(forward);
	}
	
}
