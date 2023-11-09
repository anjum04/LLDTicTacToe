package ChainOfResponsibility;

public class Main {
	
	 private static Logger doChaining(){ 
         Logger consoleLogger = new ConsoleBasedLogger(Logger.OUTPUTINFO);  
           
         Logger errorLogger = new ErrorBasedLogger(Logger.ERRORINFO);  
         consoleLogger.setNextLevelLogger(errorLogger);  
           
         Logger debugLogger = new DebugBasedLogger(Logger.DEBUGINFO);  
         errorLogger.setNextLevelLogger(debugLogger);  
           
         return consoleLogger;   
         }  
	 
    public static void main(String args[]){  
         Logger chainLogger= doChaining();  //consoleLogger
         chainLogger.logMessage(Logger.ERRORINFO, "An error is occured now");  
         chainLogger.logMessage(Logger.DEBUGINFO, "This was the error now debugging is compeled");  
            
    }  

}
