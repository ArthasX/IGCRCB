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
import com.deliverik.infogovernor.drm.bl.IGDRM17BL;
import com.deliverik.infogovernor.drm.dto.IGDRM17DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1702Form;
import com.deliverik.infogovernor.drm.vo.IGDRM17021VO;

/**
 * <p>
 * Title : InfoGovernor ģ������
 * </p>
 * <p>
 * Description:��ѵ��¼����Action
 * </p>
 * 
 * @author zhangbo@deliverik.com
 * @version 1.0
 */
public class IGDRM1702Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		//��־����ȡ�� 
		Log log = LogFactory.getLog(IGDRM1702Action.class);
		//BLȡ��
		IGDRM17BL ctlBL = (IGDRM17BL) getBean("igdrm17BL");
		//ʵ����DTO
		IGDRM17DTO dto = new IGDRM17DTO();
		//formȡ��
		IGDRM1702Form form = (IGDRM1702Form) actionForm;
		//dto�����趨
		dto.setForm(actionForm);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("===============��ѵ��¼����������ʼ==================");
			dto = ctlBL.initTrainRecordAction(dto);
			//ʵ����vo
			IGDRM17021VO vo = new IGDRM17021VO();
			vo.setAttachmentList(dto.getAttList());
			vo.setTrainparticipantList(dto.getTrainparticipantList());
			super.setVO(request, vo);
			saveToken(request);
			log.debug("===============��ѵ��¼������������==================");
		}
		//��������
		if("CHANGE".equals(mapping.getParameter())){
			if (isTokenValid(request, true)){
				if(form.getTrid() != null && form.getTrid() > 0){
					log.debug("=============��ѵ��¼�޸Ĳ�����ʼ=================");
					dto = ctlBL.changeTrainRecordAction(dto);
					log.debug("=============��ѵ��¼�޸Ĳ�������=================");
				}else{
					log.debug("=============��ѵ��¼����������ʼ=================");
					dto = ctlBL.insertTrainRecordAction(dto);
					log.debug("=============��ѵ��¼������������=================");
				}
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		
		if(StringUtils.isNotEmpty(request.getParameter("backUrl"))){
			request.setAttribute("backUrl", request.getParameter("backUrl"));
			return mapping.findForward("DETAIL");
		}else{
			return mapping.findForward("DISP");
		}
		
	}

}
