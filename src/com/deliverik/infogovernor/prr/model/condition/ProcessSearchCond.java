/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.model.condition;

import java.util.List;

import com.deliverik.framework.workflow.prd.model.IG110Info;
import com.deliverik.framework.workflow.prd.model.IG111Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ͨ�ò�ѯ��ѯ�����ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface ProcessSearchCond {

	/**
	 * ���̶���IDȡ��
	 * @return pdid ���̶���ID
	 */
	public String getPdid();

	/**
	 * ��ѯ������ʶȡ��
	 * @return queryKey ��ѯ������ʶ
	 */
	public String[] getQueryKey();

	/**
	 * ��ѯ����ֵȡ��
	 * @return queryValue ��ѯ����ֵ
	 */
	public String[] getQueryValue();
	
	/**
	 * ��ʾ�м���ȡ��
	 * @return showColumnList ��ʾ�м���
	 */
	public List<IG110Info> getShowColumnList();

	/**
	 * ��ѯ�������弯��ȡ��
	 * @return queryList ��ѯ�������弯��
	 */
	public List<IG111Info> getQueryList();

	/**
	 * ���̽����̶�ȡ��(��Ӧ������ΪӦ��ָ�������Ƿ������������ʶ)
	 * 
	 * @return
	 */
	public String getPrurgency();
}
