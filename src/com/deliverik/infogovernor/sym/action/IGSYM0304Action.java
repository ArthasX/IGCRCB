/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;
import com.deliverik.infogovernor.sym.vo.IGSYM03041VO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 角色管理域（资产相关控制）ACTION
 * </p>
 * 
 * @author duchong@deliverik.com
 * @version 1.0
 */

public class IGSYM0304Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM0304Action.class);
	
	/**
	 * <p>
	 * Description: 成功后跳转
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @author duchong@deliverik.com
	 * @update
	 */

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取BL接口实例
		IGSYM03BL ctlBL = (IGSYM03BL) getBean("igsym03BL");
		//实例化DTO
		IGSYM03DTO dto = new IGSYM03DTO();
		User user = (User)request.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		String isItDrivers = request.getParameter("isItDrivers");
		dto.setIsItDrivers(isItDrivers);
		String cimTye="";
		if("DOMAINTREE".equals(mapping.getParameter())){//角色的管理域树
			String roletype = request.getParameter("roletype");
			String attribute_name="DomainTree_"+roletype;
			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM03041VO vo = new IGSYM03041VO(treeNodeMap);
				super.<IGSYM03041VO>setVO(request, vo);
			}else{
				dto = ctlBL.getRoleDomainTree(dto, roletype, user);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM03041VO vo = new IGSYM03041VO(dto.getTreeNodeMap());
				super.<IGSYM03041VO>setVO(request, vo);
			}
			
			
		}else if("ASSETDOMAINTREE".equals(mapping.getParameter())){//角色的资产管理内容树
			String roletype = request.getParameter("roletype");//角色类型
			cimTye=roletype;
			String subtype = request.getParameter("subtype");//资产模型的一级结点esyscoding
			String selectedLast = request.getParameter("selecedlast");
			String isRoot = request.getParameter("isRoot");
			dto.setIsRoot(isRoot);
			dto.setSubtype(subtype);
			String attribute_name="AssetDomainTree_"+roletype;
			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM03041VO vo = new IGSYM03041VO(treeNodeMap);
				if(StringUtils.isNotEmpty(selectedLast)){
					vo.setSelectedLast(selectedLast);
				}
				super.<IGSYM03041VO>setVO(request, vo);
			}else{
				dto = ctlBL.getAssetDomainTree(dto, roletype, user);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM03041VO vo = new IGSYM03041VO(dto.getTreeNodeMap());
				if(StringUtils.isNotEmpty(selectedLast)){
					vo.setSelectedLast(selectedLast);
				}
				super.<IGSYM03041VO>setVO(request, vo);
			}
		}
		if("IGCI01".equalsIgnoreCase(cimTye)){
			return mapping.findForward("RESET");
		}else{
			return mapping.findForward("DISP");
		}
	}
	
}
