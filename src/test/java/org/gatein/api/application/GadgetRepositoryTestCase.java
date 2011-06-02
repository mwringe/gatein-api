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

import java.net.URI;
import java.util.List;

import org.gatein.api.GateIn;
import org.gatein.api.Portal;
import org.gatein.api.application.repository.GadgetRepository;
import org.gatein.api.exceptions.AlreadyExistsException;
import org.testng.Assert;

/**
 * @author <a href="mailto:mwringe@redhat.com">Matt Wringe</a>
 * @version $Revision$
 */
public class GadgetRepositoryTestCase
{

   Portal portal = ((GateIn)null).getPortal();
   ApplicationRegistry appRegistry = portal.getApplicationRegistry();
   
   public void testGetGadget()
   {
      GadgetRepository gadgetRepo = appRegistry.getGadgetRepository();
      Gadget gadget = gadgetRepo.getGadget("gadgetA");
      
      Assert.assertNotNull(gadget);
      //TODO: add checks on the gadget object
   }
   
   public void testGetGadgets()
   {
      GadgetRepository gadgetRepo = appRegistry.getGadgetRepository();
      List<Gadget> gadgets = gadgetRepo.getGadgets();
      Assert.assertNotNull(gadgets);
      Assert.assertEquals(gadgets.size(), 5);
      //TODO: check the values of the expected gadgets
   }
   
   public void testDeleteGadget()
   {
      GadgetRepository gadgetRepo = appRegistry.getGadgetRepository();
      gadgetRepo.deleteGadget("gadgetA");
      
      Assert.assertNull(gadgetRepo.getGadget("gadgetA"));
   }
   
   public void testCreateGadget()
   {
      GadgetRepository gadgetRepo = appRegistry.getGadgetRepository();
      Gadget gadget = gadgetRepo.createGadget("gadgetB", "<?xml version=....");
      
      Assert.assertNotNull(gadget);
      Assert.assertEquals(gadget.getName(), "gadgetB");
      Assert.assertEquals(gadget.getContent(), "<?xml version=...");
      //TODO: continue on with this test
      
      try
      {
         gadgetRepo.createGadget("gadgetB", "some content goes here");
      }
      catch (AlreadyExistsException e)
      {
         //expected
      }
   }
   
   public void testAddRemoteGadget() throws Exception
   {
      GadgetRepository gadgetRepo = appRegistry.getGadgetRepository();
      URI gadgetURI = new URI("file:///path/to/a/gadget/xml.file");
      Gadget gadget = gadgetRepo.addGadget(gadgetURI);
      
      Assert.assertNotNull(gadget);
      Assert.assertEquals(gadget.getName(), "foo");
      //TODO: continue on with this test
   }
   
}

