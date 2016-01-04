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
public class XplaneFileDataIterator implements XplaneDataIterator {
    File dataFile;
    public XplaneFileDataIterator(File dataFile) {
        this.dataFile = dataFile;
    }
    
    @Override
    public boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public XplaneData next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
