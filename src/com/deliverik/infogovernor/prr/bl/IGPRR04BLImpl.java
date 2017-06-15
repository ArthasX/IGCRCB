/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prr.bl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.infogovernor.prr.dto.IGPRR04DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0402Form;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 流程服务目录BL实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR04BLImpl extends BaseBLImpl implements IGPRR04BL {
	
	/** 日志对象取得 */
	private static Log log = LogFactory.getLog(IGPRR04BLImpl.class);
	
	/** 流程定义BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** 数据详细信息BL */
	protected CodeDetailDefBL codeDetailDefBL;
	
	/** 流程定义BL */
	protected IG380BL ig380BL;

	/**
	 * 流程定义BL设定
	 * @param workFlowDefinitionBL 流程定义BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * 数据详细信息BL设定
	 * @param codeDetailDefBL 数据详细信息BL
	 */
	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}
	
	/**
	 * 流程定义BL设定
	 * @param ig380BL 流程定义BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	/**
	 * 初始化服务目录显示页面
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR04DTO initServiceCatelogAction(IGPRR04DTO dto) throws BLException{
		log.debug("===========服务目录页面初始化操作开始=============");
		//查询所有流程
		IG380SearchCondImpl pdcond = new IG380SearchCondImpl();
		List<IG380Info> pdList = workFlowDefinitionBL.searchLastProcessDefinition(pdcond,0,0);
		//查询服务目录一级分类
		CodeDetailDefSearchCondImpl cdcond = new CodeDetailDefSearchCondImpl();
		cdcond.setCcid(IGPRR04BLType.SERVICE_CATALOG_FIRST_CLASSIFY_CCID);
		List<CodeDetailDef> first = codeDetailDefBL.searchCodeDetailDef(cdcond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//查询服务目录二级分类
		cdcond.setCcid(IGPRR04BLType.SERVICE_CATALOG_SECOND_CLASSIFY_CCID);
		List<CodeDetailDef> second = codeDetailDefBL.searchCodeDetailDef(cdcond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//处理流程定义信息
		Map<String, List<IG380Info>> pdMap = new LinkedHashMap<String, List<IG380Info>>();
		for(IG380Info pd:pdList){
			if(pdMap.get(pd.getPdservicecatalog()) == null){
				List<IG380Info> temp = new ArrayList<IG380Info>();
				temp.add(pd);
				pdMap.put(pd.getPdservicecatalog(), temp);
			}else{
				pdMap.get(pd.getPdservicecatalog()).add(pd);
			}
		}
		//处理二级分类
		Map<String, List<CodeDetailDef>> secondMap = new LinkedHashMap<String, List<CodeDetailDef>>();
		for(CodeDetailDef cd:second){
			if(secondMap.get(cd.getPcid()) == null){
				List<CodeDetailDef> temp = new ArrayList<CodeDetailDef>();
				temp.add(cd);
				secondMap.put(cd.getPcid(), temp);
			}else{
				secondMap.get(cd.getPcid()).add(cd);
			}
		}
		//处理分类
		Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> serviceCatalogMap = new LinkedHashMap<String, List<Map<CodeDetailDef,List<IG380Info>>>>();
		for(CodeDetailDef cd:first){
			List<Map<CodeDetailDef, List<IG380Info>>> list = new ArrayList<Map<CodeDetailDef,List<IG380Info>>>();
			List<CodeDetailDef> secondList = secondMap.get(cd.getCid());
			if(secondList != null){
				for(CodeDetailDef two:secondList){
					Map<CodeDetailDef, List<IG380Info>> temp = new LinkedHashMap<CodeDetailDef, List<IG380Info>>();
					temp.put(two, pdMap.get(two.getSyscoding()));
					list.add(temp);
				}
			}
			serviceCatalogMap.put(cd.getSyscoding(), list);
		}
		dto.setServiceCatalogMap(serviceCatalogMap);
		dto.setServiceCatalogFirstClassify(first);
		log.debug("===========服务目录页面初始化操作结束=============");
		return dto;
	}
	
	/**
	 * 一级菜单下的服务目录查询操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR04DTO searchFirstActionServiceCatalog(IGPRR04DTO dto) throws BLException{
		log.debug("============一级菜单下的服务目录查询操作开始============");
		//dto参数取得
		IGPRR0402Form form = dto.getIgprr0402Form();
		//查询所有流程
		IG380SearchCondImpl pdcond = new IG380SearchCondImpl();
		List<IG380Info> pdList = workFlowDefinitionBL.searchLastProcessDefinition(pdcond,0,0);
		//处理流程定义信息
		Map<String, List<IG380Info>> pdMap = new LinkedHashMap<String, List<IG380Info>>();
		for(IG380Info pd:pdList){
			if(pdMap.get(pd.getPdservicecatalog()) == null){
				List<IG380Info> temp = new ArrayList<IG380Info>();
				temp.add(pd);
				pdMap.put(pd.getPdservicecatalog(), temp);
			}else{
				pdMap.get(pd.getPdservicecatalog()).add(pd);
			}
		}
		//查询服务目录一级分类
		CodeDetailDefSearchCondImpl cdcond = new CodeDetailDefSearchCondImpl();
		cdcond.setCcid(IGPRR04BLType.SERVICE_CATALOG_FIRST_CLASSIFY_CCID);
		cdcond.setSyscoding(form.getSyscoding());
		if(StringUtils.isEmpty(form.getSyscoding())){
			cdcond.setSyscoding("###");
		}
		List<CodeDetailDef> first = codeDetailDefBL.searchCodeDetailDef(cdcond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//查询服务目录二级分类
		cdcond.setCcid(IGPRR04BLType.SERVICE_CATALOG_SECOND_CLASSIFY_CCID);
		cdcond.setSyscoding(null);
		cdcond.setSyscoding_q(form.getSyscoding());
		List<CodeDetailDef> second = codeDetailDefBL.searchCodeDetailDef(cdcond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//处理二级分类
		Map<String, List<CodeDetailDef>> secondMap = new LinkedHashMap<String, List<CodeDetailDef>>();
		for(CodeDetailDef cd:second){
			if(secondMap.get(cd.getPcid()) == null){
				List<CodeDetailDef> temp = new ArrayList<CodeDetailDef>();
				temp.add(cd);
				secondMap.put(cd.getPcid(), temp);
			}else{
				secondMap.get(cd.getPcid()).add(cd);
			}
		}
		//处理分类
		Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> serviceCatalogMap = new LinkedHashMap<String, List<Map<CodeDetailDef,List<IG380Info>>>>();
		for(CodeDetailDef cd:first){
			List<Map<CodeDetailDef, List<IG380Info>>> list = new ArrayList<Map<CodeDetailDef,List<IG380Info>>>();
			List<CodeDetailDef> secondList = secondMap.get(cd.getCid());
			if(secondList != null){
				for(CodeDetailDef two:secondList){
					Map<CodeDetailDef, List<IG380Info>> temp = new LinkedHashMap<CodeDetailDef, List<IG380Info>>();
					temp.put(two, pdMap.get(two.getSyscoding()));
					list.add(temp);
				}
			}
			serviceCatalogMap.put(cd.getSyscoding(), list);
		}
		dto.setServiceCatalogMap(serviceCatalogMap);
		//可发起流程查询
		dto.setPdList(ig380BL.findSelfDefinitionByUserId(dto.getUser().getUserid(),IGPRDCONSTANTS.PD_STATUS_ENABLE));
		log.debug("============一级菜单下的服务目录查询操作结束============");
		return dto;
	}
}
