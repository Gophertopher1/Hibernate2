package CIT360project;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "iproject", schema = "project", catalog = "")
public class IprojectEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "project_code")
    private String projectCode;
    @Basic
    @Column(name = "project_name")
    private String projectName;
    @Basic
    @Column(name = "due_dates")
    private Date dueDates;
    @Basic
    @Column(name = "points")
    private String points;
    @Basic
    @Column(name = "isCompleted")
    private String isCompleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getDueDates() {
        return dueDates;
    }

    public void setDueDates(Date dueDates) {
        this.dueDates = dueDates;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IprojectEntity that = (IprojectEntity) o;

        if (id != that.id) return false;
        if (projectCode != null ? !projectCode.equals(that.projectCode) : that.projectCode != null) return false;
        if (projectName != null ? !projectName.equals(that.projectName) : that.projectName != null) return false;
        if (dueDates != null ? !dueDates.equals(that.dueDates) : that.dueDates != null) return false;
        if (points != null ? !points.equals(that.points) : that.points != null) return false;
        if (isCompleted != null ? !isCompleted.equals(that.isCompleted) : that.isCompleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (projectCode != null ? projectCode.hashCode() : 0);
        result = 31 * result + (projectName != null ? projectName.hashCode() : 0);
        result = 31 * result + (dueDates != null ? dueDates.hashCode() : 0);
        result = 31 * result + (points != null ? points.hashCode() : 0);
        result = 31 * result + (isCompleted != null ? isCompleted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "IprojectEntity{" +
                "id=" + id +
                ", projectCode='" + projectCode + '\'' +
                ", projectName='" + projectName + '\'' +
                ", dueDates=" + dueDates +
                ", points='" + points + '\'' +
                ", isCompleted='" + isCompleted + '\'' +
                '}';
    }
}
