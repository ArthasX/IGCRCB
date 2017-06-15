package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.asset.bl.task.IG343BL;
import com.deliverik.infogovernor.asset.bl.task.IG344BL;
import com.deliverik.infogovernor.asset.dto.IGASM25DTO;
import com.deliverik.infogovernor.asset.model.IG343Info;
import com.deliverik.infogovernor.asset.model.IG344Info;
import com.deliverik.infogovernor.asset.model.condition.IG343SearchCondImpl;
import com.deliverik.infogovernor.asset.model.condition.IG344SearchCondImpl;

/**
 * 服务记录统计业务逻辑实现
 *
 */
public class IGASM25BLImpl extends BaseBLImpl implements IGASM25BL {

	static Log log = LogFactory.getLog(IGASM25BLImpl.class);

	/** 服务记录统计BL */
	private IG343BL ig343BL;
	
	/** 服务记录明细BL */
	private IG344BL ig344BL;
	
	/** 资产信息BL */
//	private IG013BL ig013BL;
	protected SOC0118BL soc0118BL;
	

    /**
     * 资产信息BL设定
     *
     * @param soc0118BL soc0118BL
     */
    public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}


	/**
     * 服务记录统计BL设定
     *
     * @param ig343bl ig343BL
     */
    public void setIg343BL(IG343BL ig343bl) {
        ig343BL = ig343bl;
    }


    /**
     * 服务记录明细BL设定
     *
     * @param ig344bl ig344BL
     */
    public void setIg344BL(IG344BL ig344bl) {
        ig344BL = ig344bl;
    }


    /**
	 * 服务记录统计信息查询处理
	 *
	 * @param dto IGASM20DTO
	 * @return IGASM20DTO
	 */
	public IGASM25DTO searchEntityItemRelationVW(IGASM25DTO dto)
			throws BLException {
		log.debug("========服务记录统计信息查询处理开始========");
		//创建条件查询对象
		IG343SearchCondImpl cond = new IG343SearchCondImpl();
		//设置查询条件
		cond.setEiname_like(dto.getEiname_like());//服务商名称
		cond.setBeginTime_q(dto.getBeginTime_q());//服务记录起始时间
		cond.setEndTime_q(dto.getEndTime_q());//服务记录中止时间
		List<IG343Info> entityItemRelationVWInfoList = ig343BL.searchIG343(cond, 0, 0);
		int sbSumCount = 0;//设备资产共计
		int yySumCount = 0;//应用资产共计
		int pxSumCount = 0;//培训记录共计
		int hjSumCount = 0;//合计次数共计
		//循环统计共计
		for(IG343Info info :entityItemRelationVWInfoList){
			sbSumCount += info.getCivalue();
			yySumCount += info.getCivalue2();
			pxSumCount += info.getEiname3();
			hjSumCount += info.getSumcount();
		}
		//将值保存到dto中
		dto.setSbSumCount(sbSumCount);
		dto.setYySumCount(yySumCount);
		dto.setPxSumCount(pxSumCount);
		dto.setHjSumCount(hjSumCount);
		dto.setEntityItemRelationVWInfoList(entityItemRelationVWInfoList);
		log.debug("========服务记录统计信息查询处理结束========");
		return dto;
	}
	
	/**		
	 * 服务记录明细信息查询处理		
	 *		
	 * @param dto IGASM20DTO		
	 * @return IGASM20DTO		
	 */		
	public IGASM25DTO searchEntityItemRelationDetailVW(IGASM25DTO dto)		
			throws BLException {
		log.debug("========服务记录统计信息查询处理开始========");	
		//查询服务商名称
		SOC0118Info item = soc0118BL.searchEntityItemByKey(Integer.parseInt(dto.getIgasm2502Form().getEiid_q()));
		//创建条件查询对象	
		IG344SearchCondImpl cond = new IG344SearchCondImpl();	
		//设置查询条件	
		cond.setBeginTime_q(dto.getIgasm2502Form().getBeginTime());//服务记录起始时间	
		cond.setEndTime_q(dto.getIgasm2502Form().getEndTime());//服务记录中止时间	
		cond.setEiid_q(dto.getIgasm2502Form().getEiid_q());//服务商id	
		List<IG344Info> entityItemRelationDetailVWInfoList = ig344BL.searchIG344(cond, 0, 0);	
		int fwcsSumCount = 0;//服务次数累计	
		double fwpjfSumStore = 0;//服务平均分累计	
		
		for(IG344Info info :entityItemRelationDetailVWInfoList){	
			fwcsSumCount += 1;
			fwpjfSumStore += info.getCivalue3();
		}	
		//将值保存到dto中	
		dto.setFwcsSumCount(fwcsSumCount);	
		dto.setFwpjfSumStore(fwpjfSumStore);	
		dto.setEiname_like(item.getEiname());	
		dto.setEntityItemRelationDetailVWInfo(entityItemRelationDetailVWInfoList);	
		log.debug("========服务记录统计信息查询处理结束========");	
		return dto;	
	}


}
