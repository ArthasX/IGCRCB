/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM20BL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
import com.deliverik.infogovernor.asset.form.IGASM2003Form;
import com.deliverik.infogovernor.asset.vo.IGASM20031VO;

/**
 * ����: �ʲ������ѯ����Action����
 * ��������: �ʲ������ѯ����Action����
 * ������¼: 2011/04/25
 * �޸ļ�¼: 
 */
public class IGASM2003Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2003Action.class);


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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGASM2003Form form = (IGASM2003Form)actionForm;
		
		//BLȡ��
		IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		
		//DTO����
		IGASM20DTO dto = new IGASM20DTO();
		
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM2003");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM2003Form) req.getSession().getAttribute("IGASM2003Form");
				if ( form== null){
					form = new IGASM2003Form();
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
					form = (IGASM2003Form) req.getSession().getAttribute("IGASM2003Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//�ʲ������ѯ����
			log.debug("========�ʲ������ѯ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM2003");
			
			//DTO��������趨
			dto.setEiDomainDefSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�ʲ���������߼�����
			dto = ctlBL.searchEiDomainDefAction(dto);
			
			//���ʲ�������Ϣ��������趨��VO��
			IGASM20031VO vo = new IGASM20031VO(dto.getEiDomainDefInfoList());
			
			super.<IGASM20031VO>setVO(req,vo);
			
			log.debug("========�ʲ������ѯ��������========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//�ʲ�����ɾ������
			log.debug("========�ʲ�����ɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEiddid(form.getDeleteEiddid());
			
			//�ʲ�������Ϣɾ���߼�����
			ctlBL.deleteEiDomainDefAction(dto);
			
			log.debug("========�ʲ�����ɾ����������========");
		}
		
		if ("SNAPSHOT".equals(mapping.getParameter())) {
			log.debug("========���ֶ��������ɴ���ʼ========");
			
			dto.setIgasm2003Form(form);
			dto = ctlBL.handSnapshotAction(dto);
			
			
			log.debug("========���ֶ��������ɴ�������========");
			
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
