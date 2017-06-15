/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prj.model;

/**
 * ����: Ͷ��ʹ���������ʵ��ӿ�
 * ����������Ͷ��ʹ���������ʵ��ӿ�
 * �����ˣ���͢־
 * ������¼�� 2012-5-22
 * �޸ļ�¼��
 */
public interface InvestUseInfoVW{


	/**
	 * pidȡ��
	 * @return pid pid
	 */
	public Integer getPid() ;
	/**
	 * ��Ŀ����ȡ��
	 * @return ppquality ��Ŀ����
	 */
	public String getPpquality();
	/**
	 * ��Ŀ���ȡ��
	 * @return ptype ��Ŀ���
	 */
	public String getPtype() ;
	/**
	 * ��Ŀ����ȡ��
	 * @return pname ��Ŀ����
	 */
	public String getPname() ;
	/**
	 * ��Ŀ���ȡ��
	 * @return pdesc ��Ŀ���
	 */
	public String getPdesc();
	/**
	 * Ԥ����Ŀ���ȡ��
	 * @return pstorecode Ԥ����Ŀ���
	 */
	public String getPstorecode() ;
	/**
	 * ��ͬ����ܼ�ȡ��
	 * @return ltotal ��ͬ����ܼ�
	 */
	public Double getLtotal() ;
	/**
	 * ��ͬ����ʱ����ܼ�ȡ��
	 * @return ltotalctsum ��ͬ����ʱ����ܼ�
	 */
	public Double getLtotalctsum() ;
	/**
	 * ��ͬ���ɱ����ܼ�ȡ��
	 * @return ltotalcssum ��ͬ���ɱ����ܼ�
	 */
	public Double getLtotalcssum() ;
	/**
	 * ��ͬ����ʱ��𿪷�ȡ��
	 * @return ltotal1 ��ͬ����ʱ��𿪷�
	 */
	public Double getLtotal1() ;
	/**
	 * ��ͬ����ʱ������ȡ��
	 * @return ltotal2 ��ͬ����ʱ������
	 */
	public Double getLtotal2();
	/**
	 * ��ͬ����ʱ���Ӳ��ȡ��
	 * @return ltotal3 ��ͬ����ʱ���Ӳ��
	 */
	public Double getLtotal3() ;
	/**
	 * ��ͬ����ʱ��𹤳�ȡ��
	 * @return ltotal4 ��ͬ����ʱ��𹤳�
	 */
	public Double getLtotal4() ;
	/**
	 * ��ͬ����ʱ�������ȡ��
	 * @return ltotal5 ��ͬ����ʱ�������
	 */
	public Double getLtotal5() ;
	/**
	 * ��ͬ���ɱ���ʵʩȡ��
	 * @return ltotal6 ��ͬ���ɱ���ʵʩ
	 */
	public Double getLtotal6();
	/**
	 * ��ͬ���ɱ�������ȡ��
	 * @return ltotal7 ��ͬ���ɱ�������
	 */
	public Double getLtotal7() ;
	/**
	 * ��������ȡ��
	 * @return term ��������
	 */
	public String getTerm();
	/**
	 * ����ȡ��
	 * @return fktotal ����
	 */
	public Double getFktotal();
	/**
	 * Ԥ���ܼ�ȡ��
	 * @return bztotal Ԥ���ܼ�
	 */
	public Double getBztotal();
	/**
	 * Ԥ���ʱ����ܼ�ȡ��
	 * @return bztotalctsum Ԥ���ʱ����ܼ�
	 */
	public Double getBztotalctsum();
	/**
	 * Ԥ��ɱ����ܼ�ȡ��
	 * @return bztotalcssum Ԥ��ɱ����ܼ�
	 */
	public Double getBztotalcssum() ;
	/**
	 * Ԥ���ʱ��𿪷�ȡ��
	 * @return bztotal1 Ԥ���ʱ��𿪷�
	 */
	public Double getBztotal1() ;
	/**
	 * Ԥ���ʱ������ȡ��
	 * @return bztotal2 Ԥ���ʱ������
	 */
	public Double getBztotal2() ;
	/**
	 * Ԥ���ʱ���Ӳ��ȡ��
	 * @return bztotal3 Ԥ���ʱ���Ӳ��
	 */
	public Double getBztotal3() ;
	/**
	 * Ԥ���ʱ��𹤳�ȡ��
	 * @return bztotal4 Ԥ���ʱ��𹤳�
	 */
	public Double getBztotal4() ;
	/**
	 * Ԥ���ʱ�������ȡ��
	 * @return bztotal5 Ԥ���ʱ�������
	 */
	public Double getBztotal5();
	/**
	 * Ԥ��ɱ���ʵʩȡ��
	 * @return bztotal6 Ԥ��ɱ���ʵʩ
	 */
	public Double getBztotal6() ;
	/**
	 * Ԥ��ɱ�������ȡ��
	 * @return bztotal7 Ԥ��ɱ�������
	 */
	public Double getBztotal7();
	/**
	 * ��Ŀ�ܼ�ȡ��
	 * @return ptotal ��Ŀ�ܼ�
	 */
	public Double getPtotal() ;
	/**
	 * ��Ŀ�ʱ����ܼ�ȡ��
	 * @return ptotalctsum ��Ŀ�ʱ����ܼ�
	 */
	public Double getPtotalctsum() ;
	/**
	 * ��Ŀ�ɱ����ܼ�ȡ��
	 * @return ptotalcssum ��Ŀ�ɱ����ܼ�
	 */
	public Double getPtotalcssum() ;
	/**
	 * ��Ŀ�ʱ��𿪷�ȡ��
	 * @return ptotal1 ��Ŀ�ʱ��𿪷�
	 */
	public Double getPtotal1();
	/**
	 * ��Ŀ�ʱ������ȡ��
	 * @return ptotal2 ��Ŀ�ʱ������
	 */
	public Double getPtotal2() ;
	/**
	 * ��Ŀ�ʱ���Ӳ��ȡ��
	 * @return ptotal3 ��Ŀ�ʱ���Ӳ��
	 */
	public Double getPtotal3() ;
	/**
	 * ��Ŀ�ʱ��𹤳�ȡ��
	 * @return ptotal4 ��Ŀ�ʱ��𹤳�
	 */
	public Double getPtotal4() ;
	/**
	 * ��Ŀ�ʱ�������ȡ��
	 * @return ptotal5 ��Ŀ�ʱ�������
	 */
	public Double getPtotal5() ;
	/**
	 * ��Ŀ�ɱ���ʵʩȡ��
	 * @return ptotal6 ��Ŀ�ɱ���ʵʩ
	 */
	public Double getPtotal6();
	/**
	 * ��Ŀ�ɱ�������ȡ��
	 * @return ptotal7 ��Ŀ�ɱ�������
	 */
	public Double getPtotal7() ;
	/**
	 * ��Ŀ��;ȡ��
	 * @return ppurpose ��Ŀ��;
	 */
	public String getPpurpose() ;
}
