/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.drm.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.bl.IGDRM17BL;
import com.deliverik.infogovernor.drm.dto.IGDRM17DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1701Form;
import com.deliverik.infogovernor.drm.vo.IGDRM17011VO;

/**
 * <p>
 * Title : InfoGovernor ģ������
 * </p>
 * <p>
 * Description:��ѵ��¼��ѯAction
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
public class IGDRM1701Action extends BaseAction {
	
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��־����ȡ�� 
		Log log = LogFactory.getLog(IGDRM1701Action.class);
		
		//BLȡ��
		IGDRM17BL ctlBL = (IGDRM17BL) getBean("igdrm17BL");
		
		//ʵ����DTO
		IGDRM17DTO dto = new IGDRM17DTO();
		
		//formȡ�� 
   		IGDRM1701Form form = (IGDRM1701Form)actionForm;
   		
   		//dto�����趨 
   		dto.setForm(form);
		
        if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())) {
			log.debug("========�û���ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGDRM1701");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM1701Form) request.getSession().getAttribute("IGDRM1701Form");
				if (form == null) {
					form = new IGDRM1701Form();
				} else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGDRM1701Form) request.getSession().getAttribute("IGDRM1701Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			int maxCnt = getMaxDataCount("IGDRM1701");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			dto = ctlBL.searchTrainAction(dto);
			IGDRM17011VO vo = new IGDRM17011VO();
			vo.setTrainrecordList(dto.getTrainrecordList());
			super.<IGDRM17011VO>setVO(request,vo);
			log.debug("========�û���ѯ��������========");
		}else if("DELETE".equals(mapping.getParameter())){
			
			log.debug("===========��ѵ��¼ɾ����ʼ============");
			dto.setDeleteEntityItem(form.getDeleteTrid());
			ctlBL.deleteEntityItemAction(dto);
			log.debug("===========��ѵ��¼ɾ������============");
		}
        List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		
		if(StringUtils.isNotEmpty(request.getParameter("mode"))){
			return mapping.findForward("LIST");
		}else{
			return mapping.findForward("DISP");
		}
	}

}
