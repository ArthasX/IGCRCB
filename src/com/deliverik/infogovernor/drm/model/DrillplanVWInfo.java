/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �����ƻ��ӿ�
  * ��������: �����ƻ��ӿ�
  * ������¼: 2015/02/28
  * �޸ļ�¼: 
  */
public interface DrillplanVWInfo extends BaseModel {

    public Integer getDiid();

    public Integer getDid() ;

    public Integer getPrid();

    public String getStatus() ;

    public String getExpecttime();

    public String getActstarttime();

    public String getDiname() ;

    public String getDicontant();

    public String getDidestination();

    public String getDiscene() ;

    public String getDiscope();

    public String getDidutyorg();
    
    public String getPartorg();

    public String getDuserid();

    public String getDusername() ;

    public String getCrttime() ;

    public String getJudgetime() ;

    public String getDserial() ;

    public String getDname();

    public String getJudgestatus();

   
}