package com.sparkle.core.exception.base;

import com.sparkle.core.exception.BaseException;
import com.sparkle.core.exception.IErrorCode;

/**
 * ClassName : FileDownloadException<br>
 * Description : 文件下载异常<br>
 *
 * @author : sj
 * @version : 1.0.0
 * @date : 2021/4/22
 */
public class FileDownloadException extends BaseException {


    public FileDownloadException(IErrorCode iErrorCode) {
        super(iErrorCode);
    }


    public FileDownloadException(String message) {
        super(message);
    }
}
