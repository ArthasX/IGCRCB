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
import com.deliverik.infogovernor.soc.cim.form.IGCIM0211Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02111VO;

/**
 * ����: �������汾��ѯ����Action����
 * ��������: �������汾��ѯ����Action����
 * ������¼: 2011/05/05
 * �޸ļ�¼: 
 */
public class IGCIM0211Action extends BaseAction{
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
		IGCIM0211Form form = (IGCIM0211Form)actionForm;
		
		//BLȡ��
		IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		
		//DTO����
		IGCIM02DTO dto = new IGCIM02DTO();
		
		dto.setLocale(this.getLocale(req));
		
		if ("DISP".equals(mapping.getParameter())){
			//���������ʷ�汾��ѯ����
			log.debug("========���������ʷ�汾��ѯ��ʼ========");
			
			//DTO��������趨
			dto.setImpeiname(form.getImpeiname());
			
			dto.setImpversion(form.getImpversion());
			
			//���������ʷ�汾��ѯ�߼�����
			dto=ctlBL.searchImportVersionIGCIM0210Action(dto);
			
			//��Ӧ��������Ϣ��ʷ��¼��������趨��VO��
			IGCIM02111VO vo = new IGCIM02111VO(dto.getImportVersionInfoList(),dto.getImportVersionInfo());
			
			super.<IGCIM02111VO>setVO(req.getSession(), vo);
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
