/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.igflow.resultset;

/**
 * ���̻�����Ϣ
 */
public class ProcessRecord implements ProcessRecordInfo{
	
	/** ����ID */
	private Integer prid;
	
	/** ���̶������� */
	private String prpdname;
	
	/** ������ */
	private String prserialnum;
	
	/** ����ʱ�� */
	private String propentime;
	
	/** �ر�ʱ�� */
	private String prclosetime;
	
	/** �������� */
	private String prtitle;
	
	/** �������� */
	private String prdesc;
	
	/** ����״̬ */
	private String prstatus;

	/** ���ȼ� */
	private String prPriority;

	/** ���̶���ID */
	private String prpdid;
	
	/** �������� */
	private String prtype;
	
	/** �����ɫID */
	private Integer prroleid;
	
	/** �����û�ID */
	private String pruserid;
	
	/**
	 * ����IDȡ��
	 * @return ����ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����ID�趨
	 * @param prid ����ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * ���̶�������ȡ��
	 * @return ���̶�������
	 */
	public String getPrpdname() {
		return prpdname;
	}

	/**
	 * ���̶��������趨
	 * @param prpdname ���̶�������
	 */
	public void setPrpdname(String prpdname) {
		this.prpdname = prpdname;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPrserialnum() {
		return prserialnum;
	}

	/**
	 * �������趨
	 *
	 * @param prserialnum ������
	 */
	public void setPrserialnum(String prserialnum) {
		this.prserialnum = prserialnum;
	}

    /**
     * ����ʱ��ȡ��
     * @return ����ʱ��
     */
    public String getPropentime() {
        return propentime;
    }

    /**
     * ����ʱ���趨
     * @param propentime ����ʱ��
     */
    public void setPropentime(String propentime) {
        this.propentime = propentime;
    }

    /**
     * �ر�ʱ��ȡ��
     * @return �ر�ʱ��
     */
    public String getPrclosetime() {
        return prclosetime;
    }

    /**
     * �ر�ʱ���趨
     * @param prclosetime �ر�ʱ��
     */
    public void setPrclosetime(String prclosetime) {
        this.prclosetime = prclosetime;
    }

    /**
     * ��������ȡ��
     * @return ��������
     */
    public String getPrdesc() {
        return prdesc;
    }

    /**
     * ���������趨
     * @param prdesc ��������
     */
    public void setPrdesc(String prdesc) {
        this.prdesc = prdesc;
    }

    /**
     * ����״̬ȡ��
     * @return ����״̬
     */
    public String getPrstatus() {
        return prstatus;
    }

    /**
     * ����״̬�趨
     * @param prstatus ����״̬
     */
    public void setPrstatus(String prstatus) {
        this.prstatus = prstatus;
    }

    /**
     * ��������ȡ��
     * @return ��������
     */
    public String getPrtitle() {
        return prtitle;
    }

    /**
     * ���������趨
     * @param prtitle ��������
     */
    public void setPrtitle(String prtitle) {
        this.prtitle = prtitle;
    }
    
    /**
     * ���ȼ�ȡ��
     * @return ���ȼ�
     */
    public String getPrPriority() {
    	return prPriority;
    }

    /**
     * ���ȼ��趨
     * @param prPriority ���ȼ�
     */
	public void setPrPriority(String prPriority) {
		this.prPriority = prPriority;
	}

	/**
	 * ���̶���IDȡ��
	 * @return ���̶���ID
	 */
	public String getPrpdid() {
		return prpdid;
	}

	/**
	 * ���̶���ID�趨
	 * @param prpdid ���̶���ID
	 */
	public void setPrpdid(String prpdid) {
		this.prpdid = prpdid;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���������趨
	 * @param prtype ��������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * �����ɫIDȡ��
	 * @return prroleid �����ɫID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * �����ɫID�趨
	 * @param prroleid �����ɫID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * �����û�IDȡ��
	 * @return pruserid �����û�ID
	 */
	public String getPruserid() {
		return pruserid;
	}

	/**
	 * �����û�ID�趨
	 * @param pruserid �����û�ID
	 */
	public void setPruserid(String pruserid) {
		this.pruserid = pruserid;
	}
	
}
