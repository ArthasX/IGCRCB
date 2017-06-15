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
 * Description: �����ƻ�����Form
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM0602Form extends BaseForm{
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

    /**�������*/
    protected String dopinion;
    
    /**�Ƿ��Ǿ�������Ȩ��*/
    protected String isAdmin;
    
    /**����״̬*/
    protected String judgestatus;
    /**�����Ƿ�ͨ��*/
    protected String isthrough;
    /**��ʼʱ��*/
	protected String propentime;
	
	/**����ʱ��*/
	protected String prclosetime;

    public String getIsthrough() {
        return isthrough;
    }

    public void setIsthrough(String isthrough) {
        this.isthrough = isthrough;
    }

    /**����״̬*/
    public String getJudgestatus() {
        return judgestatus;
    }

    public void setJudgestatus(String judgestatus) {
        this.judgestatus = judgestatus;
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getDopinion() {
        return dopinion;
    }

    public void setDopinion(String dopinion) {
        this.dopinion = dopinion;
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

	/**  
	 * ��ȡ��ʼʱ��  
	 * @return propentime ��ʼʱ��  
	 */
	
	public String getPropentime() {
		return propentime;
	}

	/**  
	 * ���ÿ�ʼʱ��  
	 * @param propentime ��ʼʱ��  
	 */
	
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**  
	 * ��ȡ����ʱ��  
	 * @return prclosetime ����ʱ��  
	 */
	
	public String getPrclosetime() {
		return prclosetime;
	}

	/**  
	 * ���ý���ʱ��  
	 * @param prclosetime ����ʱ��  
	 */
	
	public void setPrclosetime(String prclosetime) {
		this.prclosetime = prclosetime;
	}
    
}
