/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * ����: ״̬�����߹����������Ͷ�����������ʵ��
  * ��������: ״̬�����߹����������Ͷ�����������ʵ��
  * ������¼: 2012/10/18
  * �޸ļ�¼: 
  */
public class IG911SearchCondImpl implements
		IG911SearchCond {
    
    /** ���� */
    protected String psprpid;

    /** ���̶���id */
    protected String pdid;

    /** ����״̬id */
    protected String psdid;

    /** �����߽�ɫid */
    protected Integer roleid;
    
    /** ����ģ��״̬��a���ã�iͣ�ã�t���ԣ�*/
    protected String[] ptstatuses;
    
    /**
     * ����ȡ��
     *
     * @return ����
     */
    public String getPsprpid() {
        return psprpid;
    }

    /**
     * �����趨
     *
     * @param psprpid ����
     */
    public void setPsprpid(String psprpid) {
        this.psprpid = psprpid;
    }

    /**
     * ���̶���idȡ��
     *
     * @return ���̶���id
     */
    public String getPdid() {
        return pdid;
    }

    /**
     * ���̶���id�趨
     *
     * @param pdid ���̶���id
     */
    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

    /**
     * ����״̬idȡ��
     *
     * @return ����״̬id
     */
    public String getPsdid() {
        return psdid;
    }

    /**
     * ����״̬id�趨
     *
     * @param psdid ����״̬id
     */
    public void setPsdid(String psdid) {
        this.psdid = psdid;
    }

    /**
     * �����߽�ɫidȡ��
     *
     * @return �����߽�ɫid
     */
    public Integer getRoleid() {
        return roleid;
    }

    /**
     * �����߽�ɫid�趨
     *
     * @param roleid �����߽�ɫid
     */
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    /**
     * @return the ����ģ��״̬��a���ã�iͣ�ã�t���ԣ�
     */
    public String[] getPtstatuses() {
        return ptstatuses;
    }

    /**
     * @param ����ģ��״̬��a���ã�iͣ�ã�t���ԣ� the ptstatuses to set
     */
    public void setPtstatuses(String[] ptstatuses) {
        this.ptstatuses = ptstatuses;
    }

}