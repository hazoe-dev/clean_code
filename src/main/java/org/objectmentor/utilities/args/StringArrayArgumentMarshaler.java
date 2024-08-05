package org.objectmentor.utilities.args;

import java.util.Iterator;

public class StringArrayArgumentMarshaler implements ArgumentMarshaler {

    public void set(Iterator<String> currentArgument) throws ArgsException {
    }

    public static String[] getValue(ArgumentMarshaler argumentMarshaller) {
        return new String[0];
    }
}