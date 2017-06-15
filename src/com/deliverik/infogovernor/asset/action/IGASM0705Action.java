package com.deliverik.infogovernor.asset.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.asset.bl.IGASM07BL;
import com.deliverik.infogovernor.asset.dto.IGASM07DTO;
import com.deliverik.infogovernor.asset.form.IGASM0705Form;
import com.deliverik.infogovernor.asset.vo.IGASM07051VO;

/**
 * ����������Ϣ��ʷ��¼����Action����
 *
 */
public class IGASM0705Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0705Action.class);

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
		IGASM0705Form form = (IGASM0705Form)actionForm;
		
		//BLȡ��
		IGASM07BL ctlBL = (IGASM07BL) getBean("igasm07BL");
		
		//DTO����
		IGASM07DTO dto = new IGASM07DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//����������Ϣ��ʷ��¼���������ʾ����
			log.debug("========����������Ϣ��ʷ��¼���������ʾ����ʼ========");
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0705");

			//DTO��������趨
			dto.setIgasm0705Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			//����������Ϣ��ʷ��¼���������ʾ�߼�����
			dto = ctlBL.initIGASM0705Action(dto);
			
			//������������Ϣ��ʷ��¼��������趨��VO��
			IGASM07051VO vo = new IGASM07051VO(dto.getEntityItemVWInfo(),
					dto.getConfigItemList());
			
			super.<IGASM07051VO>setVO(req.getSession(), vo);
			
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
