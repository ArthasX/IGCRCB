/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.dev.crc.report.jdbc.query;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ֵ��ѯDAO�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ReportValueQueryDAO {

	/**
	 * ��ѯ�����ֵ
	 * ͨ�����̶���ID��ȡ��XML�����ļ����ƣ�ͨ��XML�ļ�ȡ�ø����̶�Ӧ������ȡֵsql
	 * ͨ������ȡ�����еı�ֵ��װ��Map����
	 * ����ֵ��ʽ��key -- ��ȫ·����������������#��������#�������⣩
	 *            value -- ��ֵ���ϣ������Ƕ��У������Ǹ�List
	 * @param pdid ��������ID
	 * @return ��ֵ���
	 */
	public Map<String,List<String>> getValue(String pdid);
}
