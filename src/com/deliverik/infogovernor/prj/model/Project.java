package com.deliverik.infogovernor.prj.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.fin.model.entity.BudgetTB;

public interface Project  extends BaseModel {

	/** ��ȡ����ID*/
	public abstract Integer getPid();

	/** ��ȡ��Ŀ����*/
	public abstract String getPtype();

	/** ��ȡ��Ŀ���*/
	public abstract String getPcode();

	/** ��ȡ��Ŀ����*/
	public abstract String getPname();

	/** ��ȡ��Ŀ���*/
	public abstract String getPdesc();

	public abstract String getPinfo();

	/** ��ȡ��ʼʱ��*/
	public abstract String getPopentime();

	/** ��ȡ����ʱ��*/
	public abstract String getPclosetime();

	/** ��ȡ״̬*/
	public abstract String getPstatus();

	/** ��ȡ�Ǽ��˻���ID*/
	public abstract String getPorg();

	/** ��ȡ�Ǽ��˽�ɫ*/
	public abstract String getProle();

	/** ��ȡ�Ǽ���*/
	public abstract String getPuser();

	/** ��ȡ��ĿԤ�㣬��ӦԤ����е�Ԥ������*/
	public abstract String getPamount();
	
	/** ��ȡ��ĿԤ����;*/
	public abstract String getPuse();
	
	/** ��ȡ��ĿԤ����*/
	public abstract Double getPlimit();
	
	/** ��ȡ������*/
	public abstract String getPbranch();
	
	/** ��ȡԤ������ID*/
	public abstract Integer getPbid();
	
	/** ��ȡ��ĿĿ��*/
	public abstract String getPaim();
	
	/**
	 * ��ȡ��Ŀ��;
	 * @return fppurpose ��Ŀ��;
	 */
	public abstract String getPpurpose();
	
	/**
	 * ��ȡԤ���ʵ��
	 * @param ppurpose  Ԥ���ʵ��
	 */
	public abstract BudgetTB getBudgetTB();
	
	/**
	 * ��ȡʹ��Ԥ��
	 * @return
	 */
	public abstract String getIsUseBudget();
	
	/**
	 * �ƻ�����ʱ��ȡ��
	 * @return pplanclosetime �ƻ�����ʱ��
	 */
	public String getPplanclosetime() ;
	
	/**
	 * ��Ŀ�ʱ��𿪷�ȡ��
	 * @return bzdevelop ��Ŀ�ʱ��𿪷�
	 */
	public Double getPzdevelop() ;

	/**
	 * ��Ŀ�ʱ���Ӳ��ȡ��
	 * @return bzhardware ��Ŀ�ʱ���Ӳ��
	 */
	public Double getPzhardware() ;

	/**
	 * ��Ŀ�ʱ������ȡ��
	 * @return bzsoftware ��Ŀ�ʱ������
	 */
	public Double getPzsoftware();

	/**
	 * ��Ŀ�ʱ��𹤳�ȡ��
	 * @return bzproject ��Ŀ�ʱ��𹤳�
	 */
	public Double getPzproject() ;

	/**
	 * ��Ŀ�ʱ�������ȡ��
	 * @return bzelse ��Ŀ�ʱ�������
	 */
	public Double getPzelse() ;

	/**
	 * ��Ŀ�ɱ���ʵʩȡ��
	 * @return bcimplement ��Ŀ�ɱ���ʵʩ
	 */
	public Double getPcimplement();

	/**
	 * ��Ŀ�ɱ�������ȡ��
	 * @return bcelse ��Ŀ�ɱ�������
	 */
	public Double getPcelse() ;
	
	/**
	 * ��ͬ���ȡ��
	 * @return plcid ��ͬ���
	 */
	public Integer getPlcid() ;
	/**
	 * ��Ŀ����ȡ��
	 * @return ppquality ��Ŀ����
	 */
	public String getPpquality();
}