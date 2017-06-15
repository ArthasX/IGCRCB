/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.bl.IGDRM07BL;
import com.deliverik.infogovernor.drm.dto.IGDRM07DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0701Form;
import com.deliverik.infogovernor.drm.vo.IGDRM07011VO;


/**
 * �������������Ӧ��ָ�ӷ���Action
 * @author zyl
 * 
 * 2015��3��6��09:12:52
 */
public class IGDRM0701Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0701Action.class);

	/**
	 * 
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		IGDRM0701Form form = (IGDRM0701Form)actionForm;
		//BLȡ��
		IGDRM07BL ctlBL = (IGDRM07BL) getBean("igdrm07BL");
		
		//DTO����
		IGDRM07DTO dto = new IGDRM07DTO();
		dto.setUser(user);
		//������ת�趨
		String forward = "DISP";
		//������������
		if( "DEFINE".equals(mapping.getParameter())){
		    dto=ctlBL.initIGDRM0701DefAction(dto);
		    //����VO
			IGDRM07011VO vo = new IGDRM07011VO();
			vo.setIg500InfoList(dto.getIg500InfoList());
			super.<IGDRM07011VO>setVO(req, vo);
		    return mapping.findForward(forward);
		}
		//����ʵʩ
		if( "IMPL".equals(mapping.getParameter())){
			dto=ctlBL.initIGDRM0701ImplAction(dto);
			//����VO
			IGDRM07011VO vo = new IGDRM07011VO();
			vo.setIg500InfoList(dto.getIg500InfoList());
			super.<IGDRM07011VO>setVO(req, vo);
			return mapping.findForward(forward);
		}
		//������ѯ
		if( "ALLPROCESS".equals(mapping.getParameter())||"SEARCH".equals(mapping.getParameter()) || "SEARCH1".equals(mapping.getParameter())||"SEARCH2".equals(mapping.getParameter())){
			log.debug("========ȫ��������ѯ��ʼ========");

			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDRM0701");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM0701Form) req.getSession().getAttribute("IGDRM0701Form");
				if ( form== null){
					form = new IGDRM0701Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGDRM0701Form) req.getSession().getAttribute("IGDRM0701Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGDRM0701");
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			dto.setIgdrm0701Form(form);
			dto.setPagingDto(pDto);
			dto=ctlBL.initIGDRM0701ALLProcessAction(dto);
			List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
			if (dto.getiG333InfoList() != null && dto.getiG333InfoList().size() > 0) {
				List<IG333Info> statusList = dto.getiG333InfoList();
				statusBeanList.add(new LabelValueBean());
				for (int i = 0; i < statusList.size(); i++) {
					statusBeanList.add(new LabelValueBean(statusList.get(i).getPsdname(), statusList.get(i).getPsdcode()));
				}
			}
			req.setAttribute("statusBeanList", statusBeanList);
			//���ʲ�����Ϣ��������趨��VO��
			IGDRM07011VO vo = new IGDRM07011VO();
			vo.setIg500InfoList(dto.getIg500InfoList());
			super.<IGDRM07011VO>setVO(req, vo);
			log.debug("========ȫ��������ѯ����========");
		
		}
		//����������ѯ
		if("SEARCHCLOSE".equals(mapping.getParameter())){
			log.debug("========����������ѯ��ʼ========");
			form.setPrstatus("C");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDRM0701");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGDRM0701Form) req.getSession().getAttribute("IGDRM0701Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			int maxCnt = getMaxDataCount("IGDRM0701");
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			dto.setIgdrm0701Form(form);
			dto.setPagingDto(pDto);
			dto=ctlBL.initIGDRM0701ALLProcessAction(dto);
			List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
			if (dto.getiG333InfoList() != null && dto.getiG333InfoList().size() > 0) {
				List<IG333Info> statusList = dto.getiG333InfoList();
				statusBeanList.add(new LabelValueBean());
				for (int i = 0; i < statusList.size(); i++) {
					statusBeanList.add(new LabelValueBean(statusList.get(i).getPsdname(), statusList.get(i).getPsdcode()));
				}
			}
			req.setAttribute("statusBeanList", statusBeanList);
			//���ʲ�����Ϣ��������趨��VO��
			IGDRM07011VO vo = new IGDRM07011VO();
			vo.setIg500InfoList(dto.getIg500InfoList());
			super.<IGDRM07011VO>setVO(req, vo);
			log.debug("========����������ѯ����========");
			
		}
		//����ҳ
		if( "SEL".equals(mapping.getParameter())){
			dto.setPrpdidLike(IGDRMCONSTANTS.DRILL_PROCESS_DEF_ID);
			dto=ctlBL.searchProcess(dto);
			//����VO
			IGDRM07011VO vo = new IGDRM07011VO();
			vo.setIg500InfoList(dto.getIg500InfoList());
			super.<IGDRM07011VO>setVO(req, vo);
			return mapping.findForward(forward);
		}
		
		if("SEARCHEMCLOSE".equals(mapping.getParameter())){
			log.debug("========Ӧ��ָ�Ӳ�ѯ��ʼ========");
			form.setPrstatus("C");
			form.setPrurgency("0");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDRM0701");

			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				form = (IGDRM0701Form) req.getSession().getAttribute("IGDRM0701Form");
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			int maxCnt = getMaxDataCount("IGDRM0701");
			//DTO��������趨
			dto.setMaxSearchCount(maxCnt);
			dto.setIgdrm0701Form(form);
			dto.setPagingDto(pDto);
			dto=ctlBL.initIGDRM0701ALLProcessAction(dto);
			List<LabelValueBean> statusBeanList = new ArrayList<LabelValueBean>();
			if (dto.getiG333InfoList() != null && dto.getiG333InfoList().size() > 0) {
				List<IG333Info> statusList = dto.getiG333InfoList();
				statusBeanList.add(new LabelValueBean());
				for (int i = 0; i < statusList.size(); i++) {
					statusBeanList.add(new LabelValueBean(statusList.get(i).getPsdname(), statusList.get(i).getPsdcode()));
				}
			}
			req.setAttribute("statusBeanList", statusBeanList);
			//���ʲ�����Ϣ��������趨��VO��
			IGDRM07011VO vo = new IGDRM07011VO();
			vo.setIg500InfoList(dto.getIg500InfoList());
			super.<IGDRM07011VO>setVO(req, vo);
			log.debug("========Ӧ��ָ�Ӳ�ѯ����========");
		}
		
        List<ActionMessage> messageList = dto.getMessageList();
        if (messageList != null && messageList.size() > 0) {
            for (ActionMessage message : messageList) {
                addMessage(req, message);
            }
        }
		return mapping.findForward(forward);
	}
}
