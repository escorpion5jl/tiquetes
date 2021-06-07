package edu.gonet.vuelos.business.util;

public interface Business {
    
    public interface Constants {
    
        public interface ErrorCode {
            final static int SUCCESS = 0;
            final static int UNKNOWN_ERROR = 1;
            final static int INVALID_RECEIVED_DATA = 2;
            final static int NOT_FOUND_DATA = 3;
            final static int NOT_EXISTS_DATA = 4;
            final static int ALREADY_EXISTS_DATA = 5;
            final static int INVALID_DATETIME_RANGE = 6;
            
            final static int DB_ERROR = 1000000;
    
        }
    
    }

}