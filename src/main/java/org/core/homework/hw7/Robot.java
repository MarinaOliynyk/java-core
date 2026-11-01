package org.core.homework.hw7;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robot {

    private String name;
    private Robot.Head head;
    private Robot.Body body;

    public static class Head {

        private final String title;

        public Head(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Head{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }

    public static class Body {

        private final String title;

        public Body(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Body{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }

    public Robot(String name, Head head, Body body) {
        this.name = name;
        this.head = head;
        this.body = body;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "name='" + name + '\'' +
                ", head=" + head.getTitle() +
                ", body=" + body.getTitle() +
                '}';
    }
}
