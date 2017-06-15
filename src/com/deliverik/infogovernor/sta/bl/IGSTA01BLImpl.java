/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sta.bl;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.bl.task.IG499BL;
import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.condition.IG499SearchCondImpl;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.sta.bl.task.ContractVWBL;
import com.deliverik.infogovernor.sta.bl.task.ProjectStatisticVWBL;
import com.deliverik.infogovernor.sta.bl.task.RiskCheckProblemSuperviseVWBL;
import com.deliverik.infogovernor.sta.dto.IGSTA01DTO;
import com.deliverik.infogovernor.sta.form.IGSTA0102Form;
import com.deliverik.infogovernor.sta.form.IGSTA0103Form;
import com.deliverik.infogovernor.sta.form.IGSTA0105Form;
import com.deliverik.infogovernor.sta.model.Contract;
import com.deliverik.infogovernor.sta.model.ProjectStatistic;
import com.deliverik.infogovernor.sta.model.RiskCheckProblemSuperviseVWInfo;
import com.deliverik.infogovernor.sta.model.condition.ContractSearchCondImpl;
import com.deliverik.infogovernor.sta.model.condition.ProjectStatisticSearchCondImpl;
import com.deliverik.infogovernor.sta.model.condition.RiskCheckProblemSuperviseVWSearchCondImpl;

/**
 * 工作监督业务逻辑实现
 *
 */
public class IGSTA01BLImpl extends BaseBLImpl implements IGSTA01BL {

	static Log log = LogFactory.getLog(IGSTA01BLImpl.class);
	
	/** 审计版本信息BL */
	protected RiskCheckProblemSuperviseVWBL riskcheckproblemsuperviseVWBL;
	/** 合同统计BL*/
	protected ContractVWBL contractVWBL;
	/** 项目统计BL*/
	protected ProjectStatisticVWBL projectStatisticVWBL;
	/** IG117*/
	protected SOC0117BL soc0117BL;
	
	protected IG499BL ig499BL;

	/**
	 * 审计版本信息BL设定
	 * @param riskcheckproblemsuperviseVWBL 审计版本信息BL
	 */
	public void setRiskcheckproblemsuperviseVWBL(
			RiskCheckProblemSuperviseVWBL riskcheckproblemsuperviseVWBL) {
		this.riskcheckproblemsuperviseVWBL = riskcheckproblemsuperviseVWBL;
	}
	/**
     * 合同统计BL设定
     *
     * @param contractVWBL 合同统计BL
     */
    public void setContractVWBL(ContractVWBL contractVWBL) {
        this.contractVWBL = contractVWBL;
    }

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

    
    /**
     * ig499BL设定
     *
     * @param ig499bl ig499BL
     */
    public void setIg499BL(IG499BL ig499bl) {
        ig499BL = ig499bl;
    }
    /**
     * 项目统计BL设定
     *
     * @param projectStatisticVWBL 项目统计BL
     */
    public void setProjectStatisticVWBL(ProjectStatisticVWBL projectStatisticVWBL) {
        this.projectStatisticVWBL = projectStatisticVWBL;
    }
    /**
	 * 问题整改监督查询处理
	 *
	 * @param dto IGSTA01DTO
	 * @return IGSTA01DTO
	 */
	public IGSTA01DTO searchRiskcheckproblemsuperviseAction(IGSTA01DTO dto) throws BLException {
		IGSTA0102Form form = dto.getIgsta0102Form();
		RiskCheckProblemSuperviseVWSearchCondImpl cond = new RiskCheckProblemSuperviseVWSearchCondImpl();
		this.copyProperties(cond, form);
		//审计版本信息查询件数取得 
		int totalCount = this.riskcheckproblemsuperviseVWBL.getRiskCheckProblemSuperviseSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========审计版本信息查询数据不存在========");
			//审计版本信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========审计版本信息查询数据件数过多========");
			//审计版本信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		//当前页问题整改信息取得
		List<RiskCheckProblemSuperviseVWInfo> riskCheckProblemSuperviseVWList = this.riskcheckproblemsuperviseVWBL.findDispatchStatisticsVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setRiskCheckProblemSuperviseVWList(riskCheckProblemSuperviseVWList);
		return dto;
	}
	
