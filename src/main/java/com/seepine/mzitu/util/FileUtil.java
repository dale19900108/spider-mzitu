package com.seepine.mzitu.util;

import cn.hutool.core.img.Img;
import cn.hutool.core.img.ImgUtil;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * @author Seepine
 * @date 2020-05-19 8:44
 */
@Slf4j
@UtilityClass
public class FileUtil {
    public void createDir(final String dirPath) {
        File filePath = new File(dirPath);
        if (!filePath.exists()) {
            if (!filePath.mkdirs()) {
                log.error("mkdirs fail:" + dirPath);
            }
        }
    }

    public void createFile(final String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            if (!file.createNewFile()) {
                log.error("create new file fail:" + filePath);
            }
        }
    }

    public boolean isValidFile(final String filePath) {
        File file = new File(filePath);
        return file.exists() && file.isFile();
    }

    public boolean isValidImage(final String filePath) {
        try {
            ImgUtil.read(filePath).getAccelerationPriority();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNotValidImage(final String filePath) {
        return !isValidImage(filePath);
    }
}
