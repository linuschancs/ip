package main.java;

public class Task {
        protected String description;
        protected boolean isDone;

        public Task(String description) {
            this.description = description;
            this.isDone = false;
        }

        public String getStatusIcon() {
            return (isDone ? "X" : " "); // mark done task with X
        }

        public String getTaskDescription() {
            return this.description;
        }

        public void markAsDone() {
            this.isDone = true;
            System.out.println("Nice! I've marked this task as done:");
            System.out.println("[X] " + this.description +"\n");
        }

        public void markAsNotDone() {
            this.isDone = false;
            System.out.println("Nice! I've marked this task as not done yet:");
            System.out.println("[ ] " + this.description +"\n");
        }
}