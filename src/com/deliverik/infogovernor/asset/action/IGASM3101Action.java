/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.asset.EntityCategory;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM3101ExcelBL;
import com.deliverik.infogovernor.asset.bl.IGASM31BL;
import com.deliverik.infogovernor.asset.dto.IGASM3101ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3101Form;
import com.deliverik.infogovernor.asset.vo.IGASM31011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * ����ָ���ѯ����Action����
 *
 */
public class IGASM3101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM3101Action.class);

	/**
	 * �¼�����
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
		IGASM3101Form form = (IGASM3101Form)actionForm;
		
		//BLȡ��
		IGASM31BL ctlBL = (IGASM31BL) getBean("igasm31BL");
		
		
		//DTO����
		IGASM31DTO dto = new IGASM31DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//����ָ���ѯ���������ʾ����
			log.debug("========����ָ���ѯ���������ʾ����ʼ========");
			
			//***************************************************************************
			//���ͷ���(����ָ��)�趨
			form = new IGASM3101Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_RISK_TARGET);
			req.setAttribute("IGASM3101Form", form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto = ctlBL.checkEntityItemDomain(dto);
			
			if(EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE))) {
				req.getSession().setAttribute("ADmode", EntityCategory.ENTITYITEM_PERMISSION_MODE_A);
			} else {
				req.getSession().setAttribute("ADmode", EntityCategory.ENTITYITEM_PERMISSION_MODE_B);
			}
			//�����ģʽA���Ǹ����ˣ���Ȩ�����
			if(dto.getFlag() && EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE))) {
				req.setAttribute("deforgsys", dto.getOrgsyscoding());
				req.setAttribute("deforgname", dto.getOrgname());
				req.setAttribute("defassetsys", "_" + dto.getEsyscoding());
				req.setAttribute("defassetname", dto.getEname());
				req.getSession().setAttribute("ADrolemanager", "true");
				
			}else {
				//���ó�ʼȨ����
				IGSYM03DTO sym03dto = new IGSYM03DTO();
				IGSYM03BL treeBL = (IGSYM03BL) getBean("igsym03BL");
				String roletype = req.getParameter("roletype")==null?"IGAC10":req.getParameter("roletype");
				sym03dto = treeBL.getRoleDomainTree(sym03dto, roletype, user);
				Map<String,TreeNode> treeNodeMap = sym03dto.getTreeNodeMap();
				if(treeNodeMap!=null&&!treeNodeMap.isEmpty()){			
					if(treeNodeMap.keySet()!=null&&!treeNodeMap.keySet().isEmpty()){
							Iterator<String> it=treeNodeMap.keySet().iterator();
							while(it.hasNext()){
								Object obj = it.next();
								String key=(String)obj;	
								TreeNode treeNode=(TreeNode)treeNodeMap.get(key);
								req.setAttribute("deforgsys", treeNode.getId());
								req.setAttribute("deforgname", treeNode.getName());
								break;
							}
							
					}
				}
				
				
				//���ó�ʼ�ʲ�����������
				IGSYM03DTO sym03dto1 = new IGSYM03DTO();
				IGSYM03BL treeBL1 = (IGSYM03BL) getBean("igsym03BL");
				sym03dto1.setSubtype("999019");
				String roletype1 = req.getParameter("roletype")==null?"IGAC14":req.getParameter("roletype");
				sym03dto1 = treeBL1.getAssetDomainTree(sym03dto1, roletype1, user);
				Map<String,TreeNode> treeNodeMap1 = sym03dto1.getTreeNodeMap();
				if(treeNodeMap1!=null&&!treeNodeMap1.isEmpty()){			
					if(treeNodeMap1.keySet()!=null&&!treeNodeMap1.keySet().isEmpty()){
							Iterator<String> it=treeNodeMap1.keySet().iterator();
							while(it.hasNext()){
								Object obj = it.next();
								String key=(String)obj;	
								TreeNode treeNode=(TreeNode)treeNodeMap1.get(key);
								req.setAttribute("defassetsys", treeNode.getId());
								req.setAttribute("defassetname", treeNode.getName());
								break;
							}
							
					}
				}
			}
			//***************************************************************************
			
			//��ȡ���������б�ֵ*
			ctlBL.searchRiskPropertyActioin(dto);
			
			//������ָ����Ϣ��������趨��VO��
			IGASM31011VO vo = new IGASM31011VO(dto.getEntityItemVWInfoList());
			
			//����ָ��--��ֵ����
			vo.setThresholdList(dto.getThresholdList());
			
			//����ָ��--�Ƿ�ؼ�ָ������
			vo.setKeyIndexList(dto.getKeyIndexList());
			
			super.<IGASM31011VO>setVO(req, vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����ָ���ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//����ָ���ѯ��������ʾ����
			log.debug("========����ָ���ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========����ָ���ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())||"SEARCHWINDOW".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM3101");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM3101");
			//����ָ���ѯ����
			log.debug("========����ָ���ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM3101Form) req.getSession().getAttribute("IGASM3101Form");
				if ( form== null){
					form = new IGASM3101Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_RISK_TARGET);
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else if("SEARCHWINDOW".equals(mapping.getParameter())){
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGASM3101Form) req.getSession().getAttribute("IGASM3101Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_RISK_TARGET);
					if (form !=null) {
						form.setFromCount(0);
					}
					String eiids = req.getParameter("eiids");
					//���eiidΪ�գ�ֱ�ӽ��в�ѯ�������ǽ��Բ�ѯ���ļ��ָ����ȥ��
					if(StringUtils.isNotEmpty(eiids)){
						StringBuffer eiid_NotIn = new StringBuffer();
						if(StringUtils.isNotEmpty(eiids) && !("0".equals(eiids))){
							String[] eiidList = eiids.split(",");
							for(int i=0;i<eiidList.length;i++){
								eiid_NotIn.append("'");
								eiid_NotIn.append(eiidList[i]);
								eiid_NotIn.append("'");
								if(i<eiidList.length-1){
									eiid_NotIn.append(",");
								}
							}
						}
						form.setEiid_NotIn(eiid_NotIn.toString());
					}
					//����ҳ
					pDto.setFromCount(0);
					pDto.setPageDispCount(maxCnt);
				}
			}else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGASM3101Form) req.getSession().getAttribute("IGASM3101Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_RISK_TARGET);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//DTO��������趨
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setIGASM3101FORM(form);
			//��ȡ���������б�ֵ*
			ctlBL.searchRiskPropertyActioin(dto);
			
			//����ָ������߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			
			//������ָ����Ϣ��������趨��VO��
			IGASM31011VO vo = new IGASM31011VO(dto.getEntityItemVWInfoList());
			
			//����ָ��--��ֵ����
			vo.setThresholdList(dto.getThresholdList());
			
			//����ָ��--�Ƿ�ؼ�ָ������
			vo.setKeyIndexList(dto.getKeyIndexList());
			//��ѯ������ؼ���
			vo.setSearchRiskIndexSearchVWList(dto.getSearchRiskIndexSearchVWList());
			
			super.<IGASM31011VO>setVO(req, vo);
			
			log.debug("========����ָ���ѯ��������========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//����ָ��ɾ������
			log.debug("========����ָ��ɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//����ָ����Ϣɾ���߼�����
			ctlBL.deleteEntityItemAction(dto);
			
			log.debug("========����ָ��ɾ����������========");
		}
		
		if("EXCEL".equals(mapping.getParameter())){
			log.debug("=====================����ָ���ѯ������ʼ=======================");

			dto.setIGASM3101FORM(form);
			
			// ȡ��Excel����BL
			IGASM3101ExcelBL excelBL = (IGASM3101ExcelBL) getBean("igasm3101ExcelBL");
			
			/**��ʼ�����ݲ�ѯ*/
			ctlBL.searchRiskPropertyActioin(dto);
			//����bl �������ݴ���
			dto=excelBL.searchRiskPointManagerAction(dto);
			
			// ʵ��ExeclDTO
			IGASM3101ExcelDTO excelDTO = new IGASM3101ExcelDTO();
			excelDTO.setProcessList(dto.getSearchRiskIndexSearchVWList());
			// ���ģ����
			excelDTO.setFileid("ASM3101");
			excelDTO.setResponse(res);
			excelBL.initExcel(excelDTO);
			
			log.debug("=====================����ָ���ѯ��������=======================");
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
