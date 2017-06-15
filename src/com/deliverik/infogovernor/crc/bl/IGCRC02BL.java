/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.crc.dto.IGCRC02DTO;
import com.deliverik.infogovernor.crc.model.IgalarmInfo;
/**	
 * 概述:告警信息controlBL接口
 * 功能描述：1.查询集成告警信息列表	
 *           2.通过id组 查询告警信息	
 * 创建记录：changhao    2014/7/1	
 * 修改记录：maxu    	2014/7/9	
 *         	yukexin 	2014-8-26 13:42:53
 */	
public interface IGCRC02BL extends BaseBL {

	/***
	 * 通过dto创建查询条件并查询
	 * 根据主机名称，IP地址，触发时间，恢复时间排序查询
	 * @param dto
	 */
	public void serachIgalarmSortList(IGCRC02DTO dto); 
	
	/**
	 * 查询集成告警信息列表
	 * @param dto 集成告警相关业务用DTO
	 */
	public void serachIgalarmList(IGCRC02DTO dto);
	
	/***
	 * 通过id组 查询告警信息
	 * @param alarmIds 告警Id
	 * @return 集成告警表列表
	 */
	public List<IgalarmInfo> serachByAlarmIds(String[] alarmIds); 
	
	
	/**
	 * 导出变更管理Excel
	 * @return
	 * @throws BLException
	 */
	public IGCRC02DTO getExcelDataList(IGCRC02DTO dto) throws BLException ;
	
	/**	
	 * 功能：通过id 查询告警信息
	 * @param id
	 * @return
	 * 修改记录：null 	
	 */	
	public IGCRC02DTO searchIgalarmByPK(IGCRC02DTO dto) throws BLException;
	
	/**	
	 * 功能：根据告警id更新
	 * @param dto
	 * @return
	 * @throws BLException
	 * 修改记录：null 	
	 */	
	public IGCRC02DTO updateIgalarmByForm(IGCRC02DTO dto) throws BLException; 
	
	/**	
	 * 功能：根据告警id更新
	 * @param dto
	 * @return
	 * @throws BLException
	 * 修改记录：null 	
	 */	
	public IGCRC02DTO updateIgalarmByIgalarm(IGCRC02DTO dto) throws BLException; 
	
	
	/**	
	 * 功能：根据告警id删除
	 * @param dto
	 * @throws BLException
	 * 修改记录：null 	
	 */	
	public void deleteIgalarmByPK(IGCRC02DTO dto) throws BLException;
	
	/**
	 *告警事件查询
	 */
	public IGCRC02DTO getProcessRecords(IGCRC02DTO dto) throws BLException;
}
