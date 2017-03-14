/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
/**
 * 
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.bl.task.IG342BL;
import com.deliverik.infogovernor.asset.dto.IGASM26DTO;
import com.deliverik.infogovernor.asset.model.IG342Info;
import com.deliverik.infogovernor.asset.model.condition.IG342SearchCondImpl;

/**
 * @author Administrator
 *
 */
/**
 * 概述: 服务商资源池统计业务逻辑接口实现
 * 功能描述：服务商资源池统计业务逻辑接口实现
 * 创建人：赵敏
 * 创建记录： 2012-8-3
 * 修改记录：
 */
public class IGASM26BLImpl extends BaseBLImpl implements IGASM26BL {

	static Log log = LogFactory.getLog(IGASM26BLImpl.class);
	
	/** 服务商资源池统计BL*/
	private IG342BL ig342BL;
	
    /**
     * 服务商资源池统计BL设定
     *
     * @param ig342bl ig342BL
     */
    public void setIg342BL(IG342BL ig342bl) {
        ig342BL = ig342bl;
    }

    /**
	 * 服务商资源池统计处理
	 *
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 */
	public IGASM26DTO searchEntityItemRelationVW(IGASM26DTO dto)
			throws BLException {
		log.debug("========服务商资源池统计处理开始========");
		//创建条件查询对象	
		IG342SearchCondImpl cond = new IG342SearchCondImpl();	
		//设置查询条件	
		cond.setBeginTime_q(dto.getIgasm2601Form().getBeginTime_q());//服务记录起始时间	
		cond.setEndTime_q(dto.getIgasm2601Form().getEndTime_q());//服务记录中止时间	
		int totalCount = ig342BL.getSearchCount(cond);
		//查询数据不存在
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 评估信息查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		// 当查询结果集数量大于所能查询最大数值时，页面提示查询数据件数过多
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			//查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		List<IG342Info> entityItemAndConfigItemVWInfoList = ig342BL.searchIG342(cond,  pDto
				.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setEntityItemAndConfigItemVWInfoList(entityItemAndConfigItemVWInfoList);
		log.debug("========服务商资源池统计处理结束========");
		return dto;
	}


}
