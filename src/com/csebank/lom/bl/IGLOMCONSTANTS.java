/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.bl;

import org.apache.commons.lang.time.FastDateFormat;

import com.csebank.common.TopOrgValueBean;
import com.deliverik.framework.utility.ResourceUtility;

/**
 * 
 * �Ӵ�������
 *
 */
public class IGLOMCONSTANTS {
	
	public static final String LOM_GOODS_TYPE = "216";
	
	//------------------------------------�Ӵ�����ʹ��״̬-----------------------------------------------------
	
	/** �Ӵ�����״̬ ������ */
	public static final String REC_STATUS_ENABLE = "1";
	/** �Ӵ�����״̬ ���� */
	public static final String REC_STATUS_DISABLE = "2";
	
	//------------------------------------Ԥ֧��ʽ-----------------------------------------------------
	
	/** Ԥ֧��ʽ �ֽ� */
	public static final String ADVANCESCOST_TYPE_CASH = "1";
	/** Ԥ֧��ʽ �ֽ�֧Ʊ */
	public static final String ADVANCESCOST_TYPE_INVOICE = "2";
	
	//------------------------------------Ԥ֧����״̬-----------------------------------------------------
	
	/** Ԥ֧����״̬ δ��� */
	public static final String ADVANCESCOST_STATUS_UNCREDIT = "0";
	/** Ԥ֧����״̬ �ѳ�� */
	public static final String ADVANCESCOST_STATUS_CREDIT = "1";
	/** Ԥ֧����״̬ Ԥ֧���� */
	public static final String ADVANCESCOST_STATUS_ADJUST = "2";
	/** Ԥ֧����״̬ �ֽ��� */
	public static final String ADVANCESCOST_STATUS_CASH_CREDIT = "3";
	
	/** ʱ�� */
	public static final FastDateFormat DATETIME_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");
	
	//------------------------------------�軹��״̬-----------------------------------------------------
	/** �軹��״̬ ��ȷ�� */
	public static final String LPD_STATUS_YIQUEREN= "0";
	/** �軹��״̬ ������ */
	public static final String LPD_STATUS_DAISHENPI = "1";
	/** �軹��״̬ ����ͨ�� */
	public static final String LPD_STATUS_YITONGGUO = "2";
	/** �軹��״̬ ����δͨ�� */
	public static final String LPD_STATUS_WEITONGGUO = "3";
	/** �軹��״̬ �ѻ��� */
	public static final String LPD_STATUS_YIHUANKUAN= "4";
	/** �軹��״̬ �ѳ�� */
	public static final String LPD_STATUS_CREDIT = "5";
	/** �軹��״̬ ��ѯʱ�� �ǻ������� */
	public static final String LPD_STATUS_YIQUEREN_YIHUANKUAN = "6";
	
	//------------------------------------�軹������-----------------------------------------------------
	
	/** ��� */
	public static final String LPD_TYPE_LOAN = "0";
	
	/** �ֽ𻹿� */
	public static final String LPD_TYPE_PAY = "1";
	
	/** ��Ʊ���� */
	public static final String LPD_TYPE_PAY_INVOICE = "2";
	
	//------------------------------------��Ʒ��Ϣ״̬-----------------------------------------------------

	/** ��Ʒ��Ϣ״̬ ���� */
	public static final String GOODS_STATUS_ENABLE = "1";
	/** ��Ʒ��Ϣ״̬ ͣ�� */
	public static final String GOODS_STATUS_DISABLE = "0";
	
	
	//------------------------------------��Ʒ����-----------------------------------------------------
	
	/**
	 * Ĭ�϶�������
	 */
	public static final String DEFAULT_ORGSYSCODING = TopOrgValueBean.getTopOrg();
	
	/** ʳ�û�������� */
	public static final String ST_ORGSYSCODING = "STORG";
	
	/** ʳ�û������� */
	public static final String ST_ORGNAME = "ʳ��";
	
	/** �ɱ�ʳ��������Ʒ������� */
	public static final String ST_SEARCH_TYPE = "216004";
	/** ��Ʒ����Ʒ������� */
	public static final String  PRESENT_CODE = "216002";
	
	//////////////////////////////////////�������ϸ��
	
	/** ��������� ��� */
	public static final String GIODTYPE_RK = "0";
	
	/** ��������� ���� */
	public static final String GIODTYPE_LY = "1";
	
	/** ��������� ���� */
	public static final String GIODTYPE_TJ = "2";
	
	/** ��������� ���� */
	public static final String GIODTYPE_HX = "3";

	/** �����״̬ ����� */
	public static final String GIODSTATUS_KCW = "0";
	
	/** �����״̬ ����� */
	public static final String GIODSTATUS_KCY = "1";
	
	/** �����״̬ ������� */
	public static final String GIODSTATUS_CKWC = "0";
	
	/** �����״̬ ������ */
	public static final String GIODSTATUS_DSP = "1";

	/** �����״̬ ����δͨ�� */
	public static final String GIODSTATUS_SPWTG = "2";
	

	//////////////////////////////////////�����
	
	/** �������� ���� */
	public static final String GOTYPE_LY = "1";

	/** �������� ���� */
	public static final String GOTYPE_TJ = "2";
	
	/** ����״̬ ������� */
	public static final String GOSTATUS_CKWC = "0";
	
	/** ����״̬ ������ */
	public static final String GOSTATUS_DSP = "1";

	/** ����״̬ ����δͨ�� */
	public static final String GOSTATUS_SPWTG = "2";
	
	//////////////////////////////////////���Ԥ��
	/** Ԥ������ ��Ԥ����ѯ */
	public static final String WARN_TYPE_YYJ = "1";
	
	/** Ԥ������ �ٽ�Ԥ����ѯ */
	public static final String WARN_TYPE_LJYJ = "2";
	
	
	/** ������ڹ���_��Ʒ_ÿ���̵㹦���Ƿ����ã�1���� 0ͣ�ã� */
	public static final String INVENTORY_STATUS = ResourceUtility.getString("INVENTORY_STATUS");;
	
	//------------------------------------��Ʊ-----------------------------------------------------
	/** ��Ʊ״̬ */
	public static final String INVOICE_TYPE_UNPLAY = "0";
}
