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
import com.deliverik.infogovernor.soc.cim.form.IGCIM0158Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01581VO;

/**
 * 资产相关流程查询Action处理
 *
 */
public class IGCIM0158Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0158Action.class);

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
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGCIM0158Form form = (IGCIM0158Form)actionForm;
	
//		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
	
//		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		if( "DISP".equals(mapping.getParameter())){
			//应用查询画面初期显示处理
			log.debug("========应用查询画面初期显示处理开始========");
			String eiid = form.getEiid();
			dto.setEiid(eiid);
			if("0".equals(form.getType())){
				ctlBL.getProcessByEiid(dto);
			}else{
				ctlBL.getMaintainByEiid(dto);
			}
			IGCIM01581VO vo = new IGCIM01581VO();
			vo.setRes500VWList(dto.getRes500VWList());
			super.<IGCIM01581VO>setVO(req, vo);
			log.debug("========应用查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
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
