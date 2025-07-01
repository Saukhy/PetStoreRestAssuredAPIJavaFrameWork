package POJO;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import javax.swing.*;
@Builder
@Data

@NoArgsConstructor  // ✅ Required for Jackson
@AllArgsConstructor
public class UserDetails {

    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String phone;
//    private String userStatus;
}
