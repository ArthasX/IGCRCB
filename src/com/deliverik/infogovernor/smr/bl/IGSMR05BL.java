/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.smr.dto.IGSMR05DTO;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 报表相关业务逻辑处理接口
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface IGSMR05BL extends BaseBL{

	/**
	 * 查询分组信息操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR05DTO searchRegulatoryHistoryListAction(IGSMR05DTO dto) throws BLException;

	/**
	 * 填报说明查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSMR05DTO searchReportDescAction(IGSMR05DTO dto) throws BLException;

}
