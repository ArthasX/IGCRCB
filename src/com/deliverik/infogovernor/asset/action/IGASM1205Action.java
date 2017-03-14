package com.deliverik.infogovernor.asset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM12BL;
import com.deliverik.infogovernor.asset.dto.IGASM12DTO;
import com.deliverik.infogovernor.asset.form.IGASM1205Form;
import com.deliverik.infogovernor.asset.vo.IGASM12051VO;

/**
 * ����������Ϣ��ʷ��¼����Action����
 *
 */
public class IGASM1205Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1205Action.class);

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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGASM1205Form form = (IGASM1205Form)actionForm;
		
		//BLȡ��
		IGASM12BL ctlBL = (IGASM12BL) getBean("igasm12BL");
		
		//DTO����
		IGASM12DTO dto = new IGASM12DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//����������Ϣ��ʷ��¼���������ʾ����
			log.debug("========����������Ϣ��ʷ��¼���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1205");

			//DTO��������趨
			dto.setIgasm1205Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//����������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGASM1205Action(dto);
			
			//������������Ϣ��ʷ��¼��������趨��VO��
			IGASM12051VO vo = new IGASM12051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemList());
			
			super.<IGASM12051VO>setVO(req.getSession(), vo);
			
			log.debug("========����������Ϣ��ʷ��¼���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		if ("BACK".equals(mapping.getParameter())) {
			//����������Ϣ��ʷ��¼���淵�ذ�ť����ʱ�ķ��ش���
			return mapping.findForward("DISP");
		}
		return mapping.findForward(null);
	}
}
