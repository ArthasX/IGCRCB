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
import com.deliverik.infogovernor.asset.bl.IGASM27BL;
import com.deliverik.infogovernor.asset.dto.IGASM27DTO;
import com.deliverik.infogovernor.asset.form.IGASM2701Form;
import com.deliverik.infogovernor.asset.vo.IGASM27011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * 风险点查询画面Action处理
 *
 */
public class IGASM2701Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM2701Action.class);

	/**
	 * 事件处理
	 *
	 * @param mapping 
	 * @param actionForm 
	 * @param req 
	 * @param res 
	 * @return 
	 * @throws Exception 
	 */
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm, HttpServletRequest req, HttpServletResponse res) throws Exception {
		//FORM取得
		IGASM2701Form form = (IGASM2701Form)actionForm;
		
		//BL取得
		IGASM27BL ctlBL = (IGASM27BL) getBean("igasm27BL");
		
		//DTO生成
		IGASM27DTO dto = new IGASM27DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//风险点查询画面初期显示处理
			log.debug("========风险点查询画面初期显示处理开始========");
			
			//***************************************************************************
			//类型分类(风险点)设定
			form = new IGASM2701Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_RISK);
			req.setAttribute("IGASM2701Form", form);
			
			User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
			dto.setUser(user);
			dto = ctlBL.checkEntityItemDomain(dto);
			
			if(EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE))) {
				req.getSession().setAttribute("ADmode", EntityCategory.ENTITYITEM_PERMISSION_MODE_A);
			} else {
				req.getSession().setAttribute("ADmode", EntityCategory.ENTITYITEM_PERMISSION_MODE_B);
			}
			//如果在模式A下是负责人，则权限最大
			if(dto.getFlag() && EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE))) {
				req.setAttribute("deforgsys", dto.getOrgsyscoding());
				req.setAttribute("deforgname", dto.getOrgname());
				req.setAttribute("defassetsys", "_" + dto.getEsyscoding());
				req.setAttribute("defassetname", dto.getEname());
				req.getSession().setAttribute("ADrolemanager", "true");
				
			}else {
				//设置初始权限树
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
				
				
				//设置初始资产管理内容树
				IGSYM03DTO sym03dto1 = new IGSYM03DTO();
				IGSYM03BL treeBL1 = (IGSYM03BL) getBean("igsym03BL");
				sym03dto1.setSubtype("999017");
				String roletype1 = req.getParameter("roletype")==null?"IGAC13":req.getParameter("roletype");
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
			log.debug("========风险点查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//风险点查询画面再显示处理
			log.debug("========风险点查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========风险点查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM2701");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//风险点查询处理
			log.debug("========风险点查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM2701Form) req.getSession().getAttribute("IGASM2701Form");
				if ( form== null){
					form = new IGASM2701Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_RISK);
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
					form = (IGASM2701Form) req.getSession().getAttribute("IGASM2701Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_RISK);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM2701");
			
			//DTO输入参数设定
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//风险点检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			
			//将风险点信息检索结果设定到VO中
			IGASM27011VO vo = new IGASM27011VO(dto.getEntityItemVWInfoList());
			
			super.<IGASM27011VO>setVO(req, vo);
			
			log.debug("========风险点查询处理终了========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//风险点删除处理
			log.debug("========风险点删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//风险点信息删除逻辑调用
			ctlBL.deleteEntityItemAction(dto);
			
			log.debug("========风险点删除处理终了========");
		}
		
		//逻辑处理过程中的信息显示
		List<ActionMessage> messageList = dto.getMessageList();
		
		if( messageList != null && messageList.size() > 0 ) {
			for (ActionMessage message : messageList) {	
				addMessage(req, message);
			}
			
		}

		return mapping.findForward("DISP");
	}
}
