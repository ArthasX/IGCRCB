package com.deliverik.infogovernor.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;

/**
 * �ʲ���������Ϣ�汾�Ƚ���Ϣ�֣�
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCOM03071VO extends BaseVO implements Serializable{
	
	/** �ʲ�����Ϣ */
	protected SOC0124Info entityItemData;
	
	/** �ʲ���������Ϣ������� */
	protected List<SOC0107Info> configItemList;
	
	/** ��ʾVO */
	protected List<IGCOM03072VO> voList;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	/** �汾���� */
	protected Map<String, String> versionDate;
	
	/** �汾���� */
	protected Integer versionsize = 0;

	/**
	 * ���캯��
	 * @param entityItemData���ʲ�����Ϣ
	 * @param configItemList���ʲ���������Ϣ�������
	 */
	public IGCOM03071VO(SOC0124Info entityItemData,List<SOC0107Info> configItemList) {
		this.entityItemData = entityItemData;
		this.configItemList = configItemList;
		
		if(configItemList != null && !configItemList.isEmpty()) {
			if(this.versionDate == null) {
				//��¼���汾����
				this.versionDate = new LinkedHashMap<String,String>();
				//�汾���ϣ�����
				List<String> versionList = new ArrayList<String>(); 
				for(SOC0107Info ci : configItemList) {
					String key = ci.getCiversion().toString();
					if("1".equals(entityItemData.getEmodeltype())) {
						key = ci.getCiversion() + "." + ci.getCismallversion();
					}
					if(!versionDate.containsKey(key)) {
						versionDate.put(key, ci.getCiupdtime().substring(0,10));
						versionList.add(key);
					}
				}
				//����
				Collections.reverse(versionList);
				//��¼���汾����
				Map<String,String> versionDate_temp = new LinkedHashMap<String,String>();
				for(String version : versionList) {
					versionDate_temp.put(version, versionDate.get(version));
				}
				//�滻
				this.versionDate = versionDate_temp;
				this.versionsize = this.versionDate.size();
			}
			this.voList = new ArrayList<IGCOM03072VO>();
			Map<String,Integer> map = new HashMap<String,Integer>();
			//����������
			String ccategory = "";
			//VO���
			int i = -1;
			for(SOC0107Info ci :configItemList) {
				if(map.containsKey(ci.getConfiguration().getCcategory())) {
					this.voList.get(map.get(ci.getConfiguration().getCcategory())).addConfigItem(ci);
				} else {
					ccategory = ci.getConfiguration().getCcategory();
					this.voList.add(new IGCOM03072VO());
					this.voList.get(++i).setVoList(new ArrayList<IGCOM03073VO>());
					this.voList.get(i).setCcategory(ccategory);
					this.voList.get(i).addConfigItem(ci);
					map.put(ccategory, i);
				}
			}
			//��ѯ����ǰ��汾������Ҫ������
			for(IGCOM03072VO vo : this.voList) {
				if(vo.getVoList() != null) {
					for(IGCOM03073VO v : vo.getVoList()) {
						if(vo.getVoList() != null) {
							if(v.getConfigItemList() != null) {
								//length>0������������ͣ�õ����ԣ���ʾʱ��Ҫ����
								int length =  this.versionDate.size() - v.getConfigItemList().size();
								if(length > 0) {
									List<SOC0107Info> ciList = new ArrayList<SOC0107Info>();
									Set<Map.Entry<String,String>> set = versionDate.entrySet();
									for(Iterator<Map.Entry<String,String>> iter = set.iterator();iter.hasNext();){
										Map.Entry<String,String> entry = iter.next();
										SOC0107Info nullCi =  null;
										for(SOC0107Info ci : v.getConfigItemList()) {
											String key = ci.getCiversion().toString();
											if("1".equals(entityItemData.getEmodeltype())) {
												key = ci.getCiversion() + "." + ci.getCismallversion();
											}
											if(entry.getKey().equals(key)) {
												nullCi = ci;
												break;
											}
										}
										//����
										if(nullCi == null) {
											ciList.add(new SOC0107TB());
										} else {
											ciList.add(nullCi);
										}
									}
									v.getConfigItemList().clear();
									v.getConfigItemList().addAll(ciList);//�ò������б���
								} else {
									Collections.reverse(v.getConfigItemList());
								}
							}
						}
					}
				}
			}
			//�ʲ����԰�ccategory����չʾtabҳ
			Set<String> keySet = map.keySet();
			List<String> list = new ArrayList<String>();
			list.addAll(keySet);
			Collections.sort(list);
			List<IGCOM03072VO> dispList = new ArrayList<IGCOM03072VO>();
			for(String key : list){
				for(IGCOM03072VO vo : this.voList) {
					if(key.equals(vo.getCcategory())){
						dispList.add(vo);
						break;
					}
				}
			}
			this.voList = dispList;
		}
	}
	
	/**
	 * �ʲ�����Ϣȡ��
	 * @return �ʲ�����Ϣ
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * Ȩ�ޱ�ʶȡ��
	 * @return Ȩ�ޱ�ʶ
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * Ȩ�ޱ�ʶ�趨
	 * @param flag Ȩ�ޱ�ʶ
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * ��ʾVOȡ��
	 * @return ��ʾVO
	 */
	public List<IGCOM03072VO> getVoList() {
		return voList;
	}

	/**
	 * �汾����ȡ��
	 * @return �汾����
	 */
	public Map<String, String> getVersionDate() {
		return versionDate;
	}

	public Integer getVersionsize() {
		return versionsize;
	}

}


