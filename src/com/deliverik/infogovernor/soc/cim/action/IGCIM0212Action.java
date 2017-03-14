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
import com.deliverik.infogovernor.soc.cim.bl.IGCIM02BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM02DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0212Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02121VO;

/**
 * ����: �ʲ�����汾��ѯ����Action����
 * ��������: �ʲ�����汾��ѯ����Action����
 * ������¼: 2011/04/26
 * �޸ļ�¼: 
 */
public class IGCIM0212Action extends BaseAction{
	static Log log = LogFactory.getLog(IGCIM0203Action.class);
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
		IGCIM0212Form form = (IGCIM0212Form)actionForm;
		
		//BLȡ��
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		
		//DTO����
		IGCIM02DTO dto = new IGCIM02DTO();
		
		dto.setLocale(this.getLocale(req));
		
		if ("DISP".equals(mapping.getParameter())){
			//�ʲ�������ʷ�汾��ѯ����
			log.debug("========�ʲ�������ʷ�汾��ѯ��ʼ========");
			
			//DTO��������趨
			dto.setIgcim0212Form(form);
			
			//�ʲ�������ʷ�汾��ѯ�߼�����
			dto=ctlBL.searchIGCIM0212Action(dto);
			
			//��Ӧ��������Ϣ��ʷ��¼��������趨��VO��
			IGCIM02121VO vo = new IGCIM02121VO(dto.getEiDomainDefInfo(),dto.getEiDomainDefInfoList());
			
			super.<IGCIM02121VO>setVO(req.getSession(), vo);
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
