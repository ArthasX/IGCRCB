/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.soc.asset.model.EntityItemUntreatedVWInfo;
import com.deliverik.framework.soc.asset.model.dao.EntityItemUntreatedVWDAO;


/**
 * ����:δ�ϼܻ��񡢿յ���ups��ͼBLʵ��
 * ��������: δ�ϼܻ��񡢿յ���ups��ͼBLʵ��
 * �����ˣ�����
 * ������¼: 2013/07/03
 * �޸ļ�¼: 
 */

public class EntityItemUntreatedVWBLImpl implements EntityItemUntreatedVWBL {

	/** ��Ʊ��������ͼDAO */
	protected EntityItemUntreatedVWDAO entityItemUntreatedVWDAO;

	public void setEntityItemUntreatedVWDAO(
			EntityItemUntreatedVWDAO entityItemUntreatedVWDAO) {
		this.entityItemUntreatedVWDAO = entityItemUntreatedVWDAO;
	}
	
	
	/**
	 * δ�ϼܻ��񡢿յ���ups�б�ȡ��
	 *
	 * @return list ��������б�
	 */
	public List<EntityItemUntreatedVWInfo> getToolsData(){
		return entityItemUntreatedVWDAO.getToolsData();
	}
}
