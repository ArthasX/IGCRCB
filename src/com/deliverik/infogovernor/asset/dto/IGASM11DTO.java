package com.deliverik.infogovernor.asset.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.EquipmentInquireVWInfo;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0601Info;
import com.deliverik.framework.soc.asset.model.SOC0602Info;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.SOC0606Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0605SearchCond;
import com.deliverik.framework.user.model.User;
import com.deliverik.infogovernor.asset.form.IGASM1102Form;
import com.deliverik.infogovernor.asset.form.IGASM1104Form;
import com.deliverik.infogovernor.asset.form.IGASM1105Form;
import com.deliverik.infogovernor.asset.form.IGASM1112Form;
import com.deliverik.infogovernor.asset.form.IGASM1114Form;
import com.deliverik.infogovernor.asset.form.IGASM1115Form;
import com.deliverik.infogovernor.asset.form.IGASM1116Form;
import com.deliverik.infogovernor.asset.form.IGASM1120Form;

/**
 * @Description: �������ù���ҵ����DTO
 * @Author  
 * @History 2009-8-19     �½�
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 * @Version V2.0
 */
@SuppressWarnings("serial")
public class IGASM11DTO extends BaseDTO implements Serializable{

	/** ������Ϣ */
	protected IGASM1102Form igasm1102Form;
	
	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ����������� */
	protected List<SOC0601Info> computerRoomVWInfoList;

	/** ����ɾ������ */
	protected String[] deleteEntityItem;

	/** ������Ϣ�������� */
	protected SOC0605SearchCond entityItemVWSearchCond;
	
	/**���ϼܻ���XML */
	protected String jiguiXml;
	
	/**δ�ϼܻ���XML */
	protected String toolsXml;
	
	/**�����ذ�XML */
	protected String guodaoXML;
	
	/** ��ǰ����EIID */
	protected Integer eiid;
	/**��Ч�����ذ�XML */
	protected String wuxiaoXML;
	
	/**ͼ����ϢXML */
	protected String legendXML;
	
	/**��������XML */
	protected String relateRoomXML;
	
	/**3D����֧��IP��ѯForm */
	protected IGASM1120Form igasm1120Form;

	/**3D����֧��IP��ѯ��� */
	List<EquipmentInquireVWInfo> eilist;
	
	public String getRelateRoomXML() {
		return relateRoomXML;
	}

	public void setRelateRoomXML(String relateRoomXML) {
		this.relateRoomXML = relateRoomXML;
	}

	/** ������Ϣ */
	protected IGASM1112Form igasm1112Form;
	
	/** ����ƽ��ͼ�����ü������� */
	protected IGASM1104Form igasm1104Form;
	
	/** ����ƽ��ͼ�����û�����Ϣ */
	protected SOC0601Info computerRoomVWInfo;
	
	/** ������������������ */
	protected List<SOC0603Info> computerContainerVWInfoList;

	/** ����ѡ�����ü������� */
	protected IGASM1105Form igasm1105Form;
	
	/** ����ƽ��ͼ�����ü������� */
	protected IGASM1114Form igasm1114Form;
	
	/** ����ƽ��ͼ�����û�����Ϣ */
	protected SOC0603Info computerContainerVWInfo;
	
	/** ���������豸������� */
	protected List<SOC0602Info> computerDeviceVWInfoList;

	/** �豸ѡ�����ü������� */
	protected IGASM1115Form igasm1115Form;
	
	/** �豸������ϸ��Ϣ�ü������� */
	protected IGASM1116Form igasm1116Form;
	
	/** �豸������Ϣ������� */
	protected List<SOC0107Info> configItemList;

	/** �豸��Ϣ */
	protected SOC0605Info entityItemVWInfo;

	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0107Info>> configItemMap;
	
	/** �ʲ���������Ϣ������� */
	protected Map<String,List<SOC0606Info>> configItemVWInfoMap;
	
	/** �û����� */
	protected User user;
	
	/** Ȩ�ޱ�ʶ */
	protected Boolean flag;
	
	protected List<SOC0109Info> configurationList;
	protected List<SOC0606Info> configItemVWInfoList;
	
	/** �豸�߶�LIST */
	protected List<LabelValueBean> cubicalHeigthList;
	
