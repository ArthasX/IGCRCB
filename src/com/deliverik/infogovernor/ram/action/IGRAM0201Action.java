/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ram.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.ram.bl.IGRAM02BL;
import com.deliverik.infogovernor.ram.dto.IGRAM02DTO;
import com.deliverik.infogovernor.ram.vo.IGRAM02011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ��ȫ����ƽ̨
 * </p>
 * <p>
 * Description: ��������_����������¼��ѯACTION
 * </p>
 * 
 * @author tangzhen@deliverik.com
 * @version 1.0
 */

public class IGRAM0201Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGRAM0201Action.class);
	
	/**
	 * <p>
	 * Description: ���˹���action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author tangzhen@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("====================��������������ʷ��¼��ѯ��ʼ====================");
		//��ȡBL�ӿ�ʵ��
		IGRAM02BL ctlBL = (IGRAM02BL) getBean("igram02BL");
		IGRAM02DTO dto = new IGRAM02DTO();
		
		if(request.getParameter("prid") != null){
			dto.setPrid(request.getParameter("prid"));
		}
		if(request.getParameter("pdid") != null){
			dto.setPdid(request.getParameter("pdid"));
		}
		//����prid��ѯ��ʷ���ּ�¼
		dto = ctlBL.searchAssessmentScoreHistory(dto);
		
		IGRAM02011VO vo = new IGRAM02011VO();
		//������ֲ�����Ա
		vo.setPpList(dto.getPpList());
		//������
		vo.setPrjMap(dto.getPrjMap());
		//���ַ���
		vo.setHsList(dto.getHistoryScoreList());
		
		super.<IGRAM02011VO>setVO(request, vo);
		log.debug("====================��������������ʷ��¼��ѯ����====================");
		
		return mapping.findForward("DISP");

	}
}
