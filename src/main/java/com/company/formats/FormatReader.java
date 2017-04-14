package com.company.formats;

import com.company.test_model.Test;

/**
 * Created by nazymko.patronus@gmail.com
 */
public interface FormatReader {

    Test read(String content, String fileName);
}
