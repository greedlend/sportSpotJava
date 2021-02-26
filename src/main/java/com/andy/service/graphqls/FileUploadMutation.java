package com.andy.service.graphqls;

import graphql.kickstart.servlet.context.DefaultGraphQLServletContext;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.stereotype.Component;

import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @Author: Lim, Andy
 * @Date: 2020/11/12
 * @Proposal:
 */
@Component
public class FileUploadMutation {

    public void fileUpload(DataFetchingEnvironment e) throws IOException {

        DefaultGraphQLServletContext context = e.getContext();
        List<Part> filePartList = context.getFileParts();

        UUID id = UUID.randomUUID();

        for (Part part:filePartList) {
            //todo: stores file
            InputStream inputStream = part.getInputStream();
            String fileName = part.getSubmittedFileName();

        }
    }
}
