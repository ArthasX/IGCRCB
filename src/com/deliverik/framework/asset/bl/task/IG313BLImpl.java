package com.deliverik.framework.asset.bl.task;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG313Info;
import com.deliverik.framework.asset.model.condition.IG313SearchCond;
import com.deliverik.framework.asset.model.condition.IG313SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG313DAO;
import com.deliverik.framework.asset.model.entity.IG313TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;


/**
 * �ʲ���ϵҵ���߼�ʵ��
 * 
 * @author 
 */
public class IG313BLImpl extends BaseBLImpl implements IG313BL {

	/** ig313 DAO */
	protected IG313DAO ig313DAO;

	public void setIg313DAO(IG313DAO ig313DAO) {
		this.ig313DAO = ig313DAO;
	}
	
	/**
	 * <p>
	 * �µ��ʲ���ϵ��Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ���ϵ��Ϣ����ʵ��ȡ��
	 */

	public IG313TB getIG313TBInstance() {
		return new IG313TB();
	}

	/**
	 * ���ݼ�������ȡ���ʲ���ϵ��Ϣ�������
	 * 
	 * @param cond �ʲ���ϵ��Ϣ��������
	 * @return �ʲ���ϵ��Ϣ�������
	 */
	public int getIG313InfoSearchCount(IG313SearchCond cond){

		return ig313DAO.getSearchCount(cond);
	}

	
	/**
	 * �����ʲ���ϵ��Ϣ����ȡ���ʲ���ϵ��Ϣ
	 * 
	 * @param eirid �ʲ���ϵ��Ϣ����
	 * @return �ʲ���ϵ��Ϣ
	 * @throws BLException 
	 */
	public IG313Info searchIG313InfoByKey(Integer eirid) throws BLException{

		return checkExistEntityItemRelation(eirid);
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ���ϵ��Ϣ�б�
	 * 
	 * @param cond �ʲ���ϵ��Ϣ��������
	 * @return �ʲ���ϵ��Ϣ��������б�
	 */

	public List<IG313Info> searchIG313Info(IG313SearchCond cond){

		List<IG313Info> ret = ig313DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ���ʲ���ϵ��Ϣ�б�
	 * 
	 * @param cond �ʲ���ϵ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ���ϵ��Ϣ��������б�
	 */
	public List<IG313Info> searchIG313Info(IG313SearchCond cond, int start, int count){

		List<IG313Info> ret = ig313DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * �����ʲ���ϵ��Ϣ����
	 * 
	 * @param ig313Info ������ʲ���ϵ��Ϣ����
	 * @return �ʲ���ϵ��Ϣ
	 * @throws BLException 
	 */
	public IG313Info registIG313Info(IG313Info ig313Info) throws BLException{
		//checkNotExistEntityItemRelation(entityItemRelation.getPareiid(),entityItemRelation.getCldeiid());
		IG313Info ret = ig313DAO.save(ig313Info);
		return ret;
	}

	/**
	 * ����ʲ���ϵ��Ϣ����
	 * 
	 * @param ig313Info ������ʲ���ϵ��Ϣ����
	 * @return �ʲ���ϵ��Ϣ
	 * @throws BLException 
	 */
	public IG313Info updateIG313Info(IG313Info ig313Info) throws BLException{
		checkExistEntityItemRelation(ig313Info.getEirid());
		IG313Info ret = ig313DAO.save(ig313Info);
		return ret;
	}
	
	/**
	 * �ʲ���ϵ��Ϣ�汾��������
	 * 
	 * @param eiid ����ʲ�ID
	 * @param eiversion ��ϵ�����ʲ����´�汾
	 * @param eismallversion �رձ����ʲ�����С�汾
	 * @param neweiversion �ʲ����´�汾
	 * @param neweismallversion �ʲ�����С�汾
	 * @throws BLException 
	 */
	public void upgradeIG313Info(Integer eiid, Integer eiversion, Integer eismallversion,
			Integer neweiversion, Integer neweismallversion) throws BLException {
		//��ǰʱ��
		String dataTime = IGStringUtils.getCurrentDateTime();
		//������ϵ�����ʲ����°汾��ϵ������
		IG313SearchCondImpl condPar = new IG313SearchCondImpl();
		condPar.setPareiid(eiid);//�ʲ�ID
		condPar.setParversion(eiversion);//�ʲ���汾
		condPar.setParsmallversion(eismallversion);//�ʲ�С�汾
		List<IG313Info> eirList = this.searchMaxIG313Info(condPar);
		IG313TB eirTB = null;
		for(IG313Info eir : eirList) {
			eirTB = (IG313TB)SerializationUtils.clone(eir);
			eirTB.setEirid(null);
			eirTB.setParversion(neweiversion);
			eirTB.setParsmallversion(neweismallversion);
			eirTB.setEirupdtime(dataTime);
			eirTB.setDeleteflag("0");
			this.ig313DAO.save(eirTB);
		}
		/**
		//������ϵ�����ʲ����°汾��ϵ������
		IG313SearchCondImpl condCld = new IG313SearchCondImpl();
		condCld.setCldeiid(eiid.toString());//�ʲ�ID
		condCld.setCldversion(eiversion.toString());//�ʲ���汾
		condCld.setCldsmallversion(eismallversion.toString());//�ʲ�С�汾
		condCld.setDeleteflag("0");//�ʲ���ϵ���ñ�־
		eirList = this.searchMaxIG313Info(condCld);
		for(IG313Info eir : eirList) {
			eirTB = (IG313TB)SerializationUtils.clone(eir);
			eirTB.setEirid(null);
			eirTB.setCldversion(neweiversion);
			eirTB.setCldsmallversion(neweismallversion);
			eirTB.setEirupdtime(dataTime);
			eirTB.setDeleteflag("0");
			this.ig313DAO.save(eirTB);
		}
		*/
		
	}
	
	/**
	 * ɾ���ʲ���ϵ��Ϣ����
	 * 
	 * @param ig313Info ɾ�����ʲ���ϵ��Ϣ����
	 * @return
	 * @throws BLException 
	 */
	public void deleteIG313Info(IG313Info ig313Info) throws BLException{
		checkExistEntityItemRelation(ig313Info.getEirid());
		ig313DAO.delete(ig313Info);
	}

	/**
	 * �ʲ���ϵ��Ϣ�����ڼ��
	 * 
	 * @param pareiid �ʲ�ID������
	 * @param cldeiid �ʲ�ID������
	 * @throws BLException 
	 */
	protected void checkNotExistEntityItemRelation(Integer pareiid, Integer cldeiid) throws BLException{
		IG313SearchCondImpl cond = new IG313SearchCondImpl();
		
		cond.setPareiid(pareiid);
		cond.setCldeiid(cldeiid);
		
		List<IG313Info> infoList = ig313DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException("IGCO10000.E003","�ʲ���ϵ");
		}
	}
	
	/**
	 * �ʲ���ϵ��Ϣ���ڼ��
	 * 
	 * @param eirid �ʲ���ϵ��ϢID
	 * @return �ʲ���ϵ��Ϣ
	 * @throws BLException 
	 */
	protected IG313Info checkExistEntityItemRelation(Integer eirid) throws BLException{
		IG313Info info = ig313DAO.findByPK(eirid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�ʲ���ϵ");
		}
		
		return info;
	}
	/**
	 * �����ʲ���ϵ��Ϣ����ɾ���ʲ���ϵ��Ϣ����
	 * 
	 * @param eirid ɾ���ʲ���ϵ��Ϣ������
	 * @return
	 * @throws BLException
	 */

	public void deleteIG313InfoByKey(Integer eirid) throws BLException {
		IG313Info entityItemRelation = checkExistEntityItemRelation(eirid);
		ig313DAO.delete(entityItemRelation);
		
	}
	
	/**
	 * �ʲ���ϵ���汾����
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG313Info> searchMaxIG313Info(IG313SearchCond cond) {
		return this.ig313DAO.searchMaxIG313Info(cond);
	}

	/**
	 * ��ͬ-�����ϵ����
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeIG313InfoOne(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion, String[] cldeiids)
			throws BLException {
		//��ǰʱ��
		String dataTime = IGStringUtils.getCurrentDateTime();
		//������ϵ�����ʲ����°汾��ϵ������
		IG313SearchCondImpl condPar = new IG313SearchCondImpl();
		condPar.setPareiid(eiid);//�ʲ�ID
		condPar.setParversion(eiversion);//�ʲ���汾
		condPar.setParsmallversion(eismallversion);//�ʲ�С�汾
		condPar.setDeleteflag("0");
		List<IG313Info> eirList = this.searchIG313Info(condPar);
		IG313TB eirTB = null;
		for(IG313Info eir : eirList) {
			eirTB = (IG313TB)SerializationUtils.clone(eir);
			eirTB.setEirid(null);
			eirTB.setParversion(neweiversion);
			eirTB.setParsmallversion(neweismallversion);
			eirTB.setEirupdtime(dataTime);
			eirTB.setDeleteflag("0");
			//��ģʽ
			if("C".equals(eir.getEirstatus())) {
				if(cldeiids!=null&&cldeiids.length>0){
					for(int i=0;i<cldeiids.length;i++){
						if(StringUtils.isNotEmpty(cldeiids[i])){
							String cldeiid=cldeiids[i].split("_")[0];
							String cldversion=cldeiids[i].split("_")[1];
							String cldsmallversion=cldeiids[i].split("_")[2];
							String ciid="_"+cldeiids[i].split("_")[3]+"_";
							//�ж��Ƿ����������ʲ�
							if(cldeiid.equals(eirTB.getCldeiid().toString())&&eirTB.getEirinfo().indexOf(ciid)!=-1){
								eirTB.setCldversion(Integer.parseInt(cldversion));
								eirTB.setCldsmallversion(Integer.parseInt(cldsmallversion));
								break;
							}
						}
					}
				}
			} else {
				eirTB.setCldversion(eirTB.getCldEntityItemVW().getEiversion());
				eirTB.setCldsmallversion(eirTB.getCldEntityItemVW().getEismallversion());
			}
			this.ig313DAO.save(eirTB);
		}
		
	}
	
	/**
	 * ������ģʽ��ϵ
	 * @param eiid
	 * @param eiversion
	 * @param eismallversion
	 * @param version
	 * @param i
	 * @param cldeiids
	 */
	public void upgradeIG313InfoByJiFang(Integer eiid, Integer eiversion,
			Integer eismallversion, int neweiversion, int neweismallversion)
			throws BLException {
		//��ǰʱ��
		String dataTime = IGStringUtils.getCurrentDateTime();
		//������ϵ�����ʲ����°汾��ϵ������
		IG313SearchCondImpl condPar = new IG313SearchCondImpl();
		condPar.setPareiid(eiid);//�ʲ�ID
		condPar.setParversion(eiversion);//�ʲ���汾
		condPar.setParsmallversion(eismallversion);//�ʲ�С�汾
		condPar.setDeleteflag("0");
		List<IG313Info> eirList = this.searchIG313Info(condPar);
		IG313TB eirTB = null;
		for(IG313Info eir : eirList) {
			//��ģʽ
			if(!"C".equals(eir.getEirstatus())) {
				eirTB = (IG313TB)SerializationUtils.clone(eir);
				eirTB.setEirid(null);
				eirTB.setParversion(neweiversion);
				eirTB.setParsmallversion(neweismallversion);
				eirTB.setEirupdtime(dataTime);
				eirTB.setDeleteflag("0");
				eirTB.setCldversion(eirTB.getCldEntityItemVW().getEiversion());
				eirTB.setCldsmallversion(eirTB.getCldEntityItemVW().getEismallversion());
				this.ig313DAO.save(eirTB);
			}
		}
		
	}

}
