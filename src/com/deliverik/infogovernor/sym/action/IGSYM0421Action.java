/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.infogovernor.sym.bl.IGSYM04BL;
import com.deliverik.infogovernor.sym.dto.IGSYM04DTO;
import com.deliverik.infogovernor.sym.vo.IGSYM04211VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��Ȩ����_��Դ����Ȩ��ɫ��ѯACTION
 * </p>
 * 
 * @author lujiayuan 2012/11/15
 * @version 1.0
 */

public class IGSYM0421Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0421Action.class);
	
	/**
	 * <p>
	 * Description: ��Դ����Ȩaction����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author lujiayuan
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��ȡBL�ӿ�ʵ��
		IGSYM04BL ctlBL = (IGSYM04BL) getBean("igsym04BL");
		//ʵ����DTO
		IGSYM04DTO dto = new IGSYM04DTO();

		if( "DISP".equals(mapping.getParameter())){
			log.debug("========��Դ����Ȩ��ѯ���������ʾ����ʼ========");
			
			//��ȡ��ͬ����HQ��EAM_ROLE��Ľ�ɫ
			dto = ctlBL.searchSYNRoleAction(dto);
			//����VO
			IGSYM04211VO vo = new IGSYM04211VO();
			vo.setRoleList(dto.getRoleList());
			super.<IGSYM04211VO>setVO(request, vo);
			
			log.debug("========��Դ����Ȩ��ѯ���������ʾ��������========");
		}
		return mapping.findForward("DISP");
	}

}
