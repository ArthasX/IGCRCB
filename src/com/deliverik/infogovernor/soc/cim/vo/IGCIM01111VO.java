/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.cim.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.infogovernor.asset.vo.IGCIM01112VO;
import com.deliverik.infogovernor.soc.cim.bl.IGRAWCIType;
import com.deliverik.infogovernor.soc.model.CR01VWInfo;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ����Դ���ݰ汾�Ƚ�vo
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGCIM01111VO extends BaseVO{

	/** �豸������Ϣ */
	protected SOC0118Info entityItem;
	
	/** ���⼯�� */
	protected List<String> titleList;
	
	/** ��ʾ���� */
	protected Map<String, List<IGCIM01112VO>> data;
	
	/** �ɼ�������༯�� */
	protected Map<String, List<String>> categorys;
	
	/**�ɼ��ļ���*/
	protected String host;
	
	
	/**
	 * ���췽��
	 */
	public IGCIM01111VO(){
		
	}
	
	/**
	 * ���췽��
	 */
	public IGCIM01111VO(Map<String, List<CR01VWInfo>> crMap){
		if(crMap!=null){
			if(titleList==null){
				//�ı����ݽṹ
				Map<String, Map<String, List<CR01VWInfo>>> dataMap = new LinkedHashMap<String, Map<String,List<CR01VWInfo>>>();
				String[] title = new String[crMap.size()];
				int index = 0;
				for(String key:crMap.keySet()){
					title[index] = key;
					index++;
					for(CR01VWInfo cr01:crMap.get(key)){
						if(dataMap.get(cr01.getCommand())==null){
							List<CR01VWInfo> tempList = new ArrayList<CR01VWInfo>();
							tempList.add(cr01);
							Map<String, List<CR01VWInfo>> tempMap = new HashMap<String, List<CR01VWInfo>>();
							tempMap.put(key, tempList);
							dataMap.put(cr01.getCommand(), tempMap);
						}else{
							if(dataMap.get(cr01.getCommand()).get(key)==null){
								List<CR01VWInfo> tempList = new ArrayList<CR01VWInfo>();
								tempList.add(cr01);
								dataMap.get(cr01.getCommand()).put(key, tempList);
							}else{
								dataMap.get(cr01.getCommand()).get(key).add(cr01);
							}
						}
					}
				}
				Arrays.sort(title);
				//�������
				titleList = new ArrayList<String>();
				categorys = new LinkedHashMap<String, List<String>>();
				titleList.add("�������");
				titleList.add("�ؼ���");
				titleList.add("�ɼ�����");
				for(String s:title){
					titleList.add(s);
				}
				//��������
				data = new LinkedHashMap<String, List<IGCIM01112VO>>();
				for(String key:dataMap.keySet()){
					IGCIM01112VO vo = new IGCIM01112VO();
					vo.setCommand(key);
					//ȡ�ñ��Ƚ�����
					List<CR01VWInfo> list1 = dataMap.get(key).get(title[0]);
					if(list1!=null&&list1.size()>0){
						vo.setCategory(IGRAWCIType.getKeys(list1.get(0).getCategory()));
						vo.setKeys(IGRAWCIType.getKeys(list1.get(0).getKeys()));
					}else{
						vo.setCategory("");
						vo.setKeys("");
					}
					//�Ƚ�����ȡ��
					List<CR01VWInfo> list2 = dataMap.get(key).get(title[1]);
					
					//�ж�����
					Map<Integer, CR01VWInfo> map1 = new HashMap<Integer, CR01VWInfo>();
					Map<Integer, CR01VWInfo> map2 = new HashMap<Integer, CR01VWInfo>();
					if(list1!=null&&list1.size()>0){
						for(CR01VWInfo cr:list1){
							map1.put(cr.getCdataorder(), cr);
						}
					}
					if(list2!=null&&list2.size()>0){
						for(CR01VWInfo cr:list2){
							map2.put(cr.getCdataorder(), cr);
						}
					}
					
					//���ñ��Ƚ�����
					if(list1!=null&&list1.size()>0){
						if(list1.size()>1){
							vo.setCompare1(map1.get(list1.get(0).getCdataorder()).getCdata()+"... ...");
						}else{
							if (map1.get(0) != null) {
								vo.setCompare1(map1.get(0).getCdata());
							} else {
								vo.setCompare1(map1.get(1).getCdata());
							}
						}
					}else{
						vo.setCompare1("");
					}
					//���ñȽ�����
					if(list2!=null&&list2.size()>0){
						if(list2.size()>1){
							vo.setCompare2(map2.get(list2.get(0).getCdataorder()).getCdata()+"... ...");
						}else{
							if (map2.get(0) != null) {
								vo.setCompare2(map2.get(0).getCdata());
							} else {
								vo.setCompare2(map2.get(1).getCdata());
							}
						}
					}else{
						vo.setCompare2("");
					}
					//�Ƚ����ݽ��
					boolean flag = false;
					
					//������Ƚ����ݺͱȽ����ݶ�Ϊ�գ��򲻱��ٱȽ�
					if((list1==null||list1.isEmpty())&&(list2==null||list2.isEmpty())){
						continue;
					}
					
					//�жϱ��Ƚ����������ϵĲ���
					if(((list1==null||list1.isEmpty())!=(list2==null||list2.isEmpty()))||(list1.size()!=list2.size())){
						flag = true;
					}else{
						for(Integer order:map1.keySet()){
							if(map2.get(order)==null){
								flag = true;
								break;
							}else{
								if(!map1.get(order).getCdata().equals(map2.get(order).getCdata())){
									flag = true;
									vo.setCompare1(map1.get(order).getCdata()+(map1.size()>1?"... ...":""));
									vo.setCompare2(map2.get(order).getCdata()+(map2.size()>1?"... ...":""));
									break;
								}
							}
						}
					}
					if (flag) {
						vo.setCompareStyle(" background:#ffff99;");
					}
					String mapKey = vo.getCategory();
					//��װ����
					if(data.get(mapKey)==null){
						List<IGCIM01112VO> datatemplist = new ArrayList<IGCIM01112VO>();
						datatemplist.add(vo);
						data.put(mapKey, datatemplist);
					}else{
						data.get(mapKey).add(vo);
					}
					
					//��װcategory��Ϣ
					String category = vo.getCategory();
					String[] keys = vo.getKeys()==null?null:vo.getKeys().split(",");
					if(categorys.get(category)==null){
						if(keys==null){
							categorys.put(category, new ArrayList<String>());
						}else{
							List<String> keysList = new ArrayList<String>();
							for(String s:keys){
								keysList.add(s);
							}
							categorys.put(category, keysList);
						}
					}else{
						if(keys!=null){
							for(String s:keys){
								if(!categorys.get(category).contains(s)){
									categorys.get(category).add(s);
								}
							}
						}
					}
				}
				
			}
		}
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
	 * ���⼯��ȡ��
	 * @return ���⼯��
	 */
	public List<String> getTitleList() {
		return titleList;
	}

	/**
	 * ���⼯���趨
	 * @param titleList ���⼯��
	 */
	public void setTitleList(List<String> titleList) {
		this.titleList = titleList;
	}

	/**
	 * ��ʾ����ȡ��
	 * @return ��ʾ����
	 */
	public Map<String, List<IGCIM01112VO>> getData() {
		return data;
	}

	/**
	 * ��ʾ�����趨
	 * @param data ��ʾ����
	 */
	public void setData(Map<String, List<IGCIM01112VO>> data) {
		this.data = data;
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
	 * �ɼ��ļ���ȡ��
	 *
	 * @return host �ɼ��ļ���
	 */
	
	public String getHost() {
		return host;
	}

	/**
	 * �ɼ��ļ����趨
	 *
	 * @param host �ɼ��ļ���
	 */
	
	public void setHost(String host) {
		this.host = host;
	}
	
	
	
}
