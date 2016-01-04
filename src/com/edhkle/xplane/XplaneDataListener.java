/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edhkle.xplane;

import java.io.File;

/**
 *
 * @author ehansen
 */
public class XplaneDataListener {
    String dataSource;
    boolean network = false;
    
    int udpPort;
    File dataFile;
    
    XplaneDataHandler handler;
    
    public XplaneDataListener(String dataSource) throws XplaneDataListenerException {
        this.dataSource = dataSource;
        isValidDataSource();
        XplaneDataIterator iterator;
        if(network == true) {
            iterator = new XplaneNetworkDataIteraror(udpPort);
        } else {
            iterator = new XplaneFileDataIterator(dataFile);
        }
        handler = new XplaneDataHandler(iterator);
    }
    
    private void isValidDataSource() throws XplaneDataListenerException {
        try {
            udpPort = Integer.parseInt(dataSource);
            if(udpPort > 1024 && udpPort <= 65535) {
                network = true;
            } else {
                throw new XplaneDataListenerException("Invalid UDP port number: " + udpPort + ".  Must be 1024 > udp_port <= 65535");
            }
        } catch (NumberFormatException e) {
            // Could be a filename?
            dataFile = new File(dataSource);
            if(!dataFile.exists() || !dataFile.canRead()) {
                throw new XplaneDataListenerException("Invalid data file.  File: " + dataSource + " either does not exist or is not readable");
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        if(args.length < 1) {
            System.out.println("usage: XplaneDataListener { source file | udp_port }");
        }

        XplaneDataListener listener = new XplaneDataListener(args[0]);
        
    }
    
}
