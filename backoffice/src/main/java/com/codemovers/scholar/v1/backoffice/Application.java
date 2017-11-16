/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.codemovers.scholar.v1.backoffice;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 *
 * @author Mover 11/16/2017
 */
public class Application {

    private static final Logger LOG = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {

    }

    public void init() {
        LOG.log(Level.INFO, "Starting Application ");
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

    }

}
