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
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM21BL;
import com.deliverik.infogovernor.asset.dto.IGASM21DTO;
import com.deliverik.infogovernor.asset.form.IGASM2102Form;
import com.deliverik.infogovernor.asset.vo.IGASM21021VO;

/**
 * @Description: ��ƶԱȽ����ѯ����Action����
 * @Author  
 * @History 2011-5-18     �½�
 * @Version V2.0
 */
public class IGASM2102Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2102Action.class);

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
		IGASM2102Form form = (IGASM2102Form)actionForm;
		
		//BLȡ��
		IGASM21BL ctlBL = (IGASM21BL) getBean("igasm21BL");
		
		//DTO����
		IGASM21DTO dto = new IGASM21DTO();
		
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
			dto = ctlBL.searchAuditResultAction(dto);
			
			//����ƶԱȽ����Ϣ��������趨��VO��
			IGASM21021VO vo = new IGASM21021VO();
			vo.setAuditResultList(dto.getAuditResultList());
			
			super.<IGASM21021VO>setVO(req, vo);
			
			log.debug("========��ƶԱȽ����ѯ��������========");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			
			log.debug("========��ƶԱȽ�����洦��ʼ========");
			
			dto.setIgasm2102Form(form);
			dto.setAuditResultSearchCond(form);
			// ��������
			ctlBL.updateAuditResultAction(dto);
			
			log.debug("========��ƶԱȽ�����洦������========");
			
		}
		
		if( "UPDATE".equals(mapping.getParameter())){
			
			log.debug("========�ʲ����´���ʼ========");
			dto.setIgasm2102Form(form);
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
			IGASM21021VO vo = new IGASM21021VO();
			vo.setAuditResultList(dto.getAuditResultList());
			
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
