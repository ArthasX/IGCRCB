/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.ArrayList;
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

import com.csebank.items.util.DefineUtils;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.sym.bl.IGSYM01BL;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.form.IGSYM0101Form;
import com.deliverik.infogovernor.sym.vo.IGSYM01011VO;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ϵͳ����_��������_��ѯɾ��ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0104Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0101Action.class);
	
	/**
	 * <p>
	 * Description: ����action����
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author liupeng@deliverik.com
	 * @update
	 */

	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// ��½�û�ȡ��
	    User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//ʵ����FORM
		IGSYM0101Form form = (IGSYM0101Form)actionForm;
		//��ȡBL�ӿ�ʵ��
		IGSYM01BL ctlBL = (IGSYM01BL) getBean("igsym01BL");
		//ʵ����DTO
		IGSYM01DTO dto = new IGSYM01DTO();
//		dto = ctlBL.searchOrganizationAll(dto);
//		List<Organization> list = dto.getOrganizationList();
//		List<LabelValueBean> organizationList = new ArrayList<LabelValueBean>();
//		organizationList.add(new LabelValueBean("��ѡ��", ""));
//		for(Iterator<Organization> iter = list.iterator();iter.hasNext();){
//			Organization organization = iter.next();
//			organizationList.add(new LabelValueBean(organization.getOrgname(), organization.getOrgid().toString()));
//		}
//		request.setAttribute("organizationList", organizationList);
		
		//������ʾ����
		
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========������ѯ���������ʾ����ʼ========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			
			
			log.debug("========������ѯ���������ʾ��������========");
			return mapping.findForward("DISP");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){	//������ѯ
			log.debug("========������ѯ����ʼ========");
			//��ȡ��ҳBean
			getPaginDTO(request,"IGSYM0101");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//����ϸ���棬�༭���淵�ز�ѯ����ʱ���ټ�������
				form = (IGSYM0101Form) request.getSession().getAttribute("IGSYM0101Form");
				if ( form== null){
					form = new IGSYM0101Form();
				}else {
					if (request.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else {
				if (request.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGSYM0101Form) request.getSession().getAttribute("IGSYM0101Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			int maxCnt = getMaxDataCount("IGSYM0101");
			
			form.setOrgsuper(9);
			form.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
			dto.setIgsym0101Form(form);
			
			dto.setOrganizationSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			//����BL��ѯ
			dto = ctlBL.searchOrganizationAction(dto);
			
			request.setAttribute("nameMap", dto.getCompletenameMap());
			request.setAttribute("buttonMap", dto.getButtonMap());
			request.setAttribute("startbuttonMap", dto.getStartbuttonMap());
			//����VO
			IGSYM01011VO vo = new IGSYM01011VO(dto.getOrganizationCondList());
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			//vo.setCompletenameMap(dto.getCompletenameMap());
			super.<IGSYM01011VO>setVO(request, vo);
			log.debug("========������ѯ��������========");
		}else if ("DELETE".equals(mapping.getParameter())){//ɾ��
			log.debug("========����ɾ������ʼ========");
			dto.setDeleteOrgid(form.getDeleteOrgid());
			ctlBL.deleteOrganizationAction(dto);
			log.debug("========����ɾ����������========");
		}else if ("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========����״̬�仯����ʼ========");
			dto.setChangeOrgid(Integer.valueOf(form.getOrgid()));
			ctlBL.changePTStatus(dto);
			addMessage(request, new ActionMessage("IGSYM0101.I001"));
			log.debug("========����״̬�仯��������========");
		}else if("TREE".equals(mapping.getParameter())){
			dto = ctlBL.searchOrgTreeAction(dto,"ORG");
			//����VO
			IGSYM01011VO vo = new IGSYM01011VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGSYM01011VO>setVO(request, vo);
		}else if("ROLETREE".equals(mapping.getParameter())){
			dto = ctlBL.searchOrgTreeAction(dto,"ROLE");
			//����VO
			IGSYM01011VO vo = new IGSYM01011VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGSYM01011VO>setVO(request, vo);
		}else if("CONDTREE".equals(mapping.getParameter())){
			log.debug("========����������ָ��������ʾ����ʼ========");
			String orgid = "";
			if(StringUtils.isNotEmpty(request.getParameter("orgid"))){
				orgid = request.getParameter("orgid");
			}else{
				orgid = user.getOrgid();
			}
			Map<String, TreeNode> tnMap= ctlBL.getOrgsyscodingTree(orgid);
			IGSYM01011VO vo = new IGSYM01011VO();
			vo.setTreeNodeMap(tnMap);
			super.<IGSYM01011VO>setVO(request, vo);
			log.debug("========����������ָ��������ʾ��������========");
		}else if("ENTITYITEMTREE".equals(mapping.getParameter())){
			dto = ctlBL.searchItemTreeAction(dto,"ROLE");
			IGSYM01011VO vo = new IGSYM01011VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGSYM01011VO>setVO(request, vo);
		}else if( "ALLOCATE".equals(mapping.getParameter())){
			log.debug("========��ȡ֧�л�����ʼ========");
			
			ArrayList<String> not_in_syscoding_area = new ArrayList<String>();
			String orgTemp = DefineUtils.NOT_SHOW_LIST;
			if(orgTemp!=null){
				String[] temp = orgTemp.split(",");
				
				if(temp!=null && temp.length>0){
					for(int i=0;i<temp.length-1;  i++){			
							not_in_syscoding_area.add(temp[i]);
					}
				}
			}
			OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
			//cond.setOrgparid(DefineUtils.ZHIH_ORGNO);//�����ϼ�����
			cond.setNot_in_syscoding_area(not_in_syscoding_area);
			cond.setXbtype(DefineUtils.XB_TYPE_ZHIH);
			dto.setOrganizationSearchCond(cond);

			//����BL��ѯ
			ctlBL.searchITEMS0174Tree(dto);
			//����VO
			IGSYM01011VO vo = new IGSYM01011VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGSYM01011VO>setVO(request, vo);
		}
		
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(request, message);
			}
		}
		return mapping.findForward("DISP");
	}

}
