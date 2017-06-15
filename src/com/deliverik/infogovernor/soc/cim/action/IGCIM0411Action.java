/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM04BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0411Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04111VO;

/**
 * 资产下拉数据选择画面Action处理
 *
 */

public class IGCIM0411Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM0411Action.class);
	
	/**
	 * <p>
	 * Description:选择数据ACTION处理
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author sunkaiyu@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		//获取BL接口实例
		IGCIM04BL ctlBL = (IGCIM04BL) getBean("igcim04BL");
		IGCIM0411Form form = (IGCIM0411Form)actionForm;
		//实例化DTO
		IGCIM04DTO dto = new IGCIM04DTO();
		//选择流程类型查询
		log.debug("========资产下拉数据查询处理开始========");
		
		//调用BL查询
		if("DISP".equals(mapping.getParameter())){
			saveToken(req);
			dto.setIgcim0411Form(form);
			dto = ctlBL.getCfgCodeDetailByCategory(dto);
			IGCIM04111VO vo = new IGCIM04111VO();
			vo.setConfigurationCodeDetail(dto.getConfigurationcodedetail());
			saveToken(req);
			super.<IGCIM04111VO>setVO(req, vo);
		} else if ("INSERT".equals(mapping.getParameter())){
			dto.setIgcim0411Form(form);
			if (isTokenValid(req, true)){
				dto = ctlBL.insertCfgCodeDetailAction(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		log.debug("========资产下拉数据查询处理终了========");
		return mapping.findForward("DISP");
	}

}
