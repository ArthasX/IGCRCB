package com.deliverik.infogovernor.asset.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM03BL;
import com.deliverik.infogovernor.asset.dto.IGASM03DTO;
import com.deliverik.infogovernor.asset.form.IGASM0312Form;
import com.deliverik.infogovernor.asset.vo.IGASM03121VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * �豸�Ͻɲ�ѯ����Action����
 *
 */
public class IGASM0312Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0312Action.class);

	/**
	 * �豸�Ͻ�
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGASM0312Form form = (IGASM0312Form)actionForm;
		
		//BLȡ��
		IGASM03BL ctlBL = (IGASM03BL) getBean("igasm03BL");
		
		//DTO����
		IGASM03DTO dto = new IGASM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//�豸��ѯ���������ʾ����
			log.debug("========�豸�Ͻɲ�ѯ���������ʾ����ʼ========");
			
			//***************************************************************************
			//���ͷ���(�豸)�趨
			form = new IGASM0312Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
			req.setAttribute("IGASM0312Form", form);
			
			//���ó�ʼȨ����
			IGSYM03DTO sym03dto = new IGSYM03DTO();
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			IGSYM03BL treeBL = (IGSYM03BL) getBean("igsym03BL");
			String roletype = req.getParameter("roletype")==null?"IGAC01":req.getParameter("roletype");
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
			sym03dto1.setSubtype("999001");
			sym03dto1.setIsItDrivers("t");
			String roletype1 = req.getParameter("roletype")==null?"IGAC01":req.getParameter("roletype");
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
			//***************************************************************************
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�豸�Ͻɲ�ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//�豸��ѯ��������ʾ����
			log.debug("========�豸��ѯ��������ʾ����ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�豸��ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM0312");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//�豸�·���ѯ������ѯEntityItem��
			log.debug("========�豸�Ͻɲ�ѯ����ʼ========");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//DTO����
				if(req.getSession().getAttribute("ADSelectEntity")!=null){
					req.getSession().removeAttribute("ADSelectEntity");
				}
				if(req.getSession().getAttribute("ADSelectedEntity")!=null){
					req.getSession().removeAttribute("ADSelectedEntity");
				}
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM0312Form) req.getSession().getAttribute("IGASM0312Form");
				if ( form== null){
					form = new IGASM0312Form();
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
					form = (IGASM0312Form) req.getSession().getAttribute("IGASM0312Form");
					if (form !=null) {
						form.setFromCount(0);
//						req.getSession().removeAttribute("ADSelectEntity");
//						form.setPayEiid(null);
					}
				}
			}
			Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
			if(set != null && set.size() > 0) {
				form.setPayEiid(set.toArray(new String[0]));
			}else {
				form.setPayEiid(null);
			}
			
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0312");
			
			//DTO��������趨
			form.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_USE);//�����ʲ����״̬
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�豸�����߼�����
			dto = ctlBL.searchUsingEntityItemAction(dto);
			
			//���豸��Ϣ��������趨��VO��
			IGASM03121VO vo = new IGASM03121VO(dto.getEntityItemVWInfoList());
			
			super.<IGASM03121VO>setVO(req, vo);
			
			log.debug("========�豸�Ͻɲ�ѯ��������========");
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
