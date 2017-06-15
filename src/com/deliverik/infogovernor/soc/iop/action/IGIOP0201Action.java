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
import com.deliverik.infogovernor.soc.iop.IOPKeyWords;
import com.deliverik.infogovernor.soc.iop.bl.IGIOP02BL;
import com.deliverik.infogovernor.soc.iop.dto.IGIOP02DTO;
import com.deliverik.infogovernor.soc.iop.form.IGIOP0201Form;
import com.deliverik.infogovernor.soc.iop.vo.IGIOP02011VO;

/**
 * IP���� Action����
 *
 */
public class IGIOP0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGIOP0201Action.class);

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
				IGIOP0201Form form = (IGIOP0201Form) actionForm;

				// BLȡ��
				IGIOP02BL ctlBL = (IGIOP02BL) getBean("igiop02BL");

				// DTO����
				IGIOP02DTO dto = new IGIOP02DTO();
				
				dto.setLocale(this.getLocale(req));
				
				if("DISP".equals(mapping.getParameter())){
					
				}
				
				if ("SEARCH".equals(mapping.getParameter())|| "SEARCH1".equals(mapping.getParameter())) {
					// ��ҳ��DTOȡ��
					getPaginDTO(req, "IGIOP0201");

					PagingDTO pDto;

					pDto = (PagingDTO) req.getAttribute("PagingDTO");
					// �豸��ѯ����
					log.debug("========IP��ѯ����ʼ========");
					if ("SEARCH1".equals(mapping.getParameter())) {
						form = (IGIOP0201Form) req.getSession().getAttribute(
								"IGIOP0201Form");
						if (form == null) {
							form = new IGIOP0201Form();
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
							form = (IGIOP0201Form) req.getSession().getAttribute(
									"IGIOP0201Form");
							if (form != null) {
								form.setFromCount(0);
							}
						}
					}
					// ��ѯ��¼������ȡ��
					int maxCnt = getMaxDataCount("IGIOP0201");
					if(StringUtils.isEmpty(form.getEid()))
						form.setEid(IOPKeyWords.IP_EID);
					dto.setIgiop0201Form(form);
					
					dto.setMaxSearchCount(maxCnt);

					dto.setPagingDto(pDto);

					// �豸�����߼�����
					dto = ctlBL.searchIP(dto);

					// ���豸��Ϣ��������趨��VO��
					IGIOP02011VO vo = new IGIOP02011VO();
					
					vo.setIpList(dto.getSoc0118List());
					
					super.<IGIOP02011VO> setVO(req, vo);

					log.debug("========IP��ѯ��������========");
				}
				
				
				if ("RECOVERY".equals(mapping.getParameter())) {
					// IP���մ���
					log.debug("========IP���մ���ʼ========");
					
					dto.setIgiop0201Form(form);
					
					ctlBL.recoveryIP(dto);
					

					log.debug("========IP���մ�������========");
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
