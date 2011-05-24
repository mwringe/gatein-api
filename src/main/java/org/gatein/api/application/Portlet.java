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

import org.gatein.api.permissions.AccessPermissions;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public interface Portlet extends Application
{
   public String getPortletName();
   public String getApplicationName();
   
   public String getDescription();
   public Void setDescription(String description);
   
   public AccessPermissions getAccessPermissions();
   //NOTE: no setAccessPermission since we will directly manipulate the object returned above
   
   public String getPortletPreference(String name);
   public void setPortletPreference(String name, String value);
   
   //TODO: determine if we should have getters/setters for things like
   // portlet title, height, show info bar, ...
   // Or if we should have a more generic get/set Property method?
   //public String getPortletTitle();
   //public void setPortletTitle();
   // OR
   //public void setProperty(String propertyName, Object value);
   //public object getProperty(String propertyName);
   /**
    * Need to handle:
    * - portletTitle
    * - width
    * - height
    * - show info bar
    * - show portlet mode
    * - show window state
    * - decoration
    * - icon
    */
   
   
}

