/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * ����: ������ֵ���������ʵ��
  * ��������: ������ֵ���������ʵ��
  * ������¼: 2013/06/25
  * �޸ļ�¼: 
  */
public class IG898SearchCondImpl implements IG898SearchCond {

	/** �������� */
	protected Integer prid;
	
	/** �������������� */
	protected String pidid;
	
	/** ������ */
	protected String pidname;
	
	/** �к� */
	protected String rownumber;

	/**����*/
	protected String pvcolname;
	
	/** ��ֵ */
	protected String pvalue;
	
	public String getPvalue() {
		return pvalue;
	}

	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}

	/**  
	 * ��ȡpvcolname  
	 * @return pvcolname 
	 */
	public String getPvcolname() {
		return pvcolname;
	}

	/**  
	 * ����pvcolname  
	 * @param pvcolname
	 */
	
	public void setPvcolname(String pvcolname) {
		this.pvcolname = pvcolname;
	}

	/**
	 * ��������ȡ��
	 * @return prid ��������
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ���������趨
	 * @param prid ��������
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ��������������ȡ��
	 * @return pidid ��������������
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ���������������趨
	 * @param pidid ��������������
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
     * ������ȡ��
     * @return pidname ������
     */
    public String getPidname() {
        return pidname;
    }

    /**
     * �������趨
     * @param pidname ������
     */
    public void setPidname(String pidname) {
        this.pidname = pidname;
    }

	/**
	 * �к�ȡ��
	 * @return rownumber �к�
	 */
	public String getRownumber() {
		return rownumber;
	}

	/**
	 * �к��趨
	 * @param rownumber �к�
	 */
	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}
}