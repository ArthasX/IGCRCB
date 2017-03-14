package com.deliverik.infogovernor.drm.form;
/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����ƻ���Ŀ����Form
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM0604Form extends BaseForm{
  //id
    protected Integer did;

    /** �����ƻ��ƶ���id */
    protected String duserid;

    /** �����ƻ�ָ������ */
    protected String dusername;

    /** ����ʱ�� */
    protected String crttimestart;
    /** ����ʱ�� */
    protected String crttimeend;

    /** ����ʱ�� */
    protected String judgetimestart;
    /** ����ʱ�� */
    protected String judgetimeend;
    
    /**������id*/
    protected String judgeuserid;
    
    /**������username*/
    protected String judgeusername;

    /** �����ƻ���� */
    protected String dserial;

    /** �����ƻ����� */
    protected String dname;
    
    /**�Ƿ��Ǿ�������Ȩ��*/
    protected String isAdmin;
    
    /**����״̬*/
    protected String judgestatus;
    
    /**��������*/
    protected String diname;
    
    /**����Ԥ��ʱ��*/
    protected String expecttimestart;
    
    protected String expecttimeend;
    
    /** ���������� */
    protected String didutyorg;

    /** ���벿�� */
    protected String partorg;
    
    
    
    public String getDiname() {
        return diname;
    }

    public void setDiname(String diname) {
        this.diname = diname;
    }

    public String getExpecttimestart() {
        return expecttimestart;
    }

    public void setExpecttimestart(String expecttimestart) {
        this.expecttimestart = expecttimestart;
    }

    public String getExpecttimeend() {
        return expecttimeend;
    }

    public void setExpecttimeend(String expecttimeend) {
        this.expecttimeend = expecttimeend;
    }

    public String getDidutyorg() {
        return didutyorg;
    }

    public void setDidutyorg(String didutyorg) {
        this.didutyorg = didutyorg;
    }

    public String getPartorg() {
        return partorg;
    }

    public void setPartorg(String partorg) {
        this.partorg = partorg;
    }

    public String getJudgestatus() {
        return judgestatus;
    }

    public void setJudgestatus(String judgestatus) {
        this.judgestatus = judgestatus;
    }

    /**�Ƿ��Ǿ�������Ȩ��*/
    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }


    
    public String getJudgeuserid() {
        return judgeuserid;
    }

    public void setJudgeuserid(String judgeuserid) {
        this.judgeuserid = judgeuserid;
    }

    public String getJudgeusername() {
        return judgeusername;
    }

    public void setJudgeusername(String judgeusername) {
        this.judgeusername = judgeusername;
    }

    /**
     * �����ƻ�idȡ��
     *
     * @return �����ƻ�id
     */
    public Integer getDid() {
        return did;
    }

    /**
     * �����ƻ�id�趨
     *
     * @param did �����ƻ�id
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * �����ƻ��ƶ���idȡ��
     *
     * @return �����ƻ��ƶ���id
     */
    public String getDuserid() {
        return duserid;
    }

    /**
     * �����ƻ��ƶ���id�趨
     *
     * @param duserid �����ƻ��ƶ���id
     */
    public void setDuserid(String duserid) {
        this.duserid = duserid;
    }

    /**
     * �����ƻ�ָ������ȡ��
     *
     * @return �����ƻ�ָ������
     */
    public String getDusername() {
        return dusername;
    }

    /**
     * �����ƻ�ָ�������趨
     *
     * @param dusername �����ƻ�ָ������
     */
    public void setDusername(String dusername) {
        this.dusername = dusername;
    }



    /**
     * �����ƻ����ȡ��
     *
     * @return �����ƻ����
     */
    public String getDserial() {
        return dserial;
    }

    /**
     * �����ƻ�����趨
     *
     * @param dserial �����ƻ����
     */
    public void setDserial(String dserial) {
        this.dserial = dserial;
    }

    /**
     * �����ƻ�����ȡ��
     *
     * @return �����ƻ�����
     */
    public String getDname() {
        return dname;
    }

    /**
     * �����ƻ������趨
     *
     * @param dname �����ƻ�����
     */
    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getCrttimestart() {
        return crttimestart;
    }

    public void setCrttimestart(String crttimestart) {
        this.crttimestart = crttimestart;
    }

    public String getCrttimeend() {
        return crttimeend;
    }

    public void setCrttimeend(String crttimeend) {
        this.crttimeend = crttimeend;
    }

    public String getJudgetimestart() {
        return judgetimestart;
    }

    public void setJudgetimestart(String judgetimestart) {
        this.judgetimestart = judgetimestart;
    }

    public String getJudgetimeend() {
        return judgetimeend;
    }

    public void setJudgetimeend(String judgetimeend) {
        this.judgetimeend = judgetimeend;
    }
    
}
