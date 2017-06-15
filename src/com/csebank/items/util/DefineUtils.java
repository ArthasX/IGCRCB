package com.csebank.items.util;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.time.FastDateFormat;

import com.csebank.common.TopOrgValueBean;
import com.deliverik.framework.utility.ResourceUtility;

public final class DefineUtils {
	public static final FastDateFormat DATETIME_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm");
	public static final FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd");
	public static final String ITEMSCODES_STOCK_CATEGORY = "1";//��Ʒ����
	public static final String ITEMSCODES_STOCK_TYPE = "2";//��Ʒ����
	public static final String ITEMSCODES_STOCK_NATURE = "3";//��Ʒ����
	public static final String ITEMSCODES_INSTOCK_STATUS = "4";//����״̬
	public static final String ITEMSCODES_OUTSTOCK_OUTTYPE = "5";//��������
	public static final String ITEMSCODES_OUTSTOCK_REQSTATUS = "6";//����״̬
	public static final String ITEMSCODES_OUTSTOCK_ACCOUNTSTATUS = "7";//����״̬
	public static final String ITEMSCODES_ITEMSCODES_REQUESTSTATUS = "8";//����״̬
	
	//stock��prenum�ֶβ�������
	public static final String STOCK_PRENUM_RK = "0";//���
	public static final String STOCK_PRENUM_SL = "1";//����
	public static final String STOCK_PRENUM_XB = "2";//�²�
	public static final String STOCK_PRENUM_SY = "3";//ʹ��
	public static final String STOCK_PRENUM_SH = "4";//���
	public static final String STOCK_PRENUM_XH = "5";//����
	public static final String STOCK_PRENUM_CK = "6";//����
	public static final String STOCK_PRENUM_TZ = "7";//����
	public static final String STOCK_PRENUM_SP = "8";//����
	public static final String STOCK_PRENUM_JS = "9";//����
	
	public static final String STOCK_PRENUM_SLXG = "10";//�����޸�
	public static final String STOCK_PRENUM_SLSC = "11";//����ɾ��
	
	//����״̬
	public static final String ITEMSCODES_STATUS_WCK = "1";//δ����
	public static final String ITEMSCODES_STATUS_BFCK = "2";//���ֳ���
	public static final String ITEMSCODES_STATUS_YCK = "3";//�ѳ���
	public static final String ITEMSCODES_STATUS_YSH = "4";//�����
	public static final String ITEMSCODES_STATUS_YXH = "5";//������
	
	//��������
	public static final String ITEMSCODES_OUTTYPE_RK = "0";//���
	public static final String ITEMSCODES_OUTTYPE_ZHSL = "1";//֧������
	public static final String ITEMSCODES_OUTTYPE_ZHXB = "2";//�����²�
	public static final String ITEMSCODES_OUTTYPE_SY = "3";//ʹ��
	public static final String ITEMSCODES_OUTTYPE_SH = "4";//���
	public static final String ITEMSCODES_OUTTYPE_XH = "5";//����
	public static final String ITEMSCODES_OUTTYPE_RKTZ = "6";//������
	
	//����״̬
	public static final String ITEMSCODES_REQSTATUS_SLDSP = "1";//���������
	public static final String ITEMSCODES_REQSTATUS_DCK = "2";//������
	public static final String ITEMSCODES_REQSTATUS_DJS = "3";//������
	public static final String ITEMSCODES_REQSTATUS_SPWTG = "5";//����δͨ��
	public static final String ITEMSCODES_REQSTATUS_SHDSP = "7";//��Ĵ�����
	public static final String ITEMSCODES_REQSTATUS_XHDSP = "9";//���ٴ�����
	public static final String ITEMSCODES_REQSTATUS_CKWC = "0";//������ɡ�����������ϡ������������������ͨ��
	
	public static final String ITEMSCODES_REQSTATUS_DJS_CKWC = "0_3";//�ֿ������ѯʹ��(������_�������)
	
	//����״̬
	/**
	 * δ����
	 */
	public static final String ITEMSCODES_ACCOUNTSTATUS_WJZ = "0";//
	/**
	 * �ѽ���
	 */
	public static final String ITEMSCODES_ACCOUNTSTATUS_YJZ = "1";//
	
	//����״̬
	/**
	 * ������
	 */
	public static final String ITEMSCODES_REQUEST_TRUE = "1";//
	/**
	 * ��������
	 */
	public static final String ITEMSCODES_REQUEST_FALSE = "0";//
	

	/**
	 * Ĭ�϶�������
	 */
	public static final String DEFAULT_ORGNO = TopOrgValueBean.getTopOrg();

	/**
	 * Ĭ���²�ʱ��ѯ�������ϼ�����
	 */
	public static final String DEFAULT_XB_ORGNO = TopOrgValueBean.getXbOrg();
	

