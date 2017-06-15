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
import com.deliverik.infogovernor.asset.bl.IGASM08BL;
import com.deliverik.infogovernor.asset.dto.IGASM08DTO;
import com.deliverik.infogovernor.asset.form.IGASM0801Form;
import com.deliverik.infogovernor.asset.vo.IGASM08011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * 应用查询画面Action处理
 *
 */
public class IGASM0801Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0801Action.class);

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
		IGASM0801Form form = (IGASM0801Form)actionForm;
		
		//BL取得
		IGASM08BL ctlBL = (IGASM08BL) getBean("igasm08BL");
		
		//DTO生成
		IGASM08DTO dto = new IGASM08DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//应用查询画面初期显示处理
			log.debug("========应用查询画面初期显示处理开始========");
			
			//***************************************************************************
			//类型分类(应用)设定
			form = new IGASM0801Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION);
			req.setAttribute("IGASM0801Form", form);
			
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
				String roletype = req.getParameter("roletype")==null?"IGAC07":req.getParameter("roletype");
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
				sym03dto1.setSubtype("999003");
				String roletype1 = req.getParameter("roletype")==null?"IGAC07":req.getParameter("roletype");
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
			log.debug("========应用查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//应用查询画面再显示处理
			log.debug("========应用查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========应用查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM0801");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//应用查询处理
			log.debug("========应用查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM0801Form) req.getSession().getAttribute("IGASM0801Form");
				if ( form== null){
					form = new IGASM0801Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION);
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
					form = (IGASM0801Form) req.getSession().getAttribute("IGASM0801Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_APPLICATION);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0801");
			
			//DTO输入参数设定
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//应用检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			
			//将应用信息检索结果设定到VO中
			IGASM08011VO vo = new IGASM08011VO(dto.getEntityItemVWInfoList());
			
			super.<IGASM08011VO>setVO(req, vo);
			
			log.debug("========应用查询处理终了========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//应用删除处理
			log.debug("========应用删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//应用信息删除逻辑调用
			ctlBL.deleteEntityItemAction(dto);
			
			log.debug("========应用删除处理终了========");
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
