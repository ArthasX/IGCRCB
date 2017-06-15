/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.bl;

import java.text.ParseException;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.dto.IGSYM19DTO;
/**
 * 概述:服务流程有效时间计算业务逻辑接口
 * 功能描述：服务流程有效时间计算
 * 创建记录：张楠    2011/10/18
 */
public interface IGSYM19BL extends BaseBL{
	/**
	 * 作息日期查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM19DTO searchProcessWorkTimeTemplate(IGSYM19DTO dto) throws BLException;
	/**
	 * 作息日期新增
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM19DTO insertProcessWorkTimeTemplateAction(IGSYM19DTO dto) throws BLException;
	/**
	 * 作息日期变更
	 * @param dto
	 * @return
	 * @throws BLException
	 * @throws ParseException 
	 */
	public IGSYM19DTO updateProcessWorkTimeTemplateAction(IGSYM19DTO dto) throws BLException, ParseException;

	/**
	 * 用户作息日期查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGSYM19DTO searchProcessWorkTimeCount(IGSYM19DTO dto) throws BLException;
	
	/**
	 * 作息日期模板主键检索
	 * @param dto
	 * @return
	 */
	public IGSYM19DTO searchProcessWorkTimeTemplateByPK(IGSYM19DTO dto) throws BLException;
}
