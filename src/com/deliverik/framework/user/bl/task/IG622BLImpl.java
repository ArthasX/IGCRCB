/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.user.bl.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.IG622Info;
import com.deliverik.framework.user.model.condition.IG622SearchCond;
import com.deliverik.framework.user.model.dao.IG622DAO;
import com.deliverik.framework.user.model.entity.IG622TB;

/**
  * ����: ��ҳ��תURL����ҵ���߼�ʵ��
  * ��������: ��ҳ��תURL����ҵ���߼�ʵ��
  * ������¼: 2012/07/18
  * �޸ļ�¼: 
  */
public class IG622BLImpl extends BaseBLImpl implements
		IG622BL {

	/** ��ҳ��תURL����DAO�ӿ� */
	protected IG622DAO ig622DAO;
	
	//��װ��ҳ��תURL���弯��
	private static List<LabelValueBean> lst_LabelValueBean = null;
	
	//��װ�û���ҳ�����б�
	private static Map<String, IG622Info> map_IG622Info = null;
	
	/**
	 * ��ҳ��תURL����DAO�ӿ��趨
	 *
	 * @param ig622DAO ��ҳ��תURL����DAO�ӿ�
	 */
	public void setIg622DAO(IG622DAO ig622DAO) {
		this.ig622DAO = ig622DAO;
	}

	/**
	 * ��ҳ��תURL����ʵ��ȡ��
	 *
	 * @return ��ҳ��תURL����ʵ��
	 */
	public IG622TB getIG622TBInstance() {
		return new IG622TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG622Info> searchIG622Info() {
		return ig622DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG622Info searchIG622InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG622SearchCond cond) {
		return ig622DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG622Info> searchIG622Info(
			IG622SearchCond cond) {
		return ig622DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG622Info> searchIG622Info(
			IG622SearchCond cond, int start,
			int count) {
		return ig622DAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG622Info registIG622Info(IG622Info instance)
		throws BLException {
		return ig622DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG622Info updateIG622Info(IG622Info instance)
		throws BLException {
		checkExistInstance(instance.getHpid());
		return ig622DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG622InfoByPK(String pk)
		throws BLException {
		ig622DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG622Info(IG622Info instance)
		throws BLException {
		ig622DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public IG622Info checkExistInstance(String pk)
		throws BLException {
		IG622Info instance = ig622DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * ��ʼ��
	 */
	@SuppressWarnings("unused")
	private void init() throws BLException {
		List<IG622Info> lst_IG622Info = searchIG622Info();
		lst_LabelValueBean = new ArrayList<LabelValueBean>();
		map_IG622Info = new HashMap<String, IG622Info>();
		for(IG622Info info : lst_IG622Info) {
			//��װ��ҳ��תURL���弯��
			map_IG622Info.put(info.getHpid(), info);
			//��װ�û���ҳ�����б�������ϵͳ����Ա
			if(!"S".equals(info.getHpid())) {
				lst_LabelValueBean.add(new LabelValueBean(info.getHplabel(), info.getHpid().toString()));
			}
		}
	}
	
	/**
	 * �û���ҳ�����б�ȡ��
	 *
	 * @return �û���ҳ�����б�
	 */
	public List<LabelValueBean> getComboBox() {
		return lst_LabelValueBean;
	}
	
	/**
	 * ��ҳ��תURLȡ��
	 *
	 * @param hpid ����ID
	 * @return ��ҳ��תURL
	 * @throws BLException 
	 */
	public String getUrl(String hpid) throws BLException {
		IG622Info info = map_IG622Info.get(hpid);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "��ҳ��" + hpid + "����תURL�������");
		}
		return info.getHpurl();
	}
	
	/**
	 * ��ҳ��ʾ����ȡ��
	 *
	 * @param hpid ����ID
	 * @return ��ҳ��ʾ����
	 * @throws BLException 
	 */
	public String getTitle(String hpid) throws BLException {
		IG622Info info = map_IG622Info.get(hpid);
		if (info == null) {
			throw new BLException("IGCO10000.E004", "��ҳ��" + hpid + "����תURL�������");
		}
		return info.getHptitle();
	}

}