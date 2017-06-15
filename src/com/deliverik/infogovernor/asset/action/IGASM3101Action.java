/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.asset.action;

import java.util.Iterator;
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

import com.deliverik.framework.asset.EntityCategory;
import com.deliverik.framework.base.BaseAction;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.bl.IGASM3101ExcelBL;
import com.deliverik.infogovernor.asset.bl.IGASM31BL;
import com.deliverik.infogovernor.asset.dto.IGASM3101ExcelDTO;
import com.deliverik.infogovernor.asset.dto.IGASM31DTO;
import com.deliverik.infogovernor.asset.form.IGASM3101Form;
import com.deliverik.infogovernor.asset.vo.IGASM31011VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * 风险指标查询画面Action处理
 *
 */
public class IGASM3101Action extends BaseAction {

	static Log log = LogFactory.getLog(IGASM3101Action.class);

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
		IGASM3101Form form = (IGASM3101Form)actionForm;
		
		//BL取得
		IGASM31BL ctlBL = (IGASM31BL) getBean("igasm31BL");
		
		
		//DTO生成
		IGASM31DTO dto = new IGASM31DTO();
		
		if( "DISP".equals(mapping.getParameter())){
			//风险指标查询画面初期显示处理
			log.debug("========风险指标查询画面初期显示处理开始========");
			
			//***************************************************************************
			//类型分类(风险指标)设定
			form = new IGASM3101Form();
			form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_RISK_TARGET);
			req.setAttribute("IGASM3101Form", form);
			
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
				sym03dto1.setSubtype("999019");
				String roletype1 = req.getParameter("roletype")==null?"IGAC14":req.getParameter("roletype");
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
			
			//获取属性下拉列表值*
			ctlBL.searchRiskPropertyActioin(dto);
			
			//将风险指标信息检索结果设定到VO中
			IGASM31011VO vo = new IGASM31011VO(dto.getEntityItemVWInfoList());
			
			//风险指标--阀值下拉
			vo.setThresholdList(dto.getThresholdList());
			
			//风险指标--是否关键指标下拉
			vo.setKeyIndexList(dto.getKeyIndexList());
			
			super.<IGASM31011VO>setVO(req, vo);
			
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========风险指标查询画面初期显示处理终了========");
			return mapping.findForward("DISP");
		} else if("REDISP".equals(mapping.getParameter())){
			//风险指标查询画面再显示处理
			log.debug("========风险指标查询画面再显示处理开始========");
			addMessage(req, new ActionMessage("IGCO10000.I003"));
			log.debug("========风险指标查询画面再显示处理终了========");
			return mapping.findForward("DISP");
		}	

		if( "SEARCH".equals(mapping.getParameter())||"SEARCH1".equals(mapping.getParameter())||"SEARCHWINDOW".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGASM3101");
			
			PagingDTO pDto;
			
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//查询记录最大件数取得
			int maxCnt = getMaxDataCount("IGASM3101");
			//风险指标查询处理
			log.debug("========风险指标查询处理开始========");
			if ("SEARCH1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				form = (IGASM3101Form) req.getSession().getAttribute("IGASM3101Form");
				if ( form== null){
					form = new IGASM3101Form();
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_RISK_TARGET);
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(form.getFromCount());
					} else {
						form.setFromCount(pDto.getFromCount());
					}
				}
			} else if("SEARCHWINDOW".equals(mapping.getParameter())){
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGASM3101Form) req.getSession().getAttribute("IGASM3101Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_RISK_TARGET);
					if (form !=null) {
						form.setFromCount(0);
					}
					String eiids = req.getParameter("eiids");
					//如果eiid为空，直接进行查询。功能是将以查询过的监测指标列去掉
					if(StringUtils.isNotEmpty(eiids)){
						StringBuffer eiid_NotIn = new StringBuffer();
						if(StringUtils.isNotEmpty(eiids) && !("0".equals(eiids))){
							String[] eiidList = eiids.split(",");
							for(int i=0;i<eiidList.length;i++){
								eiid_NotIn.append("'");
								eiid_NotIn.append(eiidList[i]);
								eiid_NotIn.append("'");
								if(i<eiidList.length-1){
									eiid_NotIn.append(",");
								}
							}
						}
						form.setEiid_NotIn(eiid_NotIn.toString());
					}
					//不分页
					pDto.setFromCount(0);
					pDto.setPageDispCount(maxCnt);
				}
			}else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					form = (IGASM3101Form) req.getSession().getAttribute("IGASM3101Form");
					form.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_RISK_TARGET);
					if (form !=null) {
						form.setFromCount(0);
					}
				}
			}
			
			//DTO输入参数设定
			dto.setEntityItemVWSearchCond(form);
			
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setIGASM3101FORM(form);
			//获取属性下拉列表值*
			ctlBL.searchRiskPropertyActioin(dto);
			
			//风险指标检索逻辑调用
			dto = ctlBL.searchEntityItemAction(dto);
			
			//将风险指标信息检索结果设定到VO中
			IGASM31011VO vo = new IGASM31011VO(dto.getEntityItemVWInfoList());
			
			//风险指标--阀值下拉
			vo.setThresholdList(dto.getThresholdList());
			
			//风险指标--是否关键指标下拉
			vo.setKeyIndexList(dto.getKeyIndexList());
			//查询结果返回集合
			vo.setSearchRiskIndexSearchVWList(dto.getSearchRiskIndexSearchVWList());
			
			super.<IGASM31011VO>setVO(req, vo);
			
			log.debug("========风险指标查询处理终了========");
		}
		if ("DELETE".equals(mapping.getParameter())){
			//风险指标删除处理
			log.debug("========风险指标删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItem(form.getDeleteEiid());
			
			//风险指标信息删除逻辑调用
			ctlBL.deleteEntityItemAction(dto);
			
			log.debug("========风险指标删除处理终了========");
		}
		
		if("EXCEL".equals(mapping.getParameter())){
			log.debug("=====================风险指标查询导出开始=======================");

			dto.setIGASM3101FORM(form);
			
			// 取得Excel处理BL
			IGASM3101ExcelBL excelBL = (IGASM3101ExcelBL) getBean("igasm3101ExcelBL");
			
			/**初始化数据查询*/
			ctlBL.searchRiskPropertyActioin(dto);
			//调用bl 进行数据处理
			dto=excelBL.searchRiskPointManagerAction(dto);
			
			// 实例ExeclDTO
			IGASM3101ExcelDTO excelDTO = new IGASM3101ExcelDTO();
			excelDTO.setProcessList(dto.getSearchRiskIndexSearchVWList());
			// 填充模板编号
			excelDTO.setFileid("ASM3101");
			excelDTO.setResponse(res);
			excelBL.initExcel(excelDTO);
			
			log.debug("=====================风险指标查询导出结束=======================");
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
