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
import com.deliverik.infogovernor.asset.bl.IGASM20BL;
import com.deliverik.infogovernor.asset.dto.IGASM20DTO;
import com.deliverik.infogovernor.asset.form.IGASM2012Form;
import com.deliverik.infogovernor.asset.vo.IGASM20121VO;

/**
 * ����: �ʲ�����汾��ѯ����Action����
 * ��������: �ʲ�����汾��ѯ����Action����
 * ������¼: 2011/04/26
 * �޸ļ�¼: 
 */
public class IGASM2012Action extends BaseAction{
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
		IGASM2012Form form = (IGASM2012Form)actionForm;
		
		//BLȡ��
		IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		
		//DTO����
		IGASM20DTO dto = new IGASM20DTO();
		
		if ("DISP".equals(mapping.getParameter())){
			//�ʲ�������ʷ�汾��ѯ����
			log.debug("========�ʲ�������ʷ�汾��ѯ��ʼ========");
			
			//DTO��������趨
			dto.setIgasm2012Form(form);
			
			//�ʲ�������ʷ�汾��ѯ�߼�����
			dto=ctlBL.searchIGASM2012Action(dto);
			
			//��Ӧ��������Ϣ��ʷ��¼��������趨��VO��
			IGASM20121VO vo = new IGASM20121VO(dto.getEiDomainDefInfo(),dto.getEiDomainDefInfoList());
			
			super.<IGASM20121VO>setVO(req.getSession(), vo);
			log.debug("========�ʲ�������ʷ�汾��ѯ��������========");
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
