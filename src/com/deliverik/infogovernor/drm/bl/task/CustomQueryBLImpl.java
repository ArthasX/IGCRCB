/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.dao.CustomQueryDAO;

/**
 * �������Զ����ѯͨ��BL ���������� ������¼��2016/8/10 �޸ļ�¼��
 */
public class CustomQueryBLImpl extends BaseBLImpl implements CustomQueryBL {

	private CustomQueryDAO customQueryDAO;

	public void setCustomQueryDAO(CustomQueryDAO customQueryDAO) {
		this.customQueryDAO = customQueryDAO;
	}

	public List<Map<String, Object>> queryBySql(String sql, Map<String, Type> resultField) throws BLException {
		return customQueryDAO.queryBySql(sql, resultField);
	}

}