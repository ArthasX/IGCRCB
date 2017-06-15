/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.action;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.dwp.bl.IGDWP01BL;
import com.deliverik.infogovernor.dwp.dto.IGDWP01DTO;
import com.deliverik.infogovernor.dwp.form.IGDWP0101Form;
import com.deliverik.infogovernor.dwp.vo.IGDWP01011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����ѯAction
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGDWP0101Action extends BaseAction{

	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, 
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//��־����ȡ��
		Log log = LogFactory.getLog(IGDWP0101Action.class);
		//BLȡ��
		IGDWP01BL ctlBL = (IGDWP01BL) getBean("igdwp01BL");
		//ʵ����dto
		IGDWP01DTO dto = new IGDWP01DTO();
		//formȡ��
		IGDWP0101Form form = (IGDWP0101Form) actionForm;
		//��¼�û�ȡ��
		User user = (User) request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//dto�����趨
		dto.setForm(form);
		dto.setUser(user);
		//ҳ���ʼ������
		if("DISP".equals(mapping.getParameter())){
			log.debug("================�ճ������ƻ���ѯҳ���ʼ��������ʼ=================");
			log.debug("================�ճ������ƻ���ѯҳ���ʼ����������=================");
		}
		
		//�ճ������ƻ���ѯ����
		if("SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())){
			//��ȡ��ҳBean
			getPaginDTO(request,"IGDWP0101");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDWP0101Form) request.getSession().getAttribute("IGDWP0101Form");
				if ( form == null ) {
					form = new IGDWP0101Form();
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
					form = (IGDWP0101Form) request.getSession().getAttribute("IGDWP0101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			if("Y".equals(form.getSingle())){
				form.setPuserid(user.getUserid());
			}else{
				form.setPuserid(null);
			}
			int maxCnt = getMaxDataCount("IGDWP0101");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchDayWorkPlanAction(dto);
			//ʵ����vo
			IGDWP01011VO vo = new IGDWP01011VO();
			vo.setDayWorkPlanList(dto.getDayWorkPlanList());
			super.<IGDWP01011VO>setVO(request, vo);
			saveToken(request);
		}
		//����ɾ������
		if("DELETE".equals(mapping.getParameter())){
			log.debug("================�ճ������ƻ�ɾ��������ʼ=================");
			if (isTokenValid(request, true)){
				dto = ctlBL.deleteDayWorkPlanAction(dto);
			}else{
				addMessage(request, new ActionMessage("IGCO00000.E007"));
				return mapping.findForward("/error1");
			}
			log.debug("================�ճ������ƻ�ɾ����������=================");
		}
		
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
