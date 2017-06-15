package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>
 * ���̼�¼������û���Ϣ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>prtype</td>
 * <td>���̼�¼����</td>
 * </tr>
 * <tr>
 * <td>ppuserid</td>
 * <td>���̲����û�ID</td>
 * </tr>
 * <tr>
 * <td>ppstatus</td>
 * <td>���̲����û��Ĳ���״̬</td>
 * </tr>
 * <tr>
 * <td>pproleid</td>
 * <td>���̲����û���ɫID</td>
 * </tr>
 * <tr>
 * <td>propentime</td>
 * <td>���̼�¼����ʱ�䣨����ڣ�</td>
 * </tr>
 * <tr>
 * <td>prclosetime</td>
 * <td>���̼�¼����ʱ�䣨С���ڣ�</td>
 * </tr>
 * <tr>
 * <td>pcode</td>
 * <td>���̼�¼�����Ŀ���</td>
 * </tr>
 * <tr>
 * <td>prassetid</td>
 * <td>���̼�¼����ʲ�ID</td>
 * </tr>
 * <tr>
 * <td>prassetcategory</td>
 * <td>���̼�¼����ʲ�����</td>
 * </tr>
 * <tr>
 * <td>prserialnum</td>
 * <td>���̼�¼������</td>
 * </tr>
 * <tr>
 * <td>prsubstatus</td>
 * <td>���̼�¼״̬��״̬</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG677SearchCond {
	/**
	 * ���̼�¼����ʲ�IDȡ��
	 * @return ���̼�¼����ʲ�ID
	 */
	public Integer getPrassetid();

	/**
	 * ���̼�¼����ʲ�����ȡ��
	 * @return ���̼�¼����ʲ�����
	 */
	public String getPrassetcategory();

	/**
	 * ���̲����û��Ĳ���״̬ȡ��
	 * @return ���̲����û��Ĳ���״̬
	 */
	public String getPpstatus();

	/**
	 * ���̼�¼��Ŀȡ��
	 * @return ���̼�¼��Ŀ
	 */
	public String getPrtitle();

	/**
	 * ���̼�¼����ȡ��
	 * @return ���̼�¼����
	 */
	public String getPrtype();

	/**
	 * ���̼�¼״̬ȡ��
	 * @return ���̼�¼״̬
	 */
	public String getPrstatus();
	
	/**
	 * ���̲����û���ɫIDȡ��
	 * @return ���̲����û���ɫID
	 */
	public Integer getPproleid();

	/**
	 * ���̲����û�IDȡ��
	 * @return ���̲����û�ID
	 */
	public String getPpuserid();

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
	 * ���̲����û�������ɿ�ʼʱ��ȡ��
	 * @return ���̲����û�����ʼʱ��
	 */
	public String getPpproctime_from();
	
	/**
	 * ���̲����û�������ɽ���ʱ��ȡ��
	 * @return ���̲����û�������ɽ���ʱ��
	 */
	public String getPpproctime_to();

	/**
	 * ���̲����û�����ȡ��
	 * @return ���̲����û�����
	 */
	public String getPpusername();

	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid();

	/**
	 * ���̼�¼�����̶�ȡ��
	 * @return ���̼�¼�����̶�
	 */
	public String getPrurgency();

	/**
	 * ���̼�¼����ʱ��ȡ��
	 * @return ���̼�¼����ʱ��
	 */
	public String getPropentime();
	/**
	 * ���̼�¼����ʱ�䣨С���ڣ�ȡ��
	 * @return ���̼�¼����ʱ�䣨С���ڣ�
	 */
	public String getPrclosetime();

	/**
	 * ���̼�¼�����Ŀ���ȡ��
	 * @return ���̼�¼�����Ŀ���
	 */
	public String getPcode();

	/**
	 * ���̼�¼�ƻ�ִ��ʱ��ȡ��
	 * @return ���̼�¼�ƻ�ִ��ʱ��
	 */
	public String getPrplantime();

	/**
	 * ���̼�¼�ƻ�ִ������ȡ��
	 * @return ���̼�¼�ƻ�ִ������
	 */
	public String getPrduration();

	/**
	 * ���̼�¼״̬��״̬ȡ��
	 * @return ���̼�¼״̬��״̬
	 */
	public String getPrsubstatus();

	/**
	 * ���̼�¼������ȡ��
	 * @return ���̼�¼������
	 */
	public String getPrserialnum();
	
	
	/**
	 * ƽ̨����
	 * @return 
	 */
	public String getMode();

	/**
	 * ƽ̨����
	 * @return 
	 */
	public String getPrActive();

	/**
	 * ƽ̨����
	 * @return 
	 */
	public boolean isTodo();
	
	/**
	 * ƽ̨����
	 * @return 
	 */
	public int getIsWork();

	/**
	 * ƽ̨����
	 * @return 
	 */
	public String getSelectMode();

	/**
	 * ƽ̨����
	 * @return 
	 */
	public boolean isToImplement();
	
	/**
	 * ���ܣ���������״̬��������ȡ��
	 * @return ��������״̬��������
	 */
	public String getDsstatus();
	
	 /**
     * ����ģ��ȡ��
     *
     * @return prpdid ����ģ��
     */
    public String getPrpdid();
    
    /**
     * ȡ��
     *
     * @return prtypes 
     */
    public String[] getPrtypes();
    
    /**
	 * ���̽ڵ�״̬��ʾ��(��ȫƥ��)ȡ��
	 * @return
	 */
	public String getPsdid_eq();
	
	/**
	 * �����˻�����(��ȫƥ��)ȡ��
	 * @return
	 */
	public String getPporgid_eq();
}
