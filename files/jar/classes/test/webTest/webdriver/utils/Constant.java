package test.webTest.webdriver.utils;

import java.nio.file.FileSystems;

/**
 * Created by Arthur on 24/07/2016.
 */
public class Constant {

    public static final String GECKONAME = "appium.gecko.driver";

    public static String getPathDriver(){

        final String separator = FileSystems.getDefault().getSeparator();

        StringBuilder builder = new StringBuilder();
        builder.append("files");
        builder.append(separator);
        builder.append("driver");
        builder.append(separator);
        builder.append("geckodriver.exe");
        return builder.toString();
    }

    public static String getPathFeature(){

        final String separator = FileSystems.getDefault().getSeparator();

        StringBuilder builder = new StringBuilder();
        builder.append("target");
        builder.append(separator);
        builder.append("classes");
        builder.append(separator);
        builder.append("test");
        builder.append(separator);
        builder.append("webTest");
        builder.append(separator);
        builder.append("cucumber");
        builder.append(separator);
        builder.append("features");
        return builder.toString();
    }
}
