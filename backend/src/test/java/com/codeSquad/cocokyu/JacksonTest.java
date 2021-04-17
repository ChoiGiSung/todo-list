package com.codeSquad.cocokyu;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

public class JacksonTest {

    @Test
    void jacksonTest() throws JsonProcessingException {
        String json = "{\"id\":1,\"name\":\"John\"}";
        ObjectMapper mapper = new ObjectMapper();

        User o = mapper.reader().forType(User.class).readValue(json);

        System.out.println(o.toString());
    }

    public static class User {
        private int id;
        private String name;

        public User() {
            this.id = 3;
            this.name = "박남춘";
        }

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }
    }
}
