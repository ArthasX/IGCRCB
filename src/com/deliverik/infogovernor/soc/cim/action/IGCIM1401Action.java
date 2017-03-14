package com.deliverik.infogovernor.soc.cim.action;

import java.util.Iterator;
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

import com.deliverik.framework.asset.EntityCategory;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM14BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM14DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1401Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM14011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * ��Ա��ѯ����Action����
 *
 */
public class IGCIM1401Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM1401Action.class);

	/**
	 * ��Ա��ѯ
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
		IGCIM1401Form form = (IGCIM1401Form)actionForm;
		
		//BLȡ��
		IGCIM14BL ctlBL = (IGCIM14BL) getBean("igcim14BL");
		
		//DTO����
		IGCIM14DTO dto = new IGCIM14DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//��Ա��ѯ���������ʾ����
			log.debug("========��Ա��ѯ���������ʾ����ʼ========");
			
			//***************************************************************************
			//���ͷ���(��Ա)�趨
			form = new IGCIM1401Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_PERSON);
			req.setAttribute("IGCIM1401Form", form);
			
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
				String roletype = req.getParameter("roletype")==null?"IGAC08":req.getParameter("roletype");
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
				sym03dto1.setSubtype("999010");
				String roletype1 = req.getParameter("roletype")==null?"IGAC08":req.getParameter("roletype");
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
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��Ա��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//��Ա��ѯ��������ʾ����
			log.debug("========��Ա��ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========��Ա��ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGCIM1401");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//��Ա��ѯ����
			log.debug("========��Ա��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM1401Form) req.getSession().getAttribute("IGCIM1401Form");
				if ( form== null){
					form = new IGCIM1401Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_PERSON);
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
					form = (IGCIM1401Form) req.getSession().getAttribute("IGCIM1401Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_PERSON);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM1401");
			
			//DTO��������趨
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//��Ա�����߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			
			//����Ա��Ϣ��������趨��VO��
			IGCIM14011VO vo = new IGCIM14011VO();
			vo.setEntityDataList(dto.getEntityItemVWInfoList());
			super.<IGCIM14011VO>setVO(req, vo);
			
			log.debug("========��Ա��ѯ��������========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//��Աɾ������
			log.debug("========��Աɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//��Ա��Ϣɾ���߼�����
			ctlBL.deleteEntityItemAction(dto);
			
			log.debug("========��Աɾ����������========");
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
