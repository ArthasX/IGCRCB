package com.deliverik.framework.workflow.prr.model.condition;

import java.util.List;

/**
 * <p>
 * ���̼�¼��Ϣ��������
 * </p>
 * <p>
 * ��δ˵������Ϊƽ̨��������)<br>
 * <table border="1">
 * <tr>
 * <td>prtitle</td>
 * <td>���̼�¼��Ŀ��ģ��ƥ�䣩</td>
 * </tr>
 * <tr>
 * <td>prstatus</td>
 * <td>���̼�¼״̬</td>
 * </tr>
 * <tr>
 * <td>pcode</td>
 * <td>���̼�¼�����Ŀ���</td>
 * </tr>
 * <tr>
 * <td>prusername</td>
 * <td>���̼�¼�������û�����</td>
 * </tr>
 * <tr>
 * <td>prid</td>
 * <td>���̼�¼ID</td>
 * </tr>
 * <tr>
 * <td>prurgency</td>
 * <td>���̼�¼�����̶�</td>
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
 * <td>pruserid</td>
 * <td>���̼�¼�������û�ID</td>
 * </tr>
 * <tr>
 * <td>prroleid</td>
 * <td>���̼�¼�����߽�ɫID</td>
 * </tr>
 * <tr>
 * <td>prpdid</td>
 * <td>���̼�¼��������ID</td>
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
 * <tr>
 * <td>approveflag</td>
 * <td>���˹����ĵ�ǰ�û��Ƿ��������������ɫ</td>
 * </tr>
 * <tr>
 * <td>varnames</td>
 * <td>��������</td>
 * </tr>
 * <tr>
 * <td>varvalues</td>
 * <td>��ֵ����</td>
 * </tr>
 * <tr>
 * <td>pdactname</td>
 * <td>���̹����˵�</td>
 * </tr>
 * </table>
 * </p>
 * 
 */
public interface IG500SearchCond {
	/**
	 * ���̼�¼��Ŀȡ��
	 * @return  ���̼�¼��Ŀ
	 */
	public String getPrtitle();

	/**
	 * ���̼�¼����ȡ��
	 * @return  ���̼�¼����
	 */
	public String getPrtype();
	
	/**
	 * ���̼�¼��������ȡ��
	 * @return  ���̼�¼��������
	 */
	public String[] getPrtypes();

	/**
	 * ���̼�¼״̬ȡ��
	 * @return ���̼�¼״̬
	 */
	public String getPrstatus();

	/**
	 * ���̼�¼IDȡ��
	 * @return ���̼�¼ID
	 */
	public Integer getPrid();

	/**
	 * ���̼�¼�����Ŀ���ȡ��
	 * @return ���̼�¼�����Ŀ���
	 */
	public String getPcode();

	/**
	 * ���̼�¼�������û�����ȡ��
	 * @return ���̼�¼�������û�����
	 */
	public String getPrusername();

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
	 * ���̼�¼�ر�ʱ��ȡ��
	 * @return ���̼�¼�ر�ʱ��
	 */
	public String getPrclosetime();

	/**
	 * ���̼�¼��������IDȡ��
	 * @return ���̼�¼��������ID
	 */
	public String getPrpdid();

	/**
	 * һ�����̼�¼��������IDģ����ѯȡ��
	 *
	 * @return prpdid_like_or һ�����̼�¼��������IDģ����ѯ
	 */
	public String[] getPrpdid_like_or();
	
	/**
	 * ���̼�¼�������û�IDȡ��
	 * @return ���̼�¼�������û�ID
	 */
	public String getPruserid();

	/**
	 * ���̼�¼�����߽�ɫIDȡ��
	 * @return ���̼�¼�����߽�ɫID
	 */
	public Integer getPrroleid();

	/**
	 * ���̼�¼�ƻ�ִ��ʱ��ȡ��
	 * @return ���̼�¼�ƻ�ִ��ʱ��
	 */
	public String getPrplantime();
	
	/**
	 * ���̼�¼�ƻ�ִ��ʱ��ȡ��
	 * @return ���̼�¼�ƻ�ִ��ʱ��
	 */
	public String getPrplantime_like();
	
	
	/**
	 * ���̼�¼�ر�ʱ��(like)ȡ��
	 * @return
	 */
	public String getPrclosetime_like();

	/**
	 * ���̼�¼�ƻ�ִ������ȡ��
	 * @return ���̼�¼�ƻ�ִ������
	 */
	public String getPrduration();

	
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
	 * ���̼�¼������ȡ��
	 * @return ���̼�¼������
	 */
	public String getPrserialnum();

	/**
	 * ���̼�¼״̬��״̬ȡ��
	 * @return ���̼�¼״̬��״̬
	 */
	public String getPrsubstatus();

	/**
	 * ���̼�¼����������������ȡ��
	 * @return ���̼�¼������������
	 */
	public String[] getPrTypeArray();
	
	/**
	 * ���̼�¼��������״̬����ȡ��
	 * @return ���̼�¼����״̬����
	 */
	public String[] getPrStatusArray();
	
	
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
	public List<Integer> getPridNotInList();

	/**
	 * ƽ̨����
	 * @return 
	 */
	public List<String> getPrserialnumNotInList();

	/**
	 * ƽ̨����
	 * @return 
	 */
	public String getPrActive();
	
	/**
	 * ƽ̨����
	 */
	public String getUserid_q();
	
	/**
	 * ��ѯ����
	 * @return 
	 */
	public String getPrdesc();
	
