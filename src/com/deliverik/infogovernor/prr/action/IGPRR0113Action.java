/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.prr.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0113Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01131VO;

/**
 * @Description: 流程SUPER分派Action
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
public class IGPRR0113Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRR0113Action.class);
	
	/**
	 * <p>
	 * Description: SUPER分派action
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGPRR0113Form form = (IGPRR0113Form)actionForm;
		//获取BL接口实例
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//实例化DTO
		IGPRR01DTO dto = new IGPRR01DTO();
		String forward = "DISP";
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUser(user);
		dto.setIgPRR0113Form(form);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========参与者查询处理开始========");
			//调用BL查询
			dto = ctlBL.initIGPRR0113Action(dto);
			//构造VO
			IGPRR01131VO vo = new IGPRR01131VO();
			vo.setRoleList(dto.getRoleList());
			vo.setLst_IGPRR01132VO(dto.getMap_ParticipantToBeAssign());
			vo.setOrg_List(dto.getOrg_List());
			super.<IGPRR01131VO>setVO(request, vo);
			saveToken(request);
			if(IGPRDCONSTANTS.MODE_OA.equals(form.getPsdmode())) {
				if(IGPRDCONSTANTS.PSDASSIGN_ORG.equals(form.getPsdassign())){
					forward = "OA2";
				}else{
					forward = "OA";
				}
			} else {
				if(IGPRDCONSTANTS.PSDASSIGN_ROLE.equals(form.getPsdassign())) {
					forward = "ROLE";
				}
			}
			log.debug("========参与者查询处理终了========");
		}
		if ("ADMIN".equals(mapping.getParameter())){
			log.debug("========参与者查询处理开始========");
			//调用BL查询
			dto = ctlBL.initIGPRR0113Action(dto);
			//构造VO
			IGPRR01131VO vo = new IGPRR01131VO();
			vo.setRoleList(dto.getRoleList());
			vo.setLst_IGPRR01132VO(dto.getMap_ParticipantToBeAssign());
			vo.setOrg_List(dto.getOrg_List());
			super.<IGPRR01131VO>setVO(request, vo);
			saveToken(request);
			//调整角色
			if("0".equals(form.getFlag())) {
				if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(form.getPsdtype())) {
					if(IGPRDCONSTANTS.MODE_OA.equals(form.getPsdmode())) {
						forward = "OA";
					} else {
						forward = "ROLE";
					}
				} else {
					forward = "NORMAL_ROLE";
				}
			} else {
				if(IGPRDCONSTANTS.PROCESS_NODE_TYPE_CONCURRENCY.equals(form.getPsdtype())) {
					forward = "DISP";
				} else {
					forward = "NORMAL_USER";
				}
			}
			log.debug("========参与者查询处理终了========");
		}
		//处理人
		if ("SUPER".equals(mapping.getParameter())){
			log.debug("========参与者分派处理开始========");
			dto.setIgPRR0113Form(form);
			//添加角色
			if(isTokenValid(request,true)){
				ctlBL.addProcessParticipantBySuper(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			request.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// 工单号
			request.setAttribute("prid",dto.getProcess().getPrid());
			request.setAttribute("pts",dto.getProcess().getPrtype());
			log.debug("========参与者分派处理终了========");
		}
		//主办机构改派
		if("SUPERORG".equals(mapping.getParameter())){
			log.debug("==============参与者分派处理开始===============");
			if(isTokenValid(request,true)){
				dto.setIgPRR0113Form(form);
				ctlBL.addProcessParticipantByOrgSuper(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			request.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// 工单号
			request.setAttribute("prid",dto.getProcess().getPrid());
			request.setAttribute("pts",dto.getProcess().getPrtype());
			log.debug("==============参与者分派处理终了===============");
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		if(!"DISP".equals(mapping.getParameter()) && !"ADMIN".equals(mapping.getParameter())){
			//act表示保持高亮菜单不变
			String url = "/IGPRR0102_Disp.do?clear=1&act=0&prid=" + form.getPrid() + "&jump=" + form.getJump();
			form = new IGPRR0113Form();
			request.getSession().removeAttribute("AD_columnInfoMap");
			request.getSession().removeAttribute("ADroleList");
			request.getSession().removeAttribute("IGPRR01021VO");
			return new ActionForward(url);
		}
		return mapping.findForward(forward);
	}
	
}
