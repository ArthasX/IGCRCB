package com.deliverik.infogovernor.soc.iop.action;

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
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.soc.iop.bl.IGIOP02BL;
import com.deliverik.infogovernor.soc.iop.dto.IGIOP02DTO;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0202Form;
import com.deliverik.infogovernor.soc.iop.vo.IGIOP02021VO;

/**
 * IP分配Action处理
 *
 */
public class IGIOP0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIOP0202Action.class);

	/**
	 * IP分配事件处理
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

		// FORM取得
		IGIOP0202Form form = (IGIOP0202Form) actionForm;

		// BL取得
		IGIOP02BL ctlBL = (IGIOP02BL) getBean("igiop02BL");

		// DTO生成
		IGIOP02DTO dto = new IGIOP02DTO();
		
		dto.setLocale(this.getLocale(req));
		
		dto.setIgiop0202Form(form);
		
		if("EDIT".equals(mapping.getParameter())){
			log.debug("=============IP分配预处理开始==================");
			
			dto = ctlBL.getIPByEiid(dto);
			
			req.getSession().setAttribute("IGIOP0202Form", null);
			
			IGIOP02021VO vo = new IGIOP02021VO();
			
			SOC0118Info ipInfo = dto.getIpInfo();
			
			vo.setEiid(ipInfo.getEiid());
			
			vo.setIPAddr(ipInfo.getEiname());
			
			vo.setSubnet(ipInfo.getEilabel().substring(0,ipInfo.getEilabel().indexOf("_")));
			
			super.<IGIOP02021VO>setVO(req, vo);
			
			
			log.debug("=============IP分配预处理结束==================");
		}
		if("ALLOT".equals(mapping.getParameter())){
			log.debug("=============IP分配开始==================");
			
			dto = ctlBL.allotIP(dto);
			
			log.debug("=============IP分配结束==================");
		}
		
		// 逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
