package hibernate_example2;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        WorldService service = new WorldService();
        System.out.println(service.getCityById(4080));
        System.out.println(service.getCityById(1080));
        System.out.println(service.getCityById(3983));

        City city = service.getCityById(4080);
        city.setPopulation(999);
        //System.out.println(service.update(city));

        City cityKrynki = new City();
        cityKrynki.setName("Krynki");
        cityKrynki.setPopulation(200);
        cityKrynki.setCountryCode("POL");
        cityKrynki.setDistrict("Podlaskie");
        //System.out.println(service.save(cityKrynki));

        System.out.println("List of cities with 'new' in name");
        List<City> cities = service.findCitiesByName("new");
        cities.forEach(System.out::println);

        System.out.println("List of cities in Podlaskie");
        List<City> citiesPod = service.findCitiesByDistrict("Podlaskie");
        citiesPod.forEach(System.out::println);

        service.stop();
    }
}