package com.deliverik.infogovernor.syslog.action;


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
import com.deliverik.infogovernor.syslog.bl.IGLOG002BL;
import com.deliverik.infogovernor.syslog.dto.IGLOG0021DTO;
import com.deliverik.infogovernor.syslog.form.IGLOG0021Form;
import com.deliverik.infogovernor.syslog.vo.IGLOG0021VO;

/**
 * <p>
 * Title : InfoGovernor ��־�������
 * </p>
 * <p>
 * Description: ��ѯACTION
 * </p>
 * 
 * @author wangrongguagn@deliverik.com
 * @version 1.0
 */
public class IGLOG0021Action extends BaseAction{
	
	static Log log = LogFactory.getLog(IGLOG0021Action.class);
	
	/**
	 * <p>
	 * Description:
	 * </p>
	 * 
	 * @param mapping
	 *            ActionMapping
	 * @param form
	 *            ActionForm
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//ʵ����DTO
		IGLOG0021DTO dto = new IGLOG0021DTO();
		
		//�澯����formȡ��
		IGLOG0021Form form = (IGLOG0021Form) actionForm;
		
		//ʵ����ctrolBL
		IGLOG002BL ctlBL = (IGLOG002BL) getBean("iglog002BL");
		
		//��form�����dto������
		dto.setIgLog0021Form(form);
		
		//�����ѯҳ
		if("SEARCH".equals(mapping.getParameter())){
			log.debug("========�澯��������ѯ��ʼ========");
			
			getPaginDTO(request,"IGLOG0021");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGLOG0021Form) request.getSession().getAttribute("IGLOG0021Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			pDto.setPageDispCount(10);
			
			int maxCnt = getMaxDataCount("IGLOG0021");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			
			dto = ctlBL.searchDeviceTemps(dto);
			
			IGLOG0021VO vo = new IGLOG0021VO();
			vo.setDeviceTempList(dto.getDeviceTempList());
			
			super.<IGLOG0021VO> setVO(request, vo);
			
			log.debug("========�澯��������ѯ����========");
		}
		if("EDIT_DISP".equals(mapping.getParameter())){
			
			dto = ctlBL.getDevice(dto);//��ȡ�豸��Ϣ
			dto = ctlBL.getDevicesByTypeid(dto);
			dto = ctlBL.getRuleTempsByDeviceid(dto);//���豸ID��ȡ���������б�
			dto = ctlBL.getRuleTempsByTypeid(dto);//ͨ���豸���ͻ�ȡ�����͹����б�
			dto = ctlBL.getRelationEntityByDeviceid(dto);
			
			IGLOG0021VO vo = new IGLOG0021VO();
			vo.setMss00001TB(dto.getMss00001TB());
			vo.setDeviceList(dto.getDeviceList());
			vo.setTempList(dto.getTempList());
			vo.setTempListFromDevice(dto.getTempListFromDevice());
			vo.setTypeid(form.getTypeid());
			vo.setMss00002TB(dto.getMss00002TB());
			
			super.<IGLOG0021VO> setVO(request, vo);
		}
		if("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========�澯����״̬�޸Ŀ�ʼ========");
			dto = ctlBL.changeTempstate(dto);
			log.debug("========�澯����״̬�޸Ľ���========");
		}
		if("DELETE".equals(mapping.getParameter())){
			log.debug("========�澯����ɾ����ʼ========");
			dto = ctlBL.deleteAlarmRule(dto);
			log.debug("========�澯����ɾ������========");
		}
		if("EDIT".equals(mapping.getParameter())){
			
			dto = ctlBL.updateDeviceAndRules(dto);
		}
		List<ActionMessage> messageList = dto.getMessageList();
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
