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
public interface DrillplanVWSearchCond {
    
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
    
    //��������  
    public String getDiname();
    //Ԥ��ʱ�� ��
    public String getExpecttimestart() ;
    //��
    public String getExpecttimeend() ;
    //������    
    public String getDidutyorg();
    //���벿��
    public String getPartorg() ;
    
	/**
	 * judgestatus_neȡ��
	 *
	 * @return judgestatus_ne judgestatus_ne
	 */
	public String getJudgestatus_ne();
}