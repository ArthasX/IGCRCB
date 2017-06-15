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
import com.deliverik.infogovernor.prr.form.IGPRR0104Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01041VO;

/**
 * @Description: 流程改派Action
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
public class IGPRR0104Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRR0104Action.class);
	
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
		IGPRR0104Form form = (IGPRR0104Form)actionForm;
		//获取BL接口实例
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//实例化DTO
		IGPRR01DTO dto = new IGPRR01DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setPrid(form.getPrid());
		dto.setUser(user);
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========执行人查询处理开始========");
			//调用BL查询
			dto = ctlBL.searchProcessExecutorsAction(dto);
			//构造VO
			super.<IGPRR01041VO>setVO(request, new IGPRR01041VO(dto.getProcessExecutorVWList()));
			saveToken(request);
			log.debug("========执行人查询处理终了========");
		}
		//执行人
		if ("MANAGER".equals(mapping.getParameter())){
			log.debug("========执行人处理开始========");
			dto.setIgPRR0104Form(form);
			if (isTokenValid(request, true)){
				dto = ctlBL.adjustExecutorsAction(dto);//跃迁
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
			//by 张志颖--form里会保存角色ID，导致调整执行人后还能显示按钮，所以在初始化查看时清空角色ID
			actionForward.setPath("/IGPRR0102_Disp.do?prtype=WD&roleid=&prid=" + dto.getProcess().getPrid());
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
