package com.mehta.web.interceptor;

import org.hibernate.EmptyInterceptor;
import org.springframework.stereotype.Component;

@Component
public class EibpHibernateCallbackInterceptor extends EmptyInterceptor {

	private static final long serialVersionUID = 1L;

	/*
	 * private static final long serialVersionUID = -1205144912038582043L;
	 * 
	 * private boolean canAddCurrencyClasses; private boolean
	 * canUpdateCurrencyClasses; private boolean canDeleteCurrencyClasses;
	 * 
	 * private boolean canAddContactPointClasses; private boolean
	 * canUpdateContactPointClasses; private boolean
	 * canDeleteContactPointClasses;
	 * 
	 * private boolean canAddContactPointEmailClasses; private boolean
	 * canUpdateContactPointEmailClasses; private boolean
	 * canDeleteContactPointEmailClasses;
	 * 
	 * private boolean canAddContactPointNumberClasses; private boolean
	 * canUpdateContactPointNumberClasses; private boolean
	 * canDeleteContactPointNumberClasses;
	 * 
	 * private boolean canAddCustomerCorporateContactPointClasses; private
	 * boolean canUpdateCustomerCorporateContactPointClasses; private boolean
	 * canDeleteCustomerCorporateContactPointClasses;
	 * 
	 * private boolean canAddCustomerIndividualContactPointClasses; private
	 * boolean canUpdateCustomerIndividualContactPointClasses; private boolean
	 * canDeleteCustomerIndividualContactPointClasses;
	 * 
	 * static ContactPointService contactPointService; static
	 * ContactPointEmailService contactPointEmailService; static
	 * ContactPointNumberService contactPointNumberService; static
	 * CurrencyService currencyService; static CustomeContactPointsService
	 * customeContactPointsService;
	 * 
	 * private Integer deletedEntityId;
	 * 
	 * @Override public boolean onLoad(Object entity, Serializable id, Object[]
	 * state, String[] propertyNames, Type[] types) { System.out.println(
	 * "OnLoad - Interceptor Called");
	 * 
	 * if (entity instanceof Currency) { System.out.println(
	 * "Currency - Interceptor Called on Read..."); } else if (entity instanceof
	 * ContactPoint) { System.out.println(
	 * "ContactPoint - Interceptor Called on Read..."); } else if (entity
	 * instanceof ContactPointEmail) { System.out.println(
	 * "ContactPointEmail - Interceptor Called on Read..."); } else if (entity
	 * instanceof ContactPointNumber) { System.out.println(
	 * "ContactPointNumber - Interceptor Called on Read..."); } else if (entity
	 * instanceof CustomerCorporateContactPoint) { System.out.println(
	 * "CustomerCorporateContactPoint - Interceptor Called on Read..."); } else
	 * if (entity instanceof CustomerIndividualContactPoint) {
	 * System.out.println(
	 * "CustomerIndividualContactPoint - Interceptor Called on Read..."); }
	 * return super.onLoad(entity, id, state, propertyNames, types); }
	 * 
	 * @Override public boolean onSave(Object entity, Serializable id, Object[]
	 * state, String[] propertyNames, Type[] types) { System.out.println(
	 * "OnSave - Interceptor Called"); if (entity instanceof Currency) {
	 * canAddCurrencyClasses = true; } else if (entity instanceof ContactPoint)
	 * { canAddContactPointClasses = true; } else if (entity instanceof
	 * ContactPointEmail) { canAddContactPointEmailClasses = true; } else if
	 * (entity instanceof ContactPointNumber) { canAddContactPointNumberClasses
	 * = true; } else if (entity instanceof CustomerCorporateContactPoint) {
	 * canAddCustomerCorporateContactPointClasses = true; } else if (entity
	 * instanceof CustomerIndividualContactPoint) {
	 * canAddCustomerIndividualContactPointClasses = true; } return
	 * super.onSave(entity, id, state, propertyNames, types); }
	 * 
	 * @Override public void onDelete(Object entity, Serializable id, Object[]
	 * state, String[] propertyNames, Type[] types) { System.out.println(
	 * "OnDelete - Interceptor Called");
	 * 
	 * if (entity instanceof Currency) { deletedEntityId = (Integer) id;
	 * canDeleteCurrencyClasses = true; } else if (entity instanceof
	 * ContactPoint) { canDeleteContactPointClasses = true; } else if (entity
	 * instanceof ContactPointEmail) { canDeleteContactPointEmailClasses = true;
	 * } else if (entity instanceof ContactPointNumber) {
	 * canDeleteContactPointNumberClasses = true; } else if (entity instanceof
	 * CustomerCorporateContactPoint) {
	 * canDeleteCustomerCorporateContactPointClasses = true; } else if (entity
	 * instanceof CustomerIndividualContactPoint) {
	 * canDeleteCustomerIndividualContactPointClasses = true; }
	 * super.onDelete(entity, id, state, propertyNames, types); }
	 * 
	 * @Override public void onCollectionUpdate(Object collection, Serializable
	 * key) throws CallbackException { System.out.println(
	 * "OnCollectionUpdate- Interceptor Called");
	 * super.onCollectionUpdate(collection, key); }
	 * 
	 * @Override public boolean onFlushDirty(Object entity, Serializable id,
	 * Object[] currentState, Object[] previousState, String[] propertyNames,
	 * Type[] types) { System.out.println("onFlushDirty - Interceptor Called");
	 * System.out.println(entity.getClass().getSimpleName()); if (entity
	 * instanceof Currency) { canUpdateCurrencyClasses = true; } else if (entity
	 * instanceof ContactPoint) { canUpdateContactPointClasses = true; } else if
	 * (entity instanceof ContactPointEmail) { canUpdateContactPointEmailClasses
	 * = true; } else if (entity instanceof ContactPointNumber) {
	 * canUpdateContactPointNumberClasses = true; } else if (entity instanceof
	 * CustomerCorporateContactPoint) {
	 * canUpdateCustomerCorporateContactPointClasses = true; } else if (entity
	 * instanceof CustomerIndividualContactPoint) {
	 * canUpdateCustomerIndividualContactPointClasses = true; } return
	 * super.onFlushDirty(entity, id, currentState, previousState,
	 * propertyNames, types); }
	 * 
	 * @Override public void preFlush(Iterator entities) { System.out.println(
	 * "preFlush - Interceptor Called"); super.preFlush(entities); }
	 * 
	 * @Override public void postFlush(Iterator entities) { System.out.println(
	 * "postFlush - Interceptor Called");
	 * 
	 * if (contactPointService == null) contactPointService =
	 * (ContactPointService)
	 * SpringApplicationContext.getBean("contactPointServiceImpl"); if
	 * (contactPointEmailService == null) contactPointEmailService =
	 * (ContactPointEmailService)
	 * SpringApplicationContext.getBean("contactPointEmailServiceImpl"); if
	 * (contactPointNumberService == null) contactPointNumberService =
	 * (ContactPointNumberService)
	 * SpringApplicationContext.getBean("contactPointNumberServiceImpl"); if
	 * (currencyService == null) currencyService = (CurrencyService)
	 * SpringApplicationContext.getBean("currencyServiceImpl"); if
	 * (customeContactPointsService == null) customeContactPointsService =
	 * (CustomeContactPointsService)
	 * SpringApplicationContext.getBean("customeContactPointsServiceImpl");
	 * 
	 * while (entities.hasNext()) { Object entity = entities.next();
	 * 
	 * if (entity instanceof Currency) {
	 * 
	 * if (canAddCurrencyClasses) { canAddCurrencyClasses = false;
	 * currencyService.addCurrencyToMemcached((Currency) entity);
	 * System.out.println(
	 * "Currancy onSave Interceptor after flust(postflush) to DB..."); } else if
	 * (canUpdateCurrencyClasses) { canUpdateCurrencyClasses = false;
	 * currencyService.updateCurrencyToMemcached((Currency) entity);
	 * System.out.println(
	 * "Currancy onUpdate Interceptor after flust(postflush) to DB..."); } }
	 * else if (entity instanceof ContactPoint) { if (canAddContactPointClasses)
	 * { canAddContactPointClasses = false;
	 * contactPointService.addCompositeContactPointToMemcached((ContactPoint)
	 * entity); System.out.println(
	 * "ContactPoint onSave Interceptor after flust(postflush) to DB..."); }
	 * else if (canUpdateContactPointClasses) { canUpdateContactPointClasses =
	 * false;
	 * contactPointService.updateCompositeContactPointToMemcached((ContactPoint)
	 * entity); System.out.println(
	 * "ContactPoint onUpdate Interceptor after flust(postflush) to DB..."); }
	 * System.out.println(
	 * "ContactPoint onSave Interceptor after flust(postflush) to DB..."); }
	 * else if (entity instanceof ContactPointEmail) { System.out.println(
	 * "ContactPointEmail onSave Interceptor after flust(postflush) to DB...");
	 * } else if (entity instanceof ContactPointNumber) { System.out.println(
	 * "ContactPointNumber onSave Interceptor after flust(postflush) to DB...");
	 * } else if (entity instanceof CustomerCorporateContactPoint) {
	 * System.out.println(
	 * "CustomerCorporateContactPoint onSave Interceptor after flust(postflush) to DB..."
	 * ); } else if (entity instanceof CustomerIndividualContactPoint) {
	 * System.out.println(
	 * "CustomerIndividualContactPoint onSave Interceptor after flust(postflush) to DB..."
	 * ); } else if (entity instanceof Agent) { System.out.println(
	 * "Agent onSave Interceptor after flust(postflush) to DB..."); } }
	 * 
	 * //to deleete reocrds from memcached if (canDeleteCurrencyClasses) {
	 * canDeleteCurrencyClasses = false;
	 * currencyService.deleteCurrencyToMemcached(deletedEntityId);
	 * System.out.println(
	 * "Currancy onDelete Interceptor after flust(postflush) to DB..."); }else
	 * if (canDeleteContactPointClasses) { canDeleteCurrencyClasses = false;
	 * contactPointService.deleteCurrencyToMemcached(deletedEntityId);
	 * System.out.println(
	 * "ContactPoint onDelete Interceptor after flust(postflush) to DB...");
	 * }else if (canDeleteContactPointNumberClasses) { canDeleteCurrencyClasses
	 * = false; currencyService.deleteCurrencyToMemcached(deletedEntityId);
	 * System.out.println(
	 * "ContactPointNumber onDelete Interceptor after flust(postflush) to DB..."
	 * ); }else if (canDeleteContactPointEmailClasses) {
	 * canDeleteCurrencyClasses = false;
	 * currencyService.deleteCurrencyToMemcached(deletedEntityId);
	 * System.out.println(
	 * "ContactPointEmail onDelete Interceptor after flust(postflush) to DB..."
	 * ); }else if (canDeleteCustomerIndividualContactPointClasses) {
	 * canDeleteCurrencyClasses = false;
	 * currencyService.deleteCurrencyToMemcached(deletedEntityId);
	 * System.out.println(
	 * "CustomerIndividualContactPoint onDelete Interceptor after flust(postflush) to DB..."
	 * ); }else if (canDeleteCustomerCorporateContactPointClasses) {
	 * canDeleteCurrencyClasses = false;
	 * currencyService.deleteCurrencyToMemcached(deletedEntityId);
	 * System.out.println(
	 * "CustomerCorporateContactPoint onDelete Interceptor after flust(postflush) to DB..."
	 * ); }
	 * 
	 * super.postFlush(entities); }
	 */
}
