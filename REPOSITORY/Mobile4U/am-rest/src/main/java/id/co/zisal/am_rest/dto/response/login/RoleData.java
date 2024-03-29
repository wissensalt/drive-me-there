package id.co.zisal.am_rest.dto.response.login;

import com.google.gson.annotations.SerializedName;
import id.co.zisal.am_common.constant.ApplicationConstant;

import org.parceler.Parcel;

/**
 * Created on 10/2/2015 : 3:33 PM.
 *
 * @author <a href="fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
@Parcel
public class RoleData {

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.ID)
    private String id;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.RoleData.CODE)
    private String code;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.STATUS)
    private int status;

    @SerializedName(ApplicationConstant.Rest.DTO.Response.Login.UserData.REMARKS)
    private String remarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "RoleData{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
