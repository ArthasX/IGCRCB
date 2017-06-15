/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0207Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02071VO;

/**
 * ����: ���������Ϣ��ѯ����Action����
 * ��������: ���������Ϣ��ѯ����Action����
 * ������¼: 2011/05/04
 * �޸ļ�¼: 
 */
public class IGCIM0207Action extends BaseAction{
	static Log log = LogFactory.getLog(IGCIM0207Action.class);
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
		IGCIM0207Form form = (IGCIM0207Form)actionForm;
		
		//BLȡ��
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		
		//DTO����
		IGCIM02DTO dto = new IGCIM02DTO();
		dto.setLocale(this.getLocale(req));
		
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGCIM0207");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM0207Form) req.getSession().getAttribute("IGCIM0207Form");
				if ( form== null){
					form = new IGCIM0207Form();
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
					form = (IGCIM0207Form) req.getSession().getAttribute("IGCIM0207Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��������ѯ����
			log.debug("========��������ѯ����ʼ========");
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0207");
			
			//DTO��������趨
			dto.setImportVersionSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�����������߼�����
			dto = ctlBL.searchImportVersionAction(dto);
			//�����������Ϣ��������趨��VO��
			IGCIM02071VO vo = new IGCIM02071VO(dto.getImportVersionInfoList());
			
			super.<IGCIM02071VO>setVO(req,vo);
			
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
			
			addMessage(req, new ActionMessage("IGCIM0207.I001"));
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
