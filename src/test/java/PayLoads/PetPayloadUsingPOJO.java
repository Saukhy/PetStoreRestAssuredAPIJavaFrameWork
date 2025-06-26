package PayLoads;

import POJO.Category;
import POJO.PetDetails;
import POJO.Photo;
import POJO.Tags;

import Utils.RandomDataGenerator;
import Utils.Status;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Builder;
import net.datafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

import static Utils.RandomDataTypeNames.PETNAME;

public class PetPayloadUsingPOJO {

@Test
    public static PetDetails createPayLoad()  {

        Faker faker = new Faker();

        Category category = new Category();
        category.setId(Integer.parseInt(RandomDataGenerator.getRandomNumber(5)));
                category.setName(RandomDataGenerator.getRandomeData(PETNAME));


                Photo photo1 = new Photo();
                photo1.setPhotoUrls(RandomDataGenerator.photoUrl());
                photo1.setPhotoUrls(RandomDataGenerator.photoUrl());

                Photo photo2 = new Photo();
                photo2.setPhotoUrls(faker.internet().image());

                List<Photo> urls = new ArrayList<>();
                urls.add(photo1);
                urls.add(photo2);

                Tags tag = new Tags();
                tag.setId(34);
                tag.setName("tag1");

                Tags tag1 = new Tags();
                tag.setId(35);
                tag.setName("tag2");


                List<Tags> tags = new ArrayList<>();
                tags.add(tag);
                tags.add(tag1);


         return PetDetails.builder()
                .id(Integer.parseInt(RandomDataGenerator.getRandomNumber(5)))
                .name("Bruno")
                .category(category)
                .Photo(urls)
                 .tag(tags)
                .status(String.valueOf(Status.available))
                .build();

}

}






