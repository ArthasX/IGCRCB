/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.bl.task.IG337BL;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.model.IG337Info;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.dto.IGSMR04DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0402Form;
import com.deliverik.infogovernor.smr.model.BatchExamineVWInfo;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCondImpl;
import com.deliverik.infogovernor.smr.model.entity.BatchExamineVW;

/**
 * 年报审批业务逻辑实现
 *
 */
public class IGSMR04BLImpl extends BaseBLImpl implements IGSMR04BL {
	
	
	/** 报表填报实例BL */
	protected RegulatoryReportInstanceBL regulatoryReportInstanceBL;
	
	/** 参与人BL */
	protected IG337BL ig337BL;
	
	/** 流程处理BL */
	protected FlowOptBL flowOptBL;

	/** 流程处理BL */
	protected IG333BL ig333BL;
	
	/**表单值bl*/
	protected IG599BL ig599BL;
	
	/**流程主表*/
	protected IG500BL ig500BL;
	/**
	 * 报表填报实例BL
	 * @param regulatoryReportInstanceBL
	 */	
	public void setRegulatoryReportInstanceBL(
			RegulatoryReportInstanceBL regulatoryReportInstanceBL) {
		this.regulatoryReportInstanceBL = regulatoryReportInstanceBL;
	}
	
	/**
	 *  参与人BL
	 * @param ig337bl
	 */	
	public void setIg337BL(IG337BL ig337bl) {
		ig337BL = ig337bl;
	}
	
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	
	public void setIg333BL(IG333BL ig333bl) {
		ig333BL = ig333bl;
	}
    
	
	public void setIg599BL(IG599BL ig599bl) {
		ig599BL = ig599bl;
	}

	
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * 年报明细列表查询处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 */
	public IGSMR04DTO initIGSMR0402Action(IGSMR04DTO dto) throws BLException {
		//实例化查询条件
		RegulatoryReportInstanceSearchCondImpl cond = new RegulatoryReportInstanceSearchCondImpl();
		cond.setInstanceid(dto.getInstanceID());
		//查询出所有流程包括流程的填报完成时间和报表审批完成时间
		List<BatchExamineVWInfo> list_be = regulatoryReportInstanceBL.findBatchExanmie(cond);
		//新建一个包含填报人和报表审批人的集合
		List<BatchExamineVW> list_all = new ArrayList<BatchExamineVW>();
		//遍历集合根据流程id查询对应的填报人和报表审批人
		for(BatchExamineVWInfo bean:list_be){
			BatchExamineVW tb = (BatchExamineVW)SerializationUtils.clone(bean);
			//定义填报人
			String fillinusername ="";
			//定义填报人状态标识码
			String fillincode = "";
			//到状态表中查询状态码
			IG333SearchCondImpl cond333 = new IG333SearchCondImpl();
			cond333.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_REPORT);
			cond333.setPdid(bean.getPrpdid());
			List<IG333Info> ig333 = ig333BL.searchIG333Info(cond333);
			for(IG333Info info3:ig333){
				fillincode = info3.getPsdcode();
			}
			//实例化参与者查询条件
			IG337SearchCondImpl cond337 = new IG337SearchCondImpl();
			cond337.setPpstatus_q(fillincode);
			cond337.setPrid(bean.getPrid());
			List<IG337Info> list_337 = ig337BL.getIG337Infos(cond337);
			//遍历结合拼写填报人
			for(int i=0;i<list_337.size();i++){
				IG337Info info1 = list_337.get(i);
				if(i!=list_337.size()-1){
					fillinusername = fillinusername+info1.getPpusername()+",";
				}else{
					fillinusername =fillinusername +info1.getPpusername();
				}
			}

			//定义报表审批人
			String examineusername = "";
			//定义报表填报状态标识码
			String examinecode = "";
			//到状态表中查询状态码
			IG333SearchCondImpl cond_3 = new IG333SearchCondImpl();
			cond_3.setPsdname(IGSMRCONSTANT.PRSTATUSNAME_FIRSTEXAMINE);
			cond_3.setPdid(bean.getPrpdid());
			List<IG333Info> ig_3 = ig333BL.searchIG333Info(cond_3);
			for(IG333Info info3:ig_3){
				examinecode = info3.getPsdcode();
			}
			//实例化参与者查询条件
			IG337SearchCondImpl cond_ig337 = new IG337SearchCondImpl();
			cond_ig337.setPpstatus(examinecode);
			cond_ig337.setPrid(bean.getPrid());
			List<IG337Info> list_ig337 = ig337BL.getIG337Infos(cond_ig337);			
			//遍历结合拼写报表审批人
			for(int i=0;i<list_ig337.size();i++){
				IG337Info info2 = list_ig337.get(i);
				if(i!=list_ig337.size()-1){
					examineusername = examineusername+info2.getPpusername()+",";
				}else{
					examineusername =examineusername +info2.getPpusername();
				}
			}
			//将填报人放进实体中
			tb.setFillinusername(fillinusername);
			//将报表审批人放进实体中
			tb.setExanimeusername(examineusername);
			IG599SearchCondImpl cond599 = new IG599SearchCondImpl();
		    cond599.setPrid(bean.getPrid());
		    cond599.setPivarlabel(IGSMRCONSTANT.BAOSONG_NULLTABLE);
		    List<IG599Info> ig599 =ig599BL.searchIG599InfosByCond(cond599);
		    if(ig599!=null&&ig599.size()!=0){		    	
		    	//判断是否报送空表设置标识
		    	if(StringUtils.isNotEmpty(ig599.get(0).getPivarvalue())){
		    		tb.setFlag(IGSMRCONSTANT.BAOSONG_NULLTABLE);
		    	}
		    }
			//将实体放进集合中
			list_all.add(tb);
		}
		dto.setLst_Report(list_all);
		return dto;
	}
	
	/**
	 * 年报审批处理
	 *
	 * @param dto IGSMR01DTO
	 * @return IGSMR01DTO
	 * @throws  
	 */
	public IGSMR04DTO managerIGSMR0402Action(IGSMR04DTO dto) throws BLException {
		//form取得
		IGSMR0402Form form = dto.getIgsmr0402Form();
	    for(Integer prid:form.getPrids()){						
	        //循环选择的流程，将流程进行驳回或审批通过处理
	        if("1".equals(form.getType())){
	            flowOptBL.transitionProcess(prid, dto.getUser().getUserid(), "审批通过", IGStringUtils.getCurrentDateTime());
	        } else if("2".equals(form.getType())){
	            flowOptBL.transitionProcess(prid, dto.getUser().getUserid(), "驳回", IGStringUtils.getCurrentDateTime());
	        }
	    }
		return dto;
	}
}
