/**
 * 
 */
package com.deliverik.infogovernor.drm.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCond;
import com.deliverik.infogovernor.drm.dto.IGDRM19DTO;

/**
 * @author Administrator
 *
 */
public class IGDRM19BLImpl  extends BaseBLImpl implements IGDRM19BL{
	static Log log = LogFactory.getLog(IGDRM19BLImpl.class);
	protected IG500BL ig500BL;
	
	/**  
	 * 获取ig500BL  
	 * @return ig500BL 
	 */
	public IG500BL getIg500BL() {
		return ig500BL;
	}

	/**  
	 * 设置ig500BL  
	 * @param ig500BL
	 */
	
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
	}

	/**
	 * <p>
	 * Description: 查询工作记录
	 * </p>
	 * 
	 * @param dto IGWKM01DTO
	 * @return IGWKM01DTO
	 * @throws BLException
	 * @update sunkaiyu@deliverik.com
	 */
		
	public IGDRM19DTO getProcessRecords(IGDRM19DTO dto) throws BLException {
		log.debug("========查询工作记录处理开始========");
		// 查询记录总数
		IG500SearchCond cond = dto.getPrSearchCond();
		int totalCount = ig500BL.countDrmFlow(cond);
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<IG500Info> prList = ig500BL.getDrmFlow(cond, pDto.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setProcessList(prList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========查询工作记录处理终了========");
		return dto;
	}
}
