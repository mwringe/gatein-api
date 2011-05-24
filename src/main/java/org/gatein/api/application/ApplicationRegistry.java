/******************************************************************************
 * JBoss, a division of Red Hat                                               *
 * Copyright 2011, Red Hat Middleware, LLC, and individual                    *
 * contributors as indicated by the @authors tag. See the                     *
 * copyright.txt in the distribution for a full listing of                    *
 * individual contributors.                                                   *
 *                                                                            *
 * This is free software; you can redistribute it and/or modify it            *
 * under the terms of the GNU Lesser General Public License as                *
 * published by the Free Software Foundation; either version 2.1 of           *
 * the License, or (at your option) any later version.                        *
 *                                                                            *
 * This software is distributed in the hope that it will be useful,           *
 * but WITHOUT ANY WARRANTY; without even the implied warranty of             *
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU           *
 * Lesser General Public License for more details.                            *
 *                                                                            *
 * You should have received a copy of the GNU Lesser General Public           *
 * License along with this software; if not, write to the Free                *
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA         *
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.                   *
 ******************************************************************************/
package org.gatein.api.application;

import java.util.Iterator;
import org.gatein.api.application.repository.GadgetRepository;
import org.gatein.api.application.repository.PortletRepository;
import org.gatein.api.exceptions.AlreadyExistsException;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public interface ApplicationRegistry
{
   public Category getCategory(String categoryName);
   
   //TODO: behaviour of create when it already exists. Should we throw an error or just return the previously created object?
   public Category createCategory(String categoryName) throws AlreadyExistsException;
   
   public void deleteCategory(String categoryName);
   public Iterator getCategories();
   
   //TODO: maybe figure out a better way to handle the 'repository' situation?
   public PortletRepository getPortletRepository(String name); // ie name=local/self/...
   // assumes we don't have a lot of different portlet repositories available, so no need to use a query object
   public Iterator<PortletRepository> getPortletRepositories();
   
   public GadgetRepository getGadgetRepository();
   
   //TODO: have something like importAllApplications() like what we have in the GUI?
   
   //TODO: have methods here to directly access what portlet/gadgets can be retrieved? Or force user to go through all
   // categories searching for things? For example, the dashboard needs access to a list of categories which only contain gadgets...
   //public Iterator getApplications(Query query);
}

