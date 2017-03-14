package com.deliverik.infogovernor.soc.iop.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.soc.iop.IOPKeyWords;
import com.deliverik.infogovernor.soc.iop.bl.IGIOP01BL;
import com.deliverik.infogovernor.soc.iop.dto.IGIOP01DTO;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0102Form;
import com.deliverik.infogovernor.soc.iop.vo.IGIOP01021VO;

/**
 * IP�ι���Action����
 *
 */
public class IGIOP0102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIOP0102Action.class);

	/**
	 * IP�ι���Action����
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
		IGIOP0102Form form = (IGIOP0102Form) actionForm;

		// BLȡ��
		IGIOP01BL ctlBL = (IGIOP01BL) getBean("igiop01BL");

		// DTO����
		IGIOP01DTO dto = new IGIOP01DTO();
		dto.setLocale(this.getLocale(req));

		if ("DISP".equals(mapping.getParameter())) {
			clearSessionFormData(req);
		} 

		if ("SEARCH".equals(mapping.getParameter())|| "SEARCH1".equals(mapping.getParameter())) {
			// ��ҳ��DTOȡ��
			getPaginDTO(req, "IGIOP0102");

			PagingDTO pDto;

			pDto = (PagingDTO) req.getAttribute("PagingDTO");
			// �豸��ѯ����
			log.debug("========IP�β�ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())) {
				form = (IGIOP0102Form) req.getSession().getAttribute(
						"IGIOP0102Form");
				if (form == null) {
					form = new IGIOP0102Form();
				} else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGIOP0102Form) req.getSession().getAttribute(
							"IGIOP0102Form");
					if (form != null) {
						form.setFromCount(0);
					}
				}
			}
			// ��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGIOP0102");
			if(StringUtils.isEmpty(form.getEid()))
				form.setEid(IOPKeyWords.IPS_EID);
			dto.setIgiop0102Form(form);
			
			dto.setMaxSearchCount(maxCnt);

			dto.setPagingDto(pDto);

			// �豸�����߼�����
			dto = ctlBL.searchIPS(dto);

			// ���豸��Ϣ��������趨��VO��
			IGIOP01021VO vo = new IGIOP01021VO();
			
			vo.setIpsList(dto.getSoc0118List());
			
			super.<IGIOP01021VO> setVO(req, vo);

			log.debug("========IP�β�ѯ��������========");
		}
		
		
		if ("RECOVERY".equals(mapping.getParameter())) {
			// IP���մ���
			log.debug("========IP���մ���ʼ========");
			
			dto.setIgiop0102Form(form);
			
			ctlBL.recoveryAllIP(dto);
			

			log.debug("========IP���մ�������========");
		}
		if("VIEW".equals(mapping.getParameter())){
			log.debug("==============�鿴����IP��ʼ==========");
			
			dto.setIgiop0102Form(form);
			
			ctlBL.showIP(dto);
			
			IGIOP01021VO vo = new IGIOP01021VO();
			
			vo.setIpList(dto.getSoc0118List());
			
			super.<IGIOP01021VO>setVO(req, vo);
			
			log.debug("==============�鿴����IP����==========");
		}
		if("EDIT".equals(mapping.getParameter())){
			
			//clearSessionFormData(req);
			
			form.setEidesc(null);
			
			dto.setIgiop0102Form(form);
			
			dto= ctlBL.searchIPByEiids(dto);
			
			IGIOP01021VO vo = new IGIOP01021VO();
			
			vo.setIpList(dto.getSoc0118List());
			
			super.<IGIOP01021VO>setVO(req, vo);
			
		}
		if("ALLOT".equals(mapping.getParameter())){
			
			log.debug("============IP���俪ʼ================");
			
			dto.setIgiop0102Form(form);
			
			ctlBL.allotIP(dto);
			
			
			
			log.debug("============IP�������================");
		}
		if("INSERT".equals(mapping.getParameter())){
			log.debug("=========����IP��ʼ=============");
			
			User user = (User)getSessionAttribute(req, SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto.setIgiop0102Form(form);
			
			ctlBL.regIP(dto);
			
			log.debug("=========����IP����=============");
		}
		if("DELETE".equals(mapping.getParameter())){
			log.debug("=============ɾ��������ʼ=================");
			dto.setIgiop0102Form(form);
			
			ctlBL.delSubNet(dto);
			log.debug("=============ɾ����������=================");
		}
		if("UPDATE".equals(mapping.getParameter())){
			log.debug("=============����������ʼ=================");
			dto.setIgiop0102Form(form);
			
			ctlBL.updateSubNet(dto);
			log.debug("=============������������=================");
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
