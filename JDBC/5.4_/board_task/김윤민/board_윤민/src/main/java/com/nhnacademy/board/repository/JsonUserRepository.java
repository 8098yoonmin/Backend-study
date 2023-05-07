package com.nhnacademy.board.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.nhnacademy.board.domain.User;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JsonUserRepository implements UserRepository {
    private final ObjectMapper objectMapper;
    private static final String JSON_FILE_PATH="/Users/yoonmin/Desktop/java_backend/backend-study/Spring MVC/4.20/board/src/main/java/com/nhnacademy/json/user.json";

    public JsonUserRepository(){
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        File file =new File(JSON_FILE_PATH);
        if(file.exists()){
            file.delete();
        }

    }

    private synchronized List<User> readJsonFile(){
        List<User> users;
        File file =new File(JSON_FILE_PATH);

        if(!file.exists()){
            return new ArrayList<>();
        }

        try(FileInputStream fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ) {
            users = objectMapper.readValue(bufferedReader, new TypeReference<List<User>>() {});
            return  users;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private synchronized void writeJsonFile(List<User> userList){

        File file = new File(JSON_FILE_PATH);

        try(
                FileWriter fileWriter = new FileWriter(file);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        ) {
            objectMapper.writeValue(bufferedWriter,userList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(User user) {
        List<User> users = readJsonFile();
        users.add(user);
        writeJsonFile(users);
    }

    @Override
    public void update(User user) {
        List<User> users = readJsonFile();
        Optional<User> target = users.stream()
                .filter(o-> o.getUserId().equals(user.getUserId()))
                .findFirst();

        if(target.isPresent()){
            target.get().update(user.getUserId(),user.getUserName(),user.getProfileName(),user.getUserPassword());
            writeJsonFile(users);
        }
    }

    @Override
    public void deleteById(String id) {
        List<User> users = readJsonFile();
        boolean isDeleted = users.removeIf(o->o.getUserId().equals(id));
        if(isDeleted){
            writeJsonFile(users);
        }
    }

    @Override
    public User getUserById(String id) {
        List<User> users = readJsonFile();
        Optional<User> user = users.stream().filter(o->o.getUserId().equals(id)).findFirst();
        if(user.isPresent()){
            return user.get();
        }
        return null;
    }

    @Override
    public List<User> getUsers() {
        return readJsonFile();
    }

    @Override
    public boolean existById(String id) {
        List<User> users = readJsonFile();
        long count = users.stream()
                .filter(o->o.getUserId().equals(id))
                .count();

        return  count > 0  ? true : false;
    }
}
