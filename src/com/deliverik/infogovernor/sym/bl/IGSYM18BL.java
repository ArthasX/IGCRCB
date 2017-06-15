/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM18DTO;

/**
 * 概述: 数据管理 首页管理处理
 * 功能描述：数据管理 首页管理处理
 * 创建记录：崔学志    2012/11/14
 * 修改记录：
 */
public interface IGSYM18BL extends BaseBL {
	/**
	 * 功能：首页管理查询处理 查询ig622信息
	 * 
	 * @param dto IGSYM18DTO
	 * @return IGSYM18DTO
	 */
	public IGSYM18DTO searchFirstJspInfoAction(IGSYM18DTO dto) throws BLException;

	/**
	 * 首页管理登记 插入ig622数据
	 *
	 *崔学志
	 *2012-11-14下午2:06:31
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM18DTO insertFirstJspInfoAction(IGSYM18DTO dto)throws BLException;
	/***
	 * 根据主键查询
	 *
	 *崔学志
	 *2012-11-14下午3:41:53
	 * @param dto
	 * @return
	 */
	public IGSYM18DTO searchFirstJspInfoByPKAction(IGSYM18DTO dto)throws BLException;
	/**
	 * 修改首页信息
	 *
	 *崔学志
	 *2012-11-14下午3:55:42
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM18DTO editFirstJspInfoAction(IGSYM18DTO dto)throws BLException;
	/**
	 *  首页信息删除
	 *
	 *崔学志
	 *2012-11-14下午4:19:20
	 * @param dto
	 * @throws BLException
	 */
	public IGSYM18DTO deleteFirstJspInfoAction(IGSYM18DTO dto)throws BLException;
	
}
