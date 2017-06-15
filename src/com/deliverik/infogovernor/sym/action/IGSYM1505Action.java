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

import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.sym.bl.IGSYM16BL;
import com.deliverik.infogovernor.sym.dto.IGSYM16DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1502Form;
import com.deliverik.infogovernor.sym.form.IGSYM1506Form;
import com.deliverik.infogovernor.sym.vo.IGSYM15051VO;

/**
 * @Description: 数据信息树（CODEDETAILDEF相关信息组成的树）Action
 * @Author  
 * @History 2009-8-18     新建 
 * @History 2010-5-07     0000428: 增加机房属性管理
 * @Version V2.0
 */
public class IGSYM1505Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM1505Action.class);
	
	/**
	 * <p>
	 * Description: 数据信息树（CODEDETAILDEF相关信息组成的树）Action
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

	@SuppressWarnings({ "unchecked", "unused" })
	public ActionForward doProcess(ActionMapping mapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		//获取BL接口实例
		IGSYM16BL ctlBL = (IGSYM16BL) getBean("igsym16BL");
		//实例化DTO
		IGSYM16DTO dto = new IGSYM16DTO();
	
		if("CODETREE".equals(mapping.getParameter())){
			IGSYM1502Form form = new IGSYM1502Form();
			//没用到
//			if(null!=request.getParameter("ccname")){
////				?ccname=<%=URLEncoder.encode(cc_name,"UTF-8")%>
//				String name = new String(request.getParameter("ccname").getBytes("iso-8859-1"),"UTF-8");
//				form.setCcname(name);
//			}
			
			form.setClevel(request.getParameter("clevel"));
			form.setCcid(request.getParameter("ccid"));	
			form.setCid(request.getParameter("cid"));
			form.setPsyscoding(request.getParameter("syscode"));
			form.setRootSelect(request.getParameter("rootSelect"));
			String selectedLast = request.getParameter("selecedlast");
			dto.setIgsym1502form(form);
			
			String treetype = request.getParameter("treetype");
			String attribute_name="CODETREE_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM15051VO vo = new IGSYM15051VO();
				if(StringUtils.isNotEmpty(selectedLast)){
					vo.setSelectedLast(selectedLast);
				}
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM15051VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchCodeTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM15051VO vo = new IGSYM15051VO();
				if(StringUtils.isNotEmpty(selectedLast)){
					vo.setSelectedLast(selectedLast);
				}
				vo.setTreeSize(dto.getTreeSize());
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				vo.setTreeNodeNewMap(dto.getTreeNodeNewMap());
				super.<IGSYM15051VO>setVO(request, vo);
			}
			
			
		}else if("PRCODETREE".equals(mapping.getParameter())){
			IGSYM1502Form form = new IGSYM1502Form();
			//没用到
//			if(null!=request.getParameter("ccname")){
////				?ccname=<%=URLEncoder.encode(cc_name,"UTF-8")%>
//				String name = new String(request.getParameter("ccname").getBytes("iso-8859-1"),"UTF-8");
//				form.setCcname(name);
//			}
			
			form.setClevel(request.getParameter("clevel"));
			form.setCcid(request.getParameter("ccid"));	
			form.setCid(request.getParameter("cid"));
			form.setPsyscoding(request.getParameter("syscode"));
			dto.setIgsym1502form(form);
			
			String treetype = request.getParameter("treetype");
			String attribute_name="CODETREE_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM15051VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchCodeTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM15051VO>setVO(request, vo);
			}
			
			
		}else if("PROJECTTREE".equals(mapping.getParameter())){
			IGSYM1502Form form = new IGSYM1502Form();
			form.setCcid(request.getParameter("ccid"));	
			dto.setIgsym1502form(form);
			
			String treetype = request.getParameter("treetype");
			String attribute_name="PROJECTTREE_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM15051VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchCodeTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM15051VO>setVO(request, vo);
			}
			
			
		}else if("ENTITYTREE".equals(mapping.getParameter())){
			IGSYM1506Form form = new IGSYM1506Form();
			if(request.getParameter("levelnode")!=null){
				if("999".equals(request.getParameter("levelnode"))){
					form.setEparcoding(request.getParameter("levelnode"));
				}else if("IGAC01".equals(request.getParameter("levelnode"))){
					List<String> selectList = new ArrayList<String>();
					selectList.add("999001");
					selectList.add("999012");
					form.setSelectList(selectList);
				}else if("IGAC04".equals(request.getParameter("levelnode"))){
					List<String> selectList = new ArrayList<String>();
					selectList.add("999005");
					selectList.add("999009");
					form.setSelectList(selectList);
				}
				if(!"IGAC01".equals(request.getParameter("levelnode")) && !"IGAC04".equals(request.getParameter("levelnode"))){
					form.setEsyscoding_tree(request.getParameter("levelnode"));
				}
				
			}
//			if(request.getParameter("type")!=null){
				form.setType(request.getParameter("type"));//资产模型树中是否显示机房标识  0不显示
//			}
			dto.setIgsym1506form(form);
			String treetype = request.getParameter("treetype");
			String attribute_name="ENTITYTREE_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM15051VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchEntityTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM15051VO>setVO(request, vo);
			}
		}else if("ENTITYTREEBYLEVEL".equals(mapping.getParameter())){
			IGSYM1506Form form = new IGSYM1506Form();
			if(request.getParameter("levelnode")!=null){
				if("999".equals(request.getParameter("levelnode"))){
					form.setEparcoding(request.getParameter("levelnode"));
				}
				form.setEsyscoding_tree(request.getParameter("levelnode"));

			}
			if(request.getParameter("select")!=null){
				dto.setSelect_level(request.getParameter("select"));
			}
			if(request.getParameter("del")!=null){
				dto.setDel_level(request.getParameter("del"));
			}
			dto.setIgsym1506form(form);
			String treetype = request.getParameter("treetype");
			String attribute_name="ENTITYTREEBYLEVEL_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM15051VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchEntityTreeByLevelAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM15051VO>setVO(request, vo);
			}
		}else if("ENTITYTREE03".equals(mapping.getParameter())){
			IGSYM1506Form form = new IGSYM1506Form();
			if(request.getParameter("levelnode")!=null){
				if("999".equals(request.getParameter("levelnode"))){
					form.setEparcoding(request.getParameter("levelnode"));
				}
				form.setEsyscoding_tree(request.getParameter("levelnode"));

			}
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			dto.setIgsym1506form(form);
			String treetype = request.getParameter("treetype");
			String attribute_name="ENTITYTREE03_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM15051VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchEntityTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM15051VO>setVO(request, vo);
			}
		}else if("SPECIALCODETREE".equals(mapping.getParameter())){
			IGSYM1502Form form = new IGSYM1502Form();
//			if(null!=request.getParameter("ccname")){
//				String name = new String(request.getParameter("ccname").getBytes("iso-8859-1"),"UTF-8");
//				form.setCcname(name);
//			}
			
			form.setClevel(request.getParameter("clevel"));
			form.setCcid(request.getParameter("ccid"));	
			form.setCid(request.getParameter("cid"));
			form.setPsyscoding(request.getParameter("syscode"));
			dto.setIgsym1502form(form);
			
			String treetype = request.getParameter("treetype");
			String attribute_name="CODETREE_"+(treetype==null?"Special":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM15051VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchSpecialCodeTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM15051VO>setVO(request, vo);
			}
			
			
		}else if("CODETREEBYSTATUS".equals(mapping.getParameter())){
			IGSYM1502Form form = new IGSYM1502Form();
//			if(null!=request.getParameter("ccname")){
//				String name = new String(request.getParameter("ccname").getBytes("iso-8859-1"),"UTF-8");
//				form.setCcname(name);
//			}
			
			form.setClevel(request.getParameter("clevel"));
			form.setCcid(request.getParameter("ccid"));	
			form.setCid(request.getParameter("cid"));
			form.setPsyscoding(request.getParameter("syscode"));
			dto.setIgsym1502form(form);
			
			String treetype = request.getParameter("treetype");
			String attribute_name="CODETREE_"+(treetype==null?"ByStatus":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM15051VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchSpecialCodeTreeByCdStatusAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM15051VO vo = new IGSYM15051VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM15051VO>setVO(request, vo);
			}
			
			
		}
		
		return mapping.findForward("DISP");
	}
	
}
