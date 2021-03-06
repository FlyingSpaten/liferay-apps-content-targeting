/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.content.targeting.report.campaign.tracking.action.service.base;

import com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction;
import com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionFinder;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionPersistence;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionTotalFinder;
import com.liferay.content.targeting.report.campaign.tracking.action.service.persistence.CTActionTotalPersistence;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.model.PersistedModel;
import com.liferay.portal.service.BaseLocalServiceImpl;
import com.liferay.portal.service.PersistedModelLocalServiceRegistryUtil;
import com.liferay.portal.service.persistence.UserPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the c t action local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CTActionLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.impl.CTActionLocalServiceImpl
 * @see com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalServiceUtil
 * @generated
 */
public abstract class CTActionLocalServiceBaseImpl extends BaseLocalServiceImpl
	implements CTActionLocalService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalServiceUtil} to access the c t action local service.
	 */

	/**
	 * Adds the c t action to the database. Also notifies the appropriate model listeners.
	 *
	 * @param ctAction the c t action
	 * @return the c t action that was added
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CTAction addCTAction(CTAction ctAction) throws SystemException {
		ctAction.setNew(true);

		return ctActionPersistence.update(ctAction);
	}

	/**
	 * Creates a new c t action with the primary key. Does not add the c t action to the database.
	 *
	 * @param CTActionId the primary key for the new c t action
	 * @return the new c t action
	 */
	@Override
	public CTAction createCTAction(long CTActionId) {
		return ctActionPersistence.create(CTActionId);
	}

	/**
	 * Deletes the c t action with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param CTActionId the primary key of the c t action
	 * @return the c t action that was removed
	 * @throws PortalException if a c t action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CTAction deleteCTAction(long CTActionId)
		throws PortalException, SystemException {
		return ctActionPersistence.remove(CTActionId);
	}

	/**
	 * Deletes the c t action from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ctAction the c t action
	 * @return the c t action that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public CTAction deleteCTAction(CTAction ctAction) throws SystemException {
		return ctActionPersistence.remove(ctAction);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(CTAction.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return ctActionPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return ctActionPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	@SuppressWarnings("rawtypes")
	public List dynamicQuery(DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return ctActionPersistence.findWithDynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery)
		throws SystemException {
		return ctActionPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows that match the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows that match the dynamic query
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) throws SystemException {
		return ctActionPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public CTAction fetchCTAction(long CTActionId) throws SystemException {
		return ctActionPersistence.fetchByPrimaryKey(CTActionId);
	}

	/**
	 * Returns the c t action with the primary key.
	 *
	 * @param CTActionId the primary key of the c t action
	 * @return the c t action
	 * @throws PortalException if a c t action with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public CTAction getCTAction(long CTActionId)
		throws PortalException, SystemException {
		return ctActionPersistence.findByPrimaryKey(CTActionId);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException, SystemException {
		return ctActionPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the c t actions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.content.targeting.report.campaign.tracking.action.model.impl.CTActionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of c t actions
	 * @param end the upper bound of the range of c t actions (not inclusive)
	 * @return the range of c t actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<CTAction> getCTActions(int start, int end)
		throws SystemException {
		return ctActionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of c t actions.
	 *
	 * @return the number of c t actions
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int getCTActionsCount() throws SystemException {
		return ctActionPersistence.countAll();
	}

	/**
	 * Updates the c t action in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param ctAction the c t action
	 * @return the c t action that was updated
	 * @throws SystemException if a system exception occurred
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public CTAction updateCTAction(CTAction ctAction) throws SystemException {
		return ctActionPersistence.update(ctAction);
	}

	/**
	 * Returns the c t action local service.
	 *
	 * @return the c t action local service
	 */
	public com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService getCTActionLocalService() {
		return ctActionLocalService;
	}

	/**
	 * Sets the c t action local service.
	 *
	 * @param ctActionLocalService the c t action local service
	 */
	public void setCTActionLocalService(
		com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService ctActionLocalService) {
		this.ctActionLocalService = ctActionLocalService;
	}

	/**
	 * Returns the c t action remote service.
	 *
	 * @return the c t action remote service
	 */
	public com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionService getCTActionService() {
		return ctActionService;
	}

	/**
	 * Sets the c t action remote service.
	 *
	 * @param ctActionService the c t action remote service
	 */
	public void setCTActionService(
		com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionService ctActionService) {
		this.ctActionService = ctActionService;
	}

	/**
	 * Returns the c t action persistence.
	 *
	 * @return the c t action persistence
	 */
	public CTActionPersistence getCTActionPersistence() {
		return ctActionPersistence;
	}

	/**
	 * Sets the c t action persistence.
	 *
	 * @param ctActionPersistence the c t action persistence
	 */
	public void setCTActionPersistence(CTActionPersistence ctActionPersistence) {
		this.ctActionPersistence = ctActionPersistence;
	}

	/**
	 * Returns the c t action finder.
	 *
	 * @return the c t action finder
	 */
	public CTActionFinder getCTActionFinder() {
		return ctActionFinder;
	}

	/**
	 * Sets the c t action finder.
	 *
	 * @param ctActionFinder the c t action finder
	 */
	public void setCTActionFinder(CTActionFinder ctActionFinder) {
		this.ctActionFinder = ctActionFinder;
	}

	/**
	 * Returns the c t action total local service.
	 *
	 * @return the c t action total local service
	 */
	public com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalService getCTActionTotalLocalService() {
		return ctActionTotalLocalService;
	}

	/**
	 * Sets the c t action total local service.
	 *
	 * @param ctActionTotalLocalService the c t action total local service
	 */
	public void setCTActionTotalLocalService(
		com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalService ctActionTotalLocalService) {
		this.ctActionTotalLocalService = ctActionTotalLocalService;
	}

	/**
	 * Returns the c t action total remote service.
	 *
	 * @return the c t action total remote service
	 */
	public com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalService getCTActionTotalService() {
		return ctActionTotalService;
	}

	/**
	 * Sets the c t action total remote service.
	 *
	 * @param ctActionTotalService the c t action total remote service
	 */
	public void setCTActionTotalService(
		com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalService ctActionTotalService) {
		this.ctActionTotalService = ctActionTotalService;
	}

	/**
	 * Returns the c t action total persistence.
	 *
	 * @return the c t action total persistence
	 */
	public CTActionTotalPersistence getCTActionTotalPersistence() {
		return ctActionTotalPersistence;
	}

	/**
	 * Sets the c t action total persistence.
	 *
	 * @param ctActionTotalPersistence the c t action total persistence
	 */
	public void setCTActionTotalPersistence(
		CTActionTotalPersistence ctActionTotalPersistence) {
		this.ctActionTotalPersistence = ctActionTotalPersistence;
	}

	/**
	 * Returns the c t action total finder.
	 *
	 * @return the c t action total finder
	 */
	public CTActionTotalFinder getCTActionTotalFinder() {
		return ctActionTotalFinder;
	}

	/**
	 * Sets the c t action total finder.
	 *
	 * @param ctActionTotalFinder the c t action total finder
	 */
	public void setCTActionTotalFinder(CTActionTotalFinder ctActionTotalFinder) {
		this.ctActionTotalFinder = ctActionTotalFinder;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();

		PersistedModelLocalServiceRegistryUtil.register("com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction",
			ctActionLocalService);
	}

	public void destroy() {
		PersistedModelLocalServiceRegistryUtil.unregister(
			"com.liferay.content.targeting.report.campaign.tracking.action.model.CTAction");
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return CTAction.class;
	}

	protected String getModelClassName() {
		return CTAction.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = ctActionPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService.class)
	protected com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionLocalService ctActionLocalService;
	@BeanReference(type = com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionService.class)
	protected com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionService ctActionService;
	@BeanReference(type = CTActionPersistence.class)
	protected CTActionPersistence ctActionPersistence;
	@BeanReference(type = CTActionFinder.class)
	protected CTActionFinder ctActionFinder;
	@BeanReference(type = com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalService.class)
	protected com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalLocalService ctActionTotalLocalService;
	@BeanReference(type = com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalService.class)
	protected com.liferay.content.targeting.report.campaign.tracking.action.service.CTActionTotalService ctActionTotalService;
	@BeanReference(type = CTActionTotalPersistence.class)
	protected CTActionTotalPersistence ctActionTotalPersistence;
	@BeanReference(type = CTActionTotalFinder.class)
	protected CTActionTotalFinder ctActionTotalFinder;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private CTActionLocalServiceClpInvoker _clpInvoker = new CTActionLocalServiceClpInvoker();
}