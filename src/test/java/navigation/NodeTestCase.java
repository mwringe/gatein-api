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
import java.util.List;

import org.gatein.api.GateIn;
import org.gatein.api.Portal;
import org.gatein.api.navigation.Node;
import org.gatein.api.navigation.Page;
import org.testng.Assert;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public class NodeTestCase
{

   Portal portal = ((GateIn)null).getPortal();
   
   public void testGetNode()
   {
      Node node = portal.getNode("foo", "bar");
      Assert.assertNotNull(node);
      //TODO: actual test
   }
   
   public void testGetPage()
   {
      Node node = portal.getNode("foo", "bar");
      Assert.assertNotNull(node);
      Page nodePage = node.getPage();
      Assert.assertNotNull(nodePage);
      //TODO: actual test
   }

   public void testGetAllNodes()
   {
      Node node = portal.getNode("bar", "foo1");
      List<Node> nodes = node.getNodes(-1);
      Assert.assertNotNull(nodes);
      Assert.assertFalse(nodes.isEmpty());
      //TODO: actual test
   }
   
   public void testGetChildNodes()
   {
      Node node = portal.getNode("bar", "foo1");
      List<Node> nodes = node.getNodes(1);
      //TODO: actual test
   }
   
   public void testGetChildrendndGrandChildrenNodes()
   {
      Node node = portal.getNode("bar", "foo1");
      List<Node> nodes = node.getNodes(2);
      //TODO: actual test
   }
   
   public void testLabel()
   {
      //TODO: actual test
   }

   //TODO: the actual tests
}

