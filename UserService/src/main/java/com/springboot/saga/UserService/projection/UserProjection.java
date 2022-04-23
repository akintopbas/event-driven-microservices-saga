package com.springboot.saga.UserService.projection;

import com.springboot.saga.CommonService.model.CardDetails;
import com.springboot.saga.CommonService.model.User;
import com.springboot.saga.CommonService.queries.GetUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserProjection {

    @QueryHandler

    public User getUserPaymentDetails(GetUserPaymentDetailsQuery query) {
        //Ideally get the details from the DB
        //Şuan statik bir data dönüyoruz.
        //Normalde gelen query'e göre db'den datayı alıp o datayı dönmeliyiz.
        CardDetails cardDetails
                = CardDetails.builder()
                .name("Akın Topbaş")
                .validUntilYear(2023)
                .validUntilMonth(11)
                .cardNumber("342423423432")
                .cvv(111)
                .build();

        return User.builder()
                .userId(query.getUserId())
                .firstName("Akın")
                .lastName("Topbaş")
                .cardDetails(cardDetails)
                .build();
    }

}
