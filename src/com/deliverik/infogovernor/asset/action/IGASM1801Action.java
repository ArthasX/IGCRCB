package com.deliverik.infogovernor.asset.action;

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
import com.deliverik.infogovernor.asset.bl.IGASM18BL;
import com.deliverik.infogovernor.asset.dto.IGASM18DTO;
import com.deliverik.infogovernor.asset.form.IGASM1801Form;
import com.deliverik.infogovernor.asset.vo.IGASM18011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * ϵͳ��ѯ����Action����
 *
 */
public class IGASM1801Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM1801Action.class);

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
		IGASM1801Form form = (IGASM1801Form)actionForm;
		
		//BLȡ��
		IGASM18BL ctlBL = (IGASM18BL) getBean("igasm18BL");
		
		//DTO����
		IGASM18DTO dto = new IGASM18DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//ϵͳ��ѯ���������ʾ����
			log.debug("========ϵͳ��ѯ���������ʾ����ʼ========");
			
			//***************************************************************************
			//���ͷ���(ϵͳ)�趨
			form = new IGASM1801Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_SYSTEM);
			req.setAttribute("IGASM1801Form", form);
			
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
				String roletype = req.getParameter("roletype")==null?"IGAC09":req.getParameter("roletype");
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
				sym03dto1.setSubtype("999006");
				String roletype1 = req.getParameter("roletype")==null?"IGAC09":req.getParameter("roletype");
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
			log.debug("========ϵͳ��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//ϵͳ��ѯ��������ʾ����
			log.debug("========ϵͳ��ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========ϵͳ��ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM1801");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//ϵͳ��ѯ����
			log.debug("========ϵͳ��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM1801Form) req.getSession().getAttribute("IGASM1801Form");
				if ( form== null){
					form = new IGASM1801Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_SYSTEM);
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
					form = (IGASM1801Form) req.getSession().getAttribute("IGASM1801Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_SYSTEM);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM1801");
			
			//DTO��������趨
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//ϵͳ�����߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			
			//��ϵͳ��Ϣ��������趨��VO��
			IGASM18011VO vo = new IGASM18011VO(dto.getEntityItemVWInfoList());
			
			super.<IGASM18011VO>setVO(req, vo);
			
			log.debug("========ϵͳ��ѯ��������========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//ϵͳɾ������
			log.debug("========ϵͳɾ������ʼ========");
			
			//DTO��������趨
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//ϵͳ��Ϣɾ���߼�����
			ctlBL.deleteEntityItemAction(dto);
			
			log.debug("========ϵͳɾ����������========");
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
