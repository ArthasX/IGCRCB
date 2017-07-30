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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.asset.bl.IGASM03BL;
import com.deliverik.infogovernor.asset.dto.IGASM03DTO;
import com.deliverik.infogovernor.asset.form.IGASM0320Form;
import com.deliverik.infogovernor.asset.vo.IGASM03011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * �豸��ѯ����Action����
 *
 */
public class IGASM0320Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0320Action.class);

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
		IGASM0320Form form = (IGASM0320Form)actionForm;
		
		//BLȡ��
		IGASM03BL ctlBL = (IGASM03BL) getBean("igasm03BL");
		
		//DTO����
		IGASM03DTO dto = new IGASM03DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//�豸��ѯ���������ʾ����
			log.debug("========�豸��ѯ���������ʾ������ʼ========");
			
			
			//***************************************************************************
			//���ͷ���(�豸)�趨
			form = new IGASM0320Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
			req.setAttribute("IGASM0320Form", form);
			
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
			
			//***************************************************************************
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�豸��ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//�豸��ѯ��������ʾ����
			log.debug("========�豸��ѯ��������ʾ������ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�豸��ѯ��������ʾ��������========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGASM0320");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//�豸��ѯ����
			log.debug("========�豸��ѯ������ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGASM0320Form) req.getSession().getAttribute("IGASM0320Form");
				if ( form== null){
					form = new IGASM0320Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
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
					form = (IGASM0320Form) req.getSession().getAttribute("IGASM0320Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGASM0320");
			
			//DTO��������趨
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�豸�����߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			
			//���豸��Ϣ��������趨��VO��
			IGASM03011VO vo = new IGASM03011VO(dto.getEntityItemVWInfoList());
			
			super.<IGASM03011VO>setVO(req, vo);
			
			log.debug("========�豸��ѯ��������========");
		}
		if ("ISSUEDISP".equals(mapping.getParameter())){
			//�豸�����·���������ʾ����
			log.debug("========�豸�����·���������ʾ������ʼ========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�豸�����·���������ʾ��������========");
			return mapping.findForward("DISP");
		}
		
		//�߼����������е���Ϣ��ʾ
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}