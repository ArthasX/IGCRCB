/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.bl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;



/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����ԭ������س���
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGRAWCIType {
	
	private static Map<String, String> valueMap = new HashMap<String, String>();
	
	static{
		valueMap.put("logic", "�߼�����");
		valueMap.put("physical", "Ӳ����Ϣ");
		valueMap.put("software", "�����Ϣ");
		valueMap.put("mem", "�ڴ���Ϣ");
		valueMap.put("part", "������Ϣ");
		valueMap.put("cpu", "CPU��Ϣ");
		valueMap.put("disk", "������Ϣ");
		valueMap.put("bus", "������Ϣ");
		valueMap.put("pci", "PCI��չ");
		valueMap.put("bios", "BIOS��Ϣ");
		valueMap.put("driver", "������Ϣ");
		valueMap.put("if", "������Ϣ");
		valueMap.put("os", "ϵͳ��Ϣ");
		valueMap.put("fs", "�ļ�ϵͳ");
		valueMap.put("env", "��������");
		valueMap.put("hba", "HBA����");
		valueMap.put("vg", "������Ϣ");
		valueMap.put("pv", "������Ϣ");
		valueMap.put("env", "��������");
		valueMap.put("IO", "IO�豸");
		valueMap.put("map", "ӳ���ϵ");
		valueMap.put("mc", "΢����Ϣ");
		valueMap.put("fc", "���˽ӿ�");
		valueMap.put("vhost", "��������");
		valueMap.put("port", "�˿�");
		valueMap.put("da", "��˿�");
		valueMap.put("ddm", "�豸����");
		valueMap.put("array", "����Ϣ");
		valueMap.put("fbvol", "�־���Ϣ");
		valueMap.put("stgencl", "������Ϣ");
		valueMap.put("hostconnect", "��������");
		valueMap.put("extpool", "��չ��");
		valueMap.put("volgrp", "������Ϣ");
		//-------------------------------------ORACLE----------------------------------------------------------
		valueMap.put("ORACLE", "Oracle����");
		valueMap.put("DB_NAME", "���ݿ���Ϣ");
		valueMap.put("DB_USER", "�û���Ϣ");
		valueMap.put("DB_TABLESPACE", "��ռ���Ϣ");
		valueMap.put("DB_TABLE", "��������Ϣ");
		valueMap.put("DB_FILE", "���ݿ��ļ���Ϣ");
		//-------------------------------------VMWare----------------------------------------------------------
		valueMap.put("vmware", "VMWare����");
		valueMap.put("datacenter", "����������Ϣ");
		valueMap.put("cluster", "��Ⱥ��Ϣ");
		valueMap.put("datastore", "���ݴ洢��Ϣ");
		valueMap.put("host", "Esx������Ϣ");
		valueMap.put("lun", "Lun��Ϣ");
		valueMap.put("vm", "�������Ϣ");
		valueMap.put("datacenter", "����������Ϣ");
		//-------------------------------------sybase----------------------------------------------------------
		valueMap.put("sybase", "Sybase����");
		valueMap.put("Sybase", "Sybase���ݿ���Ϣ");
		valueMap.put("Device", "�豸��Ϣ");
		valueMap.put("User", "�û���Ϣ");
		valueMap.put("Table", "����Ϣ");
		//-------------------------------------informix----------------------------------------------------------
		valueMap.put("informix", "informix����");
		valueMap.put("Informix", "Informix���ݿ���Ϣ");
		valueMap.put("Dbs", "�����ļ���Ϣ");
		valueMap.put("Model Base", "����Ϣ");
		valueMap.put("OnConfig", "OnConfig��Ϣ");
		//-------------------------------------informix----------------------------------------------------------
		valueMap.put("server", "Tuxedo������Ϣ");
		valueMap.put("domian", "domian��Ϣ");
		valueMap.put("group", "Group��Ϣ");
		valueMap.put("machine", "machine��Ϣ");
	}
	
	public static String getCategory(String arg){
		String value = "ȱʡ";
		if(StringUtils.isNotEmpty(arg)){
			if(StringUtils.isNotEmpty(valueMap.get(arg))){
				value = valueMap.get(arg);
			}
		}
		return value;
	}
	
	public static String getKeys(String arg){
		StringBuffer value = new StringBuffer();
		if(StringUtils.isNotEmpty(arg)){
			String[] keys = arg.split(",");
			int index=0;
			for(String key:keys){
				if(index>0){
					value.append(",");
				}
				if(StringUtils.isNotEmpty(valueMap.get(key))){
					index++;
					value.append(valueMap.get(key));
				}
			}
		}
		return value.toString();
	}
}
