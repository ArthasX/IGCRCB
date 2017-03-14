/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.utility.CodeListUtils;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.bl.task.IG105BL;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG105Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG105SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.entity.IG105TB;
import com.deliverik.infogovernor.svc.bl.IGPROCESSType;
import com.deliverik.infogovernor.sym.dto.IGSYM17DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1701Form;
import com.deliverik.infogovernor.sym.form.IGSYM1702Form;
import com.deliverik.infogovernor.util.CodeDefine;

/**
 * 概述: 流程策略设定业务逻辑实现
 * 功能描述：流程策略设定业务逻辑实现
 * 创建记录：刘鹏    2010/11/26
 * 修改记录：
 */
public class IGSYM17BLImpl extends BaseBLImpl implements IGSYM17BL {

	static Log log = LogFactory.getLog(IGSYM17BLImpl.class);
	
	/** 分隔符 */
	protected final static String split = "#";
	
	/** 流程定义信息BL */
	protected IG380BL ig380BL;
	
	/** 流程状态信息BL */
	protected IG333BL ig333BL;
	
	/** 流程模板信息BL */
	protected IG259BL ig259BL;
	
	/** 流程策略信息BL */
	protected IG105BL ig105BL;
	
	/** 基础数据信息BL */
	protected CodeListUtils codeListUtils;
	
	/**
	 * 基础数据信息BL设定
	 * 
	 * @param codeListUtils基础数据信息BL
	 */
	public void setCodeListUtils(CodeListUtils codeListUtils) {
		this.codeListUtils = codeListUtils;
	}
	
