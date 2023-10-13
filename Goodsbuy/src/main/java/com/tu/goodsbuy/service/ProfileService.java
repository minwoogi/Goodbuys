package com.tu.goodsbuy.service;


import com.tu.goodsbuy.global.exception.file.FileTransferException;
import com.tu.goodsbuy.global.exception.file.NotImageFileException;
import com.tu.goodsbuy.global.exception.profile.*;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
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
        String saveName = imagePath + "/" + folderPath + "/" + uuid + "_" + fileName;
        //ex) profileImage.2023.09.18.uuid_filename
        Path savePath = Paths.get(saveName);
        try {
            file.transferTo(savePath);
        } catch (IOException e) {
            throw new FileTransferException();
        }
        log.info("Saved Photos ==> " + folderPath + File.separator + uuid + "_" + fileName);

        String srcPath = folderPath.replace(File.separator, "/");

        return srcPath + "/" + uuid + "_" + fileName;
    }

    public void deleteImage(String imagePath, String imageUrl) {

        try {
            if (Objects.nonNull(imageUrl)) {
                String filePath = imagePath + "/" + imageUrl.replace("/", File.separator);
                Path deletePath = Paths.get(filePath);
                Files.deleteIfExists(deletePath);
                log.info("Deleted Image ==> " + deletePath);
            }
        } catch (IOException e) {
            log.error("Failed to delete image: " + e);
        }

    }


    @Transactional
    public void setEmailVerificationStatus(Long userNo) {
        if (profileRepository.setEmailVerificationStatus(userNo) == 0) {
            throw new EmailStatusUpdateException();
        }
    }

    @Transactional
    public void setEmailProfileByUserNo(String email, Long userNo) {
        if (profileRepository.setEmailProfileByUserNo(email, userNo) == 0) {
            throw new EmailStatusUpdateException();
        }
    }

    @Transactional
    public void setLocationByUserNo(String location, Long userNo) {
        if (profileRepository.setLocationByUserNo(location, userNo) == 0) {
            throw new LocationUpdateException();
        }
    }

    @Transactional
    public void setIntroductionByUserNo(String introduction, Long userNo) {
        if (profileRepository.setIntroductionByUserNo(introduction, userNo) == 0) {
            throw new IntroductionUpdateException();
        }
    }

    @Transactional
    public void setImgUrlByUserNo(String imgURL, Long userNo) { // chat_room imageUrl도 업데이트


        if (profileRepository.setImgUrlByUserNo(imgURL, userNo) == 0) {
        }
    }


    @Transactional(readOnly = true)
    public String getNicknameByUserNo(Long userNo) {
        return profileRepository.getNicknameByUserNo(userNo);
    }
}

