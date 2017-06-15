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
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM03BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0302Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM03021VO;

/**
 * @Description: ��ƶԱȽ����ѯ����Action����
 * @Author  
 * @History 2011-5-18     �½�
 * @Version V2.0
 */
public class IGCIM0302Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0302Action.class);

	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources"); 
	
	/**
	 * ����
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
		IGCIM0302Form form = (IGCIM0302Form)actionForm;
		
		//BLȡ��
		IGCIM03BL ctlBL = (IGCIM03BL) getBean("igcim03BL");
		
		//DTO����
		IGCIM03DTO dto = new IGCIM03DTO();
		
		dto.setLocale(this.getLocale(req));
		
		if( "DISP".equals(mapping.getParameter())){
			//��ƶԱȽ����ѯ���������ʾ����
			log.debug("========��ƶԱȽ����ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��ƶԱȽ����ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} 	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ƶԱȽ����ѯ����
			log.debug("========��ƶԱȽ����ѯ����ʼ========");
			
			//DTO��������趨
			dto.setAuditResultSearchCond(form);
			
			//��ƶԱȽ����Ϣ�����߼�����
			dto = ctlBL.searchIGCIM0302Action(dto);
			
			//����ƶԱȽ����Ϣ��������趨��VO��
			IGCIM03021VO vo = new IGCIM03021VO();
			vo.setSOC0137List(dto.getAuditResultOneInfoList());
			
			super.<IGCIM03021VO>setVO(req, vo);
			
			log.debug("========��ƶԱȽ����ѯ��������========");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			
			log.debug("========��ƶԱȽ�����洦��ʼ========");
			
			dto.setIgcim0302Form(form);
			dto.setAuditResultSearchCond(form);
			// ��������
			ctlBL.updateAuditResultAction(dto);
			
			log.debug("========��ƶԱȽ�����洦������========");
			
		}
		
		if("SHOW".equals(mapping.getParameter())){
			log.debug("========��ƶԱȽ����ϸ�鿴��ʼ========");
			
			//DTO��������趨
			dto.setAuditResultSearchCond(form);
			
			//��ƶԱȽ����Ϣ�����߼�����
			dto = ctlBL.searchAuditResultAction(dto);
			
			//����ƶԱȽ����Ϣ��������趨��VO��
			IGCIM03021VO vo = new IGCIM03021VO();
			
			vo.setSOC0103List(dto.getAuditResultList());
			
			super.<IGCIM03021VO>setVO(req, vo);
			log.debug("========��ƶԱȽ����ϸ�鿴����========");
		}
		
		if( "UPDATE".equals(mapping.getParameter())){
			
			log.debug("========�ʲ����´���ʼ========");
			dto.setIgcim0302Form(form);
			// �����ʲ�
			ctlBL.updateEntityAction(dto);
			// ��������CI(���ù�ϵ������bat)
//			ctlBL.rootMarkUpdateAction(dto);
			
			log.debug("========�ʲ����´�������========");
			
		}
		if("EXPORT".equals(mapping.getParameter())){
			
			//DTO��������趨
			dto.setAuditResultSearchCond(form);
			
			//��ƶԱȽ����Ϣ�����߼�����
			dto = ctlBL.searchAuditResultAction(dto);
			
			//����ƶԱȽ����Ϣ��������趨��VO��
			IGCIM03021VO vo = new IGCIM03021VO();
			vo.setSOC0103List(dto.getAuditResultList());
			
			req.setAttribute("vo", vo);
			req.setAttribute("form", form);
		}
		if("EXPORTONE".equals(mapping.getParameter())){
			
			//DTO��������趨
			dto.setAuditResultSearchCond(form);
			
			//��ƶԱȽ����Ϣ�����߼�����
			dto = ctlBL.searchIGCIM0302Action(dto);
			
			//����ƶԱȽ����Ϣ��������趨��VO��
			IGCIM03021VO vo = new IGCIM03021VO();
			vo.setSOC0137List(dto.getAuditResultOneInfoList());
			
			req.setAttribute("vo", vo);
			req.setAttribute("form", form);
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
