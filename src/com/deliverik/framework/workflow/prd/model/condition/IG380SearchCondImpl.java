package com.deliverik.framework.workflow.prd.model.condition;


/**
 * �������Ͷ�����Ϣ��������ʵ��
 * 
 */
public class IG380SearchCondImpl implements IG380SearchCond{
	
	/** �������Ͷ���ID */
	protected String pdid;
	
	protected String[] pdid_in;
	protected String[] pdid_not_in;

	/** ����ģ��ID */
	protected Integer ptid;

	/** �������Ͷ������� */
	protected String pdname;

	/** �������Ͷ���״̬��a���ã�iͣ�ã�*/
	protected String pdstatus;
	
	/** ����ģ��ID����ƥ�䣩 */
	protected Integer notSelfPd;

	/** �Ƿ�Ϊ��ѯ��ʷ�汾 1����ʷ  0��ȫ�� */
	protected String searchHistory ;
	/**
	 * �Զ�������ģ��ȡ��
	 * @return ����ģ��ID
	 */
	public Integer[] PrTypeArray;
	
	public String[] pdstatuses;
	
	/** �������Ͷ���ID */
	protected String pdid_like;
	
	/**
	 * ������־Ȩ��
	 */
	protected String permission;
	
	   /**
     * һ�����̼�¼��������IDģ����ѯ
     */
    protected String[] prpdid_like_or;
    
    /** ���̷���λ�ò˵� */
    protected String actname;
	
	public String[] getPrpdid_like_or() {
        return prpdid_like_or;
    }


    public void setPrpdid_like_or(String[] prpdid_like_or) {
        this.prpdid_like_or = prpdid_like_or;
    }


	/**
	 * ������־Ȩ��ȡ��
	 * @return ������־Ȩ��
	 */
	public String getPermission() {
		return permission;
	}


	/**
	 * ������־Ȩ���趨
	  * @param permission ������־Ȩ��
	 */
	public void setPermission(String permission) {
		this.permission = permission;
	}
	

	/**
	 * �������Ͷ���IDȡ��
	 * @return �������Ͷ���ID
	 */
	public String getPdid() {
		return pdid;
	}
	
	/**
	 * ��������IDȡ���Զ������̺ͱ�׼����ID
	  * @param pdid �������Ͷ���ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * ����ģ��IDȡ��
	 * @return ����ģ��ID
	 */
	public Integer getPtid() {
		return ptid;
	}

	/**
	 * ����ģ��ID�趨
	  * @param ptid ����ģ��ID
	 */
	public void setPtid(Integer ptid) {
		this.ptid = ptid;
	}

	/**
	 * �������Ͷ�������ȡ��
	 * @return �������Ͷ�������
	 */
	public String getPdname() {
		return pdname;
	}

	/**
	 * �������Ͷ��������趨
	  * @param pdname �������Ͷ�������
	 */
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}

	/**
	 * �������Ͷ���״̬��a���ã�iͣ�ã�ȡ��
	 * @return �������Ͷ���״̬
	 */
	public String getPdstatus() {
		return pdstatus;
	}

	/**
	 * �������Ͷ���״̬��a���ã�iͣ�ã��趨
	  * @param pdstatus �������Ͷ���״̬
	 */
	public void setPdstatus(String pdstatus) {
		this.pdstatus = pdstatus;
	}

	/**
	 * ����ģ��ID����ƥ�䣩ȡ��
	 * @return ����ģ��ID
	 */
	public Integer getNotSelfPd() {
		return notSelfPd;
	}

	/**
	 * ����ģ��ID����ƥ�䣩�趨
	  * @param notSelfPd ����ģ��ID
	 */
	public void setNotSelfPd(Integer notSelfPd) {
		this.notSelfPd = notSelfPd;
	}

	public String[] getPdstatuses() {
		return pdstatuses;
	}

	public void setPdstatuses(String[] pdstatuses) {
		this.pdstatuses = pdstatuses;
	}

	public Integer[] getPrTypeArray() {
		return PrTypeArray;
	}

	public void setPrTypeArray(Integer[] prTypeArray) {
		PrTypeArray = prTypeArray;
	}


	public String getSearchHistory() {
		return searchHistory;
	}


	public void setSearchHistory(String searchHistory) {
		this.searchHistory = searchHistory;
	}

	/**
	 * �������Ͷ���IDȡ��
	 * 
	 * @return �������Ͷ���ID
	 */
	public String getPdid_like() {
		return pdid_like;
	}

	/**
	 * �������Ͷ���ID�趨
	 * 
	 * @param pdid_like �������Ͷ���ID
	 */
	public void setPdid_like(String pdid_like) {
		this.pdid_like = pdid_like;
	}

	/**
	 * ���̷���λ�ò˵�ȡ��
	 * @return  ���̷���λ�ò˵�  
	 */
    public String getActname() {
        return actname;
    }

    /**
     * ���̷����˵�λ���趨
     * @param actname ���̷���λ�ò˵�   
     */
    public void setActname(String actname) {
        this.actname = actname;
    }


	/**
	 * pdid_in   ȡ��
	 * @return pdid_in pdid_in
	 */
	public String[] getPdid_in() {
		return pdid_in;
	}
	
		/**
	 * pdid_in   �趨
	 * @param pdid_in pdid_in
	 */
	public void setPdid_in(String[] pdid_in) {
		this.pdid_in = pdid_in;
	}


	/**
	 * pdid_not_in   ȡ��
	 * @return pdid_not_in pdid_not_in
	 */
	public String[] getPdid_not_in() {
		return pdid_not_in;
	}


	/**
	 * pdid_not_in   �趨
	 * @param pdid_not_in pdid_not_in
	 */
	public void setPdid_not_in(String[] pdid_not_in) {
		this.pdid_not_in = pdid_not_in;
	}
	


}
