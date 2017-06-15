/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dbm.dto.IGDBM13DTO;

/**
 * @概述 工作管理 BL
 */

public interface IGDBM13BL extends BaseBL {

    /** 工作管理信息查询
     * @param dto
     */
    public IGDBM13DTO searchWorkmanagerInfos(IGDBM13DTO dto) throws BLException;
    
    /**
     * 新增工作信息
     */
    public IGDBM13DTO addWorkmanagerInfo(IGDBM13DTO dto) throws BLException;
    
    /**
     * 更新工作信息
     */
    public IGDBM13DTO updateWorkmanagerInfo(IGDBM13DTO dto) throws BLException;
    
	/**
	 * <p>
	 * Description: 工作信息登记初始化
	 * </p>
	 */
	public IGDBM13DTO dispWorkmanagerInfoAction(IGDBM13DTO dto) throws BLException;
	
	 /** 工作信息复制
     * @param dto
     */
    public void copyWorkmanagerInfo(IGDBM13DTO dto) throws BLException;
    
    /**
     * 编辑工作信息
     */
    public IGDBM13DTO editWorkmanagerInfo(IGDBM13DTO dto) throws BLException;
    
    /**
     * 更新工作信息
     */
    public IGDBM13DTO updateWorkmanager(IGDBM13DTO dto) throws BLException;
    
    /**
     * 更新工作信息状态
     */
    public IGDBM13DTO updateWorkmanagerInfoRemind(IGDBM13DTO dto) throws BLException;
    
    /** 工作管理信息导出查询
     * @param dto
     */
    public IGDBM13DTO exportWorkmanagerInfos(IGDBM13DTO dto) throws BLException;
    
    /** 查询每日待处理工作
     * @param dto
     */
    public IGDBM13DTO searchDealWorkmanagerInfos(IGDBM13DTO dto) throws BLException;
    
    //插入每日查询待处理工作定时任务
    public void insertEveryDayjob() throws BLException;
    
  //删除每日查询待处理工作定时任务
    public void delEveryDayjob() throws BLException;
	/**
	 * <p>
	 * Description: 工作信息编辑初始化
	 * </p>
	 */
	public IGDBM13DTO editWorkmanagerInfoAction(IGDBM13DTO dto) throws BLException;
}
