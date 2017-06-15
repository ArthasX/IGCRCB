/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.cim.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM12BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM12DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1202Form;
import com.deliverik.infogovernor.sym.vo.IGSYM12011VO;

/**
 * @Description: 数据信息树（CODEDETAIL相关信息组成的树）Action
 * @Author  
 * @History 2009-8-18     新建 
 * @History 2010-5-07     0000428: 增加机房属性管理
 * @Version V2.0
 */
public class IGCIM1201Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGCIM1201Action.class);
	
	/**
	 * <p>
	 * Description: 数据信息树（CODEDETAIL相关信息组成的树）Action
	 * </p>
	 * 
	 * @param mapping ActionMapping
	 * @param form ActionForm
	 * @param request HttpServletRequest
	 * @param response HttpServletResponse
	 * @return ActionForward
	 * @throws Exception
	 * @History 2010-5-07     0000428: 增加机房属性管理
	 */

	@SuppressWarnings("unchecked")
	@Override
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取BL接口实例
		IGCIM12BL ctlBL = (IGCIM12BL) getBean("igcim12BL");
		//实例化DTO
		IGCIM12DTO dto = new IGCIM12DTO();
	
		if("ENTITYTREE03".equals(mapping.getParameter())){
			IGCIM1202Form form = new IGCIM1202Form();
			if(request.getParameter("levelnode")!=null){
				if("999".equals(request.getParameter("levelnode"))){
					form.setEparcoding(request.getParameter("levelnode"));
				}
				form.setEsyscoding_tree(request.getParameter("levelnode"));

			}
			form.setEkey1(EntityItemKeyWords.ENTITY_EKEY1_0);//控制模型在资产树上显示和隐藏，使用entity表中预留字段EKEY1，0代表显示，1代表隐藏
			//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			dto.setIgcim1202form(form);
			String treetype = request.getParameter("treetype");
			String attribute_name="ENTITYTREE03_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM12011VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchEntityTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM12011VO>setVO(request, vo);
			}
		}
		
		return mapping.findForward("DISP");
	}
	
}
