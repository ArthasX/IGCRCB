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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0911Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM09111VO;

/**
 * ���罻�����˿ڲ�ѯ���� Action����
 *
 */
public class IGCIM0911Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0911Action.class);

	/**
	 * �¼�����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM0911Form form = (IGCIM0911Form)actionForm;
		//BLȡ��
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		//DTO����
		IGCIM01DTO dto = new IGCIM01DTO();
		
		dto.setLocale(this.getLocale(req));
		
		//���罻�����˿ڲ�ѯ���������ʾ����
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========���罻�����˿ڲ�ѯ���������ʾ����ʼ========");
			form = new IGCIM0911Form();
			req.setAttribute("IGCIM0911Form", form);
			log.debug("========���罻�����˿ڲ�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//���罻�����˿ڲ�ѯ��������ʾ����
			log.debug("========���罻�����˿ڲ�ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���罻�����˿ڲ�ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		//���罻�����˿ڲ�ѯ����
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGCIM0911");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			log.debug("========���罻�����˿ڲ�ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM0911Form) req.getSession().getAttribute("IGCIM0911Form");
				if ( form== null){
					form = new IGCIM0911Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGCIM0911Form) req.getSession().getAttribute("IGCIM0911Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0911");
			//DTO��������趨
			dto.setIgcim0911Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//�豸�����߼�����
			dto = ctlBL.searchIGCIM0911Action(dto);
			//���豸��Ϣ��������趨��VO��
			IGCIM09111VO vo = new IGCIM09111VO();
			vo.setNetDeviceList(dto.getNetDeviceList());
			super.<IGCIM09111VO>setVO(req, vo);
			log.debug("========���罻�����˿ڲ�ѯ��������========");
		}
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		return mapping.findForward("DISP");
	}
}