	/**
	 * 流程定义信息BL设定
	 * 
	 * @param ig380BL流程定义信息BL
	 */
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}
	
	/**
	 * 流程状态信息BL设定
	 * 
	 * @param ig333BL流程状态信息BL
	 */
	public void setIg333BL(IG333BL ig333BL) {
		this.ig333BL = ig333BL;
	}
	
	/**
	 * 流程模板信息BL设定
	 * @param processTemplateBL流程模板信息BL
	 */
	public void setIg259BL(IG259BL ig259BL) {
		this.ig259BL = ig259BL;
	}
	
	/**
	 * 流程策略信息BL设定
	 * @param processStrategyDefBL流程策略信息BL
	 */
	public void setIg105BL(IG105BL ig105BL) {
		this.ig105BL = ig105BL;
	}
	
	/**
	 * 功能：流程定义信息查询处理
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO searchProcessDefinitionAction(IGSYM17DTO dto) throws BLException {
		
		log.debug("========流程定义信息查询处理开始========");
		
		IGSYM1701Form form = dto.getIgSYM1701Form();
		
		//定义查询条件
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		
		String[] pttype_str = form.getPttype().split("_");
		
		Integer[] pttype_int = new Integer[pttype_str.length];
		
		//字符数组转换成整型数组
		for(int i = 0; i < pttype_str.length; i++) {
			pttype_int[i] = new Integer(pttype_str[i]);
		}
		//流程模板ID数组
		cond.setPrTypeArray(pttype_int);
		
		String[] ptstatuses = new String[2];
		ptstatuses[0] = "a";//启用
		ptstatuses[1] = "t";//测试
		cond.setPdstatuses(ptstatuses);
		
		//流程定义信息查询件数取得 
		int totalCount = this.ig380BL.getIG380InfoSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========流程定义信息查询数据不存在========");
			//流程定义信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========流程定义信息查询数据件数过多========");
			//流程定义信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		//当前页流程定义信息取得
		List<IG380Info> processDefinitionList = this.ig380BL.searchIG380Info(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setProcessDefinitionList(processDefinitionList);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========流程定义信息查询处理终了========");
		
		return dto;
	}
	
	/**
	 * 功能：流程策略设定查询处理
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO initIGSYM1702Action(IGSYM17DTO dto) throws BLException {
		
		log.debug("========流程策略设定查询处理开始========");
		
		IGSYM1702Form form = dto.getIgSYM1702Form();
		
		//获取流程类型信息
		dto.setProcessDefinition(this.ig380BL.searchIG380InfoByKey(form.getPdid()));
		
		//定义流程策略Map
		Map<String, String> strategyMap = new LinkedHashMap<String, String>();
		
		dto = this.searchPrstatusList(dto);
		
		dto.setMaxPsdversion(this.ig105BL.getMaxgPsdversion(form.getPdid()));//当前策略最大版本号
		
		List<IG105Info> processStrategyDefList = null;
		
		//判断策略是否存在版本
		if(dto.getMaxPsdversion() != null && dto.getMaxPsdversion() > 0) {
			//查询指定流程定义ID当前策略集合
			IG105SearchCondImpl processStrategyDefCond = new IG105SearchCondImpl();
			
			processStrategyDefCond.setPdid(form.getPdid());//流程定义ID
			
			//设定当前所选择的策略版本号
			if(form.getPsdversion() != null && form.getPsdversion() > 0) {
				processStrategyDefCond.setPsdversion(form.getPsdversion());//点击历史版本号
			} else {
				processStrategyDefCond.setPsdversion(dto.getMaxPsdversion());//点击类型列表，查询最大版本
				form.setPsdversion(dto.getMaxPsdversion());
			}
			
			processStrategyDefList  = this.ig105BL.searchIG105Info(processStrategyDefCond, 0, 0);
			
		} else {
			processStrategyDefList = new ArrayList<IG105Info>();
		}
		
		//判断流程状态是否是新增加的状态
		boolean flag = true;
		
		//填充流程策略Map，已当前流程状态为基准
		for(LabelValueBean bean : dto.getPrstatusList()) {//流程状态集合
			
			for(IG105Info processStrategyDef : processStrategyDefList) {//当前策略集合
				//状态相等且设定了预期解决时间
				if(bean.getValue().equals(processStrategyDef.getPrstatus()) 
						&& (processStrategyDef.getExpecttime() != null && processStrategyDef.getExpecttime() > 0)) {
					//该状态已设定策略，设定预期解决时间。key：状态 + split + 紧急程度，不考虑之前定义的紧急度被删除的情况
					strategyMap.put(bean.getValue() + split + processStrategyDef.getPrurgency(), processStrategyDef.getExpecttime().toString());
					flag = false;
				}
			}
			if(flag){
				for(LabelValueBean prurgency : dto.getPrurgencyList()) {
					//新增加的状态，设定预期解决时间为空
					strategyMap.put(bean.getValue() + split + prurgency.getValue(), null);
				}
			}
		}
		
		dto.setStrategyMap(strategyMap);
		
		log.debug("========流程策略设定查询处理终了========");
		
		return dto;
	}
	
	/**
	 * 功能：流程策略设定编辑处理
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO editIGSYM1702Action(IGSYM17DTO dto) throws BLException {
		
		log.debug("========流程策略设定编辑处理开始========");
		
		IGSYM1702Form form = dto.getIgSYM1702Form();
		
		//获取当前策略最大版本
		Integer version = this.ig105BL.getMaxgPsdversion(form.getPdid()) + 1;
		
		//获取当前时间
		String datatime = IGStringUtils.getCurrentDateTime();
		
		//获取流程策略Map
		Map<String,String> strategyMap = form.getStrategyMap();
		
		Set<Map.Entry<String,String>> set = strategyMap.entrySet();
		
		//迭代保存记录
		for(Iterator<Map.Entry<String,String>> iter = set.iterator(); iter.hasNext();){
			
			Map.Entry<String,String> entry = iter.next();
			
			IG105TB psdTB = new IG105TB();
			
			psdTB.setPdid(form.getPdid());//流程定义ID

			psdTB.setPrstatus(entry.getKey().split(split)[0]);//流程状态

			psdTB.setPrurgency(entry.getKey().split(split)[1]);//紧急程度
			
			psdTB.setPsdversion(version);//策略版本

			if(StringUtils.isNotEmpty(entry.getValue())) {
				psdTB.setExpecttime(Double.parseDouble(entry.getValue()));//期望解决时间
			}

			psdTB.setCreatetime(datatime);//策略创建时间
			
			//保存策略
			this.ig105BL.registIG105Info(psdTB);
		}
		
		dto.addMessage(new ActionMessage( "IGCO10000.I010", "流程策略信息保存") );
		
		log.debug("========流程策略设定编辑处理终了========");
		
		return dto;
	}
	
	/**
	 * 功能：流程状态列表和紧急程度查询处理
	 * 		自定义流程从ProcessStatusDef中查询
	 * 		基本流程从CodeDetail中查询
	 * 
	 * @param dto IGSYM17DTO
	 * @return IGSYM17DTO
	 */
	public IGSYM17DTO searchPrstatusList(IGSYM17DTO dto) throws BLException {
		
		log.debug("========流程状态列表和紧急程度查询处理开始========");
		
		//获取流程模版ID
		Integer ptid = dto.getIgSYM1702Form().getPtid();
		
		//定义流程状态列表
		List<LabelValueBean> prstatusList = null;
		
		//获取当前流程类型紧急程度
		List<LabelValueBean> prurgencyList = null;
		
		//基本事件,问题,变更
		if(IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_I.equals(ptid)) {
			prstatusList = this.searchPrstatusList(IGPROCESSType.INCIDENT_PRTYPE);
			prurgencyList = this.searchPrurgencyList("PROCESS_PRIORITY_I");
		} else if(IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_P.equals(ptid)){
			prstatusList = this.searchPrstatusList(IGPROCESSType.PROBLEM_PRTYPE);
			prurgencyList = this.searchPrurgencyList("PURGENCY_GRADE_CODE");
		} else if(IGPRDCONSTANTS.PROCESS_DEFINITION_TEMPLATE_C.equals(ptid)){
			prstatusList = this.searchPrstatusList(IGPROCESSType.CHANGE_PRTYPE);
			prurgencyList = this.searchPrurgencyList("CURGENCY_GRADE_CODE");
		} else {//自定义流程
			
			prurgencyList = this.searchPrurgencyList("WDURGENCY_GRADE_CODE");
			
			prstatusList = new ArrayList<LabelValueBean>();
			
			//查询指定流程定义ID当前状态集合
			IG333SearchCondImpl processStatusDefCond = new IG333SearchCondImpl();
			
			processStatusDefCond.setPdid(dto.getIgSYM1702Form().getPdid());
			
			List<IG333Info> processStatusDefList  = this.ig333BL.searchIG333Info(processStatusDefCond);
			
			//过滤发起状态
			IG333Info psd = null;
			for(Iterator<IG333Info> iter = processStatusDefList.iterator(); iter.hasNext();) {
				psd = iter.next();
				if(IGPRDCONSTANTS.PROCESS_START_STATUS.equals(psd.getPsdcode())) {
					iter.remove();
				} else {
					if(IGPRDCONSTANTS.PROCESS_END_STATUS.equals(psd.getPsdcode())) {
						
						prstatusList.add(new LabelValueBean("流程总体用时", psd.getPsdcode()));//填充流程状态列表
					} else {
						prstatusList.add(new LabelValueBean(psd.getPsdname(), psd.getPsdcode()));//填充流程状态列表
					}
				}
			}
		}
		
		dto.setPrstatusList(prstatusList);
		
		dto.setPrurgencyList(prurgencyList);
		
		log.debug("========流程状态列表和紧急程度查询处理终了========");
		
		return dto;
	}
	
	/**
	 * 功能：基本流程状态列表
	 * 
	 * @param codeDefine String
	 * @return List<LabelValueBean>
	 */
	public List<LabelValueBean> searchPrstatusList(String codeDefine) throws BLException {
		List<LabelValueBean> prstatusList = codeListUtils.getCodeList(CodeDefine.getCodeDefine(
				codeDefine + "_STRATEGY_STATUS").getCcid(), null, null, false, false);
		if(prstatusList == null || prstatusList.size() == 0) {
			throw new BLException("IGCO10000.E004","可设定策略的状态基本");
		}
		LabelValueBean bean = null;
		//cid是排序标识-流程状态，此处value取流程状态
		for(Iterator<LabelValueBean> iter = prstatusList.iterator(); iter.hasNext();) {
			bean = iter.next();
			bean.setValue(bean.getValue().split("-")[1]);
		}
		return prstatusList;
	}
	
	/**
	 * 功能：流程紧急度列表
	 * 
	 * @param codeDefine String
	 * @return List<LabelValueBean>
	 */
	public List<LabelValueBean> searchPrurgencyList(String codeDefine) throws BLException {
		
		List<LabelValueBean> prurgencyList = codeListUtils.getCodeList(CodeDefine.getCodeDefine(
				codeDefine).getCcid(), null, null, false, false);
		if(prurgencyList == null || prurgencyList.size() == 0) {
			throw new BLException("IGCO10000.E004","紧急程度基本");
		}
		return prurgencyList;
	}
	
}
