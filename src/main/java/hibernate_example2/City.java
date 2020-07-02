package hibernate_example2;

import javax.persistence.*;

@NamedQueries({
        @NamedQuery(
                name = "citiesByName",
                query = "SELECT c FROM city c WHERE c.name like :name"),
        @NamedQuery(
                name = "findCityInDistrict",
                query = "SELECT c FROM city c WHERE c.district = :dis"),
})
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "findCityInDistrictNative",
                query = "SELECT ID, Name, CountryCode, District, Population FROM city WHERE city.district =  ?",
                resultClass = City.class
        )
})
@Entity(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "Name", length = 35)
    private String name;

    @Column(name = "CountryCode", length = 3)
    private String countryCode;

    @Column(name = "District", length = 20)
    private String district;

    @Column(name = "Population")
    private int population;

    public City() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }
}