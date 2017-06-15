/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * @Description:��������Cond�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface KnowledgeSearchCond {
	
	/**
	 *���
	 */
	public Integer getKnid();
	
	
	/**
	 *���
	 */
	public String getKnserial();

	/**
	 *����
	 */
	public String getKndepartment();

	/**
	 *�鵵��
	 */
	public String getKnapprover();


	/**
	 *����
	 */
	public String getKnclass();

	/**
	 *�ؼ���
	 */
	public String getKnkey();

	/**
	 *��Դ
	 */
	public String getKnorigin();

	/**
	 *֪ʶ������
	 */
	public String getKnproffer();


	/**
	 *����
	 */
	public String getKntitle();

	/**
	 *��������
	 */
	public String getKndes();

	/**
	 *����ԭ���ܽ�
	 */
	public String getKnfaultcause();

	/**
	 *����취
	 */
	public String getKnsolveway();

	/**
	 *״̬
	 */
	public String getKnstatus();
	
	/**
	 *�ؼ�������ȡ��
	 * 
	 * @return �ؼ�������
	 */
	public String[] getKnkeys();
	
	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String[] getKntitles();
	
	/**
	 *�鵵������ȡ��
	 * 
	 * @return �鵵������
	 */
	public String getKnapprovername();
	
	/**
	 *֪ʶ����������ȡ��
	 * 
	 * @return ֪ʶ����������
	 */
	public String getKnproffername() ;
	
	/**
	 *�鵵ʱ���ȡ��
	 * 
	 * @return �鵵ʱ���
	 */
	public String getKnapprovetime_f();
	/**
	 *�鵵ʱ�䵽ȡ��
	 * 
	 * @return �鵵ʱ�䵽
	 */
	public String getKnapprovetime_t();
	
	/**
	 *����ʱ���ȡ��
	 * 
	 * @return ����ʱ���
	 */
	public String getKnproffertime_f();
	
	/**
	 *����ʱ�䵽ȡ��
	 * 
	 * @return ����ʱ�䵽
	 */
	public String getKnproffertime_t() ;
	
	/**
	 *ҵ������ȡ��
	 * 
	 * @return ҵ������
	 */
	public String getKnarea();
	public String getSystemid();
	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKntelarea();
	
	public Integer getKnapproverole() ;

	public Integer[] getKnapproveroles();
	
	/**
	 *֪ʶ���ȡ��
	 * 
	 * @return ֪ʶ���
	 */
	public String getKnserial_like();
	public String getSing();
	public String getSelectstatus();
	public String getOrder();
	
	public String getKnclass_like();
}
