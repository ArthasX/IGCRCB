/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.soc.cim.bl.IGRAWCIType;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;
import com.deliverik.infogovernor.soc.model.CR03Info;
import com.deliverik.infogovernor.soc.model.CR03VWInfo;
import com.deliverik.infogovernor.soc.model.entity.CR01VW;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:����ԭ������ʾvo 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIM01101VO extends BaseVO{

	/** �豸��������Ϣ */
	protected SOC0118Info entityItem;
	
	/** ԭ������������ */
	protected List<CR03Info> cr03List;
	
	/** �ɼ���¼�汾��Ϣ */
	protected CR03Info cr03;
	
	/** �ɼ���¼�汾��Ϣ(��) */
	protected CR03VWInfo cr03VW;
	
	/** �ɼ�������� */
	protected List<CR01VWInfo> cr01List;
	
	/** ��ʾ��ʶ */
	protected String showFlag;
	
	/** ����ҳ����ת���� */
	protected String otherFlag;

	/** ����չ��map */
	protected Map<String, Map<String, CR01VWInfo>> dataMap =new LinkedHashMap<String, Map<String,CR01VWInfo>>();
	
	/** �ɼ�������༯�� */
	protected Map<String, List<String>> categorys;
	
	/**�ɼ��ļ�����*/
	protected String host;
	
	/** �ɼ��汾�б� */
	protected List<CR03VWInfo> cr03VWList;	
	
	
	
	public List<CR03VWInfo> getCr03VWList() {
		return cr03VWList;
	}

	public void setCr03VWList(List<CR03VWInfo> cr03VWList) {
		this.cr03VWList = cr03VWList;
	}

	/**
	 * �豸������Ϣȡ��
	 * @return �豸������Ϣ
	 */
	public SOC0118Info getEntityItem() {
		return entityItem;
	}

	/**
	 * �豸������Ϣ�趨
	 * @param entityItem �豸������Ϣ
	 */
	public void setEntityItem(SOC0118Info entityItem) {
		this.entityItem = entityItem;
	}

	/**
	 *  ԭ������������ȡ��
	 * @return  ԭ������������
	 */
	public List<CR03Info> getCr03List() {
		return cr03List;
	}

	/**
	 *  ԭ�������������趨
	 * @param cr03List  ԭ������������
	 */
	public void setCr03List(List<CR03Info> cr03List) {
		this.cr03List = cr03List;
	}
	
	/**
	 * �ɼ���¼�汾��Ϣȡ��
	 * @return �ɼ���¼�汾��Ϣ
	 */
	public CR03Info getCr03() {
		return cr03;
	}

	/**
	 * �ɼ���¼�汾��Ϣ�趨
	 * @param cr03 �ɼ���¼�汾��Ϣ
	 */
	public void setCr03(CR03Info cr03) {
		this.cr03 = cr03;
	}

	/**
	 * �ɼ��������ȡ��
	 * @return �ɼ��������
	 */
	public List<CR01VWInfo> getCr01List() {
		return cr01List;
	}

	/**
	 * �ɼ��������ȡ���趨
	 * @param cr01List �ɼ��������ȡ��
	 */
	public void setCr01List(List<CR01VWInfo> cr01List) {
		this.cr01List = cr01List;
		if(cr01List!=null){
			if(this.dataMap == null||this.dataMap.size()==0){
				dataMap = new LinkedHashMap<String, Map<String, CR01VWInfo>>();
				categorys = new LinkedHashMap<String, List<String>>();
				for(CR01VWInfo cr01Info:cr01List){
					/*--------��װ��ʾ������Ϣ-------*/
					String key = IGRAWCIType.getCategory(cr01Info.getCategory());
					CR01VW cr01 = (CR01VW) SerializationUtils.clone(cr01Info);
					cr01.setKeys(IGRAWCIType.getKeys(cr01Info.getKeys()));
					if(dataMap.get(key)==null){
						Map<String, CR01VWInfo> tempmap = new LinkedHashMap<String, CR01VWInfo>();
						tempmap.put(cr01.getCommand(), cr01);
						dataMap.put(key, tempmap);
					}else{
						if(dataMap.get(key).get(cr01.getCommand())==null){
							dataMap.get(key).put(cr01.getCommand(), cr01);
						}else{
							String data = dataMap.get(key).get(cr01.getCommand()).getCdata();
							if(StringUtils.isNotEmpty(data)&&!"null".equals(data)&&(data.length()<8||!"... ...".equals(data.substring(data.length()-7)))){
								CR01VW cr = (CR01VW) SerializationUtils.clone(dataMap.get(key).get(cr01.getCommand()));
								cr.setCdata(data+"... ...");
								dataMap.get(key).put(cr01.getCommand(), cr);
							}
						}
					}
					/*--------��װ������Ϣ-------*/
					String[] keys = StringUtils.isNotEmpty(cr01.getKeys())? cr01.getKeys().split(","):null;
					if(categorys.get(key)==null){
						if(keys!=null){
							List<String> keyList = new ArrayList<String>();
							for(String s:keys){
								keyList.add(s);
								categorys.put(key, keyList);
							}
						}else{
							categorys.put(key, null);
						}
					}else{
						List<String> list = categorys.get(key);
						if(keys!=null){
							for(String s:keys){
								if(!list.contains(s)){
									list.add(s);
								}
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * ��ʾ��ʶȡ��
	 * @return ��ʾ��ʶ
	 */
	public String getShowFlag() {
		return showFlag;
	}

	/**
	 * ��ʾ��ʶ�趨
	 * @param showFlag ��ʾ��ʶ
	 */
	public void setShowFlag(String showFlag) {
		this.showFlag = showFlag;
	}
	
	/**
	 * ����չ��mapȡ��
	 * @return ����չ��map
	 */
	public Map<String,Map<String, CR01VWInfo>> getDataMap() {
		return dataMap;
	}

	/**
	 * �趨
	 * @param dataMap ����չ��map
	 */
	public void setDataMap(Map<String, Map<String, CR01VWInfo>> dataMap) {
		this.dataMap = dataMap;
	}

	/**
	 * �ɼ�������༯��ȡ��
	 * @return �ɼ�������༯��
	 */
	public Map<String, List<String>> getCategorys() {
		return categorys;
	}

	/**
	 * �ɼ�������༯���趨
	 * @param categorys �ɼ�������༯��
	 */
	public void setCategorys(Map<String, List<String>> categorys) {
		this.categorys = categorys;
	}
	/**
	 * �ɼ������ѯҳ����ת����ȡ��
	 * @return �ɼ������ѯҳ����ת����
	 */
	public String getOtherFlag() {
		return otherFlag;
	}
	/**
	 * �ɼ������ѯҳ����ת�����趨
	 * @return �ɼ������ѯҳ����ת����
	 */
	public void setOtherFlag(String otherFlag) {
		this.otherFlag = otherFlag;
	}

	/**
	 * �ɼ��ļ�����ȡ��
	 *
	 * @return host �ɼ��ļ�����
	 */
	
	public String getHost() {
		return host;
	}

	/**
	 * �ɼ��ļ������趨
	 *
	 * @param host �ɼ��ļ�����
	 */
	
	public void setHost(String host) {
		this.host = host;
	}
	
	/**
	 * �ɼ���¼�汾��Ϣȡ��
	 * @return
	 */
	public CR03VWInfo getCr03VW() {
		return cr03VW;
	}
	
	/**
	 * �ɼ���¼�汾��Ϣ�趨
	 * @param cr03VW
	 */
	public void setCr03VW(CR03VWInfo cr03VW) {
		this.cr03VW = cr03VW;
	}
	
}
