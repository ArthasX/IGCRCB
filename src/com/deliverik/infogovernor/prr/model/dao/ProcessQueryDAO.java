/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.model.dao;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ͨ�ò�ѯ�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ProcessQueryDAO {

	/**
	 * ȡ�ò�ѯ����
	 * @param sql ִ��sql
	 * @return ��ѯ����
	 */
	public int getSearchCount(String sql);

	/**
	 * ���̲�ѯ����
	 * @param sql ִ��sql
	 * @param start ��ʼҳ��
	 * @param count ��ʾ����
	 * @return ������Ϣ����
	 */
	public List<Map<String, Object>> searchProcessRecordInfo(String sql, int start, int count);

}
