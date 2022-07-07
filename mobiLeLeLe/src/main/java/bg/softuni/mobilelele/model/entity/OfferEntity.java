package bg.softuni.mobilelele.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;
    @Column(name = "engine",nullable = false)
    private EngineName engine;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "mileage")
    private Integer mileage;
    @Column(name = "price",nullable = false)
    private BigDecimal price;
    @Column(name = "transmission",nullable = false)
    private TransmissionName transmission;
    @Column(name = "year",nullable = false)
    private Integer year;
    @Column(name = "created",nullable = false)
    private LocalDateTime created;
    @Column(name = "modified",nullable = false)
    private LocalDateTime modified;
    @OneToOne
    private ModelEntity model;
    @ManyToOne
    private UserEntity seller;

    public OfferEntity() {
    }

    public UserEntity getSeller() {
        return seller;
    }

    public void setSeller(UserEntity seller) {
        this.seller = seller;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineName getEngine() {
        return engine;
    }

    public void setEngine(EngineName engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getMileage() {
        return mileage;
    }

    public void setMileage(Integer mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionName getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionName transmission) {
        this.transmission = transmission;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }
}
