package se.joshua.endpoint.party.model;

import com.so4it.common.util.object.Required;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

/**
 * @author Ali Yusha {@literal <mailto:Ali.yusha@so4it.com/>}
 */


@ApiModel("Player Model")
public class PlayerModel {


    @ApiModelProperty(value = "First name", required = true)
    @NotNull
    @NotEmpty
    private String firstName;

    @ApiModelProperty(value = "Last name", required = true)
    @NotNull
    @NotEmpty
    private String lastName;

    @ApiModelProperty(value = "start date", required = true)
    @NotNull
    @NotEmpty
    private LocalDate startDate;

    @ApiModelProperty(value = "End date", required = true)
    @NotNull
    @NotEmpty
    private LocalDate endDate;

    @ApiModelProperty(value = "Email", required = true)
    @NotNull
    @NotEmpty
    private String email;

    @NotNull
    @NotEmpty
    @ApiModelProperty(value = "User name", required = true)
    private String userName;


    public PlayerModel(Builder builder) {
        this.firstName = Required.notNull(builder.firstName, "firstName");
        this.lastName = Required.notNull(builder.lastName, "lastName");
        this.startDate = Required.notNull(builder.startDate, "startDate");
        this.endDate = Required.notNull(builder.endDate, "endDate");
        this.email = Required.notNull(builder.email, "email");
        this.userName = Required.notNull(builder.userName, "userName");
        //this.attributes = Required.notNull(builder.attributes, "attributes");
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getEmail() {
        return email;
    }

    public String getUserName() {
        return userName;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private String firstName;
        private String lastName;

        private LocalDate startDate;
        private LocalDate endDate;
        private String email;
        private String userName;


        public Builder withFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder withLastName(String lastName) {

            this.lastName = lastName;
            return this;
        }

        public Builder withStartDate(LocalDate startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder withEndDate(LocalDate endDate) {

            this.endDate = endDate;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder withUserName(String userName) {
            this.userName = userName;
            return this;
        }

        public PlayerModel build() {
            return new PlayerModel(this);
        }

    }
}