/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prd.action;

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
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.prd.bl.IGPRD02BL;
import com.deliverik.infogovernor.prd.dto.IGPRD02DTO;
import com.deliverik.infogovernor.prd.form.IGPRD0201Form;
import com.deliverik.infogovernor.prd.vo.IGPRD02011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�û���ѯaction 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRD0201Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGPRD0201Action.class);
		//blȡ��
		IGPRD02BL ctlBL = (IGPRD02BL) getBean("igprd02BL");
		//ʵ����dto
		IGPRD02DTO dto = new IGPRD02DTO();
		//formȡ��
		IGPRD0201Form form = (IGPRD0201Form) actionForm;
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("===========�û���ѯҳ���ʼ��������ʼ============");
			//���form
			log.debug("===========�û���ѯҳ���ʼ����������============");
		}
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("===========�û���ѯ������ʼ=============");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGPRD0201");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGPRD0201Form) request.getSession().getAttribute("IGPRD0201Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			
			//����ҳ���ѯ������¼����ȡ��
			int maxCnt = getMaxDataCount("IGPRD0201");
			//����ҳ���ѯ������¼�����趨
			dto.setMaxSearchCount(maxCnt);
			//��ҳdto�趨
			dto.setPagingDto(pDto);
			//form�趨
			dto.setIgprd0201Form(form);
			//����BL��ѯ�û�����
			dto = ctlBL.searchUserInfoList(dto);
			//ʵ����vo
			IGPRD02011VO vo = new IGPRD02011VO();
			vo.setUserroleList(dto.getUserroleList());
			super.<IGPRD02011VO>setVO(request, vo);
			log.debug("===========�û���ѯ��������=============");
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}

