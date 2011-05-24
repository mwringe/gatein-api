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

import org.gatein.api.Icon;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public interface Node
{
   public String getName();
   
   //TODO: do we need to expose the URI for a node?
   public String getURI();
   
   public String getLabel();
   public void setLabel(String label);
   
   public Page getPage();
   public void setPage(Page page);
   
   public Iterator<Node> getNodes(int level);
   
   public boolean isVisible();
   public void setVisible(boolean visible);
   
   public Date getStartPublicationDate();
   public void setStartPublicationDate(Date stateDate);
   
   public Date getEndPublicationDate();
   public void setEndPublicationDate(Date endDate);
   
   public Icon getIcon();
   public void setIcon(Icon icon);
}

