/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sta.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.sta.model.Contract;



@SuppressWarnings("serial")
public class IGSTA01031VO extends BaseVO implements Serializable {

  /**��ͬͳ����Ϣ*/
  protected List<Contract> contracts;
  
  /** ��ͬ��Ϣ������� */
  protected List<IG499Info> entityItemCompactVWInfoList;

/**
 * ��ͬͳ����Ϣȡ��
 *
 * @return contracts ��ͬͳ����Ϣ
 */
public List<Contract> getContracts() {
    return contracts;
}

/**
 * ��ͬͳ����Ϣ�趨
 *
 * @param contracts ��ͬͳ����Ϣ
 */
public void setContracts(List<Contract> contracts) {
    this.contracts = contracts;
}

/**
 * ��ͬ��Ϣ�������ȡ��
 *
 * @return entityItemCompactVWInfoList ��ͬ��Ϣ�������
 */
public List<IG499Info> getEntityItemCompactVWInfoList() {
    return entityItemCompactVWInfoList;
}

/**
 * ��ͬ��Ϣ��������趨
 *
 * @param entityItemCompactVWInfoList ��ͬ��Ϣ�������
 */
public void setEntityItemCompactVWInfoList(List<IG499Info> entityItemCompactVWInfoList) {
    this.entityItemCompactVWInfoList = entityItemCompactVWInfoList;
}
  
}
