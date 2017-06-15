/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.dao.ParentNodeDAO;

/**
 * ��������ȡ����ĸ��ڵ�BL
 * ����������
 * ������¼��2014/05/19
 * �޸ļ�¼��
 */
public class ParentNodeBLImpl extends BaseBLImpl implements ParentNodeBL {
	
	private ParentNodeDAO parentNodeDao;
	
	public void setParentNodeDao(ParentNodeDAO parentNodeDao) {
		this.parentNodeDao = parentNodeDao;
	}

	/**
	 * ͨ������id��ȡ��ǰ�ڵ���Ϣ
	 */
	public List<Map<String,Object>> getParentNodes(String psdid) {
		return parentNodeDao.searchParentNodes(psdid);
	}
}