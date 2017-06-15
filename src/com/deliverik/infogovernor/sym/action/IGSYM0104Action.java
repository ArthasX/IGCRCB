/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_机构管理_查询删除ACTION
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGSYM0104Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0101Action.class);
	
	/**
	 * <p>
	 * Description: 机构action处理
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
		
		// 登陆用户取得
	    User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//实例化FORM
		IGSYM0101Form form = (IGSYM0101Form)actionForm;
		//获取BL接口实例
		IGSYM01BL ctlBL = (IGSYM01BL) getBean("igsym01BL");
		//实例化DTO
		IGSYM01DTO dto = new IGSYM01DTO();
//		dto = ctlBL.searchOrganizationAll(dto);
//		List<Organization> list = dto.getOrganizationList();
//		List<LabelValueBean> organizationList = new ArrayList<LabelValueBean>();
//		organizationList.add(new LabelValueBean("请选择", ""));
//		for(Iterator<Organization> iter = list.iterator();iter.hasNext();){
//			Organization organization = iter.next();
//			organizationList.add(new LabelValueBean(organization.getOrgname(), organization.getOrgid().toString()));
//		}
//		request.setAttribute("organizationList", organizationList);
		
		//树形显示机构
		
		
		if( "DISP".equals(mapping.getParameter())){
			log.debug("========机构查询画面初期显示处理开始========");
			addMessage(request, new ActionMessage("IGCO10000.I003"));
			
			
			log.debug("========机构查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		}else if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){	//机构查询
			log.debug("========机构查询处理开始========");
			//获取分页Bean
			getPaginDTO(request,"IGSYM0101");

			PagingDTO pDto;
			
			pDto = (PagingDTO)request.getAttribute("PagingDTO");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
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
			//调用BL查询
			dto = ctlBL.searchOrganizationAction(dto);
			
			request.setAttribute("nameMap", dto.getCompletenameMap());
			request.setAttribute("buttonMap", dto.getButtonMap());
			request.setAttribute("startbuttonMap", dto.getStartbuttonMap());
			//构造VO
			IGSYM01011VO vo = new IGSYM01011VO(dto.getOrganizationCondList());
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			//vo.setCompletenameMap(dto.getCompletenameMap());
			super.<IGSYM01011VO>setVO(request, vo);
			log.debug("========机构查询处理终了========");
		}else if ("DELETE".equals(mapping.getParameter())){//删除
			log.debug("========机构删除处理开始========");
			dto.setDeleteOrgid(form.getDeleteOrgid());
			ctlBL.deleteOrganizationAction(dto);
			log.debug("========机构删除处理终了========");
		}else if ("CHANGE_STATUS".equals(mapping.getParameter())){
			log.debug("========机构状态变化处理开始========");
			dto.setChangeOrgid(Integer.valueOf(form.getOrgid()));
			ctlBL.changePTStatus(dto);
			addMessage(request, new ActionMessage("IGSYM0101.I001"));
			log.debug("========机构状态变化处理终了========");
		}else if("TREE".equals(mapping.getParameter())){
			dto = ctlBL.searchOrgTreeAction(dto,"ORG");
			//构造VO
			IGSYM01011VO vo = new IGSYM01011VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGSYM01011VO>setVO(request, vo);
		}else if("ROLETREE".equals(mapping.getParameter())){
			dto = ctlBL.searchOrgTreeAction(dto,"ROLE");
			//构造VO
			IGSYM01011VO vo = new IGSYM01011VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGSYM01011VO>setVO(request, vo);
		}else if("CONDTREE".equals(mapping.getParameter())){
			log.debug("========机构树按照指定机构显示处理开始========");
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
			log.debug("========机构树按照指定机构显示处理终了========");
		}else if("ENTITYITEMTREE".equals(mapping.getParameter())){
			dto = ctlBL.searchItemTreeAction(dto,"ROLE");
			IGSYM01011VO vo = new IGSYM01011VO();
			vo.setTreeNodeMap(dto.getTreeNodeMap());
			super.<IGSYM01011VO>setVO(request, vo);
		}else if( "ALLOCATE".equals(mapping.getParameter())){
			log.debug("========获取支行机构开始========");
			
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
			//cond.setOrgparid(DefineUtils.ZHIH_ORGNO);//设置上级机构
			cond.setNot_in_syscoding_area(not_in_syscoding_area);
			cond.setXbtype(DefineUtils.XB_TYPE_ZHIH);
			dto.setOrganizationSearchCond(cond);

			//调用BL查询
			ctlBL.searchITEMS0174Tree(dto);
			//构造VO
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
