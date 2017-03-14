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
 * IP����Action����
 *
 */
public class IGIOP0202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIOP0202Action.class);

	/**
	 * IP�����¼�����
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

		// FORMȡ��
		IGIOP0202Form form = (IGIOP0202Form) actionForm;

		// BLȡ��
		IGIOP02BL ctlBL = (IGIOP02BL) getBean("igiop02BL");

		// DTO����
		IGIOP02DTO dto = new IGIOP02DTO();
		
		dto.setLocale(this.getLocale(req));
		
		dto.setIgiop0202Form(form);
		
		if("EDIT".equals(mapping.getParameter())){
			log.debug("=============IP����Ԥ����ʼ==================");
			
			dto = ctlBL.getIPByEiid(dto);
			
			req.getSession().setAttribute("IGIOP0202Form", null);
			
			IGIOP02021VO vo = new IGIOP02021VO();
			
			SOC0118Info ipInfo = dto.getIpInfo();
			
			vo.setEiid(ipInfo.getEiid());
			
			vo.setIPAddr(ipInfo.getEiname());
			
			vo.setSubnet(ipInfo.getEilabel().substring(0,ipInfo.getEilabel().indexOf("_")));
			
			super.<IGIOP02021VO>setVO(req, vo);
			
			
			log.debug("=============IP����Ԥ�������==================");
		}
		if("ALLOT".equals(mapping.getParameter())){
			log.debug("=============IP���俪ʼ==================");
			
			dto = ctlBL.allotIP(dto);
			
			log.debug("=============IP�������==================");
		}
		
		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
