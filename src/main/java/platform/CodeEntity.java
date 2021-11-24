package platform;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "CODE")
public class CodeEntity {

    @Id
    @JsonIgnore
    UUID uuid = UUID.randomUUID();

    String code;

    String date;

    @JsonIgnore
    boolean restricted = false;

    int time = 0;

    int views = 0;

    public CodeEntity(String code) {
        this.code = code;
        this.date = LocalDateTime.now().toString();
    }

    public CodeEntity(String code, int time, int views) {
        this.code = code;
        this.date = LocalDateTime.now().toString();
        if (time != 0 || views != 0){
            this.time = time;
            this.views = views;
            this.restricted = true;
        }
    }

    public CodeEntity() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isRestricted() {
        return restricted;
    }

    public void setRestricted(boolean restricted) {
        this.restricted = restricted;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CodeEntity{");
        sb.append("uuid=").append(uuid);
        sb.append(", code='").append(code).append('\'');
        sb.append(", date='").append(date).append('\'');
        sb.append(", restricted=").append(restricted);
        sb.append(", time=").append(time);
        sb.append(", views=").append(views);
        sb.append('}');
        return sb.toString();
    }
}
