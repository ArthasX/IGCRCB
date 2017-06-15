/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
import com.deliverik.infogovernor.drm.bl.IGDRM09BL;
import com.deliverik.infogovernor.drm.dto.IGDRM09DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0904Form;
import com.deliverik.infogovernor.drm.vo.IGDRM09041VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 应急指挥定义列表查询
 * </p>
 * 
 * @version 1.0
 */

public class IGDRM0904Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGDRM0904Action.class);
	

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//实例化FORM
		IGDRM0904Form form = (IGDRM0904Form)actionForm;
		//获取BL接口实例
		IGDRM09BL ctlBL = (IGDRM09BL) getBean("igdrm09BL");
		IGDRM09DTO dto = new IGDRM09DTO();
		
		if("SEARCH".equals(mapping.getParameter())){
			
			dto.setIgdrm0904Form(form);
			
			dto = ctlBL.getProcessDef(dto);
			
			IGDRM09041VO vo = new IGDRM09041VO(dto.getProcessDefinitionList());
			
			super.<IGDRM09041VO>setVO(request, vo);
			
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
