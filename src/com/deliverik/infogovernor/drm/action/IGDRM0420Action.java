/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.drm.action;


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
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0420Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04201VO;

/**
 * 资产下拉数据选择画面Action处理
 *
 */

public class IGDRM0420Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM0420Action.class);
	
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
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		IGDRM0420Form form = (IGDRM0420Form)actionForm;
		//实例化DTO
		IGDRM04DTO dto = new IGDRM04DTO();
		dto.setIgdrm0420Form(form);
		//选择流程类型查询
		log.debug("========资产下拉数据查询处理开始========");
		
		//调用BL查询
		if("CHANGE_STATUS".equals(mapping.getParameter())){
			dto.setStrflag("status");
		}else if("CHANGE_VALUE".equals(mapping.getParameter())){
			dto.setStrflag("changeValue");
		}
		dto = ctlBL.searchCfgCodeDetailByCategory(dto);
		//构造VO
		IGDRM04201VO vo = new IGDRM04201VO(dto.getConfigurationCodeDetailList());
		super.<IGDRM04201VO>setVO(req, vo);
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
