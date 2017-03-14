/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.crc.bl.IGCRC13BL;
import com.deliverik.infogovernor.crc.dto.IGCRC1304DTO;
import com.deliverik.infogovernor.crc.form.IGCRC1304Form;
import com.deliverik.infogovernor.crc.vo.IGCRC1304VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ĵ���Ϣ��ѯAction
 * </p>
 * 
 * @author ʷ����@deliverik.com
 * @version 1.0
 */
public class IGCRC1304Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC1304Action.class);
	
	/**
	 * <p>
	 * Description: ҳ���ѯaction����
	 * </p>
	 * 
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		log.debug("================�����ύͳ��Action��ʼ=============");
		IGCRC1304Form form = (IGCRC1304Form)actionForm;
		
		IGCRC13BL igcrc13bl = (IGCRC13BL)getBean("igcrc13bl");

		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		
		IGCRC1304DTO dto = new IGCRC1304DTO();
		
		dto.setUser(user);
		
		if("DISP".equals(mapping.getParameter())){
			log.debug("=================�����ύͳ�ƴ���ʼ===============");
			PagingDTO pDto = getPaginDTO(request, "IGCRC1304");
			
			int maxCnt = getMaxDataCount("IGCRC1304");
			
			dto.setIgcrc1304Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = igcrc13bl.searchDepartSumAction(dto);

			//����VO
			IGCRC1304VO vo = new IGCRC1304VO();
			vo.setIgcrc1304VWList(dto.getEntityItemVWInfoList());
			vo.setMaps(dto.getMaps());
			vo.setListVM(dto.getListVM());
			request.getSession().setAttribute("isManager", dto.getIsManeger()==null?"0":dto.getIsManeger());
			super.<IGCRC1304VO>setVO(request, vo);
			
			log.debug("=================�����ύͳ�ƴ������===============");
		}else if("SEARCH".equals(mapping.getParameter())){
			log.debug("=================����ͳ�Ʋ�ѯ���̴���ʼ===============");
			PagingDTO pDto = getPaginDTO(request, "IGCRC1304");
			String type = request.getParameter("type");
			int maxCnt = getMaxDataCount("IGCRC1304");
			form.setEiid(type);
			dto.setIgcrc1304Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			dto = igcrc13bl.searchIG500ItemAction(dto);
			IGCRC1304VO vo = new IGCRC1304VO();
			vo.setProcessList(dto.getProcessList());
			super.<IGCRC1304VO>setVO(request, vo);
			log.debug("=================����ͳ�����̲�ѯ�������===============");
		}
		log.debug("================�����ύͳ��Action����=============");
		return mapping.findForward("DISP");
	}
}
