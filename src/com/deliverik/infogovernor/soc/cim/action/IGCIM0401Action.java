package com.deliverik.infogovernor.soc.cim.action;

import java.util.ArrayList;
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
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.soc.cim.bl.IGCIM04BL;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM04DTO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM0401Form;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1202Form;
import com.deliverik.infogovernor.soc.cim.vo.IGCIM04011VO;

/**
 * @Description: 类型查询画面Action处理
 * @Author  
 * @History 2009-8-18     新建
 * @History 2010-5-07     0000428: 增加机房属性管理
 * @Version V2.0
 */
public class IGCIM0401Action extends BaseAction {

	static Log log = LogFactory.getLog(IGCIM0401Action.class);

	/**
	 * 处理
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
		IGCIM0401Form form = (IGCIM0401Form)actionForm;
		
		//BL取得
		IGCIM04BL ctlBL = (IGCIM04BL) getBean("igcim04BL");
		
		//DTO生成
		IGCIM04DTO dto = new IGCIM04DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//类型查询画面初期显示处理
			log.debug("========类型查询画面初期显示处理开始========");
			IGCIM1202Form treeForm = new IGCIM1202Form();
			treeForm.setEparcoding("999");
			treeForm.setEsyscoding_tree("999");
//			treeForm.setEkey1(EntityItemKeyWords.ENTITY_EKEY1_0);//控制模型在资产树上显示和隐藏，使用entity表中预留字段EKEY1，0代表显示，1代表隐藏
			//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			dto.setIgcim1202Form(treeForm);
			String treetype = req.getParameter("treetype");
			String attribute_name="ENTITYTREE03_"+(treetype==null?"Default":treetype);

			Map<String,TreeNode> treeNodeMap = (Map<String,TreeNode>)req.getSession().getAttribute(attribute_name);
			treeNodeMap = null;
			if(treeNodeMap!=null){
				IGCIM04011VO vo = new IGCIM04011VO();
				vo.setTreeNodeMap(treeNodeMap);
				super.<IGCIM04011VO>setVO(req, vo);
			}else{
				dto = ctlBL.searchEntityTreeAction(dto);
				//setSessionAttribute(request, attribute_name, dto.getTreeNodeMap());
				
				IGCIM04011VO vo = new IGCIM04011VO();
				vo.setTreeNodeMap(dto.getTreeNodeMap());
				String eid = (String) req.getSession().getAttribute("eid");
				if(eid == null){
					eid = "CM01000000";
				}else{
					req.getSession().setAttribute("eid", null);
				}
				vo.setEidInSession(eid);
				super.<IGCIM04011VO>setVO(req, vo);
			}
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========类型查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//类型查询画面再显示处理
			log.debug("========类型查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========类型查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())){
			//类型查询处理
			log.debug("========类型查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGCIM0401");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM0401Form) req.getSession().getAttribute("IGCIM0401Form");
				if ( form == null ) {
					form = new IGCIM0401Form();
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
					form = (IGCIM0401Form) req.getSession().getAttribute("IGCIM0401Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGCIM0401");
			
			//DTO输入参数设定
			form.setEstatus(null);
			
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			
			dto.setEntitySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//类型信息检索逻辑调用
			dto = ctlBL.searchEntityAction(dto);
			
			req.setAttribute("stopbuttonMap", dto.getStopbuttonMap());
			req.setAttribute("startbuttonMap", dto.getStartbuttonMap());
			
			//将类型信息检索结果设定到VO中
			IGCIM04011VO vo = new IGCIM04011VO(dto.getEntityList());
//			CommonDefineUtils.SOC_ESYSCODING_NODE_LENGTH
			
			super.<IGCIM04011VO>setVO(req, vo);
			
			log.debug("========类型查询处理终了========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//类型删除处理
			log.debug("========类型删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntity(form.getDeleteEid());
			
			//类型信息删除逻辑调用
			ctlBL.deleteEntityAction(dto);
			
			log.debug("========类型删除处理终了========");
		}
		//修改模型状态1启用 2停用
		if ("CHANGE_STATUS".equals(mapping.getParameter())){

			log.debug("========资产模型状态变化处理开始========");
			if(req.getParameter("eid")!=null){
				form.setEid(req.getParameter("eid"));
			}
			if(req.getParameter("estatus")!=null){
				form.setEstatus(req.getParameter("estatus"));
			}
			dto.setEstatus(form.getEstatus());
			dto.setIgcim0401Form(form);
			ctlBL.changeEntityStatus(dto);
			
			log.debug("========资产模型状态变化处理终了========");
			return mapping.findForward("BACK");
		
		}
		if( "EXCCELDISP".equals(mapping.getParameter())){
			//查询处理
			log.debug("========一级模型查询处理开始========");
			//分页用DTO取得
			getPaginDTO(req,"IGASM0112");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGCIM0401Form) req.getSession().getAttribute("IGCIM0401Form");
				if ( form == null ) {
					form = new IGCIM0401Form();
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
					form = (IGCIM0401Form) req.getSession().getAttribute("IGCIM0401Form");
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM0112");
			
			//DTO输入参数设定
			form.setEstatus("1");
			
			//form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
			
			//form.setEsyscoding_q("999");//查询上级模型为根结点的模型，即查询一级模型
			
			//form.setEsyscoding_nq("999009");//不查询服务记录及其下级模型
			
			List<String> delList_q = new ArrayList<String>();
			delList_q.add("999009");//不查询服务记录及其下级模型
			delList_q.add("999012");//不查询组件及其下级模型
			delList_q.add("999014");//不查询组件及其下级模型
			form.setDelList_q(delList_q);
			dto.setEntitySearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			
			//类型信息检索逻辑调用
			dto = ctlBL.searchEntityActionForExportExcelModel(dto);
			
			//将类型信息检索结果设定到VO中
			IGCIM04011VO vo = new IGCIM04011VO(dto.getEntityList());
			
			super.<IGCIM04011VO>setVO(req, vo);
			
			log.debug("========一级模型查询处理终了========");
		}
		if("EXPORTEXCEL".equals(mapping.getParameter())){
			
			dto = ctlBL.searchInfoForExportExcel(form.getEsyscoding());
			IGCIM04011VO vo = new IGCIM04011VO(dto.getEntityList());
			vo.setOrglist(dto.getOrglist());
			vo.setTopEntityList(dto.getTopEntityList());
			vo.setConfigurationMapList(dto.getConfigurationMapList());
			vo.setCcdList(dto.getCcdList());
			vo.setUserlist(dto.getUserlist());
			super.<IGCIM04011VO>setVO(req, vo);
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
