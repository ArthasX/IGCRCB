/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM03BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM03DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0308Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM03081VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * ����: �豸����Action����
 * ��������: �豸����Action����
 * ������¼: 2011/05/19
 * �޸ļ�¼: 
 */
public class IGCIM0308Action extends BaseAction{
	static Log log = LogFactory.getLog(IGCIM0308Action.class);


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
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORMȡ��
		IGCIM0308Form form = (IGCIM0308Form)actionForm;
		
		//BLȡ��
		IGCIM03BL ctlBL = (IGCIM03BL) getBean("igcim03BL");
		
		//DTO����
		IGCIM03DTO dto = new IGCIM03DTO();
		dto.setLocale(this.getLocale(req));
		
		if( "DISP".equals(mapping.getParameter())){
			//�豸��ѯ���������ʾ����
			log.debug("========�豸��ѯ���������ʾ����ʼ========");
			
			
			//***************************************************************************
			//���ͷ���(�豸)�趨
			form = new IGCIM0308Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
			req.setAttribute("IGCIM0308Form", form);
			
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
		}
		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//��ҳ��DTOȡ��
			getPaginDTO(req,"IGCIM0308");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//�豸��ѯ����
			log.debug("========�豸��ѯ����ʼ========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGCIM0308Form) req.getSession().getAttribute("IGCIM0308Form");
				if ( form== null){
					form = new IGCIM0308Form();
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
					form = (IGCIM0308Form) req.getSession().getAttribute("IGCIM0308Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//��ѯ��¼������ȡ��
			int maxCnt = getMaxDataCount("IGCIM0308");
			
			//DTO��������趨
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//�豸�����߼�����
			dto = ctlBL.searchEntityItemAction(dto);
			
			//���豸��Ϣ��������趨��VO��
			IGCIM03081VO vo = new IGCIM03081VO();
			vo.setSoc0124List(dto.getEntityItemVWInfoList());
			super.<IGCIM03081VO>setVO(req, vo);
			
			log.debug("========�豸��ѯ��������========");
		}
		if( "INCIDENCE".equals(mapping.getParameter())){
			//�豸Ӱ�췶Χ���������ʾ����
			log.debug("========�豸Ӱ�췶Χ���������ʾ����ʼ========");
			
			dto.setIgcim0308Form(form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			
			dto.setUser(user);
			
			dto=ctlBL.initIGCIM0308Action(dto);
			
			//���豸��Ϣ��������趨��VO��
			IGCIM03081VO vo = new IGCIM03081VO();
			
			vo.setEntityItemVWInfoMap(dto.getEntityItemVWInfoMap());
			
			super.<IGCIM03081VO>setVO(req, vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========�豸Ӱ�췶Χ���������ʾ��������========");
			return mapping.findForward("DISP");
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
