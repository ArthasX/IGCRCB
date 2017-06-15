package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM01BL;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0101Form;
import com.deliverik.infogovernor.asset.vo.IGASM01011VO;

/**
 * @Description: ���Ͳ�ѯ����Action����
 * @Author  
 * @History 2009-8-18     �½�
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 * @Version V2.0
 */
public class IGASM0101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0101Action.class);

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
		IGASM0101Form form = (IGASM0101Form)actionForm;
		
		//BLȡ��
		IGASM01BL ctlBL = (IGASM01BL) getBean("igasm01BL");
		
		//DTO����
		IGASM01DTO dto = new IGASM01DTO();
		
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
			getPaginDTO(req,"IGASM0101");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM0101Form) req.getSession().getAttribute("IGASM0101Form");
				if ( form == null ) {
					form = new IGASM0101Form();
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
					form = (IGASM0101Form) req.getSession().getAttribute("IGASM0101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0101");
			
			//DTO��������趨
			form.setEstatus(null);
			
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			
			dto.setEntitySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//������Ϣ�����߼�����
			dto = ctlBL.searchEntityAction(dto);
			
			req.setAttribute("stopbuttonMap", dto.getStopbuttonMap());
			req.setAttribute("startbuttonMap", dto.getStartbuttonMap());
			
			//��������Ϣ��������趨��VO��
			IGASM01011VO vo = new IGASM01011VO(dto.getEntityList());
			
			super.<IGASM01011VO>setVO(req, vo);
			
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
		//�޸�ģ��״̬1���� 2ͣ��
		if ("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========�ʲ�ģ��״̬�仯����ʼ========");
			if(req.getParameter("eid")!=null){
				form.setEid(req.getParameter("eid"));
			}
			if(req.getParameter("estatus")!=null){
				form.setEstatus(req.getParameter("estatus"));
			}
			dto.setEstatus(form.getEstatus());
			dto.setIgasm0101Form(form);
			ctlBL.changeEntityStatus(dto);
			
			log.debug("========�ʲ�ģ��״̬�仯��������========");
			return mapping.findForward("BACK");
		}
		if( "EXCCELDISP".equals(mapping.getParameter())){
			//��ѯ����
			log.debug("========һ��ģ�Ͳ�ѯ����ʼ========");
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM0112");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM0101Form) req.getSession().getAttribute("IGASM0101Form");
				if ( form == null ) {
					form = new IGASM0101Form();
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
					form = (IGASM0101Form) req.getSession().getAttribute("IGASM0101Form");
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
			
			//form.setEsyscoding_q("999");//��ѯ�ϼ�ģ��Ϊ������ģ�ͣ�����ѯһ��ģ��
			
			//form.setEsyscoding_nq("999009");//����ѯ�����¼�����¼�ģ��
			
			List<String> delList_q = new ArrayList<String>();
			delList_q.add("999009");//����ѯ�����¼�����¼�ģ��
			delList_q.add("999012");//����ѯ��������¼�ģ��
			delList_q.add("999014");//����ѯ��������¼�ģ��
			form.setDelList_q(delList_q);
			dto.setEntitySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//������Ϣ�����߼�����
			dto = ctlBL.searchEntityActionForExportExcelModel(dto);
			
			//��������Ϣ��������趨��VO��
			IGASM01011VO vo = new IGASM01011VO(dto.getEntityList());
			
			super.<IGASM01011VO>setVO(req, vo);
			
			log.debug("========һ��ģ�Ͳ�ѯ��������========");
		}
		if("EXPORTEXCEL".equals(mapping.getParameter())){
			
			dto = ctlBL.searchInfoForExportExcel(form.getEsyscoding());
			IGASM01011VO vo = new IGASM01011VO(dto.getEntityList());
			vo.setOrglist(dto.getOrglist());
			vo.setTopEntityList(dto.getTopEntityList());
			vo.setConfigurationMapList(dto.getConfigurationMapList());
			vo.setCcdList(dto.getCcdList());
			vo.setUserlist(dto.getUserlist());
			super.<IGASM01011VO>setVO(req, vo);
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
