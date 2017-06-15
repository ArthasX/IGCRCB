/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.framework.soc.asset;

/**
 * 
 * ��ϵͼ��س�����
 *
 */
public final class EiRelationKeyWords {
	
	/** ϵͳ */	
	public static final String SYS = "999003001";
	
	/** Ӧ�� */	
	public static final String APPLICATION = "999003002";
	
	/** ϵͳ */	
	public static final String APP = "999003";
	
	/** ���� */	
	public static final String HOST = "999001001";
	
	/** HBA�� */	
	public static final String HBA = "999001002";
	
	/** HBA�˿� */	
	public static final String HBAPORT = "999001003";
	
	/** ������ */	
	public static final String SWITCH = "999001006";
	
	/** ���罻���� */	
	public static final String NETSWITCH = "999001006004";
	
	/** ���罻�����˿� */	
	public static final String NETSWITCH_PORT = "999001023";
	
	/** ���罻����VLAN */	
	public static final String NETSWITCH_VLAN = "999001024";
	
	/** �洢 */	
	public static final String STORAGE = "999001009";
	
	/** �洢֮DMX */	
	public static final String STORAGE_DMX = "999001009001";
	
	/** ǰ�˿� */	
	public static final String FRONTPORT = "999001011";
	
	/** DISK */	
	public static final String DISK = "999001013";
	
	/** DA */	
	public static final String DA = "999001012";
	
	/** SANPORT */	
	public static final String SANPORT = "999001008";
	
	/** FA */	
	public static final String FA = "999001010";
	
	/** FS */	
	public static final String FS = "999001016";
	
	/** VG */	
	public static final String VG = "999001004";
	
	/** LV */	
	public static final String LV = "999001005";
	
	/** PV */	
	public static final String PV = "999001017";
	
	/** PP */	
	public static final String PP = "999001019";
	
	/** ZONE */	
	public static final String ZONE = "999001018";
	
	/** META */	
	public static final String META = "999001015";
	
	/** HYPER */	
	public static final String HYPER = "999001014";
	
	/** ҵ��ϵͳ-Ӧ��ģ�� */	
	public static final String EIR_ID_18 = "18";
	
	/** ҵ��ϵͳ-���� */	
	public static final String EIR_ID_3 = "CR030100010001";
	
	/** ===================����ͨ·=================== */	
		
	/** ����-HBA�� */	
	public static final String EIR_ID_201 = "CR010100010001";
	
	/** HBA��-HBA Port */	
	public static final String EIR_ID_202 = "CR010100020001";
	
	/** HBA Port-SAN Port */	
	public static final String EIR_ID_203 = "CR010100030001";
	
	/** SAN Port-SAN ģ�� */	
	public static final String EIR_ID_204 = "CR010100080001";
	
	/** SAN ģ��-SAN ������ */	
	public static final String EIR_ID_205 = "CR010100070001";
	
	/** SAN ������-SAN ģ�� */	
	public static final String EIR_ID_206 = "CR010100060001";
	
	/** SAN ģ��-SAN Port */	
	public static final String EIR_ID_207 = "CR010100070002";
	
	/** SAN Port-ǰ�˿� */	
	public static final String EIR_ID_208 = "CR010100080002";
	
	/** ǰ�˿�-FA */	
	public static final String EIR_ID_209 = "CR010100110001";
	
	/** FA-�������� */	
	public static final String EIR_ID_210 = "CR010100100001";
	
	/** ��������-DA */	
	public static final String EIR_ID_211 = "CR010100090001";
	
	/** DA-Disk */	
	public static final String EIR_ID_212 = "CR010100120001";
	
	/** ����-�������� */	
	public static final String EIR_ID_222 = "CR010100010005";
	
	/** ����-Disk */	
	public static final String EIR_ID_230 = "CR010100010008";
	
	/** ����-ǰ�˿� */	
	public static final String EIR_ID_231 = "CR010100010009";
	
	/** SAN ������-SAN Port */	
	public static final String EIR_ID_225 = "CR010100060002";
	
	/** SAN ������-zone */	
	public static final String EIR_ID_226 = "CR010100060003";
	
	/** zone- port*/	
	public static final String EIR_ID_227 = "CR010200180001";
			
	/** ===================�߼�ͨ·=================== */	
	
	/** ����-FS */	
	public static final String EIR_ID_213 = "CR010100010002";
	
	/** ����-LV */	
	public static final String EIR_ID_214 = "CR010100010003";
	
	/** ����-VG */	
	public static final String EIR_ID_215 = "CR010100010004";
	
	/** FS-LV */	
	public static final String EIR_ID_216 = "CR010200160001";
	
	/** LV-PV */	
	public static final String EIR_ID_217 = "CR010200050001";
	
	/** PV-Meta */	
	public static final String EIR_ID_218 = "CR010100170001";
	
	/** Meta-Hyper */	
	public static final String EIR_ID_219 = "CR010200150001";
	
	/** Hyper-Disk */	
	public static final String EIR_ID_220 = "CR010200140001";
	
	/** VG-PV */	
	public static final String EIR_ID_221 = "CR010200040001";
	
	/** ����-meta */
	public static final String EIR_ID_228 = "CR010100010007";
	
	/** meta-disk */
	public static final String EIR_ID_229 = "CR010200150002";
	
	/** Ӧ��-������ϵ */
	public static final String EIR_ID_200 = "CR030100010001";
	
	/** PV-PP */
	public static final String EIR_ID_224 = "CR010200170002";
	
	
	/** ���ݿ��û�*/	
	public static final String DB_USER = "�û�";
	
	/** ���ݿ��ռ�*/	
	public static final String DB_TABLESPACE = "��ռ�";
	
	/** �豸�ʲ�*/
	public static final String DEVICE = "999001";
	
	/** ����ʲ�*/
	public static final String SOFTWARE = "999002";
	
	private EiRelationKeyWords() {
	}
	
}
