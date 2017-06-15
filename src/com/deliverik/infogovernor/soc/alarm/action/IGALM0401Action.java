/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.action;

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
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.alarm.bl.IGALM04BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM04DTO;
import com.deliverik.infogovernor.soc.alarm.form.IGALM0401Form;
import com.deliverik.infogovernor.soc.alarm.vo.IGALM04021VO;

/**
 * �澯��ϸ��ѯ�����ѯ����
 * @author Xudong Wang 
 * 2013.08.01
 */
public class IGALM0401Action extends BaseAction {

	static Log log = LogFactory.getLog(IGALM0401Action.class);

	/**
	 * �澯��ϸ��ѯ���洦��
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return ActionForward
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGALM0401Form form = (IGALM0401Form)actionForm;
		//BLȡ��
		IGALM04BL ctlBL = (IGALM04BL) getBean("igalm04BL");
		//DTO����
		IGALM04DTO dto = new IGALM04DTO();
		//�澯��Ϣ��ѯ
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========�澯��Ϣ��ѯ������ʾ����ʼ========");
			form.reset(mapping, request);
			log.debug("========�澯��Ϣ��ѯ������ʾ��������========");
			return mapping.findForward("DISP");
		}
		//�澯��Ϣ��ѯ
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.debug("========�澯��Ϣ��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				form = (IGALM0401Form) request.getSession().getAttribute("IGALM0401Form");
			}
			//��ȡ��ҳBean���������ݵ�dto��
			getPaginDTO(request,"IGALM0401");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			//�ж��Ƿ�����ϸ���棬�༭���淵�ز�ѯ����
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGALM0401Form) request.getSession().getAttribute("IGALM0401Form");
				if ( form== null){
					form = new IGALM0401Form();
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
					form = (IGALM0401Form) request.getSession().getAttribute("IGALM0401Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			if("no".equals(request.getParameter("isquery")) || "false".equals(request.getParameter("isof"))){
				form.setPriority(null);
			}
			
			//��ѯ��¼�����ֵ
			int maxCnt = getMaxDataCount("IGALM0401");
			//������������
			dto.setIgalm0401Form(form);
			//��ѯ������¼������
			dto.setMaxSearchCount(maxCnt);
			//��ҳBean����
			String count = ResourceUtility.getString("WARNING_MESSAGE_COUNT");
			
			pDto.setPageDispCount(Integer.parseInt(count));
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchCRM04Action(dto);	
			dto = ctlBL.getAlarmPriority(dto);
			dto = ctlBL.getRefreshRate(dto);
			
			Integer[] string = form.getPriority();
			String checkedPrioritiesStr = "";
			if(string !=null && string.length !=0){
				for(Integer str:string){
					checkedPrioritiesStr = checkedPrioritiesStr + str + "&";
				}
			}
			
			//����VO
			IGALM04021VO vo = new IGALM04021VO();
			vo.setIgalm0401List(dto.getCrm04infoList());
			vo.setAlarmPrioritiesList(dto.getAlarmPrioritiesList());
			vo.setAlarmPrioritiesStr(dto.getAlarmPrioritiesStr());
			vo.setCheckedPrioritiesStr(checkedPrioritiesStr);
			vo.setRefreshRate(dto.getRefreshRate());
			super.<IGALM04021VO>setVO(request, vo);
			
			if("yes".equals(request.getParameter("isquery"))){
				form.setIsquery("yes");
			}else{
				form.setIsquery("");
			}
			
			log.debug("========�澯��Ϣ��ѯ��������========");
		}
		//�澯��ϸ��ѯ
		if( "DETAIL".equals(mapping.getParameter())){
			log.debug("========�澯��ϸ��ѯ������ʾ����ʼ========");
			//ctlBL.xxx();
			log.debug("========�澯��ϸ��ѯ������ʾ��������========");
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
