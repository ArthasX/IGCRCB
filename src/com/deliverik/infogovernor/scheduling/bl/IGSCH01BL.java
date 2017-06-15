package com.deliverik.infogovernor.scheduling.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.scheduling.dto.IGSCH01DTO;
import com.deliverik.infogovernor.sdl.dto.IGSDL01DTO;

public interface IGSCH01BL extends BaseBL  {
	/**
	 * <p>
	 * Description: 定时任务查询
	 * </p>
	 * 
	 * @param dto IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	public IGSCH01DTO searchQuartzJobs(IGSCH01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 定时任务按照ID查询
	 * </p>
	 * 
	 * @param integer IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	public IGSCH01DTO searchQuartzJobsByPK(IGSCH01DTO dto) throws BLException;
	/**dto
	 * <p>
	 * Description: 定时任务删除
	 * </p>
	 * 
	 * @param dto IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGSCH01DTO deleteQuartzJobs(IGSCH01DTO dto) throws BLException;

	/**
	 * <p>
	 * Description: 定时任务变更初始化
	 * </p>
	 * 
	 * @param dto IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public IGSCH01DTO initIGSCH0101(IGSCH01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 定时任务变更
	 * </p>
	 * 
	 * @param dto IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @author maozhipeng@deliverik.com
	 * @update
	 */
	
	public void updateQuartzJobs(IGSCH01DTO dto) throws BLException;
	
	public IGSCH01DTO getQuartzJobs(IGSCH01DTO dto) throws BLException;
	
	public IGSDL01DTO findQuartzJobsForSDL(IGSDL01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 根据日期查询服务策略
	 * </p>
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSDL01DTO searchQuartzJobsByDate(IGSDL01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 定时任务按照ID查询QuartzJobDetails
	 * </p>
	 * 
	 * @param integer IGSCH01DTO
	 * @return IGSCH01DTO
	 * @throws BLException
	 * @update
	 */
	public IGSCH01DTO searchQuartzJobDetailsByQjid(IGSCH01DTO dto) throws BLException;
	

	/**
	 * <p>
	 * Description: 根据日期及登录用户查询服务策略
	 * </p>
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSDL01DTO searchQuartzJobsByUserDate(IGSDL01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 根据日期及登录用户查询运维计划（IGSDL0110.JSP查询页使用）
	 * </p>
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSDL01DTO searchQuartzJobsForIGSDL0110(IGSDL01DTO dto) throws BLException;
}