	/** �豸�߶� */
	protected String cubicalHeigth;
	
	public Map<String, List<SOC0107Info>> getConfigItemMap() {
		return configItemMap;
	}

	public void setConfigItemMap(Map<String, List<SOC0107Info>> configItemMap) {
		this.configItemMap = configItemMap;
	}

	public Map<String, List<SOC0606Info>> getConfigItemVWInfoMap() {
		return configItemVWInfoMap;
	}

	public void setConfigItemVWInfoMap(
			Map<String, List<SOC0606Info>> configItemVWInfoMap) {
		this.configItemVWInfoMap = configItemVWInfoMap;
	}

	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public IGASM1102Form getIgasm1102Form() {
		return igasm1102Form;
	}

	/**
	 * ������Ϣ�趨
	 *
	 * @param igasm1102Form ������Ϣ
	 */
	public void setIgasm1102Form(IGASM1102Form igasm1102Form) {
		this.igasm1102Form = igasm1102Form;
	}

	/**
	 * ������Ϣ��������ȡ��
	 * @return ������Ϣ��������
	 */
	public SOC0605SearchCond getEntityItemVWSearchCond() {
		return entityItemVWSearchCond;
	}

	/**
	 * ������Ϣ���������趨
	 *
	 * @param entityItemVWSearchCond ������Ϣ��������
	 */
	public void setEntityItemVWSearchCond(
			SOC0605SearchCond entityItemVWSearchCond) {
		this.entityItemVWSearchCond = entityItemVWSearchCond;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����������趨
	 *
	 * @param maxSearchCount ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 *
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * �����������ȡ��
	 * @return �����������
	 */
	public List<SOC0601Info> getComputerRoomVWInfoList() {
		return computerRoomVWInfoList;
	}

	/**
	 * ������������趨
	 *
	 * @param entityItemVWInfoList �����������
	 */
	public void setComputerRoomVWInfoList(List<SOC0601Info> computerRoomVWInfoList) {
		this.computerRoomVWInfoList = computerRoomVWInfoList;
	}

	/**
	 * ����ɾ������ȡ��
	 * @return ����ɾ������
	 */
	public String[] getDeleteEntityItem() {
		return deleteEntityItem;
	}

	/**
	 * ����ɾ�������趨
	 *
	 * @param deleteEntityItem ����ɾ������
	 */
	public void setDeleteEntityItem(String[] deleteEntityItem) {
		this.deleteEntityItem = deleteEntityItem;
	}

	/**
	 * ������Ϣȡ��
	 * @return ������Ϣ
	 */
	public IGASM1112Form getIgasm1112Form() {
		return igasm1112Form;
	}

	/**
	 * ������Ϣ�趨
	 *
	 * @param igasm1112Form ������Ϣ
	 */
	public void setIgasm1112Form(IGASM1112Form igasm1112Form) {
		this.igasm1112Form = igasm1112Form;
	}

	/**
	 * ����ƽ��ͼ�����ü�������ȡ��
	 * @return ����ƽ��ͼ�����ü�������
	 */
	public IGASM1104Form getIgasm1104Form() {
		return igasm1104Form;
	}

	/**
	 * ����ƽ��ͼ�����ü��������趨
	 *
	 * @param igasm1104Form ����ƽ��ͼ�����ü�������
	 */
	public void setIgasm1104Form(IGASM1104Form igasm1104Form) {
		this.igasm1104Form = igasm1104Form;
	}

	/**
	 * ����ƽ��ͼ�����û�����Ϣȡ��
	 * @return ����ƽ��ͼ�����û�����Ϣ
	 */
	public SOC0601Info getComputerRoomVWInfo() {
		return computerRoomVWInfo;
	}

	/**
	 * ����ƽ��ͼ�����û�����Ϣ�趨
	 *
	 * @param computerRoomVWInfo ����ƽ��ͼ�����û�����Ϣ
	 */
	public void setComputerRoomVWInfo(SOC0601Info computerRoomVWInfo) {
		this.computerRoomVWInfo = computerRoomVWInfo;
	}

	/**
	 * ������������������ȡ��
	 * @return ������������������
	 */
	public List<SOC0603Info> getComputerContainerVWInfoList() {
		return computerContainerVWInfoList;
	}

	/**
	 * �������������������趨
	 *
	 * @param computerContainerVWInfoList ������������������
	 */
	public void setComputerContainerVWInfoList(
			List<SOC0603Info> computerContainerVWInfoList) {
		this.computerContainerVWInfoList = computerContainerVWInfoList;
	}

	/**
	 * ����ѡ�����ü�������ȡ��
	 * @return ����ѡ�����ü�������
	 */
	public IGASM1105Form getIgasm1105Form() {
		return igasm1105Form;
	}

	/**
	 * ����ѡ�����ü��������趨
	 *
	 * @param igasm1105Form ����ѡ�����ü�������
	 */
	public void setIgasm1105Form(IGASM1105Form igasm1105Form) {
		this.igasm1105Form = igasm1105Form;
	}

	/**
	 * ����ƽ��ͼ�����ü�������ȡ��
	 * @return ����ƽ��ͼ�����ü�������
	 */
	public IGASM1114Form getIgasm1114Form() {
		return igasm1114Form;
	}

	/**
	 * ����ƽ��ͼ�����ü��������趨
	 *
	 * @param igasm1114Form ����ƽ��ͼ�����ü�������
	 */
	public void setIgasm1114Form(IGASM1114Form igasm1114Form) {
		this.igasm1114Form = igasm1114Form;
	}

	/**
	 * ����ƽ��ͼ�����û�����Ϣȡ��
	 * @return ����ƽ��ͼ�����û�����Ϣ
	 */
	public SOC0603Info getComputerContainerVWInfo() {
		return computerContainerVWInfo;
	}

	/**
	 * ����ƽ��ͼ�����û�����Ϣ�趨
	 *
	 * @param computerContainerVWInfo ����ƽ��ͼ�����û�����Ϣ
	 */
	public void setComputerContainerVWInfo(
			SOC0603Info computerContainerVWInfo) {
		this.computerContainerVWInfo = computerContainerVWInfo;
	}

	/**
	 * ���������豸�������ȡ��
	 * @return ���������豸�������
	 */
	public List<SOC0602Info> getComputerDeviceVWInfoList() {
		return computerDeviceVWInfoList;
	}

	/**
	 * ���������豸��������趨
	 *
	 * @param computerDeviceVWInfoList ���������豸�������
	 */
	public void setComputerDeviceVWInfoList(
			List<SOC0602Info> computerDeviceVWInfoList) {
		this.computerDeviceVWInfoList = computerDeviceVWInfoList;
	}

	/**
	 * �豸ѡ�����ü�������ȡ��
	 * @return �豸ѡ�����ü�������
	 */
	public IGASM1115Form getIgasm1115Form() {
		return igasm1115Form;
	}

	/**
	 * �豸ѡ�����ü��������趨
	 *
	 * @param igasm1115Form �豸ѡ�����ü�������
	 */
	public void setIgasm1115Form(IGASM1115Form igasm1115Form) {
		this.igasm1115Form = igasm1115Form;
	}

	/**
	 * �豸������ϸ��Ϣ�ü�������ȡ��
	 * @return �豸������ϸ��Ϣ�ü�������
	 */
	public IGASM1116Form getIgasm1116Form() {
		return igasm1116Form;
	}

	/**
	 * �豸������ϸ��Ϣ�ü��������趨
	 *
	 * @param igasm1116Form �豸������ϸ��Ϣ�ü�������
	 */
	public void setIgasm1116Form(IGASM1116Form igasm1116Form) {
		this.igasm1116Form = igasm1116Form;
	}

	/**
	 * �豸��Ϣȡ��
	 * @return �豸��Ϣ
	 */
	public SOC0605Info getEntityItemVWInfo() {
		return entityItemVWInfo;
	}

	/**
	 * �豸��Ϣ�趨
	 *
	 * @param entityItemVWInfo �豸��Ϣ
	 */
	public void setEntityItemVWInfo(SOC0605Info entityItemVWInfo) {
		this.entityItemVWInfo = entityItemVWInfo;
	}

	/**
	 * �豸������Ϣ�������ȡ��
	 * @return �豸������Ϣ�������
	 */
	public List<SOC0107Info> getConfigItemList() {
		return configItemList;
	}

	/**
	 * �豸������Ϣ��������趨
	 *
	 * @param configItemList �豸������Ϣ�������
	 */
	public void setConfigItemList(List<SOC0107Info> configItemList) {
		this.configItemList = configItemList;
	}

	/**
	 * �û�����ȡ��
	 * @return �û�����
	 */
	public User getUser() {
		return user;
	}

	/**
	 * �û������趨
	 *
	 * @param user �û�����
	 */
	public void setUser(User user) {
		this.user = user;
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
	 *
	 * @param flag Ȩ�ޱ�ʶ
	 */
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

	public List<SOC0109Info> getConfigurationList() {
		return configurationList;
	}

	public void setConfigurationList(List<SOC0109Info> configurationList) {
		this.configurationList = configurationList;
	}

	public List<SOC0606Info> getConfigItemVWInfoList() {
		return configItemVWInfoList;
	}

	public void setConfigItemVWInfoList(List<SOC0606Info> configItemVWInfoList) {
		this.configItemVWInfoList = configItemVWInfoList;
	}

	public String getJiguiXml() {
		return jiguiXml;
	}

	public void setJiguiXml(String jiguiXml) {
		this.jiguiXml = jiguiXml;
	}

	public String getToolsXml() {
		return toolsXml;
	}

	public void setToolsXml(String toolsXml) {
		this.toolsXml = toolsXml;
	}

	public String getGuodaoXML() {
		return guodaoXML;
	}

	public void setGuodaoXML(String guodaoXML) {
		this.guodaoXML = guodaoXML;
	}

	public Integer getEiid() {
		return eiid;
	}

	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}
	/**
	 * ��Ч����ȡ��
	 * @return ��Ч����
	 */
	public String getWuxiaoXML() {
		return wuxiaoXML;
	}
	/**
	 * ��Ч�����趨
	 *
	 * @param ��Ч����
	 */
	public void setWuxiaoXML(String wuxiaoXML) {
		this.wuxiaoXML = wuxiaoXML;
	}
	/**
	 * ͼ����Ϣȡ��
	 * @return ͼ����Ϣ
	 */
	public String getLegendXML() {
		return legendXML;
	}
	/**
	 * ͼ����Ϣ�趨
	 *
	 * @param ͼ����Ϣ
	 */
	public void setLegendXML(String legendXML) {
		this.legendXML = legendXML;
	}

	public List<LabelValueBean> getCubicalHeigthList() {
		return cubicalHeigthList;
	}

	public void setCubicalHeigthList(List<LabelValueBean> cubicalHeigthList) {
		this.cubicalHeigthList = cubicalHeigthList;
	}

	public String getCubicalHeigth() {
		return cubicalHeigth;
	}

	public void setCubicalHeigth(String cubicalHeigth) {
		this.cubicalHeigth = cubicalHeigth;
	}
	/**
	 * 3D����֧��IP��ѯFormȡ��
	 * @return 3D����֧��IP��ѯForm
	 */
	public IGASM1120Form getIgasm1120Form() {
		return igasm1120Form;
	}
	/**
	 * 3D����֧��IP��ѯForm�趨
	 *
	 * @param 3D����֧��IP��ѯForm
	 */
	public void setIgasm1120Form(IGASM1120Form igasm1120Form) {
		this.igasm1120Form = igasm1120Form;
	}
	/**
	 * 3D����֧��IP��ѯ���ȡ��
	 * @return 3D����֧��IP��ѯ���
	 */
	public List<EquipmentInquireVWInfo> getEilist() {
		return eilist;
	}
	/**
	 * 3D����֧��IP��ѯ����趨
	 *
	 * @param 3D����֧��IP��ѯ���
	 */
	public void setEilist(List<EquipmentInquireVWInfo> eilist) {
		this.eilist = eilist;
	}
	/**��������Id*/
	protected String computerContainerId ;
	
	/**
	 *��������Idȡ��
	 * @return ��������Id
	 */
	public String getComputerContainerId() {
		return computerContainerId;
	}
	/**
	 * ��������Id�趨
	 *
	 * @param computerContainerId ��������Id
	 */
	public void setComputerContainerId(String computerContainerId) {
		this.computerContainerId = computerContainerId;
	}
}


