/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.dut.model.DutyPerson;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;
import com.deliverik.infogovernor.dut.model.condition.OnDutyPersonRecordSearchCond;
import com.deliverik.infogovernor.dut.model.dao.DutyPersonDAO;
import com.deliverik.infogovernor.dut.model.dao.OnDutyPersonRecordDAO;
import com.deliverik.infogovernor.dut.model.entity.OnDutyPersonRecordTB;

/**
 * 概述: 日常维修taskbl实现
 * 功能描述: 日常维修taskbl实现
 * 创建记录: 2012/04/01
 * 修改记录: 
 */
public class OnDutyPersonRecordBLImpl extends BaseBLImpl implements OnDutyPersonRecordBL{

    /** OnDutyPersonRecord DAO */
    protected OnDutyPersonRecordDAO onDutyPersonRecordDAO;
    
    /**
     * 删除实例
     *
     * @param instance
     * @throws BLException
     */
    public void deleteOnDutyPersonRecord(OnDutyPersonRecordInfo instance)
            throws BLException {
       onDutyPersonRecordDAO.delete(instance);
        
    }

    /**
     * 按主键删除
     *
     * @param pk
     * @throws BLException
     */
    public void deleteOnDutyPersonRecordByPK(Integer pk) throws BLException {
        OnDutyPersonRecordInfo onDutyPersonRecordInfo = checkExistDutyPerson(pk);
        onDutyPersonRecordDAO.delete(onDutyPersonRecordInfo);
        
    }

    /**
     * 实例取得
     *
     * @return
     */
    public OnDutyPersonRecordTB getOnDutyPersonRecordTBInstance() {
        return new OnDutyPersonRecordTB();
    }

    /**
     * 检索结果件数取得
     *
     * @param cond
     * @return
     */
    public int getSearchCount(OnDutyPersonRecordSearchCond cond) {
        return onDutyPersonRecordDAO.getSearchCount(cond);
    }

    /**
     * 添加处理
     *
     * @param instance
     * @return
     * @throws BLException
     */
    public OnDutyPersonRecordInfo registOnDutyPersonRecord(
            OnDutyPersonRecordInfo instance) throws BLException {
        return onDutyPersonRecordDAO.save(instance);
    }

    /**
     * 全件检索
     *
     * @return
     */
    public List<OnDutyPersonRecordInfo> searchOnDutyPersonRecordALL() {
        return onDutyPersonRecordDAO.findAll();
    }

    /**
     * 按条件检索
     *
     * @param cond
     * @return
     */
    public List<OnDutyPersonRecordInfo> searchOnDutyPersonRecord(
            OnDutyPersonRecordSearchCond cond) {
        return onDutyPersonRecordDAO.findByCond(cond, 0, 0);
    }

    /**
     * 按条件检索
     *
     * @param cond
     * @param start
     * @param count
     * @return
     */
    public List<OnDutyPersonRecordInfo> searchOnDutyPersonRecord(
            OnDutyPersonRecordSearchCond cond, int start, int count) {
        return onDutyPersonRecordDAO.findByCond(cond, start, count);
    }

    /**
     * 按主键检索
     *
     * @param pk
     * @return
     * @throws BLException
     */
    public OnDutyPersonRecordInfo searchOnDutyPersonRecordByPK(Integer pk)
            throws BLException {
        return onDutyPersonRecordDAO.findByPK(pk);
    }

    /**
     * 变更处理
     *
     * @param instance
     * @return
     * @throws BLException
     */
    public OnDutyPersonRecordInfo updateOnDutyPersonRecord(
            OnDutyPersonRecordInfo instance) throws BLException {
        OnDutyPersonRecordInfo onDutyPersonRecordInfo = checkExistDutyPerson(instance.getOdprid());
        return onDutyPersonRecordDAO.save(onDutyPersonRecordInfo);
    }
    
    /**
     * 日常维修信息存在检查
     * 
     * @param instance 日常维修ID
     * @return 日常维修项信息
     * @throws BLException 
     */
    protected OnDutyPersonRecordInfo checkExistDutyPerson(Integer ODPRID) throws BLException{
        OnDutyPersonRecordInfo info = onDutyPersonRecordDAO.findByPK(ODPRID);
        if( info == null) {
            throw new BLException("IGCO10000.E004","维修表条目");
        }
        return info;
        }

    /**
     * OnDutyPersonRecordDAO取得
     *
     * @return onDutyPersonRecordDAO OnDutyPersonRecordDAO
     */
    public OnDutyPersonRecordDAO getOnDutyPersonRecordDAO() {
        return onDutyPersonRecordDAO;
    }

    /**
     * OnDutyPersonRecordDAO设定
     *
     * @param onDutyPersonRecordDAO OnDutyPersonRecordDAO
     */
    public void setOnDutyPersonRecordDAO(OnDutyPersonRecordDAO onDutyPersonRecordDAO) {
        this.onDutyPersonRecordDAO = onDutyPersonRecordDAO;
    }

}
