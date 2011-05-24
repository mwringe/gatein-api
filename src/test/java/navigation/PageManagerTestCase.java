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
import java.util.regex.Pattern;

import org.gatein.api.GateIn;
import org.gatein.api.Portal;
import org.gatein.api.Query;
import org.gatein.api.navigation.Page;
import org.gatein.api.navigation.PageManager;
import org.gatein.api.navigation.PageManager.PageProperty;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public class PageManagerTestCase
{
   Portal portal = ((GateIn)null).getPortal();
   
   public void testGetPortalLayout()
   {
      PageManager pageManager = portal.getPageManager();
      Page layout = pageManager.getLayout();
      //TODO: actual test
   }
   
   public void testGetPagesByOwnerType()
   {
      PageManager pageManager = portal.getPageManager();
      
      Query query = pageManager.createPageQuery();
      query.addSearchProperty(PageProperty.OWNERTYPE.name(), "foo");
      
      Iterator<Page> pages = pageManager.getPages(query);
      //TODO: actual test
   }
   
   public void testGetPagesByOwnerId()
   {
      PageManager pageManager = portal.getPageManager();
      
      Query query = pageManager.createPageQuery();
      query.addSearchProperty(PageProperty.OWNERID.name(), "foo");
      
      Iterator<Page> pages = pageManager.getPages(query);
      //TODO: actual test
   }
   
   public void testGetPagesByTitle()
   {
      PageManager pageManager = portal.getPageManager();
      
      Query query = pageManager.createPageQuery();
      query.addSearchProperty(PageProperty.TITLE.name(), "foo");
      
      Iterator<Page> pages = pageManager.getPages(query);
      //TODO: actual test
   }
   
   public void testGetPages()
   {
      PageManager pageManager = portal.getPageManager();
      
      //Query to find pages with titles that contain foo, ownerid which contain bar
      // and returns the results 10 through 20 (ie for pagination).
      Query query = pageManager.createPageQuery();
      query.addSearchProperty(PageProperty.TITLE.name(), "foo");
      query.addSearchProperty(PageProperty.OWNERID.name(), "bar");
      query.setStartElement(10);
      query.setEndElement(20);
      
      Iterator<Page> pages = pageManager.getPages(query);
      //TODO: actual test
   }
   
   public void testCreatePage()
   {
      PageManager pageManager = portal.getPageManager();
      Page.ID pageId = Page.ID.generateId("PageName", "OwnerType", "OwnerId");
      Page page = pageManager.createPage(pageId);
      //TODO: actual test
   }
   
   public void testDeletePage()
   {
      PageManager pageManager = portal.getPageManager();
      Page.ID pageId = Page.ID.generateId("PageName", "OwnerType", "OwnerId");
      pageManager.deletePage(pageId);
      //TODO: actual test
   }
   
   public void testGetPage()
   {
      PageManager pageManager = portal.getPageManager();
      
      Page.ID pageId = Page.ID.generateId("PageName", "OwnerType", "OwnerId");
      
      Page page = pageManager.getPage(pageId);
      //TODO: actual test
   }
}

