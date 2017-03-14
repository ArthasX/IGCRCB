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
import com.deliverik.infogovernor.soc.cim.form.IGCIM0206Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM02061VO;

/**
 * ����: �������Action����
 * ��������: �������Action����
 * ������¼: 2011/05/03
 * �޸ļ�¼: 
 */
public class IGCIM0206Action extends BaseAction{
	static Log log = LogFactory.getLog(IGCIM0206Action.class);
	
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
		IGCIM0206Form form = (IGCIM0206Form) actionForm;
		// BLȡ��
		 IGCIM02BL ctlBL = (IGCIM02BL) getBean("igcim02BL");
		// DTO����
		IGCIM02DTO dto = new IGCIM02DTO();
		dto.setLocale(this.getLocale(req));
		// ������ת�趨
		String forward = null;
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========���������Ϣ�Ǽǳ�����ʾ����ʼ========");
			dto = ctlBL.getEiImportProgrammeAction(dto);
			req.getSession().setAttribute("ADImpTypeList", dto.getImpTypeList());
			saveToken(req);
			addMessage(req, new ActionMessage("IGCO10000.I001",resources.getMessage(this.getLocale(req),"message.IGCIM0206.001")));
			log.debug("========���������Ϣ�Ǽǳ�����ʾ��������========");
			return mapping.findForward("DISP");
		}
		if( "INSERT".equals(mapping.getParameter())){
			//���������Ϣ�༭����
			if (form.getMode().equals("0")){
				//���������Ϣ�ǼǴ���
				log.debug("========���������Ϣ�ǼǴ���ʼ========");
				//DTO��������趨
				dto.setIgcim0206Form(form);
				if (isTokenValid(req, true)){
				//���������Ϣ�Ǽ��߼�����
				dto = ctlBL.insertImportVersionAction(dto);
				}else{
					addMessage(req, new ActionMessage("IGCO00000.E007"));
					return mapping.findForward("/error1");
				}
				//���Ǽ����˵ĵ��������Ϣ�趨��VO��
				IGCIM02061VO vo = new IGCIM02061VO(dto.getIgcim0206Form());
				super.<IGCIM02061VO>setVO(req.getSession(), vo);
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
