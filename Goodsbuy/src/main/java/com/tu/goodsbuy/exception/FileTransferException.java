package com.tu.goodsbuy.exception;

public class FileTransferException extends RuntimeException{
    public FileTransferException() {
        super("사진 파일 저장에 실패하였습니다.");
    }
}
