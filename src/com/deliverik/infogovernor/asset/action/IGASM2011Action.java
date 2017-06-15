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
import com.deliverik.infogovernor.asset.form.IGASM2011Form;
import com.deliverik.infogovernor.asset.vo.IGASM20111VO;

/**
 * ����: �������汾��ѯ����Action����
 * ��������: �������汾��ѯ����Action����
 * ������¼: 2011/05/05
 * �޸ļ�¼: 
 */
public class IGASM2011Action extends BaseAction{
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
		IGASM2011Form form = (IGASM2011Form)actionForm;
		
		//BLȡ��
		IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		
		//DTO����
		IGASM20DTO dto = new IGASM20DTO();
		
		if ("DISP".equals(mapping.getParameter())){
			//���������ʷ�汾��ѯ����
			log.debug("========���������ʷ�汾��ѯ��ʼ========");
			
			//DTO��������趨
			dto.setImpeiname(form.getImpeiname());
			
			dto.setImpversion(form.getImpversion());
			
			//���������ʷ�汾��ѯ�߼�����
			dto=ctlBL.searchImportVersionIGASM2010Action(dto);
			
			//��Ӧ��������Ϣ��ʷ��¼��������趨��VO��
			IGASM20111VO vo = new IGASM20111VO(dto.getImportVersionInfoList(),dto.getImportVersionInfo());
			
			super.<IGASM20111VO>setVO(req.getSession(), vo);
			log.debug("========���������ʷ�汾��ѯ��������========");
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
