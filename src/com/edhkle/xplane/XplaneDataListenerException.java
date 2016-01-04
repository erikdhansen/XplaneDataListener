/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edhkle.xplane;

/**
 *
 * @author ehansen
 */
class XplaneDataListenerException extends Exception {

    public XplaneDataListenerException(String message) {
        super(message);
    }
    
    public XplaneDataListenerException(String message, Throwable t) {
        super(message, t);
    }
    
}
