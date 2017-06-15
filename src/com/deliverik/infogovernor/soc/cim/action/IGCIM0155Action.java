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
import com.deliverik.infogovernor.soc.cim.form.IGCIM0155Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01551VO;

/**
 * 查询指标
 *
 */
public class IGCIM0155Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM0155Action.class);
	
	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCIM0155Form form = (IGCIM0155Form)actionForm;
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========查询指标处理开始========");
			
			dto.setIgcim0155Form(form);
			
			//获取集合
			dto = ctlBL.initIGCIM0155Action(dto);
			
			IGCIM01551VO vo = new IGCIM01551VO();
			super.<IGCIM01551VO>setVO(req, vo);
			
			//逻辑处理过程中的信息显示
			List<ActionMessage> messageList = dto.getMessageList();
			
			if( messageList != null && messageList.size() > 0 ) {
				for (ActionMessage message : messageList) {	
					addMessage(req, message);
				}
			}
			
			log.debug("========查询指标处理处理终了========");
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}

}
