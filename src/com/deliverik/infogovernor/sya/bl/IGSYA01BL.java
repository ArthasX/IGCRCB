/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sya.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sya.dto.IGSYA01DTO;

/**
 * 绩效考核业务逻辑接口
 *
 *	@author zhaomin@deliverik.com
 */
public interface IGSYA01BL extends BaseBL {


    /**
     *  绩效考核查询处理
     *
     * @param dto IGSVC19DTO
     * 
     * 
     * @return IGSVC19DTO
     */
    public IGSYA01DTO search(IGSYA01DTO dto) throws BLException;
    
    /**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IGSYA01DTO regist(IGSYA01DTO dto) throws BLException;
	
	public IGSYA01DTO init(IGSYA01DTO dto) throws BLException ;
	
	/**
	 * <p>
	 * Description: 变更
	 * </p>
	 * 
	 * @param dto IGSVC19DTO
	 * @return IGSVC19DTO
	 * @throws BLException
	 * @update
	 */
	public IGSYA01DTO update(IGSYA01DTO dto) throws BLException;
	
	 /**
     * 删除
     */
    public IGSYA01DTO deleteTrain(IGSYA01DTO dto)throws BLException;
        
}
