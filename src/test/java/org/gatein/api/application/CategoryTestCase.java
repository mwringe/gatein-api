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

import java.util.List;

import org.gatein.api.GateIn;
import org.gatein.api.Portal;
import org.gatein.api.application.repository.GadgetRepository;
import org.gatein.api.application.repository.PortletRepository;
import org.gatein.api.application.repository.WSRPPortletRepository;
import org.gatein.api.exceptions.AlreadyExistsException;
import org.gatein.api.permissions.AccessPermissions;
import org.testng.Assert;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public class CategoryTestCase
{

   Portal portal = ((GateIn)null).getPortal();
   ApplicationRegistry appRegistry = portal.getApplicationRegistry();
   
   public void testGetCategory()
   {
      Category category = appRegistry.getCategory("categoryA");
      Assert.assertNotNull(category);
      
      Assert.assertEquals(category.getName(), "categoryA");
      Assert.assertEquals(category.getDisplayName(), "displayNameA");
      Assert.assertEquals(category.getDescription(), "descriptionA");
      
      AccessPermissions accessPermissions = category.getAccessPermissions();
      Assert.assertNotNull(accessPermissions);
      //TODO: add more checks on the accessPermissions object
      
      List<ManagedApplication> managedApplications = category.getManagedApplications();
      Assert.assertEquals(managedApplications.size(), 4);
      //TODO: add more checks on the returned ManagedApplications
   }
   
   public void testModifyCategory()
   {
      Category category = appRegistry.getCategory("categoryB");
      Assert.assertNotNull(category);
      
      Assert.assertEquals(category.getName(), "categoryB");
      Assert.assertEquals(category.getDisplayName(), "displayNameB");
      category.setDisplayName("someOtherDisplayName");
      Assert.assertEquals(appRegistry.getCategory("categoryB").getDisplayName(), "someOtherDisplayName");
      
      Assert.assertEquals(category.getDescription(), "descriptionB");
      category.setDescription("someOtherDescription");
      Assert.assertEquals(appRegistry.getCategory("categoryB").getDescription(), "someOtherDescription");
      
      AccessPermissions accessPermissions = category.getAccessPermissions();
      Assert.assertNotNull(accessPermissions);
      //TODO: modify the accessPermissions object and check that it gets properly updated
   }
   
   public void testGetManagedApplication()
   { 
      Category category = appRegistry.getCategory("categoryA");
      
      ManagedApplication application = category.getManagedApplication("portletA");
      
      Assert.assertNotNull(application);
   }
   
   public void testGetPortlet()
   {
      Category category = appRegistry.getCategory("categoryA");
      ManagedApplication application = category.getManagedApplication("portletA");
      
      if (application.getApplication() instanceof Portlet)
      {
         Portlet portlet = (Portlet)application.getApplication();
         //TODO: add checks on the returned portlet
      }
      else
      {
         Assert.fail("Expected the application to be a gadget.");
      }
   }
   
   public void testDeletePortlet()
   {
      Category category = appRegistry.getCategory("categoryA");
      category.deleteManagedApplication("portletA");
      
      Assert.assertNull(category.getManagedApplication("portletA"));
      Assert.assertNull(appRegistry.getCategory("categoryA").getManagedApplication("portletA"));
   }
   
   public void testAddPortlet()
   {
      Category category = appRegistry.getCategory("categoryA");
      
      PortletRepository portletRepository = appRegistry.getPortletRepository();
      Application portlet = portletRepository.getPortlet("applicationA", "portletC");
      ManagedApplication managedPortlet = category.addManagedApplication("portletB", portlet);
      
      Assert.assertNotNull(category.getManagedApplication("portletB"));
      Assert.assertNotNull(appRegistry.getCategory("categoryA").getManagedApplication("portletB"));
      
      //TODO: check that the properties of the returned portlet.
      
      try
      {
         category.addManagedApplication("portletB", portlet);
         Assert.fail();
      }
      catch (AlreadyExistsException e)
      {
         //expected
      }
   }
   
   public void testAddWSRPPortlet()
   {
      Category category = appRegistry.getCategory("categoryA");
      
      WSRPPortletRepository portletRepository = appRegistry.getWSRPPortletRepository();
      Application portlet = portletRepository.getPortlet("invokerC", "portletC");
      ManagedApplication managedPortlet = category.addManagedApplication("portletB", portlet);
      
      Assert.assertNotNull(category.getManagedApplication("portletB"));
      Assert.assertNotNull(appRegistry.getCategory("categoryA").getManagedApplication("portletB"));
      
      //TODO: check that the properties of the returned portlet.
      
      try
      {
         category.addManagedApplication("portletB", portlet);
         Assert.fail();
      }
      catch (AlreadyExistsException e)
      {
         //expected
      }
   }
   
   public void testGetGadget()
   {
      Category category = appRegistry.getCategory("categoryA");
      ManagedApplication application = category.getManagedApplication("gadgetA");
      if (application.getApplication() instanceof Gadget)
      {
         Gadget gadget = (Gadget)application.getApplication();
         //TODO: adds checks on returned gadget
      }
      else
      {
         Assert.fail("Expected the application to be a gadget");
      }
   }
   
   public void testDeleteGadget()
   {
      Category category = appRegistry.getCategory("categoryA");
      category.deleteManagedApplication("gadgetA");
      
      Assert.assertNull(category.getManagedApplication("gadgetA"));
      Assert.assertNull(appRegistry.getCategory("categoryA").getManagedApplication("gadgetA"));
   }
   
   public void testAddGadget()
   {
      Category category = appRegistry.getCategory("categoryA");
      
      GadgetRepository gadgetRepository = appRegistry.getGadgetRepository();
      Application gadget = gadgetRepository.getGadget("gadgetB");
      ManagedApplication managedGadget = category.addManagedApplication("gadgetB", gadget);
      
      Assert.assertNotNull(category.getManagedApplication("gadgetB"));
      Assert.assertNotNull(appRegistry.getCategory("categoryA").getManagedApplication("gadgetB"));
      
      //TODO: perform checks on the created gadget
      
      try
      {
         category.addManagedApplication("gadgetB", gadget);
      }
      catch (AlreadyExistsException e)
      {
         //expected
      }
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

