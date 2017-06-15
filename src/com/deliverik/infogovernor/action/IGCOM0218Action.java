/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.bl.IGCOM02BL;
import com.deliverik.infogovernor.dto.IGCOM02DTO;
import com.deliverik.infogovernor.vo.IGCOM02181VO;

/**
 * ����: Ӧ�ù�����ҳ��ʾAction����
 * ��������: Ӧ�ù�����ҳ��ʾAction����
 * ������¼: 2012/03/01
 * �޸ļ�¼: 
 */
public class IGCOM0218Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCOM0218Action.class);
	/**
	 * 
	 * �¼�����
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		log.debug("========Ӧ�ù�����ҳ��ʾ��ʼ========");
		//BLȡ��
		IGCOM02BL ctlBL = (IGCOM02BL) getBean("igcom02BL");
		
		//DTO����
		IGCOM02DTO dto = new IGCOM02DTO();
		
		//�����߼�����
		dto = ctlBL.searchIgcom0218Action(dto);
		
		//����Ϣ��������趨��VO��
		IGCOM02181VO vo = new IGCOM02181VO();
		//�澯��Ϣ�趨
		vo.setSoc0307List(dto.getSoc0307List());
		//֪ʶ��Ϣ�趨
		vo.setKnowledgeList(dto.getKnowledgeList());
		super.<IGCOM02181VO>setVO(req, vo);

		log.debug("========Ӧ�ù�����ҳ��ʾ����========");
		return mapping.findForward("DISP");
	}
	






}
