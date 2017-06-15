package com.deliverik.infogovernor.soc.cim.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM04BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0401Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1202Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04011VO;

/**
 * @Description: ���Ͳ�ѯ����Action����
 * @Author  
 * @History 2009-8-18     �½�
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 * @Version V2.0
 */
public class IGCIM0401Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0401Action.class);

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
		IGCIM0401Form form = (IGCIM0401Form)actionForm;
		
		//BLȡ��
		IGCIM04BL ctlBL = (IGCIM04BL) getBean("igcim04BL");
		
		//DTO����
		IGCIM04DTO dto = new IGCIM04DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//���Ͳ�ѯ���������ʾ����
			log.debug("========���Ͳ�ѯ���������ʾ����ʼ========");
			IGCIM1202Form treeForm = new IGCIM1202Form();
			treeForm.setEparcoding("999");
			treeForm.setEsyscoding_tree("999");
//			treeForm.setEkey1(EntityItemKeyWords.ENTITY_EKEY1_0);//����ģ�����ʲ�������ʾ�����أ�ʹ��entity����Ԥ���ֶ�EKEY1��0������ʾ��1��������
			//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			dto.setIgcim1202Form(treeForm);
			String treetype = req.getParameter("treetype");
			String attribute_name="ENTITYTREE03_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)req.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGCIM04011VO vo = new IGCIM04011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGCIM04011VO>setVO(req, vo);
			}else{
				dto = ctlBL.searchEntityTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGCIM04011VO vo = new IGCIM04011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				String eid = (String) req.getSession().getAttribute("eid");
				if(eid == null){
					eid = "CM01000000";
				}else{
					req.getSession().setAttribute("eid", null);
				}
				vo.setEidInSession(eid);
				super.<IGCIM04011VO>setVO(req, vo);
			}
			
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
			getPaginDTO(req,"IGCIM0401");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM0401Form) req.getSession().getAttribute("IGCIM0401Form");
				if ( form == null ) {
					form = new IGCIM0401Form();
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
					form = (IGCIM0401Form) req.getSession().getAttribute("IGCIM0401Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0401");
			
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
			IGCIM04011VO vo = new IGCIM04011VO(dto.getEntityList());
//			CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH
			
			super.<IGCIM04011VO>setVO(req, vo);
			
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
			dto.setIgcim0401Form(form);
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
				form = (IGCIM0401Form) req.getSession().getAttribute("IGCIM0401Form");
				if ( form == null ) {
					form = new IGCIM0401Form();
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
					form = (IGCIM0401Form) req.getSession().getAttribute("IGCIM0401Form");
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
			IGCIM04011VO vo = new IGCIM04011VO(dto.getEntityList());
			
			super.<IGCIM04011VO>setVO(req, vo);
			
			log.debug("========һ��ģ�Ͳ�ѯ��������========");
		}
		if("EXPORTEXCEL".equals(mapping.getParameter())){
			
			dto = ctlBL.searchInfoForExportExcel(form.getEsyscoding());
			IGCIM04011VO vo = new IGCIM04011VO(dto.getEntityList());
			vo.setOrglist(dto.getOrglist());
			vo.setTopEntityList(dto.getTopEntityList());
			vo.setConfigurationMapList(dto.getConfigurationMapList());
			vo.setCcdList(dto.getCcdList());
			vo.setUserlist(dto.getUserlist());
			super.<IGCIM04011VO>setVO(req, vo);
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
