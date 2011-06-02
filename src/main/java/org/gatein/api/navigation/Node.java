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
package org.gatein.api.navigation;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.gatein.api.navigation.id.NodeId;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public interface Node
{
   public NodeId getNodeID();
   
   public String getName();
   
   public String getLabel();
   
   public Page getPage();
   
   public Date getStartPublicationDate();
   public Date getEndPublicationDate();
   
   /**
    * Returns the child nodes for this particular node.
    * 
    * The level determine how many levels of child nodes should be retrieved.
    * 
    * a level of 1 means return only the child nodes without their nodes populated (ie children nodes only)
    * a level of 2 means return the child nodes with only their child nodes populated (ie children plus grandchildren nodes)
    * 
    * a level of -1 will return all nodes
    * 
    * @param level How many levels of child nodes to fetch
    * @return the child nodes
    */
   public List<Node> getNodes(int level);
   
   /*
    * NOTE: excluded for the first version of the api
    * 
   public void setLabel(String label);
   public void setPage(Page page);

   public boolean isVisible();
   public void setVisible(boolean visible);

   public void setStartPublicationDate(Date stateDate);

   public void setEndPublicationDate(Date endDate);
   
   public Icon getIcon();
   public void setIcon(Icon icon);
   */
}

