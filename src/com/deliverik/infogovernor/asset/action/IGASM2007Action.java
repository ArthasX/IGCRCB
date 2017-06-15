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
import com.deliverik.infogovernor.asset.form.IGASM2007Form;
import com.deliverik.infogovernor.asset.vo.IGASM20071VO;

/**
 * ����: ���������Ϣ��ѯ����Action����
 * ��������: ���������Ϣ��ѯ����Action����
 * ������¼: 2011/05/04
 * �޸ļ�¼: 
 */
public class IGASM2007Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2007Action.class);
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
		IGASM2007Form form = (IGASM2007Form)actionForm;
		
		//BLȡ��
		IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		
		//DTO����
		IGASM20DTO dto = new IGASM20DTO();
		
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM2007");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM2007Form) req.getSession().getAttribute("IGASM2007Form");
				if ( form== null){
					form = new IGASM2007Form();
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
					form = (IGASM2007Form) req.getSession().getAttribute("IGASM2007Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��������ѯ����
			log.debug("========��������ѯ����ʼ========");
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM2007");
			
			//DTO��������趨
			dto.setImportVersionSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�����������߼�����
			dto = ctlBL.searchImportVersionAction(dto);
			//�����������Ϣ��������趨��VO��
			IGASM20071VO vo = new IGASM20071VO(dto.getImportVersionInfoList());
			
			super.<IGASM20071VO>setVO(req,vo);
			
			log.debug("========��������ѯ��������========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//�������ɾ������
			log.debug("========�������ɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteImpeiid(form.getDeleteImpeiid());
			
			//���������Ϣɾ���߼�����
			ctlBL.deleteImportVersionAction(dto);
			
			log.debug("========�������ɾ����������========");
		}
		if ("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========�������״̬�仯����ʼ========");
			//DTO��������趨
			dto.setImpeiname(form.getImpeiname_eq());
			
			dto.setImpversion(form.getImpversion());
			
			dto.setDeleteflag(form.getDeleteflag());
			
			//���������Ϣ�����߼�����
			ctlBL.changeDeleteFlagAction(dto);
			
			addMessage(req, new ActionMessage("IGASM2007.I001"));
			log.debug("========�������״̬�仯��������========");
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
