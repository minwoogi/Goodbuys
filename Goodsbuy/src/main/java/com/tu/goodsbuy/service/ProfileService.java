package com.tu.goodsbuy.service;


import com.tu.goodsbuy.global.exception.*;
import com.tu.goodsbuy.model.dto.MemberProfile;
import com.tu.goodsbuy.repository.ProfileRepository;
import com.tu.goodsbuy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class ProfileService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;


    @Transactional
    public void makeMemberProfile(String userId, String nickname) {
        if (profileRepository.makeMemberProfile(userRepository.findUserNoById(userId), nickname) == 0) {
            throw new MakeMemberProfileException();
        }
    }


    @Transactional(readOnly = true)
    public MemberProfile getMemberProfileByUserNo(Long userNo) {
        return profileRepository.getMemberProfileByUserNo(userNo).orElseThrow(GetProfileException::new);
    }

    @Transactional
    public void updateNickname(Long userNo, String nickname) {
        if (profileRepository.updateNickname(userNo, nickname) == 0) {
            throw new NicknameDuplicateException();
        }
    }

    @Transactional
    public void updateProfile(Long userNo) {

    }


    public String makeFolder(String imagePath) {
        String date = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String folderPath = date.replace("/", File.separator);


        File uploadPathFolder = new File(imagePath, folderPath);


        if (!uploadPathFolder.exists()) {
            uploadPathFolder.mkdirs();
        } else {
            log.info("already [" + folderPath + "] folder exists");
        }
        return folderPath;
    }

    public String uploadSaveImageAndGetIdentifier(String imagePath, MultipartFile file) {

        if (!file.getContentType().startsWith("image")) {
            log.warn("this file is not image type");
            throw new NotImageFileException();
        }

        String fileName = file.getOriginalFilename()
                .substring(file.getOriginalFilename().lastIndexOf("//") + 1);


        String folderPath = makeFolder(imagePath);

        String uuid = UUID.randomUUID().toString();
        String saveName = imagePath + File.separator + folderPath + File.separator + uuid + "_" + fileName;
        //ex) profileImage.2023.09.18.uuid_filename
        Path savePath = Paths.get(saveName);
        try {
            file.transferTo(savePath);
        } catch (IOException e) {
            throw new FileTransferException();
        }
        log.info("Saved Photos ==> " + folderPath + File.separator + uuid + "_" + fileName);

        return folderPath + uuid + "_" + fileName;
    }

    public void setEmailVerificationStatus(Long userNo) {
        if (profileRepository.setEmailVerificationStatus(userNo) == 0) {
            throw new EmailStatusUpdateException();
        }
    }

    public void setEmailProfileByUserNo(String email, Long userNo) {
        if (profileRepository.setEmailProfileByUserNo(email, userNo) == 0) {
            throw new EmailStatusUpdateException();
        }
    }
}

