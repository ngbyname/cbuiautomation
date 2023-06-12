package com.code.bull.commonutils.applicationutils.contants;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class ConstantUtils implements Cloneable {

    private static ConstantUtils constants;

    private final Properties props;

    private static final String USER_DIR = System.getProperty("user.dir");
    private static final String ENV_FILE_PATH = USER_DIR + "/src/main/resources/properties/" + "env.properties";
    private static final List<String> fileList = Arrays.asList(ENV_FILE_PATH);


    private ConstantUtils() {
        props = new Properties();
        fileList.forEach(file -> {
            Scanner inFile;
            try {
                inFile = new Scanner(new FileReader(file));
                inFile.next();
            } catch (FileNotFoundException ex) {
                ex.getMessage();
            }
            try {
                InputStream input = Files.newInputStream(Paths.get(file));
                props.load(input);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    /**
     * This method will return the value of key
     *
     * @param key the key
     * @return the value
     */
    public String getValue(String key) {

        return props.getProperty(key);
    }

    /**
     * This method will initialize the object of ConstantUtils class
     *
     * @return the object
     */
    public static ConstantUtils getInstance() {
        if (constants == null) {
            constants = new ConstantUtils();
        }
        return constants;
    }


}
