/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * ����: �����ƻ���Ŀ���������ӿ�
  * ��������: �����ƻ���Ŀ���������ӿ�
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
public interface DrillplanitemSearchCond {

    public Integer getDid() ;

    public Integer getPrid();

    public String getStatus() ;

    public String getExpecttimestart() ;

    public String getExpecttimeend();

    public String getDiname() ;

    public String getDicontant();

    public String getDidestination() ;

    public String getDiscene();

    public String getDiscope();

    public String getDidutyorg() ;

    public String getPartorg();
    
}