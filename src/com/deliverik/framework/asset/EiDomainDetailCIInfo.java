/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.asset;

import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BaseModel;

/**
 * ����: ����ϸ��Ϣ�ӿڣ�Ӱ��CI��
 * ��������: ����ϸ��Ϣ�ӿڣ�Ӱ��CI��
 * ������¼: 2011/05/25
 * �޸ļ�¼: 
 */
public interface EiDomainDetailCIInfo extends BaseModel {
	
	public Integer getDomainid();
	
	public Integer getDomainversion() ;
	
	public String getName();
	
	public String getEiname() ;
	
	public Integer getEiversion() ;
	
	public String getEiupdtime() ;
	
	public Integer getEiid() ;
	
	public IG013TB getEntityItemTB();

}
