package com.udacity.gradle.builditbigger.backend;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.project.udacity.jokeprovider.JokeProvider;

@Api(
        name = "myApi",
        version = "v1",
        namespace = @ApiNamespace(
                ownerDomain = "backend.builditbigger.gradle.udacity.com",
                ownerName = "backend.builditbigger.gradle.udacity.com",
                packagePath = ""
        )
)

public class MyEndpoint
{
    @ApiMethod(name = "getJoke")
    public MyBean getJoke()
    {
        try
        {
            Thread.sleep(5 * 1000);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        MyBean response = new MyBean();
        response.setData(new JokeProvider().jokeProvide());
        return response;
    }
}
