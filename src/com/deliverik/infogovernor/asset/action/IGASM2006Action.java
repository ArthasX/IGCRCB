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
import com.deliverik.infogovernor.asset.form.IGASM2006Form;
import com.deliverik.infogovernor.asset.vo.IGASM20061VO;

/**
 * ����: �������Action����
 * ��������: �������Action����
 * ������¼: 2011/05/03
 * �޸ļ�¼: 
 */
public class IGASM2006Action extends BaseAction{
	static Log log = LogFactory.getLog(IGASM2006Action.class);
	
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
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		// FORMȡ��
		IGASM2006Form form = (IGASM2006Form) actionForm;
		// BLȡ��
		 IGASM20BL ctlBL = (IGASM20BL) getBean("igasm20BL");
		// DTO����
		IGASM20DTO dto = new IGASM20DTO();
		
		// ������ת�趨
		String forward = null;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========���������Ϣ�Ǽǳ�����ʾ����ʼ========");
			dto = ctlBL.getEiImportProgrammeAction(dto);
			req.getSession().setAttribute("ADImpTypeList", dto.getImpTypeList());
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001",resources.getMessage(this.getLocale(req),"message.IGASM2006.001")));
			log.debug("========���������Ϣ�Ǽǳ�����ʾ��������========");
			return mapping.findForward("DISP");
		}
		if( "INSERT".equals(mapping.getParameter())){
			//���������Ϣ�༭����
			if (form.getMode().equals("0")){
				//���������Ϣ�ǼǴ���
				log.debug("========���������Ϣ�ǼǴ���ʼ========");
				//DTO��������趨
				dto.setIgasm2006Form(form);
				if (isTokenValid(req, true)){
				//���������Ϣ�Ǽ��߼�����
				dto = ctlBL.insertImportVersionAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//���Ǽ����˵ĵ��������Ϣ�趨��VO��
				IGASM20061VO vo = new IGASM20061VO(dto.getIgasm2006Form());
				super.<IGASM20061VO>setVO(req.getSession(), vo);
				log.debug("========���������Ϣ�ǼǴ�������========");
				forward = "DISP";
			}
		}
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
		}
		
		return mapping.findForward(forward);
	}

}
