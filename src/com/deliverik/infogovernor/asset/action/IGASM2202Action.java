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
import com.deliverik.infogovernor.asset.bl.IGASM22BL;
import com.deliverik.infogovernor.asset.dto.IGASM22DTO;
import com.deliverik.infogovernor.asset.form.IGASM2202Form;
import com.deliverik.infogovernor.asset.vo.IGASM22021VO;

/**
 * @Description: CI����ԱȽ����ѯ����Action����
 * @Author  
 * @History 2011-5-18     �½�
 * @Version V2.0
 */
public class IGASM2202Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2202Action.class);

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
		IGASM2202Form form = (IGASM2202Form)actionForm;
		
		//BLȡ��
		IGASM22BL ctlBL = (IGASM22BL) getBean("igasm22BL");
		
		//DTO����
		IGASM22DTO dto = new IGASM22DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//CI����ԱȽ����ѯ���������ʾ����
			log.debug("========CI����ԱȽ����ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========CI����ԱȽ����ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} 	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//CI����ԱȽ����ѯ����
			log.debug("========CI����ԱȽ����ѯ����ʼ========");
			
			//DTO��������趨
			dto.setCiResultSearchCond(form);
			
			//CI����ԱȽ����Ϣ�����߼�����
			dto = ctlBL.searchCIResultAction(dto);
			
			//��CI����ԱȽ����Ϣ��������趨��VO��
			IGASM22021VO vo = new IGASM22021VO();
			vo.setCiResultList(dto.getCiResultList());
			
			super.<IGASM22021VO>setVO(req, vo);
			
			log.debug("========CI����ԱȽ����ѯ��������========");
		}
		
		if( "INSERT".equals(mapping.getParameter())){
			
			log.debug("========CI����ԱȽ�����洦��ʼ========");
			
			dto.setIgasm2202Form(form);
			dto.setCiResultSearchCond(form);
			// ��������
			ctlBL.updateCIResultAction(dto);
			
			log.debug("========CI����ԱȽ�����洦������========");
			
		}
		
		if( "UPDATE".equals(mapping.getParameter())){
			
			log.debug("========�ʲ����´���ʼ========");
			// �����ʲ�
			ctlBL.updateEntityAction(dto);
			// ��������CI(���ù�ϵ������bat)
			ctlBL.rootMarkUpdateAction(dto);
			
			log.debug("========�ʲ����´�������========");
			
		}
		if("EXPORT".equals(mapping.getParameter())){
			
			//DTO��������趨
			dto.setCiResultSearchCond(form);
			
			//CI����ԱȽ����Ϣ�����߼�����
			dto = ctlBL.searchCIResultAction(dto);
			
			//��CI����ԱȽ����Ϣ��������趨��VO��
			IGASM22021VO vo = new IGASM22021VO();
			vo.setCiResultList(dto.getCiResultList());
			
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
