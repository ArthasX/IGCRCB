package com.deliverik.infogovernor.rdp.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.rdp.dto.IGRDP01DTO;

public interface IGRDP01BL extends BaseBL {
	
	/**
	 * 远程部署脚本
	 * @param dto
	 * @return
	 */
	public IGRDP01DTO remoteDeploy(final IGRDP01DTO dto) throws BLException;
	
	
	/**
	 * 获取业务系统列表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO getBusinessSystems(IGRDP01DTO dto) throws BLException;
	
	
	/**
	 * 通过业务系统eiid获取所属主机列表
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO getHostsBySystemID(IGRDP01DTO dto) throws BLException;
	
	/**
	 * 添加部署任务和结果
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO insertTaskAndResults(IGRDP01DTO dto) throws BLException;
	
	
	/**
	 * 查询升级任务
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO searchTasks(IGRDP01DTO dto) throws BLException;
	
	/**
	 * 获取所有任务
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO searchAllTasks(IGRDP01DTO dto) throws BLException;
	
	/**
	 * 通过任务id获取任务结果
	 * @param dto
	 * @return
	 */
	public IGRDP01DTO getExcuteResultByTaskID(IGRDP01DTO dto) throws BLException;
	
	/**
	 * 通过任务id获取任务结果(ajax)
	 * @param dto
	 * @return
	 */
	public IGRDP01DTO getExcuteResultByTaskIDByAjax(IGRDP01DTO dto) throws BLException;
	
	
	/**
	 * 通过日志路径获取本地日志
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO getLogByLogPath(IGRDP01DTO dto) throws BLException;
	
	/**
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO getHostByAjax(IGRDP01DTO dto) throws BLException;
	/**
	 * Ajax 根据任务id 和 主机ip查询realtimedetail 最新数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO searchRealTimeDetail(IGRDP01DTO dto)throws BLException;
	/**
	 * Ajax 根据任务id 和 已查出的最后的id 获取数据
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGRDP01DTO searchLastRealTimeDetail(IGRDP01DTO dto)throws BLException;
}
