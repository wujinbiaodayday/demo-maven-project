package com.ddc.common.demo.service.config.log;

import com.ctrip.framework.apollo.Config;
import com.ctrip.framework.apollo.ConfigChangeListener;
import com.ctrip.framework.apollo.ConfigService;
import com.ctrip.framework.apollo.model.ConfigChangeEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.plugins.Plugin;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URI;

@Plugin(name = "ApolloXmlLog4j2ConfigurationFactory", category = ConfigurationFactory.CATEGORY)
@Order(50)
public class ApolloXmlLog4j2ConfigurationFactory extends ConfigurationFactory {

    /**
     * Log4j2的NameSpace名称
     */
    private static final String LOG4J2_NAMESPACE = "TEST1.demo-dubbo-logConfig";
    private static final String LOG_CONFIG = "logConfig";

    @Override
    protected String[] getSupportedTypes() {
        return new String[]{"*"};
    }

    private boolean isInit = false;
    private Config config;

    public ApolloXmlLog4j2ConfigurationFactory () {
        config = ConfigService.getConfig(LOG4J2_NAMESPACE);
        config.addChangeListener(new ConfigChangeListener() {
            public void onChange(ConfigChangeEvent changeEvent) {
                if (isInit) {
                    LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
                    //Configuration newConfig = doGetConfiguration(ctx);
                    //ctx.updateLoggers(newConfig);
                    ctx.reconfigure();
                }
            }
        });
    }

    @Override
    public Configuration getConfiguration(LoggerContext loggerContext, ConfigurationSource source) {
        return getConfiguration(loggerContext, source.toString(), null);
    }

    @Override
    public Configuration getConfiguration(LoggerContext loggerContext, String name, URI configLocation) {
        String xmlConfig = config.getProperty(LOG_CONFIG, "");
        InputStream stream = null;
        try {
            stream = new ByteArrayInputStream(xmlConfig.getBytes());
            ConfigurationSource source = new ConfigurationSource(stream);
            Configuration configuration = new ApolloXmlConfiguration(loggerContext, source);
            isInit = true;
            return configuration;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (null != stream) {
                    stream.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
