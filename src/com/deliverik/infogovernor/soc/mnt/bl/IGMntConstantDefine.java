/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.mnt.bl;

import java.lang.reflect.Field;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * ����:��Ϣ������س���
 * ��������:��Ϣ������س���
 * ������¼: ����ȫ 2011-9-20
 * �޸ļ�¼:
 */
public class IGMntConstantDefine {
	static Log log = LogFactory.getLog(IGMNT01BLImpl.class);
	// -------------------------- �����˵�������Ϣ --------------------------
	/** ������ͱ�ʶ */
	public static String COMPONENT_TYPE_CODE="800";
    /** SYSTEM_KPI��ʶ */
	public static String SYSTEM_KPI_CODE="801";
    /** SYSTEM�ɼ������ʶ */
	public static String SYSTEM_VAL_CODE="802";
    /** RA_KPI��ʶ */
	public static String RA_KPI_CODE="803";
    /** RA�ɼ������ʶ */
	public static String RA_VAL_CODE="804";
    /** SA_KPI��ʶ */
	public static String SA_KPI_CODE="805";
    /** SA�ɼ������ʶ */
	public static String SA_VAL_CODE="806";
    /** CACHE_KPI��ʶ */
	public static String CACHE_KPI_CODE="807";
    /** CACHE�ɼ������ʶ */
	public static String CACHE_VAL_CODE="808";
    /**DA_KPI��ʶ */
	public static String DA_KPI_CODE="809";
    /** DA�ɼ������ʶ */
	public static String DA_VAL_CODE="810";
    /** DISK_KPI��ʶ */
	public static String DISK_KPI_CODE="811";
    /** DISK�ɼ������ʶ */
	public static String DISK_VAL_CODE="812";
    /** DIRECTOR_KPI��ʶ */
	public static String DIRECTOR_KPI_CODE="813";
    /** DIRECTOR�ɼ������ʶ */
	public static String DIRECTOR_VAL_CODE="814";
    /** PORT_KPI��ʶ */
	public static String PORT_KPI_CODE="815";
    /** PORT�ɼ������ʶ */
	public static String PORT_VAL_CODE="816";
	//-----------��Ӧcollect_object_list��object_type-----------
	/** system ��Ӧ������ */
	public static String SYSTEM="";
	/** RA ��Ӧ������ */
	public static String RA="DIRECTORS_RDF";
	/** SA ��Ӧ������ */
	public static String SA="DIRECTORS_FE";
	/** Cache ��Ӧ������ */
	public static String CACHE="DIRECTORS_FE";
	/** DA ��Ӧ������ */
	public static String DA="DIRECTORS_DA";
	/** Disk ��Ӧ������ */
	public static String DISK="DISK";
	/** Director ��Ӧ������ */
	public static String DIRECTOR="DIRECTORS_FE,DIRECTORS_DA";
	/** Ports ��Ӧ������ */
	public static String PORT="PORTS_FE";
	
	//--------����״̬--------
	/** ���*/
	public static String TASKSTATUSACTIVITY="0"; 
	/** �ѹر� */
	public static String TASKSTATUSACLOSE="1"; 
	/** û���˳���ť */
	public static String NOEXITFLAG="1";
	/** ���˳���ť */
	public static String ISEXITFLAG="1";
	/**����Ĭ��Ϊ120��*/
	public static String INTERVAL_DEFAULT="Disk,Cache";
	/**Ĭ��Ϊ120*/
	public static String INTERVAL_DEFAULT_VAL="120";
	/**����Ĭ��Ϊ15��*/
	public static String INTERVAL_DEFAULT_OTHER_VAL="15";
	/**�����ʶ*/
	public static String ERR_FLAG="ERR";
	/**��������*/
	public static String MONITOR_OBJTYPE="Symmetrix";
	/**
	 * �÷����ȡ����ֵ
	 * @param fieldName ����ֵ
	 * @return
	 */
	public static String getValue(String fieldName){
		IGMntConstantDefine iGMntConstantDefine=new IGMntConstantDefine();
		String valueStr="";
		try{
			Field value=iGMntConstantDefine.getClass().getField(fieldName);
			 valueStr=(String) value.get(iGMntConstantDefine);
		}catch (Exception e) {
			log.error("========��ȡ"+fieldName+"û�л�ȡ��========");
		}
		return valueStr;
	}
}
