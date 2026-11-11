package org.core.homework.hw8;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Robot<H extends RobotPart<?>, B extends RobotPart<?>> {

    private String name;
    private H head;
    private B body;

    public static class Head implements RobotPart<RobotHead> {

        private final String title;
        private final RobotHead value;

        public Head(String title, RobotHead value) {
            this.title = title;
            this.value = value;
        }

        @Override
        public RobotHead getValue() {
            return value;
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

    public static class Body implements RobotPart<RobotBody> {

        private final String title;
        private final RobotBody value;

        public Body(String title, RobotBody value) {
            this.title = title;
            this.value = value;
        }

        @Override
        public RobotBody getValue() {
            return value;
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

    public Robot(String name, H head, B body) {
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
