/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * �����ලҵ���߼�ʵ��
 *
 */
public class IGSTA01BLImpl extends BaseBLImpl implements IGSTA01BL {

	static Log log = LogFactory.getLog(IGSTA01BLImpl.class);
	
	/** ��ư汾��ϢBL */
	protected RiskCheckProblemSuperviseVWBL riskcheckproblemsuperviseVWBL;
	/** ��ͬͳ��BL*/
	protected ContractVWBL contractVWBL;
	/** ��Ŀͳ��BL*/
	protected ProjectStatisticVWBL projectStatisticVWBL;
	/** IG117*/
	protected SOC0117BL soc0117BL;
	
	protected IG499BL ig499BL;

	/**
	 * ��ư汾��ϢBL�趨
	 * @param riskcheckproblemsuperviseVWBL ��ư汾��ϢBL
	 */
	public void setRiskcheckproblemsuperviseVWBL(
			RiskCheckProblemSuperviseVWBL riskcheckproblemsuperviseVWBL) {
		this.riskcheckproblemsuperviseVWBL = riskcheckproblemsuperviseVWBL;
	}
	/**
     * ��ͬͳ��BL�趨
     *
     * @param contractVWBL ��ͬͳ��BL
     */
    public void setContractVWBL(ContractVWBL contractVWBL) {
        this.contractVWBL = contractVWBL;
    }

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

    
    /**
     * ig499BL�趨
     *
     * @param ig499bl ig499BL
     */
    public void setIg499BL(IG499BL ig499bl) {
        ig499BL = ig499bl;
    }
    /**
     * ��Ŀͳ��BL�趨
     *
     * @param projectStatisticVWBL ��Ŀͳ��BL
     */
    public void setProjectStatisticVWBL(ProjectStatisticVWBL projectStatisticVWBL) {
        this.projectStatisticVWBL = projectStatisticVWBL;
    }
    /**
	 * �������ļල��ѯ����
	 *
	 * @param dto IGSTA01DTO
	 * @return IGSTA01DTO
	 */
	public IGSTA01DTO searchRiskcheckproblemsuperviseAction(IGSTA01DTO dto) throws BLException {
		IGSTA0102Form form = dto.getIgsta0102Form();
		RiskCheckProblemSuperviseVWSearchCondImpl cond = new RiskCheckProblemSuperviseVWSearchCondImpl();
		this.copyProperties(cond, form);
		//��ư汾��Ϣ��ѯ����ȡ�� 
		int totalCount = this.riskcheckproblemsuperviseVWBL.getRiskCheckProblemSuperviseSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========��ư汾��Ϣ��ѯ���ݲ�����========");
			//��ư汾��Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ư汾��Ϣ��ѯ���ݼ�������========");
			//��ư汾��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		//��ǰҳ����������Ϣȡ��
		List<RiskCheckProblemSuperviseVWInfo> riskCheckProblemSuperviseVWList = this.riskcheckproblemsuperviseVWBL.findDispatchStatisticsVW(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setRiskCheckProblemSuperviseVWList(riskCheckProblemSuperviseVWList);
		return dto;
	}
	
	/**
	 * ��ͬͳ�Ʋ�ѯ����
	 *
	 * @param dto IGSTA01DTO
	 * @return IGSTA01DTO
	 */
	public IGSTA01DTO searchContractAmountAction(IGSTA01DTO dto) throws BLException {
	    log.debug("===================��ͬͳ�Ʋ�ѯ��ʼ====================");
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
	    log.debug("===================��ͬͳ�Ʋ�ѯ����====================");
	    return dto;
	}
	/**
	 * ��Ŀͳ�Ʋ�ѯ����
	 *
	 * @param dto IGSTA01DTO
	 * @return IGSTA01DTO
	 */
	public IGSTA01DTO searchPrjRecAction(IGSTA01DTO dto) throws BLException {
	    log.debug("===================��Ŀ��ѯ��ʼ====================");
	    IGSTA0105Form form = dto.getIgsta0105Form();
	    ProjectStatisticSearchCondImpl cond = new ProjectStatisticSearchCondImpl();
	    try {
	        BeanUtils.copyProperties(cond, form);
	        
	        int totalCount = projectStatisticVWBL.searchPrjRec(cond,0,0).size();
	        
	        if (totalCount == 0) {
	            log.debug("========��Ŀ��Ϣ��ѯ���ݲ�����========");
	            //��ư汾��Ϣ��ѯ���ݲ�����
	            dto.addMessage(new ActionMessage("IGCO10000.I002",0));
	            return dto;
	        } 
	        
	        //��ҳ����Ϣȡ��
	        PagingDTO pDto = dto.getPagingDto();
	        
	        List<ProjectStatistic> projects = projectStatisticVWBL.searchPrjRec(cond, pDto.getFromCount(), pDto.getPageDispCount());
	        
            pDto.setTotalCount(totalCount);
	        
	        dto.setProjectInfo(projects);
	    } catch (IllegalAccessException e) {
	        log.debug(e);
	    } catch (InvocationTargetException e) {
	        log.debug(e);
	    }
	    log.debug("===================��Ŀ��ѯ����====================");
	    return dto;
	}
	
    /**
     * ��ͬ��Ϣ��ѯ����
     *
     * @param dto IGASM04DTO
     * @return IGASM04DTO
     */
    public IGSTA01DTO searchEntityItemAction(IGSTA01DTO dto) throws BLException {

        log.debug("========��ͬ��Ϣ��ѯ����ʼ========");
        
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

            //ǰһ��ĵ�һ��
            calendar.clear();
            calendar.set(Calendar.YEAR, year-1);
            String condudetime_from = f.format(calendar.getTime());
          
            //��ǰ������һ��
            calendar.clear();
            calendar.set(Calendar.YEAR, year);
            calendar.roll(Calendar.DAY_OF_YEAR, -1);
            String condudetime_to = f.format(calendar.getTime());

            
            condImpl.setCondudetime_from(condudetime_from);
            condImpl.setCondudetime_to(condudetime_to);
        }
        int totalCount = ig499BL.getSearchCount(condImpl);
        
        if (totalCount == 0) {
            log.debug("========��ͬ��Ϣ��ѯ���ݲ�����========");
            //��ư汾��Ϣ��ѯ���ݲ�����
            dto.addMessage(new ActionMessage("IGCO10000.I002",0));
            return dto;
        } 
        
        //��ҳ����Ϣȡ��
        PagingDTO pDto = dto.getPagingDto();

        //��ǰҳ��ͬ��Ϣȡ��
        List<IG499Info> entityItemCompactVWInfoList = this.ig499BL.searchIG499Info(condImpl, pDto.getFromCount(), pDto.getPageDispCount());
        
        pDto.setTotalCount(totalCount);
        
        dto.setEntityItemCompactVWInfoList(entityItemCompactVWInfoList);
        
        log.debug("========��ͬ��Ϣ��ѯ��������========");
        return dto;
    }
	/**
	 * ��ͬģ��labelvaluebean��ѯ����
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
