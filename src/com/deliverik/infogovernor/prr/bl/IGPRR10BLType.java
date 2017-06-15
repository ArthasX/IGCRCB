/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.bl;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����excel���볣����
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR10BLType {

	/**
	 * ���
	 */
	public static enum Sign{
		/** ���̶���ID */
		PDID("pdid"),
		/** ������Ϣ */
		BASIS("basis"),
		/** ��������Ϣ */
		PARTICIPANT("participant"),
		/** ����Ϣ */
		PROCESS_INFO("processinfo")
		;
		
		private String code;
		
		private Sign(String _code){
			this.code = _code;
		}
		
		public String toString(){
			return this.code;
		}
	}
	
	/** ��ͨ��KEY */
	public static final String PROCESS_BASIS_FORM_KEY = "basis_key";
	
	/** ���̷����� */
	public static final String PROCESS_BASIS_OPENER = "������ID";
	
	/** ���̷���ʱ�� */
	public static final String PROCESS_BASIS_OPENTIME = "����ʱ��";
	
	/** ���̹ر�ʱ�� */
	public static final String PROCESS_BASIS_CLOSETIME = "�ر�ʱ��";
	
	/** 
	 * <p>�ɵ�����������ͷ�Χ</p> 
	 * �Ž�����(01371)�����ݿ�������(01281)
	 * --�ڲ�����������(01372)���ⲿ����������(01373)��
	 * ���ݲ�ѯ����(01060)�����ݱ����������(01063)����������������(01065)�� 
	 */
	public static final String[] PROCESS_PDIDS = new String[]{"01371","01281","01060","01063","01065"};
}
