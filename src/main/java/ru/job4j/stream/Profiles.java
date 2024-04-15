package ru.job4j.stream;

import java.util.List;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(profile -> new Address(
                        profile.address().getCity(),
                        profile.address().getStreet(),
                        profile.address().getHome(),
                        profile.address().getApartment())
                )
                .toList();
    }
}
