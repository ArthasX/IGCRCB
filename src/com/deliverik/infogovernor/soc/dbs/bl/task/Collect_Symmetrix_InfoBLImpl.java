/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.dbs.bl.task;

import java.io.Serializable;
import java.util.List;

import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.IniReader;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Info;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_InfoSearchCondImpl;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_InfoDAO;


/**
 * 
 * @Description:�洢������ϢBLʵ����
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_InfoBLImpl extends BaseBLImpl implements Collect_Symmetrix_InfoBL{

	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources"); 
	
	protected Collect_Symmetrix_InfoDAO collect_Symmetrix_InfoDAO;

	public void setCollect_Symmetrix_InfoDAO(
			Collect_Symmetrix_InfoDAO collect_Symmetrix_InfoDAO) {
		this.collect_Symmetrix_InfoDAO = collect_Symmetrix_InfoDAO;
	}

	/**
	 * �־û�����
	 * 
	 * @param Collect_Symmetrix_Infoʵ����
	 * @return Collect_Symmetrix_Infoʵ����
	 */
	public Collect_Symmetrix_Info saveCollect_Symmetrix_Info(
			Collect_Symmetrix_Info collect_Symmetrix_Info) throws BLException {
		checkNotCollect_Symmetrix_Info(collect_Symmetrix_Info.getSymm_id());
		return collect_Symmetrix_InfoDAO.save(collect_Symmetrix_Info);
	}

	/**
	 * ������������
	 * 
	 * @param id
	 *            ����
	 * @return �������
	 */
	public Collect_Symmetrix_Info findCollect_Symmetrix_InfoByPK(Integer id)
			throws BLException {
		return collect_Symmetrix_InfoDAO.findByPK(id);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<Collect_Symmetrix_Info> findAllCollect_Symmetrix_Info()
			throws BLException {
		return collect_Symmetrix_InfoDAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(Collect_Symmetrix_InfoSearchCond cond)
			throws BLException {
		return collect_Symmetrix_InfoDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 */
	public List<Collect_Symmetrix_Info> findCollect_Symmetrix_InfoByCond(
			Collect_Symmetrix_InfoSearchCond cond, int start, int count)
			throws BLException {
		return collect_Symmetrix_InfoDAO.findByCond(cond, start, count);
	}

	/**
	 * ɾ������
	 * 
	 * @param Collect_Symmetrix_Infoʵ����
	 */
	public void deleteCollect_Symmetrix_Info(
			Collect_Symmetrix_Info collect_Symmetrix_Info) throws BLException {
		collect_Symmetrix_InfoDAO.delete(collect_Symmetrix_Info);
	}

	/**
	 * �޸Ĵ���
	 */
	public Collect_Symmetrix_Info updateCollect_Symmetrix_Info(
			Collect_Symmetrix_Info collect_Symmetrix_Info) throws BLException {
		checkExistInstance(collect_Symmetrix_Info.getId());
		return collect_Symmetrix_InfoDAO.save(collect_Symmetrix_Info);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 * 
	 * @param pk����
	 * @return ʵ��
	 */
	public Collect_Symmetrix_Info checkExistInstance(Serializable pk)
			throws BLException {
		Collect_Symmetrix_Info instance = collect_Symmetrix_InfoDAO
				.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "�洢����");
		}
		return instance;
	}

	/**
	 * �洢���Ʋ����ڼ��
	 * 
	 * @param symm_id�洢����
	 * @return
	 * @throws BLException
	 */
	public void checkNotCollect_Symmetrix_Info(String symm_id)
			throws BLException {
		Collect_Symmetrix_InfoSearchCondImpl collect_Symmetrix_InfoSearchCond = new Collect_Symmetrix_InfoSearchCondImpl();
		collect_Symmetrix_InfoSearchCond.setSymm_id(symm_id);
		List<Collect_Symmetrix_Info> infoList = collect_Symmetrix_InfoDAO
				.findByCond(collect_Symmetrix_InfoSearchCond, 0, 0);
		if (infoList != null && infoList.size() > 0) {
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,"IGASM2602.E001", getValueFromResources("message.Collect_Symmetrix_InfoBLImpl.001"));
		}
	}

	/**
	 * <p>
	 * ���������ļ���ֵ���ж�ʹ���������Ե���Դ
	 * </p>
	 * 
	 * @param key ��Դ�ļ��е�key
	 * @return ��Դ�ļ��е�value
	 * @throws BLException
	 *
	 */
	private String getValueFromResources(String key){
		String value = "";
		String reourceLanguage = IniReader.getValue("LANGUAGE");
		if("EN".equals(reourceLanguage)){
			resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources_en_US"); 
		} else{
			resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources_zh_CN");
		}
		value = resources.getMessage(key);
		return value;
	}
}

