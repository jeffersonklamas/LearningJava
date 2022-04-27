package model;

import java.util.Date;
import controller.ProjectController;
import controller.TaskController;

/**
 *
 * @author Jefferson Klamas Marzani (jkm)
 */
public class Project {

    /**
     * Atributos criados conforme modelo da tabela projeto.
     */
    private int id;
    private String name;
    private String description;
    private Date createDat;
    private Date updateDat;

    
    /*Construtores criados */
    public Project (int id, String name, String description, Date createDat,Date updateDat) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.createDat = createDat;
        this.updateDat = updateDat;
    }

    public Project() {
        this.createDat = new Date();
        this.updateDat = new Date();
    }

    /* Metodos Getter e Setter */
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    /*Metodo ToString */

    @Override
    public String toString() {
//        return "Project{" + "id=" + id + ", "
//                + "name=" + name + ", "
//                + "description=" + description + ", "
//                + "createDat=" + createDat + ", "
//                + "updateDat=" + updateDat + '}';
        return this.name;
    }
}
