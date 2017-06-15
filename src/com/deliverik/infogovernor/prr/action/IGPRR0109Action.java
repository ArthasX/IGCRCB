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
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0109Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01091VO;

/**
 * @Description: 流程OA执行人Action
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
public class IGPRR0109Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRR0109Action.class);
	
	/**
	 * <p>
	 * Description: 执行人处理action
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGPRR0109Form form = (IGPRR0109Form)actionForm;
		//获取BL接口实例
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//实例化DTO
		IGPRR01DTO dto = new IGPRR01DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setPrid(form.getPrid());
		dto.setUser(user);
		dto.setIgPRR0109Form(form);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========执行人查询处理开始========");
			
			//调用BL查询
			dto = ctlBL.searchAssignOAPersonAction(dto);
			//构造VO
			IGPRR01091VO vo = new IGPRR01091VO(dto.getUserInfoList());
			super.<IGPRR01091VO>setVO(request, vo);
			saveToken(request);
			log.debug("========执行人查询处理终了========");
		}
		//执行人
		if ("MANAGER".equals(mapping.getParameter())){
			log.debug("========执行人处理开始========");
			dto.setIgPRR0109Form(form);
			
			if (isTokenValid(request, true)){
				dto = ctlBL.assignOAPersonAction(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			
			request.setAttribute("prserialnum", dto.getProcess().getPrserialnum());// 工单号
			request.setAttribute("prid",dto.getProcess().getPrid());
			request.setAttribute("pts",dto.getProcess().getPrtype());
			log.debug("========执行人处理终了========");
			//====>
			ActionForward actionForward = new ActionForward();
			actionForward.setPath("/IGPRR0102_Disp.do?prtype=WD&prid=" + dto.getProcess().getPrid());
			return actionForward;
			//====>
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}
	
}
