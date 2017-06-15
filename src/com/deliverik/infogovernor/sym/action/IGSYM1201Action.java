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
import com.deliverik.infogovernor.sym.bl.IGSYM12BL;
import com.deliverik.infogovernor.sym.dto.IGSYM12DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1201Form;
import com.deliverik.infogovernor.sym.form.IGSYM1202Form;
import com.deliverik.infogovernor.sym.vo.IGSYM12011VO;

/**
 * @Description: 数据信息树（CODEDETAIL相关信息组成的树）Action
 * @Author  
 * @History 2009-8-18     新建 
 * @History 2010-5-07     0000428: 增加机房属性管理
 * @Version V2.0
 */
public class IGSYM1201Action extends BaseAction {
	
	static Log log = LogFactory.getLog(IGSYM1201Action.class);
	
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
		IGSYM12BL ctlBL = (IGSYM12BL) getBean("igsym12BL");
		//实例化DTO
		IGSYM12DTO dto = new IGSYM12DTO();
	
		if("CODETREE".equals(mapping.getParameter())){
			IGSYM1201Form form = new IGSYM1201Form();
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
			dto.setIgsym1201form(form);
			
			String treetype = request.getParameter("treetype");
			String attribute_name="CODETREE_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM12011VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchCodeTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM12011VO>setVO(request, vo);
			}
			
			
		}else if("PROJECTTREE".equals(mapping.getParameter())){
			IGSYM1201Form form = new IGSYM1201Form();
			form.setCcid(request.getParameter("ccid"));	
			dto.setIgsym1201form(form);
			
			String treetype = request.getParameter("treetype");
			String attribute_name="PROJECTTREE_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM12011VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchCodeTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM12011VO>setVO(request, vo);
			}
			
			
		}else if("ENTITYTREE".equals(mapping.getParameter())){
			IGSYM1202Form form = new IGSYM1202Form();
			if(request.getParameter("levelnode")!=null){
				if("999".equals(request.getParameter("levelnode"))){
					form.setEparcoding(request.getParameter("levelnode"));
				}else if("888".equals(request.getParameter("levelnode"))){
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
				}else if("0306".equals(request.getParameter("levelnode"))){
					List<String> selectList = new ArrayList<String>();
					selectList.add("999001");
					selectList.add("999002");
					selectList.add("999003");
					selectList.add("999004");
					selectList.add("999006");
					selectList.add("999007");
					selectList.add("999008");
					selectList.add("999010");
					selectList.add("999011");
					selectList.add("999013");
					form.setSelectList(selectList);
				}
				if(!"IGAC01".equals(request.getParameter("levelnode")) && !"IGAC04".equals(request.getParameter("levelnode")) && !"0306".equals(request.getParameter("levelnode"))){
					form.setEsyscoding_tree(request.getParameter("levelnode"));
				}
				
			}
//			if(request.getParameter("type")!=null){
				form.setType(request.getParameter("type"));//资产模型树中是否显示机房标识  0不显示
//			}
			if(request.getParameter("estatus")!=null){
				form.setEstatus(request.getParameter("estatus"));
			}
			if(StringUtils.isNotEmpty(request.getParameter("emodeltype_eq"))) {
				form.setEmodeltype_eq(request.getParameter("emodeltype_eq"));
			}
			dto.setIgsym1202form(form);
			String treetype = request.getParameter("treetype");
			String attribute_name="ENTITYTREE_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM12011VO>setVO(request, vo);
			}else{
//				dto = ctlBL.searchEntityTreeAction(dto);
				if("yes".equals(request.getParameter("socflag"))){//如果是从SOC配置模型模块进入，则查SOC0117表(by wangxing) 
					dto = ctlBL.searchSocEntityTreeAction(dto);
				}else if("yes".equals(request.getParameter("socVWflag"))){ 
					if(StringUtils.isNotEmpty(request.getParameter("esyscoding"))){
						form.setEsyscoding(request.getParameter("esyscoding"));
					}else{
						form.setEsyscoding("999");//根节点
					}
					dto.setIgsym1202form(form);
					dto = ctlBL.searchSocVWEntityTreeAction(dto);
				}else{
					dto = ctlBL.searchEntityTreeAction(dto);
				}
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM12011VO>setVO(request, vo);
			}
		}else if("ENTITYTREEBYLEVEL".equals(mapping.getParameter())){
			IGSYM1202Form form = new IGSYM1202Form();
			form.setType("0");
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
			dto.setIgsym1202form(form);
			String treetype = request.getParameter("treetype");
			String attribute_name="ENTITYTREEBYLEVEL_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM12011VO>setVO(request, vo);
			}else{
				if("yes".equals(request.getParameter("socflag"))){
					dto = ctlBL.searchSOCEntityTreeByLevelAction(dto);
				}else{
					dto = ctlBL.searchEntityTreeByLevelAction(dto);
				}
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM12011VO>setVO(request, vo);
			}
		}else if("ENTITYTREE03".equals(mapping.getParameter())){
			IGSYM1202Form form = new IGSYM1202Form();
			if(request.getParameter("levelnode")!=null){
				if("999".equals(request.getParameter("levelnode"))){
					form.setEparcoding(request.getParameter("levelnode"));
				}
				form.setEsyscoding_tree(request.getParameter("levelnode"));

			}
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			dto.setIgsym1202form(form);
			String treetype = request.getParameter("treetype");
			String attribute_name="ENTITYTREE03_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM12011VO>setVO(request, vo);
			}else{
				if("yes".equals(request.getParameter("socflag"))){//如果是从SOC配置模型模块进入，则查SOC0117表(by wangxing) 
					dto = ctlBL.searchSocEntityTreeAction(dto);
				}else{
					dto = ctlBL.searchEntityTreeAction(dto);
				}
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM12011VO>setVO(request, vo);
			}
			if("1".equals(request.getParameter("flag"))){
				return mapping.findForward("RESET");
			}
		}else if("EXCELENTITYTREE".equals(mapping.getParameter())){
			IGSYM1202Form form = new IGSYM1202Form();
			if(request.getParameter("levelnode")!=null){
				if("999".equals(request.getParameter("levelnode"))){
					form.setEparcoding(request.getParameter("levelnode"));
				}
				form.setEsyscoding_tree(request.getParameter("levelnode"));

			}
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			List<String> selectList = new ArrayList<String>();
			selectList.add("999001");
			selectList.add("999002");
			selectList.add("999003");
			selectList.add("999004");
			selectList.add("999005");
			selectList.add("999006");
			selectList.add("999010");
			selectList.add("999011");
			selectList.add("999013");
			form.setSelectList(selectList);
			dto.setIgsym1202form(form);
			String treetype = request.getParameter("treetype");
			String attribute_name="EXCELENTITYTREE_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM12011VO>setVO(request, vo);
			}else{
//				dto = ctlBL.searchEntityTreeAction(dto);
				if("yes".equals(request.getParameter("socflag"))){//如果是从SOC配置模型模块进入，则查SOC0117表(by wangxing) 
					dto = ctlBL.searchSocEntityTreeAction(dto);
				}else{
					dto = ctlBL.searchEntityTreeAction(dto);
				}
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM12011VO>setVO(request, vo);
			}
		}else if("SPECIALCODETREE".equals(mapping.getParameter())){
			IGSYM1201Form form = new IGSYM1201Form();
//			if(null!=request.getParameter("ccname")){
//				String name = new String(request.getParameter("ccname").getBytes("iso-8859-1"),"UTF-8");
//				form.setCcname(name);
//			}
			
			form.setClevel(request.getParameter("clevel"));
			form.setCcid(request.getParameter("ccid"));	
			form.setCid(request.getParameter("cid"));
			form.setPsyscoding(request.getParameter("syscode"));
			dto.setIgsym1201form(form);
			
			String treetype = request.getParameter("treetype");
			String attribute_name="CODETREE_"+(treetype==null?"Special":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM12011VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchSpecialCodeTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM12011VO>setVO(request, vo);
			}
			
			
		}else if("CODETREEBYSTATUS".equals(mapping.getParameter())){
			IGSYM1201Form form = new IGSYM1201Form();
//			if(null!=request.getParameter("ccname")){
//				String name = new String(request.getParameter("ccname").getBytes("iso-8859-1"),"UTF-8");
//				form.setCcname(name);
//			}
			
			form.setClevel(request.getParameter("clevel"));
			form.setCcid(request.getParameter("ccid"));	
			form.setCid(request.getParameter("cid"));
			form.setPsyscoding(request.getParameter("syscode"));
			dto.setIgsym1201form(form);
			
			String treetype = request.getParameter("treetype");
			String attribute_name="CODETREE_"+(treetype==null?"ByStatus":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM12011VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchSpecialCodeTreeByCdStatusAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM12011VO>setVO(request, vo);
			}
			
			
		}
		else if("SVCSTATUS".equals(mapping.getParameter())){
			IGSYM1201Form form = new IGSYM1201Form();
//			if(null!=request.getParameter("ccname")){
//				String name = new String(request.getParameter("ccname").getBytes("iso-8859-1"),"UTF-8");
//				form.setCcname(name);
//			}
			
			form.setClevel(request.getParameter("clevel"));
			form.setCcid(request.getParameter("ccid"));	
			form.setCid(request.getParameter("cid"));
			form.setPsyscoding(request.getParameter("syscode"));
			dto.setIgsym1201form(form);
			
			String treetype = request.getParameter("treetype");
			String attribute_name="CODETREE_"+(treetype==null?"ByStatus":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)request.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGSYM12011VO>setVO(request, vo);
			}else{
				dto = ctlBL.searchSpecialCodeTreeByPcidAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGSYM12011VO vo = new IGSYM12011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				super.<IGSYM12011VO>setVO(request, vo);
			}		
		}
		
		return mapping.findForward("DISP");
	}
	
}
