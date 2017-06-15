package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.asset.model.entity.IG117TB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.utility.CommonDefineUtils;


/**
 * �ʲ���ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class IG117DAOImpl extends BaseHibernateDAOImpl<IG117Info> implements IG117DAO {

	/**
	 * ���캯��
	 */
	public IG117DAOImpl(){
		super(IG117TB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<IG117Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("eid"));
		List<IG117Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param eid ����
	 * @return �������
	 */
	public IG117Info findByPK(Serializable eid) {

		IG117Info entity = super.findByPK(eid);
		if(entity == null) return null;

		return entity;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG117SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG117Info> findByCond(final IG117SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("esyscoding"));
		List<IG117Info> ret = findByCriteria(c, start, count);
		return ret;
	}
	/**
	 * ���������¼���
	 */
	
	public List<IG117Info> findByCond(final IG117SearchCond cond,final String orderType){
		DetachedCriteria c = getCriteria(cond);
		if("assetdomain".equals(orderType)){//��ѯ��ɫ�ʲ������������Ľ��ȫ��ʹ��
			c.addOrder(Order.asc("esyscoding"));
		}else{
			c.addOrder(Order.desc("eparcoding"));
		}
		
		List<IG117Info> ret = findByCriteria(c);
		return ret;
	}
	
	public List<IG117Info> findByCondCoding(final IG117SearchCond cond)
	{
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("esyscoding"));
		List<IG117Info> ret = findByCriteria(c);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG117SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		if( !StringUtils.isEmpty(cond.getEcategory())){
			if(!CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory())
					&& !CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
				//c.add(Expression.ne("esyscoding", "999007"));
			    c.add(Expression.ne("esyscoding", "999008"));	
			    c.add(Expression.ne("esyscoding", "999014"));//��Ʊ�ʲ�
			}else if(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory())
					&& !CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
				c.add(Expression.ne("esyscoding", "999008"));	
				c.add(Expression.ne("esyscoding", "999014"));//��Ʊ�ʲ�
			}
