/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.base.BasePK;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.dao.annotation.FieldType;
import com.deliverik.infogovernor.nms.model.dao.annotation.Fk;
import com.deliverik.infogovernor.nms.model.dao.annotation.TableSpace;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: NMSDAO����ʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMSBaseDAOImpl<T> extends BaseHibernateDAOImpl<T> implements NMSBaseDAO<T> {

	/** �汾 */
	protected Integer version = 0;
	
	/**
	 * ���췽��
	 */
	public NMSBaseDAOImpl(){}
	
	/**
	 * ���췽��
	 */
	@SuppressWarnings("rawtypes")
	public NMSBaseDAOImpl(Class c){
		super(c);
	}

	/**
	 * �汾ȡ��
	 * @return version �汾
	 */
	public Integer getVersion() {
		return version;
	}

	/**
	 * �汾�趨
	 * @param version �汾
	 */
	public void setVersion(Integer version) {
		this.version = version;
	}
	
	/**
	 * ��������ʵ��
	 * ��������ʱ�����²���
	 * ���������ڵ�ʱ�����������
	 * @param entity ��Ҫ�����ʵ��
	 * @return ������ʵ��
	 */
	public T save(T entity){
		T target = getTarget(entity);
		if(target instanceof BaseEntity){
			BaseEntity baseEntity = (BaseEntity) entity;
			Serializable pk = baseEntity.getPK();
			boolean isSaved = true;
			if(pk == null){
				isSaved = false;
			}else if(pk instanceof BasePK){
				Map<String, Object> params = new HashMap<String, Object>();
				Field[] fields = pk.getClass().getDeclaredFields();
				for(Field field:fields){
					field.setAccessible(true);
					try {
						Object o = field.get(pk);
						if(o != null){
							params.put(field.getName(), o);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				if(params.isEmpty()){
					isSaved = false;
				}else{
					isSaved = checkDataExits(params);
				}
			}else{
				Map<String, Object> params = new HashMap<String, Object>();
				Field[] fields = type.getDeclaredFields();
				for(Field field:fields){
					Id id = field.getAnnotation(Id.class);
					if(id != null){
						params.put(field.getName(), pk);
						break;
					}
				}
				isSaved = checkDataExits(params);
			}
			if(isSaved){
				updateEntity(target);
			}else{
				saveEntity(target);
			}
		}
		return target;
	}
	
	/**
	 * У�������Ƿ����
	 * @param params ����
	 * @return �����Ƿ���� 
	 */
	@SuppressWarnings("rawtypes")
	private boolean checkDataExits(final Map<String, Object> params){
		boolean flag = true;
		if(!params.isEmpty()){
			HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					Table table = type.getAnnotation(Table.class);
					String schema = table.schema();
					String tableName = table.name();
					query.append("select ");
					List<Field> fields = getSQLFields(type);
					for(int i=0;i<fields.size();i++){
						if(i>0){
							query.append(",");
						}
						query.append("this_.");
						query.append(fields.get(i).getName());
					}
					query.append(" from ");
					if(StringUtils.isNotEmpty(schema)){
						query.append(schema);
						query.append(".");
					}
					query.append(tableName);
					query.append("_");
					query.append(getVersion());
					query.append(" this_ where ");
					int index = 0;
					for(Iterator<String> iter = params.keySet().iterator();iter.hasNext();){
						if(index > 0){
							query.append(" and ");
						}else{
							index ++;
						}
						String next = iter.next();
						query.append(" this_.");
						query.append(next);
						query.append(" = :");
						query.append(next);
					}
					SQLQuery q = session.createSQLQuery(query.toString());
					q.setProperties(params);
					List list = q.list();
					session.clear();
					return list;
				}
			};
			List list = (List) execute(action);
			if(list.isEmpty()){
				flag = false;
			}
		}else{
			flag = false;
		}
		return flag;
	}
	
	/**
	 * ����ʵ��
	 * @param target ��Ҫ���µ�ʵ��
	 */
	private void updateEntity(final T target){
		final Table table = target.getClass().getAnnotation(Table.class);
		final List<Field> fields = getSQLFields(target.getClass());
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("update ")
					 .append(table.schema())
					 .append(".")
					 .append(table.name())
					 .append("_")
					 .append(version)
					 .append(" set ");
				for(int i=0;i<fields.size();i++){
					if(i > 0){
						query.append(",");
					}
					query.append(fields.get(i).getName());
					query.append(" = :");
					query.append(fields.get(i).getName());
				}
				query.append(" where ");
				int index = 0;
				for(int i=0;i<fields.size();i++){
					if(fields.get(i).getAnnotation(Id.class) != null){
						if(index > 0){
							query.append(" and ");
						}else{
							index ++;
						}
						query.append(fields.get(i).getName());
						query.append(" = :");
						query.append(fields.get(i).getName());
					}
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(target);
				int flag = q.executeUpdate();
				session.clear();
				return flag;
			}
		};
		execute(action);
	}
	
	/**
	 * ����ʵ��
	 * @param entity ��Ҫ�����ʵ��
	 */
	private void saveEntity(T entity){
		final Table table = entity.getClass().getAnnotation(Table.class);
		final List<Field> fields = getSQLFields(entity.getClass());
		boolean generatored = false;
		TableGenerator tableGenerator = null;
		Field pkField = null;
		for(Field field:fields){
			GeneratedValue generatedValue = field.getAnnotation(GeneratedValue.class);
			if(generatedValue != null && generatedValue.strategy() == GenerationType.TABLE){
				generatored = true;
				tableGenerator = field.getAnnotation(TableGenerator.class);
				pkField = field;
				break;
			}
		}
		if(generatored){
			entity = generatorPK(entity,tableGenerator,pkField);
		}
		final T target = entity;
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("insert into ")
					 .append(table.schema())
					 .append(".")
					 .append(table.name())
					 .append("_")
					 .append(version)
					 .append(" (");
				for(int i=0;i<fields.size();i++){
					if(i > 0){
						query.append(",");
					}
					query.append(fields.get(i).getName());
				}
				query.append(") values (");
				for(int i=0;i<fields.size();i++){
					if(i > 0){
						query.append(",");
					}
					query.append(":");
					query.append(fields.get(i).getName());
				}
				query.append(")");
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(target);
				int flag = q.executeUpdate();
				session.clear();
				return flag;
			}
		};
		execute(action);
	}
	
	/**
	 * ��������
	 * @param entity ��Ҫ�����ʵ��
	 * @param tableGenerator ʵ�����������ɲ���
	 * @param pkField �������Զ���
	 * @return �������������ʵ��
	 */
	@SuppressWarnings("rawtypes")
	private T generatorPK(T entity,final TableGenerator tableGenerator,Field pkField){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select ");
				query.append(tableGenerator.valueColumnName());
				query.append(" from ");
				query.append(tableGenerator.table());
				query.append(" where  ");
				query.append(tableGenerator.pkColumnName());
				query.append(" = '");
				query.append(tableGenerator.pkColumnValue());
				query.append("' ");
				SQLQuery q = session.createSQLQuery(query.toString());
				setFetchPoint(q, 0, 0);
				List list = q.list();
				session.clear();
				if(list.isEmpty()){
					return null;
				}
				return getCount(list);
			}
		};
		final Integer pk = (Integer)execute(action);
		Integer pkValue = pk;
		if(pk == null){
			pkValue = tableGenerator.initialValue();
			HibernateCallback insertAction = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append("insert info  ");
					query.append(tableGenerator.table());
					query.append(" ( ");
					query.append(tableGenerator.pkColumnName());
					query.append(",");
					query.append(tableGenerator.valueColumnName());
					query.append(" ) values ('");
					query.append(tableGenerator.pkColumnValue());
					query.append("',");
					query.append(tableGenerator.initialValue() + tableGenerator.allocationSize());
					query.append(") ");
					SQLQuery q = session.createSQLQuery(query.toString());
					int flag = q.executeUpdate();
					session.clear();
					return flag;
				}
			};
			execute(insertAction);
		}else{
			HibernateCallback updateAction = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					query.append("update ");
					query.append(tableGenerator.table());
					query.append(" set ");
					query.append(tableGenerator.valueColumnName());
					query.append(" = ");
					query.append(pk + tableGenerator.allocationSize());
					query.append(" where  ");
					query.append(tableGenerator.pkColumnName());
					query.append(" = '");
					query.append(tableGenerator.pkColumnValue());
					query.append("' ");
					SQLQuery q = session.createSQLQuery(query.toString());
					int flag = q.executeUpdate();
					session.clear();
					return flag;
				}
			};
			execute(updateAction);
		}
		pkField.setAccessible(true);
		try {
			pkField.set(entity, pkValue);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return entity;
	}
	
	/**
	 * ȡ��ʵ�����������ֶ�
	 * @param target ʵ��
	 * @return ʵ�����������ֶ�
	 */
	@SuppressWarnings("rawtypes")
	private List<Field> getSQLFields(Class c){
		List<Field> fields = new ArrayList<Field>();
		for(;c != null;c = c.getSuperclass()){
			Field[] declaredFields = c.getDeclaredFields();
			for(Field field:declaredFields){
				if(field.getAnnotation(Transient.class) == null){
					fields.add(field);
				}
			}
		}
		return fields;
	}

	/**
	 * ��������
	 * @param pk ����
	 * @return �鵽��ʵ��
	 */
	@SuppressWarnings("unchecked")
	public T findByPK(final Serializable pk) {
		T entity = getEntityClassInstance();
		if(pk == null){
			return null;
		}else if(pk instanceof BasePK){
			boolean flag = false;
			Field[] fields = pk.getClass().getDeclaredFields();
			for(Field field:fields){
				field.setAccessible(true);
				try {
					Object object = field.get(pk);
					if(object != null){
						flag = true;
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
			}
			if(flag){
				return null;
			}
		}else{
			HibernateCallback action = new HibernateCallback() {
				public Object doInHibernate(Session session) throws HibernateException, SQLException {
					session.flush();
					StringBuffer query = new StringBuffer();
					Table table = type.getAnnotation(Table.class);
					String schema = table.schema();
					String tableName = table.name();
					query.append("select ");
					List<Field> pkFields = new ArrayList<Field>();
					List<Field> fields = getSQLFields(type);
					for(int i=0;i<fields.size();i++){
						if(i>0){
							query.append(",");
						}
						query.append("this_.");
						query.append(fields.get(i).getName());
						if(fields.get(i).getAnnotation(Id.class) != null){
							pkFields.add(fields.get(i));
						}
					}
					query.append(" from ");
					if(StringUtils.isNotEmpty(schema)){
						query.append(schema);
						query.append(".");
					}
					query.append(tableName);
					query.append("_");
					query.append(getVersion());
					query.append(" this_ where ");
					for(int i=0;i<pkFields.size();i++){
						if(i>0){
							query.append(" and ");
						}
						query.append(" this_.");
						query.append(pkFields.get(0).getName());
						query.append(" = :");
						query.append(pkFields.get(0).getName());
					}
					SQLQuery q = session.createSQLQuery(query.toString());
					Map<String, Object> map = new HashMap<String, Object>();
					if(pkFields.size() == 1){
						map.put(pkFields.get(0).getName(), pk);
					}else{
						Field[] pkValues = pk.getClass().getDeclaredFields();
						for(Field field:pkValues){
							field.setAccessible(true);
							try{
								map.put(field.getName(), field.get(pk));
							}catch(Exception e){
								e.printStackTrace();
							}
						}
					}
					q.setProperties(map);
					q.addEntity(type);
					List<T> list = q.list();
					session.clear();
					if(list.isEmpty()){
						return null;
					}else{
						return list.get(0);
					}
				}
			};
			entity = (T)execute(action);
		}
		return entity;
	}

	/**
	 * ɾ������
	 * @param entity Ҫɾ����ʵ��
	 */
	public void delete(final T entity) {
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("delete from ");
				Table table = type.getAnnotation(Table.class);
				String schema = table.schema();
				String tableName = table.name();
				if(StringUtils.isNotEmpty(schema)){
					query.append(schema);
					query.append(".");
				}
				query.append(tableName);
				query.append("_");
				query.append(getVersion());
				query.append(" where ");
				List<Field> fields = getSQLFields(entity.getClass());
				Map<String, Object> sqlMap = new LinkedHashMap<String, Object>();
				for(int i=0;i<fields.size();i++){
					fields.get(i).setAccessible(true);
					try {
						Object value = fields.get(i).get(entity);
						if(value != null){
							if(value instanceof Integer){
								Integer intValue = (Integer) value;
								if(intValue != 0){
									sqlMap.put(fields.get(i).getName(), value);
								}
							}else{
								String StringValue = value.toString();
								if(StringUtils.isNotEmpty(StringValue)){
									sqlMap.put(fields.get(i).getName(), value);
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				Set<String> set = sqlMap.keySet();
				int index = 0;
				for(Iterator<String> iter = set.iterator();iter.hasNext();){
					String next = iter.next();
					if(index > 0){
						query.append(" and ");
					}else{
						index ++;
					}
					query.append(next);
					query.append(" = :");
					query.append(next);
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(sqlMap);
				int flag = q.executeUpdate();
				session.clear();
				return flag;
			}
		};
		execute(action);
	}

	/**
	 * ��ѯ����
	 * @param c ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(final DetachedCriteria c, int start, int count) {
		HibernateCallback action = new HibernateCallback() {
			@SuppressWarnings("rawtypes")
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				Table table = type.getAnnotation(Table.class);
				String schema = table.schema();
				String tableName = table.name();
				query.append("select ");
				List<Field> fields = getSQLFields(type);
				for(int i=0;i<fields.size();i++){
					if(i>0){
						query.append(",");
					}
					query.append("this_.");
					query.append(fields.get(i).getName());
				}
				query.append(" from ");
				if(StringUtils.isNotEmpty(schema)){
					query.append(schema);
					query.append(".");
				}
				query.append(tableName);
				query.append("_");
				query.append(getVersion());
				query.append(" this_ ");
				Criteria criteria = c.getExecutableCriteria(getSession());
				try {
					Field criterionField = criteria.getClass().getDeclaredField("criterionEntries");
					criterionField.setAccessible(true);
					Object criterionObj = criterionField.get(criteria);
					if(criterionObj != null){
						List criterionList = (List) criterionObj;
						if(criterionList.size() > 0){
							query.append(" where ");
							for(int i=0;i<criterionList.size();i++){
								String criterion = criterionList.get(i).toString();
//								System.out.println("��ѯ������" + criterion);
								if(i>0){
									query.append(" and ");
								}
								query.append("this_.");
								query.append(criterion.trim());
							}
						}
					}
					Field orderField = criteria.getClass().getDeclaredField("orderEntries");
					orderField.setAccessible(true);
					Object orderObj = orderField.get(criteria);
					if(orderObj != null){
						List orderList = (List) orderObj;
						if(orderList.size() > 0){
							query.append(" order by ");
							for(int i=0;i<orderList.size();i++){
								String order = orderList.get(i).toString();
								if(i>0){
									query.append(" , ");
								}
								query.append(order.trim());
							}
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
				} 
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(type);
				List<T> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<T>) execute(action);
	}
	
	/**
	 * ����������ǰ�汾����ڣ���ɾ���������ݣ����򴴽���
	 */
	public void upateVersionForCreateTable(){
		//�����ʱɾ����������
		if(checkTableExits()){
			deleteTableDatas();
		}else{
			createTable();
		}
	}
	
	/**
	 * ������
	 */
	private void createTable(){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				Table table = type.getAnnotation(Table.class);
				String tablename = table.name() + "_" + getVersion();
				if(StringUtils.isNotEmpty(table.schema())){
					tablename = table.schema() + "." + tablename;
				}
				query.append("create table ");
				query.append(tablename);
				query.append(" ( ");
				List<Field> fields = getSQLFields(type);
				List<Field> pkFields = new ArrayList<Field>();
				List<Field> fkFields = new ArrayList<Field>();
				for(Field field:fields){
					if(field.getAnnotation(Id.class) != null){
						pkFields.add(field);
					}
					if(field.getAnnotation(Fk.class) != null){
						fkFields.add(field);
					}
					FieldType fieldType = field.getAnnotation(FieldType.class);
					query.append(field.getName());
					if(fieldType ==null){
						query.append(" varchar(256) ");
					}else{
						query.append(" ");
						query.append(fieldType.value());
						if(fieldType.notNull()){
							query.append(" not null");
						}
					}
					query.append(" , ");
				}
				if(pkFields.isEmpty()){
					throw new HibernateException("pk is not exits :" + type.getName());
				}
				query.append(" primary key ( ");
				for(int i=0;i<pkFields.size();i++){
					if(i>0){
						query.append(",");
					}
					query.append(pkFields.get(i).getName());
				}
				query.append(" ) ");
				if(fkFields.size() > 0){
					for(Field field : fkFields){
						Fk fk = field.getAnnotation(Fk.class);
						query.append(", foreign key (");
						query.append(field.getName());
						query.append(") references ");
						query.append(fk.tablename());
						query.append(" (");
						query.append(fk.fkfield());
						query.append(") ");
						if(fk.deleteCascade()){
							query.append(" on delete cascade ");
						}
						if(fk.updateCascade()){
							query.append(" on update cascade ");
						}
					}
				}
				query.append(") ");
				TableSpace tableSpace = type.getAnnotation(TableSpace.class);
				if(tableSpace != null){
					query.append(" TABLESPACE ");
					query.append("\""+tableSpace.name()+"\"");
				}
				query.append(";");
				SQLQuery q = session.createSQLQuery(query.toString());
				int flag = q.executeUpdate();
				session.clear();
				return flag;
			}
		};
		execute(action);
	}
	
	/**
	 * ɾ����������
	 */
	private void deleteTableDatas(){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				Table table = type.getAnnotation(Table.class);
				if(table == null){
					throw new HibernateException("table name not exits " + type.getName());
				}
				String tablename = table.name() + "_" + getVersion();
				if(StringUtils.isNotEmpty(table.schema())){
					tablename = table.schema() + "." + tablename;
				}
				query.append("truncate ");
				query.append(tablename);
				SQLQuery q = session.createSQLQuery(query.toString());
				int flag = q.executeUpdate();
				session.clear();
				return flag;
			}
		};
		execute(action);
	}
	
	/**
	 * У�鵱ǰ���Ƿ����
	 * @return true ���� false ������
	 */
	public boolean checkTableExits(){
		boolean flag = false;
		HibernateCallback action = new HibernateCallback() {
			@SuppressWarnings("rawtypes")
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select count(1) from pg_tables where ");
				Table table = type.getAnnotation(Table.class);
				if(table == null){
					throw new HibernateException("table name not exits " + type.getName());
				}
				Map<String, String> map = new HashMap<String, String>();
				query.append("tablename = :tablename");
				map.put("tablename", table.name().toLowerCase() + "_" + getVersion());
				if(StringUtils.isNotEmpty(table.schema())){
					query.append(" and schemaname = :schemaname");
					map.put("schemaname", table.schema().toLowerCase());
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setProperties(map);
				List list = q.list();
				session.clear();
				return getCount(list);
			}
		};
		Integer count = (Integer) execute(action);
		if(count > 0){
			flag = true;
		}
		return flag;
	}

	/**
	 * ɾ����
	 */
	public void dropTable(){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("drop table ");
				Table table = type.getAnnotation(Table.class);
				if(StringUtils.isNotEmpty(table.schema())){
					query.append(table.schema());
					query.append(".");
				}
				query.append(table.name());
				query.append("_");
				query.append(getVersion());
				SQLQuery q = session.createSQLQuery(query.toString());
				int flag = q.executeUpdate();
				session.clear();
				return flag;
			}
		};
		execute(action);
	}
}
