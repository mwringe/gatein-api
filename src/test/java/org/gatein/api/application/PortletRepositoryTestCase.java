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

import org.gatein.api.GateIn;
import org.gatein.api.Iterator;
import org.gatein.api.Portal;
import org.gatein.api.Query;
import org.gatein.api.application.repository.PortletRepository;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public class PortletRepositoryTestCase
{

   Portal portal = ((GateIn)null).getPortal();
   ApplicationRegistry appRegistry = portal.getApplicationRegistry();
   
   public void testGetPortlet()
   {
      PortletRepository portletRepo = appRegistry.getApplicationRepository().getPortletRepository();
      
      Portlet.ID portletID = Portlet.ID.generateID("applicationName", "portletName");
      Portlet portlet = portletRepo.getPortlet(portletID);
      //TODO: actual test
   }
   
   public void testGetPortletsPerApplication()
   {
      PortletRepository portletRepo = appRegistry.getApplicationRepository().getPortletRepository();
      Iterator portlets = portletRepo.getPortlets("applicationName");
      //TODO: actual test
   }
   
   public void testGetPortlets()
   {
      PortletRepository portletRepo = appRegistry.getApplicationRepository().getPortletRepository();
      Iterator portlets = portletRepo.getPortlets(Query.ALL);
      //TODO: actual test
   }
   
}

