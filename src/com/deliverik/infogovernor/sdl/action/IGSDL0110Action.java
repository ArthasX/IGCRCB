/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.scheduling.bl.IGSCH01BL;
import com.deliverik.infogovernor.sdl.dto.IGSDL01DTO;
import com.deliverik.infogovernor.sdl.form.IGSDL0110Form;
import com.deliverik.infogovernor.sdl.vo.IGSDL01101VO;

public class IGSDL0110Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSDL0110Action.class);


	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if ("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			IGSCH01BL ctlBL = (IGSCH01BL) getBean("IGSCH01BL");
			IGSDL0110Form form = (IGSDL0110Form)actionForm;
			IGSDL01DTO dto = new IGSDL01DTO();

			getPaginDTO(request,"IGSDL0110");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSDL0110Form) request.getSession().getAttribute("IGSDL0110Form");
				if ( form == null ) {
					form = new IGSDL0110Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGSDL0110Form) request.getSession().getAttribute("IGSDL0110Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//pDto.setFromCount(form.getFromCount());
			int maxCnt = getMaxDataCount("IGSDL0110");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			form.setQjtype_q("0");//��ѯqjtype��Ϊ�յļ�¼(��ȥ�������ල)
			form.setDate_now(IGStringUtils.getCurrentDate());//��ǰ����
			dto.setIgsdl0110Form(form);
			dto.setUserid(user.getUserid());
			
			// ����BL��ѯ
			dto = ctlBL.searchQuartzJobsForIGSDL0110(dto);
			// ����VO
			IGSDL01101VO vo = new IGSDL01101VO();
			vo.setQuartzJobsDetailList(dto.getQuartzJobDetailList());
			super.<IGSDL01101VO> setVO(request, vo);
		}
		
		return mapping.findForward("DISP");
	}
}