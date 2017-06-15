package com.deliverik.infogovernor.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dto.IGCOM04DTO;
import com.deliverik.infogovernor.vo.IGCOM04051VO;

public interface IGCOM04BL extends BaseBL {
	public IGCOM04DTO getWorkAssigned(IGCOM04DTO dto) throws BLException;
	public IGCOM04DTO getProcessRecordList(IGCOM04DTO dto) throws BLException;
	/**
	 * 业务人员首页信息取得
	 * 
	 * @param dto IGCOM04DTO
	 * @param vo IGCOM04051VO
	 * @return IGCOM04DTO
	 * @throws BLException 
	 */
	public IGCOM04DTO initIGCOM0405Action(IGCOM04DTO dto, IGCOM04051VO vo) throws BLException;
	
	/**
     * 功能:处长首页本月事件数量取得处理
     * @param IGCOM07DTO dto
     * @return 本月事件数量
     * @throws BLException
     */
    public IGCOM04DTO getCurrentMouthEventCount(IGCOM04DTO dto)  throws BLException;
    
    /**
     * 功能:处长首页本月问题数量取得处理
     * @param IGCOM07DTO dto
     * @return 本月问题数量
     * @throws BLException
     */
    public IGCOM04DTO getCurrentMouthProblemCount(IGCOM04DTO dto)  throws BLException;
    
    /**
	 * 
	 * 功能:流程主题各种类型工作数量取得处理
	 * @param IGCOM07DTO dto
	 * @return 各种类型工作数量
	 * @throws BLException
	 */
	public IGCOM04DTO getAllTypeWorkCount(IGCOM04DTO dto)  throws BLException;
	
	/**
	 * 功能:生成处长首页年度事件数量及平均解决时间xml
	 * @param IGCOM07DTO dto
	 * @return 年度事件数量及平均解决时间
	 * @throws BLException（事件趋势）
	 */
	public IGCOM04DTO setEventAvgCost(IGCOM04DTO dto)  throws BLException;
	
	/**
	 * 功能:生成处长首页年度事件数量及平均解决时间xml
	 * @param IGCOM07DTO dto
	 * @return 年度事件数量及平均解决时间
	 * @throws BLException（事件趋势）
	 */
	public IGCOM04DTO searchProblemAvgSuccess(IGCOM04DTO dto)  throws BLException;
	
	/**
	 * 功能:生成事件优先级、影响程度、紧急程度xml
	 * @param IGCOM07DTO dto
	 * @throws BLException
	 */
	public IGCOM04DTO setproincidentInfo(IGCOM04DTO dto)  throws BLException;
	
	/**
	 * 按月查询问题数量
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGCOM04DTO searchProblemTotalByMonth(IGCOM04DTO dto) throws BLException;
}
