package io.github.yellldo.core.exception.base;

import io.github.yellldo.core.exception.BaseException;
import io.github.yellldo.core.exception.IErrorCode;

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
