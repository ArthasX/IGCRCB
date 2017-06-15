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
import com.deliverik.infogovernor.asset.bl.IGASM23BL;
import com.deliverik.infogovernor.asset.dto.IGASM23DTO;
import com.deliverik.infogovernor.asset.form.IGASM2301Form;
import com.deliverik.infogovernor.asset.vo.IGASM23011VO;

/**
 * ����: �ɼ�����̨��Ϣ��ѯ����Action����
 * ��������: �ɼ�����̨��Ϣ��ѯ����Action����
 * ������¼: 2311/05/04
 * �޸ļ�¼: 
 */
public class IGASM2301Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2301Action.class);
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
		IGASM2301Form form = (IGASM2301Form)actionForm;
		
		//BLȡ��
		IGASM23BL ctlBL = (IGASM23BL) getBean("igasm23BL");
		
		//DTO����
		IGASM23DTO dto = new IGASM23DTO();
		
		if( "SEARCH".equals(mapping.getParameter())){
			//�ɼ�����̨��ѯ����
			log.debug("========�ɼ�����̨��ѯ����ʼ========");
			//DTO��������趨
			dto.setImportVersionSearchCond(form);
			
			//�ɼ�����̨�����߼�����
			dto = ctlBL.initIGASM2301Action(dto);
			
			//���ɼ�����̨��Ϣ��������趨��VO��
			IGASM23011VO vo = new IGASM23011VO(dto.getImportVersionInfoList());
			
			super.<IGASM23011VO>setVO(req,vo);
			
			saveToken(req);
			
			log.debug("========�ɼ�����̨��ѯ��������========");
		} else if("COLLECT".equals(mapping.getParameter())){
			
			log.debug("========�ɼ�����ʼ========");
			
			if (isTokenValid(req, true)){
				dto.setCollectIds(form.getCollectIds());
				dto = ctlBL.collectIGASM2301Action(dto);
			}else{
				addMessage(req, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			Thread.sleep(1500);
			log.debug("========�ɼ���������========");
			
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
