/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: �����ƻ����������ӿ�
  * ��������: �����ƻ����������ӿ�
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
public interface DrillplanSearchCond {
    
    /**
     * 
     * @Title: getJudgeuserid 
     * @Description: TODO ������useridȡ��
     * @return    
     * String    
     * @throws
     */
    public String getJudgeuserid();
    /**
     * 
     * @Title: getJudgeusername 
     * @Description: TODO ������usernameȡ��
     * @return    
     * String    
     * @throws
     */
    public String getJudgeusername();

    /**
     * �����ƻ�idȡ��
     *
     * @return �����ƻ�id
     */
    public Integer getDid() ;

    /**
     * �����ƻ��ƶ���idȡ��
     *
     * @return �����ƻ��ƶ���id
     */
    public String getDuserid();

    /**
     * �����ƻ�ָ������ȡ��
     *
     * @return �����ƻ�ָ������
     */
    public String getDusername();


    /**
     * �����ƻ����ȡ��
     *
     * @return �����ƻ����
     */
    public String getDserial();

    /**
     * �����ƻ�����ȡ��
     *
     * @return �����ƻ�����
     */
    public String getDname() ;
    //����ʱ���
    public String getCrttimestart();
    //����ʱ�䵽
    public String getCrttimeend(); 
    //����ʱ���
    public String getJudgetimestart();
    //����ʱ�䵽
    public String getJudgetimeend();
    /**�Ƿ��Ǿ�������Ȩ��*/
    public String getIsAdmin();
    /**����״̬*/
    public String getJudgestatus() ;
	/**
	 * serial_like   ȡ��
	 * @return serial_like serial_like
	 */
	public String getSerial_like() ;
	
	/**
	 * judgestatus_neȡ��
	 *
	 * @return judgestatus_ne judgestatus_ne
	 */
	public String getJudgestatus_ne();
	
	/**  
	 * ��ȡ��ʼʱ��  
	 * @return propentime ��ʼʱ��  
	 */
	public String getPropentime();
	
	/**  
	 * ��ȡ����ʱ��  
	 * @return prclosetime ����ʱ��  
	 */
	
	public String getPrclosetime();
}