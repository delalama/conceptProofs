package com.dll.interfaceAndSuperclass;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Home {
    private List<Space> spaces = new ArrayList<>();

    public List<Space> getSpaces() {
        return spaces;
    }

    public void addSpace(Space space) {
        this.spaces.add(space);
    }

    public void addSpace(Space... spaces) {
        Stream.of(spaces).forEach(s -> this.spaces.add(s));
    }

    public String getHouseSpacesDescription() {
        return "Descripción de la casa: " + spaces
                .stream()
                .map(Space::getDescription)
                .collect(Collectors.joining("\n- ", "\n- ", ""));
    }

}
