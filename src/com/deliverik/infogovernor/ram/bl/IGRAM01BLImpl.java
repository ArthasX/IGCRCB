/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.ram.bl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.IG259BL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG259Info;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG259SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.infogovernor.ram.dto.IGRAM01DTO;

/**
 * 审计版本业务逻辑实现
 *
 */
public class IGRAM01BLImpl extends BaseBLImpl implements IGRAM01BL {
	
	static Log log = LogFactory.getLog(IGRAM01BLImpl.class);
	
	/**流程定义类型BL*/
	protected IG380BL ig380BL;
	
	/**流程模板类型BL*/
	protected IG259BL ig259BL;

	/**
	 * ig380BL设定
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	/**
	 * ig259BL设定
	 */
	public void setIg259BL(IG259BL ig259bl) {
		ig259BL = ig259bl;
	}

	/**
	 * <p>
	 * Description: 获取风险评估处理显示状态（处理按钮权限）
	 * </p>
	 * 
	 * @param dto IGRAM01DTO
	 * @return IGRAM01DTO
	 * @throws BLException
	 * @author tangzhen@deliverik.com
	 * @update
	 */
	public IGRAM01DTO searchWD4typeProcessDef(IGRAM01DTO dto)
			throws BLException {
		//查询风险评估
		Map<IG259Info,List<IG380Info>> templateDefinitionMap = new HashMap<IG259Info,List<IG380Info>>();
		IG259Info ig259 = ig259BL.searchIG259InfoByKey(Integer.parseInt(dto.getPtid()));
		
		IG380SearchCondImpl cond = new IG380SearchCondImpl();
		cond.setPtid(Integer.parseInt(dto.getPtid()));
		cond.setPdstatus("a");
		List<IG380Info> ig380List = ig380BL.searchIG380Info(cond);
		templateDefinitionMap.put(ig259, ig380List);
		dto.setTemplateDefinitionMap(templateDefinitionMap);
		return dto;
	}	
}
