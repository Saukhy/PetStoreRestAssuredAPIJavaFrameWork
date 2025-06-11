package POJO;

import lombok.*;

import java.util.List;


@Builder
@Data


public  class PetDetails {

        private int id;
        private Category category;
        private String name;
        private List<Photo> Photo;
        private List<Tags> tag;
        private String status;

}
