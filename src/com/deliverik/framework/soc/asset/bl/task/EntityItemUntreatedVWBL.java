/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.EntityItemUntreatedVWInfo;

/**
 * ����:δ�ϼܻ��񡢿յ���ups��ͼBL�ӿ�
 * ��������: δ�ϼܻ��񡢿յ���ups��ͼBL�ӿ�
 * �����ˣ�����
 * ������¼: 2013/07/03
 * �޸ļ�¼: 
 */

public interface EntityItemUntreatedVWBL extends BaseBL {

	/**
	 * δ�ϼܻ��񡢿յ���ups�б�ȡ��
	 *
	 * @return list ��������б�
	 */
	public List<EntityItemUntreatedVWInfo> getToolsData();
	
}
