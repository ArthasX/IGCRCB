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
import com.deliverik.infogovernor.asset.form.IGASM0308Form;
import com.deliverik.infogovernor.asset.vo.IGASM03081VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * 设备下发查询画面Action处理
 *
 */
public class IGASM0308Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM0308Action.class);

	/**
	 * 设备下发查询
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
		//FORM取得
		IGASM0308Form form = (IGASM0308Form)actionForm;
		
		//BL取得
		IGASM03BL ctlBL = (IGASM03BL) getBean("igasm03BL");
		

		IGASM03DTO dto = new IGASM03DTO();
		if( "DISP".equals(mapping.getParameter())){
			//设备查询画面初期显示处理
			log.debug("========设备查询画面初期显示处理开始========");
			//***************************************************************************
			//类型分类(设备)设定
			form = new IGASM0308Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_DEVICE);
			req.setAttribute("IGASM0308Form", form);
			
			//设置初始权限树
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
			
			//设置初始资产管理内容树
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
			getPaginDTO(req,"IGASM0308");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//设备下发查询处理，查询EntityItem表
			log.debug("========设备查询处理开始========");
			
			if ("SEARCH1".equals(mapping.getParameter())){
				//DTO生成
				if(req.getSession().getAttribute("ADSelectEntity")!=null){
					req.getSession().removeAttribute("ADSelectEntity");
				}
				if(req.getSession().getAttribute("ADSelectedEntity")!=null){
					req.getSession().removeAttribute("ADSelectedEntity");
				}
				
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM0308Form) req.getSession().getAttribute("IGASM0308Form");
				if ( form == null ) {
					form = new IGASM0308Form();
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
					form = (IGASM0308Form) req.getSession().getAttribute("IGASM0308Form");
					if (form !=null) {
						form.setFromCount(0);
//						req.getSession().removeAttribute("ADSelectEntity");
//						form.setIssueEiid(null);
					}
				}
			}
			Set<String> set = (Set<String>)req.getSession().getAttribute("ADSelectEntity");
			if(set != null && set.size() > 0) {
				form.setIssueEiid(set.toArray(new String[0]));
			}else {
				form.setIssueEiid(null);
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0308");
			
			//DTO输入参数设定
			form.setEistatus(CommonDefineUtils.ENTITYITEM_STARUS_NEW+"_"+CommonDefineUtils.ENTITYITEM_STARUS_RENEW);//设置资产项的状态
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//设备检索逻辑调用
			dto = ctlBL.searchNewAndReciveEntityItemAction(dto);
			
			//将设备信息检索结果设定到VO中
			IGASM03081VO vo = new IGASM03081VO(dto.getEntityItemVWInfoList());
			
			super.<IGASM03081VO>setVO(req, vo);
			
			log.debug("========设备查询处理终了========");
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
