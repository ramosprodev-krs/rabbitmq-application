package krs.rabbitmq_application.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MessageDTO {
    // Creating the necessary attributes
    private String text;
    private String author;

    // Overriding "toString()" method for better displaying
    @Override
    public String toString() {
        return "Message{text=" + text + " , author=" + author + "}";
    }
}
