/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: �ճ�ά��taskblʵ��
 * ��������: �ճ�ά��taskblʵ��
 * ������¼: 2012/04/01
 * �޸ļ�¼: 
 */
public class OnDutyPersonRecordBLImpl extends BaseBLImpl implements OnDutyPersonRecordBL{

    /** OnDutyPersonRecord DAO */
    protected OnDutyPersonRecordDAO onDutyPersonRecordDAO;
    
    /**
     * ɾ��ʵ��
     *
     * @param instance
     * @throws BLException
     */
    public void deleteOnDutyPersonRecord(OnDutyPersonRecordInfo instance)
            throws BLException {
       onDutyPersonRecordDAO.delete(instance);
        
    }

    /**
     * ������ɾ��
     *
     * @param pk
     * @throws BLException
     */
    public void deleteOnDutyPersonRecordByPK(Integer pk) throws BLException {
        OnDutyPersonRecordInfo onDutyPersonRecordInfo = checkExistDutyPerson(pk);
        onDutyPersonRecordDAO.delete(onDutyPersonRecordInfo);
        
    }

    /**
     * ʵ��ȡ��
     *
     * @return
     */
    public OnDutyPersonRecordTB getOnDutyPersonRecordTBInstance() {
        return new OnDutyPersonRecordTB();
    }

    /**
     * �����������ȡ��
     *
     * @param cond
     * @return
     */
    public int getSearchCount(OnDutyPersonRecordSearchCond cond) {
        return onDutyPersonRecordDAO.getSearchCount(cond);
    }

    /**
     * ��Ӵ���
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
     * ȫ������
     *
     * @return
     */
    public List<OnDutyPersonRecordInfo> searchOnDutyPersonRecordALL() {
        return onDutyPersonRecordDAO.findAll();
    }

    /**
     * ����������
     *
     * @param cond
     * @return
     */
    public List<OnDutyPersonRecordInfo> searchOnDutyPersonRecord(
            OnDutyPersonRecordSearchCond cond) {
        return onDutyPersonRecordDAO.findByCond(cond, 0, 0);
    }

    /**
     * ����������
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
     * ����������
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
     * �������
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
     * �ճ�ά����Ϣ���ڼ��
     * 
     * @param instance �ճ�ά��ID
     * @return �ճ�ά������Ϣ
     * @throws BLException 
     */
    protected OnDutyPersonRecordInfo checkExistDutyPerson(Integer ODPRID) throws BLException{
        OnDutyPersonRecordInfo info = onDutyPersonRecordDAO.findByPK(ODPRID);
        if( info == null) {
            throw new BLException("IGCO10000.E004","ά�ޱ���Ŀ");
        }
        return info;
        }

    /**
     * OnDutyPersonRecordDAOȡ��
     *
     * @return onDutyPersonRecordDAO OnDutyPersonRecordDAO
     */
    public OnDutyPersonRecordDAO getOnDutyPersonRecordDAO() {
        return onDutyPersonRecordDAO;
    }

    /**
     * OnDutyPersonRecordDAO�趨
     *
     * @param onDutyPersonRecordDAO OnDutyPersonRecordDAO
     */
    public void setOnDutyPersonRecordDAO(OnDutyPersonRecordDAO onDutyPersonRecordDAO) {
        this.onDutyPersonRecordDAO = onDutyPersonRecordDAO;
    }

}
