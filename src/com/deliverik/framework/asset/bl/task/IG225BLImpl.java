package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG225SearchCond;
import com.deliverik.framework.asset.model.condition.IG225SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG225DAO;
import com.deliverik.framework.asset.model.entity.IG225TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;


/**
 * <p>
 * �ʲ�ģ������ҵ���߼�ʵ��
 * </p>
 */
public class IG225BLImpl extends BaseBLImpl implements IG225BL {

	/** Configuration DAO */
	protected IG225DAO ig225DAO;
	
	/** �ʲ�ģ��BL */
	protected IG117BL ig117BL;

	public void setIg117BL(IG117BL ig117BL) {
		this.ig117BL = ig117BL;
	}

	public void setIg225DAO(IG225DAO ig225DAO) {
		this.ig225DAO = ig225DAO;
	}
	
	/**
	 * <p>
	 * �µ��ʲ�ģ��������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ�ģ��������Ϣ����ʵ��ȡ��
	 */

	public IG225TB getIG225TBInstance() {
		return new IG225TB();
	}

	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ����
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @return �ʲ�ģ��������Ϣ����
	 */
	public int getIG225InfoSearchCount(IG225SearchCond cond){

		return ig225DAO.getSearchCount(cond);
	}

	/**
	 * �����ʲ�ģ����������ȡ���ʲ�ģ��������Ϣ
	 * 
	 * @param cid �ʲ�ģ����������
	 * @return �ʲ�ģ��������Ϣ
	 * @throws BLException 
	 */
	public IG225Info searchIG225InfoByKey(Integer cid) throws BLException{

		return checkExistConfiguration(cid);
	}

	/**
	 * ȡ�ø��ʲ�ģ�͵�ģ��������Ϣ
	 * 
	 * @param list �ʲ�ģ�ͼ���
	 * @param cseq �ʲ�ģ�������Ƿ���ʾ��ʶ��1��ʾ���ԣ�0����ʾ��null����ȫ�����ԣ�
	 * @return ���ʲ�ģ�͵�ģ��������Ϣ
	 */
	public Map<String,List<IG225Info>> searchIG225Info(List<IG117Info> list,Integer cseq){
		Map<String,List<IG225Info>> map = new LinkedHashMap<String,List<IG225Info>>();
		IG225SearchCondImpl cond = new IG225SearchCondImpl();
		if(cseq!=null){
			cond.setCseq(cseq);//�����Ƿ���ʾ��1������ʾ���ԣ�0������ʾ
		}
		//�ʲ�������Ϣ�ֲ�β�ѯ
		for(IG117Info e : list){
			cond.setEid(e.getEid().toString());
			List<IG225Info> configurationList = ig225DAO.findByCond(cond, 0, 0);
			map.put(e.getEname(), configurationList);
		}

		return map;
	}
	
	/**
	 * �����ʲ�ģ��IDȡ�������м̳�������Ϣ�б�
	 * 
	 * @param eid ģ������ID
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<IG225Info> searchIG225InfoByEid(Integer eid) throws BLException{
		List<IG117Info> list = ig117BL.getParentNodes(eid);
		List<IG225Info> configlist = new ArrayList<IG225Info>();
		IG225SearchCondImpl cond = new IG225SearchCondImpl();
		cond.setCstatus("1");//1����
		//�ʲ�������Ϣ�ֲ�β�ѯ
		for(IG117Info e : list){
			cond.setEid(e.getEid().toString());
			List<IG225Info> configurationList = ig225DAO.findByCond(cond, 0, 0);
			configlist.addAll(configurationList);
		}

		return configlist;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<IG225Info> searchIG225Info(IG225SearchCond cond, int start, int count){

		List<IG225Info> ret = ig225DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * �����ʲ�ģ��������Ϣ����
	 * 
	 * @param configuration �ʲ�ģ��������Ϣ
	 * @return �������ʲ�ģ��������Ϣ
	 * @throws BLException
	 */
	public IG225Info registIG225Info(IG225Info configuration) throws BLException{
		if(null!=configuration.getClabel()&&!configuration.getClabel().equals("")){
			checkNotExistConfiguration(configuration.getClabel());
		}
		IG225Info ret = ig225DAO.save(configuration);
		return ret;
	}

	/**
	 * ɾ���ʲ�ģ��������Ϣ����
	 * 
	 * @param ig225Info ɾ�����ʲ�ģ��������Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteIG225Info(IG225Info ig225Info) throws BLException{
		checkExistConfiguration(ig225Info.getCid());
		ig225DAO.delete(ig225Info);
	}

	/**
	 * �����ʲ�ģ����������ɾ���ʲ�ģ��������Ϣ����
	 * 
	 * @param cid ɾ���ʲ�ģ��������Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteConfiguration(Integer cid) throws BLException{
		IG225Info ret = checkExistConfiguration(cid);
		ig225DAO.delete(ret);
	}

	/**
	 * ����ʲ�ģ��������Ϣ����
	 * 
	 * @param ig225Info ���ǰ���ʲ�ģ��������Ϣ
	 * @return �ʲ�ģ��������Ϣ
	 * @throws BLException
	 */
	public IG225Info updateIG225Info(IG225Info ig225Info) throws BLException{
		checkExistConfiguration(ig225Info.getCid());
		IG225Info ret = ig225DAO.save(ig225Info);
		return ret;
	}

	/**
	 * �ʲ�ģ��������Ϣ�����ڼ��
	 * 
	 * @param clabel ���ñ�� 
	 * @return
	 * @throws BLException 
	 */
	protected void checkNotExistConfiguration(String clabel) throws BLException{
		IG225SearchCondImpl cond = new IG225SearchCondImpl();
		cond.setClabel(clabel);
		
		List<IG225Info> infoList = ig225DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size() >0 ) {
			throw new BLException(BLErrorType.CONFIGURATION_ALREADY_EXISTS,
					"IGCO10000.E003","�ʲ�ģ������");
		}
	}
	
	/**
	 * �ʲ�ģ��������Ϣ���ڼ��
	 * 
	 * @param cid ����ID
	 * @return �ʲ�ģ��������Ϣ
	 * @throws BLException 
	 */
	protected IG225Info checkExistConfiguration(Integer cid) throws BLException{
		IG225Info info = ig225DAO.findByPK(cid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�ʲ�ģ������");
		}
		
		return info;
	}

	/**
	 * �����ʲ�ģ����������ɾ���ʲ�ģ��������Ϣ����
	 * 
	 * @param cid ɾ���ʲ�ģ��������Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteIG225InfoByKey(Integer cid) throws BLException {
		IG225Info Configuration = checkExistConfiguration(cid);
		ig225DAO.delete(Configuration);
		
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�ģ��������Ϣ�б�
	 * 
	 * @param cond �ʲ�ģ��������Ϣ��������
	 * @return �ʲ�ģ��������Ϣ�б�
	 */
	public List<IG225Info> searchIG225Info(IG225SearchCond cond) {
		List<IG225Info> ret = ig225DAO.findByCond(cond,0,0);
		return ret;
	}
}
