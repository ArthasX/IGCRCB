/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm.action;

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
import com.deliverik.infogovernor.drm.bl.IGDRM05BL;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0502Form;
import com.deliverik.infogovernor.drm.vo.IGDRM05021VO;
import com.google.gson.Gson;


/**
 * ר��Ԥ������Action
 * @author zyl
 *
 * 2015-2-28 10:27:47
 */
public class IGDRM0502Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0502Action.class);

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
		
		//BLȡ��
		IGDRM05BL ctlBL = (IGDRM05BL) getBean("igdrm05BL");
		
		IGDRM0502Form form = (IGDRM0502Form)actionForm;
		
		//DTO����
		IGDRM05DTO dto = new IGDRM05DTO();
		dto.setUser(user);
		//Ԥ��Gson
		Gson g = new Gson();
		
		//������ת�趨
		String forward = "DISP";

	
		if("DISP".equals(mapping.getParameter())){
			//���̶����ѯ����
			log.debug("========ר��Ԥ����ѯ��ʼ������ʼ========");
			form.setEsyscoding("");
			form.setEiname("");
			dto.setIgdrm0502Form(form);
			getPaginDTO(req,"IGDRM0501");
			
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if (req.getParameter("PAGING") == null) {
				pDto.setFromCount(0);
				if (form !=null) {
					form.setFromCount(0);
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDRM0502");
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//ר��Ԥ���ʲ���ѯ
			dto = ctlBL.searchSpeicalPlanResource(dto);
			
			IGDRM05021VO vo = new IGDRM05021VO();
			vo.setEntityItemList(dto.getEntityItemList());	
			vo.setNodeMapJson(g.toJson(dto.getNodeMap()));
			super.<IGDRM05021VO>setVO(req, vo);
			
			log.debug("========ר��Ԥ����ѯ��ʼ����������========");
		}
		if("SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//���̶����ѯ����
			log.debug("========ר��Ԥ����ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDRM0501");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM0502Form) req.getSession().getAttribute("IGDRM0502Form");
				if ( form == null ) {
					form = new IGDRM0502Form();
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
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDRM0502");
			
			dto.setIgdrm0502Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//��ȡ��ǰ��
//			if(StringUtil.isEmpty(form.getEiinsdate())){
//				Calendar cal = Calendar.getInstance();
//				int year = cal.get(Calendar.YEAR);
//				req.setAttribute("eiinsdate", year);
//			}else{
//				req.setAttribute("eiinsdate", form.getEiinsdate());
//			}
			//ר��Ԥ���ʲ���ѯ�߼�����
			dto = ctlBL.searchSpeicalPlanResource(dto);
			
			IGDRM05021VO vo = new IGDRM05021VO();
			
			vo.setEntityItemList(dto.getEntityItemList());
			
			vo.setNodeMapJson(g.toJson(dto.getNodeMap()));
			
			super.<IGDRM05021VO>setVO(req, vo);
			
			saveToken(req);
			
			log.debug("========ר��Ԥ����ѯ��������========");
		}
		//ɾ��	
		if("DELETE".equals(mapping.getParameter())){
			dto.setIgdrm0502Form(form);
			dto.setUser(user);
			//DTO��������趨
			dto.setDeleteEntityItem(form.getDeleteEiid());
			//ר��Ԥ���ʲ���Ϣɾ���߼�����
			ctlBL.deleteEntityItemAction(dto);
		}

		// �߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();

		if (messageList != null && messageList.size() > 0) {
			for (ActionMessage message : messageList) {
				addMessage(req, message);
			}

		}
			log.debug("========ר��Ԥ��������Ϣ��ʷ��¼���������ʾ��������========");

		return mapping.findForward(forward);
	}
}
