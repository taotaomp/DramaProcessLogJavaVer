package Logger;

import Const.ConstValues;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerRun implements ConstValues {
    private Logger logger;

    public Logger getLogger() {
        return logger;
    }

    /**
     * 创建LoggerRun唯一实例
     * @return 此类对象
     */
    public static LoggerRun getInstance() {
        PropertyConfigurator.configure(ConstValues.LOGGER_PATH);
        LoggerRun loggerRun = new LoggerRun();
        loggerRun.logger = Logger.getLogger(LoggerRun.class);
        return loggerRun;
    }

}