	/**
	 * �����ʶ
	 * @return
	 * */
	public String getOrder();
	
	public String getSing();
	
	public String getPrimpact();
	
	public String getPrpriority();
	
	/**
	 * ���˹����ĵ�ǰ�û��Ƿ��������������ɫ
	 * ����:1
	 * @return
	 */
	public String getApproveflag();
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String[] getVarnames();
	
	/**
	 * ���������趨
	 * @return ��������
	 */
	public String[] getVarvalues();
	
	/**
	 * @return the ������ʶ
	 */
	public String[] getVarmodes();
	
	/**
	 * ���̲����ˣ�like��ȡ��
	 *
	 * @return ppusername_like ���̲����ˣ�like��
	 */
	public String getPpusername_like();
	
	/**
	 * ���̲�����IDȡ��
	 * @return ppuserid ���̲�����ID
	 */
	public String getPpuserid();
	public String getPpuserid_like();

	/**
	 * ��������ָ��״̬����(���ݸ�ʽ��prpdid_ppstatus)ȡ��
	 * @return ��������ָ��״̬����(���ݸ�ʽ��prpdid_ppstatus)
	 */
	public String[] getPrpdidAndPpstatus_or();
	
	/**
	 * ���̲�������������״̬ȡ��
	 * @return ���̲�������������״̬
	 */
    public String getPpstatus_eq();
    
    /**
	 * ���̲����˴���ʱ���Ƿ�Ϊ�ձ�ʶȡ��
	 * @return ���̲����˴���ʱ���Ƿ�Ϊ�ձ�ʶ
	 */
	public String getPpproctime_status_active();
	
    /**
	 * ���̲�����ID(��״̬����)ȡ��
	 * @return ���̲�����ID(��״̬����)
	 */
	public String getPpuserid_status_eq();
	
	/**
	 * ���̲����˽�ɫ����(��״̬����)ȡ��
	 * @return ���̲����˽�ɫ����(��״̬����)
	 */
	public String getRoletype_status_eq();
	
    /**
	 * ���̲�����������ɫ����(��״̬����)ȡ��
	 * @return ���̲�����������ɫ����(��״̬����)
	 */
	public String[] getPproleid_status_in();
	
	/**
	 * �����˻�����ȡ��
	 * @return �����˻�����
	 */
	public String getProrgid_like();
	
	/**
     * ���̼�¼������like����ȡ��
     * @return prserialnum_likeArr ���̼�¼������like����
     */
    public String[] getPrserialnum_likeArr();

    /**
	 * ����״̬������ȡ��
	 * @return prstatus_ne ����״̬������
	 */
	public String getPrstatus_ne();
	
	/**
	 * ���̼�¼����ʱ�䣨like��ȡ��
	 * @return propentime_eq ���̼�¼����ʱ�䣨like��
	 */
	public String getPropentime_like();
	
	/**
	 * ���������̱�ʶȡ��
	 * @return lctype ���������̱�ʶ
	 */
	public String getLctype();
	
	/**
	 * �����˻�����ȡ��
	 * @return prorgid_in �����˻�����
	 */
	public String getProrgid_in();

	/**
     * ������Դȡ��
     *
     * @return prassetname ������Դ
     */
    public String getPrassetname();
	
	/**
	 * ��ȡ����id��Χ
	 * @return
	 */
	public String getPrid_in();
	
	/**
	 * �����˵�ȡ��
	 * @return pdactname �����˵�
	 */
	public String getPdactname();
	


	/**
	 * �����ɫID����ȡ��
	 * @return prroleid_in �����ɫID����
	 */
	public List<Integer> getPrroleid_in();

	/**
	 * �����ɫID����ȡ��
	 * @return prroleid_not_in �����ɫID����
	 */
	public List<Integer> getPrroleid_not_in();

	/**
	 * �����˴���״̬
	 * @return Ppstatus  �����˴���״̬
	 */
	public String getPpstatus();
	
	/**
	 * �����ؼ���ȡ��
	 * @return content �����ؼ���
	 */
	public String getContent();
	/**
	 * ��ֵ����ȡ��
	 * @return the varvalues_in
	 */
	public String[] getVarvalues_in();
	
	/**
	 * ��������ȡ��
	 * @return the varnames_in
	 */
	public String[] getVarnames_in();
	
	/**
	 * �Ƿ�Ϊ�澯�¼�1Ϊ��0Ϊ���ȡ��ȡ
	 * @return the alarm_Is
	 */
	public String getAlarm_Is();
	
	/**
	 * ���Ƿ��Ѿ�ȷ��1Ϊ��0Ϊ�ǻ�ȡ
	 * @return the ppbacktime_isNull
	 */
	public String getPpbacktime_isNull();
		/**
	 * �������ı�ʾ(Y����ɹ�)ȡ��
	 * @return pivarlabel �������ı�ʾ(Y����ɹ�)
	 */
	public String getPivarlabel();
	
	/**
	 * �¼��������
	 * @return PivarValue ��ȡǰ6λ
	 */
	public String getPivarValue();
	
	/**
	 * �����������
	 * @return PivarValue ��ȡǰ6λ
	 */
	
	public String getPppivarValue();
	/**
	 * @return the ������ID
	 */
	public Integer getPid();
	
	/**
	 * �Ƿ�Ϊ�쵼
	 * @return
	 */
	public String getLeaderFlag();
	
	/**
	 * ����id
	 * @return
	 */
	public String getOrgID();
	
	/**flag���*/
	public String getFlag();

	/** ��������(����/Ӧ��) */
	public String getDwpType();
}
