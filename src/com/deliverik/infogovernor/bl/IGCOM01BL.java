package com.deliverik.infogovernor.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dto.IGCOM01DTO;


/**
 * 登录画面业务逻辑接口
 *
 *
 */
public interface IGCOM01BL extends BaseBL {


	/**
	 * 
	 *
	 * @param dto IGBAS01DTO
	 * @return IGBAS01DTO
	 */
	public IGCOM01DTO loginAction(IGCOM01DTO dto) throws BLException;
	
	public IGCOM01DTO loginActionByLDAP(IGCOM01DTO dto) throws BLException;
	
	public IGCOM01DTO loginActionByAD(IGCOM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 获取用户被授予的角色List
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @return 用户被授予的角色List
	 * @author liupeng@deliverik.com
	 */

	public IGCOM01DTO getUserRoles(IGCOM01DTO dto);
	
	/**
	 * <p>
	 * 获取首页处理中的工作
	 * </p>
	 * 
	 * @param userId 用户ID
	 * @return 处理中的工作
	 * @author   
	 */
	public IGCOM01DTO getProcessInHand(IGCOM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 获取首页处理中的知识
	 * </p>
	 * 
	 * @author   
	 */
	public IGCOM01DTO getKnowledge(IGCOM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * Description: 获取首页中检查工作结果
	 * </p>
	 */
	public IGCOM01DTO getRiskCheckResultGoup(IGCOM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 获取首页通知
	 * </p>
	 * 
	 * @author   
	 */
	public IGCOM01DTO getNotice(IGCOM01DTO dto) throws BLException;
	
	/**
	 * <p>
	 * 首页日常计划日历
	 * </p>
	 * 
	 * @author   
	 */
	public IGCOM01DTO getDaysPlans(IGCOM01DTO dto) throws BLException;
	
	/**
	 * 首页跳转处理
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws BLException
	 */
	public IGCOM01DTO initIGCOM0105Action(IGCOM01DTO dto) throws BLException;
	
	/**
	 * 告警列表
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchHQAlertListDetailVWAction(IGCOM01DTO dto) throws Exception;
	
	/**
	 * 业务系统可用性列表
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchBussinessAvailvalVWAction(IGCOM01DTO dto) throws Exception;
	
	/**
	 * Oracle告警列表
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchOracleAlertAction(IGCOM01DTO dto) throws Exception;
	
	/**
	 * 告警列表
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 */
	public IGCOM01DTO searchHQAlertListDetailVWActionByIP(IGCOM01DTO dto) throws Exception;
	
	/**
	 * 首页查询当日工作
	 * @param dto IGCOM01DTO
	 * @return IGCOM01DTO
	 * @throws Exception
	 * @return
	 */
	public IGCOM01DTO findTodayWorkByCondForFirstPage(IGCOM01DTO dto) throws Exception;
}
