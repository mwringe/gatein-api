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

import java.util.Iterator;
import org.gatein.api.permissions.AccessPermissions;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public interface Category
{
   public Application getApplication(String name);
   
   public void deleteApplication(String name);
   
   //NOTE: the returned application is _not_ the same object as the one passed. The returned application
   // should be mostly a clone of the passed application (but maybe slightly different, eg the name passed may change something like the display-name).
   public Application addApplication(String name, Application application); 
   
   public Iterator<Application> getApplications();
   
   public AccessPermissions getAccessPermissions();
   //NOTE: no setAcessPermissions, we need to modify the object returned above.
   
   public String getDisplayName();
   public void setDisplayName(String displayName);
   
   public String getDescription();
   public void setDescription(String description);
}