	/**
	 * ��Ʒ����
	 */
	public static final String CATEGORY_PZ = "CER";//ƾ֤certificate
	public static final String CATEGORY_BGYP = "OFF";//�칫��ƷOffice Supplies
	public static final String CATEGORY_HC = "ITE";//�Ĳ�items
	public static final String CATEGORY_DZSB = "ELE";//�����豸electronics
	public static final String CATEGORY_QT = "OTH";//����other
	
	public static Map<String,String> CATEGORY_MAP = new HashMap<String,String>();
	
	static {
		CATEGORY_MAP.put("1", CATEGORY_PZ);//ƾ֤
		CATEGORY_MAP.put("2", CATEGORY_BGYP);//�칫��Ʒ
		CATEGORY_MAP.put("3", CATEGORY_HC);//�Ĳ�
		CATEGORY_MAP.put("4", CATEGORY_DZSB);//�����豸
		CATEGORY_MAP.put("5", CATEGORY_QT);//����
	}
	
	/**
	 * instock���ѯ���������ʽ
	 */
	public static final String INSTOCK_SORT_BYINTIME = "BYINTIME";
	public static final String INSTOCK_SORT_BYINCODE = "BYINCODE";//����Ʒ�������
	public static final String INSTOCK_SORT_BYINTIME_DESC = "BYINTIMEDESC";//����Ʒ���ʱ�併��
	
	/**
	 * outstock��ѯ���������ʽ
	 */
	public static final String OUTSTOCK_SORT_BYOUTTIME = "BYOUTTIME";
	
	/**
	 * outstock��ѯ���������ʽ
	 */
	public static final String OUTSTOCK_SORT_BYORG = "BYORG";
	
	/**
	 * outstock��ѯ���������ʽ
	 */
	public static final String OUTSTOCK_SORT_BYSEQCODE = "BYSEQCODE";
	
	/**
	 * �ֿ�����outstock��ѯ���������ʽ
	 */
	public static final String OUTSTOCK_SORTTYPE_0169 = "0169";
	
	/**
	 * ��Ʒ����outstockdetail��ѯ���������ʽ
	 */
	public static final String OUTSTOCKDETAIL_SORTTYPE_0171 = "0171";
	
	/**
	 * �ĲĹ���Ĭ�Ͻ�ɫ���ͣ������͵Ľ�ɫ�����˿��Թ������п��
	 */
	public static final String ITEMS_ROLETYPE = ResourceUtility.getString("ITEMS_ROLETYPE");//�ĲĽ�ɫĬ�Ͻ�ɫ����
	
	/**
	 * ��Ʒ�������
	 */
	public static final String ITEMSCATEGORY_STATUS_QY = "1";
	
	/**
	 * ��Ʒ���ͣ��
	 */
	public static final String ITEMSCATEGORY_STATUS_TY = "0";
	
	/**
	 * δ����״̬�����������ۿ��޸�
	 */
	public static final String INSTOCK_PRICE_EDIT_TRUE = "1";//
	/**
	 * �ѽ���״̬�����������۲����޸�
	 */
	public static final String INSTOCK_PRICE_EDIT_FALSE = "0";//
	
	/**
	 * �ɽ���
	 */
	public static final String ACCOUNTSTATUS_TRUE = "1";//
	/**
	 * ���ɽ���
	 */
	public static final String ACCOUNTSTATUS_FALSE = "0";//
	
	/**
	 * ��Ʒ���ʣ�����
	 */
	public static final String ITEMSCODES_STOCK_NATURE_ZZ = "1";
	
	/**
	 * ��Ʒ���ʣ�����
	 */
	public static final String ITEMSCODES_STOCK_NATURE_WL = "2";
	/**
	 * ����ʾ����ʱ�ô˷��Ŵ���
	 */
	public static final String SEPARATOR = "/";//
	
	/**
	 * �²�ʱ��Ҫ���˵Ļ����Ĳ���뼯��
	 */
	public static final String NOT_SHOW_LIST = ResourceUtility.getString("NOT_SHOW_ORGLIST");
	
	/**
	 * �²�ȫ��
	 */
	public static final String XB_TYPE_QB = ResourceUtility.getString("XB_QB");
	
	/**
	 * �²�����
	 */
	public static final String XB_TYPE_ZONGH = ResourceUtility.getString("XB_ZONGH");
	
	/**
	 * �²�֧��
	 */
	public static final String XB_TYPE_ZHIH = ResourceUtility.getString("XB_ZHIH");
	
	/**
	 * ���л�������
	 */
	public static final String ZONGH_ORGNO = ResourceUtility.getString("ZONGH_ORG");
	
	/**
	 * ֧�л�������
	 */
	public static final String ZHIH_ORGNO = ResourceUtility.getString("ZHIH_ORG");
	
	/**
	 * �豸�����ԱĬ�Ͻ�ɫ����
	 */
	public static final String MNT_ROLETYPE = ResourceUtility.getString("MNT_ROLETYPE");
}