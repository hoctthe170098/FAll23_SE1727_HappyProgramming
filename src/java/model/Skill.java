/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class Skill {
    int ID;
    String name;
    String Description;
    String image;

    public Skill() {
    }

    public Skill(int ID, String name, String Description, String image) {
        this.ID = ID;
        this.name = name;
        this.Description = Description;
        this.image = image;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Skill{" + "ID=" + ID + ", name=" + name + ", Description=" + Description + ", image=" + image + '}';
    }
    
}
