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
package org.gatein.api;

import java.util.Iterator;

import org.gatein.api.application.ApplicationRegistry;
import org.gatein.api.navigation.Node;
import org.gatein.api.navigation.Page;
import org.gatein.api.navigation.PageManager;
import org.gatein.api.navigation.id.NodeId;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public interface Portal
{
   /**
    * Retrieves the ApplicationRegistry for this particular portal
    * 
    * @return the ApplicationRegistry
    */
   public ApplicationRegistry getApplicationRegistry();
   
   /**
    * Retrieves the PageManager for this particular portal
    * 
    * @return the PageManager
    */
   public PageManager getPageManager();


   /**
    * Return a node based on the path of the node.
    * 
    * getNode() will return the root node
    * getNode("childA") will return the node named 'childA' of the root node
    * getNode("childA", "nodeB") will return the node named 'nodeB' of the child node 'childA' of the root node.
    * ...
    * 
    * @param node The node path
    * @return The node
    */
   public Node getNode(String... node);
   // NOTE: creating/deleting nodes happens at the Node level, not here
   
   /**
    * Returns a node based on the nodes id.
    * 
    * @param id the id of the node to retrieve
    * @return the node with the specified id
    */
   public Node getNode(NodeId id);
   
   /**
    * NOTE: having two methods to retrieve nodes is a bit of a compromise. Its feels more natural to use
    * paths, but paths can change if a node has been moved.
    */
}

