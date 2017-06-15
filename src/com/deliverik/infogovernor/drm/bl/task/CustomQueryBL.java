/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;
import java.util.Map;

import org.hibernate.type.Type;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * ������ ͨ���Զ����ѯ�ӿ� ����������ͨ���Զ����ѯ�ӿ� ������¼��2016/8/10 �޸ļ�¼��
 */
public interface CustomQueryBL extends BaseBL {

	/**
	 * ͨ�ò�ѯ����
	 * 
	 * @param sql
	 *            sql���,����ֱ��ƴ��
	 * @param resultField
	 *            ���ؽ����Map�ֶ����� key=�ֶ���,value=�ֶ�����(org.hibernate.type.Type)
	 * @return
	 * @throws BLException
	 */
	public List<Map<String, Object>> queryBySql(String sql, Map<String, Type> resultField) throws BLException;
}