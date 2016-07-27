package test.java.webTest.webdriver.utils;

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
}
