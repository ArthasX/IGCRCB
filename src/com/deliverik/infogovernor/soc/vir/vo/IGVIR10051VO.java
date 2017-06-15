/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.vir.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.infogovernor.soc.vir.vim.model.Host;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���⻯������ҳVO
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGVIR10051VO extends BaseVO{

	/** �������� */
	protected Integer countS = 0;
	
	/** �������� */
	protected Integer countT = 0;
	
	/** �������� */
	protected Integer countH = 0;
	
	/** ������������ */
	protected Integer countS_C = 0;
	
	/** ���µ������� */
	protected Integer countT_C = 0;
	
	/** ���»������� */
	protected Integer countH_C = 0;
	
	/** Host��Ϣ���� */
	protected Map<Integer, List<Host>> hostMap;
	
	/** ��ҳ��ʾHost */
	protected List<List<Map<Integer, Host>>> showHostList;
	
	/** ��������top5���� */
	protected Map<String, Integer> top5Map;
	
	/** ����������� */
	protected List<Integer> monthCountS;
	
	/** ����������� */
	protected List<Integer> monthCountT;
	
	/** ����������� */
	protected List<Integer> monthCountH;

	/**
	 * ��������ȡ��
	 * @return countS ��������
	 */
	public Integer getCountS() {
		return countS;
	}
	
	/**
	 * ��������ȡ��
	 * @return countS ��������
	 */
	public String getCountSImg() {
		return numberConvertToImage(countS);
	}

	/**
	 * ���������趨
	 * @param countS ��������
	 */
	public void setCountS(Integer countS) {
		this.countS = countS;
	}

	/**
	 * ��������ȡ��
	 * @return countT ��������
	 */
	public Integer getCountT() {
		return countT;
	}
	
	/**
	 * ��������ȡ��
	 * @return countT ��������
	 */
	public String getCountTImg() {
		return numberConvertToImage(countT);
	}

	/**
	 * ���������趨
	 * @param countT ��������
	 */
	public void setCountT(Integer countT) {
		this.countT = countT;
	}

	/**
	 * ��������ȡ��
	 * @return countH ��������
	 */
	public Integer getCountH() {
		return countH;
	}
	
	/**
	 * ��������ȡ��
	 * @return countH ��������
	 */
	public String getCountHImg() {
		return numberConvertToImage(countH);
	}

	/**
	 * ���������趨
	 * @param countH ��������
	 */
	public void setCountH(Integer countH) {
		this.countH = countH;
	}

	/**
	 * ������������ȡ��
	 * @return countS_C ������������
	 */
	public Integer getCountS_C() {
		return countS_C;
	}

	/**
	 * �������������趨
	 * @param countS_C ������������
	 */
	public void setCountS_C(Integer countS_C) {
		this.countS_C = countS_C;
	}

	/**
	 * ���µ�������ȡ��
	 * @return countT_C ���µ�������
	 */
	public Integer getCountT_C() {
		return countT_C;
	}

	/**
	 * ���µ��������趨
	 * @param countT_C ���µ�������
	 */
	public void setCountT_C(Integer countT_C) {
		this.countT_C = countT_C;
	}

	/**
	 * ���»�������ȡ��
	 * @return countH_C ���»�������
	 */
	public Integer getCountH_C() {
		return countH_C;
	}

	/**
	 * ���»��������趨
	 * @param countH_C ���»�������
	 */
	public void setCountH_C(Integer countH_C) {
		this.countH_C = countH_C;
	}
	
	/**
	 * Host��Ϣ����ȡ��
	 * @return hostMap Host��Ϣ����
	 */
	public Map<Integer, List<Host>> getHostMap() {
		return hostMap;
	}

	/**
	 * Host��Ϣ�����趨
	 * @param hostMap Host��Ϣ����
	 */
	public void setHostMap(Map<Integer, List<Host>> hostMap) {
		this.hostMap = hostMap;
		if(hostMap != null){
			this.showHostList = new ArrayList<List<Map<Integer,Host>>>();
			List<Map<Integer, Host>> temp = new ArrayList<Map<Integer,Host>>();
			int index = 0;
			for(Iterator<Entry<Integer, List<Host>>> iter = hostMap.entrySet().iterator();iter.hasNext();){
				Entry<Integer, List<Host>> next = iter.next();
				Integer key = next.getKey();
				List<Host> list = next.getValue();
				for(Host host : list){
					if(index > 0 && index % 6 == 0){
						showHostList.add(temp);
						temp = new ArrayList<Map<Integer,Host>>();
					}
					Map<Integer, Host> map = new HashMap<Integer, Host>();
					map.put(key, host);
					temp.add(map);
					index ++;
				}
			}
			if(temp.size() > 0){
				showHostList.add(temp);
			}
		}
	}

	/**
	 * ��ҳ��ʾHostȡ��
	 * @return showHostList ��ҳ��ʾHost
	 */
	public List<List<Map<Integer, Host>>> getShowHostList() {
		return showHostList;
	}

	/**
	 * ��ҳ��ʾHost�趨
	 * @param showHostList ��ҳ��ʾHost
	 */
	public void setShowHostList(List<List<Map<Integer, Host>>> showHostList) {
		this.showHostList = showHostList;
	}

	/**
	 * ��������top5����ȡ��
	 * @return top5Map ��������top5����
	 */
	public Map<String, Integer> getTop5Map() {
		return top5Map;
	}

	/**
	 * ��������top5�����趨
	 * @param top5Map ��������top5����
	 */
	public void setTop5Map(Map<String, Integer> top5Map) {
		this.top5Map = top5Map;
	}

	/**
	 * �����������ȡ��
	 * @return monthCountS �����������
	 */
	public List<Integer> getMonthCountS() {
		return monthCountS;
	}

	/**
	 * ������������趨
	 * @param monthCountS �����������
	 */
	public void setMonthCountS(List<Integer> monthCountS) {
		this.monthCountS = monthCountS;
	}

	/**
	 * �����������ȡ��
	 * @return monthCountT �����������
	 */
	public List<Integer> getMonthCountT() {
		return monthCountT;
	}

	/**
	 * ������������趨
	 * @param monthCountT �����������
	 */
	public void setMonthCountT(List<Integer> monthCountT) {
		this.monthCountT = monthCountT;
	}

	/**
	 * �����������ȡ��
	 * @return monthCountH �����������
	 */
	public List<Integer> getMonthCountH() {
		return monthCountH;
	}

	/**
	 * ������������趨
	 * @param monthCountH �����������
	 */
	public void setMonthCountH(List<Integer> monthCountH) {
		this.monthCountH = monthCountH;
	}

	/**
	 * ����װ��ΪͼƬ
	 * @param number ����
	 * @return ͼƬHTML
	 */
	private String numberConvertToImage(Integer number){
		StringBuffer numStr = new StringBuffer();
		if(number == null || number == 0){
			numStr.append("<img src=\"images/number/0.png\" width=\"22\" height=\"29\"/>&nbsp;");
			numStr.append("<img src=\"images/number/0.png\" width=\"22\" height=\"29\"/>");
		}else if(number >= 99){
			numStr.append("<img src=\"images/number/9.png\" width=\"22\" height=\"29\"/>&nbsp;");
			numStr.append("<img src=\"images/number/9.png\" width=\"22\" height=\"29\"/>");
		}else if(number > 9){
			String s = number.toString();
			numStr.append("<img src=\"images/number/");
			numStr.append(s.charAt(0));
			numStr.append(".png\" width=\"22\" height=\"29\"/>&nbsp;");
			numStr.append("<img src=\"images/number/");
			numStr.append(s.charAt(1));
			numStr.append(".png\" width=\"22\" height=\"29\"/>");
		}else{
			numStr.append("<img src=\"images/number/0.png\" width=\"22\" height=\"29\"/>&nbsp;");
			numStr.append("<img src=\"images/number/");
			numStr.append(number);
			numStr.append(".png\" width=\"22\" height=\"29\"/>");
		}
		return numStr.toString();
	}
}
