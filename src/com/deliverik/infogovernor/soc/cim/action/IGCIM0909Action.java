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
import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM01BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM01DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0101Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM01011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * 设备查询画面Action处理
 *
 */
public class IGCIM0909Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0909Action.class);

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
		IGCIM0101Form form = (IGCIM0101Form)actionForm;
		
		//BL取得
		IGCIM01BL ctlBL = (IGCIM01BL) getBean("igcim01BL");
		
		//DTO生成
		IGCIM01DTO dto = new IGCIM01DTO();
		dto.setLocale(this.getLocale(req));
		if( "DISP".equals(mapping.getParameter())){
			//设备查询画面初期显示处理
			log.debug("========设备查询画面初期显示处理开始========");
			
			//***************************************************************************
			//类型分类(设备)设定
			form = new IGCIM0101Form();
			//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
			req.setAttribute("IGCIM0101Form", form);
			
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
				String roletype = req.getParameter("roletype")==null?"IGCI01":req.getParameter("roletype");
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
				sym03dto1.setSubtype("999001");
				String roletype1 = req.getParameter("roletype")==null?"IGCI01":req.getParameter("roletype");
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
			log.debug("========设备查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//设备查询画面再显示处理
			log.debug("========设备查询画面再显示处理开始========");
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========设备查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM0301");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//设备查询处理
			log.debug("========设备查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM0101Form) req.getSession().getAttribute("IGCIM0101Form");
				if ( form== null){
					form = new IGCIM0101Form();
					//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
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
					form = (IGCIM0101Form) req.getSession().getAttribute("IGCIM0101Form");
					//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0101");
			
			//只查询顶级CI
//			if(form.getEsyscoding()!=null&&form.getEsyscoding().equals("999001")){
//				form.setTopCiFlag(true);
//			}else{
//				form.setTopCiFlag(false);
//			}
			//DTO输入参数设定
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//设备检索逻辑调用
			dto = ctlBL.searchSOC0118(dto);
			

			//将设备信息检索结果设定到VO中
			IGCIM01011VO vo = new IGCIM01011VO();
			vo.setSoc0118List(dto.getEntityItemList());
			vo.setDomainid(dto.getDomainid());
			vo.setDomainversion(dto.getDomainversion());
			vo.setShowRelationMap(dto.getShowRelationMap());
			vo.setCreatetime(dto.getCreatetime());
			
			super.<IGCIM01011VO>setVO(req, vo);
			
			log.debug("========设备查询处理终了========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//设备删除处理
			log.debug("========设备删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//设备信息删除逻辑调用
			ctlBL.deleteEntityItemAction(dto);
			
			log.debug("========设备删除处理终了========");
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
