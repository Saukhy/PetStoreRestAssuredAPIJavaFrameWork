package PayLoads;

import POJO.Category;
import POJO.PetDetails;
import POJO.Photo;
import POJO.Tags;
import Utils.Status;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;


import java.util.ArrayList;
import java.util.List;

public class PetPayloadUsingPOJO {
    //Below uses Pojo and JackSonX
    public static PetDetails createPayLoad() throws JsonProcessingException {
        PetDetails.builder()
                .id(10)
                .name("Bruno")
                .category(1,"fdg")
                .category("sad")
                .Photo("https://www.pexels.com/photo/two-yellow-labrador-retriever-puppies-1108099","https://www.pexels.com/photo/two-yellow-labrador-retriever-puppies-1108099/")
                .tag(9101,"Tag")
                .status(Status.available)
                .build();



   //     PetDetails nestedPOJO = new PetDetails();


//
//        nestedPOJO.setId(1);
//
//        Category category = new Category();
//        category.setId(10);
//        category.setName("LoyalDogs");
//
//        nestedPOJO.setName("test");
//        nestedPOJO.setCategory(category);
//
//
//
//        Photo photo = new Photo();
//        photo.setPhotoUrls("https://www.pexels.com/photo/two-yellow-labrador-retriever-puppies-1108099/");
//        Photo photo2 = new Photo();
//        photo.setPhotoUrls("https://www.pexels.com/photo/two-yellow-labrador-retriever-puppies-1108099/");
//
//        List<Photo> allphotoUrls = new ArrayList<>();
//        allphotoUrls.add(photo);
//        allphotoUrls.add(photo2);
//        nestedPOJO.setPhoto(allphotoUrls);
//
//        Tags tag = new Tags();
//        tag.setId(9101);
//        tag.setName("testTagName");
//
//
//        Tags tag2 = new Tags();
//        tag2.setId(9102);
//        tag2.setName("testTagName2");
//
//        List<Tags> allTags = new ArrayList<>();
//        allTags.add(tag);
//        allTags.add(tag2) ;
//
//        nestedPOJO.setTag(allTags);
//
//
//        nestedPOJO.setStatus(String.valueOf(Status.available));
//
//        return  PetDetails;
//
//        ObjectMapper objectmapper = new ObjectMapper();
//
//        String payload = objectmapper.writerWithDefaultPrettyPrinter().writeValueAsString(nestedPOJO);
//
//        System.out.println(payload);












    }
}
