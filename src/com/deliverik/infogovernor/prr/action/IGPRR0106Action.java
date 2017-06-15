/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.action;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.prr.bl.IGPRR01BL;
import com.deliverik.infogovernor.prr.dto.IGPRR01DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0106Form;
import com.deliverik.infogovernor.prr.vo.IGPRR01061VO;

/**
 * @Description: 查看表单日志Action
 * @Author  
 * @History 2010-9-17     新建 
 * @Version V1.0
 */
public class IGPRR0106Action extends BaseAction {

	static Log log = LogFactory.getLog(IGPRR0106Action.class);

	/**
	 * 处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("========查看表单日志处理开始========");
		//FORM取得
		IGPRR0106Form form = (IGPRR0106Form)actionForm;
		
		//BL取得
		IGPRR01BL ctlBL = (IGPRR01BL) getBean("igPRR01BL");
		
		String forward = "DISP";
		
		//DTO生成
		IGPRR01DTO dto = new IGPRR01DTO();

		if("DISP".equals(mapping.getParameter())){
			//表单日志查询
			dto.setRlid(form.getRlid());
			
			dto = ctlBL.getVarRecordLogs(dto);
			dto.setPrid(dto.getVarLogList().get(0).getPrid());
			Map<String,List<Attachment>> map =ctlBL.getProcessInfo(dto.getVarLogList().get(0).getPrid());

			
			//VO生成
			IGPRR01061VO vo = new IGPRR01061VO();
			vo.setVarLogList(dto.getVarLogList());
			vo.setAttachmentMap(map);
			super.<IGPRR01061VO>setVO(req, vo);

		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}
		log.debug("========查看表单日志处理终了========");
		return mapping.findForward(forward);
	}
	
	

}
