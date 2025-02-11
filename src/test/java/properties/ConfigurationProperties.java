package properties;

import org.aeonbits.owner.Config;

@Config.Sources("file:src/test/resources/application.properties")
public interface ConfigurationProperties extends Config {
    @Config.Key("telephone")
    String telephone();

    @Config.Key("url")
    String url();

    @Config.Key("name")
    String name();

    @Config.Key("address")
    String address();


}