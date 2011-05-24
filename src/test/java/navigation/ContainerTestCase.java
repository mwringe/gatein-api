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
package navigation;

import java.util.Iterator;

import org.gatein.api.GateIn;
import org.gatein.api.Portal;
import org.gatein.api.application.Application;
import org.gatein.api.application.ApplicationRegistry;
import org.gatein.api.application.Category;
import org.gatein.api.navigation.Page;
import org.gatein.api.navigation.PageManager;
import org.gatein.api.navigation.page.layout.Container;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public class ContainerTestCase
{

   Portal portal = ((GateIn)null).getPortal();
   PageManager pageManager = portal.getPageManager();
   
   public void testAllContainers()
   {
      Page.ID pageId = Page.ID.generateId("name", "ownerType", "ownerId");
      Page page = pageManager.getPage(pageId);
      Iterator<Container> containers = page.getContainers(-1);
      //TODO: actual test
   }
   
   public void testGetChildContainers()
   {
      Page.ID pageId = Page.ID.generateId("name", "ownerType", "ownerId");
      Page page = pageManager.getPage(pageId);
      Iterator<Container> containers = page.getContainers(1);
      //TODO: actual test
   }
   
   public void testAddContainer()
   {
      Page.ID pageId = Page.ID.generateId("name", "ownerType", "ownerId");
      Page page = pageManager.getPage(pageId);
      
      Container container = null;
      
      page.addContainer(container);
      //TODO: actual test
   }
   
   public void testGetContainer()
   {
      Page.ID pageId = Page.ID.generateId("name", "ownerType", "ownerId");
      Page page = pageManager.getPage(pageId);
      Container container = page.getContainer("containerA");
      //TODO: actual test
   }
   
   public void testDeleteContainer()
   {
      Page.ID pageId = Page.ID.generateId("name", "ownerType", "ownerId");
      Page page = pageManager.getPage(pageId);
      page.deleteContainer("containerA");
      //TODO: actual test
   }
   
   public void testAddApplication()
   {
      Page.ID pageId = Page.ID.generateId("name", "ownerType", "ownerId");
      Page page = pageManager.getPage(pageId);
      
      ApplicationRegistry appRegistry = portal.getApplicationRegistry();
      Category category = appRegistry.getCategory("catB");
      Application application = category.getApplication("appB");
      
      page.addApplication(application);
      //TODO: actual test
   }
   
   public void testGetApplications()
   {
      Page.ID pageId = Page.ID.generateId("name", "ownerType", "ownerId");
      Page page = pageManager.getPage(pageId);
      Iterator<Application> applications = page.getApplications();
      //TODO: actual test
   }
   
   public void testGetApplication()
   {
      Page.ID pageId = Page.ID.generateId("name", "ownerType", "ownerId");
      Page page = pageManager.getPage(pageId);
      Application application = page.getApplication("applicationA");
      //TODO: actual test
   }
}

