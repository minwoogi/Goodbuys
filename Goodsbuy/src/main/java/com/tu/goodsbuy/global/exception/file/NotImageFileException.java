package com.tu.goodsbuy.global.exception.file;

public class NotImageFileException extends  RuntimeException{

    public NotImageFileException() {
        super("이미지 파일만 업로드 가능합니다.");
    }
}
