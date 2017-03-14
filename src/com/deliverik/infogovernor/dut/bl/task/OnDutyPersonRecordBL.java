/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;
import com.deliverik.infogovernor.dut.model.condition.OnDutyPersonRecordSearchCond;
import com.deliverik.infogovernor.dut.model.entity.OnDutyPersonRecordTB;

/**
 * ����: �ճ�ά��taskbl
 * ��������: �ճ�ά��taskbl
 * ������¼: 2012/04/01
 * �޸ļ�¼: 
 */
public interface OnDutyPersonRecordBL extends BaseBL{

    /**
     * �ʲ������ʵ��ȡ��
     *
     * @return �ʲ������ʵ��
     */
    public OnDutyPersonRecordTB getOnDutyPersonRecordTBInstance();

    /**
     * ȫ������
     *
     * @return ���������
     */
    public List<OnDutyPersonRecordInfo> searchOnDutyPersonRecordALL();

    /**
     * ������������
     *
     * @param pk ����
     * @return �������
     */
    public OnDutyPersonRecordInfo searchOnDutyPersonRecordByPK(Integer pk)
        throws BLException;

    /**
     * ���������������ȡ��
     *
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(OnDutyPersonRecordSearchCond cond);

    /**
     * ������������
     *
     * @param cond ��������
     * @return ��������б�
     */
    public List<OnDutyPersonRecordInfo> searchOnDutyPersonRecord(
            OnDutyPersonRecordSearchCond cond);

    /**
     * ������������
     *
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<OnDutyPersonRecordInfo> searchOnDutyPersonRecord(
            OnDutyPersonRecordSearchCond cond, int start,
            int count);

    /**
     * ��������
     *
     * @param instance ����ʵ��
     * @return ����ʵ��
     */
    public OnDutyPersonRecordInfo registOnDutyPersonRecord(OnDutyPersonRecordInfo instance)
        throws BLException;

    /**
     * �޸Ĵ���
     *
     * @param instance �޸�ʵ��
     * @return �޸�ʵ��
     */
    public OnDutyPersonRecordInfo updateOnDutyPersonRecord(OnDutyPersonRecordInfo instance)
        throws BLException;

    /**
     * ɾ������
     *
     * @param pk ����
     */
    public void deleteOnDutyPersonRecordByPK(Integer pk)
        throws BLException;

    /**
     * ɾ������
     *
     * @param instance ɾ��ʵ��
     */
    public void deleteOnDutyPersonRecord(OnDutyPersonRecordInfo instance)
        throws BLException;
    
}
