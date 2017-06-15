/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.kgm.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.model.Attachment;

/**
 * ����: ֪ʶ��Ϣ�ӿ�
 * ����������֪ʶ��Ϣ�ӿ�
 * ������¼��wangxiaoqiang    2010/12/07
 * �޸ļ�¼��
 */
public interface Knowledge extends BaseModel{
	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public Integer getKnid();
	
	/**
	 *֪ʶ�汾ȡ��
	 * 
	 * @return ֪ʶ�汾
	 */
	public Integer getKnversion();
	
	/**
	 * ���ȡ��
	 * 
	 * @return ���
	 */
	public String getKnserial();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getKndepartment();

	/**
	 * �鵵��ȡ��
	 * 
	 * @return �鵵��
	 */
	public String getKnapprover();

	/**
	 * �鵵ʱ��ȡ��
	 * 
	 * @return �鵵ʱ��
	 */
	public String getKnapprovetime();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getKnclass();

	/**
	 * �ؼ���ȡ��
	 * 
	 * @return �ؼ���
	 */
	public String getKnkey();

	/**
	 * ��Դȡ��
	 * 
	 * @return ��Դ
	 */
	public String getKnorigin();
	
	/**
	 * ��Դȡ��
	 * 
	 * @return ��Դ
	 */
	public String getKnoriginname();

	/**
	 * ֪ʶ������ȡ��
	 * 
	 * @return ֪ʶ������
	 */
	public String getKnproffer();

	/**
	 * ����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getKnproffertime();

	/**
	 * ����ȡ��
	 * 
	 * @return ����
	 */
	public String getKntitle();

	/**
	 * ��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKndes();

	/**
	 * ����ԭ���ܽ�ȡ��
	 * 
	 * @return ����ԭ���ܽ�
	 */
	public String getKnfaultcause();

	/**
	 * ����취ȡ��
	 * 
	 * @return ����취
	 */
	public String getKnsolveway();

	/**
	 * ״̬ȡ��
	 * 
	 * @return ״̬
	 */
	public String getKnstatus();
	
	/**
	 *�������ȡ��
	 * 
	 * @return �������
	 */
	public String getKnclassname() ;
	
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
	 *����ԭ��ȡ��
	 * 
	 * @return ����ԭ��
	 */
	public String getKnreject();
	
	/**
	 * ����keyȡ��
	 * @return ����key
	 */
	public String getKnattkey();
	
	/**
	 *ҵ������ȡ��
	 * 
	 * @return ҵ������
	 */
	public String getKnarea();
	/**
	 *ҵ��������ȡ��
	 * 
	 * @return ҵ��������
	 */
	public String getKnareaname();
	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKntelarea();
	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getKntelareaname();
	
	/**
	 * ֪ʶ����Listȡ��
	 * @return ֪ʶ����List
	 */
	public List<Attachment> getAttachmentList();

	/**
	 * ֪ʶ����List�趨
	 * @return ֪ʶ����List
	 */
	public void setAttachmentList(List<Attachment> attachmentList);
	
	/**
	 * ֪ʶ������
	 * @return ֪ʶ������
	 */
	public Integer getKnapproverole();
	
	
}
