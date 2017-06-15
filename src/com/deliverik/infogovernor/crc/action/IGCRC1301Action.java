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
import com.deliverik.infogovernor.crc.dto.IGCRC1301DTO;
import com.deliverik.infogovernor.crc.form.IGCRC1301Form;
import com.deliverik.infogovernor.crc.vo.IGCRC1301VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ĵ���Ϣ��ѯAction
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class IGCRC1301Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCRC1301Action.class);
	
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
		log.debug("================�ĵ���Ϣ��ѯAction��ʼ=============");
		//ʵ����FORM
		IGCRC1301Form form = (IGCRC1301Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGCRC13BL crcBL = (IGCRC13BL)getBean("igcrc13bl");
		//ʵ����DTO
		IGCRC1301DTO dto = new IGCRC1301DTO();

		//��ȡ�����ɫ�б�
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
				
		dto.setUser(user);
		
		//�ĵ���Ϣ��ѯ
		if( "SEARCH".equals(mapping.getParameter())){
			log.debug("========�ĵ���Ϣ��ѯ����ʼ========");
			//��ȡ��ҳBean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC1301");
			
			int maxCnt = getMaxDataCount("IGCRC1301");
			
			dto.setIgcrc1301Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDTO);
			//����BL��ѯ 
			dto = crcBL.searchEntityItemAction(dto);
			//����VO
			IGCRC1301VO vo = new IGCRC1301VO();
			vo.setIgcrc1301VWList(dto.getEntityItemVWInfoList());
			request.getSession().setAttribute("isManager", dto.getIsManeger()==null?"0":dto.getIsManeger());
			super.<IGCRC1301VO>setVO(request, vo);
			log.debug("========�ĵ���Ϣ��ѯ��������========");
		}
		
		//�ĵ���Ϣ��ѯ
		if( "OPENSEARCH".equals(mapping.getParameter())){
			log.debug("========�ĵ���Ϣ��ѯ����ʼ========");
			//��ȡ��ҳBean
			PagingDTO pDTO = getPaginDTO(request,"IGCRC1301");
			int maxCnt = getMaxDataCount("IGCRC1301");
			dto.setIgcrc1301Form(form);
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDTO);
			//����BL��ѯ 
			dto = crcBL.openSearchEntityItemAction(dto);
			//����VO
			IGCRC1301VO vo = new IGCRC1301VO();
			vo.setIgcrc1301VWList(dto.getEntityItemVWInfoList());
			request.setAttribute("pidid", request.getParameter("pidid"));
			super.<IGCRC1301VO>setVO(request, vo);
			log.debug("========�ĵ���Ϣ��ѯ��������========");
		}
		return mapping.findForward("DISP");
	}
}
