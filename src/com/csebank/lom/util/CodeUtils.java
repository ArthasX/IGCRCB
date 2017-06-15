package com.csebank.lom.util;

import org.apache.commons.lang.time.FastDateFormat;

import com.deliverik.framework.utility.ResourceUtility;

public final class CodeUtils {
	public static final FastDateFormat DATETIME_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm");
	public static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd");
	
	/** �Ӵ�������ģ */
	public static final String RECPTION_RSCALE = "9";	
	/** �Ӵ��Ӵ���׼ */
	public static final String RECPTION_RSTANDARD = "10";
	/** �Ӵ�����״̬ */
	public static final String RECPTION_STATUS = "11";
	/** Ԥ֧��ʽ */
	public static final String ADVANCESCOST_ACTYPE = "12";	
	/** ס�ޱ�׼ */
	public static final String LODGE_STANDARD = "30";
	
	/**��������*/
	public static final String GOUT_CONSUME="31";
	
	
	/** ��Ϳ����� */
	public static final String EWLBREAKFASTCARDPRICE = ResourceUtility.getString("EWLBREAKFASTCARDPRICE");	
	/** ��Ϳ����� */
	public static final String EWLLUNCHCARDPRICE = ResourceUtility.getString("EWLLUNCHCARDPRICE");
	/** ��Ϳ����� */
	public static final String EWLSUPPERPRICE = ResourceUtility.getString("EWLSUPPERPRICE");
	/** 1��ȯ���� */
	public static final String EWLONETICKETPRICE = ResourceUtility.getString("EWLONETICKETPRICE");
	/** 2��ȯ���� */
	public static final String EWLTWOTICKETPRICE = ResourceUtility.getString("EWLTWOTICKETPRICE");
	/** 3��ȯ���� */
	public static final String EWLTHREETICKETPRICE = ResourceUtility.getString("EWLTHREETICKETPRICE");
	
	/** ��������� ���*/
	public static final String GIODTYPE_INSTOCK = "0";
	/** �����״̬ ���*/
	public static final String GIODSTATUS_INSTOCK = "0";
	/** ����״̬ ����*/
	public static final String GOUTSTOCK_DESTROY = "3";
	/** ����״̬ ������*/
	public static final String GOUTSTOCK_DSP = "1";
	/** ����״̬ �������*/
	public static final String GOUTSTOCK_CKWC = "0";
	/** ����״̬ ����δͨ��*/
	public static final String GOUTSTOCK_SPWTG = "2";
	/** ���ʽ */
	public static final String INVOICE_IPAYMENTTYPE = "19";
	/** ״̬ */
	public static final String INVOICE_ISTATUS = "20";
	/** ��Ʊ���� */
	public static final String INVOICE_ITYPE = "21";
	/** Ԥ֧����״̬ */
	public static final String ADVANCESCOST_ACSTATUS = "22";	
	/** ���ʽ */
	public static final String LOANPAYDETAIL_LPDTYPE = "23";
	/** �軹��״̬ */
	public static final String LOANPAYDETAIL_LPDSTATUS = "28";
	/** �������� */
	public static final String ADVANCEDETAIL_TYPE = "29";
	
	/****************************************ʳ�òͿ�*************************************************/
	
	/** �Ϳ����� */
	public static final String CARD_CATEGORY = "35";
	
	/****************************************��Ʒ����*************************************************/
	
	/** ��Ʒ���� */
	public static final String GOODS_CATEGORY = "24";
	/** ��Ʒ״̬ */
	public static final String GOODS_STATUS = "25";
	/** ����״̬ */
	public static final String OUTSTOCK_STATUS = "26";
	/** ���ⷽʽ */
	public static final String OUTSTOCK_TYPE = "32";
	
	/** ��������� */
	public static final String INOUTSTOCK_TYPE = "27";	
	/** Ԥ������ */
	public static final String GSTOCK_WARNING_TYPE = "28";	
	
}