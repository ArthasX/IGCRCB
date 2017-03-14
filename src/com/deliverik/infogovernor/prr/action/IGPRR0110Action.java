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
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0110Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01101VO;
 
/**
 * @Description: 流程状态日志查看Action
 * @Author  
 * @History 2010-9-13     新建 
 * @Version V1.0
 */
public class IGPRR0110Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGPRR0110Action.class);
	
	/**
	 * <p>
	 * Description: 流程状态日志查看action处理
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
		IGPRR0110Form form = (IGPRR0110Form)actionForm;
		//获取BL接口实例
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		//实例化DTO
		IGPRR01DTO dto = new IGPRR01DTO();
		log.debug("========流程状态日志查看处理开始========");
		dto.setPrid(form.getPrid());
		//调用BL查询
		dto = ctlBL.searchRecordStatusLogAction(dto);
		//构造VO
		IGPRR01101VO vo = new IGPRR01101VO(dto.getRecordStatusLogList());
			
		super.<IGPRR01101VO>setVO(request, vo);
			
		List<ActionMessage> messageList = dto.getMessageList();
			
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		log.debug("========流程状态日志查看处理终了========");
		return mapping.findForward("DISP");
	}

}
