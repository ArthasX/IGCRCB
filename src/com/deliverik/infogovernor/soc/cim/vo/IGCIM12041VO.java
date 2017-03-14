package com.deliverik.infogovernor.soc.cim.vo;

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
 * 资产配置项信息版本比较信息ＶＯ
 * 
 * @author
 *
 */
@SuppressWarnings("serial")
public class IGCIM12041VO extends BaseVO implements Serializable{
	
	/** 资产项信息 */
	protected SOC0124Info entityItemData;
	
	/** 资产项配置信息检索结果 */
	protected List<SOC0107Info> configItemList;
	
	/** 显示VO */
	protected List<IGCIM12042VO> voList;
	
	/** 权限标识 */
	protected Boolean flag;
	
	/** 版本日期 */
	protected Map<String, String> versionDate;
	
	/** 版本个数 */
	protected Integer versionsize = 0;

	/**
	 * 构造函数
	 * @param entityItemData　资产项信息
	 * @param configItemList　资产项配置信息检索结果
	 */
	public IGCIM12041VO(SOC0124Info entityItemData,List<SOC0107Info> configItemList) {
		this.entityItemData = entityItemData;
		this.configItemList = configItemList;
		
		if(configItemList != null && !configItemList.isEmpty()) {
			if(this.versionDate == null) {
				//记录各版本日期
				this.versionDate = new LinkedHashMap<String,String>();
				//版本集合，倒序
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
				//正序
				Collections.reverse(versionList);
				//记录各版本日期
				Map<String,String> versionDate_temp = new LinkedHashMap<String,String>();
				for(String version : versionList) {
					versionDate_temp.put(version, versionDate.get(version));
				}
				//替换
				this.versionDate = versionDate_temp;
				this.versionsize = this.versionDate.size();
			}
			this.voList = new ArrayList<IGCIM12042VO>();
			Map<String,Integer> map = new HashMap<String,Integer>();
			//配置项类型
			String ccategory = "";
			//VO序号
			int i = -1;
			for(SOC0107Info ci :configItemList) {
				if(map.containsKey(ci.getConfiguration().getCcategory())) {
					this.voList.get(map.get(ci.getConfiguration().getCcategory())).addConfigItem(ci);
				} else {
					ccategory = ci.getConfiguration().getCcategory();
					this.voList.add(new IGCIM12042VO());
					this.voList.get(++i).setVoList(new ArrayList<IGCIM12043VO>());
					this.voList.get(i).setCcategory(ccategory);
					this.voList.get(i).addConfigItem(ci);
					map.put(ccategory, i);
				}
			}
			//查询结果是按版本倒序，需要正过来
			for(IGCIM12042VO vo : this.voList) {
				if(vo.getVoList() != null) {
					for(IGCIM12043VO v : vo.getVoList()) {
						if(vo.getVoList() != null) {
							if(v.getConfigItemList() != null) {
								//length>0表明有新增或停用的属性，显示时需要补齐
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
										//补齐
										if(nullCi == null) {
											ciList.add(new SOC0107TB());
										} else {
											ciList.add(nullCi);
										}
									}
									v.getConfigItemList().clear();
									v.getConfigItemList().addAll(ciList);//用补齐后的列表覆盖
								} else {
									Collections.reverse(v.getConfigItemList());
								}
							}
						}
					}
				}
			}
			//资产属性按ccategory排序展示tab页
			Set<String> keySet = map.keySet();
			List<String> list = new ArrayList<String>();
			list.addAll(keySet);
			Collections.sort(list);
			List<IGCIM12042VO> dispList = new ArrayList<IGCIM12042VO>();
			for(String key : list){
				for(IGCIM12042VO vo : this.voList) {
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
	 * 资产项信息取得
	 * @return 资产项信息
	 */
	public SOC0124Info getEntityData() {
		return entityItemData;
	}
	
	/**
	 * 权限标识取得
	 * @return 权限标识
	 */
	public Boolean getFlag() {
		return flag;
	}

	/**
	 * 权限标识设定
	 * @param flag 权限标识
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	/**
	 * 显示VO取得
	 * @return 显示VO
	 */
	public List<IGCIM12042VO> getVoList() {
		return voList;
	}

	/**
	 * 版本日期取得
	 * @return 版本日期
	 */
	public Map<String, String> getVersionDate() {
		return versionDate;
	}

	public Integer getVersionsize() {
		return versionsize;
	}

}


