/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.csebank.lom.model;



/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ʳ�ù���_ͳ�ƻ���_����������ͳ����ϢMODEL
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */
public interface WorkLunchEatery {
	
	/**
	 * ����
	 * @return ����
	 */
	public String getWldate();
	
	/**
	 * �ɱ��ϼ�
	 * @return �ɱ��ϼ�
	 */
	public String getAllcost();
	
	/**
	 * ��ζƷ�ɱ�
	 * @return eflavouringcost ��ζƷ�ɱ�
	 */
	public String getEflavouringcost();
	
	/**
	 * �ɹ�ԭ�ϳɱ�
	 * @return �ɹ�ԭ�ϳɱ�
	 */
	public String getEstaplecost();
	
	/**
	 * �����ɱ�
	 * @return �����ɱ�
	 */
	public String getEothercost();
	
	public String getLunchcardname();
	
	public String getLunchcardnum();
	
	public String getIncost();
	
	public String getOutcost();
	
	public void setWldate(String wldate);
	
	public void setAllcost(String allcost);
	
	public void setEflavouringcost(String eflavouringcost);
	
	public void setEstaplecost(String estaplecost);
	
	public void setEothercost(String eothercost);
	
	public void setLunchcardname(String lunchcardname);
	
	public void setLunchcardnum(String lunchcardnum);
	
	public void setIncost(String incost);
	
	public void setOutcost(String outcost);
	
	public String getLunchcardprice();
	
	public void setLunchcardprice(String lunchcardprice);
	

}