/*
 *
 
package com.perennialsys.innovision.dao;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.DistinctRootEntityResultTransformer;

import com.perennialsys.innovision.constants.InnovisionConstant;
import com.perennialsys.innovision.constants.InnovisionUserType;
import com.perennialsys.innovision.db.HibernateUtil;
import com.perennialsys.innovision.enums.EnumUserType;
import com.perennialsys.innovision.exception.InnovisionException;
import com.perennialsys.innovision.logger.INVLogger;
import com.perennialsys.innovision.query.DBQueries;
import com.perennialsys.innovision.util.KeyValue;
import com.perennialsys.innovision.vo.AwardedProjectsVO;
import com.perennialsys.innovision.vo.MessagesAttachmentVO;
import com.perennialsys.innovision.vo.MessagesVO;
import com.perennialsys.innovision.vo.MilestoneDetailsVO;
import com.perennialsys.innovision.vo.NotificationVO;
import com.perennialsys.innovision.vo.PostProjectVO;
import com.perennialsys.innovision.vo.ProjectAttachmentVO;
import com.perennialsys.innovision.vo.ProjectCatagory;
import com.perennialsys.innovision.vo.ProjectLogVO;
import com.perennialsys.innovision.vo.ProjectSubCatagory;
import com.perennialsys.innovision.vo.RolesVO;
import com.perennialsys.innovision.vo.SubmitProposalVO;
import com.perennialsys.innovision.vo.UserVO;

*//**
 * The Class INVDAOImpl.
 *
 * @author musaddique
 *
 * @param <S>
 *            the generic type
 *//*
public class INVDAOImpl<S> implements IINVDAO<S> {

	*//** The session factory. *//*
	private SessionFactory sessionFactory;

	public INVDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public S getById(Class cls, Serializable id) throws InnovisionException {
		Session session = null;
		S s = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			s = (S) session.get(cls, id);
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
		return s;
	}

	@Override
	public S getByConditions(Class cls, List<KeyValue> conditions) throws InnovisionException {
		Session session = null;
		S s = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Criteria criteria = session.createCriteria(cls);
			if (conditions != null) {
				for (KeyValue keyValue : conditions) {
					criteria.add(Restrictions.eq(keyValue.getKey(), keyValue.getValue()));
				}
			}
			s = (S) criteria.uniqueResult();
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
		return s;
	}

	@Override
	public List<S> getObjectList(Class cls, List<KeyValue> conditions, List<KeyValue> orderByColumnNames,
			Integer startLimit, Integer offset) throws InnovisionException {

		return null;
	}

	@Override
	public Long save(S s) throws InnovisionException {
		Session session = null;
		Long id = 0l;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			id = (Long) session.save(s);
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
		} catch (HibernateException he) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
		return id;
	}

	@Override
	public void save(List<S> objects) throws InnovisionException {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveOrUpdate(S s) throws InnovisionException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.saveOrUpdate((s));
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
		} catch (HibernateException he) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public S merge(S s) throws InnovisionException {
		Session session = null;
		S s1 = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			s1 = (S) session.merge(s);
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
		} catch (HibernateException he) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(he.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return s1;
	}

	@Override
	public void delete(S s) throws InnovisionException {
		// TODO Auto-generated method stub
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			session.delete(s);

			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
		} catch (HibernateException he) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(he.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteById(Class cls, Serializable id) throws InnovisionException {
		// TODO Auto-generated method stub
		Session session = null;
		S s = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			s = (S) session.get(cls, id);
			if(s instanceof PostProjectVO){
				PropertyUtils.setProperty(s, "projectDesc", null);
				PropertyUtils.setProperty(s, "deliverablesOutcome", null);
				PropertyUtils.setProperty(s, "evalCriteria", null);
				PropertyUtils.setProperty(s, "generalTerms", null);
				PropertyUtils.setProperty(s, "submitPropsals", null);
			}
			if(s instanceof SubmitProposalVO){
				 List<MilestoneDetailsVO> list1=(List<MilestoneDetailsVO>)PropertyUtils.getProperty(s, "milestoneDetails");

				 for(MilestoneDetailsVO m:list1){
					 session.delete(m);
				 }
				 List<TechnicalBackgroundAttachmentVO> list12=(List<TechnicalBackgroundAttachmentVO>)PropertyUtils.getProperty(s, "technicalBackgroundAttachments");
				 for(TechnicalBackgroundAttachmentVO t:list12){
					 session.delete(t);
				 }
				PropertyUtils.setProperty(s, "milestoneDetails", null);
				PropertyUtils.setProperty(s, "technicalBackgroundAttachments", null);

			}
			if (s != null) {
				session.delete(s);
			}

			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
		} catch (HibernateException he) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(he.getMessage());
		} catch (IllegalAccessException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(e.getMessage());
		} catch (InvocationTargetException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(e.getMessage());
		} catch (NoSuchMethodException e) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(e.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public void deleteListOfObjects(List<S> objects) throws InnovisionException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteByConditions(Class cls, List<KeyValue> conditions) throws InnovisionException {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> executeSqlQuery(String sQuery, List<KeyValue> conditions) throws InnovisionException {
		Session session = null;
		List<Object[]> list = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(sQuery);
			if (conditions != null) {
				for (KeyValue kv : conditions) {
					if (kv.getKey().equalsIgnoreCase("sql_in_orgName")) {
						query.setParameterList(kv.getKey(), (List<String>) kv.getValue());
					}
					else if(kv.getKey().equalsIgnoreCase("project_limit_first_index")){
						query.setFirstResult((Integer)kv.getValue());
					}
					else if(kv.getKey().equalsIgnoreCase("project_limit_max_data")){
						query.setMaxResults((Integer)kv.getValue());
					} else {
						query.setParameter(kv.getKey(), kv.getValue());
					}
				}
			}

			list = query.list();
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
			if (list == null) {
				list = null;
			}
			return list;
		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Object> executeHqlQuery(String sQuery, List<KeyValue> conditions) throws InnovisionException {
		return executeHqlQuery(sQuery, conditions, false);
	}

	@Override
	public List<Object> executeHqlQueryWithLimit(String sQuery, List<KeyValue> conditions, int startIndex, int offset,boolean getDistinctRootEntities) throws InnovisionException {
		Session session = null;
		List<Object> list = null;


		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery(sQuery);
			if (conditions != null) {
				for (KeyValue kv : conditions) {
					if(kv.getValue() instanceof List){
						query.setParameterList(kv.getKey(),(Collection)kv.getValue());
					}
					else{
						query.setParameter(kv.getKey(), kv.getValue());
					}
				}
			}
			if(getDistinctRootEntities) {
				query.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
			}
			if(offset>0){
				query.setFirstResult(startIndex);
				query.setMaxResults(offset);
			}
			list = query.list();
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
			if (list == null || list.isEmpty()) {
				list = null;
			}
			return list;
		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Object> executeHqlQueryDistinctRootEntities(String sQuery, List<KeyValue> conditions)
			throws InnovisionException {
		return executeHqlQuery(sQuery, conditions, true);
	}

	private List<Object> executeHqlQuery(String sQuery, List<KeyValue> conditions, boolean getDistinctRootEntities) throws InnovisionException {
		Session session = null;
		List<Object> list = null;

		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery(sQuery);
			if (conditions != null) {
				for (KeyValue kv : conditions) {
					if (kv.getValue() instanceof Collection) {
						query.setParameterList(kv.getKey(), (Collection) kv.getValue());
					} else {
						query.setParameter(kv.getKey(), kv.getValue());
					}
				}
			}
			if(getDistinctRootEntities) {
				query.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
			}
			list = query.list();
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
			if (list == null || list.isEmpty()) {
				list = null;
			}
			return list;
		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public int deleteByHqlConditions(String hqlQuery, List<KeyValue> conditions) throws InnovisionException {
		Session session = null;
		int result = 0;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery(hqlQuery);
			if (conditions != null) {
				for (KeyValue kv : conditions) {
					query.setParameter(kv.getKey(), kv.getValue());
				}
			}

			result = query.executeUpdate();
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}

		} catch (HibernateException he) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(he.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return result;
	}

	@Override
	public Object getSingleColumnBySqlQuery(String sQuery, List<KeyValue> conditions) throws InnovisionException {
		Session session = null;
		Object obj = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(sQuery);
			if (conditions != null) {
				for (KeyValue kv : conditions) {
					if (kv.getKey().startsWith("sqllike_")) {
						query.setParameter(kv.getKey(), "%" + kv.getValue() + "%");
					} else {
						query.setParameter(kv.getKey(), kv.getValue());
					}
				}
			}
			obj = query.uniqueResult();

			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}

		} catch (HibernateException he) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(he.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return obj;
	}

	@Override
	public int updateBySqlQuery(String dbQuery, List<KeyValue> conditions) throws InnovisionException {
		Session session = null;
		int result = 0;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Query query = session.createSQLQuery(dbQuery);
			if (conditions != null) {
				for (KeyValue kv : conditions) {
					query.setParameter(kv.getKey(), kv.getValue());
				}
			}

			result = query.executeUpdate();
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}

		} catch (HibernateException he) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(he.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return result;

	}

	@Override
	public List<String> executeSqlQueryForString(String sQuery, List<KeyValue> conditions) throws InnovisionException {
		Session session = null;
		List<String> list = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			SQLQuery query = session.createSQLQuery(sQuery);
			if (conditions != null) {
				for (KeyValue kv : conditions) {
					query.setParameter(kv.getKey(), kv.getValue());
				}
			}
			list = query.list();
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
			if (list == null) {
				list = null;
			}
			return list;
		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public List<Object> getObjectList(String hqlQuery, List<KeyValue> conditions) throws InnovisionException {
		List<Object> objects = new ArrayList<Object>();
		objects = executeHqlQuery(hqlQuery, conditions);
		return objects;
	}

	@Override
	public List<Object[]> getColumnByHqlQuery(String hqlQuery, List<KeyValue> conditions) throws InnovisionException {
		Session session = null;
		List<Object[]> list = null;

		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery(hqlQuery);
			if (conditions != null) {
				for (KeyValue kv : conditions) {
					query.setParameter(kv.getKey(), kv.getValue());
				}
			}
			list = query.list();
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
			if (list == null || list.isEmpty()) {
				list = null;
			}
			return list;
		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public long getNoOfAdmin(long orgId) throws InnovisionException {

		Session session = null;
		long noOfAdmin;

		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery(DBQueries.GET_NO_OF_ADMINS).setBoolean("isDeleted", Boolean.FALSE)
					.setString("roleName", EnumUserType.ADMIN.name()).setLong("orgId", orgId);

			noOfAdmin = (Long) query.uniqueResult();

			return noOfAdmin;

		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}

	}

	@Override
	public Set<RolesVO> getRolesByUserId(Long userId) throws InnovisionException {

		Session session = null;
		Set<RolesVO> roles = null;

		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery(DBQueries.GET_USER_ROLES).setLong("userId", userId);

			List<RolesVO> rolesList = query.list();
			roles = new HashSet<RolesVO>(rolesList);

			return roles;

		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@Override
	public int updateByHQLQuery(String dbQuery, List<KeyValue> conditions) throws InnovisionException {
		Session session = null;
		int result = 0;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery(dbQuery);
			if (conditions != null) {
				for (KeyValue kv : conditions) {
					query.setParameter(kv.getKey(), kv.getValue());
				}
			}

			result = query.executeUpdate();
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}

		} catch (HibernateException he) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(he.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return result;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PostProjectVO> getProjectDetailsForDashBoardByUser(long userId,List<String> status,int offset,int limit) throws InnovisionException {

		Session session = null;
		List<PostProjectVO> projectList = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery("from PostProjectVO where status in (:pstatus) and user.id=:userId order by modifiedDateTime desc");
			query.setParameterList("pstatus", status);
			query.setParameter("userId", userId);
			query.setFirstResult(offset);
			if (limit>0) {
				query.setMaxResults(limit);
			}
			projectList = query.list();
			if (projectList != null) {
				for (PostProjectVO p : projectList) {
					AwardedProjectsVO awardedProject = p.getAwardedProject();
					List<SubmitProposalVO> submitPropsals = p.getSubmitPropsals();
					for(SubmitProposalVO submitProposalVO:submitPropsals){

					}
					if (awardedProject != null) {
						SubmitProposalVO submitProposal = awardedProject.getSubmitProposal();
						if (submitProposal != null) {
							List<MilestoneDetailsVO> md = submitProposal.getMilestoneDetails();
							if (md != null) {
								for (MilestoneDetailsVO m : md) {

								}
							}
						}
					}
					if(p.getMessages()!=null){
						for(MessagesVO m:p.getMessages()){

						}
					}

				}
			}
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
		return projectList;

	}

	@Override
	public List<ProjectCatagory> getAllCategories() throws InnovisionException {
		Session session = null;
		int result = 0;
		List<ProjectCatagory> categories = new ArrayList<ProjectCatagory>();
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery("FROM ProjectCatagory order by name ASC");


			categories =  query.list();
			for(ProjectCatagory projectCategory : categories){
				projectCategory.getId();
				for(ProjectSubCatagory subCategories : projectCategory.getProjectSubCatagories()){

				}}
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}

			} catch (HibernateException he) {
				if (session.getTransaction() != null) {
					session.getTransaction().rollback();
				}
				throw new InnovisionException(he.getMessage());
			}finally {
				if (session != null) {
					session.close();
				}
			}
		return categories;
	}

	@Override
	public PostProjectVO getProjectById(Class<PostProjectVO> class1, long postProjectId, String userType)
			throws InnovisionException {
		Session session = null;
		PostProjectVO proj = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			proj = (PostProjectVO) session.get(class1, postProjectId);
			if (InnovisionUserType.CLIENT.equalsIgnoreCase(userType)) {
				for (SubmitProposalVO proposalVO : proj.getSubmitPropsals()) {
					for (MilestoneDetailsVO milestones : proposalVO.getMilestoneDetails()) {

					}
					// fetch lazy data
				}
				if (proj.getProjectDesc() != null) {
					for (ProjectAttachmentVO attachVO : proj.getProjectDesc()
							.getProjectAttachments()) {
						// fetch lazy data
					}
				}
				for(MessagesVO messagesVO : proj.getMessages()){
					for (MessagesAttachmentVO messagesAttachVO : messagesVO
							.getMessagesAttachmentVOs()) {
						// fetch lazy data
					}
				}
				for (ProjectLogVO projectLogVO : proj.getProjectLogs()) {
					// fetch lazy data
				}

			} else if (InnovisionUserType.RESEARCHER.equalsIgnoreCase(userType)) {
				// fetch lazy data if needed for researcher
				if (proj.getProjectDesc() != null) {
					for (ProjectAttachmentVO attachVO : proj.getProjectDesc()
							.getProjectAttachments()) {
						// fetch lazy data
					}
				}
				for (MessagesVO messagesVO : proj.getMessages()) {
					for (MessagesAttachmentVO messagesAttachVO : messagesVO
							.getMessagesAttachmentVOs()) {
						// fetch lazy data
					}
				}
				for (ProjectLogVO projectLogVO : proj.getProjectLogs()) {
					// fetch lazy data
				}
			}
			 else if (InnovisionUserType.GUEST.equalsIgnoreCase(userType)) {
					// fetch lazy data if needed for researcher
					if (proj.getProjectDesc() != null) {
						for (ProjectAttachmentVO attachVO : proj.getProjectDesc()
								.getProjectAttachments()) {
							// fetch lazy data
						}
					}
			}
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
		return proj;
	}

	@Override
	public MessagesVO getMessageById(Class<MessagesVO> class1, long messageId) throws InnovisionException {
		Session session = null;
		MessagesVO msg = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			msg = (MessagesVO) session.get(class1, messageId);
			for (MessagesAttachmentVO attachVO : msg.getMessagesAttachmentVOs()) {
				// fetch lazy data
			}
		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	@Override
	public List<NotificationVO> getNotificationVO(long userId,int firstResult,int maxResult)throws InnovisionException{
		List<NotificationVO> notifications = new ArrayList<>();
		Session session=null;
		try {
			String query="from NotificationVO where toUser.id=:userId order by modifiedDateTime desc";
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Query hqlQuery = session.createQuery(query);
			hqlQuery.setLong("userId", userId);
			hqlQuery.setFirstResult(firstResult);
			hqlQuery.setMaxResults(maxResult);
			notifications=hqlQuery.list();
			if(notifications!=null){
				for(NotificationVO n:notifications){
					n.getFromUser();
				}
			}
		} catch (InnovisionException e) {
			INVLogger.error("INVDAOIMPL", "getNotification", "Notification error: "+e.getMessage());
			throw new InnovisionException(e.getMessage());
		}finally {
			if(session != null){
				session.close();
			}
		}
		return notifications;
	}

	@Override
	public long getNotificationCount(long userId)throws InnovisionException{
		long count=0;
		Session session=null;
		try {
			String query="select count(*) from NotificationVO where toUser.id=:userId and isRead=:readStatus";
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Query hqlQuery = session.createQuery(query);
			hqlQuery.setLong("userId", userId);
			hqlQuery.setBoolean("readStatus", Boolean.FALSE);
			count=(long)hqlQuery.uniqueResult();

		} catch (InnovisionException e) {
			INVLogger.error("INVDAOIMPL", "getNotification", "Notification error: "+e.getMessage());
			throw new InnovisionException(e.getMessage());
		}finally {
			if(session != null){
				session.close();
			}
		}
		return count;
	}

	@Override
	public byte[] getUserImage(long userId)throws InnovisionException{
		byte[] profileImage=null;
		Session session=null;
		try {
			String query="select profilePhoto from UserVO where id=:userId";
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			Query hqlQuery = session.createQuery(query);
			hqlQuery.setLong("userId", userId);
			if(hqlQuery.uniqueResult()!=null){
				profileImage=(byte[])hqlQuery.uniqueResult();
			}
		} catch (InnovisionException e) {
			INVLogger.error("INVDAOIMPL", "getNotification", "Notification error: "+e.getMessage());
			throw new InnovisionException(e.getMessage());
		}finally {
			if(session != null){
				session.close();
			}
		}
		return profileImage;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getUserList() throws InnovisionException {
		List<Object[]> userVOList = new ArrayList<>();
		Session session=null;
		try {
			String query="select u.firstName,u.lastName,u.userName,u.status,p.status FROM UserVO u join u.postProjects p where u.isDeleted =:notDeleted";
			
			session = sessionFactory.openSession();
			Query hqlQuery = session.createQuery(query);
			hqlQuery.setBoolean("notDeleted", Boolean.FALSE);
			userVOList=hqlQuery.list();
			if(userVOList!=null){
				for (UserVO userVO : userVOList) {
					if(userVO.getPostProjects()!=null){
						for (PostProjectVO postProjectVO : userVO.getPostProjects()) {
							//
						}
					}
					if(userVO.getSubmitProposals()!=null){
						for (SubmitProposalVO proposalVO : userVO.getSubmitProposals()) {
							//
						}
					}
				}
			}
		} catch (HibernateException e) {
			INVLogger.error("INVDAOIMPL", "getUserList", "getUserList error: "+e.getMessage());
			throw new InnovisionException(e.getMessage());
		}finally {
			if(session != null){
				session.close();
			}
		}
		return userVOList;
	}

	@Override
	public UserVO getUserById(Class<UserVO> userVO, Serializable userId) throws InnovisionException {
		Session session = null;
		UserVO dbUser = null;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			dbUser = (UserVO) session.get(userVO, userId);
			
			if(dbUser!=null && dbUser.getPostProjects()!=null){
				for (PostProjectVO project : dbUser.getPostProjects()) {
					// code for iterate projects
				}
			}
			if(dbUser!=null && dbUser.getSubmitProposals()!=null){
				for (SubmitProposalVO prposal : dbUser.getSubmitProposals()) {
					// code for iterate proposal
				}
			}
			
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}
		} catch (HibernateException he) {
			throw new InnovisionException(he.getMessage());
		}

		finally {
			if (session != null) {
				session.close();
			}
		}
		return dbUser;
	}

	@Override
	public int deleteMutipleRecordsUsingInQuery(String hqlQuery, List<KeyValue> conditions) throws InnovisionException {
		Session session = null;
		int result = 0;
		try {
			session = sessionFactory.openSession();
			session.getTransaction().begin();
			Query query = session.createQuery(hqlQuery);
			if (conditions != null) {
				for (KeyValue kv : conditions) {
					query.setParameterList(kv.getKey(), (Collection) kv.getValue());
				}
			}

			result = query.executeUpdate();
			if (!session.getTransaction().wasCommitted()) {
				session.getTransaction().commit();
			}

		} catch (HibernateException he) {
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
			throw new InnovisionException(he.getMessage());
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return result;
		
	}
}
*/