/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.crc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC13BL;
import com.deliverik.infogovernor.crc.dto.IGCRC1302DTO;
import com.deliverik.infogovernor.crc.vo.IGCRC1302VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class IGCRC1302Action extends BaseAction{

	static Log log = LogFactory.getLog(IGCRC1302Action.class);
	
	/**
	 * <p>
	 * Description: �ҵĽ���action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author shenbing@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// ��ȡBL�ӿ�ʵ��
		IGCRC13BL ctlBL = (IGCRC13BL) getBean("igcrc13bl");
		// ʵ����DTO
		IGCRC1302DTO dto = new IGCRC1302DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setUserId(user.getUserid());
		// �ҵķ����ѯ
		log.debug("========�ҵĽ��Ĳ�ѯ����ʼ========");
		// ����BL��ѯ
		dto = ctlBL.getWorkInitByMe(dto);
		// ����VO
		IGCRC1302VO vo = new IGCRC1302VO();
		vo.setIg500InfoList(dto.getEntityItemInfoList());
		super.<IGCRC1302VO> setVO(request, vo);
		log.debug("========�ҵĽ��Ĳ�ѯ��������========");
		return mapping.findForward("DISP");
	}
}
