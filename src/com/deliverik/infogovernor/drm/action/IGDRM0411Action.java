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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.drm.bl.IGDRM04BL;
import com.deliverik.infogovernor.drm.dto.IGDRM04DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0411Form;
import com.deliverik.infogovernor.drm.vo.IGDRM04111VO;

/**
 * @Description: ���Ͳ�ѯ����Action����
 * @Author  
 * @History 2009-8-18     �½�
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 * @Version V2.0
 */
public class IGDRM0411Action extends BaseAction {

	static Log log = LogFactory.getLog(IGDRM0411Action.class);

	/**
	 * ����
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGDRM0411Form form = (IGDRM0411Form)actionForm;
		
		//BLȡ��
		IGDRM04BL ctlBL = (IGDRM04BL) getBean("igdrm04BL");
		
		//DTO����
		IGDRM04DTO dto = new IGDRM04DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//���Ͳ�ѯ���������ʾ����
			log.debug("========���Ͳ�ѯ���������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���Ͳ�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//���Ͳ�ѯ��������ʾ����
			log.debug("========���Ͳ�ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========���Ͳ�ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//���Ͳ�ѯ����
			log.debug("========���Ͳ�ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGDRM0411");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM0411Form) req.getSession().getAttribute("IGDRM0411Form");
				if ( form == null ) {
					form = new IGDRM0411Form();
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
					form = (IGDRM0411Form) req.getSession().getAttribute("IGDRM0411Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGDRM0411");
			
			//DTO��������趨
			form.setEstatus(null);
			
//			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
//			form.setSyscoding_q("999040");
			dto.setIgdrm0411Form(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			
			
			//������Ϣ�����߼�����
			dto = ctlBL.searchEntityAction(dto);
			
			req.setAttribute("stopbuttonMap", dto.getStopbuttonMap());
			req.setAttribute("startbuttonMap", dto.getStartbuttonMap());
			
			//��������Ϣ��������趨��VO�� 
			IGDRM04111VO vo = new IGDRM04111VO(null,dto.getErEntityList());
			
			super.<IGDRM04111VO>setVO(req, vo);
			
			log.debug("========���Ͳ�ѯ��������========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//����ɾ������
			log.debug("========����ɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntity(form.getDeleteEid());
			
			//������Ϣɾ���߼�����
			ctlBL.deleteEntityAction(dto);
			
			log.debug("========����ɾ����������========");
		}
		//�޸ķ���״̬1���� 2ͣ��
		if ("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========�ʲ�����״̬�仯����ʼ========");
			if(req.getParameter("eid")!=null){
				form.setEid(req.getParameter("eid"));
			}
			if(req.getParameter("estatus")!=null){
				form.setEstatus(req.getParameter("estatus"));
			}
			dto.setEstatus(form.getEstatus());
			dto.setIgdrm0411Form(form);
			ctlBL.changeEntityStatus(dto);
			
			log.debug("========�ʲ�����״̬�仯��������========");
			return mapping.findForward("BACK");
		}
		if( "EXCCELDISP".equals(mapping.getParameter())){
			//��ѯ����
			log.debug("========һ�������ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM0112");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGDRM0411Form) req.getSession().getAttribute("IGDRM0411Form");
				if ( form == null ) {
					form = new IGDRM0411Form();
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
					form = (IGDRM0411Form) req.getSession().getAttribute("IGDRM0411Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0112");
			
			//DTO��������趨
			form.setEstatus("1");
			
			//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			
			//form.setEsyscoding_q("999");//��ѯ�ϼ�����Ϊ�����ķ��࣬����ѯһ������
			
			//form.setEsyscoding_nq("999009");//����ѯ�����¼�����¼�����
			
			List<String> delList_q = new ArrayList<String>();
			delList_q.add("999009");//����ѯ�����¼�����¼�����
			delList_q.add("999012");//����ѯ��������¼�����
			delList_q.add("999014");//����ѯ��������¼�����
			form.setDelList_q(delList_q);
			dto.setEntitySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//������Ϣ�����߼�����
			dto = ctlBL.searchEntityActionForExportExcelModel(dto);
			
			//��������Ϣ��������趨��VO��
			IGDRM04111VO vo = new IGDRM04111VO(dto.getEntityList(),null);
			
			super.<IGDRM04111VO>setVO(req, vo);
			
			log.debug("========һ�������ѯ��������========");
		}
		if("EXPORTEXCEL".equals(mapping.getParameter())){
			
			dto = ctlBL.searchInfoForExportExcel(form.getEsyscoding());
			IGDRM04111VO vo = new IGDRM04111VO(dto.getEntityList(),null);
			vo.setOrglist(dto.getOrglist());
			vo.setTopEntityList(dto.getTopEntityList());
			vo.setConfigurationMapList(dto.getConfigurationMapList());
			vo.setCcdList(dto.getCcdList());
			vo.setUserlist(dto.getUserlist());
			super.<IGDRM04111VO>setVO(req, vo);
		}
		//�߼���������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
