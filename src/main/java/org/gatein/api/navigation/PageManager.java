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

import java.util.Iterator;

import org.gatein.api.Query;
import org.gatein.api.navigation.id.PageId;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public interface PageManager
{
   //TODO: we need a way to query pages, not sure exactly how much we need to expose here
   //mimimum would be to return pages filtered based on owner, title and name
   //should also be able to query based on more complex requirements
   public Iterator<Page> getPages(Query query);
   
   public Page getPage(PageId id);
   
   /**
    * NOTE: creating/deleting will be the responsibility of this interface, but not for the first versions of the api.
    *
    * public Page createPage(String pageName);
    * public void deletePage(PageId id);
    * ...
    */
   
   /**
    * NOTE: we also need a getLayout() option to retrieve the portal layout. Not sure if this should go
    * here or in the portal object. Also not for the first version of the api.
    */
}

