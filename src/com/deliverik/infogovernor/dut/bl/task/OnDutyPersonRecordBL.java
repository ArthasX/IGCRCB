/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;
import com.deliverik.infogovernor.dut.model.condition.OnDutyPersonRecordSearchCond;
import com.deliverik.infogovernor.dut.model.entity.OnDutyPersonRecordTB;

/**
 * 概述: 日常维修taskbl
 * 功能描述: 日常维修taskbl
 * 创建记录: 2012/04/01
 * 修改记录: 
 */
public interface OnDutyPersonRecordBL extends BaseBL{

    /**
     * 资产域定义表实例取得
     *
     * @return 资产域定义表实例
     */
    public OnDutyPersonRecordTB getOnDutyPersonRecordTBInstance();

    /**
     * 全件检索
     *
     * @return 检索结果集
     */
    public List<OnDutyPersonRecordInfo> searchOnDutyPersonRecordALL();

    /**
     * 主键检索处理
     *
     * @param pk 主键
     * @return 检索结果
     */
    public OnDutyPersonRecordInfo searchOnDutyPersonRecordByPK(Integer pk)
        throws BLException;

    /**
     * 条件检索结果件数取得
     *
     * @param cond 检索条件
     * @return 检索结果件数
     */
    public int getSearchCount(OnDutyPersonRecordSearchCond cond);

    /**
     * 条件检索处理
     *
     * @param cond 检索条件
     * @return 检索结果列表
     */
    public List<OnDutyPersonRecordInfo> searchOnDutyPersonRecord(
            OnDutyPersonRecordSearchCond cond);

    /**
     * 条件检索处理
     *
     * @param cond 检索条件
     * @param start 检索记录起始行号
     * @param count 检索记录件数
     * @return 检索结果列表
     */
    public List<OnDutyPersonRecordInfo> searchOnDutyPersonRecord(
            OnDutyPersonRecordSearchCond cond, int start,
            int count);

    /**
     * 新增处理
     *
     * @param instance 新增实例
     * @return 新增实例
     */
    public OnDutyPersonRecordInfo registOnDutyPersonRecord(OnDutyPersonRecordInfo instance)
        throws BLException;

    /**
     * 修改处理
     *
     * @param instance 修改实例
     * @return 修改实例
     */
    public OnDutyPersonRecordInfo updateOnDutyPersonRecord(OnDutyPersonRecordInfo instance)
        throws BLException;

    /**
     * 删除处理
     *
     * @param pk 主键
     */
    public void deleteOnDutyPersonRecordByPK(Integer pk)
        throws BLException;

    /**
     * 删除处理
     *
     * @param instance 删除实例
     */
    public void deleteOnDutyPersonRecord(OnDutyPersonRecordInfo instance)
        throws BLException;
    
}
