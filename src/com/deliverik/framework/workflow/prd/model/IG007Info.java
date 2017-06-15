package com.deliverik.framework.workflow.prd.model;

import java.util.List;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prd.model.entity.IG286TB;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
 * ���̱���������Ϣ
 *
 */
public interface IG007Info  extends BaseModel {

	/**
	 * ���̱�������IDȡ��
	 * @return ���̱�������ID
	 */
	public String getPidid();

	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public String getPdid();

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidname();

	/**
	 * ���̱�����ʾ����ȡ��
	 * @return ���̱�����ʾ����
	 */
	public String getPidlabel();

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPiddesc();

	/**
	 * ���̱�������ȡ��
	 * @return ���̱�������
	 */
	public String getPidtype();

	/**
	 * ���̱���ѡ��ȡ��
	 * @return ���̱���ѡ��
	 */
	public String getPidoption();

	/**
	 * ���̱���Ĭ��ֵȡ��
	 * @return ���̱���Ĭ��ֵ
	 */
	public String getPiddefault();

	/**
	 * ���̱���IDȡ��
	 * @return ���̱���ID
	 */
	public Integer getPiid();

	/**
	 * ���̱��������ʶȡ��
	 * @return ���̱��������ʶ
	 */
	public String getPidsortid();
	
	/**
	 * ���̱����Ƿ����ȡ��
	 * @return ���̱����Ƿ����
	 */
	public String getPidrequired();
	
	/**
	 * ���̱���ֵȡ��
	 * @return ���̱���ֵ
	 */
	public String getPidvalue();
	
	/**
	 * �����߾��е����̱���Ȩ��ȡ��
	 * @return �����߾��е����̱���Ȩ��
	 */
	public String getPidaccess();
	
	public Integer getPidgid();
	/**
	 * ���̱���������Ϣȡ��
	 * @return ���̱���������Ϣ
	 */
	public List<IG286TB> getProcessLinkageDefList();
	
	/**
	 * �������̱���CCIDȡ��
	 * @return �������̱���CCID
	 */
	public String getCcid();
	
	/**
	 * ����Ϣ��ģʽȡ��
	 *
	 * @return pidmode ����Ϣ��ģʽ
	 */
	public String getPidmode();
	
	
//	public String getPiattkey()
	
	/**
	 * ����Ϣ������ʾģʽȡ��
	 *
	 * @return ����Ϣ����ģʽ
	 */
	public String getRowwidth();
	
	/**
	 * ˽�б���Ȩ�޷�Χ�趨
	 * 
	 * @return ˽�б���Ȩ�޷�Χ
	 */
	public String getPrivatescope();
	
	/**
	 * ˽�б���ֵȡ��
	 * @return ˽�б���ֵ����
	 */
	public List<IG899TB> getProcessPrivateInfoList();
	
	/**
	 * �Ƿ��������ȡ��
	 * @return �Ƿ��������
	 */
	public String getHasattach();
	/**
	 * ���ģʽȡ��
	 * @return piddisplay ���ģʽ
	 */
	public String getPiddisplay();

	/**
	 * ʹ��ģʽȡ��
	 * @return piduse ʹ��ģʽ
	 */
	public String getPiduse();

	/**
	 * ���ȡ��
	 * @return pidwidth ���
	 */
	public Integer getPidwidth();

	/**
	 * ������������ȡ��
	 * @return ppidid ������������
	 */
	public String getPpidid();
	
	/**
	 * ����ȡ��
	 * @return pidrows ����
	 */
	public Integer getPidrows();
	
	/**
	 * �Ƿ���������ȡ��
	 * @return pidhide �Ƿ���������
	 */
	public String getPidhide();
		
	/**
	 * �Ƿ���ʾ�к�ȡ��
	 * @return showrownum �Ƿ���ʾ�к�
	 */
	public String getShowrownum();
	
	/**
	 * ����λȡ��
	 */
	public String getPidunit() ;
	
	/**
	 *�Ƿ������עȡ��
	 */
	public String getRemarks();
	
	/**
	 *��ѡ��ѡ��ʾ��ʽȡ��
	 */
	public String getShowstyles();
	
	
	/**
	 * �������Ƿ���ʾ����ȡ��
	 * @return showline �������Ƿ���ʾ����
	 */
	public String getShowline();
	
	/**
	 * ���������ʾ��ʽȡ��
	 * @return titledisplay ���������ʾ��ʽ
	 */
	public String getTitledisplay();
	
	/**
	 * �Ƿ���Ҫ�������ȡ��
	 * @return needidea �Ƿ���Ҫ�������
	 */
	public String getNeedidea();
	
	/**
	 * js����ȡ��
	 * @return jsfunction js����
	 */
	public String getJsfunction();
	
	/**
	 * ���ʽ����ģʽ�������ݱ���ȡ��
	 * @return pidratio ���ʽ����ģʽ�������ݱ���
	 */
	public String getPidratio();
	
	/**
	 * ����ַ���ȡ��
	 * @return pidsize ����ַ���
	 */
	public Integer getPidsize();
	
	/**
	 * ����д��ʶȡ��
	 * @return writeable ����д��ʶ
	 */
	public String getWriteable();
	
	/**
	 * ���α�ֻ��ѡ��ĩ����ʶȡ��
	 * @return selecedlast ���α�ֻ��ѡ��ĩ����ʶ
	 */
	public String getSelecedlast();
	
	/**
	 * ��������ȡ��
	 * @return numbertype ��������
	 */
	public String getNumbertype();
	
	/**
	 * ���뷽ʽȡ��
	 * @return align ���뷽ʽ
	 */
	public String getAlign();
	/**
	 * �Ƿ�Ϊ��ʶ��ȡ��
	 * @return isFlag �Ƿ�Ϊ��ʶ��
	 */
	public String getIsFlag();
}