//			else if(!CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory())
//					&& CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
//				c.add(Expression.ne("esyscoding", "999007"));	
//			}
		} else {
//			if(!StringUtils.isEmpty(cond.getEname())){
//			}else{
//				c.add(Expression.ne("esyscoding", "999007"));
//			}
			c.add(Expression.ne("esyscoding", "999007"));
			c.add(Expression.ne("esyscoding", "999008"));
			if(StringUtils.isNotEmpty(cond.getType()) && "0".equals(cond.getType())){
    			c.add(Expression.ne("esyscoding", "999014"));//��Ʊ�ʲ�
			}
		}
		//�ʲ�ģ��ID
		if( !StringUtils.isEmpty(cond.getEidStr())){
			c.add(Expression.eq("eid", Integer.parseInt(cond.getEidStr())));
		}	
		//�ʲ�ģ�ͱ��
		if( !StringUtils.isEmpty(cond.getElabel())){
			c.add(Expression.eq("elabel", cond.getElabel()));
		}	
		//�ʲ�ģ����
		if( !StringUtils.isEmpty(cond.getEname())){
			c.add(Expression.like("ename", "%" + cond.getEname() + "%"));
		}	
		
		//�ʲ�ģ�ͷ���
		if( !StringUtils.isEmpty(cond.getEcategory_q())){
			c.add(Expression.eq("ecategory", cond.getEcategory()));
		}
		//�ʲ�ģ�ͷ���
		if( !StringUtils.isEmpty(cond.getEcategory()) && 
				!CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM.equals(cond.getEcategory()) 
				&& !CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER.equals(cond.getEcategory())){
			c.add(Expression.eq("ecategory", cond.getEcategory()));
		}
		//�ʲ�ģ��һ������
		if( !StringUtils.isEmpty(cond.getEkey1())){
			c.add(Expression.eq("ekey1", cond.getEkey1()));
		}
		//�ʲ�ģ�Ͷ�������
		if( !StringUtils.isEmpty(cond.getEkey2())){
			c.add(Expression.eq("ekey2", cond.getEkey2()));
		}
		//�ʲ�ģ����������
		if( !StringUtils.isEmpty(cond.getEkey3())){
			c.add(Expression.eq("ekey3", cond.getEkey3()));
		}
		
		//Entity tree
		if( !StringUtils.isEmpty(cond.getEsyscoding())){
			c.add(Expression.eq("esyscoding", cond.getEsyscoding()));
		}
		if( !StringUtils.isEmpty(cond.getEsyscoding_q())){
			c.add(Expression.like("eparcoding", cond.getEsyscoding_q()));
//			if("999".equals(cond.getEsyscoding_q())){
//				c.add(Expression.ne("esyscoding", "999007"));
//				c.add(Expression.ne("esyscoding", "999008"));
//			}
		}
		if( cond.getSelectList()!=null && cond.getSelectList().size()>0){
			c.add(Expression.in("esyscoding", cond.getSelectList()));
		}
		if( cond.getDelList()!=null && cond.getDelList().size()>0){
			c.add(Expression.not(Expression.in("esyscoding", cond.getDelList())));
		}
		
		//�豸�Ǽ�_����ѡ��tree
		if( !StringUtils.isEmpty(cond.getEsyscoding_tree()) && StringUtils.isEmpty(cond.getEparcoding())){
			c.add(Expression.eq("esyscoding", cond.getEsyscoding_tree()));
//			if(!StringUtils.isEmpty(cond.getEparcoding())){
//				c.add(Expression.or(Expression.eq("esyscoding", cond.getEsyscoding_tree()),Expression.eq("eparcoding", cond.getEparcoding())));
//			}
		}else{
			//���͵Ǽ�_�ϼ�����ѡ��tree
			if(!StringUtils.isEmpty(cond.getEparcoding())){
				c.add(Expression.eq("eparcoding", cond.getEparcoding()));
			}
		}
		//Entity tree
		if( !StringUtils.isEmpty(cond.getEparcoding()) && StringUtils.isEmpty(cond.getEsyscoding_tree())){
			c.add(Expression.eq("eparcoding", cond.getEparcoding()));
		}
		if( !StringUtils.isEmpty(cond.getEparcoding_q())){
			c.add(Expression.eq("eparcoding", cond.getEparcoding_q()));
		}
		
		if( !StringUtils.isEmpty(cond.getEstatus())){
			c.add(Expression.eq("estatus", cond.getEstatus()));
		}
	
		//Entity tree �ӽ�㼯��
		if( !StringUtils.isEmpty(cond.getSyscoding_q())){
			c.add(Expression.like("esyscoding", cond.getSyscoding_q()+"%"));
		}
		//�ʲ�ģ��in����
		if( cond.getEsyscodingList()!=null && cond.getEsyscodingList().size()>0){
			c.add(Expression.in("esyscoding", cond.getEsyscodingList()));
		}

		//�ʲ�ģ��״̬�޸�
		if( !StringUtils.isEmpty(cond.getEparcoding_status())){
			c.add(Expression.eq("eparcoding", cond.getEparcoding_status()));
		}
		if( !StringUtils.isEmpty(cond.getEparcoding_status_start())){
			c.add(Expression.eq("esyscoding", cond.getEparcoding_status_start()));
		}
		
		//��ѯnot like Esyscoding_nq��ģ��
		if( !StringUtils.isEmpty(cond.getEsyscoding_nq())){
			c.add(Expression.not(Expression.like("esyscoding", cond.getEsyscoding_nq()+"%")));
		}
		
		if( cond.getDelList_q()!=null && cond.getDelList_q().size()>0){
			for(String esys:cond.getDelList_q()){
				c.add(Expression.not(Expression.like("esyscoding", esys+"%")));
			}
			
		}
		
		return c;
	}
	
	protected DetachedCriteria getCriterias(IG117SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		return c;
	}

}
