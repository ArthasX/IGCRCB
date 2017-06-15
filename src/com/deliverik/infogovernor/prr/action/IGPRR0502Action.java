/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.prr.bl.IGPRR05BL;
import com.deliverik.infogovernor.prr.dto.IGPRR05DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0502Form;
import com.deliverik.infogovernor.prr.vo.IGPRR05021VO;

/**
 * 概述: 流程组成员列表查询Action
 * 功能描述: 流程组成员列表查询Action
 * 创建记录: 2015/02/03
 * 修改记录: 
 */
public class IGPRR0502Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRR0502Action.class);
	
	/**
	 * 流程组成员列表查询处理
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGPRR0502Form form = (IGPRR0502Form)actionForm;
		//获取BL接口实例
		IGPRR05BL ctlBL = (IGPRR05BL) getBean("igPRR05BL");
		IGPRR05DTO dto = new IGPRR05DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========流程组成员列表查询处理开始========");
			dto.setPgrid(form.getPgrid());
			//调用BL查询
			dto = ctlBL.searchProcessAction(dto);
			//构造VO
			IGPRR05021VO vo = new IGPRR05021VO();
			vo.setLst_IG500Info(dto.getLst_IG500Info());
			super.<IGPRR05021VO>setVO(request, vo);
			log.debug("========流程组成员列表查询处理终了========");
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
