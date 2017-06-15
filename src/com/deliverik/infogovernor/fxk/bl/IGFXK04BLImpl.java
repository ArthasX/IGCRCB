/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.fxk.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.infogovernor.fxk.dto.IGFXK04DTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0401Form;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 风险评估BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGFXK04BLImpl extends BaseBLImpl implements IGFXK04BL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGFXK04BLImpl.class);
	
	/** 资产模型BL */
	protected SOC0117BL soc0117BL;
	
	/** 资产实体BL */
	protected SOC0118BL soc0118BL;
	
	/** 数据详细信息BL */
	protected CodeDetailDefBL codeDetailDefBL;
	
	/** 流程处理BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;

	/**
	 * 资产模型BL设定
	 * @param soc0117BL 资产模型BL
	 */
	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	/**
	 * 资产实体BL设定
	 * @param soc0118BL 资产实体BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * 数据详细信息BL设定
	 * @param codeDetailDefBL 数据详细信息BL
	 */
	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}

	/**
	 * 流程处理BL设定
	 * @param workFlowOperationBL 流程处理BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 模型树查询
	 * @param dto
	 * @return
	 */
	public IGFXK04DTO searchAsmModelTree(IGFXK04DTO dto) throws BLException {
		log.debug("=============模型树查询操作开始==============");
		//资产一级模型
		String subtype = null;
		//dto参数取得
		if(dto.getForm() instanceof IGFXK0401Form){
			IGFXK0401Form form = (IGFXK0401Form) dto.getForm();
			subtype = form.getSubtype();
		}
		//模型数据
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		//实例化模型查询条件
		SOC0117SearchCondImpl soc0117cond=new SOC0117SearchCondImpl();
		soc0117cond.setSyscoding_q(subtype);
		soc0117cond.setEstatus("1");
		List<SOC0117Info> ret = soc0117BL.searchEntity(soc0117cond,0,0);
		TreeNode ptNode = new TreeNode();
		ptNode.setId(ret.get(0).getEid()+"_"+ret.get(0).getEsyscoding()+"_"+ret.get(0).getEcategory());
		ptNode.setName(ret.get(0).getEname());
		//添加孩子结点
		int nowlen = ret.get(0).getEsyscoding().length();
		getAssetChildTree(ret,ptNode,nowlen,subtype);
		treeNodeMap.put(ptNode.getId(),ptNode);
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("=============模型树查询操作结束==============");
		return dto;
	}
	
	/**
	 * 模型树查询ZTree
	 * @param dto
	 * @return
	 */
	public String searchAsmModelZTree(IGFXK04DTO dto) throws BLException {
		log.debug("=============模型树查询操作开始==============");
		//资产一级模型
		String subtype = null;
		//dto参数取得
		if(dto.getForm() instanceof IGFXK0401Form){
			IGFXK0401Form form = (IGFXK0401Form) dto.getForm();
			subtype = form.getSubtype();
		}
		//模型数据
		//实例化模型查询条件
		SOC0117SearchCondImpl soc0117cond=new SOC0117SearchCondImpl();
		soc0117cond.setSyscoding_q(subtype);
		soc0117cond.setEstatus("1");
		List<SOC0117Info> ret = soc0117BL.searchEntity(soc0117cond,0,0);
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>(); 
		for (SOC0117Info soc0117Info : ret) {
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("id", soc0117Info.getEsyscoding());	// id属性  ，数据传递 
			if("999".equals(soc0117Info.getEparcoding())){
				hm.put("name", "风险类别"); 					// name属性，第一级固定显示"风险类别"
			}else{
				hm.put("name", soc0117Info.getEname()); 	// name属性，显示节点名称    
			}
            hm.put("pId", soc0117Info.getEparcoding());
            if(soc0117Info.getEparcoding().length()==6){
//            	hm.put("checked", "true");
                hm.put("open", "true"); 
            }
            list.add(hm);  
	}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		log.debug("=============模型树查询操作结束==============");
		return json;
	}
	
	/**
	 * <p>
	 * 查询子结点
	 * </p>
	 * @param 全部的结点LIST
	 * @param 该级结点的上级结点
	 * @param 该级结点的上级结点的syscoding的长度
	 * @author duchong@deliverik.com
	 */
	private void getAssetChildTree(List<SOC0117Info> ret,TreeNode ptNode,int ptlen,String syscoding){
		List<SOC0117Info> nextret = getAssetNextLevelNodesOne(ret,ptlen,syscoding);//取得该级结点的LIST
		for(int i=0,j=nextret.size();i<j;i++){
			String syscode = nextret.get(i).getEsyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextret.get(i).getEid()+"_"+nextret.get(i).getEsyscoding()+"_"+nextret.get(i).getEcategory());
			pdNode.setName(nextret.get(i).getEname());
			getAssetChildTree(ret,pdNode,syscode.length(),syscode);
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}
	}
	
	/**
	 * <p>
	 * 取下一level的结点集合
	 * </p>
	 * @param 全部的结点LIST
	 * @param 当前结点的len
	 * @param 当前结点的syscode
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	private List<SOC0117Info> getAssetNextLevelNodesOne(List<SOC0117Info> ret,int levellen,String syscode) {
		
		List<SOC0117Info> entitylist = new ArrayList<SOC0117Info>();
		for(int i=0,j=ret.size();i<j;i++){
			String syscoding = ret.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+3) && (syscoding.substring(0,syscoding.length()-3)).equals(syscode)){
				entitylist.add(ret.get(i));
			}
			
		}
		
		return entitylist;
	}
	
	/**
	 * 风险点查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK04DTO searchAsm013Action(IGFXK04DTO dto) throws BLException {
		log.debug("=============风险点查询操作开始============");
		String ajaxResult = "";
		List<List<Map<String, String>>> dataList = new ArrayList<List<Map<String,String>>>();
		if(dto.getForm() instanceof IGFXK0401Form){
			//dto参数取得
			IGFXK0401Form form = (IGFXK0401Form) dto.getForm();
			String[] esyscodings = form.getEsyscoding().split("_");
			for (String esyscoding : esyscodings) {
				if(StringUtils.isNotEmpty(esyscoding)){
					dto.setEsyscoding(esyscoding);
					//查询风险点信息
					dto = searchAsmAction(dto);
					List<SOC0124Info> list = dto.getEntityItemVWInfoList();
					if(list != null && list.size() > 0){
						List<Map<String, String>> tempList = new ArrayList<Map<String,String>>();
						for(SOC0124Info info:list){
							Map<String, String> map = new HashMap<String, String>();
							map.put("eiid", info.getEiid() + "");
							map.put("eiversion", info.getEiversion() + "");
							map.put("einame", info.getEiname());
							tempList.add(map);
						}
						dataList.add(tempList);
					}
				}
			}
		}
		Gson gson = new Gson();
		ajaxResult = gson.toJson(dataList);
		dto.setAjaxResult(ajaxResult);
		log.debug("=============风险点查询操作结束============");
		return dto;
	}
	
	/**
	 * 检查项查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK04DTO searchAsm014Action(IGFXK04DTO dto) throws BLException {
		log.debug("==============检查项查询操作开始=============");
		String ajaxResult = "";
		List<List<Map<String, String>>> dataList = new ArrayList<List<Map<String, String>>>();
		if (dto.getForm() instanceof IGFXK0401Form) {
			// dto参数取得
			IGFXK0401Form form = (IGFXK0401Form) dto.getForm();
			String[] esyscodings = form.getEsyscoding().split("_");
			for (String esyscoding : esyscodings) {
				if (StringUtils.isNotEmpty(esyscoding)) {
					// 查询关系数据
					CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
					cond.setCcid("293");
					cond.setSyscoding(esyscoding);
					List<CodeDetailDef> codeList = codeDetailDefBL
							.searchCodeDetailDef(cond);
					for (CodeDetailDef code : codeList) {
						if (esyscoding.equals(code.getSyscoding())) {
							dto.setEsyscoding(code.getPsyscoding());
							break;
						}
					}
					// 查询风险点信息
					dto = searchAsmAction(dto);
					List<SOC0124Info> list = dto.getEntityItemVWInfoList();
					if (list != null && list.size() > 0) {
						List<Map<String, String>> tempList = new ArrayList<Map<String, String>>();
						for (SOC0124Info info : list) {
							Map<String, String> map = new HashMap<String, String>();
							map.put("eiid", info.getEiid() + "");
							map.put("eiversion", info.getEiversion() + "");
							map.put("einame", info.getEiname());
							tempList.add(map);
						}
						dataList.add(tempList);
					}
				}

			}
		}
		Gson gson = new Gson();
		ajaxResult = gson.toJson(dataList);
		dto.setAjaxResult(ajaxResult);
		log.debug("==============检查项查询操作结束=============");
		return dto;
	}

	/**
	 * 资产信息查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGFXK04DTO searchAsmAction(IGFXK04DTO dto) throws BLException{
		log.debug("===============资产信息查询操作开始================");
		if(StringUtils.isNotEmpty(dto.getEsyscoding())){
			//实例化查询条件
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			cond.setEsyscoding(dto.getEsyscoding());
			List<SOC0124Info> entityItemVWInfoList = soc0118BL.searchEntityItemVW(cond, 0,0);
			dto.setEntityItemVWInfoList(entityItemVWInfoList);
		}
		log.debug("===============资产信息查询操作结束================");
		return dto;
	}
	
	/**
	 * 查询相关风险清单
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK04DTO getRelationProcess(IGFXK04DTO dto) throws BLException {
		log.debug("===============相关风险清单查询操作开始===============");
		if(dto.getForm() instanceof IGFXK0401Form){
			IGFXK0401Form form = (IGFXK0401Form) dto.getForm();
			Integer prid = form.getPrid();
			List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
			List<ProcessInfoEntityInfo> list = flowSearchBL.searchProcessEntityItem(prid, "相关风险事件");
			if(list != null){
				for(ProcessInfoEntityInfo info:list){
					SOC0118Info sj = soc0118BL.searchEntityItemByKey(info.getEiversion());
					Map<String, String> map = new HashMap<String, String>();
					map.put("eiid", info.getEiid() + "");
					map.put("eiversion", info.getEiversion() + "");
					map.put("einame", sj.getEiname());
					dataList.add(map);
				}
			}
			Gson gson = new Gson();
			dto.setAjaxResult(gson.toJson(dataList));
		}
		log.debug("===============相关风险清单查询操作开始===============");
		return dto;
	}
}
