package com.jpa.study.starbucks.jpastudy2.main;

import com.jpa.study.starbucks.jpastudy2.User2;
import com.jpa.study.starbucks.jpastudy2.app.*;
import com.jpa.study.starbucks.jpastudy2.jpa.EMF;
import jakarta.persistence.EntityExistsException;
import lombok.extern.log4j.Log4j2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;

@Log4j2
public class Main {

    private static NewUserService newUserService = new NewUserService();
    private static GetUserService getUserService = new GetUserService();
    private static ChangeNameService changeNameService = new ChangeNameService();
    private static RemoveUserService removeUserService = new RemoveUserService();

    public static void main(String[] args) throws IOException {
        /**
         * 초기화
         */
        EMF.init();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            while (true) {
                System.out.println("명령어를 입력하세요:");
                String line = reader.readLine();
                if (line == null) break;
                if (line.startsWith("new ")) {
                    handleNew(line);
                } else if (line.startsWith("get ")) {
                    handleGet(line);
                } else if (line.startsWith("change name ")) {
                    handleChangeName(line);
                } else if (line.startsWith("remove ")) {
                    handleRemove(line);
                } else if (line.equals("exit")) {
                    break;
                }
            }
        } finally {
            /**
             * 종료
             */
            EMF.close();
        }
    }

    private static void handleNew(String line) {
        String[] v = line.substring(4).split(" ");
        User2 u = new User2(v[0], v[1], LocalDateTime.now());
        try {
            newUserService.saveNewUser(u);
            log.info("새 사용자 저장: {}", u);
        } catch (EntityExistsException e) {
            log.info("사용자가 이미 존재함: {}", u.getEmail());
        }
    }

    private static void handleGet(String line) {
        String email = line.substring(4);
        try {
            User2 user = getUserService.getUser(email);
            log.info("사용자 정보: {}", user);
        } catch (NoUserException e) {
            log.info("사용자가 존재하지 않음: {}", email);
        }
    }

    private static void handleChangeName(String line) {
        String[] v = line.substring(12).split(" ");
        String email = v[0];
        String newName = v[1];
        try {
            changeNameService.changeName(email, newName);
            log.info("사용자 이름 변경: {}, {}", email, newName);
        } catch (NoUserException e) {
            log.info("사용자가 존재하지 않음: {}", email);
        }
    }

    private static void handleRemove(String line) {
        String email = line.substring(7);
        try {
            removeUserService.removeUser(email);
            log.info("사용자 삭제함: {}", email);
        } catch (NoUserException e) {
            log.info("사용자가 존재하지 않음: {}", email);
        }
    }

}
