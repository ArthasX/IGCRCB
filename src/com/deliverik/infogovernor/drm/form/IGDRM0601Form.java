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
 * Description: �����ƻ��Ǽ�/�޸�Form
 * </p>
 * 
 * @author sunkaiyu@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGDRM0601Form extends BaseForm{
    protected Integer did;
    
    /** ����id */
    protected String[] diid;

    /** �����ƻ��ƶ���id */
    protected String duserid;

    /** �����ƻ�ָ������ */
    protected String dusername;

    /** ����ʱ�� */
    protected String crttime;

    /** ����ʱ�� */
    protected String judgetime;

    /** �����ƻ���� */
    protected String dserial;

    /** �����ƻ����� */
    protected String dname;

    /** ����״̬ a Ϊ����b�����У�c������� */
    protected String judgestatus;

    /** ���� */
    protected String depict;
    
    /**������userid*/
    protected String judgeuserid;

    /**������username*/
    protected String judgeusername;
    
    /** �������� */
    protected String[] diname;
    
    /** ����Ԥ�ڿ�ʼʱ�� */
    protected String[] expecttime;
    
    /** ���������� */
    protected String[] didutyorg;
    
    /** ���벿�� */
    protected String[] partorg;
    
    /** �������� */
    protected String[] dicontant;

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
	 * diidȡ��
	 *
	 * @return diid diid
	 */
	public String[] getDiid() {
		return diid;
	}

	/**
	 * diid�趨
	 *
	 * @param diid diid
	 */
	public void setDiid(String[] diid) {
		this.diid = diid;
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
     * ����ʱ��ȡ��
     *
     * @return ����ʱ��
     */
    public String getCrttime() {
        return crttime;
    }

    /**
     * ����ʱ���趨
     *
     * @param crttime ����ʱ��
     */
    public void setCrttime(String crttime) {
        this.crttime = crttime;
    }

    /**
     * ����ʱ��ȡ��
     *
     * @return ����ʱ��
     */
    public String getJudgetime() {
        return judgetime;
    }

    /**
     * ����ʱ���趨
     *
     * @param judgetime ����ʱ��
     */
    public void setJudgetime(String judgetime) {
        this.judgetime = judgetime;
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

    /**
     * ����״̬ a Ϊ����b�����У�c�������ȡ��
     *
     * @return ����״̬ a Ϊ����b�����У�c�������
     */
    public String getJudgestatus() {
        return judgestatus;
    }

    /**
     * ����״̬ a Ϊ����b�����У�c��������趨
     *
     * @param judgestatus ����״̬ a Ϊ����b�����У�c�������
     */
    public void setJudgestatus(String judgestatus) {
        this.judgestatus = judgestatus;
    }

    /**
     * ����ȡ��
     *
     * @return ����
     */
    public String getDepict() {
        return depict;
    }

    /**
     * �����趨
     *
     * @param depict ����
     */
    public void setDepict(String depict) {
        this.depict = depict;
    }

	/**
	 * dinameȡ��
	 *
	 * @return diname diname
	 */
	public String[] getDiname() {
		return diname;
	}

	/**
	 * diname�趨
	 *
	 * @param diname diname
	 */
	public void setDiname(String[] diname) {
		this.diname = diname;
	}

	/**
	 * expecttimeȡ��
	 *
	 * @return expecttime expecttime
	 */
	public String[] getExpecttime() {
		return expecttime;
	}

	/**
	 * expecttime�趨
	 *
	 * @param expecttime expecttime
	 */
	public void setExpecttime(String[] expecttime) {
		this.expecttime = expecttime;
	}

	/**
	 * didutyorgȡ��
	 *
	 * @return didutyorg didutyorg
	 */
	public String[] getDidutyorg() {
		return didutyorg;
	}

	/**
	 * didutyorg�趨
	 *
	 * @param didutyorg didutyorg
	 */
	public void setDidutyorg(String[] didutyorg) {
		this.didutyorg = didutyorg;
	}

	/**
	 * partorgȡ��
	 *
	 * @return partorg partorg
	 */
	public String[] getPartorg() {
		return partorg;
	}

	/**
	 * partorg�趨
	 *
	 * @param partorg partorg
	 */
	public void setPartorg(String[] partorg) {
		this.partorg = partorg;
	}

	/**
	 * dicontantȡ��
	 *
	 * @return dicontant dicontant
	 */
	public String[] getDicontant() {
		return dicontant;
	}

	/**
	 * dicontant�趨
	 *
	 * @param dicontant dicontant
	 */
	public void setDicontant(String[] dicontant) {
		this.dicontant = dicontant;
	}

}
