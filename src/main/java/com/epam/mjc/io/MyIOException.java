package com.epam.mjc.io;

import java.io.IOException;

public class MyIOException extends RuntimeException {
    public MyIOException() {
        super("IOException");
    }
}
