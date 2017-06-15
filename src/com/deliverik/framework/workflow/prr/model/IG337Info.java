package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.user.model.entity.UserTB;

/**
 * ���̲����û���Ϣ
 *
 */
public interface IG337Info  extends BaseModel {

	/**
	 * ���̲����û�������������ȡ��
	 * @return ���̲����û�������������
	 */
	public String getPporgname();

	/**
	 * ���̲����û�IDȡ��
	 * @return ���̲����û�ID
	 */
	public Integer getPpid();

	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid();
	
	/**
	 * ���̲����û��������������ȡ��
	 * @return ���̲����û��������������
	 */
	public String getPporgid();

	/**
	 * ���̲����û���ɫIDȡ��
	 * @return ���̲����û���ɫID
	 */
	public Integer getPproleid();

	/**
	 * ���̲����û���ɫ����ȡ��
	 * @return ���̲����û���ɫ����
	 */
	public String getPprolename();

	/**
	 * ���̲����û�IDȡ��
	 * @return ���̲����û�ID
	 */
	public String getPpuserid();

	/**
	 * ���̲����û�����ȡ��
	 * @return ���̲����û�����
	 */
	public String getPpusername();

	/**
	 * ���̲����û��Ĳ�������ȡ��
	 * @return ���̲����û��Ĳ�������
	 */
	public String getPptype();

	/**
	 * ���̲����û�����Ϣ����ϵ��ʽ�ȣ�ȡ��
	 * @return ���̲����û�����Ϣ����ϵ��ʽ�ȣ�
	 */
	public String getPpuserinfo();

	/**
	 * ���̲����û��Ĺ�������ȡ��
	 * @return ���̲����û��Ĺ�������
	 */
	public String getPpcomment();

	/**
	 * ���̲����û��Ĳ���״̬ȡ��
	 * @return ���̲����û��Ĳ���״̬
	 */
	public String getPpstatus();

	/**
	 * ��������KEYȡ��
	 * @return ��������KEY
	 */
	public String getPpattkey();

	/**
	 * ���̲����û�ָ��ʱ��ȡ��
	 * @return ���̲����û�ָ��ʱ��
	 */
	public String getPpinittime();

	/**
	 * ���̲����û��������ʱ��ȡ��
	 * @return ���̲����û��������ʱ��
	 */
	public String getPpproctime();

	/**
	 * ���̲����û���״̬ȡ��
	 * @return ���̲����û���״̬
	 */
	public String getPpsubstatus();

	/**
	 * ���̲����û�ʵ�ʽ��ʱ��ȡ��
	 * @return ���̲����û�ʵ�ʽ��ʱ��
	 */
	public Integer getPpfacttime();

	/**
	 * ���̻���ָ��ʱ��ȡ��
	 * @return ���̻���ָ��ʱ��
	 */
	public String getPpbacktime();
	
	/**
	 * ����super�����߱�ʶȡ��
	 * @return ����super�����߱�ʶ
	 */
	public String getPpsuper();
	
	/**
	 * ���̲����߽�ɫ�����˱�ʶȡ��
	 * @return ���̲����߽�ɫ�����˱�ʶ
	 */
	public String getPprolemanager();
	
	/**
	 * ���̲�����ֵ���˱�ʶȡ��
	 * @return ���̲�����ֵ���˱�ʶ
	 */
	public String getPpdutyperson();
	
	/**
	 * ���̲��������ȡ��
	 * @return ���̲��������
	 */
	public String getPpproxyuserid();
	
	/**
	 * ���̲��������ʵ��ȡ��
	 * @return ���̲��������ʵ��
	 */
	public UserTB getProxyUserTB();
	
	/**
	 * ��ť����IDȡ��
	 * 
	 * @return ��ť����ID
	 */
	public String getPbdid();

	/**
	 * ����״̬����IDȡ��
	 * @return ����״̬����ID
	 */
	public String getPsdid();

	/**
	 * ��̬��֧���ȡ��
	 * @return ��̬��֧���
	 */
	public Integer getPsdnum();
}