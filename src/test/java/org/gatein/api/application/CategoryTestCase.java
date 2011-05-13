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

import org.gatein.api.AccessPermissions;
import org.gatein.api.GateIn;
import org.gatein.api.Portal;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public class CategoryTestCase
{

   Portal portal = ((GateIn)null).getPortal();
   ApplicationRegistry appRegistry = portal.getApplicationRegistry();
   
   public void testGetManagedPortlet()
   {
      Category category = appRegistry.getCategory("categoryA");

      Application.ID appID = Portlet.ID.generateID("appName", "portletName");
      ManagedApplication managedApplication = category.getManagedApplication("aPortlet", appID);
      //TODO: actual test
   }

   public void testDeleteManagedPortlet()
   {
      Category category = appRegistry.getCategory("categoryA");

      Application.ID appID = Portlet.ID.generateID("appName", "portletName");
      category.deleteManagedApplication("aPortlet", appID);
      //TODO: actual test
   }
   
   public void testCreateManagedPortlet()
   {
      Category category = appRegistry.getCategory("categoryA");

      Application.ID appID = Portlet.ID.generateID("appName", "portletName");
      ManagedApplication managedApplication = category.createManagedApplication("aPortlet", appID);
      //TODO: actual test
   }
   
   public void testGetManagedGadget()
   {
      Category category = appRegistry.getCategory("categoryA");
      
      Application.ID appID = Gadget.ID.generateID("gadget_name");
      ManagedApplication managedApplication = category.getManagedApplication("aGadget", appID);
      //TODO: actual test
   }
 
   public void testDeleteManagedGadget()
   {
      Category category = appRegistry.getCategory("categoryA");
      
      Application.ID appID = Gadget.ID.generateID("gadget_name");
      category.deleteManagedApplication("aGadget", appID);
      //TODO: actual test
   }
   
   public void testCreateManagedGadget()
   {
      Category category = appRegistry.getCategory("categoryA");
      
      Application.ID appID = Gadget.ID.generateID("gadget_name");
      ManagedApplication managedApplication = category.createManagedApplication("aGadget", appID);
      //TODO: actual test
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

