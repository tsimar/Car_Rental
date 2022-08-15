package carService.entity.CarHairService;


import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class CarReturn  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long companyId;
    private Long userId;
    private Long descriptionCarId;
    private Long employeeId;

    private Long incomeMoney;
    private Date returnDate;
    private double supplement;

    private String commentsReturn;
    private String commentsCustomer;



//@Embedded
//@AttributeOverrides(
//        {
//          @AttributeOverride(column=@Column(name="editOn"),name="updateOn")
//}
//)
//private Audit audit=new Audit();




CarReturn(){

}



    public Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getDescriptionCarId() {
        return descriptionCarId;
    }

    public void setDescriptionCarId(Long descriptionCarId) {
        this.descriptionCarId = descriptionCarId;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getCommentsReturn() {
        return commentsReturn;
    }

    public void setCommentsReturn(String commentsReturn) {
        this.commentsReturn = commentsReturn;
    }

    public String getCommentsCustomer() {
        return commentsCustomer;
    }

    public void setCommentsCustomer(String commentsCustomer) {
        this.commentsCustomer = commentsCustomer;
    }

    public double getSupplement() {
        return supplement;
    }

    public void setSupplement(double supplement) {
        this.supplement = supplement;
    }


//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "carReturn", orphanRemoval = true)
//    private List<Reservation> reservations;

    //    @ManyToOne
//    @JoinColumn(name = "income_money_id")
//    private IncomeMoney incomeMoney;
    public void updateFrom(final CarReturn carReturn) {
        employeeId = carReturn.employeeId;

        userId = carReturn.userId;
        companyId = carReturn.companyId;
        descriptionCarId = carReturn.descriptionCarId;
        returnDate = carReturn.returnDate;
        commentsReturn = carReturn.commentsReturn;
        commentsCustomer = carReturn.commentsCustomer;

    }



}
