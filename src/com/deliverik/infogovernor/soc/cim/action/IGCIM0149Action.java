/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.cim.action;

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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0149Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01491VO;

/**
 * 概述: 配置包含关系显示Action IGCIM0142Action
 * 功能描述: 配置包含关系显示Action
 * 创建记录: 2011/04/29
 * 修改记录: 
 */
public class IGCIM0149Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0149Action.class);

	/**
	 * 配置包含关系显示处理
	 *
	 * @param mapping ActionMapping 
	 * @param actionForm ActionForm 
	 * @param req HttpServletRequest 
	 * @param res HttpServletResponse 
	 * @return ActionForward
	 * @throws Exception
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//FORM取得
		IGCIM0149Form form = (IGCIM0149Form)actionForm;
		
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		
		if ("DISP".equals(mapping.getParameter())){
			log.debug("========配置包含关系显示开始========");
			
			dto.setIgcim0149Form(form);
			
//			dto = ctlBL.initIGAIM0146Action(dto);
			dto=ctlBL.getContainTree0149Action(dto);
			IGCIM01491VO vo = new IGCIM01491VO();
			vo.setInitTreeStr(dto.getInitTreeStr());
			log.info(" >> >> " + dto.getInitTreeStr());
			vo.setInitNodeID(dto.getInitNodeID());
			super.<IGCIM01491VO>setVO(req, vo);
			
			log.debug("========配置包含关系显示终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
