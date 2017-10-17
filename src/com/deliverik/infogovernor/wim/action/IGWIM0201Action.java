package com.deliverik.infogovernor.wim.action;

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
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.wim.bl.IGWIM02BL;
import com.deliverik.infogovernor.wim.dto.IGWIM02DTO;
import com.deliverik.infogovernor.wim.form.IGWIM0201Form;
import com.deliverik.infogovernor.wim.vo.IGWIM02011VO;

/**
 * �����Ǽǻ���Action����
 *
 */
public class IGWIM0201Action extends BaseAction {

	static Log log = LogFactory.getLog(IGWIM0201Action.class);

	/**
	 * �����ǼǴ���
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
    public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		//FORMȡ��
		IGWIM0201Form form = (IGWIM0201Form)actionForm;
		
		//BLȡ��
		IGWIM02BL ctlBL = (IGWIM02BL) getBean("igwim02BL");
		//DTO����
		IGWIM02DTO dto = new IGWIM02DTO();
		
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		dto.setIgwim0201Form(form);
		dto.setUser(user);
		//������ѯ��ʼ��
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========������ѯ��ʼ�����������ʾ����ʼ========");

			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGWIM0201");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGWIM0201");
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			//���÷�ҳDTO
			dto.setPagingDto(pDto);
			//��ȡ����
			dto = ctlBL.getCenterOrgAction(dto);
			//��ȡ�����µ���
			dto = ctlBL.getCenterOrgUserAction(dto);
			//��ʼ����ȡ��½�û���orgid
			form.setOrgsyscoding(dto.getUser().getOrgid());
			dto.setForm(form);
			//��ȡ��ǰʱ�䣬�Ӷ���ȡ��ǰһ�ܣ���ʾ��һ�ܵĹ���
			dto = ctlBL.getCurrentWorkByDateAction(dto);
			//��ȡ��ǰ��¼�û�Ȩ��
			dto = ctlBL.getPermissionByUser(dto);
			
			IGWIM02011VO vo = new IGWIM02011VO();
			vo.setDateList(dto.getDateList());
			vo.setDateToWeekYearList(dto.getDateToWeekYearList());
			vo.setOrgMap(dto.getOrgMap());
			vo.setUserOrgList(dto.getUserOrgList());
			vo.setWiList(dto.getWiList());
			super.<IGWIM02011VO>setVO(request, vo);	
			//Ĭ�ϻ�������Ա���Լ���ʱ��Ĭ�Ͻ���
			request.setAttribute("myorg", user.getOrgid());
			request.setAttribute("myuserid", user.getUserid());
			request.setAttribute("permission", dto.getUserPermission());
			form.setWorkDate(IGStringUtils.getCurrentDate());
			form.setUserid(user.getUserid());
			//�鿴Ȩ���ã������Լ��ĵ��ӣ�ֻ�ܿ������ܴ���
			request.setAttribute("powerUserid", user.getUserid());
			log.debug("========������ѯ��ʼ�����������ʾ��������========");
			return mapping.findForward("DISP");
		}
		 
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			log.info("==========������ѯ����Action��ʼ==========");
			
			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGWIM0201");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGWIM0201Form) request.getSession().getAttribute("IGWIM0201Form");
				if ( form == null ) {
					form = new IGWIM0201Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			}else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGWIM0201Form) request.getSession().getAttribute("IGWIM0201Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				 }
			}
			
			int maxCnt = getMaxDataCount("IGWIM0201");
			
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			//���÷�ҳDTO
			dto.setPagingDto(pDto);
			
			//����bl���ݼ���
			ctlBL.getCurrentWorkByDateAction(dto);

			//��ȡ����
			dto = ctlBL.getCenterOrgAction(dto);
			//��ȡ�����µ���
			dto = ctlBL.getCenterOrgUserAction(dto);
			
			//��ȡ��ǰ��¼�û�Ȩ��
			dto = ctlBL.getPermissionByUser(dto);
			//ʵ����IGWIM02011VO
			IGWIM02011VO vo = new IGWIM02011VO();
			vo.setDateList(dto.getDateList());
			vo.setDateToWeekYearList(dto.getDateToWeekYearList());
			vo.setOrgMap(dto.getOrgMap());
			vo.setUserOrgList(dto.getUserOrgList());
			vo.setWiList(dto.getWiList());
			super.<IGWIM02011VO>setVO(request,vo);
			//�鿴Ȩ���ã������Լ��ĵ��ӣ�ֻ�ܿ������ܴ���
			request.setAttribute("powerUserid", user.getUserid());
			request.setAttribute("permission", dto.getUserPermission());
			log.info("==========������ѯ����Action����==========");
		}
		//���ڹ���ȷ�ϴ����ʼ��
		if( "CYCLE_INIT".equals(mapping.getParameter())){
			log.debug("========���ڹ���ȷ�ϴ����ʼ������ʼ========");
			//��ȡ��ǰʱ�䣬�Ӷ���ȡ��ǰһ�ܣ���ʾ��һ�ܵĹ���
			dto = ctlBL.confirmCycleWorkInit(dto);
			request.setAttribute("titleDate", form.getTitleDate());
			//ֻ����ʶ
			request.setAttribute("lookFlag", request.getParameter("lookFlag"));
			IGWIM02011VO vo = new IGWIM02011VO();
			vo.setWiInfo(dto.getWiInfo());
			vo.setWlogList(dto.getWlogList());
			//��������
			log.info("���ڹ����鿴�й�����������"+dto.getDesc());
			vo.setDesc(dto.getDesc());
			super.<IGWIM02011VO>setVO(request, vo);	
			log.debug("========���ڹ���ȷ�ϴ����ʼ����������========");
			return mapping.findForward("DISP");
		}
		//���ڹ���ȷ�ϴ���
		if( "CYCLE".equals(mapping.getParameter())){
			log.debug("========���ڹ���ȷ�ϴ�����ʼ========");
			//��ȡ��ǰʱ�䣬�Ӷ���ȡ��ǰһ�ܣ���ʾ��һ�ܵĹ���
			dto = ctlBL.confirmCycleWork(dto);
			//�رո�ҳ,��ˢ��
			request.setAttribute("close", form.getOpenFlag());
			log.debug("========���ڹ���ȷ�ϴ���������========");
			return mapping.findForward("DISP");
		}
		//���칤��ȷ�ϴ����ʼ��
		if( "Today_Init".equals(mapping.getParameter())){
			log.debug("========���칤��ȷ�ϴ����ʼ������ʼ========");
			//��ȡ��ǰʱ�䣬�Ӷ���ȡ��ǰһ�ܣ���ʾ��һ�ܵĹ���
			dto = ctlBL.confirmTodayWorkInit(dto);	
			request.setAttribute("titleDate", form.getTitleDate());
			//ֻ����ʶ
			request.setAttribute("lookFlag", request.getParameter("lookFlag"));
			IGWIM02011VO vo = new IGWIM02011VO();
			vo.setIsOverTime(dto.getIsOverTime());
			vo.setWiInfo(dto.getWiInfo());
			vo.setWlogList(dto.getWlogList());
			//��������
			vo.setDesc(dto.getDesc());
			super.<IGWIM02011VO>setVO(request, vo);	
			log.debug("========���칤��ȷ�ϴ����ʼ����������========");
			return mapping.findForward("DISP");
		}
		//���칤��ȷ�ϴ���
		if( "TODAY".equals(mapping.getParameter())){
			log.debug("========���칤��ȷ�ϴ�����ʼ========");
			//��ȡ��ǰʱ�䣬�Ӷ���ȡ��ǰһ�ܣ���ʾ��һ�ܵĹ���
			dto = ctlBL.confirmTodayWork(dto);
			//�رո�ҳ��ˢ��
			request.setAttribute("close", form.getOpenFlag());
			log.debug("========���칤��ȷ�ϴ���������========");
			return mapping.findForward("DISP");
		}
		
		if("EXPORT".equals(mapping.getParameter())){
			log.debug("========������Ϣͳ�Ʋ�ѯ��������Action��ʼ========");
			dto.setResponse(response);
			dto = ctlBL.searchExport(dto);
			log.debug("========������Ϣͳ�Ʋ�ѯ��������Action����========");
			return null;
		}

		if("COUNT".equals(mapping.getParameter())){
			log.debug("========������Ϣͳ�Ʋ�ѯ����Action��ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGWIM0201");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if (request.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGWIM0201Form) request.getSession().getAttribute("IGWIM0201Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			 }
			
			//��ȡ�������
			int maxCnt = getMaxDataCount("IGWIM0201");
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			//���÷�ҳDTO
			dto.setPagingDto(pDto);
			
			//����bl���ݼ���
			dto = ctlBL.countSearch(dto);
			
			//ʵ����IGWIM02011VO
			IGWIM02011VO vo = new IGWIM02011VO();
			vo.setWiList(dto.getWiList());
			super.<IGWIM02011VO>setVO(request,vo);
			log.debug("========������Ϣͳ�Ʋ�ѯ����Action����========");
		}
		//��ҳ�ҵĵ��չ���
		if( "FIRSTPAGE".equals(mapping.getParameter())){
			log.debug("========��ҳ�ҵĵ��չ�����ѯ���������ʾ����ʼ========");

			//��ҳ��DTOȡ��
			getPaginDTO(request,"IGWIM0201");
			PagingDTO pDto;
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			int maxCnt = getMaxDataCount("IGWIM0201");
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			//���÷�ҳDTO
			dto.setPagingDto(pDto);
			//��ҳ�ҵĵ��չ���
			dto = ctlBL.findTodayWorkByCondForFirstPage(dto);
			
			IGWIM02011VO vo = new IGWIM02011VO();
			vo.setWiList(dto.getWiList());
			super.<IGWIM02011VO>setVO(request, vo);
			//�鿴Ȩ���ã������Լ��ĵ��ӣ�ֻ�ܿ������ܴ���
			request.setAttribute("myuserid", user.getUserid());
			request.setAttribute("titledate", IGStringUtils.getCurrentDate());
			log.debug("========��ҳ�ҵĵ��չ�����ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
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
	