	/**
	 * 合同统计查询处理
	 *
	 * @param dto IGSTA01DTO
	 * @return IGSTA01DTO
	 */
	public IGSTA01DTO searchContractAmountAction(IGSTA01DTO dto) throws BLException {
	    log.debug("===================合同统计查询开始====================");
	    IGSTA0103Form form = dto.getIgsta0103Form();
	    ContractSearchCondImpl cond = new ContractSearchCondImpl();
	    try {
	       BeanUtils.copyProperties(cond, form);
	        
	       List<Contract> contracts = contractVWBL.statisticContractAmount(cond);
	       
	       dto.setContracts(contracts);
	    } catch (IllegalAccessException e) {
	       log.debug(e);
	    } catch (InvocationTargetException e) {
	        log.debug(e);
	    }
	    log.debug("===================合同统计查询终了====================");
	    return dto;
	}
	/**
	 * 项目统计查询处理
	 *
	 * @param dto IGSTA01DTO
	 * @return IGSTA01DTO
	 */
	public IGSTA01DTO searchPrjRecAction(IGSTA01DTO dto) throws BLException {
	    log.debug("===================项目查询开始====================");
	    IGSTA0105Form form = dto.getIgsta0105Form();
	    ProjectStatisticSearchCondImpl cond = new ProjectStatisticSearchCondImpl();
	    try {
	        BeanUtils.copyProperties(cond, form);
	        
	        int totalCount = projectStatisticVWBL.searchPrjRec(cond,0,0).size();
	        
	        if (totalCount == 0) {
	            log.debug("========项目信息查询数据不存在========");
	            //审计版本信息查询数据不存在
	            dto.addMessage(new ActionMessage("IGCO10000.I002",0));
	            return dto;
	        } 
	        
	        //分页用信息取得
	        PagingDTO pDto = dto.getPagingDto();
	        
	        List<ProjectStatistic> projects = projectStatisticVWBL.searchPrjRec(cond, pDto.getFromCount(), pDto.getPageDispCount());
	        
            pDto.setTotalCount(totalCount);
	        
	        dto.setProjectInfo(projects);
	    } catch (IllegalAccessException e) {
	        log.debug(e);
	    } catch (InvocationTargetException e) {
	        log.debug(e);
	    }
	    log.debug("===================项目查询终了====================");
	    return dto;
	}
	
    /**
     * 合同信息查询处理
     *
     * @param dto IGASM04DTO
     * @return IGASM04DTO
     */
    public IGSTA01DTO searchEntityItemAction(IGSTA01DTO dto) throws BLException {

        log.debug("========合同信息查询处理开始========");
        
        IG499SearchCondImpl condImpl = new IG499SearchCondImpl();
        IGSTA0103Form form =dto.getIgsta0103Form();
        condImpl.setEsyscoding(form.getEsyscoding());
        
        if(StringUtils.isNotEmpty(form.getFacilitator())){
            try {
                condImpl.setFacilitator(URLDecoder.decode(form.getFacilitator(),"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                log.debug(e);
            }
        }
       
        if(StringUtils.isNotEmpty(form.getCurYear())){
            
            int year = Integer.valueOf(form.getCurYear());
            
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd");

            //前一年的第一天
            calendar.clear();
            calendar.set(Calendar.YEAR, year-1);
            String condudetime_from = f.format(calendar.getTime());
          
            //当前年的最后一天
            calendar.clear();
            calendar.set(Calendar.YEAR, year);
            calendar.roll(Calendar.DAY_OF_YEAR, -1);
            String condudetime_to = f.format(calendar.getTime());

            
            condImpl.setCondudetime_from(condudetime_from);
            condImpl.setCondudetime_to(condudetime_to);
        }
        int totalCount = ig499BL.getSearchCount(condImpl);
        
        if (totalCount == 0) {
            log.debug("========合同信息查询数据不存在========");
            //审计版本信息查询数据不存在
            dto.addMessage(new ActionMessage("IGCO10000.I002",0));
            return dto;
        } 
        
        //分页用信息取得
        PagingDTO pDto = dto.getPagingDto();

        //当前页合同信息取得
        List<IG499Info> entityItemCompactVWInfoList = this.ig499BL.searchIG499Info(condImpl, pDto.getFromCount(), pDto.getPageDispCount());
        
        pDto.setTotalCount(totalCount);
        
        dto.setEntityItemCompactVWInfoList(entityItemCompactVWInfoList);
        
        log.debug("========合同信息查询处理终了========");
        return dto;
    }
	/**
	 * 合同模型labelvaluebean查询处理
	 *
	 * @param dto IGSTA01DTO
	 * @return IGSTA01DTO
	 */
	public IGSTA01DTO getContractLabel(IGSTA01DTO dto) throws BLException {
	    
	    SOC0117SearchCondImpl condImpl  = new SOC0117SearchCondImpl();
	    
	    condImpl.setEparcoding(CommonDefineUtils.ENTIY_CATEGORY_CONTRACT_SYSCODING);
	    
	    List<SOC0117Info> soc0117Infos = soc0117BL.searchEntity(condImpl);
	    
	    List<LabelValueBean> contract = new ArrayList<LabelValueBean>();
	    
	    contract.add(new LabelValueBean("", ""));
	    
	    for (SOC0117Info soc117Info : soc0117Infos) {
            contract.add(new LabelValueBean(soc117Info.getEname(), soc117Info.getEname()));
        }
	    
	    dto.setContractType(contract);
	    return dto;
	}

	
}
