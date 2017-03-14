/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testex.jokefetching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Emil
 */
public class FetcherFactory implements IFetcherFactory {

    private final List<String> availableTypes = Arrays.asList("EduJoke", "ChuckNorris", "Moma", "Tambal");

    @Override
    public List<String> getAvailableTypes() {
        return availableTypes;
    }

    @Override
    public List<IJokeFetcher> getJokeFetchers(String jokesToFetch) {
        List<IJokeFetcher> fetchers = new ArrayList<>();
        for (String token : jokesToFetch.split(",")) {
            switch (token.toLowerCase()) {
                case "eduprog":
                    fetchers.add(new EduJoke());
                    break;
                case "chucknorris":
                    fetchers.add(new ChuckNorris());
                    break;
                case "moma":
                    fetchers.add(new Moma());
                    break;
                case "tambal":
                    fetchers.add(new Tambal());
                    break;
            }
        }
        return fetchers;
    }
}
