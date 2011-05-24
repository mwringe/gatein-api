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
import org.gatein.api.navigation.Node;
import org.gatein.api.navigation.NodeManager;
import org.gatein.api.navigation.Page;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public class NodeTestCase
{

   Portal portal = ((GateIn)null).getPortal();
   NodeManager nodeManager = portal.getNodeManager();
   
   public void testGetURI()
   {
      Node node = nodeManager.getNode("foo/bar");
      String nodeURI = node.getURI();
      //TODO: actual test
   }
   
   public void testGetPage()
   {
      Node node = nodeManager.getNode("foo/bar");
      Page nodePage = node.getPage();
      //TODO: actual test
   }
   
   public void testSetPage()
   {
      Node node = nodeManager.getNode("foo/bar2");
      
      Page.ID pageId = Page.ID.generateId("name", "ownerType", "ownerId");
      Page page = portal.getPageManager().getPage(pageId);
      
      node.setPage(page);
      //TODO: actual test
   }
   
   public void testGetAllNodes()
   {
      Node node = nodeManager.getNode("bar/foo1");
      Iterator<Node> nodes = node.getNodes(-1);
      //TODO: actual test
   }
   
   public void testGetChildNodes()
   {
      Node node = nodeManager.getNode("bar/foo1");
      Iterator<Node> nodes = node.getNodes(1);
      //TODO: actual test
   }
   
   public void testGetChildrendndGrandChildrenNodes()
   {
      Node node = nodeManager.getNode("bar/foo1");
      Iterator<Node> nodes = node.getNodes(2);
      //TODO: actual test
   }
   
   public void testLabel()
   {
      //TODO: actual test
   }

   //TODO: the actual tests
}

