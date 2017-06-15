package com.deliverik.infogovernor.risk.action;

import java.util.ArrayList;
import java.util.LinkedHashMap;
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
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.risk.bl.IGRIS06BL;
import com.deliverik.infogovernor.risk.dto.IGRIS06DTO;
import com.deliverik.infogovernor.risk.form.IGRIS0614Form;
import com.deliverik.infogovernor.risk.vo.IGRIS06022VO;
import com.deliverik.infogovernor.risk.vo.IGRIS06071VO;
import com.deliverik.infogovernor.sym.bl.IGSYM03BL;
import com.deliverik.infogovernor.sym.dto.IGSYM03DTO;

/**
 * 检查项查询画面Action处理
 *
 */
public class IGRIS0614Action extends BaseAction {

	static Log log = LogFactory.getLog(IGRIS0614Action.class);

	/**
	 * 检查项查询
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
		IGRIS0614Form igris0614form = (IGRIS0614Form) actionForm;
		
		//BL取得
		IGRIS06BL ctrlBL = (IGRIS06BL) getBean("igris06BL");
		
		//DTO生成
		IGRIS06DTO dto = new IGRIS06DTO();
		dto.setIgris0614form(igris0614form);
		//获取当前用户
		User user = (User)req.getSession().getAttribute(SESSION_KEY_LOGIN_USER);
		//获取查询资产类别BL接口实例
		IGSYM03BL ctl03BL = (IGSYM03BL) getBean("igsym03BL");
		//实例化类别dto
		IGSYM03DTO igsym03dto = new IGSYM03DTO();
		//获取当前用户
		igsym03dto.setSubtype("999021");
		//获取带类别树的dto
		igsym03dto = ctl03BL.getAssetDomainTree(igsym03dto, "IGBP19", user);
		//初始化类别列表
		List<IGRIS06022VO> labelAndValueList = new ArrayList<IGRIS06022VO>();
		labelAndValueList.add(new IGRIS06022VO());
		//获取类别 遍历
		Map<String, TreeNode> treeMap = igsym03dto.getTreeNodeMap();
		for(Map.Entry<String, TreeNode> entry : treeMap.entrySet()){
			TreeNode treeNode = entry.getValue();
			LinkedHashMap<String, TreeNode> linkHashMap = treeNode.getChildTreeNodeMap();
			for(Map.Entry<String, TreeNode> subEntry : linkHashMap.entrySet()){
				TreeNode subTreeNode = subEntry.getValue();
				labelAndValueList.add(new IGRIS06022VO(subTreeNode.getName(),subTreeNode.getId().split("_")[1]));
			}
		}
		//保存到request
		req.setAttribute("labelAndValueList", labelAndValueList);
		
		if ("DISP".equals(mapping.getParameter())){
			//风险点修改处理显示
			log.debug("========风险点查询初始化显示开始========");
			
			IGRIS06071VO vo=new IGRIS06071VO();
			super.<IGRIS06071VO>setVO(req, vo);
			//实例化vo
			log.debug("=======检查项资产查询处理结束========");
			
		}else if("SEARCH".equals(mapping.getParameter()) || "BACK".equals(mapping.getParameter())){
			
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0614");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			
			if ("BACK".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				igris0614form = (IGRIS0614Form) req.getSession().getAttribute("IGRIS0614Form");
				if ( igris0614form == null ) {
					igris0614form = new IGRIS0614Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(igris0614form.getFromCount());
					} else {
						igris0614form.setFromCount(pDto.getFromCount());
					}
				}
			}else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(0);
					igris0614form = (IGRIS0614Form) req.getSession().getAttribute("IGRIS0614Form");
					if (igris0614form !=null) {
						igris0614form.setFromCount(0);
					}
				 }
			}
			
			int maxCnt = getMaxDataCount("IGRIS0614");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//调用bl 进行数据处理
			ctrlBL.searchCheckItemListAction(dto);
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			dto.setIgris0614form(igris0614form);

			//TODO 获得检查项详细信息集合
			ctrlBL.serachCheckItemInfoListAction(dto);
			
			IGRIS06071VO vo=new IGRIS06071VO();
			vo.setIgris0614form(igris0614form);
			//检查项集合
			vo.setItemList(dto.getItemList());
			super.<IGRIS06071VO>setVO(req, vo);
		}else if("SEARCH1".equals(mapping.getParameter()) || "BACK1".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0614");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			if ("BACK1".equals(mapping.getParameter())){
				//由详细画面，编辑画面返回查询画面时的再检索处理
				igris0614form = (IGRIS0614Form) req.getSession().getAttribute("IGRIS0614Form");
				if ( igris0614form == null ) {
					igris0614form = new IGRIS0614Form();
				}else {
					if (req.getParameter("PAGING") == null) {
						pDto.setFromCount(igris0614form.getFromCount());
					} else {
						igris0614form.setFromCount(pDto.getFromCount());
					}
				}
			}
			int maxCnt = getMaxDataCount("IGRIS0614");
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			String eiidStr = igris0614form.getEiids();
			
			StringBuffer eiid_in = new StringBuffer();
			if(eiidStr!=null && !(eiidStr.equals("")) && !(eiidStr.equals("0"))){
				String[] eiids = eiidStr.split(",");
				for(int i = 0; i <eiids.length;i++){
					 eiid_in.append("'").append(eiids[i]).append("'");
					 if(i < eiids.length-1){
						 eiid_in.append(",");
					 }
				}
			}
			dto.getIgris0614form().setEiids(eiid_in.toString());	
			
			//调用bl 进行数据处理
			ctrlBL.searchCheckItemWindowAction(dto);
			
			dto.setIgris0614form(igris0614form);

			//获得检查项详细信息集合
			ctrlBL.serachCheckItemInfoListAction(dto);
			
			IGRIS06071VO vo=new IGRIS06071VO();
			String eiidSt = "";
			if(igris0614form.getEiids()!=null && !(igris0614form.getEiids().equals("0"))){
				eiidSt = igris0614form.getEiids().replaceAll("'", "");
				igris0614form.setEiids(eiidSt);
			}
			vo.setIgris0614form(igris0614form);
			//检查项集合
			vo.setItemList(dto.getItemList());
			super.<IGRIS06071VO>setVO(req, vo);
		}else if("SEARCH2".equals(mapping.getParameter())){
			//分页用DTO取得
			getPaginDTO(req,"IGRIS0614");
			PagingDTO pDto;
			pDto = (PagingDTO)req.getAttribute("PagingDTO");
			//由详细画面，编辑画面返回查询画面时的再检索处理
			igris0614form = (IGRIS0614Form) req.getSession().getAttribute("IGRIS0614Form");
			if ( igris0614form == null ) {
				igris0614form = new IGRIS0614Form();
			}else {
				if (req.getParameter("PAGING") == null) {
					pDto.setFromCount(igris0614form.getFromCount());
				} else {
					igris0614form.setFromCount(pDto.getFromCount());
				}
			}
			int maxCnt = getMaxDataCount("IGRIS0614");
			String eiidStr = igris0614form.getEiids();
			
			StringBuffer eiid_in = new StringBuffer();
			if(eiidStr!=null && !(eiidStr.equals("")) && !(eiidStr.equals("0"))){
				String[] eiids = eiidStr.split(",");
				for(int i = 0; i <eiids.length;i++){
					 eiid_in.append("'").append(eiids[i]).append("'");
					 if(i < eiids.length-1){
						 eiid_in.append(",");
					 }
				}
			}
			dto.getIgris0614form().setEiids(eiid_in.toString());
			
			dto.setMaxSearchCount(maxCnt);
			dto.setPagingDto(pDto);
			
			//调用bl 进行数据处理
			ctrlBL.searchCheckItemListNotPageAction(dto);
			
			//DTO输入参数设定
			dto.setMaxSearchCount(maxCnt);
			
			dto.setPagingDto(pDto);
			StringBuffer eiids = new StringBuffer();
			StringBuffer eiversions = new StringBuffer();
			if(igris0614form.getDeleteEiid()!=null && igris0614form.getDeleteEiid().length>0){
				for(int i=0;i<igris0614form.getDeleteEiid().length;i++){
					eiids.append(igris0614form.getDeleteEiid()[i]);
					if(i<igris0614form.getDeleteEiid().length-1){
						eiids.append(",");
					}
				}
			}
			igris0614form.setEiids(eiids.toString());
			
			dto.setIgris0614form(igris0614form);
			
			//获得检查项详细信息集合
			ctrlBL.serachCheckItemInfoListAction(dto);
			
			IGRIS06071VO vo=new IGRIS06071VO();
			String eiidSt = "";
			if(igris0614form.getEiids()!=null && !(igris0614form.getEiids().equals("0"))){
				eiidSt = igris0614form.getEiids().replaceAll("'", "");
				igris0614form.setEiids(eiidSt);
			}
			vo.setIgris0614form(igris0614form);
			//检查项集合
			vo.setItemList(dto.getItemList());
			super.<IGRIS06071VO>setVO(req, vo);
		}else if ("DELETE".equals(mapping.getParameter())){
			//检查项删除处理
			log.debug("========检查项删除处理开始========");
			
			//DTO输入参数设定
			dto.setDeleteEntityItem(igris0614form.getDeleteEiid());
			
			//检查项信息删除逻辑调用
			ctrlBL.deleteEntityItemAction(dto);
			
			log.debug("========检查项删除处理终了========");
		}else if("SELECT".equals(mapping.getParameter())){
			
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
