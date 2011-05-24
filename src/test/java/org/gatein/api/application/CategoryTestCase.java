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

import org.gatein.api.GateIn;
import org.gatein.api.Portal;
import org.gatein.api.application.repository.GadgetRepository;
import org.gatein.api.application.repository.PortletRepository;
import org.gatein.api.permissions.AccessPermissions;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public class CategoryTestCase
{

   Portal portal = ((GateIn)null).getPortal();
   ApplicationRegistry appRegistry = portal.getApplicationRegistry();
   
   public void testGetPortlet()
   {
      Category category = appRegistry.getCategory("categoryA");
      Application application = category.getApplication("portletA");
      Portlet portlet = (Portlet)application;
      //TODO: actual test
   }
   
   public void testDeletePortlet()
   {
      Category category = appRegistry.getCategory("categoryA");
      category.deleteApplication("portletA");
      //TODO: actual test
   }
   
   public void testAddPortlet()
   {
      Category category = appRegistry.getCategory("categoryA");
      
      PortletRepository portletRepository = appRegistry.getPortletRepository(PortletRepository.LOCAL);
      Application portlet = portletRepository.getPortlet("applicationA", "portletC");
      Application managedPortlet = category.addApplication("portletB", portlet);
      //TODO: actual test
   }
   
   public void testGetGadget()
   {
      Category category = appRegistry.getCategory("categoryA");
      Application application = category.getApplication("gadgetA");
      Gadget gadget = (Gadget)application;
      //TODO: actual test
   }
   
   public void testDeleteGadget()
   {
      Category category = appRegistry.getCategory("categoryA");
      category.deleteApplication("gadgetA");
      //TODO: actual test
   }
   
   public void testAddGadget()
   {
      Category category = appRegistry.getCategory("categoryA");
      
      GadgetRepository gadgetRepository = appRegistry.getGadgetRepository();
      Application gadget = gadgetRepository.getGadget("gadgetB");
      Application managedPortlet = category.addApplication("gadgetB", gadget);
      //TODO: actual test
   }
   
   public void testGetApplications()
   {
      Category category = appRegistry.getCategory("categoryA");
      Iterator<Application> applications = category.getApplications();
      //TODO: actual tests
   }
   
   public void testGetAccessPermissions()
   {
      Category category = appRegistry.getCategory("categoryA");
      AccessPermissions accessPermissions = category.getAccessPermissions();
      //TODO: actual test
   }
   
   public void testUpdateAccessPermissions()
   {
      Category category = appRegistry.getCategory("categoryA");
      AccessPermissions accessPermissions = category.getAccessPermissions();
      //TODO: actual test
   }
   
   public void testDiscription()
   {
      Category category = appRegistry.getCategory("categoryA");
      String description = category.getDescription();
      //TODO: actual test
   }
   
   public void testDisplayName()
   {
      Category category = appRegistry.getCategory("categoryA");
      String displayName = category.getDisplayName();
      //TODO: actual test
   }
}

