
package model;

import java.util.Date;

/**
 *
 * @author Jefferson Klamas Marzani (jkm)
 */
public class Task {
    
    /*Criando os atributos conforme requisitos */
    private int id;
    private int idProject;
    private String name;
    private String description;
    private String notes;
    private boolean isCompleted;
    private Date deadline;
    private Date createDat;
    private Date updateDat;

    public Task() {
        this.isCompleted = false;
        this.createDat = new Date();
        this.updateDat = new Date();
    }
    
    /*Criando os Construtores  */

    public Task(int id, 
            int idProject, 
            String name, 
            String description, 
            String notes, 
            boolean isCompleted, 
            Date deadline, 
            Date createDat, 
            Date updateDat) {
        
        this.id = id;
        this.idProject = idProject;
        this.name = name;
        this.description = description;
        this.notes = notes;
        this.isCompleted = isCompleted;
        this.deadline = deadline;
        this.createDat = createDat;
        this.updateDat = updateDat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProject() {
        return idProject;
    }

    public void setIdProject(int idProject) {
        this.idProject = idProject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(boolean isCompleted) {
        this.isCompleted = isCompleted;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreateDat() {
        return createDat;
    }

    public void setCreateDat(Date createDat) {
        this.createDat = createDat;
    }

    public Date getUpdateDat() {
        return updateDat;
    }

    public void setUpdateDat(Date updateDat) {
        this.updateDat = updateDat;
    }
    
    /*ToString */

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", "
                + "idProject=" + idProject + ", "
                + "name=" + name + ", "
                + "description=" + description + ", "
                + "notes=" + notes + ", "
                + "isCompleted=" + isCompleted + ", "
                + "deadline=" + deadline + ", "
                + "createDat=" + createDat + ", "
                + "updateDat=" + updateDat + '}';
    }     
}
