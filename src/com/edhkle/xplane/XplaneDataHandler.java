/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edhkle.xplane;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

/**
 *
 * @author ehansen
 */
public class XplaneDataHandler implements Runnable {
    final static Logger log = Logger.getLogger(XplaneDataHandler.class.getName());
    
    // Make consumers public so that consumer list can be modified while the 
    // Data handler is in it's infinte run loop...maybe use a static util 
    // class for this?
    public List<XplaneDataConsumer> consumers = new LinkedList<>();
    public boolean done = false;
    XplaneDataIterator iterator;
    
    public XplaneDataHandler(XplaneDataIterator iterator) {
        this.iterator = iterator;
    }

    public void register(XplaneDataConsumer consumer) {
        consumers.add(consumer);
    }
    

    public void deregister(XplaneDataConsumer consumer) {
        consumers.remove(consumer);
    }
    
    @Override
    public void run() {
        while(!done) {
            log.info("Entering XplaneDataHandler run loop...");
            int count = 0;
            while(iterator.hasNext()) {
                XplaneData data = iterator.next();
                for(XplaneDataConsumer consumer : consumers) {
                    count++;
                    XplaneDataHandler.dump(data);
                    consumer.consume(data);
                }
            }
            log.info("Exiting XplaneDataHandler run loop -- processed " + count + " data events");
        }
    }
    
    public static void dump(XplaneData data) {
        log.info(data.toString());
    }
}
