/*
 * ��������������������޹�˾��
 */
package com.deliverik.plugin.PluginMgr.bl;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.plugin.PluginMgr.dto.IGPluginDTO;

/**
 * ����: �������ӿ�
 * ��������: �������ӿ�
 * ������¼: 2012-11-5
 * �޸ļ�¼: 
 */
public interface IGPluginMgrBL extends BaseBL {
	//��ѯ����б�
	public IGPluginDTO getPluginList(IGPluginDTO dto)throws BLException;
	//���Ĳ��״̬
	public IGPluginDTO modifyPlugin(IGPluginDTO dto)throws BLException;
	//���²������
	public IGPluginDTO updatePluginDataXml(IGPluginDTO dto)throws BLException, Exception;
}
